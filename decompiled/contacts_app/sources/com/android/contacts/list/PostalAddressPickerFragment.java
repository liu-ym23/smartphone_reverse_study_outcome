package com.android.contacts.list;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.R;
import com.android.contacts.common.list.ContactEntryListFragment;

/* JADX INFO: loaded from: classes2.dex */
public class PostalAddressPickerFragment extends ContactEntryListFragment<com.android.contacts.common.list.ContactEntryListAdapter> {
    private OnPostalAddressPickerActionListener mListener;

    public PostalAddressPickerFragment() {
        setQuickContactEnabled(false);
        setPhotoLoaderEnabled(true);
        setSectionHeaderDisplayEnabled(true);
        setDirectorySearchMode(3);
    }

    public void setOnPostalAddressPickerActionListener(OnPostalAddressPickerActionListener r1) {
        this.mListener = r1;
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected void onItemClick(int r1, long r2) {
        if (isLegacyCompatibilityMode() == true) goto L5;
        pickPostalAddress(((PostalAddressListAdapter) getAdapter()).getDataUri(r1));
        return;
    L5:
        pickPostalAddress(((LegacyPostalAddressListAdapter) getAdapter()).getContactMethodUri(r1));
    }

    @Override // com.android.contacts.common.list.ContactEntryListFragment
    protected com.android.contacts.common.list.ContactEntryListAdapter createListAdapter() {
        if (isLegacyCompatibilityMode() == true) goto L6;
        PostalAddressListAdapter r0 = new PostalAddressListAdapter(getActivity());
        r0.setSectionHeaderDisplayEnabled(true);
        r0.setDisplayPhotos(true);
        return r0;
    L6:
        LegacyPostalAddressListAdapter r1 = new LegacyPostalAddressListAdapter(getActivity());
        r1.setSectionHeaderDisplayEnabled(false);
        r1.setDisplayPhotos(false);
        return r1;
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

    private void pickPostalAddress(Uri r1) {
        this.mListener.onPickPostalAddressAction(r1);
    }
}
