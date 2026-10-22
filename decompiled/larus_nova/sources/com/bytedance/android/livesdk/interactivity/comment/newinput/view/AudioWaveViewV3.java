package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.common.utility.UIUtils;
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

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioWaveViewV3;", "Landroid/widget/LinearLayout;", "", "getViewAnimatorHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioWaveViewV3 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<View> f136065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<ValueAnimator> f136066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile short[] f136067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f136068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f136069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f136070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f136071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f136072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f136073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f136074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f136075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f136076l;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioWaveViewV3$a$a, reason: collision with other inner class name */
        public static final class C2142a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AudioWaveViewV3 f136077a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ValueAnimator f136078b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                AudioWaveViewV3 r101 = this.f136077a;
                if (r101.f136076l == false) goto L5;
                return;
            L5:
                ValueAnimator r102 = this.f136078b;
                int r103 = AudioWaveViewV3.a(r101);
                r102.setIntValues(new int[]{this.f136077a.f136070f, r103});
                AudioWaveViewV3 r104 = this.f136077a;
                r102.setDuration((r104.f136075k * ((long) r103)) / ((long) r104.f136069e));
                r102.start();
            }

            public C2142a(AudioWaveViewV3 r100, ValueAnimator r101) {
                Intrinsics.checkNotNullParameter(r100, "waveView");
                Intrinsics.checkNotNullParameter(r101, "animator");
                this.f136077a = r100;
                this.f136078b = r101;
            }
        }

        public static final class b implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f136079a;

            public b(View r100) {
                Intrinsics.checkNotNullParameter(r100, "animatorView");
                this.f136079a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                View r101 = this.f136079a;
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

    public final void b() {
        this.f136076l = false;
        Iterator<ValueAnimator> r100 = this.f136066b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ValueAnimator r101 = r100.next();
        int r102 = getViewAnimatorHeight();
        r101.setIntValues(new int[]{this.f136070f, r102});
        r101.setDuration((this.f136075k * ((long) r102)) / ((long) this.f136069e));
        r101.start();
        goto L4
    }

    private final int getViewAnimatorHeight() {
        if (this.f136067c == null) goto L19;
        short[] r100 = this.f136067c;
        Intrinsics.checkNotNull(r100);
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L19;
        short[] r102 = this.f136067c;
        Intrinsics.checkNotNull(r102);
        Random r103 = this.f136068d;
        short[] r104 = this.f136067c;
        Intrinsics.checkNotNull(r104);
        float r105 = (3 * Math.abs(r102[r103.nextInt(r104.length)])) / 32767;
        double r106 = r105;
        if (r106 <= 0.6d) goto L14;
        return this.f136069e;
    L14:
        if (r106 < 0.1d) goto L21;
        int r107 = this.f136069e;
        int r108 = this.f136070f;
        return RangesKt.coerceAtMost((int) (((r107 - r108) * r105) + r108), r107);
    L21:
        return this.f136070f;
    L7:
        r101 = false;
    L19:
        return this.f136070f;
    }

    public final void c() {
        Iterator<ValueAnimator> r100 = this.f136066b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().cancel();
        goto L4
    L6:
        this.f136076l = true;
        this.f136067c = null;
    }

    public AudioWaveViewV3(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ int a(AudioWaveViewV3 r100) {
        return r100.getViewAnimatorHeight();
    }

    public AudioWaveViewV3(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        if (r101 != 0) goto L5;
        return;
    L5:
        if (isAttachedToWindow() == false) goto L9;
        c();
        return;
    }

    public AudioWaveViewV3(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f136065a = new ArrayList();
        this.f136066b = new ArrayList();
        this.f136068d = new Random();
        this.f136076l = true;
        if (r101 == null) goto L7;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.wave_animator_time, R.attr.wave_corner, R.attr.wave_count, R.attr.wave_end_color, R.attr.wave_margin, R.attr.wave_max_height, R.attr.wave_min_height, R.attr.wave_start_color, R.attr.wave_width});
        if (r102 == null) goto L7;
        this.f136069e = (int) r102.getDimension(5, UIUtils.dip2Px(r100, 24.0f));
        this.f136070f = (int) r102.getDimension(6, UIUtils.dip2Px(r100, 4.0f));
        this.f136071g = (int) r102.getDimension(4, UIUtils.dip2Px(r100, 4.0f));
        this.f136072h = (int) r102.getDimension(8, UIUtils.dip2Px(r100, 2.0f));
        this.f136073i = (int) r102.getDimension(1, UIUtils.dip2Px(r100, 1.0f));
        this.f136074j = r102.getInt(2, 13);
        this.f136075k = r102.getInt(0, (int) 300);
        r102.recycle();
    L7:
        int r103 = this.f136074j;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        View r105 = new View(r100);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(this.f136072h, this.f136070f);
        int r107 = this.f136071g >> 1;
        r106.setMargins(r107, 0, r107, 0);
        r105.setLayoutParams(r106);
        GradientDrawable r108 = new GradientDrawable();
        r108.setCornerRadius(this.f136073i);
        r108.setColor(-1);
        Unit r109 = Unit.INSTANCE;
        r105.setBackground(r108);
        this.f136065a.add(r105);
        addView(r105);
        ArrayList<ValueAnimator> r111 = this.f136066b;
        ValueAnimator r112 = ValueAnimator.ofInt(new int[]{1, 2});
        r112.setRepeatCount(1);
        r112.setRepeatMode(2);
        r112.setInterpolator(new AccelerateDecelerateInterpolator());
        r112.addUpdateListener(new a.b(r105));
        r112.addListener(new a.C2142a(this, r112));
        r111.add(r112);
        r104 = r104 + 1;
        goto L8
    }
}
