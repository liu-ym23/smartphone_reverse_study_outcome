package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f174825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f174826h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174819a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("author_id", r100, r101);
        appendParam("group_id", this.f174823e, r101);
        appendParam("product_id", this.f174820b, r101);
        appendParam("promotion_id", this.f174821c, r101);
        appendParam("enter_from", this.f174822d, r101);
        appendParam("log_id", this.f174824f, r101);
        Integer r102 = this.f174825g;
        if (r102 == null) goto L5;
        String r103 = String.valueOf(r102.intValue());
    L6:
        appendParam("status_code", r103, r101);
        appendParam("status_msg", this.f174826h, r101);
        appendParam("log_id", this.f174824f, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public m1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
