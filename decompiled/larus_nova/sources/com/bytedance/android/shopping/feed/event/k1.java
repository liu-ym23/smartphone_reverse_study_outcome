package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class k1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f174788d;

    public static final class a {
    }

    static {
    }

    public k1() {
        super("product_slide_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174785a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f174786b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SLIDE_TYPE, this.f174787c, r101);
        Integer r102 = this.f174788d;
        if (r102 == null) goto L5;
        String r103 = String.valueOf(r102.intValue());
    L6:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST_SLIDE, r103, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
