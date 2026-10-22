package com.alibaba.gaiax.render.view.basic;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.template.GXColor;
import com.alibaba.gaiax.template.GXProgressConfig;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J(\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0014J\u0010\u0010&\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010'\u001a\u00020\u0019H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u00108BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXProgressView;", "Landroid/view/View;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animator", "Landroid/animation/Animator;", "bgPath", "Landroid/graphics/Path;", "config", "Lcom/alibaba/gaiax/template/GXProgressConfig;", "currentProgressWidth", "", "mPaint", "Landroid/graphics/Paint;", "percent", "getPercent", "()F", "progressPath", "getConfig", "initView", "", "onBindData", "data", "Lorg/json/JSONObject;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "", "h", "oldw", "oldh", "setConfig", "updateProgressPath", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXProgressView extends View implements GXIViewBindData {
    public static final Companion Companion = null;
    private static final float PADDING = 1.0f;
    private static final String PROGRESS_WIDTH_VALUE_HOLDER = "PROGRESS_WIDTH_VALUE_HOLDER";
    private Animator animator;
    private final Path bgPath;
    private GXProgressConfig config;
    private float currentProgressWidth;
    private final Paint mPaint;
    private float percent;
    private final Path progressPath;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXProgressView$Companion;", "", "()V", "PADDING", "", GXProgressView.PROGRESS_WIDTH_VALUE_HOLDER, "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(GXProgressView r100, ValueAnimator r101) {
        updateProgressPath$lambda$2$lambda$1(r100, r101);
    }

    private final float getPercent() {
        float r100 = this.percent;
        if (r100 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceAtMost(r100, 1.0f);
    }

    private final void initView() {
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
    }

    private final void updateProgressPath() {
        float r100 = (getMeasuredWidth() - 2.0f) * getPercent();
        GXProgressConfig r101 = this.config;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        this.progressPath.reset();
        this.progressPath.moveTo(1.0f, 1.0f);
        float r103 = r100 + 1.0f;
        this.progressPath.lineTo(r103, 1.0f);
        this.progressPath.lineTo(r103, getMeasuredHeight() - 1.0f);
        this.progressPath.lineTo(1.0f, getMeasuredHeight() - 1.0f);
        this.progressPath.close();
    L14:
        this.currentProgressWidth = r100;
        return;
    L10:
        Animator r104 = this.animator;
        if (r104 == null) goto L13;
        r104.cancel();
    L13:
        ValueAnimator r105 = new ValueAnimator();
        r105.setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(PROGRESS_WIDTH_VALUE_HOLDER, new float[]{this.currentProgressWidth, r100})});
        r105.setDuration(300);
        r105.setInterpolator(new AccelerateDecelerateInterpolator());
        r105.addUpdateListener(new b(this));
        r105.start();
        this.animator = r105;
        goto L14
    L5:
        if (r101.getAnimated() == true) goto L7;
        r102 = true;
        goto L8
    }

    public final GXProgressConfig getConfig() {
        return this.config;
    }

    public GXProgressView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.mPaint = new Paint();
        this.bgPath = new Path();
        this.progressPath = new Path();
        initView();
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(JSONObject r100) {
        if (r100 == null) goto L5;
        this.percent = (float) r100.optDouble("value");
        updateProgressPath();
        invalidate();
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        Paint r101 = this.mPaint;
        GXProgressConfig r102 = this.config;
        if (r102 == null) goto L7;
        GXColor r103 = r102.getTrailColor();
        if (r103 == null) goto L7;
        int r104 = r103.value(getContext());
    L8:
        r101.setColor(r104);
        if (r100 == null) goto L12;
        r100.drawPath(this.bgPath, this.mPaint);
    L12:
        if (getPercent() <= 0.0f) goto L23;
        Paint r105 = this.mPaint;
        GXProgressConfig r106 = this.config;
        if (r106 == null) goto L18;
        GXColor r107 = r106.getStrokeColor();
        if (r107 == null) goto L18;
        int r108 = r107.value(getContext());
    L19:
        r105.setColor(r108);
        if (r100 == null) goto L24;
        r100.drawPath(this.progressPath, this.mPaint);
        return;
    L24:
        return;
    L18:
        r108 = FakePickerAvatarCreator.BLUE;
        goto L19
    L23:
        return;
    L7:
        r104 = FakePickerAvatarCreator.GRAY;
        goto L8
    }

    public final void setConfig(GXProgressConfig r100) {
        this.config = r100;
    }

    public GXProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.mPaint = new Paint();
        this.bgPath = new Path();
        this.progressPath = new Path();
        initView();
    }

    private static final void updateProgressPath$lambda$2$lambda$1(GXProgressView r100, ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Object r102 = r101.getAnimatedValue(PROGRESS_WIDTH_VALUE_HOLDER);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        float r103 = ((Float) r102).floatValue();
        r100.progressPath.reset();
        r100.progressPath.moveTo(1.0f, 1.0f);
        float r104 = r103 + 1.0f;
        r100.progressPath.lineTo(r104, 1.0f);
        r100.progressPath.lineTo(r104, r100.getMeasuredHeight() - 1.0f);
        r100.progressPath.lineTo(1.0f, r100.getMeasuredHeight() - 1.0f);
        r100.progressPath.close();
        r100.invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = r101;
        this.mPaint.setPathEffect(new CornerPathEffect((r104 - 2.0f) / 2));
        this.bgPath.reset();
        this.bgPath.moveTo(1.0f, 1.0f);
        float r105 = r100 - 1.0f;
        this.bgPath.lineTo(r105, 1.0f);
        float r106 = r104 - 1.0f;
        this.bgPath.lineTo(r105, r106);
        this.bgPath.lineTo(1.0f, r106);
        this.bgPath.close();
        updateProgressPath();
    }
}
