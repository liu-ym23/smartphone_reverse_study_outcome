package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TypeKey.java */
/* JADX INFO: loaded from: classes2.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f12998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Class<?> f12999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.k f13000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f13001d;

    public aa() {
    }

    public aa(Class<?> r2, boolean r3) {
        this.f12999b = r2;
        this.f13000c = null;
        this.f13001d = r3;
        if (r3 == false) goto L5;
        int r4 = b(r2);
    L6:
        this.f12998a = r4;
        return;
    L5:
        r4 = a(r2);
        goto L6
    }

    public aa(com.fasterxml.jackson.databind.k r2, boolean r3) {
        this.f13000c = r2;
        this.f12999b = null;
        this.f13001d = r3;
        if (r3 == false) goto L5;
        int r4 = b(r2);
    L6:
        this.f12998a = r4;
        return;
    L5:
        r4 = a(r2);
        goto L6
    }

    public static final int a(Class<?> r0) {
        return r0.getName().hashCode();
    }

    public static final int b(Class<?> r0) {
        return r0.getName().hashCode() + 1;
    }

    public static final int a(com.fasterxml.jackson.databind.k r0) {
        return r0.hashCode() - 1;
    }

    public static final int b(com.fasterxml.jackson.databind.k r0) {
        return r0.hashCode() - 2;
    }

    public boolean a() {
        return this.f13001d;
    }

    public Class<?> b() {
        return this.f12999b;
    }

    public com.fasterxml.jackson.databind.k getType() {
        return this.f13000c;
    }

    public final int hashCode() {
        return this.f12998a;
    }

    public final String toString() {
        if (this.f12999b == null) goto L7;
        return "{class: " + this.f12999b.getName() + ", typed? " + this.f13001d + "}";
    L7:
        return "{type: " + this.f13000c + ", typed? " + this.f13001d + "}";
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5 != this) goto L9;
        return true;
    L9:
        if (r5.getClass() == getClass()) goto L11;
        return false;
    L11:
        aa r6 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.aiagent.plugin");
        if (r6.f13001d != this.f13001d) goto L21;
        Class<?> r2 = this.f12999b;
        if (r2 == null) goto L20;
        if (r6.f12999b == r2) goto L18;
        return false;
    L18:
        return true;
    L20:
        return this.f13000c.equals(r6.f13000c);
    L21:
        return false;
    }
}
