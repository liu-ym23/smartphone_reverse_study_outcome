package com.obric.autoaction.app.launcherpage.detail.shortcut.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShortInstructInputUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23533c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23531a, r6.f23531a) == true) goto L12;
        return false;
    L12:
        if (this.f23532b == r6.f23532b) goto L15;
        return false;
    L15:
        if (this.f23533c == r6.f23533c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f23531a.hashCode() * 31) + Boolean.hashCode(this.f23532b)) * 31) + Boolean.hashCode(this.f23533c);
    }

    public String toString() {
        return "ShortInstructNormalizeResult(text=" + this.f23531a + ", hasIllegalChar=" + this.f23532b + ", isOverMaxLength=" + this.f23533c + ')';
    }

    public d(String r2, boolean r3, boolean r4) {
        o.e(r2, "text");
        this.f23531a = r2;
        this.f23532b = r3;
        this.f23533c = r4;
    }

    public final String a() {
        return this.f23531a;
    }

    public final boolean b() {
        return this.f23532b;
    }

    public final boolean c() {
        return this.f23533c;
    }
}
