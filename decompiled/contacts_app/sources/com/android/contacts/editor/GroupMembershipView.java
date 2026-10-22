package com.android.contacts.editor;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.ContactBaseData;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.AccountSelectionMenuDialog;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.NameSortComparator;
import com.google.common.base.Objects;
import com.obric.account.LocalAccountContactsUtils;
import com.obric.oui.popover.v2.OPopover;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GroupMembershipView extends LinearLayout implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String CHINESE_SAMPLE = "啊";
    private static final int CREATE_NEW_GROUP_GROUP_ID = 133;
    public static final int REQUEST_CODE_CREATE_GROUP = 7;
    private String mAccountName;
    private String mAccountType;
    private AccountTypeManager mAccountTypeManager;
    private GroupMembershipAdapter mAdapter;
    ContactEditorFragment mContactEditorFragment;
    private String mDataSet;
    private HashSet<Long> mDefaultGroupIds;
    private boolean mDefaultGroupVisibilityKnown;
    private boolean mDefaultGroupVisible;
    private Editor.EditorListener mExternalEditorListener;
    private HashSet<Long> mFavoriteGroupIds;
    private TextView mGroupFieldLabel;
    private TextView mGroupList;
    private Cursor mGroupMetaData;
    private String mGroupName;
    private Handler mHandler;
    private int mHintColorStateList;
    private boolean mIsCreateGroup;
    private boolean mIsMixedContact;
    private boolean mIsNeedToAdd;
    private DataKind mKind;
    private String mNoGroupString;
    private OPopover mPopover;
    private int mPrimaryColorStateList;
    private EntityDelta mState;

    private class GroupMembershipAdapter extends BaseAdapter {
        ArrayList<GroupSelectionItem> mGroupSelectionItems;
        final /* synthetic */ GroupMembershipView this$0;

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 4;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public GroupMembershipAdapter(GroupMembershipView r1) {
            this.this$0 = r1;
            this.mGroupSelectionItems = new ArrayList();
        }

        public void setData(ArrayList<GroupSelectionItem> r1) {
            this.mGroupSelectionItems = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mGroupSelectionItems.size();
        }

        @Override // android.widget.Adapter
        public GroupSelectionItem getItem(int r1) {
            return this.mGroupSelectionItems.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return GroupSelectionItem.access$400(this.mGroupSelectionItems.get(r1));
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            GroupSelectionItem r0 = getItem(r1);
            if (r0 != null) goto L7;
            return 0;
        L7:
            return GroupSelectionItem.access$300(r0);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            GroupSelectionItem r0 = getItem(r5);
            if (r0 == null) goto L5;
            int r1 = GroupSelectionItem.access$300(r0);
            if (r1 != 1) goto L9;
            if (r6 != null) goto L21;
            r6 = LayoutInflater.from(GroupMembershipView.access$500(this.this$0)).inflate(R.layout.group_membership_list_item, null);
        L21:
            CheckedTextView r4 = (CheckedTextView) r6.findViewById(R.id.checkedtextview);
            r4.setText(r0.toString());
            r4.setChecked(r0.isChecked());
            ((ListView) r7).setItemChecked(r5, r0.isChecked());
        L22:
            return r6;
        L9:
            if (r1 != 2) goto L11;
            if (r6 != null) goto L18;
            r6 = LayoutInflater.from(GroupMembershipView.access$600(this.this$0)).inflate(R.layout.group_membership_list_account_title_item, null);
        L18:
            ((TextView) r6.findViewById(R.id.textview)).setText(r0.toString());
            goto L22
        L11:
            if (r1 != 3) goto L22;
            if (r6 != null) goto L15;
            r6 = LayoutInflater.from(GroupMembershipView.access$700(this.this$0)).inflate(R.layout.group_membership_list_btn_add_item, null);
        L15:
            ((TextView) r6.findViewById(R.id.textview)).setText(r0.toString());
            goto L22
        L5:
            return new View(this.this$0.getContext());
        }
    }

    public static final class GroupSelectionItem extends ContactBaseData {
        public static final int TYPE_ADD = 3;
        public static final int TYPE_GROUP = 1;
        public static final int TYPE_TITLE = 2;
        private String accountName;
        private String accountType;
        private String dataSet;
        private boolean mChecked;
        private final long mGroupId;
        private final int type;

        static /* synthetic */ int access$300(GroupSelectionItem r0) {
            return r0.type;
        }

        static /* synthetic */ long access$400(GroupSelectionItem r2) {
            return r2.mGroupId;
        }

        public GroupSelectionItem(int r1, long r2, String r4, boolean r5, String r6, String r7, String r8) {
            this.type = r1;
            this.mGroupId = r2;
            this.name = r4;
            this.mChecked = r5;
            this.accountName = r6;
            this.accountType = r7;
            this.dataSet = r8;
            this.hasname = !TextUtils.isEmpty(r4);
            this.sortkey = ContactsUtils.getPinyinChineseName(this.name);
            this.group = ContactsUtils.getContactSection(ContactsUtils.getPinyinChineseName(r6));
            this.section = ContactsUtils.getContactSection(this.sortkey);
        }

        public long getGroupId() {
            return this.mGroupId;
        }

        public boolean isChecked() {
            return this.mChecked;
        }

        public void setChecked(boolean r1) {
            this.mChecked = r1;
        }

        public String getAccountName() {
            return this.accountName;
        }

        public String getAccountType() {
            return this.accountType;
        }

        public String getDataSet() {
            return this.dataSet;
        }

        public String toString() {
            return this.name;
        }
    }

    static /* synthetic */ GroupMembershipAdapter access$000(GroupMembershipView r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ OPopover access$100(GroupMembershipView r0) {
        return r0.mPopover;
    }

    static /* synthetic */ OPopover access$102(GroupMembershipView r0, OPopover r1) {
        r0.mPopover = r1;
        return r1;
    }

    static /* synthetic */ TextView access$200(GroupMembershipView r0) {
        return r0.mGroupList;
    }

    static /* synthetic */ Context access$500(GroupMembershipView r0) {
        return r0.mContext;
    }

    static /* synthetic */ Context access$600(GroupMembershipView r0) {
        return r0.mContext;
    }

    static /* synthetic */ Context access$700(GroupMembershipView r0) {
        return r0.mContext;
    }

    public GroupMembershipView(Context r2) {
        super(r2);
        this.mDefaultGroupIds = new HashSet();
        this.mFavoriteGroupIds = new HashSet();
        this.mGroupName = null;
        this.mIsNeedToAdd = true;
        this.mIsMixedContact = false;
        this.mIsCreateGroup = false;
        init(r2);
    }

    public GroupMembershipView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mDefaultGroupIds = new HashSet();
        this.mFavoriteGroupIds = new HashSet();
        this.mGroupName = null;
        this.mIsNeedToAdd = true;
        this.mIsMixedContact = false;
        this.mIsCreateGroup = false;
        init(r1);
    }

    private void init(Context r3) {
        this.mPrimaryColorStateList = r3.getResources().getColor(R.color.oui_basic_text_1);
        this.mHintColorStateList = r3.getResources().getColor(R.color.oui_basic_text_3);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mGroupFieldLabel = (TextView) findViewById(R.id.group_field_label);
        boolean r0 = "zh".equals(Locale.getDefault().getLanguage());
        boolean r1 = ContactsUtils.isScaledFontApplied(getContext());
        int r2 = R.dimen.text_field_label_width_big_font;
        if (r1 == false) goto L7;
        if (r0 == true) goto L9;
        r2 = R.dimen.text_field_lable_width_git_font_foreign;
    L9:
        ViewGroup.LayoutParams r3 = this.mGroupFieldLabel.getLayoutParams();
        r3.width = getResources().getDimensionPixelSize(r2);
        this.mGroupFieldLabel.setLayoutParams(r3);
        this.mNoGroupString = this.mContext.getString(R.string.common_groups);
        this.mHandler.postDelayed(new AnonymousClass1(this), 300);
        return;
    L7:
        if (r0 == false) goto L9;
        r2 = R.dimen.text_field_label_width;
        goto L9
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        TextView r0 = this.mGroupList;
        if (r0 == null) goto L6;
        r0.setEnabled(r1);
        return;
    }

    public void setKind(DataKind r1) {
        this.mKind = r1;
    }

    public void setGroupMetaData(Cursor r1) {
        this.mGroupMetaData = r1;
        updateView();
    }

    public void setContactEditorFragment(ContactEditorFragment r1) {
        this.mContactEditorFragment = r1;
    }

    public void setExternalEditorListener(Editor.EditorListener r1) {
        this.mExternalEditorListener = r1;
    }

    public boolean hasSelectedGroup() {
        if (isShown() == true) goto L5;
    L39:
        return false;
    L5:
        if (this.mState == null) goto L39;
        Cursor r0 = this.mGroupMetaData;
        if (r0 == null) goto L39;
        if (r0.isClosed() == true) goto L39;
        if (TextUtils.isEmpty(this.mGroupName) == true) goto L14;
        return true;
    L14:
        this.mGroupMetaData.moveToPosition(-1);
    L16:
        if (this.mGroupMetaData.moveToNext() == false) goto L39;
        String r1 = this.mGroupMetaData.getString(0);
        String r3 = this.mGroupMetaData.getString(1);
        String r4 = this.mGroupMetaData.getString(2);
        AccountWithDataSet r5 = new AccountWithDataSet(r1, r3, r4);
        if (this.mIsMixedContact == true) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == true) goto L31;
        if (TextUtils.equals(r1, this.mAccountName) == false) goto L16;
        if (TextUtils.equals(r3, this.mAccountType) == false) goto L16;
        if (Objects.equal(r4, this.mDataSet) == false) goto L16;
    L31:
        long r7 = this.mGroupMetaData.getLong(3);
        if (this.mFavoriteGroupIds.contains(Long.valueOf(r7)) == true) goto L16;
        if (this.mDefaultGroupIds.contains(Long.valueOf(r7)) == true) goto L16;
        if (hasMembership(r7) == false) goto L16;
        return true;
    L20:
        if (this.mState.isRefAccount(r5) == false) goto L22;
        r6 = true;
        goto L23
    }

    public void setState(EntityDelta r6) {
        this.mState = r6;
        EntityDelta.ValuesDelta r7 = r6.getValues();
        this.mAccountType = r7.getAsString("account_type");
        this.mAccountName = r7.getAsString("account_name");
        this.mDataSet = r7.getAsString("data_set");
        boolean r0 = false;
        this.mDefaultGroupVisibilityKnown = false;
        if (r7.getAsLong("_id").longValue() != (-115)) goto L5;
        r0 = true;
    L5:
        this.mIsMixedContact = r0;
        updateView();
    }

    private void updateView() {
        Cursor r1 = this.mGroupMetaData;
        if (r1 != null) goto L5;
    L118:
        setVisibility(8);
        return;
    L5:
        if (r1.isClosed() == true) goto L118;
        if (this.mAccountType == null) goto L118;
        if (this.mAccountName == null) goto L118;
        this.mFavoriteGroupIds.clear();
        this.mDefaultGroupIds.clear();
        StringBuilder r2 = new StringBuilder();
        this.mGroupMetaData.moveToPosition(-1);
        int r3 = 0;
        int r5 = 0;
    L12:
        boolean r10 = true;
        if (this.mGroupMetaData.moveToNext() == false) goto L51;
        String r6 = this.mGroupMetaData.getString(0);
        String r11 = this.mGroupMetaData.getString(1);
        String r9 = this.mGroupMetaData.getString(2);
        AccountWithDataSet r12 = new AccountWithDataSet(r6, r11, r9);
        if (this.mIsMixedContact == true) goto L17;
    L19:
        r10 = false;
    L20:
        if (r10 == true) goto L27;
        if (r6.equals(this.mAccountName) == false) goto L12;
        if (r11.equals(this.mAccountType) == false) goto L12;
        if (Objects.equal(r9, this.mDataSet) == false) goto L12;
    L27:
        long r8 = this.mGroupMetaData.getLong(3);
        if (this.mGroupMetaData.isNull(6) == true) goto L33;
        if (this.mGroupMetaData.getInt(6) == 0) goto L33;
        this.mFavoriteGroupIds.add(Long.valueOf(r8));
    L38:
        if (this.mFavoriteGroupIds.contains(Long.valueOf(r8)) == true) goto L12;
        if (this.mDefaultGroupIds.contains(Long.valueOf(r8)) == true) goto L12;
        if (hasMembership(r8) == false) goto L12;
        String r7 = this.mGroupMetaData.getString(4);
        if (TextUtils.isEmpty(r7) == true) goto L12;
        if (r2.length() == 0) goto L48;
        r5 = r5 + 1;
    L48:
        if (r5 != 0) goto L12;
        r2.append(r7);
    L33:
        if (this.mGroupMetaData.isNull(5) == true) goto L38;
        if (this.mGroupMetaData.getInt(5) == 0) goto L38;
        this.mDefaultGroupIds.add(Long.valueOf(r8));
        goto L38
    L17:
        if (this.mState.isRefAccount(r12) == false) goto L19;
    L51:
        if (this.mGroupList != null) goto L53;
        this.mGroupList = (TextView) findViewById(R.id.group_list);
    L53:
        this.mGroupList.setEnabled(isEnabled());
        if (r5 <= 0) goto L61;
        Resources r13 = getResources();
        Object[] r14 = new Object[1];
        if (this.mGroupName != null) goto L58;
        int r15 = 1;
    L59:
        r14[0] = Integer.valueOf(r15 + r5);
        r2.append(r13.getString(R.string.group_in_edit, r14));
        goto L61
    L58:
        r15 = 2;
    L61:
        if (r2.length() != 0) goto L66;
        String r16 = this.mGroupName;
        if (r16 != null) goto L65;
        this.mGroupList.setText(this.mNoGroupString);
        this.mGroupList.setTextColor(this.mHintColorStateList);
    L71:
        setVisibility(0);
        if (this.mDefaultGroupVisibilityKnown == true) goto L75;
        this.mDefaultGroupVisible = false;
        this.mDefaultGroupVisibilityKnown = true;
    L75:
        if (this.mGroupName == null) goto L117;
        this.mIsNeedToAdd = false;
        ArrayList<GroupSelectionItem> r4 = new ArrayList();
        this.mGroupMetaData.moveToPosition(-1);
    L78:
        if (this.mGroupMetaData.moveToNext() == false) goto L104;
        if (this.mGroupMetaData.getInt(8) != 0) goto L78;
        String r17 = this.mGroupMetaData.getString(r3);
        String r18 = this.mGroupMetaData.getString(1);
        String r19 = this.mGroupMetaData.getString(2);
        AccountWithDataSet r110 = new AccountWithDataSet(r17, r18, r19);
        if (this.mIsMixedContact == true) goto L85;
    L87:
        int r111 = r3;
    L88:
        if (r111 == 0) goto L90;
    L95:
        long r112 = this.mGroupMetaData.getLong(3);
        if (this.mFavoriteGroupIds.contains(Long.valueOf(r112)) == false) goto L98;
    L102:
        r3 = 0;
        goto L78
    L98:
        if (this.mDefaultGroupIds.contains(Long.valueOf(r112)) == true) goto L100;
    L101:
        r4.add(new GroupSelectionItem(1, r112, this.mGroupMetaData.getString(4), hasMembership(r112), r17, r18, r19));
        goto L102
    L100:
        if (this.mDefaultGroupVisible == false) goto L102;
    L90:
        if (r17.equals(this.mAccountName) == false) goto L102;
        if (r18.equals(this.mAccountType) == false) goto L102;
        if (Objects.equal(r19, this.mDataSet) == false) goto L102;
    L85:
        if (this.mState.isRefAccount(r110) == false) goto L87;
        r111 = 1;
        goto L88
    L104:
        if (r4.size() <= 1) goto L106;
        Collections.sort(r4, new NameSortComparator());
    L106:
        addExtraItems(r4);
        GroupMembershipAdapter r20 = this.mAdapter;
        if (r20 == null) goto L149;
        r20.setData(r4);
        this.mAdapter.notifyDataSetChanged();
        int r21 = 0;
    L110:
        if (r21 >= this.mAdapter.getCount()) goto L151;
        GroupSelectionItem r22 = this.mAdapter.getItem(r21);
        long r23 = r22.getGroupId();
        if (r22.name == null) goto L116;
        if (r22.name.equals(this.mGroupName) == false) goto L116;
        r22.setChecked(true);
        insertChild(r23, r22);
        this.mGroupName = null;
        this.mIsNeedToAdd = true;
        return;
    L116:
        r21 = r21 + 1;
        goto L110
    L151:
        return;
    L149:
        return;
    L117:
        return;
    L65:
        r2.append(r16);
        this.mGroupList.setText(r2);
        this.mGroupList.setTextColor(this.mPrimaryColorStateList);
        goto L71
    L66:
        if (r5 == 0) goto L68;
    L70:
        this.mGroupList.setText(r2);
        this.mGroupList.setTextColor(this.mPrimaryColorStateList);
        goto L71
    L68:
        if (this.mGroupName == null) goto L70;
        r2.append(getResources().getString(R.string.group_in_edit, new Object[]{2}));
        goto L70
    }

    private void addExtraItems(ArrayList<GroupSelectionItem> r18) {
        int r4 = 0;
        if (this.mIsMixedContact == false) goto L11;
        EntityDelta r2 = this.mState;
        if (r2 == null) goto L11;
        if (r2.getRefAccounts() == null) goto L11;
        if (this.mState.getRefAccounts().size() <= 1) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L23;
        HashMap r5 = new HashMap();
        int r6 = r18.size();
        String r7 = "";
        int r8 = 0;
    L14:
        if (r8 >= r6) goto L19;
        String r9 = getAccountTitle(r18.get(r8));
        if (r7.equals(r9) == true) goto L18;
        r5.put(Integer.valueOf(r8), r9);
        r7 = r9;
    L18:
        r8 = r8 + 1;
        goto L14
    L19:
        ArrayList r10 = new ArrayList(r5.keySet());
        Collections.sort(r10);
        Iterator r11 = r10.iterator();
    L21:
        if (r11.hasNext() == false) goto L23;
        Integer r12 = (Integer) r11.next();
        r18.add(r12.intValue() + r4, new GroupSelectionItem(2, -1, (String) r5.get(r12), false, "", "", ""));
        r4 = r4 + 1;
    L23:
        r18.add(r18.size(), new GroupSelectionItem(3, -1, getContext().getString(R.string.common_create_new_group), false, "", "", ""));
        return;
    L11:
        r3 = false;
        goto L12
    }

    private String getAccountTitle(GroupSelectionItem r6) {
        if (this.mAccountTypeManager != null) goto L5;
        this.mAccountTypeManager = AccountTypeManager.getInstance(getContext());
    L5:
        String r0 = r6.getAccountType();
        String r1 = r6.getAccountName();
        AccountType r7 = this.mAccountTypeManager.getAccountType(r0, r6.getDataSet());
        if (LocalAccountContactsUtils.isLocalAccount(r1, r0) == false) goto L9;
        return getContext().getString(R.string.local_group) + " - " + r7.getDisplayLabel(getContext());
    L9:
        return r7.getDisplayLabel(getContext()) + " - " + ContactsUtils.getAccountName(getContext(), r0, r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r13) {
        if (ContactsUtils.isJustClicked() == false) goto L5;
        return;
    L5:
        OPopover r14 = this.mPopover;
        if (r14 != null) goto L8;
    L11:
        Cursor r15 = this.mGroupMetaData;
        if (r15 != null) goto L14;
    L50:
        hideSoftKeyboard();
        this.mIsCreateGroup = false;
        return;
    L14:
        if (r15.isClosed() == true) goto L50;
        if (this.mAdapter != null) goto L19;
        this.mAdapter = new GroupMembershipAdapter(this);
    L19:
        final ArrayList<GroupSelectionItem> r16 = new ArrayList();
        this.mGroupMetaData.moveToPosition(-1);
    L20:
        boolean r2 = true;
        if (this.mGroupMetaData.moveToNext() == false) goto L46;
        if (this.mGroupMetaData.getInt(8) != 0) goto L20;
        String r9 = this.mGroupMetaData.getString(0);
        String r10 = this.mGroupMetaData.getString(1);
        String r11 = this.mGroupMetaData.getString(2);
        AccountWithDataSet r1 = new AccountWithDataSet(r9, r10, r11);
        if (this.mIsMixedContact == true) goto L28;
    L30:
        r2 = false;
    L31:
        if (r2 == true) goto L38;
        if (r9.equals(this.mAccountName) == false) goto L20;
        if (r10.equals(this.mAccountType) == false) goto L20;
        if (Objects.equal(r11, this.mDataSet) == false) goto L20;
    L38:
        long r5 = this.mGroupMetaData.getLong(3);
        if (this.mFavoriteGroupIds.contains(Long.valueOf(r5)) == true) goto L20;
        if (this.mDefaultGroupIds.contains(Long.valueOf(r5)) == false) goto L44;
        if (this.mDefaultGroupVisible == false) goto L20;
    L44:
        r16.add(new GroupSelectionItem(1, r5, this.mGroupMetaData.getString(4), hasMembership(r5), r9, r10, r11));
        goto L20
    L28:
        if (this.mState.isRefAccount(r1) == false) goto L30;
    L46:
        if (r16.size() <= 1) goto L48;
        Collections.sort(r16, new NameSortComparator());
    L48:
        addExtraItems(r16);
        hideSoftKeyboard();
        this.mIsCreateGroup = false;
        this.mHandler.post(new AnonymousClass2(this, r16));
        return;
    L8:
        if (r14.isShowing() == false) goto L11;
        this.mPopover.dismiss();
    }

    public int getListViewHeight(ListView r7) {
        int r0 = r7.getMeasuredHeight();
        int r2 = 0;
    L4:
        if (r2 >= this.mAdapter.getCount()) goto L9;
        View r5 = (View) null;
        View r3 = this.mAdapter.getView(r2, null, r7);
        if (r3 == null) goto L8;
        r3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r0 = r0 + r3.getMeasuredHeight();
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OPopover r0 = this.mPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mPopover = null;
        return;
    }

    private void hideSoftKeyboard() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r4, View r5, int r6, long r7) {
        if (GroupSelectionItem.access$300(this.mAdapter.getItem(r6)) != 2) goto L5;
        return;
    L5:
        ListView r8 = (ListView) r4;
        int r9 = this.mAdapter.getCount();
        int r10 = r9 - 1;
        int r0 = 0;
        if (r8.isItemChecked(r10) == false) goto L14;
        r8.setItemChecked(r10, false);
        this.mIsCreateGroup = true;
        OPopover r11 = this.mPopover;
        if (r11 != null) goto L10;
    L12:
        createNewGroup();
        return;
    L10:
        if (r11.isShowing() == false) goto L12;
        this.mPopover.dismiss();
        goto L12
    L14:
        int r12 = 0;
    L15:
        if (r12 >= r9) goto L17;
        this.mAdapter.getItem(r12).setChecked(r8.isItemChecked(r12));
        r12 = r12 + 1;
        goto L15
    L17:
        ArrayList<EntityDelta.ValuesDelta> r13 = this.mState.getMimeEntries("vnd.android.cursor.item/group_membership");
        if (r13 == null) goto L37;
        Iterator<EntityDelta.ValuesDelta> r14 = r13.iterator();
    L21:
        if (r14.hasNext() == false) goto L37;
        EntityDelta.ValuesDelta r15 = r14.next();
        if (r15.isDelete() == true) goto L21;
        Long r16 = r15.getAsLong("data1");
        if (r16 == null) goto L21;
        if (this.mFavoriteGroupIds.contains(r16) == true) goto L21;
        if (this.mDefaultGroupIds.contains(r16) == false) goto L33;
        if (this.mDefaultGroupVisible == false) goto L21;
    L33:
        if (isGroupChecked(r16.longValue()) == true) goto L21;
        r15.markDeleted();
        if (this.mIsMixedContact == false) goto L21;
        r15.markRefDeleted();
    L37:
        if (r0 >= r9) goto L44;
        GroupSelectionItem r17 = this.mAdapter.getItem(r0);
        long r18 = r17.getGroupId();
        if (r17.isChecked() == false) goto L43;
        if (hasMembership(r18) == true) goto L43;
        insertChild(r18, r17);
    L43:
        r0 = r0 + 1;
        goto L37
    L44:
        updateView();
        GroupMembershipAdapter r19 = this.mAdapter;
        if (r19 == null) goto L47;
        r19.notifyDataSetChanged();
    L47:
        Editor.EditorListener r3 = this.mExternalEditorListener;
        if (r3 == null) goto L73;
        r3.onRequest(2);
        return;
    }

    private void insertChild(long r8, GroupSelectionItem r10) {
        if (this.mIsMixedContact == false) goto L14;
        Iterator<EntityDelta> r0 = this.mContactEditorFragment.getEntityDeltaList().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        EntityDelta r2 = r0.next();
        EntityDelta.ValuesDelta r3 = r2.getValues();
        String r4 = r3.getAsString("account_name");
        String r5 = r3.getAsString("account_type");
        String r6 = r3.getAsString("data_set");
        if (TextUtils.equals(r4, r10.getAccountName()) == false) goto L6;
        if (TextUtils.equals(r5, r10.getAccountType()) == false) goto L6;
        if (TextUtils.equals(r6, r10.getDataSet()) == false) goto L6;
        EntityModifier.insertChild(r2, AccountTypeManager.getInstance(getContext()).getAccountType(r5, r6).getKindForMimetype("vnd.android.cursor.item/group_membership")).put("data1", r8);
    L14:
        EntityModifier.insertChild(this.mState, this.mKind).put("data1", r8);
    }

    public void setGroupNameToAdd(String r1) {
        this.mGroupName = r1;
        if (this.mIsNeedToAdd == false) goto L5;
        updateView();
    L5:
        Editor.EditorListener r0 = this.mExternalEditorListener;
        if (r0 == null) goto L9;
        r0.onRequest(2);
        return;
    }

    private boolean isGroupChecked(long r7) {
        int r0 = this.mAdapter.getCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        GroupSelectionItem r3 = this.mAdapter.getItem(r2);
        if (r7 == r3.getGroupId()) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return r3.isChecked();
    L9:
        return false;
    }

    private boolean hasMembership(long r5) {
        if (this.mDefaultGroupIds.contains(Long.valueOf(r5)) == true) goto L5;
    L7:
        ArrayList<EntityDelta.ValuesDelta> r4 = this.mState.getMimeEntries("vnd.android.cursor.item/group_membership");
        if (r4 == null) goto L19;
        Iterator<EntityDelta.ValuesDelta> r6 = r4.iterator();
    L11:
        if (r6.hasNext() == false) goto L29;
        EntityDelta.ValuesDelta r0 = r6.next();
        if (r0.isDelete() == true) goto L11;
        Long r1 = r0.getAsLong("data1");
        if (r1 == null) goto L11;
        if (r1.longValue() != r5) goto L11;
        return true;
    L29:
        return false;
    L19:
        return false;
    L5:
        if (this.mState.isContactInsert() == false) goto L7;
        return true;
    }

    private void createNewGroup() {
        OPopover r0 = this.mPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mPopover = null;
    L6:
        if (this.mIsMixedContact == false) goto L19;
        Set<AccountWithDataSet> r1 = this.mState.getRefAccounts();
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isEmpty() == true) goto L24;
        Iterator<AccountWithDataSet> r2 = r1.iterator();
        if (r1.size() != 1) goto L16;
        AccountWithDataSet r3 = r2.next();
        this.mContactEditorFragment.createNewGroup(r3);
        return;
    L16:
        if (r1.size() <= 1) goto L23;
        showSelectAccountDialog();
        return;
    L23:
        return;
    L24:
        return;
    L19:
        this.mContactEditorFragment.createNewGroup();
    }

    private void showSelectAccountDialog() {
        Set<AccountWithDataSet> r0 = this.mState.getRefAccounts();
        if (r0 != null) goto L5;
        return;
    L5:
        final ArrayList r1 = new ArrayList(r0);
        ((AccountSelectionMenuDialog) AccountSelectionUtil.getSelectAccountDialog(getContext(), R.string.group_editor_prompt_multiple_accounts_bytedance, new AnonymousClass3(this, r1), null, r1)).show();
    }
}
