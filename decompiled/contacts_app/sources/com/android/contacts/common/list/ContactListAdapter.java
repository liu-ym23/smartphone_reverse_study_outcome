package com.android.contacts.common.list;

import android.accounts.Account;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.ContactSaveService;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.ContactsCompat;
import com.android.contacts.util.Constants;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactListAdapter extends ContactEntryListAdapter {
    private ContactListItemView.PhotoPosition mPhotoPosition;
    private long mSelectedContactDirectoryId;
    private long mSelectedContactId;
    private String mSelectedContactLookupKey;
    private CharSequence mUnknownNameText;

    protected static class ContactQuery {
        public static final int CONTACT_ACCOUNT_NAME = 10;
        public static final int CONTACT_ACCOUNT_TYPE = 9;
        public static final int CONTACT_CONTACT_STATUS = 3;
        public static final int CONTACT_DISPLAY_NAME = 1;
        public static final int CONTACT_ID = 0;
        public static final int CONTACT_IS_USER_PROFILE = 7;
        public static final int CONTACT_LAST_TIME_CONTACTED = 11;
        public static final int CONTACT_LOOKUP_KEY = 6;
        public static final int CONTACT_PHONETIC_NAME = 8;
        public static final int CONTACT_PHOTO_ID = 4;
        public static final int CONTACT_PHOTO_URI = 5;
        public static final int CONTACT_PRESENCE_STATUS = 2;
        private static final String[] CONTACT_PROJECTION_ALTERNATIVE = null;
        private static final String[] CONTACT_PROJECTION_PRIMARY = null;
        public static final int CONTACT_SNIPPET = 13;
        public static final int CONTACT_STARRED = 12;
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
            CONTACT_PROJECTION_PRIMARY = new String[]{"_id", "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "phonetic_name", "account_type", "account_name"};
            CONTACT_PROJECTION_ALTERNATIVE = new String[]{"_id", "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "phonetic_name", "account_type", "account_name"};
            FILTER_PROJECTION_PRIMARY = new String[]{"_id", "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "phonetic_name", "account_type", "account_name", "last_time_contacted", ContactSaveService.EXTRA_STARRED_FLAG, Constants.SNIPPET};
            FILTER_PROJECTION_ALTERNATIVE = new String[]{"_id", "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "phonetic_name", "account_type", "account_name", "last_time_contacted", ContactSaveService.EXTRA_STARRED_FLAG, Constants.SNIPPET};
        }
    }

    public ContactListAdapter(Context r2) {
        super(r2);
        this.mUnknownNameText = r2.getText(R.string.missing_name);
    }

    public void setPhotoPosition(ContactListItemView.PhotoPosition r1) {
        this.mPhotoPosition = r1;
    }

    public ContactListItemView.PhotoPosition getPhotoPosition() {
        return this.mPhotoPosition;
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
        return r2.buildUpon().appendQueryParameter("android.provider.extra.ADDRESS_BOOK_INDEX", "true").build();
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
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
        if (r6 != null) goto L5;
        return r6;
    L5:
        if (r3 != 0) goto L7;
        return r6;
    L7:
        return r6.buildUpon().appendQueryParameter("directory", String.valueOf(r3)).build();
    }

    public boolean isEnterpriseContact(int r1) {
        Cursor r0 = (Cursor) getItem(r1);
        if (r0 != null) goto L5;
        return false;
    L5:
        return ContactsCompat.isEnterpriseContactId(r0.getLong(0));
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

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        ContactListItemView r6 = (ContactListItemView) super.newView(r1, r2, r3, r4, r5);
        r6.setUnknownNameText(this.mUnknownNameText);
        r6.setQuickContactEnabled(isQuickContactEnabled());
        r6.setAdjustSelectionBoundsEnabled(isAdjustSelectionBoundsEnabled());
        r6.setActivatedStateSupported(isSelectionVisible());
        ContactListItemView.PhotoPosition r0 = this.mPhotoPosition;
        if (r0 == null) goto L5;
        r6.setPhotoPosition(r0);
    L5:
        return r6;
    }

    protected void bindSectionHeaderAndDivider(ContactListItemView r1, int r2, Cursor r3) {
        r1.setIsSectionHeaderEnabled(isSectionHeaderDisplayEnabled());
        if (isSectionHeaderDisplayEnabled() == false) goto L5;
        r1.setSectionHeader(getItemPlacementInSection(r2).sectionHeader);
        return;
    L5:
        r1.setSectionHeader(null);
    }

    protected void bindPhoto(ContactListItemView r20, int r21, Cursor r22) {
        if (isPhotoSupported(r21) == true) goto L7;
        r20.removePhotoView();
        return;
    L7:
        if (r22.isNull(4) == true) goto L9;
        long r10 = r22.getLong(4);
    L10:
        ContactPhotoManager.DefaultImageRequest r6 = null;
        if (r22.isNull(9) == false) goto L13;
    L15:
        Account r15 = null;
    L17:
        if (r10 == 0) goto L19;
        getPhotoLoader().loadThumbnail(r20.getPhotoView(), r10, r15, false, getCircularPhotos(), null);
        return;
    L19:
        String r1 = r22.getString(5);
        if (r1 != null) goto L22;
        Uri r14 = null;
    L23:
        if (r14 != null) goto L25;
        r6 = getDefaultImageRequestFromCursor(r22, 1, 6);
    L25:
        getPhotoLoader().loadDirectoryPhoto(r20.getPhotoView(), r14, r15, false, getCircularPhotos(), r6);
        return;
    L22:
        r14 = Uri.parse(r1);
        goto L23
    L13:
        if (r22.isNull(10) == true) goto L15;
        r15 = new Account(r22.getString(10), r22.getString(9));
        goto L17
    L9:
        r10 = 0;
        goto L10
    }

    protected void bindName(ContactListItemView r2, Cursor r3) {
        r2.showDisplayName(r3, 1, getContactNameDisplayOrder());
    }

    protected void bindNameAndViewId(ContactListItemView r3, Cursor r4) {
        r3.showDisplayName(r4, 1, getContactNameDisplayOrder());
        bindViewId(r3, r4, 0);
    }

    protected void bindPresenceAndStatusMessage(ContactListItemView r2, Cursor r3) {
        r2.showPresenceAndStatusMessage(r3, 2, 3);
    }

    protected void bindSearchSnippet(ContactListItemView r1, Cursor r2) {
        r1.showSnippet(r2, 13);
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

    public TreeSet<Long> getAllVisibleContactIds() {
        TreeSet<Long> r0 = new TreeSet();
        int r1 = getPartitionCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L16;
        if (((DirectoryPartition) getPartition(r3)).isLoading() == true) goto L15;
        Cursor r4 = getCursor(r3);
        if (r4 == null) goto L15;
        if (r4.moveToFirst() == false) goto L15;
    L13:
        r0.add(Long.valueOf(r4.getLong(0)));
        if (r4.moveToNext() == true) goto L13;
    L15:
        r3 = r3 + 1;
        goto L3
    L16:
        return r0;
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

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    public void changeCursor(int r1, Cursor r2) {
        super.changeCursor(r1, r2);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.moveToFirst() == false) goto L13;
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
