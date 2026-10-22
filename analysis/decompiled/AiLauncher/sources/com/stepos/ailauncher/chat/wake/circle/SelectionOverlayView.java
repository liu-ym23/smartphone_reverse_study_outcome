package com.stepos.ailauncher.chat.wake.circle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001ZB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u0014J\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010\u0018J#\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b$\u0010%J!\u0010(\u001a\u0004\u0018\u00010 2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0002¢\u0006\u0004\b(\u0010)J'\u0010-\u001a\u00020\f2\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020#H\u0002¢\u0006\u0004\b-\u0010.R0\u00100\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u00107\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R0\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00101\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\u0014\u0010@\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010HR\u0014\u0010J\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010AR\u0014\u0010K\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010AR\u0014\u0010L\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010AR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010OR\u0014\u0010Q\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010AR\u0018\u0010R\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010ER\u0016\u0010U\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010AR\u0016\u0010V\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010AR\u0016\u0010W\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010CR\u0016\u0010X\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010ER\u0016\u0010Y\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010E¨\u0006["}, d2 = {"Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/RectF;", "rect", "LY8/t;", "setSelectionRect", "(Landroid/graphics/RectF;)V", "", x5.d.EXTRA_ENABLED, "setTouchEnabled", "(Z)V", "onDetachedFromWindow", "()V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", "Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView$HandlePosition;", "hp", "Lkotlin/Pair;", "", "e", "(Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView$HandlePosition;)Lkotlin/Pair;", "x", "y", "f", "(FF)Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView$HandlePosition;", "handle", "dx", "dy", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView$HandlePosition;FF)V", "Lkotlin/Function1;", "onRectChanged", "Lp9/l;", "getOnRectChanged", "()Lp9/l;", "setOnRectChanged", "(Lp9/l;)V", "Lkotlin/Function0;", "onBlankTapped", "Lp9/a;", "getOnBlankTapped", "()Lp9/a;", "setOnBlankTapped", "(Lp9/a;)V", "onDragStateChanged", "getOnDragStateChanged", "setOnDragStateChanged", "density", "F", "selectionRect", "Landroid/graphics/RectF;", "touchEnabled", "Z", "Landroid/graphics/Paint;", "dimPaint", "Landroid/graphics/Paint;", "bracketPaint", "borderRadius", "bracketArmLength", "minRectSize", "Landroid/graphics/Path;", "clipPath", "Landroid/graphics/Path;", "bracketPath", "handleTouchRadiusPx", "activeHandle", "Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView$HandlePosition;", "isDraggingRect", "dragStartX", "dragStartY", "dragStartRect", "hasMoved", "dragActive", "HandlePosition", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectionOverlayView extends View {
    private HandlePosition activeHandle;
    private final float borderRadius;
    private final float bracketArmLength;
    private final Paint bracketPaint;
    private final Path bracketPath;
    private final Path clipPath;
    private final float density;
    private final Paint dimPaint;
    private boolean dragActive;
    private RectF dragStartRect;
    private float dragStartX;
    private float dragStartY;
    private final float handleTouchRadiusPx;
    private boolean hasMoved;
    private boolean isDraggingRect;
    private final float minRectSize;
    private InterfaceC5063a<Y8.t> onBlankTapped;
    private InterfaceC5074l<? super Boolean, Y8.t> onDragStateChanged;
    private InterfaceC5074l<? super RectF, Y8.t> onRectChanged;
    private final RectF selectionRect;
    private boolean touchEnabled;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/circle/SelectionOverlayView$HandlePosition;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class HandlePosition {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ HandlePosition[] $VALUES;
        public static final HandlePosition TOP_LEFT = new HandlePosition("TOP_LEFT", 0);
        public static final HandlePosition TOP_RIGHT = new HandlePosition("TOP_RIGHT", 1);
        public static final HandlePosition BOTTOM_LEFT = new HandlePosition("BOTTOM_LEFT", 2);
        public static final HandlePosition BOTTOM_RIGHT = new HandlePosition("BOTTOM_RIGHT", 3);

        private static final /* synthetic */ HandlePosition[] $values() {
            return new HandlePosition[]{TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT};
        }

        static {
            HandlePosition[] handlePositionArr$values = $values();
            $VALUES = handlePositionArr$values;
            $ENTRIES = kotlin.enums.a.a(handlePositionArr$values);
        }

        private HandlePosition(String str, int i10) {
        }

        public static InterfaceC4149a<HandlePosition> getEntries() {
            return $ENTRIES;
        }

        public static HandlePosition valueOf(String str) {
            return (HandlePosition) Enum.valueOf(HandlePosition.class, str);
        }

        public static HandlePosition[] values() {
            return (HandlePosition[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HandlePosition.values().length];
            try {
                iArr[HandlePosition.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HandlePosition.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HandlePosition.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HandlePosition.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionOverlayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        float f10 = getResources().getDisplayMetrics().density;
        this.density = f10;
        this.selectionRect = new RectF();
        this.touchEnabled = true;
        Paint paint = new Paint();
        paint.setColor(Color.argb(77, 0, 0, 0));
        this.dimPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f10 * 4.0f);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        this.bracketPaint = paint2;
        this.borderRadius = 20.0f * f10;
        this.bracketArmLength = 4.0f * f10;
        this.minRectSize = 60.0f * f10;
        this.clipPath = new Path();
        this.bracketPath = new Path();
        this.handleTouchRadiusPx = f10 * 28.0f;
        this.dragStartRect = new RectF();
    }

    public final void a(HandlePosition handle, float dx, float dy) {
        RectF rectF = this.dragStartRect;
        RectF rectF2 = this.selectionRect;
        float fM = rectF2.left;
        float fM2 = rectF2.top;
        float fM3 = rectF2.right;
        float fM4 = rectF2.bottom;
        float fE = C5685n.e(rectF.right - this.minRectSize, 0.0f);
        float fE2 = C5685n.e(rectF.bottom - this.minRectSize, 0.0f);
        float fI = C5685n.i(rectF.left + this.minRectSize, getWidth());
        float fI2 = C5685n.i(rectF.top + this.minRectSize, getHeight());
        int i10 = a.$EnumSwitchMapping$0[handle.ordinal()];
        if (i10 == 1) {
            fM = C5685n.m(rectF.left + dx, 0.0f, fE);
            fM2 = C5685n.m(rectF.top + dy, 0.0f, fE2);
        } else if (i10 == 2) {
            fM3 = C5685n.m(rectF.right + dx, fI, getWidth());
            fM2 = C5685n.m(rectF.top + dy, 0.0f, fE2);
        } else if (i10 == 3) {
            fM = C5685n.m(rectF.left + dx, 0.0f, fE);
            fM4 = C5685n.m(rectF.bottom + dy, fI2, getHeight());
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            fM3 = C5685n.m(rectF.right + dx, fI, getWidth());
            fM4 = C5685n.m(rectF.bottom + dy, fI2, getHeight());
        }
        this.selectionRect.set(fM, fM2, fM3, fM4);
    }

    public final void b() {
        if (this.dragActive) {
            return;
        }
        this.dragActive = true;
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onDragStateChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.TRUE);
        }
    }

    public final void c(Canvas canvas) {
        RectF rectF = this.selectionRect;
        float f10 = this.borderRadius;
        float f11 = this.bracketArmLength;
        Path path = this.bracketPath;
        path.rewind();
        path.moveTo(rectF.left, rectF.top + f10 + f11);
        path.lineTo(rectF.left, rectF.top + f10);
        float f12 = rectF.left;
        float f13 = rectF.top;
        float f14 = 2 * f10;
        path.arcTo(new RectF(f12, f13, f12 + f14, f13 + f14), 180.0f, 90.0f, false);
        path.lineTo(rectF.left + f10 + f11, rectF.top);
        path.moveTo((rectF.right - f10) - f11, rectF.top);
        path.lineTo(rectF.right - f10, rectF.top);
        float f15 = rectF.right;
        float f16 = rectF.top;
        path.arcTo(new RectF(f15 - f14, f16, f15, f16 + f14), 270.0f, 90.0f, false);
        path.lineTo(rectF.right, rectF.top + f10 + f11);
        path.moveTo(rectF.right, (rectF.bottom - f10) - f11);
        path.lineTo(rectF.right, rectF.bottom - f10);
        float f17 = rectF.right;
        float f18 = rectF.bottom;
        path.arcTo(new RectF(f17 - f14, f18 - f14, f17, f18), 0.0f, 90.0f, false);
        path.lineTo((rectF.right - f10) - f11, rectF.bottom);
        path.moveTo(rectF.left + f10 + f11, rectF.bottom);
        path.lineTo(rectF.left + f10, rectF.bottom);
        float f19 = rectF.left;
        float f20 = rectF.bottom;
        path.arcTo(new RectF(f19, f20 - f14, f14 + f19, f20), 90.0f, 90.0f, false);
        path.lineTo(rectF.left, (rectF.bottom - f10) - f11);
        canvas.drawPath(path, this.bracketPaint);
    }

    public final void d() {
        this.activeHandle = null;
        this.isDraggingRect = false;
        if (this.dragActive) {
            this.dragActive = false;
            InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onDragStateChanged;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.FALSE);
            }
        }
    }

    public final Pair<Float, Float> e(HandlePosition hp) {
        RectF rectF = this.selectionRect;
        int i10 = a.$EnumSwitchMapping$0[hp.ordinal()];
        if (i10 == 1) {
            return Y8.j.a(Float.valueOf(rectF.left), Float.valueOf(rectF.top));
        }
        if (i10 == 2) {
            return Y8.j.a(Float.valueOf(rectF.right), Float.valueOf(rectF.top));
        }
        if (i10 == 3) {
            return Y8.j.a(Float.valueOf(rectF.left), Float.valueOf(rectF.bottom));
        }
        if (i10 == 4) {
            return Y8.j.a(Float.valueOf(rectF.right), Float.valueOf(rectF.bottom));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final HandlePosition f(float x10, float y10) {
        for (HandlePosition handlePosition : HandlePosition.getEntries()) {
            Pair<Float, Float> pairE = e(handlePosition);
            float fFloatValue = x10 - pairE.a().floatValue();
            float fFloatValue2 = y10 - pairE.b().floatValue();
            float f10 = (fFloatValue * fFloatValue) + (fFloatValue2 * fFloatValue2);
            float f11 = this.handleTouchRadiusPx;
            if (f10 <= f11 * f11) {
                return handlePosition;
            }
        }
        return null;
    }

    public final InterfaceC5063a<Y8.t> getOnBlankTapped() {
        return this.onBlankTapped;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnDragStateChanged() {
        return this.onDragStateChanged;
    }

    public final InterfaceC5074l<RectF, Y8.t> getOnRectChanged() {
        return this.onRectChanged;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (this.selectionRect.isEmpty()) {
            return;
        }
        this.clipPath.rewind();
        Path path = this.clipPath;
        RectF rectF = this.selectionRect;
        float f10 = this.borderRadius;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        canvas.save();
        canvas.clipOutPath(this.clipPath);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.dimPaint);
        canvas.restore();
        c(canvas);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        kotlin.jvm.internal.p.i(event, "event");
        if (!this.touchEnabled || this.selectionRect.isEmpty()) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            d();
            this.hasMoved = false;
            HandlePosition handlePositionF = f(event.getX(), event.getY());
            if (handlePositionF != null) {
                this.activeHandle = handlePositionF;
                this.dragStartX = event.getX();
                this.dragStartY = event.getY();
                this.dragStartRect.set(this.selectionRect);
                return true;
            }
            if (!this.selectionRect.contains(event.getX(), event.getY())) {
                this.dragStartX = event.getX();
                this.dragStartY = event.getY();
                return true;
            }
            this.isDraggingRect = true;
            this.dragStartX = event.getX();
            this.dragStartY = event.getY();
            this.dragStartRect.set(this.selectionRect);
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float x10 = event.getX() - this.dragStartX;
                float y10 = event.getY() - this.dragStartY;
                if (!this.hasMoved) {
                    float f10 = 8;
                    if (Math.abs(x10) < this.density * f10 && Math.abs(y10) < f10 * this.density) {
                        return true;
                    }
                }
                this.hasMoved = true;
                HandlePosition handlePosition = this.activeHandle;
                if (handlePosition == null) {
                    if (this.isDraggingRect) {
                        float fE = C5685n.e(getWidth() - this.dragStartRect.width(), 0.0f);
                        float fE2 = C5685n.e(getHeight() - this.dragStartRect.height(), 0.0f);
                        float fM = C5685n.m(this.dragStartRect.left + x10, 0.0f, fE);
                        float fM2 = C5685n.m(this.dragStartRect.top + y10, 0.0f, fE2);
                        RectF rectF = this.selectionRect;
                        if (rectF.left != fM || rectF.top != fM2) {
                            rectF.offsetTo(fM, fM2);
                            b();
                            invalidate();
                        }
                    }
                    return true;
                }
                RectF rectF2 = this.selectionRect;
                float f11 = rectF2.left;
                float f12 = rectF2.top;
                float f13 = rectF2.right;
                float f14 = rectF2.bottom;
                kotlin.jvm.internal.p.f(handlePosition);
                a(handlePosition, x10, y10);
                RectF rectF3 = this.selectionRect;
                if (rectF3.left != f11 || rectF3.top != f12 || rectF3.right != f13 || rectF3.bottom != f14) {
                    b();
                    invalidate();
                }
                return true;
            }
            if (actionMasked != 3) {
                return super.onTouchEvent(event);
            }
        }
        boolean z10 = this.activeHandle != null;
        boolean z11 = this.isDraggingRect;
        d();
        boolean z12 = this.hasMoved;
        if (z12 && (z10 || z11)) {
            InterfaceC5074l<? super RectF, Y8.t> interfaceC5074l = this.onRectChanged;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(new RectF(this.selectionRect));
            }
        } else if (!z12 && f(event.getX(), event.getY()) == null && !this.selectionRect.contains(event.getX(), event.getY()) && (interfaceC5063a = this.onBlankTapped) != null) {
            interfaceC5063a.invoke();
        }
        return true;
    }

    public final void setOnBlankTapped(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onBlankTapped = interfaceC5063a;
    }

    public final void setOnDragStateChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onDragStateChanged = interfaceC5074l;
    }

    public final void setOnRectChanged(InterfaceC5074l<? super RectF, Y8.t> interfaceC5074l) {
        this.onRectChanged = interfaceC5074l;
    }

    public final void setSelectionRect(RectF rect) {
        kotlin.jvm.internal.p.i(rect, "rect");
        this.selectionRect.set(rect);
        invalidate();
    }

    public final void setTouchEnabled(boolean enabled) {
        this.touchEnabled = enabled;
        if (enabled) {
            return;
        }
        d();
    }

    public /* synthetic */ SelectionOverlayView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
