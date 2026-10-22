package com.android.contacts.editor;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.BytedanceAccountType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.obric.account.LocalAccountContactsUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContactEditorUtils {
    private static final List<AccountWithDataSet> EMPTY_ACCOUNTS = null;
    private static final String KEY_ANYTHING_SAVED = "ContactEditorUtils_anything_saved";
    private static final String KEY_DEFAULT_ACCOUNT = "ContactEditorUtils_default_account";
    private static final String KEY_KNOWN_ACCOUNTS = "ContactEditorUtils_known_accounts";
    private static final String TAG = "ContactEditorUtils";
    private static ContactEditorUtils sInstance;
    private final AccountTypeManager mAccountTypes;
    private final Context mContext;
    private final SharedPreferences mPrefs;

    static {
        EMPTY_ACCOUNTS = ImmutableList.of();
    }

    private ContactEditorUtils(Context r2) {
        this(r2, AccountTypeManager.getInstance(r2));
    }

    ContactEditorUtils(Context r1, AccountTypeManager r2) {
        Context r3 = r1.getApplicationContext();
        this.mContext = r3;
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(r3);
        this.mAccountTypes = r2;
    }

    public static synchronized ContactEditorUtils getInstance(Context r2) {
        monitor-enter(ContactEditorUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new ContactEditorUtils(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        ContactEditorUtils r3 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(ContactEditorUtils.class);
        return r3;
    }

    void cleanupForTest() {
        this.mPrefs.edit().remove(KEY_DEFAULT_ACCOUNT).remove(KEY_KNOWN_ACCOUNTS).remove(KEY_ANYTHING_SAVED).apply();
    }

    void removeDefaultAccountForTest() {
        this.mPrefs.edit().remove(KEY_DEFAULT_ACCOUNT).apply();
    }

    private void resetPreferenceValues() {
        this.mPrefs.edit().putString(KEY_KNOWN_ACCOUNTS, "").putString(KEY_DEFAULT_ACCOUNT, "").apply();
    }

    private List<AccountWithDataSet> getWritableAccounts() {
        return this.mAccountTypes.getAccounts(true);
    }

    private boolean isFirstLaunch() {
        return !this.mPrefs.getBoolean(KEY_ANYTHING_SAVED, false);
    }

    public void saveDefaultAndAllAccounts(AccountWithDataSet r7) {
        SharedPreferences.Editor r0 = this.mPrefs.edit().putBoolean(KEY_ANYTHING_SAVED, true);
        if (r7 != null) goto L5;
    L10:
        r0.putString(KEY_KNOWN_ACCOUNTS, "");
        r0.putString(KEY_DEFAULT_ACCOUNT, "");
    L11:
        r0.apply();
        return;
    L5:
        if (r7.type.equals("com.android.sim") == true) goto L10;
        if (r7.name.equals(this.mContext.getResources().getString(R.string.local_contact)) == true) goto L11;
        r0.putString(KEY_KNOWN_ACCOUNTS, AccountWithDataSet.stringifyList(getWritableAccounts()));
        r0.putString(KEY_DEFAULT_ACCOUNT, r7.stringify());
        goto L11
    }

    public AccountWithDataSet getDefaultAccount() {
        String r0 = this.mPrefs.getString(KEY_DEFAULT_ACCOUNT, null);
        if (TextUtils.isEmpty(r0) == false) goto L12;
        return null;
    L12:
        AccountWithDataSet r1 = AccountWithDataSet.unstringify(r0);     // Catch: IllegalArgumentException -> L9
        if (isValidAccount(r1) == false) goto L8;
        return r1;
    L8:
        return null;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error with retrieving default account " + e.toString());
        resetPreferenceValues();
        return null;
    }

    public boolean isValidAccount(AccountWithDataSet r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (LocalAccountContactsUtils.isLocalAccount(r3) == false) goto L9;
        return true;
    L9:
        return getWritableAccounts().contains(r3);
    }

    List<AccountWithDataSet> getSavedAccounts() {
        String r0 = this.mPrefs.getString(KEY_KNOWN_ACCOUNTS, null);
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return AccountWithDataSet.unstringifyList(r0);
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error with retrieving saved accounts " + e.toString());
        resetPreferenceValues();
        return EMPTY_ACCOUNTS;
    L5:
        return EMPTY_ACCOUNTS;
    }

    public boolean shouldShowAccountChangedNotification() {
        if (isFirstLaunch() == false) goto L5;
        return true;
    L5:
        List<AccountWithDataSet> r0 = getSavedAccounts();
        List<AccountWithDataSet> r2 = getWritableAccounts();
        Iterator<AccountWithDataSet> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        if (r0.contains(r3.next()) == true) goto L7;
        return true;
    L11:
        AccountWithDataSet r1 = getDefaultAccount();
        if (isValidAccount(r1) == true) goto L14;
        return true;
    L14:
        if (r1 == null) goto L16;
        return false;
    L16:
        if (r2.size() <= 0) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Preferences file in an inconsistent state, request that the default account and current writable accounts be saved again");
        return true;
    L24:
        return false;
    }

    public static boolean hasLoginBytedanceAccount(Context r1) {
        if (AccountManager.get(r1).getAccountsByType(BytedanceAccountType.ACCOUNT_TYPE).length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    String[] getWritableAccountTypeStrings(ArrayList<String> r4) {
        HashSet r0 = Sets.newHashSet();
        Iterator<AccountType> r3 = this.mAccountTypes.getAccountTypes(true).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        AccountType r1 = r3.next();
        if (r4 == null) goto L10;
        if (r4.contains(r1.accountType) == true) goto L4;
    L10:
        r0.add(r1.accountType);
        goto L4
    L11:
        r0.add("com.google");
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    public Intent createAddWritableAccountIntent(ArrayList<String> r9) {
        return AccountManager.newChooseAccountIntent(null, new ArrayList(), getWritableAccountTypeStrings(r9), false, null, null, null, null);
    }

    public AccountWithDataSet getCreatedAccount(int r2, Intent r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r4 = r3.getStringExtra(ContactSaveService.EXTRA_ACCOUNT_TYPE);
        String r5 = r3.getStringExtra("authAccount");
        if (TextUtils.isEmpty(r4) == false) goto L8;
    L12:
        return null;
    L8:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        return new AccountWithDataSet(r5, r4, null);
    }
}
