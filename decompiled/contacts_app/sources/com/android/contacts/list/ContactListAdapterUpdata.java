package com.android.contacts.list;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class ContactListAdapterUpdata extends ContactEntryListAdapter {
    @Override // com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r1, int r2, Cursor r3, int r4) {
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r1, long r2) {
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public String getContactDisplayName(int r1) {
        return null;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        return null;
    }

    public ContactListAdapterUpdata(Context r1, NewContactListFragment r2) {
        super(r1);
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public void changeCursor(Cursor r1) {
        super.changeCursor(r1);
    }
}
