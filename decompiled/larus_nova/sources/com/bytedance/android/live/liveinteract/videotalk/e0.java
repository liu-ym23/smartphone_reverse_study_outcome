package com.bytedance.android.live.liveinteract.videotalk;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e0 extends com.bytedance.android.live.liveinteract.a {
    public final TextView C;
    public final ImageView D;
    public final TextView E;
    public final ObjectAnimator F;
    public final ObjectAnimator G;
    public final ObjectAnimator H;
    public final ObjectAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ObjectAnimator f79275J;
    public final ObjectAnimator K;
    public final ObjectAnimator L;
    public final ObjectAnimator M;
    public final ObjectAnimator N;
    public final ObjectAnimator O;
    public final ObjectAnimator P;
    public final ObjectAnimator Q;
    public final ObjectAnimator R;
    public ObjectAnimator S;
    public ObjectAnimator T;

    @Override // com.bytedance.android.live.liveinteract.a
    public final void b() {
        this.f70873e.setScaleX(0.5f);
        this.f70873e.setScaleY(0.5f);
        this.f70875g.setAlpha(0.0f);
        this.E.setAlpha(1.0f);
        this.C.setAlpha(1.0f);
        this.D.setAlpha(1.0f);
        super.b();
    }

    @Override // com.bytedance.android.live.liveinteract.a
    public final void c() {
        if (this.f70878j == true) goto L5;
        this.f70891w.playTogether(new Animator[]{this.F, this.G, this.f70879k, this.H, this.f70880l, this.I, this.f79275J, this.K, this.L, this.M});
        this.f70892x.playTogether(new Animator[]{this.f70882n, this.f70883o, this.N, this.O});
        this.f70893y.playTogether(new Animator[]{this.f70884p, this.f70885q, this.P, this.Q, this.f70886r});
        this.f70894z.playTogether(new Animator[]{this.f70887s, this.f70890v, this.f70889u, this.f70888t, this.R});
        super.a();
        this.f70894z.addListener(new d0(this));
        this.f70878j = true;
    L5:
        this.A = true;
        this.f70891w.start();
    }

    public e0(View r110) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        super(r110);
        TextView r100 = (TextView) r110.findViewById(R.id.ttlive_empty_position);
        this.C = r100;
        ImageView r101 = (ImageView) r110.findViewById(R.id.ttlive_empty_avatar);
        this.D = r101;
        TextView r111 = (TextView) r110.findViewById(R.id.ttlive_empty_tips);
        this.E = r111;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f70873e, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.5f, 1.0f});
        r102.setDuration(400);
        r102.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r102);
        Unit r103 = Unit.INSTANCE;
        this.F = r102;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f70873e, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.5f, 1.0f});
        r104.setDuration(400);
        r104.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r104);
        this.G = r104;
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f70874f, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.f(10.0f), 0.0f});
        r105.setDuration(400);
        r105.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r105);
        this.H = r105;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.f(10.0f), 0.0f});
        r106.setDuration(400);
        r106.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r106);
        this.I = r106;
        ObjectAnimator r107 = ObjectAnimator.ofFloat(this.f70875g, "alpha", new float[]{0.0f, 0.15f});
        r107.setDuration(400);
        r107.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r107);
        this.f79275J = r107;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r108.setDuration(300);
        ((ArrayList) this.f70877i).add(r108);
        this.K = r108;
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{1.0f, 0.0f});
        r109.setDuration(300);
        ((ArrayList) this.f70877i).add(r109);
        this.L = r109;
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r111, "alpha", new float[]{1.0f, 0.0f});
        r112.setDuration(300);
        ((ArrayList) this.f70877i).add(r112);
        this.M = r112;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.83f});
        r113.setDuration(400);
        ((ArrayList) this.f70877i).add(r113);
        this.N = r113;
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this.f70875g, "alpha", new float[]{0.15f, 1.0f});
        r114.setDuration(400);
        ((ArrayList) this.f70877i).add(r114);
        this.O = r114;
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.83f, 0.97f});
        r115.setDuration(400);
        ((ArrayList) this.f70877i).add(r115);
        this.P = r115;
        ObjectAnimator r116 = ObjectAnimator.ofFloat(this.f70875g, "alpha", new float[]{1.0f, 0.15f});
        r116.setDuration(400);
        ((ArrayList) this.f70877i).add(r116);
        this.Q = r116;
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r111, "alpha", new float[]{0.0f, 1.0f});
        r117.setDuration(300);
        ((ArrayList) this.f70877i).add(r117);
        this.R = r117;
    }
}
