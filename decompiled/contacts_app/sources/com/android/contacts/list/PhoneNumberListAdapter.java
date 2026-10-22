package com.android.contacts.list;

import android.R;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.util.Constants;
import com.android.contacts.widget.IndexerListAdapter;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneNumberListAdapter extends ContactEntryListAdapter {
    private static final String TAG = "PhoneNumberListAdapter";
    private ContactListItemView.PhotoPosition mPhotoPosition;
    private final CharSequence mUnknownNameText;

    protected static class PhoneQuery {
        public static final int PHONE_CONTACT_ID = 4;
        public static final int PHONE_DISPLAY_NAME = 7;
        public static final int PHONE_ID = 0;
        public static final int PHONE_LABEL = 2;
        public static final int PHONE_LOOKUP_KEY = 5;
        public static final int PHONE_NUMBER = 3;
        public static final int PHONE_PHOTO_ID = 6;
        public static final int PHONE_TYPE = 1;
        private static final String[] PROJECTION_ALTERNATIVE = null;
        private static final String[] PROJECTION_PRIMARY = null;

        protected PhoneQuery() {
        }

        static /* synthetic */ String[] access$000() {
            return PROJECTION_PRIMARY;
        }

        static /* synthetic */ String[] access$100() {
            return PROJECTION_ALTERNATIVE;
        }

        static {
            PROJECTION_PRIMARY = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name"};
            PROJECTION_ALTERNATIVE = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name_alt"};
        }
    }

    public PhoneNumberListAdapter(Context r2) {
        super(r2);
        this.mUnknownNameText = r2.getText(R.string.unknownName);
    }

    protected CharSequence getUnknownNameText() {
        return this.mUnknownNameText;
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r5, long r6) {
        if (r6 == 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "PhoneNumberListAdapter is not ready for non-default directory ID (directoryId: " + r6 + ")");
    L6:
        if (isSearchMode() == false) goto L12;
        String r0 = getQueryString();
        Uri.Builder r1 = ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI.buildUpon();
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r1.appendPath("");
    L11:
        r1.appendQueryParameter("directory", String.valueOf(r6));
        Uri r7 = r1.build();
    L16:
        r5.setUri(r7.buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build());
        if (getContactNameDisplayOrder() != 1) goto L19;
        r5.setProjection(PhoneQuery.access$000());
    L21:
        if (getSortOrder() != 1) goto L23;
        r5.setSortOrder(PickerFragment.CONTACT_SORT_CNAME);
        return;
    L23:
        r5.setSortOrder("sort_key_alt");
        return;
    L19:
        r5.setProjection(PhoneQuery.access$100());
        goto L21
    L10:
        r1.appendPath(r0);
        goto L11
    L12:
        Uri r2 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build();
        if (isSectionHeaderDisplayEnabled() == false) goto L15;
        r2 = buildSectionIndexerUri(r2);
    L15:
        configureSelection(r5, r6, getFilter());
        r7 = r2;
        goto L16
    }

    private void configureSelection(CursorLoader r3, long r4, ContactListFilter r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r4 != 0) goto L25;
        StringBuilder r2 = new StringBuilder();
        ArrayList r5 = new ArrayList();
        int r7 = r6.filterType;
        if (r7 != (-5)) goto L9;
    L22:
        r3.setSelection(r2.toString());
        r3.setSelectionArgs((String[]) r5.toArray(new String[0]));
        return;
    L9:
        if (r7 != (-3)) goto L11;
        r2.append("in_visible_group=1 AND has_phone_number=1");
        goto L22
    L11:
        if (r7 == (-2)) goto L22;
        if (r7 == (-1)) goto L22;
        if (r7 == 0) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unsupported filter type came (type: " + r6.filterType + ", toString: " + r6 + ") showing all contacts.");
        goto L22
    L16:
        r2.append("(account_type=? AND account_name=?");
        r5.add(r6.accountType);
        r5.add(r6.accountName);
        if (r6.dataSet == null) goto L19;
        r2.append(" AND data_set=?");
        r5.add(r6.dataSet);
    L20:
        r2.append(")");
        goto L22
    L19:
        r2.append(" AND data_set IS NULL");
        goto L20
    }

    protected static Uri buildSectionIndexerUri(Uri r2) {
        return r2.buildUpon().appendQueryParameter(Constants.ADDRESS_BOOK_INDEX_EXTRAS, "true").build();
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public String getContactDisplayName(int r1) {
        return ((Cursor) getItem(r1)).getString(7);
    }

    public Uri getDataUri(int r2) {
        Cursor r1 = (Cursor) getItem(r2);
        if (r1 == null) goto L6;
        long r3 = r1.getLong(0);
        return ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r3);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Cursor was null in getDataUri() call. Returning null instead.");
        return null;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        ContactListItemView r6 = new ContactListItemView(r1, null);
        r6.setUnknownNameText(this.mUnknownNameText);
        r6.setQuickContactEnabled(isQuickContactEnabled());
        r6.setPhotoPosition(this.mPhotoPosition);
        return r6;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r10, int r11, Cursor r12, int r13) {
        ContactListItemView r14 = (ContactListItemView) r10;
        r12.moveToPosition(r13);
        long r1 = r12.getLong(4);
        if (r12.moveToPrevious() == true) goto L5;
    L9:
        boolean r3 = true;
    L10:
        r12.moveToPosition(r13);
        if (r12.moveToNext() == true) goto L13;
    L17:
        boolean r8 = true;
    L18:
        r12.moveToPosition(r13);
        bindSectionHeaderAndDivider(r14, r13);
        if (r3 == false) goto L24;
        bindName(r14, r12);
        if (isQuickContactEnabled() == false) goto L23;
        bindQuickContact(r14, r11, r12, 6, 4, 5, 7);
    L25:
        bindPhoneNumber(r14, r12);
        r14.setDividerVisible(r8);
        return;
    L23:
        bindPhoto(r14, r12);
        goto L25
    L24:
        unbindName(r14);
        r14.removePhotoView(true, false);
        goto L25
    L13:
        if (r12.isAfterLast() == true) goto L17;
        if (r1 != r12.getLong(4)) goto L17;
        r8 = false;
        goto L18
    L5:
        if (r12.isBeforeFirst() == true) goto L9;
        if (r1 != r12.getLong(4)) goto L9;
        r3 = false;
        goto L10
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

    protected void bindSectionHeaderAndDivider(ContactListItemView r4, int r5) {
        String r2 = null;
        if (isSectionHeaderDisplayEnabled() == false) goto L8;
        IndexerListAdapter.Placement r3 = getItemPlacementInSection(r5);
        if (r3.firstInSection == false) goto L7;
        r2 = r3.sectionHeader;
    L7:
        r4.setSectionHeader(r2);
        r4.setDividerVisible(!r3.lastInSection);
        return;
    L8:
        r4.setSectionHeader(null);
        r4.setDividerVisible(true);
    }

    protected void bindName(ContactListItemView r2, Cursor r3) {
        r2.showDisplayName(r3, 7, getContactNameDisplayOrder());
    }

    protected void unbindName(ContactListItemView r1) {
        r1.hideDisplayName();
    }

    protected void bindPhoto(ContactListItemView r9, Cursor r10) {
        if (r10.isNull(6) == true) goto L5;
        long r0 = r10.getLong(6);
    L6:
        long r4 = r0;
        r9.getPhotoView().setPhotoID(r4);
        getPhotoLoader().loadPhoto(r9.getPhotoView(), r4, false, false);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public void setPhotoPosition(ContactListItemView.PhotoPosition r1) {
        this.mPhotoPosition = r1;
    }

    public ContactListItemView.PhotoPosition getPhotoPosition() {
        return this.mPhotoPosition;
    }
}
