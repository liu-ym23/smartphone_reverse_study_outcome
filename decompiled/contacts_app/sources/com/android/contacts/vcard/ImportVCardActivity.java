package com.android.contacts.vcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bytedanceos.util.LogTag;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.BytedanceApi;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.FixHeightByItemCountListView;
import com.android.contacts.widget.NoDimDialogBuilder;
import com.android.contacts.widget.ProgressDialog;
import com.android.vcard.VCardEntryCounter;
import com.android.vcard.VCardParser;
import com.android.vcard.VCardParser_V21;
import com.android.vcard.VCardParser_V30;
import com.android.vcard.VCardSourceDetector;
import com.android.vcard.exception.VCardException;
import com.android.vcard.exception.VCardNestedException;
import com.android.vcard.exception.VCardVersionException;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.account.LocalAccountContactsUtils;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.privacy.PrivacyUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ImportVCardActivity extends ContactsActivity implements ImportVCardDialogFragment.Listener {
    public static final String ACCOUNT_NAME = "account_name";
    public static final String ACCOUNT_TYPE = "account_type";
    static final String CACHED_URIS = "cached_uris";
    public static final String DATA_SET = "data_set";
    static final String ENTRY_COUNT_ARRAY = "entry_count";
    static final String ESTIMATED_CHARSET_ARRAY = "estimated_charset";
    static final String ESTIMATED_VCARD_TYPE_ARRAY = "estimated_vcard_type";
    public static final String EXTRA_FROM_MMS = "from_mms";
    private static final int FAILURE_NOTIFICATION_ID = 1;
    private static final int FOREGROUND_NOTIFICATION_ID = 17;
    private static final String FORGROUND_VCARD_SERVICE_CHANNEL = "foreground_vcard_service_channel";
    private static final int FROM_MMS = 1;
    private static final int FROM_MMS_DEFAULT = 0;
    private static final String LOG_TAG = "VCardImport";
    private static final int MSG_DISMISS_VCARD_FILE_SELECT_DIALOG = 31;
    private static final String SECURE_DIRECTORY_NAME = ".android_secure";
    private static final int SELECT_ACCOUNT = 0;
    static final String VCARD_URI_ARRAY = "vcard_uri";
    static final String VCARD_VERSION_ARRAY = "vcard_version";
    static final int VCARD_VERSION_AUTO_DETECT = 0;
    static final int VCARD_VERSION_V21 = 1;
    static final int VCARD_VERSION_V30 = 2;
    private boolean isServiceUnbind;
    private AccountWithDataSet mAccount;
    private AccountSelectionUtil.AccountSelectedListener mAccountSelectionListener;
    private List<VCardFile> mAllVCardFileList;
    private AlertDialog mAskJoinDialog;
    private CancelListener mCancelListener;
    private ImportRequestConnection mConnection;
    private String mErrorMessage;
    private boolean mFinishAfterVCardFileSelectDialogDismiss;
    private Handler mHandler;
    VCardImportExportListener mListener;
    private ProgressDialog mProgressDialogForScanVCard;
    private VCardCacheThread mVCardCacheThread;
    private VCardFileListAdapter mVCardFileListAdapter;
    private OCheckBox mVCardFileSelectAllCheckBox;
    private Dialog mVCardFileSelectDialog;
    private View mVCardFileSelectPositive;
    private VCardScanThread mVCardScanThread;

    private class CancelListener implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        final /* synthetic */ ImportVCardActivity this$0;

        private CancelListener(ImportVCardActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CancelListener(ImportVCardActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            if (r1 == null) goto L4;
            r1.dismiss();
        L4:
            this.this$0.finish();
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            if (r1 == null) goto L4;
            r1.dismiss();
        L4:
            this.this$0.finish();
        }
    }

    private class DialogDisplayer implements Runnable {
        private final int mResId;
        final /* synthetic */ ImportVCardActivity this$0;

        public DialogDisplayer(ImportVCardActivity r1, int r2) {
            this.this$0 = r1;
            this.mResId = r2;
        }

        public DialogDisplayer(ImportVCardActivity r2, String r3) {
            this.this$0 = r2;
            this.mResId = R.id.dialog_error_with_message;
            ImportVCardActivity.access$302(r2, r3);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.isFinishing() == true) goto L12;
            this.this$0.showDialog(this.mResId);
            if (this.mResId == R.id.dialog_select_multiple_vcard) goto L7;
            return;
        L7:
            if (ImportVCardActivity.access$000(this.this$0) != null) goto L9;
            return;
        L9:
            if (ImportVCardActivity.access$400(this.this$0) == null) goto L15;
            ImportVCardActivity.access$400(this.this$0).setEnabled(false);
            return;
        L15:
            return;
        }
    }

    private class ImportRequestConnection implements ServiceConnection {
        private VCardService mService;
        final /* synthetic */ ImportVCardActivity this$0;

        private ImportRequestConnection(ImportVCardActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ImportRequestConnection(ImportVCardActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void sendImportRequest(List<ImportRequest> r3, boolean r4) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Send an import request");
            this.mService.handleImportRequest(r3, this.this$0.mListener, r4);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r3, IBinder r4) {
            this.mService = ((VCardService.MyBinder) r4).getService();
            this.mService.startForeground(17, new Notification.Builder(this.this$0.getApplicationContext(), ImportVCardActivity.FORGROUND_VCARD_SERVICE_CHANNEL).build(), 1);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, String.format("Connected to VCardService. Kick a vCard cache thread (uri: %s)", new Object[]{Arrays.toString(ImportVCardActivity.access$600(this.this$0).getSourceUris())}));
            ImportVCardActivity.access$600(this.this$0).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r2) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Disconnected from VCardService");
            VCardService r1 = this.mService;
            if (r1 == null) goto L6;
            r1.stopForeground(true);
            return;
        }
    }

    private class ImportTypeSelectedListener implements DialogInterface.OnClickListener {
        public static final int IMPORT_ALL = 2;
        public static final int IMPORT_MULTIPLE = 1;
        public static final int IMPORT_ONE = 0;
        public static final int IMPORT_TYPE_SIZE = 3;
        private int mCurrentIndex;
        final /* synthetic */ ImportVCardActivity this$0;

        private ImportTypeSelectedListener(ImportVCardActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ImportTypeSelectedListener(ImportVCardActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (r3 != (-1)) goto L22;
            if (this.this$0.isFinishing() == true) goto L7;
            int r4 = this.mCurrentIndex;
            if (r4 == 1) goto L19;
            if (r4 != 2) goto L15;
            ImportVCardActivity r1 = this.this$0;
            ImportVCardActivity.access$200(r1, ImportVCardActivity.access$100(r1));
            return;
        L15:
            if (this.this$0.isFinishing() == true) goto L29;
            this.this$0.showDialog(R.id.dialog_select_one_vcard);
            return;
        L29:
            return;
        L19:
            if (this.this$0.isFinishing() == true) goto L32;
            this.this$0.showDialog(R.id.dialog_select_multiple_vcard);
            return;
        L32:
            return;
        L7:
            if (ContactsUtils.DEBUG == false) goto L28;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ImportVCardActivity.LOG_TAG, "Import VCard Activity is finish.");
            return;
        L28:
            return;
        L22:
            if (r3 != (-2)) goto L26;
            if (r2 == null) goto L25;
            r2.dismiss();
        L25:
            this.this$0.finish();
            return;
        L26:
            this.mCurrentIndex = r3;
        }
    }

    private class VCardCacheThread extends Thread implements DialogInterface.OnCancelListener {
        private boolean mAllowJoin;
        private boolean mCanceled;
        private final String mDisplayName;
        private final byte[] mSource;
        private final Uri[] mSourceUris;
        private VCardParser mVCardParser;
        private PowerManager.WakeLock mWakeLock;
        final /* synthetic */ ImportVCardActivity this$0;

        public VCardCacheThread(ImportVCardActivity r3, Uri[] r4) {
            this.this$0 = r3;
            this.mAllowJoin = true;
            this.mSourceUris = r4;
            this.mSource = null;
            this.mWakeLock = ((PowerManager) r3.getSystemService("power")).newWakeLock(536870918, ImportVCardActivity.LOG_TAG);
            this.mDisplayName = null;
        }

        public VCardCacheThread(ImportVCardActivity r1, Uri[] r2, boolean r3) {
            this(r1, r2);
            this.mAllowJoin = r3;
        }

        public void finalize() {
            PowerManager.WakeLock r0 = this.mWakeLock;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isHeld() == false) goto L9;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "WakeLock is being held.");
            this.mWakeLock.release();
            return;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "vCard cache thread starts running.");
            if (ImportVCardActivity.access$700(this.this$0) == null) goto L121;
            this.mWakeLock.acquire();
        L102:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "IOException during caching vCard", e);     // Catch: Throwable -> L100
            ImportVCardActivity r0 = this.this$0;     // Catch: Throwable -> L100
            ImportVCardActivity r5 = this.this$0;     // Catch: Throwable -> L100
            r0.runOnUiThread(new DialogDisplayer(r5, r5.getString(R.string.fail_reason_io_error)));     // Catch: Throwable -> L100
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$800(this.this$0) == true) goto L107;
            ImportVCardActivity r1 = this.this$0;
            r1.unbindService(ImportVCardActivity.access$700(r1));
            ImportVCardActivity.access$802(this.this$0, true);
        L107:
            ImportVCardActivity r2 = this.this$0;
            Runnable r3 = new AnonymousClass1(this);
        L108:
            r2.runOnUiThread(r3);
            return;
        L109:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "OutOfMemoryError occured during caching vCard");     // Catch: Throwable -> L100
            System.gc();     // Catch: Throwable -> L100
            ImportVCardActivity r4 = this.this$0;     // Catch: Throwable -> L100
            ImportVCardActivity r6 = this.this$0;     // Catch: Throwable -> L100
            r4.runOnUiThread(new DialogDisplayer(r6, r6.getString(R.string.fail_reason_low_memory_during_import)));     // Catch: Throwable -> L100
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$800(this.this$0) == true) goto L113;
            ImportVCardActivity r7 = this.this$0;
            r7.unbindService(ImportVCardActivity.access$700(r7));
            ImportVCardActivity.access$802(this.this$0, true);
        L113:
            r2 = this.this$0;
            r3 = new AnonymousClass1(this);
            goto L108
        L7:
            if (this.mCanceled != true) goto L15;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "vCard cache operation is canceled.");     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$800(this.this$0) == true) goto L12;
            ImportVCardActivity r8 = this.this$0;
            r8.unbindService(ImportVCardActivity.access$700(r8));
            ImportVCardActivity.access$802(this.this$0, true);
        L12:
            ImportVCardActivity r9 = this.this$0;
            Runnable r10 = new AnonymousClass1(this);
        L13:
            r9.runOnUiThread(r10);
            return;
        L15:
            ImportVCardActivity r11 = this.this$0;     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            ArrayList r12 = new ArrayList();     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            byte[] r13 = this.mSource;     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            if (r13 != null) goto L122;
            ContentResolver r19 = this.this$0.getContentResolver();     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            Uri[] r15 = this.mSourceUris;     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            int r14 = r15.length;     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            int r16 = 0;
            int r17 = 0;
            boolean r20 = false;
        L27:
            if (r17 >= r14) goto L89;
            Uri r18 = r15[r17];     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            int r21 = r16;
        L29:
            String r22 = "import_tmp_" + r21 + ".vcf";     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            if (r11.getFileStreamPath(r22).exists() == false) goto L31;
            int r23 = r17;
            int r24 = r14;
            Uri[] r25 = r15;
            if (r21 == Integer.MAX_VALUE) goto L87;
            r21 = r21 + 1;     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            r17 = r23;
            r14 = r24;
            r15 = r25;
            goto L29
        L87:
            throw new RuntimeException("Exceeded cache limit");     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L31:
            Uri r26 = copyTo(r18, r22);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            if (this.mCanceled == true) goto L33;
            if (r26 == null) goto L35;
            int r27 = r17;
            int r28 = r14;
            Uri[] r29 = r15;
            Cursor r110 = r19.query(r18, new String[]{"_display_name"}, null, null, null);     // Catch: Throwable -> L78
            if (r110 != null) goto L124;
        L52:
            String r111 = null;
        L53:
            if (r110 == null) goto L56;
            r110.close();     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L56:
            if (TextUtils.isEmpty(r111) == false) goto L130;
            r111 = r18.getLastPathSegment();     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L130:
            ImportRequest r30 = constructImportRequest(null, r26, r111);     // Catch: IOException -> L68 VCardException -> L74 Throwable -> L100 OutOfMemoryError -> L109
        L61:
            if (this.mCanceled == true) goto L62;
            r12.add(r30);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L77:
            r17 = r27 + 1;     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            r16 = r21;
            r14 = r28;
            r15 = r29;
            goto L27
        L62:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "vCard cache operation is canceled.");     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$800(this.this$0) == true) goto L66;
            ImportVCardActivity r31 = this.this$0;
            r31.unbindService(ImportVCardActivity.access$700(r31));
            ImportVCardActivity.access$802(this.this$0, true);
        L66:
            r9 = this.this$0;
            r10 = new AnonymousClass1(this);
        L74:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "Maybe the file is in wrong format", e);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            r20 = true;
        L68:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "Unexpected IOException", e);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            this.this$0.showFailureNotification(R.string.fail_reason_io_error);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$800(this.this$0) == true) goto L73;
            ImportVCardActivity r32 = this.this$0;
            r32.unbindService(ImportVCardActivity.access$700(r32));
            ImportVCardActivity.access$802(this.this$0, true);
        L73:
            r9 = this.this$0;
            r10 = new AnonymousClass1(this);
            goto L13
        L124:
            if (r110.getCount() <= 0) goto L52;
            if (r110.moveToFirst() == false) goto L52;
            if (r110.getCount() <= 1) goto L46;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Unexpected multiple rows: " + r110.getCount());     // Catch: Throwable -> L50
        L46:
            int r112 = r110.getColumnIndex("_display_name");     // Catch: Throwable -> L50
            if (r112 < 0) goto L52;
            r111 = r110.getString(r112);     // Catch: Throwable -> L50
        L50:
            th = th;
        L80:
            if (r110 == null) goto L82;
            r110.close();     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L82:
            throw th;     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L78:
            th = th;
            r110 = null;
            goto L80
        L35:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "destUri is null");     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            goto L89
        L33:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "vCard cache operation is canceled.");     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L89:
            if (r12.isEmpty() == false) goto L93;
            if (r20 == false) goto L93;
            this.this$0.showFailureNotification(R.string.fail_reason_not_supported);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L93:
            if (r12.isEmpty() == true) goto L95;
            ImportVCardActivity.access$700(this.this$0).sendImportRequest(r12, this.mAllowJoin);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L96:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$800(this.this$0) == true) goto L99;
            ImportVCardActivity r33 = this.this$0;
            r33.unbindService(ImportVCardActivity.access$700(r33));
            ImportVCardActivity.access$802(this.this$0, true);
        L99:
            r2 = this.this$0;
            r3 = new AnonymousClass1(this);
            goto L108
        L95:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Empty import requests. Ignore it.");     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            goto L96
        L122:
            r12.add(constructImportRequest(r13, null, this.mDisplayName));     // Catch: VCardException -> L20 Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
        L20:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "Maybe the file is in wrong format", e);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            this.this$0.showFailureNotification(R.string.fail_reason_not_supported);     // Catch: Throwable -> L100 IOException -> L102 OutOfMemoryError -> L109
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$800(this.this$0) == true) goto L25;
            ImportVCardActivity r34 = this.this$0;
            r34.unbindService(ImportVCardActivity.access$700(r34));
            ImportVCardActivity.access$802(this.this$0, true);
        L25:
            r9 = this.this$0;
            r10 = new AnonymousClass1(this);
        L100:
            th = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$800(this.this$0) == true) goto L118;
            ImportVCardActivity r35 = this.this$0;
            r35.unbindService(ImportVCardActivity.access$700(r35));
            ImportVCardActivity.access$802(this.this$0, true);
        L118:
            this.this$0.runOnUiThread(new AnonymousClass1(this));
            throw th;
        L121:
            throw new NullPointerException("vCard cache thread must be launched after a service connection is established");
        }

        private Uri copyTo(Uri r10, String r11) throws IOException {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, String.format("Copy a Uri to app local storage (%s -> %s)", new Object[]{r10, r11}));
            ImportVCardActivity r2 = this.this$0;
            ReadableByteChannel r6 = null;
            ReadableByteChannel r5 = Channels.newChannel(r2.getContentResolver().openInputStream(r10));     // Catch: Throwable -> L43
            Uri r7 = Uri.parse(r2.getFileStreamPath(r11).toURI().toString());     // Catch: Throwable -> L40
            FileChannel r12 = r2.openFileOutput(r11, 0).getChannel();     // Catch: Throwable -> L40
            ByteBuffer r3 = ByteBuffer.allocateDirect(8192);     // Catch: Throwable -> L38
        L8:
            if (r5.read(r3) == (-1)) goto L24;
            if (this.mCanceled == true) goto L12;
            r3.flip();     // Catch: Throwable -> L38
            r12.write(r3);     // Catch: Throwable -> L38
            r3.compact();     // Catch: Throwable -> L38
            goto L8
        L12:
            if (ContactsUtils.DEBUG == false) goto L14;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ImportVCardActivity.LOG_TAG, "Canceled during caching " + r10);     // Catch: Throwable -> L38
        L14:
            if (r5 != null) goto L65;
        L18:
            if (r12 != null) goto L54;
        L22:
            return null;
        L54:
            r12.close();     // Catch: IOException -> L21
        L21:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Failed to close outputChannel");
            goto L22
        L65:
            r5.close();     // Catch: IOException -> L17
        L17:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Failed to close inputChannel.");
            goto L18
        L24:
            r3.flip();     // Catch: Throwable -> L38
        L26:
            if (r3.hasRemaining() == false) goto L29;
            r12.write(r3);     // Catch: Throwable -> L38
            goto L26
        L29:
            if (r5 != null) goto L56;
        L33:
            if (r12 != null) goto L60;
        L37:
            return r7;
        L60:
            r12.close();     // Catch: IOException -> L36
        L36:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Failed to close outputChannel");
            goto L37
        L56:
            r5.close();     // Catch: IOException -> L32
        L32:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Failed to close inputChannel.");
        L38:
            th = th;
        L42:
            r6 = r5;
        L45:
            if (r6 != null) goto L58;
        L49:
            if (r12 == null) goto L74;
            r12.close();     // Catch: IOException -> L52
            throw th;
        L52:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Failed to close outputChannel");
            throw th;
        L74:
            throw th;
        L58:
            r6.close();     // Catch: IOException -> L48
        L48:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Failed to close inputChannel.");
        L40:
            th = th;
            r12 = null;
        L43:
            th = th;
            r12 = null;
            goto L45
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v15, types: [com.android.vcard.VCardParser] */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v11 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v19 */
        /* JADX WARN: Type inference failed for: r8v2, types: [com.android.vcard.VCardSourceDetector] */
        /* JADX WARN: Type inference failed for: r8v20 */
        /* JADX WARN: Type inference failed for: r8v21 */
        /* JADX WARN: Type inference failed for: r8v22, types: [com.android.vcard.VCardInterpreter, com.android.vcard.VCardSourceDetector] */
        /* JADX WARN: Type inference failed for: r8v23 */
        /* JADX WARN: Type inference failed for: r8v24 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private ImportRequest constructImportRequest(byte[] r12, Uri r13, String r14) throws IOException, VCardException {
            ContentResolver r0 = this.this$0.getContentResolver();
            VCardEntryCounter r2 = null;
            r2 = null;
            r2 = null;
            Object r3 = null;
            int r5 = 1;
            if (r12 == null) goto L5;
            InputStream r6 = new ByteArrayInputStream(r12);     // Catch: VCardNestedException -> L50
        L66:
            this.mVCardParser = new VCardParser_V21();     // Catch: VCardNestedException -> L50
            VCardEntryCounter r7 = new VCardEntryCounter();     // Catch: Throwable -> L22 VCardVersionException -> L24
            ?? r8 = new VCardSourceDetector();     // Catch: Throwable -> L17 VCardVersionException -> L20
            this.mVCardParser.addInterpreter(r7);     // Catch: Throwable -> L15 VCardVersionException -> L58
            this.mVCardParser.addInterpreter(r8);     // Catch: Throwable -> L15 VCardVersionException -> L58
            VCardParser r4 = this.mVCardParser;     // Catch: Throwable -> L15 VCardVersionException -> L58
            r4.parse(r6);     // Catch: Throwable -> L15 VCardVersionException -> L58
            if (r6 != null) goto L86;
        L14:
            boolean r1 = false;
            r3 = r4;
            r8 = r8;
        L41:
            if (r1 == false) goto L65;
            r5 = 2;
        L65:
        L53:
            return new ImportRequest(ImportVCardActivity.access$900(this.this$0), r12, r13, r14, r8.getEstimatedType(), r8.getEstimatedCharset(), r5, r7.getCount());
        L86:
            r6.close();     // Catch: VCardNestedException -> L55 IOException -> L54
        L13:
            r2 = r7;
        L51:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Nested Exception is found (it may be false-positive).");
            r7 = r2;
        L15:
            th = th;
        L19:
            r2 = r7;
        L47:
            if (r6 != null) goto L68;
        L49:
            throw th;     // Catch: VCardNestedException -> L56
        L68:
            r6.close();     // Catch: IOException -> L57 VCardNestedException -> L56
        L21:
            r2 = r7;
            r8 = r8;
        L72:
            r6.close();     // Catch: Throwable -> L27 IOException -> L59
        L27:
            th = th;
        L29:
            if (r12 == null) goto L31;
            InputStream r9 = new ByteArrayInputStream(r12);     // Catch: Throwable -> L27
        L32:
            r6 = r9;
            this.mVCardParser = new VCardParser_V30();     // Catch: Throwable -> L27
            r7 = new VCardEntryCounter();     // Catch: Throwable -> L27 VCardVersionException -> L62
            VCardSourceDetector r10 = new VCardSourceDetector();     // Catch: Throwable -> L15 VCardVersionException -> L61
            this.mVCardParser.addInterpreter(r7);     // Catch: Throwable -> L17 VCardVersionException -> L43
            this.mVCardParser.addInterpreter(r10);     // Catch: Throwable -> L17 VCardVersionException -> L43
            this.mVCardParser.parse(r6);     // Catch: Throwable -> L17 VCardVersionException -> L43
            if (r6 != null) goto L88;
        L40:
            r8 = r10;
            r1 = true;
            r3 = r10;
            goto L41
        L88:
            r6.close();     // Catch: VCardNestedException -> L39 IOException -> L60
        L39:
            r8 = r10;
        L43:
            r8 = r10;
            goto L44
        L44:
            r2 = r7;
        L46:
            throw new VCardException("vCard with unspported version.");     // Catch: Throwable -> L27
        L31:
            r9 = r0.openInputStream(r13);     // Catch: Throwable -> L27
        L20:
            r8 = 0;
            goto L21
        L24:
            r8 = 0;
        L22:
            th = th;
            r8 = 0;
        L17:
            th = th;
            r8 = r3;
            goto L19
        L5:
            r6 = r0.openInputStream(r13);     // Catch: VCardNestedException -> L50
        L50:
            r8 = 0;
            goto L51
        }

        public Uri[] getSourceUris() {
            return this.mSourceUris;
        }

        public void cancel() {
            this.mCanceled = true;
            VCardParser r1 = this.mVCardParser;
            if (r1 == null) goto L6;
            r1.cancel();
            return;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r2) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Cancel request has come. Abort caching vCard.");
            cancel();
        }
    }

    private static class VCardFile {
        private final String mCanonicalPath;
        private final long mLastModified;
        private final String mName;

        public VCardFile(String r1, String r2, long r3) {
            this.mName = r1;
            this.mCanonicalPath = r2;
            this.mLastModified = r3;
        }

        public String getName() {
            return this.mName;
        }

        public String getCanonicalPath() {
            return this.mCanonicalPath;
        }

        public long getLastModified() {
            return this.mLastModified;
        }
    }

    private static class VCardFileListAdapter extends BaseAdapter {
        private Context mContext;
        DateFormat mDateFormat;
        private Set<Integer> mSelectedIndexSet;
        private ConcurrentHashMap<String, Integer> mVCardEntryCountCache;
        private List<VCardFile> mVCardFileList;

        class VCardFileWorkerTask extends AsyncTask<String, Void, Integer> {
            private String mCanonicalPath;
            private WeakReference<TextView> mCountViewReference;
            private WeakReference<ProgressBar> mLoadingProgressBarReference;
            final /* synthetic */ VCardFileListAdapter this$0;

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ Integer doInBackground(String[] r1) {
                return doInBackground2(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ void onPostExecute(Integer r1) {
                onPostExecute2(r1);
            }

            public VCardFileWorkerTask(VCardFileListAdapter r1, ProgressBar r2, TextView r3) {
                this.this$0 = r1;
                this.mLoadingProgressBarReference = new WeakReference(r2);
                this.mCountViewReference = new WeakReference(r3);
            }

            /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
            protected Integer doInBackground2(String... r2) {
                this.mCanonicalPath = r2[0];
                int r3 = 0;
                r3 = Integer.valueOf(getVCardEntryCount(this.mCanonicalPath));     // Catch: Exception -> L5
            L7:
                VCardFileListAdapter.access$2800(this.this$0).put(this.mCanonicalPath, r3);
                return r3;
            L5:
                e = move-exception;
                e.printStackTrace();
                goto L7
            }

            /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
            protected void onPostExecute2(Integer r3) {
                TextView r0 = getAttachedTextView();
                if (r0 == null) goto L5;
                r0.setVisibility(0);
                r0.setText(VCardFileListAdapter.access$2900(this.this$0, r3.intValue()));
            L5:
                ProgressBar r2 = getAttachedProgressBar();
                if (r2 == null) goto L9;
                r2.setVisibility(8);
                return;
            }

            private TextView getAttachedTextView() {
                TextView r0 = this.mCountViewReference.get();
                if (r0 == null) goto L8;
                Object r1 = r0.getTag();
                if ((r1 instanceof VCardFileWorkerTask) == false) goto L10;
                if (this != r1) goto L11;
                return r0;
            L11:
                return null;
            L10:
                return null;
            L8:
                return null;
            }

            private ProgressBar getAttachedProgressBar() {
                ProgressBar r0 = this.mLoadingProgressBarReference.get();
                if (r0 == null) goto L8;
                Object r1 = r0.getTag();
                if ((r1 instanceof VCardFileWorkerTask) == false) goto L10;
                if (this != r1) goto L11;
                return r0;
            L11:
                return null;
            L10:
                return null;
            L8:
                return null;
            }

            private int getVCardEntryCount(String r5) throws IOException, VCardException {
                Uri r6 = Uri.parse("file://" + r5);
                ContentResolver r4 = VCardFileListAdapter.access$2700(this.this$0).getContentResolver();
                VCardEntryCounter r0 = null;
                InputStream r1 = r4.openInputStream(r6);     // Catch: VCardNestedException -> L41
                VCardParser_V21 r2 = new VCardParser_V21();     // Catch: VCardNestedException -> L41
                VCardEntryCounter r3 = new VCardEntryCounter();     // Catch: Throwable -> L13 VCardVersionException -> L37
                r2.addInterpreter(r3);     // Catch: Throwable -> L10 VCardVersionException -> L12
                r2.parse(r1);     // Catch: Throwable -> L10 VCardVersionException -> L12
                if (r1 == null) goto L34;
                r1.close();     // Catch: VCardNestedException -> L9 IOException -> L35
            L9:
                r0 = r3;
            L34:
                return r3.getCount();
            L12:
                r0 = r3;
            L10:
                th = th;
                r0 = r3;
            L29:
                if (r1 != null) goto L42;
            L31:
                throw th;     // Catch: VCardNestedException -> L41
            L42:
                r1.close();     // Catch: IOException -> L36 VCardNestedException -> L41
            L13:
                th = th;
            L50:
                r1.close();     // Catch: Throwable -> L13 IOException -> L38
            L16:
                r1 = r4.openInputStream(r6);     // Catch: Throwable -> L13
                VCardParser_V30 r7 = new VCardParser_V30();     // Catch: Throwable -> L13
                VCardEntryCounter r8 = new VCardEntryCounter();     // Catch: Throwable -> L13 VCardVersionException -> L40
                r7.addInterpreter(r8);     // Catch: Throwable -> L24 VCardVersionException -> L26
                r7.parse(r1);     // Catch: Throwable -> L24 VCardVersionException -> L26
                if (r1 != null) goto L53;
            L23:
                r3 = r8;
                goto L34
            L53:
                r1.close();     // Catch: VCardNestedException -> L22 IOException -> L39
            L22:
                r0 = r8;
                goto L32
            L26:
                r0 = r8;
            L24:
                th = th;
                r0 = r8;
            L28:
                throw new VCardException("vCard with unsupported version.");     // Catch: Throwable -> L13
            L32:
                GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Nested Exception is found (it may be false-positive).");
                r3 = r0;
                goto L34
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return 0;
        }

        static /* synthetic */ Set access$2600(VCardFileListAdapter r0) {
            return r0.mSelectedIndexSet;
        }

        static /* synthetic */ Context access$2700(VCardFileListAdapter r0) {
            return r0.mContext;
        }

        static /* synthetic */ ConcurrentHashMap access$2800(VCardFileListAdapter r0) {
            return r0.mVCardEntryCountCache;
        }

        static /* synthetic */ CharSequence access$2900(VCardFileListAdapter r0, int r1) {
            return r0.getVCardEntryCountString(r1);
        }

        public VCardFileListAdapter(Context r1, List<VCardFile> r2) {
            this.mContext = r1;
            this.mVCardFileList = r2;
            this.mVCardEntryCountCache = new ConcurrentHashMap();
            this.mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.mSelectedIndexSet = new HashSet();
        }

        public Set<Integer> getSelectedIndexSet() {
            return this.mSelectedIndexSet;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<VCardFile> r0 = this.mVCardFileList;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            List<VCardFile> r0 = this.mVCardFileList;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(final int r10, View r11, ViewGroup r12) {
            AnonymousClass1 r0 = null;
            if (r11 != null) goto L5;
            VCardItemViewHolder r13 = new VCardItemViewHolder(r0);
            final View r14 = LayoutInflater.from(this.mContext).inflate(R.layout.select_vcard_dialog_multichoice, r12, false);
            r13.nameView = (TextView) r14.findViewById(R.id.name_view);
            r13.dateView = (TextView) r14.findViewById(R.id.date_view);
            r13.checkedTextView = (OCheckBox) r14.findViewById(R.id.check_text_view);
            r13.countView = (TextView) r14.findViewById(R.id.count_view);
            r13.loadingProgressBar = (ProgressBar) r14.findViewById(R.id.item_circle_progress_bar);
            r14.setTag(r13);
        L6:
            BytedanceApi.setMaxTextSize(r13.nameView, ContactsUtils.dipTopx(this.mContext, 20.0d));
            BytedanceApi.setMaxTextSize(r13.dateView, ContactsUtils.dipTopx(this.mContext, 14.0d));
            BytedanceApi.setMaxTextSize(r13.countView, ContactsUtils.dipTopx(this.mContext, 14.0d));
            VCardFile r2 = this.mVCardFileList.get(r10);
            r13.nameView.setText(r2.getName());
            r13.dateView.setText(this.mDateFormat.format(new Date(r2.getLastModified())));
            r13.loadingProgressBar.setVisibility(0);
            if (this.mSelectedIndexSet.contains(Integer.valueOf(r10)) == false) goto L9;
            r13.checkedTextView.setChecked(true);
        L10:
            r13.checkedTextView.setOnClickListener(new AnonymousClass1(this, r10, r14));
            Integer r15 = this.mVCardEntryCountCache.get(r2.getCanonicalPath());
            if (r15 == null) goto L13;
            r13.countView.setTag(null);
            r13.loadingProgressBar.setTag(null);
            r13.countView.setVisibility(0);
            r13.countView.setText(getVCardEntryCountString(r15.intValue()));
            r13.loadingProgressBar.setVisibility(8);
        L14:
            return r14;
        L13:
            cancelPotentialWork(r13.countView);
            VCardFileWorkerTask r16 = new VCardFileWorkerTask(this, r13.loadingProgressBar, r13.countView);
            r13.countView.setTag(r16);
            r13.loadingProgressBar.setTag(r16);
            r13.countView.setVisibility(4);
            r13.loadingProgressBar.setVisibility(0);
            r16.execute(new String[]{r2.getCanonicalPath()});
            goto L14
        L9:
            r13.checkedTextView.setChecked(false);
            goto L10
        L5:
            r14 = r11;
            r13 = (VCardItemViewHolder) r11.getTag();
            goto L6
        }

        private CharSequence getVCardEntryCountString(int r4) {
            return this.mContext.getResources().getQuantityString(R.plurals.vcard_person, r4, new Object[]{Integer.valueOf(r4)});
        }

        public void cancelPotentialWork(TextView r1) {
            Object r0 = r1.getTag();
            if ((r0 instanceof VCardFileWorkerTask) == false) goto L6;
            ((VCardFileWorkerTask) r0).cancel(true);
            return;
        }
    }

    private static class VCardItemViewHolder {
        public OCheckBox checkedTextView;
        public TextView countView;
        public TextView dateView;
        public ProgressBar loadingProgressBar;
        public TextView nameView;

        private VCardItemViewHolder() {
        }

        /* synthetic */ VCardItemViewHolder(AnonymousClass1 r1) {
            this();
        }
    }

    private class VCardMultiSelectedListener implements DialogInterface.OnClickListener {
        final /* synthetic */ ImportVCardActivity this$0;

        public VCardMultiSelectedListener(ImportVCardActivity r1, boolean r2) {
            this.this$0 = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r6, int r7) {
            if (ImportVCardActivity.access$1100(this.this$0) != null) goto L5;
            return;
        L5:
            Set<Integer> r0 = ImportVCardActivity.access$1100(this.this$0).getSelectedIndexSet();
            boolean r2 = false;
            int r3 = 0;
            if (r7 != (-1)) goto L16;
            if (r0 == null) goto L44;
            ArrayList r8 = new ArrayList();
            int r9 = ImportVCardActivity.access$100(this.this$0).size();
        L9:
            if (r3 >= r9) goto L14;
            if (r0.contains(Integer.valueOf(r3)) == false) goto L13;
            r8.add((VCardFile) ImportVCardActivity.access$100(this.this$0).get(r3));
        L13:
            r3 = r3 + 1;
            goto L9
        L14:
            ImportVCardActivity.access$200(this.this$0, r8);
            return;
        L44:
            return;
        L16:
            if (r7 != (-2)) goto L21;
            if (r6 == null) goto L19;
            r6.dismiss();
        L19:
            this.this$0.finish();
            return;
        L21:
            if (r7 != (-3)) goto L30;
            if (r0 == null) goto L47;
            AlertDialog r10 = (AlertDialog) r6;
            ListView r11 = r10.getListView();
            if (r11 == null) goto L29;
            int r1 = 0;
        L27:
            if (r1 >= r11.getCount()) goto L29;
            r11.setItemChecked(r1, true);
            r1 = r1 + 1;
        L29:
            r10.setCancelable(false);
            ImportVCardActivity.access$1200(this.this$0).sendEmptyMessageDelayed(31, 500);
            return;
        L47:
            return;
        L30:
            if (r0 != null) goto L32;
            return;
        L32:
            if (r0.contains(Integer.valueOf(r7)) == false) goto L34;
            r0.remove(Integer.valueOf(r7));
        L35:
            Button r12 = ((AlertDialog) r6).getButton(-1);
            if (r0.size() <= 0) goto L38;
            r2 = true;
        L38:
            r12.setEnabled(r2);
            ImportVCardActivity.access$1100(this.this$0).notifyDataSetChanged();
            return;
        L34:
            r0.add(Integer.valueOf(r7));
            goto L35
        }
    }

    private class VCardScanThread extends Thread implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
        private volatile boolean mCanceled;
        private Set<String> mCheckedPaths;
        private boolean mGotIOException;
        private boolean mGotNullPointerException;
        private File mRootDirectory;
        private PowerManager.WakeLock mWakeLock;
        final /* synthetic */ ImportVCardActivity this$0;

        private class CanceledException extends Exception {
            final /* synthetic */ VCardScanThread this$1;

            private CanceledException(VCardScanThread r1) {
                this.this$1 = r1;
            }

            /* synthetic */ CanceledException(VCardScanThread r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        private class ModifyTimeComparator implements Comparator<VCardFile> {
            final /* synthetic */ VCardScanThread this$1;

            private ModifyTimeComparator(VCardScanThread r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ModifyTimeComparator(VCardScanThread r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(VCardFile r1, VCardFile r2) {
                return compare2(r1, r2);
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(VCardFile r3, VCardFile r4) {
                if (r3 == null) goto L6;
                if (r4 != null) goto L5;
                return 0;
            L5:
                return (int) (r4.getLastModified() - r3.getLastModified());
            L6:
                return 0;
            }
        }

        public VCardScanThread(ImportVCardActivity r2, File r3) {
            this.this$0 = r2;
            this.mCanceled = false;
            this.mGotIOException = false;
            this.mGotNullPointerException = false;
            this.mRootDirectory = r3;
            this.mCheckedPaths = new HashSet();
            this.mWakeLock = ((PowerManager) r2.getSystemService("power")).newWakeLock(536870918, ImportVCardActivity.LOG_TAG);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ImportVCardActivity.access$102(this.this$0, new Vector());
            this.mWakeLock.acquire();     // Catch: Throwable -> L5 NullPointerException -> L7 IOException -> L9 CanceledException -> L10
            getVCardFileRecursively(this.mRootDirectory);     // Catch: Throwable -> L5 NullPointerException -> L7 IOException -> L9 CanceledException -> L10
        L11:
            this.mWakeLock.release();
            if (this.mCanceled == false) goto L14;
            ImportVCardActivity.access$102(this.this$0, null);
        L14:
            this.this$0.runOnUiThread(new AnonymousClass1(this));
            if (this.mGotIOException == false) goto L18;
            this.this$0.runOnUiThread(new DialogDisplayer(this.this$0, R.id.dialog_io_exception));
            return;
        L18:
            if (this.mCanceled == false) goto L21;
            this.this$0.runOnUiThread(new AnonymousClass2(this));
            return;
        L21:
            if (this.mGotNullPointerException == false) goto L23;
            this.this$0.runOnUiThread(new DialogDisplayer(this.this$0, null));
            return;
        L23:
            int r0 = ImportVCardActivity.access$100(this.this$0).size();
            ImportVCardActivity r1 = this.this$0;
            if (r0 != 0) goto L26;
            r1.runOnUiThread(new DialogDisplayer(this.this$0, R.id.dialog_vcard_not_found));
            return;
        L26:
            ImportVCardActivity.access$1400(r1);
            return;
        L5:
            th = move-exception;
            this.mWakeLock.release();
            throw th;
        L10:
            this.mCanceled = true;     // Catch: Throwable -> L5
        L9:
            this.mGotIOException = true;     // Catch: Throwable -> L5
        L7:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L5
            this.mGotNullPointerException = true;     // Catch: Throwable -> L5
            goto L11
        }

        private void getVCardFileRecursively(File r10) throws CanceledException, IOException, NullPointerException {
            AnonymousClass1 r1 = null;
            if (this.mCanceled == true) goto L31;
            File[] r0 = r10.listFiles();
            if (r0 == null) goto L7;
            int r11 = r0.length;
            int r2 = 0;
        L11:
            if (r2 >= r11) goto L29;
            File r3 = r0[r2];
            if (this.mCanceled == true) goto L28;
            String r4 = r3.getCanonicalPath();
            if (this.mCheckedPaths.contains(r4) == true) goto L26;
            this.mCheckedPaths.add(r4);
            if (r3.isDirectory() == false) goto L21;
            getVCardFileRecursively(r3);
        L25:
            Collections.sort(ImportVCardActivity.access$100(this.this$0), new ModifyTimeComparator(this, r1));
            goto L26
        L21:
            if (r4.toLowerCase().endsWith(".vcf") == false) goto L25;
            if (r3.canRead() == false) goto L25;
            ImportVCardActivity.access$100(this.this$0).add(new VCardFile(r3.getName(), r4, r3.lastModified()));
        L26:
            r2 = r2 + 1;
            goto L11
        L28:
            throw new CanceledException(this, r1);
        L29:
            return;
        L7:
            if (TextUtils.equals(r10.getCanonicalPath(), this.mRootDirectory.getCanonicalPath().concat(ImportVCardActivity.SECURE_DIRECTORY_NAME)) == true) goto L36;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "listFiles() returned null (directory: " + r10 + ")");
            return;
        L36:
            return;
        L31:
            throw new CanceledException(this, r1);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            this.mCanceled = true;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            if (r2 != (-2)) goto L6;
            this.mCanceled = true;
            return;
        }
    }

    private class VCardSelectedListener implements DialogInterface.OnClickListener {
        private int mCurrentIndex;
        final /* synthetic */ ImportVCardActivity this$0;

        public VCardSelectedListener(ImportVCardActivity r1, boolean r2) {
            this.this$0 = r1;
            this.mCurrentIndex = 0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (r3 != (-1)) goto L6;
            ImportVCardActivity r4 = this.this$0;
            ImportVCardActivity.access$1000(r4, (VCardFile) ImportVCardActivity.access$100(r4).get(this.mCurrentIndex));
            return;
        L6:
            if (r3 != (-2)) goto L10;
            if (r2 == null) goto L9;
            r2.dismiss();
        L9:
            this.this$0.finish();
            return;
        L10:
            this.mCurrentIndex = r3;
        }
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_vcard_ImportVCardActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_vcard_ImportVCardActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_vcard_ImportVCardActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_vcard_ImportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ImportVCardActivity() {
        this.mHandler = new AnonymousClass1(this);
        this.mCancelListener = new CancelListener(this, null);
        this.isServiceUnbind = false;
    }

    static /* synthetic */ Dialog access$000(ImportVCardActivity r0) {
        return r0.mVCardFileSelectDialog;
    }

    static /* synthetic */ List access$100(ImportVCardActivity r0) {
        return r0.mAllVCardFileList;
    }

    static /* synthetic */ void access$1000(ImportVCardActivity r0, VCardFile r1) {
        r0.importVCardFromSDCard(r1);
    }

    static /* synthetic */ List access$102(ImportVCardActivity r0, List r1) {
        r0.mAllVCardFileList = r1;
        return r1;
    }

    static /* synthetic */ VCardFileListAdapter access$1100(ImportVCardActivity r0) {
        return r0.mVCardFileListAdapter;
    }

    static /* synthetic */ Handler access$1200(ImportVCardActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ ProgressDialog access$1300(ImportVCardActivity r0) {
        return r0.mProgressDialogForScanVCard;
    }

    static /* synthetic */ ProgressDialog access$1302(ImportVCardActivity r0, ProgressDialog r1) {
        r0.mProgressDialogForScanVCard = r1;
        return r1;
    }

    static /* synthetic */ void access$1400(ImportVCardActivity r0) {
        r0.startVCardSelectAndImport();
    }

    static /* synthetic */ void access$1700(ImportVCardActivity r0, Uri[] r1) {
        r0.askJoinOrNot(r1);
    }

    static /* synthetic */ void access$1800(ImportVCardActivity r0, Uri[] r1, boolean r2) {
        r0.importVCardInternal(r1, r2);
    }

    static /* synthetic */ void access$200(ImportVCardActivity r0, List r1) {
        r0.importVCardFromSDCard(r1);
    }

    static /* synthetic */ boolean access$2000(ImportVCardActivity r0) {
        return r0.mFinishAfterVCardFileSelectDialogDismiss;
    }

    static /* synthetic */ boolean access$2002(ImportVCardActivity r0, boolean r1) {
        r0.mFinishAfterVCardFileSelectDialogDismiss = r1;
        return r1;
    }

    static /* synthetic */ void access$2100(ImportVCardActivity r0) {
        r0.importSelectedVCardFiles();
    }

    static /* synthetic */ void access$2200(ImportVCardActivity r0) {
        r0.updateVCardFileSelectionState();
    }

    static /* synthetic */ void access$2300(ImportVCardActivity r0) {
        r0.toggleAllVCardFileSelection();
    }

    static /* synthetic */ String access$302(ImportVCardActivity r0, String r1) {
        r0.mErrorMessage = r1;
        return r1;
    }

    static /* synthetic */ View access$400(ImportVCardActivity r0) {
        return r0.mVCardFileSelectPositive;
    }

    static /* synthetic */ View access$402(ImportVCardActivity r0, View r1) {
        r0.mVCardFileSelectPositive = r1;
        return r1;
    }

    static /* synthetic */ VCardCacheThread access$600(ImportVCardActivity r0) {
        return r0.mVCardCacheThread;
    }

    static /* synthetic */ ImportRequestConnection access$700(ImportVCardActivity r0) {
        return r0.mConnection;
    }

    static /* synthetic */ boolean access$800(ImportVCardActivity r0) {
        return r0.isServiceUnbind;
    }

    static /* synthetic */ boolean access$802(ImportVCardActivity r0, boolean r1) {
        r0.isServiceUnbind = r1;
        return r1;
    }

    static /* synthetic */ AccountWithDataSet access$900(ImportVCardActivity r0) {
        return r0.mAccount;
    }

    @Override // com.android.contacts.vcard.ImportVCardDialogFragment.Listener
    public void onImportVCardConfirmed(Uri r1, String r2) {
        importVCard(r1);
    }

    @Override // com.android.contacts.vcard.ImportVCardDialogFragment.Listener
    public void onImportVCardDenied() {
        finish();
    }

    private void startVCardSelectAndImport() {
        if (getResources().getBoolean(R.bool.config_import_all_vcard_from_sdcard_automatically) == false) goto L6;
        importVCardFromSDCard(this.mAllVCardFileList);
        return;
    L6:
        if (getResources().getBoolean(R.bool.config_allow_users_select_all_vcard_import) == false) goto L8;
        runOnUiThread(new DialogDisplayer(this, R.id.dialog_select_import_type));
        return;
    L8:
        runOnUiThread(new DialogDisplayer(this, R.id.dialog_select_multiple_vcard));
    }

    private void importVCardFromSDCard(List<VCardFile> r6) {
        String[] r0 = new String[r6.size()];
        Iterator<VCardFile> r7 = r6.iterator();
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        r0[r1] = "file://" + r7.next().getCanonicalPath();
        r1 = r1 + 1;
        goto L4
    L6:
        importVCard(r0);
    }

    private void importVCardFromSDCard(VCardFile r4) {
        importVCard(new Uri[]{Uri.parse("file://" + r4.getCanonicalPath())});
    }

    private void importVCard(Uri r3) {
        importVCard(new Uri[]{r3});
    }

    private void importVCard(String[] r5) {
        int r0 = r5.length;
        Uri[] r1 = new Uri[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = Uri.parse(r5[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        importVCard(r1);
    }

    private void importVCard(final Uri[] r2) {
        runOnUiThread(new AnonymousClass2(this, r2));
    }

    private void importVCardInternal(Uri[] r5, boolean r6) {
        if (isFinishing() == true) goto L5;
        Intent r0 = getIntent();
        String r1 = IntentUtils.getStringExtra(r0, "account_name");
        String r2 = IntentUtils.getStringExtra(r0, "account_type");
        String r3 = IntentUtils.getStringExtra(r0, "data_set");
        if (TextUtils.isEmpty(r1) == false) goto L11;
    L13:
        this.mAccount = LocalAccountContactsUtils.getLocalAccountContacts(null);
    L14:
        this.mVCardCacheThread = new VCardCacheThread(this, r5, r6);
        this.mListener = new NotificationImportExportListener(this);
        if (isFinishing() == false) goto L17;
        return;
    L17:
        if (isDestroyed() == true) goto L22;
        startVCardService();
        return;
    L22:
        return;
    L11:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        this.mAccount = new AccountWithDataSet(r1, r2, r3);
        goto L14
    L5:
        if (ContactsUtils.DEBUG == false) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "Import VCard Activity is finish.");
        return;
    }

    private void askJoinOrNot(final Uri[] r4) {
        if (isFinishing() == true) goto L17;
        if (isDestroyed() == true) goto L17;
        if (this.mAskJoinDialog != null) goto L11;
        AlertDialog.Builder r0 = new AlertDialog.Builder(new ContextThemeWrapper(this, 2131951754));
        r0.setTitle(R.string.common_merge_contacts);
        r0.setMessage(R.string.import_join_contacts_hint);
        r0.setOnCancelListener(new AnonymousClass3(this));
        r0.setPositiveButton(R.string.import_not_join, new AnonymousClass4(this, r4));
        r0.setNegativeButton(R.string.common_merge, new AnonymousClass5(this, r4));
        AlertDialog r5 = r0.create();
        this.mAskJoinDialog = r5;
        r5.setCanceledOnTouchOutside(false);
    L11:
        if (isFinishing() == false) goto L13;
        return;
    L13:
        if (isDestroyed() == true) goto L21;
        this.mAskJoinDialog.show();
        return;
    L21:
        return;
    L17:
        if (ContactsUtils.DEBUG == false) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "Import VCard Activity is finish or destroyed.");
        return;
    }

    private Dialog getSelectImportTypeDialog() {
        ImportTypeSelectedListener r0 = new ImportTypeSelectedListener(this, null);
        AlertDialog.Builder r1 = new AlertDialog.Builder(this).setTitle(R.string.select_vcard_title).setPositiveButton(android.R.string.ok, r0).setOnCancelListener(this.mCancelListener).setNegativeButton(android.R.string.cancel, this.mCancelListener);
        r1.setSingleChoiceItems(new String[]{getString(R.string.import_one_vcard_string), getString(R.string.import_multiple_vcard_string), getString(R.string.import_all_vcard_string)}, 0, r0);
        return r1.create();
    }

    private Dialog getVCardFileSingleSelectDialog() {
        int r0 = this.mAllVCardFileList.size();
        VCardSelectedListener r1 = new VCardSelectedListener(this, false);
        AlertDialog.Builder r3 = new AlertDialog.Builder(this).setTitle(R.string.select_vcard_title).setPositiveButton(android.R.string.ok, r1).setOnCancelListener(this.mCancelListener).setNegativeButton(android.R.string.cancel, this.mCancelListener);
        CharSequence[] r4 = new CharSequence[r0];
        SimpleDateFormat r5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int r6 = 0;
    L3:
        if (r6 >= r0) goto L5;
        VCardFile r7 = this.mAllVCardFileList.get(r6);
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        r8.append(r7.getName());
        r8.append('\n');
        int r9 = r8.length();
        r8.append("(" + r5.format(new Date(r7.getLastModified())) + ")");
        r8.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.vcf_name_text_size)), 0, r9, 33);
        r8.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.contact_count_text_color)), r9, r8.length(), 33);
        r8.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.vcf_last_modified_time_text_size)), r9, r8.length(), 33);
        r4[r6] = r8;
        r6 = r6 + 1;
        goto L3
    L5:
        r3.setSingleChoiceItems(new ArrayAdapter(this, R.layout.select_vcard_dialog_singlechoice, R.id.text1, r4), 0, r1);
        return r3.create();
    }

    private Dialog getVCardFileMultiSelectDialog() {
        final OAlertDialog r0 = new OAlertDialogBuilder(this).title(R.string.select_vcard_title).body(new OViewStyleController(new ImportVCardActivity$$ExternalSyntheticLambda0(this))).horizontalButton().negativeButton(R.string.btn_cancel, new AnonymousClass7(this)).positiveButton(R.string.import_selected_vcard_btn_text, new AnonymousClass6(this)).build();
        r0.setOnShowListener(new AnonymousClass8(this, r0));
        r0.setOnCancelListener(new AnonymousClass9(this));
        r0.setOnDismissListener(new AnonymousClass10(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$getVCardFileMultiSelectDialog$0$com-android-contacts-vcard-ImportVCardActivity, reason: not valid java name */
    /* synthetic */ Unit m226xa528d8dd(DialogContainer r4) {
        FrameLayout r5 = r4.getBodySlot();
        r5.removeAllViews();
        r5.addView(getVCardDialogContainer(), new FrameLayout.LayoutParams(-1, -2));
        return Unit.INSTANCE;
    }

    private View getVCardDialogContainer() {
        View r0 = LayoutInflater.from(this).inflate(R.layout.o_import_v_card_container, null);
        FixHeightByItemCountListView r1 = (FixHeightByItemCountListView) r0.findViewById(R.id.lv_vcard);
        r1.setMaxShowCount(4.0f);
        r1.setItemHeight((int) OUnitExtensionKt.dp2px(64.6f));
        List<VCardFile> r3 = this.mAllVCardFileList;
        if (r3 != null) goto L5;
    L16:
        VCardFileListAdapter r2 = new VCardFileListAdapter(this, this.mAllVCardFileList);
        this.mVCardFileListAdapter = r2;
        r1.setAdapter(r2);
        r1.setOnItemClickListener(new AnonymousClass11(this));
        r0.findViewById(R.id.ll_select_all).setOnClickListener(new AnonymousClass12(this));
        OCheckBox r4 = (OCheckBox) r0.findViewById(R.id.cb_select_all);
        this.mVCardFileSelectAllCheckBox = r4;
        r4.setClickable(false);
        return r0;
    L5:
        if (r3.size() <= 4) goto L16;
        View r5 = new View(this);
        Drawable r6 = r1.getDivider();
        if (r6 == null) goto L12;
        Drawable.ConstantState r7 = r6.getConstantState();
        if (r7 == null) goto L11;
        r6 = r7.newDrawable().mutate();
    L11:
        r5.setBackground(r6);
    L12:
        int r8 = r1.getDividerHeight();
        if (r8 > 0) goto L15;
        r8 = getResources().getDimensionPixelSize(R.dimen.oui_divider_height);
    L15:
        r5.setLayoutParams(new AbsListView.LayoutParams(-1, r8));
        r1.addFooterView(r5, null, false);
        goto L16
    }

    private void toggleAllVCardFileSelection() {
        VCardFileListAdapter r0 = this.mVCardFileListAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        Set<Integer> r1 = r0.getSelectedIndexSet();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.size() != this.mAllVCardFileList.size()) goto L11;
        r1.clear();
    L15:
        this.mVCardFileListAdapter.notifyDataSetChanged();
        updateVCardFileSelectionState();
        return;
    L11:
        r1.clear();
        int r2 = 0;
    L13:
        if (r2 >= this.mAllVCardFileList.size()) goto L15;
        r1.add(Integer.valueOf(r2));
        r2 = r2 + 1;
        goto L13
    }

    private void updateVCardFileSelectionState() {
        VCardFileListAdapter r0 = this.mVCardFileListAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        Set<Integer> r1 = r0.getSelectedIndexSet();
        boolean r2 = false;
        if (r1 != null) goto L8;
        int r3 = 0;
    L9:
        View r4 = this.mVCardFileSelectPositive;
        if (r4 == null) goto L15;
        if (r3 <= 0) goto L13;
        boolean r5 = true;
    L14:
        r4.setEnabled(r5);
        goto L15
    L13:
        r5 = false;
    L15:
        OCheckBox r6 = this.mVCardFileSelectAllCheckBox;
        if (r6 != null) goto L18;
        return;
    L18:
        if (this.mAllVCardFileList.isEmpty() == false) goto L20;
    L22:
        r6.setChecked(r2);
        return;
    L20:
        if (r3 != this.mAllVCardFileList.size()) goto L22;
        r2 = true;
        goto L22
    L8:
        r3 = r1.size();
        goto L9
    }

    private void importSelectedVCardFiles() {
        VCardFileListAdapter r0 = this.mVCardFileListAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        Set<Integer> r1 = r0.getSelectedIndexSet();
        if (r1 == null) goto L20;
        ArrayList r2 = new ArrayList();
        int r3 = this.mAllVCardFileList.size();
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L14;
        if (r1.contains(Integer.valueOf(r4)) == false) goto L12;
        r2.add(this.mAllVCardFileList.get(r4));
    L12:
        r4 = r4 + 1;
        goto L8
    L14:
        if (r2.isEmpty() == true) goto L21;
        importVCardFromSDCard(r2);
        return;
    L21:
        return;
    }

    public void com_android_contacts_vcard_ImportVCardActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        getWindow().addSystemFlags(524288);
        UiUtils.setWindowColorStatusBar(this);
        setContentView(R.layout.import_v_card_activity);
        NotificationChannel r4 = new NotificationChannel(FORGROUND_VCARD_SERVICE_CHANNEL, FORGROUND_VCARD_SERVICE_CHANNEL, 3);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(r4);
        startImport();
    }

    public void com_android_contacts_vcard_ImportVCardActivity__onStop$___twin___() {
        super.onStop();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        if (r3 == 0) goto L5;
        return;
    L5:
        if (r4 != (-1)) goto L7;
        this.mAccount = new AccountWithDataSet(r5.getStringExtra("account_name"), r5.getStringExtra("account_type"), r5.getStringExtra("data_set"));
        startImport();
        return;
    L7:
        if (r4 == 0) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Result code was not OK nor CANCELED: " + r4);
    L9:
        finish();
    }

    private void startImport() {
        Intent r0 = getIntent();
        Uri r1 = r0.getData();
        if (r1 == null) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Starting vCard import using Uri " + r1);
        if (isCallerSelf(this) == false) goto L7;
        importVCard(r1);
        return;
    L7:
        ImportVCardDialogFragment.show(this, r1, getDisplayName(r1));
        return;
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Start vCard without Uri. The user will select vCard manually.");
        doScanExternalStorageAndImportVCard(IntentUtils.getBooleanExtra(r0, "isImportFromExternalSdcard", false));
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r10, Bundle r11) {
        switch(r10) {
            case 2131362497: goto L30;
            case 2131362502: goto L29;
            case 2131362516: goto L26;
            case 2131887002: goto L20;
            default: goto L4;
        };
    L4:
        switch(r10) {
            case 2131362508: goto L18;
            case 2131362509: goto L14;
            case 2131362510: goto L12;
            case 2131362511: goto L9;
            case 2131362512: goto L8;
            default: goto L6;
        };
    L9:
        Dialog r12 = getVCardFileMultiSelectDialog();
        this.mVCardFileSelectDialog = r12;
        return r12;
    L18:
        com.obric.oui.dialog.alert.OAlertDialog r13 = new NoDimDialogBuilder(this).autoDismiss(false).title(R.string.no_sdcard_title).message(R.string.no_sdcard_message).horizontalButton().negativeButton(android.R.string.ok, this.mCancelListener).build();
        r13.setCancelable(true);
        r13.setCanceledOnTouchOutside(true);
        r13.setOnCancelListener(this.mCancelListener);
        return r13;
    L6:
        return super.onCreateDialog(r10, r11);
    L8:
        return getVCardFileSingleSelectDialog();
    L12:
        return getSelectImportTypeDialog();
    L14:
        if (this.mProgressDialogForScanVCard != null) goto L17;
        String r14 = getString(R.string.searching_vcard_title);
        String r15 = getString(R.string.searching_vcard_message);
        ProgressDialog r0 = new ProgressDialog(this);
        this.mProgressDialogForScanVCard = r0;
        r0.setTitle(r14);
        this.mProgressDialogForScanVCard.setMessage(r15);
        this.mProgressDialogForScanVCard.show();
        this.mProgressDialogForScanVCard.setCancelable(false);
        this.mProgressDialogForScanVCard.setOnCancelListener(this.mVCardScanThread);
        this.mVCardScanThread.start();
    L17:
        return this.mProgressDialogForScanVCard;
    L20:
        AccountSelectionUtil.AccountSelectedListener r16 = this.mAccountSelectionListener;
        if (r16 == null) goto L25;
        return AccountSelectionUtil.getSelectAccountDialog(this, R.string.select_import_account_prompt, r16, this.mCancelListener);
    L25:
        throw new NullPointerException("mAccountSelectionListener must not be null.");
    L26:
        OAlertDialogUtils r17 = OAlertDialogUtils.INSTANCE;
        return OAlertDialogUtils.showConfirmationDialog(this, getString(R.string.vcard_not_found_title), getString(R.string.import_failure_has_no_vcard_file), getString(R.string.common_ok), this.mCancelListener, null, getString(R.string.common_cancel), this.mCancelListener, null);
    L30:
        String r18 = this.mErrorMessage;
        if (TextUtils.isEmpty(r18) == false) goto L34;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Error message is null while it must not.");
        r18 = getString(R.string.fail_reason_unknown);
    L34:
        return new AlertDialog.Builder(this).setTitle(getString(R.string.reading_vcard_failed_title)).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(r18).setOnCancelListener(this.mCancelListener).setPositiveButton(android.R.string.ok, this.mCancelListener).create();
    L29:
        return new AlertDialog.Builder(this).setTitle(R.string.scanning_sdcard_failed_title).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(getString(R.string.scanning_sdcard_failed_message, new Object[]{getString(R.string.fail_reason_io_error)})).setOnCancelListener(this.mCancelListener).setPositiveButton(android.R.string.ok, this.mCancelListener).create();
    }

    void startVCardService() {
        this.mConnection = new ImportRequestConnection(this, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Bind to VCardService.");
        startService(new Intent(this, VCardService.class));
        bindService(new Intent(this, VCardService.class), this.mConnection, 1);
    }

    public void com_android_contacts_vcard_ImportVCardActivity__onDestroy$___twin___() {
        super.onDestroy();
        ImportRequestConnection r0 = this.mConnection;
        if (r0 != null) goto L5;
    L7:
        AlertDialog r2 = this.mAskJoinDialog;
        if (r2 == null) goto L11;
        r2.dismiss();
        return;
    L11:
        return;
    L5:
        if (this.isServiceUnbind == true) goto L7;
        unbindService(r0);
        this.isServiceUnbind = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        finish();
    }

    private void doScanExternalStorageAndImportVCard(boolean r2) {
        if (isFinishing() == true) goto L5;
        if (r2 == false) goto L10;
        File r3 = ContactsUtils.getExternalSdcardDirectory();
    L11:
        if (r3 == null) goto L23;
        if (r3.exists() == false) goto L23;
        if (r3.isDirectory() == false) goto L23;
        if (r3.canRead() == false) goto L23;
        this.mVCardScanThread = new VCardScanThread(this, r3);
        if (isFinishing() == true) goto L27;
        showDialog(R.id.dialog_searching_vcard);
        return;
    L27:
        return;
    L23:
        if (isFinishing() == true) goto L29;
        showDialog(R.id.dialog_sdcard_not_found);
        return;
    L29:
        return;
    L10:
        r3 = Environment.getExternalStorageDirectory();
        goto L11
    L5:
        if (ContactsUtils.DEBUG == false) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "Import VCard Activity is finish.");
        return;
    }

    void showFailureNotification(int r4) {
        ((NotificationManager) getSystemService("notification")).notify("VCardServiceFailure", 1, NotificationImportExportListener.constructImportFailureNotification(this, getString(r4)));
        this.mHandler.post(new AnonymousClass13(this));
    }

    public void com_android_contacts_vcard_ImportVCardActivity__finish$___twin___() {
        super.finish();
        AnimationUtil.switchActivityAnimation(this, 0);
    }

    private static boolean isCallerSelf(Activity r2) {
        ComponentName r0 = r2.getCallingActivity();
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = r0.getPackageName();
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.equals(r2.getApplicationContext().getPackageName());
    }

    static boolean isFromMmsIntent(Intent r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getIntExtra(EXTRA_FROM_MMS, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    private String getDisplayName(Uri r11) {
        ?? r3 = 0;
        String r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        if (r11 != null) goto L39;
        return null;
    L39:
        Cursor r10 = getContentResolver().query(r11, new String[]{"_display_name"}, null, null, null);     // Catch: Throwable -> L23 SecurityException -> L25
        if (r10 != null) goto L40;
    L21:
        if (r10 == null) goto L31;
    L22:
        r10.close();
    L31:
        if (TextUtils.isEmpty(r4) == true) goto L33;
        return r4;
    L33:
        return r11.getLastPathSegment();
    L40:
    L19:
        e = e;
    L27:
        LogTag.e(LOG_TAG, e.getMessage());     // Catch: Throwable -> L34
        ContactsApplication.showToast(R.string.reading_vcard_failed_title, 0);     // Catch: Throwable -> L34
        if (r10 == null) goto L31;
    L9:
        if (r10.getCount() <= 0) goto L21;
        if (r10.moveToFirst() == false) goto L21;
        if (r10.getCount() <= 1) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Unexpected multiple rows: " + r10.getCount());     // Catch: SecurityException -> L19 Throwable -> L34
    L15:
        int r1 = r10.getColumnIndex("_display_name");     // Catch: SecurityException -> L19 Throwable -> L34
        if (r1 < 0) goto L21;
        r4 = r10.getString(r1);     // Catch: SecurityException -> L19 Throwable -> L34
        goto L21
    L34:
        th = th;
        r3 = this;
    L36:
        if (r3 == 0) goto L38;
        r3.close();
    L38:
        throw th;
    L25:
        e = e;
        r10 = null;
    L23:
        th = th;
        goto L36
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_vcard_ImportVCardActivity_com_obric_privacyhook_PrivacyHook_onCreate(ImportVCardActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ImportVCardActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_vcard_ImportVCardActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_vcard_ImportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ImportVCardActivity r1) {
        com_android_contacts_vcard_ImportVCardActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_vcard_ImportVCardActivity_com_obric_privacyhook_PrivacyHook_onStop(ImportVCardActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ImportVCardActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_vcard_ImportVCardActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_vcard_ImportVCardActivity_com_obric_privacyhook_PrivacyHook_onDestroy(ImportVCardActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ImportVCardActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_vcard_ImportVCardActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_vcard_ImportVCardActivity_com_obric_privacyhook_PrivacyHook_finish(ImportVCardActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ImportVCardActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_vcard_ImportVCardActivity__finish$___twin___();
    }
}
