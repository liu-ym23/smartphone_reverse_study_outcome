package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.animation.ValueAnimator;
import android.content.Context;
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
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView$c;", "getListener", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView$c;", "setListener", "(Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView$c;)V", "listener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioRecordBtnView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f136042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f136043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f136044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f136045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f136046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f136047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f136048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f136049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f136050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ValueAnimator f136051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f136052k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f136053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioRecordBtnView f136054b;

        public a(ValueAnimator r100, AudioRecordBtnView r101) {
            this.f136053a = r100;
            this.f136054b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            AudioRecordBtnView r101 = this.f136054b;
            Object r102 = this.f136053a.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.f136050i = ((Integer) r102).intValue();
            this.f136054b.invalidate();
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

        void d(boolean r100);
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioRecordBtnView f136055a;

        public d(AudioRecordBtnView r100) {
            this.f136055a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AudioRecordBtnView r100 = this.f136055a;     // Catch: Throwable -> L6
            r100.f136046e = 1;     // Catch: Throwable -> L6
            r100.f136051j.start();     // Catch: Throwable -> L6
            c r101 = this.f136055a.getListener();     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.c();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public AudioRecordBtnView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AudioRecordBtnView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f136046e = 2;
        this.f136051j.cancel();
        this.f136050i = s1.f(60.0f);
        invalidate();
    }

    public final c getListener() {
        return this.f136042a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = r100.getWidth() / 2;
        if (this.f136046e == 2) goto L5;
        r100.drawCircle(r101, r101, this.f136050i, this.f136047f);
        r100.drawCircle(r101, r101, (int) UtilityKotlinExtentionsKt.h(79.0f), this.f136048g);
    L5:
        Drawable r102 = this.f136049h;
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
    L42:
        if (r101 != null) goto L45;
    L49:
        return true;
    L45:
        if (r101.intValue() != 3) goto L49;
        MainThreadPostUtils.d(this.f136052k);
        this.f136043b = true;
        a();
        c r102 = this.f136042a;
        if (r102 == null) goto L49;
        r102.a();
        goto L49
    L21:
        if (r101.intValue() != 2) goto L42;
        int[] r103 = new int[2];
        getLocationOnScreen(r103);
        int r104 = r103[0];
        int r105 = r103[1];
        if (r100.getRawX() >= r104) goto L25;
    L31:
        boolean r106 = false;
    L33:
        if (r106 == this.f136043b) goto L49;
        this.f136043b = r106;
        if (r106 == false) goto L39;
        c r107 = this.f136042a;
        if (r107 == null) goto L49;
        r107.d(false);
        goto L49
    L39:
        c r108 = this.f136042a;
        if (r108 == null) goto L49;
        r108.d(true);
        goto L49
    L25:
        if (r100.getRawX() > (r104 + getWidth())) goto L31;
        if (r100.getRawY() < (r105 - this.f136044c)) goto L31;
        if (r100.getRawY() > ((r105 + getHeight()) + this.f136044c)) goto L31;
        r106 = true;
        goto L33
    L14:
        if (r101.intValue() != 1) goto L18;
        MainThreadPostUtils.d(this.f136052k);
        a();
        c r109 = this.f136042a;
        if (r109 == null) goto L49;
        r109.b(r100);
        goto L49
    L9:
        if (r101.intValue() != 0) goto L11;
        MainThreadPostUtils.d(this.f136052k);
        MainThreadPostUtils.c(this.f136052k, this.f136045d);
        goto L49
    L4:
        r101 = null;
        goto L6
    }

    public final void setListener(c r100) {
        this.f136042a = r100;
    }

    public AudioRecordBtnView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f136043b = true;
        this.f136044c = 50;
        this.f136045d = 200;
        this.f136046e = 2;
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.FILL);
        r103.setColor(s1.h(R.color.ttlive_record_audio_btn_bg_color));
        Unit r104 = Unit.INSTANCE;
        this.f136047f = r103;
        Paint r105 = new Paint();
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeWidth(UtilityKotlinExtentionsKt.i(1));
        r105.setColor(s1.h(R.color.ttlive_record_audio_btn_bg_color));
        this.f136048g = r105;
        Drawable r106 = s1.m(R.drawable.ttlive_input_v3_audio_button);
        if (r106 == null) goto L5;
        int r107 = s1.f(19.0f);
        int r108 = s1.f(120.0f) + r107;
        r106.setBounds(r107, r107, r108, r108);
    L6:
        this.f136049h = r106;
        this.f136050i = s1.f(60.0f);
        ValueAnimator r109 = ValueAnimator.ofInt(new int[]{s1.f(60.0f), s1.f(79.0f)});
        r109.setDuration(500);
        r109.setRepeatCount(-1);
        r109.setRepeatMode(2);
        r109.setInterpolator(new LinearInterpolator());
        r109.addUpdateListener(new a(r109, this));
        this.f136051j = r109;
        this.f136052k = new d(this);
        return;
    L5:
        r106 = null;
        goto L6
    }

    public /* synthetic */ AudioRecordBtnView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
