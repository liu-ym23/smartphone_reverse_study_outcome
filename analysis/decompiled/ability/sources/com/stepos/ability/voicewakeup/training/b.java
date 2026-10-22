package com.stepos.ability.voicewakeup.training;

import B9.Q;
import Ba.f;
import D6.e;
import D6.i;
import android.view.View;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final View f3395a;
    public final View b;
    public final c c;
    public final e d;

    public b(View view, View view2, String str) {
        this.f3395a = view;
        this.b = view2;
        this.c = new c(new i(this, 5), new G6.e(this, 1), new TrainingListenController$session$1(1, this, b.class, "setHomeBarHidden", "setHomeBarHidden(Z)V", 0), new Q(this, 13), new f(13), str);
        e eVar = new e(this, 1);
        this.d = eVar;
        view2.setVisibility(4);
        view.addOnAttachStateChangeListener(eVar);
    }

    public final void a(long j5) {
        c cVar = this.c;
        if (j5 != cVar.l) {
            return;
        }
        cVar.m = false;
        try {
            TrainingListenEffect trainingListenEffect = cVar.g;
            if (trainingListenEffect != null) {
                trainingListenEffect.setVolume(0.0f);
            }
        } catch (Exception e) {
            cVar.b(e);
        }
    }
}
