package com.android.contacts.list;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.loader.content.Loader;
import com.GlobalProxyLancet;
import com.android.common.widget.CompositeCursorAdapter;
import com.android.contacts.ContactsApplication;
import com.android.contacts.common.list.AutoScrollListView;
import com.android.contacts.common.list.ContactEntryListFragment;
import com.android.contacts.common.util.ContactLoaderUtils;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContactBrowseListFragment extends ContactEntryListFragment<com.android.contacts.common.list.ContactListAdapter> {
    private static final int AUTOSELECT_FIRST_FOUND_CONTACT_MIN_QUERY_LENGTH = 2;
    private static final int DELAY_AUTOSELECT_FIRST_FOUND_CONTACT_MILLIS = 500;
    private static final String KEY_FILTER = "filter";
    private static final String KEY_LAST_SELECTED_POSITION = "lastSelected";
    private static final String KEY_SELECTED_URI = "selectedUri";
    private static final String KEY_SELECTION_VERIFIED = "selectionVerified";
    private static final int MESSAGE_AUTOSELECT_FIRST_FOUND_CONTACT = 1;
    private static final String PERSISTENT_SELECTION_PREFIX = "defaultContactBrowserSelection";
    private static final String TAG = "ContactList";
    private ContactLookupTask mContactLookupTask;
    private boolean mDelaySelection;
    private com.android.contacts.common.list.ContactListFilter mFilter;
    private Handler mHandler;
    private int mLastSelectedPosition;
    protected OnContactBrowserActionListener mListener;
    private String mPersistentSelectionPrefix;
    private SharedPreferences mPrefs;
    private boolean mRefreshingContactUri;
    private long mSelectedContactDirectoryId;
    private long mSelectedContactId;
    private String mSelectedContactLookupKey;
    private Uri mSelectedContactUri;
    private boolean mSelectionPersistenceRequested;
    private boolean mSelectionRequired;
    private boolean mSelectionToScreenRequested;
    private boolean mSelectionVerified;
    private boolean mSmoothScrollRequested;
    private boolean mStartedLoading;

    private final class ContactLookupTask extends AsyncTask<Void, Void, Uri> {
        private boolean mIsCancelled;
        private final Uri mUri;
        final /* synthetic */ ContactBrowseListFragment this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Uri doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Uri r1) {
            onPostExecute2(r1);
        }

        public ContactLookupTask(ContactBrowseListFragment r1, Uri r2) {
            this.this$0 = r1;
            this.mUri = r2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Uri doInBackground2(Void... r9) {
            Cursor r0 = null;
            ContentResolver r2 = this.this$0.getContext().getContentResolver();     // Catch: Throwable -> L21
            Cursor r1 = r2.query(ContactLoaderUtils.ensureIsContactUri(r2, this.mUri), new String[]{"_id", "lookup"}, null, null, null);     // Catch: Throwable -> L21
            if (r1 != null) goto L25;
        L15:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactBrowseListFragment.TAG, "Error: No contact ID or lookup key for contact " + this.mUri);     // Catch: Throwable -> L19
            if (r1 == null) goto L18;
            r1.close();
        L18:
            return null;
        L25:
        L19:
            th = th;
            r0 = r1;
        L22:
            if (r0 == null) goto L24;
            r0.close();
        L24:
            throw th;
        L6:
            if (r1.moveToFirst() == false) goto L15;
            long r3 = r1.getLong(0);     // Catch: Throwable -> L19
            String r4 = r1.getString(1);     // Catch: Throwable -> L19
            if (r3 == 0) goto L15;
            if (TextUtils.isEmpty(r4) == true) goto L15;
            Uri r8 = ContactsContract.Contacts.getLookupUri(r3, r4);     // Catch: Throwable -> L19
            if (r1 == null) goto L14;
            r1.close();
        L14:
            return r8;
        L21:
            th = th;
            goto L22
        }

        public void cancel() {
            super.cancel(true);
            this.mIsCancelled = true;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Uri r2) {
            if (this.mIsCancelled == false) goto L5;
            return;
        L5:
            if (this.this$0.isAdded() == false) goto L10;
            this.this$0.onContactUriQueryFinished(r2);
            return;
        }
    }

    public boolean isOptionsMenuChanged() {
        return false;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment, androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> r1) {
    }

    public ContactBrowseListFragment() {
        this.mLastSelectedPosition = -1;
        this.mPersistentSelectionPrefix = PERSISTENT_SELECTION_PREFIX;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment, androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        onLoadFinished(r1, r2);
    }

    private Handler getHandler() {
        if (this.mHandler != null) goto L6;
        this.mHandler = new AnonymousClass1(this);
    L6:
        return this.mHandler;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(r1);
        restoreFilter();
        restoreSelectedUri(false);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void setSearchMode(boolean r2) {
        if (isSearchMode() == r2) goto L8;
        if (r2 == true) goto L6;
        restoreSelectedUri(true);
    L6:
        super.setSearchMode(r2);
        return;
    }

    public void setFilter(com.android.contacts.common.list.ContactListFilter r2) {
        setFilter(r2, true);
    }

    public void setFilter(com.android.contacts.common.list.ContactListFilter r3, boolean r4) {
        com.android.contacts.common.list.ContactListFilter r0 = this.mFilter;
        if (r0 != null) goto L6;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r0 != null) goto L8;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "New filter: " + r3);
        this.mFilter = r3;
        this.mLastSelectedPosition = -1;
        saveFilter();
        if (r4 == false) goto L13;
        this.mSelectedContactUri = null;
        restoreSelectedUri(true);
    L13:
        reloadData();
        return;
    L8:
        if (r0.equals(r3) == false) goto L10;
    }

    public com.android.contacts.common.list.ContactListFilter getFilter() {
        return this.mFilter;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void restoreSavedState(Bundle r2) {
        super.restoreSavedState(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        this.mFilter = (com.android.contacts.common.list.ContactListFilter) r2.getParcelable(KEY_FILTER);
        this.mSelectedContactUri = (Uri) r2.getParcelable(KEY_SELECTED_URI);
        this.mSelectionVerified = r2.getBoolean(KEY_SELECTION_VERIFIED);
        this.mLastSelectedPosition = r2.getInt(KEY_LAST_SELECTED_POSITION);
        parseSelectedContactUri();
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putParcelable(KEY_FILTER, this.mFilter);
        r3.putParcelable(KEY_SELECTED_URI, this.mSelectedContactUri);
        r3.putBoolean(KEY_SELECTION_VERIFIED, this.mSelectionVerified);
        r3.putInt(KEY_LAST_SELECTED_POSITION, this.mLastSelectedPosition);
    }

    protected void refreshSelectedContactUri() {
        ContactLookupTask r0 = this.mContactLookupTask;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (isSelectionVisible() == true) goto L8;
        return;
    L8:
        this.mRefreshingContactUri = true;
        Uri r1 = this.mSelectedContactUri;
        if (r1 != null) goto L12;
        onContactUriQueryFinished(null);
        return;
    L12:
        long r2 = this.mSelectedContactDirectoryId;
        if (r2 != 0) goto L15;
    L17:
        ContactLookupTask r3 = new ContactLookupTask(this, this.mSelectedContactUri);
        this.mContactLookupTask = r3;
        Void[] r4 = (Void[]) null;     // Catch: RejectedExecutionException -> L20
        r3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);     // Catch: RejectedExecutionException -> L20
        return;
    L20:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "RejectedExecutionException occurred when execute ContactLookupTask.\n" + e);
        Void[] r5 = (Void[]) null;
        this.mContactLookupTask.executeOnExecutor(ContactsApplication.getThreadPoolExecutor(), null);
        return;
    L15:
        if (r2 == 1) goto L17;
        onContactUriQueryFinished(r1);
    }

    protected void onContactUriQueryFinished(Uri r2) {
        this.mRefreshingContactUri = false;
        this.mSelectedContactUri = r2;
        parseSelectedContactUri();
        checkSelection();
    }

    public Uri getSelectedContactUri() {
        return this.mSelectedContactUri;
    }

    public void setSelectedContactUri(Uri r7) {
        setSelectedContactUri(r7, true, true, true, false);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void setQueryString(String r1, boolean r2) {
        this.mDelaySelection = r2;
        super.setQueryString(r1, r2);
    }

    public void setSelectionRequired(boolean r1) {
        this.mSelectionRequired = r1;
    }

    private void setSelectedContactUri(Uri r7, boolean r8, boolean r9, boolean r10, boolean r11) {
        this.mSmoothScrollRequested = r9;
        this.mSelectionToScreenRequested = true;
        Uri r12 = this.mSelectedContactUri;
        if (r12 != null) goto L5;
        if (r7 == null) goto L5;
    L8:
        this.mSelectionVerified = false;
        this.mSelectionRequired = r8;
        this.mSelectionPersistenceRequested = r10;
        this.mSelectedContactUri = r7;
        parseSelectedContactUri();
        if (r11 == true) goto L13;
        com.android.contacts.common.list.ContactListAdapter r0 = getAdapter();
        if (r0 == null) goto L13;
        r0.setSelectedContact(this.mSelectedContactDirectoryId, this.mSelectedContactLookupKey, this.mSelectedContactId);
        getListView().invalidateViews();
    L13:
        refreshSelectedContactUri();
        return;
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.equals(r7) == false) goto L8;
    }

    private void parseSelectedContactUri() {
        Uri r0 = this.mSelectedContactUri;
        if (r0 == null) goto L21;
        String r1 = r0.getQueryParameter("directory");
        if (TextUtils.isEmpty(r1) == false) goto L7;
        long r4 = 0;
    L8:
        this.mSelectedContactDirectoryId = r4;
        List<String> r2 = this.mSelectedContactUri.getPathSegments();
        if (this.mSelectedContactUri.toString().startsWith(ContactsContract.Contacts.CONTENT_LOOKUP_URI.toString()) == false) goto L14;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.size() != 4) goto L24;
        this.mSelectedContactLookupKey = Uri.encode(r2.get(2));
        this.mSelectedContactId = ContentUris.parseId(this.mSelectedContactUri);
        return;
    L24:
        return;
    L14:
        if (r2 != null) goto L16;
    L20:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unsupported contact URI: " + this.mSelectedContactUri);
        this.mSelectedContactLookupKey = null;
        this.mSelectedContactId = 0;
        return;
    L16:
        if (this.mSelectedContactUri.toString().startsWith(ContactsContract.Contacts.CONTENT_URI.toString()) == false) goto L20;
        if (r2.size() < 2) goto L20;
        this.mSelectedContactLookupKey = null;
        this.mSelectedContactId = ContentUris.parseId(this.mSelectedContactUri);
        return;
    L7:
        r4 = Long.parseLong(r1);
        goto L8
    L21:
        this.mSelectedContactDirectoryId = 0;
        this.mSelectedContactLookupKey = null;
        this.mSelectedContactId = 0;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void configureAdapter() {
        super.configureAdapter();
        com.android.contacts.common.list.ContactListAdapter r0 = getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r7 = isSearchMode();
        if (r7 == true) goto L14;
        com.android.contacts.common.list.ContactListFilter r1 = this.mFilter;
        if (r1 == null) goto L14;
        r0.setFilter(r1);
        if (this.mSelectionRequired == false) goto L12;
    L13:
        r0.setSelectedContact(this.mSelectedContactDirectoryId, this.mSelectedContactLookupKey, this.mSelectedContactId);
        goto L14
    L12:
        if (this.mFilter.filterType == (-6)) goto L13;
    L14:
        r0.setIncludeProfile(!r7);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        super.onLoadFinished2(r1, r2);
        this.mSelectionVerified = false;
        refreshSelectedContactUri();
    }

    private void checkSelection() {
        if (this.mSelectionVerified == false) goto L6;
        return;
    L6:
        if (this.mRefreshingContactUri == false) goto L9;
        return;
    L9:
        if (isLoadingDirectoryList() == false) goto L11;
        return;
    L11:
        com.android.contacts.common.list.ContactListAdapter r0 = getAdapter();
        if (r0 != null) goto L14;
        return;
    L14:
        int r1 = r0.getPartitionCount();
        int r2 = 0;
    L16:
        if (r2 >= r1) goto L23;
        CompositeCursorAdapter.Partition r3 = r0.getPartition(r2);
        if ((r3 instanceof com.android.contacts.common.list.DirectoryPartition) == false) goto L22;
        com.android.contacts.common.list.DirectoryPartition r4 = (com.android.contacts.common.list.DirectoryPartition) r3;
        if (r4.getDirectoryId() != this.mSelectedContactDirectoryId) goto L22;
        boolean r5 = r4.isLoading();
    L24:
        if (r5 == false) goto L26;
        return;
    L26:
        r0.setSelectedContact(this.mSelectedContactDirectoryId, this.mSelectedContactLookupKey, this.mSelectedContactId);
        int r6 = r0.getSelectedContactPosition();
        if (r6 == (-1)) goto L30;
        this.mLastSelectedPosition = r6;
    L55:
        this.mSelectionRequired = false;
        this.mSelectionVerified = true;
        if (this.mSelectionPersistenceRequested == false) goto L59;
        saveSelectedUri(this.mSelectedContactUri);
        this.mSelectionPersistenceRequested = false;
    L59:
        if (this.mSelectionToScreenRequested == false) goto L61;
        requestSelectionToScreen(r6);
    L61:
        getListView().invalidateViews();
        OnContactBrowserActionListener r11 = this.mListener;
        if (r11 == null) goto L71;
        r11.onSelectionChange();
        return;
    L71:
        return;
    L30:
        if (isSearchMode() == false) goto L38;
        if (this.mDelaySelection == false) goto L54;
        selectFirstFoundContactAfterDelay();
        OnContactBrowserActionListener r12 = this.mListener;
        if (r12 == null) goto L69;
        r12.onSelectionChange();
        return;
    L69:
        return;
    L54:
        saveSelectedUri(null);
        selectDefaultContact();
        goto L55
    L38:
        if (this.mSelectionRequired == false) goto L48;
        this.mSelectionRequired = false;
        com.android.contacts.common.list.ContactListFilter r7 = this.mFilter;
        if (r7 != null) goto L42;
    L46:
        notifyInvalidSelection();
        return;
    L42:
        if (r7.filterType != (-6)) goto L44;
    L45:
        reloadData();
        return;
    L44:
        if (this.mFilter.filterType != (-2)) goto L46;
    L48:
        com.android.contacts.common.list.ContactListFilter r8 = this.mFilter;
        if (r8 == null) goto L54;
        if (r8.filterType != (-6)) goto L54;
        notifyInvalidSelection();
        return;
    L22:
        r2 = r2 + 1;
        goto L16
    L23:
        r5 = true;
        goto L24
    }

    public void selectFirstFoundContactAfterDelay() {
        Handler r0 = getHandler();
        r0.removeMessages(1);
        String r2 = getQueryString();
        if (r2 != null) goto L5;
    L7:
        setSelectedContactUri(null, false, false, false, false);
        return;
    L5:
        if (r2.length() < 2) goto L7;
        r0.sendEmptyMessageDelayed(1, 500);
    }

    protected void selectDefaultContact() {
        com.android.contacts.common.list.ContactListAdapter r0 = getAdapter();
        if (this.mLastSelectedPosition == (-1)) goto L9;
        int r1 = r0.getCount();
        int r2 = this.mLastSelectedPosition;
        if (r2 < r1) goto L8;
        if (r1 <= 0) goto L8;
        r2 = r1 - 1;
    L8:
        Uri r3 = r0.getContactUri(r2);
    L10:
        if (r3 != null) goto L12;
        r3 = r0.getFirstContactUri();
    L12:
        setSelectedContactUri(r3, false, this.mSmoothScrollRequested, false, false);
        return;
    L9:
        r3 = null;
        goto L10
    }

    protected void requestSelectionToScreen(int r3) {
        if (r3 == (-1)) goto L6;
        AutoScrollListView r0 = (AutoScrollListView) getListView();
        r0.requestPositionToScreen(r3 + r0.getHeaderViewsCount(), this.mSmoothScrollRequested);
        this.mSelectionToScreenRequested = false;
        return;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public boolean isLoading() {
        if (this.mRefreshingContactUri == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isLoading() == true) goto L8;
        return false;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void startLoading() {
        this.mStartedLoading = true;
        this.mSelectionVerified = false;
        super.startLoading();
    }

    public void reloadDataAndSetSelectedUri(Uri r7) {
        setSelectedContactUri(r7, true, true, true, true);
        reloadData();
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void reloadData() {
        if (this.mStartedLoading == false) goto L6;
        this.mSelectionVerified = false;
        this.mLastSelectedPosition = -1;
        super.reloadData();
        return;
    }

    public void setOnContactListActionListener(OnContactBrowserActionListener r1) {
        this.mListener = r1;
    }

    public void createNewContact() {
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onCreateNewContactAction();
        return;
    }

    public void viewContact(Uri r7) {
        setSelectedContactUri(r7, false, false, true, false);
        OnContactBrowserActionListener r6 = this.mListener;
        if (r6 == null) goto L6;
        r6.onViewContactAction(r7);
        return;
    }

    public void editContact(Uri r1) {
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onEditContactAction(r1);
        return;
    }

    public void deleteContact(Uri r1) {
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onDeleteContactAction(r1);
        return;
    }

    public void addToFavorites(Uri r1) {
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onAddToFavoritesAction(r1);
        return;
    }

    public void removeFromFavorites(Uri r1) {
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onRemoveFromFavoritesAction(r1);
        return;
    }

    public void callContact(Uri r1) {
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onCallContactAction(r1);
        return;
    }

    public void smsContact(Uri r1) {
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onSmsContactAction(r1);
        return;
    }

    private void notifyInvalidSelection() {
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onInvalidSelection();
        return;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void finish() {
        super.finish();
        OnContactBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onFinishAction();
        return;
    }

    private void saveSelectedUri(Uri r3) {
        if (isSearchMode() == false) goto L5;
        return;
    L5:
        com.android.contacts.common.list.ContactListFilter.storeToPreferences(this.mPrefs, this.mFilter);
        SharedPreferences.Editor r0 = this.mPrefs.edit();
        if (r3 != null) goto L8;
        r0.remove(getPersistentSelectionKey());
    L9:
        r0.apply();
        return;
    L8:
        r0.putString(getPersistentSelectionKey(), r3.toString());
        goto L9
    }

    private void restoreSelectedUri(boolean r13) {
        if (this.mSelectionRequired == false) goto L5;
        return;
    L5:
        String r0 = this.mPrefs.getString(getPersistentSelectionKey(), null);
        if (r0 != null) goto L8;
        setSelectedContactUri(null, false, false, false, r13);
        return;
    L8:
        setSelectedContactUri(Uri.parse(r0), false, false, false, r13);
    }

    private void saveFilter() {
        com.android.contacts.common.list.ContactListFilter.storeToPreferences(this.mPrefs, this.mFilter);
    }

    private void restoreFilter() {
        this.mFilter = com.android.contacts.common.list.ContactListFilter.restoreDefaultPreferences(this.mPrefs);
    }

    private String getPersistentSelectionKey() {
        if (this.mFilter != null) goto L7;
        return this.mPersistentSelectionPrefix;
    L7:
        return this.mPersistentSelectionPrefix + "-" + this.mFilter.getId();
    }
}
