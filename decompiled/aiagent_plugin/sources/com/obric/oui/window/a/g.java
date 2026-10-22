package com.obric.oui.window.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: WindowSizeClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f36868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f36869b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f36868a == r6.f36868a) goto L12;
        return false;
    L12:
        if (o.a(this.f36869b, r6.f36869b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f36868a.hashCode() * 31) + this.f36869b.hashCode();
    }

    public String toString() {
        return "WindowSizeWithPageSize(windowSizeClass=" + this.f36868a + ", pageSize=" + this.f36869b + ')';
    }

    public final f a() {
        return this.f36868a;
    }

    public final a b() {
        return this.f36869b;
    }
}
