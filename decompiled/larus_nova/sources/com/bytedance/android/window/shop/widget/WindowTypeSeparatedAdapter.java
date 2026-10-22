package com.bytedance.android.window.shop.widget;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.window.shop.eventcard.windowability.WindowAnchorAbility;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.holder.footer.WindowFooterHolder;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.g0;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.repository.tab.entity.m0;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00040\u00012\u00020\u00052\u00020\u0006:\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowTypeSeparatedAdapter;", "Lcom/bytedance/android/window/shop/widget/WindowRecyclerViewWithHeaderAndFooterAdapterV2;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "Lcom/bytedance/android/window/shop/holder/ShopWindowHolder;", "Lfq3/b;", "Landroidx/lifecycle/LifecycleEventObserver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTypeSeparatedAdapter extends WindowRecyclerViewWithHeaderAndFooterAdapterV2<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> implements fq3.b, LifecycleEventObserver {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final fo.a<WindowLayoutType> f189945t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final fo.a<Boolean> f189946u = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Runnable> f189947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.window.shop.widget.holderprocessor.c f189948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gr3.e f189949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final gr3.e f189950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WindowLayoutType f189951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.android.window.shop.repository.tab.entity.f> f189952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap<Integer, com.bytedance.android.window.shop.repository.tab.entity.f> f189953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WindowFooterHolder f189954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final fo.b f189955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f189956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FooterStatus f189957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<ECLynxCardEvent, j> f189958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Fragment f189959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<Integer> f189960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function1<Integer, Unit> f189961q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function0<Unit> f189962r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f189963s;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowTypeSeparatedAdapter f189964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WindowAnchorAbility f189965b;

        public b(WindowTypeSeparatedAdapter r100, WindowAnchorAbility r101) {
            this.f189964a = r100;
            this.f189965b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f189964a.B2(this.f189965b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowTypeSeparatedAdapter f189966a;

        public c(WindowTypeSeparatedAdapter r100) {
            this.f189966a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r100 = this.f189966a.f189956l;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.invalidateItemDecorations();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        f189945t = new fo.a("discover_product_tab_layout", new WindowLayoutType[0]);
        new fo.a("show_coupon_skeleton", new Boolean[0]);
        f189946u = new fo.a("show_sort_skeleton", new Boolean[0]);
    }

    public final void A2() {
        Iterator r100 = ((ArrayList) this.f189952h).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r101).f189560i != 2508) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.android.window.shop.repository.tab.entity.f r103 = (com.bytedance.android.window.shop.repository.tab.entity.f) r101;
        if (r103 != null) goto L15;
        return;
    L15:
        int r104 = ((ArrayList) this.f189952h).indexOf(r103);
        if ((-1) != r104) goto L18;
        return;
    L18:
        ListProtector.remove(this.f189952h, r104);
        notifyItemRemoved(r104);
        return;
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final void H2() {
        int r100 = ((ArrayList) this.f189952h).size();
        Iterator r101 = ((ArrayList) this.f189952h).iterator();
        int r102 = 0;
    L3:
        int r103 = -1;
        if (r101.hasNext() == false) goto L9;
        if ((((com.bytedance.android.window.shop.repository.tab.entity.f) r101.next()) instanceof e0) == true) goto L10;
        r102 = r102 + 1;
    L10:
        if ((-1) != r102) goto L19;
        Iterator r104 = ((ArrayList) this.f189952h).iterator();
        int r105 = 0;
    L13:
        if (r104.hasNext() == false) goto L18;
        if ((((com.bytedance.android.window.shop.repository.tab.entity.f) r104.next()) instanceof i0) == true) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        r103 = r105;
    L18:
        r102 = r103;
    L19:
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r106 = this.f189952h;
        ArrayList r107 = new ArrayList();
        Iterator r108 = ((ArrayList) r106).iterator();
        int r109 = 0;
    L21:
        if (r108.hasNext() == false) goto L32;
        Object r110 = r108.next();
        int r111 = r109 + 1;
        if (r109 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        com.bytedance.android.window.shop.repository.tab.entity.f r112 = (com.bytedance.android.window.shop.repository.tab.entity.f) r110;
        if (r109 > r102) goto L28;
        boolean r113 = true;
    L29:
        if (r113 == false) goto L31;
        r107.add(r110);
    L31:
        r109 = r111;
        goto L21
    L28:
        r113 = false;
        goto L29
    L32:
        ((ArrayList) this.f189952h).clear();
        ((ArrayList) this.f189952h).addAll(r107);
        notifyItemRangeRemoved(((ArrayList) this.f189952h).size(), r100 - ((ArrayList) this.f189952h).size());
        return;
    L9:
        r102 = -1;
        goto L10
    }

    @Override // fq3.b
    public final void clear() {
        ((ArrayList) this.f189952h).clear();
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final int getBasicItemCount() {
        return ((ArrayList) this.f189952h).size();
    }

    public final void B2(WindowAnchorAbility r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorAbility");
        if (this.f189959o.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) >= 0) goto L7;
        ((ArrayList) this.f189947c).add(new b(this, r100));
        return;
    L7:
        if ((!StringsKt.isBlank(r100.f187809a)) == false) goto L16;
        Iterator r101 = ((ArrayList) this.f189952h).iterator();
        int r102 = 0;
    L10:
        if (r101.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(com.bytedance.android.window.shop.repository.tab.entity.s.a((com.bytedance.android.window.shop.repository.tab.entity.f) r101.next()), r100.f187809a) == true) goto L17;
        r102 = r102 + 1;
    L17:
        int r103 = ((ArrayList) this.f189952h).size();
        if (r102 < 0) goto L49;
        if (r103 <= r102) goto L51;
        int r104 = w.f190127a[r100.f187811c.ordinal()];
        if (r104 != 1) goto L24;
        C2(r102, r100.f187812d);
    L43:
        RecyclerView r105 = this.f189956l;
        if (r105 == null) goto L50;
        r105.post(new c(this));
        return;
    L50:
        return;
    L24:
        if (r104 != 2) goto L26;
        C2(r102 + 1, r100.f187812d);
        goto L43
    L26:
        if (r104 == 3) goto L38;
        if (r104 != 4) goto L43;
        if (r100.f187812d.isEmpty() == false) goto L33;
        return;
    L33:
        List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r106 = CollectionsKt.toMutableList(r100.f187812d);
        com.bytedance.android.window.shop.repository.tab.entity.n r107 = new com.bytedance.android.window.shop.repository.tab.entity.n((com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.remove(r106, 0), (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.f189952h, r102));
        com.bytedance.android.window.shop.repository.tab.entity.f r108 = (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.f189952h, r102);
        if ((true ^ r106.isEmpty()) == false) goto L36;
        C2(r102, r106);
    L36:
        z2(r108, CollectionsKt.listOf(r107));
        goto L43
    L38:
        if (r100.f187812d.isEmpty() == false) goto L40;
        return;
    L40:
        List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r109 = CollectionsKt.toMutableList(r100.f187812d);
        ListProtector.add(r109, 0, new com.bytedance.android.window.shop.repository.tab.entity.n((com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.f189952h, r102), (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.remove(r109, 0)));
        z2((com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.f189952h, r102), r109);
        goto L43
    L51:
        return;
    L49:
        return;
    L15:
        r102 = -1;
        goto L17
    L16:
        r102 = r100.f187810b;
        goto L17
    }

    public final synchronized void D2(List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "list");     // Catch: Throwable -> L6
        C2(((ArrayList) this.f189952h).size(), r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void E2(FooterStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "footerStatus");
        this.f189957m = r100;
        WindowFooterHolder r101 = this.f189954j;
        if (r101 == null) goto L6;
        r101.u4(r100);
        return;
    }

    public final void F2(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        Iterator r101 = ((ArrayList) this.f189952h).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r102).f189560i != 2508) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L13:
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r102) == null) goto L15;
        return;
    L15:
        ((ArrayList) this.f189952h).add(r100);
        notifyItemChanged(((ArrayList) this.f189952h).size() - 1);
        return;
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L13
    }

    public final void G2(WindowLayoutType r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100 == this.f189951g) goto L9;
        this.f189951g = r100;
        fo.b r101 = this.f189955k;
        fo.a<WindowLayoutType> r102 = WindowConstDef.f188713a;
        r101.b(WindowConstDef.f188713a, r100);
        r101.b(f189945t, this.f189951g);
        return;
    }

    @Override // fq3.b
    public final void add(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ArrayList r101 = (ArrayList) this.f189952h;
        r101.add((com.bytedance.android.window.shop.repository.tab.entity.f) r100);
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final int getBasicItemViewType(int r100) {
        com.bytedance.android.window.shop.repository.tab.entity.f r101 = (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.f189952h, r100);
        WindowLayoutType r102 = this.f189951g;
        if (r102 != null) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r101, "$this$markAsFullSpan");
        r101.f189557f.d(m0.f189602d, Boolean.TRUE);
    L8:
        IntRange r103 = gr3.f.f482355a;
        Intrinsics.checkNotNullParameter(r101, "vo");
        String r104 = r101.f189554c;
        boolean r105 = false;
        if (r104 == null) goto L14;
        gr3.f.a r106 = gr3.f.f482356b;
        int r107 = r101.f189560i;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r104, "uniqueId");
        String r108 = r104 + r107;
        Integer r109 = r106.f482359a.get(r108);
        if (r109 == null) goto L13;
        int r110 = r109.intValue();
    L19:
        Intrinsics.checkNotNullParameter(r101, "$this$isFullSpan");
        Boolean r111 = (Boolean) r101.f189557f.a(m0.f189602d);
        if (r111 == null) goto L22;
        r105 = r111.booleanValue();
    L22:
        if (r105 == false) goto L24;
        int r112 = com.bytedance.android.window.shop.b.f187760a;
        return 1073741824 | r110;
    L24:
        int r113 = com.bytedance.android.window.shop.b.f187760a;
        return (-1073741825) & r110;
    L13:
        int r114 = r106.f482363e.getAndIncrement();
        r106.f482359a.put(r108, Integer.valueOf(r114));
        r106.f482362d.put(Integer.valueOf(r114), Integer.valueOf(r107));
        r110 = r114;
        goto L19
    L14:
        gr3.f.a r115 = gr3.f.f482356b;
        int r116 = r101.f189560i;
        Intrinsics.checkNotNullParameter(r101, "$this$isFullSpan");
        Boolean r117 = (Boolean) r101.f189557f.a(m0.f189602d);
        if (r117 == null) goto L17;
        boolean r118 = r117.booleanValue();
    L18:
        r110 = r115.a(r116, r118);
        goto L19
    L17:
        r118 = false;
        goto L18
    L5:
        if (r102.isDoubleColumn() != true) goto L7;
        Intrinsics.checkNotNullParameter(r101, "$this$cancelFullSpan");
        r101.f189557f.d(m0.f189602d, Boolean.FALSE);
        goto L8
    }

    @Override // fq3.b
    public final Object getItem(int r100) {
        return ListProtector.get(this.f189952h, r100);
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f189956l = r100;
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        ShopWindowItemHolder r101 = (ShopWindowItemHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        com.bytedance.android.window.shop.repository.tab.entity.j r102 = com.bytedance.android.window.shop.repository.tab.entity.j.f189580j;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "vo");
        r101.q4(r102);
        FooterStatus r103 = this.f189957m;
        if (r103 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof WindowFooterHolder) == true) goto L7;
        r101 = null;
    L7:
        WindowFooterHolder r104 = (WindowFooterHolder) r101;
        if (r104 == null) goto L12;
        r104.u4(r103);
        return;
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        WindowFooterHolder r101 = new WindowFooterHolder(r100.getContext());
        this.f189954j = r101;
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f189956l = null;
        super.onDetachedFromRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        ShopWindowItemHolder r101 = (ShopWindowItemHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        r101.t4();
    }

    @Override // fq3.b
    public final void remove(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r101 = this.f189952h;
        if (r101 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r101).remove(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final boolean y2(RecyclerView.ViewHolder r100) {
        ShopWindowItemHolder r101 = (ShopWindowItemHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        return r101.s4();
    }

    public final void C2(int r100, List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L15;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        com.bytedance.android.window.shop.repository.tab.entity.f r107 = (com.bytedance.android.window.shop.repository.tab.entity.f) r105;
        List<Integer> r108 = this.f189960p;
        int r109 = com.bytedance.android.window.shop.b.f187760a;
        if (r108.contains(Integer.valueOf(r107.f189560i & (-1073741825))) == false) goto L13;
        this.f189953i.put(Integer.valueOf(r104 + r100), r107);
    L14:
        r104 = r106;
        goto L6
    L13:
        r102.add(r107);
        goto L14
    L15:
        ((ArrayList) this.f189952h).addAll(r100, r102);
        if (r100 != 0) goto L18;
        notifyItemRangeChanged(r100, ((ArrayList) this.f189952h).size());
        return;
    L18:
        notifyItemRangeInserted(r100, r102.size());
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r102 = (ShopWindowItemHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        com.bytedance.android.window.shop.repository.tab.entity.f r103 = (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.f189952h, r101);
        this.f189950f.a(r102, r103, r101);
        Intrinsics.checkNotNullParameter(r103, "vo");
        r102.q4(r103);
        this.f189949e.a(r102, r103, r101);
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = com.bytedance.android.window.shop.b.f187760a;
        int r103 = (r101 & (-1073741825)) & (-1073741825);
        Integer r104 = gr3.f.f482356b.f482362d.get(Integer.valueOf(r103));
        if (r104 == null) goto L5;
        r103 = r104.intValue();
    L5:
        int r105 = r103 & (-1073741825);
        if (com.bytedance.android.window.shop.holder.factory.c.f187946d.contains((-1073741825) & r105) == false) goto L9;
        int r106 = com.bytedance.android.window.shop.holder.factory.b.f187942a;
        return com.bytedance.android.window.shop.holder.factory.b.a(this.f189959o, r105, this.f189955k, new WindowTypeSeparatedAdapter$onCreateBasicViewHolder$holder$1(this));
    L9:
        if (com.bytedance.android.window.shop.repository.tab.datasource.mapping.g.a(r105) == false) goto L11;
        int r107 = com.bytedance.android.window.shop.holder.factory.h.f187962a;
        Fragment r108 = this.f189959o;
        boolean r109 = this.f189963s;
        WindowTypeSeparatedAdapter$onCreateBasicViewHolder$holder$2 r110 = new WindowTypeSeparatedAdapter$onCreateBasicViewHolder$holder$2(this);
        Intrinsics.checkNotNullParameter(r108, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r110, "callback");
        return new WindowLynxHolder(r108, r110, r109);
    L11:
        ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r111 = com.bytedance.android.window.shop.holder.factory.i.f187964b.a(r105, this.f189959o, this.f189955k);
        if ((r111 instanceof WindowHotsaleLoadMoreHolder) == false) goto L17;
        x r112 = new x(this, r111);
        ((WindowHotsaleLoadMoreHolder) r111).f187862v = r112;
        return r111;
    L17:
        return r111;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L11;
        Iterator<T> r102 = this.f189947c.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((Runnable) r102.next()).run();
        goto L6
    L8:
        ((ArrayList) this.f189947c).clear();
        return;
    }

    public final void z2(com.bytedance.android.window.shop.repository.tab.entity.f r100, List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r101) {
        Intrinsics.checkNotNullParameter(r100, "targetVO");
        Intrinsics.checkNotNullParameter(r101, "list");
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        int r102 = ((ArrayList) this.f189952h).indexOf(r100);
        if (r102 >= 0) goto L8;
        return;
    L8:
        ListProtector.set(this.f189952h, r102, ListProtector.get(r101, 0));
        if (r101.size() <= 1) goto L11;
        C2(r102 + 1, CollectionsKt.drop(r101, 1));
    L11:
        notifyItemChanged(r102);
    }

    public /* synthetic */ WindowTypeSeparatedAdapter(Fragment r100, List r101, Function1 r102, Function0 r110) {
        this(r100, r101, r102, r110, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowTypeSeparatedAdapter(Fragment r100, List<Integer> r101, Function1<? super Integer, Unit> r102, Function0<Unit> r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "dataBufferItemTypes");
        Intrinsics.checkNotNullParameter(r102, "bindCallback");
        Intrinsics.checkNotNullParameter(r103, "playTriggerCallback");
        this.f189959o = r100;
        this.f189960p = r101;
        this.f189961q = r102;
        this.f189962r = r103;
        this.f189963s = r104;
        r100.getLifecycle().addObserver(this);
        this.f189947c = new ArrayList();
        com.bytedance.android.window.shop.widget.holderprocessor.c r105 = new com.bytedance.android.window.shop.widget.holderprocessor.c();
        this.f189948d = r105;
        gr3.e r106 = new gr3.e();
        gr3.d[] r107 = {new z(this), new com.bytedance.android.window.shop.widget.holderprocessor.i(), new com.bytedance.android.window.shop.widget.holderprocessor.f(new WindowTypeSeparatedAdapter$preparePostProcessors$1(this), r103), r105.f190028d};
        Intrinsics.checkNotNullParameter(r107, "processors");
        CollectionsKt.addAll(r106.f482354a, r107);
        Unit r108 = Unit.INSTANCE;
        this.f189949e = r106;
        gr3.e r109 = new gr3.e();
        gr3.d[] r110 = {r105.f190027c, new com.bytedance.android.window.shop.widget.holderprocessor.e(new WindowTypeSeparatedAdapter$preparePreProcessors$1(this), new WindowTypeSeparatedAdapter$preparePreProcessors$2(this)), new com.bytedance.android.window.shop.widget.holderprocessor.b()};
        Intrinsics.checkNotNullParameter(r110, "processors");
        CollectionsKt.addAll(r109.f482354a, r110);
        this.f189950f = r109;
        this.f189951g = WindowLayoutType.DOUBLECOLUMN;
        this.f189952h = new ArrayList();
        this.f189953i = new LinkedHashMap();
        fo.b r111 = new fo.b();
        r111.b(WindowConstDef.f188713a, this.f189951g);
        r111.b(f189945t, this.f189951g);
        this.f189955k = r111;
        int r112 = i.f190048a;
        FallbackStrategy r113 = FallbackStrategy.REPLACE;
        WindowTypeSeparatedAdapter$removeExecutor$1 r114 = new WindowTypeSeparatedAdapter$removeExecutor$1(this);
        WindowTypeSeparatedAdapter$removeExecutor$2 r115 = WindowTypeSeparatedAdapter$removeExecutor$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r113, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        int r116 = h.f190016a[r113.ordinal()];
        if (r116 == 1) goto L8;
        if (r116 != 2) goto L7;
        Intrinsics.checkNotNull(r114);
        Object r117 = new f(r114);
    L9:
        this.f189958n = MapsKt.mapOf(new Pair[]{TuplesKt.to(ECLynxCardEvent.FAILED, r117), TuplesKt.to(ECLynxCardEvent.TIMEOUT, r117)});
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        Intrinsics.checkNotNull(r115);
        r117 = new g(r115);
        goto L9
    }
}
