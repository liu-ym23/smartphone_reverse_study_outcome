package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class q1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174854a;

    public q1() {
        super("label_group_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_CONTENT_TYPE, "label_group", com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        appendParam("label_group_show_name", this.f174854a);
    }
}
