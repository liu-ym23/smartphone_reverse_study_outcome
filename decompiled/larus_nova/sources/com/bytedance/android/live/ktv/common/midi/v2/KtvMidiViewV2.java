package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.midi.KSongToneLinesView;
import com.bytedance.android.live.ktv.common.midi.j;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/v2/KtvMidiViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lqb0/b;", "Lkotlin/Pair;", "", "getTimeRange", "Lcom/bytedance/android/live/ktv/common/midi/g;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "setPerformStrategy", VideoThumbInfo.KEY_INTERVAL, "setScoreInterval", "Ljava/text/DecimalFormat;", FaceService.neutralLabel, "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "df", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiViewV2 extends ConstraintLayout implements qb0.b {
    public static final /* synthetic */ int O = 0;
    public final int A;
    public final Handler B;
    public ConstraintLayout C;
    public TextView D;
    public ImageView E;
    public View F;
    public float G;
    public final DecimalFormat H;
    public com.bytedance.android.live.ktv.common.midi.g I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f69898J;
    public com.bytedance.android.live.ktv.common.midi.f K;
    public MidiSkinDressInfo L;
    public k M;
    public final i N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.midi.d f69899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f69900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f69901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public db0.a f69902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f69903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f69904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f69905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f69906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f69907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f69908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f69909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f69910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f69911m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HSImageView f69912n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public KSongToneLinesView f69913o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f69914p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f69915q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f69916r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f69917s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.midi.d f69918t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f69919u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f69920v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AnimatorSet f69921w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AnimatorSet f69922x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f69923y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f69924z;

    public static final class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiViewV2 f69925a;

        /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.midi.v2.KtvMidiViewV2$a$a, reason: collision with other inner class name */
        public static final class RunnableC1134a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f69926a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f69927b;

            /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.midi.v2.KtvMidiViewV2$a$a$a, reason: collision with other inner class name */
            public static final class C1135a implements ValueAnimator.AnimatorUpdateListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ RunnableC1134a f69928a;

                public C1135a(RunnableC1134a r100) {
                    this.f69928a = r100;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator r100) {
                    Intrinsics.checkNotNullParameter(r100, "it");
                    ImageView r101 = this.f69928a.f69926a.f69925a.f69911m;
                    if (r101 == null) goto L9;
                    Object r102 = r100.getAnimatedValue();
                    if (r102 == null) goto L8;
                    r101.setY(((Float) r102).floatValue());
                    goto L9
                L8:
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                L9:
                    ImageView r103 = this.f69928a.f69926a.f69925a.f69910l;
                    if (r103 == null) goto L16;
                    Object r104 = r100.getAnimatedValue();
                    if (r104 == null) goto L15;
                    float r105 = ((Float) r104).floatValue();
                    ImageView r106 = this.f69928a.f69926a.f69925a.f69911m;
                    Intrinsics.checkNotNull(r106);
                    float r107 = r105 + (r106.getHeight() / 2);
                    ImageView r108 = this.f69928a.f69926a.f69925a.f69910l;
                    Intrinsics.checkNotNull(r108);
                    r103.setY(r107 - (r108.getHeight() / 2));
                    goto L16
                L15:
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                L16:
                    ConstraintLayout r109 = this.f69928a.f69926a.f69925a.C;
                    if (r109 == null) goto L23;
                    Object r110 = r100.getAnimatedValue();
                    if (r110 == null) goto L22;
                    float r111 = ((Float) r110).floatValue();
                    ConstraintLayout r112 = this.f69928a.f69926a.f69925a.C;
                    Intrinsics.checkNotNull(r112);
                    r109.setY(r111 - r112.getHeight());
                    return;
                L22:
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
            }

            public RunnableC1134a(a r100, Ref.IntRef r101) {
                this.f69926a = r100;
                this.f69927b = r101;
            }

            public final void a() {
                Ref.LongRef r100 = new Ref.LongRef();
                int r101 = this.f69926a.f69925a.f69914p;
                int r102 = this.f69927b.element;
                long r103 = 100;
                if (r101 > r102) goto L6;
                r103 = Math.max((long) (Math.abs(r101 - r102) * 4.0f), 100);
            L6:
                r100.element = r103;
                KtvMidiViewV2 r104 = this.f69926a.f69925a;
                if (KtvSettingHelper.z() == false) goto L9;
                ValueAnimator r105 = LiveDegradeFpsAnimator.ofFloat(new float[]{this.f69926a.f69925a.f69914p, this.f69927b.element});
            L10:
                r105.setDuration(r100.element);
                r105.setInterpolator(new LinearInterpolator());
                r105.setEvaluator(new com.bytedance.android.live.ktv.common.midi.v2.h());
                r105.addUpdateListener(new C1135a(this));
                Unit r106 = Unit.INSTANCE;
                r104.f69904f = r105;
                ValueAnimator r107 = this.f69926a.f69925a.f69904f;
                if (r107 == null) goto L13;
                r107.start();
            L13:
                this.f69926a.f69925a.f69914p = this.f69927b.element;
                return;
            L9:
                r105 = ValueAnimator.ofFloat(new float[]{this.f69926a.f69925a.f69914p, this.f69927b.element});
                goto L10
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

        public a(KtvMidiViewV2 r100) {
            this.f69925a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v8, types: [T, android.animation.ValueAnimator] */
        /* JADX WARN: Type inference failed for: r7v12, types: [T, android.animation.ValueAnimator] */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            int r100 = r110.what;
            if (r100 == 0) goto L41;
            if (r100 != 1) goto L6;
            KtvMidiViewV2 r111 = this.f69925a;
            r111.f69923y = false;
            AnimatorSet r101 = r111.f69922x;
            if (r101 != null) goto L18;
        L20:
            AnimatorSet r102 = r111.f69921w;
            if (r102 != null) goto L23;
        L27:
            Ref.ObjectRef r103 = new Ref.ObjectRef();
            if (KtvSettingHelper.z() == false) goto L30;
            ?? r104 = LiveDegradeFpsAnimator.ofFloat(r111.f69910l, "alpha", new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
        L31:
            r104.setDuration(500);
            r104.setInterpolator(new LinearInterpolator());
            Unit r105 = Unit.INSTANCE;
            r103.element = r104;
            Ref.ObjectRef r106 = new Ref.ObjectRef();
            if (KtvSettingHelper.z() == false) goto L34;
            ?? r107 = LiveDegradeFpsAnimator.ofFloat(r111.f69912n, "alpha", new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
        L35:
            r107.setDuration(500);
            r107.setInterpolator(new LinearInterpolator());
            r106.element = r107;
            com.bytedance.android.live.ktv.common.midi.g r108 = r111.I;
            if (r108 != null) goto L38;
        L40:
            AnimatorSet r109 = new AnimatorSet();
            r109.playTogether(new Animator[]{(ValueAnimator) r103.element, (ValueAnimator) r106.element});
            r109.addListener(new com.bytedance.android.live.ktv.common.midi.v2.c(r111));
            r111.f69922x = r109;
            r109.start();
        L106:
            return true;
        L38:
            if (r108.getCurrentMode() != 1) goto L40;
            AnimatorSet r112 = new AnimatorSet();
            r112.playTogether(new Animator[]{(ValueAnimator) r103.element});
            r112.addListener(new com.bytedance.android.live.ktv.common.midi.v2.b(r111));
            r111.f69922x = r112;
            r112.start();
            goto L106
        L34:
            r107 = ObjectAnimator.ofFloat(r111.f69912n, View.ALPHA, new float[]{1.0f, 0.0f});
            goto L35
        L30:
            r104 = ObjectAnimator.ofFloat(r111.f69910l, View.ALPHA, new float[]{1.0f, 0.0f});
            goto L31
        L23:
            if (r102.isRunning() != true) goto L27;
            AnimatorSet r113 = r111.f69921w;
            if (r113 == null) goto L27;
            r113.cancel();
            goto L27
        L18:
            if (r101.isRunning() != true) goto L20;
        L6:
            if (r100 != 3) goto L106;
            Ref.IntRef r114 = new Ref.IntRef();
            Object r115 = r110.obj;
            if (r115 == null) goto L14;
            r114.element = ((Integer) r115).intValue();
            com.bytedance.android.live.ktv.common.midi.e.b("KtvMidiViewV2", "tonePoint?.post");
            ImageView r116 = this.f69925a.f69911m;
            if (r116 == null) goto L106;
            r116.post(new RunnableC1134a(this, r114));
            goto L106
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L41:
            KtvMidiViewV2 r117 = this.f69925a;
            r117.f69923y = true;
            AnimatorSet r118 = r117.f69921w;
            if (r118 != null) goto L44;
        L46:
            AnimatorSet r119 = r117.f69922x;
            if (r119 == null) goto L54;
            if (r119.isRunning() != true) goto L54;
            AnimatorSet r120 = r117.f69922x;
            if (r120 == null) goto L54;
            r120.cancel();
        L54:
            if (KtvSettingHelper.z() == false) goto L56;
            ValueAnimator r121 = LiveDegradeFpsAnimator.ofFloat(r117.f69910l, "alpha", new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
        L57:
            r121.setDuration(500);
            r121.setInterpolator(new LinearInterpolator());
            Unit r122 = Unit.INSTANCE;
            if (KtvSettingHelper.z() == false) goto L60;
            ValueAnimator r123 = LiveDegradeFpsAnimator.ofFloat(r117.f69912n, "alpha", new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
        L61:
            r123.setDuration(500);
            r123.setInterpolator(new LinearInterpolator());
            com.bytedance.android.live.ktv.common.midi.g r124 = r117.I;
            if (r124 != null) goto L64;
        L77:
            AnimatorSet r125 = new AnimatorSet();
            r125.playTogether(new Animator[]{r121, r123});
            r117.f69921w = r125;
            com.bytedance.android.live.ktv.common.midi.g r126 = r117.I;
            if (r126 == null) goto L81;
            k r127 = r126.G();
            if (r127 == null) goto L81;
        L90:
            if (r117.f69900b == false) goto L97;
            if (r127 == null) goto L97;
            if (Intrinsics.areEqual(r117.M, r127) == false) goto L97;
            com.bytedance.android.live.ktv.common.midi.d r128 = r117.f69899a;
            if (r128 == null) goto L106;
            r128.onFinalImageSet("", null, null);
        L97:
            r117.M = r127;
            if (r117.T5() == false) goto L100;
            FrescoLoader.with(r117.getContext()).load(r127).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r117.f69899a).into(r117.f69912n);
            goto L106
        L100:
            com.bytedance.android.live.ktv.common.midi.g r129 = r117.I;
            if (r129 != null) goto L103;
        L105:
            FrescoLoader.with(r117.getContext()).load(com.bytedance.android.live.ktv.common.midi.c.f69842d).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r117.f69918t).into(r117.f69912n);
            goto L106
        L103:
            if (r129.getCurrentMode() != 2) goto L105;
            FrescoLoader.with(r117.getContext()).load(j.f69856c).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r117.f69918t).into(r117.f69912n);
        L81:
            MidiSkinDressInfo r130 = r117.L;
            if (r130 == null) goto L88;
            MidiSkinMaterial r131 = r130.getMaterial();
            if (r131 == null) goto L88;
            BackgroundMaterial r132 = r131.getBg();
            if (r132 == null) goto L88;
            r127 = r132.getBuoyAreaBg();
        L88:
            r127 = null;
            goto L90
        L64:
            if (r124.getCurrentMode() != 1) goto L77;
            AnimatorSet r133 = new AnimatorSet();
            r133.playTogether(new Animator[]{r121});
            r117.f69921w = r133;
            com.bytedance.android.live.ktv.common.midi.f r134 = r117.K;
            if (r134 != null) goto L69;
        L73:
            KtvMidiViewV2.S5(r117.f69910l);
        L74:
            AnimatorSet r135 = r117.f69921w;
            if (r135 == null) goto L106;
            r135.start();
            goto L106
        L69:
            if (r134.c() != true) goto L73;
            ImageView r136 = r117.f69910l;
            if (r136 == null) goto L74;
            r136.setVisibility(0);
            goto L74
        L60:
            r123 = ObjectAnimator.ofFloat(r117.f69912n, View.ALPHA, new float[]{0.0f, 1.0f});
            goto L61
        L56:
            r121 = ObjectAnimator.ofFloat(r117.f69910l, View.ALPHA, new float[]{0.0f, 1.0f});
            goto L57
        L44:
            if (r118.isRunning() != true) goto L46;
            goto L46
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiViewV2 f69929a;

        public c(KtvMidiViewV2 r100) {
            this.f69929a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f69929a.getViewTreeObserver().addOnGlobalLayoutListener(this.f69929a.N);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiViewV2 f69930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f69931b;

        public d(KtvMidiViewV2 r100, long r101) {
            this.f69930a = r100;
            this.f69931b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List<cb0.c> r101 = (List) r100;
            KSongToneLinesView r102 = this.f69930a.f69913o;
            if (r102 == null) goto L6;
            r102.d(this.f69931b, r101);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f69932a = null;

        static {
            f69932a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiViewV2 f69933a;

        public f(KtvMidiViewV2 r100) {
            this.f69933a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f69933a.getViewTreeObserver().addOnGlobalLayoutListener(this.f69933a.N);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiViewV2 f69934a;

        public g(KtvMidiViewV2 r100) {
            this.f69934a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            cb0.c r100 = (cb0.c) r110;
            KtvMidiViewV2 r101 = this.f69934a;
            int r102 = KtvMidiViewV2.O;
            r101.getClass();
            List<cb0.a> r103 = r100.f22993c;
            if (r103 != null) goto L5;
            r103 = new CopyOnWriteArrayList();
        L5:
            long r104 = r101.f69901c;
            r103.add(new cb0.a(r104, Math.min(r101.f69909k + r104, r100.f22991a.f22989b)));
            int r105 = 1;
            if (r103.size() <= 1) goto L16;
            CopyOnWriteArrayList r106 = new CopyOnWriteArrayList();
            long r107 = ((cb0.a) ListProtector.get(r103, 0)).f22988a;
            long r108 = ((cb0.a) ListProtector.get(r103, 0)).f22989b;
            cb0.a r109 = new cb0.a(r107, r108);
            r106.add(r109);
            int r111 = r103.size();
        L9:
            if (r105 >= r111) goto L15;
            cb0.a r112 = (cb0.a) ListProtector.get(r103, r105);
            long r113 = r112.f22988a;
            KtvMidiViewV2 r114 = r101;
            if (r113 > ((r101.f69909k * ((long) 2)) + r108)) goto L13;
            long r115 = Math.max(r112.f22989b, r108);
            r109.f22989b = r115;
        L14:
            r108 = r115;
            r105 = r105 + 1;
            r101 = r114;
            goto L9
        L13:
            r115 = r112.f22989b;
            r109 = new cb0.a(r113, r115);
            r106.add(r109);
            goto L14
        L15:
            r103 = r106;
        L16:
            r100.f22993c = r103;
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f69935a = null;

        static {
            f69935a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
        }
    }

    public static final class i implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiViewV2 f69936a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            com.bytedance.android.live.ktv.common.midi.g r100 = this.f69936a.I;
            if (r100 != null) goto L5;
        L7:
            KtvMidiViewV2.R5(this.f69936a, 1360, 3470);
        L8:
            this.f69936a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L5:
            if (r100.getCurrentMode() != 1) goto L7;
            KtvMidiViewV2.R5(this.f69936a, 1000, 2500);
            goto L8
        }

        public i(KtvMidiViewV2 r100) {
            this.f69936a = r100;
        }
    }

    static {
    }

    public KtvMidiViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvMidiViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // qb0.b
    public final void detach() {
        this.f69902d = null;
        this.I = null;
        Handler r100 = this.B;
        if (r100 == null) goto L5;
        r100.removeMessages(0);
    L5:
        Handler r101 = this.B;
        if (r101 == null) goto L9;
        r101.removeMessages(1);
        return;
    }

    @Override // qb0.b
    public final void show() {
        setVisibility(0);
    }

    @Override // qb0.b
    public final void S3() {
        db0.a r100 = this.f69902d;
        if (r100 == null) goto L13;
        Disposable r101 = this.f69908j;
        if (r101 != null) goto L7;
    L11:
        this.f69908j = r100.findMidiSegment(this.f69901c).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this), h.f69935a);
        return;
    L7:
        if (r101.isDisposed() == true) goto L11;
        Disposable r102 = this.f69908j;
        if (r102 == null) goto L11;
        r102.dispose();
        goto L11
    }

    public final boolean T5() {
        MidiSkinDressInfo r100 = this.L;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getDressId();
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        MidiSkinDressInfo r103 = this.L;
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

    @Override // qb0.b
    public final void clear() {
        KSongToneLinesView r100 = this.f69913o;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        qb0.b.a.a(this, 0.0f, this.f69906h, 0.0f, false, false, 28);
        this.G = -1.0f;
        this.f69898J = 1;
        S5(this.f69912n);
        S5(this.f69910l);
        TextView r101 = this.D;
        if (r101 == null) goto L8;
        r101.setText(s1.B(R.string.ttlive_ktv_score));
    L8:
        Integer r102 = this.f69907i;
        if (r102 != null) goto L12;
    L13:
        TextView r103 = this.D;
        if (r103 == null) goto L16;
        r103.setTypeface(Typeface.defaultFromStyle(0));
    L16:
        this.f69907i = 0;
    L17:
        com.bytedance.android.live.ktv.common.midi.g r104 = this.I;
        if (r104 != null) goto L20;
    L31:
        ImageView r105 = this.E;
        if (r105 == null) goto L34;
        r105.setImageResource(R.drawable.ttlive_ktv_component_midi_score_text_bg);
    L34:
        TextView r106 = this.D;
        if (r106 == null) goto L40;
        r106.setTextColor(s1.h(R.color.ttlive_ktv_midi_score_low_text_color));
        return;
    L40:
        return;
    L20:
        if (r104.getCurrentMode() != 2) goto L31;
        ImageView r107 = this.E;
        if (r107 == null) goto L24;
        r107.setImageResource(R.drawable.ttlive_ktv_component_midi_score_bg);
    L24:
        TextView r108 = this.D;
        if (r108 == null) goto L38;
        com.bytedance.android.live.ktv.common.midi.g r109 = this.I;
        if (r109 == null) goto L29;
        int r110 = r109.B();
    L30:
        r108.setTextColor(r110);
        return;
    L29:
        r110 = s1.h(R.color.ttlive_chorus_midi_score_low_text_color);
        goto L30
    L38:
        return;
    L12:
        if (r102.intValue() == 0) goto L17;
        goto L13
    }

    public final Pair<Long, Long> getTimeRange() {
        com.bytedance.android.live.ktv.common.midi.g r100 = this.I;
        if (r100 == null) goto L8;
        if (r100.getCurrentMode() != 1) goto L8;
        return new Pair(1000L, 2500L);
    L8:
        return new Pair(1360L, 3470L);
    }

    @Override // qb0.b
    public final void hide() {
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f69903e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f69908j;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        ValueAnimator r102 = this.f69904f;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        AnimatorSet r103 = this.f69922x;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        AnimatorSet r104 = this.f69921w;
        if (r104 == null) goto L18;
        r104.cancel();
        return;
    }

    public final DecimalFormat getDf() {
        return this.H;
    }

    public static void S5(View r100) {
        if (r100 == null) goto L5;
        r100.setVisibility(8);
        return;
    }

    @Override // qb0.b
    public final void D3(long r100) {
        this.f69901c = r100;
        Disposable r101 = this.f69903e;
        if (r101 != null) goto L5;
    L9:
        db0.a r102 = this.f69902d;
        if (r102 == null) goto L23;
        com.bytedance.android.live.ktv.common.midi.g r103 = this.I;
        if (r103 != null) goto L14;
    L18:
        Single<List<cb0.c>> r104 = r102.findMidiSegments(r100 - 1360, 3470 + r100);
        if (r104 != null) goto L21;
        return;
    L21:
        this.f69903e = r104.compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r100), e.f69932a);
        return;
    L14:
        if (r103.getCurrentMode() != 1) goto L18;
        r104 = r102.findMidiSegments(r100 - 1000, 2500 + r100);
        if (r104 != null) goto L21;
        return;
    L23:
        return;
    L5:
        if (r101.isDisposed() == true) goto L9;
        Disposable r105 = this.f69903e;
        if (r105 == null) goto L9;
        r105.dispose();
        goto L9
    }

    @Override // qb0.b
    public final void J3(long r100) {
        this.f69901c = r100;
    }

    public final void setPerformStrategy(com.bytedance.android.live.ktv.common.midi.g r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.I = r100;
        TextView r101 = this.D;
        if (r101 == null) goto L5;
        r101.setTextColor(r100.B());
    L5:
        y(r100.z());
        postDelayed(new f(this), 100);
    }

    @Override // qb0.b
    public void setScoreInterval(long r100) {
        this.f69909k = r100;
    }

    @Override // qb0.b
    public final void y(MidiSkinDressInfo r100) {
        this.L = r100;
        Pair<String, String> r101 = null;
        String r102 = null;
        r102 = null;
        r102 = null;
        if (T5() == false) goto L38;
        ImageView r103 = this.f69910l;
        MidiSkinDressInfo r104 = this.L;
        if (r104 == null) goto L11;
        MidiSkinMaterial r105 = r104.getMaterial();
        if (r105 == null) goto L11;
        BuoyMaterial r106 = r105.getBuoy();
        if (r106 == null) goto L11;
        k r107 = r106.getBuoyTailing();
    L12:
        ImageUtil.loadImage(r103, r107, 0);
        ImageView r108 = this.f69911m;
        MidiSkinDressInfo r109 = this.L;
        if (r109 == null) goto L19;
        MidiSkinMaterial r110 = r109.getMaterial();
        if (r110 == null) goto L19;
        BuoyMaterial r111 = r110.getBuoy();
        if (r111 == null) goto L19;
        k r112 = r111.getBuoyBall();
    L20:
        ImageUtil.loadImage(r108, r112, 0);
        KSongToneLinesView r113 = this.f69913o;
        if (r113 == null) goto L60;
        MidiSkinDressInfo r114 = this.L;
        if (r114 == null) goto L29;
        MidiSkinMaterial r115 = r114.getMaterial();
        if (r115 == null) goto L29;
        BackgroundMaterial r116 = r115.getBg();
        if (r116 == null) goto L29;
        String r117 = r116.getToneLineStart();
    L30:
        MidiSkinDressInfo r118 = this.L;
        if (r118 == null) goto L37;
        MidiSkinMaterial r119 = r118.getMaterial();
        if (r119 == null) goto L37;
        BackgroundMaterial r120 = r119.getBg();
        if (r120 == null) goto L37;
        r102 = r120.getToneLineEnd();
    L37:
        r113.f69747o = TuplesKt.to(r117, r102);
    L29:
        r117 = null;
    L60:
        TextView r121 = this.D;
        if (r121 == null) goto L68;
        com.bytedance.android.live.ktv.common.midi.g r122 = this.I;
        if (r122 == null) goto L65;
        int r123 = r122.B();
    L66:
        r121.setTextColor(r123);
        return;
    L65:
        r123 = s1.h(R.color.ttlive_chorus_midi_score_low_text_color);
        goto L66
    L68:
        return;
    L19:
        r112 = null;
    L11:
        r107 = null;
        goto L12
    L38:
        com.bytedance.android.live.ktv.common.midi.g r124 = this.I;
        if (r124 != null) goto L41;
    L51:
        ImageView r125 = this.f69910l;
        if (r125 == null) goto L54;
        r125.setImageResource(R.drawable.ttlive_ktv_hit_float_ball_tail);
    L54:
        ImageView r126 = this.f69911m;
        if (r126 == null) goto L57;
        r126.setImageResource(R.drawable.ttlive_ktv_hit_float_ball);
    L57:
        KSongToneLinesView r127 = this.f69913o;
        if (r127 == null) goto L60;
        r127.f69747o = null;
        goto L60
    L41:
        if (r124.getCurrentMode() != 2) goto L51;
        ImageView r128 = this.f69910l;
        if (r128 == null) goto L45;
        r128.setImageResource(R.drawable.ttlive_chorus_hit_tail);
    L45:
        KSongToneLinesView r129 = this.f69913o;
        if (r129 == null) goto L60;
        com.bytedance.android.live.ktv.common.midi.g r130 = this.I;
        if (r130 == null) goto L50;
        r101 = r130.E();
    L50:
        r129.f69747o = r101;
        goto L60
    }

    @Override // qb0.b
    public final void D5(int r100, int r101) {
        this.f69905g = r100;
        this.f69906h = r101;
        KSongToneLinesView r102 = this.f69913o;
        if (r102 == null) goto L6;
        r102.f69739g = r100;
        r102.f69740h = r101;
        r102.f69745m = r102.f69746n / (r101 - r100);
        return;
    }

    @Override // qb0.b
    public final void f0(db0.a r100, com.bytedance.android.live.ktv.common.midi.g r101) {
        Intrinsics.checkNotNullParameter(r100, "midiDataHolder");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f69902d = r100;
        this.I = r101;
        if (r101 != null) goto L5;
    L12:
        com.bytedance.android.live.ktv.common.midi.g r102 = this.I;
        if (r102 != null) goto L15;
    L22:
        KSongToneLinesView r103 = this.f69913o;
        if (r103 == null) goto L25;
        r103.e(1360, 3470);
    L25:
        ConstraintLayout r104 = this.C;
        if (r104 == null) goto L28;
        r104.setVisibility(8);
    L28:
        com.bytedance.android.live.ktv.common.midi.g r105 = this.I;
        if (r105 != null) goto L31;
    L38:
        this.f69920v = 0 - this.f69919u;
    L39:
        postDelayed(new c(this), 100);
        com.bytedance.android.live.ktv.common.midi.e.b("KtvMidiViewV2", "initView topAdapter : " + this.f69920v);
        return;
    L31:
        if (r105.L() != true) goto L38;
        com.bytedance.android.live.ktv.common.midi.g r106 = this.I;
        if (r106 != null) goto L35;
    L37:
        this.f69920v = s1.f(19.0f) - this.f69919u;
        goto L39
    L35:
        if (r106.getCurrentMode() != 2) goto L37;
        this.f69920v = 0 - this.f69919u;
        goto L39
    L15:
        if (r102.getCurrentMode() != 1) goto L22;
        KSongToneLinesView r107 = this.f69913o;
        if (r107 == null) goto L19;
        r107.e(1000, 2500);
    L19:
        View r108 = this.F;
        if (r108 == null) goto L28;
        r108.setVisibility(8);
        goto L28
    L5:
        if (r101.getCurrentMode() != 2) goto L12;
        UIUtils.updateLayout(this.f69913o, -3, -1);
        KSongToneLinesView r109 = this.f69913o;
        if (r109 == null) goto L9;
        r109.f69746n = s1.f(18.0f);
    L9:
        KSongToneLinesView r110 = this.f69913o;
        if (r110 == null) goto L12;
        r110.f69736d = s1.j(R.dimen.ttlive_rt_chorus_midi_container_width);
        goto L12
    }

    public KtvMidiViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f69899a = com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvMidiViewV2$midiHitAnimCallback$1(this));
        this.f69900b = ((Boolean) vm2.h.G1.getValue(null, vm2.h.f556082a[135(0x87, float:1.89E-43)])).booleanValue();
        this.f69905g = 58;
        this.f69906h = 90;
        this.f69909k = vm2.h.D();
        this.f69918t = com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvMidiViewV2$hitAnimationCallback$1(this));
        this.f69919u = s1.f(9.0f);
        this.f69920v = s1.f(14.0f);
        s1.f(92.0f);
        this.f69924z = vm2.h.H();
        this.A = vm2.h.J();
        this.G = -1.0f;
        this.H = new DecimalFormat("#0.0");
        this.f69898J = 1;
        this.N = new i(this);
        this.B = new Handler(Looper.getMainLooper(), new a(this));
        ViewGroup.inflate(r100, R.layout.ttlive_ktv_midi_view_v2, this);
        this.f69912n = (HSImageView) findViewById(R.id.midi_tone_hit_bg);
        this.f69911m = (ImageView) findViewById(R.id.tonePoint);
        this.f69910l = (ImageView) findViewById(R.id.tonePoint_tail);
        this.f69913o = (KSongToneLinesView) findViewById(R.id.toneLines);
        this.C = (ConstraintLayout) findViewById(R.id.ktv_component_midi_score_content);
        this.D = (TextView) findViewById(R.id.ktv_component_midi_score_text);
        this.E = (ImageView) findViewById(R.id.ktv_component_midi_score_bg);
        this.F = findViewById(R.id.midi_divide_line);
    }

    public static final void R5(KtvMidiViewV2 r100, long r101, long r102) {
        long r103 = r102 + r101;
        int r104 = r100.getWidth();
        if (r104 == 0) goto L36;
        ImageView r105 = r100.f69911m;
        ViewGroup.LayoutParams r106 = null;
        if (r105 == null) goto L8;
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
    L10:
        if ((r107 instanceof ConstraintLayout.LayoutParams) == true) goto L12;
        r107 = null;
    L12:
        ConstraintLayout.LayoutParams r108 = (ConstraintLayout.LayoutParams) r107;
        ImageView r109 = r100.f69910l;
        if (r109 == null) goto L15;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
    L17:
        if ((r110 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        r106 = r110;
    L20:
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r106;
        float r112 = (r104 * r101) / r103;
        ImageView r113 = r100.f69911m;
        if (r113 == null) goto L23;
        int r114 = r113.getWidth();
    L24:
        if (r108 == null) goto L26;
        r108.setMarginStart((int) (r112 - (r114 / 2)));
    L26:
        if (r111 == null) goto L28;
        r111.setMarginStart((int) (r112 - s1.e(55.0f)));
    L28:
        ImageView r115 = r100.f69911m;
        if (r115 == null) goto L31;
        r115.setLayoutParams(r108);
    L31:
        ImageView r116 = r100.f69910l;
        if (r116 == null) goto L35;
        r116.setLayoutParams(r111);
        return;
    L35:
        return;
    L23:
        r114 = 0;
        goto L24
    L15:
        r110 = null;
        goto L17
    L8:
        r107 = null;
        goto L10
    }

    public /* synthetic */ KtvMidiViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // qb0.b
    public final Pair<Float, Float> l1(float r100, float r101, float r110, boolean r111, boolean r112) {
        com.bytedance.android.live.ktv.common.midi.g r102 = this.I;
        if (r102 == null) goto L5;
        int r103 = r102.getCurrentMode();
    L7:
        if (r103 != 1) goto L14;
        com.bytedance.android.live.ktv.common.midi.f r104 = this.K;
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L15:
        com.bytedance.android.live.ktv.common.midi.g r106 = this.I;
        if (r106 != null) goto L18;
    L24:
        boolean r107 = false;
    L25:
        Message r108 = null;
        if (r105 == false) goto L65;
        if (r111 == true) goto L65;
        float r113 = 0;
        if (r100 > r113) goto L31;
    L35:
        boolean r114 = false;
    L37:
        if (r114 == true) goto L39;
    L51:
        if (r114 == true) goto L65;
        if (this.f69923y == false) goto L65;
        Handler r115 = this.B;
        if (r115 == null) goto L57;
        Message r116 = r115.obtainMessage(1);
    L58:
        Handler r109 = this.B;
        if (r109 == null) goto L61;
        r109.removeMessages(0);
    L61:
        if (r116 == null) goto L65;
        Handler r117 = this.B;
        if (r117 == null) goto L65;
        r117.sendMessageDelayed(r116, 300);
        goto L65
    L57:
        r116 = null;
        goto L58
    L39:
        if (this.f69923y == true) goto L51;
        Handler r118 = this.B;
        if (r118 == null) goto L43;
        Message r119 = r118.obtainMessage(0);
    L44:
        Handler r120 = this.B;
        if (r120 == null) goto L47;
        r120.removeMessages(1);
    L47:
        if (r119 == null) goto L65;
        Handler r121 = this.B;
        if (r121 == null) goto L65;
        r121.sendMessageDelayed(r119, 300);
        goto L65
    L43:
        r119 = null;
        goto L44
    L31:
        if (r101 <= r113) goto L35;
        if (Math.abs(r100 - r101) > ((Number) KtvSettingHelper.C0.getValue()).intValue()) goto L35;
        r114 = true;
    L65:
        if (r107 == false) goto L147;
        ConstraintLayout r122 = this.C;
        if (r122 == null) goto L70;
        r122.setVisibility(0);
    L70:
        if (r110 > 0) goto L72;
    L149:
        int r123 = this.f69916r % this.f69924z;
        this.f69916r = r123 + 1;
        if (r123 != 0) goto L185;
        if (getVisibility() != 0) goto L185;
        if (r100 >= this.f69905g) goto L157;
    L160:
        int r124 = this.f69917s + 1;
        this.f69917s = r124;
        if (r124 < this.A) goto L163;
    L164:
        KSongToneLinesView r125 = this.f69913o;
        Intrinsics.checkNotNull(r125);
        int r126 = r125.f((int) r101) + this.f69920v;
        this.f69915q = r126;
        ValueAnimator r127 = this.f69904f;
        if (r127 == null) goto L169;
        if (r127.isRunning() != true) goto L169;
    L183:
        return new Pair(Float.valueOf(s1.f(92.0f)), Float.valueOf(this.f69915q));
    L169:
        if (this.f69914p == r126) goto L183;
        Handler r128 = this.B;
        if (r128 == null) goto L173;
        r108 = r128.obtainMessage(3);
    L173:
        if (r108 == null) goto L175;
        r108.obj = Integer.valueOf(this.f69915q);
    L175:
        Handler r129 = this.B;
        if (r129 == null) goto L178;
        r129.removeMessages(3);
    L178:
        if (r108 == null) goto L183;
        Handler r130 = this.B;
        if (r130 == null) goto L183;
        r130.sendMessage(r108);
        goto L183
    L163:
        return new Pair(Float.valueOf(s1.f(92.0f)), Float.valueOf(this.f69915q));
    L157:
        if (r100 > this.f69906h) goto L160;
        this.f69917s = 0;
    L185:
        return new Pair(Float.valueOf(s1.f(92.0f)), Float.valueOf(this.f69915q));
    L72:
        if (r110 == this.G) goto L149;
        if (r110 == 0.0f) goto L149;
        this.G = r110;
        ConstraintLayout r131 = this.C;
        if (r131 == null) goto L78;
        r131.setVisibility(0);
    L78:
        Integer r132 = this.f69907i;
        if (r132 != null) goto L82;
    L83:
        TextView r133 = this.D;
        if (r133 == null) goto L86;
        r133.setTypeface(Typeface.defaultFromStyle(2));
    L86:
        this.f69907i = 2;
    L87:
        float r134 = this.G;
        if (((int) r134) < 100) goto L92;
        TextView r135 = this.D;
        if (r135 == null) goto L95;
        r135.setText("100");
    L95:
        ImageView r136 = this.E;
        if (r136 == null) goto L98;
        r136.setVisibility(0);
    L98:
        TextView r137 = this.D;
        if (r137 == null) goto L101;
        r137.setBackground(null);
    L101:
        com.bytedance.android.live.ktv.common.midi.g r138 = this.I;
        if (r138 != null) goto L104;
    L115:
        int r139 = this.f69898J;
        if (r139 == 1) goto L134;
        if (r139 != 2) goto L149;
        if (this.G < vm2.h.z()) goto L127;
        ImageView r140 = this.E;
        if (r140 == null) goto L124;
        r140.setImageResource(R.drawable.ttlive_ktv_component_midi_score_high_bottom_bg);
    L124:
        TextView r141 = this.D;
        if (r141 == null) goto L149;
        r141.setTextColor(s1.h(R.color.ttlive_ktv_midi_score_high_text_color));
        goto L149
    L127:
        ImageView r142 = this.E;
        if (r142 == null) goto L130;
        r142.setImageResource(R.drawable.ttlive_ktv_component_midi_score_low_bottom_bg);
    L130:
        TextView r143 = this.D;
        if (r143 == null) goto L149;
        r143.setTextColor(s1.h(R.color.ttlive_ktv_midi_score_low_text_color));
        goto L149
    L134:
        if (this.G < vm2.h.z()) goto L141;
        ImageView r144 = this.E;
        if (r144 == null) goto L138;
        r144.setImageResource(R.drawable.ttlive_ktv_component_midi_score_high_top_bg);
    L138:
        TextView r145 = this.D;
        if (r145 == null) goto L149;
        r145.setTextColor(s1.h(R.color.ttlive_ktv_midi_score_high_text_color));
        goto L149
    L141:
        ImageView r146 = this.E;
        if (r146 == null) goto L144;
        r146.setImageResource(R.drawable.ttlive_ktv_component_midi_score_bg);
    L144:
        TextView r147 = this.D;
        if (r147 == null) goto L149;
        r147.setTextColor(s1.h(R.color.ttlive_ktv_midi_score_low_text_color));
        goto L149
    L104:
        if (r138.getCurrentMode() != 2) goto L115;
        ImageView r148 = this.E;
        if (r148 == null) goto L108;
        r148.setImageResource(R.drawable.ttlive_ktv_component_midi_score_bg);
    L108:
        TextView r149 = this.D;
        if (r149 == null) goto L149;
        com.bytedance.android.live.ktv.common.midi.g r150 = this.I;
        if (r150 == null) goto L113;
        int r151 = r150.B();
    L114:
        r149.setTextColor(r151);
        goto L149
    L113:
        r151 = s1.h(R.color.ttlive_chorus_midi_score_low_text_color);
        goto L114
    L92:
        TextView r152 = this.D;
        if (r152 == null) goto L95;
        r152.setText(this.H.format(Float.valueOf(r134)));
        goto L95
    L82:
        if (2 == r132.intValue()) goto L87;
    L147:
        if (r112 == true) goto L149;
        S5(this.C);
        goto L149
    L18:
        if (r106.L() != true) goto L24;
        com.bytedance.android.live.ktv.common.midi.f r153 = this.K;
        if (r153 == null) goto L24;
        if (r153.b() != true) goto L24;
        r107 = true;
        goto L25
    L11:
        if (r104.c() != true) goto L13;
    L14:
        r105 = true;
        goto L15
    L5:
        r103 = -1;
        goto L7
    }
}
