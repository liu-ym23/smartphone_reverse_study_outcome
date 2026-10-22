package com.android.contacts.list;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import com.android.contacts.R;
import com.android.contacts.pick.PickerFragment;

/* JADX INFO: loaded from: classes2.dex */
public class JoinContactListAdapter extends com.android.contacts.common.list.ContactListAdapter {
    private static final int MAX_SUGGESTIONS = 4;
    public static final int PARTITION_ALL_CONTACTS = 1;
    public static final int PARTITION_SUGGESTIONS = 0;
    private long mTargetContactId;

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected void bindHeaderView(View r1, int r2, Cursor r3) {
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return false;
    }

    public JoinContactListAdapter(Context r1) {
        super(r1);
        setPinnedPartitionHeadersEnabled(true);
        setSectionHeaderDisplayEnabled(true);
        setIndexedPartition(1);
        setDirectorySearchMode(0);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    protected void addPartitions() {
        addPartition(false, true);
        addPartition(createDefaultDirectoryPartition());
    }

    public void setTargetContactId(long r1) {
        this.mTargetContactId = r1;
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public void configureLoader(CursorLoader r5, long r6) {
        JoinContactLoader r7 = (JoinContactLoader) r5;
        Uri.Builder r8 = ContactsContract.Contacts.CONTENT_URI.buildUpon();
        r8.appendEncodedPath(String.valueOf(this.mTargetContactId));
        r8.appendEncodedPath("suggestions");
        String r9 = getQueryString();
        if (TextUtils.isEmpty(r9) == true) goto L5;
        r8.appendEncodedPath(Uri.encode(r9));
    L5:
        r8.appendQueryParameter("limit", String.valueOf(4));
        r7.setSuggestionUri(r8.build());
        r7.setProjection(getProjection(false));
        if (TextUtils.isEmpty(r9) == true) goto L8;
        Uri r10 = buildSectionIndexerUri(ContactsContract.Contacts.CONTENT_FILTER_URI).buildUpon().appendEncodedPath(Uri.encode(r9)).appendQueryParameter("directory", String.valueOf(0)).build();
    L9:
        r7.setUri(r10);
        r7.setSelection("_id!=?");
        r7.setSelectionArgs(new String[]{String.valueOf(this.mTargetContactId)});
        if (getSortOrder() != 1) goto L12;
        r7.setSortOrder(PickerFragment.CONTACT_SORT_CNAME);
        return;
    L12:
        r7.setSortOrder("sort_key_alt");
        return;
    L8:
        r10 = buildSectionIndexerUri(ContactsContract.Contacts.CONTENT_URI).buildUpon().appendQueryParameter("directory", String.valueOf(0)).build();
        goto L9
    }

    public void setSuggestionsCursor(Cursor r2) {
        changeCursor(0, r2);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public void changeCursor(Cursor r2) {
        changeCursor(1, r2);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter
    public void configureDefaultPartition(boolean r1, boolean r2) {
        super.configureDefaultPartition(false, true);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    public int getItemViewType(int r1, int r2) {
        return super.getItemViewType(r1, r2);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected View newHeaderView(Context r2, int r3, Cursor r4, ViewGroup r5) {
        if (r3 != 0) goto L5;
        View r1 = inflate(R.layout.join_contact_picker_section_header, r5);
        ((TextView) r1.findViewById(R.id.text)).setText(R.string.separatorJoinAggregateSuggestions);
        return r1;
    L5:
        if (r3 == 1) goto L8;
        return null;
    L8:
        View r6 = inflate(R.layout.join_contact_picker_section_header, r5);
        ((TextView) r6.findViewById(R.id.text)).setText(R.string.common_all_contacts);
        return r6;
    }

    @Override // com.android.contacts.common.list.ContactListAdapter, com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r2, int r3, Cursor r4, int r5, ViewGroup r6) {
        if (r3 == 0) goto L8;
        if (r3 == 1) goto L8;
        return null;
    L8:
        return super.newView(r2, r3, r4, r5, r6);
    }

    private View inflate(int r2, ViewGroup r3) {
        return LayoutInflater.from(getContext()).inflate(r2, r3, false);
    }

    @Override // com.android.contacts.common.list.ContactEntryListAdapter, com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r2, int r3, Cursor r4, int r5) {
        if (r3 != 0) goto L4;
        com.android.contacts.common.list.ContactListItemView r6 = (com.android.contacts.common.list.ContactListItemView) r2;
        r6.setSectionHeader(null);
        bindPhoto(r6, r3, r4);
        bindName(r6, r4);
        return;
    L4:
        if (r3 != 1) goto L10;
        com.android.contacts.common.list.ContactListItemView r7 = (com.android.contacts.common.list.ContactListItemView) r2;
        bindSectionHeaderAndDivider(r7, r5, r4);
        bindPhoto(r7, r3, r4);
        bindName(r7, r4);
        return;
    }

    @Override // com.android.contacts.common.list.ContactListAdapter
    public Uri getContactUri(int r2, Cursor r3) {
        return ContactsContract.Contacts.getLookupUri(r3.getLong(0), r3.getString(6));
    }
}
