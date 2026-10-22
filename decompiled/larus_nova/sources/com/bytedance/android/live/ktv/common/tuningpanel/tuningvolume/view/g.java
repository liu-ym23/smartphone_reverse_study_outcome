package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements gc0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningVolumeContentArea f70578a;

    public static final class a implements SeekBarWithProgress.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f70579a;

        @Override // com.bytedance.android.livesdk.widget.SeekBarWithProgress.b
        public final boolean a() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f70579a.f70578a.f70564a;
            if (r100 != null) goto L5;
            return true;
        L5:
            if (r100.d(TuningVolumeType.ACCOMPANIMENT_VOLUME) != true) goto L10;
            return false;
        L10:
            return true;
        }

        public a(g r100) {
            this.f70579a = r100;
        }
    }

    @Override // gc0.c
    public final int c() {
        return 100;
    }

    @Override // gc0.c
    public final SeekBarWithProgress.b b() {
        return new a(this);
    }

    @Override // gc0.c
    public final int d() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f70578a.f70564a;
        if (r100 != null) goto L7;
        return 50;
    L7:
        return (int) r100.A();
    }

    @Override // gc0.c
    public final String a() {
        return s1.B(R.string.ttlive_ktv_music_volume);
    }

    public g(TuningVolumeContentArea r100) {
        this.f70578a = r100;
    }

    @Override // gc0.c
    public final void onProgressChanged(int r100) {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f70578a.f70564a;
        if (r101 == null) goto L6;
        r101.G(r100);
        return;
    }
}
