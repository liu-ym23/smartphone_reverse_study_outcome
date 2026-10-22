package com.bytedance.android.shopping.anchorv3.videowindow;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoWindowSession f165385a;

    public d(VideoWindowSession r100) {
        this.f165385a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        VideoWindowSession r101 = this.f165385a;
        int r102 = VideoWindowSession.f165362t;
        if (r101.h().isPlaying() == false) goto L5;
        this.f165385a.h().pause();
        this.f165385a.g().setImageResource(R.drawable.anchor_v3_hao_wu_video_play);
        return;
    L5:
        this.f165385a.h().play();
        this.f165385a.g().setImageResource(R.drawable.anchor_v3_hao_wu_video_pause);
        VideoWindowSession.j(this.f165385a, true, 2);
        VideoWindowSession r103 = this.f165385a;
        vg3.c r104 = r103.f165379q;
        if (r104 == null) goto L10;
        r104.a(r103);
        return;
    }
}
