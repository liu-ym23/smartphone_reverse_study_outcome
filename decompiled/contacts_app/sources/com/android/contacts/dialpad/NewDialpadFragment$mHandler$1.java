package com.android.contacts.dialpad;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.view.LayoutInflater;
import android.widget.ListAdapter;
import androidx.core.app.NotificationCompat;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.forcetouch.ForceTouchController;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.recommend.FlowAdapter;
import com.android.contacts.util.UiUtils;
import com.obric.ui.OUIHelper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewDialpadFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/android/contacts/dialpad/NewDialpadFragment$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewDialpadFragment$mHandler$1 extends Handler {
    final /* synthetic */ NewDialpadFragment this$0;

    public static /* synthetic */ void $r8$lambda$ZJaofLndLZxs3M9JVr1YJGvoA4I(NewDialpadFragment r0) {
        handleMessage$lambda$0(r0);
    }

    NewDialpadFragment$mHandler$1(NewDialpadFragment r1, Looper r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r9) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        if (UiUtils.isUiFinishing(this.this$0.getActivity()) == false) goto L5;
        return;
    L5:
        int r0 = r9.what;
        if (r0 == 201) goto L157;
        String r2 = null;
        Future<?> r3 = null;
        ArrayList<ContactItem> r4 = null;
        ListAdapter r5 = null;
        if (r0 != 202) goto L10;
        Object r10 = r9.obj;
        if ((r10 instanceof String) == false) goto L154;
        r2 = (String) r10;
    L154:
        if (r2 == null) goto L181;
        NewDialpadFragment.access$queryNumberAttribution(this.this$0, r2);
        return;
    L181:
        return;
    L10:
        if (r0 == 1000) goto L145;
        boolean r6 = true;
        int r7 = 0;
        if (r0 == R.id.msg_addresult_to_t9adapter) goto L97;
        switch(r0) {
            case 10: goto L95;
            case 11: goto L94;
            case 12: goto L88;
            case 13: goto L83;
            default: goto L14;
        };
    L14:
        switch(r0) {
            case 2131363094: goto L74;
            case 2131363095: goto L66;
            case 2131363096: goto L27;
            case 2131363097: goto L17;
            default: goto L184;
        };
    L74:
        ObjectAnimator r11 = NewDialpadFragment.access$getMListViewAlphaAnimator$p(this.this$0);
        if (r11 != null) goto L77;
    L79:
        r6 = false;
    L80:
        if (r6 == false) goto L166;
        this.this$0.resetDialpad();
        return;
    L166:
        return;
    L77:
        if (r11.isRunning() == true) goto L79;
    L184:
        return;
    L17:
        if (NewDialpadFragment.access$isDigitsEmpty(this.this$0) == true) goto L160;
        NewDialpadFragment.access$beginRefreshOptionFrame(this.this$0);
        QuickContactListView r12 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r12 == null) goto L21;
        r12.setOnScrollStateChangeListener(null);
    L21:
        DigitsEditText r8 = NewDialpadFragment.access$getMDigits$p(this.this$0);
        if (r8 == null) goto L24;
        int r13 = r8.length();
    L25:
        DialpadMatchTracker.onMatchDone(r13, 0);
        return;
    L24:
        r13 = 0;
        goto L25
    L160:
        return;
    L27:
        if (NewDialpadFragment.access$isDigitsEmpty(this.this$0) == false) goto L29;
        return;
    L29:
        if (NewDialpadFragment.access$hasT9ListAdapter(this.this$0) == true) goto L33;
        QuickContactListView r14 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r14 == null) goto L33;
        r14.restoreScrollState(false);
    L33:
        T9Search.T9Adapter r15 = NewDialpadFragment.access$getMT9Adapter$p(this.this$0);
        if (r15 == null) goto L36;
        r15.setCountLimit(true);
    L36:
        sendEmptyMessageDelayed(13, 300);
        NewDialpadFragment.access$updateListViewConfig(this.this$0, false);
        QuickContactListView r16 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r16 == null) goto L40;
        r16.setAdapter(NewDialpadFragment.access$getMT9Adapter$p(this.this$0));
    L40:
        QuickContactListView r17 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r17 == null) goto L44;
        r17.setScrollEnabled(true);
    L44:
        ContactDetailCacheManager.getInstance().refreshCache(NewDialpadFragment.access$getMListView$p(this.this$0));
        QuickContactListView r18 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r18 == null) goto L47;
        r18.setOnScrollStateChangeListener(NewDialpadFragment.access$getMT9Adapter$p(this.this$0));
    L47:
        ForceTouchController r19 = NewDialpadFragment.access$getMForceTouchController$p(this.this$0);
        if (r19 == null) goto L50;
        r19.setAdapter(NewDialpadFragment.access$getMT9Adapter$p(this.this$0));
    L50:
        NewDialpadFragment.access$showListViewWithAnimIfNeed(this.this$0);
        QuickContactListView r20 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r20 == null) goto L55;
        NewDialpadFragment r1 = this.this$0;
        if (r20.getFooterViewsCount() != 0) goto L55;
        LayoutInflater r21 = r1.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(r21, "layoutInflater");
        OUIHelper.OUIList.setFooter(r21, r20, Integer.valueOf(OUIHelper.OUIList.getFooterHeight184()));
    L55:
        DigitsEditText r22 = NewDialpadFragment.access$getMDigits$p(this.this$0);
        if (r22 == null) goto L58;
        int r23 = r22.length();
    L59:
        T9Search.T9SearchResult r24 = this.this$0.getMT9Result();
        if (r24 == null) goto L64;
        ArrayList<ContactItem> r25 = r24.getResults();
        if (r25 == null) goto L64;
        r7 = r25.size();
    L64:
        DialpadMatchTracker.onMatchDone(r23, r7);
        return;
    L58:
        r23 = 0;
        goto L59
    L66:
        if (NewDialpadFragment.access$getMVisibilityChanged$p(this.this$0) == false) goto L164;
        this.this$0.setMT9Result(null);
        Future r26 = NewDialpadFragment.access$getMSearchFuture$p(this.this$0);
        if (r26 == null) goto L70;
        r26.cancel(true);
    L70:
        NewDialpadFragment r27 = this.this$0;
        ExecutorService r28 = r27.getPool();
        if (r28 == null) goto L73;
        final NewDialpadFragment r29 = this.this$0;
        r3 = r28.submit(new NewDialpadFragment$mHandler$1$$ExternalSyntheticLambda0(r29));
    L73:
        NewDialpadFragment.access$setMSearchFuture$p(r27, r3);
        return;
    L164:
        return;
    L94:
        String r30 = (String) r9.obj;
        return;
    L95:
        NewDialpadFragment.access$updateOnEntry(this.this$0);
        return;
    L83:
        if (NewDialpadFragment.access$getMT9Adapter$p(this.this$0) == null) goto L168;
        T9Search.T9Adapter r31 = NewDialpadFragment.access$getMT9Adapter$p(this.this$0);
        if (r31 == null) goto L169;
        r31.setCountLimit(false);
        return;
    L169:
        return;
    L168:
        return;
    L88:
        if (NewDialpadFragment.access$getMDigits$p(this.this$0) == null) goto L171;
        NewDialpadFragment.Companion.access$log(NewDialpadFragment.Companion, "handleMessge: SHOW_MIRAGE_HIDE_ANIMATION");
        DigitsEditText r32 = NewDialpadFragment.access$getMDigits$p(this.this$0);
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type com.android.contacts.dialpad.DigitsEditText");
        r32.startMirageHideAnimation();
        DigitsEditText r33 = NewDialpadFragment.access$getMDigits$p(this.this$0);
        if (r33 == null) goto L172;
        Editable r34 = r33.getText();
        if (r34 == null) goto L173;
        r34.clear();
        return;
    L173:
        return;
    L172:
        return;
    L171:
        return;
    L97:
        if (NewDialpadFragment.access$isDigitsEmpty(this.this$0) == false) goto L99;
        return;
    L99:
        if (NewDialpadFragment.access$hasT9ListAdapter(this.this$0) == true) goto L121;
        T9Search.T9Adapter r35 = NewDialpadFragment.access$getMT9Adapter$p(this.this$0);
        if (r35 == null) goto L103;
        r35.setCountLimit(true);
    L103:
        sendEmptyMessageDelayed(13, 300);
        NewDialpadFragment.access$updateListViewConfig(this.this$0, false);
        QuickContactListView r36 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r36 == null) goto L107;
        r36.setAdapter(NewDialpadFragment.access$getMT9Adapter$p(this.this$0));
    L107:
        QuickContactListView r37 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r37 == null) goto L111;
        r37.setScrollEnabled(true);
    L111:
        QuickContactListView r38 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r38 == null) goto L114;
        r38.setOnScrollStateChangeListener(NewDialpadFragment.access$getMT9Adapter$p(this.this$0));
    L114:
        QuickContactListView r39 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r39 == null) goto L117;
        r39.restoreScrollState(false);
    L117:
        ForceTouchController r40 = NewDialpadFragment.access$getMForceTouchController$p(this.this$0);
        if (r40 == null) goto L120;
        r40.setAdapter(NewDialpadFragment.access$getMT9Adapter$p(this.this$0));
    L120:
        NewDialpadFragment.access$showListViewWithAnimIfNeed(this.this$0);
    L122:
        T9Search.T9SearchResult r41 = this.this$0.getMT9Result();
        if (r41 == null) goto L125;
        ArrayList<ContactItem> r42 = r41.getResults();
    L126:
        if (r42 != null) goto L128;
    L135:
        DigitsEditText r43 = NewDialpadFragment.access$getMDigits$p(this.this$0);
        if (r43 == null) goto L138;
        int r44 = r43.length();
    L139:
        T9Search.T9SearchResult r45 = this.this$0.getMT9Result();
        if (r45 == null) goto L144;
        ArrayList<ContactItem> r46 = r45.getResults();
        if (r46 == null) goto L144;
        r7 = r46.size();
    L144:
        DialpadMatchTracker.onMatchDone(r44, r7);
        return;
    L138:
        r44 = 0;
        goto L139
    L128:
        if (NewDialpadFragment.access$getMT9Adapter$p(this.this$0) == null) goto L135;
        T9Search.T9Adapter r47 = NewDialpadFragment.access$getMT9Adapter$p(this.this$0);
        if (r47 == null) goto L135;
        T9Search.T9SearchResult r48 = this.this$0.getMT9Result();
        if (r48 == null) goto L134;
        r4 = r48.getResults();
    L134:
        r47.setItems(r4);
        goto L135
    L125:
        r42 = null;
        goto L126
    L121:
        NewDialpadFragment.access$showListViewWithoutAnimIfNeed(this.this$0);
        goto L122
    L145:
        QuickContactListView r49 = NewDialpadFragment.access$getMListView$p(this.this$0);
        if (r49 == null) goto L148;
        r5 = r49.getAdapter();
    L148:
        ListAdapter r50 = r5;
        if ((r50 instanceof FlowAdapter) == false) goto L179;
        ((FlowAdapter) r50).notifyDataSetChanged();
        return;
    L179:
        return;
    L157:
        if (NewDialpadFragment.access$isDigitsEmpty(this.this$0) == true) goto L183;
        NewDialpadFragment.access$refreshOptionFrame(this.this$0, r9.obj);
        return;
    }

    private static final void handleMessage$lambda$0(NewDialpadFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.searchContacts();
    }
}
