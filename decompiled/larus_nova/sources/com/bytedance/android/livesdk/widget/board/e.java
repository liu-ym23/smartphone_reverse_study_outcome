package com.bytedance.android.livesdk.widget.board;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends FrameLayout implements jf2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f161460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExpressionSectionPagerAdapter f161461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExpressionSectionListAdapter f161462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f161463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f161464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f161465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f161466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f161467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ExpressionContext f161468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f161469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f161470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f161471l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f161472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.expression.i f161473n;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r100 = l42.a.f507335v;
        Integer r101 = Integer.valueOf(this.f161469j);
        r100.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r100, r101);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = l42.a.f507334u;
        Boolean r103 = Boolean.FALSE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        this.f161461b.j();
        this.f161470k.dispose();
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

    public final com.bytedance.android.livesdk.interactivity.api.expression.i getParam() {
        return this.f161473n;
    }

    public final int getParentViewHeight() {
        return this.f161472m;
    }

    public static final /* synthetic */ boolean b(e r100) {
        return r100.getSelfIsVisibility();
    }

    @Override // jf2.a
    public final void a(String r100) {
        if (this.f161473n.f133216b == true) goto L10;
        TextView r101 = this.f161464e;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        int r102 = 4;
    L8:
        UIUtils.setViewVisibility(r101, r102);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public final void setOnCommentSendDelegate(com.bytedance.android.livesdk.interactivity.api.expression.j r100) {
        Intrinsics.checkNotNullParameter(r100, "onCommentSendDelegate");
        this.f161468i.getOnCommentSendDelegate().setValue(r100);
    }

    public static void c(View r100, String r101) {
        r100.setTag(r101);
        if ((r100 instanceof ViewGroup) == false) goto L10;
        ViewGroup r102 = (ViewGroup) r100;
        if (r102.getChildCount() <= 0) goto L12;
        Iterator<View> r103 = UtilityKotlinExtentionsKt.g(r102).iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        View r104 = r103.next();
        r104.setTag(r101);
        c(r104, r101);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (Intrinsics.areEqual(r100, this) == false) goto L23;
        String r102 = "";
        if (r101 != 0) goto L21;
        Object r103 = r100.getTag();
        if (r103 == null) goto L10;
        String r104 = r103.toString();
        if (r104 == null) goto L10;
    L11:
        c(this, r104);
        com.bytedance.android.livesdk.interactivity.api.expression.j r105 = this.f161468i.getOnCommentSendDelegate().getValue();
        if (r105 == null) goto L20;
        String r106 = ((com.bytedance.android.livesdk.model.h) ListProtector.get(this.f161461b.f161449g, this.f161467h)).getPageName();
        Object r107 = getTag();
        if (r107 == null) goto L19;
        String r108 = r107.toString();
        if (r108 == null) goto L19;
        r102 = r108;
    L19:
        r105.d(r106, r102);
    L20:
        c(this, "change_emoji_sub_type");
        return;
    L10:
        r104 = "";
        goto L11
    L21:
        c(this, "");
        return;
    }

    public e(Context r100, int r101, boolean r110, com.bytedance.android.livesdk.interactivity.api.expression.i r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "param");
        super(r100, null, 0);
        this.f161472m = r101;
        this.f161473n = r111;
        this.f161460a = new LinearLayoutManager(r100, 0, false);
        ExpressionContext r102 = new ExpressionContext();
        this.f161468i = r102;
        this.f161470k = new CompositeDisposable();
        this.f161471l = -1;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_expression_board, this, true);
        setBackgroundColor(getResources().getColor(R.color.ttlive_white));
        TextView r103 = (TextView) findViewById(R.id.emoji_send_btn_red);
        this.f161464e = r103;
        View r104 = findViewById(R.id.emoji_delete_btn);
        this.f161465f = r104;
        SSViewPager r105 = (SSViewPager) findViewById(R.id.emoji_pager);
        this.f161463d = (RecyclerView) findViewById(R.id.rv_emoji_section_list);
        this.f161461b = new ExpressionSectionPagerAdapter(r100, r105, r102);
        View r106 = findViewById(R.id.emoji_send_btn_grey);
        this.f161466g = r106;
        if (r106 == null) goto L5;
        r106.setOnClickListener(com.bytedance.android.livesdk.widget.board.a.f161454a);
    L5:
        r103.setOnClickListener(new g(this));
        r104.setOnClickListener(new h(this));
        ArrayList r107 = CollectionsKt.arrayListOf(new com.bytedance.android.livesdk.model.h[]{new tv2.a(r110, r111)});
        if (r111.f133215a == false) goto L16;
        com.bytedance.android.live.profit.vip.e r108 = yt0.c.l();
        if (r108 == null) goto L15;
        m<? extends com.bytedance.android.live.profit.vip.h> r109 = r108.getSubscribeInfo();
        if (r109 == null) goto L15;
        com.bytedance.android.live.profit.vip.h r112 = r109.getValue();
        if (r112 == null) goto L15;
        if (r112.f89134b == 0) goto L16;
    L15:
        r107.add(new uv2.b(r110, null));
        this.f161471l = r107.size() - 1;
    L16:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r107.iterator();
    L18:
        if (r114.hasNext() == false) goto L20;
        r113.add(((com.bytedance.android.livesdk.model.h) r114.next()).b());
        goto L18
    L20:
        ExpressionSectionListAdapter r115 = new ExpressionSectionListAdapter(this.f161463d, r113, false);
        this.f161462c = r115;
        if (r107.isEmpty() == true) goto L49;
        this.f161463d.setLayoutManager(this.f161460a);
        this.f161463d.setAdapter(r115);
        ExpressionSectionPagerAdapter r116 = this.f161461b;
        Function3<Integer, Integer, com.bytedance.android.livesdk.model.h, Unit> r117 = new ExpressionBoard$bindSections$1(this);
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "onSectionChangedListener");
        r116.f161443a.add(r117);
        this.f161461b.h(r107);
        r115.f161428a = new ExpressionBoard$bindSections$2(this);
        if (this.f161469j >= r107.size()) goto L48;
        com.bytedance.android.live.profit.vip.e r118 = yt0.c.l();
        if (r118 == null) goto L46;
        m<Boolean> r119 = r118.isFirstTimeOpenEmoji();
        if (r119 == null) goto L46;
        if (r119.getValue().booleanValue() != true) goto L46;
        com.bytedance.android.live.profit.vip.e r120 = yt0.c.l();
        if (r120 == null) goto L40;
        m<? extends com.bytedance.android.live.profit.vip.h> r121 = r120.getSubscribeInfo();
        if (r121 == null) goto L40;
        com.bytedance.android.live.profit.vip.h r122 = r121.getValue();
        if (r122 == null) goto L40;
        if (r122.f89134b != 1) goto L40;
        int r123 = this.f161471l;
    L41:
        this.f161469j = r123;
        com.bytedance.android.live.profit.vip.e r124 = yt0.c.l();
        if (r124 == null) goto L47;
        m<Boolean> r125 = r124.isFirstTimeOpenEmoji();
        if (r125 == null) goto L47;
        r125.setValue(Boolean.FALSE);
    L47:
        r115.f161430c.add(Integer.valueOf(this.f161469j));
        this.f161461b.f161452j.setCurrentItem(this.f161469j, false);
    L40:
        r123 = 0;
    L46:
        this.f161469j = l42.a.f507335v.getValue().intValue();
        goto L47
    L48:
        r115.f161430c.add(0);
        this.f161461b.f161452j.setCurrentItem(0, false);
    L49:
        post(new b(this));
        com.bytedance.android.live.profit.vip.e r126 = yt0.c.l();
        if (r126 == null) goto L58;
        m<Boolean> r127 = r126.isEmojiPanelShow();
        if (r127 == null) goto L58;
        Observable<Boolean> r128 = r127.a();
        if (r128 == null) goto L58;
        Disposable r129 = r128.subscribe(new c(this, r113));
        if (r129 == null) goto L58;
        RxUtilKt.c(r129, this.f161470k);
    L58:
        com.bytedance.android.live.profit.vip.e r130 = yt0.c.l();
        if (r130 == null) goto L69;
        m<Boolean> r131 = r130.getHasNewSubscribeEmoji();
        if (r131 == null) goto L70;
        Observable<Boolean> r132 = r131.a();
        if (r132 == null) goto L71;
        Disposable r133 = r132.subscribe(new d(this, r113));
        if (r133 == null) goto L72;
        RxUtilKt.c(r133, this.f161470k);
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    }
}
