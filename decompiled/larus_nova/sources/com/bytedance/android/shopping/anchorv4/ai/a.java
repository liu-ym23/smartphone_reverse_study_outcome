package com.bytedance.android.shopping.anchorv4.ai;

import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f165638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentManager.FragmentLifecycleCallbacks f165639b;

    public a(b r100, PdpAIPageEventObserverImpl$createFragmentCoverCallback$1 r101) {
        this.f165638a = r100;
        this.f165639b = r101;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.f
    public final void dispose() {
        this.f165638a.f165641a.f165644c.unregisterFragmentLifecycleCallbacks(this.f165639b);
    }
}
