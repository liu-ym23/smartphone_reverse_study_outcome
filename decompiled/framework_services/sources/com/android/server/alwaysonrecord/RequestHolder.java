package com.android.server.alwaysonrecord;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetrics;
import android.media.alwaysonrecord.AlwaysOnRecordConfig;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestHolder implements AudioDataArchiver.ArchiverListener {
    public static final int FORCE_SYNC_DURATION_MS = 300;
    public static final String KEY_DURATION = "duration";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TIMESTAMP = "timestamp";
    private static final long MIN_TOLERANCE_WINDOW_MILLIS = 300;
    public static final int STATUS_FAILED = 2;
    public static final int STATUS_NO_ERROR = 0;
    public static final int STATUS_RETRY = 1;
    private static final String mMetricsId = "audio.alwaysOnRecord.client.";
    private final int DEFAULT_RETRY_COUNT;
    private final int MAX_RETRY_COUNT;
    private final String TAG;
    private AlwaysOnRecordConfig mConfig;
    private Context mContext;
    private int mFiredCount;
    private long mInitialLaunchTimeMillis;
    private long mLastSaveFileTimeMillis;
    private long mLaunchTimeMillis;
    private String mPackageName;
    private ArrayList<AudioFileInfo> mPendingFileList;
    private PendingIntent mPendingIntent;
    private long mPeriodInMillis;
    private int mRetryCount;
    private int mSessionId;
    private int mTotalFileCount;
    private int mTotalFiredCount;

    private class AudioFileInfo {
        long duration;
        String filePath;
        long timestamp;

        AudioFileInfo(RequestHolder r1, long timestamp, long duration, String filePath) {
            this.timestamp = timestamp;
            this.duration = duration;
            this.filePath = filePath;
        }
    }

    public static /* synthetic */ void $r8$lambda$7BAQIgX07EW16lkJnj0TmDizNrA(RequestHolder r0, JSONArray r1, AudioFileInfo r2) {
        r0.lambda$getPendingFileInfo$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$TmM9EWF3QnFf7f_bEt13rOrJ4Ak(ArrayList r0, AudioFileInfo r1) {
        lambda$getPendingFileList$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$arGyxHnqITcf-drV4J_7vxz6JuY, reason: not valid java name */
    public static /* synthetic */ boolean m1084$r8$lambda$arGyxHnqITcfdrV4J_7vxz6JuY(String r0, AudioFileInfo r1) {
        return lambda$onAudioDataSavedToFile$0(r0, r1);
    }

    public RequestHolder(Context context, int sessionId, AlwaysOnRecordConfig config, PendingIntent callbackIntent, String packageName) {
        this.TAG = "RequestHolder";
        this.MAX_RETRY_COUNT = 2;
        this.DEFAULT_RETRY_COUNT = 1;
        this.mRetryCount = 1;
        this.mTotalFileCount = 0;
        this.mPendingFileList = new ArrayList();
        this.mContext = context;
        this.mSessionId = sessionId;
        this.mConfig = config;
        this.mPendingIntent = callbackIntent;
        this.mPackageName = packageName;
        this.mInitialLaunchTimeMillis = System.currentTimeMillis();
        this.mLaunchTimeMillis = System.currentTimeMillis();
        this.mFiredCount = 0;
        this.mTotalFiredCount = 0;
        this.mPeriodInMillis = config.getWakeUpPeriod() * 1000;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public int getSessionId() {
        return this.mSessionId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long getNextExpiredTimeMillis() {
        long now = System.currentTimeMillis();
        long pastTimeMillis = (now - this.mLaunchTimeMillis) % this.mPeriodInMillis;
        long expiredTimeMillis = this.mPeriodInMillis - pastTimeMillis;
        if (Build.IS_DEBUGGABLE == true) goto L5;
    L7:
        return expiredTimeMillis;
    L5:
        if (Log.isLoggable("RequestHolder", 2) == false) goto L7;
        Log.v("RequestHolder", "pastTimeMillis: " + pastTimeMillis + ", expiredTimeMillis:" + expiredTimeMillis + ", now " + now + " vs launch " + this.mLaunchTimeMillis);
        goto L7
    }

    public boolean supportToFireIntent() {
        if (this.mPendingIntent == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateLaunchTime() {
        this.mLaunchTimeMillis = System.currentTimeMillis();
        this.mLastSaveFileTimeMillis = System.currentTimeMillis();
        this.mFiredCount = 0;
    }

    public boolean readyToFire() {
        if (supportToFireIntent() == true) goto L5;
        return false;
    L5:
        long now = System.currentTimeMillis();
        long expectedFireCount = (now - this.mLaunchTimeMillis) / this.mPeriodInMillis;
        long pastTimeMillis = (now - this.mLaunchTimeMillis) % this.mPeriodInMillis;
        long expiredTimeMillis = this.mPeriodInMillis - pastTimeMillis;
        Log.v("RequestHolder", "expectedFireCount " + expectedFireCount + ", vs mFiredCount " + this.mFiredCount + ", pastTimeMillis: " + pastTimeMillis + ", expiredTimeMillis:" + expiredTimeMillis + ", now " + now + " vs launch " + this.mLaunchTimeMillis);
        if (expectedFireCount <= this.mFiredCount) goto L9;
        return true;
    L9:
        return false;
    }

    public int fire(int status) {
        Log.v("RequestHolder", "fire event " + this.mSessionId + ", status " + status);
        long lastSaveFileDurationMillis = System.currentTimeMillis() - this.mLastSaveFileTimeMillis;
        if (this.mRetryCount >= 2) goto L9;
        if (lastSaveFileDurationMillis <= this.mPeriodInMillis) goto L9;
        Log.d("RequestHolder", "Force to sync data: pending file list is " + this.mPendingFileList.size() + ", last save file duration is " + lastSaveFileDurationMillis);
        this.mRetryCount = this.mRetryCount + 1;
        return 1;
    L9:
        if (this.mRetryCount <= 1) goto L11;
        Log.w("RequestHolder", "Retry " + this.mRetryCount + " times, session is " + this.mSessionId);
        this.mRetryCount = 1;
    L11:
        logFireEventMetrics(status);
        Intent intent = new Intent();     // Catch: PendingIntent.CanceledException -> L17
        intent.putExtra("android.media.EXTRA_SESSION_ID", this.mSessionId);     // Catch: PendingIntent.CanceledException -> L17
        intent.putExtra("android.media.EXTRA_RECORD_OPERATION_STATUS", status);     // Catch: PendingIntent.CanceledException -> L17
        intent.putExtra("android.media.EXTRA_RECORD_FILE_LIST", getPendingFileInfo());     // Catch: PendingIntent.CanceledException -> L17
        this.mPendingIntent.send(this.mContext, 0, intent);     // Catch: PendingIntent.CanceledException -> L17
        resetPendingFileList();
        this.mFiredCount++;
        this.mTotalFiredCount++;
        long durationMillis = System.currentTimeMillis() - (this.mLaunchTimeMillis + (((long) this.mFiredCount) * this.mPeriodInMillis));
        long cycle = durationMillis / this.mPeriodInMillis;
        if (cycle <= 0) goto L16;
        Log.e("RequestHolder", "Some intent maybe missed " + cycle + " times, while fired " + this.mFiredCount + " times");
        this.mFiredCount = (int) (((long) this.mFiredCount) + cycle);
    L16:
        return 0;
    L17:
        e = move-exception;
        Log.e("RequestHolder", "CanceledException happens: " + e.toString());
        return 2;
    }

    public boolean fireStorageLowStateEvent(boolean storageLow) {
        Log.v("RequestHolder", "fire storage low event, id is " + this.mSessionId + ", storageLow state is " + storageLow);
        if (storageLow == false) goto L5;
        int status = -4;
    L6:
        logFireEventMetrics(status);
        Intent intent = new Intent();     // Catch: PendingIntent.CanceledException -> L10
        intent.putExtra("android.media.EXTRA_SESSION_ID", this.mSessionId);     // Catch: PendingIntent.CanceledException -> L10
        intent.putExtra("android.media.EXTRA_RECORD_OPERATION_STATUS", status);     // Catch: PendingIntent.CanceledException -> L10
        this.mPendingIntent.send(this.mContext, 0, intent);     // Catch: PendingIntent.CanceledException -> L10
        return true;
    L10:
        e = move-exception;
        Log.e("RequestHolder", "CanceledException happens: " + e.toString());
        return false;
    L5:
        status = 0;
        goto L6
    }

    public boolean verifyFireWorks() {
        Log.v("RequestHolder", "verify to fire event " + this.mSessionId);
        Intent intent = new Intent();     // Catch: PendingIntent.CanceledException -> L5
        intent.putExtra("android.media.EXTRA_VERIFICATION_PURPOSE", true);     // Catch: PendingIntent.CanceledException -> L5
        this.mPendingIntent.send(this.mContext, 0, intent);     // Catch: PendingIntent.CanceledException -> L5
        return true;
    L5:
        e = move-exception;
        Log.e("RequestHolder", "CanceledException happens: " + e.toString());
        return false;
    }

    @Override // com.android.server.alwaysonrecord.AudioDataArchiver.ArchiverListener
    public void onAudioDataSavedToFile(long timestamp, long duration, final String fileName) {
        ArrayList<AudioFileInfo> r1 = this.mPendingFileList;
        monitor-enter(r1);
        boolean fileExists = this.mPendingFileList.stream().anyMatch(new RequestHolder$$ExternalSyntheticLambda1(fileName));     // Catch: Throwable -> L18
        if (fileExists == true) goto L24;
        this.mPendingFileList.add(new AudioFileInfo(this, timestamp, duration, fileName));     // Catch: Throwable -> L16
        this.mLastSaveFileTimeMillis = System.currentTimeMillis();     // Catch: Throwable -> L16
        this.mTotalFileCount++;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L24:
        Log.w("RequestHolder", "File already exists: " + fileName);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L16
        throw th;
    L18:
        th = th;
    L16:
        th = th;
        goto L20
    }

    private static /* synthetic */ boolean lambda$onAudioDataSavedToFile$0(String fileName, AudioFileInfo fileInfo) {
        return fileName.equals(fileInfo.filePath);
    }

    private void resetPendingFileList() {
        ArrayList<AudioFileInfo> r0 = this.mPendingFileList;
        monitor-enter(r0);
        this.mPendingFileList.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ArrayList<String> getPendingFileList() {
        ArrayList<AudioFileInfo> r0 = this.mPendingFileList;
        monitor-enter(r0);
        final ArrayList<String> filePaths = new ArrayList();     // Catch: Throwable -> L7
        this.mPendingFileList.forEach(new RequestHolder$$ExternalSyntheticLambda0(filePaths));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return filePaths;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$getPendingFileList$1(ArrayList filePaths, AudioFileInfo info) {
        filePaths.add(info.filePath);
    }

    public String getPendingFileInfo() {
        final JSONArray jsonArray = new JSONArray();
        ArrayList<AudioFileInfo> r1 = this.mPendingFileList;
        monitor-enter(r1);
        this.mPendingFileList.forEach(new RequestHolder$$ExternalSyntheticLambda2(this, jsonArray));     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (jsonArray.length() > 0) goto L16;
        return "";
    L16:
        return jsonArray.toString();
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$getPendingFileInfo$2(JSONArray jsonArray, AudioFileInfo info) {
        JSONObject jsonObject = new JSONObject();     // Catch: JSONException -> L4
        jsonObject.put("timestamp", info.timestamp);     // Catch: JSONException -> L4
        jsonObject.put(KEY_DURATION, info.duration);     // Catch: JSONException -> L4
        jsonObject.put(KEY_FILE_PATH, info.filePath);     // Catch: JSONException -> L4
        jsonArray.put(jsonObject);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Log.e("RequestHolder", "JSONException happens: " + e.toString());
    }

    private MediaMetrics.Item getMetricsItem(String event) {
        MediaMetrics.Item mmi = new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, event).setUid(Binder.getCallingUid()).setPid(Binder.getCallingPid()).set(MediaMetrics.Property.ID, Integer.valueOf(this.mSessionId)).set(MediaMetrics.Property.CALLING_PACKAGE, this.mPackageName).set(MediaMetrics.Property.RECORD_MODE, Integer.valueOf(this.mConfig.getRecordingMode())).set(MediaMetrics.Property.WAKEUP_PERIOD, Long.valueOf(this.mConfig.getWakeUpPeriod()));
        return mmi;
    }

    public void logConstructorMetrics() {
        getMetricsItem("create").record();
    }

    private void logFireEventMetrics(int status) {
        getMetricsItem("fire").set(MediaMetrics.Property.STATUS, Integer.valueOf(status)).set(MediaMetrics.Property.FILE_COUNT, Integer.valueOf(getPendingFileList().size())).record();
    }

    public void logDestructorMetrics() {
        getMetricsItem("ctor").set(MediaMetrics.Property.FIRE_EVENT_COUNT, Integer.valueOf(this.mFiredCount)).set(MediaMetrics.Property.FILE_COUNT, Integer.valueOf(this.mTotalFileCount)).record();
    }

    public String toString() {
        return "{sessionId=" + this.mSessionId + ", pendingIntent=" + this.mPendingIntent + ", when=" + this.mLaunchTimeMillis + ", firedCount=" + this.mFiredCount + "}";
    }

    public void dump(PrintWriter pw) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss");
        pw.println("- Client: " + this.mSessionId);
        pw.println("-- Package = " + this.mPackageName);
        pw.println("-- Mode = " + this.mConfig.getRecordingMode());
        pw.println("-- Wakeup period sec = " + this.mConfig.getWakeUpPeriod());
        pw.println("-- When(initial) = " + format.format(new Date(this.mInitialLaunchTimeMillis)));
        pw.println("-- When(latest) = " + format.format(new Date(this.mLaunchTimeMillis)));
        pw.println("-- PendingIntent = " + this.mPendingIntent.toString());
        pw.println("-- FiredCount = " + this.mFiredCount);
        pw.println("-- TotalFiredCount = " + this.mTotalFiredCount);
        pw.println("-- LastSaveFileTimeMillis = " + format.format(new Date(this.mLastSaveFileTimeMillis)));
    }
}
