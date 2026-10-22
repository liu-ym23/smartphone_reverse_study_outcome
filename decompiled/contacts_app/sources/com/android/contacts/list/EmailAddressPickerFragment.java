package com.android.contacts.list;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.R;
import com.android.contacts.common.list.ContactEntryListFragment;

/* JADX INFO: loaded from: classes2.dex */
public class EmailAddressPickerFragment extends ContactEntryListFragment<com.android.contacts.common.list.ContactEntryListAdapter> {
    private OnEmailAddressPickerActionListener mListener;

    public EmailAddressPickerFragment() {
        setQuickContactEnabled(false);
        setPhotoLoaderEnabled(true);
        setSectionHeaderDisplayEnabled(true);
        setDirectorySearchMode(3);
    }

    public void setOnEmailAddressPickerActionListener(OnEmailAddressPickerActionListener r1) {
        this.mListener = r1;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void onItemClick(int r1, long r2) {
        pickEmailAddress(((EmailAddressListAdapter) getAdapter()).getDataUri(r1));
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected com.android.contacts.common.list.ContactEntryListAdapter createListAdapter() {
        EmailAddressListAdapter r0 = new EmailAddressListAdapter(getActivity());
        r0.setSectionHeaderDisplayEnabled(true);
        r0.setDisplayPhotos(true);
        return r0;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected View inflateView(LayoutInflater r1, ViewGroup r2) {
        return r1.inflate(R.layout.contact_list_content, null);
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void onCreateView(LayoutInflater r1, ViewGroup r2) {
        super.onCreateView(r1, r2);
        setVisibleScrollbarEnabled(!isLegacyCompatibilityMode());
    }

    private void pickEmailAddress(Uri r1) {
        this.mListener.onPickEmailAddressAction(r1);
    }
}
