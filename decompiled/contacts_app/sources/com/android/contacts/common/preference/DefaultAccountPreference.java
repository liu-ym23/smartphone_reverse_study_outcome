package com.android.contacts.common.preference;

import android.app.AlertDialog;
import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountWithDataSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAccountPreference extends ListPreference {
    private Map<String, AccountWithDataSet> mAccountMap;
    private ContactsPreferences mPreferences;

    @Override // android.preference.Preference
    protected boolean shouldPersist() {
        return false;
    }

    public DefaultAccountPreference(Context r1) {
        super(r1);
        prepare();
    }

    public DefaultAccountPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        prepare();
    }

    private void prepare() {
        this.mPreferences = new ContactsPreferences(getContext());
        this.mAccountMap = new HashMap();
        List<AccountWithDataSet> r0 = AccountTypeManager.getInstance(getContext()).getAccounts(true);
        Iterator<AccountWithDataSet> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        AccountWithDataSet r3 = r2.next();
        this.mAccountMap.put(r3.name, r3);
        goto L4
    L6:
        Set<String> r4 = this.mAccountMap.keySet();
        String[] r5 = (String[]) r4.toArray(new String[r4.size()]);
        setEntries(r5);
        setEntryValues(r5);
        String r6 = String.valueOf(this.mPreferences.getDefaultAccount());
        if (r0.size() != 1) goto L10;
        setValue(r0.get(0).name);
        return;
    L10:
        if (r4.contains(r6) == false) goto L12;
        setValue(r6);
        return;
    L12:
        setValue(null);
    }

    @Override // android.preference.ListPreference, android.preference.Preference
    public CharSequence getSummary() {
        return this.mPreferences.getDefaultAccount();
    }

    @Override // android.preference.Preference
    protected boolean persistString(String r4) {
        if (r4 == null) goto L5;
    L7:
        if (r4 != null) goto L9;
    L12:
        this.mPreferences.setDefaultAccount(this.mAccountMap.get(r4));
        notifyChanged();
    L13:
        return true;
    L9:
        if (this.mPreferences.getDefaultAccount() == null) goto L12;
        if (r4.equals(this.mPreferences.getDefaultAccount()) == true) goto L13;
    L5:
        if (this.mPreferences.getDefaultAccount() != null) goto L7;
        return true;
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder r1) {
        super.onPrepareDialogBuilder(r1);
        r1.setNegativeButton(null, null);
    }
}
