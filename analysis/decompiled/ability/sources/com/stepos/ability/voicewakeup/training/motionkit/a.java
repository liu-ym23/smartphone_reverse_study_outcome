package com.stepos.ability.voicewakeup.training.motionkit;

import A5.c;
import C7.r;
import D7.q;
import D7.w;
import H7.b;
import I4.e;
import I4.f;
import I4.h;
import I4.i;
import I4.j;
import I4.n;
import I4.o;
import I4.p;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.FxModule;
import com.stepos.motionkit.MotionHost;
import com.stepos.motionkit.UniformSpec;
import com.stepos.motionkit.fx.MotionHostExtKt;
import g1.AbstractC1451a;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.q0;
import m9.r0;
import s9.C1923c;
import u9.d;
import z2.l;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: J, reason: collision with root package name */
    public static final Set f3410J = q.K0(new String[]{"uScreenSize", "uViewOrigin", "uCoordScale", "uListenTime", "uRippleTime", "uPxPerDp", "uGpuReady", "uGpuListenEA", "uGpuListenFade", "uGpuRing1", "uGpuRing2", "uGpuRippleEA", "uGpuRippleRing"});

    /* renamed from: A, reason: collision with root package name */
    public q0 f3411A;

    /* renamed from: B, reason: collision with root package name */
    public q0 f3412B;

    /* renamed from: C, reason: collision with root package name */
    public q0 f3413C;

    /* renamed from: D, reason: collision with root package name */
    public final AtomicBoolean f3414D;
    public boolean E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f3415F;

    /* renamed from: G, reason: collision with root package name */
    public long f3416G;

    /* renamed from: H, reason: collision with root package name */
    public long f3417H;

    /* renamed from: I, reason: collision with root package name */
    public long f3418I;

    /* renamed from: a, reason: collision with root package name */
    public final View f3419a;
    public final p b;
    public final e c;
    public final i d;
    public final VoiceListenAnimation$WaterBackend e;
    public final float f;
    public final LinkedHashMap g;
    public final CopyOnWriteArrayList h;
    public final c i;

    /* renamed from: j, reason: collision with root package name */
    public final c f3420j;
    public final c k;
    public final c l;
    public final c m;
    public final h n;
    public MotionHost o;
    public MotionHost p;

    /* renamed from: q, reason: collision with root package name */
    public final FrameLayout f3421q;

    /* renamed from: r, reason: collision with root package name */
    public final FrameLayout f3422r;

    /* renamed from: s, reason: collision with root package name */
    public final PopupWindow f3423s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f3424t;
    public final Rect u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3425v;

    /* renamed from: w, reason: collision with root package name */
    public final n f3426w;

    /* renamed from: x, reason: collision with root package name */
    public final D6.e f3427x;
    public final C1923c y;

    /* renamed from: z, reason: collision with root package name */
    public q0 f3428z;

    public a(View anchor) {
        k.f(anchor, "anchor");
        this.f3419a = anchor;
        VoiceListenAnimation$PlayMask[] voiceListenAnimation$PlayMaskArr = VoiceListenAnimation$PlayMask.f3398a;
        this.e = VoiceListenAnimation$WaterBackend.f3399a;
        this.f = 1.0f;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new CopyOnWriteArrayList();
        final int i = 0;
        final int i6 = 2;
        c cVar = new c("Glow", new S7.n(this) { // from class: I4.m
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                FxInstance fxInstance;
                String n = (String) obj;
                float[] v10 = (float[]) obj2;
                switch (i) {
                    case 0:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        FxInstance fxInstance2 = (FxInstance) this.b.g.get("Glow");
                        if (fxInstance2 != null) {
                            if (!fxInstance2.getIsActive()) {
                                fxInstance2 = null;
                            }
                            if (fxInstance2 != null) {
                                o.b(fxInstance2, n, v10);
                            }
                        }
                        break;
                    case 1:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        if (!kotlin.jvm.internal.k.b(n, "uPxPerDp")) {
                            n = "uR".concat(j9.m.y0("u", n));
                        }
                        com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                        aVar.k.v(n, v10, false);
                        FxInstance fxInstance3 = (FxInstance) aVar.g.get("WaterDrop");
                        if (fxInstance3 != null) {
                            if (!fxInstance3.getIsActive()) {
                                fxInstance3 = null;
                            }
                            if (fxInstance3 != null) {
                                o.b(fxInstance3, n, v10);
                            }
                        }
                        break;
                    case 2:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        if ((n.length() <= 2 || !t.e0(n, "uR", false) || !Character.isUpperCase(n.charAt(2))) && (fxInstance = (FxInstance) this.b.g.get("WaterDrop")) != null) {
                            if (!fxInstance.getIsActive()) {
                                fxInstance = null;
                            }
                            if (fxInstance != null) {
                                o.b(fxInstance, n, v10);
                            }
                        }
                        break;
                    default:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        FxInstance fxInstance4 = (FxInstance) this.b.g.get("AudioWave");
                        if (fxInstance4 != null) {
                            if (!fxInstance4.getIsActive()) {
                                fxInstance4 = null;
                            }
                            if (fxInstance4 != null) {
                                o.b(fxInstance4, n, v10);
                            }
                        }
                        break;
                }
                return r.f317a;
            }
        }, new S7.a(this) { // from class: I4.k
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i10 = i6;
                com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                switch (i10) {
                    case 0:
                        aVar.n();
                        break;
                    case 1:
                        aVar.n();
                        break;
                    case 2:
                        aVar.n();
                        break;
                    case 3:
                        aVar.n();
                        break;
                    default:
                        aVar.n();
                        break;
                }
                return r.f317a;
            }
        });
        this.i = cVar;
        final int i10 = 1;
        final int i11 = 3;
        c cVar2 = new c("GlowRipple", new S7.n(this) { // from class: I4.m
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                FxInstance fxInstance;
                String n = (String) obj;
                float[] v10 = (float[]) obj2;
                switch (i10) {
                    case 0:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        FxInstance fxInstance2 = (FxInstance) this.b.g.get("Glow");
                        if (fxInstance2 != null) {
                            if (!fxInstance2.getIsActive()) {
                                fxInstance2 = null;
                            }
                            if (fxInstance2 != null) {
                                o.b(fxInstance2, n, v10);
                            }
                        }
                        break;
                    case 1:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        if (!kotlin.jvm.internal.k.b(n, "uPxPerDp")) {
                            n = "uR".concat(j9.m.y0("u", n));
                        }
                        com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                        aVar.k.v(n, v10, false);
                        FxInstance fxInstance3 = (FxInstance) aVar.g.get("WaterDrop");
                        if (fxInstance3 != null) {
                            if (!fxInstance3.getIsActive()) {
                                fxInstance3 = null;
                            }
                            if (fxInstance3 != null) {
                                o.b(fxInstance3, n, v10);
                            }
                        }
                        break;
                    case 2:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        if ((n.length() <= 2 || !t.e0(n, "uR", false) || !Character.isUpperCase(n.charAt(2))) && (fxInstance = (FxInstance) this.b.g.get("WaterDrop")) != null) {
                            if (!fxInstance.getIsActive()) {
                                fxInstance = null;
                            }
                            if (fxInstance != null) {
                                o.b(fxInstance, n, v10);
                            }
                        }
                        break;
                    default:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        FxInstance fxInstance4 = (FxInstance) this.b.g.get("AudioWave");
                        if (fxInstance4 != null) {
                            if (!fxInstance4.getIsActive()) {
                                fxInstance4 = null;
                            }
                            if (fxInstance4 != null) {
                                o.b(fxInstance4, n, v10);
                            }
                        }
                        break;
                }
                return r.f317a;
            }
        }, new S7.a(this) { // from class: I4.k
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i102 = i11;
                com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                switch (i102) {
                    case 0:
                        aVar.n();
                        break;
                    case 1:
                        aVar.n();
                        break;
                    case 2:
                        aVar.n();
                        break;
                    case 3:
                        aVar.n();
                        break;
                    default:
                        aVar.n();
                        break;
                }
                return r.f317a;
            }
        });
        this.f3420j = cVar2;
        final int i12 = 4;
        c cVar3 = new c("WaterDrop", new S7.n(this) { // from class: I4.m
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                FxInstance fxInstance;
                String n = (String) obj;
                float[] v10 = (float[]) obj2;
                switch (i6) {
                    case 0:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        FxInstance fxInstance2 = (FxInstance) this.b.g.get("Glow");
                        if (fxInstance2 != null) {
                            if (!fxInstance2.getIsActive()) {
                                fxInstance2 = null;
                            }
                            if (fxInstance2 != null) {
                                o.b(fxInstance2, n, v10);
                            }
                        }
                        break;
                    case 1:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        if (!kotlin.jvm.internal.k.b(n, "uPxPerDp")) {
                            n = "uR".concat(j9.m.y0("u", n));
                        }
                        com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                        aVar.k.v(n, v10, false);
                        FxInstance fxInstance3 = (FxInstance) aVar.g.get("WaterDrop");
                        if (fxInstance3 != null) {
                            if (!fxInstance3.getIsActive()) {
                                fxInstance3 = null;
                            }
                            if (fxInstance3 != null) {
                                o.b(fxInstance3, n, v10);
                            }
                        }
                        break;
                    case 2:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        if ((n.length() <= 2 || !t.e0(n, "uR", false) || !Character.isUpperCase(n.charAt(2))) && (fxInstance = (FxInstance) this.b.g.get("WaterDrop")) != null) {
                            if (!fxInstance.getIsActive()) {
                                fxInstance = null;
                            }
                            if (fxInstance != null) {
                                o.b(fxInstance, n, v10);
                            }
                        }
                        break;
                    default:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        FxInstance fxInstance4 = (FxInstance) this.b.g.get("AudioWave");
                        if (fxInstance4 != null) {
                            if (!fxInstance4.getIsActive()) {
                                fxInstance4 = null;
                            }
                            if (fxInstance4 != null) {
                                o.b(fxInstance4, n, v10);
                            }
                        }
                        break;
                }
                return r.f317a;
            }
        }, new S7.a(this) { // from class: I4.k
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i102 = i12;
                com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                switch (i102) {
                    case 0:
                        aVar.n();
                        break;
                    case 1:
                        aVar.n();
                        break;
                    case 2:
                        aVar.n();
                        break;
                    case 3:
                        aVar.n();
                        break;
                    default:
                        aVar.n();
                        break;
                }
                return r.f317a;
            }
        });
        this.k = cVar3;
        c cVar4 = new c("AudioWave", new S7.n(this) { // from class: I4.m
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                FxInstance fxInstance;
                String n = (String) obj;
                float[] v10 = (float[]) obj2;
                switch (i11) {
                    case 0:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        FxInstance fxInstance2 = (FxInstance) this.b.g.get("Glow");
                        if (fxInstance2 != null) {
                            if (!fxInstance2.getIsActive()) {
                                fxInstance2 = null;
                            }
                            if (fxInstance2 != null) {
                                o.b(fxInstance2, n, v10);
                            }
                        }
                        break;
                    case 1:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        if (!kotlin.jvm.internal.k.b(n, "uPxPerDp")) {
                            n = "uR".concat(j9.m.y0("u", n));
                        }
                        com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                        aVar.k.v(n, v10, false);
                        FxInstance fxInstance3 = (FxInstance) aVar.g.get("WaterDrop");
                        if (fxInstance3 != null) {
                            if (!fxInstance3.getIsActive()) {
                                fxInstance3 = null;
                            }
                            if (fxInstance3 != null) {
                                o.b(fxInstance3, n, v10);
                            }
                        }
                        break;
                    case 2:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        if ((n.length() <= 2 || !t.e0(n, "uR", false) || !Character.isUpperCase(n.charAt(2))) && (fxInstance = (FxInstance) this.b.g.get("WaterDrop")) != null) {
                            if (!fxInstance.getIsActive()) {
                                fxInstance = null;
                            }
                            if (fxInstance != null) {
                                o.b(fxInstance, n, v10);
                            }
                        }
                        break;
                    default:
                        kotlin.jvm.internal.k.f(n, "n");
                        kotlin.jvm.internal.k.f(v10, "v");
                        FxInstance fxInstance4 = (FxInstance) this.b.g.get("AudioWave");
                        if (fxInstance4 != null) {
                            if (!fxInstance4.getIsActive()) {
                                fxInstance4 = null;
                            }
                            if (fxInstance4 != null) {
                                o.b(fxInstance4, n, v10);
                            }
                        }
                        break;
                }
                return r.f317a;
            }
        }, new S7.a(this) { // from class: I4.k
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i102 = i;
                com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                switch (i102) {
                    case 0:
                        aVar.n();
                        break;
                    case 1:
                        aVar.n();
                        break;
                    case 2:
                        aVar.n();
                        break;
                    case 3:
                        aVar.n();
                        break;
                    default:
                        aVar.n();
                        break;
                }
                return r.f317a;
            }
        });
        this.l = cVar4;
        c cVar5 = new c("Timing", new b(i6), new S7.a(this) { // from class: I4.k
            public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i102 = i10;
                com.stepos.ability.voicewakeup.training.motionkit.a aVar = this.b;
                switch (i102) {
                    case 0:
                        aVar.n();
                        break;
                    case 1:
                        aVar.n();
                        break;
                    case 2:
                        aVar.n();
                        break;
                    case 3:
                        aVar.n();
                        break;
                    default:
                        aVar.n();
                        break;
                }
                return r.f317a;
            }
        });
        this.m = cVar5;
        this.n = new h(new j(this, i10));
        FrameLayout frameLayout = new FrameLayout(anchor.getContext());
        this.f3421q = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(anchor.getContext());
        frameLayout2.setClipChildren(false);
        frameLayout2.setClipToPadding(false);
        this.f3422r = frameLayout2;
        PopupWindow popupWindow = new PopupWindow((View) frameLayout, 32, 32, false);
        popupWindow.setTouchable(false);
        popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        frameLayout.setBackgroundColor(0);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        this.f3423s = popupWindow;
        this.f3424t = new Rect();
        this.u = new Rect();
        this.f3426w = new n(this);
        this.f3427x = new D6.e(this, 2);
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        this.y = AbstractC1683A.b(l.H(r0VarC, s9.k.f6003a.d));
        this.f3414D = new AtomicBoolean(false);
        new p(cVar2);
        this.b = new p(cVar3);
        this.c = new e(cVar4);
        this.d = new i(cVar5);
        cVar.y(o.d(f.f797a));
        cVar2.y(o.d(I4.b.f793a));
        cVar3.y(o.d(I4.c.f794a));
        cVar4.y(o.d(I4.a.f792a));
        cVar5.y(kotlin.collections.a.O(new Pair("glowDelayS", new float[]{0.0f}), new Pair("rippleDelayS", new float[]{0.0f}), new Pair("waterDelayS", new float[]{0.0f}), new Pair("waveStartAtS", new float[]{0.3f}), new Pair("waveIntroDurS", new float[]{0.6f})));
        FxInstance fxInstance = (FxInstance) linkedHashMap.get("WaterDrop");
        if (fxInstance != null) {
            if ((fxInstance.getIsActive() ? fxInstance : null) != null) {
                f();
                l(false);
            }
        }
        FxInstance fxInstance2 = (FxInstance) linkedHashMap.get("AudioWave");
        if (fxInstance2 != null) {
            FxInstance fxInstance3 = fxInstance2.getIsActive() ? fxInstance2 : null;
            if (fxInstance3 != null) {
                for (Map.Entry entry : cVar4.A().entrySet()) {
                    String str = (String) entry.getKey();
                    float[] fArr = (float[]) entry.getValue();
                    if (!k.b(str, "uPxPerDp") && !k.b(str, "uWaveTime")) {
                        o.b(fxInstance3, str, fArr);
                    }
                }
            }
        }
        n();
        if (g()) {
            return;
        }
        this.f3419a.addOnAttachStateChangeListener(this.f3427x);
    }

    public static final Object a(a aVar, float f, SuspendLambda suspendLambda) {
        Object objF;
        if (f < 0.0f) {
            f = 0.0f;
        }
        float f7 = f * 1000.0f;
        float f9 = aVar.f;
        if (f9 < 0.01f) {
            f9 = 0.01f;
        }
        long j5 = (long) (f7 / f9);
        return (j5 <= 0 || (objF = kotlinx.coroutines.a.f(j5, suspendLambda)) != CoroutineSingletons.f4909a) ? r.f317a : objF;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(com.stepos.ability.voicewakeup.training.motionkit.a r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.motionkit.a.b(com.stepos.ability.voicewakeup.training.motionkit.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(com.stepos.ability.voicewakeup.training.motionkit.a r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.motionkit.a.c(com.stepos.ability.voicewakeup.training.motionkit.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final void d(a aVar) {
        if (aVar.f3425v) {
            return;
        }
        aVar.f3425v = true;
        Choreographer.getInstance().postFrameCallback(aVar.f3426w);
    }

    public static final boolean e(a aVar, boolean z10) {
        if (aVar.f3414D.get()) {
            return false;
        }
        return z10 ? aVar.E : aVar.f3415F;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void q(com.stepos.ability.voicewakeup.training.motionkit.a r3, long r4, float r6, java.lang.String r7, long r8) {
        /*
            java.util.LinkedHashMap r0 = r3.g
            java.lang.Object r0 = r0.get(r7)
            com.stepos.motionkit.FxInstance r0 = (com.stepos.motionkit.FxInstance) r0
            if (r0 != 0) goto Lc
            goto L73
        Lc:
            r1 = 0
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L13
            goto L14
        L13:
            r8 = r4
        L14:
            long r4 = r4 - r8
            float r4 = (float) r4
            r5 = 1148846080(0x447a0000, float:1000.0)
            float r4 = r4 / r5
            float r4 = r4 * r6
            r5 = 0
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 >= 0) goto L20
            r4 = r5
        L20:
            java.lang.String r5 = "uReleaseAt"
            r0.setUniform(r5, r4)
            int r6 = r7.hashCode()
            switch(r6) {
                case -2133928387: goto L5c;
                case -2102728753: goto L50;
                case -1789797270: goto L44;
                case 2222509: goto L39;
                case 1789338758: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L64
        L2d:
            java.lang.String r6 = "WaterDrop"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L36
            goto L64
        L36:
            A5.c r3 = r3.k
            goto L68
        L39:
            java.lang.String r6 = "Glow"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L64
            A5.c r3 = r3.i
            goto L68
        L44:
            java.lang.String r6 = "Timing"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L4d
            goto L64
        L4d:
            A5.c r3 = r3.m
            goto L68
        L50:
            java.lang.String r6 = "AudioWave"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L59
            goto L64
        L59:
            A5.c r3 = r3.l
            goto L68
        L5c:
            java.lang.String r6 = "GlowRipple"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L66
        L64:
            r3 = 0
            goto L68
        L66:
            A5.c r3 = r3.f3420j
        L68:
            if (r3 == 0) goto L73
            r6 = 1
            float[] r6 = new float[r6]
            r7 = 0
            r6[r7] = r4
            r3.v(r5, r6, r7)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.motionkit.a.q(com.stepos.ability.voicewakeup.training.motionkit.a, long, float, java.lang.String, long):void");
    }

    public final LinkedHashMap A() {
        LinkedHashMap linkedHashMapA = this.k.A();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMapA.entrySet()) {
            String str = (String) entry.getKey();
            if (!f3410J.contains(str) && (str.length() <= 2 || !t.e0(str, "uR", false) || !Character.isUpperCase(str.charAt(2)))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final void f() {
        FxInstance fxInstance = (FxInstance) this.g.get("WaterDrop");
        if (fxInstance != null) {
            if (!fxInstance.getIsActive()) {
                fxInstance = null;
            }
            if (fxInstance == null) {
                return;
            }
            for (Map.Entry entry : A().entrySet()) {
                o.b(fxInstance, (String) entry.getKey(), (float[]) entry.getValue());
            }
            FxInstance fxInstance2 = (FxInstance) this.g.get("WaterDrop");
            if (fxInstance2 != null) {
                if (!fxInstance2.getIsActive()) {
                    fxInstance2 = null;
                }
                if (fxInstance2 == null) {
                    return;
                }
                for (Map.Entry entry2 : u().entrySet()) {
                    o.b(fxInstance2, (String) entry2.getKey(), (float[]) entry2.getValue());
                }
            }
        }
    }

    public final boolean g() {
        FxInstance fxInstance;
        View viewT = t();
        if (viewT == null) {
            return false;
        }
        if (viewT instanceof ViewGroup) {
            this.n.b((ViewGroup) viewT);
        }
        if (this.e == VoiceListenAnimation$WaterBackend.f3399a && (fxInstance = (FxInstance) this.g.get("WaterDrop")) != null && fxInstance.getIsActive()) {
            w(viewT);
        } else {
            k();
        }
        return true;
    }

    public final boolean h() {
        return this.f3417H <= 0 && this.f3416G <= 0;
    }

    public final void i() {
        this.f3414D.set(true);
        this.E = false;
        this.f3415F = false;
        q0 q0Var = this.f3428z;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        q0 q0Var2 = this.f3411A;
        if (q0Var2 != null) {
            q0Var2.cancel(null);
        }
        q0 q0Var3 = this.f3412B;
        if (q0Var3 != null) {
            q0Var3.cancel(null);
        }
        q0 q0Var4 = this.f3413C;
        if (q0Var4 != null) {
            q0Var4.cancel(null);
        }
        this.f3428z = null;
        this.f3411A = null;
        this.f3412B = null;
        this.f3413C = null;
        h hVar = this.n;
        hVar.d();
        if (this.f3425v) {
            this.f3425v = false;
            Choreographer.getInstance().removeFrameCallback(this.f3426w);
        }
        LinkedHashMap linkedHashMap = this.g;
        Collection collectionValues = linkedHashMap.values();
        k.e(collectionValues, "<get-values>(...)");
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).release();
        }
        linkedHashMap.clear();
        k();
        r();
        n();
        AbstractC1683A.e(this.y, null);
        this.f3419a.removeOnAttachStateChangeListener(this.f3427x);
        hVar.d();
        ViewGroup viewGroup = hVar.d;
        FrameLayout frameLayout = hVar.e;
        if (viewGroup != null && frameLayout != null && frameLayout.getParent() == viewGroup) {
            viewGroup.removeView(frameLayout);
        }
        hVar.e = null;
        hVar.f = null;
        Bitmap bitmap = hVar.h;
        if (bitmap != null) {
            if (bitmap == hVar.g || bitmap.isRecycled()) {
                bitmap = null;
            }
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        hVar.h = null;
        Bitmap bitmap2 = hVar.g;
        if (bitmap2 != null) {
            if (bitmap2.isRecycled()) {
                bitmap2 = null;
            }
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
        }
        hVar.g = null;
        hVar.d = null;
        MotionHost motionHost = this.p;
        if (motionHost != null) {
            motionHost.release();
        }
        MotionHost motionHost2 = this.o;
        if (motionHost2 != null) {
            motionHost2.release();
        }
        PopupWindow popupWindow = this.f3423s;
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        this.h.clear();
    }

    public final MotionHost j() {
        View viewT = t();
        ViewGroup viewGroup = viewT instanceof ViewGroup ? (ViewGroup) viewT : null;
        if (viewGroup == null) {
            return this.p;
        }
        m(viewGroup);
        MotionHost motionHost = this.p;
        if (motionHost != null) {
            return motionHost;
        }
        MotionHost motionHostCreate = MotionHostExtKt.create(MotionHost.INSTANCE, this.f3422r);
        MotionHostExtKt.getFx(motionHostCreate).setFrameRate(0);
        this.p = motionHostCreate;
        return motionHostCreate;
    }

    public final void k() {
        this.f3424t.setEmpty();
        this.u.setEmpty();
        PopupWindow popupWindow = this.f3423s;
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    public final void l(boolean z10) {
        View viewT;
        if (this.e == VoiceListenAnimation$WaterBackend.f3399a && (viewT = t()) != null) {
            View rootView = viewT.getRootView();
            int width = rootView.getWidth();
            int height = rootView.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            boolean z11 = this.f3415F || this.f3417H > 0;
            boolean z12 = this.E || this.f3416G > 0;
            FxInstance fxInstance = null;
            c cVar = z11 ? this.k : null;
            c cVar2 = z12 ? this.f3420j : null;
            float f = viewT.getResources().getDisplayMetrics().density;
            Rect rect = new Rect();
            if (cVar != null) {
                N9.j.Q(rect, cVar, width, height, f);
            }
            if (cVar2 != null) {
                N9.j.Q(rect, cVar2, width, height, f);
            }
            if (rect.isEmpty()) {
                rect = null;
            } else {
                int i = (int) (f * 48.0f);
                if (i < 32) {
                    i = 32;
                }
                int i6 = -i;
                rect.inset(i6, i6);
                rect.left = AbstractC1451a.u(rect.left, 0, width - 1);
                rect.top = AbstractC1451a.u(rect.top, 0, height - 1);
                rect.right = AbstractC1451a.u(rect.right, rect.left + 1, width);
                rect.bottom = AbstractC1451a.u(rect.bottom, rect.top + 1, height);
            }
            if (rect == null) {
                return;
            }
            int iMin = (rect.left / 32) * 32;
            int iMin2 = (rect.top / 32) * 32;
            int iMax = ((rect.right + 31) / 32) * 32;
            int iMax2 = ((rect.bottom + 31) / 32) * 32;
            Rect rect2 = this.u;
            if (!rect2.isEmpty()) {
                iMin = Math.min(iMin, rect2.left);
                iMin2 = Math.min(iMin2, rect2.top);
                iMax = Math.max(iMax, rect2.right);
                iMax2 = Math.max(iMax2, rect2.bottom);
            }
            rect2.set(iMin, iMin2, iMax, iMax2);
            int i10 = iMax - iMin;
            if (i10 < 32) {
                i10 = 32;
            }
            int i11 = iMax2 - iMin2;
            int i12 = i11 >= 32 ? i11 : 32;
            FxInstance fxInstance2 = (FxInstance) this.g.get("WaterDrop");
            if (fxInstance2 != null && fxInstance2.getIsActive()) {
                fxInstance = fxInstance2;
            }
            if (fxInstance != null) {
                fxInstance.setUniform("uScreenSize", width, height);
            }
            if (fxInstance != null) {
                fxInstance.setUniform("uViewOrigin", iMin, iMin2);
            }
            if (fxInstance != null) {
                fxInstance.setUniform("uCoordScale", 1.0f);
            }
            Rect rect3 = this.f3424t;
            int i13 = rect3.left;
            PopupWindow popupWindow = this.f3423s;
            if (i13 == iMin && rect3.top == iMin2 && rect3.right == iMin + i10 && rect3.bottom == iMin2 + i12) {
                if (z10 && !popupWindow.isShowing() && viewT.isAttachedToWindow()) {
                    popupWindow.showAtLocation(viewT, 0, iMin, iMin2);
                    return;
                }
                return;
            }
            rect3.set(iMin, iMin2, iMin + i10, iMin2 + i12);
            if (popupWindow.isShowing()) {
                popupWindow.update(iMin, iMin2, i10, i12);
            } else if (z10 && viewT.isAttachedToWindow()) {
                popupWindow.setWidth(i10);
                popupWindow.setHeight(i12);
                popupWindow.showAtLocation(viewT, 0, iMin, iMin2);
            }
        }
    }

    public final void m(ViewGroup viewGroup) {
        float fMin;
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        float f = width;
        float f7 = height;
        c bag = this.l;
        k.f(bag, "bag");
        int iU = 0;
        if (f > 0.0f && f7 > 0.0f) {
            float f9 = f7 >= 1.0f ? f7 : 1.0f;
            float fT = bag.t("uDpRef");
            if (fT > 0.5f) {
                fMin = Math.min(f, f7) / (fT * f9);
            } else {
                float fT2 = bag.t("uPxPerDp");
                if (fT2 <= 0.0f) {
                    iU = (int) (f7 * 0.28f);
                    if (iU < 1) {
                        iU = 1;
                    }
                } else {
                    fMin = fT2 / f9;
                }
            }
            float fMax = (Math.max(bag.t("uGlowUp"), bag.t("uGlowDn")) * fMin) + (Math.abs(bag.t("uAmp")) * fMin * 1.35f) + bag.t("uOffsetY") + 0.5f + 0.04f;
            if (fMax > 0.0f) {
                int i = (int) (fMax * f7 * 1.12f);
                int i6 = (int) f7;
                if (i6 < 1) {
                    i6 = 1;
                }
                iU = AbstractC1451a.u(i, 1, i6);
            }
        }
        if (iU < 32) {
            iU = 32;
        }
        View view = this.f3422r;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-1, iU, 80);
        }
        layoutParams2.width = -1;
        layoutParams2.height = iU;
        layoutParams2.gravity = 80;
        if (view.getParent() != viewGroup) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            viewGroup.addView(view, layoutParams2);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 == null || layoutParams4.height != iU) {
            view.setLayoutParams(layoutParams2);
        }
    }

    public final void n() {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((S7.a) it.next()).invoke();
        }
    }

    public final void o() {
        boolean z10 = this.E;
        VoiceListenAnimation$PlayMask[] voiceListenAnimation$PlayMaskArr = VoiceListenAnimation$PlayMask.f3398a;
        q0 q0Var = this.f3411A;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        this.f3411A = AbstractC1683A.n(this.y, null, new VoiceListenAnimation$playListen$1(this, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.motionkit.a.p():void");
    }

    public final void r() {
        FxInstance fxInstance;
        LinkedHashMap linkedHashMap = this.g;
        FxInstance fxInstance2 = (FxInstance) linkedHashMap.get("WaterDrop");
        VoiceListenAnimation$WaterBackend voiceListenAnimation$WaterBackend = this.e;
        if ((fxInstance2 == null || !fxInstance2.getIsActive()) && voiceListenAnimation$WaterBackend == VoiceListenAnimation$WaterBackend.f3399a) {
            MotionHost motionHost = this.o;
            if (motionHost != null) {
                motionHost.release();
            }
            this.o = null;
        }
        FxInstance fxInstance3 = (FxInstance) linkedHashMap.get("AudioWave");
        if (fxInstance3 == null || !fxInstance3.getIsActive()) {
            if (voiceListenAnimation$WaterBackend == VoiceListenAnimation$WaterBackend.f3399a || (fxInstance = (FxInstance) linkedHashMap.get("WaterDrop")) == null || !fxInstance.getIsActive()) {
                MotionHost motionHost2 = this.p;
                if (motionHost2 != null) {
                    motionHost2.release();
                }
                this.p = null;
                FrameLayout frameLayout = this.f3422r;
                ViewParent parent = frameLayout.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(frameLayout);
                }
            }
        }
    }

    public final void s() {
        LinkedHashMap linkedHashMap = this.g;
        FxInstance fxInstance = (FxInstance) linkedHashMap.remove("WaterDrop");
        if (fxInstance != null) {
            fxInstance.release();
        }
        k();
        FxInstance fxInstance2 = (FxInstance) linkedHashMap.get("AudioWave");
        if ((fxInstance2 == null || !fxInstance2.getIsActive()) && this.f3425v) {
            this.f3425v = false;
            Choreographer.getInstance().removeFrameCallback(this.f3426w);
        }
        r();
    }

    public final View t() {
        View view = this.f3419a;
        View rootView = view.isAttachedToWindow() ? view : view.getRootView().isAttachedToWindow() ? view.getRootView() : null;
        if (rootView == null) {
            return null;
        }
        Context context = rootView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            Context context2 = view.getContext();
            activity = context2 instanceof Activity ? (Activity) context2 : null;
        }
        ViewGroup viewGroup = activity != null ? (ViewGroup) activity.findViewById(R.id.content) : null;
        return (viewGroup == null || !viewGroup.isAttachedToWindow()) ? rootView.getRootView() : viewGroup;
    }

    public final LinkedHashMap u() {
        LinkedHashMap linkedHashMapA = this.f3420j.A();
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(linkedHashMapA.size()));
        for (Map.Entry entry : linkedHashMapA.entrySet()) {
            String strConcat = (String) entry.getKey();
            if (!k.b(strConcat, "uPxPerDp")) {
                strConcat = "uR".concat(m.y0("u", strConcat));
            }
            linkedHashMap.put(strConcat, entry.getValue());
        }
        return linkedHashMap;
    }

    public final void v(float f) {
        e eVar = this.c;
        eVar.getClass();
        float fT = AbstractC1451a.t(f, 0.0f, 1.0f);
        c cVar = eVar.f796a;
        cVar.v("uExtEnergy", new float[]{1.0f}, true);
        cVar.v("uEnergyIn", new float[]{fT}, true);
    }

    public final void w(View view) {
        if (view.isAttachedToWindow()) {
            l(true);
            o.a(this.f3423s);
            view.post(new I4.l(0, view, this));
        }
    }

    public final void x(MotionHost motionHost, EffectDefinition effectDefinition, LinkedHashMap linkedHashMap, S7.k kVar) {
        UniformSpec float4;
        Map mapU = kotlin.collections.a.U(linkedHashMap, new Pair("uPxPerDp", new float[]{motionHost.getView().getResources().getDisplayMetrics().density}));
        FxModule fx = MotionHostExtKt.getFx(motionHost);
        EffectDefinition effectDefinitionCopy$default = effectDefinition;
        k.f(effectDefinitionCopy$default, "<this>");
        if (!mapU.isEmpty()) {
            List<UniformSpec> uniforms = effectDefinitionCopy$default.getUniforms();
            ArrayList arrayList = new ArrayList(w.c0(uniforms, 10));
            for (UniformSpec uniformSpec : uniforms) {
                float[] fArr = (float[]) mapU.get(uniformSpec.getName());
                if (fArr != null) {
                    if (uniformSpec instanceof UniformSpec.Float1) {
                        float4 = new UniformSpec.Float1(uniformSpec.getName(), fArr.length > 0 ? fArr[0] : ((UniformSpec.Float1) uniformSpec).getDefault(), ((UniformSpec.Float1) uniformSpec).getRange(), uniformSpec.getLabel());
                    } else if (uniformSpec instanceof UniformSpec.Float2) {
                        float4 = new UniformSpec.Float2(uniformSpec.getName(), fArr.length > 0 ? fArr[0] : ((UniformSpec.Float2) uniformSpec).getDefaultX(), 1 < fArr.length ? fArr[1] : ((UniformSpec.Float2) uniformSpec).getDefaultY(), uniformSpec.getLabel());
                    } else if (uniformSpec instanceof UniformSpec.Float3) {
                        float4 = new UniformSpec.Float3(uniformSpec.getName(), fArr.length > 0 ? fArr[0] : ((UniformSpec.Float3) uniformSpec).getDefaultX(), 1 < fArr.length ? fArr[1] : ((UniformSpec.Float3) uniformSpec).getDefaultY(), 2 < fArr.length ? fArr[2] : ((UniformSpec.Float3) uniformSpec).getDefaultZ(), uniformSpec.getLabel());
                    } else if (uniformSpec instanceof UniformSpec.Float4) {
                        float4 = new UniformSpec.Float4(uniformSpec.getName(), fArr.length > 0 ? fArr[0] : ((UniformSpec.Float4) uniformSpec).getDefaultX(), 1 < fArr.length ? fArr[1] : ((UniformSpec.Float4) uniformSpec).getDefaultY(), 2 < fArr.length ? fArr[2] : ((UniformSpec.Float4) uniformSpec).getDefaultZ(), 3 < fArr.length ? fArr[3] : ((UniformSpec.Float4) uniformSpec).getDefaultW(), uniformSpec.getLabel());
                    }
                    uniformSpec = float4;
                }
                arrayList.add(uniformSpec);
            }
            effectDefinitionCopy$default = EffectDefinition.copy$default(effectDefinitionCopy$default, null, null, null, arrayList, null, false, null, 119, null);
        }
        FxInstance fxInstancePlay = MotionHostExtKt.play(fx, effectDefinitionCopy$default, kVar);
        if (fxInstancePlay == null) {
            Log.e("MKDemo", "play " + effectDefinition.getName() + " failed");
            return;
        }
        this.g.put(effectDefinition.getName(), fxInstancePlay);
        fxInstancePlay.setSpeed(this.f);
        for (Map.Entry entry : mapU.entrySet()) {
            o.b(fxInstancePlay, (String) entry.getKey(), (float[]) entry.getValue());
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0056 -> B:23:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x009a -> B:47:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$waitReady$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$waitReady$1 r0 = (com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$waitReady$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$waitReady$1 r0 = new com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$waitReady$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 16
            r5 = 60
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L42
            if (r2 == r8) goto L3c
            if (r2 != r6) goto L34
            int r10 = r0.f3409a
            android.view.View r2 = r0.b
            kotlin.b.b(r11)
            goto L9d
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            int r2 = r0.f3409a
            kotlin.b.b(r11)
            goto L59
        L42:
            kotlin.b.b(r11)
            r2 = r7
        L46:
            boolean r11 = r10.g()
            if (r11 != 0) goto L5b
            if (r2 >= r5) goto L5b
            r0.f3409a = r2
            r0.e = r8
            java.lang.Object r11 = kotlinx.coroutines.a.f(r3, r0)
            if (r11 != r1) goto L59
            goto L9c
        L59:
            int r2 = r2 + r8
            goto L46
        L5b:
            com.stepos.motionkit.MotionHost r11 = r10.z()
            if (r11 != 0) goto L64
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            return r10
        L64:
            com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$WaterBackend r11 = com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$WaterBackend.f3399a
            com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$WaterBackend r2 = r10.e
            if (r2 != r11) goto L73
            android.view.View r9 = r10.t()
            if (r9 == 0) goto L73
            r10.w(r9)
        L73:
            if (r2 != r11) goto L78
            android.widget.FrameLayout r10 = r10.f3421q
            goto L7c
        L78:
            android.view.View r10 = r10.t()
        L7c:
            r2 = r10
            r10 = r7
        L7e:
            r11 = 64
            if (r2 == 0) goto L8e
            boolean r9 = r2.isAttachedToWindow()
            if (r9 == 0) goto L8e
            int r9 = r2.getWidth()
            if (r9 >= r11) goto L9f
        L8e:
            if (r10 >= r5) goto L9f
            r0.b = r2
            r0.f3409a = r10
            r0.e = r6
            java.lang.Object r11 = kotlinx.coroutines.a.f(r3, r0)
            if (r11 != r1) goto L9d
        L9c:
            return r1
        L9d:
            int r10 = r10 + r8
            goto L7e
        L9f:
            if (r2 == 0) goto Lae
            boolean r10 = r2.isAttachedToWindow()
            if (r10 == 0) goto Lae
            int r10 = r2.getWidth()
            if (r10 < r11) goto Lae
            r7 = r8
        Lae:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.motionkit.a.y(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final MotionHost z() {
        int iOrdinal = this.e.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                return j();
            }
            throw new NoWhenBranchMatchedException();
        }
        MotionHost motionHost = this.o;
        if (motionHost != null) {
            return motionHost;
        }
        MotionHost motionHostCreate = MotionHostExtKt.create(MotionHost.INSTANCE, this.f3421q);
        MotionHostExtKt.getFx(motionHostCreate).setFrameRate(0);
        this.o = motionHostCreate;
        return motionHostCreate;
    }
}
