package com.obric.common.oea.foundation.animation.a;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AnimConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.common.oea.foundation.animation.d.b f32296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.common.oea.foundation.animation.d.a f32297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f32298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f32299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f32300e;

    public a() {
        this(null, null, 0.0f, 0.0f, false, 31, null);
    }

    public a(com.obric.common.oea.foundation.animation.d.b r2, com.obric.common.oea.foundation.animation.d.a r3, float r4, float r5, boolean r6) {
        o.e(r2, "runMode");
        o.e(r3, "repeatMode");
        this.f32296a = r2;
        this.f32297b = r3;
        this.f32298c = r4;
        this.f32299d = r5;
        this.f32300e = r6;
    }

    public /* synthetic */ a(com.obric.common.oea.foundation.animation.d.b r4, com.obric.common.oea.foundation.animation.d.a r5, float r6, float r7, boolean r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = com.obric.common.oea.foundation.animation.d.b.f32344a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = com.obric.common.oea.foundation.animation.d.a.f32340a;
    L8:
        com.obric.common.oea.foundation.animation.d.a r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = 1.0f;
    L11:
        float r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = 30.0f;
    L14:
        float r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = false;
    L17:
        com.obric.common.oea.foundation.animation.d.b r12 = r4;
        this(r12, r11, r0, r1, r8);
    }

    public final com.obric.common.oea.foundation.animation.d.b a() {
        return this.f32296a;
    }

    public final com.obric.common.oea.foundation.animation.d.a b() {
        return this.f32297b;
    }

    public final float c() {
        return this.f32298c;
    }

    public final float d() {
        return this.f32299d;
    }

    public final boolean e() {
        return this.f32300e;
    }
}
