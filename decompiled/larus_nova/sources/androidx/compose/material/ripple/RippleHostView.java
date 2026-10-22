package androidx.compose.material.ripple;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0001\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014J0\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016JK\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!¢\u0006\u0004\b/\u00100J\u0006\u00101\u001a\u00020\u0007J-\u00102\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b3\u00104J\u0006\u00105\u001a\u00020\u0007J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\rH\u0002R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshDrawableState", "ripple", "Landroidx/compose/material/ripple/UnprojectedRipple;", "bounded", "Ljava/lang/Boolean;", "lastRippleStateChangeTimeMillis", "", "Ljava/lang/Long;", "resetRippleRunnable", "Ljava/lang/Runnable;", "createRipple", "onInvalidateRipple", "Lkotlin/Function0;", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "addRipple-KOepWvA", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;ZJIJFLkotlin/jvm/functions/Function0;)V", "removeRipple", "setRippleProperties", "setRippleProperties-biQXAtU", "(JIJF)V", "disposeRipple", "setRippleState", "pressed", "Companion", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleHostView extends View {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final long MinimumRippleStateChangeTime = 5;
    private static final int[] PressedState = null;
    private static final long ResetRippleDelayDuration = 50;
    private static final int[] RestingState = null;
    private Boolean bounded;
    private Long lastRippleStateChangeTimeMillis;
    private Function0<Unit> onInvalidateRipple;
    private Runnable resetRippleRunnable;
    private UnprojectedRipple ripple;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView$Companion;", "", "<init>", "()V", "MinimumRippleStateChangeTime", "", "ResetRippleDelayDuration", "PressedState", "", "RestingState", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public static /* synthetic */ void a(RippleHostView r100) {
        setRippleState$lambda$2(r100);
    }

    public final void disposeRipple() {
        this.onInvalidateRipple = null;
        Runnable r100 = this.resetRippleRunnable;
        if (r100 == null) goto L5;
        removeCallbacks(r100);
        Runnable r101 = this.resetRippleRunnable;
        Intrinsics.checkNotNull(r101);
        r101.run();
    L8:
        UnprojectedRipple r102 = this.ripple;
        if (r102 != null) goto L11;
        return;
    L11:
        r102.setVisible(false, false);
        unscheduleDrawable(r102);
        return;
    L5:
        UnprojectedRipple r103 = this.ripple;
        if (r103 == null) goto L8;
        r103.setState(RestingState);
        goto L8
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // android.view.View
    public void refreshDrawableState() {
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        PressedState = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        RestingState = new int[0];
    }

    public RippleHostView(Context r100) {
        super(r100);
    }

    private final void createRipple(boolean r100) {
        UnprojectedRipple r101 = new UnprojectedRipple(r100);
        setBackground(r101);
        this.ripple = r101;
    }

    private final void setRippleState(boolean r100) {
        long r101 = AnimationUtils.currentAnimationTimeMillis();
        Runnable r102 = this.resetRippleRunnable;
        if (r102 == null) goto L5;
        removeCallbacks(r102);
        r102.run();
    L5:
        Long r103 = this.lastRippleStateChangeTimeMillis;
        if (r103 == null) goto L8;
        long r104 = r103.longValue();
    L9:
        long r105 = r101 - r104;
        if (r100 == false) goto L12;
    L14:
        if (r100 == false) goto L16;
        int[] r106 = PressedState;
    L17:
        UnprojectedRipple r107 = this.ripple;
        if (r107 == null) goto L20;
        r107.setState(r106);
    L20:
        this.lastRippleStateChangeTimeMillis = Long.valueOf(r101);
        return;
    L16:
        r106 = RestingState;
        goto L17
    L12:
        if (r105 >= 5) goto L14;
        Runnable r108 = new c(this);
        this.resetRippleRunnable = r108;
        postDelayed(r108, 50);
        goto L20
    L8:
        r104 = 0;
        goto L9
    }

    private static final void setRippleState$lambda$2(RippleHostView r100) {
        UnprojectedRipple r101 = r100.ripple;
        if (r101 == null) goto L5;
        r101.setState(RestingState);
    L5:
        r100.resetRippleRunnable = null;
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        if (isAttachedToWindow() == true) goto L6;
        disposeRipple();
        return;
    L6:
        super.draw(r100);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        Function0<Unit> r101 = this.onInvalidateRipple;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }

    /* JADX INFO: renamed from: setRippleProperties-biQXAtU, reason: not valid java name */
    public final void m1825setRipplePropertiesbiQXAtU(long r100, int r101, long r102, float r103) {
        UnprojectedRipple r104 = this.ripple;
        if (r104 != null) goto L5;
        return;
    L5:
        r104.trySetRadius(r101);
        r104.m1836setColorDxMtmZc(r102, r103);
        Rect r105 = new Rect(0, 0, MathKt.roundToInt(Size.m4651getWidthimpl(r100)), MathKt.roundToInt(Size.m4648getHeightimpl(r100)));
        setLeft(r105.left);
        setTop(r105.top);
        setRight(r105.right);
        setBottom(r105.bottom);
        r104.setBounds(r105);
    }

    /* JADX INFO: renamed from: addRipple-KOepWvA, reason: not valid java name */
    public final void m1824addRippleKOepWvA(PressInteraction.Press r110, boolean r111, long r112, int r113, long r114, float r115, Function0<Unit> r116) {
        if (this.ripple != null) goto L5;
    L6:
        createRipple(r111);
        this.bounded = Boolean.valueOf(r111);
    L7:
        UnprojectedRipple r100 = this.ripple;
        Intrinsics.checkNotNull(r100);
        this.onInvalidateRipple = r116;
        m1825setRipplePropertiesbiQXAtU(r112, r113, r114, r115);
        if (r111 == false) goto L10;
        r100.setHotspot(Offset.m4582getXimpl(r110.m552getPressPositionF1C5BW0()), Offset.m4583getYimpl(r110.m552getPressPositionF1C5BW0()));
    L11:
        setRippleState(true);
        return;
    L10:
        r100.setHotspot(r100.getBounds().centerX(), r100.getBounds().centerY());
        goto L11
    L5:
        if (Intrinsics.areEqual(Boolean.valueOf(r111), this.bounded) == true) goto L7;
        goto L6
    }
}
