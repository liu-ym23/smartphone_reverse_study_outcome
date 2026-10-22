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
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EmailPickerFragment extends PickerFragment {
    protected PickerAdapter mPhonesPickerAdapter;
    protected SearchQueryHandler mSearchQueryHandler;
    protected PickerAdapter mSearchResultsPickerAdapter;
    protected ArrayList<Long> mSelectContactIds;
    protected ArrayList<Long> mSelectedIds2Remove;
    protected Type mType;

    public static class EmailQuery {
        public static final int EMAIL_ADDRESS = 3;
        public static final int EMAIL_CONTACT_ID = 4;
        public static final int EMAIL_DISPLAY_NAME = 7;
        public static final int EMAIL_ID = 0;
        public static final int EMAIL_LABEL = 2;
        public static final int EMAIL_LOOKUP_KEY = 5;
        public static final int EMAIL_PHOTO_ID = 6;
        public static final int EMAIL_SORT_KEY = 8;
        public static final int EMAIL_TYPE = 1;
        public static final int PHONEBOOK_LABEL_PRIMARY = 9;
        private static final String[] PROJECTION = null;

        public EmailQuery() {
        }

        static {
            PROJECTION = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name", PickerFragment.CONTACT_SORT_CNAME, Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        }

        public static String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            PROJECTION[7] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            PROJECTION[8] = "sort_key_alt";
        L11:
            return PROJECTION;
        L9:
            PROJECTION[8] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            PROJECTION[7] = "display_name";
            goto L7
        }
    }

    public class SearchQueryHandler extends AsyncQueryHandler {
        final /* synthetic */ EmailPickerFragment this$0;

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r3, Object r4, Cursor r5) {
            super.onQueryComplete(r3, r4, r5);
            if (r3 == 1002) goto L6;
            return;
        L6:
            if (this.this$0.getActivity() != null) goto L8;
            return;
        L8:
            String r6 = (String) r4;
            if (TextUtils.isEmpty(r6) == false) goto L16;
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
            if (this.this$0.mSearchResultListView.getEmptyView() != null) goto L19;
            this.this$0.mSearchResultListView.setEmptyView(this.this$0.mSearchEmptyView);
        L19:
            if (this.this$0.mSearchResultListView.getVisibility() != 8) goto L21;
            this.this$0.mSearchResultListView.setVisibility(0);
        L21:
            ArrayList<SamContact> r7 = EmailPickerFragment.access$000(this.this$0, r5);
            if (this.this$0.mSearchResultListView.getAdapter() == null) goto L24;
            this.this$0.mSearchResultsPickerAdapter.setContacts(r7, r6);
            this.this$0.mSearchResultsPickerAdapter.notifyDataSetChanged();
            return;
        L24:
            if (this.this$0.mType != Type.SINGLE) goto L26;
            EmailPickerFragment r8 = this.this$0;
            r8.mSearchResultsPickerAdapter = new SingleEmailPickerAdapter(this.this$0.getActivity());
        L27:
            this.this$0.mSearchResultsPickerAdapter.setPickerFragment(this.this$0);
            this.this$0.mSearchResultsPickerAdapter.setPhotoManger(this.this$0.mPhotoManager);
            this.this$0.mSearchResultsPickerAdapter.setContacts(r7, r6);
            this.this$0.mSearchResultListView.setAdapter(this.this$0.mSearchResultsPickerAdapter);
            return;
        L26:
            EmailPickerFragment r9 = this.this$0;
            r9.mSearchResultsPickerAdapter = new MultiEmailsPickerAdapter(this.this$0.getActivity());
            goto L27
        }

        public SearchQueryHandler(EmailPickerFragment r1, ContentResolver r2) {
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

    public EmailPickerFragment() {
        this.mSelectContactIds = new ArrayList();
        this.mSelectedIds2Remove = new ArrayList();
    }

    static /* synthetic */ ArrayList access$000(EmailPickerFragment r0, Cursor r1) {
        return r0.getSearchResult(r1);
    }

    public void setType(Type r1) {
        this.mType = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = inflateAndSetupView(r3, r4, r5, R.layout.contact_picker_fragment);
        getActivity().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Email.CONTENT_URI, true, this.mContactsContent);
        triggerLoad();
        this.mSearchQueryHandler = new SearchQueryHandler(this, getActivity().getContentResolver());
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
        if (r2 > r1) goto L15;
        View r3 = this.mListView.getChildAt(r2 - r0);
        if (r3 == null) goto L10;
        OCheckBox r4 = (OCheckBox) r3.findViewById(R.id.checkBox);
    L11:
        if (r4 == null) goto L14;
        long r5 = ((SamContact) this.mListView.getAdapter().getItem(r2)).phoneId;
        r4.setChecked(this.mSelectContactIds.contains(Long.valueOf(r5)));
    L14:
        r2 = r2 + 1;
        goto L6
    L10:
        r4 = null;
        goto L11
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<SamContact> getContacts() {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap();
        ArrayList<SamContact> r2 = new ArrayList();
        Cursor r3 = this.mActivity.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build(), EmailQuery.getProjection(getDisplayOrder(), getSortOrder()), null, null, PickerFragment.CONTACT_SORT_CNAME);
        ArrayList r4 = new ArrayList();
        r4.addAll(this.mSelectedIds2Remove);
    L43:
        th = move-exception;
        if (r3 == null) goto L46;
        r3.close();
    L46:
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L39;
    L5:
        boolean r6 = false;
        SamContact r5 = new SamContact(0);     // Catch: Throwable -> L43
        r5.phoneId = r3.getLong(0);     // Catch: Throwable -> L43
        r5.contactId = r3.getLong(4);     // Catch: Throwable -> L43
        r5.number = r3.getString(3);     // Catch: Throwable -> L43
        r5.name = r3.getString(7);     // Catch: Throwable -> L43
        r5.label = r3.getString(2);     // Catch: Throwable -> L43
        r5.labelres = r3.getInt(1);     // Catch: Throwable -> L43
        if (r4.contains(Long.valueOf(r5.phoneId)) == false) goto L12;
        r4.remove(Long.valueOf(r5.phoneId));     // Catch: Throwable -> L43
        if (r0.get(Long.valueOf(r5.contactId)) == null) goto L10;
        addToList((List) r0.get(Long.valueOf(r5.contactId)), r5);     // Catch: Throwable -> L43
    L38:
        if (r3.moveToNext() == true) goto L5;
    L10:
        r0.put(Long.valueOf(r5.contactId), addToList(null, r5));     // Catch: Throwable -> L43
        goto L38
    L12:
        if (TextUtils.isEmpty(r5.name) == true) goto L14;
        boolean r8 = true;
    L15:
        r5.hasname = r8;     // Catch: Throwable -> L43
        r5.sortkey = r3.getString(8);     // Catch: Throwable -> L43
        r5.phoneBookLabel = r3.getString(9);     // Catch: Throwable -> L43
        r5.section = ContactsUtils.getContactSection(r5.sortkey, r5.phoneBookLabel);     // Catch: Throwable -> L43
        r5.LookKey = r3.getString(5);     // Catch: Throwable -> L43
        r5.photoId = r3.getLong(6);     // Catch: Throwable -> L43
        SamContact r9 = ContactsUtils.generateIfFamilyNameNeedPolyphone(r5);     // Catch: Throwable -> L43
        if (r9 == null) goto L28;
        if (r1.get(Long.valueOf(r9.contactId)) == null) goto L23;
        List<SamContact> r10 = (List) r1.get(Long.valueOf(r9.contactId));     // Catch: Throwable -> L43
        if (alreadyExistContact(r10, r9) == false) goto L22;
        boolean r11 = false;
    L25:
        if (r11 == false) goto L28;
        r2.add(r9);     // Catch: Throwable -> L43
        goto L28
    L22:
        addToList(r10, r9);     // Catch: Throwable -> L43
    L24:
        r11 = true;
        goto L25
    L23:
        r1.put(Long.valueOf(r9.contactId), addToList(null, r9));     // Catch: Throwable -> L43
    L28:
        if (r0.get(Long.valueOf(r5.contactId)) == null) goto L33;
        List<SamContact> r12 = (List) r0.get(Long.valueOf(r5.contactId));     // Catch: Throwable -> L43
        if (alreadyExistContact(r12, r5) == true) goto L35;
        addToList(r12, r5);     // Catch: Throwable -> L43
    L34:
        r6 = true;
    L35:
        if (r6 == false) goto L38;
        r2.add(r5);     // Catch: Throwable -> L43
        goto L38
    L33:
        r0.put(Long.valueOf(r5.contactId), addToList(null, r5));     // Catch: Throwable -> L43
        goto L34
    L14:
        r8 = false;
    L39:
        if (r3 == null) goto L41;
        r3.close();
    L41:
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

    private boolean alreadyExistContact(List<SamContact> r5, SamContact r6) {
        Iterator<SamContact> r4 = r5.iterator();
    L4:
        if (r4.hasNext() == false) goto L17;
        SamContact r7 = r4.next();
        if (TextUtils.equals(r7.name, r6.name) == false) goto L4;
        if (TextUtils.equals(r7.number, r6.number) == false) goto L4;
        if (TextUtils.equals(r7.label, r6.label) == false) goto L4;
        if (r6.labelres != r7.labelres) goto L4;
        if (r7.contactId != r6.contactId) goto L4;
        return true;
    L17:
        return false;
    }

    @Override // com.android.contacts.pick.PickerFragment
    public ArrayList<Long> getSelectedIds() {
        return this.mSelectContactIds;
    }

    @Override // com.android.contacts.pick.PickerFragment, com.android.contacts.pick.IPickerSearchBarView
    public void onQueryTextChangeIView(String r4) {
        setSearchString(Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI, Uri.encode("%25" + r4, "%")), r4);
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setSearchString(Uri r11, String r12) {
        this.mSearchQueryHandler.removeMessages(1002);
        this.mSearchQueryHandler.startQuery(1002, r12, r11, EmailQuery.getProjection(getDisplayOrder(), getSortOrder()), null, null, PickerFragment.CONTACT_SORT_CNAME);
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected void onTitleBarBtnClick(View r2) {
        if (r2 != this.mBtnRightDone) goto L6;
        this.mPickerListener.onPickDatasAction(ContactsContract.CommonDataKinds.Email.CONTENT_URI, getSelectedIds());
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

    private ArrayList<SamContact> getSearchResult(Cursor r9) {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.mSelectedIds2Remove);
        ArrayList<SamContact> r8 = new ArrayList();
        if (r9 != null) goto L5;
    L13:
        return r8;
    L5:
        if (r9.moveToFirst() == false) goto L12;
    L6:
        long r2 = r9.getLong(0);
        if (r0.contains(Long.valueOf(r2)) == false) goto L9;
        r0.remove(Long.valueOf(r2));
    L11:
        if (r9.moveToNext() == true) goto L6;
    L9:
        SamContact r4 = new SamContact(0);
        r4.contactId = r9.getLong(4);
        r4.number = r9.getString(3);
        r4.name = r9.getString(7);
        r4.hasname = !TextUtils.isEmpty(r4.name);
        r4.sortkey = r9.getString(8);
        r4.phoneBookLabel = r9.getString(9);
        r4.section = ContactsUtils.getContactSection(r4.sortkey, r4.phoneBookLabel);
        r4.LookKey = r9.getString(5);
        r4.photoId = r9.getLong(6);
        r4.phoneId = r2;
        r4.label = r9.getString(2);
        r4.labelres = r9.getInt(1);
        r8.add(r4);
    L12:
        Collections.sort(r8, new NameSortComparator());
        goto L13
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void onPreferencesChanged() {
        triggerLoad();
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
        this.mPhonesPickerAdapter = new SingleEmailPickerAdapter(getActivity());
    L12:
        this.mPhonesPickerAdapter.setPickerFragment(this);
        this.mPhonesPickerAdapter.setContacts(this.mContacts);
        this.mPhonesPickerAdapter.setPhotoManger(this.mPhotoManager);
        this.mListView.setAdapter(this.mPhonesPickerAdapter);
        setEmptyView(this.mListView);
        return;
    L11:
        this.mPhonesPickerAdapter = new MultiEmailsPickerAdapter(getActivity());
        goto L12
    L5:
        r1 = 8;
        goto L6
    }

    @Override // com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        this.mTitleBar.setCenterTitle(R.string.picker_title_email);
    }
}
