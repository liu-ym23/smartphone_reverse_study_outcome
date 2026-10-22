package com.android.contacts.list;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.google.android.collect.Lists;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ContactListFilterController.java */
/* JADX INFO: loaded from: classes2.dex */
class ContactListFilterControllerImpl extends ContactListFilterController {
    private final Context mContext;
    private Set<ContactListFilter> mFilters;
    private final List<ContactListFilterController.ContactListFilterListener> mListeners;

    public ContactListFilterControllerImpl(Context r2) {
        this.mListeners = new ArrayList();
        this.mContext = r2;
        this.mFilters = ContactListFilter.restoreDefaultPreferences(getSharedPreferences());
        checkFilterValidity(true);
    }

    @Override // com.android.contacts.list.ContactListFilterController
    public void addListener(ContactListFilterController.ContactListFilterListener r1) {
        this.mListeners.add(r1);
    }

    @Override // com.android.contacts.list.ContactListFilterController
    public void removeListener(ContactListFilterController.ContactListFilterListener r1) {
        this.mListeners.remove(r1);
    }

    @Override // com.android.contacts.list.ContactListFilterController
    public Set<ContactListFilter> getFilters() {
        if (this.mFilters != null) goto L7;
        return null;
    L7:
        return new HashSet(this.mFilters);
    }

    private SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this.mContext);
    }

    @Override // com.android.contacts.list.ContactListFilterController
    public void setContactListFilter(Set<ContactListFilter> r2, boolean r3) {
        setContactListFilter(r2, r3, true);
    }

    private void setContactListFilter(Set<ContactListFilter> r1, boolean r2, boolean r3) {
        this.mFilters = r1;
        if (r2 == false) goto L5;
        ContactListFilter.storeToPreferences(getSharedPreferences(), this.mFilters);
    L5:
        if (r3 == true) goto L7;
        return;
    L7:
        if (this.mListeners.isEmpty() == true) goto L11;
        notifyContactListFilterChanged();
        return;
    }

    private void notifyContactListFilterChanged() {
        Iterator<ContactListFilterController.ContactListFilterListener> r1 = this.mListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onContactListFilterChanged();
        goto L4
    }

    @Override // com.android.contacts.list.ContactListFilterController
    public void checkFilterValidity(boolean r10) {
        if (this.mFilters != null) goto L5;
        return;
    L5:
        HashSet r0 = new HashSet();
        Iterator<ContactListFilter> r1 = this.mFilters.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        ContactListFilter r2 = r1.next();
        if (filterAccountExists(r2) == false) goto L7;
        r0.add(r2);
        goto L7
    L11:
        AccountTypeManager r3 = AccountTypeManager.getInstance(this.mContext);
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L14;
        List<AccountWithDataSet> r4 = r3.getAccountsIncludeSIM(false);
    L15:
        ArrayList r5 = new ArrayList(r4);
        List r6 = ContactListFilter.restoreAvailableAccountsFromPreferences(this.mContext);
        if (r6 != null) goto L18;
        r6 = Lists.newArrayList();
    L18:
        Iterator r7 = r5.iterator();
    L20:
        if (r7.hasNext() == false) goto L28;
        AccountWithDataSet r8 = (AccountWithDataSet) r7.next();
        if (r6.contains(r8) == true) goto L20;
        String r9 = r8.type;
        String r11 = r8.name;
        if ("com.android.sim".equals(r8.type) == false) goto L26;
        String r12 = null;
    L27:
        r0.add(ContactListFilter.createAccountFilter(r9, r11, r12));
        goto L20
    L26:
        r12 = r8.dataSet;
        goto L27
    L28:
        ContactListFilter.storeAvailableAccountsToPreferences(this.mContext, r5);
        setContactListFilter(r0, r10);
        return;
    L14:
        r4 = r3.getAccounts(false);
        goto L15
    }

    private boolean filterAccountExists(ContactListFilter r4) {
        if (ContactsUtils.LOCAL_ACCOUNT_TYPE.equals(r4.accountType) == false) goto L7;
        return true;
    L7:
        return AccountTypeManager.getInstance(this.mContext).contains(new AccountWithDataSet(r4.accountName, r4.accountType, r4.dataSet), false);
    }
}
