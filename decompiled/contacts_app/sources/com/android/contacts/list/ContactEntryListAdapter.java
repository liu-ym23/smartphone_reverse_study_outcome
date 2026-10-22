package com.android.contacts.list;

import android.content.Context;
import android.content.CursorLoader;
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
import com.GlobalProxyLancet;
import com.android.common.widget.CompositeCursorAdapter;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.widget.IndexerListAdapter;
import com.android.contacts.widget.TextWithHighlightingFactory;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContactEntryListAdapter extends IndexerListAdapter {
    private static final boolean LOCAL_INVISIBLE_DIRECTORY_ENABLED = false;
    private static final String TAG = "ContactEntryListAdapter";
    private String mContactsCount;
    private boolean mDarkTheme;
    private int mDirectoryResultLimit;
    private int mDirectorySearchMode;
    private int mDisplayOrder;
    private boolean mDisplayPhotos;
    private boolean mEmptyListEnabled;
    private ContactListFilter mFilter;
    private boolean mIncludeProfile;
    private boolean mLoading;
    private boolean mNameHighlightingEnabled;
    private ContactPhotoManager mPhotoLoader;
    private boolean mProfileExists;
    private String mQueryString;
    private boolean mQuickContactEnabled;
    private boolean mSearchMode;
    private boolean mSelectionVisible;
    private int mSortOrder;
    private TextWithHighlightingFactory mTextWithHighlightingFactory;
    private char[] mUpperCaseQueryString;
    private int mViewMode;

    public abstract void configureLoader(CursorLoader r1, long r2);

    public abstract String getContactDisplayName(int r1);

    public ContactEntryListAdapter(Context r1) {
        super(r1);
        this.mDirectoryResultLimit = Integer.MAX_VALUE;
        this.mLoading = true;
        this.mEmptyListEnabled = true;
        this.mContactsCount = "";
        this.mDarkTheme = false;
        addPartitions();
    }

    @Override // com.android.contacts.widget.IndexerListAdapter
    protected View createPinnedSectionHeaderView(Context r1, ViewGroup r2) {
        return new ContactListPinnedHeaderView(r1, null);
    }

    @Override // com.android.contacts.widget.IndexerListAdapter
    protected void setPinnedSectionTitle(View r1, String r2) {
        ((ContactListPinnedHeaderView) r1).setSectionHeader(r2);
    }

    @Override // com.android.contacts.widget.IndexerListAdapter
    protected void setPinnedHeaderContactsCount(View r2) {
        if (this.mProfileExists == false) goto L5;
        ((ContactListPinnedHeaderView) r2).setCountView(this.mContactsCount);
        return;
    L5:
        clearPinnedHeaderContactsCount(r2);
    }

    @Override // com.android.contacts.widget.IndexerListAdapter
    protected void clearPinnedHeaderContactsCount(View r1) {
        ((ContactListPinnedHeaderView) r1).setCountView(null);
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
        return r0;
    }

    private int getPartitionByDirectoryId(long r5) {
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
        this.mUpperCaseQueryString = r2.toUpperCase().toCharArray();
    }

    public char[] getUpperCaseQueryString() {
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

    public int getViewMode() {
        return this.mViewMode;
    }

    public void setViewMode(int r1) {
        this.mViewMode = r1;
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

    public void configureDirectoryLoader(DirectoryListLoader r1) {
        r1.setDirectorySearchMode(this.mDirectorySearchMode);
        r1.setLocalInvisibleDirectoryEnabled(false);
    }

    public void changeDirectories(Cursor r12) {
        if (r12.getCount() != 0) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Directory search loader returned an empty cursor, which implies we have no directory entries.", new RuntimeException());
        return;
    L6:
        HashSet r0 = new HashSet();
        int r1 = r12.getColumnIndex("_id");
        int r2 = r12.getColumnIndex("directoryType");
        int r3 = r12.getColumnIndex("displayName");
        int r4 = r12.getColumnIndex("photoSupport");
        r12.moveToPosition(-1);
    L8:
        if (r12.moveToNext() == false) goto L17;
        long r6 = r12.getLong(r1);
        r0.add(Long.valueOf(r6));
        if (getPartitionByDirectoryId(r6) != (-1)) goto L8;
        boolean r9 = false;
        DirectoryPartition r8 = new DirectoryPartition(false, true);
        r8.setDirectoryId(r6);
        r8.setDirectoryType(r12.getString(r2));
        r8.setDisplayName(r12.getString(r3));
        int r7 = r12.getInt(r4);
        if (r7 != 1) goto L14;
    L15:
        r9 = true;
    L16:
        r8.setPhotoSupported(r9);
        addPartition(r8);
        goto L8
    L14:
        if (r7 != 3) goto L16;
    L17:
        int r13 = getPartitionCount();
    L18:
        r13 = r13 - 1;
        if (r13 < 0) goto L25;
        CompositeCursorAdapter.Partition r5 = getPartition(r13);
        if ((r5 instanceof DirectoryPartition) == false) goto L18;
        if (r0.contains(Long.valueOf(((DirectoryPartition) r5).getDirectoryId())) == true) goto L18;
        removePartition(r13);
        goto L18
    L25:
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
        return;
    L18:
        if (r3 != getIndexedPartition()) goto L22;
        updateIndexer(r4);
        return;
    L22:
        return;
    L11:
        if (this.mPhotoLoader == null) goto L15;
        if (isPhotoSupported(r3) == false) goto L15;
        this.mPhotoLoader.refreshCache();
        goto L15
    }

    public void changeCursor(Cursor r2) {
        changeCursor(0, r2);
    }

    private void updateIndexer(Cursor r4) {
        if (r4 != null) goto L6;
        setIndexer(null);
        return;
    L6:
        Bundle r5 = r4.getExtras();
        if (r5.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES") == false) goto L9;
        setIndexer(new ContactsSectionIndexer(r5.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES"), r5.getIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS")));
        return;
    L9:
        setIndexer(null);
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
        if (this.mEmptyListEnabled == true) goto L6;
        return false;
    L6:
        if (isSearchMode() == false) goto L10;
        return TextUtils.isEmpty(getQueryString());
    L10:
        if (this.mLoading == false) goto L13;
        return false;
    L13:
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
        return LayoutInflater.from(r1).inflate(R.layout.directory_header, r4, false);
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected void bindHeaderView(View r9, int r10, Cursor r11) {
        CompositeCursorAdapter.Partition r12 = getPartition(r10);
        if ((r12 instanceof DirectoryPartition) == true) goto L5;
        return;
    L5:
        DirectoryPartition r13 = (DirectoryPartition) r12;
        long r0 = r13.getDirectoryId();
        TextView r2 = (TextView) r9.findViewById(R.id.label);
        TextView r3 = (TextView) r9.findViewById(R.id.display_name);
        if (r0 != 0) goto L8;
    L15:
        r2.setText(R.string.common_all_contacts);
        r3.setText(null);
    L16:
        TextView r14 = (TextView) r9.findViewById(R.id.count);
        if (r13.isLoading() == false) goto L20;
        r14.setText(R.string.search_results_searching);
        return;
    L20:
        if (r11 != null) goto L22;
        int r15 = 0;
    L23:
        if (r0 != 0) goto L25;
    L29:
        r14.setText(getQuantityText(r15, R.string.listFoundAllContactsZero, R.plurals.searchFoundContacts));
        return;
    L25:
        if (r0 == 1) goto L29;
        if (r15 < getDirectoryResultLimit()) goto L29;
        r14.setText(this.mContext.getString(R.string.foundTooManyContacts, new Object[]{Integer.valueOf(getDirectoryResultLimit())}));
        return;
    L22:
        r15 = r11.getCount();
        goto L23
    L8:
        if (r0 == 1) goto L15;
        r2.setText(R.string.directory_search_label);
        String r4 = r13.getDisplayName();
        if (TextUtils.isEmpty(r4) == false) goto L14;
        r4 = r13.getDirectoryType();
    L14:
        r3.setText(r4);
        goto L16
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

    protected void bindQuickContact(ContactListItemView r3, int r4, Cursor r5, int r6, int r7, int r8, int r9) {
        if (r5.isNull(r6) == true) goto L5;
        long r0 = r5.getLong(r6);
    L6:
        String r10 = r5.getString(r9);
        QuickContactBadge r11 = r3.getQuickContact();
        r11.assignContactUri(getContactUri(r4, r5, r7, r8));
        r11.setImageBitmap(ContactsUtils.creatBitmapFromName(this.mContext, r10));
        long r12 = r0;
        getPhotoLoader().loadPhoto(r11, r12, false, this.mDarkTheme);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    protected Uri getContactUri(int r3, Cursor r4, int r5, int r6) {
        Uri r7 = ContactsContract.Contacts.getLookupUri(r4.getLong(r5), r4.getString(r6));
        long r2 = ((DirectoryPartition) getPartition(r3)).getDirectoryId();
        if (r2 != 0) goto L5;
        return r7;
    L5:
        return r7.buildUpon().appendQueryParameter("directory", String.valueOf(r2)).build();
    }

    public void setContactsCount(String r1) {
        this.mContactsCount = r1;
    }

    public String getContactsCount() {
        return this.mContactsCount;
    }
}
