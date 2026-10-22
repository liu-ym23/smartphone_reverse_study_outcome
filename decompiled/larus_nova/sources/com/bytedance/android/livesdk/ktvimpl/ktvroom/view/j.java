package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.util.LiveKtvMidiRenderElementFpsAnimator;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import java.text.DecimalFormat;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j extends com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a {
    public final Handler A;
    public AnimatorSet B;
    public AnimatorSet C;
    public float D;
    public final int E;
    public final Bitmap F;
    public final Bitmap G;
    public final Bitmap H;
    public final Bitmap I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Bitmap f145124J;
    public final Bitmap K;
    public boolean L;
    public final c M;
    public final c N;
    public final c O;
    public final u P;
    public final c Q;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f145125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f145126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f145127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f145128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f145129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f145130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f145131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f145132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f145133s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f145134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f145135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f145136v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LiveDegradeFpsAnimator f145137w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f145138x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f145139y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f145140z;

    public static final class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f145141a;

        public a(j r100) {
            this.f145141a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            int r111 = r110.what;
            if (r111 == 0) goto L30;
            if (r111 != 1) goto L62;
            j r112 = this.f145141a;
            r112.f145140z = false;
            AnimatorSet r100 = r112.C;
            if (r100 != null) goto L9;
        L11:
            AnimatorSet r101 = r112.B;
            if (r101 != null) goto L14;
        L18:
            LiveKtvMidiRenderElementFpsAnimator r102 = LiveKtvMidiRenderElementFpsAnimator.a(r112.M, "alpha", new float[]{1.0f, 0.0f});
            int r103 = KtvSettingHelper.k();
            if (r103 <= 0) goto L21;
            r102.f145337a = r103;
        L21:
            r102.setDuration(500);
            r102.setInterpolator(new LinearInterpolator());
            LiveKtvMidiRenderElementFpsAnimator r104 = LiveKtvMidiRenderElementFpsAnimator.a(r112.Q, "alpha", new float[]{1.0f, 0.0f});
            int r105 = KtvSettingHelper.k();
            if (r105 <= 0) goto L24;
            r104.f145337a = r105;
        L24:
            r104.setDuration(500);
            r104.setInterpolator(new LinearInterpolator());
            com.bytedance.android.live.ktv.common.midi.g r106 = r112.f144969d;
            if (r106 != null) goto L27;
        L29:
            AnimatorSet r107 = new AnimatorSet();
            r107.playTogether(new Animator[]{r102, r104});
            r107.addListener(new l(r112));
            Unit r108 = Unit.INSTANCE;
            r112.C = r107;
            r107.start();
            goto L62
        L27:
            if (r106.getCurrentMode() != 1) goto L29;
            AnimatorSet r109 = new AnimatorSet();
            r109.playTogether(new Animator[]{r102});
            r109.addListener(new k(r112));
            Unit r113 = Unit.INSTANCE;
            r112.C = r109;
            r109.start();
            goto L62
        L14:
            if (r101.isRunning() != true) goto L18;
            AnimatorSet r114 = r112.B;
            if (r114 == null) goto L18;
            r114.cancel();
            goto L18
        L9:
            if (r100.isRunning() != true) goto L11;
        L62:
            return true;
        L30:
            j r115 = this.f145141a;
            r115.f145140z = true;
            AnimatorSet r116 = r115.B;
            if (r116 != null) goto L33;
        L35:
            AnimatorSet r117 = r115.C;
            if (r117 != null) goto L38;
        L42:
            r115.M.f145265g = r115.L;
            r115.M.f145259a = 0.0f;
            LiveKtvMidiRenderElementFpsAnimator r118 = LiveKtvMidiRenderElementFpsAnimator.a(r115.M, "alpha", new float[]{0.0f, 1.0f});
            int r119 = KtvSettingHelper.k();
            if (r119 <= 0) goto L45;
            r118.f145337a = r119;
        L45:
            r118.setDuration(500);
            r118.setInterpolator(new LinearInterpolator());
            c r120 = r115.Q;
            com.bytedance.android.live.ktv.common.midi.g r121 = r115.f144969d;
            if (r121 != null) goto L48;
        L51:
            boolean r122 = true;
        L52:
            r120.f145265g = r122;
            r115.Q.f145259a = 0.0f;
            LiveKtvMidiRenderElementFpsAnimator r123 = LiveKtvMidiRenderElementFpsAnimator.a(r115.Q, "alpha", new float[]{0.0f, 1.0f});
            int r124 = KtvSettingHelper.k();
            if (r124 <= 0) goto L55;
            r123.f145337a = r124;
        L55:
            r123.setDuration(500);
            r123.setInterpolator(new LinearInterpolator());
            com.bytedance.android.live.ktv.common.midi.g r125 = r115.f144969d;
            if (r125 != null) goto L58;
        L61:
            AnimatorSet r126 = new AnimatorSet();
            r126.playTogether(new Animator[]{r118, r123});
            Unit r127 = Unit.INSTANCE;
            r115.B = r126;
            r126.start();
            goto L62
        L58:
            if (r125.getCurrentMode() != 1) goto L61;
            AnimatorSet r128 = new AnimatorSet();
            r128.playTogether(new Animator[]{r118});
            Unit r129 = Unit.INSTANCE;
            r115.B = r128;
            r128.start();
            goto L62
        L48:
            if (r121.getCurrentMode() != 1) goto L51;
            r122 = false;
            goto L52
        L38:
            if (r117.isRunning() != true) goto L42;
            AnimatorSet r130 = r115.C;
            if (r130 == null) goto L42;
            r130.cancel();
            goto L42
        L33:
            if (r116.isRunning() != true) goto L35;
            goto L35
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void f() {
        this.D = -1.0f;
        this.f145131q = 0;
        this.f145133s = 0;
        this.f145134t = 0;
        this.f145140z = false;
        u r100 = this.P;
        r100.f145333k = s1.B(R.string.ttlive_ktv_score);
        this.M.f145265g = false;
        this.Q.f145265g = false;
        u r101 = this.P;
        Typeface r102 = Typeface.defaultFromStyle(0);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f145334l = r102;
        this.P.f145335m.setTypeface(Typeface.defaultFromStyle(0));
        this.O.d(this.G);
        this.P.f145335m.setColor(s1.h(R.color.ttlive_ktv_midi_score_low_text_color));
    }

    public j() {
        this.f145125k = s1.f(55.0f);
        this.f145126l = s1.f(13.0f);
        this.f145127m = s1.f(16.0f);
        this.f145129o = true;
        this.f145135u = vm2.h.H();
        this.f145136v = vm2.h.J();
        this.D = -1.0f;
        this.E = 1;
        this.F = s1.g(R.drawable.ttlive_ktv_component_midi_score_high_top_bg);
        this.G = s1.g(R.drawable.ttlive_ktv_component_midi_score_low_top_bg);
        this.H = s1.g(R.drawable.ttlive_ktv_component_midi_score_high_bottom_bg);
        this.I = s1.g(R.drawable.ttlive_ktv_component_midi_score_low_bottom_bg);
        this.f145124J = s1.g(R.drawable.ttlive_ktv_hit_float_ball);
        this.K = s1.g(R.drawable.ttlive_ktv_hit_float_ball_tail);
        this.L = true;
        this.M = new c();
        this.N = new c();
        this.O = new c();
        this.P = new u();
        this.Q = new c();
        this.A = new Handler(Looper.getMainLooper(), new a(this));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void e() {
        super.e();
        Handler r100 = this.A;
        if (r100 == null) goto L5;
        r100.removeMessages(0);
    L5:
        Handler r101 = this.A;
        if (r101 == null) goto L8;
        r101.removeMessages(1);
    L8:
        AnimatorSet r102 = this.C;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        AnimatorSet r103 = this.B;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        LiveDegradeFpsAnimator r104 = this.f145137w;
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        this.f145138x = false;
        Bitmap r105 = this.F;
        if (r105 == null) goto L20;
        r105.recycle();
    L20:
        Bitmap r106 = this.G;
        if (r106 == null) goto L23;
        r106.recycle();
    L23:
        Bitmap r107 = this.H;
        if (r107 == null) goto L26;
        r107.recycle();
    L26:
        Bitmap r108 = this.I;
        if (r108 == null) goto L29;
        r108.recycle();
    L29:
        this.M.c();
        this.Q.c();
        this.M.c();
        this.N.c();
        this.P.getClass();
        this.O.c();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.t
    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.Q.b(r100);
        this.M.b(r100);
        this.N.b(r100);
        if (this.f145129o == false) goto L6;
        this.O.b(r100);
        this.P.b(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void d(db0.a r110) {
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f144970e = r110;
        v r111 = this.f144971f;
        if (r111 != null) goto L5;
        return;
    L5:
        this.f145128n = (r111.f145351j * r111.f145354m) - r111.f145343b;
        com.bytedance.android.live.ktv.common.midi.f r100 = this.f144968c;
        boolean r101 = false;
        if (r100 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        this.L = r102;
        this.M.f145265g = r102;
        ImageLoader.downloadBitmap(com.bytedance.android.live.ktv.common.midi.c.f69842d, new m(this.Q));
        this.N.d(this.f145124J);
        if (this.L == false) goto L14;
        this.M.f145259a = 0.0f;
        this.M.d(this.K);
    L14:
        this.N.f145265g = true;
        float r103 = this.f144966a;
        float r104 = r111.f145343b;
        float r105 = (r103 - r104) / 2.0f;
        RectF r106 = this.N.f145266h;
        float r107 = this.f145128n;
        r106.set(r107, r105, r104 + r107, r105 + r104);
        int r108 = (int) r105;
        this.f145131q = r108;
        this.f145132r = r108;
        float r109 = ((this.f145128n + r111.f145343b) - this.f145125k) - s1.f(2.0f);
        RectF r112 = this.N.f145266h;
        float r113 = r112.top;
        float r114 = r112.height();
        float r115 = this.f145126l;
        float r116 = r113 + ((r114 - r115) / 2.0f);
        this.M.f145266h.set(r109, r116, this.f145125k + r109, r115 + r116);
        this.Q.f145266h.set(0.0f, 0.0f, this.f145128n + (r111.f145343b / 2.0f), this.f144966a);
        this.P.f145335m.setColor(s1.h(R.color.ttlive_ktv_midi_score_low_text_color));
        u r117 = this.P;
        Typeface r118 = Typeface.defaultFromStyle(2);
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r117.f145334l = r118;
        float r119 = 9;
        this.P.f145336n = UtilityKotlinExtentionsKt.h(r119);
        this.P.f145335m.setTextSize(UtilityKotlinExtentionsKt.h(r119));
        this.P.f145265g = true;
        this.P.f145333k = s1.B(R.string.ttlive_ktv_score);
        float r120 = this.P.f145335m.measureText("44.44");
        float r121 = (s1.f(1.0f) * 2) + r120;
        RectF r122 = this.N.f145266h;
        float r123 = r122.left - ((r121 - r111.f145343b) / 2.0f);
        float r124 = r122.top;
        float r125 = this.f145127m;
        float r126 = r124 - r125;
        this.O.f145265g = true;
        this.O.d(this.G);
        this.O.f145266h.set(r123, r126, r121 + r123, r125 + r126);
        RectF r127 = this.O.f145266h;
        float r128 = r127.left + ((r127.width() - r120) / 2.0f);
        RectF r129 = this.O.f145266h;
        float r130 = r129.bottom - UtilityKotlinExtentionsKt.h(3);
        this.P.f145266h.set(r128, r129.top, r120 + r128, r130);
        com.bytedance.android.live.ktv.common.midi.g r131 = this.f144969d;
        if (r131 != null) goto L17;
    L23:
        this.f145129o = r101;
        return;
    L17:
        if (r131.L() != true) goto L23;
        com.bytedance.android.live.ktv.common.midi.f r132 = this.f144968c;
        if (r132 == null) goto L23;
        if (r132.b() != true) goto L23;
        r101 = true;
        goto L23
    L8:
        if (r100.c() != true) goto L10;
        r102 = true;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void h(MidiSkinDressInfo r100) {
        this.f144972g = r100;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getDressId();
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        MidiSkinDressInfo r103 = this.f144972g;
        if (r103 == null) goto L11;
        r101 = r103.getDressId();
    L11:
        boolean r104 = Intrinsics.areEqual(r101, "0");
        boolean r105 = true;
        if ((!r104) == false) goto L14;
    L15:
        if (r105 == false) goto L51;
        MidiSkinDressInfo r106 = this.f144972g;
        if (r106 == null) goto L27;
        MidiSkinMaterial r107 = r106.getMaterial();
        if (r107 == null) goto L27;
        BackgroundMaterial r108 = r107.getBg();
        if (r108 == null) goto L27;
        py.k r109 = r108.getBuoyAreaBg();
        if (r109 == null) goto L27;
        String r110 = KtvUtilsKt.g(r109);
        if (r110 == null) goto L27;
        ImageLoader.downloadBitmap(r110, new m(this.Q));
    L27:
        MidiSkinDressInfo r111 = this.f144972g;
        if (r111 == null) goto L39;
        MidiSkinMaterial r112 = r111.getMaterial();
        if (r112 == null) goto L39;
        BuoyMaterial r113 = r112.getBuoy();
        if (r113 == null) goto L39;
        py.k r114 = r113.getBuoyBall();
        if (r114 == null) goto L39;
        String r115 = KtvUtilsKt.g(r114);
        if (r115 == null) goto L39;
        ImageLoader.downloadBitmap(r115, new m(this.N));
    L39:
        if (this.L == false) goto L55;
        MidiSkinDressInfo r116 = this.f144972g;
        if (r116 == null) goto L56;
        MidiSkinMaterial r117 = r116.getMaterial();
        if (r117 == null) goto L57;
        BuoyMaterial r118 = r117.getBuoy();
        if (r118 == null) goto L58;
        py.k r119 = r118.getBuoyTailing();
        if (r119 == null) goto L59;
        String r120 = KtvUtilsKt.g(r119);
        if (r120 == null) goto L60;
        ImageLoader.downloadBitmap(r120, new m(this.M));
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L51:
        ImageLoader.downloadBitmap(com.bytedance.android.live.ktv.common.midi.c.f69842d, new m(this.Q));
        this.N.d(this.f145124J);
        if (this.L == false) goto L62;
        this.M.d(this.K);
        return;
    L62:
        return;
    L14:
        r105 = false;
        goto L15
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a
    public final void b(com.bytedance.android.live.ktv.common.midi.k r100, Long r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "scoreInfo");
        super.b(r100, r110, r111);
        float r112 = r100.f69860a;
        float r101 = r100.f69861b;
        float r102 = r100.f69863d;
        v r103 = this.f144971f;
        if (r103 != null) goto L5;
        Pair<Float, Float> r104 = new Pair(Float.valueOf(this.f145128n), Float.valueOf(this.f145139y));
    L107:
        s r113 = this.f144975j;
        if (r113 == null) goto L111;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r113.f145270b = r104;
        return;
    L111:
        return;
    L5:
        com.bytedance.android.live.ktv.common.midi.g r105 = this.f144969d;
        if (r105 == null) goto L8;
        int r106 = r105.getCurrentMode();
    L10:
        if (r106 == 0) goto L17;
        com.bytedance.android.live.ktv.common.midi.f r107 = this.f144968c;
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L18:
        com.bytedance.android.live.ktv.common.midi.g r109 = this.f144969d;
        if (r109 != null) goto L21;
    L27:
        boolean r114 = false;
    L28:
        this.f145130p = r114;
        if (r108 == false) goto L66;
        float r115 = 0;
        if (r112 > r115) goto L33;
    L37:
        boolean r116 = false;
    L38:
        Message r117 = null;
        if (r116 == true) goto L41;
    L52:
        if (r116 == true) goto L66;
        if (this.f145140z == false) goto L66;
        Handler r118 = this.A;
        if (r118 == null) goto L58;
        r117 = r118.obtainMessage(1);
    L58:
        Handler r119 = this.A;
        if (r119 == null) goto L61;
        r119.removeMessages(0);
    L61:
        if (r117 == null) goto L66;
        Handler r120 = this.A;
        if (r120 == null) goto L66;
        r120.sendMessageDelayed(r117, 300);
        goto L66
    L41:
        if (this.f145140z == true) goto L52;
        Handler r121 = this.A;
        if (r121 == null) goto L45;
        r117 = r121.obtainMessage(0);
    L45:
        Handler r122 = this.A;
        if (r122 == null) goto L48;
        r122.removeMessages(1);
    L48:
        if (r117 == null) goto L66;
        Handler r123 = this.A;
        if (r123 == null) goto L66;
        r123.sendMessageDelayed(r117, 300);
        goto L66
    L33:
        if (r101 <= r115) goto L37;
        if (Math.abs(r112 - r101) > ((Number) KtvSettingHelper.C0.getValue()).intValue()) goto L37;
        r116 = true;
    L66:
        if (this.f145130p == false) goto L85;
        this.f145129o = true;
        if (r102 > 0) goto L70;
    L87:
        int r124 = this.f145134t % this.f145135u;
        this.f145134t = r124 + 1;
        if (r124 == 0) goto L91;
        r104 = new Pair(Float.valueOf(this.f145128n), Float.valueOf(this.f145139y));
        goto L107
    L91:
        if (r112 >= r103.f145348g) goto L93;
    L96:
        int r125 = this.f145133s + 1;
        this.f145133s = r125;
        if (r125 >= this.f145136v) goto L99;
        r104 = new Pair(Float.valueOf(this.f145128n), Float.valueOf(this.f145139y));
        goto L107
    L99:
        this.f145133s = 0;
    L100:
        float r126 = Integer.valueOf(r103.a(this.f144966a, (int) r112)).intValue() - (this.N.f145266h.height() / 2.0f);
        int r127 = (int) r126;
        this.f145139y = r127;
        if (this.f145138x == false) goto L103;
    L106:
        r104 = new Pair(Float.valueOf(this.f145128n), Float.valueOf(this.f145139y));
        goto L107
    L103:
        if (this.f145131q == r127) goto L106;
        float r128 = r126 - this.f145132r;
        this.f145138x = true;
        LiveDegradeFpsAnimator r129 = LiveDegradeFpsAnimator.ofFloat(new float[]{this.N.f145263e, r128}).setFpsConfig(KtvSettingHelper.k());
        r129.setDuration(100);
        r129.setInterpolator(new LinearInterpolator());
        r129.setEvaluator(new com.bytedance.android.live.ktv.common.midi.v2.h());
        r129.addListener(new n(r128, this));
        r129.addUpdateListener(new o(this));
        Unit r130 = Unit.INSTANCE;
        this.f145137w = r129;
        r129.start();
        this.f145131q = r127;
        goto L106
    L93:
        if (r112 > r103.f145349h) goto L96;
        this.f145133s = 0;
        goto L100
    L70:
        if (r102 == this.D) goto L87;
        if (r102 == 0.0f) goto L87;
        this.D = r102;
        this.O.f145265g = true;
        this.P.f145265g = true;
        this.P.f145333k = new DecimalFormat("#0.0").format(Float.valueOf(this.D));
        int r131 = this.E;
        if (r131 == 1) goto L82;
        if (r131 != 2) goto L87;
        if (this.D < vm2.h.z()) goto L80;
        this.O.d(this.H);
        this.P.f145335m.setColor(s1.h(R.color.ttlive_ktv_midi_score_high_text_color));
        goto L87
    L80:
        this.O.d(this.I);
        this.P.f145335m.setColor(s1.h(R.color.ttlive_ktv_midi_score_low_text_color));
        goto L87
    L82:
        if (this.D < vm2.h.z()) goto L84;
        this.O.d(this.F);
        this.P.f145335m.setColor(s1.h(R.color.ttlive_ktv_midi_score_high_text_color));
        goto L87
    L84:
        this.O.d(this.G);
        this.P.f145335m.setColor(s1.h(R.color.ttlive_ktv_midi_score_low_text_color));
        goto L87
    L85:
        if (r111 == true) goto L87;
        this.f145129o = false;
        goto L87
    L21:
        if (r109.L() != true) goto L27;
        com.bytedance.android.live.ktv.common.midi.f r132 = this.f144968c;
        if (r132 == null) goto L27;
        if (r132.b() != true) goto L27;
        r114 = true;
        goto L28
    L14:
        if (r107.c() != true) goto L16;
    L17:
        r108 = true;
        goto L18
    L8:
        r106 = -1;
        goto L10
    }
}
