package com.android.contacts.calllog;

import android.content.Intent;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.obric.privacyhook.BaseIntentService;

/* JADX INFO: loaded from: classes.dex */
public class CallLogNotificationsService extends BaseIntentService {
    public static final String ACTION_MARK_NEW_VOICEMAILS_AS_OLD = "com.android.contacts.calllog.ACTION_MARK_NEW_VOICEMAILS_AS_OLD";
    public static final String ACTION_UPDATE_NOTIFICATIONS = "com.android.contacts.calllog.UPDATE_NOTIFICATIONS";
    public static final String EXTRA_NEW_VOICEMAIL_URI = "NEW_VOICEMAIL_URI";
    private static final String TAG = "CallLogNotificationsService";
    private CallLogQueryHandler mCallLogQueryHandler;

    public CallLogNotificationsService() {
        super(TAG);
    }

    @Override // com.obric.privacyhook.BaseIntentService, android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mCallLogQueryHandler = new CallLogQueryHandler(getContentResolver(), null);
    }

    @Override // com.obric.privacyhook.BaseIntentService
    protected void handleAction(String r2, Intent r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (ACTION_MARK_NEW_VOICEMAILS_AS_OLD.equals(r3.getAction()) == false) goto L8;
        this.mCallLogQueryHandler.markNewVoicemailsAsOld();
        return;
    L8:
        if (ACTION_UPDATE_NOTIFICATIONS.equals(r3.getAction()) == false) goto L11;
        DefaultVoicemailNotifier.getInstance(this).updateNotification((Uri) r3.getParcelableExtra(EXTRA_NEW_VOICEMAIL_URI));
        return;
    L11:
        if (ContactsUtils.DEBUG == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onHandleIntent: could not handle: " + r3);
        return;
    }
}
