package com.android.contacts.common.list;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.loader.content.Loader;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.util.AccountFilterUtil;
import com.android.contacts.commonbind.analytics.AnalyticsUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PhoneNumberPickerFragment extends ContactEntryListFragment<ContactEntryListAdapter> implements ShortcutIntentBuilder.OnShortcutIntentCreatedListener, PhoneNumberListAdapter.Listener {
    private static final String KEY_FILTER = "filter";
    private static final String KEY_SHORTCUT_ACTION = "shortcutAction";
    private static final String TAG = "PhoneNumberPickerFragment";
    private View mAccountFilterHeader;
    private ContactListFilter mFilter;
    private OnPhoneNumberPickerActionListener mListener;
    private boolean mLoaderStarted;
    private View mPaddingView;
    private ContactListItemView.PhotoPosition mPhotoPosition;
    private String mShortcutAction;
    private boolean mUseCallableUri;

    static {
    }

    protected void cacheContactInfo(int r1) {
    }

    protected int getCallInitiationType(boolean r1) {
        return 0;
    }

    protected boolean getVisibleScrollbarEnabled() {
        return true;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment, androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        onLoadFinished(r1, r2);
    }

    @Override // com.android.contacts.common.list.PhoneNumberListAdapter.Listener
    public void onVideoCallIconClicked(int r2) {
        callNumber(r2, true);
    }

    public PhoneNumberPickerFragment() {
        this.mPhotoPosition = ContactListItemView.getDefaultPhotoPosition(false);
        setQuickContactEnabled(false);
        setPhotoLoaderEnabled(true);
        setSectionHeaderDisplayEnabled(true);
        setDirectorySearchMode(0);
        setHasOptionsMenu(true);
    }

    public void setDirectorySearchEnabled(boolean r1) {
        setDirectorySearchMode(r1 ? 1 : 0);
    }

    public void setOnPhoneNumberPickerActionListener(OnPhoneNumberPickerActionListener r1) {
        this.mListener = r1;
    }

    public OnPhoneNumberPickerActionListener getOnPhoneNumberPickerListener() {
        return this.mListener;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void onCreateView(LayoutInflater r3, ViewGroup r4) {
        super.onCreateView(r3, r4);
        View r5 = r3.inflate(R.layout.contact_detail_list_padding, null, false);
        this.mPaddingView = r5.findViewById(R.id.contact_detail_list_padding);
        getListView().addHeaderView(r5);
        this.mAccountFilterHeader = getView().findViewById(R.id.account_filter_header_container);
        updateFilterHeaderView();
        setVisibleScrollbarEnabled(getVisibleScrollbarEnabled());
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void setSearchMode(boolean r1) {
        super.setSearchMode(r1);
        updateFilterHeaderView();
    }

    private void updateFilterHeaderView() {
        ContactListFilter r0 = getFilter();
        if (this.mAccountFilterHeader == null) goto L17;
        if (r0 != null) goto L7;
        return;
    L7:
        if (isSearchMode() == false) goto L9;
    L11:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L15;
        this.mPaddingView.setVisibility(8);
        this.mAccountFilterHeader.setVisibility(0);
        return;
    L15:
        this.mPaddingView.setVisibility(0);
        this.mAccountFilterHeader.setVisibility(8);
        return;
    L9:
        if (AccountFilterUtil.updateAccountFilterTitleForPhone(this.mAccountFilterHeader, r0, false) == false) goto L11;
        r1 = true;
        goto L13
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void restoreSavedState(Bundle r2) {
        super.restoreSavedState(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        this.mFilter = (ContactListFilter) r2.getParcelable(KEY_FILTER);
        this.mShortcutAction = r2.getString(KEY_SHORTCUT_ACTION);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putParcelable(KEY_FILTER, this.mFilter);
        r3.putString(KEY_SHORTCUT_ACTION, this.mShortcutAction);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 16908332) goto L10;
        OnPhoneNumberPickerActionListener r2 = this.mListener;
        if (r2 == null) goto L11;
        r2.onHomeInActionBarSelected();
        return true;
    L11:
        return true;
    L10:
        return super.onOptionsItemSelected(r3);
    }

    public void setShortcutAction(String r1) {
        this.mShortcutAction = r1;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void onItemClick(int r1, long r2) {
        callNumber(r1, false);
    }

    private void callNumber(int r4, boolean r5) {
        Uri r0 = getPhoneUri(r4);
        if (r0 == null) goto L5;
        pickPhoneNumber(r0, r5);
    L9:
        String r6 = getLookupKey(r4);
        if (TextUtils.isEmpty(r6) == true) goto L13;
        maybeTrackAnalytics(r6);
        return;
    L13:
        return;
    L5:
        String r1 = getPhoneNumber(r4);
        if (TextUtils.isEmpty(r1) == true) goto L8;
        cacheContactInfo(r4);
        this.mListener.onPickPhoneNumber(r1, r5, getCallInitiationType(true));
        goto L9
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Item at " + r4 + " was clicked before adapter is ready. Ignoring");
        goto L9
    }

    protected String getPhoneNumber(int r1) {
        return ((PhoneNumberListAdapter) getAdapter()).getPhoneNumber(r1);
    }

    protected Uri getPhoneUri(int r1) {
        return ((PhoneNumberListAdapter) getAdapter()).getDataUri(r1);
    }

    protected String getLookupKey(int r1) {
        return ((PhoneNumberListAdapter) getAdapter()).getLookupKey(r1);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void startLoading() {
        this.mLoaderStarted = true;
        super.startLoading();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        super.onLoadFinished2(r1, r2);
        if (r2 != null) goto L5;
    L9:
        boolean r3 = false;
    L10:
        setVisibleScrollbarEnabled(r3);
        return;
    L5:
        if (r2.isClosed() == true) goto L9;
        if (r2.getCount() <= 0) goto L9;
        r3 = true;
        goto L10
    }

    public void setUseCallableUri(boolean r1) {
        this.mUseCallableUri = r1;
    }

    public boolean usesCallableUri() {
        return this.mUseCallableUri;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected ContactEntryListAdapter createListAdapter() {
        PhoneNumberListAdapter r0 = new PhoneNumberListAdapter(getActivity());
        r0.setDisplayPhotos(true);
        r0.setUseCallableUri(this.mUseCallableUri);
        return r0;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void configureAdapter() {
        super.configureAdapter();
        ContactEntryListAdapter r0 = getAdapter();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isSearchMode() == true) goto L10;
        ContactListFilter r1 = this.mFilter;
        if (r1 == null) goto L10;
        r0.setFilter(r1);
    L10:
        setPhotoPosition(r0);
    }

    protected void setPhotoPosition(ContactEntryListAdapter r1) {
        ((PhoneNumberListAdapter) r1).setPhotoPosition(this.mPhotoPosition);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected View inflateView(LayoutInflater r1, ViewGroup r2) {
        return r1.inflate(R.layout.contact_list_content, null);
    }

    public void pickPhoneNumber(Uri r3, boolean r4) {
        if (this.mShortcutAction != null) goto L5;
        this.mListener.onPickDataUri(r3, r4, getCallInitiationType(false));
        return;
    L5:
        startPhoneNumberShortcutIntent(r3, r4);
    }

    protected void startPhoneNumberShortcutIntent(Uri r2, boolean r3) {
        new ShortcutIntentBuilder(getActivity(), this).createPhoneNumberShortcutIntent(r2, this.mShortcutAction);
    }

    @Override // com.android.contacts.common.list.ShortcutIntentBuilder.OnShortcutIntentCreatedListener
    public void onShortcutIntentCreated(Uri r1, Intent r2) {
        this.mListener.onShortcutIntentCreated(r2);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void onPickerResult(Intent r3) {
        this.mListener.onPickDataUri(r3.getData(), false, getCallInitiationType(false));
    }

    public ContactListFilter getFilter() {
        return this.mFilter;
    }

    public void setFilter(ContactListFilter r2) {
        ContactListFilter r0 = this.mFilter;
        if (r0 != null) goto L5;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L9:
        this.mFilter = r2;
        if (this.mLoaderStarted == false) goto L12;
        reloadData();
    L12:
        updateFilterHeaderView();
        return;
    L7:
        if (r0.equals(r2) == false) goto L9;
    }

    public void setPhotoPosition(ContactListItemView.PhotoPosition r1) {
        this.mPhotoPosition = r1;
        PhoneNumberListAdapter r0 = (PhoneNumberListAdapter) getAdapter();
        if (r0 == null) goto L6;
        r0.setPhotoPosition(r1);
        return;
    }

    private void maybeTrackAnalytics(String r8) {
        JSONObject r0 = new JSONObject(r8);     // Catch: Throwable -> L13
        String r2 = r0.getString(PhoneNumberListAdapter.PhoneQuery.ANALYTICS_CATEGORY);     // Catch: Throwable -> L13
        String r3 = r0.getString(PhoneNumberListAdapter.PhoneQuery.ANALYTICS_ACTION);     // Catch: Throwable -> L13
        String r9 = r0.getString(PhoneNumberListAdapter.PhoneQuery.ANALYTICS_VALUE);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r9) == false) goto L10;
        return;
    L10:
        long r5 = (long) Float.parseFloat(r9);
        AnalyticsUtil.sendEvent(getActivity().getApplication(), r2, r3, "", r5);     // Catch: Throwable -> L13
        return;
    }
}
