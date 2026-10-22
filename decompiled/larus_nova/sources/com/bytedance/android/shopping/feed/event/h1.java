package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class h1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174750a;

    public h1() {
        super("invalid_activity_event");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174750a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PAGE_LOCATION, r100, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
    }
}
