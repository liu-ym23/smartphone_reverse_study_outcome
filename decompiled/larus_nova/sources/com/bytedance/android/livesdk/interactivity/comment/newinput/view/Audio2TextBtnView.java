package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView$c;", "d", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView$c;", "getListener", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView$c;", "setListener", "(Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView$c;)V", "listener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Audio2TextBtnView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f136027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f136028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f136029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f136030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f136031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f136032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f136033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f136034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f136035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ValueAnimator f136036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f136037k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f136038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Audio2TextBtnView f136039b;

        public a(ValueAnimator r100, Audio2TextBtnView r101) {
            this.f136038a = r100;
            this.f136039b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Audio2TextBtnView r101 = this.f136039b;
            Object r102 = this.f136038a.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.f136035i = ((Integer) r102).intValue();
            this.f136039b.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b {
    }

    public interface c {
        void a();

        void b(MotionEvent r100);

        void c();
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Audio2TextBtnView f136040a;

        public d(Audio2TextBtnView r100) {
            this.f136040a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Audio2TextBtnView r100 = this.f136040a;     // Catch: Throwable -> L12
            r100.f136031e = 1;     // Catch: Throwable -> L12
            Drawable r101 = r100.f136034h;     // Catch: Throwable -> L12
            if (r101 == null) goto L5;
            float r102 = r100.f136028b;     // Catch: Throwable -> L12
            float r103 = r100.f136027a;     // Catch: Throwable -> L12
            int r104 = (int) (r102 - r103);     // Catch: Throwable -> L12
            int r105 = ((int) (r103 * 2)) + r104;     // Catch: Throwable -> L12
            r101.setBounds(r104, r104, r105, r105);     // Catch: Throwable -> L12
        L5:
            ValueAnimator r106 = r100.f136036j;     // Catch: Throwable -> L12
            if (r106 == null) goto L8;
            r106.start();     // Catch: Throwable -> L12
        L8:
            c r107 = this.f136040a.getListener();     // Catch: Throwable -> L12
            if (r107 == null) goto L15;
            r107.c();     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    static {
    }

    public final void a() {
        this.f136031e = 2;
        ValueAnimator r100 = this.f136036j;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f136035i = (int) this.f136027a;
        invalidate();
    }

    public final c getListener() {
        return this.f136030d;
    }

    public Audio2TextBtnView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = r100.getWidth() / 2;
        if (this.f136031e == 2) goto L5;
        r100.drawCircle(r101, r101, this.f136035i, this.f136032f);
        r100.drawCircle(r101, r101, this.f136028b, this.f136033g);
    L5:
        Drawable r102 = this.f136034h;
        if (r102 == null) goto L9;
        r102.draw(r100);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L6:
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L18:
        if (r101 != null) goto L21;
    L23:
        if (r101 != null) goto L26;
    L30:
        return true;
    L26:
        if (r101.intValue() != 3) goto L30;
        MainThreadPostUtils.d(this.f136037k);
        a();
        c r102 = this.f136030d;
        if (r102 == null) goto L30;
        r102.a();
        goto L30
    L21:
        if (r101.intValue() != 2) goto L23;
    L14:
        if (r101.intValue() != 1) goto L18;
        MainThreadPostUtils.d(this.f136037k);
        a();
        c r103 = this.f136030d;
        if (r103 == null) goto L30;
        r103.b(r100);
        goto L30
    L9:
        if (r101.intValue() != 0) goto L11;
        MainThreadPostUtils.d(this.f136037k);
        MainThreadPostUtils.c(this.f136037k, this.f136029c);
        goto L30
    L4:
        r101 = null;
        goto L6
    }

    public final void setListener(c r100) {
        this.f136030d = r100;
    }

    public Audio2TextBtnView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public Audio2TextBtnView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f136027a = 60.0f;
        this.f136028b = 79.0f;
        this.f136029c = 200;
        this.f136031e = 2;
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.FILL);
        r103.setColor(s1.h(R.color.ttlive_record_audio2text_btn_bg_color));
        Unit r104 = Unit.INSTANCE;
        this.f136032f = r103;
        Paint r105 = new Paint();
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeWidth(UtilityKotlinExtentionsKt.i(1));
        r105.setColor(s1.h(R.color.ttlive_record_audio2text_btn_bg_color));
        this.f136033g = r105;
        Drawable r106 = s1.m(R.drawable.ttlive_input_v3_audio2text_button);
        if (r106 == null) goto L5;
        int r107 = (int) (79.0f - 60.0f);
        int r108 = ((int) (2 * 60.0f)) + r107;
        r106.setBounds(r107, r107, r108, r108);
    L6:
        this.f136034h = r106;
        this.f136035i = (int) 60.0f;
        this.f136037k = new d(this);
        TypedArray r109 = r100.obtainStyledAttributes(r101, new int[]{R.attr.inner_radius, R.attr.outter_radius});
        if (r109 == null) goto L13;
        float r110 = r109.getDimension(0, 0.0f);
        this.f136027a = r110;
        float r111 = r109.getDimension(1, 0.0f);
        this.f136028b = r111;
        if (r106 == null) goto L11;
        int r112 = (int) (r111 - r110);
        int r113 = ((int) (2 * r110)) + r112;
        r106.setBounds(r112, r112, r113, r113);
    L11:
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{(int) r110, (int) r111});
        r114.setDuration(500);
        r114.setRepeatCount(-1);
        r114.setRepeatMode(2);
        r114.setInterpolator(new LinearInterpolator());
        r114.addUpdateListener(new a(r114, this));
        this.f136036j = r114;
        r109.recycle();
        return;
    L13:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
