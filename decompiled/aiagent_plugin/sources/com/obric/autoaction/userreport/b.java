package com.obric.autoaction.userreport;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: UserReportCallbackHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f25172a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d.h.a.a<x> f25173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d.h.a.b<? super Boolean, x> f25174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a.C0604a f25175d;

    static {
        f25172a = new b();
    }

    private b() {
    }

    public final d.h.a.a<x> a() {
        return f25173b;
    }

    public final void a(d.h.a.a<x> r2) {
        f25173b = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void a(d.h.a.b<? super Boolean, x> r2) {
        f25174c = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final d.h.a.b<Boolean, x> b() {
        return f25174c;
    }

    public final void a(a.C0604a r1) {
        f25175d = r1;
    }

    public final a.C0604a c() {
        return f25175d;
    }

    public final void d() {
        f25173b = null;
        f25174c = null;
        f25175d = null;
    }
}
