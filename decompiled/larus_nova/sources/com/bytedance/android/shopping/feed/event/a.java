package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f174593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f174594b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.event.a$a, reason: collision with other inner class name */
    public static final class C2603a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = "1";
        if (this.f174594b == false) goto L5;
        String r101 = "1";
    L6:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r102 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("error_status", r101, r102);
        if (this.f174593a == true) goto L10;
        r100 = "0";
    L10:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, r100, r102);
        return;
    L5:
        r101 = "0";
        goto L6
    }

    public a(boolean r100, boolean r101) {
        super("ec_inner_flow_ad_action_event");
        this.f174593a = r100;
        this.f174594b = r101;
    }
}
