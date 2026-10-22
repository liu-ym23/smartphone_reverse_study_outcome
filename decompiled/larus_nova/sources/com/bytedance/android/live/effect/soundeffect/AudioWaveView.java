package com.bytedance.android.live.effect.soundeffect;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/AudioWaveView;", "Landroid/widget/LinearLayout;", "", "getViewAnimatorHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioWaveView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<View> f68063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<ValueAnimator> f68064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile short[] f68065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f68066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f68068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f68069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f68070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f68071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f68072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f68073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f68074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f68075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f68076n;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.effect.soundeffect.AudioWaveView$a$a, reason: collision with other inner class name */
        public static final class C1113a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AudioWaveView f68077a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ValueAnimator f68078b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                AudioWaveView r101 = this.f68077a;
                if (r101.f68076n == false) goto L5;
                return;
            L5:
                ValueAnimator r102 = this.f68078b;
                int r103 = AudioWaveView.a(r101);
                r102.setIntValues(new int[]{this.f68077a.f68068f, r103});
                AudioWaveView r104 = this.f68077a;
                r102.setDuration((r104.f68075m * ((long) r103)) / ((long) r104.f68067e));
                r102.start();
            }

            public C1113a(AudioWaveView r100, ValueAnimator r101) {
                Intrinsics.checkNotNullParameter(r100, "waveView");
                Intrinsics.checkNotNullParameter(r101, "animator");
                this.f68077a = r100;
                this.f68078b = r101;
            }
        }

        public static final class b implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f68079a;

            public b(View r100) {
                Intrinsics.checkNotNullParameter(r100, "animatorView");
                this.f68079a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                View r101 = this.f68079a;
                ViewGroup.LayoutParams r102 = r101.getLayoutParams();
                Object r103 = r100.getAnimatedValue();
                if (r103 == null) goto L7;
                r102.height = ((Integer) r103).intValue();
                r101.requestLayout();
                return;
            L7:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    static {
    }

    private final int getViewAnimatorHeight() {
        if (this.f68065c == null) goto L19;
        short[] r100 = this.f68065c;
        Intrinsics.checkNotNull(r100);
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L19;
        short[] r102 = this.f68065c;
        Intrinsics.checkNotNull(r102);
        Random r103 = this.f68066d;
        short[] r104 = this.f68065c;
        Intrinsics.checkNotNull(r104);
        float r105 = (3 * Math.abs(r102[r103.nextInt(r104.length)])) / 32767;
        double r106 = r105;
        if (r106 <= 0.6d) goto L14;
        return this.f68067e;
    L14:
        if (r106 < 0.1d) goto L21;
        int r107 = this.f68067e;
        int r108 = this.f68068f;
        return RangesKt.coerceAtMost((int) (((r107 - r108) * r105) + r108), r107);
    L21:
        return this.f68068f;
    L7:
        r101 = false;
    L19:
        return this.f68068f;
    }

    public AudioWaveView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ int a(AudioWaveView r100) {
        return r100.getViewAnimatorHeight();
    }

    public AudioWaveView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        if (r101 == 0) goto L11;
        Iterator<ValueAnimator> r102 = this.f68064b.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().cancel();
        goto L6
    L8:
        this.f68076n = true;
        this.f68065c = null;
        return;
    }

    public AudioWaveView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f68063a = new ArrayList();
        this.f68064b = new ArrayList();
        this.f68066d = new Random();
        this.f68076n = true;
        int r100 = 0;
        if (r111 == null) goto L7;
        TypedArray r101 = r110.obtainStyledAttributes(r111, new int[]{R.attr.wave_animator_time, R.attr.wave_corner, R.attr.wave_count, R.attr.wave_end_color, R.attr.wave_margin, R.attr.wave_max_height, R.attr.wave_min_height, R.attr.wave_start_color, R.attr.wave_width});
        if (r101 == null) goto L7;
        this.f68067e = (int) r101.getDimension(5, UIUtils.dip2Px(r110, 24.0f));
        this.f68068f = (int) r101.getDimension(6, UIUtils.dip2Px(r110, 4.0f));
        this.f68069g = (int) r101.getDimension(4, UIUtils.dip2Px(r110, 4.0f));
        this.f68070h = (int) r101.getDimension(8, UIUtils.dip2Px(r110, 2.0f));
        this.f68071i = (int) r101.getDimension(1, UIUtils.dip2Px(r110, 1.0f));
        this.f68072j = r101.getColor(7, ColorProtector.parseColor("#FF6397"));
        this.f68073k = r101.getColor(3, ColorProtector.parseColor("#FF307A"));
        this.f68074l = r101.getInt(2, 13);
        this.f68075m = r101.getInt(0, (int) 300);
        r101.recycle();
    L7:
        int r102 = Color.red(this.f68072j);
        float r103 = (Color.red(this.f68073k) - r102) / this.f68074l;
        int r104 = Color.green(this.f68072j);
        float r105 = (Color.green(this.f68073k) - r104) / this.f68074l;
        int r106 = Color.red(this.f68072j);
        float r113 = Color.blue(this.f68073k) - r106;
        int r114 = this.f68074l;
        float r115 = r113 / r114;
        int r116 = 0;
    L8:
        if (r116 >= r114) goto L10;
        View r117 = new View(r110);
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(this.f68070h, this.f68068f);
        int r107 = this.f68069g >> 1;
        r118.setMargins(r107, r100, r107, r100);
        r117.setLayoutParams(r118);
        GradientDrawable r108 = new GradientDrawable();
        r108.setCornerRadius(this.f68071i);
        float r119 = r116;
        r108.setColor(Color.rgb(((int) (r103 * r119)) + r102, ((int) (r105 * r119)) + r104, ((int) (r119 * r115)) + r106));
        Unit r109 = Unit.INSTANCE;
        r117.setBackground(r108);
        this.f68063a.add(r117);
        addView(r117);
        ArrayList<ValueAnimator> r120 = this.f68064b;
        ValueAnimator r121 = ValueAnimator.ofInt(new int[]{1, 2});
        r121.setRepeatCount(1);
        r121.setRepeatMode(2);
        r121.setInterpolator(new AccelerateDecelerateInterpolator());
        r121.addUpdateListener(new a.b(r117));
        r121.addListener(new a.C1113a(this, r121));
        r120.add(r121);
        r116 = r116 + 1;
        r100 = 0;
        goto L8
    }
}
