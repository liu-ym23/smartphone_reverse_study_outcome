package com.android.contacts.list;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import com.android.contacts.R;
import com.android.contacts.common.list.ContactEntryListFragment;

/* JADX INFO: loaded from: classes2.dex */
public class JoinContactListFragment extends ContactEntryListFragment<JoinContactListAdapter> {
    private static final int DISPLAY_NAME_LOADER = -2;
    private static final String KEY_TARGET_CONTACT_ID = "targetContactId";
    private OnContactPickerActionListener mListener;
    private final LoaderManager.LoaderCallbacks<Cursor> mLoaderCallbacks;
    private long mTargetContactId;

    static /* synthetic */ long access$000(JoinContactListFragment r2) {
        return r2.mTargetContactId;
    }

    static /* synthetic */ void access$100(JoinContactListFragment r0, String r1) {
        r0.showTargetContactName(r1);
    }

    static /* synthetic */ void access$200(JoinContactListFragment r0, Cursor r1, Cursor r2) {
        r0.onContactListLoaded(r1, r2);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public /* bridge */ /* synthetic */ com.android.contacts.common.list.ContactEntryListAdapter createListAdapter() {
        return createListAdapter();
    }

    public JoinContactListFragment() {
        this.mLoaderCallbacks = new AnonymousClass1(this);
        setPhotoLoaderEnabled(true);
        setSectionHeaderDisplayEnabled(true);
        setVisibleScrollbarEnabled(false);
        setQuickContactEnabled(false);
    }

    public void setOnContactPickerActionListener(OnContactPickerActionListener r1) {
        this.mListener = r1;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void startLoading() {
        super.startLoading();
        configureAdapter();
        getLoaderManager().initLoader(-2, null, this.mLoaderCallbacks);
        getLoaderManager().restartLoader(1, null, this.mLoaderCallbacks);
    }

    private void onContactListLoaded(Cursor r2, Cursor r3) {
        getAdapter().setSuggestionsCursor(r2);
        setVisibleScrollbarEnabled(true);
        onPartitionLoaded(1, r3);
    }

    private void showTargetContactName(String r4) {
        FragmentActivity r3 = getActivity();
        ((TextView) r3.findViewById(R.id.join_contact_blurb)).setText(r3.getString(R.string.blurbJoinContactDataWith, new Object[]{r4}));
    }

    public void setTargetContactId(long r1) {
        this.mTargetContactId = r1;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public JoinContactListAdapter createListAdapter() {
        JoinContactListAdapter r0 = new JoinContactListAdapter(getActivity());
        r0.setPhotoPosition(com.android.contacts.common.list.ContactListItemView.getDefaultPhotoPosition(true));
        return r0;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void configureAdapter() {
        super.configureAdapter();
        getAdapter().setTargetContactId(this.mTargetContactId);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected View inflateView(LayoutInflater r1, ViewGroup r2) {
        return r1.inflate(R.layout.join_contact_picker_list_content, null);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void onItemClick(int r1, long r2) {
        Uri r3 = getAdapter().getContactUri(r1);
        if (r3 == null) goto L6;
        this.mListener.onPickContactAction(r3);
        return;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void onPickerResult(Intent r1) {
        Uri r2 = r1.getData();
        if (r2 == null) goto L6;
        this.mListener.onPickContactAction(r2);
        return;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r4) {
        super.onSaveInstanceState(r4);
        r4.putLong(KEY_TARGET_CONTACT_ID, this.mTargetContactId);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void restoreSavedState(Bundle r3) {
        super.restoreSavedState(r3);
        if (r3 == null) goto L6;
        this.mTargetContactId = r3.getLong(KEY_TARGET_CONTACT_ID);
        return;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    public void setQueryString(String r1, boolean r2) {
        super.setQueryString(r1, r2);
        setSearchMode(!TextUtils.isEmpty(r1));
    }
}
