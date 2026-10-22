package com.stepos.pps.data.ouc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.provider.Settings;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.data.util.Utils;
import com.stepos.pps.logpull.LogCollectionGate;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.File;

/* loaded from: classes.dex */
public class ErrorManager {
    private static final int FILE_SIZE_100M = 104857600;
    private static final int FILE_SIZE_500M = 524288000;
    private static final String TAG = "PPS:ErrorManager";
    private final Context mContext;
    private DropBoxManager mDropBoxManager;
    private final ErrorLogManager mErrorLogFileManager;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private boolean mRecording;
    private SettingsObserver mSettingsObserver;

    private static class DropBoxEntryAddedData {
        int droppedCount;
        long received;
        String tag;
        long time;

        private DropBoxEntryAddedData() {
        }
    }

    public ErrorManager(Context context) throws ClassNotFoundException {
        HandlerThread handlerThread = new HandlerThread("OucHandlerThread");
        this.mHandlerThread = handlerThread;
        this.mRecording = false;
        this.mSettingsObserver = null;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        ErrorLogManager errorLogManager = ErrorLogManager.getInstance(context);
        this.mErrorLogFileManager = errorLogManager;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mHandler = handler;
        this.mRecording = Utils.canLogCollect(applicationContext);
        this.mSettingsObserver = new SettingsObserver(handler);
        applicationContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.SETTINGS_KEY_OUC_LOG_COLLECT), true, this.mSettingsObserver);
        ExceptionManagerStepOS.setExceptionReportingStatus(this.mRecording);
        registerDropBoxBroadcast();
        if (this.mRecording) {
            errorLogManager.scheduleStartUploaderJob();
        }
        LogCollectionGate.sync(applicationContext, true);
    }

    private void registerDropBoxBroadcast() {
        this.mDropBoxManager = (DropBoxManager) this.mContext.getSystemService("dropbox");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DROPBOX_ENTRY_ADDED");
        this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.stepos.pps.data.ouc.ErrorManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ErrorManager.this.handleDropBoxBroadcast(intent);
            }
        }, intentFilter, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDropBoxBroadcast(Intent intent) {
        if (!this.mRecording) {
            LogUtil.w(TAG, "handleDropBoxBroadcast, should not upload, ignore it!!!");
            return;
        }
        DropBoxEntryAddedData dropBoxEntryAddedData = new DropBoxEntryAddedData();
        dropBoxEntryAddedData.tag = intent.getStringExtra("tag");
        dropBoxEntryAddedData.time = intent.getLongExtra("time", 0L);
        dropBoxEntryAddedData.droppedCount = intent.getIntExtra("android.os.extra.DROPPED_COUNT", 0);
        dropBoxEntryAddedData.received = SystemClock.elapsedRealtime();
        LogUtil.d(TAG, "onReceive: tag=" + dropBoxEntryAddedData.tag + ",time=" + dropBoxEntryAddedData.time);
        DropBoxManager.Entry nextEntry = this.mDropBoxManager.getNextEntry(dropBoxEntryAddedData.tag, dropBoxEntryAddedData.time - 1);
        if (nextEntry != null) {
            ErrorHandlerRunnable errorHandlerRunnable = new ErrorHandlerRunnable(nextEntry);
            LogUtil.d(TAG, "Post error handler runnable");
            this.mHandler.post(errorHandlerRunnable);
            return;
        }
        LogUtil.w(TAG, "Entry is null!!!");
    }

    private class ErrorHandlerRunnable implements Runnable {
        DropBoxManager.Entry entry;

        ErrorHandlerRunnable(DropBoxManager.Entry entry) {
            this.entry = entry;
        }

        @Override // java.lang.Runnable
        public void run() {
            ErrorInfo errorInfo = DropBoxParserManager.getInstance().parse(this.entry, ErrorManager.this.mContext);
            if (errorInfo == null) {
                LogUtil.i(ErrorManager.TAG, "parse to error info failed errorInfo is null!!!");
            } else if (!canUpload(errorInfo)) {
                LogUtil.w(ErrorManager.TAG, "Can not upload!!!");
            } else if (ErrorManager.this.mErrorLogFileManager.addErrorLogData(errorInfo)) {
                LogUtil.i(ErrorManager.TAG, "Success add error log data!!!");
            }
            DropBoxManager.Entry entry = this.entry;
            if (entry != null) {
                entry.close();
            }
        }

        private boolean canUpload(ErrorInfo errorInfo) {
            File file = errorInfo.extFile;
            if (file == null || !file.exists() || file.length() < 524288000) {
                return true;
            }
            LogUtil.d(ErrorManager.TAG, "File size " + file.length() + " is to big, can not upload!!!");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyRecordingState() throws ClassNotFoundException {
        boolean zCanLogCollect = Utils.canLogCollect(this.mContext);
        if (this.mRecording != zCanLogCollect) {
            this.mRecording = zCanLogCollect;
            ExceptionManagerStepOS.setExceptionReportingStatus(zCanLogCollect);
            LogUtil.d(TAG, "recording state changed = " + this.mRecording);
        }
        if (!this.mRecording) {
            LogUtil.i(TAG, "Recording is disabled, cancelling ErrorLogUploaderJob.");
            this.mErrorLogFileManager.scheduleStoploaderJob();
        } else {
            LogUtil.i(TAG, "Recording is enabled, scheduling ErrorLogUploaderJob.");
            this.mErrorLogFileManager.scheduleStartUploaderJob();
        }
        LogCollectionGate.sync(this.mContext, true);
    }

    public void onUserTypeChanged() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.stepos.pps.data.ouc.ErrorManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws ClassNotFoundException {
                    this.f$0.applyRecordingState();
                }
            });
        } else {
            applyRecordingState();
        }
    }

    private class SettingsObserver extends ContentObserver {
        SettingsObserver(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) throws ClassNotFoundException {
            ErrorManager.this.applyRecordingState();
        }
    }
}
