package com.obric.oui.indicator;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OBaseIndicator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35365b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f35364a == r6.f35364a) goto L12;
        return false;
    L12:
        if (this.f35365b == r6.f35365b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f35364a) * 31) + Integer.hashCode(this.f35365b);
    }

    public String toString() {
        return "DotSpacingSpec(startMargin=" + this.f35364a + ", endMargin=" + this.f35365b + ')';
    }

    public a(int r1, int r2) {
        this.f35364a = r1;
        this.f35365b = r2;
    }

    public final int a() {
        return this.f35364a;
    }

    public final int b() {
        return this.f35365b;
    }
}
