package com.android.contacts.calllog;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDiskIOException;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.CallDetailActivity;
import com.android.contacts.R;
import com.google.common.collect.Maps;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class DefaultVoicemailNotifier implements VoicemailNotifier {
    private static final int NOTIFICATION_ID = 1;
    private static final String NOTIFICATION_TAG = "DefaultVoicemailNotifier";
    public static final String TAG = "DefaultVoicemailNotifier";
    private static DefaultVoicemailNotifier sInstance;
    private final Context mContext;
    private final NameLookupQuery mNameLookupQuery;
    private final NewCallsQuery mNewCallsQuery;
    private final NotificationManager mNotificationManager;
    private final PhoneNumberHelper mPhoneNumberHelper;

    /* JADX INFO: renamed from: com.android.contacts.calllog.DefaultVoicemailNotifier$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class DefaultNameLookupQuery implements NameLookupQuery {
        private static final int DISPLAY_NAME_COLUMN_INDEX = 0;
        private static final String[] PROJECTION = null;
        private final ContentResolver mContentResolver;

        /* synthetic */ DefaultNameLookupQuery(ContentResolver r1, AnonymousClass1 r2) {
            this(r1);
        }

        static {
            PROJECTION = new String[]{"display_name"};
        }

        private DefaultNameLookupQuery(ContentResolver r1) {
            this.mContentResolver = r1;
        }

        @Override // com.android.contacts.calllog.DefaultVoicemailNotifier.NameLookupQuery
        public String query(String r9) {
            Cursor r1 = null;
            if (TextUtils.isEmpty(r9) == false) goto L24;
            return null;
        L24:
            Cursor r8 = this.mContentResolver.query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r9)), PROJECTION, null, null, null);     // Catch: Throwable -> L18
        L16:
            th = th;
            r1 = r8;
        L19:
            if (r1 == null) goto L21;
            r1.close();
        L21:
            throw th;
        L7:
            if (r8.moveToFirst() == true) goto L12;
            if (r8 == null) goto L10;
            r8.close();
        L10:
            return null;
        L12:
            String r10 = r8.getString(0);     // Catch: Throwable -> L16
            if (r8 == null) goto L15;
            r8.close();
        L15:
            return r10;
        L18:
            th = th;
            goto L19
        }
    }

    private static final class DefaultNewCallsQuery implements NewCallsQuery {
        private static final int ID_COLUMN_INDEX = 0;
        private static final int NUMBER_COLUMN_INDEX = 1;
        private static final String[] PROJECTION = null;
        private static final int VOICEMAIL_URI_COLUMN_INDEX = 2;
        private final ContentResolver mContentResolver;

        /* synthetic */ DefaultNewCallsQuery(ContentResolver r1, AnonymousClass1 r2) {
            this(r1);
        }

        static {
            PROJECTION = new String[]{"_id", "number", "voicemail_uri"};
        }

        private DefaultNewCallsQuery(ContentResolver r1) {
            this.mContentResolver = r1;
        }

        @Override // com.android.contacts.calllog.DefaultVoicemailNotifier.NewCallsQuery
        public NewCall[] query() {
            Cursor r0 = this.mContentResolver.query(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, PROJECTION, String.format("%s = 1 AND %s = ?", new Object[]{"new", "type"}), new String[]{Integer.toString(4)}, "date DESC");     // Catch: Throwable -> L15 SQLiteDiskIOException -> L17
            if (r0 != null) goto L8;
            NewCall[] r10 = new NewCall[0];     // Catch: Throwable -> L15 SQLiteDiskIOException -> L17
            MoreCloseables.closeQuietly(r0);
            return r10;
        L8:
            NewCall[] r1 = new NewCall[r0.getCount()];     // Catch: Throwable -> L15 SQLiteDiskIOException -> L17
        L10:
            if (r0.moveToNext() == false) goto L13;
            r1[r0.getPosition()] = createNewCallsFromCursor(r0);     // Catch: Throwable -> L15 SQLiteDiskIOException -> L17
            goto L10
        L13:
            MoreCloseables.closeQuietly(r0);
            return r1;
        L17:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L15
            NewCall[] r11 = new NewCall[0];     // Catch: Throwable -> L15
            MoreCloseables.closeQuietly(null);
            return r11;
        L15:
            th = move-exception;
            MoreCloseables.closeQuietly(null);
            throw th;
        }

        private NewCall createNewCallsFromCursor(Cursor r4) {
            String r3 = r4.getString(2);
            Uri r0 = ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, r4.getLong(0));
            if (r3 != null) goto L5;
            Uri r5 = null;
        L7:
            return new NewCall(r0, r5, r4.getString(1));
        L5:
            r5 = Uri.parse(r3);
            goto L7
        }
    }

    public interface NameLookupQuery {
        String query(String r1);
    }

    private static final class NewCall {
        public final Uri callsUri;
        public final String number;
        public final Uri voicemailUri;

        public NewCall(Uri r1, Uri r2, String r3) {
            this.callsUri = r1;
            this.voicemailUri = r2;
            this.number = r3;
        }
    }

    public interface NewCallsQuery {
        NewCall[] query();
    }

    public static synchronized DefaultVoicemailNotifier getInstance(Context r8) {
        monitor-enter(DefaultVoicemailNotifier.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        Context r3 = r8.getApplicationContext();     // Catch: Throwable -> L10
        NotificationManager r4 = (NotificationManager) r3.getSystemService("notification");     // Catch: Throwable -> L10
        ContentResolver r9 = r3.getContentResolver();     // Catch: Throwable -> L10
        sInstance = new DefaultVoicemailNotifier(r3, r4, createNewCallsQuery(r9), createNameLookupQuery(r9), createPhoneNumberHelper(r3));     // Catch: Throwable -> L10
    L7:
        DefaultVoicemailNotifier r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(DefaultVoicemailNotifier.class);
        return r10;
    }

    private DefaultVoicemailNotifier(Context r1, NotificationManager r2, NewCallsQuery r3, NameLookupQuery r4, PhoneNumberHelper r5) {
        this.mContext = r1;
        this.mNotificationManager = r2;
        this.mNewCallsQuery = r3;
        this.mNameLookupQuery = r4;
        this.mPhoneNumberHelper = r5;
    }

    @Override // com.android.contacts.calllog.VoicemailNotifier
    public void updateNotification(Uri r15) {
        NewCall[] r0 = this.mNewCallsQuery.query();
        if (r0.length != 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("DefaultVoicemailNotifier", "No voicemails to notify about: clear the notification.");
        clearNotification();
        return;
    L6:
        Resources r1 = this.mContext.getResources();
        HashMap r3 = Maps.newHashMap();
        int r4 = r0.length;
        NewCall r5 = null;
        String r7 = null;
        int r8 = 0;
    L8:
        if (r8 >= r4) goto L25;
        NewCall r10 = r0[r8];
        if (((String) r3.get(r10.number)) != null) goto L20;
        String r11 = this.mNameLookupQuery.query(r10.number);
        if (r11 != null) goto L16;
        r11 = this.mPhoneNumberHelper.getDisplayNumber(r10.number, "", 1).toString();
        if (TextUtils.isEmpty(r11) == false) goto L16;
        r11 = r10.number;
    L16:
        r3.put(r10.number, r11);
        if (TextUtils.isEmpty(r7) == false) goto L19;
        r7 = r11;
        goto L20
    L19:
        r7 = r1.getString(R.string.notification_voicemail_callers_list, new Object[]{r7, r11});
    L20:
        if (r15 == null) goto L24;
        if (r15.equals(r10.voicemailUri) == false) goto L24;
        r5 = r10;
    L24:
        r8 = r8 + 1;
        goto L8
    L25:
        if (r15 == null) goto L28;
        if (r5 != null) goto L28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("DefaultVoicemailNotifier", "The new call could not be found in the call log: " + r15);
    L28:
        Notification.Builder r16 = new Notification.Builder(this.mContext).setSmallIcon(android.R.drawable.stat_notify_voicemail).setContentTitle(r1.getQuantityString(R.plurals.notification_voicemail_title, r0.length, new Object[]{Integer.valueOf(r0.length)})).setContentText(r7);
        if (r5 == null) goto L31;
        int r6 = -1;
    L32:
        Notification r17 = r16.setDefaults(r6).setDeleteIntent(createMarkNewVoicemailsAsOldIntent()).setAutoCancel(true).getNotification();
        if (r0.length != 1) goto L35;
        Intent r9 = new Intent(this.mContext, CallDetailActivity.class);
        r9.setData(r0[0].callsUri);
        r9.putExtra(CallDetailActivity.EXTRA_VOICEMAIL_URI, r0[0].voicemailUri);
    L36:
        r17.contentIntent = PendingIntent.getActivity(this.mContext, 0, r9, 0);
        if (r5 == null) goto L39;
        r17.tickerText = r1.getString(R.string.notification_new_voicemail_ticker, new Object[]{r3.get(r5.number)});
    L39:
        this.mNotificationManager.notify("DefaultVoicemailNotifier", 1, r17);
        return;
    L35:
        r9 = new Intent("android.intent.action.VIEW", CallLog.Calls.CONTENT_URI);
        goto L36
    L31:
        r6 = 0;
        goto L32
    }

    private PendingIntent createMarkNewVoicemailsAsOldIntent() {
        Intent r0 = new Intent(this.mContext, CallLogNotificationsService.class);
        r0.setAction(CallLogNotificationsService.ACTION_MARK_NEW_VOICEMAILS_AS_OLD);
        return PendingIntent.getService(this.mContext, 0, r0, 0);
    }

    @Override // com.android.contacts.calllog.VoicemailNotifier
    public void clearNotification() {
        this.mNotificationManager.cancel("DefaultVoicemailNotifier", 1);
    }

    public static NewCallsQuery createNewCallsQuery(ContentResolver r2) {
        return new DefaultNewCallsQuery(r2, null);
    }

    public static NameLookupQuery createNameLookupQuery(ContentResolver r2) {
        return new DefaultNameLookupQuery(r2, null);
    }

    public static PhoneNumberHelper createPhoneNumberHelper(Context r1) {
        return new PhoneNumberHelper(r1.getResources());
    }
}
