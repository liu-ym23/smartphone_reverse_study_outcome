package com.bytedance.android.live.ktv.common.midi;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextSwitcher f69870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f69871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f69872c;

    public m(View r100) {
        Intrinsics.checkNotNullParameter(r100, "parentContext");
        TextSwitcher r101 = (TextSwitcher) r100.findViewById(R.id.score_switcher);
        this.f69870a = r101;
        this.f69871b = (TextView) r100.findViewById(R.id.current_score_tv);
        this.f69872c = (TextView) r100.findViewById(R.id.next_score_tv);
        r101.setMeasureAllChildren(false);
        r101.setInAnimation(AnimationUtils.loadAnimation(r101.getContext(), R.anim.ttlive_fan_ticket_slide_up_in));
        r101.setOutAnimation(AnimationUtils.loadAnimation(r101.getContext(), R.anim.ttlive_fan_ticket_slide_up_out));
        r101.setCurrentText("0.0分");
    }
}
