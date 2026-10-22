package com.android.contacts.pick;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.util.Constants;
import com.android.contacts.util.NameSortComparator;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class AddressPickerFragment extends PickerFragment {
    protected PickerAdapter mPhonesPickerAdapter;
    protected SearchQueryHandler mSearchQueryHandler;
    protected PickerAdapter mSearchResultsPickerAdapter;
    protected ArrayList<Long> mSecletContactIds;
    protected Type mType;

    public class SearchQueryHandler extends AsyncQueryHandler {
        final /* synthetic */ AddressPickerFragment this$0;

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r3, Object r4, Cursor r5) {
            super.onQueryComplete(r3, r4, r5);
            if (r3 == 1001) goto L6;
            return;
        L6:
            if (this.this$0.getActivity() != null) goto L9;
            return;
        L9:
            if (TextUtils.isEmpty((String) r4) == false) goto L16;
            this.this$0.mSearchResultListView.setVisibility(4);
            this.this$0.mSearchResultListView.setAdapter(null);
            if (this.this$0.mSearchResultsPickerAdapter == null) goto L13;
            this.this$0.mSearchResultsPickerAdapter.setContacts(null);
            this.this$0.mSearchResultsPickerAdapter.notifyDataSetChanged();
        L13:
            this.this$0.mSearchEmptyView.setVisibility(8);
            this.this$0.mSearchQueryHandler.removeMessages(1001);
            return;
        L16:
            if (this.this$0.mSearchResultListView.getEmptyView() != null) goto L18;
            this.this$0.mSearchResultListView.setEmptyView(this.this$0.mSearchEmptyView);
        L18:
            ArrayList<SamContact> r6 = this.this$0.getSearchResult(r5);
            if (this.this$0.mSearchResultListView.getAdapter() == null) goto L21;
            this.this$0.mSearchResultsPickerAdapter.setContacts(r6);
            this.this$0.mSearchResultsPickerAdapter.notifyDataSetChanged();
        L27:
            if (this.this$0.mSearchResultListView.getVisibility() != 8) goto L30;
            this.this$0.mSearchResultListView.setVisibility(0);
            return;
        L30:
            return;
        L21:
            if (this.this$0.mType != Type.SINGLE) goto L23;
            AddressPickerFragment r7 = this.this$0;
            r7.mSearchResultsPickerAdapter = new SingleAddressPickerAdapter(this.this$0.getActivity());
        L24:
            this.this$0.mSearchResultsPickerAdapter.setPickerFragment(this.this$0);
            this.this$0.mSearchResultsPickerAdapter.setPhotoManger(this.this$0.mPhotoManager);
            this.this$0.mSearchResultsPickerAdapter.setContacts(r6);
            this.this$0.mSearchResultListView.setAdapter(this.this$0.mSearchResultsPickerAdapter);
            goto L27
        L23:
            AddressPickerFragment r8 = this.this$0;
            r8.mSearchResultsPickerAdapter = new MultiPhonesPickerAdapter(this.this$0.getActivity());
            goto L24
        }

        public SearchQueryHandler(AddressPickerFragment r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
        }
    }

    public static class StructuredPostalQuery {
        public static final int PHONEBOOK_LABEL_PRIMARY = 9;
        public static final int PHONE_CONTACT_ID = 4;
        public static final int PHONE_DISPLAY_NAME = 7;
        public static final int PHONE_ID = 0;
        public static final int PHONE_LABEL = 2;
        public static final int PHONE_LOOKUP_KEY = 5;
        public static final int PHONE_NUMBER = 3;
        public static final int PHONE_PHOTO_ID = 6;
        public static final int PHONE_SORT_KEY_PRIMARY = 8;
        public static final int PHONE_TYPE = 1;
        public static final String[] PROJECTION_PRIMARY = null;

        public StructuredPostalQuery() {
        }

        static {
            PROJECTION_PRIMARY = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name", PickerFragment.CONTACT_SORT_CNAME, Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        }
    }

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
    public void refreshVisibleListItems() {
    }

    public AddressPickerFragment() {
        this.mSecletContactIds = new ArrayList();
    }

    public void setType(Type r1) {
        this.mType = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = inflateAndSetupView(r3, r4, r5, R.layout.contact_picker_fragment);
        getActivity().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, true, this.mContactsContent);
        triggerLoad();
        this.mSearchQueryHandler = new SearchQueryHandler(this, getActivity().getContentResolver());
        return r6;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<SamContact> getContacts() {
        ArrayList<SamContact> r0 = new ArrayList();
        Cursor r8 = this.mActivity.getContentResolver().query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build(), StructuredPostalQuery.PROJECTION_PRIMARY, null, null, PickerFragment.CONTACT_SORT_CNAME);
    L18:
        th = move-exception;
        if (r8 == null) goto L21;
        r8.close();
    L21:
        throw th;
    L4:
        if (r8.moveToFirst() == false) goto L14;
    L5:
        SamContact r1 = new SamContact(0);     // Catch: Throwable -> L18
        r1.contactId = r8.getLong(4);     // Catch: Throwable -> L18
        r1.number = r8.getString(3);     // Catch: Throwable -> L18
        r1.name = r8.getString(7);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r1.name) == true) goto L8;
        boolean r3 = true;
    L9:
        r1.hasname = r3;     // Catch: Throwable -> L18
        r1.sortkey = r8.getString(8);     // Catch: Throwable -> L18
        r1.phoneBookLabel = r8.getString(9);     // Catch: Throwable -> L18
        r1.section = ContactsUtils.getContactSection(r1.sortkey, r1.phoneBookLabel);     // Catch: Throwable -> L18
        r1.LookKey = r8.getString(5);     // Catch: Throwable -> L18
        r1.photoId = r8.getLong(6);     // Catch: Throwable -> L18
        r1.phoneId = r8.getLong(0);     // Catch: Throwable -> L18
        r1.label = r8.getString(2);     // Catch: Throwable -> L18
        r1.labelres = r8.getInt(1);     // Catch: Throwable -> L18
        SamContact r2 = ContactsUtils.generateIfFamilyNameNeedPolyphone(r1);     // Catch: Throwable -> L18
        if (r2 == null) goto L12;
        r0.add(r2);     // Catch: Throwable -> L18
    L12:
        r0.add(r1);     // Catch: Throwable -> L18
        if (r8.moveToNext() == true) goto L5;
    L8:
        r3 = false;
    L14:
        if (r8 == null) goto L16;
        r8.close();
    L16:
        Collections.sort(r0, new NameSortComparator());
        return r0;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<Long> getSelectedIds() {
        return this.mSecletContactIds;
    }

    @Override // com.android.contacts.pick.PickerFragment, com.android.contacts.pick.IPickerSearchBarView
    public void onQueryTextChangeIView(String r2) {
        setSearchString(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, r2);
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setSearchString(Uri r11, String r12) {
        this.mSearchQueryHandler.removeMessages(1001);
        this.mSearchQueryHandler.startQuery(1001, r12, r11, StructuredPostalQuery.PROJECTION_PRIMARY, "data1 LIKE ? OR display_name LIKE ? ", new String[]{"%" + r12 + "%", "%" + r12 + "%"}, PickerFragment.CONTACT_SORT_CNAME);
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void onTitleBarBtnClick(View r2) {
        if (r2 != this.mBtnRightDone) goto L6;
        this.mPickerListener.onPickDatasAction(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, getSelectedIds());
        return;
    L6:
        if (r2 != this.mBtnLeftCancel) goto L10;
        getActivity().finish();
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void hideUselessView() {
        if (this.mType != Type.SINGLE) goto L6;
        updateTitleBarStatus(this.mTitleBarLeftStatus, null);
        return;
    }

    public ArrayList<SamContact> getSearchResult(Cursor r7) {
        ArrayList<SamContact> r6 = new ArrayList();
        if (r7 != null) goto L5;
    L8:
        Collections.sort(r6, new NameSortComparator());
        return r6;
    L5:
        if (r7.moveToFirst() == false) goto L8;
    L6:
        SamContact r0 = new SamContact(0);
        r0.contactId = r7.getLong(4);
        r0.number = r7.getString(3);
        r0.name = r7.getString(7);
        r0.hasname = !TextUtils.isEmpty(r0.name);
        r0.sortkey = r7.getString(8);
        r0.phoneBookLabel = r7.getString(9);
        r0.section = ContactsUtils.getContactSection(r0.sortkey, r0.phoneBookLabel);
        r0.LookKey = r7.getString(5);
        r0.photoId = r7.getLong(6);
        r0.phoneId = r7.getLong(0);
        r0.label = r7.getString(2);
        r0.labelres = r7.getInt(1);
        r6.add(r0);
        if (r7.moveToNext() == true) goto L6;
        goto L8
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void notifyData() {
        OIndexScrollbar r0 = this.mQuickBar;
        if (this.mContacts.size() < 30) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        PickerAdapter r2 = this.mPhonesPickerAdapter;
        if (r2 == null) goto L9;
        r2.setContacts(this.mContacts);
        this.mPhonesPickerAdapter.notifyDataSetChanged();
        return;
    L9:
        if (this.mType != Type.SINGLE) goto L11;
        this.mPhonesPickerAdapter = new SingleAddressPickerAdapter(getActivity());
    L12:
        this.mPhonesPickerAdapter.setPickerFragment(this);
        this.mPhonesPickerAdapter.setContacts(this.mContacts);
        this.mPhonesPickerAdapter.setPhotoManger(this.mPhotoManager);
        this.mListView.setAdapter(this.mPhonesPickerAdapter);
        setEmptyView(this.mListView);
        return;
    L11:
        this.mPhonesPickerAdapter = new MultiPhonesPickerAdapter(getActivity());
        goto L12
    L5:
        r1 = 8;
        goto L6
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        this.mTitleBar.setCenterTitle(R.string.common_address);
    }
}
