package com.android.contacts.common.list;

import android.accounts.Account;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.loader.content.CursorLoader;
import com.GlobalProxyLancet;
import com.android.contacts.common.CallUtil;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.ContactsUtils;
import com.android.contacts.common.GeoUtil;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.CallableCompat;
import com.android.contacts.common.compat.CompatUtils;
import com.android.contacts.common.compat.DirectoryCompat;
import com.android.contacts.common.compat.PhoneCompat;
import com.android.contacts.common.extensions.ExtendedPhoneDirectoriesManager;
import com.android.contacts.common.extensions.ExtensionsFactory;
import com.android.contacts.pick.PickerFragment;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PhoneNumberListAdapter extends ContactEntryListAdapter {
    private static final String IGNORE_NUMBER_TOO_LONG_CLAUSE = "length(data1) < 1000";
    private static final String TAG = "PhoneNumberListAdapter";
    private final String mCountryIso;
    private final List<DirectoryPartition> mExtendedDirectories;
    private long mFirstExtendedDirectoryId;
    private boolean mIsPresenceEnabled;
    private boolean mIsVideoEnabled;
    private Listener mListener;
    private ContactListItemView.PhotoPosition mPhotoPosition;
    private final CharSequence mUnknownNameText;
    private boolean mUseCallableUri;

    public interface Listener {
        void onVideoCallIconClicked(int r1);
    }

    public static class PhoneQuery {
        public static final String ANALYTICS_ACTION = "analytics_action";
        public static final String ANALYTICS_CATEGORY = "analytics_category";
        public static final String ANALYTICS_VALUE = "analytics_value";
        public static final int CARRIER_PRESENCE = 11;
        public static final int CONTACT_ID = 4;
        public static final int DISPLAY_NAME = 7;
        public static final int LOOKUP_KEY = 5;
        public static final int PHONE_ACCOUNT_NAME = 10;
        public static final int PHONE_ACCOUNT_TYPE = 9;
        public static final int PHONE_ID = 0;
        public static final int PHONE_LABEL = 2;
        public static final int PHONE_NUMBER = 3;
        public static final int PHONE_TYPE = 1;
        public static final int PHOTO_ID = 6;
        public static final int PHOTO_URI = 8;
        public static final String[] PROJECTION_ALTERNATIVE = null;
        public static final String[] PROJECTION_ALTERNATIVE_INTERNAL = null;
        public static final String[] PROJECTION_PRIMARY = null;
        public static final String[] PROJECTION_PRIMARY_INTERNAL = null;

        public PhoneQuery() {
        }

        static {
            String[] r0 = {"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name", "photo_thumb_uri", "account_type", "account_name"};
            PROJECTION_PRIMARY_INTERNAL = r0;
            ArrayList r1 = Lists.newArrayList(r0);
            if (CompatUtils.isMarshmallowCompatible() == false) goto L5;
            r1.add("carrier_presence");
        L5:
            PROJECTION_PRIMARY = (String[]) r1.toArray(new String[r1.size()]);
            String[] r2 = {"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name_alt", "photo_thumb_uri", "account_type", "account_name"};
            PROJECTION_ALTERNATIVE_INTERNAL = r2;
            ArrayList r3 = Lists.newArrayList(r2);
            if (CompatUtils.isMarshmallowCompatible() == false) goto L8;
            r3.add("carrier_presence");
        L8:
            PROJECTION_ALTERNATIVE = (String[]) r3.toArray(new String[r3.size()]);
        }
    }

    static {
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected /* bridge */ /* synthetic */ View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        return newView(r1, r2, r3, r4, r5);
    }

    public PhoneNumberListAdapter(Context r4) {
        super(r4);
        this.mFirstExtendedDirectoryId = Long.MAX_VALUE;
        setDefaultFilterHeaderText(R.string.list_filter_phones);
        this.mUnknownNameText = r4.getText(android.R.string.unknownName);
        this.mCountryIso = GeoUtil.getCurrentCountryIso(r4);
        ExtendedPhoneDirectoriesManager r0 = ExtensionsFactory.getExtendedPhoneDirectoriesManager();
        if (r0 == null) goto L5;
        this.mExtendedDirectories = r0.getExtendedDirectories(this.mContext);
    L6:
        int r5 = CallUtil.getVideoCallingAvailability(r4);
        boolean r1 = false;
        if ((r5 & 1) == 0) goto L9;
        boolean r2 = true;
    L10:
        this.mIsVideoEnabled = r2;
        if ((r5 & 2) == 0) goto L13;
        r1 = true;
    L13:
        this.mIsPresenceEnabled = r1;
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        this.mExtendedDirectories = new ArrayList();
        goto L6
    }

    protected CharSequence getUnknownNameText() {
        return this.mUnknownNameText;
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r13, long r14) {
        String r0 = getQueryString();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (isExtendedDirectory(r14) == false) goto L12;
        DirectoryPartition r15 = getExtendedDirectoryFromId(r14);
        String r16 = r15.getContentUri();
        if (r16 == null) goto L11;
        Uri.Builder r17 = Uri.parse(r16).buildUpon();
        r17.appendPath(r0);
        r17.appendQueryParameter("limit", String.valueOf(getDirectoryResultLimit(r15)));
        r13.setUri(r17.build());
        r13.setProjection(PhoneQuery.PROJECTION_PRIMARY);
        return;
    L11:
        throw new IllegalStateException("Extended directory must have a content URL: " + r15);
    L12:
        boolean r1 = DirectoryCompat.isRemoteDirectoryId(r14);
        if (isSearchMode() == false) goto L24;
        if (r1 == false) goto L17;
        Uri r3 = PhoneCompat.getContentFilterUri();
    L20:
        Uri.Builder r4 = r3.buildUpon();
        r4.appendPath(r0);
        r4.appendQueryParameter("directory", String.valueOf(r14));
        if (r1 == false) goto L31;
        r4.appendQueryParameter("limit", String.valueOf(getDirectoryResultLimit(getDirectoryById(r14))));
    L31:
        String r18 = r13.getSelection();
        if (TextUtils.isEmpty(r18) == true) goto L34;
        String r19 = r18 + " AND length(data1) < 1000";
    L35:
        r13.setSelection(r19);
        r4.appendQueryParameter("remove_duplicate_entries", "true");
        r13.setUri(r4.build());
        if (getContactNameDisplayOrder() != 1) goto L38;
        r13.setProjection(PhoneQuery.PROJECTION_PRIMARY);
    L40:
        if (getSortOrder() != 1) goto L42;
        r13.setSortOrder(PickerFragment.CONTACT_SORT_CNAME);
        return;
    L42:
        r13.setSortOrder("sort_key_alt");
        return;
    L38:
        r13.setProjection(PhoneQuery.PROJECTION_ALTERNATIVE);
        goto L40
    L34:
        r19 = IGNORE_NUMBER_TOO_LONG_CLAUSE;
        goto L35
    L17:
        if (this.mUseCallableUri == false) goto L19;
        r3 = CallableCompat.getContentFilterUri();
        goto L20
    L19:
        r3 = PhoneCompat.getContentFilterUri();
        goto L20
    L24:
        if (this.mUseCallableUri == false) goto L26;
        Uri r2 = ContactsContract.CommonDataKinds.Callable.CONTENT_URI;
    L27:
        r4 = r2.buildUpon().appendQueryParameter("directory", String.valueOf(0));
        if (isSectionHeaderDisplayEnabled() == false) goto L30;
        r4.appendQueryParameter("android.provider.extra.ADDRESS_BOOK_INDEX", "true");
    L30:
        applyFilter(r13, r4, r14, getFilter());
        goto L31
    L26:
        r2 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        goto L27
    }

    protected boolean isExtendedDirectory(long r3) {
        if (r3 < this.mFirstExtendedDirectoryId) goto L5;
        return true;
    L5:
        return false;
    }

    private DirectoryPartition getExtendedDirectoryFromId(long r3) {
        int r4 = (int) (r3 - this.mFirstExtendedDirectoryId);
        return this.mExtendedDirectories.get(r4);
    }

    private void applyFilter(CursorLoader r3, Uri.Builder r4, long r5, ContactListFilter r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r5 != 0) goto L21;
        StringBuilder r2 = new StringBuilder();
        ArrayList r6 = new ArrayList();
        int r8 = r7.filterType;
        if (r8 != (-5)) goto L9;
    L18:
        r3.setSelection(r2.toString());
        r3.setSelectionArgs((String[]) r6.toArray(new String[0]));
        return;
    L9:
        if (r8 != (-3)) goto L11;
        r2.append("in_visible_group=1 AND has_phone_number=1");
        goto L18
    L11:
        if (r8 == (-2)) goto L18;
        if (r8 == (-1)) goto L18;
        if (r8 == 0) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unsupported filter type came (type: " + r7.filterType + ", toString: " + r7 + ") showing all contacts.");
        goto L18
    L16:
        r7.addAccountQueryParameterToUrl(r4);
        goto L18
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public String getContactDisplayName(int r1) {
        return ((Cursor) getItem(r1)).getString(7);
    }

    public String getPhoneNumber(int r1) {
        Cursor r0 = (Cursor) getItem(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString(3);
    }

    public Uri getDataUri(int r2) {
        int r0 = getPartitionForPosition(r2);
        Cursor r3 = (Cursor) getItem(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return getDataUri(r0, r3);
    }

    public Uri getDataUri(int r3, Cursor r4) {
        long r2 = ((DirectoryPartition) getPartition(r3)).getDirectoryId();
        if (DirectoryCompat.isRemoteDirectoryId(r2) == false) goto L6;
        return null;
    L6:
        if (DirectoryCompat.isEnterpriseDirectoryId(r2) == false) goto L8;
        return null;
    L8:
        long r5 = r4.getLong(0);
        return ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r5);
    }

    public String getLookupKey(int r1) {
        Cursor r0 = (Cursor) getItem(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString(5);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected ContactListItemView newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        ContactListItemView r6 = (ContactListItemView) super.newView(r1, r2, r3, r4, r5);
        r6.setUnknownNameText(this.mUnknownNameText);
        r6.setQuickContactEnabled(isQuickContactEnabled());
        r6.setPhotoPosition(this.mPhotoPosition);
        return r6;
    }

    protected void setHighlight(ContactListItemView r1, Cursor r2) {
        if (isSearchMode() == false) goto L5;
        String r0 = getUpperCaseQueryString();
    L6:
        r1.setHighlightedPrefix(r0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    protected int getResultCount(Cursor r6) {
        int r5 = 0;
        if (r6 != null) goto L5;
        return 0;
    L5:
        r6.moveToPosition(-1);
        long r0 = -1;
    L7:
        if (r6.moveToNext() == false) goto L11;
        long r2 = r6.getLong(4);
        if (r2 == r0) goto L7;
        r5 = r5 + 1;
        r0 = r2;
        goto L7
    L11:
        return r5;
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r12, int r13, Cursor r14, int r15) {
        super.bindView(r12, r13, r14, r15);
        ContactListItemView r16 = (ContactListItemView) r12;
        setHighlight(r16, r14);
        r14.moveToPosition(r15);
        long r1 = r14.getLong(4);
        if (r14.moveToPrevious() == true) goto L5;
    L9:
        boolean r2 = true;
    L10:
        r14.moveToPosition(r15);
        if (r14.moveToNext() == true) goto L13;
    L15:
        r14.moveToPosition(r15);
        bindViewId(r16, r14, 0);
        bindSectionHeaderAndDivider(r16, r15);
        if (r2 == false) goto L23;
        bindName(r16, r14);
        if (isQuickContactEnabled() == false) goto L21;
        bindQuickContact(r16, r13, r14, 6, 8, 4, 5, 7, 9, 10);
    L24:
        bindPhoneNumber(r16, r14, ((DirectoryPartition) getPartition(r13)).isDisplayNumber(), r15);
        return;
    L21:
        if (getDisplayPhotos() == false) goto L24;
        bindPhoto(r16, r13, r14);
        goto L24
    L23:
        unbindName(r16);
        r16.removePhotoView(true, false);
        goto L24
    L13:
        if (r14.isAfterLast() == true) goto L15;
        r14.getLong(4);
        goto L15
    L5:
        if (r14.isBeforeFirst() == true) goto L9;
        if (r1 != r14.getLong(4)) goto L9;
        r2 = false;
        goto L10
    }

    protected void bindPhoneNumber(ContactListItemView r6, Cursor r7, boolean r8, int r9) {
        boolean r1 = true;
        if (r8 == true) goto L5;
    L7:
        CharSequence r2 = null;
    L8:
        r6.setLabel(r2);
        if (r8 == false) goto L11;
        String r10 = r7.getString(3);
    L15:
        r6.setPhoneNumber(r10, this.mCountryIso);
        if (CompatUtils.isVideoCompatible() == true) goto L18;
        return;
    L18:
        if ((r7.getInt(11) & 1) == 0) goto L20;
        boolean r11 = true;
    L22:
        if (this.mIsVideoEnabled == false) goto L28;
        boolean r0 = this.mIsPresenceEnabled;
        if (r0 == false) goto L26;
        if (r11 == false) goto L26;
    L29:
        r6.setShowVideoCallIcon(r1, this.mListener, r9);
        return;
    L26:
        if (r0 == false) goto L29;
    L28:
        r1 = false;
        goto L29
    L20:
        r11 = false;
        goto L22
    L11:
        r10 = r7.getString(2);
        if (r10 != null) goto L15;
        r10 = GeoUtil.getGeocodedLocationFor(this.mContext, r7.getString(3));
        goto L15
    L5:
        if (r7.isNull(1) == true) goto L7;
        r2 = ContactsContract.CommonDataKinds.Phone.getTypeLabel(getContext().getResources(), r7.getInt(1), r7.getString(2));
        goto L8
    }

    protected void bindSectionHeaderAndDivider(ContactListItemView r3, int r4) {
        String r1 = null;
        if (isSectionHeaderDisplayEnabled() == false) goto L8;
        IndexerListAdapter.Placement r2 = getItemPlacementInSection(r4);
        if (r2.firstInSection == false) goto L7;
        r1 = r2.sectionHeader;
    L7:
        r3.setSectionHeader(r1);
        return;
    L8:
        r3.setSectionHeader(null);
    }

    protected void bindName(ContactListItemView r2, Cursor r3) {
        r2.showDisplayName(r3, 7, getContactNameDisplayOrder());
    }

    protected void unbindName(ContactListItemView r1) {
        r1.hideDisplayName();
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    protected void bindWorkProfileIcon(ContactListItemView r5, int r6) {
        long r0 = ((DirectoryPartition) getPartition(r6)).getDirectoryId();
        long r2 = ContactsUtils.determineUserType(Long.valueOf(r0), null);
        if (isExtendedDirectory(r0) == false) goto L5;
    L7:
        boolean r4 = false;
    L8:
        r5.setWorkProfileIconEnabled(r4);
        return;
    L5:
        if (r2 != 1) goto L7;
        r4 = true;
        goto L8
    }

    protected void bindPhoto(ContactListItemView r20, int r21, Cursor r22) {
        if (isPhotoSupported(r21) == true) goto L7;
        r20.removePhotoView();
        return;
    L7:
        if (r22.isNull(6) == true) goto L9;
        long r10 = r22.getLong(6);
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
        String r1 = r22.getString(8);
        if (r1 != null) goto L22;
        Uri r14 = null;
    L23:
        if (r14 != null) goto L25;
        r6 = new ContactPhotoManager.DefaultImageRequest(r22.getString(7), r22.getString(5), getCircularPhotos());
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

    public void setPhotoPosition(ContactListItemView.PhotoPosition r1) {
        this.mPhotoPosition = r1;
    }

    public ContactListItemView.PhotoPosition getPhotoPosition() {
        return this.mPhotoPosition;
    }

    public void setUseCallableUri(boolean r1) {
        this.mUseCallableUri = r1;
    }

    public boolean usesCallableUri() {
        return this.mUseCallableUri;
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public void changeDirectories(Cursor r12) {
        super.changeDirectories(r12);
        if (getDirectorySearchMode() != 0) goto L5;
        return;
    L5:
        int r0 = this.mExtendedDirectories.size();
        if (getPartitionCount() != (r12.getCount() + r0)) goto L8;
        return;
    L8:
        this.mFirstExtendedDirectoryId = Long.MAX_VALUE;
        if (r0 <= 0) goto L25;
        int r13 = getPartitionCount();
        int r3 = 0;
        long r5 = 1;
        int r4 = 0;
        int r7 = 0;
    L11:
        if (r4 >= r13) goto L19;
        long r8 = ((DirectoryPartition) getPartition(r4)).getDirectoryId();
        if (r8 <= r5) goto L16;
        r5 = r8;
    L16:
        if (DirectoryCompat.isRemoteDirectoryId(r8) == true) goto L18;
        r7 = r4 + 1;
    L18:
        r4 = r4 + 1;
        goto L11
    L19:
        this.mFirstExtendedDirectoryId = r5 + 1;
    L20:
        if (r3 >= r0) goto L32;
        long r1 = this.mFirstExtendedDirectoryId + ((long) r3);
        DirectoryPartition r14 = this.mExtendedDirectories.get(r3);
        if (getPartitionByDirectoryId(r1) != (-1)) goto L24;
        addPartition(r7, r14);
        r14.setDirectoryId(r1);
    L24:
        r3 = r3 + 1;
        goto L20
    L32:
        return;
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    protected Uri getContactUri(int r5, Cursor r6, int r7, int r8) {
        DirectoryPartition r0 = (DirectoryPartition) getPartition(r5);
        long r1 = r0.getDirectoryId();
        if (isExtendedDirectory(r1) == true) goto L7;
        return super.getContactUri(r5, r6, r7, r8);
    L7:
        return ContactsContract.Contacts.CONTENT_LOOKUP_URI.buildUpon().appendPath("encoded").appendQueryParameter("displayName", r0.getLabel()).appendQueryParameter("directory", String.valueOf(r1)).encodedFragment(r6.getString(r8)).build();
    }

    public Listener getListener() {
        return this.mListener;
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }
}
