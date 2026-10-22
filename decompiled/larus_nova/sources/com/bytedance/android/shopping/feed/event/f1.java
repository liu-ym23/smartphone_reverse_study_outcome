package com.bytedance.android.shopping.feed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class f1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174710c;

    public static final class a {
    }

    static {
    }

    public f1() {
        super("inflow_unused_monitor");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("type", this.f174708a);
        appendParam("class_name", this.f174709b);
        appendParam("comment", null);
        appendParam("extra_log", null);
        appendParam("request_id", this.f174710c);
    }

    public final String getType() {
        return this.f174708a;
    }
}
