package com.bytedance.android.livesdk.vscore_impl.component.tabs.popup;

import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.LivePagerTabsStrip;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.TabLogHelper;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/popup/MultiTabBubbleWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiTabBubbleWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f159982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f159983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f159984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f159985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f159986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f159987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MultiTab.Bubble f159988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f159989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f159990i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_impl.component.tabs.popup.MultiTabBubbleWidget$onLoad$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/popup/g;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/popup/g;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<g, Unit> {
        public AnonymousClass1(MultiTabBubbleWidget r100) {
            super(1, r100, MultiTabBubbleWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/popup/ShowMultiTabPopupEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(g r110) {
            Intrinsics.checkNotNullParameter(r110, "p1");
            MultiTabBubbleWidget r100 = (MultiTabBubbleWidget) this.receiver;
            r100.getClass();
            LinkedList<MultiTab.Bubble> r101 = MultiTabBubbleManager.f159974a;
            MultiTabBubbleManager.b(r110.f159999b.getBubbleId() + " onEvent " + r110.f159999b.toString());
            if (r100.f159987f == false) goto L5;
            MultiTabBubbleManager.b(r110.f159999b.getBubbleId() + " onEvent abandon because ishowing now " + r110.f159999b.toString() + ' ');
            return;
        L5:
            DataCenter r102 = r100.dataCenter;
            int r103 = r110.f159998a;
            Intrinsics.checkNotNullParameter(r102, "dataCenter");
            WeakReference<LivePagerTabsStrip> r104 = MultiTabBubbleManager.f159977d;
            if (r104 == null) goto L10;
            LivePagerTabsStrip r105 = r104.get();
            if (r105 == null) goto L10;
            int r106 = r105.getWidth();
        L12:
            if (r103 <= 0) goto L15;
            if (r103 >= r106) goto L15;
            boolean r107 = true;
        L17:
            if (r107 == true) goto L19;
            MultiTabBubbleManager.b(r110.f159999b.getBubbleId() + " onEvent abandon because ishowing isShownMoreThanHalf false \n try to show next bubble ");
            MultiTabBubbleManager.c(null, null);
            return;
        L19:
            u r108 = r.u(r100.dataCenter, null, 2);
            if (r108 == null) goto L28;
            n<Long> r109 = r108.y7();
            if (r109 == null) goto L28;
            Observable<sh6.b<Long>> r111 = r109.a();
            if (r111 == null) goto L28;
            Disposable r112 = r111.subscribe(new b(r100, r110));
            if (r112 == null) goto L28;
            RxUtilKt.c(r112, r100.f159990i);
        L28:
            ReplayDataContext.a r113 = ReplayDataContext.Companion;
            DataCenter r114 = r100.dataCenter;
            r113.getClass();
            ReplayDataContext r115 = ReplayDataContext.a.b(r114);
            if (r115 == null) goto L37;
            n<Long> r116 = r115.getCurTabId();
            if (r116 == null) goto L37;
            Observable<sh6.b<Long>> r117 = r116.a();
            if (r117 == null) goto L37;
            Disposable r118 = r117.subscribe(new c(r100, r110));
            if (r118 == null) goto L37;
            RxUtilKt.c(r118, r100.f159990i);
        L37:
            int r119 = r110.f159998a;
            MultiTab.Bubble r120 = r110.f159999b;
            Intrinsics.checkNotNullParameter(r120, "bubble");
            TextView r121 = r100.f159985d;
            if (r121 == null) goto L84;
            TextPaint r122 = r121.getPaint();
            if (r122 == null) goto L84;
            TextView r123 = r100.f159985d;
            if (r123 == null) goto L44;
            CharSequence r124 = r123.getText();
        L45:
            int r125 = (int) (r122.measureText(String.valueOf(r124)) + s1.f(24.0f));
            float r126 = r119;
            float r127 = r126 - (r125 / 2.0f);
            float r128 = s1.f(r100.f159989h);
            if (r127 >= r128) goto L49;
            byte r129 = -1;
        L53:
            if (r129 != (-1)) goto L55;
            r127 = r127 + s1.f(18.0f);
        L57:
            float r130 = Math.max(Math.min((int) ((r126 - r127) - s1.f(10.0f)), r125 - s1.f(8.0f)), s1.f(8.0f));
            View r131 = r100.contentView;
            if (r131 == null) goto L60;
            ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        L62:
            if ((r132 instanceof FrameLayout.LayoutParams) == true) goto L64;
            r132 = null;
        L64:
            FrameLayout.LayoutParams r133 = (FrameLayout.LayoutParams) r132;
            if (r133 == null) goto L67;
            r133.leftMargin = (int) r127;
        L67:
            View r134 = r100.contentView;
            if (r134 == null) goto L70;
            r134.setLayoutParams(r133);
        L70:
            ImageView r135 = r100.f159984c;
            if (r135 == null) goto L73;
            ViewGroup.LayoutParams r136 = r135.getLayoutParams();
        L74:
            if (r136 == null) goto L83;
            ConstraintLayout.LayoutParams r137 = (ConstraintLayout.LayoutParams) r136;
            ((ViewGroup.MarginLayoutParams) r137).leftMargin = (int) r130;
            ImageView r138 = r100.f159984c;
            if (r138 == null) goto L78;
            r138.setLayoutParams(r137);
        L78:
            TextView r139 = r100.f159985d;
            if (r139 == null) goto L81;
            r139.setText(r120.getBubbleText());
        L81:
            r100.f159988g = r120;
            UtilityKotlinExtentionsKt.w(r100.contentView);
            r100.f159987f = true;
            r100.f159983b = new d(r100, r120);
            MultiTabBubbleManager.b(r120.getBubbleId() + " realPopBubble SUCCESSED duration:" + r120.getDuration());
            Handler r140 = r100.f159982a;
            d r141 = r100.f159983b;
            Intrinsics.checkNotNull(r141);
            r140.postDelayed(r141, r120.getDuration() * 1000);
            goto L84
        L83:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L73:
            r136 = null;
            goto L74
        L60:
            r132 = null;
            goto L62
        L55:
            if (r129 != 1) goto L57;
            r127 = r127 - s1.f(18.0f);
            goto L57
        L49:
            if ((s1.y() - r127) >= r128) goto L51;
            r129 = 1;
            goto L53
        L51:
            r129 = 0;
            goto L53
        L44:
            r124 = null;
        L84:
            SharedPrefHelper r142 = SharedPrefHelper.b(s1.getContext());
            r142.l(r100.f159986e + r110.f159999b.getBubbleId(), 1);
            r142.a();
            int r143 = TabLogHelper.f159919a;
            MultiTab.Bubble r144 = r110.f159999b;
            if (ReplayDataContext.a.b(r100.dataCenter) == null) goto L87;
            boolean r145 = true;
        L88:
            Boolean r146 = Boolean.valueOf(r145);
            Intrinsics.checkNotNullParameter(r144, "bubble");
            MultiTabType.a r147 = MultiTabType.Companion;
            long r148 = r144.getShowTabId();
            r147.getClass();
            Map r149 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("tab_type", MultiTabType.a.a(r148).getLogParam())});
            if (Intrinsics.areEqual(r146, Boolean.TRUE) == false) goto L91;
            r149.put(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, "1");
        L91:
            TabLogHelper.b("livesdk_live_tab_bubble_show", r149, null);
            return;
        L87:
            r145 = false;
        L15:
            r107 = false;
        L10:
            r106 = s1.y();
            goto L12
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(g r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_multitab_bubble;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        LinkedList<MultiTab.Bubble> r100 = MultiTabBubbleManager.f159974a;
        MultiTabBubbleManager.b("onUnload");
        d r101 = this.f159983b;
        if (r101 == null) goto L5;
        this.f159982a.removeCallbacks(r101);
    L5:
        this.f159983b = null;
        if (this.f159987f == false) goto L8;
        MultiTabBubbleManager.b("hide latest bubble because has been clicked");
    L8:
        LinkedList<MultiTab.Bubble> r102 = MultiTabBubbleManager.f159974a;
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        MultiTabBubbleManager.f159974a = null;
        ((LinkedHashMap) MultiTabBubbleManager.f159978e).clear();
        MultiTabBubbleManager.a r103 = MultiTabBubbleManager.f159976c;
        if (r103 == null) goto L14;
        ((Handler) MultiTabBubbleManager.f159975b.getValue()).removeCallbacks(r103);
    L14:
        WeakReference<LivePagerTabsStrip> r104 = MultiTabBubbleManager.f159977d;
        if (r104 == null) goto L17;
        r104.clear();
    L17:
        MultiTabBubbleManager.f159977d = null;
        MultiTabBubbleManager.b("manager onUnload & clear");
        UtilityKotlinExtentionsKt.t(this.contentView);
        this.f159990i.clear();
    }

    public MultiTabBubbleWidget() {
        this.f159982a = new Handler(Looper.getMainLooper());
        this.f159986e = "live.key.KEY_LIVE_VS_MULTITAB_BUBBLE";
        this.f159989h = 8.0f;
        this.f159990i = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        LinkedList<MultiTab.Bubble> r101 = MultiTabBubbleManager.f159974a;
        MultiTabBubbleManager.b("MultiTabBubbleWidget onLoad");
        this.f159984c = (ImageView) findViewById(R.id.iv_top_arrow);
        this.f159985d = (TextView) findViewById(R.id.bubble_text);
        AnonymousClass1 r102 = new AnonymousClass1(this);
        RxUtilKt.c(xs2.b.a().b(g.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r102)), this.f159990i);
        u r103 = r.u(this.dataCenter, null, 2);
        if (r103 == null) goto L8;
        m<Boolean> r104 = r103.j();
        if (r104 == null) goto L9;
        r104.setValue(Boolean.TRUE);
        return;
    L9:
        return;
    }

    public final void wq(String r110) {
        Intrinsics.checkNotNullParameter(r110, "hideAction");
        UtilityKotlinExtentionsKt.t(this.contentView);
        this.f159987f = false;
        MultiTabBubbleManager.c(null, null);
        MultiTab.Bubble r100 = this.f159988g;
        if (r100 == null) goto L13;
        int r101 = TabLogHelper.f159919a;
        ReplayDataContext.a r102 = ReplayDataContext.Companion;
        DataCenter r103 = this.dataCenter;
        r102.getClass();
        if (ReplayDataContext.a.b(r103) == null) goto L7;
        boolean r104 = true;
    L8:
        Boolean r105 = Boolean.valueOf(r104);
        Intrinsics.checkNotNullParameter(r100, "bubble");
        Intrinsics.checkNotNullParameter(r110, ReportConstant.COMMON_ACTION_TYPE);
        MultiTabType.a r106 = MultiTabType.Companion;
        long r107 = r100.getShowTabId();
        r106.getClass();
        Map r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("tab_type", MultiTabType.a.a(r107).getLogParam()), TuplesKt.to("action_type", r110)});
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L11;
        r111.put(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, "1");
    L11:
        TabLogHelper.b("livesdk_live_tab_bubble_disappear", r111, null);
        return;
    L7:
        r104 = false;
        goto L8
    }
}
