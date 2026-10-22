package com.android.contacts.list;

import android.content.Context;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.preference.ContactsPreferences;
import com.android.contacts.util.HanziToPinyin;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class SurnameMatcher {
    private static volatile SurnameMatcher sSurnameMatcher;
    private ContactsPreferences mContactsPrefs;
    protected int mDisplayOrder;
    protected int mSortOrder;

    static /* synthetic */ void access$000(SurnameMatcher r0) {
        r0.loadPreferences();
    }

    private SurnameMatcher(Context r2) {
        this.mDisplayOrder = -1;
        this.mSortOrder = -1;
        this.mContactsPrefs = new ContactsPreferences(r2);
        loadPreferences();
        this.mContactsPrefs.registerChangeListener(new AnonymousClass1(this));
    }

    public static SurnameMatcher getInstance() {
        if (sSurnameMatcher != null) goto L15;
        monitor-enter(SurnameMatcher.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sSurnameMatcher != null) goto L9;
        sSurnameMatcher = new SurnameMatcher(ContactsApplication.getInstance());     // Catch: Throwable -> L11
    L9:
        monitor-exit(SurnameMatcher.class);     // Catch: Throwable -> L11
    L15:
        return sSurnameMatcher;
    }

    private void loadPreferences() {
        this.mDisplayOrder = this.mContactsPrefs.getDisplayOrder();
        this.mSortOrder = this.mContactsPrefs.getSortOrder();
    }

    public int getDisplayOrder() {
        return this.mDisplayOrder;
    }

    public int getSortOrder() {
        return this.mSortOrder;
    }

    public boolean match(String r4, String r5, String r6, String r7) {
        boolean r0 = false;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        String r3 = Locale.getDefault().getLanguage();
        if (Locale.ENGLISH.getLanguage().equals(r3) == true) goto L28;
        if ("ru".equals(r3) == true) goto L28;
        if (Locale.KOREA.getLanguage().equals(r3) == false) goto L14;
        return r4.equals(r7);
    L14:
        if (Locale.JAPAN.getLanguage().equals(r3) == false) goto L22;
        String[] r8 = LetterMatcher.getInstance().getJapaneseMophonys(r4);
        if (TextUtils.isEmpty(r6) == true) goto L33;
        if (r6.length() < 1) goto L33;
        if (r8 == null) goto L33;
        r0 = Arrays.asList(r8).contains(String.valueOf(r6.charAt(0)));
    L33:
        return r0;
    L22:
        String r9 = String.valueOf(r5.charAt(0));
        if (r4.equals(r7) == false) goto L33;
        if (ContactsUtils.isChinese(r9) == false) goto L33;
    L31:
        r0 = true;
    L28:
        if (r4.equals(r7) == false) goto L33;
        if (ContactsUtils.isChinese(r5) == true) goto L33;
        goto L31
    }

    public String getSurname(String r6) {
        String r0 = Locale.getDefault().getLanguage();
        if (Locale.ENGLISH.getLanguage().equals(r0) == false) goto L5;
    L11:
        String[] r7 = r6.split(HanziToPinyin.Token.SEPARATOR);
        if (r7.length < 2) goto L28;
        int r1 = this.mSortOrder;
        if (r1 == 2) goto L17;
    L18:
        if (r1 != 1) goto L25;
        if (this.mDisplayOrder != 1) goto L25;
    L21:
        String r5 = r7[0];
        if (r5.endsWith(SimContactsConstants.EMAIL_SEP) == true) goto L30;
        return r5;
    L30:
        return r5.substring(0, r5.length() - 1);
    L25:
        return r7[1];
    L17:
        if (this.mDisplayOrder == 2) goto L21;
    L28:
        return r7[0];
    L5:
        if ("ru".equals(r0) == true) goto L11;
        if (Locale.JAPAN.getLanguage().equals(r0) == false) goto L27;
        return r6.split(HanziToPinyin.Token.SEPARATOR)[0];
    L27:
        return String.valueOf(r6.charAt(0));
    }
}
