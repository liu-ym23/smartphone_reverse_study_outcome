package Z3;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a {
    public static Account a(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.stepos.account");
        Log.e("[Cloud]Account.SDK", "getAccount length: " + accountsByType.length);
        if (accountsByType.length <= 0) {
            return null;
        }
        if (accountsByType.length != 1) {
            Log.e("[Cloud]Account.SDK", "more than 1 stepos account : " + accountsByType.length);
        }
        return accountsByType[0];
    }

    public static String b() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }
}
