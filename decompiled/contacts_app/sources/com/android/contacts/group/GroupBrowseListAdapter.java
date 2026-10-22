package com.android.contacts.group;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PinnedHeaderList.HeadersAdapter;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.obric.account.LocalAccountContactsUtils;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class GroupBrowseListAdapter extends BaseAdapter implements HeadersAdapter {
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;
    private AccountTypeManager mAccountTypeManager;
    private ArrayList<Long> mCheckedIds;
    private final Context mContext;
    private ArrayList<Long> mDeletedGroupIds;
    private ArrayList<GroupListItem> mGroupListItems;
    private boolean mIsEdit;
    private final LayoutInflater mLayoutInflater;
    private View mListHeaderView;
    private OnGroupActionListener mOnGroupRenameListener;
    private ArrayList<String> mSelectedGroupNameList;
    private Uri mSelectedGroupUri;
    private boolean mSelectionVisible;

    public class GroupListItemViewCache {
        public final ImageView arrow;
        private final View btnEdit;
        public OCheckBox checkBox;
        public RelativeLayout checkBoxFrame;
        public LinearLayout countFrame;
        public final TextView groupMemberCount;
        public final TextView groupTitle;
        private RelativeLayout itemBody;
        private long mGroupId;
        private GroupListItem mGroupItem;
        private String mGroupName;
        private boolean mIsReadOnly;
        private Uri mUri;
        final /* synthetic */ GroupBrowseListAdapter this$0;

        public GroupListItemViewCache(GroupBrowseListAdapter r1, View r2) {
            this.this$0 = r1;
            this.mIsReadOnly = false;
            this.groupTitle = (TextView) r2.findViewById(R.id.label);
            this.groupMemberCount = (TextView) r2.findViewById(R.id.count);
            this.btnEdit = r2.findViewById(R.id.btn_edit);
            this.arrow = (ImageView) r2.findViewById(R.id.arrow);
            this.checkBox = (OCheckBox) r2.findViewById(R.id.checkbox);
            this.checkBoxFrame = (RelativeLayout) r2.findViewById(R.id.checkboxframe);
            this.itemBody = (RelativeLayout) r2.findViewById(R.id.group_list_body);
            this.countFrame = (LinearLayout) r2.findViewById(R.id.countFrame);
        }

        public void setUri(Uri r1) {
            this.mUri = r1;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public void setGroupId(long r1) {
            this.mGroupId = r1;
        }

        public long getGroupId() {
            return this.mGroupId;
        }

        public void setGroupName(String r1) {
            this.mGroupName = r1;
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public GroupListItem getGroupItem() {
            return this.mGroupItem;
        }

        public void setGroupItem(GroupListItem r1) {
            this.mGroupItem = r1;
        }
    }

    public interface OnGroupActionListener {
        void groupRename(Uri r1);

        void onChooseGroup(int r1);

        void onViewGroupAction(Uri r1);
    }

    private class onBtnEditClickLinstener implements View.OnClickListener {
        private Uri mGroupUri;
        final /* synthetic */ GroupBrowseListAdapter this$0;

        public onBtnEditClickLinstener(GroupBrowseListAdapter r1, Uri r2) {
            this.this$0 = r1;
            this.mGroupUri = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            if (ContactsUtils.isJustClicked() == true) goto L6;
            GroupBrowseListAdapter.access$300(this.this$0).groupRename(this.mGroupUri);
            return;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    static /* synthetic */ boolean access$000(GroupBrowseListAdapter r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ ArrayList access$100(GroupBrowseListAdapter r0) {
        return r0.mCheckedIds;
    }

    static /* synthetic */ ArrayList access$200(GroupBrowseListAdapter r0) {
        return r0.mSelectedGroupNameList;
    }

    static /* synthetic */ OnGroupActionListener access$300(GroupBrowseListAdapter r0) {
        return r0.mOnGroupRenameListener;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public void setListHeaderView(View r1) {
        this.mListHeaderView = r1;
        notifyDataSetChanged();
    }

    public View getListHeaderView() {
        return this.mListHeaderView;
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersAdapter
    public View getHeaderView(int r2, View r3, ViewGroup r4) {
        if (this.mListHeaderView == null) goto L7;
        if (r2 != 0) goto L7;
        View r5 = new View(this.mContext);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
        return r5;
    L7:
        if (r3 != null) goto L9;
        r3 = LayoutInflater.from(this.mContext).inflate(R.layout.header, null);
    L9:
        TextView r6 = (TextView) r3.findViewById(R.id.text);
        if (r6 == null) goto L12;
        r6.setText(getHeaderTitle(r2));
    L12:
        return r3;
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersAdapter
    public long getHeaderId(int r2) {
        if (this.mListHeaderView == null) goto L8;
        if (r2 != 0) goto L8;
        return -1;
    L8:
        return getHeaderTitle(r2).hashCode();
    }

    private String getHeaderTitle(int r6) {
        GroupListItem r7 = getItem(r6);
        String r0 = r7.getAccountType();
        String r1 = r7.getAccountName();
        String r8 = r7.getDataSet();
        if (this.mAccountTypeManager.getAccounts(true) == null) goto L5;
        int r2 = this.mAccountTypeManager.getAccounts(true).size();
    L6:
        if (r2 <= 1) goto L12;
        AccountType r9 = this.mAccountTypeManager.getAccountType(r0, r8);
        if (LocalAccountContactsUtils.isLocalAccount(r1, r0) == false) goto L14;
        return this.mContext.getString(R.string.local_group) + " - " + r9.getDisplayLabel(this.mContext);
    L14:
        return r9.getDisplayLabel(this.mContext) + " - " + ContactsUtils.getAccountName(this.mContext, r0, r1);
    L12:
        return ContactsUtils.getGroupName(this.mContext, r0, r1);
    L5:
        r2 = 0;
        goto L6
    }

    public GroupBrowseListAdapter(Context r2) {
        this.mIsEdit = false;
        this.mListHeaderView = null;
        this.mContext = r2;
        this.mLayoutInflater = LayoutInflater.from(r2);
        this.mCheckedIds = new ArrayList();
        this.mSelectedGroupNameList = new ArrayList();
        this.mGroupListItems = new ArrayList();
        this.mAccountTypeManager = AccountTypeManager.getInstance(r2);
    }

    public void setList(ArrayList<GroupListItem> r1) {
        this.mGroupListItems = r1;
        notifyDataSetChanged();
    }

    public void setOnGroupRenameClickListener(OnGroupActionListener r1) {
        this.mOnGroupRenameListener = r1;
    }

    public ArrayList<Long> getCheckedGroupIds() {
        return this.mCheckedIds;
    }

    public String getLastSelectedGroupName() {
        ArrayList<Long> r0 = this.mCheckedIds;
        long r1 = r0.get(r0.size() - 1).longValue();
        int r2 = 0;
    L4:
        if (r2 >= getCount()) goto L10;
        if (r1 == getItemId(r2)) goto L8;
        r2 = r2 + 1;
        goto L4
    L8:
        return getItem(r2).getTitle();
    L10:
        return null;
    }

    public void setDeleted(ArrayList<Long> r1) {
        this.mDeletedGroupIds = r1;
    }

    public void setGroupEdit(boolean r1) {
        this.mIsEdit = r1;
        this.mCheckedIds.clear();
        this.mSelectedGroupNameList.clear();
        notifyDataSetChanged();
    }

    public boolean isGroupEdit() {
        return this.mIsEdit;
    }

    public int getSelectedGroupPosition() {
        if (this.mSelectedGroupUri == null) goto L22;
        ArrayList<GroupListItem> r0 = this.mGroupListItems;
        if (r0 == null) goto L22;
        if (r0.size() == 0) goto L22;
        int r1 = 0;
    L11:
        if (r1 >= this.mGroupListItems.size()) goto L22;
        GroupListItem r2 = getItem(r1);
        if (r2 == null) goto L21;
        Uri r3 = getGroupUriFromId(r2);
        if (this.mSelectedGroupUri.equals(r3) == false) goto L21;
        if (this.mListHeaderView != null) goto L20;
        return r1;
    L20:
        return r1 + 1;
    L21:
        r1 = r1 + 1;
    L22:
        return -1;
    }

    public void setSelectionVisible(boolean r1) {
        this.mSelectionVisible = r1;
    }

    public void setSelectedGroup(Uri r1) {
        this.mSelectedGroupUri = r1;
    }

    public Uri getSelectedGroup() {
        return this.mSelectedGroupUri;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int r0 = this.mGroupListItems.size();
        if (this.mListHeaderView != null) goto L5;
        return r0;
    L5:
        return r0 + 1;
    }

    public ArrayList<GroupListItem> getGroupList() {
        return this.mGroupListItems;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r4) {
        if (this.mListHeaderView == null) goto L6;
        if (r4 != 0) goto L6;
        return -1;
    L6:
        GroupListItem r3 = getItem(r4);
        if (r3 != null) goto L9;
        return -1;
    L9:
        return r3.getGroupId();
    }

    public boolean isChecked(int r2) {
        if (this.mListHeaderView == null) goto L8;
        if (r2 != 0) goto L8;
        return false;
    L8:
        return this.mCheckedIds.contains(Long.valueOf(getItemId(r2)));
    }

    public boolean setChecked(int r7, boolean r8) {
        if (this.mListHeaderView == null) goto L6;
        if (r7 != 0) goto L6;
        return false;
    L6:
        long r2 = getItemId(r7);
        if (r2 >= 0) goto L9;
        return false;
    L9:
        GroupListItem r9 = getItem(r7);
        if (r9 == null) goto L15;
        if (r9.getGroupIsReadOnly() == false) goto L15;
        return false;
    L15:
        if (r8 == true) goto L17;
    L22:
        if (r8 == false) goto L24;
    L29:
        return false;
    L24:
        if (this.mCheckedIds.contains(Long.valueOf(r2)) == false) goto L29;
        this.mCheckedIds.remove(Long.valueOf(r2));
        if (r9 == null) goto L28;
        String r10 = r9.getTitle();
        this.mSelectedGroupNameList.add(r10);
    L28:
        return true;
    L17:
        if (this.mCheckedIds.contains(Long.valueOf(r2)) == true) goto L22;
        this.mCheckedIds.add(Long.valueOf(r2));
        if (r9 == null) goto L21;
        String r11 = r9.getTitle();
        this.mSelectedGroupNameList.add(r11);
    L21:
        return true;
    }

    public int getReadOnlyItemSize() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.mGroupListItems.size()) goto L11;
        GroupListItem r2 = this.mGroupListItems.get(r0);
        if (r2 == null) goto L10;
        if (r2.getGroupIsReadOnly() == false) goto L10;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        if (this.mListHeaderView == null) goto L7;
        if (r1 != 0) goto L9;
        return 0;
    L9:
        return 1;
    L7:
        return 1;
    }

    @Override // android.widget.Adapter
    public GroupListItem getItem(int r3) {
        if (this.mListHeaderView == null) goto L8;
        if (r3 != 0) goto L6;
        return null;
    L6:
        r3 = r3 - 1;
    L8:
        if (r3 < this.mGroupListItems.size()) goto L10;
        return null;
    L10:
        return this.mGroupListItems.get(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [com.obric.utils.views.commonitemview.ContactsCommonListItem] */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.view.View, com.obric.utils.views.commonitemview.ContactsCommonListItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // android.widget.Adapter
    public View getView(int r11, View r12, ViewGroup r13) {
        View r14 = this.mListHeaderView;
        if (r14 == null) goto L6;
        if (r11 != 0) goto L6;
        return r14;
    L6:
        final GroupListItem r15 = getItem(r11);
        if (r15 != null) goto L9;
        return r12;
    L9:
        int r0 = 0;
        if (r12 != null) goto L12;
        ?? r16 = new ContactsCommonListItem(this.mContext, null, 0);
        ContactsCommonListItem r1 = (ContactsCommonListItem) r16;
        r16.setTag(r16);
        ?? r2 = r16;
        final ?? r17 = r16;
    L13:
        r17.setTitleText(r15.getTitle());
        r17.showDivider(true);
        ViewGroup r18 = (ViewGroup) this.mLayoutInflater.inflate(R.layout.group_list_item_end, null, false);
        ViewGroup r3 = (ViewGroup) r18.findViewById(R.id.count_frame);
        TextView r4 = (TextView) r18.findViewById(R.id.group_list_count);
        ImageView r5 = (ImageView) r18.findViewById(R.id.group_list_edit);
        r4.setText(String.valueOf(r15.getMemberCount()));
        r17.setItemEndContainer(r18);
        final Uri r19 = getGroupUriFromId(r15);
        long r6 = r15.getGroupId();
        boolean r7 = r15.getGroupIsReadOnly();
        r17.setOnClickListener(new AnonymousClass1(this, r15, r17));
        if (r7 == false) goto L16;
        r17.setEnabled(!this.mIsEdit);
        r17.setSelectedMode(false, true);
    L25:
        r17.setEndContainerWidthWrap();
        r17.setTitleContainerWidthSpread();
        return r2;
    L16:
        r17.setSelectedMode(this.mIsEdit, true);
        r5.setOnClickListener(new AnonymousClass2(this, r19));
        r17.setChecked(this.mCheckedIds.contains(Long.valueOf(r6)));
        if (this.mIsEdit == false) goto L19;
        int r110 = 8;
    L20:
        r3.setVisibility(r110);
        if (this.mIsEdit == true) goto L24;
        r0 = 8;
    L24:
        r5.setVisibility(r0);
        goto L25
    L19:
        r110 = 0;
        goto L20
    L12:
        r2 = r12;
        r17 = (ContactsCommonListItem) r12.getTag();
        goto L13
    }

    public static Uri getGroupUriFromId(GroupListItem r3) {
        if (r3.isUngrouped() == false) goto L7;
        Uri.Builder r0 = Uri.parse(ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, r3.getGroupId()).toString()).buildUpon();
        r0.appendQueryParameter(GroupListItem.URI_KEY_ACCOUNT_NAME, r3.getAccountName());
        r0.appendQueryParameter(GroupListItem.URI_KEY_ACCOUNT_TYPE, r3.getAccountType());
        r0.appendQueryParameter(GroupListItem.URI_KEY_IS_UNGROUPED, String.valueOf(r3.isUngrouped()));
        return r0.build();
    L7:
        return ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, r3.getGroupId());
    }
}
