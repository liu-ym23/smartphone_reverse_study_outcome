package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements gc0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningVolumeContentArea f70580a;

    @Override // gc0.a
    public final int a() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f70580a.f70564a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.u();
    }

    @Override // gc0.a
    public final void b() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f70580a.f70564a;
        if (r100 == null) goto L6;
        r100.c0(1.0d);
        return;
    }

    @Override // gc0.a
    public final void c() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f70580a.f70564a;
        if (r100 == null) goto L6;
        r100.g0(1.0d);
        return;
    }

    public h(TuningVolumeContentArea r100) {
        this.f70580a = r100;
    }

    @Override // gc0.a
    public final boolean d(TuningVolumeType r100) {
        Intrinsics.checkNotNullParameter(r100, "toneVolume");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f70580a.f70564a;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.d(r100) != true) goto L7;
        return true;
    }
}
