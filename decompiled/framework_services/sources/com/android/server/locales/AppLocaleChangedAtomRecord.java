package com.android.server.locales;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLocaleChangedAtomRecord {
    private static final String DEFAULT_PREFIX = "default-";
    int mCaller;
    final int mCallingUid;
    String mNewLocales;
    String mPrevLocales;
    int mStatus;
    int mTargetUid;

    AppLocaleChangedAtomRecord(int callingUid) {
        this.mTargetUid = -1;
        this.mNewLocales = DEFAULT_PREFIX;
        this.mPrevLocales = DEFAULT_PREFIX;
        this.mStatus = 0;
        this.mCaller = 0;
        this.mCallingUid = callingUid;
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale == null) goto L6;
        this.mNewLocales = DEFAULT_PREFIX + defaultLocale.toLanguageTag();
        this.mPrevLocales = DEFAULT_PREFIX + defaultLocale.toLanguageTag();
        return;
    }

    void setNewLocales(String newLocales) {
        this.mNewLocales = convertEmptyLocales(newLocales);
    }

    void setTargetUid(int targetUid) {
        this.mTargetUid = targetUid;
    }

    void setPrevLocales(String prevLocales) {
        this.mPrevLocales = convertEmptyLocales(prevLocales);
    }

    void setStatus(int status) {
        this.mStatus = status;
    }

    void setCaller(int caller) {
        this.mCaller = caller;
    }

    private String convertEmptyLocales(String locales) {
        if ("".equals(locales) == false) goto L8;
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale == null) goto L9;
        String target = DEFAULT_PREFIX + defaultLocale.toLanguageTag();
        return target;
    L9:
        return locales;
    L8:
        return locales;
    }
}
