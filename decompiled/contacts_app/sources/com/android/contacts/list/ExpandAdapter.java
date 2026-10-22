package com.android.contacts.list;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PinnedHeaderList.WrapperView;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout;
import com.android.contacts.bytedanceosquickcontact.QuickContactHelper;
import com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener;
import com.android.contacts.bytedanceosquickcontact.QuickContactListener;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExpandAdapter extends BaseExpandableListAdapter implements QuickContactListAdapterListener, HorizontalScrollExpandableListView.ScrollStateListener {
    private Activity mActivity;
    protected BlacklistManager mBlacklistManager;
    private ContactsSelectionListener mContactsSelectionListener;
    private Context mContext;
    private ArrayList<ArrayList<SamContact>> mData;
    public ExpandListView mExpandListView;
    private LayoutInflater mInflater;
    protected boolean mIsEdit;
    protected ContactPhotoManager mPhotoManager;
    private QuickContactListener mQuickContactListener;
    private ContactsListBaseAdapter.VoiceBtnCallBack mVoiceBtnCB;

    private class GroupViewHolder {
        TextView mGroupCount;
        TextView mGroupIcon;
        TextView mGroupName;
        final /* synthetic */ ExpandAdapter this$0;

        private GroupViewHolder(ExpandAdapter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ GroupViewHolder(ExpandAdapter r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public class ViewHolder {
        public FrameLayout avatarFrame;
        public View bgItem;
        public ImageView blacklistView;
        public OCheckBox checkBox;
        public FrameLayout checkBoxFrame;
        public long contactId;
        public QuickContactHelper helper;
        public QuickContactChildLayout item;
        public TextView label;
        public TextView name;
        public AvatarImageView photo;
        public TextView rightHand;
        public ImageView simIcon;
        final /* synthetic */ ExpandAdapter this$0;

        public ViewHolder(ExpandAdapter r1) {
            this.this$0 = r1;
        }
    }

    protected String getDefaultHeaderData() {
        return "";
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int r1, int r2) {
        return true;
    }

    @Override // com.android.contacts.list.HorizontalScrollExpandableListView.ScrollStateListener
    public void onScrollCompleted(View r1) {
    }

    static /* synthetic */ ContactsListBaseAdapter.VoiceBtnCallBack access$000(ExpandAdapter r0) {
        return r0.mVoiceBtnCB;
    }

    @Override // android.widget.ExpandableListAdapter
    public /* bridge */ /* synthetic */ Object getChild(int r1, int r2) {
        return getChild(r1, r2);
    }

    @Override // android.widget.ExpandableListAdapter
    public /* bridge */ /* synthetic */ Object getGroup(int r1) {
        return getGroup(r1);
    }

    public void setVoiceButtonCallBack(ContactsListBaseAdapter.VoiceBtnCallBack r1) {
        this.mVoiceBtnCB = r1;
    }

    public ExpandAdapter(Activity r2, ArrayList<ArrayList<SamContact>> r3, ContactPhotoManager r4, ExpandListView r5) {
        this.mInflater = null;
        this.mData = null;
        this.mActivity = r2;
        Context r6 = r2.getBaseContext();
        this.mContext = r6;
        this.mInflater = (LayoutInflater) r6.getSystemService("layout_inflater");
        this.mExpandListView = r5;
        this.mData = r3;
        this.mPhotoManager = r4;
        this.mBlacklistManager = BlacklistManager.getInstances(this.mContext);
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener
    public Activity getActivity() {
        return this.mActivity;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener
    public void setQuickContactListener(QuickContactListener r1) {
        this.mQuickContactListener = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener
    public QuickContactListener getQuickContactListener() {
        return this.mQuickContactListener;
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetChanged() {
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        super.notifyDataSetChanged();
        this.mExpandListView.refreshPinnedView();
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetInvalidated() {
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        super.notifyDataSetInvalidated();
    }

    public void setData(ArrayList<ArrayList<SamContact>> r4) {
        this.mData = r4;
        if (this.mVoiceBtnCB == null) goto L11;
        if (r4 != null) goto L6;
    L9:
        this.mVoiceBtnCB.onVoiceBtnShow(false);
        ContactsUtils.setHasContact(false);
        return;
    L6:
        if (r4.size() == 0) goto L9;
        ContactsUtils.setHasContact(true);
        new Handler().postDelayed(new AnonymousClass1(this), 200);
        return;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        ArrayList<ArrayList<SamContact>> r0 = this.mData;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int r2) {
        if (r2 >= 0) goto L4;
        return 0;
    L4:
        if (r2 < getGroupCount()) goto L7;
        return 0;
    L7:
        return this.mData.get(r2).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public List<SamContact> getGroup(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < getGroupCount()) goto L7;
        return null;
    L7:
        return this.mData.get(r2);
    }

    @Override // android.widget.ExpandableListAdapter
    public SamContact getChild(int r2, int r3) {
        if (r3 >= 0) goto L4;
        return null;
    L4:
        if (r3 < getChildrenCount(r2)) goto L7;
        return null;
    L7:
        return this.mData.get(r2).get(r3);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int r1) {
        return getHeaderData(r1).hashCode();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int r1, int r2) {
        SamContact r0 = getChild(r1, r2);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.phoneId;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int r4, boolean r5, View r6, ViewGroup r7) {
        GroupViewHolder r8 = new GroupViewHolder(this, null);
        if (r6 != null) goto L5;
        r6 = this.mInflater.inflate(R.layout.contact_group_tag, null);
        r8.mGroupName = (TextView) r6.findViewById(R.id.group_name);
        r8.mGroupCount = (TextView) r6.findViewById(R.id.group_count);
        r8.mGroupIcon = (TextView) r6.findViewById(R.id.icon);
        r6.setTag(r8);
    L6:
        SamContact r0 = getChild(r4, 0);
        if (TextUtils.isEmpty(r0.headerData) == false) goto L9;
        r8.mGroupName.setText(getDefaultHeaderData());
    L10:
        r8.mGroupCount.setText(HanziToPinyin.Token.SEPARATOR + this.mData.get(r4).size());
        if (r5 == false) goto L13;
        r8.mGroupIcon.setBackgroundResource(R.drawable.location_unfold);
    L14:
        return r6;
    L13:
        r8.mGroupIcon.setBackgroundResource(R.drawable.location_fold);
        goto L14
    L9:
        r8.mGroupName.setText(r0.headerData);
        goto L10
    L5:
        r8 = (GroupViewHolder) r6.getTag();
        goto L6
    }

    public String getHeaderData(int r2) {
        SamContact r3 = getChild(r2, 0);
        if (r3 != null) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(r3.headerData) == false) goto L10;
        return getDefaultHeaderData();
    L10:
        return r3.headerData;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int r27, int r28, boolean r29, View r30, ViewGroup r31) {
        ViewHolder r1 = new ViewHolder(this);
        if (r30 != null) goto L5;
        View r2 = LayoutInflater.from(this.mContext).inflate(R.layout.contact_list_item_sort_by_city, null);
        r1.photo = (AvatarImageView) r2.findViewById(R.id.photo);
        r1.name = (TextView) r2.findViewById(R.id.name);
        r1.label = (TextView) r2.findViewById(R.id.label);
        r1.item = (QuickContactChildLayout) r2.findViewById(R.id.item);
        r2.setTag(r1);
    L6:
        SamContact r3 = getChild(r27, r28);
        r1.name.setText(r3.name);
        r1.label.setText(ContactsUtils.getContactPhoneDescribe(this.mContext, r3.labelType, r3.label, PhoneNumberUtils.formatNumber(r3.number)));
        r1.photo.setPhotoID(r3.photoId);
        this.mPhotoManager.loadPhoto(r1.photo, r3.photoId, false, false);
        long r4 = getChildId(r27, r28);
        if (getQuickContactListener().getQuickContactCacheId() != r4) goto L9;
        QuickContactHelper r6 = new QuickContactHelper(getQuickContactListener().getQuickContactHelperCache(), getActivity(), r1.item, this.mPhotoManager, getQuickContactListener(), r3.contactId, r3.LookKey, true);
    L10:
        r6.setDataId(r4);
        r6.setTrackerTag("ContactListFragment");
        return r2;
    L9:
        r6 = new QuickContactHelper(getActivity(), r1.item, this.mPhotoManager, getQuickContactListener(), r3.contactId, r3.LookKey, true);
        goto L10
    L5:
        r1 = (ViewHolder) r30.getTag();
        r2 = r30;
        goto L6
    }

    @Override // com.android.contacts.list.HorizontalScrollExpandableListView.ScrollStateListener
    public void onScrolling(int r2, View r3) {
        if ((r3 instanceof WrapperView) == false) goto L5;
        r3 = ((ViewGroup) r3).getChildAt(0);
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        Object r4 = r3.getTag();
        if ((r4 instanceof ViewHolder) == false) goto L10;
        ((ViewHolder) r4).helper.beforeHorizontalScrollOpen();
    L10:
        ContactsListBaseAdapter.VoiceBtnCallBack r1 = this.mVoiceBtnCB;
        if (r1 == null) goto L14;
        r1.onVoiceBtnShow(false);
        return;
    }

    protected void checkItemReused(ViewHolder r3, SamContact r4) {
        if ((this.mQuickContactListener instanceof HorizontalScrollListView) == false) goto L10;
        if (r3 == null) goto L11;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r3.contactId == r4.contactId) goto L13;
        ((HorizontalScrollListView) this.mQuickContactListener).restoreScrollState(false);
        return;
    L13:
        return;
    L11:
        return;
    }

    @Override // com.android.contacts.list.HorizontalScrollExpandableListView.ScrollStateListener
    public void onScrollRestored(View r1) {
        ContactsListBaseAdapter.VoiceBtnCallBack r0 = this.mVoiceBtnCB;
        if (r0 == null) goto L6;
        r0.onVoiceBtnShow(true);
        return;
    }

    protected void setBackgroundItemButtonsOnClickListener(View r4, View.OnClickListener r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int[] r0 = {R.id.umb_phone, R.id.umb_phone_1, R.id.umb_phone_2, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        int r1 = 0;
    L5:
        if (r1 >= 7) goto L10;
        View r2 = r4.findViewById(r0[r1]);
        if (r2 == null) goto L9;
        r2.setOnClickListener(r5);
    L9:
        r1 = r1 + 1;
        goto L5
    }

    public void setEdit(boolean r1) {
        this.mIsEdit = r1;
    }

    public void setContactsSelectionListener(ContactsSelectionListener r1) {
        this.mContactsSelectionListener = r1;
    }

    protected boolean isSelected(int r1, int r2) {
        SamContact r3 = getChild(r1, r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        return this.mContactsSelectionListener.isSelected(r3.contactId);
    }
}
