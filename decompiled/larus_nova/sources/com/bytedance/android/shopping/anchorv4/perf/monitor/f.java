package com.bytedance.android.shopping.anchorv4.perf.monitor;

import android.view.Choreographer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f167239a;

    public f(Function0 r100) {
        this.f167239a = r100;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        this.f167239a.invoke();
    }
}
