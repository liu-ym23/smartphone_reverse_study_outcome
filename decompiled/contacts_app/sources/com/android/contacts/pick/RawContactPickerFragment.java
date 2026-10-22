package com.android.contacts.pick;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.util.Constants;
import com.android.contacts.util.NameSortComparator;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class RawContactPickerFragment extends PickerFragment {
    protected static final String CONTACT_QUERY = "account_type =? AND account_name =? AND deleted != 1 ";
    protected static final String CONTACT_QUERY_EXISTED = "deleted != 1 ";
    private String ACCOUNTNAME;
    private String ACCOUNTTYPE;
    protected final int CONTACT_ID;
    protected final String[] CONTACT_PROJECTION;
    protected final int DISPLAY_NAME;
    protected final int PHONEBOOK_LABEL_PRIMARY;
    protected final int SORT_KEY_PRIMARY;
    protected final int _ID;
    private String mAccountName;
    private String mAccountType;
    protected RelativeLayout mBottomOptionBarView;
    protected TextView mBottomOptionTextView;
    protected OCheckBox mBottomSelectAllCheckBox;
    public Intent mIntent;
    protected boolean mPickSupportSelectAll;
    protected PickerAdapter mPickerContactAdapter;
    protected SearchQueryHandler mSearchQueryHandler;
    protected PickerAdapter mSearchResultsAdapter;
    protected ArrayList<Long> mSecletContactIds;
    private ArrayList<Long> mSelectedIds2Remove;
    private SelectedMode mSelectedMode;
    protected Type mType;

    private class SearchQueryHandler extends AsyncQueryHandler {
        final /* synthetic */ RawContactPickerFragment this$0;

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r5, Object r6, Cursor r7) {
            super.onQueryComplete(r5, r6, r7);
            if (r5 == 1003) goto L6;
            return;
        L6:
            if (this.this$0.getActivity() != null) goto L8;
            return;
        L8:
            String r8 = (String) r6;
            if (this.this$0.isSearchInPlaceEnabled() == false) goto L40;
            if (TextUtils.isEmpty(r8) == false) goto L15;
            this.this$0.onSearchCanceledInPlace();
            this.this$0.mSearchQueryHandler.removeMessages(1001);
            return;
        L15:
            if (this.this$0.mQuickBar == null) goto L20;
            if (this.this$0.mQuickBar.getVisibility() == 8) goto L20;
            this.this$0.mQuickBar.setVisibility(8);
        L20:
            if (this.this$0.mListView == null) goto L25;
            if (this.this$0.mSearchEmptyView == null) goto L25;
            this.this$0.mListView.setEmptyView(this.this$0.mSearchEmptyView);
        L25:
            if (this.this$0.mPickerContactAdapter == null) goto L27;
        L37:
            this.this$0.mPickerContactAdapter.setContacts(RawContactPickerFragment.access$100(this.this$0, r7, false), r8);
            this.this$0.mPickerContactAdapter.notifyDataSetChanged();
            return;
        L27:
            if (this.this$0.mType != Type.SINGLE) goto L29;
            this.this$0.mPickerContactAdapter = new SingleContactPickerAdapter(this.this$0.getActivity());
        L34:
            this.this$0.mPickerContactAdapter.setPickerFragment(this.this$0);
            this.this$0.mPickerContactAdapter.setPhotoManger(this.this$0.mPhotoManager);
            if (this.this$0.mListView == null) goto L37;
            this.this$0.mListView.setAdapter(this.this$0.mPickerContactAdapter);
            goto L37
        L29:
            this.this$0.mPickerContactAdapter = new MultiContactsPickerAdapter(this.this$0.getActivity());
            PickerAdapter r9 = this.this$0.mPickerContactAdapter;
            if (RawContactPickerFragment.access$000(this.this$0) != SelectedMode.DISPLAY) goto L32;
            boolean r1 = true;
        L33:
            r9.setDisplaySelectedItems(r1);
            goto L34
        L32:
            r1 = false;
            goto L33
        L40:
            if (TextUtils.isEmpty(r8) == false) goto L44;
            this.this$0.mSearchResultListView.setVisibility(8);
            this.this$0.mSearchResultListView.setAdapter(null);
            this.this$0.mSearchEmptyView.setVisibility(8);
            return;
        L44:
            if (this.this$0.mSearchResultListView.getEmptyView() != null) goto L46;
            this.this$0.mSearchResultListView.setEmptyView(this.this$0.mSearchEmptyView);
        L46:
            ArrayList<SamContact> r10 = RawContactPickerFragment.access$100(this.this$0, r7, false);
            if (this.this$0.mSearchResultListView.getAdapter() == null) goto L49;
            this.this$0.mSearchResultsAdapter.setContacts(r10, r8);
            this.this$0.mSearchResultsAdapter.notifyDataSetChanged();
        L55:
            if (this.this$0.mSearchResultListView.getVisibility() != 8) goto L58;
            this.this$0.mSearchResultListView.setVisibility(0);
            return;
        L58:
            return;
        L49:
            if (this.this$0.mType != Type.SINGLE) goto L51;
            this.this$0.mSearchResultsAdapter = new SingleContactPickerAdapter(this.this$0.getActivity());
        L52:
            this.this$0.mSearchResultsAdapter.setPickerFragment(this.this$0);
            this.this$0.mSearchResultsAdapter.setPhotoManger(this.this$0.mPhotoManager);
            this.this$0.mSearchResultsAdapter.setContacts(r10, r8);
            this.this$0.mSearchResultListView.setAdapter(this.this$0.mSearchResultsAdapter);
            goto L55
        L51:
            this.this$0.mSearchResultsAdapter = new MultiContactsPickerAdapter(this.this$0.getActivity());
            goto L52
        }

        public SearchQueryHandler(RawContactPickerFragment r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
        }
    }

    public static final enum SelectedMode extends Enum<SelectedMode> {
        private static final /* synthetic */ SelectedMode[] $VALUES = null;
        public static final SelectedMode DISPLAY = null;
        public static final SelectedMode HIDEN = null;

        private static /* synthetic */ SelectedMode[] $values() {
            return new SelectedMode[]{HIDEN, DISPLAY};
        }

        private SelectedMode(String r1, int r2) {
            super(r1, r2);
        }

        public static SelectedMode valueOf(String r1) {
            return (SelectedMode) Enum.valueOf(SelectedMode.class, r1);
        }

        public static SelectedMode[] values() {
            return (SelectedMode[]) $VALUES.clone();
        }

        static {
            HIDEN = new SelectedMode("HIDEN", 0);
            DISPLAY = new SelectedMode("DISPLAY", 1);
            $VALUES = $values();
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

    public RawContactPickerFragment() {
        this.mSecletContactIds = new ArrayList();
        this.CONTACT_PROJECTION = new String[]{"_id", "display_name", PickerFragment.CONTACT_SORT_CNAME, "contact_id", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        this._ID = 0;
        this.DISPLAY_NAME = 1;
        this.SORT_KEY_PRIMARY = 2;
        this.CONTACT_ID = 3;
        this.PHONEBOOK_LABEL_PRIMARY = 4;
        this.mAccountType = null;
        this.mAccountName = null;
        this.ACCOUNTTYPE = "ACCOUNTTYPE";
        this.ACCOUNTNAME = "ACCOUNTNAME";
        this.mSelectedMode = SelectedMode.HIDEN;
        this.mSelectedIds2Remove = new ArrayList();
        this.mPickSupportSelectAll = false;
    }

    static /* synthetic */ SelectedMode access$000(RawContactPickerFragment r0) {
        return r0.mSelectedMode;
    }

    static /* synthetic */ ArrayList access$100(RawContactPickerFragment r0, Cursor r1, boolean r2) {
        return r0.getContactList(r1, r2);
    }

    public void setType(Type r1) {
        this.mType = r1;
    }

    public void setIntent(Intent r3) {
        this.mIntent = r3;
        this.mAccountType = r3.getStringExtra(this.ACCOUNTTYPE);
        this.mAccountName = this.mIntent.getStringExtra(this.ACCOUNTNAME);
        this.mPickSupportSelectAll = this.mIntent.getBooleanExtra("allow_selectall", false);
        String r4 = this.mIntent.getStringExtra("SelectedMode");
        if (r4 == null) goto L8;
        if (r4.equals("display") == false) goto L8;
        this.mSelectedMode = SelectedMode.DISPLAY;
    L8:
        if (this.mIntent.getExtras() == null) goto L18;
        ArrayList r5 = (ArrayList) this.mIntent.getExtra("com.android.contacts.extra.PHONE_IDS");
        if (r5 != null) goto L12;
        return;
    L12:
        if (this.mSelectedMode != SelectedMode.DISPLAY) goto L14;
        this.mSecletContactIds.addAll(r5);
        return;
    L14:
        Iterator r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L22;
        Long r0 = (Long) r6.next();
        this.mSelectedIds2Remove.add(r0);
        goto L16
    L22:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = inflateAndSetupView(r3, r4, r5, R.layout.contact_picker_fragment);
        if (this.mPickSupportSelectAll == true) goto L5;
    L7:
        getActivity().getContentResolver().registerContentObserver(ContactsContract.RawContacts.CONTENT_URI, true, this.mContactsContent);
        triggerLoad();
        this.mSearchQueryHandler = new SearchQueryHandler(this, getActivity().getContentResolver());
        return r6;
    L5:
        if (this.mType != Type.MULTIPLE) goto L7;
        RelativeLayout r7 = (RelativeLayout) r6.findViewById(R.id.option_bar_bottom);
        this.mBottomOptionBarView = r7;
        OCheckBox r8 = (OCheckBox) r7.findViewById(R.id.checkbox_select_all_bottom);
        this.mBottomSelectAllCheckBox = r8;
        r8.setOnClickListener(this);
        this.mBottomOptionTextView = (TextView) this.mBottomOptionBarView.findViewById(R.id.option_title_bottom);
        goto L7
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
        if (r2 > r1) goto L15;
        View r3 = this.mListView.getChildAt(r2 - r0);
        if (r3 == null) goto L10;
        OCheckBox r4 = (OCheckBox) r3.findViewById(R.id.checkBox);
    L11:
        if (r4 == null) goto L14;
        long r5 = ((SamContact) this.mListView.getAdapter().getItem(r2)).raw_contactid;
        r4.setChecked(this.mSecletContactIds.contains(Long.valueOf(r5)));
    L14:
        r2 = r2 + 1;
        goto L6
    L10:
        r4 = null;
        goto L11
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<SamContact> getContacts() {
        Cursor r0 = null;
    L14:
        th = move-exception;
        if (r0 == null) goto L17;
        r0.close();
    L17:
        throw th;
    L4:
        if (TextUtils.isEmpty(this.mAccountName) == false) goto L6;
    L9:
        r0 = this.mActivity.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, this.CONTACT_PROJECTION, CONTACT_QUERY_EXISTED, null, PickerFragment.CONTACT_SORT_CNAME);     // Catch: Throwable -> L14
    L10:
        ArrayList<SamContact> r8 = getContactList(r0);     // Catch: Throwable -> L14
        if (r0 == null) goto L13;
        r0.close();
    L13:
        return r8;
    L6:
        if (TextUtils.isEmpty(this.mAccountType) == true) goto L9;
        r0 = this.mActivity.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, this.CONTACT_PROJECTION, CONTACT_QUERY, new String[]{this.mAccountType, this.mAccountName}, PickerFragment.CONTACT_SORT_CNAME);     // Catch: Throwable -> L14
        goto L10
    }

    private ArrayList<SamContact> getContactList(Cursor r2) {
        return getContactList(r2, true);
    }

    private ArrayList<SamContact> getContactList(Cursor r9, boolean r10) {
        ArrayList<SamContact> r0 = new ArrayList();
        if (r9 != null) goto L5;
    L17:
        Collections.sort(r0, new NameSortComparator());
        return r0;
    L5:
        if (r9.moveToFirst() == false) goto L17;
    L6:
        SamContact r1 = new SamContact(0);
        long r3 = r9.getLong(0);
        if (this.mSelectedIds2Remove.contains(Long.valueOf(r3)) == true) goto L16;
        r1.name = ContactsUtils.getContactName(getActivity(), r9.getString(1));
        r1.hasname = !TextUtils.isEmpty(r1.name);
        r1.sortkey = r9.getString(2);
        r1.phoneBookLabel = r9.getString(4);
        r1.section = ContactsUtils.getContactSection(r1.sortkey, r1.phoneBookLabel);
        r1.contactId = r3;
        r1.raw_contactid = r9.getLong(0);
        if (r10 == false) goto L14;
        SamContact r2 = ContactsUtils.generateIfFamilyNameNeedPolyphone(r1);
        if (r2 == null) goto L14;
        r0.add(r2);
    L14:
        r0.add(r1);
    L16:
        if (r9.moveToNext() == true) goto L6;
        goto L17
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<Long> getSelectedIds() {
        return this.mSecletContactIds;
    }

    @Override // com.android.contacts.pick.PickerFragment, com.android.contacts.pick.IPickerSearchBarView
    public void onQueryTextChangeIView(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        Uri r0 = ContactsContract.RawContacts.CONTENT_URI;
    L6:
        setSearchString(r0, r3);
        return;
    L5:
        r0 = Uri.withAppendedPath(Uri.withAppendedPath(ContactsContract.RawContacts.CONTENT_URI, "filter"), Uri.encode(r3));
        goto L6
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setSearchString(Uri r19, String r20) {
        this.mSearchQueryHandler.removeMessages(1003);
        if (TextUtils.isEmpty(this.mAccountName) == false) goto L5;
    L8:
        this.mSearchQueryHandler.startQuery(1003, r20, r19, this.CONTACT_PROJECTION, CONTACT_QUERY_EXISTED, null, PickerFragment.CONTACT_SORT_CNAME);
        return;
    L5:
        if (TextUtils.isEmpty(this.mAccountType) == true) goto L8;
        this.mSearchQueryHandler.startQuery(1003, r20, r19, this.CONTACT_PROJECTION, CONTACT_QUERY, new String[]{this.mAccountType, this.mAccountName}, PickerFragment.CONTACT_SORT_CNAME);
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected void onTitleBarBtnClick(View r2) {
        if (r2 != this.mBtnRightDone) goto L6;
        this.mPickerListener.onPickDatasAction(ContactsContract.RawContacts.CONTENT_URI, getSelectedIds());
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

    @Override // com.android.contacts.pick.PickerFragment
    public void notifyData() {
        OIndexScrollbar r0 = this.mQuickBar;
        boolean r2 = false;
        if (this.mContacts.size() < 30) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        if (this.mBottomOptionTextView != null) goto L9;
    L13:
        PickerAdapter r3 = this.mPickerContactAdapter;
        if (r3 == null) goto L16;
        r3.setContacts(this.mContacts);
        this.mPickerContactAdapter.notifyDataSetChanged();
    L25:
        if (this.mPickSupportSelectAll == true) goto L27;
        return;
    L27:
        if (this.mType != Type.MULTIPLE) goto L31;
        refreshOptionBar();
        return;
    L31:
        return;
    L16:
        if (this.mType != Type.SINGLE) goto L18;
        this.mPickerContactAdapter = new SingleContactPickerAdapter(getActivity());
    L22:
        this.mPickerContactAdapter.setPickerFragment(this);
        this.mPickerContactAdapter.setContacts(this.mContacts);
        this.mPickerContactAdapter.setPhotoManger(this.mPhotoManager);
        this.mListView.setAdapter(this.mPickerContactAdapter);
        setEmptyView(this.mListView);
        goto L25
    L18:
        MultiContactsPickerAdapter r4 = new MultiContactsPickerAdapter(getActivity());
        this.mPickerContactAdapter = r4;
        if (this.mSelectedMode != SelectedMode.DISPLAY) goto L21;
        r2 = true;
    L21:
        r4.setDisplaySelectedItems(r2);
        goto L22
    L9:
        if (this.mContacts.size() < 30) goto L11;
        int r5 = ContactsUtils.dipTopx(this.mActivity, 40.0d);
    L12:
        this.mBottomOptionTextView.setPadding(0, 0, r5, 0);
        goto L13
    L11:
        r5 = 0;
        goto L12
    L5:
        r1 = 8;
        goto L6
    }

    protected void refreshOptionBar() {
        int r0 = ((MultiContactsPickerAdapter) this.mListView.getAdapter()).getContactsSize();
        if (r0 <= 0) goto L8;
        boolean r2 = false;
        this.mBottomOptionBarView.setVisibility(0);
        this.mBottomOptionTextView.setText(getResources().getString(R.string.edit_contacts_option_bar_msg, new Object[]{Integer.valueOf(this.mSecletContactIds.size()), Integer.valueOf(r0)}));
        OCheckBox r1 = this.mBottomSelectAllCheckBox;
        if (r0 != this.mSecletContactIds.size()) goto L7;
        r2 = true;
    L7:
        r1.setChecked(r2);
        return;
    L8:
        this.mBottomOptionBarView.setVisibility(8);
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        this.mTitleBar.setCenterTitle(R.string.common_contacts);
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void updateTitleLabel(int r4) {
        this.mTitleBar.setCenterTitle(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r4)}));
    }
}
