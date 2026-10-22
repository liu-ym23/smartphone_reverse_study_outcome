package com.android.contacts.list;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.GlobalProxyLancet;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.ContactsIntentUtils;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obric.utils.views.commonitemview.ContactsSwipeHelper;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public class FavoriteAdapter extends BaseAdapter {
    private static final String TAG = "FavoriteAdapter";
    private ContactsCommonListItem closingSwipeItem;
    private Activity mActivity;
    protected BlacklistManager mBlacklistManager;
    private HashMap<Long, FavoriteContact> mCheckedMap;
    private Context mContext;
    List<FavoriteContact> mFavoriteContacts;
    public HorizontalScrollListView mHSListView;
    private boolean mIsDataChanged;
    private boolean mIsEdit;
    private boolean mIsFavoriteCancling;
    private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ContactPhotoManager mPhotoManager;
    private long mSwipedItemId;
    private ContactsCommonListItem swipeItem;

    static /* synthetic */ void access$000(FavoriteAdapter r0) {
        r0.hideSwipedViews();
    }

    static /* synthetic */ AdapterView.OnItemClickListener access$100(FavoriteAdapter r0) {
        return r0.mOnItemClickListener;
    }

    static /* synthetic */ HorizontalScrollListView.ItemLongClickedListener access$200(FavoriteAdapter r0) {
        return r0.mItemLongClickedListener;
    }

    static /* synthetic */ boolean access$300(FavoriteAdapter r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ ContactsCommonListItem access$400(FavoriteAdapter r0) {
        return r0.closingSwipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$402(FavoriteAdapter r0, ContactsCommonListItem r1) {
        r0.closingSwipeItem = r1;
        return r1;
    }

    static /* synthetic */ ContactsCommonListItem access$500(FavoriteAdapter r0) {
        return r0.swipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$502(FavoriteAdapter r0, ContactsCommonListItem r1) {
        r0.swipeItem = r1;
        return r1;
    }

    static /* synthetic */ long access$600(FavoriteAdapter r2) {
        return r2.mSwipedItemId;
    }

    static /* synthetic */ long access$602(FavoriteAdapter r0, long r1) {
        r0.mSwipedItemId = r1;
        return r1;
    }

    static /* synthetic */ boolean access$702(FavoriteAdapter r0, boolean r1) {
        r0.mIsFavoriteCancling = r1;
        return r1;
    }

    static /* synthetic */ Context access$800(FavoriteAdapter r0) {
        return r0.mContext;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public FavoriteAdapter(Activity r3, List<FavoriteContact> r4, ContactPhotoManager r5) {
        this.mIsEdit = false;
        this.mCheckedMap = new HashMap();
        this.mIsFavoriteCancling = false;
        this.mIsDataChanged = false;
        this.swipeItem = null;
        this.closingSwipeItem = null;
        this.mSwipedItemId = -1;
        this.mFavoriteContacts = r4;
        this.mActivity = r3;
        Context r6 = r3.getBaseContext();
        this.mContext = r6;
        this.mPhotoManager = r5;
        this.mBlacklistManager = BlacklistManager.getInstances(r6);
    }

    public void setItemLongClickedListener(HorizontalScrollListView.ItemLongClickedListener r1) {
        this.mItemLongClickedListener = r1;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener r1) {
        this.mOnItemClickListener = r1;
    }

    public void setList(List<FavoriteContact> r1) {
        this.mFavoriteContacts = r1;
        notifyDataSetChanged();
    }

    public List<FavoriteContact> getList() {
        return this.mFavoriteContacts;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        hideSwipedViews();
        super.notifyDataSetChanged();
    }

    public void notifyDataSetChangedWithOutHideQC() {
        hideSwipedViews();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        hideSwipedViews();
        super.notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FavoriteContact> r0 = this.mFavoriteContacts;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public HashMap<Long, FavoriteContact> getRemoveCache() {
        return this.mCheckedMap;
    }

    @Override // android.widget.Adapter
    public FavoriteContact getItem(int r2) {
        List<FavoriteContact> r0 = this.mFavoriteContacts;
        if (r0 == null) goto L9;
        if (r2 < 0) goto L9;
        if (r2 >= r0.size()) goto L9;
        return this.mFavoriteContacts.get(r2);
    L9:
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        List<FavoriteContact> r0 = this.mFavoriteContacts;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.get(r1).id;
    }

    public void setIsEdit(boolean r2) {
        if (this.mIsEdit == r2) goto L6;
        this.mIsEdit = r2;
        notifyDataSetChanged();
        return;
    }

    public boolean getEditState() {
        return this.mIsEdit;
    }

    public void setFavoriteCancleState(boolean r1) {
        this.mIsFavoriteCancling = r1;
    }

    public boolean getFavoriteCancleState() {
        return this.mIsFavoriteCancling;
    }

    @Override // android.widget.Adapter
    public View getView(final int r18, View r19, ViewGroup r20) {
        if (r19 != null) goto L5;
        View r4 = new ContactsCommonListItem(this.mContext, null, 0);
    L6:
        final ContactsCommonListItem r5 = (ContactsCommonListItem) r4;
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r5.showCustomEnd(true);
        r5.showTailIcon(true);
        r5.showDivider(true);
        final FavoriteContact r7 = this.mFavoriteContacts.get(r18);
        if (r7.id == this.mSwipedItemId) goto L15;
        if (r5.isInSwipeAction() == false) goto L12;
        r5.swipeClose();
    L12:
        if (this.swipeItem != r5) goto L17;
        this.swipeItem = null;
    L17:
        this.mPhotoManager.removePhoto(r5.getAvatarPhoto());
        r5.setAvatarPhotoId(Long.valueOf(r7.photoId));
        this.mPhotoManager.loadPhoto(r5.getAvatarPhoto(), r7.photoId, false, false);
        if (this.mCheckedMap.containsKey(Long.valueOf(r7.id)) == false) goto L20;
        r5.setChecked(true);
    L22:
        if (this.mIsEdit == false) goto L24;
        r5.setSelectedMode(true, false);
        r5.showTailIcon(false);
    L28:
        r5.setTitleText(r7.name);
        r5.setSubtitleText(ContactsUtils.formatNumberForT9(r7.number));
        this.mBlacklistManager.loadBlacklist(r5.getBlacklistPhoto(), r7.number);
        r5.setOnClickListener(new AnonymousClass2(this, r5, r18, r7));
        r5.setEnableSwipe(!this.mIsEdit);
        ArrayList r14 = new ArrayList();
        r14.add(SwipeItemButtonType.SWIPE_MESSAGE);
        r14.add(SwipeItemButtonType.SWIPE_STAR);
        ContactsSwipeHelper r8 = new ContactsSwipeHelper();
        r8.setDataId(r7.id);
        r8.init(this.mActivity, r7.contactid, false, r7.LookKey, r14, null, new FavoriteAdapter$$ExternalSyntheticLambda1(this, r5));
        r5.addSwipeListener(new AnonymousClass3(this, r5, r7));
        r5.setEndContainerWidthWrap();
        r5.setTitleContainerWidthSpread();
        return r4;
    L24:
        r5.setSelectedMode(false, false);
        r5.setTailIcon(R.drawable.icon_item_arrow);
        ImageView r2 = r5.getTailIconView();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r3;
        int r9 = ContactsUtils.dipTopx(this.mContext, 4.0d);
        r6.setMarginEnd(r9);
        r6.rightMargin = r9;
        r2.setLayoutParams(r6);
    L27:
        r5.getTailIconView().setOnClickListener(new AnonymousClass1(this, r5, r18));
        goto L28
    L20:
        r5.setChecked(false);
        goto L22
    L15:
        if (r5.isInSwipeAction() == false) goto L17;
        this.swipeItem = r5;
        goto L17
    L5:
        r4 = r19;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$getView$1$com-android-contacts-list-FavoriteAdapter, reason: not valid java name */
    /* synthetic */ Unit m202lambda$getView$1$comandroidcontactslistFavoriteAdapter(ContactsCommonListItem r2, List r3, final Function1 r4) {
        r2.setSwipeItemButtonView(r3, new FavoriteAdapter$$ExternalSyntheticLambda0(this, r4));
        return null;
    }

    /* JADX INFO: renamed from: lambda$getView$0$com-android-contacts-list-FavoriteAdapter, reason: not valid java name */
    /* synthetic */ Unit m201lambda$getView$0$comandroidcontactslistFavoriteAdapter(Function1 r1, SwipeItemButtonType r2) {
        r1.invoke(r2);
        hideSwipedViews();
        return null;
    }

    private void hideSwipedViews() {
        ContactsCommonListItem r0 = this.swipeItem;
        if (r0 == null) goto L5;
        this.closingSwipeItem = r0;
        r0.swipeClose();
        this.closingSwipeItem.setEnableSwipe(false);
        this.swipeItem = null;
    L5:
        this.mSwipedItemId = -1;
    }

    public void closeSwipedViews() {
        hideSwipedViews();
    }

    public void unstar(final View r2, final FavoriteContact r3) {
        if (this.mHSListView == null) goto L7;
        if (r3 == null) goto L8;
        AnimatorListenerAdapter r0 = new AnonymousClass4(this, r2, r3);
        this.mHSListView.playDeleteItemAnimation(r0);
        return;
    L8:
        return;
    }

    public void goDetail(int r5) {
        FavoriteContact r6 = getItem(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        Uri r0 = ContactsContract.Contacts.getLookupUri(r6.contactid, r6.LookKey);
        ContactDetailCacheManager.getInstance().loadResultData(r0);
        Intent r1 = ContactsIntentUtils.launchContactDetailIntent(this.mContext, r0, true, "favorite_list");
        r1.putExtra(ContactsUtils.EXTRA_PHONE_NUMBERS, r6.number);
        this.mActivity.startActivity(r1);
        AnimationUtil.switchActivityAnimation(this.mActivity, 5);
    }

    public void goCall(int r5) {
        FavoriteContact r6 = getItem(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        Intent r0 = DSUtils.getSelectSimDialogIntentIfNeeded(this.mActivity, r6.name, r6.number, false, false);
        if (r0 == null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "goCall show select sim dialog");
        this.mActivity.startActivity(r0);
        return;
    L9:
        if (DSUtils.useDSFeature() == false) goto L11;
        Intent r7 = DSUtils.getCallIntent(this.mActivity, r6.number, -1);
    L12:
        this.mContext.startActivity(r7);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        return;
    L11:
        r7 = ContactsIntentUtils.newDialNumberIntent(r6.number);
        goto L12
    }

    public void remove(int r1) {
        List<FavoriteContact> r0 = this.mFavoriteContacts;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void move(int r3, int r4) {
        if (r3 == r4) goto L8;
        this.mIsDataChanged = true;
        FavoriteContact r0 = getItem(r3);
        if (this.mFavoriteContacts == null) goto L6;
        remove(r3);
        this.mFavoriteContacts.add(r4, r0);
    L6:
        notifyDataSetInvalidated();
        return;
    }

    public boolean isDataChanged() {
        return this.mIsDataChanged;
    }

    public void setDataChanged(boolean r1) {
        this.mIsDataChanged = r1;
    }

    public boolean isChecked(int r3) {
        long r0 = getItemId(r3);
        return this.mCheckedMap.containsKey(Long.valueOf(r0));
    }

    public boolean checkTo(int r7, boolean r8) {
        long r0 = getItemId(r7);
        if (r0 >= 0) goto L6;
        return false;
    L6:
        if (r8 == true) goto L8;
    L11:
        if (r8 == false) goto L13;
    L16:
        return false;
    L13:
        if (this.mCheckedMap.containsKey(Long.valueOf(r0)) == false) goto L16;
        this.mCheckedMap.remove(Long.valueOf(r0));
        return true;
    L8:
        if (this.mCheckedMap.containsKey(Long.valueOf(r0)) == true) goto L11;
        this.mCheckedMap.put(Long.valueOf(r0), this.mFavoriteContacts.get(r7));
        return true;
    }
}
