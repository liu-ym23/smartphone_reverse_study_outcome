package com.android.contacts.common.compat.telecom;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.compat.CompatUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TelecomManagerCompat {
    public static final String TELECOM_MANAGER_CLASS = "android.telecom.TelecomManager";

    public TelecomManagerCompat() {
    }

    public static void placeCall(Activity r1, TelecomManager r2, Intent r3) {
        if (r1 == null) goto L12;
        if (r2 == null) goto L13;
        if (r3 != null) goto L7;
        return;
    L7:
        if (CompatUtils.isMarshmallowCompatible() == false) goto L10;
        r2.placeCall(r3.getData(), r3.getExtras());
        return;
    L10:
        r1.startActivityForResult(r3, 0);
        return;
    L13:
        return;
    }

    public static Uri getAdnUriForPhoneAccount(TelecomManager r3, PhoneAccountHandle r4) {
        if (r3 == null) goto L10;
        if (CompatUtils.isMarshmallowCompatible() == true) goto L8;
        if (CompatUtils.isMethodAvailable(TELECOM_MANAGER_CLASS, "getAdnUriForPhoneAccount", new Class[]{PhoneAccountHandle.class}) == false) goto L10;
    L8:
        return r3.getAdnUriForPhoneAccount(r4);
    L10:
        return Uri.parse(SimContactsConstants.SIM_URI);
    }

    public static List<PhoneAccountHandle> getCallCapablePhoneAccounts(TelecomManager r3) {
        if (r3 == null) goto L10;
        if (CompatUtils.isMarshmallowCompatible() == true) goto L8;
        if (CompatUtils.isMethodAvailable(TELECOM_MANAGER_CLASS, "getCallCapablePhoneAccounts", new Class[0]) == false) goto L10;
    L8:
        return r3.getCallCapablePhoneAccounts();
    L10:
        return new ArrayList();
    }

    public static String getDefaultDialerPackage(TelecomManager r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (CompatUtils.isDefaultDialerCompatible() == true) goto L6;
        return null;
    L6:
        return r1.getDefaultDialerPackage();
    }

    public static PhoneAccountHandle getDefaultOutgoingPhoneAccount(TelecomManager r3, String r4) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (CompatUtils.isMarshmallowCompatible() == true) goto L8;
        if (CompatUtils.isMethodAvailable(TELECOM_MANAGER_CLASS, "getDefaultOutgoingPhoneAccount", new Class[]{String.class}) == true) goto L8;
        return null;
    L8:
        return r3.getDefaultOutgoingPhoneAccount(r4);
    }

    public static String getLine1Number(TelecomManager r1, TelephonyManager r2, PhoneAccountHandle r3) {
        if (r1 != null) goto L4;
    L7:
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.getLine1Number();
    L4:
        if (CompatUtils.isMarshmallowCompatible() == false) goto L7;
        return r1.getLine1Number(r3);
    }

    public static boolean isVoiceMailNumber(TelecomManager r3, PhoneAccountHandle r4, String r5) {
        if (r3 == null) goto L10;
        if (CompatUtils.isMarshmallowCompatible() == true) goto L8;
        if (CompatUtils.isMethodAvailable(TELECOM_MANAGER_CLASS, "isVoiceMailNumber", new Class[]{PhoneAccountHandle.class, String.class}) == false) goto L10;
    L8:
        return r3.isVoiceMailNumber(r4, r5);
    L10:
        return PhoneNumberUtils.isVoiceMailNumber(r5);
    }

    public static PhoneAccount getPhoneAccount(TelecomManager r3, PhoneAccountHandle r4) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (CompatUtils.isMethodAvailable(TELECOM_MANAGER_CLASS, "getPhoneAccount", new Class[]{PhoneAccountHandle.class}) == true) goto L6;
        return null;
    L6:
        return r3.getPhoneAccount(r4);
    }

    public static String getVoiceMailNumber(TelecomManager r3, TelephonyManager r4, PhoneAccountHandle r5) {
        if (r3 != null) goto L4;
    L7:
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.getVoiceMailNumber();
    L4:
        if (CompatUtils.isMethodAvailable(TELECOM_MANAGER_CLASS, "getVoiceMailNumber", new Class[]{PhoneAccountHandle.class}) == false) goto L7;
        return r3.getVoiceMailNumber(r5);
    }

    public static boolean handleMmi(TelecomManager r5, String r6, PhoneAccountHandle r7) {
        if (r5 != null) goto L5;
    L18:
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        if (r7 == null) goto L17;
        if (CompatUtils.isMarshmallowCompatible() == true) goto L11;
        Object r8 = CompatUtils.invokeMethod(r5, "handleMmi", new Class[]{PhoneAccountHandle.class, String.class}, new Object[]{r7, r6});
        if (r8 == null) goto L17;
        return ((Boolean) r8).booleanValue();
    L11:
        return r5.handleMmi(r6, r7);
    L17:
        return r5.handleMmi(r6);
    }

    public static void silenceRinger(TelecomManager r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (CompatUtils.isMarshmallowCompatible() == false) goto L6;
    L7:
        r3.silenceRinger();
        return;
    L6:
        if (CompatUtils.isMethodAvailable(TELECOM_MANAGER_CLASS, "silenceRinger", new Class[0]) == true) goto L7;
    }

    public static PhoneAccountHandle getSimCallManager(TelecomManager r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (CompatUtils.isMarshmallowCompatible() == true) goto L8;
        if (CompatUtils.isMethodAvailable(TELECOM_MANAGER_CLASS, "getSimCallManager", new Class[0]) == true) goto L8;
        return null;
    L8:
        return r3.getSimCallManager();
    }
}
