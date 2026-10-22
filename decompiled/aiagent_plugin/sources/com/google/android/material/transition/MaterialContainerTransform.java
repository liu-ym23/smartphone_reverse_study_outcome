package com.google.android.material.transition;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.transition.o;
import androidx.transition.s;
import androidx.transition.w;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.q;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialContainerTransform extends s {
    private static final String TAG = "MaterialContainerTransform";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f13699a = null;
    private static final b i = null;
    private static final b j = null;
    private static final b k = null;
    private static final b l = null;
    private View A;
    private View B;
    private com.google.android.material.shape.m C;
    private com.google.android.material.shape.m D;
    private a E;
    private a F;
    private a G;
    private a H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f13700J;
    private float K;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    private static final class TransitionDrawable extends Drawable {
        private static final int COMPAT_SHADOW_COLOR = -7829368;
        private static final int SHADOW_COLOR = 754974720;
        private static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3f;
        private static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5f;
        private final MaterialShapeDrawable compatShadowDrawable;
        private final Paint containerPaint;
        private float currentElevation;
        private float currentElevationDy;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private RectF currentMaskBounds;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
        private final float displayHeight;
        private final float displayWidth;
        private final boolean drawDebugEnabled;
        private final boolean elevationShadowEnabled;
        private final RectF endBounds;
        private final Paint endContainerPaint;
        private final float endElevation;
        private final com.google.android.material.shape.m endShapeAppearanceModel;
        private final View endView;
        private final boolean entering;
        private final com.google.android.material.transition.a fadeModeEvaluator;
        private c fadeModeResult;
        private final f fitModeEvaluator;
        private h fitModeResult;
        private final i maskEvaluator;
        private final float motionPathLength;
        private final PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final b progressThresholds;
        private final Paint scrimPaint;
        private final Paint shadowPaint;
        private final RectF startBounds;
        private final Paint startContainerPaint;
        private final float startElevation;
        private final com.google.android.material.shape.m startShapeAppearanceModel;
        private final View startView;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        /* synthetic */ TransitionDrawable(o r21, View r22, RectF r23, com.google.android.material.shape.m r24, float r25, View r26, RectF r27, com.google.android.material.shape.m r28, float r29, int r30, int r31, int r32, int r33, boolean r34, boolean r35, com.google.android.material.transition.a r36, f r37, b r38, boolean r39, AnonymousClass1 r40) {
            this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, (com.google.android.material.transition.a) ZeusTransformUtils.wrapperContextForParams(r36, com.google.android.material.transition.a.class, "com.obric.aiagent.plugin"), (f) ZeusTransformUtils.wrapperContextForParams(r37, f.class, "com.obric.aiagent.plugin"), r38, r39);
        }

        static /* synthetic */ void access$200(TransitionDrawable r0, float r1) {
            r0.setProgress(r1);
        }

        static /* synthetic */ View access$800(TransitionDrawable r0) {
            return r0.startView;
        }

        static /* synthetic */ View access$900(TransitionDrawable r0) {
            return r0.endView;
        }

        private TransitionDrawable(o r17, View r18, RectF r19, com.google.android.material.shape.m r20, float r21, View r22, RectF r23, com.google.android.material.shape.m r24, float r25, int r26, int r27, int r28, int r29, boolean r30, boolean r31, com.google.android.material.transition.a r32, f r33, b r34, boolean r35) {
            com.google.android.material.transition.a r2 = (com.google.android.material.transition.a) ZeusTransformUtils.wrapperContextForParams(r32, com.google.android.material.transition.a.class, "com.obric.aiagent.plugin");
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r33, f.class, "com.obric.aiagent.plugin");
            Paint r5 = new Paint();
            this.containerPaint = r5;
            Paint r6 = new Paint();
            this.startContainerPaint = r6;
            Paint r7 = new Paint();
            this.endContainerPaint = r7;
            this.shadowPaint = new Paint();
            Paint r8 = new Paint();
            this.scrimPaint = r8;
            this.maskEvaluator = new i();
            this.motionPathPosition = new float[]{r19.centerX(), r19.top};
            MaterialShapeDrawable r11 = new MaterialShapeDrawable();
            this.compatShadowDrawable = r11;
            Paint r12 = new Paint();
            this.debugPaint = r12;
            this.debugPath = new Path();
            this.startView = r18;
            this.startBounds = r19;
            this.startShapeAppearanceModel = r20;
            this.startElevation = r21;
            this.endView = r22;
            this.endBounds = r23;
            this.endShapeAppearanceModel = r24;
            this.endElevation = r25;
            this.entering = r30;
            this.elevationShadowEnabled = r31;
            this.fadeModeEvaluator = r2;
            this.fitModeEvaluator = r4;
            this.progressThresholds = r34;
            this.drawDebugEnabled = r35;
            WindowManager r3 = (WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin");
            DisplayMetrics r9 = new DisplayMetrics();
            r3.getDefaultDisplay().getMetrics(r9);
            this.displayWidth = r9.widthPixels;
            this.displayHeight = r9.heightPixels;
            r5.setColor(r26);
            r6.setColor(r27);
            r7.setColor(r28);
            r11.setFillColor(ColorStateList.valueOf(0));
            r11.setShadowCompatibilityMode(2);
            r11.setShadowBitmapDrawingEnable(false);
            r11.setShadowColor(COMPAT_SHADOW_COLOR);
            RectF r10 = new RectF(r19);
            this.currentStartBounds = r10;
            this.currentStartBoundsMasked = new RectF(r10);
            RectF r13 = new RectF(r10);
            this.currentEndBounds = r13;
            this.currentEndBoundsMasked = new RectF(r13);
            PointF r14 = getMotionPathPoint(r19);
            PointF r15 = getMotionPathPoint(r23);
            PathMeasure r16 = new PathMeasure(r17.a(r14.x, r14.y, r15.x, r15.y), false);
            this.motionPathMeasure = r16;
            this.motionPathLength = r16.getLength();
            r8.setStyle(Paint.Style.FILL);
            r8.setShader(n.a(r29));
            r12.setStyle(Paint.Style.STROKE);
            r12.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r4) {
            if (this.scrimPaint.getAlpha() <= 0) goto L6;
            r4.drawRect(getBounds(), this.scrimPaint);
        L6:
            if (this.drawDebugEnabled == false) goto L8;
            int r0 = r4.save();
        L10:
            if (this.elevationShadowEnabled == true) goto L12;
        L14:
            this.maskEvaluator.a(r4);
            maybeDrawContainerColor(r4, this.containerPaint);
            if (this.fadeModeResult.f13720c == false) goto L17;
            drawStartView(r4);
            drawEndView(r4);
        L19:
            if (this.drawDebugEnabled == false) goto L22;
            r4.restoreToCount(r0);
            drawDebugCumulativePath(r4, this.currentStartBounds, this.debugPath, -65281);
            drawDebugRect(r4, this.currentStartBoundsMasked, -256);
            drawDebugRect(r4, this.currentStartBounds, -16711936);
            drawDebugRect(r4, this.currentEndBoundsMasked, -16711681);
            drawDebugRect(r4, this.currentEndBounds, -16776961);
            return;
        L22:
            return;
        L17:
            drawEndView(r4);
            drawStartView(r4);
            goto L19
        L12:
            if (this.currentElevation <= 0.0f) goto L14;
            drawElevationShadow(r4);
            goto L14
        L8:
            r0 = -1;
            goto L10
        }

        private void drawElevationShadow(Canvas r3) {
            r3.save();
            r3.clipPath(this.maskEvaluator.a(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT <= 28) goto L5;
            drawElevationShadowWithPaintShadowLayer(r3);
        L6:
            r3.restore();
            return;
        L5:
            drawElevationShadowWithMaterialShapeDrawable(r3);
            goto L6
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas r3) {
            com.google.android.material.shape.m r0 = this.maskEvaluator.b();
            if (r0.a(this.currentMaskBounds) == false) goto L5;
            float r1 = r0.f().a(this.currentMaskBounds);
            r3.drawRoundRect(this.currentMaskBounds, r1, r1, this.shadowPaint);
            return;
        L5:
            r3.drawPath(this.maskEvaluator.a(), this.shadowPaint);
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas r6) {
            this.compatShadowDrawable.setBounds((int) this.currentMaskBounds.left, (int) this.currentMaskBounds.top, (int) this.currentMaskBounds.right, (int) this.currentMaskBounds.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.b());
            this.compatShadowDrawable.draw(r6);
        }

        private void drawStartView(Canvas r9) {
            maybeDrawContainerColor(r9, this.startContainerPaint);
            n.a(r9, getBounds(), this.currentStartBounds.left, this.currentStartBounds.top, this.fitModeResult.f13723a, this.fadeModeResult.f13718a, new AnonymousClass1(this));
        }

        private void drawEndView(Canvas r9) {
            maybeDrawContainerColor(r9, this.endContainerPaint);
            n.a(r9, getBounds(), this.currentEndBounds.left, this.currentEndBounds.top, this.fitModeResult.f13724b, this.fadeModeResult.f13719b, new AnonymousClass2(this));
        }

        private void maybeDrawContainerColor(Canvas r2, Paint r3) {
            if (r3.getColor() != 0) goto L5;
            return;
        L5:
            if (r3.getAlpha() <= 0) goto L9;
            r2.drawRect(getBounds(), r3);
            return;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private void setProgress(float r2) {
            if (this.progress == r2) goto L6;
            updateProgress(r2);
            return;
        }

        private void updateProgress(float r16) {
            this.progress = r16;
            Paint r1 = this.scrimPaint;
            if (this.entering == false) goto L5;
            float r2 = n.a(0.0f, 255.0f, r16);
        L6:
            r1.setAlpha((int) r2);
            this.motionPathMeasure.getPosTan(this.motionPathLength * r16, this.motionPathPosition, null);
            float[] r3 = this.motionPathPosition;
            float r4 = r3[0];
            float r6 = r3[1];
            if (r16 <= 1.0f) goto L9;
        L12:
            if (r16 <= 1.0f) goto L14;
            float r7 = 0.99f;
            float r8 = (r16 - 1.0f) / 0.00999999f;
        L15:
            this.motionPathMeasure.getPosTan(this.motionPathLength * r7, r3, null);
            float[] r5 = this.motionPathPosition;
            r4 = r4 + ((r4 - r5[0]) * r8);
            r6 = r6 + ((r6 - r5[1]) * r8);
        L11:
            float r12 = r4;
            float r13 = r6;
            h r9 = this.fitModeEvaluator.a(r16, ((Float) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(Float.valueOf(a.a(b.b(this.progressThresholds)))), Float.class, "com.obric.aiagent.plugin")).floatValue(), ((Float) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(Float.valueOf(a.b(b.b(this.progressThresholds)))), Float.class, "com.obric.aiagent.plugin")).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = r9;
            this.currentStartBounds.set(r12 - (r9.f13725c / 2.0f), r13, (this.fitModeResult.f13725c / 2.0f) + r12, this.fitModeResult.f13726d + r13);
            this.currentEndBounds.set(r12 - (this.fitModeResult.f13727e / 2.0f), r13, r12 + (this.fitModeResult.f13727e / 2.0f), this.fitModeResult.f + r13);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float r10 = ((Float) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(Float.valueOf(a.a(b.c(this.progressThresholds)))), Float.class, "com.obric.aiagent.plugin")).floatValue();
            float r11 = ((Float) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(Float.valueOf(a.b(b.c(this.progressThresholds)))), Float.class, "com.obric.aiagent.plugin")).floatValue();
            boolean r14 = this.fitModeEvaluator.a(this.fitModeResult);
            if (r14 == false) goto L19;
            RectF r15 = this.currentStartBoundsMasked;
        L20:
            float r17 = n.a(0.0f, 1.0f, r10, r11, r16);
            if (r14 == true) goto L24;
            r17 = 1.0f - r17;
        L24:
            this.fitModeEvaluator.a(r15, r17, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.a(r16, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, b.d(this.progressThresholds));
            this.currentElevation = n.a(this.startElevation, this.endElevation, r16);
            float r18 = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
            float r19 = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
            float r20 = this.currentElevation;
            float r21 = (int) (r19 * r20);
            this.currentElevationDy = r21;
            this.shadowPaint.setShadowLayer(r20, (int) (r18 * r20), r21, SHADOW_COLOR);
            this.fadeModeResult = this.fadeModeEvaluator.a(r16, ((Float) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(Float.valueOf(a.a(b.a(this.progressThresholds)))), Float.class, "com.obric.aiagent.plugin")).floatValue(), ((Float) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(Float.valueOf(a.b(b.a(this.progressThresholds)))), Float.class, "com.obric.aiagent.plugin")).floatValue(), 0.35f);
            if (this.startContainerPaint.getColor() == 0) goto L28;
            this.startContainerPaint.setAlpha(this.fadeModeResult.f13718a);
        L28:
            if (this.endContainerPaint.getColor() == 0) goto L30;
            this.endContainerPaint.setAlpha(this.fadeModeResult.f13719b);
        L30:
            invalidateSelf();
            return;
        L19:
            r15 = this.currentEndBoundsMasked;
            goto L20
        L14:
            r7 = 0.01f;
            r8 = (r16 / 0.01f) * (-1.0f);
            goto L15
        L9:
            if (r16 >= 0.0f) goto L11;
        L5:
            r2 = n.a(255.0f, 0.0f, r16);
            goto L6
        }

        private static PointF getMotionPathPoint(RectF r2) {
            return new PointF(r2.centerX(), r2.top);
        }

        private static float calculateElevationDxMultiplier(RectF r1, float r2) {
            return ((r1.centerX() / (r2 / 2.0f)) - 1.0f) * SHADOW_DX_MULTIPLIER_ADJUSTMENT;
        }

        private static float calculateElevationDyMultiplier(RectF r0, float r1) {
            return (r0.centerY() / r1) * SHADOW_DY_MULTIPLIER_ADJUSTMENT;
        }

        private void drawDebugCumulativePath(Canvas r3, RectF r4, Path r5, int r6) {
            PointF r7 = getMotionPathPoint(r4);
            if (this.progress != 0.0f) goto L5;
            r5.reset();
            r5.moveTo(r7.x, r7.y);
            return;
        L5:
            r5.lineTo(r7.x, r7.y);
            this.debugPaint.setColor(r6);
            r3.drawPath(r5, this.debugPaint);
        }

        private void drawDebugRect(Canvas r2, RectF r3, int r4) {
            this.debugPaint.setColor(r4);
            r2.drawRect(r3, this.debugPaint);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f13708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f13709b;

        static /* synthetic */ float a(a r0) {
            return r0.f13708a;
        }

        static /* synthetic */ float b(a r0) {
            return r0.f13709b;
        }

        public a(float r1, float r2) {
            this.f13708a = r1;
            this.f13709b = r2;
        }

        public float a() {
            return this.f13708a;
        }

        public float b() {
            return this.f13709b;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f13710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f13711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a f13712c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a f13713d;

        /* synthetic */ b(a r1, a r2, a r3, a r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ a a(b r0) {
            return r0.f13710a;
        }

        static /* synthetic */ a b(b r0) {
            return r0.f13711b;
        }

        static /* synthetic */ a c(b r0) {
            return r0.f13712c;
        }

        static /* synthetic */ a d(b r0) {
            return r0.f13713d;
        }

        private b(a r1, a r2, a r3, a r4) {
            this.f13710a = r1;
            this.f13711b = r2;
            this.f13712c = r3;
            this.f13713d = r4;
        }
    }

    static /* synthetic */ boolean a(MaterialContainerTransform r0) {
        return r0.n;
    }

    static {
        f13699a = new String[]{"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
        i = new b(new a(0.0f, 0.25f), new a(0.0f, 1.0f), new a(0.0f, 1.0f), new a(0.0f, 0.75f), null);
        AnonymousClass1 r14 = null;
        j = new b(new a(0.6f, 0.9f), new a(0.0f, 1.0f), new a(0.0f, 0.9f), new a(0.3f, 0.9f), r14);
        k = new b(new a(0.1f, 0.4f), new a(0.1f, 1.0f), new a(0.1f, 1.0f), new a(0.1f, 0.9f), null);
        l = new b(new a(0.6f, 0.9f), new a(0.0f, 0.9f), new a(0.0f, 0.9f), new a(0.2f, 0.9f), r14);
    }

    public MaterialContainerTransform() {
        boolean r0 = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = R.id.content;
        this.r = -1;
        this.s = -1;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 1375731712;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r0 = true;
    L5:
        this.I = r0;
        this.f13700J = -1.0f;
        this.K = -1.0f;
    }

    @Override // androidx.transition.s
    public void a(o r1) {
        super.a(r1);
        this.o = true;
    }

    @Override // androidx.transition.s
    public String[] a() {
        return f13699a;
    }

    @Override // androidx.transition.s
    public void a(w r3) {
        a(r3, this.A, this.r, this.C);
    }

    @Override // androidx.transition.s
    public void b(w r3) {
        a(r3, this.B, this.s, this.D);
    }

    private static void a(w r3, View r4, int r5, com.google.android.material.shape.m r6) {
        if (r5 == (-1)) goto L5;
        r3.f2870b = n.a(r3.f2870b, r5);
    L10:
        View r7 = r3.f2870b;
        if (ViewCompat.F(r7) == true) goto L17;
        if (r7.getWidth() != 0) goto L17;
        if (r7.getHeight() != 0) goto L17;
        return;
    L17:
        if (r7.getParent() != null) goto L19;
        RectF r8 = n.a(r7);
    L20:
        r3.f2869a.put("materialContainerTransition:bounds", r8);
        r3.f2869a.put("materialContainerTransition:shapeAppearance", a(r7, r8, r6));
        return;
    L19:
        r8 = n.b(r7);
        goto L20
    L5:
        if (r4 == null) goto L8;
        r3.f2870b = r4;
        goto L10
    L8:
        if (ZeusTransformUtils.instanceOf(r3.f2870b.getTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view")), View.class) == false) goto L10;
        View r9 = (View) ZeusTransformUtils.preCheckCast(r3.f2870b.getTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view")), View.class, "com.obric.aiagent.plugin");
        r3.f2870b.setTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view"), null);
        r3.f2870b = r9;
        goto L10
    }

    private static com.google.android.material.shape.m a(View r0, RectF r1, com.google.android.material.shape.m r2) {
        return n.a(a(r0, r2), r1);
    }

    private static com.google.android.material.shape.m a(View r3, com.google.android.material.shape.m r4) {
        if (r4 == null) goto L5;
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r3.getTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view")), com.google.android.material.shape.m.class) == true) goto L7;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r0 = a(r5);
        if (r0 == (-1)) goto L13;
        return com.google.android.material.shape.m.a(r5, r0, 0).a();
    L13:
        if (ZeusTransformUtils.instanceOf(r3, q.class) == false) goto L17;
        return ((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin")).getShapeAppearanceModel();
    L17:
        return com.google.android.material.shape.m.a().a();
    L7:
        return (com.google.android.material.shape.m) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view")), com.google.android.material.shape.m.class, "com.obric.aiagent.plugin");
    }

    private static int a(Context r4) {
        TypedArray r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(new int[]{ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.transitionShapeAppearance, "attr", "transitionShapeAppearance")});
        int r0 = r5.getResourceId(0, -1);
        r5.recycle();
        return r0;
    }

    @Override // androidx.transition.s
    public Animator a(ViewGroup r31, w r32, w r33) {
        if (r32 == null) goto L30;
        if (r33 == null) goto L30;
        RectF r11 = (RectF) ZeusTransformUtils.preCheckCast(r32.f2869a.get("materialContainerTransition:bounds"), RectF.class, "com.obric.aiagent.plugin");
        com.google.android.material.shape.m r12 = (com.google.android.material.shape.m) ZeusTransformUtils.preCheckCast(r32.f2869a.get("materialContainerTransition:shapeAppearance"), com.google.android.material.shape.m.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L29;
        if (r12 == null) goto L29;
        RectF r15 = (RectF) ZeusTransformUtils.preCheckCast(r33.f2869a.get("materialContainerTransition:bounds"), RectF.class, "com.obric.aiagent.plugin");
        com.google.android.material.shape.m r16 = (com.google.android.material.shape.m) ZeusTransformUtils.preCheckCast(r33.f2869a.get("materialContainerTransition:shapeAppearance"), com.google.android.material.shape.m.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L27;
        if (r16 == null) goto L27;
        final View r4 = r32.f2870b;
        final View r5 = r33.f2870b;
        if (r5.getParent() == null) goto L17;
        View r0 = r5;
    L19:
        if (this.q != r0.getId()) goto L21;
        final View r2 = (View) ZeusTransformUtils.preCheckCast(r0.getParent(), View.class, "com.obric.aiagent.plugin");
        View r1 = r0;
    L22:
        RectF r3 = n.b(r2);
        float r8 = -r3.left;
        float r6 = -r3.top;
        RectF r7 = a(r2, r1, r8, r6);
        r11.offset(r8, r6);
        r15.offset(r8, r6);
        boolean r9 = a(r11, r15);
        if (this.p == true) goto L25;
        a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9);
    L25:
        final TransitionDrawable r10 = new TransitionDrawable(i(), r4, r11, r12, a(this.f13700J, r4), r5, r15, r16, a(this.K, r5), this.t, this.u, this.v, this.w, r9, this.I, com.google.android.material.transition.b.a(this.y, r9), g.a(this.z, r9, r11, r15), b(r9), this.m, null);
        r10.setBounds(Math.round(r7.left), Math.round(r7.top), Math.round(r7.right), Math.round(r7.bottom));
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r13.addUpdateListener(new AnonymousClass1(this, r10));
        a(new AnonymousClass2(this, r2, r10, r4, r5));
        return r13;
    L21:
        r2 = n.b(r0, this.q);
        r1 = null;
        goto L22
    L17:
        r0 = r4;
    L27:
        a(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
    L29:
        a(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
    L30:
        return null;
    }

    private void a(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        n.a(this, r6, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.motionEasingStandard, "attr", "motionEasingStandard"), com.google.android.material.animation.a.f13143b);
        if (r5 == false) goto L5;
        int r7 = com.obric.aiagent.plugin.R.attr.motionDurationLong1;
        String r0 = "motionDurationLong1";
    L6:
        n.a(this, r6, ZeusTransformUtils.mapRes(r7, "attr", r0));
        if (this.o == true) goto L10;
        n.b(this, r6, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.motionPath, "attr", "motionPath"));
        return;
    L10:
        return;
    L5:
        r7 = com.obric.aiagent.plugin.R.attr.motionDurationMedium2;
        r0 = "motionDurationMedium2";
        goto L6
    }

    private static float a(float r1, View r2) {
        if (r1 == (-1.0f)) goto L6;
        return r1;
    L6:
        return ViewCompat.q(r2);
    }

    private static RectF a(View r0, View r1, float r2, float r3) {
        if (r1 == null) goto L6;
        RectF r4 = n.b(r1);
        r4.offset(r2, r3);
        return r4;
    L6:
        return new RectF(0.0f, 0.0f, r0.getWidth(), r0.getHeight());
    }

    private boolean a(RectF r4, RectF r5) {
        int r0 = this.x;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("Invalid transition direction: " + this.x);
    L12:
        if (n.a(r5) > n.a(r4)) goto L14;
        return false;
    L14:
        return true;
    }

    private b b(boolean r3) {
        o r0 = i();
        if (ZeusTransformUtils.instanceOf(r0, androidx.transition.b.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r0, j.class) == true) goto L10;
        return a(r3, i, j);
    L10:
        return a(r3, k, l);
    }

    private b a(boolean r7, b r8, b r9) {
        if (r7 == true) goto L6;
        r8 = r9;
    L6:
        return new b((a) ZeusTransformUtils.preCheckCast(n.a(this.E, b.a(r8)), a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(n.a(this.F, b.b(r8)), a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(n.a(this.G, b.c(r8)), a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(n.a(this.H, b.d(r8)), a.class, "com.obric.aiagent.plugin"), null);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
