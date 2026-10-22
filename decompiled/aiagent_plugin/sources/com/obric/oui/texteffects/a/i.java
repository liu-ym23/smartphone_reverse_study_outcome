package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f36405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f36406b;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
        return false;
    L8:
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if (this.f36405a == r10.f36405a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f36406b, r10.f36406b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f36405a) * 31) + this.f36406b.hashCode();
    }

    public String toString() {
        return "Keyframe(timeMs=" + this.f36405a + ", value=" + this.f36406b + ')';
    }

    public i(long r2, g r4) {
        d.h.b.o.e(r4, "value");
        this.f36405a = r2;
        this.f36406b = r4;
    }

    public final long a() {
        return this.f36405a;
    }

    public final g b() {
        return this.f36406b;
    }
}
