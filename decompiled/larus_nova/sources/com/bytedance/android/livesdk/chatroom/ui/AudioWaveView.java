package com.bytedance.android.livesdk.chatroom.ui;

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

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/AudioWaveView;", "Landroid/widget/LinearLayout;", "", "getViewAnimatorHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioWaveView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<View> f112094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<ValueAnimator> f112095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile short[] f112096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f112097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f112098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f112099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f112100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f112101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f112102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f112103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f112104k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f112105l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f112106m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f112107n;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.AudioWaveView$a$a, reason: collision with other inner class name */
        public static final class C1668a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AudioWaveView f112108a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ValueAnimator f112109b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                AudioWaveView r101 = this.f112108a;
                if (r101.f112107n == false) goto L5;
                return;
            L5:
                ValueAnimator r102 = this.f112109b;
                int r103 = AudioWaveView.a(r101);
                r102.setIntValues(new int[]{this.f112108a.f112099f, r103});
                AudioWaveView r104 = this.f112108a;
                r102.setDuration((r104.f112106m * ((long) r103)) / ((long) r104.f112098e));
                r102.start();
            }

            public C1668a(AudioWaveView r100, ValueAnimator r101) {
                Intrinsics.checkNotNullParameter(r100, "waveView");
                Intrinsics.checkNotNullParameter(r101, "animator");
                this.f112108a = r100;
                this.f112109b = r101;
            }
        }

        public static final class b implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f112110a;

            public b(View r100) {
                Intrinsics.checkNotNullParameter(r100, "animatorView");
                this.f112110a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                View r101 = this.f112110a;
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
        this.f112107n = false;
        Iterator<ValueAnimator> r100 = this.f112095b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ValueAnimator r101 = r100.next();
        int r102 = getViewAnimatorHeight();
        r101.setIntValues(new int[]{this.f112099f, r102});
        r101.setDuration((this.f112106m * ((long) r102)) / ((long) this.f112098e));
        r101.start();
        goto L4
    }

    private final int getViewAnimatorHeight() {
        if (this.f112096c == null) goto L19;
        short[] r100 = this.f112096c;
        Intrinsics.checkNotNull(r100);
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L19;
        short[] r102 = this.f112096c;
        Intrinsics.checkNotNull(r102);
        Random r103 = this.f112097d;
        short[] r104 = this.f112096c;
        Intrinsics.checkNotNull(r104);
        float r105 = (3 * Math.abs(r102[r103.nextInt(r104.length)])) / 32767;
        double r106 = r105;
        if (r106 <= 0.6d) goto L14;
        return this.f112098e;
    L14:
        if (r106 < 0.1d) goto L21;
        int r107 = this.f112098e;
        int r108 = this.f112099f;
        return RangesKt.coerceAtMost((int) (((r107 - r108) * r105) + r108), r107);
    L21:
        return this.f112099f;
    L7:
        r101 = false;
    L19:
        return this.f112099f;
    }

    public final void c() {
        Iterator<ValueAnimator> r100 = this.f112095b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().cancel();
        goto L4
    L6:
        this.f112107n = true;
        this.f112096c = null;
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
        if (r101 != 0) goto L5;
        return;
    L5:
        if (isAttachedToWindow() == false) goto L9;
        c();
        return;
    }

    public AudioWaveView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f112094a = new ArrayList();
        this.f112095b = new ArrayList();
        this.f112097d = new Random();
        this.f112107n = true;
        int r100 = 0;
        if (r111 == null) goto L7;
        TypedArray r101 = r110.obtainStyledAttributes(r111, new int[]{R.attr.wave_animator_time, R.attr.wave_corner, R.attr.wave_count, R.attr.wave_end_color, R.attr.wave_margin, R.attr.wave_max_height, R.attr.wave_min_height, R.attr.wave_start_color, R.attr.wave_width});
        if (r101 == null) goto L7;
        this.f112098e = (int) r101.getDimension(5, UIUtils.dip2Px(r110, 24.0f));
        this.f112099f = (int) r101.getDimension(6, UIUtils.dip2Px(r110, 4.0f));
        this.f112100g = (int) r101.getDimension(4, UIUtils.dip2Px(r110, 4.0f));
        this.f112101h = (int) r101.getDimension(8, UIUtils.dip2Px(r110, 2.0f));
        this.f112102i = (int) r101.getDimension(1, UIUtils.dip2Px(r110, 1.0f));
        this.f112103j = r101.getColor(7, ColorProtector.parseColor("#FF6397"));
        this.f112104k = r101.getColor(3, ColorProtector.parseColor("#FF307A"));
        this.f112105l = r101.getInt(2, 13);
        this.f112106m = r101.getInt(0, (int) 300);
        r101.recycle();
    L7:
        int r102 = Color.red(this.f112103j);
        float r103 = (Color.red(this.f112104k) - r102) / this.f112105l;
        int r104 = Color.green(this.f112103j);
        float r105 = (Color.green(this.f112104k) - r104) / this.f112105l;
        int r106 = Color.blue(this.f112103j);
        float r113 = Color.blue(this.f112104k) - r106;
        int r114 = this.f112105l;
        float r115 = r113 / r114;
        int r116 = 0;
    L8:
        if (r116 >= r114) goto L10;
        View r117 = new View(r110);
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(this.f112101h, this.f112099f);
        int r107 = this.f112100g >> 1;
        r118.setMargins(r107, r100, r107, r100);
        r117.setLayoutParams(r118);
        GradientDrawable r108 = new GradientDrawable();
        r108.setCornerRadius(this.f112102i);
        float r119 = r116;
        r108.setColor(Color.rgb(((int) (r103 * r119)) + r102, ((int) (r105 * r119)) + r104, ((int) (r119 * r115)) + r106));
        Unit r109 = Unit.INSTANCE;
        r117.setBackground(r108);
        this.f112094a.add(r117);
        addView(r117);
        ArrayList<ValueAnimator> r120 = this.f112095b;
        ValueAnimator r121 = ValueAnimator.ofInt(new int[]{1, 2});
        r121.setRepeatCount(1);
        r121.setRepeatMode(2);
        r121.setInterpolator(new AccelerateDecelerateInterpolator());
        r121.addUpdateListener(new a.b(r117));
        r121.addListener(new a.C1668a(this, r121));
        r120.add(r121);
        r116 = r116 + 1;
        r100 = 0;
        goto L8
    }
}
