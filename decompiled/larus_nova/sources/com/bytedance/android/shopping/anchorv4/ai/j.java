package com.bytedance.android.shopping.anchorv4.ai;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vg3.u f165666a;

    public j(vg3.u r100) {
        this.f165666a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.y
    public final f a(PdpAIPageEventObserverImpl$createFragmentCoverCallback$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f165666a.d0(r100);
        return new i(this, r100);
    }
}
