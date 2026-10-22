package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.livesdk.utils.t6;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u0004\u0018\u00010\tR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/atmosphere/hot/MiniAppHotAtmosphereView;", "Landroid/widget/LinearLayout;", "", "width", "", "setMaxWidth", "Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/atmosphere/hot/a;", "cb", "setCallback", "Lcom/bytedance/android/livesdk/wrds/syncdata/openplatform/b;", MapController.ITEM_LAYER_TAG, "setHotAtmosphereData", "getCurrentItem", "Landroid/graphics/Path;", ce.f26396k, "Lkotlin/Lazy;", "getPath", "()Landroid/graphics/Path;", "path", "Landroid/graphics/Paint;", "l", "getSolidPaint", "()Landroid/graphics/Paint;", "solidPaint", "m", "getBorderPaint", "borderPaint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppHotAtmosphereView extends LinearLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f84850s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SimpleDraweeView f84851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f84852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f84853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f84854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animator f84855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f84856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animator f84857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f84858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f84859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f84860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f84861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f84862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f84863m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f84864n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedList<com.bytedance.android.livesdk.wrds.syncdata.openplatform.b> f84865o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.b f84866p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.b f84867q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a f84868r;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniAppHotAtmosphereView f84869a;

        public static final class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f84870a;

            public a(b r100) {
                this.f84870a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                MiniAppHotAtmosphereView r101 = this.f84870a.f84869a;
                Object r102 = r100.getAnimatedValue();
                if (r102 == null) goto L7;
                r101.f84856f = ((Float) r102).floatValue();
                this.f84870a.f84869a.invalidate();
                return;
            L7:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.MiniAppHotAtmosphereView$b$b, reason: collision with other inner class name */
        public static final class C1300b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f84871a;

            public C1300b(b r100) {
                this.f84871a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                this.f84871a.f84869a.f84856f = 1.0f;
            }
        }

        public b(MiniAppHotAtmosphereView r100) {
            this.f84869a = r100;
        }

        public final void a() {
            MiniAppHotAtmosphereView r100 = this.f84869a;
            if (r100.f84864n == true) goto L5;
            return;
        L5:
            ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r101.addUpdateListener(new a(this));
            r101.addListener(new C1300b(this));
            r101.setDuration(160);
            Unit r102 = Unit.INSTANCE;
            r100.f84857g = r101;
            Animator r103 = this.f84869a.f84857g;
            if (r103 == null) goto L9;
            r103.start();
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

    static {
    }

    public MiniAppHotAtmosphereView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MiniAppHotAtmosphereView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getBorderPaint() {
        return (Paint) this.f84863m.getValue();
    }

    private final Path getPath() {
        return (Path) this.f84861k.getValue();
    }

    private final Paint getSolidPaint() {
        return (Paint) this.f84862l.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasTransientState() {
        return false;
    }

    public final void d() {
        if (this.f84864n == true) goto L5;
        return;
    L5:
        if (this.f84855e != null) goto L34;
        final com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r100 = this.f84865o.poll();
        if (r100 == null) goto L32;
        ViewGroup r101 = this.f84853c;
        if (r101 == null) goto L33;
        this.f84866p = r100;
        r101.setVisibility(0);
        String r102 = r100.c();
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r103 = this.f84866p;
        if (r103 == null) goto L14;
        String r104 = r103.c();
    L16:
        if (Intrinsics.areEqual(r102, r104) == true) goto L18;
    L20:
        this.f84852b = false;
        SimpleDraweeView r105 = this.f84851a;
        if (r105 == null) goto L23;
        AbstractDraweeController r106 = Fresco.newDraweeControllerBuilder().setOldController(r105.getController()).setUri(r100.c()).setAutoPlayAnimations(true).build();
        r106.addControllerListener(new com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.b(this));
        Unit r107 = Unit.INSTANCE;
        r105.setController(r106);
    L23:
        TextView r108 = this.f84854d;
        if (r108 == null) goto L29;
        final long r109 = r100.d();
        com.bytedance.android.live.openplatform.impl.base.utils.text.c r110 = new com.bytedance.android.live.openplatform.impl.base.utils.text.c(new SpannableStringBuilder());
        r110.d(12, MiniAppHotAtmosphereView$buildText$1$1.INSTANCE);
        com.bytedance.android.live.openplatform.impl.base.utils.text.b.a.a(r110, (int) a(1.0f));
        r110.d(20, new MiniAppHotAtmosphereView$buildText$$inlined$buildSpannedString$lambda$1(this, r109, r100));
        if (r100.d() < 10000) goto L28;
        com.bytedance.android.live.openplatform.impl.base.utils.text.b.a.a(r110, (int) a(2.5f));
        r110.d(13, MiniAppHotAtmosphereView$buildText$1$3.INSTANCE);
    L28:
        r108.setText(new SpannedString(r110.f84078a));
    L29:
        AnimatorSet r111 = h.c(r101, new float[]{1.0f, 1.3f, 1.0f});
        r111.setDuration(250);
        h.a(r111, new MiniAppHotAtmosphereView$onTextChange$$inlined$let$lambda$1(this, r100));
        Unit r112 = Unit.INSTANCE;
        this.f84855e = r111;
        r111.start();
        return;
    L18:
        if (this.f84852b == false) goto L20;
    L14:
        r104 = null;
        goto L16
    L33:
        return;
    L32:
        return;
    }

    public final void c() {
        if (getChildCount() != 0) goto L6;
        setPadding(0, 0, (int) a(8.0f), 0);
        int r100 = (int) a(24.0f);
        LinearLayout r101 = new LinearLayout(getContext());
        r101.setOrientation(0);
        r101.setGravity(80);
        SimpleDraweeView r102 = new SimpleDraweeView(r101.getContext());
        this.f84851a = r102;
        r102.setLayoutParams(new LinearLayout.LayoutParams((int) a(53.0f), r100));
        r102.getHierarchy().setFadeDuration(0);
        Unit r103 = Unit.INSTANCE;
        r101.addView(r102);
        FrameLayout r104 = new FrameLayout(r101.getContext());
        this.f84853c = r104;
        r104.setLayoutParams(new LinearLayout.LayoutParams(-1, r100));
        r104.setPadding((int) a(2.0f), 0, 0, 0);
        ItalicTextView r105 = new ItalicTextView(r104.getContext(), null);
        this.f84854d = r105;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.gravity = 16;
        r105.setLayoutParams(r106);
        r105.setIncludeFontPadding(false);
        r105.setTypeface(null, 1);
        r105.setTextColor(-1);
        r104.addView(r105);
        r101.addView(r104);
        addView(r101);
        return;
    }

    public final com.bytedance.android.livesdk.wrds.syncdata.openplatform.b getCurrentItem() {
        return this.f84866p;
    }

    public static String b(long r100) {
        if (r100 <= 9999) goto L9;
        if (((r100 / ((long) 1000)) % ((long) 10)) == 0) goto L10;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r100 / 10000.0d)}, 1));
    L10:
        return String.valueOf(r100 / ((long) 10000));
    L9:
        return String.valueOf(r100);
    }

    public static int e(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L16;
        return 0;
    L16:
    L14:
        return -16777216;
    L10:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L12;
        r100 = "#".concat(r100);     // Catch: Exception -> L14
    L12:
        return Color.parseColor(r100);
    L5:
        r101 = false;
        goto L6
    }

    public final float a(float r100) {
        return t6.a(getContext(), r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r100 = this.f84866p;
        if (r100 != null) goto L5;
        r100 = this.f84865o.peek();
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        float r101 = getWidth() * this.f84856f;
        int r102 = getHeight();
        boolean r103 = this.f84860j;
        if (r103 == false) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r103 == false) goto L16;
    L19:
        boolean r110 = true;
    L20:
        this.f84867q = r100;
        int r105 = e("#FFB11A");
        float r106 = 255;
        int r107 = (int) (0.8f * r106);
        int r108 = (int) (0.6f * r106);
        int[] r111 = {ColorUtils.setAlphaComponent(r105, r107), ColorUtils.setAlphaComponent(r105, r108), 0};
        int r109 = e("#FFDC60");
        int[] r112 = {ColorUtils.setAlphaComponent(r109, r107), ColorUtils.setAlphaComponent(r109, r108), 0};
        if (r104 == false) goto L23;
        char r113 = 3;
        getSolidPaint().setShader(new LinearGradient(0.0f, 0.0f, r101, 0.0f, r111, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.CLAMP));
        getBorderPaint().setShader(new LinearGradient(0.0f, 0.0f, r101, 0.0f, r112, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.CLAMP));
    L24:
        if (r110 == false) goto L26;
        float r114 = getHeight() / 2.0f;
        getPath().reset();
        Path r115 = getPath();
        RectF r116 = new RectF(0.0f, 0.0f, r101 + 0.0f, r102 + 0.0f);
        float[] r117 = new float[8];
        r117[0] = r114;
        r117[1] = r114;
        r117[2] = 0.0f;
        r117[r113] = 0.0f;
        r117[4] = 0.0f;
        r117[5] = 0.0f;
        r117[6] = r114;
        r117[7] = r114;
        r115.addRoundRect(r116, r117, Path.Direction.CW);
    L26:
        r210.drawPath(getPath(), getSolidPaint());
        r210.drawPath(getPath(), getBorderPaint());
        return;
    L23:
        r113 = 3;
        goto L24
    L16:
        if (this.f84867q == null) goto L19;
        r110 = false;
        goto L20
    L10:
        if (this.f84867q == null) goto L13;
        r104 = false;
        goto L14
    }

    public final void setCallback(com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a r100) {
        this.f84868r = r100;
    }

    public final void setHotAtmosphereData(com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r101 = this.f84865o.peekLast();
        if (r101 != null) goto L5;
        r101 = this.f84866p;
    L5:
        boolean r102 = true;
        if (r101 != null) goto L8;
    L13:
        if (r102 == false) goto L16;
        this.f84865o.offer(r100);
    L16:
        if (this.f84864n == true) goto L18;
        return;
    L18:
        if (this.f84865o.isEmpty() == true) goto L23;
        d();
        return;
    L23:
        return;
    L8:
        if (r101.d() < r100.d()) goto L10;
    L12:
        r102 = false;
        goto L13
    L10:
        if ((!Intrinsics.areEqual(b(r101.d()), b(r100.d()))) == false) goto L12;
        goto L12
    }

    public final void setMaxWidth(int r100) {
        this.f84859i = Integer.valueOf(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE), r101);
        Integer r102 = this.f84859i;
        if (r102 != null) goto L6;
        r102 = Integer.valueOf(View.MeasureSpec.getSize(r100));
    L6:
        if (getMeasuredWidth() <= r102.intValue()) goto L9;
        setMeasuredDimension(r102.intValue(), getMeasuredHeight());
    L9:
        if (getMeasuredWidth() <= 0) goto L21;
        TextView r103 = this.f84854d;
        if (r103 == null) goto L22;
        int r104 = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        SimpleDraweeView r105 = this.f84851a;
        if (r105 == null) goto L15;
        int r106 = r105.getMeasuredWidth();
    L16:
        float r107 = (r104 - r106) / r103.getMeasuredWidth();
        if (r107 >= 1) goto L19;
        r103.setScaleX(r107);
        r103.setScaleY(r107);
        r103.setPivotX(0.0f);
        r103.setPivotY(r103.getMeasuredHeight() / 2.0f);
        return;
    L19:
        r103.setScaleX(1.0f);
        r103.setScaleY(1.0f);
        return;
    L15:
        r106 = 0;
        goto L16
    L22:
        return;
    }

    public MiniAppHotAtmosphereView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f84858h = new b(this);
        this.f84860j = true;
        this.f84861k = LazyKt.lazy(MiniAppHotAtmosphereView$path$2.INSTANCE);
        this.f84862l = LazyKt.lazy(MiniAppHotAtmosphereView$solidPaint$2.INSTANCE);
        this.f84863m = LazyKt.lazy(new MiniAppHotAtmosphereView$borderPaint$2(r100));
        this.f84865o = new LinkedList();
        setWillNotDraw(false);
        setClipToPadding(false);
        setOrientation(1);
    }

    public /* synthetic */ MiniAppHotAtmosphereView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        this.f84860j = true;
        return;
    }
}
