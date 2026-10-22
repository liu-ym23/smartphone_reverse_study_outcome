package com.android.contacts.recyclebin;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.telephony.PhoneNumberUtils;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PinnedHeaderList.WrapperView;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.widget.AvatarImageView;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleBinSearchResultAdapter extends BaseAdapter implements HorizontalScrollListView.ScrollStateListener {
    private ContactsCommonListItem closingSwipeItem;
    private Activity mActivity;
    private ArrayList<RecycleItem> mContacts;
    private Context mContext;
    private LayoutInflater mInflater;
    private RecycleItemListener mListener;
    private String mSearchKey;
    private ContactsCommonListItem swipeItem;

    /* JADX INFO: renamed from: com.android.contacts.recyclebin.RecycleBinSearchResultAdapter$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
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

    public class ViewHolder {
        public RelativeLayout avatarFrame;
        public TextView callingApplicationLabel;
        public QuickContactChildLayout item;
        public TextView name;
        public AvatarImageView photo;
        public TextView primaryData;
        public TextView recycleDate;
        public RecycleItem recycleItem;
        final /* synthetic */ RecycleBinSearchResultAdapter this$0;

        public ViewHolder(RecycleBinSearchResultAdapter r1) {
            this.this$0 = r1;
        }
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollCompleted(View r1) {
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollRestored(View r1) {
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrolling(int r1, View r2) {
    }

    static /* synthetic */ RecycleItemListener access$000(RecycleBinSearchResultAdapter r0) {
        return r0.mListener;
    }

    static /* synthetic */ void access$100(RecycleBinSearchResultAdapter r0) {
        r0.hideSwipedViews();
    }

    static /* synthetic */ ContactsCommonListItem access$200(RecycleBinSearchResultAdapter r0) {
        return r0.closingSwipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$202(RecycleBinSearchResultAdapter r0, ContactsCommonListItem r1) {
        r0.closingSwipeItem = r1;
        return r1;
    }

    static /* synthetic */ ContactsCommonListItem access$300(RecycleBinSearchResultAdapter r0) {
        return r0.swipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$302(RecycleBinSearchResultAdapter r0, ContactsCommonListItem r1) {
        r0.swipeItem = r1;
        return r1;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public RecycleBinSearchResultAdapter(Activity r2, ArrayList<RecycleItem> r3, String r4) {
        this.mContacts = null;
        this.swipeItem = null;
        this.closingSwipeItem = null;
        this.mContext = r2;
        this.mActivity = r2;
        this.mInflater = LayoutInflater.from(r2);
        this.mContacts = r3;
        this.mSearchKey = r4;
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollStateChanged(View r1, int r2, int r3) {
        if (r2 == 0) goto L4;
        return;
    L4:
        if ((r1 instanceof WrapperView) == false) goto L6;
        r1 = ((ViewGroup) r1).getChildAt(0);
    L6:
        if (r1 == null) goto L12;
        Object r4 = r1.getTag();
        if ((r4 instanceof ViewHolder) == false) goto L13;
        beforeHorizontalScrollOpen((ViewHolder) r4);
        return;
    L13:
        return;
    }

    private void beforeHorizontalScrollOpen(ViewHolder r2) {
        if (r2.item.isAnimationing() == true) goto L6;
        bindBackgroundItemButtons((View) r2.item.getParent().getParent(), r2.recycleItem);
        return;
    }

    private View bindBackgroundItemButtons(final View r4, final RecycleItem r5) {
        View r0 = r4.findViewById(R.id.item_background);
        if (r0 != null) goto L5;
        r0 = ((ViewStub) r4.findViewById(R.id.item_background_stub)).inflate();
    L5:
        r0.findViewById(R.id.umb_restore).setOnClickListener(new AnonymousClass1(this, r4, r5));
        r0.findViewById(R.id.umb_clear).setOnClickListener(new AnonymousClass2(this, r4, r5));
        return r0;
    }

    public void setRecycleItemListener(RecycleItemListener r1) {
        this.mListener = r1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<RecycleItem> r0 = this.mContacts;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // android.widget.Adapter
    public RecycleItem getItem(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 <= (getCount() - 1)) goto L7;
        return null;
    L7:
        return this.mContacts.get(r2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        RecycleItem r0 = getItem(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.rawContactId;
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
    public View getView(final int r18, View r19, ViewGroup r20) {
        if (r19 != null) goto L5;
    L8:
        View r3 = new RecycleListItemView(this.mContext, null);
    L9:
        final RecycleListItemView r4 = (RecycleListItemView) r3;
        final RecycleItem r5 = this.mContacts.get(r18);
        r4.getName().setText(r5.displayName);
        String r6 = r5.getPrimaryData();
        if (TextUtils.isEmpty(r6) == false) goto L12;
        r6 = this.mContext.getString(R.string.joined_contact_phone_and_email_empty);
    L12:
        r4.getPrimaryData().setText(r6);
        r4.getRecycleDate().setText(r5.recycleFormattedDate);
        r4.getCallingApplicationLabel().setText(r5.getCallingInfoDescription(this.mContext));
        AvatarImageView r7 = r4.getPhoto();
        if (r7 == null) goto L23;
        if (r5.photoBytes == null) goto L17;
        boolean r11 = true;
    L18:
        r7.setStrokeEnabled(r11);
        if (r5.photoBytes == null) goto L21;
        r7.setAvatarBitmap(BitmapFactory.decodeByteArray(r5.photoBytes, 0, r5.photoBytes.length));
        goto L23
    L21:
        r7.setAvatarBitmap(null);
        goto L23
    L17:
        r11 = false;
    L23:
        if (TextUtils.isEmpty(r5.displayName) == false) goto L25;
        r4.getName().setText(this.mContext.getResources().getString(R.string.missing_name));
    L32:
        if (TextUtils.isEmpty(r6) == false) goto L34;
        r4.getPrimaryData().setText(this.mContext.getString(R.string.joined_contact_phone_and_email_empty));
    L88:
        r4.setOnClickListener(new AnonymousClass3(this, r4, r18, r5));
        r4.setEnableSwipe(true);
        ArrayList r1 = new ArrayList();
        r1.add(SwipeItemButtonType.SWIPE_RESTORE);
        r1.add(SwipeItemButtonType.SWIPE_DELETE);
        r4.setSwipeItemButtonView(r1, new AnonymousClass4(this, r4, r5));
        r4.addSwipeListener(new AnonymousClass5(this, r4));
        return r3;
    L34:
        r4.getPrimaryData().setText(r6);
        if ("vnd.android.cursor.item/phone_v2".equals(r5.getPrimaryDataMimeType()) == false) goto L81;
        if (TextUtils.isEmpty(this.mSearchKey) == true) goto L81;
        String r2 = this.mSearchKey.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "").replace(SimContactsConstants.EMAIL_SEP, "");
        int r8 = PhoneNumberUtils.normalizeNumber(r6).indexOf(r2);
        if (r8 == (-1)) goto L88;
        String r9 = ContactsUtils.formatNumberForT9(r6);
        r4.getPrimaryData().setText(r9, TextView.BufferType.SPANNABLE);
        Spannable r12 = (Spannable) r4.getPrimaryData().getText();
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L41:
        int r10 = r8 + r14;
        char r16 = ' ';
        if (r13 > r10) goto L55;
        if (r9.length() <= r13) goto L54;
        if (r9.charAt(r13) != ' ') goto L48;
    L51:
        r15 = r15 + 1;
        if (r10 >= r9.length()) goto L54;
        r14 = r14 + 1;
        goto L54
    L48:
        if (r9.charAt(r13) == '-') goto L51;
        if (r9.charAt(r13) == ',') goto L51;
    L54:
        r13 = r13 + 1;
        goto L41
    L55:
        int r17 = 0;
    L56:
        int r110 = r8 + r14;
        if (r10 >= (r110 + r2.length())) goto L73;
        if (r9.length() <= r10) goto L72;
        if (r9.charAt(r10) == r16) goto L68;
        if (r9.charAt(r10) == '-') goto L68;
        if (r9.charAt(r10) != ',') goto L72;
    L68:
        r17 = r17 + 1;
        if ((r110 + r2.length()) >= r9.length()) goto L72;
        r14 = r14 + 1;
    L72:
        r10 = r10 + 1;
        r16 = ' ';
        goto L56
    L73:
        int r21 = ((r2.length() + r8) + r17) + r15;
        if (r21 <= r9.length()) goto L77;
        r21 = r9.length();
    L77:
        if (((r2.length() + r8) + r17) > r9.length()) goto L79;
        r12.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.high_light_red)), r8 + r15, r21, 18);
    L79:
        r4.getPrimaryData().setText(r12);
    L81:
        if ("vnd.android.cursor.item/email_v2".equals(r5.getPrimaryDataMimeType()) == false) goto L88;
        SpannableStringBuilder r22 = new SpannableStringBuilder(r6);
        if (TextUtils.isEmpty(this.mSearchKey) == false) goto L85;
    L87:
        r4.getPrimaryData().setText(r22);
        goto L88
    L85:
        if (r6.contains(this.mSearchKey) == false) goto L87;
        r22.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.high_light_red)), r6.indexOf(this.mSearchKey), r6.indexOf(this.mSearchKey) + this.mSearchKey.length(), 18);
        goto L87
    L25:
        SpannableStringBuilder r23 = new SpannableStringBuilder(r5.displayName);
        if (TextUtils.isEmpty(this.mSearchKey) == false) goto L28;
    L30:
        r4.getName().setText(r23);
        goto L32
    L28:
        if (r5.displayName.contains(this.mSearchKey) == false) goto L30;
        r23.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.high_light_red)), r5.displayName.indexOf(this.mSearchKey), r5.displayName.indexOf(this.mSearchKey) + this.mSearchKey.length(), 18);
        goto L30
    L5:
        if (r19.getTag() == null) goto L8;
        r3 = r19;
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

    public void setList(ArrayList<RecycleItem> r1, String r2) {
        this.mContacts = r1;
        this.mSearchKey = r2;
        notifyDataSetChanged();
    }

    public List<RecycleItem> getList() {
        return this.mContacts;
    }
}
