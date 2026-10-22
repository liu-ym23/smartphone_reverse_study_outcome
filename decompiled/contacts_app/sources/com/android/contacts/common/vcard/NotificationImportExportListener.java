package com.android.contacts.common.vcard;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.android.contacts.common.R;
import com.android.vcard.VCardEntry;
import com.obric.capabilitykit.common.Ext;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes.dex */
public class NotificationImportExportListener implements VCardImportExportListener, Handler.Callback {
    static final String DEFAULT_NOTIFICATION_TAG = "VCardServiceProgress";
    static final String FAILURE_NOTIFICATION_TAG = "VCardServiceFailure";
    private final Activity mContext;
    private final Handler mHandler;
    private final NotificationManager mNotificationManager;

    public NotificationImportExportListener(Activity r2) {
        this.mContext = r2;
        this.mNotificationManager = (NotificationManager) r2.getSystemService("notification");
        this.mHandler = new Handler(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        String r3 = (String) r2.obj;
        Toast.makeText(this.mContext, r3, 1).show();
        return true;
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportProcessed(ImportRequest r11, int r12, int r13) {
        if (r11.displayName == null) goto L5;
        String r14 = r11.displayName;
        String r0 = this.mContext.getString(R.string.vcard_import_will_start_message, new Object[]{r14});
    L6:
        String r7 = r14;
        String r5 = r0;
        if (r13 != 0) goto L9;
        this.mHandler.obtainMessage(0, r5).sendToTarget();
    L9:
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r12, constructProgressNotification(this.mContext, 1, r5, r5, r12, r7, -1, 0));
        return;
    L5:
        r14 = this.mContext.getString(R.string.common_contacts);
        r0 = this.mContext.getString(R.string.vcard_import_will_start_message_with_default_name);
        goto L6
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportParsed(ImportRequest r17, int r18, VCardEntry r19, int r20, int r21) {
        if (r19.isIgnorable() == false) goto L5;
        return;
    L5:
        String r1 = String.valueOf(r21);
        String r11 = this.mContext.getString(R.string.progress_notifier_message, new Object[]{String.valueOf(r20), r1, r19.getDisplayName()});
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r18, constructProgressNotification(this.mContext.getApplicationContext(), 1, this.mContext.getString(R.string.importing_vcard_description, new Object[]{r19.getDisplayName()}), r11, r18, r17.displayName, r21, r20));
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportFinished(ImportRequest r5, int r6, Uri r7) {
        String r8 = this.mContext.getString(R.string.importing_vcard_finished_title, new Object[]{r5.displayName});
        if (r7 == null) goto L5;
        Intent r1 = new Intent("android.intent.action.VIEW", ContactsContract.RawContacts.getContactLookupUri(this.mContext.getContentResolver(), ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, ContentUris.parseId(r7))));
    L6:
        r1.setPackage(this.mContext.getPackageName());
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r6, constructFinishNotification(this.mContext, r8, null, r1));
        return;
    L5:
        r1 = new Intent("android.intent.action.VIEW");
        r1.setType("vnd.android.cursor.dir/contact");
        goto L6
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportFailed(ImportRequest r2) {
        this.mHandler.obtainMessage(0, this.mContext.getString(R.string.vcard_import_request_rejected_message)).sendToTarget();
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportCanceled(ImportRequest r5, int r6) {
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r6, constructCancelNotification(this.mContext, this.mContext.getString(R.string.importing_vcard_canceled_title, new Object[]{r5.displayName})));
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onExportProcessed(ExportRequest r10, int r11) {
        String r6 = ExportVCardActivity.getOpenableUriDisplayName(this.mContext, r10.destUri);
        String r4 = this.mContext.getString(R.string.contacts_export_will_start_message);
        this.mHandler.obtainMessage(0, r4).sendToTarget();
        Notification r12 = constructProgressNotification(this.mContext, 2, r4, r4, r11, r6, -1, 0);
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r11, r12);
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onExportFailed(ExportRequest r2) {
        this.mHandler.obtainMessage(0, this.mContext.getString(R.string.vcard_export_request_rejected_message)).sendToTarget();
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onCancelRequest(CancelRequest r5, int r6) {
        if (r6 != 1) goto L5;
        String r7 = this.mContext.getString(R.string.importing_vcard_canceled_title, new Object[]{r5.displayName});
    L6:
        this.mNotificationManager.notify(DEFAULT_NOTIFICATION_TAG, r5.jobId, constructCancelNotification(this.mContext, r7));
        return;
    L5:
        r7 = this.mContext.getString(R.string.exporting_vcard_canceled_title, new Object[]{r5.displayName});
        goto L6
    }

    static Notification constructProgressNotification(Context r4, int r5, String r6, String r7, int r8, String r9, int r10, int r11) {
        Intent r0 = new Intent(r4, CancelActivity.class);
        r0.setData(new Uri.Builder().scheme("invalidscheme").authority("invalidauthority").appendQueryParameter(Ext.KEY_JOB_ID, String.valueOf(r8)).appendQueryParameter("display_name", r9).appendQueryParameter("type", String.valueOf(r5)).build());
        NotificationCompat.Builder r12 = new NotificationCompat.Builder(r4);
        NotificationCompat.Builder r1 = r12.setOngoing(true);
        if (r10 != (-1)) goto L5;
        boolean r2 = true;
    L6:
        NotificationCompat.Builder r13 = r1.setProgress(r10, r11, r2).setTicker(r7).setContentTitle(r6).setColor(r4.getResources().getColor(R.color.dialtacts_theme_color));
        if (r5 != 1) goto L9;
        int r14 = android.R.drawable.stat_sys_download;
    L10:
        r13.setSmallIcon(r14).setContentIntent(PendingIntent.getActivity(r4, 0, r0, 0));
        if (r10 <= 0) goto L14;
        r12.setContentText(NumberFormat.getPercentInstance().format(((double) r11) / ((double) r10)));
    L14:
        return r12.getNotification();
    L9:
        r14 = android.R.drawable.stat_sys_upload;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    static Notification constructCancelNotification(Context r3, String r4) {
        return new NotificationCompat.Builder(r3).setAutoCancel(true).setSmallIcon(android.R.drawable.stat_notify_error).setColor(r3.getResources().getColor(R.color.dialtacts_theme_color)).setContentTitle(r4).setContentText(r4).setContentIntent(PendingIntent.getActivity(r3, 0, new Intent(r3.getPackageName(), null), 0)).getNotification();
    }

    static Notification constructFinishNotification(Context r1, String r2, String r3, Intent r4) {
        return constructFinishNotificationWithFlags(r1, r2, r3, r4, 0);
    }

    static Notification constructFinishNotificationWithFlags(Context r3, String r4, String r5, Intent r6, int r7) {
        NotificationCompat.Builder r8 = new NotificationCompat.Builder(r3).setAutoCancel(true).setColor(r3.getResources().getColor(R.color.dialtacts_theme_color)).setSmallIcon(android.R.drawable.stat_sys_download_done).setContentTitle(r4).setContentText(r5);
        if (r6 != null) goto L7;
        r6 = new Intent(r3.getPackageName(), null);
    L7:
        return r8.setContentIntent(PendingIntent.getActivity(r3, 0, r6, r7)).getNotification();
    }

    static Notification constructImportFailureNotification(Context r3, String r4) {
        return new NotificationCompat.Builder(r3).setAutoCancel(true).setColor(r3.getResources().getColor(R.color.dialtacts_theme_color)).setSmallIcon(android.R.drawable.stat_notify_error).setContentTitle(r3.getString(R.string.vcard_import_failed)).setContentText(r4).setContentIntent(PendingIntent.getActivity(r3, 0, new Intent(r3.getPackageName(), null), 0)).getNotification();
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onComplete() {
        this.mContext.finish();
    }
}
