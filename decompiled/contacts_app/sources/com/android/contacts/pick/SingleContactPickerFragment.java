package com.android.contacts.pick;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.GlobalProxyLancet;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.list.SamContact;

/* JADX INFO: loaded from: classes2.dex */
public class SingleContactPickerFragment extends ContactPickerFragment {
    public SingleContactPickerFragment() {
        setType(ContactPickerFragment.Type.SINGLE);
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r4, View r5, int r6, long r7) {
        if (this.mExtras == null) goto L8;
        int r0 = this.mExtras.getInt(ContactSelectionActivity.INTENT_EXTRA_RESULT_CODE, -1);
        if (r0 != 10) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("SingleContactPickerFragment", "onItemClick: " + r0 + " return");
        return;
    L8:
        super.onItemClick(r4, r5, r6, r7);
        int r8 = r4.getId();
        if (r8 != R.id.main_list) goto L11;
        SamContact r9 = ((PickerAdapter) this.mListView.getAdapter()).getItem(r6);
    L15:
        if (r9 != null) goto L17;
    L31:
        Uri r10 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, r9.contactId);
    L32:
        this.mContactPickerListener.onPickContactAction(r10);
        return;
    L17:
        if (r9.getType() != 1) goto L31;
        r10 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r9.contactId);
        if (r9.contactId != (-1)) goto L32;
        if (DSUtils.isMultiSimEnabled() == true) goto L23;
        r10 = r10.buildUpon().appendQueryParameter("number", r9.number).build();
        goto L32
    L23:
        if (TextUtils.isEmpty(r9.number) == true) goto L28;
        r10 = r10.buildUpon().appendQueryParameter("number", r9.number).build();
        if (TextUtils.isEmpty(r9.normalized_number) == true) goto L32;
        r10 = r10.buildUpon().appendQueryParameter("secondNumber", r9.normalized_number).build();
        goto L32
    L28:
        if (TextUtils.isEmpty(r9.normalized_number) == true) goto L32;
        r10 = r10.buildUpon().appendQueryParameter("number", r9.normalized_number).build();
        goto L32
    L11:
        if (r8 == R.id.search_listview) goto L13;
        r9 = null;
        goto L15
    L13:
        r9 = ((PickerAdapter) this.mSearchResultListView.getAdapter()).getItem(r6);
        goto L15
    }
}
