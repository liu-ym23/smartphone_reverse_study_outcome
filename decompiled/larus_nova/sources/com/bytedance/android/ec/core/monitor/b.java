package com.bytedance.android.ec.core.monitor;

import android.view.Choreographer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f45141a;

    public b(Function0 r100) {
        this.f45141a = r100;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        this.f45141a.invoke();
    }
}
