package com.bytedance.android.live.room.discovery.inspector;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficialInspectorWidget f99550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f99551b;

    public e(OfficialInspectorWidget r100, l r101) {
        this.f99550a = r100;
        this.f99551b = r101;
    }

    public final void a() {
        OfficialInspectorWidget r100 = this.f99550a;
        TextView r101 = r100.f99533c;
        if (r101 == null) goto L5;
        int r102 = r101.getWidth();
    L6:
        r100.f99538h = r102;
        OfficialInspectorWidget r103 = this.f99550a;
        l r104 = this.f99551b;
        TextView r105 = r103.f99533c;
        LinearLayout r106 = r103.f99531a;
        if (r106 == null) goto L13;
        if (r105 == null) goto L12;
        AnimatorSet r107 = new AnimatorSet();
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r106, "alpha", new float[]{0.0f, 1.0f});
        r108.setDuration(300);
        Unit r109 = Unit.INSTANCE;
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r105, "alpha", new float[]{1.0f, 0.0f});
        r110.setStartDelay(r104.f99560c * 1000);
        r110.setDuration(600);
        ValueAnimator r111 = ValueAnimator.ofInt(new int[]{r103.f99538h, 0});
        r111.setDuration(600);
        r111.addUpdateListener(new g(r103));
        r107.playSequentially(new Animator[]{r108, r110, r111});
        r107.addListener(new h(r103));
        r107.start();
        r103.f99539i = r107;
        AnimatorSet r112 = new AnimatorSet();
        ValueAnimator r113 = ValueAnimator.ofInt(new int[]{0, r103.f99538h});
        r113.setDuration(600);
        r113.addUpdateListener(new i(r103));
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r105, "alpha", new float[]{0.0f, 1.0f});
        r114.setDuration(600);
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r105, "alpha", new float[]{1.0f, 0.0f});
        r115.setStartDelay(r104.f99560c * 1000);
        r115.setDuration(600);
        ValueAnimator r116 = ValueAnimator.ofInt(new int[]{r103.f99538h, 0});
        r116.setDuration(600);
        r116.addUpdateListener(new j(r103));
        r112.playSequentially(new Animator[]{r113, r114, r115, r116});
        r112.addListener(new k(r103));
        r103.f99540j = r112;
        return;
    L12:
        return;
    L13:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
