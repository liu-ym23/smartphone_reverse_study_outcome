package com.android.contacts.common.list;

import android.accounts.Account;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.QuickContactBadge;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import com.GlobalProxyLancet;
import com.android.common.widget.CompositeCursorAdapter;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.ContactsUtils;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.CompatUtils;
import com.android.contacts.common.compat.DirectoryCompat;
import com.android.contacts.common.util.SearchUtil;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactEntryListAdapter extends IndexerListAdapter {
    public static final boolean LOCAL_INVISIBLE_DIRECTORY_ENABLED = false;
    private static final String TAG = "ContactEntryListAdapter";
    private boolean mAdjustSelectionBoundsEnabled;
    private boolean mCircularPhotos;
    private boolean mDarkTheme;
    private CharSequence mDefaultFilterHeaderText;
    private int mDirectoryResultLimit;
    private int mDirectorySearchMode;
    private int mDisplayOrder;
    private boolean mDisplayPhotos;
    private boolean mEmptyListEnabled;
    private ContactListFilter mFilter;
    private View mFragmentRootView;
    private boolean mIncludeProfile;
    private ContactPhotoManager mPhotoLoader;
    private boolean mProfileExists;
    private String mQueryString;
    private boolean mQuickContactEnabled;
    private boolean mSearchMode;
    private boolean mSelectionVisible;
    private int mSortOrder;
    private String mUpperCaseQueryString;

    public abstract void configureLoader(CursorLoader r1, long r2);

    public abstract String getContactDisplayName(int r1);

    protected boolean getExtraStartingSection() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public ContactEntryListAdapter(Context r2) {
        super(r2);
        this.mCircularPhotos = true;
        this.mDirectoryResultLimit = Integer.MAX_VALUE;
        this.mEmptyListEnabled = true;
        this.mDarkTheme = false;
        setDefaultFilterHeaderText(R.string.common_all_contacts);
        addPartitions();
    }

    protected void setFragmentRootView(View r1) {
        this.mFragmentRootView = r1;
    }

    protected void setDefaultFilterHeaderText(int r2) {
        this.mDefaultFilterHeaderText = getContext().getResources().getText(r2);
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        ContactListItemView r6 = new ContactListItemView(r1, null);
        r6.setIsSectionHeaderEnabled(isSectionHeaderDisplayEnabled());
        r6.setAdjustSelectionBoundsEnabled(isAdjustSelectionBoundsEnabled());
        return r6;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r1, int r2, Cursor r3, int r4) {
        ContactListItemView r5 = (ContactListItemView) r1;
        r5.setIsSectionHeaderEnabled(isSectionHeaderDisplayEnabled());
        bindWorkProfileIcon(r5, r2);
    }

    @Override // com.android.contacts.common.list.IndexerListAdapter
    protected View createPinnedSectionHeaderView(Context r2, ViewGroup r3) {
        return new ContactListPinnedHeaderView(r2, null, r3);
    }

    @Override // com.android.contacts.common.list.IndexerListAdapter
    protected void setPinnedSectionTitle(View r1, String r2) {
        ((ContactListPinnedHeaderView) r1).setSectionHeaderTitle(r2);
    }

    protected void addPartitions() {
        addPartition(createDefaultDirectoryPartition());
    }

    protected DirectoryPartition createDefaultDirectoryPartition() {
        DirectoryPartition r0 = new DirectoryPartition(true, true);
        r0.setDirectoryId(0);
        r0.setDirectoryType(getContext().getString(R.string.common_contacts));
        r0.setPriorityDirectory(true);
        r0.setPhotoSupported(true);
        r0.setLabel(this.mDefaultFilterHeaderText.toString());
        return r0;
    }

    public void removeDirectoriesAfterDefault() {
        int r0 = getPartitionCount() - 1;
    L3:
        if (r0 < 0) goto L10;
        CompositeCursorAdapter.Partition r1 = getPartition(r0);
        if ((r1 instanceof DirectoryPartition) == false) goto L9;
        if (((DirectoryPartition) r1).getDirectoryId() != 0) goto L9;
        return;
    L9:
        removePartition(r0);
        r0 = r0 - 1;
        goto L3
    }

    protected int getPartitionByDirectoryId(long r5) {
        int r0 = getPartitionCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        CompositeCursorAdapter.Partition r2 = getPartition(r1);
        if ((r2 instanceof DirectoryPartition) == false) goto L9;
        if (((DirectoryPartition) r2).getDirectoryId() != r5) goto L9;
        return r1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return -1;
    }

    protected DirectoryPartition getDirectoryById(long r6) {
        int r0 = getPartitionCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        CompositeCursorAdapter.Partition r2 = getPartition(r1);
        if ((r2 instanceof DirectoryPartition) == false) goto L9;
        DirectoryPartition r3 = (DirectoryPartition) r2;
        if (r3.getDirectoryId() != r6) goto L9;
        return r3;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    public void onDataReload() {
        int r0 = getPartitionCount();
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L11;
        CompositeCursorAdapter.Partition r4 = getPartition(r2);
        if ((r4 instanceof DirectoryPartition) == false) goto L10;
        DirectoryPartition r5 = (DirectoryPartition) r4;
        if (r5.isLoading() == true) goto L9;
        r3 = true;
    L9:
        r5.setStatus(0);
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        if (r3 == false) goto L17;
        notifyDataSetChanged();
        return;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    public void clearPartitions() {
        int r0 = getPartitionCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        CompositeCursorAdapter.Partition r3 = getPartition(r2);
        if ((r3 instanceof DirectoryPartition) == false) goto L7;
        ((DirectoryPartition) r3).setStatus(0);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        super.clearPartitions();
    }

    public boolean isSearchMode() {
        return this.mSearchMode;
    }

    public void setSearchMode(boolean r1) {
        this.mSearchMode = r1;
    }

    public String getQueryString() {
        return this.mQueryString;
    }

    public void setQueryString(String r2) {
        this.mQueryString = r2;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        this.mUpperCaseQueryString = null;
        return;
    L5:
        this.mUpperCaseQueryString = SearchUtil.cleanStartAndEndOfSearchQuery(r2.toUpperCase());
    }

    public String getUpperCaseQueryString() {
        return this.mUpperCaseQueryString;
    }

    public int getDirectorySearchMode() {
        return this.mDirectorySearchMode;
    }

    public void setDirectorySearchMode(int r1) {
        this.mDirectorySearchMode = r1;
    }

    public int getDirectoryResultLimit() {
        return this.mDirectoryResultLimit;
    }

    public int getDirectoryResultLimit(DirectoryPartition r2) {
        int r3 = r2.getResultLimit();
        if (r3 == (-1)) goto L5;
        return r3;
    L5:
        return this.mDirectoryResultLimit;
    }

    public void setDirectoryResultLimit(int r1) {
        this.mDirectoryResultLimit = r1;
    }

    public int getContactNameDisplayOrder() {
        return this.mDisplayOrder;
    }

    public void setContactNameDisplayOrder(int r1) {
        this.mDisplayOrder = r1;
    }

    public int getSortOrder() {
        return this.mSortOrder;
    }

    public void setSortOrder(int r1) {
        this.mSortOrder = r1;
    }

    public void setPhotoLoader(ContactPhotoManager r1) {
        this.mPhotoLoader = r1;
    }

    protected ContactPhotoManager getPhotoLoader() {
        return this.mPhotoLoader;
    }

    public boolean getDisplayPhotos() {
        return this.mDisplayPhotos;
    }

    public void setDisplayPhotos(boolean r1) {
        this.mDisplayPhotos = r1;
    }

    public boolean getCircularPhotos() {
        return this.mCircularPhotos;
    }

    public void setCircularPhotos(boolean r1) {
        this.mCircularPhotos = r1;
    }

    public boolean isEmptyListEnabled() {
        return this.mEmptyListEnabled;
    }

    public void setEmptyListEnabled(boolean r1) {
        this.mEmptyListEnabled = r1;
    }

    public boolean isSelectionVisible() {
        return this.mSelectionVisible;
    }

    public void setSelectionVisible(boolean r1) {
        this.mSelectionVisible = r1;
    }

    public boolean isQuickContactEnabled() {
        return this.mQuickContactEnabled;
    }

    public void setQuickContactEnabled(boolean r1) {
        this.mQuickContactEnabled = r1;
    }

    public boolean isAdjustSelectionBoundsEnabled() {
        return this.mAdjustSelectionBoundsEnabled;
    }

    public void setAdjustSelectionBoundsEnabled(boolean r1) {
        this.mAdjustSelectionBoundsEnabled = r1;
    }

    public boolean shouldIncludeProfile() {
        return this.mIncludeProfile;
    }

    public void setIncludeProfile(boolean r1) {
        this.mIncludeProfile = r1;
    }

    public void setProfileExists(boolean r2) {
        this.mProfileExists = r2;
        if (r2 == false) goto L8;
        SectionIndexer r3 = getIndexer();
        if (r3 == null) goto L9;
        ((ContactsSectionIndexer) r3).setProfileHeader(getContext().getString(R.string.common_i));
        return;
    L9:
        return;
    }

    public boolean hasProfile() {
        return this.mProfileExists;
    }

    public void setDarkTheme(boolean r1) {
        this.mDarkTheme = r1;
    }

    public void changeDirectories(Cursor r13) {
        if (r13.getCount() != 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Directory search loader returned an empty cursor, which implies we have no directory entries.", new RuntimeException());
        return;
    L6:
        HashSet r0 = new HashSet();
        int r1 = r13.getColumnIndex("_id");
        int r2 = r13.getColumnIndex("directoryType");
        int r3 = r13.getColumnIndex("displayName");
        int r4 = r13.getColumnIndex("photoSupport");
        r13.moveToPosition(-1);
    L8:
        if (r13.moveToNext() == false) goto L27;
        long r6 = r13.getLong(r1);
        r0.add(Long.valueOf(r6));
        if (getPartitionByDirectoryId(r6) != (-1)) goto L8;
        boolean r9 = false;
        DirectoryPartition r8 = new DirectoryPartition(false, true);
        r8.setDirectoryId(r6);
        if (DirectoryCompat.isRemoteDirectoryId(r6) == false) goto L18;
        if (DirectoryCompat.isEnterpriseDirectoryId(r6) == false) goto L16;
        r8.setLabel(this.mContext.getString(R.string.directory_search_label_work));
    L21:
        r8.setDirectoryType(r13.getString(r2));
        r8.setDisplayName(r13.getString(r3));
        int r7 = r13.getInt(r4);
        if (r7 != 1) goto L24;
    L25:
        r9 = true;
    L26:
        r8.setPhotoSupported(r9);
        addPartition(r8);
        goto L8
    L24:
        if (r7 != 3) goto L26;
    L16:
        r8.setLabel(this.mContext.getString(R.string.directory_search_label));
        goto L21
    L18:
        if (DirectoryCompat.isEnterpriseDirectoryId(r6) == false) goto L20;
        r8.setLabel(this.mContext.getString(R.string.list_filter_phones_work));
        goto L21
    L20:
        r8.setLabel(this.mDefaultFilterHeaderText.toString());
        goto L21
    L27:
        int r14 = getPartitionCount();
    L28:
        r14 = r14 - 1;
        if (r14 < 0) goto L35;
        CompositeCursorAdapter.Partition r5 = getPartition(r14);
        if ((r5 instanceof DirectoryPartition) == false) goto L28;
        if (r0.contains(Long.valueOf(((DirectoryPartition) r5).getDirectoryId())) == true) goto L28;
        removePartition(r14);
        goto L28
    L35:
        invalidate();
        notifyDataSetChanged();
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    public void changeCursor(int r3, Cursor r4) {
        if (r3 < getPartitionCount()) goto L5;
        return;
    L5:
        CompositeCursorAdapter.Partition r0 = getPartition(r3);
        if ((r0 instanceof DirectoryPartition) == false) goto L9;
        ((DirectoryPartition) r0).setStatus(2);
    L9:
        if (this.mDisplayPhotos == true) goto L11;
    L15:
        super.changeCursor(r3, r4);
        if (isSectionHeaderDisplayEnabled() == true) goto L18;
    L20:
        this.mPhotoLoader.cancelPendingRequests(this.mFragmentRootView);
        return;
    L18:
        if (r3 != getIndexedPartition()) goto L20;
        updateIndexer(r4);
        goto L20
    L11:
        if (this.mPhotoLoader == null) goto L15;
        if (isPhotoSupported(r3) == false) goto L15;
        this.mPhotoLoader.refreshCache();
        goto L15
    }

    public void changeCursor(Cursor r2) {
        changeCursor(0, r2);
    }

    private void updateIndexer(Cursor r9) {
        if (r9 != null) goto L5;
    L21:
        setIndexer(null);
        return;
    L5:
        if (r9.isClosed() == true) goto L21;
        Bundle r10 = r9.getExtras();
        if (r10.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES") == true) goto L10;
    L19:
        setIndexer(null);
        return;
    L10:
        if (r10.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS") == false) goto L19;
        String[] r0 = r10.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES");
        int[] r11 = r10.getIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS");
        if (getExtraStartingSection() == false) goto L18;
        String[] r1 = new String[r0.length + 1];
        int[] r3 = new int[r11.length + 1];
        int r5 = 0;
    L15:
        if (r5 >= r0.length) goto L17;
        int r6 = r5 + 1;
        r1[r6] = r0[r5];
        r3[r6] = r11[r5];
        r5 = r6;
        goto L15
    L17:
        r3[0] = 1;
        r1[0] = "";
        setIndexer(new ContactsSectionIndexer(r1, r3));
        return;
    L18:
        setIndexer(new ContactsSectionIndexer(r0, r11));
    }

    @Override // com.android.common.widget.CompositeCursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return (getItemViewTypeCount() * 2) + 1;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    public int getItemViewType(int r3, int r4) {
        int r0 = super.getItemViewType(r3, r4);
        if (isUserProfile(r4) == false) goto L5;
        return r0;
    L5:
        if (isSectionHeaderDisplayEnabled() == true) goto L7;
        return r0;
    L7:
        if (r3 == getIndexedPartition()) goto L9;
        return r0;
    L9:
        if (getItemPlacementInSection(r4).firstInSection == false) goto L12;
        return r0;
    L12:
        return r0 + getItemViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (this.mEmptyListEnabled == true) goto L7;
        return false;
    L7:
        if (isSearchMode() == false) goto L11;
        return TextUtils.isEmpty(getQueryString());
    L11:
        return super.isEmpty();
    }

    public boolean isLoading() {
        int r0 = getPartitionCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        CompositeCursorAdapter.Partition r3 = getPartition(r2);
        if ((r3 instanceof DirectoryPartition) == false) goto L10;
        if (((DirectoryPartition) r3).isLoading() == false) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    public boolean areAllPartitionsEmpty() {
        int r0 = getPartitionCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (isPartitionEmpty(r2) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public void configureDefaultPartition(boolean r8, boolean r9) {
        int r0 = getPartitionCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L11;
        CompositeCursorAdapter.Partition r3 = getPartition(r1);
        if ((r3 instanceof DirectoryPartition) == false) goto L10;
        if (((DirectoryPartition) r3).getDirectoryId() != 0) goto L10;
    L12:
        if (r1 == (-1)) goto L19;
        setShowIfEmpty(r1, r8);
        setHasHeader(r1, r9);
        return;
    L19:
        return;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        r1 = -1;
        goto L12
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected View newHeaderView(Context r1, int r2, Cursor r3, ViewGroup r4) {
        View r5 = LayoutInflater.from(r1).inflate(R.layout.directory_header, r4, false);
        if (getPinnedPartitionHeadersEnabled() == true) goto L5;
        r5.setBackground(null);
    L5:
        return r5;
    }

    protected void bindWorkProfileIcon(ContactListItemView r5, int r6) {
        CompositeCursorAdapter.Partition r4 = getPartition(r6);
        if ((r4 instanceof DirectoryPartition) == true) goto L5;
        return;
    L5:
        if (ContactsUtils.determineUserType(Long.valueOf(((DirectoryPartition) r4).getDirectoryId()), null) != 1) goto L7;
        boolean r7 = true;
    L8:
        r5.setWorkProfileIconEnabled(r7);
        return;
    L7:
        r7 = false;
        goto L8
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected void bindHeaderView(View r6, int r7, Cursor r8) {
        CompositeCursorAdapter.Partition r9 = getPartition(r7);
        if ((r9 instanceof DirectoryPartition) == true) goto L5;
        return;
    L5:
        DirectoryPartition r10 = (DirectoryPartition) r9;
        long r0 = r10.getDirectoryId();
        TextView r2 = (TextView) r6.findViewById(R.id.label);
        TextView r3 = (TextView) r6.findViewById(R.id.display_name);
        r2.setText(r10.getLabel());
        if (DirectoryCompat.isRemoteDirectoryId(r0) == true) goto L8;
        r3.setText(null);
    L13:
        Resources r11 = getContext().getResources();
        if (r7 != 1) goto L18;
        int r12 = 0;
        if (getPartition(0).isEmpty() == false) goto L18;
    L19:
        r6.setPaddingRelative(r6.getPaddingStart(), r12, r6.getPaddingEnd(), r6.getPaddingBottom());
        return;
    L18:
        r12 = r11.getDimensionPixelOffset(R.dimen.directory_header_extra_top_padding);
        goto L19
    L8:
        String r1 = r10.getDisplayName();
        if (TextUtils.isEmpty(r1) == false) goto L12;
        r1 = r10.getDirectoryType();
    L12:
        r3.setText(r1);
        goto L13
    }

    protected int getResultCount(Cursor r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.getCount();
    }

    protected boolean isUserProfile(int r4) {
        boolean r0 = false;
        if (r4 != 0) goto L14;
        int r1 = getPartitionForPosition(r4);
        if (r1 < 0) goto L14;
        int r2 = getCursor(r1).getPosition();
        Cursor r3 = (Cursor) getItem(r4);
        if (r3 == null) goto L14;
        int r5 = r3.getColumnIndex("is_user_profile");
        if (r5 != (-1)) goto L11;
    L13:
        r3.moveToPosition(r2);
        goto L14
    L11:
        if (r3.getInt(r5) != 1) goto L13;
        r0 = true;
    L14:
        return r0;
    }

    public String getQuantityText(int r1, int r2, int r3) {
        if (r1 != 0) goto L6;
        return getContext().getString(r2);
    L6:
        return String.format(getContext().getResources().getQuantityText(r3, r1).toString(), new Object[]{Integer.valueOf(r1)});
    }

    public boolean isPhotoSupported(int r1) {
        CompositeCursorAdapter.Partition r0 = getPartition(r1);
        if ((r0 instanceof DirectoryPartition) == true) goto L5;
        return true;
    L5:
        return ((DirectoryPartition) r0).isPhotoSupported();
    }

    public ContactListFilter getFilter() {
        return this.mFilter;
    }

    public void setFilter(ContactListFilter r1) {
        this.mFilter = r1;
    }

    protected void bindQuickContact(ContactListItemView r14, int r15, Cursor r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23) {
        if (r16.isNull(r17) == true) goto L5;
        long r9 = r16.getLong(r17);
    L6:
        ContactPhotoManager.DefaultImageRequest r11 = null;
        if (r16.isNull(r22) == false) goto L9;
    L11:
        Account r6 = null;
    L12:
        QuickContactBadge r4 = r14.getQuickContact();
        r4.assignContactUri(getContactUri(r15, r16, r19, r20));
        if (CompatUtils.hasPrioritizedMimeType() == false) goto L16;
        r4.setPrioritizedMimeType("vnd.android.cursor.item/phone_v2");
    L16:
        if (r9 == 0) goto L18;
    L27:
        getPhotoLoader().loadThumbnail(r4, r9, r6, this.mDarkTheme, this.mCircularPhotos, null);
        return;
    L18:
        if (r18 == (-1)) goto L27;
        String r2 = r16.getString(r18);
        if (r2 != null) goto L23;
        Uri r3 = null;
    L24:
        if (r3 != null) goto L26;
        r11 = getDefaultImageRequestFromCursor(r16, r21, r20);
    L26:
        getPhotoLoader().loadPhoto(r4, r3, r6, -1, this.mDarkTheme, this.mCircularPhotos, r11);
        return;
    L23:
        r3 = Uri.parse(r2);
        goto L24
    L9:
        if (r16.isNull(r23) == true) goto L11;
        r6 = new Account(r16.getString(r23), r16.getString(r22));
        goto L12
    L5:
        r9 = 0;
        goto L6
    }

    protected void bindViewId(ContactListItemView r3, Cursor r4, int r5) {
        r3.setId((int) (r4.getLong(r5) % 2147483647L));
    }

    protected Uri getContactUri(int r3, Cursor r4, int r5, int r6) {
        long r0 = r4.getLong(r5);
        String r7 = r4.getString(r6);
        long r2 = ((DirectoryPartition) getPartition(r3)).getDirectoryId();
        Uri r8 = ContactsContract.Contacts.getLookupUri(r0, r7);
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (r2 != 0) goto L7;
        return r8;
    L7:
        return r8.buildUpon().appendQueryParameter("directory", String.valueOf(r2)).build();
    }

    public ContactPhotoManager.DefaultImageRequest getDefaultImageRequestFromCursor(Cursor r1, int r2, int r3) {
        return new ContactPhotoManager.DefaultImageRequest(r1.getString(r2), r1.getString(r3), this.mCircularPhotos);
    }
}
