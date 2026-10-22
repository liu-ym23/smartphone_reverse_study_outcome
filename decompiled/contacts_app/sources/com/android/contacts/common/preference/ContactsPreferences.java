package com.android.contacts.common.preference;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.contacts.common.R;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountWithDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContactsPreferences implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String CONTACT_METADATA_AUTHORITY = "com.android.contacts.metadata";
    public static final int DISPLAY_ORDER_ALTERNATIVE = 2;
    public static final String DISPLAY_ORDER_KEY = "android.contacts.DISPLAY_ORDER";
    public static final int DISPLAY_ORDER_PRIMARY = 1;
    public static final String DO_NOT_SYNC_CONTACT_METADATA_MSG = "Do not sync metadata";
    public static final String ONLY_CLEAR_DONOT_SYNC = "only_clear_donot_sync";
    private static final int PREFERENCE_UNASSIGNED = -1;
    public static final String PREF_DISPLAY_ONLY_PHONES = "only_phones";
    public static final boolean PREF_DISPLAY_ONLY_PHONES_DEFAULT = false;
    public static final String SHOULD_CLEAR_METADATA_BEFORE_SYNCING = "should_clear_metadata_before_syncing";
    public static final int SORT_ORDER_ALTERNATIVE = 2;
    public static final String SORT_ORDER_KEY = "android.contacts.SORT_ORDER";
    public static final int SORT_ORDER_PRIMARY = 1;
    private final Context mContext;
    private String mDefaultAccount;
    private String mDefaultAccountKey;
    private String mDefaultAccountSavedKey;
    private int mDisplayOrder;
    private Handler mHandler;
    private ChangeListener mListener;
    private final SharedPreferences mPreferences;
    private int mSortOrder;

    public interface ChangeListener {
        void onChange();
    }

    public ContactsPreferences(Context r3) {
        this.mSortOrder = -1;
        this.mDisplayOrder = -1;
        this.mDefaultAccount = null;
        this.mListener = null;
        this.mContext = r3;
        this.mHandler = new Handler();
        this.mPreferences = r3.getSharedPreferences(r3.getPackageName(), 0);
        this.mDefaultAccountKey = r3.getResources().getString(R.string.contact_editor_default_account_key);
        this.mDefaultAccountSavedKey = r3.getResources().getString(R.string.contact_editor_anything_saved_key);
        maybeMigrateSystemSettings();
    }

    public boolean isSortOrderUserChangeable() {
        return this.mContext.getResources().getBoolean(R.bool.config_sort_order_user_changeable);
    }

    public int getDefaultSortOrder() {
        if (this.mContext.getResources().getBoolean(R.bool.config_default_sort_order_primary) == false) goto L6;
        return 1;
    L6:
        return 2;
    }

    public int getSortOrder() {
        if (isSortOrderUserChangeable() == true) goto L7;
        return getDefaultSortOrder();
    L7:
        if (this.mSortOrder != (-1)) goto L10;
        this.mSortOrder = this.mPreferences.getInt("android.contacts.SORT_ORDER", getDefaultSortOrder());
    L10:
        return this.mSortOrder;
    }

    public void setSortOrder(int r2) {
        this.mSortOrder = r2;
        SharedPreferences.Editor r1 = this.mPreferences.edit();
        r1.putInt("android.contacts.SORT_ORDER", r2);
        r1.commit();
    }

    public boolean isDisplayOrderUserChangeable() {
        return this.mContext.getResources().getBoolean(R.bool.config_display_order_user_changeable);
    }

    public int getDefaultDisplayOrder() {
        if (this.mContext.getResources().getBoolean(R.bool.config_default_display_order_primary) == false) goto L6;
        return 1;
    L6:
        return 2;
    }

    public int getDisplayOrder() {
        if (isDisplayOrderUserChangeable() == true) goto L7;
        return getDefaultDisplayOrder();
    L7:
        if (this.mDisplayOrder != (-1)) goto L10;
        this.mDisplayOrder = this.mPreferences.getInt("android.contacts.DISPLAY_ORDER", getDefaultDisplayOrder());
    L10:
        return this.mDisplayOrder;
    }

    public void setDisplayOrder(int r2) {
        this.mDisplayOrder = r2;
        SharedPreferences.Editor r1 = this.mPreferences.edit();
        r1.putInt("android.contacts.DISPLAY_ORDER", r2);
        r1.commit();
    }

    public boolean isDefaultAccountUserChangeable() {
        return this.mContext.getResources().getBoolean(R.bool.config_default_account_user_changeable);
    }

    public String getDefaultAccount() {
        if (isDefaultAccountUserChangeable() == true) goto L7;
        return this.mDefaultAccount;
    L7:
        if (TextUtils.isEmpty(this.mDefaultAccount) == false) goto L12;
        String r0 = this.mPreferences.getString(this.mDefaultAccountKey, this.mDefaultAccount);
        if (TextUtils.isEmpty(r0) == true) goto L12;
        this.mDefaultAccount = AccountWithDataSet.unstringify(r0).name;
    L12:
        return this.mDefaultAccount;
    }

    public void setDefaultAccount(AccountWithDataSet r3) {
        if (r3 != null) goto L4;
        String r0 = null;
    L5:
        this.mDefaultAccount = r0;
        SharedPreferences.Editor r1 = this.mPreferences.edit();
        if (TextUtils.isEmpty(this.mDefaultAccount) == false) goto L8;
        r1.remove(this.mDefaultAccountKey);
    L9:
        r1.putBoolean(this.mDefaultAccountSavedKey, true);
        r1.commit();
        return;
    L8:
        r1.putString(this.mDefaultAccountKey, r3.stringify());
        goto L9
    L4:
        r0 = r3.name;
        goto L5
    }

    public String getContactMetadataSyncAccountName() {
        Account r0 = getContactMetadataSyncAccount();
        if (r0 != null) goto L6;
        return DO_NOT_SYNC_CONTACT_METADATA_MSG;
    L6:
        return r0.name;
    }

    public void setContactMetadataSyncAccount(AccountWithDataSet r1) {
        if (r1 != null) goto L4;
        String r2 = null;
    L5:
        requestMetadataSyncForAccount(r2);
        return;
    L4:
        r2 = r1.name;
        goto L5
    }

    private Account getContactMetadataSyncAccount() {
        Iterator<Account> r4 = getFocusGoogleAccounts().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Account r0 = r4.next();
        if (ContentResolver.getIsSyncable(r0, CONTACT_METADATA_AUTHORITY) != 1) goto L4;
        if (ContentResolver.getSyncAutomatically(r0, CONTACT_METADATA_AUTHORITY) == false) goto L4;
        return r0;
    L10:
        return null;
    }

    private void requestMetadataSyncForAccount(String r10) {
        Iterator<Account> r9 = getFocusGoogleAccounts().iterator();
    L4:
        if (r9.hasNext() == false) goto L15;
        Account r0 = r9.next();
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (r10.equals(r0.name) == false) goto L11;
        Bundle r1 = new Bundle();
        r1.putBoolean(SHOULD_CLEAR_METADATA_BEFORE_SYNCING, true);
        r1.putBoolean(ONLY_CLEAR_DONOT_SYNC, false);
        r1.putBoolean("force", true);
        r1.putBoolean("expedited", true);
        ContentResolver.requestSync(r0, CONTACT_METADATA_AUTHORITY, r1);
        ContentResolver.setSyncAutomatically(r0, CONTACT_METADATA_AUTHORITY, true);
    L11:
        if (ContentResolver.getSyncAutomatically(r0, CONTACT_METADATA_AUTHORITY) == false) goto L4;
        ContentResolver.setSyncAutomatically(r0, CONTACT_METADATA_AUTHORITY, false);
        if (TextUtils.isEmpty(r10) == false) goto L4;
        Bundle r2 = new Bundle();
        r2.putBoolean("force", true);
        r2.putBoolean("expedited", true);
        r2.putBoolean(SHOULD_CLEAR_METADATA_BEFORE_SYNCING, true);
        r2.putBoolean(ONLY_CLEAR_DONOT_SYNC, true);
        ContentResolver.requestSync(r0, CONTACT_METADATA_AUTHORITY, r2);
        goto L4
    }

    private List<Account> getFocusGoogleAccounts() {
        ArrayList r0 = new ArrayList();
        Iterator<AccountWithDataSet> r4 = AccountTypeManager.getInstance(this.mContext).getAccounts(true).iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        AccountWithDataSet r1 = r4.next();
        if ("com.google".equals(r1.type) == false) goto L4;
        if (r1.dataSet != null) goto L4;
        r0.add(r1.getAccountOrNull());
        goto L4
    L10:
        return r0;
    }

    public void registerChangeListener(ChangeListener r2) {
        if (this.mListener == null) goto L5;
        unregisterChangeListener();
    L5:
        this.mListener = r2;
        this.mDisplayOrder = -1;
        this.mSortOrder = -1;
        this.mDefaultAccount = null;
        this.mPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public void unregisterChangeListener() {
        if (this.mListener == null) goto L5;
        this.mListener = null;
    L5:
        this.mPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences r2, final String r3) {
        this.mHandler.post(new AnonymousClass1(this, r3));
    }

    public void refreshValue(String r3) {
        if ("android.contacts.DISPLAY_ORDER".equals(r3) == false) goto L6;
        this.mDisplayOrder = -1;
        this.mDisplayOrder = getDisplayOrder();
    L11:
        ChangeListener r2 = this.mListener;
        if (r2 == null) goto L15;
        r2.onChange();
        return;
    L15:
        return;
    L6:
        if ("android.contacts.SORT_ORDER".equals(r3) == false) goto L9;
        this.mSortOrder = -1;
        this.mSortOrder = getSortOrder();
        goto L11
    L9:
        if (this.mDefaultAccountKey.equals(r3) == false) goto L11;
        this.mDefaultAccount = null;
        this.mDefaultAccount = getDefaultAccount();
        goto L11
    }

    private void maybeMigrateSystemSettings() {
        if (this.mPreferences.contains("android.contacts.SORT_ORDER") == true) goto L8;
        int r0 = getDefaultSortOrder();
        r0 = Settings.System.getInt(this.mContext.getContentResolver(), "android.contacts.SORT_ORDER");     // Catch: Settings.SettingNotFoundException -> L18
    L6:
        setSortOrder(r0);
    L8:
        if (this.mPreferences.contains("android.contacts.DISPLAY_ORDER") == true) goto L13;
        int r1 = getDefaultDisplayOrder();
        r1 = Settings.System.getInt(this.mContext.getContentResolver(), "android.contacts.DISPLAY_ORDER");     // Catch: Settings.SettingNotFoundException -> L19
    L11:
        setDisplayOrder(r1);
    L13:
        if (this.mPreferences.contains(this.mDefaultAccountKey) == true) goto L24;
        String r2 = android.preference.PreferenceManager.getDefaultSharedPreferences(this.mContext).getString(this.mDefaultAccountKey, null);
        if (TextUtils.isEmpty(r2) == true) goto L25;
        setDefaultAccount(AccountWithDataSet.unstringify(r2));
        return;
    L25:
        return;
    }
}
