package com.bytedance.android.gamecp.common.track.monitor.page;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import av.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/common/track/monitor/page/GPFragmentLifeCycleListener;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GPFragmentLifeCycleListener extends FragmentManager.FragmentLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f56857a;

    public GPFragmentLifeCycleListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "pageLifeCycle");
        this.f56857a = r100;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentDestroyed(FragmentManager r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, "f");
        super.onFragmentDestroyed(r100, r101);
        this.f56857a.a(r101);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentPaused(FragmentManager r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, "f");
        super.onFragmentPaused(r100, r101);
        this.f56857a.b(r101);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentResumed(FragmentManager r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, "f");
        super.onFragmentResumed(r100, r101);
        this.f56857a.d(r101);
    }
}
