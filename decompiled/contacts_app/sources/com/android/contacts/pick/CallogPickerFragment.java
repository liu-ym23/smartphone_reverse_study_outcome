package com.android.contacts.pick;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.list.SamContact;
import com.android.contacts.util.UriUtils;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class CallogPickerFragment extends PickerFragment {
    protected PhoneNumberHelper mPhoneNumberHelper;
    protected PickerAdapter mPhonesPickerAdapter;
    protected ArrayList<Long> mSecletContactIds;
    protected Type mType;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type MULTIPLE = null;
        public static final Type SINGLE = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{SINGLE, MULTIPLE};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            SINGLE = new Type("SINGLE", 0);
            MULTIPLE = new Type("MULTIPLE", 1);
            $VALUES = $values();
        }
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setSearchString(Uri r1, String r2) {
    }

    public CallogPickerFragment() {
        this.mSecletContactIds = new ArrayList();
    }

    public void setType(Type r1) {
        this.mType = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = inflateAndSetupView(r3, r4, r5, R.layout.contact_picker_fragment);
        this.mEmptyViewRes = R.layout.calllog_picker_emptyview_stub;
        getActivity().getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, true, this.mContactsContent);
        triggerLoad();
        this.mPhoneNumberHelper = new PhoneNumberHelper(getResources());
        return r6;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void refreshVisibleListItems() {
        if (this.mListView != null) goto L5;
        return;
    L5:
        int r0 = this.mListView.getFirstVisiblePosition();
        int r1 = this.mListView.getLastVisiblePosition();
        int r2 = r0;
    L6:
        if (r2 > r1) goto L19;
        View r3 = this.mListView.getChildAt(r2 - r0);
        if (r3 == null) goto L18;
        OCheckBox r4 = (OCheckBox) r3.findViewById(R.id.checkBox);
        if (r4 == null) goto L18;
        String r5 = ((SamContact) this.mListView.getAdapter().getItem(r2)).number;
        if ((this.mListView.getAdapter() instanceof MultiCalllogsPickerAdapter) == false) goto L16;
        boolean r6 = ((MultiCalllogsPickerAdapter) this.mListView.getAdapter()).isChecked(r2);
    L17:
        r4.setChecked(r6);
        goto L18
    L16:
        r6 = false;
    L18:
        r2 = r2 + 1;
        goto L6
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<SamContact> getContacts() {
        ArrayList<SamContact> r0 = new ArrayList();
        HashSet r1 = new HashSet();
        Cursor r2 = this.mActivity.getContentResolver().query(CallLog.Calls.CONTENT_URI, CallLogQuery._PROJECTION, null, null, "date desc");
        if (r2 != null) goto L19;
    L16:
        if (r2 == null) goto L18;
        r2.close();
    L18:
        return r0;
    L19:
    L12:
        th = move-exception;
        if (r2 == null) goto L15;
        r2.close();
    L15:
        throw th;
    L5:
        if (r2.moveToFirst() == false) goto L16;
    L6:
        SamContact r3 = getContactInfoFromCallLog(r2);     // Catch: Throwable -> L12
        if (r1.contains(r3.number) == true) goto L10;
        r1.add(r3.number);     // Catch: Throwable -> L12
        r0.add(r3);     // Catch: Throwable -> L12
    L10:
        if (r2.moveToNext() == true) goto L6;
        goto L16
    }

    private SamContact getContactInfoFromCallLog(Cursor r3) {
        SamContact r2 = new SamContact(0);
        r2.lookupUri = UriUtils.parseUriOrNull(r3.getString(11));
        r2.name = r3.getString(8);
        r2.labelType = r3.getInt(9);
        r2.label = r3.getString(10);
        r2.number = ContactsUtils.formatNumber(r3.getString(1));
        if (r2.number != null) goto L5;
        r2.number = "";
    L5:
        r2.normalized_number = r3.getString(13);
        r2.photoId = r3.getLong(14);
        r2.formattedNumber = r3.getString(15);
        r2.date = r3.getLong(2);
        r2.presentation = r3.getInt(17);
        return r2;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<Long> getSelectedIds() {
        return this.mSecletContactIds;
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected void onTitleBarBtnClick(View r2) {
        if (r2 != this.mBtnRightDone) goto L6;
        String[] r3 = ((MultiCalllogsPickerAdapter) this.mCalllogListView.getAdapter()).getChecked();
        this.mPickerListener.onPickNumberArray(r3);
        return;
    L6:
        if (r2 != this.mBtnLeftCancel) goto L10;
        getActivity().finish();
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void hideUselessView() {
        this.mSearchbarView.setVisibility(8);
        if (this.mType != Type.SINGLE) goto L6;
        updateTitleBarStatus(this.mTitleBarLeftStatus, null);
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void notifyData() {
        this.mQuickBar.setVisibility(8);
        if (this.mPhonesPickerAdapter == null) goto L5;
        this.mListView.setVisibility(0);
        this.mOSearchTitleBar.setVisibility(0);
        this.mPhonesPickerAdapter.setContacts(this.mContacts);
        this.mPhonesPickerAdapter.notifyDataSetChanged();
        return;
    L5:
        if (this.mType != Type.SINGLE) goto L7;
        this.mPhonesPickerAdapter = new SingleCalllogPickerAdapter(getActivity(), this.mPhoneNumberHelper);
    L8:
        this.mPhonesPickerAdapter.setPickerFragment(this);
        this.mPhonesPickerAdapter.setContacts(this.mContacts);
        this.mPhonesPickerAdapter.setPhotoManger(this.mPhotoManager);
        this.mCalllogListView.setAdapter(this.mPhonesPickerAdapter);
        this.mListView.setVisibility(8);
        this.mOSearchTitleBar.setVisibility(8);
        setEmptyView(this.mCalllogListView);
        return;
    L7:
        this.mPhonesPickerAdapter = new MultiCalllogsPickerAdapter(getActivity(), this.mPhoneNumberHelper);
        goto L8
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        this.mTitleBar.setCenterTitle(R.string.common_call_log);
    }
}
