package com.android.contacts.vcard;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.ReflectUtils;
import com.android.contacts.activities.ContactsSettingIEActivity;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.android.contacts.util.NotificationManagerHelper;
import com.android.vcard.VCardComposer;
import com.android.vcard.VCardConfig;
import com.obric.utils.OpenFileInFileManagerReceiver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: loaded from: classes2.dex */
public class ExportProcessor extends ProcessorBase {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "VCardExport";
    private volatile boolean mCanceled;
    private volatile boolean mDone;
    private final ExportRequest mExportRequest;
    private final int mJobId;
    private VCardImportExportListener mListener;
    private final NotificationManagerHelper mNotificationHelper;
    private final NotificationManager mNotificationManager;
    private final ContentResolver mResolver;
    private final VCardService mService;

    @Override // com.android.contacts.vcard.ProcessorBase
    public final int getType() {
        return 2;
    }

    static {
        DEBUG = VCardService.DEBUG;
    }

    public ExportProcessor(VCardService r2, VCardImportExportListener r3, ExportRequest r4, int r5) {
        this.mService = r2;
        this.mResolver = r2.getContentResolver();
        this.mNotificationManager = (NotificationManager) r2.getSystemService("notification");
        this.mExportRequest = r4;
        this.mJobId = r5;
        this.mListener = r3;
        this.mNotificationHelper = new NotificationManagerHelper();
    }

    @Override // com.android.contacts.vcard.ProcessorBase, java.util.concurrent.RunnableFuture, java.lang.Runnable
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
        boolean r5 = false;
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, String.format("vCard export (id: %d) has started.", new Object[]{Integer.valueOf(this.mJobId)}));
    L5:
        ExportRequest r4 = this.mExportRequest;
        VCardComposer r8 = null;
    L126:
        th = move-exception;
        Throwable r2 = th;
        BufferedWriter r11 = null;
    L128:
        if (r8 == null) goto L130;
        r8.terminate();
    L130:
        if (r11 != null) goto L156;
    L135:
        this.mService.handleFinishExportNotification(this.mJobId, r5);
        throw r2;
    L156:
        r11.close();     // Catch: IOException -> L133
    L133:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "IOException is thrown during close(). Ignored. " + e);
        goto L135
    L7:
        if (isCancelled() == false) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Export request is cancelled before handling the request");     // Catch: Throwable -> L126
    L9:
        this.mService.handleFinishExportNotification(this.mJobId, false);
        return;
    L11:
        Uri r9 = r4.destUri;     // Catch: Throwable -> L126
        OutputStream r3 = this.mResolver.openOutputStream(r9);     // Catch: FileNotFoundException -> L116 Throwable -> L126
        String r12 = r4.exportType;     // Catch: Throwable -> L126
        if (TextUtils.isEmpty(r12) == false) goto L17;
        int r13 = VCardConfig.getVCardTypeFromString(this.mService.getString(R.string.config_export_vcard_type));     // Catch: Throwable -> L126
    L18:
        VCardComposer r15 = new VCardComposer(this.mService, r13, true);     // Catch: Throwable -> L126
        r15.setPhoneNumberTranslationCallback(new AnonymousClass1(this));     // Catch: Throwable -> L113
        r11 = new BufferedWriter(new OutputStreamWriter(r3));     // Catch: Throwable -> L113
        VCardComposer r19 = r15;
    L108:
        th = th;
    L112:
        r2 = th;
    L115:
        r8 = r19;
        goto L128
    L23:
        if (r15.init(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id"}, null, null, null, ContactsContract.RawContactsEntity.CONTENT_URI.buildUpon().appendQueryParameter("for_export_only", "1").build()) == true) goto L41;
        String r6 = r19.getErrorReason();     // Catch: Throwable -> L108
        if (VCardComposer.NO_ERROR.equals(r6) == true) goto L27;
    L35:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "initialization of vCard composer failed: " + r6);     // Catch: Throwable -> L108
        doFinishNotification(this.mService.getString(R.string.fail_reason_could_not_initialize_exporter, new Object[]{translateComposerError(r6)}), 2, null, null);     // Catch: Throwable -> L108
        r19.terminate();
        r11.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        IOException r7 = e;
        StringBuilder r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
    L34:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, r0.append(r7).toString());
        goto L9
    L27:
        if (r19.getCount() != 0) goto L35;
        String r1 = this.mService.getString(R.string.fail_reason_no_exportable_contact);     // Catch: Throwable -> L108
        VCardService r10 = this.mService;     // Catch: Throwable -> L108
        doFinishNotification(r1, 2, r10.getString(R.string.exporting_contact_failed_message, new Object[]{r10.getString(R.string.contacts_empty)}), null);     // Catch: Throwable -> L108
        r19.terminate();
        r11.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        r7 = e;
        r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
        goto L34
    L41:
        int r14 = r19.getCount();     // Catch: Throwable -> L108
        if (r14 != 0) goto L49;
        doFinishNotification(this.mService.getString(R.string.fail_reason_no_exportable_contact), 2, null, null);     // Catch: Throwable -> L108
        r19.terminate();
        r11.close();     // Catch: IOException -> L47
    L47:
        e = move-exception;
        r7 = e;
        r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
        goto L34
    L49:
        int r16 = 1;
    L51:
        if (r19.isAfterLast() == true) goto L90;
        if (isCancelled() == true) goto L54;
        r11.write(r19.createOneEntry());     // Catch: IllegalStateException -> L68 IOException -> L74 Throwable -> L108
    L63:
        if ((r16 % 100) != 1) goto L67;
        if (this.mNotificationHelper.shouldNotifyNotificationLimit() == false) goto L67;
        doProgressNotification(r9, r14, r16);     // Catch: Throwable -> L108
    L67:
        r16 = r16 + 1;     // Catch: Throwable -> L108
    L68:
        VCardService r17 = this.mService;     // Catch: Throwable -> L108
        doFinishNotification(r17.getString(R.string.fail_reason_error_occurred_during_export, new Object[]{r17.getResources().getString(R.string.composer_failed_to_get_database_infomation)}), 2, null, null);     // Catch: Throwable -> L108
        r19.terminate();
        r11.close();     // Catch: IOException -> L72
    L72:
        e = move-exception;
        r7 = e;
        r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
    L74:
        e = move-exception;
        String r18 = r19.getErrorReason();     // Catch: Throwable -> L108
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Failed to read a contact: " + r18);     // Catch: Throwable -> L108
        String r20 = translateComposerError(r18);     // Catch: Throwable -> L108
        if (r20 != null) goto L78;
    L84:
        doFinishNotification(this.mService.getString(R.string.fail_reason_error_occurred_during_export, new Object[]{r20}), 2, null, null);     // Catch: Throwable -> L108
    L85:
        r19.terminate();
        r11.close();     // Catch: IOException -> L88
    L88:
        e = move-exception;
        r7 = e;
        r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
        goto L34
    L78:
        if (r20.equals(r18) == false) goto L84;
        if (ReflectUtils.isNoSpaceException(e) == false) goto L82;
        String r21 = this.mService.getString(R.string.msgs_no_disk_space);     // Catch: Throwable -> L108
    L83:
        doFinishNotification(this.mService.getString(R.string.fail_error_occurred_during_export), 2, r21, null);     // Catch: Throwable -> L108
        goto L85
    L82:
        r21 = null;
        goto L83
    L54:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Export request is cancelled during composing vCard");     // Catch: Throwable -> L108
        r19.terminate();
        r11.close();     // Catch: IOException -> L58
    L58:
        e = move-exception;
        r7 = e;
        r0 = new StringBuilder("IOException is thrown during close(). Ignored. ");
        goto L34
    L90:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Successfully finished exporting vCard " + r4.destUri);     // Catch: Throwable -> L108
        if (DEBUG == false) goto L93;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "Ask MediaScanner to scan the file: " + r4.destUri.getPath());     // Catch: Throwable -> L108
    L93:
        String r22 = r4.destUri.getPath();     // Catch: Throwable -> L108
        if (r22 == null) goto L145;
        this.mService.updateMediaScanner(r22);     // Catch: Throwable -> L108
    L145:
        String r23 = this.mService.getString(R.string.exporting_vcard_finished_title, new Object[]{r9.getLastPathSegment()});     // Catch: Throwable -> L106
        this.mService.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r9));     // Catch: Throwable -> L106
        if (r22 == null) goto L99;
        doFinishNotification(r23, 2, this.mService.getString(R.string.view_vcard_notification_message), new File(r22).getParent());     // Catch: Throwable -> L106
    L99:
        r19.terminate();
        r11.close();     // Catch: IOException -> L102
    L104:
        this.mService.handleFinishExportNotification(this.mJobId, true);
        return;
    L102:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "IOException is thrown during close(). Ignored. " + e);
    L106:
        th = move-exception;
        r2 = th;
        r5 = true;
    L110:
        th = th;
        r19 = r15;
    L113:
        th = move-exception;
        r19 = r15;
        r2 = th;
        r11 = null;
        goto L115
    L17:
        r13 = VCardConfig.getVCardTypeFromString(r12);     // Catch: Throwable -> L126
        goto L18
    L116:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "FileNotFoundException thrown", e);     // Catch: Throwable -> L126
        String r24 = this.mService.getString(R.string.fail_reason_could_not_open_file, new Object[]{r9});     // Catch: Throwable -> L126
        if (r9 != null) goto L120;
    L124:
        doFinishNotification(r24, 2, null, null);     // Catch: Throwable -> L126
        goto L9
    L120:
        if (r9.getPath() == null) goto L124;
        if (r9.getPath().contains("/bytedance/contact") == false) goto L124;
        r24 = this.mService.getString(R.string.fail_reason_could_not_open_file, new Object[]{r9.getPath().substring(r9.getPath().indexOf("/bytedance/contact"))});     // Catch: Throwable -> L126
        goto L124
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

    private void doProgressNotification(Uri r8, int r9, int r10) {
        String r4 = r8.getLastPathSegment();
        this.mListener.onExportParsed(this.mService.getString(R.string.exporting_contact_list_message, new Object[]{r4}), this.mService.getString(R.string.exporting_contact_list_title), this.mJobId, r4, r9, r10);
    }

    private void doCancelNotification() {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "send cancel notification");
    L5:
        this.mListener.onExportCanceled(this.mJobId, this.mService.getString(R.string.exporting_vcard_canceled_title, new Object[]{this.mExportRequest.destUri.getLastPathSegment()}));
    }

    private void doFinishNotification(String r3, int r4, String r5, String r6) {
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "send finish notification: " + r3 + ", " + r5 + ", " + r6);
    L6:
        if (this.mService.getString(R.string.view_vcard_notification_message).equals(r5) == false) goto L8;
        Intent r7 = new Intent(this.mService, OpenFileInFileManagerReceiver.class);
        r7.putExtra(OpenFileInFileManagerReceiver.INTENT_FILE_PATH, r6);
        this.mListener.onExportFinished(this.mJobId, r3, r5, PendingIntent.getBroadcast(this.mService, 0, r7, 201326592));
        return;
    L8:
        Intent r8 = new Intent(this.mService, ContactsSettingIEActivity.class);
        r8.addFlags(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST);
        r8.putExtra("fromFlag", 1);
        this.mListener.onExportFinished(this.mJobId, r3, r5, r8);
    }

    @Override // com.android.contacts.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean cancel(boolean r2) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "received cancel request");     // Catch: Throwable -> L17
    L7:
        if (this.mDone == false) goto L9;
    L14:
        monitor-exit(this);
        return false;
    L9:
        if (this.mCanceled == true) goto L14;
        this.mCanceled = true;     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    }

    @Override // com.android.contacts.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r0 = this.mCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.contacts.vcard.ProcessorBase, java.util.concurrent.Future
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
}
