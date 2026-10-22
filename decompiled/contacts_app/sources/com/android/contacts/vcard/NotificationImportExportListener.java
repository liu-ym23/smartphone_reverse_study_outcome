package com.android.contacts.vcard;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.widget.Toast;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.vcard.VCardEntry;
import com.obric.capabilitykit.common.Ext;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationImportExportListener implements VCardImportExportListener, Handler.Callback {
    static final String DEFAULT_NOTIFICATION_TAG = "VCardServiceProgress";
    static final String FAILURE_NOTIFICATION_TAG = "VCardServiceFailure";
    private static final String VCARD_SERVICE_CHANNEL_ID = "vcard_service_channel";
    private final Activity mContext;
    private final Handler mHandler;
    private final NotificationManager mNotificationManager;

    public NotificationImportExportListener(Activity r4) {
        this.mContext = r4;
        NotificationManager r5 = (NotificationManager) r4.getSystemService("notification");
        this.mNotificationManager = r5;
        this.mHandler = new Handler(this);
        r5.createNotificationChannel(new NotificationChannel(VCARD_SERVICE_CHANNEL_ID, "Import Export Service", 3));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        String r3 = (String) r2.obj;
        Toast.makeText(this.mContext, r3, 1).show();
        return true;
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportProcessed(ImportRequest r10, int r11, int r12, int r13) {
        boolean r1 = ImportVCardActivity.isFromMmsIntent(this.mContext.getIntent());
        if (r1 == false) goto L10;
        if (r10.displayName == null) goto L7;
        String r2 = r10.displayName;
    L8:
        String r5 = this.mContext.getString(R.string.vcard_import_will_start_message_from_mms);
    L13:
        String r6 = r2;
        if (r12 != 0) goto L22;
        if (r1 == true) goto L20;
        if (r13 <= 1) goto L20;
        if (r10.displayName == null) goto L20;
        String r0 = this.mContext.getString(R.string.vcards_import_will_start_message, new Object[]{r6});
    L21:
        this.mHandler.obtainMessage(0, r0).sendToTarget();
        String r4 = r0;
    L23:
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r11, constructProgressNotification(this.mContext, 1, r5, r4, r11, r6, -1, 0));
        return;
    L20:
        r0 = r5;
        goto L21
    L22:
        r4 = r5;
        goto L23
    L7:
        r2 = this.mContext.getString(R.string.common_contacts);
        goto L8
    L10:
        if (r10.displayName == null) goto L12;
        r2 = r10.displayName;
        r5 = this.mContext.getString(R.string.vcard_import_will_start_message, new Object[]{r2});
        goto L13
    L12:
        r2 = this.mContext.getString(R.string.common_contacts);
        r5 = this.mContext.getString(R.string.vcard_import_will_start_message_with_default_name);
        goto L13
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportParsed(ImportRequest r10, int r11, VCardEntry r12, int r13, int r14) {
        if (r12.isIgnorable() == false) goto L5;
        return;
    L5:
        Notification r0 = constructProgressNotification(this.mContext.getApplicationContext(), 1, this.mContext.getString(R.string.importing_vcard_description, new Object[]{r12.getDisplayName()}), null, r11, r10.displayName, r14, r13);
        if (ContactsUtils.DEBUG == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("VCardImport", "notify for import " + r13);
    L8:
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r11, r0);
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportFinished(ImportRequest r8, int r9, Uri r10) {
        String r4 = this.mContext.getString(R.string.importing_vcard_finished_title, new Object[]{r8.displayName});
        Intent r6 = new Intent("android.intent.action.VIEW", ContactsContract.Contacts.CONTENT_URI);
        r6.setPackage("com.android.contacts");
        Notification r11 = constructFinishNotification(this.mContext, 1, r4, null, r6);
        this.mNotificationManager.cancel(DEFAULT_NOTIFICATION_TAG, r9);
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r9, r11);
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportFailed(ImportRequest r2) {
        this.mHandler.obtainMessage(0, this.mContext.getString(R.string.vcard_import_request_rejected_message)).sendToTarget();
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportCanceled(ImportRequest r4, int r5) {
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r5, constructCancelNotification(this.mContext, this.mContext.getString(R.string.importing_vcard_canceled_title, new Object[]{r4.displayName})));
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportProcessed(ExportRequest r10, int r11) {
        String r6 = r10.destUri.getLastPathSegment();
        String r4 = this.mContext.getString(R.string.vcard_export_will_start_message, new Object[]{r6});
        this.mHandler.obtainMessage(0, r4).sendToTarget();
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r11, constructProgressNotification(this.mContext, 2, r4, r4, r11, r6, -1, 0));
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportParsed(String r10, String r11, int r12, String r13, int r14, int r15) {
        Notification r16 = constructProgressNotification(this.mContext, 2, r10, r11, r12, r13, r14, r15);
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r12, r16);
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportCanceled(int r2, String r3) {
        Notification r4 = constructCancelNotification(this.mContext, r3);
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r2, r4);
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportFinished(int r7, String r8, String r9, Intent r10) {
        Notification r11 = constructFinishNotification(this.mContext, 2, r8, r9, r10);
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r7, r11);
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportFinished(int r7, String r8, String r9, PendingIntent r10) {
        Notification r11 = constructFinishNotification(this.mContext, 2, r8, r9, r10);
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r7, r11);
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportFailed(ExportRequest r2) {
        this.mHandler.obtainMessage(0, this.mContext.getString(R.string.vcard_export_request_rejected_message)).sendToTarget();
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onCancelRequest(CancelRequest r4, int r5) {
        if (r5 != 1) goto L5;
        String r6 = this.mContext.getString(R.string.importing_vcard_canceled_title, new Object[]{r4.displayName});
    L6:
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r4.jobId, constructCancelNotification(this.mContext, r6));
        return;
    L5:
        r6 = this.mContext.getString(R.string.exporting_vcard_canceled_title, new Object[]{r4.displayName});
        goto L6
    }

    synchronized Notification constructProgressNotification(Context r5, int r6, String r7, String r8, int r9, String r10, int r11, int r12) {
        monitor-enter(this);
        Intent r0 = new Intent(r5, CancelActivity.class);     // Catch: Throwable -> L17
        r0.setData(new Uri.Builder().scheme("invalidscheme").authority("invalidauthority").appendQueryParameter(Ext.KEY_JOB_ID, String.valueOf(r9)).appendQueryParameter("display_name", r10).appendQueryParameter("type", String.valueOf(r6)).build());     // Catch: Throwable -> L17
        Notification.Builder r13 = new Notification.Builder(r5, VCARD_SERVICE_CHANNEL_ID);     // Catch: Throwable -> L17
        Notification.Builder r1 = r13.setOngoing(true).setOnlyAlertOnce(true);     // Catch: Throwable -> L17
        if (r11 != (-1)) goto L6;
        boolean r2 = true;
    L7:
        Notification.Builder r14 = r1.setProgress(r11, r12, r2).setTicker(r8).setContentTitle(r7);     // Catch: Throwable -> L17
        if (r6 != 1) goto L10;
        int r15 = android.R.drawable.stat_sys_download;
    L11:
        r14.setSmallIcon(r15).setContentIntent(PendingIntent.getActivity(r5, 0, r0, 67108864));     // Catch: Throwable -> L17
        if (r11 <= 0) goto L14;
        r13.setContentText(r5.getString(R.string.percentage, new Object[]{String.valueOf((r12 * 100) / r11)}));     // Catch: Throwable -> L17
    L14:
        Notification r16 = r13.getNotification();     // Catch: Throwable -> L17
        monitor-exit(this);
        return r16;
    L10:
        r15 = android.R.drawable.stat_sys_upload;
        goto L11
    L6:
        r2 = false;
    L17:
        th = move-exception;
        throw th;
    }

    static final Notification constructCancelNotification(Context r2, String r3) {
        return new Notification.Builder(r2, VCARD_SERVICE_CHANNEL_ID).setAutoCancel(true).setSmallIcon(android.R.drawable.stat_notify_error).setContentTitle(r3).setContentText(r3).getNotification();
    }

    Notification constructFinishNotification(Context r2, int r3, String r4, String r5, PendingIntent r6) {
        Notification.Builder r1 = new Notification.Builder(r2, VCARD_SERVICE_CHANNEL_ID).setAutoCancel(true);
        if (r3 != 1) goto L5;
        int r7 = android.R.drawable.stat_sys_download_done;
    L7:
        return r1.setSmallIcon(r7).setContentTitle(r4).setContentText(r5).setContentIntent(r6).getNotification();
    L5:
        r7 = android.R.drawable.stat_sys_upload_done;
        goto L7
    }

    Notification constructFinishNotification(Context r3, int r4, String r5, String r6, Intent r7) {
        if (r7 == null) goto L5;
        r7.putExtra("start_from_notification", true);
    L5:
        Notification.Builder r0 = new Notification.Builder(r3, VCARD_SERVICE_CHANNEL_ID).setAutoCancel(true);
        if (r4 != 1) goto L8;
        int r2 = android.R.drawable.stat_sys_download_done;
    L9:
        Notification.Builder r8 = r0.setSmallIcon(r2).setContentTitle(r5).setContentText(r6);
        int r9 = (int) System.currentTimeMillis();
        if (r7 != null) goto L14;
        r7 = new Intent();
    L14:
        return r8.setContentIntent(PendingIntent.getActivity(r3, r9, r7, 67108864)).getNotification();
    L8:
        r2 = android.R.drawable.stat_sys_upload_done;
        goto L9
    }

    static Notification constructImportFailureNotification(Context r2, String r3) {
        return new Notification.Builder(r2, VCARD_SERVICE_CHANNEL_ID).setAutoCancel(true).setSmallIcon(android.R.drawable.stat_notify_error).setContentTitle(r2.getString(R.string.vcard_import_failed)).setContentText(r3).getNotification();
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onComplete() {
        this.mContext.finish();
    }
}
