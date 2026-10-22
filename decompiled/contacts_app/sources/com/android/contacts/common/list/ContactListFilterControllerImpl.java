package com.android.contacts.common.list;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountWithDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ContactListFilterController.java */
/* JADX INFO: loaded from: classes.dex */
class ContactListFilterControllerImpl extends ContactListFilterController {
    private final Context mContext;
    private ContactListFilter mFilter;
    private final List<ContactListFilterController.ContactListFilterListener> mListeners;

    public ContactListFilterControllerImpl(Context r2) {
        this.mListeners = new ArrayList();
        this.mContext = r2;
        this.mFilter = ContactListFilter.restoreDefaultPreferences(getSharedPreferences());
        checkFilterValidity(true);
    }

    @Override // com.android.contacts.common.list.ContactListFilterController
    public void addListener(ContactListFilterController.ContactListFilterListener r1) {
        this.mListeners.add(r1);
    }

    @Override // com.android.contacts.common.list.ContactListFilterController
    public void removeListener(ContactListFilterController.ContactListFilterListener r1) {
        this.mListeners.remove(r1);
    }

    @Override // com.android.contacts.common.list.ContactListFilterController
    public ContactListFilter getFilter() {
        return this.mFilter;
    }

    private SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this.mContext);
    }

    @Override // com.android.contacts.common.list.ContactListFilterController
    public void setContactListFilter(ContactListFilter r2, boolean r3) {
        setContactListFilter(r2, r3, true);
    }

    private void setContactListFilter(ContactListFilter r2, boolean r3, boolean r4) {
        if (r2.equals(this.mFilter) == true) goto L12;
        this.mFilter = r2;
        if (r3 == false) goto L7;
        ContactListFilter.storeToPreferences(getSharedPreferences(), this.mFilter);
    L7:
        if (r4 == true) goto L9;
        return;
    L9:
        if (this.mListeners.isEmpty() == true) goto L14;
        notifyContactListFilterChanged();
        return;
    L14:
        return;
    }

    @Override // com.android.contacts.common.list.ContactListFilterController
    public void selectCustomFilter() {
        setContactListFilter(ContactListFilter.createFilterWithType(-3), true);
    }

    private void notifyContactListFilterChanged() {
        Iterator<ContactListFilterController.ContactListFilterListener> r1 = this.mListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onContactListFilterChanged();
        goto L4
    }

    @Override // com.android.contacts.common.list.ContactListFilterController
    public void checkFilterValidity(boolean r3) {
        ContactListFilter r0 = this.mFilter;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.filterType;
        if (r1 == (-6)) goto L12;
        if (r1 == 0) goto L10;
        return;
    L10:
        if (filterAccountExists() == true) goto L14;
        setContactListFilter(ContactListFilter.createFilterWithType(-2), true, r3);
        return;
    L14:
        return;
    L12:
        setContactListFilter(ContactListFilter.restoreDefaultPreferences(getSharedPreferences()), false, r3);
    }

    private boolean filterAccountExists() {
        return AccountTypeManager.getInstance(this.mContext).contains(new AccountWithDataSet(this.mFilter.accountName, this.mFilter.accountType, this.mFilter.dataSet), false);
    }
}
