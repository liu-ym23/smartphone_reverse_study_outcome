package com.android.contacts;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SplitAggregateView extends ListView {
    private static final String TAG = "SplitAggregateView";
    private AccountTypeManager mAccountTypes;
    private final Uri mAggregateUri;
    private OnContactSelectedListener mListener;

    public interface OnContactSelectedListener {
        void onContactSelected(long r1);
    }

    private static class RawContactInfo implements Comparable<RawContactInfo> {
        String accountType;
        String dataSet;
        String email;
        String name;
        String nickname;
        String phone;
        final long rawContactId;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(RawContactInfo r1) {
            return compareTo2(r1);
        }

        public RawContactInfo(long r1) {
            this.rawContactId = r1;
        }

        public String getAdditionalData() {
            String r0 = this.nickname;
            if (r0 == null) goto L5;
            return r0;
        L5:
            String r1 = this.email;
            if (r1 == null) goto L8;
            return r1;
        L8:
            String r2 = this.phone;
            if (r2 == null) goto L11;
            return r2;
        L11:
            return "";
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(RawContactInfo r2) {
            String r1 = this.accountType;
            String r0 = "";
            if (r1 != null) goto L6;
            r1 = "";
        L6:
            String r3 = r2.accountType;
            if (r3 == null) goto L10;
            r0 = r3;
        L10:
            return r1.compareTo(r0);
        }
    }

    private class SplitAggregateAdapter extends ArrayAdapter<RawContactInfo> {
        private LayoutInflater mInflater;
        final /* synthetic */ SplitAggregateView this$0;

        public SplitAggregateAdapter(SplitAggregateView r1, Context r2, List<RawContactInfo> r3) {
            this.this$0 = r1;
            super(r2, 0, r3);
            this.mInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
            r5 = this.mInflater.inflate(R.layout.split_aggregate_list_item, r6, false);
        L4:
            SplitAggregateItemCache r7 = (SplitAggregateItemCache) r5.getTag();
            Drawable r0 = null;
            Object[] r1 = 0;
            if (r7 != null) goto L7;
            r7 = new SplitAggregateItemCache(r1 == true ? 1 : 0);
            r7.name = (TextView) r5.findViewById(R.id.name);
            r7.additionalData = (TextView) r5.findViewById(R.id.additionalData);
            r7.sourceIcon = (ImageView) r5.findViewById(R.id.sourceIcon);
            r5.setTag(r7);
        L7:
            RawContactInfo r8 = getItem(r4);
            r7.name.setText(r8.name);
            r7.additionalData.setText(r8.getAdditionalData());
            AccountType r9 = SplitAggregateView.access$200(this.this$0).getAccountType(r8.accountType, r8.dataSet);
            if (r9 == null) goto L10;
            r0 = r9.getDisplayIcon(getContext());
        L10:
            if (r0 == null) goto L12;
            r7.sourceIcon.setImageDrawable(r0);
        L13:
            return r5;
        L12:
            r7.sourceIcon.setImageResource(R.drawable.unknown_source);
            goto L13
        }
    }

    private static class SplitAggregateItemCache {
        TextView additionalData;
        TextView name;
        ImageView sourceIcon;

        private SplitAggregateItemCache() {
        }

        /* synthetic */ SplitAggregateItemCache(AnonymousClass1 r1) {
            this();
        }
    }

    private interface SplitQuery {
        public static final int ACCOUNT_TYPE = 1;
        public static final String[] COLUMNS = null;
        public static final int DATA_SET = 2;
        public static final int DISPLAY_NAME = 5;
        public static final int EMAIL = 7;
        public static final int IS_PRIMARY = 4;
        public static final int MIMETYPE = 0;
        public static final int NICKNAME = 6;
        public static final int PHONE = 8;
        public static final int RAW_CONTACT_ID = 3;

        static {
            COLUMNS = new String[]{"mimetype", "account_type", "data_set", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "is_primary", "data1", "data1", "data1", "data1"};
        }
    }

    static /* synthetic */ OnContactSelectedListener access$000(SplitAggregateView r0) {
        return r0.mListener;
    }

    static /* synthetic */ AccountTypeManager access$200(SplitAggregateView r0) {
        return r0.mAccountTypes;
    }

    public SplitAggregateView(Context r2, Uri r3) {
        super(r2);
        this.mAggregateUri = r3;
        this.mAccountTypes = AccountTypeManager.getInstance(r2);
        final List<RawContactInfo> r4 = loadData();
        setAdapter(new SplitAggregateAdapter(this, r2, r4));
        setOnItemClickListener(new AnonymousClass1(this, r4));
    }

    public void setOnContactSelectedListener(OnContactSelectedListener r1) {
        this.mListener = r1;
    }

    private List<RawContactInfo> loadData() {
        HashMap r0 = new HashMap();
        Uri r4 = Uri.withAppendedPath(this.mAggregateUri, "data");
        Cursor r1 = getContext().getContentResolver().query(r4, SplitQuery.COLUMNS, null, null, null);
    L26:
        if (r1.moveToNext() == false) goto L21;
        long r2 = r1.getLong(3);     // Catch: Throwable -> L23
        RawContactInfo r5 = (RawContactInfo) r0.get(Long.valueOf(r2));     // Catch: Throwable -> L23
        if (r5 != null) goto L8;
        r5 = new RawContactInfo(r2);     // Catch: Throwable -> L23
        r0.put(Long.valueOf(r2), r5);     // Catch: Throwable -> L23
        r5.accountType = r1.getString(1);     // Catch: Throwable -> L23
        r5.dataSet = r1.getString(2);     // Catch: Throwable -> L23
    L8:
        String r3 = r1.getString(0);     // Catch: Throwable -> L23
        if ("vnd.android.cursor.item/name".equals(r3) == true) goto L10;
        if ("vnd.android.cursor.item/phone_v2".equals(r3) == true) goto L13;
        if ("vnd.android.cursor.item/email_v2".equals(r3) == true) goto L16;
        if ("vnd.android.cursor.item/nickname".equals(r3) == false) goto L26;
        loadNickname(r1, r5);     // Catch: Throwable -> L23
        goto L26
    L16:
        loadEmail(r1, r5);     // Catch: Throwable -> L23
        goto L26
    L13:
        loadPhoneNumber(r1, r5);     // Catch: Throwable -> L23
        goto L26
    L10:
        loadStructuredName(r1, r5);     // Catch: Throwable -> L23
        goto L26
    L21:
        r1.close();
        ArrayList r9 = new ArrayList(r0.values());
        Collections.sort(r9);
        return r9;
    L23:
        th = move-exception;
        r1.close();
        throw th;
    }

    private void loadStructuredName(Cursor r1, RawContactInfo r2) {
        r2.name = r1.getString(5);
    }

    private void loadNickname(Cursor r1, RawContactInfo r2) {
        if (r2.nickname != null) goto L5;
    L6:
        r2.nickname = r1.getString(6);
        return;
    L5:
        if (r1.getInt(4) != 0) goto L6;
    }

    private void loadEmail(Cursor r1, RawContactInfo r2) {
        if (r2.email != null) goto L5;
    L6:
        r2.email = r1.getString(7);
        return;
    L5:
        if (r1.getInt(4) != 0) goto L6;
    }

    private void loadPhoneNumber(Cursor r1, RawContactInfo r2) {
        if (r2.phone != null) goto L5;
    L6:
        r2.phone = r1.getString(8);
        return;
    L5:
        if (r1.getInt(4) != 0) goto L6;
    }
}
