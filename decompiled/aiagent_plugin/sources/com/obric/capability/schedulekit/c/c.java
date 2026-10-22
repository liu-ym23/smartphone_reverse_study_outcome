package com.obric.capability.schedulekit.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f31906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f31907b;

    static {
        f31906a = new c();
    }

    private c() {
    }

    public final void a(b r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        o.e(r1, "logger");
        f31907b = r1;
    }

    private final b a() {
        b r2 = f31907b;
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (b) ZeusTransformUtils.preCheckCast(a.f31905a, b.class, "com.obric.aiagent.plugin");
    }

    private final String a(String r2) {
        return "ac_" + r2;
    }

    @Override // com.obric.capability.schedulekit.c.b
    public boolean isDebug() {
        return a().isDebug();
    }

    @Override // com.obric.capability.schedulekit.c.b
    public void d(String r2, String r3) {
        o.e(r2, "tag");
        if (isDebug() == true) goto L5;
        return;
    L5:
        a().d(a(r2), r3);
    }

    @Override // com.obric.capability.schedulekit.c.b
    public void i(String r2, String r3) {
        o.e(r2, "tag");
        a().i(a(r2), r3);
    }

    @Override // com.obric.capability.schedulekit.c.b
    public void w(String r2, String r3) {
        o.e(r2, "tag");
        a().w(a(r2), r3);
    }

    @Override // com.obric.capability.schedulekit.c.b
    public void e(String r2, String r3) {
        o.e(r2, "tag");
        a().e(a(r2), r3);
    }
}
