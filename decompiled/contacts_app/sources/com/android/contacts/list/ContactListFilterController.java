package com.android.contacts.list;

import android.content.Context;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContactListFilterController {
    public static final String CONTACT_LIST_FILTER_SERVICE = "contactListFilter";

    public interface ContactListFilterListener {
        void onContactListFilterChanged();
    }

    public abstract void addListener(ContactListFilterListener r1);

    public abstract void checkFilterValidity(boolean r1);

    public abstract Set<ContactListFilter> getFilters();

    public abstract void removeListener(ContactListFilterListener r1);

    public abstract void setContactListFilter(Set<ContactListFilter> r1, boolean r2);

    public ContactListFilterController() {
    }

    public static ContactListFilterController getInstance(Context r1) {
        return (ContactListFilterController) r1.getApplicationContext().getSystemService(CONTACT_LIST_FILTER_SERVICE);
    }

    public static ContactListFilterController createContactListFilterController(Context r1) {
        return new ContactListFilterControllerImpl(r1);
    }
}
