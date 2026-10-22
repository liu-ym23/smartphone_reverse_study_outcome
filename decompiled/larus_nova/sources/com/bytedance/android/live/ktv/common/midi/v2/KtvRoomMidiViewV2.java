package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.live.ktv.common.midi.KtvMidiHitDisplayView;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.doc.structure.StructurePlugin;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/v2/KtvRoomMidiViewV2;", "Lcom/bytedance/android/live/ktv/common/midi/AbsKtvMidiView;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "config", "", "setConfig", "", BaseSwitches.V, "Z", "getEnableFontScale", "()Z", StructurePlugin.ENABLE_FONT_SCALE, "Lqb0/c;", "getMidiHit", "()Lqb0/c;", "midiHit", "Lqb0/b;", "getMidiLine", "()Lqb0/b;", "midiLine", "Lqb0/a;", "getMidiHitDisplay", "()Lqb0/a;", "midiHitDisplay", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomMidiViewV2 extends AbsKtvMidiView {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f69937w = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f69938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f69939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public KtvMidiHitDisplayView f69940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f69941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public KtvMidiViewV2 f69942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public KtvHitAnimationViewV2 f69943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f69944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HSImageView f69945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Animator f69946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Animator f69947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f69948m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f69949n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f69950o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f69951p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f69952q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f69953r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f69954s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f69955t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MidiSkinDressInfo f69956u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f69957v;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvRoomMidiViewV2 f69958a;

        public b(KtvRoomMidiViewV2 r100) {
            this.f69958a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            KtvRoomMidiViewV2 r101 = this.f69958a;
            int r102 = KtvRoomMidiViewV2.f69937w;
            if (r101.V5() == false) goto L13;
            KtvRoomMidiViewV2 r103 = this.f69958a;
            ImageView r104 = r103.f69939d;
            MidiSkinDressInfo r105 = r103.f69956u;
            if (r105 == null) goto L11;
            MidiSkinMaterial r106 = r105.getMaterial();
            if (r106 == null) goto L11;
            BackgroundMaterial r107 = r106.getBg();
            if (r107 == null) goto L11;
            k r108 = r107.getScoreboardBg();
        L12:
            ImageUtil.loadImage(r104, r108, 0);
        L16:
            super.onAnimationStart(r100);
            return;
        L11:
            r108 = null;
            goto L12
        L13:
            ImageView r109 = this.f69958a.f69939d;
            if (r109 == null) goto L16;
            r109.setImageResource(R.drawable.ttlive_ktv_midi_score_bg_high);
            goto L16
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvRoomMidiViewV2 f69959a;

        public c(KtvRoomMidiViewV2 r100) {
            this.f69959a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ImageView r101 = this.f69959a.f69939d;
            if (r101 == null) goto L5;
            r101.setImageResource(R.drawable.ttlive_ktv_midi_score_bg_low);
        L5:
            super.onAnimationStart(r100);
        }
    }

    static {
    }

    public KtvRoomMidiViewV2(Context r100) {
        this(r100, null, 0, false, 14);
    }

    public KtvRoomMidiViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 0, false, 12);
    }

    public KtvRoomMidiViewV2(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, false, 8);
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void R5() {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void U5(long r100, long r101) {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void onResume() {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public void setConfig(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void A1() {
        Animator r100 = this.f69946k;
        if (r100 != null) goto L5;
    L9:
        Animator r101 = this.f69947l;
        if (r101 != null) goto L12;
    L16:
        this.f69953r = false;
        HSImageView r102 = this.f69945j;
        if (r102 == null) goto L20;
        r102.setVisibility(8);
        return;
    L20:
        return;
    L12:
        if (r101.isRunning() != true) goto L16;
        Animator r103 = this.f69947l;
        if (r103 == null) goto L16;
        r103.cancel();
        goto L16
    L5:
        if (r100.isRunning() != true) goto L9;
        Animator r104 = this.f69946k;
        if (r104 == null) goto L9;
        r104.cancel();
        goto L9
    }

    public final boolean V5() {
        MidiSkinDressInfo r100 = this.f69956u;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getDressId();
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        MidiSkinDressInfo r103 = this.f69956u;
        if (r103 == null) goto L12;
        r101 = r103.getDressId();
    L12:
        if ((!Intrinsics.areEqual(r101, "0")) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void reset() {
        TextView r100 = this.f69944i;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        TextView r101 = this.f69941f;
        if (r101 == null) goto L8;
        r101.setText("评分");
    L8:
        ImageView r102 = this.f69939d;
        if (r102 == null) goto L11;
        r102.setImageResource(R.drawable.ttlive_ktv_midi_score_bg_low);
    L11:
        this.f69953r = false;
        this.f69948m = 0.0f;
        qb0.b r103 = getMidiLine();
        if (r103 == null) goto L14;
        r103.clear();
    L14:
        this.f69950o = -1;
        this.f69954s = 0;
        Animator r104 = this.f69946k;
        if (r104 != null) goto L17;
    L21:
        Animator r105 = this.f69947l;
        if (r105 != null) goto L24;
    L28:
        HSImageView r106 = this.f69945j;
        if (r106 == null) goto L32;
        r106.setVisibility(8);
        return;
    L32:
        return;
    L24:
        if (r105.isRunning() != true) goto L28;
        Animator r107 = this.f69947l;
        if (r107 == null) goto L28;
        r107.cancel();
        goto L28
    L17:
        if (r104.isRunning() != true) goto L21;
        Animator r108 = this.f69946k;
        if (r108 == null) goto L21;
        r108.cancel();
        goto L21
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void onDetach() {
        reset();
        KtvHitAnimationViewV2 r100 = this.f69943h;
        if (r100 == null) goto L10;
        KtvHitAnimationViewV2.d r101 = r100.f69874b;
        if (r101 == null) goto L7;
        r101.clear();
    L7:
        KtvHitAnimationViewV2.d r102 = r100.f69873a;
        if (r102 == null) goto L10;
        r102.clear();
    L10:
        KtvMidiHitDisplayView r103 = this.f69940e;
        if (r103 == null) goto L13;
        r103.onDetach();
    L13:
        qb0.b r104 = getMidiLine();
        if (r104 == null) goto L16;
        r104.detach();
    L16:
        d r105 = this.f69955t;
        if (r105 == null) goto L19;
        r105.clear();
    L19:
        setVisibility(8);
    }

    private final qb0.c getMidiHit() {
        return this.f69943h;
    }

    private final qb0.a getMidiHitDisplay() {
        return this.f69940e;
    }

    private final qb0.b getMidiLine() {
        return this.f69942g;
    }

    public final boolean getEnableFontScale() {
        return this.f69957v;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void R2(long r100) {
        qb0.b r101 = getMidiLine();
        if (r101 == null) goto L5;
        r101.show();
    L5:
        qb0.b r102 = getMidiLine();
        if (r102 == null) goto L9;
        r102.D3(r100);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void T5(db0.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        qb0.b r101 = getMidiLine();
        if (r101 == null) goto L5;
        r101.f0(r100, this.f69955t);
    L5:
        qb0.b r102 = getMidiLine();
        if (r102 == null) goto L9;
        r102.setScoreInterval(vm2.h.D());
        return;
    }

    public final void Y5(boolean r100) {
        TextView r101 = this.f69944i;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        goto L8
    L6:
        r102 = 8;
    L8:
        if (r100 == false) goto L12;
        qb0.b r103 = getMidiLine();
        if (r103 == null) goto L16;
        r103.show();
        return;
    L16:
        return;
    L12:
        qb0.b r104 = getMidiLine();
        if (r104 == null) goto L18;
        r104.hide();
        return;
    }

    public final void Z5(com.bytedance.android.live.ktv.common.midi.k r100) {
        Intrinsics.checkNotNullParameter(r100, "scoreInfo");
        int r101 = this.f69950o;
        int r102 = r100.f69864e;
        if (r101 == r102) goto L8;
        if (r100.f69863d <= 0) goto L8;
        if (r102 < 0) goto L8;
    L10:
        if (r100.f69863d == 0.0f) goto L12;
        return;
    L12:
        if (r100.f69867h == false) goto L22;
        TextView r103 = this.f69941f;
        if (r103 == null) goto L16;
        r103.setText(s1.B(R.string.ttlive_ktv_score));
    L16:
        qb0.b r104 = getMidiLine();
        if (r104 == null) goto L23;
        r104.clear();
        return;
    L23:
        return;
    L22:
        return;
    L8:
        if (r100.f69867h == true) goto L10;
    }

    public final void b6(boolean r110) {
        ImageView r100 = this.f69939d;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r110 == false) goto L8;
        Intrinsics.checkNotNull(r100);
        ObjectAnimator r111 = ObjectAnimator.ofFloat(this.f69945j, View.TRANSLATION_X, new float[]{0.0f, 0 - r100.getX()});
        r111.setDuration(500);
        r111.setInterpolator(PathInterpolatorCompat.create(0.07f, 0.0f, 0.43f, 1.0f));
        r111.addListener(new b(this));
        r111.start();
        return;
    L8:
        Intrinsics.checkNotNull(r100);
        ObjectAnimator r112 = ObjectAnimator.ofFloat(this.f69945j, View.TRANSLATION_X, new float[]{0.0f, 0 - r100.getX()});
        r112.setDuration(500);
        r112.setInterpolator(PathInterpolatorCompat.create(0.07f, 0.0f, 0.43f, 1.0f));
        r112.addListener(new c(this));
        r112.start();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void xc(Pair<Integer, Integer> r100) {
        if (r100 == null) goto L7;
        qb0.b r101 = getMidiLine();
        if (r101 == null) goto L8;
        r101.D5(r100.getFirst().intValue(), r100.getSecond().intValue());
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void y(MidiSkinDressInfo r100) {
        this.f69956u = r100;
        this.f69955t.y(r100);
        qb0.b r101 = getMidiLine();
        if (r101 == null) goto L6;
        r101.y(r100);
    L6:
        if (V5() == true) goto L8;
        return;
    L8:
        if (this.f69948m <= this.f69938c) goto L30;
        MidiSkinDressInfo r102 = this.f69956u;
        if (r102 == null) goto L31;
        MidiSkinMaterial r103 = r102.getMaterial();
        if (r103 == null) goto L32;
        BackgroundMaterial r104 = r103.getBg();
        if (r104 == null) goto L33;
        k r105 = r104.getScoreboardBg();
        if (r105 != null) goto L18;
        return;
    L18:
        if (r105.isValid() != true) goto L35;
        ImageView r106 = this.f69939d;
        MidiSkinDressInfo r107 = this.f69956u;
        if (r107 == null) goto L26;
        MidiSkinMaterial r108 = r107.getMaterial();
        if (r108 == null) goto L26;
        BackgroundMaterial r109 = r108.getBg();
        if (r109 == null) goto L26;
        k r110 = r109.getScoreboardBg();
    L27:
        ImageUtil.loadImage(r106, r110, 0);
        return;
    L26:
        r110 = null;
        goto L27
    L35:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void S5(com.bytedance.android.live.ktv.common.midi.k r110, Long r111) {
        Intrinsics.checkNotNullParameter(r110, "scoreInfo");
        if (r111 == null) goto L7;
        qb0.b r100 = getMidiLine();
        if (r100 == null) goto L7;
        r100.J3(r111.longValue());
    L7:
        qb0.b r101 = getMidiLine();
        if (r101 == null) goto L11;
        Pair r102 = qb0.b.a.a(r101, r110.f69860a, r110.f69861b, 0.0f, r110.f69867h, false, 20);
        if (r102 == null) goto L11;
    L12:
        int r103 = this.f69950o;
        int r104 = r110.f69864e;
        if (r103 == r104) goto L18;
        if (r110.f69863d <= 0) goto L18;
        if (r104 < 0) goto L18;
    L19:
        Integer r105 = r110.f69865f;
        if (r105 == null) goto L22;
        int r106 = r105.intValue();
    L23:
        int r107 = r110.f69866g;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvRoomMidiViewV2", "showHitAnimation hitType " + r106 + " comboCount " + r107);
        if (r106 == 3) goto L26;
    L30:
        if (r106 != 3) goto L32;
    L36:
        qb0.a r108 = getMidiHitDisplay();
        if (r108 == null) goto L40;
        r108.C4(r106, r107, this.f69953r);
    L40:
        if (this.f69953r == false) goto L61;
        Animator r109 = this.f69946k;
        if (r109 != null) goto L44;
    L45:
        Animator r112 = this.f69947l;
        if (r112 != null) goto L48;
    L49:
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this.f69945j, View.ALPHA, new float[]{0.0f, 1.0f});
        r113.setDuration(500);
        r113.setInterpolator(new LinearInterpolator());
        r113.addListener(new e(this));
        Unit r114 = Unit.INSTANCE;
        this.f69946k = r113;
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this.f69945j, View.ALPHA, new float[]{1.0f, 0.0f});
        r115.setDuration(500);
        r115.setInterpolator(new LinearInterpolator());
        r115.addListener(new f(this));
        this.f69947l = r115;
        if (V5() == false) goto L60;
        FrescoLoader r116 = FrescoLoader.with(getContext());
        MidiSkinDressInfo r117 = this.f69956u;
        if (r117 == null) goto L58;
        MidiSkinMaterial r118 = r117.getMaterial();
        if (r118 == null) goto L58;
        BackgroundMaterial r119 = r118.getBg();
        if (r119 == null) goto L58;
        k r120 = r119.getGlobalBg();
    L59:
        r116.load(r120).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvRoomMidiViewV2$playMidiBgAnimation$3(this))).into(this.f69945j);
    L75:
        float r121 = this.f69948m;
        float r122 = r110.f69863d;
        boolean r123 = r110.f69867h;
        if (r122 != 0.0f) goto L85;
        if (r123 == false) goto L85;
        TextView r124 = this.f69941f;
        if (r124 == null) goto L81;
        r124.setText(s1.B(R.string.ttlive_ktv_score));
    L81:
        qb0.b r125 = getMidiLine();
        if (r125 == null) goto L85;
        r125.clear();
    L85:
        if (r121 != r122) goto L87;
    L100:
        this.f69950o = r110.f69864e;
        Integer r126 = r110.f69865f;
        if (r126 == null) goto L103;
        int r127 = r126.intValue();
    L104:
        if (r127 <= 0) goto L106;
        Integer r128 = r110.f69865f;
        Intrinsics.checkNotNull(r128);
        this.f69954s = r128.intValue();
    L106:
        float r129 = r110.f69860a;
        float r130 = 0;
        if (r129 <= r130) goto L121;
        float r131 = r110.f69861b;
        if (r131 > r130) goto L111;
        return;
    L111:
        if (Math.abs(r129 - r131) > this.f69952q) goto L123;
        qb0.b r132 = getMidiLine();
        if (r132 == null) goto L115;
        r132.S3();
    L115:
        long r133 = this.f69949n % ((long) this.f69951p);
        this.f69949n = 1 + r133;
        if (r133 != 0) goto L124;
        qb0.c r134 = getMidiHit();
        if (r134 == null) goto L125;
        qb0.c.a.a(r134, ((Number) r102.getFirst()).floatValue(), ((Number) r102.getSecond()).floatValue(), Integer.valueOf(this.f69954s), this.f69953r);
        return;
    L125:
        return;
    L124:
        return;
    L123:
        return;
    L121:
        return;
    L103:
        r127 = 0;
        goto L104
    L87:
        if (r122 <= 0) goto L100;
        float r135 = this.f69948m;
        float r136 = this.f69938c;
        if (r135 < r136) goto L92;
    L94:
        float r137 = this.f69938c;
        if (r121 >= r137) goto L97;
    L99:
        this.f69948m = r122;
        ObjectAnimator r138 = ObjectAnimator.ofFloat(this.f69941f, View.SCALE_X, new float[]{1.0f, 1.3f});
        r138.setDuration(280);
        r138.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        Unit r139 = Unit.INSTANCE;
        ObjectAnimator r140 = ObjectAnimator.ofFloat(this.f69941f, View.SCALE_Y, new float[]{1.0f, 1.3f});
        r140.setDuration(280);
        r140.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        ObjectAnimator r141 = ObjectAnimator.ofFloat(this.f69941f, View.SCALE_X, new float[]{1.3f, 1.0f});
        r141.setStartDelay(480);
        r141.setDuration(120);
        r141.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        ObjectAnimator r142 = ObjectAnimator.ofFloat(this.f69941f, View.SCALE_Y, new float[]{1.3f, 1.0f});
        r142.setStartDelay(480);
        r142.setDuration(120);
        r142.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        ValueAnimator r143 = ValueAnimator.ofFloat(new float[]{r121, r122});
        r143.setDuration(280);
        r143.setInterpolator(new LinearInterpolator());
        r143.setEvaluator(new h());
        r143.addUpdateListener(new g(new DecimalFormat("#.#"), this, r123));
        AnimatorSet r144 = new AnimatorSet();
        r144.playTogether(new Animator[]{r138, r140, r141, r142, r143});
        r144.start();
        goto L100
    L97:
        if (r122 >= r137) goto L99;
        b6(false);
        goto L99
    L92:
        if (r122 < r136) goto L94;
        b6(true);
    L58:
        r120 = null;
        goto L59
    L60:
        FrescoLoader.with(getContext()).load(com.bytedance.android.live.ktv.common.midi.c.f69840b).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvRoomMidiViewV2$playMidiBgAnimation$4(this))).into(this.f69945j);
        goto L75
    L48:
        if (r112.isRunning() == true) goto L75;
    L44:
        if (r109.isRunning() == true) goto L75;
    L61:
        Animator r145 = this.f69946k;
        if (r145 != null) goto L64;
    L65:
        Animator r146 = this.f69947l;
        if (r146 == null) goto L75;
        if (r146.isRunning() != true) goto L75;
    L69:
        Animator r147 = this.f69946k;
        if (r147 == null) goto L72;
        r147.end();
    L72:
        Animator r148 = this.f69947l;
        if (r148 == null) goto L75;
        r148.end();
        goto L75
    L64:
        if (r145.isRunning() == true) goto L69;
    L32:
        if (this.f69953r == false) goto L36;
        if (r107 >= vm2.h.x()) goto L36;
        this.f69953r = false;
        goto L36
    L26:
        if (this.f69953r == true) goto L30;
        if (r107 < vm2.h.x()) goto L30;
        this.f69953r = true;
        goto L36
    L22:
        r106 = 0;
    L18:
        if (r110.f69867h == false) goto L106;
    L11:
        r102 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L12
    }

    public KtvRoomMidiViewV2(Context r100, AttributeSet r101, int r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f69957v = r103;
        this.f69938c = vm2.h.z();
        this.f69950o = -1;
        this.f69951p = vm2.h.G();
        this.f69952q = vm2.h.I();
        d r105 = new d();
        this.f69955t = r105;
        if (r103 == false) goto L14;
        int r106 = R.layout.ttlive_layout_ktv_room_midi_view_v2_adapt;
    L15:
        LayoutInflater.from(r100).inflate(r106, this);
        this.f69942g = (KtvMidiViewV2) findViewById(R.id.midi_view);
        this.f69943h = (KtvHitAnimationViewV2) findViewById(R.id.hit_animation);
        KtvMidiHitDisplayView r107 = (KtvMidiHitDisplayView) findViewById(R.id.hit_type_display);
        this.f69940e = r107;
        Intrinsics.checkNotNull(r107);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r107.f69787h = r105;
        this.f69939d = (ImageView) findViewById(R.id.midi_score_bg);
        this.f69941f = (TextView) findViewById(R.id.midi_score);
        this.f69944i = (TextView) findViewById(R.id.ktv_no_midi_hint);
        this.f69945j = (HSImageView) findViewById(R.id.ktv_midi_bg);
        qb0.c r108 = getMidiHit();
        if (r108 == null) goto L18;
        r108.b(r105);
    L18:
        qb0.c r109 = getMidiHit();
        if (r109 == null) goto L22;
        r109.setAnimGap(0);
        return;
    L22:
        return;
    L14:
        r106 = R.layout.ttlive_layout_ktv_room_midi_view_v2;
        goto L15
    }
}
