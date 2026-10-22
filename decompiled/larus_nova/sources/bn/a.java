package bn;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f19676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f19677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f19678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f19679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f19680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f19681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f19682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f19683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f19684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f19685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f19686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f19687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f19688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f19689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f19690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f19691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f19692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f19693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f19694v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f19695w;

    public a() {
        super("search");
        this.f19683k = "store_page";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f19688p;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r100, r101);
        appendParam(ECFindSimilarConfig.ENTER_FROM_SECOND, this.f19687o, r101);
        appendParam("follow_status", this.f19686n, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f19685m, r101);
        appendParam("author_id", this.f19684l, r101);
        appendParam("source_page", this.f19683k, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SORT_BY, this.f19682j, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, this.f19681i, r101);
        appendParam("is_success", this.f19680h, r101);
        appendParam("search_keyword", this.f19679g, r101);
        appendParam("page_name", this.f19678f, r101);
        appendParam("enter_method", this.f19677e, r101);
        appendParam("impr_id", this.f19676d, r101);
        appendParam("log_pb", this.f19675c, r101);
        appendParam("search_type", this.f19674b, r101);
        appendParam("enter_from", this.f19673a, r101);
        appendParam("group_id", this.f19689q, r101);
        appendParam("sug_type", this.f19690r, r101);
        appendParam("request_id", this.f19691s, r101);
        appendParam("hot_search_method", this.f19692t, r101);
        appendParam("hot_search_icon_type", this.f19693u, r101);
        appendParam("shop_search_enter_method", this.f19694v, r101);
        appendParam("is_empty", this.f19695w, r101);
    }
}
