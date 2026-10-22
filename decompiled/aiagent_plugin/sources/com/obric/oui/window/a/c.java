package com.obric.oui.window.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PageGridConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f36857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f36858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f36859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f36860d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36857a, r6.f36857a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f36858b, r6.f36858b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f36859c, r6.f36859c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f36860d, r6.f36860d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f36857a.hashCode() * 31) + this.f36858b.hashCode()) * 31) + this.f36859c.hashCode()) * 31) + this.f36860d.hashCode();
    }

    public String toString() {
        return "PageGridConfig(gridMode=" + this.f36857a + ", pageColumns=" + this.f36858b + ", pageGutter=" + this.f36859c + ", pageMargin=" + this.f36860d + ')';
    }

    public c(String r2, b r3, d r4, e r5) {
        o.e(r2, "gridMode");
        o.e(r3, "pageColumns");
        o.e(r4, "pageGutter");
        o.e(r5, "pageMargin");
        this.f36857a = r2;
        this.f36858b = r3;
        this.f36859c = r4;
        this.f36860d = r5;
    }

    public final b a() {
        return this.f36858b;
    }

    public final d b() {
        return this.f36859c;
    }

    public final e c() {
        return this.f36860d;
    }
}
