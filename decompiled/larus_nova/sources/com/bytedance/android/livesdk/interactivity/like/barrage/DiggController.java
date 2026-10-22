package com.bytedance.android.livesdk.interactivity.like.barrage;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.config.eg;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.kn;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import com.ss.ugc.live.barrage.view.BarrageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class DiggController extends AbsBarrageController {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f137576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<d> f137577o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Random f137578p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f137579q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Handler f137580r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Boolean f137581s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final BarrageLayout f137582t;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void m() {
        this.f137580r.removeCallbacksAndMessages(null);
        p();
        Iterator<T> r100 = this.f137577o.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).m();
        goto L4
    L6:
        super.m();
    }

    public final int r() {
        int r100 = (this.f458094a.size() + ((LinkedList) this.f458096c).size()) + ((LinkedList) this.f458095b).size();
        Iterator r101 = SequencesKt.map(CollectionsKt.asSequence(this.f137577o), DiggController$size$1.INSTANCE).iterator();
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
    L6:
        if (r101.hasNext() == false) goto L9;
        int r103 = ((Number) r101.next()).intValue();
        r102 = Integer.valueOf(((Number) r102).intValue() + r103);
        goto L6
    L9:
        return r100 + ((Number) r102).intValue();
    L11:
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public DiggController(BarrageLayout r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "barrageView");
        super(r100);
        this.f137582t = r100;
        this.f137576n = r101;
        this.f137577o = new ArrayList();
        this.f137578p = new Random();
        this.f137579q = 1.0f;
        this.f137580r = new Handler(Looper.getMainLooper());
        Boolean r102 = eg.f120123a.getValue();
        this.f137581s = r102;
        if (r102.booleanValue() == false) goto L5;
        this.f458101h = true;
    L5:
        this.f458100g = h21.f120336d.getValue().booleanValue();
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void j(com.ss.ugc.live.barrage.util.a r110, float r111) {
        Intrinsics.checkNotNullParameter(r110, "runningBarrageList");
        float r112 = this.f137579q + (r111 / this.f137576n);
        this.f137579q = r112;
        if (r112 > 0.2f) goto L5;
        return;
    L5:
        if (kotlin.random.Random.Default.nextInt(1, 100) >= (((Number) InteractivityOpt.c(kn.f120615a)).floatValue() * 100)) goto L7;
        return;
    L7:
        int r113 = this.f137578p.nextInt(2) + 1;
        int r100 = 0;
        long r101 = 0;
    L8:
        if (r100 >= r113) goto L14;
        c r102 = new c(this);
        if (r101 > 0) goto L12;
        this.f137580r.post(r102);
    L13:
        r101 = r101 + Math.max(200, this.f137578p.nextInt((int) ((this.f137576n * 0.2f) / r113)));
        r100 = r100 + 1;
        goto L8
    L12:
        this.f137580r.postDelayed(r102, r101);
        goto L13
    L14:
        this.f137579q = 0.0f;
    }
}
