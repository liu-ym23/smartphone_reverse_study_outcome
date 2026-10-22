package com.android.contacts.list;

import android.R;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import androidx.loader.content.CursorLoader;
import com.android.contacts.interactions.GroupDeletionDialogFragment;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyPostalAddressListAdapter extends com.android.contacts.common.list.ContactEntryListAdapter {
    static final String[] POSTALS_PROJECTION = null;
    public static final int POSTAL_DISPLAY_NAME_COLUMN_INDEX = 4;
    public static final int POSTAL_ID_COLUMN_INDEX = 0;
    public static final int POSTAL_LABEL_COLUMN_INDEX = 2;
    public static final int POSTAL_NUMBER_COLUMN_INDEX = 3;
    public static final int POSTAL_PHONETIC_NAME_COLUMN_INDEX = 5;
    public static final int POSTAL_TYPE_COLUMN_INDEX = 1;
    private CharSequence mUnknownNameText;

    static {
        POSTALS_PROJECTION = new String[]{"_id", "type", GroupDeletionDialogFragment.ARG_LABEL, "data", "display_name", "phonetic_name"};
    }

    public LegacyPostalAddressListAdapter(Context r2) {
        super(r2);
        this.mUnknownNameText = r2.getText(R.string.unknownName);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r1, long r2) {
        r1.setUri(Contacts.ContactMethods.CONTENT_URI);
        r1.setProjection(POSTALS_PROJECTION);
        r1.setSortOrder("display_name");
        r1.setSelection("kind=2");
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public String getContactDisplayName(int r1) {
        return ((Cursor) getItem(r1)).getString(4);
    }

    public Uri getContactMethodUri(int r2) {
        long r1 = ((Cursor) getItem(r2)).getLong(0);
        return ContentUris.withAppendedId(Contacts.ContactMethods.CONTENT_URI, r1);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        com.android.contacts.common.list.ContactListItemView r6 = new com.android.contacts.common.list.ContactListItemView(r1, null);
        r6.setUnknownNameText(this.mUnknownNameText);
        return r6;
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r1, int r2, Cursor r3, int r4) {
        com.android.contacts.common.list.ContactListItemView r5 = (com.android.contacts.common.list.ContactListItemView) r1;
        bindName(r5, r3);
        bindPostalAddress(r5, r3);
    }

    protected void bindName(com.android.contacts.common.list.ContactListItemView r2, Cursor r3) {
        r2.showDisplayName(r3, 4, getContactNameDisplayOrder());
        r2.showPhoneticName(r3, 5);
    }

    protected void bindPostalAddress(com.android.contacts.common.list.ContactListItemView r3, Cursor r4) {
        if (r4.isNull(1) == true) goto L5;
        int r0 = r4.getInt(1);
        String r1 = r4.getString(2);
        CharSequence r2 = ContactsContract.CommonDataKinds.StructuredPostal.getTypeLabel(getContext().getResources(), r0, r1);
    L6:
        r3.setLabel(r2);
        r3.showData(r4, 3);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
