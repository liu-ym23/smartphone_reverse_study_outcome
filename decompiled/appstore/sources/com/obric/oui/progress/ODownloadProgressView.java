package com.obric.oui.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewKt;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public class ODownloadProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f16417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f16419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f16420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ValueAnimator f16425k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16426l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f16427m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f16428n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16429o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f16430p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f16431q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f16432r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f16433s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f16434t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Drawable f16435u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f16436v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Path f16437w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PorterDuffXfermode f16438x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ValueAnimator f16439y;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentState;
        int progress;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public /* synthetic */ SavedState(Parcel r10, a r11) {
            this(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.progress);
            r10.writeInt(this.currentState);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        private SavedState(Parcel r10) {
            super(r10);
            this.progress = r10.readInt();
            this.currentState = r10.readInt();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
        public static final int LARGE = 0;
        public static final int MEDIUM = 1;
        public static final int SMALL = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int EMPTY = 10;
        public static final int FAILED = 5;
        public static final int PAUSED = 1;
        public static final int PROCESSING = 0;
        public static final int RESUMED = 2;
        public static final int RETRY = 3;
        public static final int SUCCEED = 4;
    }

    public class a implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ODownloadProgressView f16440a;

        /* JADX INFO: renamed from: com.obric.oui.progress.ODownloadProgressView$a$a, reason: collision with other inner class name */
        public class C0206a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f16441a;

            public C0206a(a r10) {
                this.f16441a = r10;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator r10) {
                this.f16441a.f16440a.invalidate();
            }
        }

        public a(ODownloadProgressView r10) {
            this.f16440a = r10;
        }

        public Unit a(View r10) {
            if (ODownloadProgressView.a(this.f16440a) == 0) goto L5;
        L13:
            ODownloadProgressView.b(this.f16440a);
            return Unit.f21064a;
        L5:
            if (this.f16440a.isShown() == false) goto L13;
            if (ODownloadProgressView.c(this.f16440a).isRunning() == true) goto L10;
            ODownloadProgressView.b(this.f16440a);
            ODownloadProgressView.c(this.f16440a).setInterpolator(new LinearInterpolator());
            ODownloadProgressView.c(this.f16440a).setDuration(ODownloadProgressView.d(this.f16440a));
            ODownloadProgressView.c(this.f16440a).setFloatValues(new float[]{0.0f, 360.0f});
            ODownloadProgressView.c(this.f16440a).addUpdateListener(new C0206a(this));
            ODownloadProgressView.c(this.f16440a).setRepeatCount(-1);
            ODownloadProgressView.c(this.f16440a).start();
            return Unit.f21064a;
        L10:
            return Unit.f21064a;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r10) {
            return a((View) r10);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ODownloadProgressView f16442a;

        public b(ODownloadProgressView r10) {
            this.f16442a = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            this.f16442a.invalidate();
        }
    }

    public ODownloadProgressView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ int a(ODownloadProgressView r10) {
        return r10.f16415a;
    }

    public static /* synthetic */ void b(ODownloadProgressView r10) {
        r10.f();
    }

    public static /* synthetic */ ValueAnimator c(ODownloadProgressView r10) {
        return r10.f16439y;
    }

    public static /* synthetic */ int d(ODownloadProgressView r10) {
        return r10.f16428n;
    }

    private Drawable getCurrentStateDrawable() {
        return i(this.f16415a);
    }

    private Drawable getLastStateDrawable() {
        return i(this.f16416b);
    }

    public final void e() {
        if (j() == false) goto L5;
        this.f16419e.cancel();
    L5:
        this.f16418d = PrivateKeyType.INVALID;
    }

    public final void f() {
        this.f16439y.removeAllUpdateListeners();
        this.f16439y.cancel();
    }

    public final void g() {
        this.f16425k.removeAllUpdateListeners();
        this.f16425k.cancel();
    }

    public int getCurrentState() {
        return this.f16415a;
    }

    public Drawable getDownloadDrawable() {
        return this.f16432r;
    }

    public Drawable getFailedDrawable() {
        return this.f16436v;
    }

    public int getLastState() {
        return this.f16416b;
    }

    public Drawable getPauseDrawable() {
        return this.f16433s;
    }

    public Drawable getProcessingDrawable() {
        return this.f16430p;
    }

    public int getProgress() {
        return this.f16424j;
    }

    public Drawable getProgressBgDrawable() {
        return this.f16431q;
    }

    public Drawable getRetryDrawable() {
        return this.f16434t;
    }

    public Drawable getSucceedDrawable() {
        return this.f16435u;
    }

    public final int h(float r10) {
        return (int) (r10 * Resources.getSystem().getDisplayMetrics().density);
    }

    public final Drawable i(int r10) {
        if (r10 == 0) goto L20;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L24;
        if (r10 == 4) goto L23;
        if (r10 == 5) goto L22;
        return null;
    L22:
        return this.f16436v;
    L23:
        return this.f16435u;
    L24:
        return this.f16434t;
    L25:
        return this.f16433s;
    L26:
        return this.f16432r;
    L20:
        return this.f16430p;
    }

    public final boolean j() {
        ValueAnimator r10 = this.f16419e;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isRunning() == false) goto L7;
        return true;
    }

    public final boolean k(int r10) {
        if (r10 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r10 == 4) goto L9;
        if (r10 == 5) goto L9;
        return false;
    }

    public void l(int r10, boolean r11) {
        if (this.f16424j != r10) goto L5;
        return;
    L5:
        this.f16425k.cancel();
        int r12 = this.f16424j;
        int r13 = Math.max(Math.min(r10, 100), 0);
        this.f16424j = r13;
        if (r12 > r13) goto L11;
        if (r11 == false) goto L11;
        this.f16425k.setInterpolator(new LinearInterpolator());
        this.f16425k.setDuration((((long) Math.abs(this.f16424j - r12)) * ((long) this.f16429o)) / 100);
        this.f16425k.setFloatValues(new float[]{r12, this.f16424j});
        this.f16425k.addUpdateListener(new b(this));
        this.f16425k.start();
        return;
    L11:
        invalidate();
    }

    public final void m() {
        if (this.f16415a == 0) goto L6;
        f();
        return;
    L6:
        ViewKt.b(this, new a(this));
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        e();
        g();
        f();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas r12) {
        super.onDraw(r12);
        if (this.f16417c != null) goto L5;
        this.f16417c = new Paint();
    L5:
        this.f16417c.reset();
        this.f16417c.setAntiAlias(true);
        int r10 = this.f16421g;
        int r11 = r10 / 2;
        int r13 = r10 / 2;
        r12.save();
        Drawable r14 = getLastStateDrawable();
        if (r14 != null) goto L8;
    L14:
        Drawable r15 = getCurrentStateDrawable();
        if (r15 != null) goto L17;
    L31:
        r12.restore();
        if (this.f16425k.isRunning() == true) goto L34;
    L37:
        float r16 = this.f16424j;
    L36:
        float r17 = (r16 * 360.0f) / 100.0f;
        r12.save();
        if (r17 < 360.0f) goto L41;
        this.f16431q.setColorFilter(this.f16426l, PorterDuff.Mode.SRC_IN);
        this.f16431q.draw(r12);
    L42:
        r12.restore();
        return;
    L41:
        Drawable r18 = this.f16431q;
        int r19 = this.f16427m;
        PorterDuff.Mode r20 = PorterDuff.Mode.SRC_IN;
        r18.setColorFilter(r19, r20);
        this.f16431q.draw(r12);
        this.f16437w.reset();
        this.f16437w.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        this.f16437w.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r17, false);
        r12.save();
        r12.clipPath(this.f16437w);
        this.f16431q.setColorFilter(this.f16426l, r20);
        this.f16431q.draw(r12);
        r12.restore();
        goto L42
    L34:
        if (this.f16425k.getAnimatedValue() == null) goto L37;
        r16 = ((Float) this.f16425k.getAnimatedValue()).floatValue();
        goto L36
    L17:
        if (k(this.f16415a) == false) goto L19;
        int r21 = this.f16421g;
        r15.setBounds(0, 0, r21, r21);
    L21:
        if (this.f16415a == 0) goto L23;
    L27:
        r15.setAlpha(this.f16418d);
        r15.draw(r12);
        if (k(this.f16415a) == false) goto L31;
        invalidate();
        return;
    L23:
        if (this.f16439y.isRunning() == false) goto L27;
        if (this.f16439y.getAnimatedValue() == null) goto L27;
        r12.save();
        Drawable r22 = this.f16431q;
        r22.setBounds(r15.getBounds());
        r22.setColorFilter(this.f16427m, PorterDuff.Mode.SRC_IN);
        r22.draw(r12);
        r12.restore();
        r12.rotate(((Float) this.f16439y.getAnimatedValue()).floatValue(), r11, r13);
        goto L27
    L19:
        int r23 = this.f16421g;
        int r24 = this.f16423i;
        r15.setBounds((r23 - r24) / 2, (r23 - r24) / 2, (r23 + r24) / 2, (r23 + r24) / 2);
        goto L21
    L8:
        if (this.f16418d == 255) goto L14;
        if (k(this.f16416b) == false) goto L12;
        int r25 = this.f16421g;
        r14.setBounds(0, 0, r25, r25);
    L13:
        r14.setAlpha(PrivateKeyType.INVALID - this.f16418d);
        r14.draw(r12);
        goto L14
    L12:
        int r26 = Math.min(r14.getIntrinsicWidth(), this.f16423i);
        int r27 = Math.min(r14.getIntrinsicHeight(), this.f16423i);
        int r28 = this.f16421g;
        r14.setBounds((r28 - r26) / 2, (r28 - r27) / 2, (r26 + r28) / 2, (r28 + r27) / 2);
        goto L13
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        if (r12 == Integer.MIN_VALUE) goto L7;
        if (r13 <= 0) goto L7;
        this.f16421g = r13;
    L8:
        int r14 = this.f16421g;
        setMeasuredDimension(r14, r14);
        return;
    L7:
        this.f16421g = this.f16422h;
        goto L8
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setCurrentState(r11.currentState);
        setProgress(r11.progress);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.progress = this.f16424j;
        r10.currentState = this.f16415a;
        return r10;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
        if (r11 != 0) goto L5;
        m();
        return;
    L5:
        f();
    }

    public void setActionColor(int r10) {
        this.f16432r = this.f16432r.mutate();
        this.f16433s = this.f16433s.mutate();
        this.f16434t = this.f16434t.mutate();
        o.a.h(this.f16432r, r10);
        o.a.h(this.f16433s, r10);
        o.a.h(this.f16434t, r10);
    }

    public void setAlphaAnimationDuration(long r10) {
        this.f16420f = r10;
    }

    public void setCurrentState(int r10) {
        int r11 = this.f16415a;
        if (r11 != r10) goto L5;
        return;
    L5:
        this.f16416b = r11;
        this.f16415a = r10;
        invalidate();
        m();
    }

    public void setDownloadDrawable(Drawable r10) {
        this.f16432r = r10;
    }

    public void setFailedDrawable(Drawable r10) {
        this.f16436v = r10;
    }

    public void setPauseDrawable(Drawable r10) {
        this.f16433s = r10;
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        super.setPressed(r10);
        invalidate();
    }

    public void setProcessingColor(int r10) {
        Drawable r11 = this.f16430p.mutate();
        this.f16430p = r11;
        o.a.h(r11, r10);
    }

    public void setProcessingDrawable(Drawable r10) {
        this.f16430p = r10;
    }

    public void setProcessingDuration(int r10) {
        this.f16428n = r10;
    }

    public void setProgress(int r10) {
        l(r10, false);
    }

    public void setProgressBackgroundColor(int r10) {
        this.f16427m = r10;
    }

    public void setProgressBgDrawable(Drawable r10) {
        this.f16431q = r10;
    }

    public void setProgressColor(int r10) {
        this.f16426l = r10;
    }

    public void setProgressDuration(int r10) {
        this.f16429o = r10;
    }

    public void setRetryDrawable(Drawable r10) {
        this.f16434t = r10;
    }

    public void setSize(int r10) {
        if (r10 != 0) goto L5;
        this.f16422h = h(48.0f);
        this.f16423i = h(24.0f);
    L9:
        Drawable r11 = this.f16431q;
        int r12 = this.f16422h;
        r11.setBounds(0, 0, r12, r12);
        invalidate();
        return;
    L5:
        if (r10 == 2) goto L7;
        this.f16422h = h(36.0f);
        this.f16423i = h(16.0f);
        goto L9
    L7:
        this.f16422h = h(24.0f);
        this.f16423i = h(12.0f);
        goto L9
    }

    public void setSucceedDrawable(Drawable r10) {
        this.f16435u = r10;
    }

    public ODownloadProgressView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ODownloadProgressView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public ODownloadProgressView(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.f16415a = 0;
        this.f16416b = 0;
        this.f16418d = PrivateKeyType.INVALID;
        this.f16420f = 300;
        this.f16425k = new ValueAnimator();
        this.f16428n = 1200;
        this.f16429o = 2000;
        this.f16437w = new Path();
        this.f16438x = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f16439y = new ValueAnimator();
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.ODownloadProgressView, r12, r13);
        int r15 = r14.getInt(R$styleable.ODownloadProgressView_oui_progress_view_size, 1);
        this.f16424j = r14.getInt(R$styleable.ODownloadProgressView_oui_progress, 0);
        int r16 = R$styleable.ODownloadProgressView_oui_progress_color;
        int r17 = R$color.oui_accent_6_bg;
        this.f16426l = r14.getColor(r16, ContextCompat.b(r10, r17));
        this.f16427m = r14.getColor(R$styleable.ODownloadProgressView_oui_progress_background_color, ContextCompat.b(r10, R$color.oui_basic_line_2));
        int r18 = r14.getColor(R$styleable.ODownloadProgressView_oui_progressing_action_color, ContextCompat.b(r10, r17));
        int r19 = r14.getColor(R$styleable.ODownloadProgressView_oui_download_action_color, ContextCompat.b(r10, r17));
        r14.recycle();
        this.f16430p = androidx.core.content.res.a.f(getResources(), R$drawable.o_ic_progress_processing, null);
        this.f16431q = androidx.core.content.res.a.f(getResources(), R$drawable.o_ic_download_progress_bg, null);
        this.f16432r = androidx.core.content.res.a.f(getResources(), R$drawable.o_ic_arrow_down_download, null);
        this.f16433s = androidx.core.content.res.a.f(getResources(), R$drawable.o_ic_pause_download, null);
        this.f16434t = androidx.core.content.res.a.f(getResources(), R$drawable.o_ic_download_retry, null);
        if (r18 == 0) goto L5;
        setProcessingColor(r18);
    L5:
        if (r19 == 0) goto L7;
        setActionColor(r19);
    L7:
        this.f16435u = androidx.core.content.res.a.f(getResources(), R$drawable.o_ic_download_succeed, null);
        this.f16436v = androidx.core.content.res.a.f(getResources(), R$drawable.o_ic_download_failed, null);
        setSize(r15);
        m();
    }
}
