package com.android.contacts.widget;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.Selection;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes2.dex */
public class ContactPhoneNumberFormattingTextWatcher extends PhoneNumberFormattingTextWatcher {
    private static int LIMITE_NUMBER_TO_FORMART = 3;
    private boolean mRemoveSpecialChar;
    private boolean mSelfChange;

    static {
    }

    public ContactPhoneNumberFormattingTextWatcher() {
        this.mSelfChange = false;
        this.mRemoveSpecialChar = true;
    }

    public ContactPhoneNumberFormattingTextWatcher(String r1) {
        super(r1);
        this.mSelfChange = false;
        this.mRemoveSpecialChar = true;
    }

    public ContactPhoneNumberFormattingTextWatcher(String r1, boolean r2) {
        this(r1);
        this.mRemoveSpecialChar = r2;
    }

    @Override // android.telephony.PhoneNumberFormattingTextWatcher, android.text.TextWatcher
    public void beforeTextChanged(CharSequence r2, int r3, int r4, int r5) {
        if (this.mSelfChange == false) goto L5;
        return;
    L5:
        if (this.mRemoveSpecialChar == true) goto L10;
        super.beforeTextChanged(r2, r3, r4, r5);
        return;
    }

    @Override // android.telephony.PhoneNumberFormattingTextWatcher, android.text.TextWatcher
    public void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        if (this.mSelfChange == false) goto L5;
        return;
    L5:
        super.onTextChanged(r2, r3, r4, r5);
    }

    @Override // android.telephony.PhoneNumberFormattingTextWatcher, android.text.TextWatcher
    public synchronized void afterTextChanged(Editable r9) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (this.mSelfChange == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        String r0 = r9.toString();     // Catch: Throwable -> L31
        if (this.mRemoveSpecialChar == false) goto L10;
        String r3 = r0.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "");     // Catch: Throwable -> L31
    L12:
        if (r3.length() != 0) goto L14;
    L28:
        super.afterTextChanged(r9);     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L14:
        if (r3.length() > LIMITE_NUMBER_TO_FORMART) goto L28;
        if ((!r0.equals(r3)) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        int r1 = Selection.getSelectionStart(r9);     // Catch: Throwable -> L31
        int r4 = Selection.getSelectionEnd(r9);     // Catch: Throwable -> L31
        int r6 = mapSelectionIndexAfterStrip(r0, r1);     // Catch: Throwable -> L31
        int r7 = mapSelectionIndexAfterStrip(r0, r4);     // Catch: Throwable -> L31
        this.mSelfChange = true;     // Catch: Throwable -> L31
        r9.replace(0, r9.length(), r3, 0, r3.length());     // Catch: Throwable -> L31
        int r2 = r9.length();     // Catch: Throwable -> L31
        if (r6 < 0) goto L25;
        if (r7 < 0) goto L25;
        Selection.setSelection(r9, Math.min(r6, r2), Math.min(r7, r2));     // Catch: Throwable -> L31
    L25:
        this.mSelfChange = false;     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L10:
        r3 = r0;
        goto L12
    }

    private static int mapSelectionIndexAfterStrip(String r4, int r5) {
        if (r5 >= 0) goto L5;
        return -1;
    L5:
        int r6 = Math.min(r5, r4.length());
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r0 >= r6) goto L13;
        char r2 = r4.charAt(r0);
        if (r2 == ' ') goto L12;
        if (r2 == '-') goto L12;
        r1 = r1 + 1;
    L12:
        r0 = r0 + 1;
        goto L6
    L13:
        return r1;
    }
}
