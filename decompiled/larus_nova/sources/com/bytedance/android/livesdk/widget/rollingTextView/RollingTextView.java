package com.bytedance.android.livesdk.widget.rollingTextView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u000b¢\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010$\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010(\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/widget/rollingTextView/RollingTextView;", "Landroid/view/View;", "", "text", "", "setText", "getText", "", "textSize", "setTextSize", "getTextSize", "", "getBaseline", "", RXScreenCaptureService.KEY_INDEX, "J", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "animationDuration", "Landroid/view/animation/Interpolator;", ce.f26395j, "Landroid/view/animation/Interpolator;", "getAnimationInterpolator", "()Landroid/view/animation/Interpolator;", "setAnimationInterpolator", "(Landroid/view/animation/Interpolator;)V", "animationInterpolator", "color", ce.f26396k, "I", "getTextColor", "()I", "setTextColor", "(I)V", "textColor", "", "getCurrentText", "()[C", "currentText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RollingTextView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f162014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f162015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f162016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pv2.b f162017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ValueAnimator f162018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f162019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f162020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f162021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f162022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Interpolator f162023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f162024k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RollingTextView f162025a;

        public a(RollingTextView r100) {
            this.f162025a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            pv2.b r101 = this.f162025a.f162017d;
            float r102 = r100.getAnimatedFraction();
            Iterator r103 = ((ArrayList) r101.f530806b).iterator();
        L4:
            if (r103.hasNext() == false) goto L13;
            pv2.a r104 = (pv2.a) r103.next();
            if (r104.f530798c == r104.f530797b) goto L4;
            r104.f530801f = ((double) ((r104.f530802g.f530807c * r102) * r104.f530804i.getValue())) + (r104.f530800e * (1.0d - ((double) r102)));
            if (r104.f530798c <= 0) goto L11;
            float r105 = r104.f530799d;
            float r106 = r104.f530796a;
            float r107 = ((r105 - r106) * r102) + r106;
        L12:
            r104.f530796a = r107;
            goto L4
        L11:
            r107 = 0.0f;
            goto L12
        L13:
            this.f162025a.requestLayout();
            this.f162025a.invalidate();
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RollingTextView f162026a;

        public b(RollingTextView r100) {
            this.f162026a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f162026a.f162017d.c();
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f162027a;

        public c(ValueAnimator r100) {
            this.f162027a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f162027a.start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public RollingTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RollingTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public int getBaseline() {
        Paint.FontMetrics r100 = this.f162016c.getFontMetrics();
        float r101 = 2;
        float r102 = this.f162017d.f530807c / r101;
        float r103 = r100.descent;
        return (int) (r102 + (((r103 - r100.ascent) / r101) - r103));
    }

    public final char[] getCurrentText() {
        return this.f162017d.a();
    }

    public final float getTextSize() {
        return this.f162016c.getTextSize();
    }

    public final long getAnimationDuration() {
        return this.f162022i;
    }

    public final Interpolator getAnimationInterpolator() {
        return this.f162023j;
    }

    public final CharSequence getText() {
        return this.f162021h;
    }

    public final int getTextColor() {
        return this.f162024k;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        r210.save();
        float r100 = this.f162017d.b();
        float r101 = this.f162017d.f530807c;
        int r102 = this.f162019f.width();
        int r103 = this.f162019f.height();
        int r104 = this.f162020g;
        if ((r104 & 16) != 16) goto L5;
        float r105 = this.f162019f.top + ((r103 - r101) / 2.0f);
    L7:
        if ((r104 & 1) != 1) goto L9;
        float r106 = this.f162019f.left + ((r102 - r100) / 2.0f);
    L11:
        if ((r104 & 48) != 48) goto L14;
        r105 = this.f162019f.top;
    L14:
        if ((r104 & 80) != 80) goto L17;
        r105 = this.f162019f.top + (r103 - r101);
    L17:
        if ((r104 & GravityCompat.START) != 8388611) goto L20;
        r106 = this.f162019f.left;
    L20:
        if ((r104 & GravityCompat.END) != 8388613) goto L22;
        r106 = this.f162019f.left + (r102 - r100);
    L22:
        r210.translate(r106, r105);
        r210.clipRect(0.0f, 0.0f, r100, r101);
        r210.translate(0.0f, this.f162017d.f530808d);
        pv2.b r107 = this.f162017d;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Iterator r110 = ((ArrayList) r107.f530806b).iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        pv2.a r111 = (pv2.a) r110.next();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r210, "canvas");
        int r112 = r210.save();
        Rect r108 = r210.getClipBounds();
        r210.clipRect(0, r108.top, (int) r111.f530796a, r108.bottom);
        r210.drawText(new char[]{r111.f530798c}, 0, 1, 0.0f, ((float) r111.f530801f) - (r111.f530802g.f530807c * r111.f530804i.getValue()), r111.f530803h);
        r210.drawText(new char[]{r111.f530797b}, 0, 1, 0.0f, (float) r111.f530801f, r111.f530803h);
        r210.restoreToCount(r112);
        r210.translate(r111.f530796a, 0.0f);
        goto L24
    L26:
        r210.restore();
        return;
    L9:
        r106 = 0.0f;
        goto L11
    L5:
        r105 = 0.0f;
        goto L7
    }

    public final void setAnimationDuration(long r100) {
        this.f162022i = r100;
    }

    public final void setAnimationInterpolator(Interpolator r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f162023j = r100;
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        a(r100, !TextUtils.isEmpty(this.f162021h));
    }

    public final void setTextColor(int r100) {
        if (this.f162024k == r100) goto L6;
        this.f162024k = r100;
        this.f162016c.setColor(r100);
        invalidate();
        return;
    }

    public final void setTextSize(float r100) {
        b(2, r100);
    }

    public final void a(CharSequence r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f162021h = r100;
        if (r101 == false) goto L8;
        this.f162017d.d(r100);
        ValueAnimator r102 = this.f162018e;
        if (r102.isRunning() == false) goto L7;
        r102.cancel();
    L7:
        r102.setDuration(this.f162022i);
        r102.setInterpolator(this.f162023j);
        post(new c(r102));
        return;
    L8:
        this.f162017d.d(r100);
        this.f162017d.c();
        requestLayout();
        invalidate();
    }

    public final void b(int r100, float r101) {
        Context r102 = getContext();
        if (r102 == null) goto L6;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L6;
    L7:
        this.f162016c.setTextSize(TypedValue.applyDimension(r100, r101, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        this.f162017d.e();
        requestLayout();
        invalidate();
        return;
    L6:
        r103 = Resources.getSystem();
        goto L7
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        this.f162014a = (((int) this.f162017d.b()) + getPaddingLeft()) + getPaddingRight();
        this.f162015b = (((int) this.f162017d.f530807c) + getPaddingTop()) + getPaddingBottom();
        setMeasuredDimension(View.resolveSize(this.f162014a, r100), View.resolveSize(this.f162015b, r101));
    }

    public RollingTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f162016c = r103;
        this.f162017d = new pv2.b(r103);
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{1.0f});
        this.f162018e = r104;
        this.f162019f = new Rect();
        this.f162020g = GravityCompat.END;
        this.f162021h = "";
        this.f162022i = 750;
        r104.addUpdateListener(new a(this));
        r104.addListener(new b(this));
        this.f162023j = new LinearInterpolator();
        this.f162024k = -16777216;
    }

    public /* synthetic */ RollingTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f162019f.set(getPaddingLeft(), getPaddingTop(), r100 - getPaddingRight(), r101 - getPaddingBottom());
    }
}
