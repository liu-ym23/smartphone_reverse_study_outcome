package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.util.LiveKtvMidiRenderElementFpsAnimator;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f145113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f145114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f145115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f145116n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f145117o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f145118p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final u f145119q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final u f145120r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f145121s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AnimatorSet f145122t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f145123u;

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void f() {
        AnimatorSet r100 = this.f145122t;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        AnimatorSet r101 = this.f145123u;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f145117o.a();
        this.f145118p.a();
        this.f145119q.a();
        this.f145120r.a();
        this.f145121s.a();
    }

    public i() {
        this.f145113k = UtilityKotlinExtentionsKt.h(96);
        this.f145114l = UtilityKotlinExtentionsKt.h(56);
        float r100 = 10;
        this.f145115m = UtilityKotlinExtentionsKt.h(r100);
        this.f145116n = UtilityKotlinExtentionsKt.h(r100);
        this.f145117o = new c();
        this.f145118p = new c();
        this.f145119q = new u();
        this.f145120r = new u();
        this.f145121s = new c();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void e() {
        super.e();
        AnimatorSet r100 = this.f145122t;
        if (r100 != null) goto L5;
    L9:
        AnimatorSet r101 = this.f145123u;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.isRunning() != true) goto L18;
        AnimatorSet r102 = this.f145123u;
        if (r102 == null) goto L19;
        r102.cancel();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r100.isRunning() != true) goto L9;
        AnimatorSet r103 = this.f145122t;
        if (r103 == null) goto L9;
        r103.cancel();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.t
    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f145117o.b(r100);
        this.f145118p.b(r100);
        this.f145121s.b(r100);
        this.f145119q.b(r100);
        this.f145120r.b(r100);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void d(db0.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f144970e = r100;
        float r101 = this.f144966a;
        float r102 = this.f145114l;
        float r103 = r101 - r102;
        float r104 = this.f144967b;
        float r105 = r104 - this.f145113k;
        float r106 = this.f145115m;
        float r107 = r105 - r106;
        float r108 = r102 + r103;
        float r109 = r104 - r106;
        this.f145118p.f145266h.set(r105, r103, r104, r108);
        this.f145117o.f145266h.set(r107, r103, r109, r108);
        this.f145121s.f145266h.set(r107, r103, r109, r108);
        this.f145117o.f144979l = true;
        this.f145121s.f144979l = true;
        u r110 = this.f145119q;
        float r111 = this.f145116n;
        r110.f145336n = r111;
        r110.f145335m.setTextSize(r111);
        u r112 = this.f145120r;
        float r113 = this.f145116n;
        r112.f145336n = r113;
        r112.f145335m.setTextSize(r113);
        this.f145119q.f145335m.setColor(-1);
        this.f145120r.f145335m.setColor(-1);
        Typeface r114 = Typeface.create(Typeface.createFromAsset(jc1.a.b().getAssets(), "font/ttlive_ktv_midi_combo_font.ttf"), 2);     // Catch: Exception -> L5
        u r115 = this.f145119q;     // Catch: Exception -> L5
        r115.getClass();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r114, "<set-?>");     // Catch: Exception -> L5
        r115.f145334l = r114;     // Catch: Exception -> L5
        u r116 = this.f145120r;     // Catch: Exception -> L5
        r116.getClass();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r114, "<set-?>");     // Catch: Exception -> L5
        r116.f145334l = r114;     // Catch: Exception -> L5
    L7:
        float r117 = this.f145119q.f145335m.measureText("x444");
        Paint.FontMetrics r118 = this.f145119q.f145335m.getFontMetrics();
        float r119 = (r118.bottom - r118.top) + r118.leading;
        float r120 = this.f144967b;
        float r121 = this.f145115m;
        float r122 = (r120 - r117) - r121;
        float r123 = this.f144966a;
        float r124 = (r123 - r119) - r121;
        float r125 = r120 - r121;
        float r126 = r123 - r121;
        this.f145119q.f145266h.set(r122, r124, r125, r126);
        this.f145120r.f145266h.set(r122, r124, r125, r126);
        return;
    L5:
        e = move-exception;
        ALogger.e("KtvRoomMidiHitDisplayView", "load font asset exception: " + e.getMessage());
        goto L7
    }

    public static final void i(i r100, String r101, Bitmap r102) {
        r100.f145118p.f145265g = true;
        c r103 = r100.f145118p;
        r103.f144982o = r101;
        r103.d(r102);
        AnimatorSet r104 = r100.f145122t;
        if (r104 == null) goto L6;
        r104.start();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void b(com.bytedance.android.live.ktv.common.midi.k r310, Long r311, boolean r312) {
        i r110 = this;
        Intrinsics.checkNotNullParameter(r310, "scoreInfo");
        super.b(r310, r311, r312);
        s r100 = r110.f144975j;
        if (r100 == null) goto L5;
        int r101 = r100.f145269a;
    L6:
        int r102 = r310.f69864e;
        if (r101 == r102) goto L240;
        if (r310.f69863d <= 0) goto L240;
        if (r102 < 0) goto L240;
        com.bytedance.android.live.ktv.common.midi.f r103 = r110.f144968c;
        if (r103 != null) goto L14;
    L227:
        i r104 = r110;
    L229:
        Integer r105 = r310.f69865f;
        if (r105 == null) goto L232;
        int r111 = r105.intValue();
    L233:
        s r106 = r104.f144975j;
        if (r106 == null) goto L236;
        r106.f145269a = r310.f69864e;
    L236:
        if (r111 <= 0) goto L241;
        if (r106 == null) goto L242;
        r106.f145272d = r111;
        return;
    L242:
        return;
    L241:
        return;
    L232:
        r111 = 0;
        goto L233
    L14:
        if (r103.d() != true) goto L227;
        Integer r107 = r310.f69865f;
        if (r107 == null) goto L18;
        int r108 = r107.intValue();
    L19:
        int r109 = r310.f69866g;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiView", "showHitAnimation hitType " + r108 + " comboCount " + r109);
        s r112 = r110.f144975j;
        if (r112 == null) goto L22;
        boolean r113 = r112.f145271c;
    L23:
        int r114 = KtvSettingHelper.l();
        if (r108 != 3) goto L30;
        if (r113 == true) goto L30;
        if (r109 < r114) goto L30;
        s r115 = r110.f144975j;
        if (r115 == null) goto L36;
        r115.f145271c = true;
    L36:
        if (r113 == false) goto L40;
        com.bytedance.android.live.ktv.common.midi.g r116 = r110.f144969d;
        if (r116 == null) goto L40;
        r116.H();
        boolean r117 = true;
    L41:
        com.bytedance.android.live.ktv.common.midi.e.b("KtvRoomMidiHitDisplayView", "showHitAnimation hitType " + r108 + " comboCount " + r109 + "  isAdvanced " + r117);
        com.bytedance.android.live.ktv.common.midi.g r118 = r110.f144969d;
        if (r118 == null) goto L227;
        String r119 = r118.K(r108, r117);
        if (r119 == null) goto L227;
        com.bytedance.android.live.ktv.common.midi.g r120 = r110.f144969d;
        if (r120 == null) goto L50;
        String r121 = r120.J();
    L52:
        if (r108 == 1) goto L195;
        if (r108 == 2) goto L195;
        if (r108 == 3) goto L57;
    L121:
        r104 = r110;
        goto L229
    L57:
        if (r117 == false) goto L123;
        if (r121 != null) goto L60;
        r121 = com.bytedance.android.live.ktv.common.midi.c.f69839a;
    L60:
        r110.f145119q.f145333k = "x" + r109;
        r110.f145120r.f145333k = "x" + r109;
        final LiveKtvMidiRenderElementFpsAnimator r122 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145119q, "alpha", new float[]{0.0f, 1.0f});
        int r123 = KtvSettingHelper.k();
        if (r123 <= 0) goto L63;
        r122.f145337a = r123;
    L63:
        r122.setStartDelay(400);
        r122.setDuration(300);
        r122.setInterpolator(new LinearInterpolator());
        final LiveKtvMidiRenderElementFpsAnimator r124 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145119q, LiveDegradeFpsAnimator.SCALE_X, new float[]{2.0f, 1.0f});
        int r125 = KtvSettingHelper.k();
        if (r125 <= 0) goto L66;
        r124.f145337a = r125;
    L66:
        r124.setStartDelay(400);
        r124.setDuration(300);
        r124.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r126 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145119q, LiveDegradeFpsAnimator.SCALE_Y, new float[]{2.0f, 1.0f});
        int r127 = KtvSettingHelper.k();
        if (r127 <= 0) goto L69;
        r126.f145337a = r127;
    L69:
        r126.setStartDelay(400);
        r126.setDuration(300);
        r126.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r128 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145119q, "alpha", new float[]{1.0f, 0.0f});
        int r129 = KtvSettingHelper.k();
        if (r129 <= 0) goto L72;
        r128.f145337a = r129;
    L72:
        r128.setStartDelay(1800);
        r128.setDuration(200);
        r128.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r130 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145120r, "alpha", new float[]{0.0f, 1.0f});
        int r131 = KtvSettingHelper.k();
        if (r131 <= 0) goto L75;
        r130.f145337a = r131;
    L75:
        long r132 = 700;
        r130.setStartDelay(700);
        r130.setDuration(300);
        r130.setInterpolator(new LinearInterpolator());
        final LiveKtvMidiRenderElementFpsAnimator r133 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145120r, "alpha", new float[]{1.0f, 0.0f});
        int r134 = KtvSettingHelper.k();
        if (r134 <= 0) goto L78;
        r133.f145337a = r134;
        r132 = 700;
    L78:
        r133.setStartDelay(r132);
        r133.setDuration(300);
        r133.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r135 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145120r, LiveDegradeFpsAnimator.SCALE_X, new float[]{2.0f, 1.0f});
        int r136 = KtvSettingHelper.k();
        if (r136 <= 0) goto L81;
        r135.f145337a = r136;
    L81:
        r135.setStartDelay(700);
        r135.setDuration(300);
        String r137 = r121;
        r135.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r138 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145120r, LiveDegradeFpsAnimator.SCALE_Y, new float[]{2.0f, 1.0f});
        int r139 = KtvSettingHelper.k();
        if (r139 <= 0) goto L84;
        r138.f145337a = r139;
    L84:
        r138.setStartDelay(700);
        r138.setDuration(300);
        r138.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r140 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145121s, LiveDegradeFpsAnimator.SCALE_X, new float[]{3.0f, 1.0f});
        int r141 = KtvSettingHelper.k();
        if (r141 <= 0) goto L87;
        r140.f145337a = r141;
    L87:
        r140.setStartDelay(200);
        r140.setDuration(200);
        r140.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r142 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145121s, LiveDegradeFpsAnimator.SCALE_Y, new float[]{3.0f, 1.0f});
        int r143 = KtvSettingHelper.k();
        if (r143 <= 0) goto L90;
        r142.f145337a = r143;
    L90:
        r142.setStartDelay(200);
        r142.setDuration(200);
        r142.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r144 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145121s, "alpha", new float[]{0.0f, 1.0f});
        int r145 = KtvSettingHelper.k();
        if (r145 <= 0) goto L93;
        r144.f145337a = r145;
    L93:
        r144.setStartDelay(200);
        r144.setDuration(200);
        r144.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r146 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145121s, "alpha", new float[]{1.0f, 0.0f});
        int r147 = KtvSettingHelper.k();
        if (r147 <= 0) goto L96;
        r146.f145337a = r147;
    L96:
        r146.setStartDelay(1800);
        r146.setDuration(200);
        r146.setInterpolator(new LinearInterpolator());
        LiveKtvMidiRenderElementFpsAnimator r148 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145117o, "alpha", new float[]{0.0f, 1.0f});
        int r149 = KtvSettingHelper.k();
        if (r149 <= 0) goto L99;
        r148.f145337a = r149;
    L99:
        r148.setDuration(200);
        r148.setInterpolator(new LinearInterpolator());
        LiveKtvMidiRenderElementFpsAnimator r150 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145117o, "alpha", new float[]{1.0f, 0.0f});
        int r151 = KtvSettingHelper.k();
        if (r151 <= 0) goto L102;
        r150.f145337a = r151;
    L102:
        r150.setStartDelay(2000);
        r150.setDuration(200);
        r150.setInterpolator(new LinearInterpolator());
        AnimatorSet r152 = new AnimatorSet();
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r152, new KtvMidiComboRender$showAdvancedPerfectCombo$$inlined$apply$lambda$1(this, r122, r124, r126, r140, r142, r144, r146, r128, r130, r133, r138, r135));
        r152.playTogether(new Animator[]{r122, r124, r126, r140, r142, r144, r146, r128, r130, r133, r138, r135});
        Unit r153 = Unit.INSTANCE;
        r110 = this;
        r110.f145122t = r152;
        AnimatorSet r154 = new AnimatorSet();
        r154.playTogether(new Animator[]{r150, r148});
        r110.f145123u = r154;
        if ((!Intrinsics.areEqual(r137, r110.f145117o.f144982o)) == true) goto L111;
        c r155 = r110.f145117o;
        if (r155.f144981n == null) goto L111;
        r155.f145265g = true;
        AnimatorSet r156 = r110.f145123u;
        if (r156 == null) goto L110;
        r156.start();
    L110:
        String r157 = r119;
    L113:
        if ((!Intrinsics.areEqual(r157, r110.f145121s.f144982o)) == true) goto L120;
        c r158 = r110.f145121s;
        if (r158.f144981n == null) goto L120;
        r158.f145265g = true;
        r110.f145119q.f145265g = true;
        r110.f145120r.f145265g = true;
        AnimatorSet r159 = r110.f145122t;
        if (r159 == null) goto L121;
        r159.start();
    L120:
        ImageLoader.downloadBitmap(r157, new e(r110, r157));
    L111:
        r157 = r119;
        ImageLoader.downloadBitmap(r137, new d(r110, r157));
        goto L113
    L123:
        if (r109 <= 1) goto L163;
        r110.f145119q.f145333k = "x" + r109;
        r110.f145119q.f145265g = true;
        final LiveKtvMidiRenderElementFpsAnimator r160 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145119q, "alpha", new float[]{0.0f, 1.0f});
        int r161 = KtvSettingHelper.k();
        if (r161 <= 0) goto L127;
        r160.f145337a = r161;
    L127:
        r160.setDuration(300);
        r160.setInterpolator(new LinearInterpolator());
        final LiveKtvMidiRenderElementFpsAnimator r162 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145119q, LiveDegradeFpsAnimator.SCALE_X, new float[]{2.0f, 1.0f});
        int r163 = KtvSettingHelper.k();
        if (r163 <= 0) goto L130;
        r162.f145337a = r163;
    L130:
        r162.setDuration(300);
        r162.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r164 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145119q, LiveDegradeFpsAnimator.SCALE_Y, new float[]{2.0f, 1.0f});
        int r165 = KtvSettingHelper.k();
        if (r165 <= 0) goto L133;
        r164.f145337a = r165;
    L133:
        r164.setDuration(300);
        r164.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r166 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145118p, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.3f});
        int r167 = KtvSettingHelper.k();
        if (r167 <= 0) goto L136;
        r166.f145337a = r167;
    L136:
        r166.setStartDelay(150);
        r166.setDuration(90);
        r166.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r168 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145118p, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.3f});
        int r169 = KtvSettingHelper.k();
        if (r169 <= 0) goto L139;
        r168.f145337a = r169;
    L139:
        r168.setStartDelay(150);
        r168.setDuration(90);
        r168.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r170 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145118p, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.3f, 1.0f});
        int r171 = KtvSettingHelper.k();
        if (r171 <= 0) goto L142;
        r170.f145337a = r171;
    L142:
        r170.setStartDelay(270);
        r170.setDuration(80);
        r170.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r172 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145118p, "alpha", new float[]{0.0f, 1.0f});
        int r173 = KtvSettingHelper.k();
        if (r173 <= 0) goto L145;
        r172.f145337a = r173;
    L145:
        r172.setDuration(300);
        r172.setInterpolator(new LinearInterpolator());
        final LiveKtvMidiRenderElementFpsAnimator r174 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145118p, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.3f, 1.0f});
        int r175 = KtvSettingHelper.k();
        if (r175 <= 0) goto L148;
        r174.f145337a = r175;
    L148:
        r174.setStartDelay(270);
        r174.setDuration(80);
        r174.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r176 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145119q, "alpha", new float[]{1.0f, 0.0f});
        int r177 = KtvSettingHelper.k();
        if (r177 <= 0) goto L151;
        r176.f145337a = r177;
    L151:
        r176.setStartDelay(1300);
        r176.setDuration(200);
        r176.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r178 = LiveKtvMidiRenderElementFpsAnimator.a(r110.f145118p, "alpha", new float[]{1.0f, 0.0f});
        int r179 = KtvSettingHelper.k();
        if (r179 <= 0) goto L154;
        r178.f145337a = r179;
    L154:
        r178.setStartDelay(1300);
        r178.setDuration(200);
        r178.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        AnimatorSet r180 = new AnimatorSet();
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r180, new KtvMidiComboRender$showPerfectCombo$$inlined$apply$lambda$1(this, r160, r162, r164, r166, r172, r168, r170, r174, r176, r178));
        r180.playTogether(new Animator[]{r160, r162, r164, r166, r172, r168, r170, r174, r176, r178});
        Unit r181 = Unit.INSTANCE;
        r104 = this;
        r104.f145122t = r180;
        if ((!Intrinsics.areEqual(r119, r104.f145118p.f144982o)) == true) goto L162;
        c r182 = r104.f145118p;
        if (r182.f144981n == null) goto L162;
        r182.f145265g = true;
        r104.f145119q.f145265g = true;
        AnimatorSet r183 = r104.f145122t;
        if (r183 == null) goto L229;
        r183.start();
    L162:
        ImageLoader.downloadBitmap(r119, new g(r104, r119));
        goto L229
    L163:
        r104 = r110;
        AnimatorSet r184 = r104.f145122t;
        if (r184 == null) goto L168;
        boolean r185 = true;
        if (r184.isRunning() == true) goto L229;
    L169:
        AnimatorSet r186 = r104.f145123u;
        if (r186 != null) goto L172;
    L174:
        final LiveKtvMidiRenderElementFpsAnimator r187 = LiveKtvMidiRenderElementFpsAnimator.a(r104.f145118p, "alpha", new float[]{0.0f, 1.0f});
        int r188 = KtvSettingHelper.k();
        if (r188 <= 0) goto L177;
        r187.f145337a = r188;
    L177:
        r187.setDuration(200);
        r187.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r189 = LiveKtvMidiRenderElementFpsAnimator.a(r104.f145118p, LiveDegradeFpsAnimator.SCALE_X, new float[]{2.0f, 1.0f});
        int r190 = KtvSettingHelper.k();
        if (r190 <= 0) goto L180;
        r189.f145337a = r190;
    L180:
        r189.setDuration(200);
        r189.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r191 = LiveKtvMidiRenderElementFpsAnimator.a(r104.f145118p, LiveDegradeFpsAnimator.SCALE_Y, new float[]{2.0f, 1.0f});
        int r192 = KtvSettingHelper.k();
        if (r192 <= 0) goto L183;
        r191.f145337a = r192;
    L183:
        r191.setDuration(200);
        r191.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        final LiveKtvMidiRenderElementFpsAnimator r193 = LiveKtvMidiRenderElementFpsAnimator.a(r104.f145118p, "alpha", new float[]{1.0f, 0.0f});
        int r194 = KtvSettingHelper.k();
        if (r194 <= 0) goto L186;
        r193.f145337a = r194;
    L186:
        r193.setDuration(200);
        r193.setStartDelay(1500);
        r193.setInterpolator(new LinearInterpolator());
        AnimatorSet r195 = new AnimatorSet();
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r195, new KtvMidiComboRender$showPerfectHit$$inlined$apply$lambda$1(this, r191, r189, r187, r193));
        r195.playTogether(new Animator[]{r191, r189, r187, r193});
        Unit r196 = Unit.INSTANCE;
        r104.f145122t = r195;
        if ((!Intrinsics.areEqual(r119, r104.f145118p.f144982o)) == true) goto L194;
        c r197 = r104.f145118p;
        if (r197.f144981n == null) goto L194;
        r197.f145265g = true;
        AnimatorSet r198 = r104.f145122t;
        if (r198 == null) goto L229;
        r198.start();
    L194:
        ImageLoader.downloadBitmap(r119, new h(r104, r119));
        goto L229
    L172:
        if (r186.isRunning() != r185) goto L174;
    L168:
        r185 = true;
    L195:
        r104 = r110;
        AnimatorSet r199 = r104.f145122t;
        if (r199 == null) goto L200;
        boolean r200 = true;
        if (r199.isRunning() == true) goto L229;
    L201:
        AnimatorSet r201 = r104.f145123u;
        if (r201 != null) goto L204;
    L206:
        final LiveKtvMidiRenderElementFpsAnimator r1100 = LiveKtvMidiRenderElementFpsAnimator.a(r104.f145118p, "alpha", new float[]{0.0f, 1.0f});
        r1100.setDuration(200);
        r1100.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        int r202 = KtvSettingHelper.k();
        if (r202 <= 0) goto L209;
        r1100.f145337a = r202;
    L209:
        final LiveKtvMidiRenderElementFpsAnimator r1101 = LiveKtvMidiRenderElementFpsAnimator.a(r104.f145118p, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.6f, 1.0f});
        r1101.setDuration(200);
        r1101.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        int r203 = KtvSettingHelper.k();
        if (r203 <= 0) goto L212;
        r1101.f145337a = r203;
    L212:
        final LiveKtvMidiRenderElementFpsAnimator r1102 = LiveKtvMidiRenderElementFpsAnimator.a(r104.f145118p, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.6f, 1.0f});
        r1102.setDuration(200);
        r1102.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        int r204 = KtvSettingHelper.k();
        if (r204 <= 0) goto L215;
        r1102.f145337a = r204;
    L215:
        final LiveKtvMidiRenderElementFpsAnimator r205 = LiveKtvMidiRenderElementFpsAnimator.a(r104.f145118p, "alpha", new float[]{1.0f, 0.0f});
        r205.setDuration(200);
        r205.setStartDelay(1500);
        r205.setInterpolator(new LinearInterpolator());
        int r206 = KtvSettingHelper.k();
        if (r206 <= 0) goto L218;
        r205.f145337a = r206;
    L218:
        AnimatorSet r207 = new AnimatorSet();
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r207, new KtvMidiComboRender$showGoodOrGreatHit$$inlined$apply$lambda$1(this, r1102, r1101, r1100, r205));
        r207.playTogether(new Animator[]{r1102, r1101, r1100, r205});
        Unit r208 = Unit.INSTANCE;
        r104.f145122t = r207;
        if ((!Intrinsics.areEqual(r119, r104.f145118p.f144982o)) == true) goto L226;
        c r209 = r104.f145118p;
        if (r209.f144981n == null) goto L226;
        r209.f145265g = true;
        AnimatorSet r210 = r104.f145122t;
        if (r210 == null) goto L229;
        r210.start();
    L226:
        ImageLoader.downloadBitmap(r119, new f(r104, r119));
        goto L229
    L204:
        if (r201.isRunning() != r200) goto L206;
    L200:
        r200 = true;
        goto L201
    L50:
        r121 = null;
    L40:
        r117 = false;
    L30:
        if (r108 == 3) goto L36;
        if (r113 == false) goto L36;
        if (r109 >= r114) goto L36;
        s r211 = r110.f144975j;
        if (r211 == null) goto L36;
        r211.f145271c = false;
        goto L36
    L22:
        r113 = false;
        goto L23
    L18:
        r108 = 0;
    L240:
        return;
    L5:
        r101 = -1;
        goto L6
    }
}
