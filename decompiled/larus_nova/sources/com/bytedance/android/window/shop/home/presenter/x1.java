package com.bytedance.android.window.shop.home.presenter;

import android.view.Choreographer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class x1 implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f188658a;

    public x1(Function0 r100) {
        this.f188658a = r100;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        this.f188658a.invoke();
    }
}
