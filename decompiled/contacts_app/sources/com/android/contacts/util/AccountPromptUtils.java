package com.android.contacts.util;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorDescription;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class AccountPromptUtils {
    private static final String KEY_ALLOW_SKIP_ACCOUNT_SETUP = "allowSkip";
    private static final String KEY_INTRO_MESSAGE = "introMessage";
    private static final String KEY_SHOW_ACCOUNT_PROMPT = "settings.showAccountPrompt";
    private static final String KEY_USER_SKIPPED_ACCOUNT_SETUP = "setupSkipped";
    private static final String TAG = "AccountPromptUtils";

    static {
    }

    public AccountPromptUtils() {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    private static SharedPreferences getSharedPreferences(Context r0) {
        return PreferenceManager.getDefaultSharedPreferences(r0);
    }

    public static boolean shouldShowAccountPrompt(Context r6) {
        AuthenticatorDescription[] r0 = AccountManager.get(r6).getAuthenticatorTypes();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if ("com.google".equals(r0[r3].type) == true) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        return getSharedPreferences(r6).getBoolean(KEY_SHOW_ACCOUNT_PROMPT, true);
    L9:
        return false;
    }

    public static void neverShowAccountPromptAgain(Context r2) {
        getSharedPreferences(r2).edit().putBoolean(KEY_SHOW_ACCOUNT_PROMPT, false).apply();
    }

    public static void launchAccountPrompt(Activity r8) {
        Bundle r4 = new Bundle();
        r4.putCharSequence(KEY_INTRO_MESSAGE, r8.getString(R.string.no_account_prompt));
        r4.putBoolean(KEY_ALLOW_SKIP_ACCOUNT_SETUP, true);
        AccountManager.get(r8).addAccount("com.google", null, null, r4, r8, getAccountManagerCallback(r8), null);
    }

    private static AccountManagerCallback<Bundle> getAccountManagerCallback(final Activity r1) {
        return new AnonymousClass1(r1);
    }
}
