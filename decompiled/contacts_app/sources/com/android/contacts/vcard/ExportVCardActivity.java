package com.android.contacts.vcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.FileProviderCompat;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import java.io.File;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ExportVCardActivity extends Activity implements ServiceConnection, DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
    private static final boolean DEBUG = false;
    private static final String KEY_TARGET_FILE_NAME = "targetFileName";
    private static final String LOG_TAG = "VCardExport";
    private boolean mConnected;
    private String mErrorReason;
    private final Messenger mIncomingMessenger;
    private boolean mIsExportToExternalSdcard;
    private volatile boolean mProcessOngoing;
    private VCardService mService;
    private String mTargetFileName;

    /* JADX INFO: renamed from: com.android.contacts.vcard.ExportVCardActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ExportConfirmationListener implements DialogInterface.OnClickListener {
        private final Uri mDestinationUri;
        final /* synthetic */ ExportVCardActivity this$0;

        public ExportConfirmationListener(ExportVCardActivity r3, String r4) {
            this(r3, Uri.parse("file://" + r4));
        }

        public ExportConfirmationListener(ExportVCardActivity r1, Uri r2) {
            this.this$0 = r1;
            this.mDestinationUri = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public synchronized void onClick(DialogInterface r4, int r5) {
            monitor-enter(this);
            if (r5 == (-1)) goto L15;
        L9:
            ExportVCardActivity.access$500(this.this$0);     // Catch: Throwable -> L12
            monitor-exit(this);
            return;
        L12:
            th = move-exception;
            throw th;
        L15:
            if (ExportVCardActivity.access$000() == false) goto L8;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ExportVCardActivity.LOG_TAG, String.format("Try sending export request (uri: %s)", new Object[]{this.mDestinationUri}));     // Catch: Throwable -> L12
        L8:
            ExportVCardActivity.access$400(this.this$0).handleExportRequest(new ExportRequest(this.mDestinationUri), new NotificationImportExportListener(this.this$0));     // Catch: Throwable -> L12
            goto L9
        }
    }

    private class IncomingHandler extends Handler {
        final /* synthetic */ ExportVCardActivity this$0;

        private IncomingHandler(ExportVCardActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ IncomingHandler(ExportVCardActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            if (ExportVCardActivity.access$000() == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ExportVCardActivity.LOG_TAG, "IncomingHandler received message.");
        L6:
            if (r5.arg1 == 0) goto L13;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ExportVCardActivity.LOG_TAG, "Message returned from vCard server contains error code.");
            if (r5.obj == null) goto L10;
            ExportVCardActivity.access$102(this.this$0, (String) r5.obj);
        L10:
            this.this$0.showDialog(r5.arg1);
            return;
        L13:
            if (r5.what == 5) goto L16;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ExportVCardActivity.LOG_TAG, "Unknown message type: " + r5.what);
            super.handleMessage(r5);
            return;
        L16:
            if (r5.obj != null) goto L18;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ExportVCardActivity.LOG_TAG, "Message returned from vCard server doesn't contain valid path");
            ExportVCardActivity r6 = this.this$0;
            ExportVCardActivity.access$102(r6, r6.getString(R.string.fail_reason_unknown));
            this.this$0.showDialog(R.id.dialog_fail_to_export_with_reason);
            return;
        L18:
            ExportVCardActivity.access$202(this.this$0, (String) r5.obj);
            if (TextUtils.isEmpty(ExportVCardActivity.access$200(this.this$0)) == false) goto L22;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ExportVCardActivity.LOG_TAG, "Destination file name coming from vCard service is empty.");
            ExportVCardActivity r7 = this.this$0;
            ExportVCardActivity.access$102(r7, r7.getString(R.string.fail_reason_unknown));
            this.this$0.showDialog(R.id.dialog_fail_to_export_with_reason);
            return;
        L22:
            if (ExportVCardActivity.access$000() == false) goto L24;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ExportVCardActivity.LOG_TAG, String.format("Target file name is set (%s). Show confirmation dialog", new Object[]{ExportVCardActivity.access$200(this.this$0)}));
        L24:
            this.this$0.showDialog(R.id.dialog_export_confirmation);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_vcard_ExportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ExportVCardActivity() {
        this.mProcessOngoing = true;
        this.mIncomingMessenger = new Messenger(new IncomingHandler(this, null));
        this.mIsExportToExternalSdcard = false;
    }

    static /* synthetic */ boolean access$000() {
        return DEBUG;
    }

    static /* synthetic */ String access$102(ExportVCardActivity r0, String r1) {
        r0.mErrorReason = r1;
        return r1;
    }

    static /* synthetic */ String access$200(ExportVCardActivity r0) {
        return r0.mTargetFileName;
    }

    static /* synthetic */ String access$202(ExportVCardActivity r0, String r1) {
        r0.mTargetFileName = r1;
        return r1;
    }

    static /* synthetic */ VCardService access$400(ExportVCardActivity r0) {
        return r0.mService;
    }

    static /* synthetic */ void access$500(ExportVCardActivity r0) {
        r0.unbindAndFinish();
    }

    static {
        DEBUG = VCardService.DEBUG;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r5) {
        super.onCreate(r5);
        UiUtils.setWindowColorStatusBar(this);
        File r6 = FileProviderCompat.getConfigDir(this);
        if (r6.exists() == false) goto L9;
        if (r6.isDirectory() == false) goto L9;
        if (r6.canRead() == false) goto L9;
    L13:
        if (getIntent() == null) goto L15;
        this.mIsExportToExternalSdcard = getIntent().getBooleanExtra("isExportToExternalSdcard", false);
    L15:
        Intent r7 = new Intent(this, VCardService.class);
        if (startService(r7) != null) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Failed to start vCard service");
        this.mErrorReason = getString(R.string.fail_reason_unknown);
        showDialog(R.id.dialog_fail_to_export_with_reason);
        return;
    L20:
        if (bindService(r7, this, 1) == true) goto L23;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Failed to connect to vCard service.");
        this.mErrorReason = getString(R.string.fail_reason_unknown);
        showDialog(R.id.dialog_fail_to_export_with_reason);
        return;
    L23:
        return;
    L9:
        if (r6.mkdirs() == true) goto L13;
        showDialog(R.id.dialog_sdcard_not_found);
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName r2, IBinder r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "connected to service, requesting a destination file name");     // Catch: Throwable -> L9
    L6:
        this.mConnected = true;     // Catch: Throwable -> L9
        VCardService r4 = ((VCardService.MyBinder) r3).getService();     // Catch: Throwable -> L9
        this.mService = r4;     // Catch: Throwable -> L9
        r4.handleRequestAvailableExportDestination(this.mIncomingMessenger, this.mIsExportToExternalSdcard);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "onServiceDisconnected()");     // Catch: Throwable -> L11
    L6:
        this.mService = null;     // Catch: Throwable -> L11
        this.mConnected = false;     // Catch: Throwable -> L11
        if (this.mProcessOngoing == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Disconnected from service during the process ongoing.");     // Catch: Throwable -> L11
        this.mErrorReason = getString(R.string.fail_reason_unknown);     // Catch: Throwable -> L11
        showDialog(R.id.dialog_fail_to_export_with_reason);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r6, Bundle r7) {
        switch(r6) {
            case 2131362499: goto L16;
            case 2131362501: goto L10;
            case 2131362508: goto L8;
            case 2131886929: goto L6;
            default: goto L5;
        };
    L6:
        this.mProcessOngoing = false;
        return new OAlertDialogBuilder(this).title(R.string.exporting_contact_failed_title).message(getString(R.string.exporting_contact_failed_message, new Object[]{getString(R.string.fail_reason_too_many_vcard)})).horizontalButton().positiveButton(android.R.string.ok, this).build();
    L8:
        this.mProcessOngoing = false;
        return new OAlertDialogBuilder(this).title(R.string.no_sdcard_title).message(R.string.no_sdcard_message).horizontalButton().positiveButton(android.R.string.ok, this).build();
    L10:
        this.mProcessOngoing = false;
        OAlertDialogBuilder r8 = new OAlertDialogBuilder(this).title(R.string.exporting_contact_failed_title);
        Object[] r9 = new Object[1];
        String r1 = this.mErrorReason;
        if (r1 != null) goto L14;
        r1 = getString(R.string.fail_reason_unknown);
    L14:
        r9[0] = r1;
        OAlertDialog r10 = r8.message(getString(R.string.exporting_contact_failed_message, r9)).horizontalButton().positiveButton(android.R.string.ok, this).build();
        r10.setCancelable(true);
        r10.setCanceledOnTouchOutside(true);
        r10.setOnCancelListener(this);
        return r10;
    L16:
        OAlertDialog r11 = new OAlertDialogBuilder(this).title(R.string.confirm_export_title).message(getString(R.string.confirm_export_message, new Object[]{this.mTargetFileName})).horizontalButton().negativeButton(android.R.string.cancel, this).positiveButton(android.R.string.ok, new ExportConfirmationListener(this, this.mTargetFileName)).build();
        r11.setCancelable(true);
        r11.setCanceledOnTouchOutside(true);
        r11.setOnCancelListener(this);
        return r11;
    L5:
        return super.onCreateDialog(r6, r7);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int r2, Dialog r3, Bundle r4) {
        if (r2 != R.id.dialog_fail_to_export_with_reason) goto L6;
        ((AlertDialog) r3).setMessage(this.mErrorReason);
        return;
    L6:
        if (r2 != R.id.dialog_export_confirmation) goto L11;
        String r5 = this.mTargetFileName.substring(11);
        if (this.mTargetFileName.contains("/bytedance/contact") == false) goto L10;
        String r6 = this.mTargetFileName;
        r5 = r6.substring(r6.indexOf("/bytedance/contact"));
    L10:
        ((OAlertDialog) r3).setMessage(getString(R.string.confirm_export_message, new Object[]{r5}), false);
        return;
    L11:
        super.onPrepareDialog(r2, r3, r4);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putString(KEY_TARGET_FILE_NAME, this.mTargetFileName);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle r2) {
        super.onRestoreInstanceState(r2);
        this.mTargetFileName = r2.getString(KEY_TARGET_FILE_NAME);
    }

    public void com_android_contacts_vcard_ExportVCardActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() == true) goto L6;
        unbindAndFinish();
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "ExportVCardActivity#onClick() is called");
    L5:
        unbindAndFinish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r2) {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "ExportVCardActivity#onCancel() is called");
    L5:
        this.mProcessOngoing = false;
        unbindAndFinish();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection r2) {
        this.mProcessOngoing = false;
        super.unbindService(r2);
    }

    private synchronized void unbindAndFinish() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mConnected == false) goto L6;
        unbindService(this);     // Catch: Throwable -> L9
        this.mConnected = false;     // Catch: Throwable -> L9
    L6:
        finish();     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AnimationUtil.switchActivityAnimation(this, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_vcard_ExportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ExportVCardActivity r1) {
        r1.com_android_contacts_vcard_ExportVCardActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
