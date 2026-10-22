package com.obric.oui.texteffects.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: TextEffectFrame.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f36463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f36464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<c> f36465c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if (this.f36463a == r10.f36463a) goto L12;
        return false;
    L12:
        if (this.f36464b == r10.f36464b) goto L15;
        return false;
    L15:
        if (o.a(this.f36465c, r10.f36465c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f36463a) * 31) + Long.hashCode(this.f36464b)) * 31) + this.f36465c.hashCode();
    }

    public String toString() {
        return "TextEffectFrame(playTimeMs=" + this.f36463a + ", normalizedPlayTimeMs=" + this.f36464b + ", layers=" + this.f36465c + ')';
    }

    public d(long r3, long r5, List<c> r7) {
        List<c> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "layers");
        this.f36463a = r3;
        this.f36464b = r5;
        this.f36465c = r8;
    }

    public final List<c> a() {
        return this.f36465c;
    }
}
