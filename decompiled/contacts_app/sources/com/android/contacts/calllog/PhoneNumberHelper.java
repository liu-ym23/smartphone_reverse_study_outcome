package com.android.contacts.calllog;

import android.content.res.Resources;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.Constants;

/* JADX INFO: loaded from: classes.dex */
public class PhoneNumberHelper {
    private final Resources mResources;

    public static boolean canPlaceCallsTo(int r1) {
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public PhoneNumberHelper(Resources r1) {
        this.mResources = r1;
        ContactsUtils.fatchVoiceMailNumber();
    }

    public boolean canSendSmsTo(CharSequence r1, int r2) {
        if (canPlaceCallsTo(r2) == true) goto L5;
    L9:
        return false;
    L5:
        if (isVoicemailNumber(r1) == true) goto L9;
        if (isSipNumber(r1) == true) goto L9;
        return true;
    }

    public CharSequence getDisplayNumber(CharSequence r2, CharSequence r3, int r4) {
        return getDisplayNumber(r2, r3, r4, false);
    }

    public CharSequence getDisplayNumber(CharSequence r3, CharSequence r4, int r5, boolean r6) {
        if (r5 != 1) goto L5;
        if (r3 != null) goto L16;
        return "";
    L16:
        if (r6 == false) goto L21;
        if (ContactsUtils.compareWithVoiceNumber(r3.toString()) == true) goto L34;
    L24:
        if (TextUtils.isEmpty(r4) == false) goto L29;
        if (TextUtils.isEmpty(r3) == true) goto L35;
        ContactsApplication.getInstance();
        return ContactsUtils.formatNumber(r3.toString());
    L35:
        return r3;
    L29:
        return r4;
    L34:
        return this.mResources.getString(R.string.common_voice_mail);
    L21:
        if (isVoicemailNumber(r3) == false) goto L24;
    L5:
        if (r5 == 2) goto L33;
        if (r5 == 3) goto L32;
        if (r5 == 4) goto L31;
        return "";
    L31:
        return this.mResources.getString(R.string.payphone);
    L32:
        return this.mResources.getString(R.string.unknown);
    L33:
        return this.mResources.getString(R.string.private_num);
    }

    public Uri getCallUri(String r2) {
        if (isVoicemailNumber(r2) == false) goto L7;
        return Uri.parse("voicemail:x");
    L7:
        if (isSipNumber(r2) == false) goto L11;
        return Uri.fromParts(Constants.SCHEME_SIP, r2, null);
    L11:
        return Uri.fromParts(Constants.SCHEME_TEL, r2, null);
    }

    public boolean isVoicemailNumber(CharSequence r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return PhoneNumberUtils.isVoiceMailNumber(r1.toString());
    }

    public boolean isSipNumber(CharSequence r1) {
        return PhoneNumberUtils.isUriNumber(r1.toString());
    }
}
