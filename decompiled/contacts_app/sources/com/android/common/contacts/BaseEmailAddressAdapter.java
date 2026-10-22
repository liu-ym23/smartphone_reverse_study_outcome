package com.android.common.contacts;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import com.android.common.widget.CompositeCursorAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseEmailAddressAdapter extends CompositeCursorAdapter implements Filterable {
    private static final int ALLOWANCE_FOR_DUPLICATES = 5;
    private static final int DEFAULT_PREFERRED_MAX_RESULT_COUNT = 10;
    private static final long DIRECTORY_LOCAL_INVISIBLE = 1;
    private static final String DIRECTORY_PARAM_KEY = "directory";
    private static final String LIMIT_PARAM_KEY = "limit";
    private static final int MESSAGE_SEARCH_PENDING = 1;
    private static final int MESSAGE_SEARCH_PENDING_DELAY = 1000;
    private static final String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";
    private static final String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";
    private static final String SEARCHING_CURSOR_MARKER = "searching";
    private static final String TAG = "BaseEmailAddressAdapter";
    private Account mAccount;
    protected final ContentResolver mContentResolver;
    private boolean mDirectoriesLoaded;
    private Handler mHandler;
    private int mPreferredMaxResultCount;

    private final class DefaultPartitionFilter extends Filter {
        final /* synthetic */ BaseEmailAddressAdapter this$0;

        private DefaultPartitionFilter(BaseEmailAddressAdapter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DefaultPartitionFilter(BaseEmailAddressAdapter r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence r12) {
            Cursor r2 = null;
            if (BaseEmailAddressAdapter.access$000(this.this$0) == true) goto L5;
            Cursor r0 = this.this$0.mContentResolver.query(DirectoryListQuery.URI, DirectoryListQuery.PROJECTION, null, null, null);
            BaseEmailAddressAdapter.access$002(this.this$0, true);
        L6:
            Filter.FilterResults r3 = new Filter.FilterResults();
            if (TextUtils.isEmpty(r12) == true) goto L12;
            Uri.Builder r13 = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI.buildUpon().appendPath(r12.toString()).appendQueryParameter(BaseEmailAddressAdapter.LIMIT_PARAM_KEY, String.valueOf(BaseEmailAddressAdapter.access$100(this.this$0)));
            if (BaseEmailAddressAdapter.access$200(this.this$0) == null) goto L11;
            r13.appendQueryParameter(BaseEmailAddressAdapter.PRIMARY_ACCOUNT_NAME, BaseEmailAddressAdapter.access$200(this.this$0).name);
            r13.appendQueryParameter(BaseEmailAddressAdapter.PRIMARY_ACCOUNT_TYPE, BaseEmailAddressAdapter.access$200(this.this$0).type);
        L11:
            r2 = this.this$0.mContentResolver.query(r13.build(), EmailQuery.PROJECTION, null, null, null);
            r3.count = r2.getCount();
        L12:
            r3.values = new Cursor[]{r0, r2};
            return r3;
        L5:
            r0 = null;
            goto L6
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence r5, Filter.FilterResults r6) {
            if (r6.values == null) goto L5;
            Cursor[] r0 = (Cursor[]) r6.values;
            this.this$0.onDirectoryLoadFinished(r5, r0[0], r0[1]);
        L5:
            r6.count = this.this$0.getCount();
        }

        @Override // android.widget.Filter
        public CharSequence convertResultToString(Object r1) {
            return BaseEmailAddressAdapter.access$300(this.this$0, (Cursor) r1);
        }
    }

    private static class DirectoryListQuery {
        public static final int ACCOUNT_NAME = 1;
        public static final int ACCOUNT_TYPE = 2;
        private static final String DIRECTORY_ACCOUNT_NAME = "accountName";
        private static final String DIRECTORY_ACCOUNT_TYPE = "accountType";
        private static final String DIRECTORY_DISPLAY_NAME = "displayName";
        private static final String DIRECTORY_ID = "_id";
        private static final String DIRECTORY_PACKAGE_NAME = "packageName";
        private static final String DIRECTORY_TYPE_RESOURCE_ID = "typeResourceId";
        public static final int DISPLAY_NAME = 3;
        public static final int ID = 0;
        public static final int PACKAGE_NAME = 4;
        public static final String[] PROJECTION = null;
        public static final int TYPE_RESOURCE_ID = 5;
        public static final Uri URI = null;

        private DirectoryListQuery() {
        }

        static {
            URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "directories");
            PROJECTION = new String[]{"_id", "accountName", "accountType", DIRECTORY_DISPLAY_NAME, DIRECTORY_PACKAGE_NAME, DIRECTORY_TYPE_RESOURCE_ID};
        }
    }

    public static final class DirectoryPartition extends CompositeCursorAdapter.Partition {
        public String accountName;
        public String accountType;
        public CharSequence constraint;
        public long directoryId;
        public String directoryType;
        public String displayName;
        public DirectoryPartitionFilter filter;
        public boolean loading;

        public DirectoryPartition() {
            super(false, false);
        }
    }

    private final class DirectoryPartitionFilter extends Filter {
        private final long mDirectoryId;
        private int mLimit;
        private final int mPartitionIndex;
        final /* synthetic */ BaseEmailAddressAdapter this$0;

        public DirectoryPartitionFilter(BaseEmailAddressAdapter r1, int r2, long r3) {
            this.this$0 = r1;
            this.mPartitionIndex = r2;
            this.mDirectoryId = r3;
        }

        public synchronized void setLimit(int r1) {
            monitor-enter(this);
            this.mLimit = r1;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized int getLimit() {
            monitor-enter(this);
            int r0 = this.mLimit;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence r8) {
            Filter.FilterResults r0 = new Filter.FilterResults();
            if (TextUtils.isEmpty(r8) == true) goto L5;
            Uri r2 = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI.buildUpon().appendPath(r8.toString()).appendQueryParameter(BaseEmailAddressAdapter.DIRECTORY_PARAM_KEY, String.valueOf(this.mDirectoryId)).appendQueryParameter(BaseEmailAddressAdapter.LIMIT_PARAM_KEY, String.valueOf(getLimit() + 5)).build();
            r0.values = this.this$0.mContentResolver.query(r2, EmailQuery.PROJECTION, null, null, null);
        L5:
            return r0;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence r4, Filter.FilterResults r5) {
            Cursor r0 = (Cursor) r5.values;
            this.this$0.onPartitionLoadFinished(r4, this.mPartitionIndex, r0);
            r5.count = this.this$0.getCount();
        }
    }

    private static class EmailQuery {
        public static final int ADDRESS = 1;
        public static final int NAME = 0;
        public static final String[] PROJECTION = null;

        private EmailQuery() {
        }

        static {
            PROJECTION = new String[]{"display_name", "data1"};
        }
    }

    @Override // com.android.common.widget.CompositeCursorAdapter, android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    protected abstract void bindView(View r1, String r2, String r3, String r4, String r5);

    protected abstract void bindViewLoading(View r1, String r2, String r3);

    protected abstract View inflateItemView(ViewGroup r1);

    protected abstract View inflateItemViewLoading(ViewGroup r1);

    static /* synthetic */ boolean access$000(BaseEmailAddressAdapter r0) {
        return r0.mDirectoriesLoaded;
    }

    static /* synthetic */ boolean access$002(BaseEmailAddressAdapter r0, boolean r1) {
        r0.mDirectoriesLoaded = r1;
        return r1;
    }

    static /* synthetic */ int access$100(BaseEmailAddressAdapter r0) {
        return r0.mPreferredMaxResultCount;
    }

    static /* synthetic */ Account access$200(BaseEmailAddressAdapter r0) {
        return r0.mAccount;
    }

    static /* synthetic */ String access$300(BaseEmailAddressAdapter r0, Cursor r1) {
        return r0.makeDisplayString(r1);
    }

    public BaseEmailAddressAdapter(Context r2) {
        this(r2, 10);
    }

    public BaseEmailAddressAdapter(Context r1, int r2) {
        super(r1);
        this.mContentResolver = r1.getContentResolver();
        this.mPreferredMaxResultCount = r2;
        this.mHandler = new AnonymousClass1(this);
    }

    public void setAccount(Account r1) {
        this.mAccount = r1;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected int getItemViewType(int r1, int r2) {
        return ((DirectoryPartition) getPartition(r1)).loading ? 1 : 0;
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5) {
        if (((DirectoryPartition) getPartition(r2)).loading == false) goto L7;
        return inflateItemViewLoading(r5);
    L7:
        return inflateItemView(r5);
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected void bindView(View r7, int r8, Cursor r9, int r10) {
        DirectoryPartition r11 = (DirectoryPartition) getPartition(r8);
        String r2 = r11.directoryType;
        String r3 = r11.displayName;
        if (r11.loading == false) goto L5;
        bindViewLoading(r7, r2, r3);
        return;
    L5:
        String r12 = r9.getString(0);
        String r13 = r9.getString(1);
        if (TextUtils.isEmpty(r12) == false) goto L8;
    L11:
        String r5 = null;
        String r4 = r13;
    L12:
        bindView(r7, r2, r3, r4, r5);
        return;
    L8:
        if (TextUtils.equals(r12, r13) == true) goto L11;
        r4 = r12;
        r5 = r13;
        goto L12
    }

    @Override // com.android.common.widget.CompositeCursorAdapter
    protected boolean isEnabled(int r1, int r2) {
        return !isLoading(r1);
    }

    private boolean isLoading(int r1) {
        return ((DirectoryPartition) getPartition(r1)).loading;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new DefaultPartitionFilter(this, null);
    }

    protected void onDirectoryLoadFinished(CharSequence r19, Cursor r20, Cursor r21) {
        int r9 = 0;
        if (r20 == null) goto L34;
        PackageManager r11 = getContext().getPackageManager();
        ArrayList r12 = new ArrayList();
        DirectoryPartition r13 = null;
    L6:
        if (r20.moveToNext() == false) goto L28;
        long r14 = r20.getLong(r9);
        if (r14 == 1) goto L6;
        DirectoryPartition r8 = new DirectoryPartition();
        r8.directoryId = r14;
        r8.displayName = r20.getString(3);
        r8.accountName = r20.getString(1);
        r8.accountType = r20.getString(2);
        String r15 = r20.getString(4);
        int r16 = r20.getInt(5);
        if (r15 == null) goto L19;
        if (r16 == 0) goto L19;
        r8.directoryType = r11.getResourcesForApplication(r15).getString(r16);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r8.directoryType != null) goto L19;
        Log.e(TAG, "Cannot resolve directory name: " + r16 + "@" + r15);     // Catch: PackageManager.NameNotFoundException -> L17
    L17:
        e = move-exception;
        Log.e(TAG, "Cannot resolve directory name: " + r16 + "@" + r15, e);
    L19:
        Account r0 = this.mAccount;
        if (r0 != null) goto L22;
    L26:
        r12.add(r8);
    L27:
        r9 = 0;
        goto L6
    L22:
        if (r0.name.equals(r8.accountName) == false) goto L26;
        if (this.mAccount.type.equals(r8.accountType) == false) goto L26;
        r13 = r8;
        goto L27
    L28:
        if (r13 == null) goto L30;
        r12.add(1, r13);
    L30:
        Iterator r1 = r12.iterator();
    L32:
        if (r1.hasNext() == false) goto L34;
        addPartition((DirectoryPartition) r1.next());
    L34:
        int r2 = getPartitionCount();
        setNotificationsEnabled(false);
        if (r21 != null) goto L71;
    L41:
        if (r21 != null) goto L43;
        int r3 = 0;
    L44:
        int r4 = this.mPreferredMaxResultCount - r3;     // Catch: Throwable -> L39
        int r5 = 1;
    L45:
        if (r5 >= r2) goto L53;
        DirectoryPartition r6 = (DirectoryPartition) getPartition(r5);     // Catch: Throwable -> L39
        r6.constraint = r19;     // Catch: Throwable -> L39
        if (r4 > 0) goto L49;
        r6.loading = false;     // Catch: Throwable -> L39
        changeCursor(r5, null);     // Catch: Throwable -> L39
    L52:
        r5 = r5 + 1;
        goto L45
    L49:
        if (r6.loading == true) goto L52;
        r6.loading = true;     // Catch: Throwable -> L39
        changeCursor(r5, null);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        setNotificationsEnabled(true);
        throw th;
    L53:
        setNotificationsEnabled(true);
        int r7 = 1;
    L54:
        if (r7 >= r2) goto L66;
        DirectoryPartition r10 = (DirectoryPartition) getPartition(r7);
        if (r10.loading == false) goto L62;
        this.mHandler.removeMessages(1, r10);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, r7, 0, r10), 1000);
        if (r10.filter != null) goto L60;
        r10.filter = new DirectoryPartitionFilter(this, r7, r10.directoryId);
    L60:
        r10.filter.setLimit(r4);
        r10.filter.filter(r19);
    L65:
        r7 = r7 + 1;
        goto L54
    L62:
        if (r10.filter == null) goto L65;
        r10.filter.filter(null);
        goto L65
    L66:
        return;
    L43:
        r3 = r21.getCount();     // Catch: Throwable -> L39
        goto L44
    L71:
        if (getPartitionCount() <= 0) goto L41;
        changeCursor(0, r21);     // Catch: Throwable -> L39
        goto L41
    }

    void showSearchPendingIfNotComplete(int r2) {
        if (r2 < getPartitionCount()) goto L5;
        return;
    L5:
        if (((DirectoryPartition) getPartition(r2)).loading == false) goto L9;
        changeCursor(r2, createLoadingCursor());
        return;
    }

    private Cursor createLoadingCursor() {
        MatrixCursor r3 = new MatrixCursor(new String[]{SEARCHING_CURSOR_MARKER});
        r3.addRow(new Object[]{""});
        return r3;
    }

    public void onPartitionLoadFinished(CharSequence r3, int r4, Cursor r5) {
        if (r4 >= getPartitionCount()) goto L11;
        DirectoryPartition r0 = (DirectoryPartition) getPartition(r4);
        if (r0.loading == true) goto L7;
    L9:
        if (r5 == null) goto L15;
        r5.close();
        return;
    L15:
        return;
    L7:
        if (TextUtils.equals(r3, r0.constraint) == false) goto L9;
        r0.loading = false;
        this.mHandler.removeMessages(1, r0);
        changeCursor(r4, removeDuplicatesAndTruncate(r4, r5));
        return;
    L11:
        if (r5 == null) goto L17;
        r5.close();
        return;
    }

    private Cursor removeDuplicatesAndTruncate(int r9, Cursor r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.getCount() <= 10) goto L8;
    L10:
        MatrixCursor r0 = new MatrixCursor(EmailQuery.PROJECTION);
        r10.moveToPosition(-1);
        int r3 = 0;
    L12:
        if (r10.moveToNext() == false) goto L17;
        if (r3 >= 10) goto L17;
        String r4 = r10.getString(0);
        String r6 = r10.getString(1);
        if (isDuplicate(r6, r9) == true) goto L12;
        r0.addRow(new Object[]{r4, r6});
        r3 = r3 + 1;
    L17:
        r10.close();
        return r0;
    L8:
        if (hasDuplicates(r10, r9) == true) goto L10;
        return r10;
    }

    private boolean hasDuplicates(Cursor r3, int r4) {
        r3.moveToPosition(-1);
    L4:
        if (r3.moveToNext() == false) goto L8;
        if (isDuplicate(r3.getString(1), r4) == false) goto L4;
        return true;
    L8:
        return false;
    }

    private boolean isDuplicate(String r7, int r8) {
        int r0 = getPartitionCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        if (r2 == r8) goto L15;
        if (isLoading(r2) == true) goto L15;
        Cursor r3 = getCursor(r2);
        if (r3 == null) goto L15;
        r3.moveToPosition(-1);
    L11:
        if (r3.moveToNext() == false) goto L15;
        if (TextUtils.equals(r7, r3.getString(1)) == false) goto L11;
        return true;
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        return false;
    }

    private final String makeDisplayString(Cursor r3) {
        if (r3.getColumnName(0).equals(SEARCHING_CURSOR_MARKER) == false) goto L6;
        return "";
    L6:
        String r2 = r3.getString(0);
        String r4 = r3.getString(1);
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L13:
        return r4;
    L9:
        if (TextUtils.equals(r2, r4) == true) goto L13;
        return new Rfc822Token(r2, r4, null).toString();
    }
}
