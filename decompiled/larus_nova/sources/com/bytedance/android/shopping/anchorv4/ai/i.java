package com.bytedance.android.shopping.anchorv4.ai;

import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f165664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentManager.FragmentLifecycleCallbacks f165665b;

    public i(j r100, PdpAIPageEventObserverImpl$createFragmentCoverCallback$1 r101) {
        this.f165664a = r100;
        this.f165665b = r101;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.f
    public final void dispose() {
        this.f165664a.f165666a.j1(this.f165665b);
    }
}
