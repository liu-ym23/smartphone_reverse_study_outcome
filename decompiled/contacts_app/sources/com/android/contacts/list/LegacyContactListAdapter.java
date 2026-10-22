package com.android.contacts.list;

import android.R;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.ContactSaveService;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyContactListAdapter extends ContactEntryListAdapter {
    static final String[] PEOPLE_PROJECTION = null;
    protected static final int PERSON_DISPLAY_NAME_COLUMN_INDEX = 1;
    protected static final int PERSON_ID_COLUMN_INDEX = 0;
    protected static final int PERSON_PHONETIC_NAME_COLUMN_INDEX = 2;
    protected static final int PERSON_PRESENCE_STATUS_COLUMN_INDEX = 4;
    protected static final int PERSON_STARRED_COLUMN_INDEX = 3;
    private CharSequence mUnknownNameText;

    static {
        PEOPLE_PROJECTION = new String[]{"_id", "display_name", "phonetic_name", ContactSaveService.EXTRA_STARRED_FLAG, "mode"};
    }

    public LegacyContactListAdapter(Context r2) {
        super(r2);
        this.mUnknownNameText = r2.getText(R.string.unknownName);
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r1, long r2) {
        r1.setUri(Contacts.People.CONTENT_URI);
        r1.setProjection(PEOPLE_PROJECTION);
        r1.setSortOrder("display_name");
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public String getContactDisplayName(int r1) {
        return ((Cursor) getItem(r1)).getString(1);
    }

    public Uri getPersonUri(int r2) {
        long r1 = ((Cursor) getItem(r2)).getLong(0);
        return ContentUris.withAppendedId(Contacts.People.CONTENT_URI, r1);
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        ContactListItemView r6 = new ContactListItemView(r1, null);
        r6.setUnknownNameText(this.mUnknownNameText);
        return r6;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r1, int r2, Cursor r3, int r4) {
        ContactListItemView r5 = (ContactListItemView) r1;
        bindName(r5, r3);
        bindPresence(r5, r3);
    }

    protected void bindName(ContactListItemView r2, Cursor r3) {
        r2.showDisplayName(r3, 1, getContactNameDisplayOrder());
        r2.showPhoneticName(r3, 2);
    }

    protected void bindPresence(ContactListItemView r2, Cursor r3) {
        r2.showPresenceAndStatusMessage(r3, 4, 0);
    }
}
