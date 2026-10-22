package com.bytedance.android.ec.common.impl.sku.utils;

import android.view.Choreographer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f43365a;

    public o(f r100) {
        this.f43365a = r100;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        f r101 = this.f43365a;
        int r102 = r101.f43354a + 1;
        r101.f43354a = r102;
        if (r102 < r101.f43355b) goto L5;
        r101.f43356c.run();
        return;
    L5:
        int r103 = p.f43366a;
        Intrinsics.checkNotNullParameter(r101, "runner");
        Choreographer.getInstance().postFrameCallback(new o(r101));
    }
}
