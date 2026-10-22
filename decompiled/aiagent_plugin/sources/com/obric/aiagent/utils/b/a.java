package com.obric.aiagent.utils.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocalMediaMetadataExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22314b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f22313a == r6.f22313a) goto L12;
        return false;
    L12:
        if (this.f22314b == r6.f22314b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f22313a) * 31) + Integer.hashCode(this.f22314b);
    }

    public String toString() {
        return "LocalImageInfo(width=" + this.f22313a + ", height=" + this.f22314b + ')';
    }

    public a(int r1, int r2) {
        this.f22313a = r1;
        this.f22314b = r2;
    }

    public final int a() {
        return this.f22313a;
    }

    public final int b() {
        return this.f22314b;
    }
}
