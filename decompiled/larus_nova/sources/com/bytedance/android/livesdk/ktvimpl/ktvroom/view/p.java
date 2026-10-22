package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.animation.LinearInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.util.LiveKtvMidiRenderElementFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class p extends com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f145213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f145214l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f145215m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f145216n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SecureRandom f145217o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f145218p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f145219q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<Pair<Integer, Integer>> f145220r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f145221s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f145222t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f145223u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f145224v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f145225w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f145226x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f145227y;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f145228a;

        public a(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.f145228a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            PointF r102 = (PointF) r101;
            r r103 = this.f145228a;
            r103.f145262d = r102.x;
            r r104 = this.f145228a;
            r104.f145263e = r102.y;
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c> f145229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c> f145230b;

        public final void b() {
            this.f145229a.clear();
            this.f145230b.clear();
        }

        public final void c() {
            Iterator<T> r100 = this.f145229a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c) r100.next()).c();
            goto L4
        L6:
            Iterator<T> r101 = this.f145230b.iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c) r101.next()).c();
            goto L8
        }

        public b(int r100) {
            CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c> r101 = new CopyOnWriteArrayList();
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L5;
            r101.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c());
            r102 = r102 + 1;
            goto L3
        L5:
            Unit r103 = Unit.INSTANCE;
            this.f145229a = r101;
            this.f145230b = new CopyOnWriteArrayList();
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.p.c
        public final void a(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c r100) {
            Intrinsics.checkNotNullParameter(r100, "particle");
            if (this.f145230b.remove(r100) == false) goto L6;
            r100.f145265g = false;
            this.f145229a.add(r100);
            return;
        }

        public final void d(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Iterator<T> r101 = this.f145230b.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            ((com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c) r101.next()).b(r100);     // Catch: Exception -> L8
            goto L4
        }
    }

    public interface c {
        void a(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c r100);
    }

    public p() {
        this.f145213k = vm2.h.G();
        this.f145215m = s1.f(92.0f);
        this.f145217o = new SecureRandom();
        this.f145220r = CollectionsKt.listOf(new Pair(Integer.valueOf(s1.f(14.0f)), Integer.valueOf(s1.f(14.0f))));
        this.f145221s = 2000;
        this.f145222t = s1.f(80.0f);
        this.f145223u = s1.f(40.0f);
        this.f145224v = s1.f(70.0f);
        this.f145225w = s1.f(30.0f);
        this.f145226x = s1.f(0.0f);
        this.f145227y = s1.f(2.0f);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void e() {
        super.e();
        b r100 = this.f145218p;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        b r101 = this.f145219q;
        if (r101 == null) goto L9;
        r101.c();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.t
    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        b r101 = this.f145218p;
        if (r101 == null) goto L5;
        r101.d(r100);
    L5:
        b r102 = this.f145219q;
        if (r102 == null) goto L9;
        r102.d(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void d(db0.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f144970e = r100;
        b r101 = this.f145218p;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        b r102 = this.f145219q;
        if (r102 == null) goto L8;
        r102.b();
    L8:
        com.bytedance.android.live.ktv.common.midi.g r103 = this.f144969d;
        if (r103 == null) goto L11;
        int r104 = r103.F();
    L12:
        this.f145218p = new b(r104);
        com.bytedance.android.live.ktv.common.midi.g r105 = this.f144969d;
        if (r105 == null) goto L15;
        int r106 = r105.D();
    L16:
        this.f145219q = new b(r106);
        return;
    L15:
        r106 = vm2.h.w();
        goto L16
    L11:
        r104 = 4;
        goto L12
    }

    public final PointF i(PointF r100, PointF r101) {
        float r102 = r100.x - r101.x;
        int r103 = (int) ((r100.y - r101.y) + 1);
        if (r103 <= 0) goto L5;
        int r104 = this.f145217o.nextInt(r103);
    L6:
        float r105 = r101.x + (r102 / 2);
        float r106 = this.f145227y;
        return new PointF(r105 - r106, (r101.y + r104) - r106);
    L5:
        r104 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void b(com.bytedance.android.live.ktv.common.midi.k r210, Long r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r210, "scoreInfo");
        super.b(r210, r211, r212);
        s r100 = this.f144975j;
        if (r100 != null) goto L5;
        return;
    L5:
        Pair<Float, Float> r101 = r100.f145270b;
        int r102 = r100.f145272d;
        boolean r103 = r100.f145271c;
        if (c(r210) == false) goto L108;
        com.bytedance.android.live.ktv.common.midi.f r104 = this.f144968c;
        if (r104 == null) goto L110;
        boolean r105 = true;
        if (r104.a() != true) goto L111;
        long r106 = this.f145214l % ((long) this.f145213k);
        this.f145214l = 1 + r106;
        if (r106 != 0) goto L112;
        float r107 = r101.getFirst().floatValue();
        float r108 = r101.getSecond().floatValue();
        Integer r109 = Integer.valueOf(r102);
        int r110 = 0;
        if (r103 == true) goto L23;
        b r111 = this.f145218p;
        if (r111 != null) goto L18;
        return;
    L18:
        if (r111.f145229a.size() <= 0) goto L20;
        boolean r112 = true;
    L21:
        if (r112 == true) goto L23;
        return;
    L20:
        r112 = false;
    L23:
        if (r103 == false) goto L32;
        b r113 = this.f145219q;
        if (r113 != null) goto L27;
        return;
    L27:
        if (r113.f145229a.size() <= 0) goto L29;
        boolean r114 = true;
    L30:
        if (r114 == true) goto L32;
        return;
    L29:
        r114 = false;
    L32:
        this.f145216n = r108;
        com.bytedance.android.live.ktv.common.midi.g r115 = this.f144969d;
        if (r115 == null) goto L115;
        List<Bitmap> r116 = r115.I(r109, r103);
        if (r116 == null) goto L118;
        p r117 = this;
        int r118 = 0;
    L38:
        int r119 = r117.f145217o.nextInt(r116.size());
        int r120 = r117.f145217o.nextInt(r117.f145220r.size());
        if (r103 == false) goto L41;
        boolean r121 = r117.f145217o.nextBoolean();
    L42:
        if (r103 == false) goto L44;
        b r122 = r117.f145219q;
    L45:
        Bitmap r123 = (Bitmap) ListProtector.get(r116, r119);
        if (r122 != null) goto L48;
    L104:
        List<Bitmap> r213 = r116;
    L106:
        if (r118 == 1) goto L119;
        r118 = r118 + 1;
        r103 = r103;
        r107 = r107;
        r108 = r108;
        r116 = r213;
        r105 = true;
        r110 = 0;
        goto L38
    L119:
        return;
    L48:
        if (r122.f145229a.size() > 0) goto L50;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.c r124 = null;
    L53:
        if (r124 == null) goto L104;
        r124.d(r123);
        r124.f145265g = r105;
        r124.f145259a = 1.0f;
        Pair r125 = (Pair) ListProtector.get(r117.f145220r, r120);
        r124.f145266h.set(0.0f, 0.0f, ((Number) r125.getFirst()).intValue(), ((Number) r125.getSecond()).intValue());
        r124.f145262d = r107;
        r124.f145263e = r108;
        if (r103 == false) goto L57;
        int r126 = r117.f145222t;
    L58:
        if (r103 == false) goto L60;
        int r127 = r117.f145223u;
    L61:
        int r128 = r117.f145217o.nextInt((r126 * 2) / 3);
        int r129 = r117.f145217o.nextInt(r127);
        if (r121 == false) goto L64;
        float r130 = (((r117.f145216n + r117.f145226x) - r127) + r129) - r117.f145227y;
    L65:
        PointF r131 = new PointF(((r117.f145215m - r126) + r128) - r117.f145227y, r130 % r117.f144966a);
        float r132 = r117.f145215m;
        float r133 = r117.f145227y;
        PointF r134 = new PointF(r132 - r133, (r117.f145216n + r117.f145226x) - r133);
        if (r103 == false) goto L68;
        int r135 = r117.f145222t;
    L69:
        if (r103 == false) goto L71;
        int r136 = r117.f145223u;
    L72:
        if (r103 == false) goto L74;
        long r137 = 2500;
    L75:
        float r138 = r134.x - r131.x;
        float r139 = r134.y - r131.y;
        r117.f145221s = (long) ((Math.sqrt((r138 * r138) + (r139 * r139)) / ((double) ((int) Math.sqrt((r135 * r135) + (r136 * r136))))) * r137);
        if (KtvSettingHelper.o() == false) goto L78;
    L81:
        ValueAnimator r140 = LiveDegradeFpsAnimator.ofObject(new com.bytedance.android.live.ktv.common.midi.a(r117.i(r134, r131)), new Object[]{r134, r131}).setFpsConfig(KtvSettingHelper.k());
    L82:
        r140.addUpdateListener(new a(r124));
        r140.setTarget(r124);
        r140.setDuration(r117.f145221s);
        LiveKtvMidiRenderElementFpsAnimator r141 = LiveKtvMidiRenderElementFpsAnimator.a(r124, "rotation", new float[]{0.0f, 360.0f});
        int r142 = KtvSettingHelper.k();
        if (r142 <= 0) goto L85;
        r141.f145337a = r142;
    L85:
        r141.setDuration(r117.f145221s);
        AnimatorSet r143 = new AnimatorSet();
        r143.playTogether(new Animator[]{r141, r140});
        LiveKtvMidiRenderElementFpsAnimator r144 = LiveKtvMidiRenderElementFpsAnimator.a(r124, "alpha", new float[]{0.0f, 1.0f});
        int r145 = KtvSettingHelper.k();
        if (r145 <= 0) goto L88;
        r144.f145337a = r145;
    L88:
        LiveKtvMidiRenderElementFpsAnimator r146 = LiveKtvMidiRenderElementFpsAnimator.a(r124, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f});
        int r147 = KtvSettingHelper.k();
        if (r147 <= 0) goto L91;
        r146.f145337a = r147;
    L91:
        LiveKtvMidiRenderElementFpsAnimator r148 = LiveKtvMidiRenderElementFpsAnimator.a(r124, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f});
        int r149 = KtvSettingHelper.k();
        if (r149 <= 0) goto L94;
        r148.f145337a = r149;
    L94:
        AnimatorSet r150 = new AnimatorSet();
        r213 = r116;
        r150.setDuration(r117.f145221s / ((long) 3));
        r150.setInterpolator(new LinearInterpolator());
        r150.playTogether(new Animator[]{r144, r146, r148});
        r150.setTarget(r124);
        LiveKtvMidiRenderElementFpsAnimator r151 = LiveKtvMidiRenderElementFpsAnimator.a(r124, "alpha", new float[]{1.0f, 0.0f});
        int r152 = KtvSettingHelper.k();
        if (r152 <= 0) goto L97;
        r151.f145337a = r152;
    L97:
        LiveKtvMidiRenderElementFpsAnimator r153 = LiveKtvMidiRenderElementFpsAnimator.a(r124, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.0f});
        int r154 = KtvSettingHelper.k();
        if (r154 <= 0) goto L100;
        r153.f145337a = r154;
    L100:
        LiveKtvMidiRenderElementFpsAnimator r155 = LiveKtvMidiRenderElementFpsAnimator.a(r124, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.0f});
        int r156 = KtvSettingHelper.k();
        if (r156 <= 0) goto L103;
        r155.f145337a = r156;
    L103:
        AnimatorSet r157 = new AnimatorSet();
        r157.setDuration(this.f145221s / ((long) 5));
        r157.setInterpolator(new LinearInterpolator());
        r157.setStartDelay(this.f145221s - r157.getDuration());
        r157.playTogether(new Animator[]{r151, r153, r155});
        r157.setTarget(r124);
        AnimatorSet r158 = new AnimatorSet();
        r158.playTogether(new Animator[]{r150, r143, r157});
        r158.setInterpolator(new LinearInterpolator());
        r158.setTarget(r124);
        r158.addListener(new q(r124, r122));
        r158.start();
        r117 = this;
        goto L106
    L78:
        if (KtvSettingHelper.z() == true) goto L81;
        r140 = ValueAnimator.ofObject(new com.bytedance.android.live.ktv.common.midi.a(r117.i(r134, r131)), new Object[]{r134, r131});
        goto L82
    L74:
        r137 = 2000;
        goto L75
    L71:
        r136 = r117.f145225w;
        goto L72
    L68:
        r135 = r117.f145224v;
        goto L69
    L64:
        r130 = (((r117.f145216n + r117.f145226x) + r127) - r129) + r117.f145227y;
        goto L65
    L60:
        r127 = r117.f145225w;
        goto L61
    L57:
        r126 = r117.f145224v;
        goto L58
    L50:
        r124 = r122.f145229a.remove(r110);
        if (r124 == null) goto L53;
        r124.f145265g = r105;
        r124.f145259a = 1.0f;
        r122.f145230b.add(r124);
        goto L53
    L44:
        r122 = r117.f145218p;
        goto L45
    L41:
        r121 = true;
        goto L42
    L118:
        return;
    L115:
        return;
    L112:
        return;
    L111:
        return;
    L110:
        return;
    }
}
