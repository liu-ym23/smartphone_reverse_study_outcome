package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements uc3.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f173200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f173201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f173202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f173203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f173204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f173205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f173206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f173207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f173208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f173209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f173210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f173211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f173212m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f173213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f173214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f173215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f173216q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f173217r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f173218s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f173219t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f173220u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f173221v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f173222w;

    public static final class a {
    }

    static {
    }

    public j() {
    }

    @Override // uc3.f
    public final Map<String, Object> a() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(TabkitFirstFramePref.T_PAGE_ROUTE_START, 0L), TuplesKt.to("t_request_start_pack", 0L), TuplesKt.to("t_request_end_pack", Long.valueOf(this.f173200a)), TuplesKt.to("t_request_start_feed", 0L), TuplesKt.to("t_request_end_feed", Long.valueOf(this.f173201b)), TuplesKt.to("t_page_cache_show", Long.valueOf(this.f173202c)), TuplesKt.to("t_first_card_show", Long.valueOf(this.f173203d)), TuplesKt.to("t_page_show", Long.valueOf(this.f173204e)), TuplesKt.to("slc_cache_card_draw_end", Long.valueOf(this.f173205f)), TuplesKt.to("slc_first_card_draw_end", Long.valueOf(this.f173206g)), TuplesKt.to("slc_second_card_draw_end", Long.valueOf(this.f173207h)), TuplesKt.to("schema_cache_hit", 0), TuplesKt.to("slc_cache_card_bind_end", Long.valueOf(this.f173208i)), TuplesKt.to("slc_first_card_bind_end", Long.valueOf(this.f173209j)), TuplesKt.to("slc_second_card_bind_end", Long.valueOf(this.f173210k)), TuplesKt.to("cache_card_bind_start", Long.valueOf(this.f173211l)), TuplesKt.to("first_card_bind_start", Long.valueOf(this.f173212m)), TuplesKt.to("second_card_bind_start", Long.valueOf(this.f173213n)), TuplesKt.to("activity_code_root", Integer.valueOf(this.f173214o)), TuplesKt.to("fragment_pre_inflate_enabled", Integer.valueOf(this.f173215p)), TuplesKt.to("fragment_pre_inflate_has_cache_entry", Integer.valueOf(this.f173216q)), TuplesKt.to("fragment_pre_inflate_hit", Integer.valueOf(this.f173217r)), TuplesKt.to("fragment_pre_inflate_request_time", Long.valueOf(this.f173218s)), TuplesKt.to("fragment_pre_inflate_end_time", Long.valueOf(this.f173219t)), TuplesKt.to("fragment_pre_inflate_consume_time", Long.valueOf(this.f173220u)), TuplesKt.to("fragment_pre_inflate_cost", Long.valueOf(this.f173221v)), TuplesKt.to("fragment_pre_inflate_wait_time", Long.valueOf(this.f173222w))});
    }

    @Override // uc3.f
    public final void b(long r100) {
        this.f173205f = r100;
    }

    @Override // uc3.f
    public final void c(long r100) {
        this.f173204e = r100;
    }

    @Override // uc3.f
    public final void d(long r100) {
        this.f173210k = r100;
    }

    @Override // uc3.f
    public final void e(long r100) {
        this.f173208i = r100;
    }

    @Override // uc3.f
    public final void f(long r100) {
        this.f173203d = r100;
    }

    @Override // uc3.f
    public final void g(long r100) {
        this.f173207h = r100;
    }

    @Override // uc3.f
    public final void h(long r100) {
        this.f173206g = r100;
    }

    @Override // uc3.f
    public final void i(long r100) {
        this.f173209j = r100;
    }

    @Override // uc3.f
    public final void j(long r100) {
        this.f173200a = r100;
    }

    @Override // uc3.f
    public final void k(long r100) {
        this.f173202c = r100;
    }

    public final void l(boolean r100, boolean r101, boolean r102, long r103, long r104, long r105) {
        this.f173215p = r100 ? 1 : 0;
        this.f173216q = r101 ? 1 : 0;
        this.f173217r = r102 ? 1 : 0;
        this.f173218s = r103;
        this.f173219t = r104;
        this.f173220u = r105;
        long r106 = 0;
        if (r103 > 0) goto L5;
    L7:
        long r107 = 0;
    L8:
        this.f173221v = r107;
        if (r103 > 0) goto L11;
    L13:
        this.f173222w = r106;
        return;
    L11:
        if (r105 <= 0) goto L13;
        r106 = r105 - r103;
        goto L13
    L5:
        if (r104 <= 0) goto L7;
        r107 = r104 - r103;
        goto L8
    }
}
