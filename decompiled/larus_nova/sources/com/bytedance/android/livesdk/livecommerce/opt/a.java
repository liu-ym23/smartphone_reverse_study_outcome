package com.bytedance.android.livesdk.livecommerce.opt;

import android.view.Choreographer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f149772a;

    public a(Function0 r100) {
        this.f149772a = r100;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        this.f149772a.invoke();
    }
}
