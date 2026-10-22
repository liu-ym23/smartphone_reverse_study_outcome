package com.a.c.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FieldDefinitionBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.a.c.a.d f3114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.a.c.b.b f3115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.a.c.b.a.b f3116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f3117d;

    public d(com.a.c.a.d r3, com.a.c.b.b r4) {
        this.f3114a = (com.a.c.a.d) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r3, "ParserBuilder must not be null"), com.a.c.a.d.class, "com.obric.aiagent.plugin");
        this.f3115b = (com.a.c.b.b) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r4, "CronFieldName must not be null"), com.a.c.b.b.class, "com.obric.aiagent.plugin");
        this.f3116c = com.a.c.b.a.b.h().a(r4);
    }

    public d f(int r2, int r3) {
        this.f3116c.a(r2, r3);
        return this;
    }

    public d e(int r2, int r3) {
        this.f3116c.b(r2, r3);
        return this;
    }

    public d b() {
        this.f3116c.f();
        return this;
    }

    public d c() {
        this.f3117d = true;
        return this;
    }

    public com.a.c.a.d a() {
        this.f3114a.a(new c(this.f3115b, this.f3116c.g(), this.f3117d));
        return this.f3114a;
    }
}
