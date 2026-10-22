package com.android.contacts.list;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PinnedHeaderList.HeadersAdapter;
import com.android.contacts.PinnedHeaderList.HeadersListView;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.forcetouch.ForceTouchController;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.status.OPageStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewContactListFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/android/contacts/list/NewContactListFragment$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewContactListFragment$mHandler$1 extends Handler {
    final /* synthetic */ NewContactListFragment this$0;

    /* JADX INFO: renamed from: $r8$lambda$M-iMwxz0FE45gye3bVGBwn3yeGk, reason: not valid java name */
    public static /* synthetic */ void m211$r8$lambda$MiMwxz0FE45gye3bVGBwn3yeGk(View r0) {
        handleMessage$lambda$3$lambda$2(r0);
    }

    private static final void handleMessage$lambda$3$lambda$2(View r0) {
    }

    NewContactListFragment$mHandler$1(NewContactListFragment r1, Looper r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public void handleMessage(Message r15) {
        Intrinsics.checkNotNullParameter(r15, NotificationCompat.CATEGORY_MESSAGE);
        if (this.this$0.isAdded() == true) goto L5;
        return;
    L5:
        if (this.this$0.isDetached() == true) goto L368;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NewContactListFragment", "handleMessage: " + r15.what);
        int r0 = r15.what;
        SamContact r4 = null;
        ListAdapter r5 = null;
        HeadersAdapter r6 = null;
        int r7 = 8;
        boolean r8 = true;
        if (r0 == 1001) goto L139;
        if (r0 == R.id.msg_loadedphotos) goto L135;
        switch(r0) {
            case 1003: goto L92;
            case 1004: goto L31;
            case 1005: goto L30;
            case 1006: goto L22;
            case 1007: goto L20;
            case 1008: goto L14;
            default: goto L369;
        };
    L20:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NewContactListFragment", "receive CHECK_CUR_LOCATION_REFRESHED");
        return;
    L30:
        NewContactListFragment.access$refreshVisibleListItems(this.this$0);
        return;
    L31:
        NewContactListFragment.access$updateListViewConfig(this.this$0, true, -1);
        Object r16 = r15.obj;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.android.contacts.list.NewContactListFragment.SearchResultPayload");
        NewContactListFragment.SearchResultPayload r17 = (NewContactListFragment.SearchResultPayload) r16;
        Map<Long, List<String>> r1 = r17.getSearchKeyMap();
        if (r1 == null) goto L34;
        NewContactListFragment.access$setMSearchKeyList$p(this.this$0, r1);
    L34:
        ArrayList<SamContact> r18 = NewContactListFragment.access$getSearchMergeList(this.this$0, r17.getContactsMap());
        QuickContactListView r2 = NewContactListFragment.access$getMSearchResultList$p(this.this$0);
        if (r2 == null) goto L37;
        r2.restoreScrollState(false);
    L37:
        QuickContactListView r3 = NewContactListFragment.access$getMSearchResultList$p(this.this$0);
        if (r3 == null) goto L41;
        r5 = r3.getAdapter();
    L41:
        if ((r5 instanceof SearchResultAdapter) == true) goto L45;
        QuickContactListView r9 = NewContactListFragment.access$getMSearchResultList$p(this.this$0);
        if (r9 == null) goto L45;
        r9.setAdapter(NewContactListFragment.access$getMSearchResultAdapter$p(this.this$0));
    L45:
        boolean r10 = Intrinsics.areEqual(NewContactListFragment.access$getMSearchKey$p(this.this$0), NewContactListFragment.access$getMLastRenderedSearchKey$p(this.this$0));
        QuickContactListView r11 = NewContactListFragment.access$getMSearchResultList$p(this.this$0);
        if (r11 == null) goto L48;
        int r12 = r11.getFirstVisiblePosition();
    L49:
        QuickContactListView r13 = NewContactListFragment.access$getMSearchResultList$p(this.this$0);
        if (r13 == null) goto L54;
        View r14 = r13.getChildAt(0);
        if (r14 == null) goto L54;
        int r19 = r14.getTop();
    L56:
        if (NewContactListFragment.access$getMSearchKeyList$p(this.this$0).isEmpty() == false) goto L60;
        SearchResultAdapter r20 = NewContactListFragment.access$getMSearchResultAdapter$p(this.this$0);
        if (r20 == null) goto L63;
        r20.setList(r18, NewContactListFragment.access$getMSearchKey$p(this.this$0));
    L63:
        if (r10 == false) goto L68;
        if (r12 <= 0) goto L68;
        QuickContactListView r21 = NewContactListFragment.access$getMSearchResultList$p(this.this$0);
        if (r21 == null) goto L68;
        r21.setSelectionFromTop(r12, r19);
    L68:
        NewContactListFragment r22 = this.this$0;
        NewContactListFragment.access$setMLastRenderedSearchKey$p(r22, NewContactListFragment.access$getMSearchKey$p(r22));
        QuickContactListView r23 = NewContactListFragment.access$getMSearchResultList$p(this.this$0);
        if (r23 != null) goto L71;
    L73:
        r8 = false;
    L74:
        if (r8 == false) goto L79;
        QuickContactListView r24 = NewContactListFragment.access$getMSearchResultList$p(this.this$0);
        if (r24 == null) goto L79;
        r24.setVisibility(0);
    L79:
        if (r18.isEmpty() == false) goto L87;
        OPageStatus r110 = NewContactListFragment.access$getMContactsListEmptyView$p(this.this$0);
        if (r110 == null) goto L87;
        NewContactListFragment r25 = this.this$0;
        r110.setTitle(r25.getString(R.string.no_search_result));
        r110.setMessage("");
        r110.setOnClickListener(new NewContactListFragment$mHandler$1$$ExternalSyntheticLambda0());
        QuickContactListView r26 = NewContactListFragment.access$getMSearchResultList$p(r25);
        if (r26 == null) goto L87;
        r26.setEmptyView(r110);
    L87:
        if (NewContactListFragment.access$getMVisible$p(this.this$0) == false) goto L89;
        ContactDetailCacheManager.getInstance().refreshCache(NewContactListFragment.access$getMSearchResultList$p(this.this$0));
    L89:
        ForceTouchController r111 = NewContactListFragment.access$getMSearchController$p(this.this$0);
        if (r111 == null) goto L361;
        r111.setAdapter(NewContactListFragment.access$getMSearchResultAdapter$p(this.this$0));
        return;
    L361:
        return;
    L71:
        if (r23.getVisibility() != 8) goto L73;
    L60:
        SearchResultAdapter r27 = NewContactListFragment.access$getMSearchResultAdapter$p(this.this$0);
        if (r27 == null) goto L63;
        r27.setListMap(r18, NewContactListFragment.access$getMSearchKeyList$p(this.this$0), NewContactListFragment.access$getMSearchKey$p(this.this$0));
    L54:
        r19 = 0;
        goto L56
    L48:
        r12 = 0;
        goto L49
    L92:
        int r112 = r15.arg1;
        if (r112 == 1) goto L129;
        if (r112 != 2) goto L97;
    L109:
        HeadersListView r113 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r113 == null) goto L113;
        r113.setVisibility(8);
    L113:
        if (NewContactListFragment.access$getMCityListViewFrame$p(this.this$0) == null) goto L119;
        FrameLayout r114 = NewContactListFragment.access$getMCityListViewFrame$p(this.this$0);
        if (r114 == null) goto L119;
        r114.setVisibility(0);
    L119:
        if (NewContactListFragment.access$getMContactsEmptyView$p(this.this$0) == null) goto L124;
        RelativeLayout r115 = NewContactListFragment.access$getMContactsEmptyView$p(this.this$0);
        if (r115 == null) goto L124;
        r115.setVisibility(8);
    L124:
        OIndexScrollbar r116 = NewContactListFragment.access$getMQuickBar$p(this.this$0);
        if (r116 == null) goto L134;
        r116.setVisibility(8);
    L134:
        NewContactListFragment.access$showWaitTipView(this.this$0);
        return;
    L97:
        if (r112 == 4) goto L129;
        if (r112 == 8) goto L129;
        if (r112 == 16) goto L109;
        if (r112 == 32) goto L129;
        if (r112 == 64) goto L129;
        if (r112 == 128) goto L129;
        if (r112 != 256) goto L134;
    L129:
        if (NewContactListFragment.access$getMCityListViewFrame$p(this.this$0) == null) goto L134;
        FrameLayout r117 = NewContactListFragment.access$getMCityListViewFrame$p(this.this$0);
        if (r117 == null) goto L134;
        r117.setVisibility(8);
        goto L134
    L369:
        return;
    L14:
        if (NewContactListFragment.access$getMFrequentContacts$p(this.this$0) == true) goto L354;
        NewContactListFragment r28 = this.this$0;
        int r29 = r15.arg1;
        if (r15.arg2 == 0) goto L18;
        boolean r118 = true;
    L19:
        NewContactListFragment.triggerLoad$default(r28, r29, r118, false, 4, null);
        return;
    L18:
        r118 = false;
        goto L19
    L354:
        return;
    L22:
        if (NewContactListFragment.access$getMSearchContainer$p(this.this$0) == null) goto L357;
        IContactSearchBarPresenter r119 = NewContactListFragment.access$getPresenter(this.this$0);
        if (r119 != null) goto L26;
        return;
    L26:
        if (r15.arg1 > 0) goto L29;
        r8 = false;
    L29:
        r119.setSortByBusinessCardSupported(r8);
        return;
    L357:
        return;
    L135:
        ContactsListSortByNameAdapter r120 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
        if (r120 == null) goto L364;
        r120.notifyDataSetChanged();
        return;
    L364:
        return;
    L139:
        if (NewContactListFragment.access$getMContactsFragment$p(this.this$0) != null) goto L141;
        return;
    L141:
        if (NewContactListFragment.access$getMContactListView$p(this.this$0) != null) goto L144;
        return;
    L144:
        if (NewContactListFragment.access$getMIsEdit$p(this.this$0) == false) goto L146;
        NewContactListFragment r30 = this.this$0;
        NewContactListFragment.access$refreshOptionBar(r30, NewContactListFragment.access$getMSelectedSet$p(r30).size());
    L146:
        this.this$0.dismissLongMenu();
        Object r31 = r15.obj;
        if ((r31 instanceof ArrayList) == false) goto L149;
        ArrayList<SamContact> r32 = (ArrayList) r31;
    L150:
        if (r32 == null) goto L157;
        if ((!r32.isEmpty()) == false) goto L157;
        if (ContactsUtils.isOnlyIncludeProfile(r32) == true) goto L157;
        NewContactListFragment.access$setEnableSelectContacts$p(this.this$0, true);
    L160:
        NewContactListFragment.access$hideWaitTipView(this.this$0);
        int r121 = r15.arg1;
        NewContactListFragment.access$updateListViewConfig(this.this$0, false, r121);
        if (r121 == 1) goto L248;
        if (r121 != 256) goto L347;
        HeadersListView r122 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r122 == null) goto L167;
        r122.setVisibility(0);
    L167:
        NewContactListFragment.access$hideCityListView(this.this$0);
        NewContactListFragment r123 = this.this$0;
        if (r32 == null) goto L170;
        int r33 = r32.size();
    L171:
        if (r33 < 30) goto L173;
        boolean r34 = true;
    L174:
        NewContactListFragment.access$setMHasQuickBar$p(r123, r34);
        if (this.this$0.isSearch() == true) goto L194;
        NewContactListFragment r124 = this.this$0;
        NewContactListFragment.access$initLetter(r124, NewContactListFragment.access$getMQuickBarState$p(r124));
        if (NewContactListFragment.access$getMHasQuickBar$p(this.this$0) == false) goto L186;
        HeadersListView r125 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r125 != null) goto L181;
    L183:
        Object[] r126 = false;
    L184:
        if (r126 == false) goto L186;
        Object[] r127 = true;
    L187:
        OIndexScrollbar r35 = NewContactListFragment.access$getMQuickBar$p(this.this$0);
        if (r35 == null) goto L194;
        if (r127 == false) goto L192;
        r7 = 0;
    L192:
        r35.setVisibility(r7);
        goto L194
    L181:
        if (r125.isStateIdle() != true) goto L183;
        r126 = true;
    L186:
        r127 = false;
    L194:
        if (NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0) == null) goto L196;
    L211:
        ContactsListSortByNameAdapter r128 = NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0);
        if (r128 == null) goto L214;
        r128.setVoiceButtonCallBack(NewContactListFragment.access$getMVoiceBtnCallBack$p(this.this$0));
    L214:
        HeadersListView r129 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r129 == null) goto L218;
        r6 = r129.getAdapter();
    L218:
        if (r6 == NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0)) goto L225;
        HeadersListView r130 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r130 == null) goto L222;
        r130.setAdapter(NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0));
    L222:
        HeadersListView r131 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r131 == null) goto L225;
        r131.setOnScrollStateChangeListener(NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0));
    L225:
        ContactsListSortByNameAdapter r132 = NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0);
        if (r132 == null) goto L228;
        r132.setList(r32);
    L228:
        ArrayList<SamContact> r36 = r32;
        if (r36 != null) goto L231;
    L234:
        if (r8 == false) goto L236;
        NewContactListFragment r133 = this.this$0;
        NewContactListFragment.access$setEmptyView(r133, NewContactListFragment.access$getMContactListView$p(r133));
        goto L347
    L236:
        HeadersListView r134 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r134 == null) goto L239;
        r134.restoreScrollState(false);
    L239:
        ContactsListSortByNameAdapter r135 = NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0);
        if (r135 == null) goto L243;
        r135.notifyDataSetChanged();
    L243:
        if (NewContactListFragment.access$getMVisible$p(this.this$0) == false) goto L245;
        ContactDetailCacheManager.getInstance().refreshCache(NewContactListFragment.access$getMContactListView$p(this.this$0));
    L245:
        ForceTouchController r136 = NewContactListFragment.access$getMForceTouchController$p(this.this$0);
        if (r136 == null) goto L347;
        r136.setAdapter(NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0));
        goto L347
    L231:
        if (r36.isEmpty() == true) goto L234;
        r8 = false;
        goto L234
    L196:
        if (this.this$0.getActivity() != null) goto L198;
        return;
    L198:
        NewContactListFragment.access$setMPhoneContactsAdapter$p(this.this$0, new ContactsListSortByNameAdapter(this.this$0.getActivity(), null, NewContactListFragment.access$getMPhotoManager$p(this.this$0), NewContactListFragment.access$getAsyncImageLoader(this.this$0)));
        ContactsListSortByNameAdapter r137 = NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0);
        if (r137 == null) goto L202;
        r137.setQuickContactListener(NewContactListFragment.access$getMContactListView$p(this.this$0));
    L202:
        ContactsListSortByNameAdapter r138 = NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0);
        if (r138 == null) goto L205;
        r138.setContactsSelectionListener(NewContactListFragment.access$getMContactsSelectionListener$p(this.this$0));
    L205:
        ContactsListSortByNameAdapter r139 = NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0);
        if (r139 == null) goto L208;
        r139.setClickContactListener(NewContactListFragment.access$getContactListViewClickListener$p(this.this$0));
    L208:
        ContactsListSortByNameAdapter r140 = NewContactListFragment.access$getMPhoneContactsAdapter$p(this.this$0);
        if (r140 == null) goto L211;
        r140.setQuickBar(NewContactListFragment.access$getMQuickBar$p(this.this$0));
        goto L211
    L173:
        r34 = false;
        goto L174
    L170:
        r33 = 0;
    L347:
        if (NewContactListFragment.access$getMResetContactListView$p(this.this$0) == false) goto L367;
        HeadersListView r141 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r141 == null) goto L351;
        r141.setSelection(0);
    L351:
        NewContactListFragment.access$setMResetContactListView$p(this.this$0, false);
        return;
    L367:
        return;
    L248:
        if (r32 == null) goto L250;
        int r142 = r32.size();
    L251:
        NewContactListFragment r37 = this.this$0;
        if (r142 <= 0) goto L260;
        if (r32 == null) goto L257;
        SamContact r143 = r32.get(r142 - 1);
        if (r143 == null) goto L257;
        int r144 = r143.count;
    L258:
        if (r144 < 30) goto L260;
        boolean r145 = true;
    L261:
        NewContactListFragment.access$setMHasQuickBar$p(r37, r145);
        NewContactListFragment r146 = this.this$0;
        NewContactListFragment.access$initLetter(r146, NewContactListFragment.access$getMQuickBarState$p(r146));
        if (this.this$0.isSearch() == false) goto L264;
    L278:
        HeadersListView r147 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r147 == null) goto L281;
        r147.setVisibility(0);
    L281:
        NewContactListFragment.access$hideCityListView(this.this$0);
        if (NewContactListFragment.access$getMNorAdapter$p(this.this$0) == null) goto L284;
    L299:
        ContactsListSortByNameAdapter r148 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
        if (r148 == null) goto L302;
        r148.setVoiceButtonCallBack(NewContactListFragment.access$getMVoiceBtnCallBack$p(this.this$0));
    L302:
        HeadersListView r149 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r149 == null) goto L305;
        HeadersAdapter r150 = r149.getAdapter();
    L307:
        if (r150 == NewContactListFragment.access$getMNorAdapter$p(this.this$0)) goto L314;
        HeadersListView r151 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r151 == null) goto L311;
        r151.setAdapter(NewContactListFragment.access$getMNorAdapter$p(this.this$0));
    L311:
        HeadersListView r152 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r152 == null) goto L314;
        r152.setOnScrollStateChangeListener(NewContactListFragment.access$getMNorAdapter$p(this.this$0));
    L314:
        ContactsListSortByNameAdapter r153 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
        if (r153 == null) goto L317;
        r153.setHasQuickBar(NewContactListFragment.access$getMHasQuickBar$p(this.this$0));
    L317:
        ContactsListSortByNameAdapter r154 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
        if (r154 == null) goto L320;
        r154.setList(r32);
    L320:
        ContactsApplication.reportLaunchEnd("NewContactListFragment");
        if (ContactsUtils.isBytedanceFeatureVersion_3_0_Enabled() == true) goto L331;
        if (r32 != null) goto L324;
    L326:
        r8 = false;
    L327:
        if (r8 == false) goto L331;
        HeadersListView r155 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r155 == null) goto L347;
        NewContactListFragment.access$setEmptyView(this.this$0, r155);
        goto L347
    L324:
        if (r32.isEmpty() != true) goto L326;
    L331:
        HeadersListView r156 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r156 == null) goto L335;
        r156.restoreScrollState(false);
    L335:
        if (NewContactListFragment.access$getMVisible$p(this.this$0) == false) goto L340;
        ContactDetailCacheManager.getInstance().refreshCache(NewContactListFragment.access$getMContactListView$p(this.this$0));
        NewContactListFragment r157 = this.this$0;
        if (r32 == null) goto L339;
        r4 = r32.get(0);
    L339:
        NewContactListFragment.access$refreshProfileDetailCache(r157, r4);
    L340:
        ForceTouchController r158 = NewContactListFragment.access$getMForceTouchController$p(this.this$0);
        if (r158 == null) goto L343;
        r158.setAdapter(NewContactListFragment.access$getMNorAdapter$p(this.this$0));
    L343:
        HeadersListView r159 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r159 == null) goto L347;
        NewContactListFragment r38 = this.this$0;
        r159.setOnTouchListener(NewContactListFragment.access$createCloseSwipeTouchListener(r38, NewContactListFragment.access$getMForceTouchController$p(r38)));
        goto L347
    L305:
        r150 = null;
        goto L307
    L284:
        if (this.this$0.getActivity() != null) goto L286;
        return;
    L286:
        NewContactListFragment.access$setMNorAdapter$p(this.this$0, new ContactsListSortByNameAdapter(this.this$0.getActivity(), null, NewContactListFragment.access$getMPhotoManager$p(this.this$0), NewContactListFragment.access$getAsyncImageLoader(this.this$0)));
        ContactsListSortByNameAdapter r160 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
        if (r160 == null) goto L290;
        r160.setQuickContactListener(NewContactListFragment.access$getMContactListView$p(this.this$0));
    L290:
        ContactsListSortByNameAdapter r161 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
        if (r161 == null) goto L293;
        r161.setContactsSelectionListener(NewContactListFragment.access$getMContactsSelectionListener$p(this.this$0));
    L293:
        ContactsListSortByNameAdapter r162 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
        if (r162 == null) goto L296;
        r162.setClickContactListener(NewContactListFragment.access$getContactListViewClickListener$p(this.this$0));
    L296:
        ContactsListSortByNameAdapter r163 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
        if (r163 == null) goto L299;
        r163.setQuickBar(NewContactListFragment.access$getMQuickBar$p(this.this$0));
        goto L299
    L264:
        if (NewContactListFragment.access$getMHasQuickBar$p(this.this$0) == false) goto L271;
        HeadersListView r164 = NewContactListFragment.access$getMContactListView$p(this.this$0);
        if (r164 == null) goto L268;
        boolean r165 = r164.isStateIdle();
    L269:
        if (r165 == false) goto L271;
        Object[] r166 = true;
    L272:
        OIndexScrollbar r39 = NewContactListFragment.access$getMQuickBar$p(this.this$0);
        if (r39 == null) goto L278;
        if (r166 == false) goto L277;
        r7 = 0;
    L277:
        r39.setVisibility(r7);
        goto L278
    L268:
        r165 = false;
    L271:
        r166 = false;
    L257:
        r144 = 0;
    L260:
        r145 = false;
        goto L261
    L250:
        r142 = 0;
    L157:
        if (NewContactListFragment.access$getMIsEdit$p(this.this$0) == false) goto L159;
        NewContactListFragment.access$processEditContacts(this.this$0, false, false);
    L159:
        NewContactListFragment.access$setEnableSelectContacts$p(this.this$0, false);
        goto L160
    L149:
        r32 = null;
        goto L150
    }
}
