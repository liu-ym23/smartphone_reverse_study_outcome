package com.android.contacts.pick;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.R;
import com.android.contacts.SendShortcutService;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.SlideListView;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MultiContactsPickerFragment extends ContactPickerFragment implements PickerFragment.MultiSlideCheckListener {
    private static final int MAX_SEND_SHORT_COUNT = 20;
    private static final String TAG = "MultiContactsPickerFragment";
    private boolean mIsForShortcut;
    private int mMaxCount;
    private ArrayList<Uri> mShortcutUris;

    @Override // com.android.contacts.pick.PickerFragment
    protected boolean isSearchInPlaceEnabled() {
        return true;
    }

    @Override // com.android.contacts.pick.PickerFragment, com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        Intent r4 = getActivity().getIntent();
        if (r4 == null) goto L10;
        boolean r0 = r4.getBooleanExtra("shortcut", false);
        this.mIsForShortcut = r0;
        if (r0 == false) goto L7;
        int r5 = 20;
    L8:
        this.mMaxCount = r5;
        return;
    L7:
        r5 = r4.getIntExtra("max_count", -1);
        goto L8
    }

    public MultiContactsPickerFragment() {
        this.mMaxCount = -1;
        this.mIsForShortcut = false;
        this.mShortcutUris = new ArrayList();
        setType(ContactPickerFragment.Type.MULTIPLE);
        setMultiSlideCheckListener(this);
    }

    @Override // com.android.contacts.pick.ContactPickerFragment, com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        if (this.mIsForShortcut == false) goto L5;
        this.mTitleBar.setCenterTitle(R.string.all_contacts);
        return;
    L5:
        int r0 = this.mSelectContactIds.size();
        if (r0 != 0) goto L8;
        super.setTitleLabel();
        return;
    L8:
        updateTitleLabel(r0);
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void updateTitleLabel(int r4) {
        this.mTitleBar.setCenterTitle(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r4)}));
    }

    @Override // com.android.contacts.pick.ContactPickerFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = super.onCreateView(r1, r2, r3);
        if (this.mIsForShortcut == false) goto L5;
        updateTitleBarStatus(PickerFragment.STATE_BACK, PickerFragment.STATE_SEND);
    L5:
        return r4;
    }

    @Override // com.android.contacts.pick.ContactPickerFragment, com.android.contacts.pick.PickerFragment
    public void onTitleBarBtnClick(View r3) {
        if (r3 != this.mBtnRightSendToDesk) goto L9;
        if (this.mShortcutUris.size() <= this.mMaxCount) goto L7;
        showTooManyCheckedToast();
        return;
    L7:
        Intent r4 = new Intent(this.mActivity, SendShortcutService.class);
        r4.setAction(SendShortcutService.CREATE_SHORTCUT_ACTION);
        r4.putParcelableArrayListExtra(SendShortcutService.CREATE_SHORTCUT_EXTRA, this.mShortcutUris);
        this.mActivity.startService(r4);
        this.mActivity.finish();
        return;
    L9:
        if (r3 != this.mBtnLeftCancel) goto L11;
        this.mActivity.finish();
        return;
    L11:
        super.onTitleBarBtnClick(r3);
    }

    @Override // com.android.contacts.pick.PickerFragment, android.view.View.OnClickListener
    public void onClick(View r6) {
        super.onClick(r6);
        if (r6.getId() == R.id.checkbox_select_all) goto L5;
        return;
    L5:
        if (this.mQuickBar == null) goto L7;
        this.mQuickBar.hideLetterGrid();
    L7:
        MultiContactsPickerAdapter r7 = (MultiContactsPickerAdapter) this.mListView.getAdapter();
        if (this.mSelectAllCheckBox.isChecked() == true) goto L10;
        this.mSelectContactIds.clear();
        this.mShortcutUris.clear();
    L19:
        refreshOptionBar();
        r7.refreshCopiedContacts(false);
        return;
    L10:
        if (r7.getContactsSize() <= this.mMaxCount) goto L12;
        showTooManyCheckedToast();
        goto L19
    L12:
        int r0 = r7.getCount();
        int r2 = 0;
    L13:
        if (r2 >= r0) goto L19;
        if (trySetContactChecked(r7.getItem(r2), true) == false) goto L19;
        r2 = r2 + 1;
        goto L13
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        super.onItemClick(r1, r2, r3, r4);
        MultiContactsPickerAdapter r5 = (MultiContactsPickerAdapter) r1.getAdapter();
        OCheckBox r6 = (OCheckBox) r1.getChildAt(r3 - r1.getFirstVisiblePosition()).findViewById(R.id.checkBox);
        SamContact r7 = r5.getItem(r3);
        doContactItemChecked(r7, r6, !this.mSelectContactIds.contains(Long.valueOf(r7.contactId)));
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public void setSlideChecked(SlideListView r3, int r4, boolean r5) {
        MultiContactsPickerAdapter r0 = (MultiContactsPickerAdapter) r3.getAdapter();
        OCheckBox r6 = (OCheckBox) r3.getChildAt(r4 - r3.getFirstVisiblePosition()).findViewById(R.id.checkBox);
        doContactItemChecked(r0.getItem(r4), r6, r5);
    }

    private void doContactItemChecked(SamContact r1, OCheckBox r2, boolean r3) {
        if (trySetContactChecked(r1, r3) == true) goto L6;
        showTooManyCheckedToast();
    L10:
        setTitleLabel();
        return;
    L6:
        if (this.mPickForSimExport == false) goto L8;
        refreshOptionBar();
    L8:
        if (r2 == null) goto L10;
        r2.setChecked(r3);
        goto L10
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public boolean isSlideChecked(SlideListView r1, int r2) {
        hideSoftKeyboard();
        SamContact r3 = ((MultiContactsPickerAdapter) r1.getAdapter()).getItem(r2);
        return this.mSelectContactIds.contains(Long.valueOf(r3.contactId));
    }

    private boolean trySetContactChecked(SamContact r2, boolean r3) {
        if (r3 == true) goto L4;
    L5:
        if (r2 == null) goto L10;
        setContactSelectState(r2, r3);
        setShortcutContactSelectState(r2, r3);
        return true;
    L10:
        return false;
    L4:
        if (isLessThanMaxCount() == true) goto L5;
        return false;
    }

    private void setContactSelectState(SamContact r3, boolean r4) {
        if (r3 == null) goto L11;
        if (r4 == false) goto L8;
        if (this.mSelectContactIds.contains(Long.valueOf(r3.contactId)) == true) goto L12;
        this.mSelectContactIds.add(Long.valueOf(r3.contactId));
        return;
    L12:
        return;
    L8:
        if (this.mSelectContactIds.contains(Long.valueOf(r3.contactId)) == false) goto L14;
        this.mSelectContactIds.remove(Long.valueOf(r3.contactId));
        return;
    L14:
        return;
    }

    private void setShortcutContactSelectState(SamContact r3, boolean r4) {
        if (this.mIsForShortcut == false) goto L14;
        if (r3 == null) goto L15;
        Uri r5 = ContactsContract.Contacts.getLookupUri(r3.contactId, r3.LookKey);
        if (this.mShortcutUris.contains(r5) == true) goto L10;
        if (r4 == false) goto L10;
        this.mShortcutUris.add(r5);
        return;
    L10:
        if (this.mShortcutUris.contains(r5) == false) goto L17;
        if (r4 == true) goto L18;
        this.mShortcutUris.remove(r5);
        return;
    L18:
        return;
    L17:
        return;
    L15:
        return;
    }

    private void showTooManyCheckedToast() {
        if (this.mIsForShortcut == false) goto L5;
        int r1 = R.string.most_choice_contacts;
    L6:
        ContactsApplication.showToast(r1, 0);
        return;
    L5:
        r1 = R.string.more_than_max;
        goto L6
    }

    @Override // com.android.contacts.pick.ContactPickerFragment
    protected void refreshOptionBar() {
        super.refreshOptionBar();
        if (this.mIsForShortcut == false) goto L10;
        View r0 = this.mBtnRightSendToDesk;
        if (this.mSelectContactIds.size() <= 0) goto L7;
        boolean r1 = true;
    L8:
        r0.setEnabled(r1);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public boolean isLessThanMaxCount() {
        int r0 = this.mMaxCount;
        if (r0 <= 0) goto L9;
        if (r0 > 0) goto L6;
    L8:
        return false;
    L6:
        if (this.mSelectContactIds.size() >= this.mMaxCount) goto L8;
    L9:
        return true;
    }

    @Override // com.android.contacts.pick.PickerFragment, com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected void onSearchCanceledInPlace() {
        if (this.mListView == null) goto L5;
        setEmptyView(this.mListView);
    L5:
        MultiContactsPickerAdapter r0 = (MultiContactsPickerAdapter) this.mListView.getAdapter();
        if (r0 != null) goto L8;
        notifyData();
    L10:
        if (this.mQuickBar == null) goto L19;
        OIndexScrollbar r1 = this.mQuickBar;
        if (this.mContacts != null) goto L14;
    L16:
        int r2 = 8;
    L17:
        r1.setVisibility(r2);
        return;
    L14:
        if (this.mContacts.size() < 30) goto L16;
        r2 = 0;
        goto L17
    L19:
        return;
    L8:
        r0.setContacts(this.mContacts);
        r0.notifyDataSetChanged();
        goto L10
    }

    @Override // com.android.contacts.pick.ContactPickerFragment
    public void beforeSetAdapter(PickerAdapter r1) {
        r1.setDisplaySelectedItems(false);
    }
}
