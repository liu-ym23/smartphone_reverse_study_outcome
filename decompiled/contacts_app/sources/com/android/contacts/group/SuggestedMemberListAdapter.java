package com.android.contacts.group;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.BytedanceContactContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SuggestedMemberListAdapter extends ArrayAdapter<SuggestedMember> {
    private static final int CONTACT_ID_COLUMN_INDEX = 1;
    private static final int DATA_COLUMN_INDEX = 3;
    private static final int DISPLAY_NAME_PRIMARY_COLUMN_INDEX = 2;
    private static final int MIMETYPE_COLUMN_INDEX = 2;
    private static final int PHOTO_COLUMN_INDEX = 4;
    private static final String[] PROJECTION_FILTERED_MEMBERS = null;
    private static final String[] PROJECTION_MEMBER_DATA = null;
    private static final int RAW_CONTACT_ID_COLUMN_INDEX = 0;
    private static final int SUGGESTIONS_LIMIT = 5;
    private String mAccountName;
    private String mAccountType;
    private ContentResolver mContentResolver;
    private String mDataSet;
    private final List<Long> mExistingMemberContactIds;
    private Filter mFilter;
    private LayoutInflater mInflater;

    public class SuggestedMember {
        private long mContactId;
        private String mDisplayName;
        private String mExtraInfo;
        private byte[] mPhoto;
        private long mRawContactId;
        final /* synthetic */ SuggestedMemberListAdapter this$0;

        public SuggestedMember(SuggestedMemberListAdapter r1, long r2, String r4, long r5) {
            this.this$0 = r1;
            this.mRawContactId = r2;
            this.mDisplayName = r4;
            this.mContactId = r5;
        }

        public String getDisplayName() {
            return this.mDisplayName;
        }

        public String getExtraInfo() {
            return this.mExtraInfo;
        }

        public long getRawContactId() {
            return this.mRawContactId;
        }

        public long getContactId() {
            return this.mContactId;
        }

        public byte[] getPhotoByteArray() {
            return this.mPhoto;
        }

        public boolean hasExtraInfo() {
            if (this.mExtraInfo == null) goto L5;
            return true;
        L5:
            return false;
        }

        public void setExtraInfo(String r1) {
            this.mExtraInfo = r1;
        }

        public void setPhotoByteArray(byte[] r1) {
            this.mPhoto = r1;
        }

        public String toString() {
            return getDisplayName();
        }
    }

    public class SuggestedMemberFilter extends Filter {
        final /* synthetic */ SuggestedMemberListAdapter this$0;

        public SuggestedMemberFilter(SuggestedMemberListAdapter r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence r23) {
            Filter.FilterResults r1 = new Filter.FilterResults();
            if (SuggestedMemberListAdapter.access$000(this.this$0) != null) goto L5;
        L59:
            return r1;
        L5:
            if (TextUtils.isEmpty(r23) == true) goto L59;
            ArrayList r2 = new ArrayList();
            HashMap r3 = new HashMap();
            String r4 = r23.toString() + "%";
            if (SuggestedMemberListAdapter.access$100(this.this$0) != null) goto L10;
            String[] r5 = {SuggestedMemberListAdapter.access$200(this.this$0), SuggestedMemberListAdapter.access$300(this.this$0), r4, r4};
            String r6 = "account_name=? AND account_type=? AND data_set IS NULL";
        L11:
            Cursor r7 = SuggestedMemberListAdapter.access$000(this.this$0).query(ContactsContract.RawContacts.CONTENT_URI, SuggestedMemberListAdapter.access$400(), r6 + " AND (display_name LIKE ? OR display_name_alt LIKE ? )", r5, "display_name COLLATE LOCALIZED ASC");
            if (r7 != null) goto L62;
            return r1;
        L62:
            r7.moveToPosition(-1);     // Catch: Throwable -> L56
        L17:
            if (r7.moveToNext() == false) goto L25;
            if (r3.keySet().size() >= 5) goto L25;
            long r20 = r7.getLong(0);     // Catch: Throwable -> L56
            long r18 = r7.getLong(1);     // Catch: Throwable -> L56
            if (SuggestedMemberListAdapter.access$500(this.this$0).contains(Long.valueOf(r18)) == true) goto L17;
            SuggestedMember r12 = new SuggestedMember(this.this$0, r20, r7.getString(2), r18);     // Catch: Throwable -> L56
            r2.add(r12);     // Catch: Throwable -> L56
            r3.put(Long.valueOf(r20), r12);     // Catch: Throwable -> L56
        L25:
            r7.close();
            int r8 = r3.keySet().size();
            if (r8 != 0) goto L28;
            return r1;
        L28:
            StringBuilder r9 = new StringBuilder("_id IN (");
            String[] r10 = new String[r8];
            Arrays.fill(r10, "?");
            r9.append(TextUtils.join(SimContactsConstants.EMAIL_SEP, r10)).append(")");
            ArrayList r11 = new ArrayList();
            r11.add("vnd.android.cursor.item/photo");
            r11.add("vnd.android.cursor.item/email_v2");
            r11.add("vnd.android.cursor.item/phone_v2");
            Iterator r14 = r3.keySet().iterator();
        L30:
            if (r14.hasNext() == false) goto L32;
            r11.add(String.valueOf((Long) r14.next()));
            goto L30
        L32:
            Cursor r13 = SuggestedMemberListAdapter.access$000(this.this$0).query(ContactsContract.RawContactsEntity.CONTENT_URI, SuggestedMemberListAdapter.access$600(), "(mimetype=? OR mimetype=? OR mimetype=?) AND " + r9.toString(), (String[]) r11.toArray(new String[0]), null);
            r13.moveToPosition(-1);     // Catch: Throwable -> L53
        L34:
            if (r13.moveToNext() == false) goto L51;
            SuggestedMember r0 = (SuggestedMember) r3.get(Long.valueOf(r13.getLong(0)));     // Catch: Throwable -> L53
            if (r0 == null) goto L34;
            String r15 = r13.getString(2);     // Catch: Throwable -> L53
            if ("vnd.android.cursor.item/photo".equals(r15) == true) goto L41;
            if ("vnd.android.cursor.item/email_v2".equals(r15) == true) goto L48;
            if ("vnd.android.cursor.item/phone_v2".equals(r15) == false) goto L34;
        L48:
            if (r0.hasExtraInfo() == true) goto L34;
            r0.setExtraInfo(r13.getString(3));     // Catch: Throwable -> L53
            goto L34
        L41:
            r0.setPhotoByteArray(r13.getBlob(4));     // Catch: Throwable -> L53
            goto L34
        L51:
            r13.close();
            r1.values = r2;
            return r1;
        L53:
            th = move-exception;
            r13.close();
            throw th;
        L56:
            th = move-exception;
            r7.close();
            throw th;
        L10:
            r5 = new String[]{SuggestedMemberListAdapter.access$200(this.this$0), SuggestedMemberListAdapter.access$300(this.this$0), SuggestedMemberListAdapter.access$100(this.this$0), r4, r4};
            r6 = "account_name=? AND account_type=? AND data_set=?";
            goto L11
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence r2, Filter.FilterResults r3) {
            List r4 = (List) r3.values;
            if (r4 != null) goto L5;
            return;
        L5:
            this.this$0.clear();
            Iterator r5 = r4.iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            SuggestedMember r6 = (SuggestedMember) r5.next();
            this.this$0.add(r6);
            goto L7
        L9:
            this.this$0.notifyDataSetChanged();
        }
    }

    static /* synthetic */ ContentResolver access$000(SuggestedMemberListAdapter r0) {
        return r0.mContentResolver;
    }

    static /* synthetic */ String access$100(SuggestedMemberListAdapter r0) {
        return r0.mDataSet;
    }

    static /* synthetic */ String access$200(SuggestedMemberListAdapter r0) {
        return r0.mAccountName;
    }

    static /* synthetic */ String access$300(SuggestedMemberListAdapter r0) {
        return r0.mAccountType;
    }

    static /* synthetic */ String[] access$400() {
        return PROJECTION_FILTERED_MEMBERS;
    }

    static /* synthetic */ List access$500(SuggestedMemberListAdapter r0) {
        return r0.mExistingMemberContactIds;
    }

    static /* synthetic */ String[] access$600() {
        return PROJECTION_MEMBER_DATA;
    }

    static {
        PROJECTION_FILTERED_MEMBERS = new String[]{"_id", "contact_id", "display_name"};
        PROJECTION_MEMBER_DATA = new String[]{"_id", "contact_id", "mimetype", "data1", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
    }

    public SuggestedMemberListAdapter(Context r1, int r2) {
        super(r1, r2);
        this.mExistingMemberContactIds = new ArrayList();
        this.mInflater = (LayoutInflater) r1.getSystemService("layout_inflater");
    }

    public void setAccountType(String r1) {
        this.mAccountType = r1;
    }

    public void setAccountName(String r1) {
        this.mAccountName = r1;
    }

    public void setDataSet(String r1) {
        this.mDataSet = r1;
    }

    public void setContentResolver(ContentResolver r1) {
        this.mContentResolver = r1;
    }

    public void updateExistingMembersList(List<GroupEditorFragment.Member> r5) {
        this.mExistingMemberContactIds.clear();
        Iterator<GroupEditorFragment.Member> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        GroupEditorFragment.Member r0 = r6.next();
        this.mExistingMemberContactIds.add(Long.valueOf(r0.getContactId()));
        goto L4
    }

    public void addNewMember(long r1) {
        this.mExistingMemberContactIds.add(Long.valueOf(r1));
    }

    public void removeMember(long r3) {
        if (this.mExistingMemberContactIds.contains(Long.valueOf(r3)) == false) goto L6;
        this.mExistingMemberContactIds.remove(Long.valueOf(r3));
        return;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int r4, View r5, ViewGroup r6) {
        if (r5 != null) goto L5;
        r5 = this.mInflater.inflate(R.layout.group_member_suggestion, r6, false);
    L5:
        SuggestedMember r3 = getItem(r4);
        TextView r7 = (TextView) r5.findViewById(R.id.text1);
        TextView r8 = (TextView) r5.findViewById(R.id.text2);
        ImageView r1 = (ImageView) r5.findViewById(R.id.icon);
        r7.setText(r3.getDisplayName());
        if (r3.hasExtraInfo() == false) goto L8;
        r8.setText(r3.getExtraInfo());
    L9:
        byte[] r9 = r3.getPhotoByteArray();
        if (r9 != null) goto L12;
        r1.setImageResource(R.drawable.ic_contact_picture_holo_light);
    L13:
        r5.setTag(r3);
        return r5;
    L12:
        r1.setImageBitmap(BitmapFactory.decodeByteArray(r9, 0, r9.length));
        goto L13
    L8:
        r8.setVisibility(8);
        goto L9
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        if (this.mFilter != null) goto L6;
        this.mFilter = new SuggestedMemberFilter(this);
    L6:
        return this.mFilter;
    }
}
