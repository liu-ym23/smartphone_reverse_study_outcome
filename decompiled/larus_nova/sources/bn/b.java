package bn;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f19696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f19699d;

    public static final class a {
    }

    static {
    }

    public b() {
        super("store_search_input_duration");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f19696a);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("duration", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_FINAL_STATUS, this.f19697b, r101);
        appendParam("author_id", this.f19698c, r101);
        appendParam("source_page", this.f19699d, r101);
    }
}
