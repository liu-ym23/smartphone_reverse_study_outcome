package com.obric.memorydata.sdk.screencapture;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScreenCaptureManager.kt */
/* JADX INFO: loaded from: classes4.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScreenEventReaction f33854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f33855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f33856c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f33854a, r10.f33854a) == true) goto L12;
        return false;
    L12:
        if (this.f33855b == r10.f33855b) goto L15;
        return false;
    L15:
        if (o.a(this.f33856c, r10.f33856c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f33854a.hashCode() * 31) + Long.hashCode(this.f33855b)) * 31) + this.f33856c.hashCode();
    }

    public String toString() {
        return "PendingOperation(screenEventReaction=" + this.f33854a + ", timeout=" + this.f33855b + ", callback=" + this.f33856c + ')';
    }

    public d(ScreenEventReaction r3, long r4, b r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        o.e(r3, "screenEventReaction");
        o.e(r7, "callback");
        this.f33854a = r3;
        this.f33855b = r4;
        this.f33856c = r7;
    }

    public final ScreenEventReaction a() {
        return this.f33854a;
    }

    public final long b() {
        return this.f33855b;
    }

    public final b c() {
        return this.f33856c;
    }
}
