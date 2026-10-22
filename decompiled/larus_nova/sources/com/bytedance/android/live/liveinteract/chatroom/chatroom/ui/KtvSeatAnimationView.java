package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.ktv.IKtvSeatAnimationView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/KtvSeatAnimationView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdkapi/ktv/IKtvSeatAnimationView;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvSeatAnimationView extends View implements IKtvSeatAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f72364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f72365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f72366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f72367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f72368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SweepGradient f72369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f72370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f72371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f72372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f72373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ValueAnimator f72374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f72375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AnimatorSet f72376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f72377n;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvSeatAnimationView f72378a;

        public a(KtvSeatAnimationView r100) {
            this.f72378a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L9;
            float r103 = r102.floatValue();
            KtvSeatAnimationView r104 = this.f72378a;
            r104.f72366c = r103;
            r104.invalidate();
            return;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvSeatAnimationView f72379a;

        public b(KtvSeatAnimationView r100) {
            this.f72379a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L9;
            float r103 = r102.floatValue();
            KtvSeatAnimationView r104 = this.f72379a;
            r104.f72367d = r103;
            r104.invalidate();
            return;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvSeatAnimationView f72380a;

        public c(KtvSeatAnimationView r100) {
            this.f72380a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L9;
            float r103 = r102.floatValue();
            this.f72380a.setAlpha(r103);
            return;
        }
    }

    public KtvSeatAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvSeatAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        ValueAnimator r100 = this.f72373j;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
    L5:
        ValueAnimator r101 = this.f72374k;
        if (r101 == null) goto L8;
        r101.removeAllUpdateListeners();
    L8:
        ValueAnimator r102 = this.f72375l;
        if (r102 == null) goto L11;
        r102.removeAllUpdateListeners();
    L11:
        ValueAnimator r103 = this.f72373j;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        ValueAnimator r104 = this.f72374k;
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        ValueAnimator r105 = this.f72375l;
        if (r105 == null) goto L20;
        r105.cancel();
    L20:
        AnimatorSet r106 = this.f72376m;
        if (r106 == null) goto L23;
        r106.cancel();
    L23:
        this.f72373j = null;
        this.f72374k = null;
        this.f72375l = null;
        this.f72376m = null;
    }

    public final void a() {
        b();
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{this.f72364a, this.f72365b});
        ValueAnimator r101 = null;
        if (r100 == null) goto L5;
        r100.setDuration(this.f72372i);
        r100.setRepeatMode(2);
        r100.setRepeatCount(-1);
        r100.addUpdateListener(new a(this));
        Unit r102 = Unit.INSTANCE;
    L6:
        this.f72373j = r100;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        if (r103 == null) goto L9;
        r103.setDuration(this.f72372i);
        r103.setRepeatMode(1);
        r103.setRepeatCount(-1);
        r103.addUpdateListener(new b(this));
        Unit r104 = Unit.INSTANCE;
    L10:
        this.f72374k = r103;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r105 == null) goto L13;
        r105.setDuration(this.f72372i);
        r105.setRepeatMode(2);
        r105.setRepeatCount(-1);
        r105.addUpdateListener(new c(this));
        Unit r106 = Unit.INSTANCE;
        r101 = r105;
    L13:
        this.f72375l = r101;
        AnimatorSet r107 = new AnimatorSet();
        r107.playTogether(new Animator[]{this.f72373j, this.f72374k, this.f72375l});
        r107.setDuration(this.f72372i);
        Unit r108 = Unit.INSTANCE;
        this.f72376m = r107;
        r107.start();
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r100 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L6;
        a();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f72368e.setStrokeWidth(this.f72366c);
        this.f72377n.setRotate(this.f72367d, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        SweepGradient r101 = this.f72369f;
        if (r101 == null) goto L5;
        r101.setLocalMatrix(this.f72377n);
    L5:
        r100.drawRect(this.f72371h, this.f72368e);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        a();
        return;
    L5:
        b();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f72369f != null) goto L5;
        SweepGradient r102 = new SweepGradient(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.f72370g, null);
        this.f72369f = r102;
        this.f72368e.setShader(r102);
    L5:
        RectF r103 = this.f72371h;
        r103.right = 0.0f;
        r103.left = getMeasuredWidth();
        RectF r104 = this.f72371h;
        r104.top = 0.0f;
        r104.bottom = getMeasuredHeight();
    }

    public KtvSeatAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        float r103 = UtilityKotlinExtentionsKt.h(1);
        this.f72364a = r103;
        this.f72365b = UtilityKotlinExtentionsKt.h(3);
        this.f72366c = r103;
        Paint r104 = new Paint();
        this.f72368e = r104;
        this.f72370g = new int[]{ColorProtector.parseColor("#63E5FF"), ColorProtector.parseColor("#A2BDFF"), ColorProtector.parseColor("#FF72C8"), ColorProtector.parseColor("#A2BDFF"), ColorProtector.parseColor("#63E5FF")};
        this.f72371h = new RectF();
        this.f72372i = 1000;
        this.f72377n = new Matrix();
        r104.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ KtvSeatAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
