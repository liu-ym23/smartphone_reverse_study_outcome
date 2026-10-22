package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.m;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.t;
import com.bytedance.android.shopping.anchorv4.voavhs.head.more.AnchorV4LoadMoreRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.q;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b<T extends m> implements j<T>, n, h, fa3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f168510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f168511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function0<Unit>> f168512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<o> f168513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.head.more.c f168514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f168515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f168516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ fa3.b f168517h;

    public static final class a extends com.bytedance.android.ec.core.widget.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b f168518g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ m f168519h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Integer f168520i;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            i r101 = this.f168518g.u(this.f168519h, this.f168520i);
            if (r101 == null) goto L6;
            r101.b(0);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(b r100, m r101, Integer r102) {
            this.f168518g = r100;
            this.f168519h = r101;
            this.f168520i = r102;
            Object[] r103 = 0 == true ? 1 : 0;
            super(null, r103, 3);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.head.base.b$b, reason: collision with other inner class name */
    public static final class C2547b implements com.bytedance.android.ecom.arch.slice.render.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcRenderContext f168521a;

        public C2547b(SlcRenderContext r100) {
            this.f168521a = r100;
        }

        @Override // com.bytedance.android.ecom.arch.slice.render.b
        public final void a(r r100) {
            Intrinsics.checkNotNullParameter(r100, "actionInfo");
            IAction r101 = r100.f49993a;
            View r102 = r100.f49996d;
            int r103 = com.bytedance.android.shopping.anchorv4.event_chain.c.f166550a;
            SlcRenderContext r104 = this.f168521a;
            if ((r104 instanceof SlcContext) == true) goto L5;
            r104 = null;
        L5:
            com.bytedance.android.shopping.anchorv4.event_chain.c.b(null, null, (SlcContext) r104, r101, r102, null);
        }
    }

    @Override // fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f168517h.add(r100);
        return r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public void i(float r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void j() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public boolean n() {
        return false;
    }

    public View w(T r100) {
        return null;
    }

    public void y(T r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeVO");
    }

    public void z(Context r100, View r101, T r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "headNodeVO");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void d() {
        Iterator<T> r100 = this.f168510a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k) r100.next()).d();
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onDestroy() {
        Iterator r100 = ((ArrayList) this.f168510a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k) r100.next()).onDestroy();
        goto L4
    L6:
        this.f168517h.a();
        AnchorV4LoadMoreRecyclerView r101 = com.bytedance.android.shopping.anchorv4.voavhs.head.more.c.f168804f;
        com.bytedance.android.shopping.anchorv4.voavhs.head.more.c.f168804f = null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onPause() {
        Iterator r100 = ((ArrayList) this.f168510a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k) r100.next()).onPause();
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onResume() {
        Iterator r100 = ((ArrayList) this.f168510a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k) r100.next()).onResume();
        goto L4
    }

    public final Context getContext() {
        return this.f168515f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.h
    public final void a(int r100) {
        k r101 = (k) CollectionsKt.getOrNull(this.f168510a, r100);
        if (r101 == null) goto L5;
        r101.c();
    L5:
        o r102 = (o) CollectionsKt.getOrNull(this.f168513d, r100);
        if (r102 == null) goto L8;
        r102.b();
    L8:
        com.bytedance.android.shopping.anchorv4.voavhs.head.more.c r103 = this.f168514e;
        if (r103 == null) goto L17;
        AnchorV4LoadMoreRecyclerView r104 = r103.f168807c;
        if (r104 == null) goto L13;
        r104.scrollToPosition(0);
    L13:
        d r105 = r103.f168809e;
        if (r105 == null) goto L16;
        r105.c(0.0f);
    L16:
        r103.f168806b = 0;
    L17:
        d r106 = this.f168516g;
        if (r106 == null) goto L21;
        r106.b();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void b(boolean r100) {
        Iterator r101 = ((ArrayList) this.f168510a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((k) r101.next()).b(r100);
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final List<ECUrlModel> k(com.bytedance.android.shopping.anchorv4.voavhs.head.c r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeVO");
        List<ECUrlModel> r101 = g(r100).b();
        ArrayList r102 = new ArrayList();
        if (r73.b.b() == true) goto L5;
    L10:
        return r102;
    L5:
        if ((!r101.isEmpty()) == false) goto L10;
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add((ECUrlModel) r103.next());
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final List<ECUrlModel> l(com.bytedance.android.shopping.anchorv4.voavhs.head.c r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeVO");
        List<ECUrlModel> r101 = g(r100).b();
        ArrayList r102 = new ArrayList();
        if ((!r101.isEmpty()) == false) goto L8;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.add((ECUrlModel) r103.next());
    L8:
        return r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public void m(com.bytedance.android.shopping.anchorv4.voavhs.head.c r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeVO");
        Intrinsics.checkNotNullParameter(r100, "nodeVO");
    }

    public b(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f168517h = new fa3.b();
        this.f168515f = r100;
        this.f168516g = r101;
        this.f168510a = new ArrayList();
        this.f168512c = new ArrayList();
        this.f168513d = new ArrayList();
        new ArrayList();
    }

    public static void q(SimpleDraweeView r100, ECUrlModel r110) {
        n1.f45660i.getClass();
        int r101 = n1.a.d();
        if (r110 == null) goto L13;
        r100.setVisibility(0);
        ImageExtensionsKt.D(r100, new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_product_header_image"));
        int r102 = -1;
        if (r110.getWidth() != 0) goto L7;
        int r103 = -1;
    L9:
        if (r110.getWidth() == 0) goto L12;
        r102 = (r101 * r110.getHeight()) / r110.getWidth();
    L12:
        y.c(r100, r110, r103, r102, new z53.a(r110.getUrlList(), ImagePosition.GOODS_HEADER.getValue(), null, false, 28));
        return;
    L7:
        r103 = r101;
        goto L9
    L13:
        r100.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.h
    public final void f(boolean r100, int r101) {
        k r102 = (k) CollectionsKt.getOrNull(this.f168510a, r101);
        if (r102 == null) goto L5;
        r102.e(r100);
    L5:
        o r103 = (o) CollectionsKt.getOrNull(this.f168513d, r101);
        if (r103 == null) goto L9;
        r103.a();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2 h(com.bytedance.android.shopping.anchorv4.voavhs.head.c r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "nodeVO");
        T r100 = g(r110);
        int r101 = this.f168511b;
        this.f168511b = r101 + 1;
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        List<Function0<Unit>> r103 = this.f168512c;
        ArrayList r104 = (ArrayList) r103;
        r104.add(BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$1.INSTANCE);
        y(r100);
        return new BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2(this, r110, r100, r111, r101, r102, this.f168515f, r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final BaseHeadViewHolderBuilder$buildHeadViewHolders$2 o(com.bytedance.android.shopping.anchorv4.voavhs.head.c r110, final int r111) {
        Intrinsics.checkNotNullParameter(r110, "nodeVO");
        T r100 = g(r110);
        int r101 = this.f168511b;
        this.f168511b = r101 + 1;
        View r102 = View.inflate(this.f168515f, R.layout.ec_commerce_layout_anchor_v4_head_background_view, null);
        if (r102 == null) goto L10;
        ViewGroup r103 = (ViewGroup) r102;
        ECDraweeView r104 = (ECDraweeView) r103.findViewById(R.id.anchor_v4_head_background_image);
        s(r103, r110.getType(), r100, Integer.valueOf(r111));
        r(r104, r100.a(), new BaseHeadViewHolderBuilder$buildHeadViewHolders$1(this, r111));
        q((SimpleDraweeView) r103.findViewById(R.id.anchor_v4_head_atmosphere_image), r110.f168530c);
        View r105 = x(r100, Integer.valueOf(r111), r101);
        if (r105 == null) goto L7;
        r103.addView(r105, r103.getChildCount());
    L7:
        t(r103, r110);
        z(this.f168515f, r103, r100, r101);
        return new BaseHeadViewHolderBuilder$buildHeadViewHolders$2(this, r110, r103, r100, r111, this.f168515f, r101);
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void t(ViewGroup r100, com.bytedance.android.shopping.anchorv4.voavhs.head.c r101) {
        d r102 = this.f168516g;
        if (r102 == null) goto L5;
        Object r103 = r102.f();
    L7:
        if ((r103 instanceof SlcRenderContext) == true) goto L9;
        r103 = null;
    L9:
        SlcRenderContext r104 = (SlcRenderContext) r103;
        com.bytedance.android.shopping.anchorv4.voavhs.head.p r105 = r101.I;
        if (r105 == null) goto L14;
        q r106 = r105.b();
        if (r106 == null) goto L14;
        SlcElement r107 = r106.a();
    L15:
        if (r107 == null) goto L28;
        if (r104 == null) goto L29;
        SliceRender r108 = SliceRender.f50121o;
        SlcElement r109 = r101.I.b().a();
        r108.getClass();
        com.bytedance.android.ecom.arch.slice.render.r.f50698d.getClass();
        com.bytedance.android.ecom.arch.slice.render.r r110 = com.bytedance.android.ecom.arch.slice.render.r.a.a(r104, r109, null);
        Map<String, Object> r111 = r101.I.c();
        if (r111 == null) goto L26;
        LinkedHashMap r112 = new LinkedHashMap();
        r112.putAll(r111);
        d r113 = this.f168516g;
        if (r113 == null) goto L24;
        boolean r114 = true;
        if (r113.i() != true) goto L24;
    L25:
        r112.put("special_size", Boolean.valueOf(r114));
        Unit r115 = Unit.INSTANCE;
        r110.a(MapsKt.mapOf(TuplesKt.to("data", r112)), null);
    L24:
        r114 = false;
    L26:
        r110.b(new C2547b(r104));
        View r116 = r110.f50701c;
        r116.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r117 = Unit.INSTANCE;
        r100.addView(r116);
        return;
    L29:
        return;
    L28:
        return;
    L14:
        r107 = null;
        goto L15
    L5:
        r103 = null;
        goto L7
    }

    public i u(T r100, Integer r101) {
        return new c(this.f168516g, r101);
    }

    public List<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f> v(T r110, Function0<? extends View> r111) {
        Intrinsics.checkNotNullParameter(r111, "rootView");
        View r100 = null;
        if (r110 == null) goto L5;
        ECUrlModel r101 = r110.a();
    L6:
        String r102 = null;
        t r103 = null;
        String r104 = null;
        if (r110 == null) goto L9;
        String r105 = r110.getDescription();
    L11:
        return CollectionsKt.listOf(new com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f(r100, r101, r102, r103, r104, r105, false, null, null, 1981));
    L9:
        r105 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public static final void p(b r100, com.bytedance.android.shopping.anchorv4.voavhs.head.c r101, View r102) {
        d r103 = r100.f168516g;
        SlcRenderContext r104 = null;
        if (r103 == null) goto L5;
        Object r105 = r103.f();
    L7:
        if ((r105 instanceof SlcRenderContext) == true) goto L9;
        r105 = null;
    L9:
        SlcRenderContext r106 = (SlcRenderContext) r105;
        com.bytedance.android.shopping.anchorv4.voavhs.head.p r107 = r101.I;
        if (r107 == null) goto L12;
        IAction r108 = r107.a();
    L13:
        if (r108 == null) goto L21;
        if (r102 == null) goto L22;
        int r109 = com.bytedance.android.shopping.anchorv4.event_chain.c.f166550a;
        if ((r106 instanceof SlcContext) == false) goto L19;
        r104 = r106;
    L19:
        com.bytedance.android.shopping.anchorv4.event_chain.c.b(null, null, (SlcContext) r104, r108, r102, null);
        return;
    L22:
        return;
    L21:
        return;
    L12:
        r108 = null;
        goto L13
    L5:
        r105 = null;
        goto L7
    }

    public final void r(ECDraweeView r110, ECUrlModel r111, Function0<Unit> r112) {
        if (r111 == null) goto L9;
        ImageExtensionsKt.D(r110, new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_product_header_image"));
        y.c(r110, r111, -1, -1, new z53.a(r111.getUrlList(), ImagePosition.GOODS_HEADER.getValue(), r112, false, 24));
        d r113 = this.f168516g;
        if (r113 != null) goto L6;
    L8:
        r110.setVisibility(0);
        return;
    L6:
        if (r113.i() != true) goto L8;
        ViewGroup.LayoutParams r114 = r110.getLayoutParams();
        r114.width = -1;
        r114.height = -2;
        Unit r115 = Unit.INSTANCE;
        r110.setLayoutParams(r114);
        r110.setAdjustMode(2);
        goto L8
    L9:
        r110.setVisibility(8);
    }

    public View x(T r100, Integer r101, int r102) {
        return w(r100);
    }

    public final void s(View r100, String r101, T r102, Integer r103) {
        r100.setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(R.color.ec_color_white));
        if ((!Intrinsics.areEqual(r101, HeadViewType.VIDEO.getType())) == false) goto L6;
        r100.setOnClickListener(new a(this, r102, r103));
        return;
    }
}
