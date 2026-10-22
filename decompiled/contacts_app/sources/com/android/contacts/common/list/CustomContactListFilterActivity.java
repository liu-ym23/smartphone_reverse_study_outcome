package com.android.contacts.common.list;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.AsyncTaskLoader;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.EntityIterator;
import android.content.Intent;
import android.content.Loader;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.ValuesDelta;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.contacts.common.util.EmptyService;
import com.android.contacts.common.util.LocalizedNameResolver;
import com.android.contacts.common.util.WeakAsyncTask;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class CustomContactListFilterActivity extends Activity implements View.OnClickListener, ExpandableListView.OnChildClickListener, LoaderManager.LoaderCallbacks<AccountSet> {
    private static final int ACCOUNT_SET_LOADER_ID = 1;
    private static final int DEFAULT_SHOULD_SYNC = 1;
    private static final int DEFAULT_VISIBLE = 0;
    private static final int SYNC_MODE_EVERYTHING = 2;
    private static final int SYNC_MODE_UNGROUPED = 1;
    private static final int SYNC_MODE_UNSUPPORTED = 0;
    private static final String TAG = "CustomContactListFilterActivity";
    private static Comparator<GroupDelta> sIdComparator;
    private DisplayAdapter mAdapter;
    private ExpandableListView mList;
    private SharedPreferences mPrefs;

    protected static class AccountDisplay {
        public final String mDataSet;
        public final String mName;
        public ArrayList<GroupDelta> mSyncedGroups;
        public final String mType;
        public GroupDelta mUngrouped;
        public ArrayList<GroupDelta> mUnsyncedGroups;

        static /* synthetic */ void access$000(AccountDisplay r0, GroupDelta r1) {
            r0.addGroup(r1);
        }

        public AccountDisplay(ContentResolver r1, String r2, String r3, String r4) {
            this.mSyncedGroups = Lists.newArrayList();
            this.mUnsyncedGroups = Lists.newArrayList();
            this.mName = r2;
            this.mType = r3;
            this.mDataSet = r4;
        }

        private void addGroup(GroupDelta r2) {
            if (r2.getShouldSync() == false) goto L5;
            this.mSyncedGroups.add(r2);
            return;
        L5:
            this.mUnsyncedGroups.add(r2);
        }

        public void setShouldSync(boolean r4) {
            if (r4 == false) goto L4;
            ArrayList<GroupDelta> r0 = this.mUnsyncedGroups;
        L5:
            Iterator<GroupDelta> r1 = r0.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            setShouldSync(r1.next(), r4, false);
            r1.remove();
            goto L7
        L9:
            return;
        L4:
            r0 = this.mSyncedGroups;
            goto L5
        }

        public void setShouldSync(GroupDelta r2, boolean r3) {
            setShouldSync(r2, r3, true);
        }

        public void setShouldSync(GroupDelta r1, boolean r2, boolean r3) {
            r1.putShouldSync(r2);
            if (r2 == false) goto L7;
            if (r3 == false) goto L6;
            this.mUnsyncedGroups.remove(r1);
        L6:
            this.mSyncedGroups.add(r1);
            Collections.sort(this.mSyncedGroups, CustomContactListFilterActivity.access$200());
            return;
        L7:
            if (r3 == false) goto L9;
            this.mSyncedGroups.remove(r1);
        L9:
            this.mUnsyncedGroups.add(r1);
        }

        public void buildDiff(ArrayList<ContentProviderOperation> r3) {
            Iterator<GroupDelta> r0 = this.mSyncedGroups.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            ContentProviderOperation r1 = r0.next().buildDiff();
            if (r1 == null) goto L4;
            r3.add(r1);
            goto L4
        L8:
            Iterator<GroupDelta> r2 = this.mUnsyncedGroups.iterator();
        L10:
            if (r2.hasNext() == false) goto L14;
            ContentProviderOperation r4 = r2.next().buildDiff();
            if (r4 == null) goto L10;
            r3.add(r4);
            goto L10
        }
    }

    protected static class AccountSet extends ArrayList<AccountDisplay> {
        protected AccountSet() {
        }

        public ArrayList<ContentProviderOperation> buildDiff() {
            ArrayList<ContentProviderOperation> r0 = Lists.newArrayList();
            Iterator<AccountDisplay> r2 = iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r2.next().buildDiff(r0);
            goto L4
        L6:
            return r0;
        }
    }

    public static class CustomFilterConfigurationLoader extends AsyncTaskLoader<AccountSet> {
        private AccountSet mAccountSet;

        @Override // android.content.Loader
        public /* bridge */ /* synthetic */ void deliverResult(Object r1) {
            deliverResult((AccountSet) r1);
        }

        @Override // android.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ AccountSet loadInBackground() {
            return loadInBackground();
        }

        public CustomFilterConfigurationLoader(Context r1) {
            super(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.content.AsyncTaskLoader
        public AccountSet loadInBackground() {
            Context r13 = getContext();
            AccountTypeManager r0 = AccountTypeManager.getInstance(r13);
            ContentResolver r7 = r13.getContentResolver();
            AccountSet r8 = new AccountSet();
            Iterator<AccountWithDataSet> r10 = r0.getAccounts(false).iterator();
        L4:
            if (r10.hasNext() == false) goto L25;
            AccountWithDataSet r11 = r10.next();
            if (r0.getAccountTypeForAccount(r11).isExtension() == false) goto L10;
            if (r11.hasData(r13) == false) goto L4;
        L10:
            AccountDisplay r12 = new AccountDisplay(r7, r11.name, r11.type, r11.dataSet);
            Uri.Builder r1 = ContactsContract.Groups.CONTENT_URI.buildUpon().appendQueryParameter("account_name", r11.name).appendQueryParameter("account_type", r11.type);
            if (r11.dataSet == null) goto L13;
            r1.appendQueryParameter("data_set", r11.dataSet).build();
        L13:
            Cursor r2 = r7.query(r1.build(), null, "deleted!=1", null, null);
            if (r2 == null) goto L4;
            EntityIterator r3 = ContactsContract.Groups.newEntityIterator(r2);
            boolean r4 = false;
        L26:
            if (r3.hasNext() == false) goto L20;
            AccountDisplay.access$000(r12, GroupDelta.fromBefore(((Entity) r3.next()).getEntityValues()));     // Catch: Throwable -> L22
            r4 = true;
            goto L26
        L20:
            r12.mUngrouped = GroupDelta.fromSettings(r7, r11.name, r11.type, r11.dataSet, r4);     // Catch: Throwable -> L22
            AccountDisplay.access$000(r12, r12.mUngrouped);     // Catch: Throwable -> L22
            r3.close();
            r8.add(r12);
        L22:
            th = move-exception;
            r3.close();
            throw th;
        L25:
            return r8;
        }

        public void deliverResult(AccountSet r2) {
            if (isReset() == false) goto L5;
            return;
        L5:
            this.mAccountSet = r2;
            if (isStarted() == false) goto L9;
            super.deliverResult(r2);
            return;
        }

        @Override // android.content.Loader
        protected void onStartLoading() {
            AccountSet r0 = this.mAccountSet;
            if (r0 == null) goto L6;
            deliverResult(r0);
        L6:
            if (takeContentChanged() == false) goto L8;
        L9:
            forceLoad();
            return;
        L8:
            if (this.mAccountSet == null) goto L9;
        }

        @Override // android.content.Loader
        protected void onStopLoading() {
            cancelLoad();
        }

        @Override // android.content.Loader
        protected void onReset() {
            super.onReset();
            onStopLoading();
            this.mAccountSet = null;
        }
    }

    protected static class DisplayAdapter extends BaseExpandableListAdapter {
        private AccountTypeManager mAccountTypes;
        private AccountSet mAccounts;
        private boolean mChildWithPhones;
        private Context mContext;
        private LayoutInflater mInflater;

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int r1) {
            return r1;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int r1, int r2) {
            return true;
        }

        static /* synthetic */ AccountSet access$500(DisplayAdapter r0) {
            return r0.mAccounts;
        }

        public DisplayAdapter(Context r2) {
            this.mChildWithPhones = false;
            this.mContext = r2;
            this.mInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
            this.mAccountTypes = AccountTypeManager.getInstance(r2);
        }

        public void setAccounts(AccountSet r1) {
            this.mAccounts = r1;
            notifyDataSetChanged();
        }

        public void setChildDescripWithPhones(boolean r1) {
            this.mChildWithPhones = r1;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int r5, boolean r6, View r7, ViewGroup r8) {
            int r9 = 0;
            if (r7 != null) goto L5;
            r7 = this.mInflater.inflate(R.layout.custom_contact_list_filter_account, r8, false);
        L5:
            TextView r10 = (TextView) r7.findViewById(android.R.id.text1);
            TextView r0 = (TextView) r7.findViewById(android.R.id.text2);
            AccountDisplay r11 = (AccountDisplay) getGroup(r5);
            AccountType r1 = this.mAccountTypes.getAccountType(r11.mType, r11.mDataSet);
            r10.setText(r11.mName);
            if (r11.mName != null) goto L8;
            r9 = 8;
        L8:
            r10.setVisibility(r9);
            r0.setText(r1.getDisplayLabel(this.mContext));
            return r7;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int r4, int r5, boolean r6, View r7, ViewGroup r8) {
            if (r7 != null) goto L5;
            r7 = this.mInflater.inflate(R.layout.custom_contact_list_filter_group, r8, false);
        L5:
            TextView r9 = (TextView) r7.findViewById(android.R.id.text1);
            TextView r0 = (TextView) r7.findViewById(android.R.id.text2);
            CheckBox r1 = (CheckBox) r7.findViewById(android.R.id.checkbox);
            AccountDisplay r2 = this.mAccounts.get(r4);
            GroupDelta r10 = (GroupDelta) getChild(r4, r5);
            if (r10 == null) goto L8;
            boolean r3 = r10.getVisible();
            r1.setVisibility(0);
            r1.setChecked(r3);
            r9.setText(r10.getTitle(this.mContext));
            r0.setVisibility(8);
        L9:
            return r7;
        L8:
            r1.setVisibility(8);
            r9.setText(R.string.display_more_groups);
            r0.setVisibility(8);
            goto L9
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int r1, int r2) {
            AccountDisplay r0 = this.mAccounts.get(r1);
            if (r2 >= 0) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == true) goto L10;
            return null;
        L10:
            return r0.mSyncedGroups.get(r2);
        L5:
            if (r2 >= r0.mSyncedGroups.size()) goto L7;
            r3 = true;
            goto L8
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int r1, int r2) {
            GroupDelta r0 = (GroupDelta) getChild(r1, r2);
            if (r0 == null) goto L8;
            Long r3 = r0.getId();
            if (r3 != null) goto L7;
            return Long.MIN_VALUE;
        L7:
            return r3.longValue();
        L8:
            return Long.MIN_VALUE;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int r1) {
            AccountDisplay r0 = this.mAccounts.get(r1);
            if (r0.mUnsyncedGroups.size() <= 0) goto L5;
            int r2 = 1;
        L7:
            return r0.mSyncedGroups.size() + r2;
        L5:
            r2 = 0;
            goto L7
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int r1) {
            return this.mAccounts.get(r1);
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            AccountSet r0 = this.mAccounts;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }
    }

    protected static class GroupDelta extends ValuesDelta {
        private boolean mAccountHasGroups;
        private boolean mUngrouped;

        static /* synthetic */ boolean access$400(GroupDelta r0) {
            return r0.mUngrouped;
        }

        private GroupDelta() {
            this.mUngrouped = false;
        }

        public static GroupDelta fromSettings(ContentResolver r11, String r12, String r13, String r14, boolean r15) {
            Uri.Builder r0 = ContactsContract.Settings.CONTENT_URI.buildUpon().appendQueryParameter("account_name", r12).appendQueryParameter("account_type", r13);
            if (r14 == null) goto L5;
            r0.appendQueryParameter("data_set", r14);
        L5:
            Cursor r16 = r11.query(r0.build(), new String[]{"should_sync", "ungrouped_visible"}, null, null, null);
            ContentValues r4 = new ContentValues();     // Catch: Throwable -> L18
            r4.put("account_name", r12);     // Catch: Throwable -> L18
            r4.put("account_type", r13);     // Catch: Throwable -> L18
            r4.put("data_set", r14);     // Catch: Throwable -> L18
            if (r16 != null) goto L9;
        L14:
            r4.put("should_sync", 1);     // Catch: Throwable -> L18
            r4.put("ungrouped_visible", 0);     // Catch: Throwable -> L18
            GroupDelta r17 = fromAfter(r4).setUngrouped(r15);     // Catch: Throwable -> L18
            if (r16 == null) goto L17;
            r16.close();
        L17:
            return r17;
        L9:
            if (r16.moveToFirst() == false) goto L14;
            r4.put("should_sync", Integer.valueOf(r16.getInt(0)));     // Catch: Throwable -> L18
            r4.put("ungrouped_visible", Integer.valueOf(r16.getInt(1)));     // Catch: Throwable -> L18
            GroupDelta r18 = fromBefore(r4).setUngrouped(r15);     // Catch: Throwable -> L18
            if (r16 == null) goto L13;
            r16.close();
        L13:
            return r18;
        L18:
            th = move-exception;
            if (r16 == null) goto L21;
            r16.close();
        L21:
            throw th;
        }

        public static GroupDelta fromBefore(ContentValues r1) {
            GroupDelta r0 = new GroupDelta();
            r0.mBefore = r1;
            r0.mAfter = new ContentValues();
            return r0;
        }

        public static GroupDelta fromAfter(ContentValues r2) {
            GroupDelta r0 = new GroupDelta();
            r0.mBefore = null;
            r0.mAfter = r2;
            return r0;
        }

        protected GroupDelta setUngrouped(boolean r2) {
            this.mUngrouped = true;
            this.mAccountHasGroups = r2;
            return this;
        }

        @Override // com.android.contacts.common.model.ValuesDelta
        public boolean beforeExists() {
            if (this.mBefore == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getShouldSync() {
            if (getAsInteger("should_sync", 1).intValue() != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean getVisible() {
            if (this.mUngrouped == false) goto L5;
            String r0 = "ungrouped_visible";
        L7:
            if (getAsInteger(r0, 0).intValue() == 0) goto L10;
            return true;
        L10:
            return false;
        L5:
            r0 = "group_visible";
            goto L7
        }

        public void putShouldSync(boolean r2) {
            put("should_sync", r2 ? 1 : 0);
        }

        public void putVisible(boolean r2) {
            if (this.mUngrouped == false) goto L5;
            String r0 = "ungrouped_visible";
        L6:
            put(r0, r2 ? 1 : 0);
            return;
        L5:
            r0 = "group_visible";
            goto L6
        }

        private String getAccountType() {
            if (this.mBefore != null) goto L5;
            ContentValues r1 = this.mAfter;
        L7:
            return r1.getAsString("account_type");
        L5:
            r1 = this.mBefore;
            goto L7
        }

        public CharSequence getTitle(Context r5) {
            if (this.mUngrouped == false) goto L13;
            String r0 = LocalizedNameResolver.getAllContactsName(r5, getAccountType());
            if (r0 == null) goto L8;
            return r0;
        L8:
            if (this.mAccountHasGroups == false) goto L12;
            return r5.getText(R.string.display_ungrouped);
        L12:
            return r5.getText(R.string.common_all_contacts);
        L13:
            Integer r1 = getAsInteger("title_res");
            if (r1 == null) goto L22;
            String r2 = getAsString("res_package");
            if (TextUtils.isEmpty(r2) == true) goto L20;
            return r5.getPackageManager().getText(r2, r1.intValue(), null);
        L20:
            return getAsString("title");
        L22:
            return getAsString("title");
        }

        public ContentProviderOperation buildDiff() {
            if (isInsert() == false) goto L11;
            if (this.mUngrouped == false) goto L9;
            this.mAfter.remove(this.mIdColumn);
            return ContentProviderOperation.newInsert(ContactsContract.Settings.CONTENT_URI).withValues(this.mAfter).build();
        L9:
            throw new IllegalStateException("Unexpected diff");
        L11:
            if (isUpdate() == true) goto L13;
            return null;
        L13:
            if (this.mUngrouped == false) goto L21;
            String r0 = getAsString("account_name");
            String r1 = getAsString("account_type");
            String r2 = getAsString("data_set");
            StringBuilder r3 = new StringBuilder("account_name=? AND account_type=?");
            if (r2 != null) goto L17;
            r3.append(" AND data_set IS NULL");
            String[] r4 = {r0, r1};
        L19:
            return ContentProviderOperation.newUpdate(ContactsContract.Settings.CONTENT_URI).withSelection(r3.toString(), r4).withValues(this.mAfter).build();
        L17:
            r3.append(" AND data_set=?");
            r4 = new String[]{r0, r1, r2};
            goto L19
        L21:
            return ContentProviderOperation.newUpdate(CustomContactListFilterActivity.access$100(ContactsContract.Groups.CONTENT_URI)).withSelection("_id=" + getId(), null).withValues(this.mAfter).build();
        }
    }

    public static class UpdateTask extends WeakAsyncTask<ArrayList<ContentProviderOperation>, Void, Void, Activity> {
        private ProgressDialog mProgress;

        @Override // com.android.contacts.common.util.WeakAsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Activity r1, ArrayList<ContentProviderOperation>[] r2) {
            return doInBackground2(r1, r2);
        }

        @Override // com.android.contacts.common.util.WeakAsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Activity r1, Void r2) {
            onPostExecute2(r1, r2);
        }

        @Override // com.android.contacts.common.util.WeakAsyncTask
        protected /* bridge */ /* synthetic */ void onPreExecute(Activity r1) {
            onPreExecute2(r1);
        }

        public UpdateTask(Activity r1) {
            super(r1);
        }

        /* JADX INFO: renamed from: onPreExecute, reason: avoid collision after fix types in other method */
        protected void onPreExecute2(Activity r3) {
            this.mProgress = ProgressDialog.show(r3, null, r3.getText(R.string.savingDisplayGroups));
            r3.startService(new Intent(r3, EmptyService.class));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Activity r3, ArrayList<ContentProviderOperation>... r4) {
            new ContentValues();
            ContentResolver r5 = r3.getContentResolver();
            r5.applyBatch("com.android.contacts", r4[0]);     // Catch: OperationApplicationException -> L5 RemoteException -> L7
        L14:
            return null;
        L5:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(CustomContactListFilterActivity.TAG, "Problem saving display groups", e);
            return null;
        L7:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(CustomContactListFilterActivity.TAG, "Problem saving display groups", e);
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Activity r2, Void r3) {
            this.mProgress.dismiss();     // Catch: Exception -> L4
        L6:
            r2.finish();
            r2.stopService(new Intent(r2, EmptyService.class));
            return;
        L4:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(CustomContactListFilterActivity.TAG, "Error dismissing progress dialog", e);
            goto L6
        }
    }

    public void com_android_contacts_common_list_CustomContactListFilterActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_list_CustomContactListFilterActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public CustomContactListFilterActivity() {
    }

    static /* synthetic */ Uri access$100(Uri r0) {
        return addCallerIsSyncAdapterParameter(r0);
    }

    static /* synthetic */ Comparator access$200() {
        return sIdComparator;
    }

    static /* synthetic */ DisplayAdapter access$300(CustomContactListFilterActivity r0) {
        return r0.mAdapter;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<AccountSet> r1, AccountSet r2) {
        onLoadFinished2(r1, r2);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.contact_list_filter_custom);
        ExpandableListView r4 = (ExpandableListView) findViewById(android.R.id.list);
        this.mList = r4;
        r4.setOnChildClickListener(this);
        this.mList.setHeaderDividersEnabled(true);
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        this.mAdapter = new DisplayAdapter(this);
        getLayoutInflater();
        findViewById(R.id.btn_done).setOnClickListener(this);
        findViewById(R.id.btn_discard).setOnClickListener(this);
        this.mList.setOnCreateContextMenuListener(this);
        this.mList.setAdapter(this.mAdapter);
        ActionBar r2 = getActionBar();
        if (r2 == null) goto L6;
        r2.setDisplayHomeAsUpEnabled(true);
        return;
    }

    @Override // android.app.Activity
    protected void onStart() {
        getLoaderManager().initLoader(1, null, this);
        super.onStart();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<AccountSet> onCreateLoader(int r1, Bundle r2) {
        return new CustomFilterConfigurationLoader(this);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<AccountSet> r1, AccountSet r2) {
        this.mAdapter.setAccounts(r2);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<AccountSet> r1) {
        this.mAdapter.setAccounts(null);
    }

    private static Uri addCallerIsSyncAdapterParameter(Uri r2) {
        return r2.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    }

    static {
        sIdComparator = new AnonymousClass1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != R.id.btn_done) goto L6;
        doSaveAction();
        return;
    L6:
        if (r3.getId() != R.id.btn_discard) goto L10;
        finish();
        return;
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView r1, View r2, int r3, int r4, long r5) {
        CheckBox r6 = (CheckBox) r2.findViewById(android.R.id.checkbox);
        AccountDisplay r7 = (AccountDisplay) this.mAdapter.getGroup(r3);
        GroupDelta r8 = (GroupDelta) this.mAdapter.getChild(r3, r4);
        if (r8 == null) goto L5;
        r6.toggle();
        r8.putVisible(r6.isChecked());
        return true;
    L5:
        openContextMenu(r2);
        return true;
    }

    protected int getSyncMode(AccountDisplay r2) {
        if ("com.google".equals(r2.mType) == true) goto L5;
        return 0;
    L5:
        if (r2.mDataSet != null) goto L10;
        return 2;
    L10:
        return 0;
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r3, View r4, ContextMenu.ContextMenuInfo r5) {
        super.onCreateContextMenu(r3, r4, r5);
        if ((r5 instanceof ExpandableListView.ExpandableListContextMenuInfo) == true) goto L5;
        return;
    L5:
        ExpandableListView.ExpandableListContextMenuInfo r6 = (ExpandableListView.ExpandableListContextMenuInfo) r5;
        int r7 = ExpandableListView.getPackedPositionGroup(r6.packedPosition);
        int r8 = ExpandableListView.getPackedPositionChild(r6.packedPosition);
        if (r8 != (-1)) goto L8;
        return;
    L8:
        AccountDisplay r0 = (AccountDisplay) this.mAdapter.getGroup(r7);
        GroupDelta r9 = (GroupDelta) this.mAdapter.getChild(r7, r8);
        int r10 = getSyncMode(r0);
        if (r10 != 0) goto L11;
        return;
    L11:
        if (r9 == null) goto L13;
        showRemoveSync(r3, r0, r9, r10);
        return;
    L13:
        showAddSync(r3, r0, r10);
    }

    protected void showRemoveSync(ContextMenu r8, final AccountDisplay r9, final GroupDelta r10, final int r11) {
        final CharSequence r5 = r10.getTitle(this);
        r8.setHeaderTitle(r5);
        r8.add(R.string.menu_sync_remove).setOnMenuItemClickListener(new AnonymousClass2(this, r9, r10, r11, r5));
    }

    protected void handleRemoveSync(final AccountDisplay r4, final GroupDelta r5, int r6, CharSequence r7) {
        boolean r0 = r4.mUngrouped.getShouldSync();
        if (r6 != 2) goto L8;
        if (r0 == false) goto L8;
        if (r5.equals(r4.mUngrouped) == true) goto L8;
        AlertDialog.Builder r8 = new AlertDialog.Builder(this);
        String r9 = getString(R.string.display_warn_remove_ungrouped, new Object[]{r7});
        r8.setTitle(R.string.menu_sync_remove);
        r8.setMessage(r9);
        r8.setNegativeButton(android.R.string.cancel, null);
        r8.setPositiveButton(android.R.string.ok, new AnonymousClass3(this, r4, r5));
        r8.show();
        return;
    L8:
        r4.setShouldSync(r5, false);
        this.mAdapter.notifyDataSetChanged();
    }

    protected void showAddSync(ContextMenu r5, final AccountDisplay r6, final int r7) {
        r5.setHeaderTitle(R.string.dialog_sync_add);
        Iterator<GroupDelta> r0 = r6.mUnsyncedGroups.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        final GroupDelta r1 = r0.next();
        if (r1.getShouldSync() == true) goto L4;
        r5.add(r1.getTitle(this)).setOnMenuItemClickListener(new AnonymousClass4(this, r1, r7, r6));
        goto L4
    }

    private void doSaveAction() {
        DisplayAdapter r0 = this.mAdapter;
        if (r0 != null) goto L5;
    L13:
        finish();
        return;
    L5:
        if (DisplayAdapter.access$500(r0) == null) goto L13;
        setResult(-1);
        ArrayList<ContentProviderOperation> r1 = DisplayAdapter.access$500(this.mAdapter).buildDiff();
        if (r1.isEmpty() == false) goto L11;
        finish();
        return;
    L11:
        new UpdateTask(this).execute(new ArrayList[]{r1});
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 16908332) goto L5;
        setResult(0);
        finish();
        return true;
    L5:
        return super.onOptionsItemSelected(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_list_CustomContactListFilterActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CustomContactListFilterActivity r1) {
        r1.com_android_contacts_common_list_CustomContactListFilterActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
