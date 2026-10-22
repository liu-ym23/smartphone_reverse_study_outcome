package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: BannerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends RecyclerView.a<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.oui.banner.b.a f34022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, f> f34023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<f> f34024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.oui.banner.a.g f34025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.obric.oui.banner.b.b f34026e;
    private WeakHashMap<d, x> f;
    private List<? extends b> g;
    private boolean h;

    public static /* synthetic */ void lambda$_rhqbnG5TophON2Iwz50JLX__H0(a r0, View r1) {
        a(r0, r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void b(RecyclerView.u r3) {
        a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void c(RecyclerView.u r3) {
        b((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void d(RecyclerView.u r3) {
        c((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
    }

    public a(com.obric.oui.banner.b.a r3) {
        com.obric.oui.banner.b.a r4 = (com.obric.oui.banner.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "bannerOperator");
        this.f34022a = r4;
        this.f34023b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f34024c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.f = new WeakHashMap();
        this.g = p.b();
        this.h = true;
        a((f) ZeusTransformUtils.preCheckCast(i.r, f.class, "com.obric.aiagent.plugin"));
    }

    public final void a(List<? extends b> r3) {
        List<? extends b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "value");
        this.g = r4;
        d();
    }

    public final void b(boolean r1) {
        this.h = r1;
    }

    public final boolean g() {
        return this.h;
    }

    public final void a(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        o.e(r4, "factory");
        this.f34023b.put(r4.a(), r4);
        this.f34024c.add(r4);
    }

    public final int h() {
        return this.g.size();
    }

    public final void a(com.obric.oui.banner.b.b r3) {
        com.obric.oui.banner.b.b r4 = (com.obric.oui.banner.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "onBannerClickListener");
        this.f34026e = r4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        if (this.h == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return this.g.size();
    }

    public d c(ViewGroup r3, int r4) {
        o.e(r3, "parent");
        if (this.f34024c.isEmpty() == true) goto L7;
        d r5 = ((f) ZeusTransformUtils.preCheckCast(this.f34024c.get(r4), f.class, "com.obric.aiagent.plugin")).a(r3);
        r5.a(this.f34022a);
        return r5;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public void a(d r5, int r6) {
        o.e(r5, "holder");
        int r7 = com.obric.oui.banner.c.a.f34047a.a(this.h, r6, h());
        if (this.g.isEmpty() == false) goto L6;
        r5.a(r7, (b) ZeusTransformUtils.preCheckCast(new h(), b.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.g.get(r7), b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, e.class) == false) goto L9;
        ((e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.aiagent.plugin")).a(this.f34025d);
    L9:
        r5.a(r7, r0);
        r5.f2390a.setTag(ZeusTransformUtils.mapRes(R.id.banner_pos_key, DbHelper.COL_ID, "banner_pos_key"), Integer.valueOf(r7));
        if (r5.f2390a.hasOnClickListeners() == true) goto L13;
        r5.f2390a.setOnClickListener(new $$Lambda$a$_rhqbnG5TophON2Iwz50JLX__H0(this));
        return;
    }

    private static final void a(a r3, View r4) {
        o.e(r3, "this$0");
        Object r5 = r4.getTag(ZeusTransformUtils.mapRes(R.id.banner_pos_key, DbHelper.COL_ID, "banner_pos_key"));
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        com.obric.oui.banner.b.b r0 = r3.f34026e;
        if (r0 == null) goto L7;
        r0.a((b) ZeusTransformUtils.preCheckCast(r3.g.get(r6), b.class, "com.obric.aiagent.plugin"), r6);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a(int r4) {
        if (this.f34024c.isEmpty() == true) goto L11;
        if (this.g.isEmpty() == false) goto L7;
        String r5 = i.r.a();
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(this.f34023b.get(r5), f.class, "com.obric.aiagent.plugin");
        return p.a(this.f34024c, r6);
    L7:
        List<? extends b> r0 = this.g;
        r5 = ((b) ZeusTransformUtils.preCheckCast(r0.get(r4 % r0.size()), b.class, "com.obric.aiagent.plugin")).b();
        goto L8
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public void a(d r3) {
        o.e(r3, "holder");
        super.b((RecyclerView.u) ZeusTransformUtils.preCheckCast(r3, RecyclerView.u.class, "com.obric.aiagent.plugin"));
        r3.F();
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r3, x.f38692a);
    }

    public void b(d r3) {
        o.e(r3, "holder");
        super.c((RecyclerView.u) ZeusTransformUtils.preCheckCast(r3, RecyclerView.u.class, "com.obric.aiagent.plugin"));
        r3.G();
        this.f.remove(r3);
    }

    public void c(d r3) {
        o.e(r3, "holder");
        super.d((RecyclerView.u) ZeusTransformUtils.preCheckCast(r3, RecyclerView.u.class, "com.obric.aiagent.plugin"));
        r3.J();
    }

    public final void i() {
        Iterator r3 = ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((d) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), d.class, "com.obric.aiagent.plugin")).G();
        goto L4
    }

    public final void a(com.obric.oui.banner.a.g r3) {
        com.obric.oui.banner.a.g r4 = (com.obric.oui.banner.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.a.g.class, "com.obric.aiagent.plugin");
        o.e(r4, "config");
        this.f34025d = r4;
    }
}
