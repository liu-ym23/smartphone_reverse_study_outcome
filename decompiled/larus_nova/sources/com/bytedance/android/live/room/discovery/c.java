package com.bytedance.android.live.room.discovery;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorPerfMonitorDialog f99372a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
        long r101 = r100 / ((long) 1000);
        TextView r102 = (TextView) this.f99372a.findViewById(R.id.tv_mic_desc);
        if (r102 == null) goto L6;
        r102.setText(s1.C(R.string.live_anchor_audio_punish_tip, new Object[]{Integer.valueOf((int) r101)}));
        return;
    }

    public c(AnchorPerfMonitorDialog r100, long r101) {
        this.f99372a = r100;
        super(r101, 1000);
    }
}
