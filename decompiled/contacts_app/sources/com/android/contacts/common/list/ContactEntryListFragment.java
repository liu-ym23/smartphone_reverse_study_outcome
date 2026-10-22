package com.android.contacts.common.list;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.android.common.widget.CompositeCursorAdapter;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.list.ContactEntryListAdapter;
import com.android.contacts.common.preference.ContactsPreferences;
import com.android.contacts.common.util.ContactListViewUtils;
import com.android.vcard.VCardConfig;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactEntryListFragment<T extends ContactEntryListAdapter> extends Fragment implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnFocusChangeListener, View.OnTouchListener, AdapterView.OnItemLongClickListener, LoaderManager.LoaderCallbacks<Cursor> {
    public static final int ACTIVITY_REQUEST_CODE_PICKER = 1;
    private static final int DEFAULT_DIRECTORY_RESULT_LIMIT = 20;
    private static final String DIRECTORY_ID_ARG_KEY = "directoryId";
    private static final int DIRECTORY_LOADER_ID = -1;
    private static final int DIRECTORY_SEARCH_DELAY_MILLIS = 300;
    private static final int DIRECTORY_SEARCH_MESSAGE = 1;
    private static final String KEY_ADJUST_SELECTION_BOUNDS_ENABLED = "adjustSelectionBoundsEnabled";
    private static final String KEY_DARK_THEME = "darkTheme";
    private static final String KEY_DIRECTORY_RESULT_LIMIT = "directoryResultLimit";
    private static final String KEY_DIRECTORY_SEARCH_MODE = "directorySearchMode";
    private static final String KEY_INCLUDE_PROFILE = "includeProfile";
    private static final String KEY_LEGACY_COMPATIBILITY = "legacyCompatibility";
    private static final String KEY_LIST_STATE = "liststate";
    private static final String KEY_PHOTO_LOADER_ENABLED = "photoLoaderEnabled";
    private static final String KEY_QUERY_STRING = "queryString";
    private static final String KEY_QUICK_CONTACT_ENABLED = "quickContactEnabled";
    private static final String KEY_REQUEST = "request";
    private static final String KEY_SCROLLBAR_POSITION = "scrollbarPosition";
    private static final String KEY_SEARCH_MODE = "searchMode";
    private static final String KEY_SECTION_HEADER_DISPLAY_ENABLED = "sectionHeaderDisplayEnabled";
    private static final String KEY_SELECTION_VISIBLE = "selectionVisible";
    private static final String KEY_VISIBLE_SCROLLBAR_ENABLED = "visibleScrollbarEnabled";
    private static final int STATUS_LOADED = 2;
    private static final int STATUS_LOADING = 1;
    private static final int STATUS_NOT_LOADED = 0;
    private static final String TAG = "ContactEntryListFragment";
    private int defaultVerticalScrollbarPosition;
    private T mAdapter;
    private boolean mAdjustSelectionBoundsEnabled;
    private ContactsPreferences mContactsPrefs;
    private Context mContext;
    private boolean mDarkTheme;
    private Handler mDelayedDirectorySearchHandler;
    private int mDirectoryListStatus;
    private int mDirectoryResultLimit;
    private int mDirectorySearchMode;
    private int mDisplayOrder;
    private boolean mEnabled;
    private boolean mForceLoad;
    private boolean mIncludeProfile;
    private boolean mLegacyCompatibility;
    private Parcelable mListState;
    private ListView mListView;
    private int mListViewTopIndex;
    private int mListViewTopOffset;
    private boolean mLoadPriorityDirectoriesOnly;
    private LoaderManager mLoaderManager;
    private boolean mPhotoLoaderEnabled;
    private ContactPhotoManager mPhotoManager;
    private ContactsPreferences.ChangeListener mPreferencesChangeListener;
    private String mQueryString;
    private boolean mQuickContactEnabled;
    private boolean mSearchMode;
    private boolean mSectionHeaderDisplayEnabled;
    private boolean mSelectionVisible;
    private boolean mShowEmptyListForEmptyQuery;
    private int mSortOrder;
    protected boolean mUserProfileExists;
    private int mVerticalScrollbarPosition;
    private View mView;
    private boolean mVisibleScrollbarEnabled;

    protected abstract T createListAdapter();

    protected void finish() {
    }

    public int getDirectoryLoaderId() {
        return -1;
    }

    protected abstract View inflateView(LayoutInflater r1, ViewGroup r2);

    protected abstract void onItemClick(int r1, long r2);

    protected boolean onItemLongClick(int r1, long r2) {
        return false;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> r1) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    public ContactEntryListFragment() {
        this.mQuickContactEnabled = true;
        this.mAdjustSelectionBoundsEnabled = true;
        this.mVerticalScrollbarPosition = getDefaultVerticalScrollbarPosition();
        this.mDirectorySearchMode = 0;
        this.mEnabled = true;
        this.mDirectoryResultLimit = 20;
        this.mDirectoryListStatus = 0;
        this.mDelayedDirectorySearchHandler = new AnonymousClass1(this);
        this.mPreferencesChangeListener = new AnonymousClass3(this);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        onLoadFinished2(r1, r2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        setContext(r1);
        setLoaderManager(super.getLoaderManager());
    }

    public void setContext(Context r1) {
        this.mContext = r1;
        configurePhotoLoader();
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this.mContext;
    }

    public void setEnabled(boolean r2) {
        if (this.mEnabled == r2) goto L10;
        this.mEnabled = r2;
        T r0 = this.mAdapter;
        if (r0 == null) goto L11;
        if (r2 == false) goto L8;
        reloadData();
        return;
    L8:
        r0.clearPartitions();
        return;
    L11:
        return;
    }

    public void setLoaderManager(LoaderManager r1) {
        this.mLoaderManager = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public LoaderManager getLoaderManager() {
        return this.mLoaderManager;
    }

    public T getAdapter() {
        return this.mAdapter;
    }

    @Override // androidx.fragment.app.Fragment
    public View getView() {
        return this.mView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean(KEY_SECTION_HEADER_DISPLAY_ENABLED, this.mSectionHeaderDisplayEnabled);
        r3.putBoolean(KEY_PHOTO_LOADER_ENABLED, this.mPhotoLoaderEnabled);
        r3.putBoolean(KEY_QUICK_CONTACT_ENABLED, this.mQuickContactEnabled);
        r3.putBoolean(KEY_ADJUST_SELECTION_BOUNDS_ENABLED, this.mAdjustSelectionBoundsEnabled);
        r3.putBoolean(KEY_INCLUDE_PROFILE, this.mIncludeProfile);
        r3.putBoolean(KEY_SEARCH_MODE, this.mSearchMode);
        r3.putBoolean(KEY_VISIBLE_SCROLLBAR_ENABLED, this.mVisibleScrollbarEnabled);
        r3.putInt(KEY_SCROLLBAR_POSITION, this.mVerticalScrollbarPosition);
        r3.putInt(KEY_DIRECTORY_SEARCH_MODE, this.mDirectorySearchMode);
        r3.putBoolean(KEY_SELECTION_VISIBLE, this.mSelectionVisible);
        r3.putBoolean(KEY_LEGACY_COMPATIBILITY, this.mLegacyCompatibility);
        r3.putString(KEY_QUERY_STRING, this.mQueryString);
        r3.putInt(KEY_DIRECTORY_RESULT_LIMIT, this.mDirectoryResultLimit);
        r3.putBoolean(KEY_DARK_THEME, this.mDarkTheme);
        ListView r2 = this.mListView;
        if (r2 == null) goto L6;
        r3.putParcelable(KEY_LIST_STATE, r2.onSaveInstanceState());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        restoreSavedState(r2);
        this.mAdapter = (T) createListAdapter();
        this.mContactsPrefs = new ContactsPreferences(this.mContext);
    }

    public void restoreSavedState(Bundle r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mSectionHeaderDisplayEnabled = r2.getBoolean(KEY_SECTION_HEADER_DISPLAY_ENABLED);
        this.mPhotoLoaderEnabled = r2.getBoolean(KEY_PHOTO_LOADER_ENABLED);
        this.mQuickContactEnabled = r2.getBoolean(KEY_QUICK_CONTACT_ENABLED);
        this.mAdjustSelectionBoundsEnabled = r2.getBoolean(KEY_ADJUST_SELECTION_BOUNDS_ENABLED);
        this.mIncludeProfile = r2.getBoolean(KEY_INCLUDE_PROFILE);
        this.mSearchMode = r2.getBoolean(KEY_SEARCH_MODE);
        this.mVisibleScrollbarEnabled = r2.getBoolean(KEY_VISIBLE_SCROLLBAR_ENABLED);
        this.mVerticalScrollbarPosition = r2.getInt(KEY_SCROLLBAR_POSITION);
        this.mDirectorySearchMode = r2.getInt(KEY_DIRECTORY_SEARCH_MODE);
        this.mSelectionVisible = r2.getBoolean(KEY_SELECTION_VISIBLE);
        this.mLegacyCompatibility = r2.getBoolean(KEY_LEGACY_COMPATIBILITY);
        this.mQueryString = r2.getString(KEY_QUERY_STRING);
        this.mDirectoryResultLimit = r2.getInt(KEY_DIRECTORY_RESULT_LIMIT);
        this.mDarkTheme = r2.getBoolean(KEY_DARK_THEME);
        this.mListState = r2.getParcelable(KEY_LIST_STATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mContactsPrefs.registerChangeListener(this.mPreferencesChangeListener);
        this.mForceLoad = loadPreferences();
        this.mDirectoryListStatus = 0;
        this.mLoadPriorityDirectoriesOnly = true;
        startLoading();
    }

    protected void startLoading() {
        if (this.mAdapter != null) goto L5;
        return;
    L5:
        configureAdapter();
        int r0 = this.mAdapter.getPartitionCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L18;
        CompositeCursorAdapter.Partition r3 = this.mAdapter.getPartition(r2);
        if ((r3 instanceof DirectoryPartition) == false) goto L16;
        DirectoryPartition r4 = (DirectoryPartition) r3;
        if (r4.getStatus() != 0) goto L17;
        if (r4.isPriorityDirectory() == false) goto L14;
    L15:
        startLoadingDirectoryPartition(r2);
        goto L17
    L14:
        if (this.mLoadPriorityDirectoriesOnly == false) goto L15;
    L17:
        r2 = r2 + 1;
        goto L6
    L16:
        getLoaderManager().initLoader(r2, null, this);
        goto L17
    L18:
        this.mLoadPriorityDirectoriesOnly = false;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int r3, Bundle r4) {
        if (r3 != (-1)) goto L6;
        DirectoryListLoader r5 = new DirectoryListLoader(this.mContext);
        r5.setDirectorySearchMode(this.mAdapter.getDirectorySearchMode());
        r5.setLocalInvisibleDirectoryEnabled(false);
        return r5;
    L6:
        CursorLoader r6 = createCursorLoader(this.mContext);
        if (r4 != null) goto L9;
    L11:
        long r0 = 0;
    L12:
        this.mAdapter.configureLoader(r6, r0);
        return r6;
    L9:
        if (r4.containsKey(DIRECTORY_ID_ARG_KEY) == false) goto L11;
        r0 = r4.getLong(DIRECTORY_ID_ARG_KEY);
        goto L12
    }

    public CursorLoader createCursorLoader(final Context r10) {
        final Uri r3 = null;
        final String[] r4 = null;
        final String r5 = null;
        final String[] r6 = null;
        final String r7 = null;
        return new AnonymousClass2(this, r10, r3, r4, r5, r6, r7);
    }

    private void startLoadingDirectoryPartition(int r6) {
        DirectoryPartition r0 = (DirectoryPartition) this.mAdapter.getPartition(r6);
        r0.setStatus(1);
        long r1 = r0.getDirectoryId();
        if (this.mForceLoad == true) goto L5;
        Bundle r2 = new Bundle();
        r2.putLong(DIRECTORY_ID_ARG_KEY, r1);
        getLoaderManager().initLoader(r6, r2, this);
        return;
    L5:
        if (r1 != 0) goto L7;
        loadDirectoryPartition(r6, r0);
        return;
    L7:
        loadDirectoryPartitionDelayed(r6, r0);
    }

    private void loadDirectoryPartitionDelayed(int r4, DirectoryPartition r5) {
        this.mDelayedDirectorySearchHandler.removeMessages(1, r5);
        Message r6 = this.mDelayedDirectorySearchHandler.obtainMessage(1, r4, 0, r5);
        this.mDelayedDirectorySearchHandler.sendMessageDelayed(r6, 300);
    }

    protected void loadDirectoryPartition(int r5, DirectoryPartition r6) {
        Bundle r0 = new Bundle();
        r0.putLong(DIRECTORY_ID_ARG_KEY, r6.getDirectoryId());
        getLoaderManager().restartLoader(r5, r0, this);
    }

    private void removePendingDirectorySearchRequests() {
        this.mDelayedDirectorySearchHandler.removeMessages(1);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<Cursor> r2, Cursor r3) {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        int r4 = r2.getId();
        if (r4 != (-1)) goto L8;
        this.mDirectoryListStatus = 2;
        this.mAdapter.changeDirectories(r3);
        startLoading();
        return;
    L8:
        onPartitionLoaded(r4, r3);
        if (isSearchMode() == true) goto L11;
        this.mDirectoryListStatus = 0;
        getLoaderManager().destroyLoader(-1);
        return;
    L11:
        if (getDirectorySearchMode() != 0) goto L13;
        return;
    L13:
        if (this.mDirectoryListStatus != 0) goto L15;
        this.mDirectoryListStatus = 1;
        getLoaderManager().initLoader(-1, null, this);
        return;
    L15:
        startLoading();
    }

    protected void onPartitionLoaded(int r2, Cursor r3) {
        if (r2 < this.mAdapter.getPartitionCount()) goto L5;
        return;
    L5:
        this.mAdapter.changeCursor(r2, r3);
        setProfileHeader();
        if (isLoading() == true) goto L9;
        completeRestoreInstanceState();
        return;
    }

    public boolean isLoading() {
        T r0 = this.mAdapter;
        if (r0 == null) goto L8;
        if (r0.isLoading() == false) goto L8;
        return true;
    L8:
        if (isLoadingDirectoryList() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isLoadingDirectoryList() {
        if (isSearchMode() == true) goto L5;
    L10:
        return false;
    L5:
        if (getDirectorySearchMode() == 0) goto L10;
        int r1 = this.mDirectoryListStatus;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L10;
        return true;
    L12:
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mContactsPrefs.unregisterChangeListener();
        this.mAdapter.clearPartitions();
    }

    protected void reloadData() {
        removePendingDirectorySearchRequests();
        this.mAdapter.onDataReload();
        this.mLoadPriorityDirectoriesOnly = true;
        this.mForceLoad = true;
        startLoading();
    }

    protected void setProfileHeader() {
        this.mUserProfileExists = false;
    }

    public void setSectionHeaderDisplayEnabled(boolean r2) {
        if (this.mSectionHeaderDisplayEnabled == r2) goto L9;
        this.mSectionHeaderDisplayEnabled = r2;
        T r0 = this.mAdapter;
        if (r0 == null) goto L7;
        r0.setSectionHeaderDisplayEnabled(r2);
    L7:
        configureVerticalScrollbar();
        return;
    }

    public boolean isSectionHeaderDisplayEnabled() {
        return this.mSectionHeaderDisplayEnabled;
    }

    public void setVisibleScrollbarEnabled(boolean r2) {
        if (this.mVisibleScrollbarEnabled == r2) goto L6;
        this.mVisibleScrollbarEnabled = r2;
        configureVerticalScrollbar();
        return;
    }

    public boolean isVisibleScrollbarEnabled() {
        return this.mVisibleScrollbarEnabled;
    }

    public void setVerticalScrollbarPosition(int r2) {
        if (this.mVerticalScrollbarPosition == r2) goto L6;
        this.mVerticalScrollbarPosition = r2;
        configureVerticalScrollbar();
        return;
    }

    private void configureVerticalScrollbar() {
        if (isVisibleScrollbarEnabled() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        ListView r1 = this.mListView;
        if (r1 == null) goto L12;
        r1.setFastScrollEnabled(r0);
        this.mListView.setFastScrollAlwaysVisible(r0);
        this.mListView.setVerticalScrollbarPosition(this.mVerticalScrollbarPosition);
        this.mListView.setScrollBarStyle(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        return;
    L12:
        return;
    L5:
        if (isSectionHeaderDisplayEnabled() == false) goto L7;
        r0 = true;
        goto L8
    }

    public void setPhotoLoaderEnabled(boolean r1) {
        this.mPhotoLoaderEnabled = r1;
        configurePhotoLoader();
    }

    public boolean isPhotoLoaderEnabled() {
        return this.mPhotoLoaderEnabled;
    }

    public boolean isSelectionVisible() {
        return this.mSelectionVisible;
    }

    public void setSelectionVisible(boolean r1) {
        this.mSelectionVisible = r1;
    }

    public void setQuickContactEnabled(boolean r1) {
        this.mQuickContactEnabled = r1;
    }

    public void setAdjustSelectionBoundsEnabled(boolean r1) {
        this.mAdjustSelectionBoundsEnabled = r1;
    }

    public void setIncludeProfile(boolean r1) {
        this.mIncludeProfile = r1;
        T r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setIncludeProfile(r1);
        return;
    }

    protected void setSearchMode(boolean r4) {
        if (this.mSearchMode == r4) goto L17;
        this.mSearchMode = r4;
        setSectionHeaderDisplayEnabled(!r4);
        if (r4 == true) goto L7;
        this.mDirectoryListStatus = 0;
        getLoaderManager().destroyLoader(-1);
    L7:
        T r1 = this.mAdapter;
        if (r1 == null) goto L13;
        r1.setSearchMode(r4);
        this.mAdapter.clearPartitions();
        if (r4 == true) goto L12;
        this.mAdapter.removeDirectoriesAfterDefault();
    L12:
        this.mAdapter.configureDefaultPartition(false, r4);
    L13:
        ListView r3 = this.mListView;
        if (r3 == null) goto L18;
        r3.setFastScrollEnabled(!r4);
        return;
    L18:
        return;
    }

    public final boolean isSearchMode() {
        return this.mSearchMode;
    }

    public final String getQueryString() {
        return this.mQueryString;
    }

    public void setQueryString(String r2, boolean r3) {
        if (TextUtils.equals(this.mQueryString, r2) == false) goto L5;
        return;
    L5:
        if (this.mShowEmptyListForEmptyQuery == true) goto L7;
    L16:
        this.mQueryString = r2;
        if (TextUtils.isEmpty(r2) == true) goto L19;
    L22:
        boolean r4 = true;
    L23:
        setSearchMode(r4);
        T r5 = this.mAdapter;
        if (r5 == null) goto L28;
        r5.setQueryString(r2);
        reloadData();
        return;
    L28:
        return;
    L19:
        if (this.mShowEmptyListForEmptyQuery == true) goto L22;
        r4 = false;
        goto L23
    L7:
        if (this.mAdapter == null) goto L16;
        if (this.mListView == null) goto L16;
        if (TextUtils.isEmpty(this.mQueryString) == false) goto L14;
        this.mListView.setAdapter(this.mAdapter);
        goto L16
    L14:
        if (TextUtils.isEmpty(r2) == false) goto L16;
        this.mListView.setAdapter(null);
        goto L16
    }

    public void setShowEmptyListForNullQuery(boolean r1) {
        this.mShowEmptyListForEmptyQuery = r1;
    }

    public int getDirectorySearchMode() {
        return this.mDirectorySearchMode;
    }

    public void setDirectorySearchMode(int r1) {
        this.mDirectorySearchMode = r1;
    }

    public boolean isLegacyCompatibilityMode() {
        return this.mLegacyCompatibility;
    }

    public void setLegacyCompatibilityMode(boolean r1) {
        this.mLegacyCompatibility = r1;
    }

    protected int getContactNameDisplayOrder() {
        return this.mDisplayOrder;
    }

    protected void setContactNameDisplayOrder(int r1) {
        this.mDisplayOrder = r1;
        T r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setContactNameDisplayOrder(r1);
        return;
    }

    public int getSortOrder() {
        return this.mSortOrder;
    }

    public void setSortOrder(int r1) {
        this.mSortOrder = r1;
        T r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setSortOrder(r1);
        return;
    }

    public void setDirectoryResultLimit(int r1) {
        this.mDirectoryResultLimit = r1;
    }

    protected boolean loadPreferences() {
        if (getContactNameDisplayOrder() == this.mContactsPrefs.getDisplayOrder()) goto L5;
        setContactNameDisplayOrder(this.mContactsPrefs.getDisplayOrder());
        boolean r0 = true;
    L7:
        if (getSortOrder() == this.mContactsPrefs.getSortOrder()) goto L10;
        setSortOrder(this.mContactsPrefs.getSortOrder());
        return true;
    L10:
        return r0;
    L5:
        r0 = false;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        onCreateView(r1, r2);
        boolean r4 = isSearchMode();
        this.mAdapter.setSearchMode(r4);
        this.mAdapter.configureDefaultPartition(false, r4);
        this.mAdapter.setPhotoLoader(this.mPhotoManager);
        this.mListView.setAdapter(this.mAdapter);
        if (isSearchMode() == true) goto L6;
        this.mListView.setFocusableInTouchMode(true);
        this.mListView.requestFocus();
    L6:
        return this.mView;
    }

    protected void onCreateView(LayoutInflater r1, ViewGroup r2) {
        View r3 = inflateView(r1, r2);
        this.mView = r3;
        ListView r4 = (ListView) r3.findViewById(R.id.list);
        this.mListView = r4;
        if (r4 == null) goto L10;
        View r5 = this.mView.findViewById(R.id.empty);
        if (r5 == null) goto L7;
        this.mListView.setEmptyView(r5);
    L7:
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnItemLongClickListener(this);
        this.mListView.setOnFocusChangeListener(this);
        this.mListView.setOnTouchListener(this);
        this.mListView.setFastScrollEnabled(!isSearchMode());
        this.mListView.setDividerHeight(0);
        this.mListView.setSaveEnabled(false);
        configureVerticalScrollbar();
        configurePhotoLoader();
        getAdapter().setFragmentRootView(getView());
        ContactListViewUtils.applyCardPaddingToView(getResources(), this.mListView, this.mView);
        return;
    L10:
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r2) {
        super.onHiddenChanged(r2);
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getView() == null) goto L10;
        if (r2 == true) goto L11;
        ContactListViewUtils.applyCardPaddingToView(getResources(), this.mListView, getView());
        return;
    L11:
        return;
    }

    protected void configurePhotoLoader() {
        if (isPhotoLoaderEnabled() == false) goto L16;
        Context r0 = this.mContext;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.mPhotoManager != null) goto L9;
        this.mPhotoManager = ContactPhotoManager.getInstance(r0);
    L9:
        ListView r1 = this.mListView;
        if (r1 == null) goto L12;
        r1.setOnScrollListener(this);
    L12:
        T r2 = this.mAdapter;
        if (r2 == null) goto L18;
        r2.setPhotoLoader(this.mPhotoManager);
        return;
    L18:
        return;
    }

    protected void configureAdapter() {
        T r0 = this.mAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setQuickContactEnabled(this.mQuickContactEnabled);
        this.mAdapter.setAdjustSelectionBoundsEnabled(this.mAdjustSelectionBoundsEnabled);
        this.mAdapter.setIncludeProfile(this.mIncludeProfile);
        this.mAdapter.setQueryString(this.mQueryString);
        this.mAdapter.setDirectorySearchMode(this.mDirectorySearchMode);
        this.mAdapter.setPinnedPartitionHeadersEnabled(false);
        this.mAdapter.setContactNameDisplayOrder(this.mDisplayOrder);
        this.mAdapter.setSortOrder(this.mSortOrder);
        this.mAdapter.setSectionHeaderDisplayEnabled(this.mSectionHeaderDisplayEnabled);
        this.mAdapter.setSelectionVisible(this.mSelectionVisible);
        this.mAdapter.setDirectoryResultLimit(this.mDirectoryResultLimit);
        this.mAdapter.setDarkTheme(this.mDarkTheme);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
        if (r2 != 2) goto L6;
        this.mPhotoManager.pause();
        return;
    L6:
        if (isPhotoLoaderEnabled() == false) goto L10;
        this.mPhotoManager.resume();
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        hideSoftKeyboard();
        int r5 = r3 - this.mListView.getHeaderViewsCount();
        if (r5 < 0) goto L6;
        onItemClick(r5, r4);
        return;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> r1, View r2, int r3, long r4) {
        int r5 = r3 - this.mListView.getHeaderViewsCount();
        if (r5 >= 0) goto L5;
        return false;
    L5:
        return onItemLongClick(r5, r4);
    }

    private void hideSoftKeyboard() {
        ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.mListView.getWindowToken(), 0);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View r2, boolean r3) {
        if (r2 != this.mListView) goto L7;
        if (r3 == false) goto L8;
        hideSoftKeyboard();
        return;
    L8:
        return;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        if (r1 != this.mListView) goto L7;
        hideSoftKeyboard();
        return false;
    L7:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.mListViewTopIndex = this.mListView.getFirstVisiblePosition();
        int r1 = 0;
        View r0 = this.mListView.getChildAt(0);
        if (r0 == null) goto L6;
        r1 = r0.getTop() - this.mListView.getPaddingTop();
    L6:
        this.mListViewTopOffset = r1;
        super.onPause();
        removePendingDirectorySearchRequests();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mListView.setSelectionFromTop(this.mListViewTopIndex, this.mListViewTopOffset);
    }

    protected void completeRestoreInstanceState() {
        Parcelable r0 = this.mListState;
        if (r0 == null) goto L6;
        this.mListView.onRestoreInstanceState(r0);
        this.mListState = null;
        return;
    }

    public void setDarkTheme(boolean r1) {
        this.mDarkTheme = r1;
        T r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setDarkTheme(r1);
        return;
    }

    public void onPickerResult(Intent r1) {
        throw new UnsupportedOperationException("Picker result handler is not implemented.");
    }

    private int getDefaultVerticalScrollbarPosition() {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L6;
        return 2;
    L6:
        return 1;
    }
}
