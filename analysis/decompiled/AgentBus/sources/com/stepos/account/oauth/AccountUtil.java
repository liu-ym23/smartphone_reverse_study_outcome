package com.stepos.account.oauth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;
import com.stepos.account.oauth.data.AccountInfo;
import java.util.Locale;

/* loaded from: classes.dex */
public class AccountUtil {
    private static final String DEFAULT_SEGMENT = "_";

    public static Account getAccount(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType(OAuthConstants.ACCOUNT_TYPE);
        Log.e("[Cloud]Account.SDK", "getAccount length: " + accountsByType.length);
        if (accountsByType.length <= 0) {
            return null;
        }
        if (accountsByType.length != 1) {
            Log.e("[Cloud]Account.SDK", "more than 1 stepos account : " + accountsByType.length);
        }
        return accountsByType[0];
    }

    public static AccountInfo getAccountInfo(Context context) {
        Account account = getAccount(context);
        if (account == null) {
            return null;
        }
        try {
            AccountManager accountManager = AccountManager.get(context);
            return new AccountInfo(accountManager.getUserData(account, OAuthConstants.KEY_NICKNAME), accountManager.getUserData(account, OAuthConstants.KEY_PHONE), accountManager.getUserData(account, OAuthConstants.KEY_ICON));
        } catch (Exception unused) {
            return new AccountInfo(null, null, null);
        }
    }

    public static String getAccountUid(Context context) {
        if (context == null) {
            return null;
        }
        Account account = getAccount(context);
        return account == null ? "" : account.name;
    }

    public static String getLocalLanguage() {
        return Locale.getDefault().getLanguage() + DEFAULT_SEGMENT + Locale.getDefault().getCountry();
    }

    public static boolean hasAccount(Context context) {
        return (context == null || getAccount(context) == null) ? false : true;
    }
}
