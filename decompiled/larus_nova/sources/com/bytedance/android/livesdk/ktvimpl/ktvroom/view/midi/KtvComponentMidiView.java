package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.midi.KtvMidiHitDisplayView;
import com.bytedance.android.live.ktv.common.midi.f;
import com.bytedance.android.live.ktv.common.midi.g;
import com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2;
import com.bytedance.android.live.ktv.common.midi.v2.KtvMidiViewV2;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016RT\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/midi/KtvComponentMidiView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/b;", "Lcom/bytedance/android/live/ktv/common/midi/g;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "setPerformStrategy", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "config", "setConfig", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", VideoSurfaceTexture.KEY_TIME, "s", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "", "t", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentMidiView extends ConstraintLayout implements com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KtvMidiHitDisplayView f145145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KtvMidiViewV2 f145146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f145147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public KtvHitAnimationViewV2 f145148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f145149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f145150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f145151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f145152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f145153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f145154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f145155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f145156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f145157m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MidiSkinDressInfo f145158n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Animator f145159o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Animator f145160p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HSImageView f145161q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public k f145162r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function2<? super Boolean, ? super Long, Unit> f145163s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f145164t;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMidiView f145165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair f145166b;

        public b(KtvComponentMidiView r100, Pair r101) {
            this.f145165a = r100;
            this.f145166b = r101;
        }

        public final void a() {
            KtvHitAnimationViewV2 r100 = this.f145165a.f145148d;
            if (r100 == null) goto L6;
            qb0.c.a.a(r100, ((Number) this.f145166b.getFirst()).floatValue(), ((Number) this.f145166b.getSecond()).floatValue(), Integer.valueOf(this.f145165a.f145154j), this.f145165a.f145153i);
            return;
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

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMidiView f145167a;

        public c(KtvComponentMidiView r100) {
            this.f145167a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f145167a.getViewTreeObserver().addOnGlobalLayoutListener(this.f145167a.f145157m);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMidiView f145168a;

        public d(KtvComponentMidiView r100) {
            this.f145168a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f145168a.getViewTreeObserver().addOnGlobalLayoutListener(this.f145168a.f145157m);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMidiView f145169a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            KtvMidiViewV2 r100 = this.f145169a.f145146b;
            if (r100 == null) goto L16;
            Pair<Long, Long> r101 = r100.getTimeRange();
            KtvComponentMidiView r102 = this.f145169a;
            long r103 = r101.getFirst().longValue();
            long r104 = r101.getSecond().longValue() + r103;
            int r105 = r102.getWidth();
            if (r105 == 0) goto L16;
            float r106 = (r105 * r103) / r104;
            KtvHitAnimationViewV2 r107 = r102.f145148d;
            if (r107 == null) goto L10;
            ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        L11:
            if (r108 == null) goto L13;
            r108.width = (int) r106;
        L13:
            KtvHitAnimationViewV2 r109 = r102.f145148d;
            if (r109 == null) goto L16;
            r109.setLayoutParams(r108);
            goto L16
        L10:
            r108 = null;
        L16:
            this.f145169a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public e(KtvComponentMidiView r100) {
            this.f145169a = r100;
        }
    }

    static {
    }

    public KtvComponentMidiView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvComponentMidiView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void A1() {
        this.f145153i = false;
        Animator r100 = this.f145160p;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() != true) goto L11;
        Animator r101 = this.f145160p;
        if (r101 == null) goto L12;
        r101.cancel();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final View asView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setConfig(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setContainerVisibility(int r100) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void onDetach() {
        KtvHitAnimationViewV2 r100 = this.f145148d;
        if (r100 == null) goto L10;
        KtvHitAnimationViewV2.d r101 = r100.f69874b;
        if (r101 == null) goto L7;
        r101.clear();
    L7:
        KtvHitAnimationViewV2.d r102 = r100.f69873a;
        if (r102 == null) goto L10;
        r102.clear();
    L10:
        KtvMidiHitDisplayView r103 = this.f145145a;
        if (r103 == null) goto L13;
        r103.onDetach();
    L13:
        KtvMidiViewV2 r104 = this.f145146b;
        if (r104 == null) goto L16;
        r104.detach();
    L16:
        g r105 = this.f145155k;
        if (r105 == null) goto L19;
        r105.clear();
    L19:
        setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void reset() {
        Animator r100 = this.f145160p;
        if (r100 != null) goto L5;
    L9:
        this.f145153i = false;
        KtvMidiViewV2 r101 = this.f145146b;
        if (r101 == null) goto L12;
        r101.clear();
    L12:
        this.f145150f = -1;
        this.f145154j = 0;
        return;
    L5:
        if (r100.isRunning() != true) goto L9;
        Animator r102 = this.f145160p;
        if (r102 == null) goto L9;
        r102.cancel();
        goto L9
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.f145163s;
    }

    @Override // com.bytedance.android.live.ktv.common.util.b
    public String getTypeName() {
        return this.f145164t;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void R2(long r100) {
        KtvMidiViewV2 r101 = this.f145146b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVisibility() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        r101.D3(r100);
        return;
    L15:
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        Function2<Boolean, Long, Unit> r101 = getOneDrawCallback();
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void qc(f r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f145156l = r100;
        KtvMidiViewV2 r101 = this.f145146b;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r101.K = r100;
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
        this.f145163s = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public void setPerformStrategy(g r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f145155k = r100;
        MidiSkinDressInfo r101 = r100.z();
        if (r101 == null) goto L5;
        r100.y(r101);
    L5:
        KtvMidiViewV2 r102 = this.f145146b;
        if (r102 == null) goto L8;
        r102.setPerformStrategy(this.f145155k);
    L8:
        KtvHitAnimationViewV2 r103 = this.f145148d;
        if (r103 == null) goto L11;
        r103.b(this.f145155k);
    L11:
        KtvMidiHitDisplayView r104 = this.f145145a;
        if (r104 == null) goto L15;
        g r105 = this.f145155k;
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r104.f69787h = r105;
    L15:
        if (this.f145155k.getCurrentMode() != 2) goto L25;
        KtvMidiHitDisplayView r106 = this.f145145a;
        if (r106 == null) goto L19;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
    L20:
        if (r107 == null) goto L22;
        r107.width = s1.f(144.0f);
    L22:
        KtvMidiHitDisplayView r108 = this.f145145a;
        if (r108 == null) goto L25;
        r108.setLayoutParams(r107);
        goto L25
    L19:
        r107 = null;
    L25:
        postDelayed(new d(this), 100);
    }

    public void setTypeName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f145164t = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void xc(Pair<Integer, Integer> r100) {
        if (r100 == null) goto L7;
        KtvMidiViewV2 r101 = this.f145146b;
        if (r101 == null) goto L8;
        r101.D5(r100.getFirst().intValue(), r100.getSecond().intValue());
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void y(MidiSkinDressInfo r100) {
        this.f145158n = r100;
        this.f145155k.y(r100);
        KtvMidiViewV2 r101 = this.f145146b;
        if (r101 == null) goto L6;
        r101.y(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void Gk(db0.a r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r101 == null) goto L6;
        this.f145155k = r101;
    L6:
        if (this.f145155k.getCurrentMode() != 2) goto L8;
        UIUtils.updateLayout(this, -3, -1);
        UIUtils.updateLayout(this.f145147c, -3, -1);
        UIUtils.updateLayout(this.f145145a, -3, -1);
    L8:
        KtvMidiViewV2 r102 = this.f145146b;
        if (r102 == null) goto L11;
        r102.f0(r100, this.f145155k);
    L11:
        KtvMidiViewV2 r103 = this.f145146b;
        if (r103 == null) goto L14;
        r103.setScoreInterval(h.D());
    L14:
        postDelayed(new c(this), 100);
    }

    public final void R5(SpannableString r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "spannableString");
        KtvMidiViewV2 r102 = this.f145146b;
        if (r102 == null) goto L18;
        Intrinsics.checkNotNullParameter(r100, "spannableString");
        if (r101 == false) goto L9;
        ConstraintLayout r103 = r102.C;
        if (r103 == null) goto L10;
        r103.setVisibility(0);
    L10:
        TextView r104 = r102.D;
        if (r104 == null) goto L13;
        r104.setText(r100);
    L13:
        TextView r105 = r102.D;
        if (r105 == null) goto L16;
        r105.setBackgroundResource(R.drawable.ttlive_ktv_component_midi_score_text_bg);
    L16:
        KtvMidiViewV2.S5(r102.E);
        return;
    L9:
        KtvMidiViewV2.S5(r102.C);
        goto L10
    }

    public KtvComponentMidiView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f145150f = -1;
        this.f145151g = h.G();
        this.f145152h = h.I();
        this.f145155k = new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.a();
        this.f145157m = new e(this);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_ktv_componet_midi_view, this);
        this.f145147c = (ViewGroup) findViewById(R.id.ktv_component_midi_view_cl);
        this.f145146b = (KtvMidiViewV2) findViewById(R.id.component_midi_view);
        KtvHitAnimationViewV2 r103 = (KtvHitAnimationViewV2) findViewById(R.id.component_hit_animation);
        this.f145148d = r103;
        Intrinsics.checkNotNull(r103);
        r103.b(this.f145155k);
        KtvMidiHitDisplayView r104 = (KtvMidiHitDisplayView) findViewById(R.id.component_hit_type_display);
        this.f145145a = r104;
        Intrinsics.checkNotNull(r104);
        g r105 = this.f145155k;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r104.f69787h = r105;
        this.f145161q = (HSImageView) findViewById(R.id.ktv_midi_bg);
        KtvHitAnimationViewV2 r106 = this.f145148d;
        if (r106 == null) goto L5;
        r106.setAnimGap(0);
    L5:
        MidiSkinDressInfo r107 = this.f145158n;
        if (r107 == null) goto L12;
        MidiSkinMaterial r108 = r107.getMaterial();
        if (r108 == null) goto L12;
        BackgroundMaterial r109 = r108.getBg();
        if (r109 == null) goto L12;
        k r110 = r109.getGlobalBg();
    L13:
        this.f145162r = r110;
        this.f145164t = KtvSubElement.MIDI;
        return;
    L12:
        r110 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b
    public final void F9(com.bytedance.android.live.ktv.common.midi.k r110, Long r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "scoreInfo");
        if (r111 == null) goto L7;
        KtvMidiViewV2 r100 = this.f145146b;
        if (r100 == null) goto L7;
        r100.f69901c = r111.longValue();
    L7:
        KtvMidiViewV2 r101 = this.f145146b;
        if (r101 == null) goto L11;
        Pair r113 = qb0.b.a.a(r101, r110.f69860a, r110.f69861b, r110.f69863d, false, r112, 8);
        if (r113 == null) goto L11;
    L12:
        int r114 = this.f145150f;
        int r102 = r110.f69864e;
        if (r114 != r102) goto L15;
    L132:
        float r115 = r110.f69860a;
        float r103 = 0;
        if (r115 <= r103) goto L151;
        float r116 = r110.f69861b;
        if (r116 > r103) goto L137;
        return;
    L137:
        if (Math.abs(r115 - r116) > this.f145152h) goto L153;
        KtvMidiViewV2 r117 = this.f145146b;
        if (r117 == null) goto L141;
        r117.S3();
    L141:
        f r118 = this.f145156l;
        if (r118 != null) goto L144;
        return;
    L144:
        if (r118.a() != true) goto L155;
        long r104 = this.f145149e % ((long) this.f145151g);
        this.f145149e = 1 + r104;
        if (r104 != 0) goto L156;
        KtvHitAnimationViewV2 r119 = this.f145148d;
        if (r119 == null) goto L157;
        r119.post(new b(this, r113));
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L153:
        return;
    L151:
        return;
    L15:
        if (r110.f69863d <= 0) goto L132;
        if (r102 < 0) goto L132;
        f r120 = this.f145156l;
        if (r120 != null) goto L20;
    L126:
        this.f145150f = r110.f69864e;
        Integer r121 = r110.f69865f;
        if (r121 == null) goto L129;
        int r122 = r121.intValue();
    L130:
        if (r122 <= 0) goto L132;
        Integer r123 = r110.f69865f;
        Intrinsics.checkNotNull(r123);
        this.f145154j = r123.intValue();
        goto L132
    L129:
        r122 = 0;
        goto L130
    L20:
        if (r120.d() != true) goto L126;
        Integer r124 = r110.f69865f;
        if (r124 == null) goto L24;
        int r125 = r124.intValue();
    L25:
        int r105 = r110.f69866g;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiView", "showHitAnimation hitType " + r125 + " comboCount " + r105);
        if (KtvSettingHelper.z() == false) goto L28;
        int r106 = KtvSettingHelper.l();
    L30:
        if (r125 == 3) goto L32;
    L35:
        if (r125 != 3) goto L37;
    L40:
        KtvMidiHitDisplayView r107 = this.f145145a;
        if (r107 == null) goto L48;
        if (this.f145153i == false) goto L45;
        this.f145155k.H();
        boolean r108 = true;
    L46:
        r107.C4(r125, r105, r108);
        goto L48
    L45:
        r108 = false;
    L48:
        if (this.f145155k.A() == false) goto L126;
        if (this.f145153i == false) goto L112;
        Animator r126 = this.f145159o;
        if (r126 != null) goto L54;
    L55:
        Animator r127 = this.f145160p;
        if (r127 == null) goto L60;
        if (r127.isRunning() == true) goto L126;
    L60:
        if (this.f145155k.getCurrentMode() == 2) goto L126;
        ObjectAnimator r128 = ObjectAnimator.ofFloat(this.f145161q, View.ALPHA, new float[]{0.0f, 1.0f});
        r128.setDuration(500);
        r128.setInterpolator(new LinearInterpolator());
        r128.addListener(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.b(this));
        Unit r109 = Unit.INSTANCE;
        this.f145159o = r128;
        ObjectAnimator r129 = ObjectAnimator.ofFloat(this.f145161q, View.ALPHA, new float[]{1.0f, 0.0f});
        r129.setDuration(500);
        r129.setInterpolator(new LinearInterpolator());
        r129.addListener(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.c(this));
        this.f145160p = r129;
        MidiSkinDressInfo r130 = this.f145158n;
        k r131 = null;
        if (r130 == null) goto L65;
        String r132 = r130.getDressId();
    L67:
        if (TextUtils.isEmpty(r132) == true) goto L75;
        MidiSkinDressInfo r133 = this.f145158n;
        if (r133 == null) goto L71;
        String r134 = r133.getDressId();
    L73:
        if ((!Intrinsics.areEqual(r134, "0")) == false) goto L75;
        boolean r135 = true;
    L76:
        if (r135 == false) goto L111;
        MidiSkinDressInfo r136 = this.f145158n;
        if (r136 == null) goto L84;
        MidiSkinMaterial r137 = r136.getMaterial();
        if (r137 == null) goto L84;
        BackgroundMaterial r138 = r137.getBg();
        if (r138 == null) goto L84;
        k r139 = r138.getGlobalBg();
    L86:
        if (Intrinsics.areEqual(r139, this.f145162r) == false) goto L95;
        HSImageView r140 = this.f145161q;
        if (r140 == null) goto L91;
        r140.setVisibility(0);
    L91:
        if (this.f145153i == false) goto L126;
        Animator r141 = this.f145159o;
        if (r141 == null) goto L126;
        r141.start();
        goto L126
    L95:
        MidiSkinDressInfo r142 = this.f145158n;
        if (r142 == null) goto L102;
        MidiSkinMaterial r143 = r142.getMaterial();
        if (r143 == null) goto L102;
        BackgroundMaterial r144 = r143.getBg();
        if (r144 == null) goto L102;
        k r145 = r144.getGlobalBg();
    L103:
        this.f145162r = r145;
        FrescoLoader r146 = FrescoLoader.with(getContext());
        MidiSkinDressInfo r147 = this.f145158n;
        if (r147 == null) goto L110;
        MidiSkinMaterial r148 = r147.getMaterial();
        if (r148 == null) goto L110;
        BackgroundMaterial r149 = r148.getBg();
        if (r149 == null) goto L110;
        r131 = r149.getGlobalBg();
    L110:
        r146.load(r131).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvComponentMidiView$playMidiBgAnimation$3(this))).into(this.f145161q);
    L102:
        r145 = null;
    L84:
        r139 = null;
        goto L86
    L111:
        FrescoLoader.with(getContext()).load(com.bytedance.android.live.ktv.common.midi.c.f69840b).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvComponentMidiView$playMidiBgAnimation$4(this))).into(this.f145161q);
        goto L126
    L71:
        r134 = null;
    L75:
        r135 = false;
        goto L76
    L65:
        r132 = null;
        goto L67
    L54:
        if (r126.isRunning() == true) goto L126;
    L112:
        Animator r150 = this.f145159o;
        if (r150 != null) goto L115;
    L116:
        Animator r151 = this.f145160p;
        if (r151 == null) goto L126;
        if (r151.isRunning() != true) goto L126;
    L120:
        Animator r152 = this.f145159o;
        if (r152 == null) goto L123;
        r152.end();
    L123:
        Animator r153 = this.f145160p;
        if (r153 == null) goto L126;
        r153.end();
        goto L126
    L115:
        if (r150.isRunning() == true) goto L120;
    L37:
        if (this.f145153i == false) goto L40;
        if (r105 >= r106) goto L40;
        this.f145153i = false;
        goto L40
    L32:
        if (this.f145153i == true) goto L35;
        if (r105 < r106) goto L35;
        this.f145153i = true;
        goto L40
    L28:
        r106 = h.x();
        goto L30
    L24:
        r125 = 0;
    L11:
        r113 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L12
    }

    public /* synthetic */ KtvComponentMidiView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
