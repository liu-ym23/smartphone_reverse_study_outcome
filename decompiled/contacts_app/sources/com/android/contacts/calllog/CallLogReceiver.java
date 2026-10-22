package com.android.contacts.calllog;

import android.content.Context;
import android.content.Intent;
import com.GlobalProxyLancet;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsTelephonyUtilImpl;
import com.android.contacts.DSUtils;
import com.android.contacts.dialpad.T9Search;
import com.android.contacts.vcard.SimContactSyncService;
import com.android.internal.telephony.IccCardConstants;
import com.android.internal.telephony.TelephonyIntents;
import com.obric.privacyhook.BaseBroadcastReceiver;

/* JADX INFO: loaded from: classes.dex */
public class CallLogReceiver extends BaseBroadcastReceiver {
    private static final long REQUEST_BLACKLIST_DELAY = 200;
    private static final String TAG = "CallLogReceiver";

    public CallLogReceiver() {
    }

    @Override // com.obric.privacyhook.BaseBroadcastReceiver
    public void onReceiveAction(Context r7, Intent r8) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onReceiver: " + r8.getAction());
        if ("android.intent.action.NEW_VOICEMAIL".equals(r8.getAction()) == false) goto L6;
        Intent r6 = new Intent(r7, CallLogNotificationsService.class);
        r6.setAction(CallLogNotificationsService.ACTION_UPDATE_NOTIFICATIONS);
        r6.putExtra(CallLogNotificationsService.EXTRA_NEW_VOICEMAIL_URI, r8.getData());
        r7.startService(r6);
        return;
    L6:
        if ("android.intent.action.BOOT_COMPLETED".equals(r8.getAction()) == false) goto L9;
        Intent r9 = new Intent(r7, CallLogNotificationsService.class);
        r9.setAction(CallLogNotificationsService.ACTION_UPDATE_NOTIFICATIONS);
        r7.startService(r9);
        T9Search.getInstance(r7).asyncPreloadContacts();
        return;
    L9:
        if (TelephonyIntents.ACTION_SIM_STATE_CHANGED.equals(r8.getAction()) == false) goto L19;
        String r10 = r8.getStringExtra(IccCardConstants.INTENT_KEY_ICC_STATE);
        if (IccCardConstants.INTENT_VALUE_ICC_LOADED.equals(r10) == false) goto L13;
    L14:
        int r11 = r8.getIntExtra("slot", -1);
        Intent r0 = new Intent(r7, SimContactSyncService.class);
        r0.putExtra(IccCardConstants.INTENT_KEY_ICC_STATE, r8.getStringExtra(IccCardConstants.INTENT_KEY_ICC_STATE));
        r0.putExtra("slot", r11);
        r7.startService(r0);
        if (DSUtils.isMultiSimEnabled() == true) goto L17;
        ContactsApplication.getInstance().initCountryIso();
    L17:
        ContactsTelephonyUtilImpl.onSimChanged(r7);
        return;
    L13:
        if (IccCardConstants.INTENT_VALUE_ICC_ABSENT.equals(r10) == false) goto L17;
    L19:
        if ("com.bytedanceos.backup.DATA_TRANSFER_FINISH".equals(r8.getAction()) == false) goto L22;
        BlacklistManager.getInstances(r7).requestQueryBlackLists(200);
        return;
    L22:
        if ("com.qualcomm.action.ACTION_ADN_INIT_DONE".equals(r8.getAction()) == false) goto L24;
        int r12 = r8.getIntExtra("slot", -1);
        Intent r13 = new Intent(r7, SimContactSyncService.class);
        r13.putExtra(IccCardConstants.INTENT_KEY_ICC_STATE, IccCardConstants.INTENT_VALUE_ICC_LOADED);
        r13.putExtra("slot", r12);
        r7.startService(r13);
        return;
    L24:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "onReceive: could not handle: " + r8);
    }
}
