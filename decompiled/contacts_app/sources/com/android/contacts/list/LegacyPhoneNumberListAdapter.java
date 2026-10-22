package com.android.contacts.list;

import android.R;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.interactions.GroupDeletionDialogFragment;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyPhoneNumberListAdapter extends ContactEntryListAdapter {
    private static final String[] PHONES_PROJECTION = null;
    private static final int PHONE_DISPLAY_NAME_COLUMN_INDEX = 4;
    private static final int PHONE_ID_COLUMN_INDEX = 0;
    private static final int PHONE_LABEL_COLUMN_INDEX = 2;
    private static final int PHONE_NUMBER_COLUMN_INDEX = 3;
    private static final int PHONE_PHONETIC_NAME_COLUMN_INDEX = 5;
    private static final int PHONE_TYPE_COLUMN_INDEX = 1;
    private CharSequence mUnknownNameText;

    static {
        PHONES_PROJECTION = new String[]{"_id", "type", GroupDeletionDialogFragment.ARG_LABEL, "number", "display_name", "phonetic_name"};
    }

    public LegacyPhoneNumberListAdapter(Context r2) {
        super(r2);
        this.mUnknownNameText = r2.getText(R.string.unknownName);
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r1, long r2) {
        r1.setUri(Contacts.Phones.CONTENT_URI);
        r1.setProjection(PHONES_PROJECTION);
        r1.setSortOrder("display_name");
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public String getContactDisplayName(int r1) {
        return ((Cursor) getItem(r1)).getString(4);
    }

    public Uri getPhoneUri(int r2) {
        if (getItem(r2) != null) goto L6;
        return null;
    L6:
        long r1 = ((Cursor) getItem(r2)).getLong(0);
        return ContentUris.withAppendedId(Contacts.Phones.CONTENT_URI, r1);
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
        bindPhoneNumber(r5, r3);
    }

    protected void bindName(ContactListItemView r2, Cursor r3) {
        r2.showDisplayName(r3, 4, getContactNameDisplayOrder());
        r2.showPhoneticName(r3, 5);
    }

    protected void bindPhoneNumber(ContactListItemView r3, Cursor r4) {
        if (r4.isNull(1) == true) goto L5;
        int r0 = r4.getInt(1);
        String r1 = r4.getString(2);
        CharSequence r2 = ContactsContract.CommonDataKinds.Phone.getTypeLabel(getContext().getResources(), r0, r1);
    L6:
        r3.setLabel(r2);
        r3.showData(r4, 3);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
