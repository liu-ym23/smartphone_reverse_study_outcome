package com.obric.common.oea.foundation.animation.e;

import com.obric.common.oea.foundation.animation.engine.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SpringAnimationHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f32352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f32353b;

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L11;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f32352a, r4.f32352a) == true) goto L9;
        return false;
    L9:
        if (o.a(this.f32353b, r4.f32353b) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        e r0 = this.f32352a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        a r4 = this.f32353b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SpringAnimationHolder(animation=" + this.f32352a + ", config=" + this.f32353b + ")";
    }

    public final void a() {
        this.f32353b.a(this.f32352a);
        this.f32352a.a();
    }
}
