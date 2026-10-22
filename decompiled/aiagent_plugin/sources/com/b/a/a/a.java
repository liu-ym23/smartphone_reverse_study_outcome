package com.b.a.a;

import com.obric.oui.animation.engine.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SpringAnimationHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f3193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.oui.animation.a.a f3194b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f3193a, r6.f3193a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f3194b, r6.f3194b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f3193a.hashCode() * 31) + this.f3194b.hashCode();
    }

    public String toString() {
        return "SpringAnimationHolder(animation=" + this.f3193a + ", config=" + this.f3194b + ')';
    }

    public a(d r2, com.obric.oui.animation.a.a r3) {
        o.e(r2, "animation");
        o.e(r3, "config");
        this.f3193a = r2;
        this.f3194b = r3;
    }

    public final void a() {
        this.f3194b.a(this.f3193a);
        this.f3193a.a();
    }
}
