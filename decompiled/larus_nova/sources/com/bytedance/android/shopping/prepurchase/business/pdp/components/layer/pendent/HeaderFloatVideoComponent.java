package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import vg3.c0;
import vg3.d0;
import vg3.r;
import vg3.t;
import vg3.w;

/* JADX INFO: loaded from: classes13.dex */
public final class HeaderFloatVideoComponent extends b0 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f181398q = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f181399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v f181400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.o f181401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f181402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f181403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f181404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f181405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f181406p;

    public static final class a implements fj.b {
        public a() {
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.l.class, w.class, t.class, d0.class, vg3.b0.class, c0.class, r.class});
    }

    public final t d2() {
        return (t) N1(t.class);
    }

    public final c0 e2() {
        return (c0) N1(c0.class);
    }

    public HeaderFloatVideoComponent() {
        this.f181399i = true;
        this.f181405o = new a();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        Z1(d0.class, new HeaderFloatVideoComponent$onAttach$1(this, null));
        Z1(vg3.l.class, new HeaderFloatVideoComponent$onAttach$2(this, null));
        Z1(vg3.b0.class, new HeaderFloatVideoComponent$onAttach$3(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        int r100 = ECSdk.f48106a;
        fj.c r101 = (fj.c) ECSdk.a(fj.c.class);
        if (r101 == null) goto L5;
        r101.a(this.f181405o);
    L5:
        vg3.b0 r102 = (vg3.b0) N1(vg3.b0.class);
        if (r102 == null) goto L9;
        r102.S0(null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.HeaderFloatVideoComponent$checkAndShowFloatVideo$$inlined$lets2$lambda$1] */
    public static void c2(final HeaderFloatVideoComponent r100) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r101 = r100.f181401k;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L75;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r104 = r100.f181401k;
        if (r104 == null) goto L33;
        int r105 = com.bytedance.android.shopping.anchorv4.video.p007float.e.f167605a;
        if (r105 != 1) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == true) goto L22;
    L23:
        if (r105 != 1) goto L25;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == false) goto L33;
        if (r104.c() == true) goto L33;
    L32:
        r102 = true;
        goto L33
    L25:
        if (r105 == 2) goto L28;
        r107 = false;
        goto L29
    L22:
        if (r104.c() == true) goto L32;
    L16:
        if (r105 == 3) goto L19;
        r106 = false;
    L33:
        if (r102 == false) goto L76;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r108 = r100.f181401k;
        x73.c r109 = null;
        if (r108 == null) goto L37;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r110 = r108.getVideoModel();
    L38:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r111 = r100.f181401k;
        if (r111 == null) goto L41;
        x73.c r112 = r111.getSharePlayer();
    L42:
        if (r110 == null) goto L77;
        if (r112 == null) goto L78;
        vg3.b0 r113 = (vg3.b0) r100.N1(vg3.b0.class);
        if (r113 == 0) goto L52;
        ?? r114 = new HeaderFloatVideoComponent$checkAndShowFloatVideo$$inlined$lets2$lambda$1(r100);
        LinkedHashMap r115 = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r116 = r100.f181401k;
        if (r116 == null) goto L51;
        Map<String, Object> r117 = r116.d();
        if (r117 == null) goto L51;
        r115.putAll(r117);
    L51:
        Unit r118 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.l r119 = r113.m0(r110, r112, r114, null, r115);
    L53:
        if (r119 == null) goto L55;
        vg3.b0 r120 = (vg3.b0) r100.N1(vg3.b0.class);
        if (r120 == null) goto L64;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.i.a r121 = r120.g1(r119);
    L65:
        r100.f181400j = r121;
        if (r121 == null) goto L68;
        return;
    L68:
        if ((r112 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) == false) goto L71;
        r109 = r112;
    L71:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c r122 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) r109;
        if (r122 == null) goto L82;
        r122.k(true);
        return;
    L82:
        return;
    L64:
        r121 = null;
        goto L65
    L55:
        if ((r112 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) == false) goto L58;
        r109 = r112;
    L58:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c r123 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) r109;
        if (r123 == null) goto L79;
        r123.k(true);
        return;
    L79:
        return;
    L52:
        r119 = null;
        goto L53
    L78:
        return;
    L77:
        return;
    L41:
        r112 = null;
        goto L42
    L37:
        r110 = null;
        goto L38
    L76:
        return;
    L75:
        return;
    L5:
        if (r101.isPlaying() != true) goto L8;
        r103 = true;
        goto L9
    }

    public static final void b2(HeaderFloatVideoComponent r100, boolean r101) {
        r100.getClass();
        w r102 = (w) r100.N1(w.class);
        if (r102 == null) goto L18;
        ProductDetailEventService.b r103 = r102.m();
        if (r103 == null) goto L19;
        LinkedHashMap r104 = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r105 = r100.f181401k;
        if (r105 == null) goto L11;
        Map<String, Object> r106 = r105.d();
        if (r106 == null) goto L11;
        r104.putAll(r106);
    L11:
        if (r101 == false) goto L13;
        String r107 = "close";
    L14:
        r104.put("click_type", r107);
        Unit r108 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r109 = r103.d(r104);
        if (r109 == null) goto L20;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r109, "main_video_window_click", false, null, null, 14);
        return;
    L20:
        return;
    L13:
        r107 = "blank";
        goto L14
    L19:
        return;
    }
}
