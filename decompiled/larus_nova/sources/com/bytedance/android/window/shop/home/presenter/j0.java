package com.bytedance.android.window.shop.home.presenter;

import android.view.Choreographer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class j0 implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f188551a;

    public j0(Function0 r100) {
        this.f188551a = r100;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        this.f188551a.invoke();
    }
}
