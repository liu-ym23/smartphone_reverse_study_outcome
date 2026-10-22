package com.android.contacts.pick;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.ShortcutIntentBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class CreateShortCutContactPickerFragment extends ContactPickerFragment {
    public CreateShortCutContactPickerFragment() {
        setType(ContactPickerFragment.Type.SINGLE);
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        super.onItemClick(r1, r2, r3, r4);
        int r5 = r1.getId();
        if (r5 != R.id.main_list) goto L5;
    L7:
        SamContact r6 = ((PickerAdapter) this.mListView.getAdapter()).getItem(r3);
        createContactShortcut(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, r6.contactId));
        return;
    L5:
        if (r5 == R.id.search_listview) goto L7;
    }

    private void createContactShortcut(Uri r3) {
        new ShortcutIntentBuilder(getActivity(), this).createContactShortcutIntent(r3);
    }
}
