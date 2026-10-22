package com.android.contacts.pick;

import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.SlideListView;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MultiPhonesPickerFragment extends PhonePickerFragment implements PickerFragment.MultiSlideCheckListener {
    protected ArrayList<String> mSelectPhoneNumbers;

    public MultiPhonesPickerFragment() {
        this.mSelectPhoneNumbers = new ArrayList();
        setType(PhonePickerFragment.Type.MULTIPLE);
        setMultiSlideCheckListener(this);
    }

    @Override // com.android.contacts.pick.PhonePickerFragment
    protected void onCreateAdapter() {
        super.onCreateAdapter();
        onSelectContactChanged();
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r3, View r4, int r5, long r6) {
        super.onItemClick(r3, r4, r5, r6);
        MultiPhonesPickerAdapter r7 = (MultiPhonesPickerAdapter) r3.getAdapter();
        if (r7 == null) goto L16;
        SamContact r8 = r7.getItem(r5);
        if (this.mSelectContactIds.contains(Long.valueOf(r8.phoneId)) == false) goto L7;
        this.mSelectContactIds.remove(Long.valueOf(r8.phoneId));
        this.mSelectPhoneNumbers.remove(r8.number);
        boolean r9 = false;
    L8:
        View r10 = r3.getChildAt(r5 - r3.getFirstVisiblePosition());
        if (r10 == null) goto L11;
        OCheckBox r11 = (OCheckBox) r10.findViewById(R.id.checkBox);
    L12:
        if (r11 == null) goto L14;
        r11.setChecked(r9);
    L14:
        onSelectContactChanged();
        return;
    L11:
        r11 = null;
        goto L12
    L7:
        this.mSelectContactIds.add(Long.valueOf(r8.phoneId));
        this.mSelectPhoneNumbers.add(r8.number);
        r9 = true;
        goto L8
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public void setSlideChecked(SlideListView r3, int r4, boolean r5) {
        SamContact r0 = ((MultiPhonesPickerAdapter) r3.getAdapter()).getItem(r4);
        ((OCheckBox) r3.getChildAt(r4 - r3.getFirstVisiblePosition()).findViewById(R.id.checkBox)).setChecked(r5);
        if (r5 == false) goto L8;
        if (this.mSelectContactIds.contains(Long.valueOf(r0.phoneId)) == true) goto L10;
        this.mSelectContactIds.add(Long.valueOf(r0.phoneId));
        this.mSelectPhoneNumbers.add(r0.number);
    L10:
        onSelectContactChanged();
        return;
    L8:
        if (this.mSelectContactIds.contains(Long.valueOf(r0.phoneId)) == false) goto L10;
        this.mSelectContactIds.remove(Long.valueOf(r0.phoneId));
        this.mSelectPhoneNumbers.remove(r0.number);
        goto L10
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public boolean isSlideChecked(SlideListView r1, int r2) {
        hideSoftKeyboard();
        SamContact r3 = ((MultiPhonesPickerAdapter) r1.getAdapter()).getItem(r2);
        return this.mSelectContactIds.contains(Long.valueOf(r3.phoneId));
    }

    protected void onSelectContactChanged() {
        int r0 = this.mSelectContactIds.size();
        View r1 = this.mBtnRightDone;
        boolean r2 = true;
        if (r0 <= 0) goto L5;
        boolean r4 = true;
    L6:
        r1.setClickable(r4);
        View r3 = this.mBtnRightSendToDesk;
        if (r0 <= 0) goto L9;
        boolean r5 = true;
    L10:
        r3.setClickable(r5);
        OButtonGroup r6 = this.mFloatingTitleBarHolder.getEndButtonGroup();
        if (r6 == null) goto L16;
        if (r0 > 0) goto L15;
        r2 = false;
    L15:
        r6.setEnabled(r2);
    L16:
        if (r0 != 0) goto L18;
        setTitleLabel();
        return;
    L18:
        updateTitleLabel(r0);
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    public boolean isSelectAll() {
        if (this.mPhonesPickerAdapter == null) goto L5;
        int r0 = this.mPhonesPickerAdapter.getContactsSize();
    L7:
        if (this.mSelectContactIds.isEmpty() == false) goto L9;
        return false;
    L9:
        if (this.mSelectContactIds.size() != r0) goto L13;
        return true;
    L13:
        return false;
    L5:
        r0 = 0;
        goto L7
    }

    public void selectAll() {
        if (this.mPhonesPickerAdapter == null) goto L15;
        List<SamContact> r0 = this.mPhonesPickerAdapter.getAllContacts();
        if (r0 != null) goto L8;
        clearSelectAll();
        return;
    L8:
        this.mSelectContactIds.clear();
        this.mSelectPhoneNumbers.clear();
        Iterator<SamContact> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        SamContact r2 = r1.next();
        this.mSelectContactIds.add(Long.valueOf(r2.phoneId));
        this.mSelectPhoneNumbers.add(r2.number);
        goto L10
    L12:
        this.mPhonesPickerAdapter.notifyDataSetChanged();
        onSelectContactChanged();
        postRefreshVisibleListItems();
        return;
    }

    public void clearSelectAll() {
        this.mSelectPhoneNumbers.clear();
        this.mSelectContactIds.clear();
        if (this.mPhonesPickerAdapter == null) goto L6;
        this.mPhonesPickerAdapter.notifyDataSetChanged();
        onSelectContactChanged();
        postRefreshVisibleListItems();
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void updateTitleLabel(int r4) {
        this.mTitleBar.setCenterTitle(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r4)}));
    }

    @Override // com.android.contacts.pick.PhonePickerFragment
    public PickerAdapter initAdapter() {
        MultiPhonesPickerForStableIdAdapter r0 = new MultiPhonesPickerForStableIdAdapter(getActivity());
        r0.setDisplaySelectedItems(false);
        return r0;
    }
}
