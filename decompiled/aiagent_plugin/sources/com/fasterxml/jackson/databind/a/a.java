package com.fasterxml.jackson.databind.a;

import com.fasterxml.jackson.databind.e.u;
import com.fasterxml.jackson.databind.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: BaseSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Serializable {
    private static final TimeZone m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k.o f12180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final u f12181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f12182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final y f12183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.a.AbstractC0271a f12184e;
    protected final com.fasterxml.jackson.databind.h.g<?> f;
    protected final com.fasterxml.jackson.databind.h.c g;
    protected final DateFormat h;
    protected final l i;
    protected final Locale j;
    protected final TimeZone k;
    protected final com.fasterxml.jackson.a.a l;

    static {
        m = TimeZone.getTimeZone("UTC");
    }

    public a(u r3, com.fasterxml.jackson.databind.b r4, y r5, com.fasterxml.jackson.databind.k.o r6, com.fasterxml.jackson.databind.h.g<?> r7, DateFormat r8, l r9, Locale r10, TimeZone r11, com.fasterxml.jackson.a.a r12, com.fasterxml.jackson.databind.h.c r13, com.fasterxml.jackson.databind.e.a.AbstractC0271a r14) {
        com.fasterxml.jackson.databind.h.g<?> r15 = (com.fasterxml.jackson.databind.h.g) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.h.g.class, "com.obric.aiagent.plugin");
        this.f12181b = r3;
        this.f12182c = r4;
        this.f12183d = r5;
        this.f12180a = r6;
        this.f = r15;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.g = r13;
        this.f12184e = r14;
    }

    public a a(u r15) {
        if (this.f12181b != r15) goto L6;
        return this;
    L6:
        return new a(r15, this.f12182c, this.f12183d, this.f12180a, this.f, this.h, this.i, this.j, this.k, this.l, this.g, this.f12184e);
    }

    public u a() {
        return this.f12181b;
    }

    public com.fasterxml.jackson.databind.b b() {
        return this.f12182c;
    }

    public y c() {
        return this.f12183d;
    }

    public com.fasterxml.jackson.databind.e.a.AbstractC0271a d() {
        return this.f12184e;
    }

    public com.fasterxml.jackson.databind.k.o e() {
        return this.f12180a;
    }

    public com.fasterxml.jackson.databind.h.g<?> f() {
        return this.f;
    }

    public com.fasterxml.jackson.databind.h.c g() {
        return this.g;
    }

    public DateFormat h() {
        return this.h;
    }

    public l i() {
        return this.i;
    }

    public Locale j() {
        return this.j;
    }

    public TimeZone k() {
        TimeZone r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return m;
    }

    public com.fasterxml.jackson.a.a l() {
        return this.l;
    }
}
