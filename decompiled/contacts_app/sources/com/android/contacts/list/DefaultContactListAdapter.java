package com.android.contacts.list;

import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import com.android.contacts.util.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultContactListAdapter extends ContactListAdapter {
    public static final String SNIPPET_ARGS = "\u0001,\u0001,…,5";
    public static final String SNIPPET_ELLIPSIS = "…";
    public static final char SNIPPET_END_MATCH = 1;
    public static final int SNIPPET_MAX_TOKENS = 5;
    public static final char SNIPPET_START_MATCH = 1;
    private String TAG;
    private boolean isCityMode;

    public DefaultContactListAdapter(Context r1) {
        super(r1);
        this.isCityMode = false;
        this.TAG = "DefaultContactListAdapter";
    }

    @Override // com.android.contacts.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r5, long r6) {
        if ((r5 instanceof ProfileAndContactsLoader) == false) goto L5;
        ((ProfileAndContactsLoader) r5).setLoadProfile(shouldIncludeProfile());
    L5:
        ContactListFilter r0 = getFilter();
        if (isSearchMode() == false) goto L23;
        String r1 = getQueryString();
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        String r2 = r1.trim();
        if (TextUtils.isEmpty(r2) == false) goto L13;
        r5.setUri(ContactsContract.Contacts.CONTENT_URI);
        r5.setProjection(getProjection(false));
        r5.setSelection("0");
    L27:
        if (this.isCityMode == true) goto L31;
        r5.setSortOrder("sort_key_alt ASC , sort_key ASC ");
        return;
    L31:
        return;
    L13:
        Uri.Builder r3 = ContactsContract.Contacts.CONTENT_FILTER_URI.buildUpon();
        r3.appendPath(r2);
        r3.appendQueryParameter("directory", String.valueOf(r6));
        if (r6 == 0) goto L19;
        if (r6 == 1) goto L19;
        r3.appendQueryParameter("limit", String.valueOf(getDirectoryResultLimit()));
    L19:
        if (Constants.ANDROID50 == true) goto L21;
        r3.appendQueryParameter(Constants.SNIPPET_ARGS_PARAM_KEY, SNIPPET_ARGS);
        r3.appendQueryParameter(Constants.DEFERRED_SNIPPETING_KEY, "1");
    L21:
        r5.setUri(r3.build());
        r5.setProjection(getProjection(true));
        goto L27
    L23:
        if (this.isCityMode == false) goto L25;
        configureCityModeUri(r5, r6, r0);
        r5.setProjection(getProjection(false));
        configureSelection(r5, r6, r0);
        goto L27
    L25:
        configureUri(r5, r6, r0);
        r5.setProjection(getProjection(false));
        configureSelection(r5, r6, r0);
        goto L27
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
    L21:
        r5.setUri(r0);
        return;
    L17:
        if (r8.filterType == (-3)) goto L21;
        if (r8.filterType == (-6)) goto L21;
        r0 = r0.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build();
        goto L21
    L13:
        if (isSectionHeaderDisplayEnabled() == false) goto L15;
        r0 = buildSectionIndexerUri(r0);
        goto L15
    }

    protected void configureCityModeUri(CursorLoader r1, long r2, ContactListFilter r4) {
        r1.setUri(Uri.parse("content://com.android.contacts/contacts_city"));
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
        int r0 = r6.filterType;
        if (r0 != (-5)) goto L10;
        r5.append("has_phone_number=1");
    L25:
        r3.setSelection(r5.toString());
        r3.setSelectionArgs((String[]) r7.toArray(new String[0]));
        return;
    L10:
        if (r0 != (-4)) goto L12;
        r5.append("starred!=0");
        goto L25
    L12:
        if (r0 == (-3)) goto L20;
        if (r0 != 0) goto L25;
        r5.append("_id IN (SELECT DISTINCT contact_id FROM raw_contacts WHERE account_type=? AND account_name=?");
        r7.add(r6.accountType);
        r7.add(r6.accountName);
        if (r6.dataSet == null) goto L18;
        r5.append(" AND data_set=?");
        r7.add(r6.dataSet);
    L19:
        r5.append(")");
        goto L25
    L18:
        r5.append(" AND data_set IS NULL");
        goto L19
    L20:
        r5.append("in_visible_group=1");
        if (isCustomFilterForPhoneNumbersOnly() == false) goto L25;
        r5.append(" AND has_phone_number=1");
        goto L25
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r10, int r11, Cursor r12, int r13) {
        ContactListItemView r14 = (ContactListItemView) r10;
        if (isSearchMode() == false) goto L5;
        char[] r0 = getUpperCaseQueryString();
    L6:
        r14.setHighlightedPrefix(r0);
        if (isSelectionVisible() == false) goto L9;
        r14.setActivated(isSelectedContact(r11, r12));
    L9:
        bindSectionHeaderAndDivider(r14, r13, r12);
        if (isQuickContactEnabled() == false) goto L12;
        bindQuickContact(r14, r11, r12, 4, 0, 6, 1);
    L13:
        bindName(r14, r12);
        bindPresenceAndStatusMessage(r14, r12);
        if (isSearchMode() == false) goto L16;
        bindSearchSnippet(r14, r12);
        return;
    L16:
        r14.setSnippet(null);
        return;
    L12:
        bindPhoto(r14, r11, r12);
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    private boolean isCustomFilterForPhoneNumbersOnly() {
        return PreferenceManager.getDefaultSharedPreferences(getContext()).getBoolean("only_phones", false);
    }
}
