package com.bytedance.android.live.liveinteract.animation.glflymic;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements com.bytedance.android.live.core.gl.primitive.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f71050a;

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "converter");
        this.f71050a = r100;
    }

    @Override // com.bytedance.android.live.core.gl.primitive.b
    public final float[] a(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        return this.f71050a.a(r100[0], r100[1]);
    }

    @Override // com.bytedance.android.live.core.gl.primitive.b
    public final float b(float r100) {
        a r101 = this.f71050a;
        return (r101.f71048e / r101.f71044a) * r100;
    }
}
