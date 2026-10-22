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
import com.GlobalProxyLancet;
import com.android.contacts.ContactsSettingActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.util.Constants;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.KeyboardShowListener;
import com.android.contacts.util.NameSortComparator;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PhonePickerFragment extends PickerFragment {
    protected PickerAdapter mPhonesPickerAdapter;
    protected SearchQueryHandler mSearchQueryHandler;
    protected PickerAdapter mSearchResultsPickerAdapter;
    protected ArrayList<Long> mSelectContactIds;
    protected Type mType;

    public static class PhoneQuery {
        public static final int NORMALIZED_NUMBER = 8;
        public static final int PHONE_BOOK_LABEL_PRIMARY = 10;
        public static final int PHONE_CONTACT_ID = 4;
        public static final int PHONE_DISPLAY_NAME = 7;
        public static final int PHONE_ID = 0;
        public static final int PHONE_LABEL = 2;
        public static final int PHONE_LOOKUP_KEY = 5;
        public static final int PHONE_NUMBER = 3;
        public static final int PHONE_PHOTO_ID = 6;
        public static final int PHONE_SORT_KEY = 9;
        public static final int PHONE_TYPE = 1;
        private static final String[] PROJECTION = null;

        public PhoneQuery() {
        }

        static {
            PROJECTION = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name", "data4", PickerFragment.CONTACT_SORT_CNAME, Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        }

        public static String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            PROJECTION[7] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            PROJECTION[9] = "sort_key_alt";
        L11:
            return PROJECTION;
        L9:
            PROJECTION[9] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            PROJECTION[7] = "display_name";
            goto L7
        }
    }

    public class SearchQueryHandler extends AsyncQueryHandler {
        final /* synthetic */ PhonePickerFragment this$0;

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r4, Object r5, Cursor r6) {
            super.onQueryComplete(r4, r5, r6);
            if (r4 == 1001) goto L6;
            return;
        L6:
            if (this.this$0.getActivity() != null) goto L8;
            return;
        L8:
            String r7 = (String) r5;
            if (this.this$0.oSearchEditor != null) goto L11;
            String r8 = null;
        L13:
            if (TextUtils.equals(r7, r8) == true) goto L16;
            return;
        L16:
            if (this.this$0.isSearchInPlaceEnabled() == false) goto L43;
            if (TextUtils.isEmpty(r7) == false) goto L22;
            this.this$0.onSearchCanceledInPlace();
            this.this$0.mSearchQueryHandler.removeMessages(1001);
            return;
        L22:
            if (this.this$0.mQuickBar == null) goto L27;
            if (this.this$0.mQuickBar.getVisibility() == 8) goto L27;
            this.this$0.mQuickBar.setVisibility(8);
        L27:
            if (this.this$0.mListView == null) goto L32;
            if (this.this$0.mSearchEmptyView == null) goto L32;
            this.this$0.mListView.setEmptyView(this.this$0.mSearchEmptyView);
        L32:
            if (this.this$0.mPhonesPickerAdapter == null) goto L34;
        L40:
            this.this$0.mPhonesPickerAdapter.setContacts(this.this$0.getSearchResult(r6), r7);
            this.this$0.mPhonesPickerAdapter.notifyDataSetChanged();
            return;
        L34:
            if (this.this$0.mType != Type.SINGLE) goto L36;
            this.this$0.mPhonesPickerAdapter = new SinglePhonePickerAdapter(this.this$0.getActivity());
        L37:
            this.this$0.mPhonesPickerAdapter.setPickerFragment(this.this$0);
            this.this$0.mPhonesPickerAdapter.setPhotoManger(this.this$0.mPhotoManager);
            this.this$0.onCreateAdapter();
            if (this.this$0.mListView == null) goto L40;
            this.this$0.mListView.setAdapter(this.this$0.mPhonesPickerAdapter);
            goto L40
        L36:
            PhonePickerFragment r9 = this.this$0;
            r9.mPhonesPickerAdapter = r9.initAdapter();
            goto L37
        L43:
            if (TextUtils.isEmpty(r7) == false) goto L50;
            this.this$0.mSearchResultListView.setVisibility(4);
            this.this$0.mSearchResultListView.setAdapter(null);
            if (this.this$0.mSearchResultsPickerAdapter == null) goto L47;
            this.this$0.mSearchResultsPickerAdapter.setContacts(null);
            this.this$0.mSearchResultsPickerAdapter.notifyDataSetChanged();
        L47:
            this.this$0.mSearchEmptyView.setVisibility(8);
            this.this$0.mSearchQueryHandler.removeMessages(1001);
            return;
        L50:
            if (this.this$0.mSearchResultListView.getEmptyView() != null) goto L52;
            this.this$0.mSearchResultListView.setEmptyView(this.this$0.mSearchEmptyView);
        L52:
            ArrayList<SamContact> r10 = this.this$0.getSearchResult(r6);
            if (this.this$0.mSearchResultListView.getAdapter() == null) goto L55;
            this.this$0.mSearchResultsPickerAdapter.setContacts(r10, r7);
            this.this$0.mSearchResultsPickerAdapter.notifyDataSetChanged();
        L61:
            if (this.this$0.mSearchResultListView.getVisibility() != 8) goto L64;
            this.this$0.mSearchResultListView.setVisibility(0);
            return;
        L64:
            return;
        L55:
            if (this.this$0.mType != Type.SINGLE) goto L57;
            this.this$0.mSearchResultsPickerAdapter = new SinglePhonePickerAdapter(this.this$0.getActivity());
        L58:
            this.this$0.mSearchResultsPickerAdapter.setPickerFragment(this.this$0);
            this.this$0.mSearchResultsPickerAdapter.setPhotoManger(this.this$0.mPhotoManager);
            this.this$0.mSearchResultsPickerAdapter.setContacts(r10, r7);
            this.this$0.mSearchResultListView.setAdapter(this.this$0.mSearchResultsPickerAdapter);
            goto L61
        L57:
            PhonePickerFragment r11 = this.this$0;
            r11.mSearchResultsPickerAdapter = r11.initAdapter();
            goto L58
        L11:
            r8 = this.this$0.oSearchEditor.getText().toString().trim();
            goto L13
        }

        public SearchQueryHandler(PhonePickerFragment r1, ContentResolver r2) {
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

    @Override // com.android.contacts.pick.PickerFragment
    protected boolean isSearchInPlaceEnabled() {
        return true;
    }

    public PhonePickerFragment() {
        this.mSelectContactIds = new ArrayList();
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected void onSearchCanceledInPlace() {
        int r1 = 8;
        if (this.mSearchEmptyView == null) goto L6;
        this.mSearchEmptyView.setVisibility(8);
    L6:
        if (this.mListView == null) goto L8;
        setEmptyView(this.mListView);
    L8:
        PickerAdapter r0 = this.mPhonesPickerAdapter;
        if (r0 != null) goto L11;
        notifyData();
    L13:
        if (this.mQuickBar == null) goto L21;
        OIndexScrollbar r2 = this.mQuickBar;
        if (this.mContacts != null) goto L17;
    L19:
        r2.setVisibility(r1);
        return;
    L17:
        if (this.mContacts.size() < 30) goto L19;
        r1 = 0;
        goto L19
    L21:
        return;
    L11:
        r0.setContacts(this.mContacts);
        this.mPhonesPickerAdapter.notifyDataSetChanged();
        goto L13
    }

    public void setType(Type r1) {
        this.mType = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = inflateAndSetupView(r3, r4, r5, R.layout.contact_picker_fragment);
        getActivity().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.mContactsContent);
        triggerLoad();
        this.mSearchQueryHandler = new SearchQueryHandler(this, getActivity().getContentResolver());
        new KeyboardShowListener().monitorKeyboardShow(r6, new AnonymousClass1(this));
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
        if (r2 > r1) goto L24;
        OCheckBox r3 = (OCheckBox) this.mListView.getChildAt(r2 - r0).findViewById(R.id.checkBox);
        if (r3 == null) goto L16;
        if (this.mListView.getAdapter() == null) goto L17;
        if (this.mListView.getAdapter().getCount() <= r2) goto L17;
        r3.setChecked(this.mSelectContactIds.contains(Long.valueOf(((SamContact) this.mListView.getAdapter().getItem(r2)).phoneId)));
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("PhonePickerFragment", "refreshVisibleListItems " + r2);
        return;
    L16:
        r2 = r2 + 1;
        goto L6
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<SamContact> getContacts() {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap();
        ArrayList<SamContact> r2 = new ArrayList();
        Cursor r3 = this.mActivity.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build(), PhoneQuery.getProjection(getDisplayOrder(), getSortOrder()), null, null, PickerFragment.CONTACT_SORT_CNAME);
    L44:
        th = move-exception;
        if (r3 == null) goto L47;
        r3.close();
    L47:
        r0.clear();
        r1.clear();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L40;
    L5:
        boolean r5 = false;
        SamContact r4 = new SamContact(0);     // Catch: Throwable -> L44
        r4.contactId = r3.getLong(4);     // Catch: Throwable -> L44
        r4.number = r3.getString(3);     // Catch: Throwable -> L44
        r4.name = r3.getString(7);     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r4.name) == true) goto L8;
        boolean r6 = true;
    L9:
        r4.hasname = r6;     // Catch: Throwable -> L44
        r4.sortkey = r3.getString(9);     // Catch: Throwable -> L44
        r4.selectedFlag = r3.getString(10);     // Catch: Throwable -> L44
        r4.section = ContactsUtils.getContactSection(r4.sortkey, r4.selectedFlag);     // Catch: Throwable -> L44
        r4.LookKey = r3.getString(5);     // Catch: Throwable -> L44
        r4.photoId = r3.getLong(6);     // Catch: Throwable -> L44
        r4.phoneId = r3.getLong(0);     // Catch: Throwable -> L44
        r4.label = r3.getString(2);     // Catch: Throwable -> L44
        r4.labelres = r3.getInt(1);     // Catch: Throwable -> L44
        SamContact r7 = ContactsUtils.generateIfFamilyNameNeedPolyphone(r4);     // Catch: Throwable -> L44
        if (r7 == null) goto L22;
        if (r1.get(Long.valueOf(r7.contactId)) == null) goto L17;
        List<SamContact> r9 = (List) r1.get(Long.valueOf(r7.contactId));     // Catch: Throwable -> L44
        if (alreadyExistContact(r9, r7) == false) goto L16;
        boolean r10 = false;
    L19:
        if (r10 == false) goto L22;
        r2.add(r7);     // Catch: Throwable -> L44
        goto L22
    L16:
        addToList(r9, r7);     // Catch: Throwable -> L44
    L18:
        r10 = true;
        goto L19
    L17:
        r1.put(Long.valueOf(r7.contactId), addToList(null, r7));     // Catch: Throwable -> L44
    L22:
        if (r0.get(Long.valueOf(r4.contactId)) == null) goto L34;
        List<SamContact> r8 = (List) r0.get(Long.valueOf(r4.contactId));     // Catch: Throwable -> L44
        if (this.mSelectContactIds.contains(Long.valueOf(r4.phoneId)) == true) goto L29;
        if (alreadyExistContact(r8, r4) == false) goto L29;
    L36:
        if (r5 == false) goto L39;
        r2.add(r4);     // Catch: Throwable -> L44
    L39:
        if (r3.moveToNext() == true) goto L5;
    L29:
        if (this.mSelectContactIds.contains(Long.valueOf(r4.phoneId)) == true) goto L31;
    L33:
        addToList(r8, r4);     // Catch: Throwable -> L44
    L35:
        r5 = true;
        goto L36
    L31:
        if (alreadyExistContact(r8, r4) == false) goto L33;
        r8.clear();     // Catch: Throwable -> L44
        r8.add(r4);     // Catch: Throwable -> L44
        goto L35
    L34:
        r0.put(Long.valueOf(r4.contactId), addToList(null, r4));     // Catch: Throwable -> L44
        goto L35
    L8:
        r6 = false;
    L40:
        if (r3 == null) goto L42;
        r3.close();
    L42:
        r0.clear();
        r1.clear();
        Collections.sort(r2, new NameSortComparator());
        return r2;
    }

    private List<SamContact> addToList(List<SamContact> r1, SamContact r2) {
        if (r1 != null) goto L4;
        r1 = new ArrayList();
    L4:
        r1.add(r2);
        return r1;
    }

    private boolean alreadyExistContact(List<SamContact> r7, SamContact r8) {
        Iterator<SamContact> r6 = r7.iterator();
    L4:
        if (r6.hasNext() == false) goto L29;
        SamContact r9 = r6.next();
        String r2 = null;
        if (r9 != null) goto L8;
    L10:
        String r4 = null;
    L11:
        if (r8 != null) goto L13;
    L15:
        if (r9 == null) goto L4;
        if (r8 == null) goto L4;
        if (TextUtils.equals(r9.name, r8.name) == false) goto L4;
        if (TextUtils.equals(r4, r2) == false) goto L4;
        if (TextUtils.equals(r9.label, r8.label) == false) goto L4;
        if (r8.labelres != r9.labelres) goto L4;
        if (r9.contactId != r8.contactId) goto L4;
        return true;
    L13:
        if (r8.number == null) goto L15;
        r2 = r8.number.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "");
        goto L15
    L8:
        if (r9.number == null) goto L10;
        r4 = r9.number.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "");
        goto L11
    L29:
        return false;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<Long> getSelectedIds() {
        return this.mSelectContactIds;
    }

    @Override // com.android.contacts.pick.PickerFragment, com.android.contacts.pick.IPickerSearchBarView
    public void onQueryTextChangeIView(String r4) {
        setSearchString(Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI, Uri.encode(r4)).buildUpon().appendQueryParameter("use_distinct", "false").build(), r4);
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setSearchString(Uri r11, String r12) {
        this.mSearchQueryHandler.removeMessages(1001);
        this.mSearchQueryHandler.startQuery(1001, r12, r11, PhoneQuery.getProjection(getDisplayOrder(), getSortOrder()), null, null, PickerFragment.CONTACT_SORT_CNAME);
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected void onTitleBarBtnClick(View r2) {
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
        r0.sortkey = r7.getString(9);
        r0.phoneBookLabel = r7.getString(10);
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
    public void onPreferencesChanged() {
        triggerLoad();
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void notifyData() {
        if (this.mContacts != null) goto L5;
        this.mContacts = new ArrayList();
    L5:
        OIndexScrollbar r0 = this.mQuickBar;
        if (this.mContacts.size() < 30) goto L8;
        int r1 = 0;
    L9:
        r0.setVisibility(r1);
        PickerAdapter r2 = this.mPhonesPickerAdapter;
        if (r2 == null) goto L12;
        r2.setContacts(this.mContacts);
        this.mPhonesPickerAdapter.notifyDataSetChanged();
        return;
    L12:
        if (this.mType != Type.SINGLE) goto L14;
        this.mPhonesPickerAdapter = new SinglePhonePickerAdapter(getActivity());
    L15:
        this.mPhonesPickerAdapter.setPickerFragment(this);
        this.mPhonesPickerAdapter.setContacts(this.mContacts);
        this.mPhonesPickerAdapter.setPhotoManger(this.mPhotoManager);
        onCreateAdapter();
        this.mListView.setAdapter(this.mPhonesPickerAdapter);
        setEmptyView(this.mListView);
        return;
    L14:
        this.mPhonesPickerAdapter = initAdapter();
        goto L15
    L8:
        r1 = 8;
        goto L9
    }

    protected void onCreateAdapter() {
        this.mBtnRightDone.setClickable(!this.mSelectContactIds.isEmpty());
        this.mFloatingTitleBarHolder.getEndButtonGroup().setEnabled(!this.mSelectContactIds.isEmpty());
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        this.mTitleBar.setCenterTitle(R.string.contactPickerActivityTitle);
        Intent r0 = getActivity().getIntent();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getBooleanExtra(ContactsSettingActivity.INTENT_PARAMS_IS_CLICK_EMERGENCY, false) == false) goto L9;
        this.mTitleBar.setCenterTitle(R.string.setting_emergency_contacts_add);
        return;
    }

    public PickerAdapter initAdapter() {
        return new MultiPhonesPickerAdapter(getActivity());
    }
}
