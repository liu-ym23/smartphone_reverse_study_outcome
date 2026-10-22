package com.android.contacts.common.list;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactListFilterController {
    private static ContactListFilterControllerImpl sFilterController;

    public interface ContactListFilterListener {
        void onContactListFilterChanged();
    }

    static {
    }

    public abstract void addListener(ContactListFilterListener r1);

    public abstract void checkFilterValidity(boolean r1);

    public abstract ContactListFilter getFilter();

    public abstract void removeListener(ContactListFilterListener r1);

    public abstract void selectCustomFilter();

    public abstract void setContactListFilter(ContactListFilter r1, boolean r2);

    public ContactListFilterController() {
    }

    public static ContactListFilterController getInstance(Context r1) {
        if (sFilterController != null) goto L6;
        sFilterController = new ContactListFilterControllerImpl(r1);
    L6:
        return sFilterController;
    }
}
