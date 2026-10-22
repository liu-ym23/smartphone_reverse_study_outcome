package com.a.c.b;

import com.a.c.b.c.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: CronField.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f3090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f3091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.c.b.a.a f3092c;

    /* JADX INFO: renamed from: lambda$oMuvygNBbXADi2pZj6PNbH-4lFs, reason: not valid java name */
    public static /* synthetic */ int m17lambda$oMuvygNBbXADi2pZj6PNbH4lFs(a r0) {
        return a(r0);
    }

    public a(b r2, e r3, com.a.c.b.a.a r4) {
        this.f3090a = r2;
        this.f3091b = (e) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r3, "FieldExpression must not be null"), e.class, "com.obric.aiagent.plugin");
        this.f3092c = (com.a.c.b.a.a) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r4, "FieldConstraints must not be null"), com.a.c.b.a.a.class, "com.obric.aiagent.plugin");
    }

    public b a() {
        return this.f3090a;
    }

    public e b() {
        return this.f3091b;
    }

    public com.a.c.b.a.a c() {
        return this.f3092c;
    }

    private static /* synthetic */ int a(a r0) {
        return r0.a().a();
    }

    public static Comparator<a> d() {
        return Comparator.comparingInt($$Lambda$a$oMuvygNBbXADi2pZj6PNbH4lFs.INSTANCE);
    }

    public String toString() {
        return "CronField{field=" + this.f3090a + '}';
    }
}
