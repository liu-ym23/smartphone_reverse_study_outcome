package com.android.contacts.pick;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;

/* JADX INFO: loaded from: classes2.dex */
public class SingleAddressPickerFragment extends AddressPickerFragment {
    public SingleAddressPickerFragment() {
        setType(AddressPickerFragment.Type.SINGLE);
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        super.onItemClick(r1, r2, r3, r4);
        int r5 = r1.getId();
        if (r5 != R.id.main_list) goto L5;
        SamContact r6 = ((PickerAdapter) this.mListView.getAdapter()).getItem(r3);
        Uri r7 = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r6.phoneId);
        this.mPickerListener.onPickDataAction(r7);
        return;
    L5:
        if (r5 != R.id.search_listview) goto L11;
        SamContact r8 = ((PickerAdapter) this.mSearchResultListView.getAdapter()).getItem(r3);
        Uri r9 = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r8.phoneId);
        this.mPickerListener.onPickDataAction(r9);
        return;
    }
}
