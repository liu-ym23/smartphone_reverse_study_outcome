package com.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;

/* JADX INFO: compiled from: CronParserField.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.c.b.b f3185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.c.b.a.a f3186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f3187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f3188d;

    /* JADX INFO: renamed from: lambda$JpBAeQf8LhdVOQ-ujjAtorUS8Ag, reason: not valid java name */
    public static /* synthetic */ int m19lambda$JpBAeQf8LhdVOQujjAtorUS8Ag(b r0) {
        return a(r0);
    }

    public b(com.a.c.b.b r2, com.a.c.b.a.a r3) {
        this(r2, r3, false);
    }

    public b(com.a.c.b.b r3, com.a.c.b.a.a r4, boolean r5) {
        this.f3185a = (com.a.c.b.b) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r3, "CronFieldName must not be null"), com.a.c.b.b.class, "com.obric.aiagent.plugin");
        this.f3186b = (com.a.c.b.a.a) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r4, "FieldConstraints must not be null"), com.a.c.b.a.a.class, "com.obric.aiagent.plugin");
        this.f3187c = new c(r4);
        this.f3188d = r5;
    }

    public com.a.c.b.b a() {
        return this.f3185a;
    }

    public final boolean b() {
        return this.f3188d;
    }

    public com.a.c.b.a a(String r5) {
        if (a().equals(com.a.c.b.b.f) == false) goto L10;
        if (r5.endsWith("L") == false) goto L10;
        Integer r1 = this.f3186b.a(r5.substring(0, r5.length() - 1));
        if (r1 == null) goto L10;
        r5 = r1 + "L";
    L10:
        return new com.a.c.b.a(this.f3185a, this.f3187c.a(r5), this.f3186b);
    }

    private static /* synthetic */ int a(b r0) {
        return r0.a().a();
    }

    public static Comparator<b> c() {
        return Comparator.comparingInt($$Lambda$b$JpBAeQf8LhdVOQujjAtorUS8Ag.INSTANCE);
    }

    public String toString() {
        return "CronParserField{field=" + this.f3185a + '}';
    }
}
