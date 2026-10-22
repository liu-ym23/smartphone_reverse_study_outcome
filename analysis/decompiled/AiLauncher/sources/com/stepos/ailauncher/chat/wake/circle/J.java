package com.stepos.ailauncher.chat.wake.circle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RecordingCanvas;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 q2\u00020\u0001:\u0001rB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ'\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010!J/\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0017¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\rH\u0014¢\u0006\u0004\b/\u0010!R0\u00102\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\r\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u00109\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R*\u0010?\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010:\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R0\u0010B\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00103\u001a\u0004\bC\u00105\"\u0004\bD\u00107R*\u0010E\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010:\u001a\u0004\bF\u0010<\"\u0004\bG\u0010>R\u0016\u0010H\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR,\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010:\u001a\u0004\bK\u0010<\"\u0004\bL\u0010>R\u0014\u0010M\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR$\u0010P\u001a\u00020*2\u0006\u0010O\u001a\u00020*8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bP\u0010I\"\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001c0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001c0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010WR\u0014\u0010Y\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010TR\u0014\u0010Z\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010TR\u0014\u0010[\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010TR\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010^R\u0014\u0010`\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010^R\u0014\u0010a\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010g\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010fR\u0016\u0010i\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010TR\u0014\u0010j\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010NR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010TR\u0016\u0010o\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010TR\u0016\u0010p\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010I¨\u0006s"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/circle/J;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "x", "y", "LY8/t;", "c", "(FF)V", "fromIdx", "toIdx", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(II)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Path;", "path", "fraction", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/graphics/Canvas;Landroid/graphics/Path;F)V", "f", "Landroid/graphics/PointF;", "point", "e", "(Landroid/graphics/Canvas;Landroid/graphics/PointF;F)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", Const.INTENT_KEY_UMID, "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDraw", "(Landroid/graphics/Canvas;)V", "onDetachedFromWindow", "Lkotlin/Function1;", "Landroid/graphics/RectF;", "onFreehandComplete", "Lp9/l;", "getOnFreehandComplete", "()Lp9/l;", "setOnFreehandComplete", "(Lp9/l;)V", "Lkotlin/Function0;", "onDrawStarted", "Lp9/a;", "getOnDrawStarted", "()Lp9/a;", "setOnDrawStarted", "(Lp9/a;)V", "onTapped", "getOnTapped", "setOnTapped", "onTouchInProgressChanged", "getOnTouchInProgressChanged", "setOnTouchInProgressChanged", "onStrokeFinished", "getOnStrokeFinished", "setOnStrokeFinished", "loggedSoftwareFallback", "Z", "excludeTopProvider", "getExcludeTopProvider", "setExcludeTopProvider", "drawPath", "Landroid/graphics/Path;", UxipConstants.f30680s, "isDrawing", "setDrawing", "(Z)V", "density", "F", "", "points", "Ljava/util/List;", "controlPoints", "coreStrokeWidth", "minMoveDistanceSq", "blurRadius", "Landroid/graphics/Paint;", "glow1Paint", "Landroid/graphics/Paint;", "glow2Paint", "corePaint", "capPaint", "Landroid/graphics/Bitmap;", "glowBitmap", "Landroid/graphics/Bitmap;", "glowCanvas", "Landroid/graphics/Canvas;", "coreBitmap", "coreCanvas", "accumulatedLength", "segPath", "Landroid/graphics/RenderNode;", "glowRenderNode", "Landroid/graphics/RenderNode;", "lastX", "lastY", "drawStartedEmitted", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J extends View {
    private static final String TAG = "FreehandDrawView";
    private float accumulatedLength;
    private final float blurRadius;
    private final Paint capPaint;
    private final List<PointF> controlPoints;
    private Bitmap coreBitmap;
    private Canvas coreCanvas;
    private final Paint corePaint;
    private final float coreStrokeWidth;
    private final float density;
    private final Path drawPath;
    private boolean drawStartedEmitted;
    private InterfaceC5063a<Float> excludeTopProvider;
    private final Paint glow1Paint;
    private final Paint glow2Paint;
    private Bitmap glowBitmap;
    private Canvas glowCanvas;
    private final RenderNode glowRenderNode;
    private boolean isDrawing;
    private float lastX;
    private float lastY;
    private boolean loggedSoftwareFallback;
    private final float minMoveDistanceSq;
    private InterfaceC5063a<Y8.t> onDrawStarted;
    private InterfaceC5074l<? super RectF, Y8.t> onFreehandComplete;
    private InterfaceC5063a<Y8.t> onStrokeFinished;
    private InterfaceC5063a<Y8.t> onTapped;
    private InterfaceC5074l<? super Boolean, Y8.t> onTouchInProgressChanged;
    private final List<PointF> points;
    private final Path segPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.drawPath = new Path();
        float f10 = getResources().getDisplayMetrics().density;
        this.density = f10;
        this.points = new ArrayList();
        this.controlPoints = new ArrayList();
        float f11 = 4.0f * f10;
        this.coreStrokeWidth = f11;
        this.minMoveDistanceSq = f10 * 3.0f * 3.0f * f10;
        float f12 = f10 * 5.0f;
        this.blurRadius = f12;
        Paint paint = new Paint(1);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(f11);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Join join = Paint.Join.ROUND;
        paint.setStrokeJoin(join);
        this.glow1Paint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(style);
        paint2.setStrokeWidth(f11);
        paint2.setStrokeCap(cap);
        paint2.setStrokeJoin(join);
        this.glow2Paint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(style);
        paint3.setStrokeWidth(f11);
        paint3.setStrokeCap(Paint.Cap.BUTT);
        paint3.setStrokeJoin(join);
        this.corePaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.FILL);
        this.capPaint = paint4;
        this.segPath = new Path();
        RenderNode renderNode = new RenderNode("glow");
        renderNode.setRenderEffect(RenderEffect.createBlurEffect(f12, f12, Shader.TileMode.DECAL));
        this.glowRenderNode = renderNode;
        setLayerType(2, null);
    }

    public static final void j(J j10) {
        j10.d();
        InterfaceC5063a<Y8.t> interfaceC5063a = j10.onTapped;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void k(J j10, RectF rectF) {
        InterfaceC5074l<? super RectF, Y8.t> interfaceC5074l = j10.onFreehandComplete;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(rectF);
        }
    }

    private final void setDrawing(boolean z10) {
        if (this.isDrawing == z10) {
            return;
        }
        this.isDrawing = z10;
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onTouchInProgressChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
    }

    public final void c(float x10, float y10) {
        float f10 = x10 - this.lastX;
        float f11 = y10 - this.lastY;
        float f12 = (f10 * f10) + (f11 * f11);
        if (f12 < this.minMoveDistanceSq) {
            return;
        }
        if (!this.drawStartedEmitted) {
            this.drawStartedEmitted = true;
            InterfaceC5063a<Y8.t> interfaceC5063a = this.onDrawStarted;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
        this.accumulatedLength += (float) Math.sqrt(f12);
        float f13 = this.lastX;
        float f14 = (f13 + x10) / 2.0f;
        float f15 = this.lastY;
        float f16 = (f15 + y10) / 2.0f;
        this.drawPath.quadTo(f13, f15, f14, f16);
        this.controlPoints.add(new PointF(this.lastX, this.lastY));
        this.points.add(new PointF(f14, f16));
        this.lastX = x10;
        this.lastY = y10;
        h(this.points.size() - 2, this.points.size() - 1);
    }

    public final void d() {
        this.drawPath.reset();
        this.points.clear();
        this.controlPoints.clear();
        this.accumulatedLength = 0.0f;
        setDrawing(false);
        this.drawStartedEmitted = false;
        Canvas canvas = this.glowCanvas;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        Canvas canvas2 = this.coreCanvas;
        if (canvas2 != null) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        invalidate();
    }

    public final void e(Canvas canvas, PointF point, float fraction) {
        this.capPaint.setColor(K.i(K.b(), K.a(), fraction));
        canvas.drawCircle(point.x, point.y, this.coreStrokeWidth / 2.0f, this.capPaint);
    }

    public final void f(Canvas canvas, Path path, float fraction) {
        this.corePaint.setColor(K.i(K.b(), K.a(), fraction));
        canvas.drawPath(path, this.corePaint);
    }

    public final void g(Canvas canvas, Path path, float fraction) {
        this.glow1Paint.setColor(K.i(K.d(), K.c(), fraction));
        canvas.drawPath(path, this.glow1Paint);
        this.glow2Paint.setColor(K.i(K.f(), K.e(), fraction));
        canvas.drawPath(path, this.glow2Paint);
    }

    public final InterfaceC5063a<Float> getExcludeTopProvider() {
        return this.excludeTopProvider;
    }

    public final InterfaceC5063a<Y8.t> getOnDrawStarted() {
        return this.onDrawStarted;
    }

    public final InterfaceC5074l<RectF, Y8.t> getOnFreehandComplete() {
        return this.onFreehandComplete;
    }

    public final InterfaceC5063a<Y8.t> getOnStrokeFinished() {
        return this.onStrokeFinished;
    }

    public final InterfaceC5063a<Y8.t> getOnTapped() {
        return this.onTapped;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnTouchInProgressChanged() {
        return this.onTouchInProgressChanged;
    }

    public final void h(int fromIdx, int toIdx) {
        Canvas canvas;
        Canvas canvas2 = this.glowCanvas;
        if (canvas2 != null && (canvas = this.coreCanvas) != null && fromIdx >= 0 && toIdx < this.points.size() && fromIdx < this.controlPoints.size()) {
            PointF pointF = this.points.get(fromIdx);
            PointF pointF2 = this.points.get(toIdx);
            PointF pointF3 = this.controlPoints.get(fromIdx);
            InterfaceC5063a<Float> interfaceC5063a = this.excludeTopProvider;
            Float fInvoke = interfaceC5063a != null ? interfaceC5063a.invoke() : null;
            if (fInvoke == null || (pointF.y < fInvoke.floatValue() && pointF2.y < fInvoke.floatValue())) {
                this.segPath.reset();
                this.segPath.moveTo(pointF.x, pointF.y);
                this.segPath.quadTo(pointF3.x, pointF3.y, pointF2.x, pointF2.y);
                float f10 = this.accumulatedLength;
                float fM = C5685n.m(f10 / ((this.density * 150.0f) + f10), 0.0f, 1.0f);
                g(canvas2, this.segPath, fM);
                f(canvas, this.segPath, fM);
                if (fromIdx == 0) {
                    e(canvas, this.points.get(0), 0.0f);
                }
                e(canvas, pointF2, fM);
            }
        }
    }

    public final void i() {
        if (!K.g(this.points.size())) {
            post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.circle.H
                @Override // java.lang.Runnable
                public final void run() {
                    J.j(this.f26708a);
                }
            });
            return;
        }
        final RectF rectF = new RectF();
        this.drawPath.computeBounds(rectF, true);
        float f10 = this.density * 60.0f;
        if (rectF.width() < f10) {
            rectF.inset((-(f10 - rectF.width())) / 2.0f, 0.0f);
        }
        if (rectF.height() < f10) {
            rectF.inset(0.0f, (-(f10 - rectF.height())) / 2.0f);
        }
        float fI = C5685n.i(rectF.width(), getWidth());
        float fI2 = C5685n.i(rectF.height(), getHeight());
        float fM = C5685n.m(rectF.left, 0.0f, getWidth() - fI);
        float fM2 = C5685n.m(rectF.top, 0.0f, getHeight() - fI2);
        rectF.set(fM, fM2, fI + fM, fI2 + fM2);
        d();
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onStrokeFinished;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.circle.I
            @Override // java.lang.Runnable
            public final void run() {
                J.k(this.f26709a, rectF);
            }
        });
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        setDrawing(false);
        super.onDetachedFromWindow();
        Bitmap bitmap = this.glowBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.glowBitmap = null;
        this.glowCanvas = null;
        Bitmap bitmap2 = this.coreBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.coreBitmap = null;
        this.coreCanvas = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        kotlin.jvm.internal.p.i(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap2 = this.glowBitmap;
        if (bitmap2 == null || (bitmap = this.coreBitmap) == null) {
            return;
        }
        if (canvas.isHardwareAccelerated()) {
            this.glowRenderNode.setPosition(0, 0, getWidth(), getHeight());
            RecordingCanvas recordingCanvasBeginRecording = this.glowRenderNode.beginRecording();
            kotlin.jvm.internal.p.h(recordingCanvasBeginRecording, "beginRecording(...)");
            recordingCanvasBeginRecording.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            this.glowRenderNode.endRecording();
            canvas.drawRenderNode(this.glowRenderNode);
        } else {
            if (!this.loggedSoftwareFallback) {
                this.loggedSoftwareFallback = true;
                C4148a.u(TAG, "software canvas: skip RenderNode glow, draw sharp bitmaps", false, 4, null);
            }
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        Bitmap bitmap = this.glowBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap bitmap2 = this.coreBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        if (w10 <= 0 || h10 <= 0) {
            return;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        this.glowBitmap = Bitmap.createBitmap(w10, h10, config);
        Bitmap bitmap3 = this.glowBitmap;
        kotlin.jvm.internal.p.f(bitmap3);
        this.glowCanvas = new Canvas(bitmap3);
        this.coreBitmap = Bitmap.createBitmap(w10, h10, config);
        Bitmap bitmap4 = this.coreBitmap;
        kotlin.jvm.internal.p.f(bitmap4);
        this.coreCanvas = new Canvas(bitmap4);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.isDrawing) {
                        return false;
                    }
                    int historySize = event.getHistorySize();
                    for (int i10 = 0; i10 < historySize; i10++) {
                        c(event.getHistoricalX(i10), event.getHistoricalY(i10));
                    }
                    c(event.getX(), event.getY());
                    invalidate();
                    return true;
                }
                if (actionMasked != 3) {
                    return super.onTouchEvent(event);
                }
            }
            if (!this.isDrawing) {
                return false;
            }
            setDrawing(false);
            c(event.getX(), event.getY());
            invalidate();
            i();
            return true;
        }
        InterfaceC5063a<Float> interfaceC5063a = this.excludeTopProvider;
        Float fInvoke = interfaceC5063a != null ? interfaceC5063a.invoke() : null;
        if (fInvoke != null && event.getY() >= fInvoke.floatValue()) {
            return false;
        }
        this.drawPath.reset();
        this.points.clear();
        this.controlPoints.clear();
        this.accumulatedLength = 0.0f;
        Canvas canvas = this.glowCanvas;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        Canvas canvas2 = this.coreCanvas;
        if (canvas2 != null) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        this.drawPath.moveTo(event.getX(), event.getY());
        this.points.add(new PointF(event.getX(), event.getY()));
        this.lastX = event.getX();
        this.lastY = event.getY();
        setDrawing(true);
        this.drawStartedEmitted = false;
        invalidate();
        return true;
    }

    public final void setExcludeTopProvider(InterfaceC5063a<Float> interfaceC5063a) {
        this.excludeTopProvider = interfaceC5063a;
    }

    public final void setOnDrawStarted(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onDrawStarted = interfaceC5063a;
    }

    public final void setOnFreehandComplete(InterfaceC5074l<? super RectF, Y8.t> interfaceC5074l) {
        this.onFreehandComplete = interfaceC5074l;
    }

    public final void setOnStrokeFinished(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onStrokeFinished = interfaceC5063a;
    }

    public final void setOnTapped(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onTapped = interfaceC5063a;
    }

    public final void setOnTouchInProgressChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onTouchInProgressChanged = interfaceC5074l;
    }

    public /* synthetic */ J(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
