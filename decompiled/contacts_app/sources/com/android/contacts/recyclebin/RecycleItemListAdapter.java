package com.android.contacts.recyclebin;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.contacts.PinnedHeaderList.HeadersAdapter;
import com.android.contacts.R;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleItemListAdapter extends BaseAdapter implements HeadersAdapter {
    private ContactsCommonListItem closingSwipeItem;
    protected Context mContext;
    private boolean mIsEdit;
    private RecycleItemListener mListener;
    protected List<RecycleItem> mRecycleItems;
    private ContactsCommonListItem swipeItem;

    /* JADX INFO: renamed from: com.android.contacts.recyclebin.RecycleItemListAdapter$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType = null;

        static {
            int[] r0 = new int[SwipeItemButtonType.values().length];
            $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType = r0;
            r0[SwipeItemButtonType.SWIPE_RESTORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType[SwipeItemButtonType.SWIPE_DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static /* synthetic */ void access$000(RecycleItemListAdapter r0) {
        r0.hideSwipedViews();
    }

    static /* synthetic */ boolean access$100(RecycleItemListAdapter r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ RecycleItemListener access$200(RecycleItemListAdapter r0) {
        return r0.mListener;
    }

    static /* synthetic */ ContactsCommonListItem access$300(RecycleItemListAdapter r0) {
        return r0.closingSwipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$302(RecycleItemListAdapter r0, ContactsCommonListItem r1) {
        r0.closingSwipeItem = r1;
        return r1;
    }

    static /* synthetic */ ContactsCommonListItem access$400(RecycleItemListAdapter r0) {
        return r0.swipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$402(RecycleItemListAdapter r0, ContactsCommonListItem r1) {
        r0.swipeItem = r1;
        return r1;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public RecycleItemListAdapter(Activity r2, List<RecycleItem> r3) {
        this.mIsEdit = false;
        this.swipeItem = null;
        this.closingSwipeItem = null;
        this.mRecycleItems = r3;
        this.mContext = r2.getBaseContext();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<RecycleItem> r0 = this.mRecycleItems;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // android.widget.Adapter
    public RecycleItem getItem(int r2) {
        List<RecycleItem> r0 = this.mRecycleItems;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() != 0) goto L7;
        return null;
    L7:
        if (r2 < this.mRecycleItems.size()) goto L10;
        return null;
    L10:
        return this.mRecycleItems.get(r2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        List<RecycleItem> r0 = this.mRecycleItems;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.get(r1).rawContactId;
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersAdapter
    public View getHeaderView(int r3, View r4, ViewGroup r5) {
        if (r4 != null) goto L4;
        r4 = LayoutInflater.from(this.mContext).inflate(R.layout.recycle_list_header, null);
    L4:
        RecycleItem r6 = this.mRecycleItems.get(r3);
        OSectionTitleBar r7 = (OSectionTitleBar) r4.findViewById(R.id.recycle_title);
        r7.setTitleTextColor(this.mContext.getResources().getColor(R.color.oui_basic_text_3));
        r7.setTitleText(r6.getSectionHeader(this.mContext));
        return r4;
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersAdapter
    public long getHeaderId(int r4) {
        List<RecycleItem> r0 = this.mRecycleItems;
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r4 >= 0) goto L7;
    L11:
        return -1;
    L7:
        if (r4 > r0.size()) goto L11;
        return this.mRecycleItems.get(r4).section;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        hideSwipedViews();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        hideSwipedViews();
        super.notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public View getView(final int r7, View r8, ViewGroup r9) {
        if (r8 != null) goto L5;
    L6:
        r8 = new RecycleListItemView(this.mContext, null);
    L7:
        final RecycleListItemView r0 = (RecycleListItemView) r8;
        final RecycleItem r1 = this.mRecycleItems.get(r7);
        r0.getName().setText(r1.displayName);
        String r2 = r1.getPrimaryData();
        if (TextUtils.isEmpty(r2) == false) goto L10;
        r2 = this.mContext.getString(R.string.joined_contact_phone_and_email_empty);
    L10:
        r0.getPrimaryData().setText(r2);
        r0.getRecycleDate().setText(r1.recycleFormattedDate);
        r0.getCallingApplicationLabel().setText(r1.getCallingInfoDescription(this.mContext));
        AvatarImageView r3 = r0.getPhoto();
        if (r3 != null) goto L13;
    L20:
        r0.setSelectedMode(this.mIsEdit);
        if (this.mIsEdit == false) goto L23;
        r0.setChecked(isSelected(r7));
    L23:
        r0.setOnClickListener(new AnonymousClass1(this, r0, r7, r1));
        r0.setEnableSwipe(!this.mIsEdit);
        ArrayList r10 = new ArrayList();
        r10.add(SwipeItemButtonType.SWIPE_RESTORE);
        r10.add(SwipeItemButtonType.SWIPE_DELETE);
        r0.setSwipeItemButtonView(r10, new AnonymousClass2(this, r0, r1));
        r0.addSwipeListener(new AnonymousClass3(this, r0));
        return r8;
    L13:
        if (r1.photoBytes == null) goto L15;
        boolean r4 = true;
    L16:
        r3.setStrokeEnabled(r4);
        if (r1.photoBytes == null) goto L19;
        r3.setAvatarBitmap(BitmapFactory.decodeByteArray(r1.photoBytes, 0, r1.photoBytes.length));
        goto L20
    L19:
        r3.setAvatarBitmap(null);
        goto L20
    L15:
        r4 = false;
        goto L16
    L5:
        if (r8.getTag() != null) goto L7;
        goto L6
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

    public void setList(List<RecycleItem> r1) {
        this.mRecycleItems = r1;
        notifyDataSetChanged();
    }

    public List<RecycleItem> getList() {
        return this.mRecycleItems;
    }

    public void setEdit(boolean r1) {
        this.mIsEdit = r1;
    }

    public boolean isEditMode() {
        return this.mIsEdit;
    }

    public void setRecycleItemListener(RecycleItemListener r1) {
        this.mListener = r1;
    }

    protected boolean isSelected(int r2) {
        return this.mListener.isSelected(getItem(r2));
    }
}
