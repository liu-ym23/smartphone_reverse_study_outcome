package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements gc0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningVolumeContentArea f70576a;

    @Override // gc0.c
    public final int c() {
        return 100;
    }

    @Override // gc0.c
    public final SeekBarWithProgress.b b() {
        return new gc0.b();
    }

    @Override // gc0.c
    public final int d() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f70576a.f70564a;
        if (r100 != null) goto L7;
        return 50;
    L7:
        return (int) r100.f();
    }

    @Override // gc0.c
    public final String a() {
        return s1.B(R.string.ttlive_ktv_echo_volume);
    }

    public e(TuningVolumeContentArea r100) {
        this.f70576a = r100;
    }

    @Override // gc0.c
    public final void onProgressChanged(int r100) {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f70576a.f70564a;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }
}
