package com.android.contacts.list;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PinnedHeaderList.HeadersAdapter;
import com.android.contacts.PinnedHeaderList.WrapperView;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout;
import com.android.contacts.bytedanceosquickcontact.QuickContactHelper;
import com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.bytedanceosquickcontact.QuickContactListener;
import com.android.contacts.util.AsyncImageLoader;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsListBaseAdapter extends BaseAdapter implements HeadersAdapter, SectionIndexer, QuickContactListAdapterListener, QuickContactListView.RightModeViewListener, HorizontalScrollListView.ScrollStateListener {
    private String[] Section;
    private Activity mActivity;
    public AsyncImageLoader mAsyncImageLoader;
    protected BlacklistManager mBlacklistManager;
    protected ArrayList<SamContact> mContacts;
    protected Context mContext;
    protected boolean mIsEdit;
    public boolean mIsRightHandViewShow;
    private ContactsSelectionListener mListener;
    protected ContactPhotoManager mPhotoManager;
    private QuickContactListener mQuickContactListener;
    private VoiceBtnCallBack mVoiceBtnCB;

    public class ViewHolder {
        public FrameLayout avatarFrame;
        public View bgItem;
        public ImageView blacklistView;
        public OCheckBox checkBox;
        public FrameLayout checkBoxFrame;
        public ViewStub checkBoxStub;
        public long contactId;
        public View driver;
        public TextView header;
        public RelativeLayout headerParent;
        public TextView headerShadow;
        public QuickContactHelper helper;
        public QuickContactChildLayout item;
        public TextView label;
        public FrameLayout left;
        public TextView name;
        public AvatarImageView photo;
        public TextView photoBg;
        public TextView rightHand;
        public ImageView simIcon;
        final /* synthetic */ ContactsListBaseAdapter this$0;

        public ViewHolder(ContactsListBaseAdapter r1) {
            this.this$0 = r1;
        }
    }

    public interface VoiceBtnCallBack {
        void onVoiceBtnShow(boolean r1);
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int r1) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int r1) {
        return 0;
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollCompleted(View r1) {
    }

    static /* synthetic */ VoiceBtnCallBack access$000(ContactsListBaseAdapter r0) {
        return r0.mVoiceBtnCB;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public ContactsListBaseAdapter(Activity r2, ArrayList<SamContact> r3, ContactPhotoManager r4, AsyncImageLoader r5) {
        this.Section = new String[27];
        this.mIsRightHandViewShow = false;
        this.mIsEdit = false;
        this.mAsyncImageLoader = r5;
        this.mContacts = r3;
        this.mActivity = r2;
        Context r6 = r2.getBaseContext();
        this.mContext = r6;
        this.mPhotoManager = r4;
        this.mBlacklistManager = BlacklistManager.getInstances(r6);
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

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        super.notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<SamContact> r0 = this.mContacts;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // android.widget.Adapter
    public SamContact getItem(int r2) {
        ArrayList<SamContact> r0 = this.mContacts;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() != 0) goto L7;
        return null;
    L7:
        if (r2 < this.mContacts.size()) goto L10;
        return null;
    L10:
        return this.mContacts.get(r2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r4) {
        ArrayList<SamContact> r0 = this.mContacts;
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r4 >= 0) goto L7;
    L11:
        return -1;
    L7:
        if (r4 > r0.size()) goto L11;
        return this.mContacts.get(r4).contactId;
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersAdapter
    public View getHeaderView(int r2, View r3, ViewGroup r4) {
        if (r3 != null) goto L4;
        r3 = LayoutInflater.from(this.mContext).inflate(R.layout.header, null);
    L4:
        SamContact r1 = this.mContacts.get(r2);
        ((TextView) r3.findViewById(R.id.text)).setText(r1.section);
        return r3;
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersAdapter
    public long getHeaderId(int r4) {
        ArrayList<SamContact> r0 = this.mContacts;
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r4 >= 0) goto L7;
    L11:
        return -1;
    L7:
        if (r4 > r0.size()) goto L11;
        return this.mContacts.get(r4).section.hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int r11, View r12, ViewGroup r13) {
        if (r12 != null) goto L4;
        ViewHolder r14 = new ViewHolder(this);
        View r15 = LayoutInflater.from(this.mContext).inflate(R.layout.contact_list_item, null);
        r14.name = (TextView) r15.findViewById(R.id.name);
        r14.photo = (AvatarImageView) r15.findViewById(R.id.photo);
        r15.setTag(r14);
    L5:
        SamContact r16 = this.mContacts.get(r11);
        r14.name.setText(r16.name);
        r14.photo.setPhotoID(r16.photoId);
        this.mPhotoManager.loadPhoto(r14.photo, r16.photoId, false, false);
        r14.item.setBackgroundResource(R.drawable.contact_list_bg);
        return r15;
    L4:
        ViewHolder r17 = (ViewHolder) r12.getTag();
        r15 = r12;
        r14 = r17;
        goto L5
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.Section;
    }

    public void setList(ArrayList<SamContact> r4) {
        this.mContacts = r4;
        notifyDataSetChanged();
        if (this.mVoiceBtnCB == null) goto L14;
        ArrayList<SamContact> r5 = this.mContacts;
        if (r5 != null) goto L7;
    L12:
        this.mVoiceBtnCB.onVoiceBtnShow(false);
        ContactsUtils.setHasContact(false);
        return;
    L7:
        if (r5.size() == 0) goto L12;
        if (ContactsUtils.isOnlyIncludeProfile(this.mContacts) == true) goto L12;
        ContactsUtils.setHasContact(true);
        new Handler().postDelayed(new AnonymousClass1(this), 200);
        return;
    }

    public ArrayList<SamContact> getList() {
        return this.mContacts;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListView.RightModeViewListener
    public void setRightModeViewVisiblity(boolean r1) {
        this.mIsRightHandViewShow = r1;
        super.notifyDataSetChanged();
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrolling(int r1, View r2) {
        VoiceBtnCallBack r0 = this.mVoiceBtnCB;
        if (r0 == null) goto L6;
        r0.onVoiceBtnShow(false);
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

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollRestored(View r1) {
        VoiceBtnCallBack r0 = this.mVoiceBtnCB;
        if (r0 == null) goto L6;
        r0.onVoiceBtnShow(true);
        return;
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollStateChanged(View r2, int r3, int r4) {
        if (r3 == 0) goto L4;
        return;
    L4:
        if ((r2 instanceof WrapperView) == false) goto L16;
        ViewGroup r5 = (ViewGroup) r2;
        int r1 = r5.getChildCount();
        int r6 = 0;
    L6:
        if (r6 >= r1) goto L31;
        View r7 = r5.getChildAt(r6);
        if (r7 == null) goto L15;
        Object r8 = r7.getTag();
        if ((r8 instanceof ViewHolder) == false) goto L15;
        ViewHolder r9 = (ViewHolder) r8;
        if (r9.helper == null) goto L15;
        r9.helper.beforeHorizontalScrollOpen();
        return;
    L15:
        r6 = r6 + 1;
        goto L6
    L31:
        return;
    L16:
        Object r10 = r2.getTag();
        if (r10 != null) goto L19;
        return;
    L19:
        if ((r10 instanceof ViewHolder) == false) goto L30;
        ((ViewHolder) r10).helper.beforeHorizontalScrollOpen();
        return;
    }

    public void setEdit(boolean r1) {
        this.mIsEdit = r1;
    }

    public void setContactsSelectionListener(ContactsSelectionListener r1) {
        this.mListener = r1;
    }

    protected boolean isSelected(int r2) {
        return this.mListener.isSelected(getItemId(r2));
    }

    public boolean isEditMode() {
        return this.mIsEdit;
    }

    public void setVoiceButtonCallBack(VoiceBtnCallBack r1) {
        this.mVoiceBtnCB = r1;
    }
}
