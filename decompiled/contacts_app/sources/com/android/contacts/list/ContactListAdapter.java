package com.android.contacts.list;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.R;
import com.android.contacts.util.Constants;
import com.android.contacts.widget.IndexerListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContactListAdapter extends ContactEntryListAdapter {
    private long mSelectedContactDirectoryId;
    private long mSelectedContactId;
    private String mSelectedContactLookupKey;
    private CharSequence mUnknownNameText;

    protected static class ContactQuery {
        public static final int CONTACT_CONTACT_STATUS = 3;
        public static final int CONTACT_DISPLAY_NAME = 1;
        public static final int CONTACT_ID = 0;
        public static final int CONTACT_IS_USER_PROFILE = 7;
        public static final int CONTACT_LOOKUP_KEY = 6;
        public static final int CONTACT_PHOTO_ID = 4;
        public static final int CONTACT_PHOTO_URI = 5;
        public static final int CONTACT_PRESENCE_STATUS = 2;
        private static final String[] CONTACT_PROJECTION_ALTERNATIVE = null;
        private static final String[] CONTACT_PROJECTION_PRIMARY = null;
        public static final int CONTACT_SNIPPET = 8;
        private static final String[] FILTER_PROJECTION_ALTERNATIVE = null;
        private static final String[] FILTER_PROJECTION_PRIMARY = null;

        protected ContactQuery() {
        }

        static /* synthetic */ String[] access$000() {
            return FILTER_PROJECTION_PRIMARY;
        }

        static /* synthetic */ String[] access$100() {
            return FILTER_PROJECTION_ALTERNATIVE;
        }

        static /* synthetic */ String[] access$200() {
            return CONTACT_PROJECTION_PRIMARY;
        }

        static /* synthetic */ String[] access$300() {
            return CONTACT_PROJECTION_ALTERNATIVE;
        }

        static {
            CONTACT_PROJECTION_PRIMARY = new String[]{"_id", "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile"};
            CONTACT_PROJECTION_ALTERNATIVE = new String[]{"_id", "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile"};
            FILTER_PROJECTION_PRIMARY = new String[]{"_id", "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", Constants.SNIPPET};
            FILTER_PROJECTION_ALTERNATIVE = new String[]{"_id", "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", Constants.SNIPPET};
        }
    }

    public ContactListAdapter(Context r2) {
        super(r2);
        this.mUnknownNameText = r2.getText(R.string.missing_name);
    }

    public CharSequence getUnknownNameText() {
        return this.mUnknownNameText;
    }

    public long getSelectedContactDirectoryId() {
        return this.mSelectedContactDirectoryId;
    }

    public String getSelectedContactLookupKey() {
        return this.mSelectedContactLookupKey;
    }

    public long getSelectedContactId() {
        return this.mSelectedContactId;
    }

    public void setSelectedContact(long r1, String r3, long r4) {
        this.mSelectedContactDirectoryId = r1;
        this.mSelectedContactLookupKey = r3;
        this.mSelectedContactId = r4;
    }

    protected static Uri buildSectionIndexerUri(Uri r2) {
        return r2.buildUpon().appendQueryParameter(Constants.ADDRESS_BOOK_INDEX_EXTRAS, "true").build();
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public String getContactDisplayName(int r1) {
        return ((Cursor) getItem(r1)).getString(1);
    }

    public Uri getContactUri(int r2) {
        int r0 = getPartitionForPosition(r2);
        Cursor r3 = (Cursor) getItem(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return getContactUri(r0, r3);
    }

    public Uri getContactUri(int r4, Cursor r5) {
        Uri r6 = ContactsContract.Contacts.getLookupUri(r5.getLong(0), r5.getString(6));
        long r3 = ((DirectoryPartition) getPartition(r4)).getDirectoryId();
        if (r3 != 0) goto L5;
        return r6;
    L5:
        return r6.buildUpon().appendQueryParameter("directory", String.valueOf(r3)).build();
    }

    public boolean isSelectedContact(int r7, Cursor r8) {
        long r0 = ((DirectoryPartition) getPartition(r7)).getDirectoryId();
        if (getSelectedContactDirectoryId() == r0) goto L5;
        return false;
    L5:
        String r9 = getSelectedContactLookupKey();
        if (r9 == null) goto L11;
        if (TextUtils.equals(r9, r8.getString(6)) == false) goto L11;
        return true;
    L11:
        if (r0 != 0) goto L13;
        return false;
    L13:
        if (r0 != 1) goto L15;
        return false;
    L15:
        if (getSelectedContactId() == r8.getLong(0)) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        ContactListItemView r6 = new ContactListItemView(r1, null);
        r6.setUnknownNameText(this.mUnknownNameText);
        r6.setQuickContactEnabled(isQuickContactEnabled());
        r6.setActivatedStateSupported(isSelectionVisible());
        return r6;
    }

    protected void bindSectionHeaderAndDivider(ContactListItemView r4, int r5, Cursor r6) {
        if (isSectionHeaderDisplayEnabled() == false) goto L11;
        IndexerListAdapter.Placement r0 = getItemPlacementInSection(r5);
        if (r5 == 0) goto L7;
    L9:
        r4.setCountView(null);
    L10:
        r4.setSectionHeader(r0.sectionHeader);
        r4.setDividerVisible(!r0.lastInSection);
        return;
    L7:
        if (r6.getInt(7) != 1) goto L9;
        r4.setCountView(getContactsCount());
        goto L10
    L11:
        r4.setSectionHeader(null);
        r4.setDividerVisible(true);
        r4.setCountView(null);
    }

    protected void bindPhoto(ContactListItemView r7, int r8, Cursor r9) {
        if (isPhotoSupported(r8) == true) goto L7;
        r7.removePhotoView();
        return;
    L7:
        if (r9.isNull(4) == true) goto L9;
        long r10 = r9.getLong(4);
    L10:
        long r2 = r10;
        r7.getPhotoView().setPhotoID(r2);
        getPhotoLoader().loadPhoto(r7.getPhotoView(), r2, false, false);
        return;
    L9:
        r10 = 0;
        goto L10
    }

    protected void bindName(ContactListItemView r2, Cursor r3) {
        r2.showDisplayName(r3, 1, getContactNameDisplayOrder());
    }

    protected void bindPresenceAndStatusMessage(ContactListItemView r2, Cursor r3) {
        r2.showPresenceAndStatusMessage(r3, 2, 3);
    }

    protected void bindSearchSnippet(ContactListItemView r1, Cursor r2) {
        r1.showSnippet(r2, 8);
    }

    public int getSelectedContactPosition() {
        if (this.mSelectedContactLookupKey == null) goto L5;
    L7:
        int r0 = getPartitionCount();
        int r5 = 0;
    L8:
        if (r5 >= r0) goto L13;
        if (((DirectoryPartition) getPartition(r5)).getDirectoryId() == this.mSelectedContactDirectoryId) goto L14;
        r5 = r5 + 1;
    L14:
        if (r5 != (-1)) goto L16;
        return -1;
    L16:
        Cursor r1 = getCursor(r5);
        if (r1 != null) goto L19;
        return -1;
    L19:
        r1.moveToPosition(-1);
    L21:
        if (r1.moveToNext() == false) goto L36;
        if (this.mSelectedContactLookupKey == null) goto L28;
        if (this.mSelectedContactLookupKey.equals(r1.getString(6)) == false) goto L28;
        int r2 = r1.getPosition();
    L37:
        if (r2 != (-1)) goto L39;
        return -1;
    L39:
        int r3 = getPositionForPartition(r5) + r2;
        if (hasHeader(r5) == true) goto L42;
        return r3;
    L42:
        return r3 + 1;
    L28:
        if (this.mSelectedContactId == 0) goto L21;
        long r6 = this.mSelectedContactDirectoryId;
        if (r6 == 0) goto L34;
        if (r6 != 1) goto L21;
    L34:
        if (r1.getLong(0) != this.mSelectedContactId) goto L21;
        r2 = r1.getPosition();
        goto L37
    L36:
        r2 = -1;
        goto L37
    L13:
        r5 = -1;
        goto L14
    L5:
        if (this.mSelectedContactId != 0) goto L7;
        return -1;
    }

    public boolean hasValidSelection() {
        if (getSelectedContactPosition() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public Uri getFirstContactUri() {
        int r0 = getPartitionCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        if (((DirectoryPartition) getPartition(r1)).isLoading() == true) goto L12;
        Cursor r2 = getCursor(r1);
        if (r2 == null) goto L12;
        if (r2.moveToFirst() == false) goto L12;
        return getContactUri(r1, r2);
    L12:
        r1 = r1 + 1;
        goto L3
    L15:
        return null;
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    public void changeCursor(int r1, Cursor r2) {
        super.changeCursor(r1, r2);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getCount() <= 0) goto L13;
        r2.moveToFirst();
        int r3 = r2.getInt(7);
        boolean r4 = true;
        if (r3 == 1) goto L10;
        r4 = false;
    L10:
        setProfileExists(r4);
        return;
    }

    protected final String[] getProjection(boolean r2) {
        int r1 = getContactNameDisplayOrder();
        if (r2 == false) goto L9;
        if (r1 != 1) goto L8;
        return ContactQuery.access$000();
    L8:
        return ContactQuery.access$100();
    L9:
        if (r1 != 1) goto L13;
        return ContactQuery.access$200();
    L13:
        return ContactQuery.access$300();
    }
}
