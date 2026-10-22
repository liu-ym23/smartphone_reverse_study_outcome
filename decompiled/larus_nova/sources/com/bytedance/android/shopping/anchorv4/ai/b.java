package com.bytedance.android.shopping.anchorv4.ai;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f165641a;

    public b(c r100) {
        this.f165641a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.y
    public final f a(PdpAIPageEventObserverImpl$createFragmentCoverCallback$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f165641a.f165644c.registerFragmentLifecycleCallbacks(r100, true);
        return new a(this, r100);
    }
}
