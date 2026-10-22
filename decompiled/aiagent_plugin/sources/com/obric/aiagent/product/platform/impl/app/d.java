package com.obric.aiagent.product.platform.impl.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ObricAutoVirtualDisplayRecordSetFramework.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18811d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18808a, r6.f18808a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f18809b, r6.f18809b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f18810c, r6.f18810c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f18811d, r6.f18811d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f18808a.hashCode() * 31) + this.f18809b.hashCode()) * 31) + this.f18810c.hashCode()) * 31) + this.f18811d.hashCode();
    }

    public String toString() {
        return "AutoVirtualDisplayRecordSetApiShape(namespace=" + this.f18808a + ", managerClassName=" + this.f18809b + ", listenerClassName=" + this.f18810c + ", invokerClassName=" + this.f18811d + ')';
    }

    public d(String r2, String r3, String r4, String r5) {
        o.e(r2, "namespace");
        o.e(r3, "managerClassName");
        o.e(r4, "listenerClassName");
        o.e(r5, "invokerClassName");
        this.f18808a = r2;
        this.f18809b = r3;
        this.f18810c = r4;
        this.f18811d = r5;
    }

    public final String a() {
        return this.f18808a;
    }

    public final String b() {
        return this.f18809b;
    }

    public final String c() {
        return this.f18810c;
    }

    public final String d() {
        return this.f18811d;
    }
}
