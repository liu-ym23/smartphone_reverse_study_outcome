package com.android.contacts.list;

import android.R;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.loader.content.CursorLoader;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.util.Constants;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes2.dex */
public class EmailAddressListAdapter extends com.android.contacts.common.list.ContactEntryListAdapter {
    private final CharSequence mUnknownNameText;

    protected static class EmailQuery {
        public static final int EMAIL_ADDRESS = 3;
        public static final int EMAIL_DISPLAY_NAME = 5;
        public static final int EMAIL_ID = 0;
        public static final int EMAIL_LABEL = 2;
        public static final int EMAIL_PHOTO_ID = 4;
        public static final int EMAIL_TYPE = 1;
        private static final String[] PROJECTION_ALTERNATIVE = null;
        private static final String[] PROJECTION_PRIMARY = null;

        protected EmailQuery() {
        }

        static /* synthetic */ String[] access$000() {
            return PROJECTION_PRIMARY;
        }

        static /* synthetic */ String[] access$100() {
            return PROJECTION_ALTERNATIVE;
        }

        static {
            PROJECTION_PRIMARY = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "photo_id", "display_name"};
            PROJECTION_ALTERNATIVE = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "photo_id", "display_name_alt"};
        }
    }

    public EmailAddressListAdapter(Context r2) {
        super(r2);
        this.mUnknownNameText = r2.getText(R.string.unknownName);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r5, long r6) {
        if (isSearchMode() == false) goto L8;
        Uri.Builder r0 = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI.buildUpon();
        String r2 = getQueryString();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        r2 = "";
    L7:
        r0.appendPath(r2);
    L11:
        r0.appendQueryParameter("directory", String.valueOf(r6));
        r0.appendQueryParameter("remove_duplicate_entries", "true");
        r5.setUri(r0.build());
        if (getContactNameDisplayOrder() != 1) goto L14;
        r5.setProjection(EmailQuery.access$000());
    L16:
        if (getSortOrder() != 1) goto L18;
        r5.setSortOrder(PickerFragment.CONTACT_SORT_CNAME);
        return;
    L18:
        r5.setSortOrder("sort_key_alt");
        return;
    L14:
        r5.setProjection(EmailQuery.access$100());
        goto L16
    L8:
        r0 = ContactsContract.CommonDataKinds.Email.CONTENT_URI.buildUpon();
        if (isSectionHeaderDisplayEnabled() == false) goto L11;
        r0.appendQueryParameter(Constants.ADDRESS_BOOK_INDEX_EXTRAS, "true");
        goto L11
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public String getContactDisplayName(int r1) {
        return ((Cursor) getItem(r1)).getString(5);
    }

    public Uri getDataUri(int r2) {
        long r1 = ((Cursor) getItem(r2)).getLong(0);
        return ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r1);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        com.android.contacts.common.list.ContactListItemView r6 = new com.android.contacts.common.list.ContactListItemView(r1, null);
        r6.setUnknownNameText(this.mUnknownNameText);
        r6.setQuickContactEnabled(isQuickContactEnabled());
        return r6;
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r1, int r2, Cursor r3, int r4) {
        com.android.contacts.common.list.ContactListItemView r5 = (com.android.contacts.common.list.ContactListItemView) r1;
        bindSectionHeaderAndDivider(r5, r4);
        bindName(r5, r3);
        bindPhoto(r5, r3);
        bindEmailAddress(r5, r3);
    }

    protected void bindEmailAddress(com.android.contacts.common.list.ContactListItemView r3, Cursor r4) {
        if (r4.isNull(1) == true) goto L5;
        int r0 = r4.getInt(1);
        String r1 = r4.getString(2);
        CharSequence r2 = ContactsContract.CommonDataKinds.Email.getTypeLabel(getContext().getResources(), r0, r1);
    L6:
        r3.setLabel(r2);
        r3.showData(r4, 3);
        return;
    L5:
        r2 = null;
        goto L6
    }

    protected void bindSectionHeaderAndDivider(com.android.contacts.common.list.ContactListItemView r4, int r5) {
        int r0 = getSectionForPosition(r5);
        if (getPositionForSection(r0) != r5) goto L5;
        r4.setSectionHeader((String) getSections()[r0]);
    L7:
        if ((getPositionForSection(r0 + 1) - 1) != r5) goto L9;
        r4.setDividerVisible(false);
        return;
    L9:
        r4.setDividerVisible(true);
        return;
    L5:
        r4.setDividerVisible(false);
        r4.setSectionHeader(null);
        goto L7
    }

    protected void bindName(com.android.contacts.common.list.ContactListItemView r2, Cursor r3) {
        r2.showDisplayName(r3, 5, getContactNameDisplayOrder());
    }

    protected void bindPhoto(com.android.contacts.common.list.ContactListItemView r3, Cursor r4) {
        if (r4.isNull(4) == true) goto L5;
        long r0 = r4.getLong(4);
    L6:
        getPhotoLoader().loadThumbnail(r3.getPhotoView(), r0, false);
        return;
    L5:
        r0 = 0;
        goto L6
    }
}
