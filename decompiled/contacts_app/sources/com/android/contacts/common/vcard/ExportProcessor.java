package com.android.contacts.common.vcard;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.vcard.VCardComposer;
import com.android.vcard.VCardConfig;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: loaded from: classes.dex */
public class ExportProcessor extends ProcessorBase {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "VCardExport";
    private final int SHOW_READY_TOAST;
    private final Handler handler;
    private final String mCallingActivity;
    private volatile boolean mCanceled;
    private volatile boolean mDone;
    private final ExportRequest mExportRequest;
    private final int mJobId;
    private final NotificationManager mNotificationManager;
    private final ContentResolver mResolver;
    private final VCardService mService;
    private String selExport;

    @Override // com.android.contacts.common.vcard.ProcessorBase
    public final int getType() {
        return 2;
    }

    static /* synthetic */ VCardService access$000(ExportProcessor r0) {
        return r0.mService;
    }

    public ExportProcessor(VCardService r2, ExportRequest r3, int r4, String r5) {
        this.selExport = "";
        this.SHOW_READY_TOAST = 1;
        this.handler = new AnonymousClass1(this);
        this.mService = r2;
        this.mResolver = r2.getContentResolver();
        this.mNotificationManager = (NotificationManager) r2.getSystemService("notification");
        this.mExportRequest = r3;
        this.mJobId = r4;
        this.mCallingActivity = r5;
    }

    @Override // com.android.contacts.common.vcard.ProcessorBase, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        runInternal();     // Catch: Throwable -> L13 RuntimeException -> L15 OutOfMemoryError -> L18
        if (isCancelled() == false) goto L6;
        doCancelNotification();     // Catch: Throwable -> L13 RuntimeException -> L15 OutOfMemoryError -> L18
    L6:
        monitor-enter(this);
        this.mDone = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        monitor-enter(this);
        this.mDone = true;     // Catch: Throwable -> L25
        throw th;
    L25:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "OutOfMemoryError thrown during import", e);     // Catch: Throwable -> L13
        throw e;     // Catch: Throwable -> L13
    L15:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "RuntimeException thrown during export", e);     // Catch: Throwable -> L13
        throw e;     // Catch: Throwable -> L13
    }

    private void runInternal() {
        ExportRequest r4 = this.mExportRequest;
        VCardComposer r5 = null;
        boolean r6 = false;
    L86:
        th = move-exception;
        Throwable r7 = th;
        BufferedWriter r10 = null;
    L88:
        if (r5 == null) goto L90;
        r5.terminate();
    L90:
        if (r10 != null) goto L109;
    L95:
        this.mService.handleFinishExportNotification(this.mJobId, r6);
        throw r7;
    L109:
        r10.close();     // Catch: IOException -> L93
    L93:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "IOException is thrown during close(). Ignored. " + e);
        goto L95
    L4:
        if (isCancelled() == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Export request is cancelled before handling the request");     // Catch: Throwable -> L86
    L6:
        this.mService.handleFinishExportNotification(this.mJobId, false);
        return;
    L8:
        Uri r8 = r4.destUri;     // Catch: Throwable -> L86
        OutputStream r9 = this.mResolver.openOutputStream(r8);     // Catch: FileNotFoundException -> L83 Throwable -> L86
        String r11 = r4.exportType;     // Catch: Throwable -> L86
        if (TextUtils.isEmpty(r11) == false) goto L14;
        int r12 = VCardConfig.getVCardTypeFromString(this.mService.getString(R.string.config_export_vcard_type));     // Catch: Throwable -> L86
    L15:
        VCardComposer r15 = new VCardComposer(this.mService, r12, true);     // Catch: Throwable -> L86
        r10 = new BufferedWriter(new OutputStreamWriter(r9));     // Catch: Throwable -> L80
        VCardComposer r18 = r15;
    L75:
        th = th;
    L79:
        r7 = th;
    L82:
        r5 = r18;
        goto L88
    L20:
        if (r15.init(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id"}, this.selExport, null, null, ContactsContract.RawContactsEntity.CONTENT_URI) == true) goto L28;
        String r13 = r18.getErrorReason();     // Catch: Throwable -> L75
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "initialization of vCard composer failed: " + r13);     // Catch: Throwable -> L75
        doFinishNotification(this.mService.getString(R.string.fail_reason_could_not_initialize_exporter, new Object[]{translateComposerError(r13)}), null);     // Catch: Throwable -> L75
        r18.terminate();
        r10.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        IOException r14 = e;
        StringBuilder r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
    L27:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, r0.append(r14).toString());
        goto L6
    L28:
        int r1 = r18.getCount();     // Catch: Throwable -> L75
        if (r1 != 0) goto L36;
        doFinishNotification(this.mService.getString(R.string.fail_reason_no_exportable_contact), null);     // Catch: Throwable -> L75
        r18.terminate();
        r10.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        r14 = e;
        r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
        goto L27
    L36:
        int r16 = 1;
    L38:
        if (r18.isAfterLast() == true) goto L58;
        if (isCancelled() == true) goto L41;
        r10.write(r18.createOneEntry());     // Catch: IOException -> L52 Throwable -> L75
    L49:
        if ((r16 % 100) != 1) goto L51;
        doProgressNotification(r8, r1, r16);     // Catch: Throwable -> L75
    L51:
        r16 = r16 + 1;     // Catch: Throwable -> L75
    L52:
        String r2 = r18.getErrorReason();     // Catch: Throwable -> L75
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Failed to read a contact: " + r2);     // Catch: Throwable -> L75
        doFinishNotification(this.mService.getString(R.string.fail_reason_error_occurred_during_export, new Object[]{translateComposerError(r2)}), null);     // Catch: Throwable -> L75
        r18.terminate();
        r10.close();     // Catch: IOException -> L56
    L56:
        e = move-exception;
        r14 = e;
        r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
        goto L27
    L41:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Export request is cancelled during composing vCard");     // Catch: Throwable -> L75
        r18.terminate();
        r10.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        r14 = e;
        r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
        goto L27
    L58:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Successfully finished exporting vCard " + r4.destUri);     // Catch: Throwable -> L75
        this.mService.updateMediaScanner(r4.destUri.getPath());     // Catch: Throwable -> L75
        String r3 = ExportVCardActivity.getOpenableUriDisplayName(this.mService, r8);     // Catch: Throwable -> L73
        if (isLocalFile(r8) == false) goto L62;
        Message r17 = this.handler.obtainMessage();     // Catch: Throwable -> L73
        r17.arg1 = 1;     // Catch: Throwable -> L73
        this.handler.sendMessage(r17);     // Catch: Throwable -> L73
        doFinishNotificationWithShareAction(this.mService.getString(R.string.exporting_vcard_finished_title_fallback), this.mService.getString(R.string.touch_to_share_contacts), r8);     // Catch: Throwable -> L73
    L66:
        r18.terminate();
        r10.close();     // Catch: IOException -> L69
    L71:
        this.mService.handleFinishExportNotification(this.mJobId, true);
        return;
    L69:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "IOException is thrown during close(). Ignored. " + e);
        goto L71
    L62:
        if (r3 != null) goto L64;
        String r19 = this.mService.getString(R.string.exporting_vcard_finished_title_fallback);     // Catch: Throwable -> L73
    L65:
        doFinishNotification(r19, null);     // Catch: Throwable -> L73
        goto L66
    L64:
        r19 = this.mService.getString(R.string.exporting_vcard_finished_title, new Object[]{r3});     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        r7 = th;
        r6 = true;
    L77:
        th = th;
        r18 = r15;
    L80:
        th = move-exception;
        r18 = r15;
        r7 = th;
        r10 = null;
        goto L82
    L14:
        r12 = VCardConfig.getVCardTypeFromString(r11);     // Catch: Throwable -> L86
        goto L15
    L83:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "FileNotFoundException thrown", e);     // Catch: Throwable -> L86
        doFinishNotification(this.mService.getString(R.string.fail_reason_could_not_open_file, new Object[]{r8, e.getMessage()}), null);     // Catch: Throwable -> L86
        goto L6
    }

    private boolean isLocalFile(Uri r2) {
        String r3 = r2.getAuthority();
        return this.mService.getString(R.string.contacts_file_provider_authority).equals(r3);
    }

    private String translateComposerError(String r2) {
        Resources r1 = this.mService.getResources();
        if (VCardComposer.FAILURE_REASON_FAILED_TO_GET_DATABASE_INFO.equals(r2) == false) goto L7;
        return r1.getString(R.string.composer_failed_to_get_database_infomation);
    L7:
        if (VCardComposer.FAILURE_REASON_NO_ENTRY.equals(r2) == false) goto L11;
        return r1.getString(R.string.composer_has_no_exportable_contact);
    L11:
        if (VCardComposer.FAILURE_REASON_NOT_INITIALIZED.equals(r2) == true) goto L13;
        return r2;
    L13:
        return r1.getString(R.string.composer_not_initialized);
    }

    private void doProgressNotification(Uri r9, int r10, int r11) {
        String r5 = r9.getLastPathSegment();
        this.mNotificationManager.notify("VCardServiceProgress", this.mJobId, NotificationImportExportListener.constructProgressNotification(this.mService, 2, this.mService.getString(R.string.exporting_contact_list_message, new Object[]{r5}), this.mService.getString(R.string.exporting_contact_list_title), this.mJobId, r5, r10, r11));
    }

    private void doCancelNotification() {
        this.mNotificationManager.notify("VCardServiceProgress", this.mJobId, NotificationImportExportListener.constructCancelNotification(this.mService, this.mService.getString(R.string.exporting_vcard_canceled_title, new Object[]{this.mExportRequest.destUri.getLastPathSegment()})));
    }

    private void doFinishNotification(String r4, String r5) {
        Intent r0 = new Intent();
        r0.setClassName(this.mService, this.mCallingActivity);
        Notification r6 = NotificationImportExportListener.constructFinishNotification(this.mService, r4, r5, r0);
        this.mNotificationManager.notify("VCardServiceProgress", this.mJobId, r6);
    }

    private void doFinishNotificationWithShareAction(String r3, String r4, Uri r5) {
        Intent r0 = new Intent("android.intent.action.SEND");
        r0.setType("text/x-vcard");
        r0.putExtra("android.intent.extra.STREAM", r5);
        r0.setFlags(1);
        Notification r6 = NotificationImportExportListener.constructFinishNotificationWithFlags(this.mService, r3, r4, r0, 268435456);
        this.mNotificationManager.notify("VCardServiceProgress", this.mJobId, r6);
    }

    @Override // com.android.contacts.common.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean cancel(boolean r1) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mDone == false) goto L6;
    L11:
        monitor-exit(this);
        return false;
    L6:
        if (this.mCanceled == true) goto L11;
        this.mCanceled = true;     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    }

    @Override // com.android.contacts.common.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r0 = this.mCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.contacts.common.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean isDone() {
        monitor-enter(this);
        boolean r0 = this.mDone;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public ExportRequest getRequest() {
        return this.mExportRequest;
    }

    public void setSelExport(String r1) {
        this.selExport = r1;
    }
}
