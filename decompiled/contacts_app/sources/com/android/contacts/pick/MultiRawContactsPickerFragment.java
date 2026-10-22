package com.android.contacts.pick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.SlideListView;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class MultiRawContactsPickerFragment extends RawContactPickerFragment implements PickerFragment.MultiSlideCheckListener {
    @Override // com.android.contacts.pick.PickerFragment
    protected boolean isSearchInPlaceEnabled() {
        return true;
    }

    public MultiRawContactsPickerFragment() {
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

    public MultiRawContactsPickerFragment(Intent r1) {
        setIntent(r1);
        setType(RawContactPickerFragment.Type.MULTIPLE);
        setMultiSlideCheckListener(this);
    }

    @Override // com.android.contacts.pick.PickerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        onSelectContactChanged();
    }

    private void onSelectContactChanged() {
        int r0 = this.mSecletContactIds.size();
        View r1 = this.mBtnRightDone;
        boolean r2 = true;
        if (r0 <= 0) goto L5;
        boolean r4 = true;
    L6:
        r1.setClickable(r4);
        OButtonGroup r3 = this.mFloatingTitleBarHolder.getEndButtonGroup();
        if (r3 == null) goto L12;
        if (r0 > 0) goto L11;
        r2 = false;
    L11:
        r3.setEnabled(r2);
    L12:
        if (r0 != 0) goto L14;
        setTitleLabel();
        return;
    L14:
        updateTitleLabel(r0);
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r5, View r6, int r7, long r8) {
        super.onItemClick(r5, r6, r7, r8);
        int r9 = r5.getId();
        OCheckBox r0 = null;
        if (r9 == R.id.main_list) goto L7;
        if (r9 == R.id.search_listview) goto L6;
        MultiContactsPickerAdapter r10 = null;
    L8:
        if (r10 == null) goto L24;
        SamContact r11 = r10.getItem(r7);
        if (this.mSecletContactIds.contains(Long.valueOf(r11.raw_contactid)) == false) goto L12;
        this.mSecletContactIds.remove(Long.valueOf(r11.raw_contactid));
        boolean r12 = false;
    L13:
        int r13 = r5.getId();
        if (r13 == R.id.main_list) goto L18;
        if (r13 != R.id.search_listview) goto L19;
        r0 = (OCheckBox) this.mSearchResultListView.getChildAt(r7 - this.mSearchResultListView.getFirstVisiblePosition()).findViewById(R.id.checkBox);
    L19:
        if (r0 == null) goto L22;
        r0.setChecked(r12);
    L22:
        if (this.mPickSupportSelectAll == false) goto L24;
        refreshOptionBar();
        goto L24
    L18:
        r0 = (OCheckBox) this.mListView.getChildAt(r7 - this.mListView.getFirstVisiblePosition()).findViewById(R.id.checkBox);
        goto L19
    L12:
        this.mSecletContactIds.add(Long.valueOf(r11.raw_contactid));
        r12 = true;
    L24:
        onSelectContactChanged();
        return;
    L6:
        r10 = (MultiContactsPickerAdapter) this.mSearchResultListView.getAdapter();
        goto L8
    L7:
        r10 = (MultiContactsPickerAdapter) this.mListView.getAdapter();
        goto L8
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public void setSlideChecked(SlideListView r3, int r4, boolean r5) {
        SamContact r0 = ((MultiContactsPickerAdapter) r3.getAdapter()).getItem(r4);
        ((OCheckBox) r3.getChildAt(r4 - r3.getFirstVisiblePosition()).findViewById(R.id.checkBox)).setChecked(r5);
        if (r5 == false) goto L8;
        if (this.mSecletContactIds.contains(Long.valueOf(r0.raw_contactid)) == true) goto L11;
        this.mSecletContactIds.add(Long.valueOf(r0.raw_contactid));
    L11:
        if (this.mPickSupportSelectAll == false) goto L13;
        refreshOptionBar();
    L13:
        onSelectContactChanged();
        return;
    L8:
        if (this.mSecletContactIds.contains(Long.valueOf(r0.raw_contactid)) == false) goto L11;
        this.mSecletContactIds.remove(Long.valueOf(r0.raw_contactid));
        goto L11
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public boolean isSlideChecked(SlideListView r1, int r2) {
        hideSoftKeyboard();
        SamContact r3 = ((MultiContactsPickerAdapter) r1.getAdapter()).getItem(r2);
        return this.mSecletContactIds.contains(Long.valueOf(r3.raw_contactid));
    }

    @Override // com.android.contacts.pick.PickerFragment, android.view.View.OnClickListener
    public void onClick(View r6) {
        super.onClick(r6);
        if (r6.getId() == R.id.checkbox_select_all_bottom) goto L6;
        return;
    L6:
        if (this.mQuickBar == null) goto L8;
        this.mQuickBar.hideLetterGrid();
    L8:
        MultiContactsPickerAdapter r7 = (MultiContactsPickerAdapter) this.mListView.getAdapter();
        HashSet<Long> r0 = r7.getAllContactsIds();
        if (r0 != null) goto L11;
        return;
    L11:
        if (this.mBottomSelectAllCheckBox.isChecked() == false) goto L18;
        Iterator<Long> r1 = r0.iterator();
    L14:
        if (r1.hasNext() == false) goto L19;
        long r2 = r1.next().longValue();
        if (this.mSecletContactIds.contains(Long.valueOf(r2)) == true) goto L14;
        this.mSecletContactIds.add(Long.valueOf(r2));
    L19:
        refreshOptionBar();
        r7.refreshCopiedContacts(false);
        return;
    L18:
        this.mSecletContactIds.clear();
        goto L19
    }

    @Override // com.android.contacts.pick.RawContactPickerFragment, com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        this.mTitleBar.setCenterTitle(R.string.contactPickerActivityTitle);
    }

    @Override // com.android.contacts.pick.RawContactPickerFragment, com.android.contacts.pick.PickerFragment
    public void updateTitleLabel(int r4) {
        this.mTitleBar.setCenterTitle(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r4)}));
    }
}
