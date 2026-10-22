package com.android.contacts.pick;

import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.obric.oui.indexscrollbar.OIndexScrollbar;

/* JADX INFO: loaded from: classes2.dex */
public class InsertOrEditContactFragment extends SingleContactPickerFragment {
    @Override // com.android.contacts.pick.PickerFragment
    protected boolean isSearchInPlaceEnabled() {
        return true;
    }

    public InsertOrEditContactFragment() {
    }

    @Override // com.android.contacts.pick.SingleContactPickerFragment, com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        hideSoftKeyboard();
        int r5 = r1.getId();
        if (r5 != R.id.main_list) goto L5;
        SamContact r6 = ((PickerAdapter) this.mListView.getAdapter()).getItem(r3);
        startInsertOrEditItent(r6.contactId, r6.LookKey);
        return;
    L5:
        if (r5 != R.id.search_listview) goto L11;
        SamContact r7 = ((PickerAdapter) this.mSearchResultListView.getAdapter()).getItem(r3);
        startInsertOrEditItent(r7.contactId, r7.LookKey);
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected void onSearchCanceledInPlace() {
        if (this.mListView == null) goto L6;
        setEmptyView(this.mListView);
    L6:
        if (this.mPickerContactAdapter != null) goto L8;
        notifyData();
    L10:
        if (this.mQuickBar == null) goto L19;
        OIndexScrollbar r0 = this.mQuickBar;
        if (this.mContacts != null) goto L14;
    L16:
        int r2 = 8;
    L17:
        r0.setVisibility(r2);
        return;
    L14:
        if (this.mContacts.size() < 30) goto L16;
        r2 = 0;
        goto L17
    L19:
        return;
    L8:
        this.mPickerContactAdapter.setContacts(this.mContacts);
        this.mPickerContactAdapter.notifyDataSetChanged();
        goto L10
    }
}
