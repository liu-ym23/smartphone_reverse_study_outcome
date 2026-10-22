package com.android.contacts.pick;

import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.list.SamContact;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.NameSortComparator;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class ContactPickerFragment extends PickerFragment {
    private static final String EXTRA_INCLUDE_ONLY_PHONE_NUMBER = "bytedance.intent.extra.include.only.number";
    public static final String PICK_INCLUDE_PROFILE_ARG = "PickIncludeProfile";
    private static final String TAG = "ContactPickerFragment";
    protected final int DISPLAY_NAME;
    protected final int LOOKUP_KEY;
    protected final int NAME_RAW_CONTACT_ID;
    protected final int PHONEBOOK_LABEL_PRIMARY;
    protected final int PHOTO_ID;
    protected final int PHOTO_THUMBNAIL_URI;
    protected final int SORT_KEY_PRIMARY;
    protected final int TIMES_CONTACTED;
    protected final int _ID;
    protected boolean isFromSearch;
    protected boolean mCreateContactEnabled;
    private boolean mIncludeOnlyPhoneNumber;
    protected RelativeLayout mOptionBarView;
    protected TextView mOptionTextView;
    protected boolean mPickForSimExport;
    private boolean mPickIncludeProfile;
    protected PickerAdapter mPickerContactAdapter;
    protected SearchQueryHandler mSearchQueryHandler;
    protected PickerAdapter mSearchResultsAdapter;
    protected OCheckBox mSelectAllCheckBox;
    protected ArrayList<Long> mSelectContactIds;
    protected Type mType;

    private class SearchQueryHandler extends AsyncQueryHandler {
        final /* synthetic */ ContactPickerFragment this$0;

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
            if (this.this$0.isSearchInPlaceEnabled() == false) goto L36;
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
        L33:
            ArrayList<SamContact> r9 = ContactPickerFragment.access$000(this.this$0, r7, false, true);
            this.this$0.mPickerContactAdapter.setContacts(r9, r8);
            this.this$0.mPickerContactAdapter.notifyDataSetChanged();
            return;
        L27:
            if (this.this$0.mType != Type.SINGLE) goto L29;
            ContactPickerFragment r10 = this.this$0;
            r10.mPickerContactAdapter = new SingleContactPickerAdapter(this.this$0.getActivity());
        L30:
            this.this$0.mPickerContactAdapter.setPickerFragment(this.this$0);
            this.this$0.mPickerContactAdapter.setPhotoManger(this.this$0.mPhotoManager);
            if (this.this$0.mListView == null) goto L33;
            this.this$0.mListView.setAdapter(this.this$0.mPickerContactAdapter);
            goto L33
        L29:
            ContactPickerFragment r11 = this.this$0;
            r11.mPickerContactAdapter = new MultiContactsPickerAdapter(this.this$0.getActivity());
            goto L30
        L36:
            if (TextUtils.isEmpty(r8) == false) goto L40;
            this.this$0.mSearchResultListView.setVisibility(8);
            this.this$0.mSearchResultListView.setAdapter(null);
            this.this$0.mSearchEmptyView.setVisibility(8);
            return;
        L40:
            if (this.this$0.mSearchResultListView.getEmptyView() != null) goto L42;
            this.this$0.mSearchResultListView.setEmptyView(this.this$0.mSearchEmptyView);
        L42:
            ArrayList<SamContact> r12 = ContactPickerFragment.access$000(this.this$0, r7, false, true);
            if (this.this$0.mSearchResultListView.getAdapter() == null) goto L45;
            this.this$0.mSearchResultsAdapter.setContacts(r12, r8);
            this.this$0.mSearchResultsAdapter.notifyDataSetChanged();
        L51:
            if (this.this$0.mSearchResultListView.getVisibility() != 8) goto L54;
            this.this$0.mSearchResultListView.setVisibility(0);
            return;
        L54:
            return;
        L45:
            if (this.this$0.mType != Type.SINGLE) goto L47;
            ContactPickerFragment r13 = this.this$0;
            r13.mSearchResultsAdapter = new SingleContactPickerAdapter(this.this$0.getActivity());
        L48:
            this.this$0.mSearchResultsAdapter.setPickerFragment(this.this$0);
            this.this$0.mSearchResultsAdapter.setPhotoManger(this.this$0.mPhotoManager);
            this.this$0.mSearchResultsAdapter.setContacts(r12, r8);
            this.this$0.mSearchResultListView.setAdapter(this.this$0.mSearchResultsAdapter);
            goto L51
        L47:
            ContactPickerFragment r14 = this.this$0;
            r14.mSearchResultsAdapter = new MultiContactsPickerAdapter(this.this$0.getActivity());
            goto L48
        }

        public SearchQueryHandler(ContactPickerFragment r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
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

    public void beforeSetAdapter(PickerAdapter r1) {
    }

    public ContactPickerFragment() {
        this.mSelectContactIds = new ArrayList();
        this._ID = 0;
        this.DISPLAY_NAME = 1;
        this.TIMES_CONTACTED = 2;
        this.PHOTO_THUMBNAIL_URI = 3;
        this.SORT_KEY_PRIMARY = 4;
        this.LOOKUP_KEY = 5;
        this.PHOTO_ID = 6;
        this.NAME_RAW_CONTACT_ID = 7;
        this.PHONEBOOK_LABEL_PRIMARY = 8;
        this.mIncludeOnlyPhoneNumber = false;
        this.mPickIncludeProfile = false;
        this.mPickForSimExport = false;
        this.isFromSearch = false;
    }

    static /* synthetic */ ArrayList access$000(ContactPickerFragment r0, Cursor r1, boolean r2, boolean r3) {
        return r0.getContactList(r1, r2, r3);
    }

    private String[] getProjection() {
        String[] r0 = {"_id", "display_name", "times_contacted", "photo_thumb_uri", PickerFragment.CONTACT_SORT_CNAME, "lookup", "photo_id", "name_raw_contact_id", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        if (getDisplayOrder() != 2) goto L6;
        r0[1] = "display_name_alt";
    L6:
        if (getSortOrder() != 2) goto L8;
        r0[4] = "sort_key_alt";
    L8:
        return r0;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void onPreferencesChanged() {
        triggerLoad();
    }

    public void setType(Type r1) {
        this.mType = r1;
    }

    public void setCreateContactEnabled(boolean r1) {
        this.mCreateContactEnabled = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        this.mIncludeOnlyPhoneNumber = this.mActivity.getIntent().getBooleanExtra(EXTRA_INCLUDE_ONLY_PHONE_NUMBER, false);
        if (getArguments() == null) goto L8;
        boolean r0 = getArguments().getBoolean(PICK_INCLUDE_PROFILE_ARG, false);
        this.mPickIncludeProfile = r0;
        if (r0 == false) goto L8;
        this.mIncludeOnlyPhoneNumber = true;
    L8:
        if (this.mIncludeOnlyPhoneNumber == false) goto L10;
        String r1 = "has_phone_number >0 ";
    L11:
        this.mContactQueryWhere = r1;
        Intent r2 = getActivity().getIntent();
        if (r2 == null) goto L14;
        this.mPickForSimExport = r2.getBooleanExtra("pick_for_sim_export", false);
    L14:
        View r8 = inflateAndSetupView(r5, r6, r7, R.layout.contact_picker_fragment);
        if (this.mCreateContactEnabled == false) goto L17;
        String r9 = PickerFragment.STATE_ADD;
    L18:
        updateTitleBarStatus(PickerFragment.STATE_BACK, r9);
        if (this.mPickForSimExport == true) goto L21;
    L23:
        this.mActivity.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, this.mContactsContent);
        triggerLoad();
        this.mSearchQueryHandler = new SearchQueryHandler(this, this.mActivity.getContentResolver());
        return r8;
    L21:
        if (this.mType != Type.MULTIPLE) goto L23;
        this.mOptionBarView = (RelativeLayout) r8.findViewById(R.id.option_bar);
        OCheckBox r10 = (OCheckBox) r8.findViewById(R.id.checkbox_select_all);
        this.mSelectAllCheckBox = r10;
        r10.setOnClickListener(this);
        this.mOptionTextView = (TextView) r8.findViewById(R.id.option_title);
        goto L23
    L17:
        r9 = PickerFragment.STATE_DONE;
        goto L18
    L10:
        r1 = null;
        goto L11
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected void onTitleBarBtnClick(View r2) {
        if (r2 != this.mBtnRightDone) goto L6;
        this.mPickerListener.onPickDatasAction(ContactsContract.Contacts.CONTENT_URI, getSelectedIds());
        return;
    L6:
        if (r2 != this.mBtnRightAdd) goto L9;
        this.mContactPickerListener.onCreateNewContactAction();
        return;
    L9:
        if (r2 != this.mBtnLeftBack) goto L14;
        this.mActivity.finish();
        return;
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
        if (r2 > r1) goto L12;
        OCheckBox r3 = (OCheckBox) this.mListView.getChildAt(r2 - r0).findViewById(R.id.checkBox);
        if (r3 == null) goto L11;
        long r4 = ((SamContact) this.mListView.getAdapter().getItem(r2)).contactId;
        r3.setChecked(this.mSelectContactIds.contains(Long.valueOf(r4)));
    L11:
        r2 = r2 + 1;
        goto L6
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<SamContact> getContacts() {
        String r0 = this.mContactQueryWhere;
        if (this.mPickForSimExport == true) goto L5;
        String[] r1 = null;
    L9:
        String r5 = r0;
        String[] r6 = r1;
    L10:
        Cursor r2 = this.mActivity.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, getProjection(), r5, r6, PickerFragment.CONTACT_SORT_CNAME);
        ArrayList<SamContact> r8 = getContactList(r2);     // Catch: Throwable -> L15
        if (r2 == null) goto L14;
        r2.close();
    L14:
        return r8;
    L15:
        th = move-exception;
        if (r2 == null) goto L18;
        r2.close();
    L18:
        throw th;
    L5:
        if (this.mContactQueryWhere != null) goto L7;
        r6 = new String[]{"com.android.sim"};
        r5 = "account_type != ?";
        goto L10
    L7:
        r0 = this.mContactQueryWhere + " AND account_type != ?";
        r1 = new String[]{"com.android.sim"};
        goto L9
    }

    private ArrayList<SamContact> getContactList(Cursor r3) {
        return getContactList(r3, true, false);
    }

    private ArrayList<SamContact> getContactList(Cursor r8, boolean r9, boolean r10) {
        ArrayList<SamContact> r0 = new ArrayList();
        if (r8 != null) goto L5;
    L13:
        Collections.sort(r0, new NameSortComparator());
        if (this.mPickIncludeProfile == false) goto L20;
        if (r10 == true) goto L20;
        if (DSUtils.isMultiSimEnabled() == false) goto L19;
        setProfileDataDS(getActivity(), r0);
        goto L20
    L19:
        setProfileData(getActivity(), r0);
    L20:
        return r0;
    L5:
        if (r8.moveToFirst() == false) goto L13;
    L6:
        SamContact r1 = new SamContact(0);
        long r2 = r8.getLong(0);
        r1.name = ContactsUtils.getContactName(this.mActivity, r8.getString(1));
        r1.hasname = !TextUtils.isEmpty(r1.name);
        r1.sortkey = r8.getString(4);
        r1.phoneBookLabel = r8.getString(8);
        r1.section = ContactsUtils.getContactSection(r1.sortkey, r1.phoneBookLabel);
        r1.LookKey = r8.getString(5);
        r1.photoId = r8.getLong(6);
        r1.contactId = r2;
        r1.raw_contactid = r8.getLong(7);
        if (r9 == false) goto L11;
        SamContact r3 = ContactsUtils.generateIfFamilyNameNeedPolyphone(r1);
        if (r3 == null) goto L11;
        r0.add(r3);
    L11:
        r0.add(r1);
        if (r8.moveToNext() == true) goto L6;
        goto L13
    }

    private void setProfileData(Context r7, ArrayList<SamContact> r8) {
        Cursor r0 = r7.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, new String[]{"_id", "display_name", "photo_id"}, null, null, null);
        boolean r4 = true;
        if (r0.moveToFirst() == false) goto L10;
        SamContact r6 = new SamContact(1);     // Catch: Throwable -> L18
        r6.name = ContactsUtils.getContactName(r7, r0.getString(1));     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r0.getString(1)) == false) goto L9;
        r4 = false;
    L9:
        r6.hasname = r4;     // Catch: Throwable -> L18
        r6.contactId = r0.getLong(0);     // Catch: Throwable -> L18
        r6.photoId = r0.getLong(2);     // Catch: Throwable -> L18
        r6.section = r7.getResources().getString(R.string.common_i);     // Catch: Throwable -> L18
        r8.add(0, r6);     // Catch: Throwable -> L18
    L15:
        if (r0 == null) goto L23;
        r0.close();
        return;
    L23:
        return;
    L10:
        String r9 = getProfileNumber(r7);     // Catch: Throwable -> L18
        if (r9 == null) goto L15;
        if (TextUtils.isEmpty(r9) == true) goto L15;
        SamContact r1 = new SamContact(1);     // Catch: Throwable -> L18
        r1.number = r9;     // Catch: Throwable -> L18
        r1.normalized_number = ContactsUtils.formatNumber(r1.number);     // Catch: Throwable -> L18
        r1.name = r1.normalized_number;     // Catch: Throwable -> L18
        r1.contactId = -1;     // Catch: Throwable -> L18
        r1.section = r7.getResources().getString(R.string.common_i);     // Catch: Throwable -> L18
        r8.add(0, r1);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if (r0 == null) goto L21;
        r0.close();
    L21:
        throw th;
    }

    private void setProfileDataDS(Context r11, ArrayList<SamContact> r12) {
        String r10 = r11.getString(R.string.unknown_number);
        String r0 = r11.getResources().getString(R.string.common_i);
        Cursor r2 = r11.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, new String[]{"_id", "display_name", "photo_id"}, null, null, null);
        boolean r4 = true;
        if (r2 != null) goto L41;
    L11:
        SamContact r1 = new SamContact(1);     // Catch: Throwable -> L37
        String r5 = DSUtils.getSimNumber(r11, 0);     // Catch: Throwable -> L37
        String r6 = DSUtils.getSimNumber(r11, 1);     // Catch: Throwable -> L37
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r5) == false) goto L14;
    L16:
        boolean r8 = false;
    L18:
        if (TextUtils.isEmpty(r6) == false) goto L20;
    L24:
        r4 = false;
    L25:
        if (r8 == true) goto L27;
        if (r4 == true) goto L27;
    L34:
        if (r2 == null) goto L42;
        r2.close();
        return;
    L42:
        return;
    L27:
        if (r8 == false) goto L31;
        r1.number = r5;     // Catch: Throwable -> L37
        if (r4 == false) goto L33;
        r1.normalized_number = r6;     // Catch: Throwable -> L37
    L33:
        r1.name = r7.toString();     // Catch: Throwable -> L37
        r1.contactId = -1;     // Catch: Throwable -> L37
        r1.section = r11.getResources().getString(R.string.common_i);     // Catch: Throwable -> L37
        r12.add(0, r1);     // Catch: Throwable -> L37
        goto L34
    L31:
        if (r4 == false) goto L33;
        r1.number = r6;     // Catch: Throwable -> L37
        goto L33
    L20:
        if (TextUtils.equals(r10, r6) == true) goto L24;
        if (r8 == false) goto L23;
        r7.append(r11.getResources().getString(R.string.symbol_comma));     // Catch: Throwable -> L37
    L23:
        r7.append(r6);     // Catch: Throwable -> L37
        goto L25
    L14:
        if (TextUtils.equals(r10, r5) == true) goto L16;
        r7.append(r5);     // Catch: Throwable -> L37
        r8 = true;
        goto L18
    L41:
    L37:
        th = move-exception;
        if (r2 == null) goto L40;
        r2.close();
    L40:
        throw th;
    L5:
        if (r2.moveToFirst() == false) goto L11;
        SamContact r13 = new SamContact(1);     // Catch: Throwable -> L37
        r13.name = ContactsUtils.getContactName(r11, r2.getString(1));     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r2.getString(1)) == false) goto L10;
        r4 = false;
    L10:
        r13.hasname = r4;     // Catch: Throwable -> L37
        r13.contactId = r2.getLong(0);     // Catch: Throwable -> L37
        r13.photoId = r2.getLong(2);     // Catch: Throwable -> L37
        r13.section = r0;     // Catch: Throwable -> L37
        r12.add(0, r13);     // Catch: Throwable -> L37
        goto L34
    }

    private String getProfileNumber(Context r1) {
        String r0 = ((TelephonyManager) r1.getSystemService("phone")).getLine1Number();
        if (ContactsUtils.isFeatureUSEnabled() == false) goto L5;
        return r0;
    L5:
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return r0;
    L7:
        if (r0.startsWith("+86") == true) goto L9;
        return r0;
    L9:
        return r0.substring(3).trim();
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<Long> getSelectedIds() {
        return this.mSelectContactIds;
    }

    public void startInsertOrEditItent(long r1, String r3) {
        Uri r2 = ContactsContract.Contacts.getLookupUri(r1, r3);
        Intent r4 = new Intent("android.intent.action.EDIT");
        r4.setPackage("com.android.contacts");
        r4.setData(r2);
        if (this.mExtras == null) goto L5;
        r4.putExtras(this.mExtras);
    L5:
        r4.putExtra(ContactEditorFragment.EXTRA_ADD_STRANGE_NUMBER, true);
        startActivity(r4);
        AnimationUtil.switchActivityAnimation(getActivity(), 1);
        if ((this.mActivity instanceof ContactSelectionActivity) == false) goto L8;
        ((ContactSelectionActivity) this.mActivity).finishWithoutAnimation();
        return;
    L8:
        this.mActivity.finish();
    }

    @Override // com.android.contacts.pick.PickerFragment, com.android.contacts.pick.IPickerSearchBarView
    public void onQueryTextChangeIView(String r3) {
        if (r3 == null) goto L4;
        Uri r0 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(r3));
    L5:
        setSearchString(r0, r3);
        return;
    L4:
        r0 = ContactsContract.Contacts.CONTENT_URI;
        goto L5
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setSearchString(Uri r11, String r12) {
        this.mSearchQueryHandler.removeMessages(1003);
        String r0 = this.mContactQueryWhere;
        if (this.mPickForSimExport == true) goto L5;
        String[] r1 = null;
    L9:
        String r7 = r0;
        String[] r8 = r1;
    L10:
        this.mSearchQueryHandler.startQuery(1003, r12, r11, getProjection(), r7, r8, PickerFragment.CONTACT_SORT_CNAME);
        return;
    L5:
        if (this.mContactQueryWhere != null) goto L7;
        r8 = new String[]{"com.android.sim"};
        r7 = "account_type != ?";
        goto L10
    L7:
        r0 = this.mContactQueryWhere + " AND account_type != ?";
        r1 = new String[]{"com.android.sim"};
        goto L9
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void hideUselessView() {
        if (this.mType == Type.SINGLE) goto L5;
        return;
    L5:
        if (this.mCreateContactEnabled == true) goto L9;
        updateTitleBarStatus(this.mTitleBarLeftStatus, null);
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void notifyData() {
        OIndexScrollbar r0 = this.mQuickBar;
        if (this.mContacts.size() < 30) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        PickerAdapter r2 = this.mPickerContactAdapter;
        if (r2 == null) goto L9;
        r2.setContacts(this.mContacts);
        this.mPickerContactAdapter.notifyDataSetChanged();
    L15:
        if (this.mPickForSimExport == true) goto L17;
        return;
    L17:
        if (this.mType != Type.MULTIPLE) goto L21;
        refreshOptionBar();
        return;
    L21:
        return;
    L9:
        if (this.mType != Type.SINGLE) goto L11;
        this.mPickerContactAdapter = new SingleContactPickerAdapter(getActivity());
    L12:
        this.mPickerContactAdapter.setPickerFragment(this);
        beforeSetAdapter(this.mPickerContactAdapter);
        this.mPickerContactAdapter.setContacts(this.mContacts);
        this.mPickerContactAdapter.setPhotoManger(this.mPhotoManager);
        this.mListView.setAdapter(this.mPickerContactAdapter);
        setEmptyView(this.mListView);
        goto L15
    L11:
        this.mPickerContactAdapter = new MultiContactsPickerAdapter(getActivity());
        goto L12
    L5:
        r1 = 8;
        goto L6
    }

    @Override // com.android.contacts.pick.PickerFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.isFromSearch = ((ContactSelectionActivity) this.mActivity).isFromSearch();
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        this.mTitleBar.setCenterTitle(R.string.common_contacts);
    }

    protected void refreshOptionBar() {
        int r0 = ((MultiContactsPickerAdapter) this.mListView.getAdapter()).getContactsSize();
        if (r0 <= 0) goto L8;
        boolean r2 = false;
        this.mOptionBarView.setVisibility(0);
        this.mOptionTextView.setText(getResources().getString(R.string.edit_contacts_option_bar_msg, new Object[]{Integer.valueOf(this.mSelectContactIds.size()), Integer.valueOf(r0)}));
        OCheckBox r1 = this.mSelectAllCheckBox;
        if (r0 != this.mSelectContactIds.size()) goto L7;
        r2 = true;
    L7:
        r1.setChecked(r2);
        return;
    L8:
        this.mOptionBarView.setVisibility(8);
    }
}
