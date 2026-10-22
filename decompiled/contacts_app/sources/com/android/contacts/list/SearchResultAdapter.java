package com.android.contacts.list;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.PhoneNumberUtils;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout;
import com.android.contacts.bytedanceosquickcontact.QuickContactHelper;
import com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener;
import com.android.contacts.bytedanceosquickcontact.QuickContactListener;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.widget.AvatarImageView;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obric.utils.views.commonitemview.ContactsSwipeHelper;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public class SearchResultAdapter extends BaseAdapter implements QuickContactListAdapterListener {
    private ContactsCommonListItem closingSwipeItem;
    private ContactsCommonListItem.ContactsCommonListItemClickListener contactListViewClickListener;
    private Activity mActivity;
    private BlacklistManager mBlacklistManager;
    private ArrayList<SamContact> mContacts;
    private Context mContext;
    private Stack<View> mItemsViewCache;
    private Handler mItemsViewPreloadHandler;
    private int mMode;
    private ContactPhotoManager mPhotoManager;
    private QuickContactListener mQuickContactListener;
    private String mSearchKey;
    private Map<Long, List<String>> mSearchKeyMap;
    private Map<Long, Boolean> mUpdateNumber;
    private ContactsCommonListItem swipeItem;

    private class ViewHolder {
        public View bgItem;
        public ImageView blacklistView;
        public QuickContactHelper helper;
        public QuickContactChildLayout item;
        public TextView nameView;
        public TextView numberView;
        public AvatarImageView photoView;
        final /* synthetic */ SearchResultAdapter this$0;

        private ViewHolder(SearchResultAdapter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ViewHolder(SearchResultAdapter r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    static /* synthetic */ Stack access$000(SearchResultAdapter r0) {
        return r0.mItemsViewCache;
    }

    static /* synthetic */ ContactsCommonListItem.ContactsCommonListItemClickListener access$200(SearchResultAdapter r0) {
        return r0.contactListViewClickListener;
    }

    static /* synthetic */ void access$300(SearchResultAdapter r0) {
        r0.hideSwipedViews();
    }

    static /* synthetic */ ContactsCommonListItem access$400(SearchResultAdapter r0) {
        return r0.closingSwipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$402(SearchResultAdapter r0, ContactsCommonListItem r1) {
        r0.closingSwipeItem = r1;
        return r1;
    }

    static /* synthetic */ ContactsCommonListItem access$500(SearchResultAdapter r0) {
        return r0.swipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$502(SearchResultAdapter r0, ContactsCommonListItem r1) {
        r0.swipeItem = r1;
        return r1;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public SearchResultAdapter(Activity r3, ArrayList<SamContact> r4, String r5, Map<Long, List<String>> r6) {
        this.mItemsViewCache = new Stack();
        this.mContacts = null;
        this.mMode = -1;
        this.mUpdateNumber = new HashMap();
        this.swipeItem = null;
        this.closingSwipeItem = null;
        this.mContext = r3;
        this.mActivity = r3;
        this.mContacts = r4;
        this.mPhotoManager = ContactPhotoManager.getInstance(r3);
        this.mBlacklistManager = BlacklistManager.getInstances(this.mContext);
        this.mSearchKey = r5;
        this.mSearchKeyMap = r6;
        initViewCache(this.mContext);
    }

    public void destory() {
        Handler r0 = this.mItemsViewPreloadHandler;
        if (r0 == null) goto L6;
        r0.getLooper().quit();
        return;
    }

    public void setContactListViewClickListener(ContactsCommonListItem.ContactsCommonListItemClickListener r1) {
        this.contactListViewClickListener = r1;
    }

    private void initViewCache(final Context r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        HandlerThread r0 = new HandlerThread("search item view preload");
        r0.start();
        LayoutInflater.from(r5);
        final Looper r1 = r0.getLooper();
        Handler r2 = new AnonymousClass1(this, r1, r5);
        this.mItemsViewPreloadHandler = r2;
        r2.sendEmptyMessageDelayed(0, MonitorConstants.STOP_MORE_CHANNEL_INTERVAL);
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
        hideSwipedViews();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        hideSwipedViews();
        super.notifyDataSetInvalidated();
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

    public void closeSwipedViews() {
        hideSwipedViews();
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
        SamContact r0 = getItem(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.contactId;
    }

    @Override // android.widget.Adapter
    public View getView(int r18, View r19, ViewGroup r20) {
        String r1 = this.mSearchKey;
        Map<Long, List<String>> r2 = this.mSearchKeyMap;
        if (r19 != null) goto L9;
        AnonymousClass1 r5 = null;
        if (this.mItemsViewCache.isEmpty() == false) goto L7;
        View r4 = new ContactsCommonListItem(this.mContext, null, 0);
    L8:
        ViewHolder r6 = new ViewHolder(this, r5);
        r6.item = (QuickContactChildLayout) r4.findViewById(R.id.item);
        r6.nameView = (TextView) r4.findViewById(R.id.name);
        r6.numberView = (TextView) r4.findViewById(R.id.number);
        r6.photoView = (AvatarImageView) r4.findViewById(R.id.photo);
        r6.bgItem = r4.findViewById(R.id.item_background);
        r6.blacklistView = (ImageView) r4.findViewById(R.id.blacklist_photo);
        r4.setTag(r6);
    L10:
        final ContactsCommonListItem r7 = (ContactsCommonListItem) r4;
        r7.setShowAvatarContainer(true);
        final SamContact r8 = this.mContacts.get(r18);
        this.mUpdateNumber.put(Long.valueOf(r8.contactId), false);
        if (r2 != null) goto L13;
    L17:
        updateSearchViewByKey(r1, r8, r7);
    L18:
        r7.setAvatarPhotoId(Long.valueOf(r8.photoId));
        this.mPhotoManager.loadPhoto(r7.getAvatarPhoto(), r8.photoId, false, false);
        this.mBlacklistManager.loadBlacklist(r7.getBlacklistPhoto(), r8.contactId);
        r7.showDivider(true);
        r7.setOnClickListener(new AnonymousClass2(this, r8));
        r7.setEnableSwipe(true);
        ArrayList r14 = new ArrayList();
        r14.add(SwipeItemButtonType.SWIPE_PHONE);
        r14.add(SwipeItemButtonType.SWIPE_PHONE1);
        r14.add(SwipeItemButtonType.SWIPE_PHONE2);
        r14.add(SwipeItemButtonType.SWIPE_MESSAGE);
        r14.add(SwipeItemButtonType.SWIPE_STAR);
        ContactsSwipeHelper r9 = new ContactsSwipeHelper();
        if (r8.getType() != 1) goto L21;
        boolean r12 = true;
    L22:
        r9.init(getActivity(), r8.contactId, r12, r8.LookKey, r14, null, new SearchResultAdapter$$ExternalSyntheticLambda0(this, r7));
        r7.addSwipeListener(new AnonymousClass3(this, r7));
        r7.setEndContainerWidthWrap();
        r7.setTitleContainerWidthSpread();
        return r4;
    L21:
        r12 = false;
        goto L22
    L13:
        if (r2.size() <= 0) goto L17;
        if (r2.containsKey(Long.valueOf(r8.contactId)) == false) goto L17;
        updateSearchViewByKeyMap(r2, r8, r7, r1);
        goto L18
    L7:
        r4 = this.mItemsViewCache.pop();
        this.mItemsViewPreloadHandler.removeMessages(0);
        this.mItemsViewPreloadHandler.sendEmptyMessage(0);
        goto L8
    L9:
        r4 = r19;
        goto L10
    }

    /* JADX INFO: renamed from: lambda$getView$1$com-android-contacts-list-SearchResultAdapter, reason: not valid java name */
    /* synthetic */ Unit m219lambda$getView$1$comandroidcontactslistSearchResultAdapter(ContactsCommonListItem r2, List r3, final Function1 r4) {
        r2.setSwipeItemButtonView(r3, new SearchResultAdapter$$ExternalSyntheticLambda1(this, r4));
        hideSwipedViews();
        return null;
    }

    /* JADX INFO: renamed from: lambda$getView$0$com-android-contacts-list-SearchResultAdapter, reason: not valid java name */
    /* synthetic */ Unit m218lambda$getView$0$comandroidcontactslistSearchResultAdapter(Function1 r1, SwipeItemButtonType r2) {
        r1.invoke(r2);
        hideSwipedViews();
        return null;
    }

    private void updateSearchViewByKeyMap(Map<Long, List<String>> r3, SamContact r4, ContactsCommonListItem r5, String r6) {
        List<String> r7 = r3.get(Long.valueOf(r4.contactId));
        if (r7 == null) goto L5;
        int r8 = 0;
    L10:
        if (r8 >= r7.size()) goto L12;
        updateSearchViewByKey(r7.get(r8), r4, r5);
        r8 = r8 + 1;
        goto L10
    L12:
        return;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L14;
        updateSearchViewByKey(r6, r4, r5);
        return;
    }

    private void updateSearchViewByKey(String r18, SamContact r19, ContactsCommonListItem r20) {
        if (TextUtils.isEmpty(r19.name) == false) goto L5;
        r20.setTitleText(this.mContext.getResources().getString(R.string.missing_name));
    L14:
        if (TextUtils.isEmpty(r19.number) == false) goto L16;
        r20.showSubtitleContainer(false);
        return;
    L16:
        TextView r4 = r20.getDefaultSubtitleText();
        r20.showSubtitleContainer(true);
        if (r18 == null) goto L19;
        String r1 = r18.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "").replace(SimContactsConstants.EMAIL_SEP, "");
        int r9 = PhoneNumberUtils.normalizeNumber(r19.number).indexOf(r1);
    L20:
        if (r9 == (-1)) goto L64;
        r20.showSubtitleContainer(true);
        String r3 = ContactsUtils.formatNumberForT9(r19.number);
        if (r3 == null) goto L25;
        if (r4 == null) goto L25;
        r4.setText(r3, TextView.BufferType.SPANNABLE);
    L25:
        Spannable r8 = (Spannable) r4.getText();
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L26:
        int r13 = r9 + r11;
        if (r10 > r13) goto L41;
        if (r3 == null) goto L40;
        if (r3.length() <= r10) goto L40;
        if (r3.charAt(r10) != ' ') goto L34;
    L37:
        r12 = r12 + 1;
        if (r13 >= r3.length()) goto L40;
        r11 = r11 + 1;
        goto L40
    L34:
        if (r3.charAt(r10) == '-') goto L37;
        if (r3.charAt(r10) == ',') goto L37;
    L40:
        r10 = r10 + 1;
        goto L26
    L41:
        int r16 = 0;
    L42:
        int r7 = r9 + r11;
        if (r13 >= (r1.length() + r7)) goto L56;
        if (r3.length() <= r13) goto L55;
        if (r3.charAt(r13) != ' ') goto L49;
    L52:
        r16 = r16 + 1;
        if ((r7 + r1.length()) >= r3.length()) goto L55;
        r11 = r11 + 1;
        goto L55
    L49:
        if (r3.charAt(r13) == '-') goto L52;
        if (r3.charAt(r13) == ',') goto L52;
    L55:
        r13 = r13 + 1;
        goto L42
    L56:
        int r6 = ((r1.length() + r9) + r16) + r12;
        if (r6 <= r3.length()) goto L60;
        r6 = r3.length();
    L60:
        if (((r1.length() + r9) + r16) > r3.length()) goto L62;
        r8.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.oui_red_7)), r9 + r12, r6, 18);
    L62:
        r4.setText(r8);
        this.mUpdateNumber.put(Long.valueOf(r19.contactId), true);
        return;
    L64:
        if (Boolean.FALSE.equals(this.mUpdateNumber.get(Long.valueOf(r19.contactId))) == false) goto L80;
        r20.showSubtitleContainer(false);
        return;
    L80:
        return;
    L19:
        r1 = null;
        r9 = -1;
        goto L20
    L5:
        SpannableStringBuilder r5 = new SpannableStringBuilder(r19.name);
        if (TextUtils.isEmpty(r18) == false) goto L8;
    L10:
        TextView r14 = r20.getDefaultTitleText();
        if (r14 == null) goto L14;
        r14.setText(r5);
        goto L14
    L8:
        if (r19.name.contains(r18) == false) goto L10;
        r5.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.oui_blue_6)), r19.name.indexOf(r18), r19.name.indexOf(r18) + r18.length(), 18);
        goto L10
    }

    public void setList(ArrayList<SamContact> r1, String r2) {
        this.mContacts = r1;
        this.mSearchKey = r2;
        this.mSearchKeyMap = null;
        notifyDataSetChanged();
    }

    public void setListMap(ArrayList<SamContact> r1, Map<Long, List<String>> r2, String r3) {
        this.mContacts = r1;
        this.mSearchKey = r3;
        this.mSearchKeyMap = r2;
        notifyDataSetChanged();
    }
}
