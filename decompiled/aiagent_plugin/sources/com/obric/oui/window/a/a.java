package com.obric.oui.window.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: WindowSizeClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f36852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f36853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f36854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f36855d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(Float.valueOf(this.f36852a), Float.valueOf(r6.f36852a)) == true) goto L12;
        return false;
    L12:
        if (o.a(Float.valueOf(this.f36853b), Float.valueOf(r6.f36853b)) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.hashCode(this.f36852a) * 31) + Float.hashCode(this.f36853b);
    }

    public String toString() {
        return "AvailableWindowSize(width=" + this.f36852a + ", height=" + this.f36853b + ')';
    }

    public a(float r1, float r2) {
        this.f36852a = r1;
        this.f36853b = r2;
        this.f36854c = (int) r1;
        this.f36855d = (int) r2;
    }

    public final float a() {
        return this.f36852a;
    }

    public final int b() {
        return this.f36854c;
    }
}
