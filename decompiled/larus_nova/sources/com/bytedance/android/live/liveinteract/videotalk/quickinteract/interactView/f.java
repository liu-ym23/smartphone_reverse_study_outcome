package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextSwitcher f79606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f79607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f79608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f79609d;

    public interface a {
        void a(String r100);
    }

    public f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "parentContext");
        TextSwitcher r101 = (TextSwitcher) r100.findViewById(R.id.score_switcher);
        this.f79606a = r101;
        this.f79607b = (TextView) r100.findViewById(R.id.thanks_tv);
        this.f79608c = (TextView) r100.findViewById(R.id.score_tv);
        this.f79609d = "0";
        r101.setMeasureAllChildren(false);
        r101.setInAnimation(AnimationUtils.loadAnimation(r101.getContext(), R.anim.ttlive_fan_ticket_slide_up_in));
        r101.setOutAnimation(AnimationUtils.loadAnimation(r101.getContext(), R.anim.ttlive_fan_ticket_slide_up_out));
        r101.setCurrentText("0");
        this.f79609d = "0";
    }

    public static AnimatorSet a(f r100, String r101, long r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 300;
    L6:
        if ((r103 & 4) == 0) goto L8;
        long r104 = 350;
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{0, 1});
        r105.setDuration(r104);
        r105.setStartDelay(r102);
        r105.addListener(new g(r100, r101));
        AnimatorSet r106 = new AnimatorSet();
        r106.play(r105);
        return r106;
    L8:
        r104 = 0;
        goto L9
    }
}
