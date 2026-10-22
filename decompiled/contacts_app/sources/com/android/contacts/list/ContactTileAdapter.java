package com.android.contacts.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.GlobalProxyLancet;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.bytedanceosquickcontact.QuickContactListener;
import com.android.contacts.group.GroupDetailFragment;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obric.utils.views.commonitemview.ContactsSwipeHelper;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public class ContactTileAdapter extends BaseAdapter implements QuickContactListAdapterListener, QuickContactListView.RightModeViewListener {
    private static final String TAG = "ContactTileAdapter";
    private ContactsCommonListItem closingSwipeItem;
    private Activity mActivity;
    private BlacklistManager mBlacklistManager;
    private Context mContext;
    private GroupDetailFragment mGroupDetailFragment;
    private boolean mIsEditmode;
    public boolean mIsRightHandViewShow;
    private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private ContactPhotoManager mPhotoManager;
    private OIndexScrollbar mQuickBar;
    private QuickContactListener mQuickContactListener;
    private ArrayList<Long> mSelectedContactIds;
    private ArrayList<ContactEntry> mSortedList;
    private ContactsListBaseAdapter.VoiceBtnCallBack mVoiceBtnCB;
    private ContactsCommonListItem swipeItem;

    /* JADX INFO: renamed from: com.android.contacts.list.ContactTileAdapter$2, reason: invalid class name */
    class AnonymousClass2 implements Function2<List<? extends SwipeItemButtonType>, Function1<? super SwipeItemButtonType, Unit>, Unit> {
        final /* synthetic */ ContactTileAdapter this$0;
        final /* synthetic */ ContactsCommonListItem val$cardListItem;

        AnonymousClass2(ContactTileAdapter r1, ContactsCommonListItem r2) {
            this.this$0 = r1;
            this.val$cardListItem = r2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends SwipeItemButtonType> r1, Function1<? super SwipeItemButtonType, Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public Unit invoke2(List<? extends SwipeItemButtonType> r3, final Function1<? super SwipeItemButtonType, Unit> r4) {
            this.val$cardListItem.setSwipeItemButtonView(r3, new ContactTileAdapter$2$$ExternalSyntheticLambda0(this, r4));
            return null;
        }

        /* JADX INFO: renamed from: lambda$invoke$0$com-android-contacts-list-ContactTileAdapter$2, reason: not valid java name */
        /* synthetic */ Unit m198lambda$invoke$0$comandroidcontactslistContactTileAdapter$2(Function1 r1, SwipeItemButtonType r2) {
            r1.invoke(r2);
            ContactTileAdapter.access$300(this.this$0);
            return null;
        }
    }

    public static class ContactEntry extends ContactBaseData {
        public long contactId;
        public Uri lookupUri;
        public String phoneLabel;
        public String phoneNumber;
        public long photoId;
        public Uri photoUri;
        public Drawable presenceIcon;
        public long rawContactId;
        public String status;

        public ContactEntry() {
        }
    }

    private int getLayoutResourceId() {
        return R.layout.contact_tile_starred_quick_contact;
    }

    static /* synthetic */ void access$000(ContactTileAdapter r0, ContactEntry r1, ContactsCommonListItem r2) {
        r0.itemClickListener(r1, r2);
    }

    static /* synthetic */ boolean access$100(ContactTileAdapter r0) {
        return r0.mIsEditmode;
    }

    static /* synthetic */ HorizontalScrollListView.ItemLongClickedListener access$200(ContactTileAdapter r0) {
        return r0.mItemLongClickedListener;
    }

    static /* synthetic */ void access$300(ContactTileAdapter r0) {
        r0.hideSwipedViews();
    }

    static /* synthetic */ ContactsCommonListItem access$400(ContactTileAdapter r0) {
        return r0.closingSwipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$402(ContactTileAdapter r0, ContactsCommonListItem r1) {
        r0.closingSwipeItem = r1;
        return r1;
    }

    static /* synthetic */ ContactsCommonListItem access$500(ContactTileAdapter r0) {
        return r0.swipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$502(ContactTileAdapter r0, ContactsCommonListItem r1) {
        r0.swipeItem = r1;
        return r1;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public void setVoiceButtonCallBack(ContactsListBaseAdapter.VoiceBtnCallBack r1) {
        this.mVoiceBtnCB = r1;
    }

    public ContactTileAdapter(GroupDetailFragment r2) {
        this.mSelectedContactIds = new ArrayList();
        this.mIsEditmode = false;
        this.mIsRightHandViewShow = true;
        this.mSortedList = new ArrayList();
        this.swipeItem = null;
        this.closingSwipeItem = null;
        this.mContext = r2.getActivity();
        this.mActivity = r2.getActivity();
        this.mGroupDetailFragment = r2;
        Context r3 = this.mContext;
        if (r3 == null) goto L6;
        this.mBlacklistManager = BlacklistManager.getInstances(r3);
        return;
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

    public ArrayList<Long> getSelectedContactIds() {
        return this.mSelectedContactIds;
    }

    public void setPhotoLoader(ContactPhotoManager r1) {
        this.mPhotoManager = r1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        hideSwipedViews();
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        super.notifyDataSetChanged();
        this.mGroupDetailFragment.dismissLongMenu();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        hideSwipedViews();
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        super.notifyDataSetInvalidated();
    }

    public void setSecletAll(boolean r5) {
        if (this.mSortedList.size() > 0) goto L5;
        return;
    L5:
        this.mSelectedContactIds.clear();
        if (r5 == false) goto L11;
        Iterator<ContactEntry> r6 = this.mSortedList.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        ContactEntry r0 = r6.next();
        this.mSelectedContactIds.add(Long.valueOf(r0.rawContactId));
    L11:
        this.mGroupDetailFragment.setSize(this.mSelectedContactIds.size());
        notifyDataSetChanged();
    }

    public void setList(ArrayList<ContactEntry> r3, boolean r4) {
        if (ContactsUtils.DEBUG == true) goto L5;
    L7:
        ArrayList<ContactEntry> r0 = new ArrayList();
        r0.addAll(r3);
        this.mSortedList = r0;
        notifyDataSetChanged(r4);
        return;
    L5:
        if (Thread.currentThread().getName().equals("main") == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "current thread id " + Thread.currentThread().getName() + "  " + Log.getStackTraceString(new Throwable()));
        goto L7
    }

    public void notifyDataSetChanged(boolean r2) {
        hideSwipedViews();
        super.notifyDataSetChanged();
        if (r2 == false) goto L5;
        this.mGroupDetailFragment.setSize(this.mSelectedContactIds.size());
    L5:
        this.mGroupDetailFragment.dismissLongMenu();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ContactEntry> r0 = this.mSortedList;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    @Override // android.widget.Adapter
    public ContactEntry getItem(int r2) {
        if (this.mSortedList.isEmpty() == true) goto L10;
        if (r2 >= this.mSortedList.size()) goto L10;
        return this.mSortedList.get(r2);
    L10:
        return new ContactEntry();
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        ArrayList<ContactEntry> r0 = this.mSortedList;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.get(r1).rawContactId;
    }

    public boolean isChecked(int r3) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "isChecked postion = " + r3);
    L6:
        return this.mSelectedContactIds.contains(Long.valueOf(getItemId(r3)));
    }

    public boolean setChecked(int r6, boolean r7) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setChecked postion = " + r6);
    L5:
        long r0 = getItemId(r6);
        if (r0 >= 0) goto L9;
        return false;
    L9:
        if (r7 == true) goto L11;
    L14:
        if (r7 == false) goto L16;
    L19:
        return false;
    L16:
        if (this.mSelectedContactIds.contains(Long.valueOf(r0)) == false) goto L19;
        this.mSelectedContactIds.remove(Long.valueOf(r0));
        return true;
    L11:
        if (this.mSelectedContactIds.contains(Long.valueOf(r0)) == true) goto L14;
        this.mSelectedContactIds.add(Long.valueOf(r0));
        return true;
    }

    @Override // android.widget.Adapter
    public View getView(final int r11, View r12, ViewGroup r13) {
        if (r12 != null) goto L5;
        r12 = new ContactsCommonListItem(this.mContext, null, 0);
    L5:
        final ContactsCommonListItem r0 = (ContactsCommonListItem) r12;
        r0.setChecked(isChecked(r11));
        r0.setShowAvatarContainer(true);
        r0.showDivider(true);
        final ContactEntry r2 = getItem(r11);
        r0.setTitleText(r2.name);
        this.mPhotoManager.loadPhoto(r0.getAvatarPhoto(), r2.photoUri, false, false);
        this.mBlacklistManager.loadBlacklist(r0.getBlacklistPhoto(), r2.contactId);
        if (this.mIsEditmode == true) goto L8;
        r0.setSelectedMode(false, false);
    L9:
        r0.setOnClickListener(new AnonymousClass1(this, r2, r0, r11));
        r0.setEnableSwipe(!this.mIsEditmode);
        ArrayList r7 = new ArrayList();
        r7.add(SwipeItemButtonType.SWIPE_PHONE);
        r7.add(SwipeItemButtonType.SWIPE_PHONE1);
        r7.add(SwipeItemButtonType.SWIPE_PHONE2);
        r7.add(SwipeItemButtonType.SWIPE_MESSAGE);
        r7.add(SwipeItemButtonType.SWIPE_STAR);
        new ContactsSwipeHelper().init(this.mContext, false, r2.lookupUri.toString(), r7, null, new AnonymousClass2(this, r0));
        r0.addSwipeListener(new AnonymousClass3(this, r0));
        r0.setEndContainerWidthWrap();
        r0.setTitleContainerWidthSpread();
        return r12;
    L8:
        r0.setSelectedMode(true, false);
        r0.setEnableSwipe(false);
        r0.setChecked(this.mSelectedContactIds.contains(Long.valueOf(r2.rawContactId)));
        goto L9
    }

    private void hideSwipedViews() {
        ContactsCommonListItem r0 = this.swipeItem;
        if (r0 == null) goto L6;
        this.closingSwipeItem = r0;
        r0.swipeClose();
        this.closingSwipeItem.setEnableSwipe(false);
        this.swipeItem = null;
        return;
    }

    private void itemClickListener(ContactEntry r5, ContactsCommonListItem r6) {
        long r0 = r5.rawContactId;
        if (this.mIsEditmode == true) goto L5;
        Uri r7 = r5.lookupUri;
        ContactDetailCacheManager.getInstance().loadResultData(r7);
        Intent r8 = ContactsIntentUtils.launchContactDetailIntent(getActivity(), r7, true, "contact_group_list");
        r8.putExtra(Constants.ContactsTracker.EXTRA_SOURCE_FOR_TRACKER, Constants.ContactsTracker.SUFFIX_FROM_LIST_GROUP);
        this.mContext.startActivity(r8);
        AnimationUtil.switchActivityAnimation(this.mGroupDetailFragment.getActivity(), 5);
        return;
    L5:
        if (this.mSelectedContactIds.contains(Long.valueOf(r0)) == true) goto L7;
        r6.setChecked(true);
        this.mSelectedContactIds.add(Long.valueOf(r0));
    L8:
        this.mGroupDetailFragment.setSize(this.mSelectedContactIds.size());
        return;
    L7:
        r6.setChecked(false);
        this.mSelectedContactIds.remove(Long.valueOf(r0));
        goto L8
    }

    public void setOnLongClickListener(HorizontalScrollListView.ItemLongClickedListener r1) {
        this.mItemLongClickedListener = r1;
    }

    protected void setBackgroundItemButtonsOnClickListener(View r4, View.OnClickListener r5) {
        int[] r0 = {R.id.umb_phone, R.id.umb_phone_1, R.id.umb_phone_2, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        int r1 = 0;
    L3:
        if (r1 >= 7) goto L8;
        View r2 = r4.findViewById(r0[r1]);
        if (r2 == null) goto L7;
        r2.setOnClickListener(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public void setEditMode(boolean r1) {
        this.mIsEditmode = r1;
        notifyDataSetChanged();
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListView.RightModeViewListener
    public void setRightModeViewVisiblity(boolean r1) {
        this.mIsRightHandViewShow = r1;
    }

    public void setQuickBar(OIndexScrollbar r1) {
        this.mQuickBar = r1;
    }
}
