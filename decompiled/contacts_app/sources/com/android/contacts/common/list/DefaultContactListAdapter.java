package com.android.contacts.common.list;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import androidx.loader.content.CursorLoader;
import com.android.contacts.common.Experiments;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.compat.ContactsCompat;
import com.android.contacts.commonbind.experiments.Flags;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.util.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DefaultContactListAdapter extends ContactListAdapter {
    private static final long LAST_TIME_USED_14_DAYS_SEC = 1209600;
    private static final long LAST_TIME_USED_30_DAYS_SEC = 2592000;
    private static final long LAST_TIME_USED_3_DAYS_SEC = 259200;
    private static final long LAST_TIME_USED_7_DAYS_SEC = 604800;
    public static final char SNIPPET_END_MATCH = ']';
    public static final char SNIPPET_START_MATCH = '[';
    private static final String STREQUENT_SORT = "(CASE WHEN (strftime('%s', 'now') - last_time_contacted/1000) < 259200 THEN 0  WHEN (strftime('%s', 'now') - last_time_contacted/1000) < 604800 THEN 1  WHEN (strftime('%s', 'now') - last_time_contacted/1000) < 1209600 THEN 2  WHEN (strftime('%s', 'now') - last_time_contacted/1000) < 2592000 THEN 3  ELSE 4 END), times_contacted DESC, starred DESC";
    private static final String TIME_SINCE_LAST_USED_SEC = "(strftime('%s', 'now') - last_time_contacted/1000)";
    private Context mContext;

    public DefaultContactListAdapter(Context r1) {
        super(r1);
        this.mContext = r1;
    }

    private void appendUriQueryParameterWithoutSim(CursorLoader r1, String r2, String r3) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L11;
        if (r3 == null) goto L13;
        Uri r0 = r1.getUri();
        if (r0 == null) goto L12;
        r1.setUri(r0.buildUpon().appendQueryParameter(r2, r3).appendQueryParameter(SimContactsConstants.WITHOUT_SIM_FLAG, "true").build());
        return;
    L12:
        return;
    L13:
        return;
    L11:
        return;
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r7, long r8) {
        if ((r7 instanceof ProfileAndContactsLoader) == false) goto L5;
        ((ProfileAndContactsLoader) r7).setLoadProfile(shouldIncludeProfile());
    L5:
        String r3 = null;
        if (isSearchMode() == false) goto L21;
        Flags r0 = Flags.getInstance(this.mContext);
        String r4 = getQueryString();
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        String r5 = r4.trim();
        if (TextUtils.isEmpty(r5) == false) goto L13;
        r7.setUri(ContactsContract.Contacts.CONTENT_URI);
        r7.setProjection(getProjection(false));
        r7.setSelection("0");
    L16:
        ContactListFilter r9 = getFilter();
        if (r9 == null) goto L23;
        if (r9.filterType != 2) goto L23;
        appendUriQueryParameterWithoutSim(r7, "account_type", "com.android.sim");
    L23:
        if (getSortOrder() != 1) goto L27;
        if (r3 != null) goto L26;
        String r6 = PickerFragment.CONTACT_SORT_CNAME;
    L30:
        r7.setSortOrder(r6);
        return;
    L26:
        r6 = r3 + ", sort_key";
        goto L30
    L27:
        if (r3 != null) goto L29;
        r6 = "sort_key_alt";
        goto L30
    L29:
        r6 = r3 + ", sort_key_alt";
        goto L30
    L13:
        Uri.Builder r10 = ContactsCompat.getContentUri().buildUpon();
        appendSearchParameters(r10, r5, r8);
        r7.setUri(r10.build());
        r7.setProjection(getProjection(true));
        if (r0.getBoolean(Experiments.FLAG_SEARCH_STREQUENTS_FIRST, false) == false) goto L16;
        r3 = STREQUENT_SORT;
        goto L16
    L21:
        ContactListFilter r1 = getFilter();
        configureUri(r7, r8, r1);
        r7.setProjection(getProjection(false));
        configureSelection(r7, r8, r1);
        goto L23
    }

    private void appendSearchParameters(Uri.Builder r3, String r4, long r5) {
        r3.appendPath(r4);
        r3.appendQueryParameter("directory", String.valueOf(r5));
        if (r5 != 0) goto L5;
    L7:
        r3.appendQueryParameter(Constants.DEFERRED_SNIPPETING_KEY, "1");
        return;
    L5:
        if (r5 == 1) goto L7;
        r3.appendQueryParameter("limit", String.valueOf(getDirectoryResultLimit(getDirectoryById(r5))));
        goto L7
    }

    protected void configureUri(CursorLoader r5, long r6, ContactListFilter r8) {
        Uri r0 = ContactsContract.Contacts.CONTENT_URI;
        if (r8 == null) goto L11;
        if (r8.filterType != (-6)) goto L11;
        String r1 = getSelectedContactLookupKey();
        if (r1 == null) goto L9;
        r0 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, r1);
        goto L11
    L9:
        r0 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, getSelectedContactId());
    L11:
        if (r6 == 0) goto L13;
    L15:
        if (r8 != null) goto L17;
    L24:
        r5.setUri(r0);
        return;
    L17:
        if (r8.filterType == (-3)) goto L24;
        if (r8.filterType == (-6)) goto L24;
        Uri.Builder r4 = r0.buildUpon();
        r4.appendQueryParameter("directory", String.valueOf(0));
        if (r8.filterType != 0) goto L23;
        r8.addAccountQueryParameterToUrl(r4);
    L23:
        r0 = r4.build();
        goto L24
    L13:
        if (isSectionHeaderDisplayEnabled() == false) goto L15;
        r0 = ContactListAdapter.buildSectionIndexerUri(r0);
        goto L15
    }

    private void configureSelection(CursorLoader r3, long r4, ContactListFilter r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r4 == 0) goto L7;
        return;
    L7:
        StringBuilder r5 = new StringBuilder();
        ArrayList r7 = new ArrayList();
        int r8 = r6.filterType;
        if (r8 != (-7)) goto L10;
        String r9 = MoreContactUtils.getSimFilter(this.mContext);
        if (TextUtils.isEmpty(r9) == true) goto L27;
        appendUriQueryParameterWithoutSim(r3, "account_name", r9);
    L27:
        r3.setSelection(r5.toString());
        r3.setSelectionArgs((String[]) r7.toArray(new String[0]));
        return;
    L10:
        if (r8 != 2) goto L12;
        appendUriQueryParameterWithoutSim(r3, "account_type", "com.android.sim");
        goto L27
    L12:
        if (r8 != (-5)) goto L14;
        r5.append("has_phone_number=1");
        goto L27
    L14:
        if (r8 != (-4)) goto L16;
        r5.append("starred!=0");
        goto L27
    L16:
        if (r8 != (-3)) goto L27;
        r5.append("in_visible_group=1");
        if (isCustomFilterForPhoneNumbersOnly() == false) goto L27;
        r5.append(" AND has_phone_number=1");
        goto L27
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r16, int r17, Cursor r18, int r19) {
        super.bindView(r16, r17, r18, r19);
        ContactListItemView r13 = (ContactListItemView) r16;
        if (isSearchMode() == false) goto L5;
        String r0 = getUpperCaseQueryString();
    L6:
        r13.setHighlightedPrefix(r0);
        if (isSelectionVisible() == false) goto L9;
        r13.setActivated(isSelectedContact(r17, r18));
    L9:
        bindSectionHeaderAndDivider(r13, r19, r18);
        if (isQuickContactEnabled() == false) goto L13;
        bindQuickContact(r13, r17, r18, 4, 5, 0, 6, 1, 9, 10);
    L15:
        bindNameAndViewId(r13, r18);
        bindPresenceAndStatusMessage(r13, r18);
        if (isSearchMode() == false) goto L18;
        bindSearchSnippet(r13, r18);
        return;
    L18:
        r13.setSnippet(null);
        return;
    L13:
        if (getDisplayPhotos() == false) goto L15;
        bindPhoto(r13, r17, r18);
        goto L15
    L5:
        r0 = null;
        goto L6
    }

    private boolean isCustomFilterForPhoneNumbersOnly() {
        return PreferenceManager.getDefaultSharedPreferences(getContext()).getBoolean("only_phones", false);
    }
}
