package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/InviteGuideEffectView;", "Landroid/view/View;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InviteGuideEffectView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f72352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f72353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f72354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f72355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SweepGradient f72356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f72357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f72358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f72359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f72360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnimatorSet f72361j;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InviteGuideEffectView f72362a;

        public b(InviteGuideEffectView r100) {
            this.f72362a = r100;
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
            InviteGuideEffectView r104 = this.f72362a;
            r104.f72354c = r103;
            r104.invalidate();
            return;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InviteGuideEffectView f72363a;

        public c(InviteGuideEffectView r100) {
            this.f72363a = r100;
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
            this.f72363a.setAlpha(r103);
            return;
        }
    }

    static {
    }

    public InviteGuideEffectView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InviteGuideEffectView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        ValueAnimator r100 = this.f72359h;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
    L5:
        ValueAnimator r101 = this.f72360i;
        if (r101 == null) goto L8;
        r101.removeAllUpdateListeners();
    L8:
        ValueAnimator r102 = this.f72359h;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        ValueAnimator r103 = this.f72360i;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        AnimatorSet r104 = this.f72361j;
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        this.f72359h = null;
        this.f72360i = null;
        this.f72361j = null;
    }

    public final void a() {
        b();
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{this.f72352a, this.f72353b});
        ValueAnimator r101 = null;
        if (r100 == null) goto L5;
        r100.setDuration(1000);
        r100.setRepeatMode(2);
        r100.setRepeatCount(-1);
        r100.addUpdateListener(new b(this));
        Unit r102 = Unit.INSTANCE;
    L6:
        this.f72359h = r100;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r103 == null) goto L9;
        r103.setDuration(1000);
        r103.setRepeatMode(2);
        r103.setRepeatCount(-1);
        r103.addUpdateListener(new c(this));
        Unit r104 = Unit.INSTANCE;
        r101 = r103;
    L9:
        this.f72360i = r101;
        AnimatorSet r105 = new AnimatorSet();
        r105.playTogether(new Animator[]{this.f72359h, this.f72360i});
        r105.setDuration(1000);
        Unit r106 = Unit.INSTANCE;
        this.f72361j = r105;
        r105.start();
        return;
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
        this.f72355d.setStrokeWidth(this.f72354c);
        r100.drawRect(this.f72358g, this.f72355d);
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
        if (this.f72356e != null) goto L5;
        SweepGradient r102 = new SweepGradient(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.f72357f, null);
        this.f72356e = r102;
        this.f72355d.setShader(r102);
    L5:
        RectF r103 = this.f72358g;
        r103.right = 0.0f;
        r103.left = getMeasuredWidth();
        RectF r104 = this.f72358g;
        r104.top = 0.0f;
        r104.bottom = getMeasuredHeight();
    }

    public InviteGuideEffectView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        float r103 = UtilityKotlinExtentionsKt.h(1);
        this.f72352a = r103;
        this.f72353b = UtilityKotlinExtentionsKt.h(10);
        this.f72354c = r103;
        Paint r104 = new Paint();
        this.f72355d = r104;
        this.f72357f = new int[]{ColorProtector.parseColor("#90FFFFFF"), ColorProtector.parseColor("#90FFFFFF"), ColorProtector.parseColor("#90FFFFFF"), ColorProtector.parseColor("#90FFFFFF"), ColorProtector.parseColor("#90FFFFFF")};
        this.f72358g = new RectF();
        r104.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ InviteGuideEffectView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
