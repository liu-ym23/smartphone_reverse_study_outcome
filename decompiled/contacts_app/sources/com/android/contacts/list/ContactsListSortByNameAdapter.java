package com.android.contacts.list;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactHelper;
import com.android.contacts.util.AsyncImageLoader;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.common.utility.UIUtils;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obric.utils.views.commonitemview.ContactsSwipeHelper;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsListSortByNameAdapter extends ContactsListBaseAdapter {
    private static final int LISTVIEW_FOOTER_COUNT = 1;
    private ContactsCommonListItem closingSwipeItem;
    private ContactsCommonListItem.ContactsCommonListItemClickListener contactListViewClickListener;
    private boolean mHasQuickBar;
    private OIndexScrollbar mQuickBar;
    private ContactsCommonListItem swipeItem;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    static /* synthetic */ ContactsCommonListItem.ContactsCommonListItemClickListener access$000(ContactsListSortByNameAdapter r0) {
        return r0.contactListViewClickListener;
    }

    static /* synthetic */ void access$100(ContactsListSortByNameAdapter r0) {
        r0.hideSwipedViews();
    }

    static /* synthetic */ ContactsCommonListItem access$200(ContactsListSortByNameAdapter r0) {
        return r0.closingSwipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$202(ContactsListSortByNameAdapter r0, ContactsCommonListItem r1) {
        r0.closingSwipeItem = r1;
        return r1;
    }

    static /* synthetic */ ContactsCommonListItem access$300(ContactsListSortByNameAdapter r0) {
        return r0.swipeItem;
    }

    static /* synthetic */ ContactsCommonListItem access$302(ContactsListSortByNameAdapter r0, ContactsCommonListItem r1) {
        r0.swipeItem = r1;
        return r1;
    }

    static /* synthetic */ OIndexScrollbar access$400(ContactsListSortByNameAdapter r0) {
        return r0.mQuickBar;
    }

    public ContactsListSortByNameAdapter(Activity r1, ArrayList<SamContact> r2, ContactPhotoManager r3, AsyncImageLoader r4) {
        super(r1, r2, r3, r4);
        this.swipeItem = null;
        this.closingSwipeItem = null;
    }

    public void setClickContactListener(ContactsCommonListItem.ContactsCommonListItemClickListener r1) {
        this.contactListViewClickListener = r1;
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        hideSwipedViews();
        super.notifyDataSetChanged();
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        hideSwipedViews();
        super.notifyDataSetInvalidated();
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, com.android.contacts.PinnedHeaderList.HeadersAdapter
    public View getHeaderView(int r2, View r3, ViewGroup r4) {
        if (r3 != null) goto L4;
        r3 = LayoutInflater.from(this.mContext).inflate(R.layout.header, null);
    L4:
        SamContact r5 = this.mContacts.get(r2);
        TextView r6 = (TextView) r3.findViewById(R.id.text);
        r6.setText(r5.section);
        r6.setTextColor(this.mContext.getColor(R.color.oui_basic_text_3));
        r3.setTag(r5.section);
        return r3;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r7) {
        if (this.mContacts == null) goto L10;
        if (r7 != (this.mContacts.size() - 1)) goto L10;
        if (this.mContacts.get(r7).getType() != 2) goto L10;
        return false;
    L10:
        if (this.mIsEdit == false) goto L22;
        if (this.mContacts == null) goto L22;
        if (this.mContacts.isEmpty() == true) goto L22;
        if (r7 != 0) goto L22;
        if (this.mContacts.get(r7).getType() != 1) goto L19;
    L20:
        return false;
    L19:
        if (this.mContacts.get(r7).contactId == (-2)) goto L20;
    L22:
        return super.isEnabled(r7);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r2) {
        SamContact r1 = this.mContacts.get(r2);
        if (r1.getType() != 1) goto L6;
        return 1;
    L6:
        if (r1.getType() != 2) goto L9;
        return 2;
    L9:
        if (r1.getType() != 3) goto L11;
        return 3;
    L11:
        return 0;
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, android.widget.Adapter
    public View getView(int r13, View r14, ViewGroup r15) {
        SamContact r16 = this.mContacts.get(r13);
        if (r16.getType() != 1) goto L19;
        if (r14 != null) goto L6;
        r14 = new ContactsCommonListItem(this.mContext, null, 0);
    L6:
        final ContactsCommonListItem r0 = (ContactsCommonListItem) r14;
        r0.setShowAvatarContainer(true);
        r0.setTitleText(r16.name);
        r0.setAvatarPhotoId(Long.valueOf(r16.photoId));
        if (r16.photoId > 0) goto L9;
    L11:
        boolean r1 = false;
    L12:
        r0.setAvatarStrokeVisible(r1);
        if (r16.contactId != (-2)) goto L15;
        r0.getAvatarPhoto().setVisibility(8);
        r0.getBlacklistPhoto().setVisibility(0);
        r0.getBlacklistPhoto().setImageResource(R.drawable.mine_group);
    L16:
        r0.setEnabled(isEnabled(r13));
        r0.showDivider(true);
        r0.setOnClickListener(new AnonymousClass1(this, r0));
        r0.setEndContainerWidthWrap();
        r0.setTitleContainerWidthSpread();
        return r14;
    L15:
        r0.getAvatarPhoto().setVisibility(0);
        this.mBlacklistManager.loadBlacklist(r0.getBlacklistPhoto(), r16.contactId);
        this.mPhotoManager.loadPhoto(r0.getAvatarPhoto(), r16.photoId, false, false);
        goto L16
    L9:
        if (r16.contactId == (-2)) goto L11;
        r1 = true;
        goto L12
    L19:
        if (r16.getType() == 2) goto L21;
        if (r14 != null) goto L24;
        r14 = new ContactsCommonListItem(this.mContext, null, 0);
    L24:
        final ContactsCommonListItem r2 = (ContactsCommonListItem) r14;
        r2.setTitleText(r16.name);
        r2.setAvatarPhotoId(Long.valueOf(r16.photoId));
        this.mPhotoManager.loadPhoto(r2.getAvatarPhoto(), r16.photoId, false, false);
        if (this.mIsEdit == true) goto L27;
    L29:
        r2.setSelectedMode(false, false);
    L30:
        this.mBlacklistManager.loadBlacklist(r2.getBlacklistPhoto(), r16.contactId);
        r2.setEnabled(isEnabled(r13));
        r2.showDivider(true);
        r2.setOnClickListener(new AnonymousClass2(this, r2));
        r2.setShowAvatarContainer(true);
        r2.setEnableSwipe(!this.mIsEdit);
        ArrayList r7 = new ArrayList();
        r7.add(SwipeItemButtonType.SWIPE_PHONE);
        r7.add(SwipeItemButtonType.SWIPE_PHONE1);
        r7.add(SwipeItemButtonType.SWIPE_PHONE2);
        r7.add(SwipeItemButtonType.SWIPE_MESSAGE);
        r7.add(SwipeItemButtonType.SWIPE_STAR);
        new ContactsSwipeHelper().init(getActivity(), r16.contactId, false, r16.LookKey, r7, null, new ContactsListSortByNameAdapter$$ExternalSyntheticLambda0(this, r2));
        r2.addSwipeListener(new AnonymousClass3(this, r2));
        r2.setEndContainerWidthWrap();
        r2.setTitleContainerWidthSpread();
        return r14;
    L27:
        if (ContactsContract.isProfileId(r16.contactId) == true) goto L29;
        r2.setSelectedMode(true, false);
        r2.setChecked(isSelected(r13));
        goto L30
    L21:
        return newStatisticView(this.mContacts.get(r13), r14);
    }

    /* JADX INFO: renamed from: lambda$getView$1$com-android-contacts-list-ContactsListSortByNameAdapter, reason: not valid java name */
    /* synthetic */ Unit m200x3e2fb586(ContactsCommonListItem r2, List r3, final Function1 r4) {
        r2.setSwipeItemButtonView(r3, new ContactsListSortByNameAdapter$$ExternalSyntheticLambda1(this, r4));
        return null;
    }

    /* JADX INFO: renamed from: lambda$getView$0$com-android-contacts-list-ContactsListSortByNameAdapter, reason: not valid java name */
    /* synthetic */ Unit m199x189bac85(Function1 r1, SwipeItemButtonType r2) {
        r1.invoke(r2);
        hideSwipedViews();
        return null;
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

    private void bindBackgroundItemButtons(SamContact r25, ContactsListBaseAdapter.ViewHolder r26) {
        if (getQuickContactListener().getQuickContactCacheId() == r25.contactId) goto L5;
    L7:
        QuickContactHelper r3 = new QuickContactHelper(getActivity(), r26.item, this.mPhotoManager, getQuickContactListener(), r25.contactId, r25.LookKey, false);
    L8:
        r3.setHasAddedTime(r25.hasAddedTime);
        r3.setTrackerTag("ContactListFragment");
        r26.helper = r3;
        return;
    L5:
        if (getQuickContactListener().hasAddedTime() != r25.hasAddedTime) goto L7;
        r3 = new QuickContactHelper(getQuickContactListener().getQuickContactHelperCache(), getActivity(), r26.item, this.mPhotoManager, getQuickContactListener(), r25.contactId, r25.LookKey, false);
        goto L8
    }

    public void setQuickBar(OIndexScrollbar r1) {
        this.mQuickBar = r1;
    }

    public void setHasQuickBar(boolean r1) {
        this.mHasQuickBar = r1;
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollRestored(View r5) {
        super.onScrollRestored(r5);
        if ((getCount() - 1) <= 0) goto L5;
        SamContact r6 = getItem(getCount() - 1);
    L7:
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        OIndexScrollbar r2 = this.mQuickBar;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r7 < 30) goto L17;
        UIUtils.setViewVisibility(r2, 0);
        new PropertyAnimatable.Builder(this.mQuickBar).animator(1.0f, 90.0f).alphaTo(1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null).build().start(RunMode.PARALLEL, RepeatMode.NORMAL);
        return;
    L17:
        return;
    L9:
        r7 = r6.count;
        goto L10
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollStateChanged(View r3, int r4, int r5) {
        super.onScrollStateChanged(r3, r4, r5);
        if (r4 == 0) goto L5;
        return;
    L5:
        if ((getCount() - 1) <= 0) goto L7;
        SamContact r6 = getItem(getCount() - 1);
    L9:
        if (r6 != null) goto L11;
        int r7 = 0;
    L12:
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 != null) goto L15;
        return;
    L15:
        if (r7 < 30) goto L20;
        UIUtils.setViewVisibility(r0, 0);
        new PropertyAnimatable.Builder(this.mQuickBar).animator(1.0f, 90.0f).alphaTo(0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null).onEnd(new AnonymousClass4(this)).build().start(RunMode.PARALLEL, RepeatMode.NORMAL);
        return;
    L20:
        return;
    L11:
        r7 = r6.count;
        goto L12
    L7:
        r6 = null;
        goto L9
    }

    private View newStatisticView(SamContact r17, View r18) {
        if (r18 != null) goto L5;
        View r2 = LayoutInflater.from(this.mContext).inflate(R.layout.contacts_statistic_view, null);
    L6:
        TextView r3 = (TextView) r2.findViewById(R.id.count_view);
        TextView r4 = (TextView) r2.findViewById(R.id.statistics_view);
        r2.setBackgroundResource(R.color.obric_page_background);
        r3.setTextColor(this.mContext.getColor(R.color.oui_basic_text_3));
        r4.setTextColor(this.mContext.getColor(R.color.oui_basic_text_3));
        r3.setText(this.mContext.getResources().getQuantityString(R.plurals.statistics_count_para, r17.count, new Object[]{Integer.valueOf(r17.count)}));
        StringBuilder r5 = new StringBuilder();
        boolean r6 = "zh".equals(Locale.getDefault().getLanguage());
        if (r17.statisticMap == null) goto L26;
        Iterator<Map.Entry<String, Integer>> r7 = r17.statisticMap.entrySet().iterator();
        int r9 = 0;
        int r11 = 0;
    L10:
        if (r7.hasNext() == false) goto L25;
        Map.Entry<String, Integer> r12 = r7.next();
        String r13 = r12.getKey();
        int r14 = r12.getValue().intValue();
        if (r14 == 0) goto L10;
        r9 = r9 + r14;
        if (r6 == true) goto L17;
    L21:
        Iterator<Map.Entry<String, Integer>> r19 = r7;
        r5.append(String.format("%s %s", new Object[]{this.mContext.getString(R.string.statistics_account, new Object[]{r13}), this.mContext.getResources().getQuantityString(R.plurals.person, r14, new Object[]{Integer.valueOf(r14)})}));
        if (r11 == (r17.statisticMap.size() - 1)) goto L24;
        r5.append(this.mContext.getResources().getString(R.string.symbol_caesura));
    L24:
        r11 = r11 + 1;
        r7 = r19;
        goto L10
    L17:
        if (ContactsUtils.isChinese(r13) == true) goto L21;
        if (r11 != 0) goto L20;
        r13 = HanziToPinyin.Token.SEPARATOR + r13 + HanziToPinyin.Token.SEPARATOR;
        goto L21
    L20:
        r13 = r13 + HanziToPinyin.Token.SEPARATOR;
        goto L21
    L25:
        int r10 = r9 - r17.count;
    L28:
        if (r11 == 0) goto L38;
        if (r11 == 1) goto L38;
        if (r10 <= 0) goto L37;
        String r8 = this.mContext.getString(R.string.statistics_first_para, new Object[]{r5});
        String r1 = this.mContext.getResources().getQuantityString(R.plurals.statistics_second_para, r10, new Object[]{Integer.valueOf(r10)});
        if (r6 == false) goto L36;
        r4.setText(r8 + this.mContext.getString(R.string.symbol_comma) + r1);
    L41:
        return r2;
    L36:
        r4.setText(r8 + this.mContext.getString(R.string.symbol_comma) + HanziToPinyin.Token.SEPARATOR + r1);
        goto L41
    L37:
        r4.setText(this.mContext.getString(R.string.statistics_first_para, new Object[]{r5}));
    L38:
        if (r10 <= 0) goto L40;
        r4.setText(this.mContext.getResources().getQuantityString(R.plurals.statistics_second_para, r10, new Object[]{Integer.valueOf(r10)}));
        goto L41
    L40:
        r4.setVisibility(8);
        goto L41
    L26:
        r10 = 0;
        r11 = 0;
        goto L28
    L5:
        r2 = r18;
        goto L6
    }
}
