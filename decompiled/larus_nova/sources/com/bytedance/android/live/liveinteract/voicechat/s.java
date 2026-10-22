package com.bytedance.android.live.liveinteract.voicechat;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class s extends com.bytedance.android.live.liveinteract.a {
    public final TextView C;
    public final HSImageView D;
    public final TextView E;
    public final ObjectAnimator F;
    public final ObjectAnimator G;
    public final ObjectAnimator H;
    public final ObjectAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ObjectAnimator f80582J;
    public final ObjectAnimator K;
    public final ObjectAnimator L;
    public final ObjectAnimator M;
    public final ObjectAnimator N;
    public final ObjectAnimator O;
    public final ObjectAnimator P;
    public final ObjectAnimator Q;
    public ObjectAnimator R;
    public ObjectAnimator S;

    @Override // com.bytedance.android.live.liveinteract.a
    public final void b() {
        this.f70875g.setAlpha(0.0f);
        this.E.setAlpha(1.0f);
        this.C.setAlpha(1.0f);
        this.D.setAlpha(1.0f);
        super.b();
    }

    @Override // com.bytedance.android.live.liveinteract.a
    public final void c() {
        if (this.f70878j == true) goto L5;
        this.f70891w.playTogether(new Animator[]{this.F, this.f70879k, this.G, this.f70880l, this.H, this.I, this.f80582J, this.K, this.L});
        this.f70892x.playTogether(new Animator[]{this.f70882n, this.f70883o, this.M, this.N});
        this.f70893y.playTogether(new Animator[]{this.f70884p, this.f70885q, this.O, this.P, this.f70886r});
        this.f70894z.playTogether(new Animator[]{this.f70887s, this.f70890v, this.f70889u, this.f70888t, this.Q});
        super.a();
        this.f70894z.addListener(new r(this));
        this.f70878j = true;
    L5:
        this.A = true;
        this.f70891w.start();
    }

    public s(View r110) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        super(r110);
        TextView r100 = (TextView) r110.findViewById(R.id.ttlive_empty_position);
        this.C = r100;
        HSImageView r101 = (HSImageView) r110.findViewById(R.id.ttlive_empty_avatar);
        this.D = r101;
        TextView r111 = (TextView) r110.findViewById(R.id.ttlive_empty_tips);
        this.E = r111;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f70873e, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.f(48.0f), 0.0f});
        r102.setDuration(400);
        r102.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r102);
        Unit r103 = Unit.INSTANCE;
        this.F = r102;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f70874f, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.f(4.0f), 0.0f});
        r104.setDuration(400);
        r104.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r104);
        this.G = r104;
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.f(4.0f), 0.0f});
        r105.setDuration(400);
        r105.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r105);
        this.H = r105;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(this.f70875g, "alpha", new float[]{0.0f, 0.15f});
        r106.setDuration(400);
        r106.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r106);
        this.I = r106;
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r107.setDuration(300);
        ((ArrayList) this.f70877i).add(r107);
        this.f80582J = r107;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{1.0f, 0.0f});
        r108.setDuration(300);
        ((ArrayList) this.f70877i).add(r108);
        this.K = r108;
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r111, "alpha", new float[]{1.0f, 0.0f});
        r109.setDuration(300);
        ((ArrayList) this.f70877i).add(r109);
        this.L = r109;
        ObjectAnimator r112 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.83f});
        r112.setDuration(400);
        ((ArrayList) this.f70877i).add(r112);
        this.M = r112;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this.f70875g, "alpha", new float[]{0.15f, 1.0f});
        r113.setDuration(400);
        ((ArrayList) this.f70877i).add(r113);
        this.N = r113;
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.83f, 0.97f});
        r114.setDuration(400);
        ((ArrayList) this.f70877i).add(r114);
        this.O = r114;
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this.f70875g, "alpha", new float[]{1.0f, 0.15f});
        r115.setDuration(400);
        ((ArrayList) this.f70877i).add(r115);
        this.P = r115;
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r111, "alpha", new float[]{0.0f, 1.0f});
        r116.setDuration(300);
        ((ArrayList) this.f70877i).add(r116);
        this.Q = r116;
    }
}
