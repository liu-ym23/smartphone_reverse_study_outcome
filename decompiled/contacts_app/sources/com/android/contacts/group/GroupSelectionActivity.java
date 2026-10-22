package com.android.contacts.group;

import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.activities.GroupEditorActivity;
import com.android.contacts.list.ContactBaseData;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.contacts.Constants;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;
import java.util.Collections;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class GroupSelectionActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int ADD_GROUP_ITEM_ID = -2;
    private static final int COLUMN_INDEX_COUNT = 2;
    private static final int COLUMN_INDEX_ID = 0;
    private static final int COLUMN_INDEX_TITLE = 1;
    public static final String EXTRA_ACCOUNT_DATA_SET = "account_data_set";
    public static final String EXTRA_ACCOUNT_NAME = "account_name";
    public static final String EXTRA_ACCOUNT_TYPE = "account_type";
    public static final String EXTRA_RAW_CONTACT_ID = "raw_contact_id";
    private static final String GROUP_ORDER_BY = "_id DESC";
    private static final String[] GROUP_PROJECTION = null;
    private static final String KEY_ACCOUNT_DATA_SET = "accountDataSet";
    private static final String KEY_ACCOUNT_NAME = "accountName";
    private static final String KEY_ACCOUNT_TYPE = "accountType";
    private static final String KEY_RAW_CONTACT_ID = "rawContactId";
    private static final String KEY_SELECTED_GROUP_IDS = "selectedIds";
    private static final String KEY_SPECIFIC_GROUP_IDS = "specificIds";
    private static final int REQUEST_CODE_ADD_NEW_GROUP = 1;
    private static final String[] SPECIFIC_GROUP_PROJECTION = null;
    private static final int TOKEN_ALL_GROUPS = 2;
    private static final int TOKEN_SPECIFIC_GROUPS = 1;
    private String mAccountDataSet;
    private String mAccountName;
    private String mAccountType;
    private String mAddGroupNameTemp;
    private TextView mBtnCancel;
    private TextView mBtnDone;
    private GroupSelectionAdapter mGroupSelectionAdapter;
    private ArrayList<GroupSelectionMetaData> mGroupsList;
    private ListView mGroupsListView;
    private GroupQueryHandler mQueryHandler;
    private long mRawContactId;
    private ArrayList<Long> mSelectedGroupIds;
    private long[] mSpecificGroupIds;

    private class GroupQueryHandler extends AsyncQueryHandler {
        private Context mContext;
        final /* synthetic */ GroupSelectionActivity this$0;

        public GroupQueryHandler(GroupSelectionActivity r1, Context r2, ContentResolver r3) {
            this.this$0 = r1;
            super(r3);
            this.mContext = r2;
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r4, Object r5, Cursor r6) {
            if (r4 != 1) goto L5;
            GroupSelectionActivity.access$400(this.this$0, r6);
            GroupSelectionActivity r7 = this.this$0;
            GroupSelectionActivity.access$700(r7, GroupSelectionActivity.access$500(r7), GroupSelectionActivity.access$600(this.this$0));
            return;
        L5:
            if (r4 != 2) goto L15;
            GroupSelectionActivity.access$000(this.this$0, r6);
            GroupSelectionActivity.access$100(this.this$0).add(new GroupSelectionMetaData(-2, null, 0));
            if (GroupSelectionActivity.access$200(this.this$0) != null) goto L10;
            GroupSelectionActivity r8 = this.this$0;
            GroupSelectionActivity r9 = this.this$0;
            GroupSelectionActivity.access$202(r8, new GroupSelectionAdapter(r9, this.mContext, GroupSelectionActivity.access$100(r9)));
            GroupSelectionActivity.access$300(this.this$0).setAdapter(GroupSelectionActivity.access$200(this.this$0));
            return;
        L10:
            GroupSelectionActivity.access$200(this.this$0).notifyDataSetChanged();
            return;
        }
    }

    private class GroupSelectionAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<GroupSelectionMetaData> mGroupList;
        final /* synthetic */ GroupSelectionActivity this$0;

        public GroupSelectionAdapter(GroupSelectionActivity r1, Context r2, ArrayList<GroupSelectionMetaData> r3) {
            this.this$0 = r1;
            this.mContext = r2;
            this.mGroupList = r3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mGroupList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mGroupList.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return GroupSelectionMetaData.access$800(this.mGroupList.get(r1));
        }

        @Override // android.widget.Adapter
        public View getView(int r6, View r7, ViewGroup r8) {
            GroupSelectionMetaData r9 = this.mGroupList.get(r6);
            if (r6 == (getCount() - 1)) goto L5;
            View r10 = LayoutInflater.from(this.mContext).inflate(R.layout.group_selection_list_item, null);
            ((TextView) r10.findViewById(R.id.group_name)).setText(r9.name);
            ((TextView) r10.findViewById(R.id.group_members_count)).setText(this.this$0.getResources().getQuantityString(R.plurals.contacts_total_number, GroupSelectionMetaData.access$900(r9), new Object[]{Integer.valueOf(GroupSelectionMetaData.access$900(r9))}));
            ((OCheckBox) r10.findViewById(R.id.group_checkbox)).setChecked(GroupSelectionActivity.access$1000(this.this$0).contains(Long.valueOf(GroupSelectionMetaData.access$800(r9))));
            return r10;
        L5:
            return LayoutInflater.from(this.mContext).inflate(R.layout.group_selection_list_add_group_item, null);
        }
    }

    public static final class GroupSelectionMetaData extends ContactBaseData {
        private final long mGroupId;
        private int mMembersCount;

        static /* synthetic */ long access$800(GroupSelectionMetaData r2) {
            return r2.mGroupId;
        }

        static /* synthetic */ int access$900(GroupSelectionMetaData r0) {
            return r0.mMembersCount;
        }

        public GroupSelectionMetaData(long r1, String r3, int r4) {
            this.mGroupId = r1;
            this.name = r3;
            this.hasname = true;
            this.sortkey = ContactsUtils.getPinyinChineseName(this.name);
            this.section = ContactsUtils.getContactSection(this.sortkey);
            this.mMembersCount = r4;
        }

        public long getGroupId() {
            return this.mGroupId;
        }

        public String toString() {
            return this.name;
        }
    }

    public void com_android_contacts_group_GroupSelectionActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_group_GroupSelectionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public GroupSelectionActivity() {
        this.mGroupsList = new ArrayList();
        this.mSelectedGroupIds = new ArrayList();
    }

    static /* synthetic */ void access$000(GroupSelectionActivity r0, Cursor r1) {
        r0.doQueryAllGroupsCompleteAction(r1);
    }

    static /* synthetic */ ArrayList access$100(GroupSelectionActivity r0) {
        return r0.mGroupsList;
    }

    static /* synthetic */ ArrayList access$1000(GroupSelectionActivity r0) {
        return r0.mSelectedGroupIds;
    }

    static /* synthetic */ GroupSelectionAdapter access$200(GroupSelectionActivity r0) {
        return r0.mGroupSelectionAdapter;
    }

    static /* synthetic */ GroupSelectionAdapter access$202(GroupSelectionActivity r0, GroupSelectionAdapter r1) {
        r0.mGroupSelectionAdapter = r1;
        return r1;
    }

    static /* synthetic */ ListView access$300(GroupSelectionActivity r0) {
        return r0.mGroupsListView;
    }

    static /* synthetic */ void access$400(GroupSelectionActivity r0, Cursor r1) {
        r0.doQuerySpecificGroupsCompleteAction(r1);
    }

    static /* synthetic */ String access$500(GroupSelectionActivity r0) {
        return r0.mAccountName;
    }

    static /* synthetic */ String access$600(GroupSelectionActivity r0) {
        return r0.mAccountType;
    }

    static /* synthetic */ void access$700(GroupSelectionActivity r0, String r1, String r2) {
        r0.queryAllGroups(r1, r2);
    }

    static {
        GROUP_PROJECTION = new String[]{"_id", "title", "summ_count"};
        SPECIFIC_GROUP_PROJECTION = new String[]{"data1"};
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.group_selection_layout);
        UiUtils.setWindowColorStatusBar(this);
        ListView r2 = (ListView) findViewById(R.id.group_selection_list);
        this.mGroupsListView = r2;
        r2.setOnItemClickListener(this);
        TextView r3 = (TextView) findViewById(R.id.btn_cancel);
        this.mBtnCancel = r3;
        r3.setOnClickListener(this);
        TextView r4 = (TextView) findViewById(R.id.btn_done);
        this.mBtnDone = r4;
        r4.setOnClickListener(this);
        parseIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        setIntent(r1);
        parseIntent(r1);
    }

    private void parseIntent(Intent r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.mRawContactId = r6.getLongExtra(EXTRA_RAW_CONTACT_ID, -1);
        this.mAccountName = r6.getStringExtra("account_name");
        this.mAccountType = r6.getStringExtra("account_type");
        if (this.mRawContactId != (-1)) goto L7;
    L10:
        finish();
    L11:
        String r7 = r6.getStringExtra(EXTRA_ACCOUNT_DATA_SET);
        this.mAccountDataSet = r7;
        if (r7 != null) goto L15;
        this.mAccountDataSet = "";
    L15:
        if (this.mQueryHandler != null) goto L17;
        this.mQueryHandler = new GroupQueryHandler(this, this, getContentResolver());
    L17:
        querySpecificGroups(this.mRawContactId);
        return;
    L7:
        if (TextUtils.isEmpty(this.mAccountName) == true) goto L10;
        if (TextUtils.isEmpty(this.mAccountType) == false) goto L11;
        goto L10
    }

    private void querySpecificGroups(long r9) {
        this.mQueryHandler.startQuery(1, null, ContactsContract.Data.CONTENT_URI, SPECIFIC_GROUP_PROJECTION, "raw_contact_id =?  AND mimetype = \"vnd.android.cursor.item/group_membership\"", new String[]{String.valueOf(r9)}, null);
    }

    private void queryAllGroups(String r9, String r10) {
        this.mQueryHandler.startQuery(2, null, ContactsContract.Groups.CONTENT_SUMMARY_URI, GROUP_PROJECTION, "account_name =? AND account_type  =? AND auto_add=0 AND favorites=0 AND deleted=0", new String[]{r9, r10}, GROUP_ORDER_BY);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != R.id.btn_cancel) goto L5;
        finish();
        return;
    L5:
        if (r3 != R.id.btn_done) goto L11;
        done();
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r3, View r4, int r5, long r6) {
        if (r6 != (-2)) goto L5;
        addNewGroup();
        return;
    L5:
        OCheckBox r7 = (OCheckBox) r4.findViewById(R.id.group_checkbox);
        if (r7.isChecked() == false) goto L12;
        if (this.mSelectedGroupIds.contains(Long.valueOf(r6)) == false) goto L10;
        this.mSelectedGroupIds.remove(Long.valueOf(r6));
    L10:
        r7.setChecked(false);
        return;
    L12:
        if (this.mSelectedGroupIds.contains(Long.valueOf(r6)) == true) goto L14;
        this.mSelectedGroupIds.add(Long.valueOf(r6));
    L14:
        r7.setChecked(true);
    }

    private void done() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
    L3:
        long[] r3 = this.mSpecificGroupIds;
        if (r2 >= r3.length) goto L10;
        if (this.mSelectedGroupIds.contains(Long.valueOf(r3[r2])) == false) goto L8;
        this.mSelectedGroupIds.remove(Long.valueOf(this.mSpecificGroupIds[r2]));
    L9:
        r2 = r2 + 1;
        goto L3
    L8:
        r0.add(Long.valueOf(this.mSpecificGroupIds[r2]));
        goto L9
    L10:
        int r4 = this.mSelectedGroupIds.size();
        long[] r6 = new long[r4];
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L13;
        r6[r5] = this.mSelectedGroupIds.get(r5).longValue();
        r5 = r5 + 1;
        goto L11
    L13:
        int r7 = r0.size();
        long[] r8 = new long[r7];
    L14:
        if (r1 >= r7) goto L16;
        r8[r1] = ((Long) r0.get(r1)).longValue();
        r1 = r1 + 1;
        goto L14
    L16:
        startService(ContactSaveService.CreateUpdateContactGroupDatas(getApplicationContext(), this.mRawContactId, r6, r8, this.mAccountName, this.mAccountType));
        finish();
    }

    private void addNewGroup() {
        Intent r0 = new Intent(this, GroupEditorActivity.class);
        r0.setAction("android.intent.action.INSERT");
        r0.putExtra(Constants.get_INSERT_ACCOUNT(), new AccountWithDataSet(this.mAccountName, this.mAccountType, this.mAccountDataSet));
        r0.putExtra(Constants.get_INSERT_DATA_SET(), this.mAccountDataSet);
        startActivityForResult(r0, 1);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 == 1) goto L5;
        return;
    L5:
        if (r3 == (-1)) goto L7;
        return;
    L7:
        if (r4 == null) goto L9;
        this.mAddGroupNameTemp = r4.getStringExtra(ContactSaveService.EXTRA_GROUP_LABEL);
    L9:
        queryAllGroups(this.mAccountName, this.mAccountType);
    }

    private void doQuerySpecificGroupsCompleteAction(Cursor r7) {
        if (r7 != null) goto L5;
    L24:
        this.mSpecificGroupIds = new long[0];
        return;
    L5:
        if (r7.getCount() == 0) goto L24;
        this.mSpecificGroupIds = new long[r7.getCount()];
    L19:
        th = move-exception;
        if (r7.isClosed() == true) goto L23;
        r7.close();
    L23:
        throw th;
    L9:
        if (r7.moveToFirst() == false) goto L16;
        int r1 = 0;
    L11:
        long r2 = r7.getLong(0);     // Catch: Throwable -> L19
        int r5 = r1 + 1;     // Catch: Throwable -> L19
        this.mSpecificGroupIds[r1] = r2;     // Catch: Throwable -> L19
        this.mSelectedGroupIds.add(Long.valueOf(r2));     // Catch: Throwable -> L19
        if (r7.moveToNext() == false) goto L16;
        r1 = r5;
    L16:
        if (r7.isClosed() == true) goto L29;
        r7.close();
        return;
    }

    private void doQueryAllGroupsCompleteAction(Cursor r7) {
        this.mGroupsList.clear();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getCount() == 0) goto L32;
    L21:
        th = move-exception;
        if (r7.isClosed() == true) goto L25;
        r7.close();
    L25:
        throw th;
    L8:
        if (r7.moveToFirst() == false) goto L18;
    L9:
        long r0 = r7.getLong(0);     // Catch: Throwable -> L21
        String r2 = r7.getString(1);     // Catch: Throwable -> L21
        int r3 = r7.getInt(2);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(this.mAddGroupNameTemp) == false) goto L12;
    L14:
        GroupSelectionMetaData r4 = new GroupSelectionMetaData(r0, r2, r3);     // Catch: Throwable -> L21
        this.mGroupsList.add(r4);     // Catch: Throwable -> L21
        if (r7.moveToNext() == true) goto L9;
        Collections.sort(this.mGroupsList, new NameSortComparator());     // Catch: Throwable -> L21
        goto L18
    L12:
        if (this.mAddGroupNameTemp.equals(r2) == false) goto L14;
        this.mSelectedGroupIds.add(Long.valueOf(r0));     // Catch: Throwable -> L21
        this.mAddGroupNameTemp = null;     // Catch: Throwable -> L21
    L18:
        if (r7.isClosed() == true) goto L31;
        r7.close();
        return;
    L31:
        return;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle r6) {
        super.onSaveInstanceState(r6);
        r6.putLong("rawContactId", this.mRawContactId);
        r6.putString("accountName", this.mAccountName);
        r6.putString("accountType", this.mAccountType);
        r6.putString(KEY_ACCOUNT_DATA_SET, this.mAccountDataSet);
        r6.putLongArray(KEY_SPECIFIC_GROUP_IDS, this.mSpecificGroupIds);
        int r0 = this.mSelectedGroupIds.size();
        long[] r1 = new long[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.mSelectedGroupIds.get(r2).longValue();
        r2 = r2 + 1;
        goto L3
    L5:
        r6.putLongArray(KEY_SELECTED_GROUP_IDS, r1);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle r6) {
        super.onRestoreInstanceState(r6);
        this.mRawContactId = r6.getLong("rawContactId");
        this.mAccountName = r6.getString("accountName");
        this.mAccountType = r6.getString("accountType");
        this.mAccountDataSet = r6.getString(KEY_ACCOUNT_DATA_SET);
        this.mSpecificGroupIds = r6.getLongArray(KEY_SPECIFIC_GROUP_IDS);
        long[] r7 = r6.getLongArray(KEY_SELECTED_GROUP_IDS);
        if (r7 != null) goto L5;
        return;
    L5:
        int r0 = r7.length;
        if (r0 <= 0) goto L8;
        this.mSelectedGroupIds.clear();
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L11;
        this.mSelectedGroupIds.add(Long.valueOf(r7[r1]));
        r1 = r1 + 1;
        goto L9
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AnimationUtil.switchActivityAnimation(this, 2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_group_GroupSelectionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(GroupSelectionActivity r1) {
        r1.com_android_contacts_group_GroupSelectionActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
