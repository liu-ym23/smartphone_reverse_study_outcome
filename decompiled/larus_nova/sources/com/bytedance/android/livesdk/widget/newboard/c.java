package com.bytedance.android.livesdk.widget.newboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.view.MaxWidthLinearLayout;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.model.ExpressionSection;
import com.bytedance.android.livesdk.model.h;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.board.ExpressionContext;
import com.bytedance.android.livesdk.widget.board.ExpressionSectionListAdapter;
import com.bytedance.android.livesdk.widget.board.ExpressionSectionPagerAdapter;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f161875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f161876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f161877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f161878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f161879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GridLayoutManager f161880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ExpressionSectionPagerAdapter f161881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExpressionSectionListAdapter f161882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RecyclerView f161883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ExpressionContext f161884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f161885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f161886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f161887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.expression.a f161888n;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r100 = l42.a.f507335v;
        Integer r101 = Integer.valueOf(this.f161885k);
        r100.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r100, r101);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = l42.a.f507334u;
        Boolean r103 = Boolean.FALSE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        this.f161881g.j();
        this.f161887m.dispose();
        Iterator<T> r104 = this.f161882h.f161432e.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((ExpressionSection) r104.next()).d();
        goto L4
    L6:
        super.onDetachedFromWindow();
    }

    private final boolean getSelfIsVisibility() {
        if (getVisibility() == 0) goto L5;
        return false;
    L5:
        if (getHeight() > 0) goto L7;
        return false;
    L7:
        if (getWidth() > 0) goto L9;
        return false;
    L9:
        if (getAlpha() <= 0) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean getEnableActivityEmoji() {
        return this.f161877c;
    }

    public final boolean getEnableFusionEmoji() {
        return this.f161878d;
    }

    public final boolean getEnableGuideChat() {
        return this.f161879e;
    }

    public final boolean getEnableSubscribeEmoji() {
        return this.f161876b;
    }

    public final com.bytedance.android.livesdk.interactivity.api.expression.a getExpressionPanelConfig() {
        return this.f161888n;
    }

    public static final /* synthetic */ boolean b(c r100) {
        return r100.getSelfIsVisibility();
    }

    public final View a(int r100) {
        if (this.f161875a != null) goto L5;
        this.f161875a = new LinkedHashMap();
    L5:
        View r101 = this.f161875a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f161875a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setOnCommentSendDelegate(j r100) {
        Intrinsics.checkNotNullParameter(r100, "onCommentSendDelegate");
        this.f161884j.getOnCommentSendDelegate().setValue(r100);
        int r101 = Math.max(Math.min(this.f161885k, ((ArrayList) this.f161881g.f161449g).size() - 1), 0);
        j r102 = this.f161884j.getOnCommentSendDelegate().getValue();
        if (r102 == null) goto L6;
        r102.i(((h) ListProtector.get(this.f161881g.f161449g, r101)).getPageName());
        return;
    }

    public c(Context r110, com.bytedance.android.livesdk.interactivity.api.expression.a r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "expressionPanelConfig");
        super(r110, null, 0);
        this.f161888n = r111;
        this.f161875a = new LinkedHashMap();
        boolean r100 = r111.f133191b;
        boolean r101 = r111.f133192c;
        this.f161876b = r101;
        boolean r102 = r111.f133193d;
        this.f161877c = r102;
        boolean r103 = r111.f133194e;
        this.f161878d = r103;
        boolean r104 = r111.f133195f;
        this.f161879e = r104;
        this.f161880f = new GridLayoutManager(r110, 2);
        ExpressionContext r105 = new ExpressionContext();
        this.f161884j = r105;
        this.f161886l = -1;
        this.f161887m = new CompositeDisposable();
        LayoutInflater.from(r110).inflate(R.layout.ttlive_expression_board_v3, this, true);
        setBackgroundColor(getResources().getColor(R.color.ttlive_white));
        SSViewPager r106 = (SSViewPager) findViewById(R.id.emoji_pager);
        if (r100 == true) goto L7;
        MaxWidthLinearLayout r107 = (MaxWidthLinearLayout) a(R.id.max_linear_layout);
        if (r107 == null) goto L7;
        r107.setMaxWidth(UtilityKotlinExtentionsKt.i(480));
    L7:
        this.f161883i = (RecyclerView) findViewById(R.id.emoji_section_list);
        this.f161881g = new ExpressionSectionPagerAdapter(r110, r106, r105);
        i r108 = new i();
        r108.f133221g = r102;
        r108.f133223i = r103;
        r108.f133222h = r104;
        Unit r109 = Unit.INSTANCE;
        ArrayList r112 = CollectionsKt.arrayListOf(new h[]{new tv2.a(r100, r108)});
        if (r101 == false) goto L18;
        com.bytedance.android.live.profit.vip.e r113 = yt0.c.l();
        if (r113 == null) goto L17;
        m<? extends com.bytedance.android.live.profit.vip.h> r114 = r113.getSubscribeInfo();
        if (r114 == null) goto L17;
        com.bytedance.android.live.profit.vip.h r115 = r114.getValue();
        if (r115 == null) goto L17;
        if (r115.f89134b == 0) goto L18;
    L17:
        r112.add(new uv2.b(r100, r111.f133190a));
    L18:
        ArrayList r116 = new ArrayList();
        Iterator r117 = r112.iterator();
    L20:
        if (r117.hasNext() == false) goto L22;
        r116.add(((h) r117.next()).b());
        goto L20
    L22:
        ExpressionSectionListAdapter r118 = new ExpressionSectionListAdapter(this.f161883i, r116, true);
        this.f161882h = r118;
        if (r112.isEmpty() == true) goto L57;
        this.f161883i.setLayoutManager(this.f161880f);
        this.f161883i.setAdapter(r118);
        ExpressionSectionPagerAdapter r119 = this.f161881g;
        Function3<Integer, Integer, h, Unit> r120 = new ExpressionBoardV3$bindSections$1(this);
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "onSectionChangedListener");
        r119.f161443a.add(r120);
        this.f161881g.h(r112);
        r118.f161428a = new ExpressionBoardV3$bindSections$2(this);
        if (this.f161885k >= r112.size()) goto L55;
        com.bytedance.android.live.profit.vip.e r121 = yt0.c.l();
        if (r121 == null) goto L53;
        m<Boolean> r122 = r121.isFirstTimeOpenEmoji();
        if (r122 == null) goto L53;
        if (r122.getValue().booleanValue() != true) goto L53;
        Integer r123 = l42.a.f507335v.getValue();
        if (r123 != null) goto L37;
    L38:
        com.bytedance.android.live.profit.vip.e r124 = yt0.c.l();
        if (r124 == null) goto L47;
        m<? extends com.bytedance.android.live.profit.vip.h> r125 = r124.getSubscribeInfo();
        if (r125 == null) goto L47;
        com.bytedance.android.live.profit.vip.h r126 = r125.getValue();
        if (r126 == null) goto L47;
        if (r126.f89134b != 1) goto L47;
        int r127 = this.f161886l;
    L48:
        this.f161885k = r127;
        com.bytedance.android.live.profit.vip.e r128 = yt0.c.l();
        if (r128 == null) goto L54;
        m<Boolean> r129 = r128.isFirstTimeOpenEmoji();
        if (r129 == null) goto L54;
        r129.setValue(Boolean.FALSE);
    L54:
        r118.f161430c.add(Integer.valueOf(this.f161885k));
        this.f161881g.f161452j.setCurrentItem(this.f161885k, false);
    L47:
        r127 = 0;
        goto L48
    L37:
        if (r123.intValue() != 1) goto L38;
    L53:
        this.f161885k = l42.a.f507335v.getValue().intValue();
        goto L54
    L55:
        r118.f161430c.add(0);
        this.f161881g.f161452j.setCurrentItem(0, false);
    L57:
        if (r112.size() > 1) goto L59;
        UtilityKotlinExtentionsKt.t(this.f161883i);
        UIUtils.updateLayoutMargin(a(R.id.emoji_delete_container), -3, -3, -3, UtilityKotlinExtentionsKt.i(2));
        this.f161884j.getSectionShow().setValue(Boolean.FALSE);
    L60:
        ImageView r130 = (ImageView) a(R.id.emoji_delete_btn);
        if (r130 == null) goto L63;
        r130.setOnClickListener(new com.bytedance.android.livesdk.widget.newboard.a(this));
    L63:
        r3.a(a(R.id.emoji_delete_btn), s1.B(R.string.ttlive_a11y_delete));
        com.bytedance.android.live.profit.vip.e r131 = yt0.c.l();
        if (r131 == null) goto L74;
        m<Boolean> r132 = r131.getHasNewSubscribeEmoji();
        if (r132 == null) goto L75;
        Observable<Boolean> r133 = r132.a();
        if (r133 == null) goto L76;
        Disposable r134 = r133.subscribe(new b(this, r116));
        if (r134 == null) goto L77;
        RxUtilKt.c(r134, this.f161887m);
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L59:
        this.f161884j.getSectionShow().setValue(Boolean.TRUE);
        goto L60
    }
}
