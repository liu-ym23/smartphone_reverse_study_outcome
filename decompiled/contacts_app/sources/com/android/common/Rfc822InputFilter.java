package com.android.common;

import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.android.contacts.common.SimContactsConstants;

/* JADX INFO: loaded from: classes.dex */
public class Rfc822InputFilter implements InputFilter {
    public Rfc822InputFilter() {
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
        if ((r4 - r3) == 1) goto L5;
    L25:
        return null;
    L5:
        if (r2.charAt(r3) != ' ') goto L25;
        boolean r8 = false;
    L8:
        if (r6 <= 0) goto L25;
        r6 = r6 - 1;
        char r9 = r5.charAt(r6);
        if (r9 == ',') goto L25;
        if (r9 != '.') goto L14;
        r8 = true;
        goto L8
    L14:
        if (r9 != '@') goto L8;
        if (r8 == true) goto L19;
        return null;
    L19:
        if ((r2 instanceof Spanned) == false) goto L22;
        SpannableStringBuilder r1 = new SpannableStringBuilder(SimContactsConstants.EMAIL_SEP);
        r1.append(r2);
        return r1;
    L22:
        return ", ";
    }
}
