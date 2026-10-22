package com.android.contacts.pick;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.list.SamContact;
import com.android.contacts.util.Constants;
import com.android.contacts.util.NameSortComparator;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.oui.button.OButtonGroup;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class UnFavoritedPhonesPickerFragment extends MultiPhonesPickerFragment {

    private static class UnFavoritePhonesQuery {
        public static final int PHONEBOOK_LABEL_PRIMARY = 11;
        public static final int PHONE_CONTACT_ID = 9;
        public static final int PHONE_DISPLAY_NAME = 8;
        public static final int PHONE_ID = 5;
        public static final int PHONE_LABEL = 3;
        public static final int PHONE_LOOKUP_KEY = 7;
        public static final int PHONE_NORMALIZED_NUMBER = 4;
        public static final int PHONE_NUMBER = 1;
        public static final int PHONE_PHOTO_ID = 6;
        public static final int PHONE_RAW_CONTACT_ID = 0;
        public static final int PHONE_SORT_KEY = 10;
        public static final int PHONE_TYPE = 2;
        public static final String SELECTION = "data15 IS NULL OR data15 != 1";
        private static final String[] sProjection = null;

        private UnFavoritePhonesQuery() {
        }

        static {
            sProjection = new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "_id", "photo_id", "lookup", "display_name", "contact_id", PickerFragment.CONTACT_SORT_CNAME, Constants.ContactsColumns.PHONEBOOK_LABEL_ALTERNATIVE};
        }

        public static String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            sProjection[8] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            sProjection[10] = "sort_key_alt";
        L11:
            return sProjection;
        L9:
            sProjection[10] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            sProjection[8] = "display_name";
            goto L7
        }
    }

    public UnFavoritedPhonesPickerFragment() {
    }

    @Override // com.android.contacts.pick.PhonePickerFragment, com.android.contacts.pick.PickerFragment
    public ArrayList<SamContact> getContacts() {
        ArrayList<SamContact> r0 = new ArrayList();
        Cursor r9 = getActivity().getApplicationContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build().buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build(), UnFavoritePhonesQuery.getProjection(getDisplayOrder(), getSortOrder()), UnFavoritePhonesQuery.SELECTION, null, PickerFragment.CONTACT_SORT_CNAME);
        if (r9 != null) goto L29;
    L25:
        if (r9 == null) goto L27;
        r9.close();
    L27:
        Collections.sort(r0, new NameSortComparator());
        return r0;
    L29:
    L21:
        th = move-exception;
        if (r9 == null) goto L24;
        r9.close();
    L24:
        throw th;
    L5:
        if (r9.moveToFirst() == false) goto L25;
    L6:
        boolean r2 = false;
        SamContact r1 = new SamContact(0);     // Catch: Throwable -> L21
        long r3 = r9.getLong(0);     // Catch: Throwable -> L21
        r1.photoId = r9.getLong(6);     // Catch: Throwable -> L21
        r1.LookKey = r9.getString(7);     // Catch: Throwable -> L21
        String r6 = r9.getString(1);     // Catch: Throwable -> L21
        r1.phoneId = r9.getLong(5);     // Catch: Throwable -> L21
        r1.raw_contactid = r3;     // Catch: Throwable -> L21
        r1.number = r6;     // Catch: Throwable -> L21
        String r4 = r9.getString(3);     // Catch: Throwable -> L21
        if (r4 == null) goto L9;
        r1.label = r4;     // Catch: Throwable -> L21
    L12:
        r1.name = r9.getString(8);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r1.name) == true) goto L15;
        r2 = true;
    L15:
        r1.hasname = r2;     // Catch: Throwable -> L21
        r1.sortkey = r9.getString(10);     // Catch: Throwable -> L21
        r1.phoneBookLabel = r9.getString(11);     // Catch: Throwable -> L21
        r1.section = ContactsUtils.getContactSection(r1.sortkey, r1.phoneBookLabel);     // Catch: Throwable -> L21
        r1.contactId = r9.getLong(9);     // Catch: Throwable -> L21
        SamContact r5 = ContactsUtils.generateIfFamilyNameNeedPolyphone(r1);     // Catch: Throwable -> L21
        if (r5 == null) goto L18;
        r0.add(r5);     // Catch: Throwable -> L21
    L18:
        r0.add(r1);     // Catch: Throwable -> L21
        if (r9.moveToNext() == true) goto L6;
    L9:
        String r7 = r9.getString(2);     // Catch: Throwable -> L21
        if (r7 == null) goto L12;
        r1.labelres = Integer.valueOf(r7).intValue();     // Catch: Throwable -> L21
        goto L12
    }

    @Override // com.android.contacts.pick.PhonePickerFragment, com.android.contacts.pick.PickerFragment
    public void setSearchString(Uri r11, String r12) {
        this.mSearchQueryHandler.removeMessages(1001);
        this.mSearchQueryHandler.startQuery(1001, r12, r11, PhonePickerFragment.PhoneQuery.getProjection(getDisplayOrder(), getSortOrder()), UnFavoritePhonesQuery.SELECTION, null, PickerFragment.CONTACT_SORT_CNAME);
    }

    @Override // com.android.contacts.pick.MultiPhonesPickerFragment, com.android.contacts.pick.PhonePickerFragment
    protected void onCreateAdapter() {
        boolean r1 = false;
        this.mPhonesPickerAdapter.setDisplaySelectedItems(false);
        int r0 = this.mSelectPhoneNumbers.size();
        View r2 = this.mBtnRightDone;
        if (r0 <= 0) goto L5;
        boolean r4 = true;
    L6:
        r2.setClickable(r4);
        OButtonGroup r5 = this.mFloatingTitleBarHolder.getEndButtonGroup();
        if (r5 == null) goto L12;
        if (r0 <= 0) goto L10;
        r1 = true;
    L10:
        r5.setEnabled(r1);
        return;
    L12:
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.android.contacts.pick.PhonePickerFragment, com.android.contacts.pick.PickerFragment
    public void setTitleLabel() {
        this.mTitleBar.setCenterTitle(getString(R.string.contactPickerActivityTitle));
    }

    @Override // com.android.contacts.pick.MultiPhonesPickerFragment
    protected void onSelectContactChanged() {
        super.onSelectContactChanged();
    }

    @Override // com.android.contacts.pick.MultiPhonesPickerFragment, com.android.contacts.pick.PickerFragment
    public void updateTitleLabel(int r4) {
        this.mTitleBar.setCenterTitle(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r4)}));
    }

    @Override // com.android.contacts.pick.PhonePickerFragment, com.android.contacts.pick.PickerFragment
    protected void onTitleBarBtnClick(View r2) {
        if (r2 != this.mBtnRightDone) goto L6;
        this.mPickerListener.onPickunStarredNumsAction(this.mSelectPhoneNumbers);
        return;
    L6:
        if (r2 != this.mBtnLeftCancel) goto L10;
        getActivity().finish();
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment
    protected String getEmptyTitle() {
        return getString(R.string.no_contacts_list);
    }
}
