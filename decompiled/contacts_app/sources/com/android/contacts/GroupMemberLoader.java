package com.android.contacts;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.loader.content.CursorLoader;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.preference.ContactsPreferences;
import com.android.contacts.util.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class GroupMemberLoader extends CursorLoader {
    private String mAccountName;
    private String mAccountType;
    private final long mGroupId;

    public static class GroupDetailQuery {
        public static final int CONTACT_DISPLAY_NAME_PRIMARY = 3;
        public static final int CONTACT_ID = 0;
        public static final int CONTACT_LOOKUP_KEY = 2;
        public static final int CONTACT_PHOTO_URI = 1;
        public static final int CONTACT_PRESENCE_STATUS = 4;
        public static final int CONTACT_STATUS = 5;
        public static final String GROUP_BY_ROW_CONTACT_ID = "GROUP_BY_ROW_CONTACT_ID";
        public static final int PHONEBOOK_LABEL_PRIMARY = 9;
        public static final int PHOTO_ID = 8;
        private static final String[] PROJECTION = null;
        public static final int RAW_CONTACT_ID = 6;
        public static final int SORT_KEY_PRIMARY = 7;

        public GroupDetailQuery() {
        }

        static {
            PROJECTION = new String[]{"contact_id", "photo_uri", "lookup", "display_name", "contact_presence", "contact_status", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, PickerFragment.CONTACT_SORT_CNAME, "photo_id", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        }

        public static String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            PROJECTION[3] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            PROJECTION[7] = "sort_key_alt";
        L11:
            return PROJECTION;
        L9:
            PROJECTION[7] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            PROJECTION[3] = "display_name";
            goto L7
        }
    }

    public static class GroupEditorQuery {
        public static final int CONTACT_DISPLAY_NAME_PRIMARY = 2;
        public static final int CONTACT_ID = 0;
        public static final int CONTACT_LOOKUP_KEY = 4;
        public static final int CONTACT_PHOTO_URI = 3;
        public static final int PHONEBOOK_LABEL_PRIMARY = 5;
        public static final String[] PROJECTION = null;
        public static final int RAW_CONTACT_ID = 1;

        public GroupEditorQuery() {
        }

        static {
            PROJECTION = new String[]{"contact_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "display_name", "photo_uri", "lookup", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        }
    }

    private String createSelection() {
        return "mimetype=? AND data1=?";
    }

    private String createSelectionForUngrouped() {
        return "account_name = ? AND account_type = ?";
    }

    public static GroupMemberLoader constructLoaderForGroupEditorQuery(Context r2, long r3) {
        return new GroupMemberLoader(r2, r3, GroupEditorQuery.PROJECTION);
    }

    public static GroupMemberLoader constructLoaderForGroupDetailQuery(Context r1, long r2, int r4, int r5) {
        return new GroupMemberLoader(r1, r2, GroupDetailQuery.getProjection(r4, r5));
    }

    public static GroupMemberLoader constructLoaderForUngroupedMemberQuery(Context r1, String r2, String r3, int r4, int r5) {
        return new GroupMemberLoader(r1, r2, r3, GroupDetailQuery.getProjection(r4, r5));
    }

    private GroupMemberLoader(Context r3, long r4) {
        super(r3);
        this.mGroupId = r4;
        setUri(ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build().buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build());
        setSelection(createSelection());
        setSelectionArgs(createSelectionArgs());
        if (new ContactsPreferences(r3).getSortOrder() != 1) goto L5;
        setSortOrder(PickerFragment.CONTACT_SORT_CNAME);
        return;
    L5:
        setSortOrder("sort_key_alt");
    }

    private GroupMemberLoader(Context r1, long r2, String[] r4) {
        super(r1);
        this.mGroupId = r2;
        setUri(createUri());
        setProjection(r4);
        setSelection(createSelection());
        setSelectionArgs(createSelectionArgs());
        if (new ContactsPreferences(r1).getSortOrder() != 1) goto L5;
        setSortOrder(PickerFragment.CONTACT_SORT_CNAME);
        return;
    L5:
        setSortOrder("sort_key_alt");
    }

    private GroupMemberLoader(Context r3, String r4, String r5, String[] r6) {
        super(r3);
        this.mGroupId = 0;
        this.mAccountName = r4;
        this.mAccountType = r5;
        setUri(createUriForUngrouped());
        setProjection(r6);
        setSelection(createSelectionForUngrouped());
        setSelectionArgs(createSelectionArgsForUngrouped());
        if (new ContactsPreferences(r3).getSortOrder() != 1) goto L5;
        setSortOrder(PickerFragment.CONTACT_SORT_CNAME);
        return;
    L5:
        setSortOrder("sort_key_alt");
    }

    private Uri createUri() {
        return ContactsContract.AUTHORITY_URI.buildUpon().appendPath("group_raw_members").build();
    }

    private Uri createUriForUngrouped() {
        return ContactsContract.AUTHORITY_URI.buildUpon().appendPath("ungroup_raw_members").build();
    }

    private String[] createSelectionArgs() {
        ArrayList r0 = new ArrayList();
        r0.add("vnd.android.cursor.item/group_membership");
        r0.add(String.valueOf(this.mGroupId));
        return (String[]) r0.toArray(new String[0]);
    }

    private String[] createSelectionArgsForUngrouped() {
        return new String[]{this.mAccountName, this.mAccountType};
    }
}
