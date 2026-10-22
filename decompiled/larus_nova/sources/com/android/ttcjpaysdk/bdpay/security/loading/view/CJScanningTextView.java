package com.android.ttcjpaysdk.bdpay.security.loading.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0014J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0014J(\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020\u0019J\u0006\u0010*\u001a\u00020\u0019R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/view/CJScanningTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "Lcom/android/ttcjpaysdk/bdpay/security/loading/view/ScanningTextConfig;", "delayedStartRunnable", "Ljava/lang/Runnable;", KFFeatureEffect.GRADIENT_JSON_FIELD, "Landroid/graphics/LinearGradient;", "gradientMatrix", "Landroid/graphics/Matrix;", "gradientTranslate", "", "scanAnimator", "Landroid/animation/ValueAnimator;", "shouldStartScan", "", "viewWidth", "createAnimator", "", "createGradient", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setConfig", "setShouldStartScan", "startScan", "stopScan", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJScanningTextView extends AppCompatTextView {
    private ScanningTextConfig config;
    private Runnable delayedStartRunnable;
    private LinearGradient gradient;
    private final Matrix gradientMatrix;
    private float gradientTranslate;
    private ValueAnimator scanAnimator;
    private boolean shouldStartScan;
    private int viewWidth;

    public CJScanningTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJScanningTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void createGradient() {
        int r100 = this.config.getGradientColors().length;
        int[] r101 = new int[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L9;
        if (this.config.getGradientColors()[r102] != 0) goto L7;
        int r103 = getCurrentTextColor();
    L8:
        r101[r102] = r103;
        r102 = r102 + 1;
        goto L3
    L7:
        r103 = this.config.getGradientColors()[r102];
        goto L8
    L9:
        this.gradient = new LinearGradient((-this.viewWidth) / 2, 0.0f, 0.0f, 0.0f, r101, this.config.getGradientPositions(), Shader.TileMode.CLAMP);
        getPaint().setShader(this.gradient);
    }

    public final void startScan() {
        if (this.viewWidth <= 0) goto L18;
        ValueAnimator r100 = this.scanAnimator;
        boolean r101 = false;
        if (r100 != null) goto L7;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        if (getLayout() == null) goto L16;
        ValueAnimator r102 = this.scanAnimator;
        if (r102 == null) goto L19;
        r102.start();
        return;
    L19:
        return;
    L16:
        post(new AnonymousClass1(this));
        return;
    L7:
        if (r100.isStarted() != true) goto L9;
        r101 = true;
        goto L9
    }

    public final void stopScan() {
        ValueAnimator r100 = this.scanAnimator;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
    L11:
        ValueAnimator r102 = this.scanAnimator;
        if (r102 == null) goto L14;
        r102.cancel();
    L14:
        Runnable r103 = this.delayedStartRunnable;
        if (r103 == null) goto L17;
        removeCallbacks(r103);
    L17:
        this.delayedStartRunnable = null;
        this.gradientTranslate = 0.0f;
        invalidate();
        return;
    L9:
        if (this.delayedStartRunnable != null) goto L11;
        return;
    L5:
        if (r100.isStarted() != true) goto L7;
        r101 = true;
        goto L7
    }

    private final void createAnimator() {
        stopScan();
        final Ref.IntRef r100 = new Ref.IntRef();
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, this.viewWidth * 2.0f});
        r101.setDuration(this.config.getAnimationDuration());
        r101.setInterpolator(this.config.getInterpolator());
        r101.setRepeatCount(0);
        r101.setRepeatMode(this.config.getRepeatMode());
        r101.addUpdateListener(new CJScanningTextView$createAnimator$1$1(this));
        r101.addListener(new CJScanningTextView$createAnimator$1$2(r100, this));
        this.scanAnimator = r101;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScan();
    }

    public static final /* synthetic */ ScanningTextConfig access$getConfig$p(CJScanningTextView r100) {
        return r100.config;
    }

    public static final /* synthetic */ Runnable access$getDelayedStartRunnable$p(CJScanningTextView r100) {
        return r100.delayedStartRunnable;
    }

    public static final /* synthetic */ ValueAnimator access$getScanAnimator$p(CJScanningTextView r100) {
        return r100.scanAnimator;
    }

    public static final /* synthetic */ int access$getViewWidth$p(CJScanningTextView r100) {
        return r100.viewWidth;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "CJScanningTextView#onDraw"
            java.lang.String r1 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            int r1 = r6.save()
            android.text.TextPaint r2 = r5.getPaint()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            android.graphics.Shader r2 = r2.getShader()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            if (r2 == 0) goto L26
            android.graphics.Matrix r2 = r5.gradientMatrix     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            float r3 = r5.gradientTranslate     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r4 = 0
            r2.setTranslate(r3, r4)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            android.graphics.LinearGradient r2 = r5.gradient     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            if (r2 == 0) goto L26
            android.graphics.Matrix r3 = r5.gradientMatrix     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r2.setLocalMatrix(r3)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
        L26:
            super.onDraw(r6)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
        L29:
            r6.restoreToCount(r1)
            goto L41
        L2d:
            r0 = move-exception
            goto L42
        L2f:
            r2 = move-exception
            com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils.reportCatchException(r0, r2)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r3 = "CJCatch"
            com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils.logCatch(r3, r0, r2)     // Catch: java.lang.Throwable -> L2d
            android.text.TextPaint r0 = r5.getPaint()     // Catch: java.lang.Throwable -> L2d
            r2 = 0
            r0.setShader(r2)     // Catch: java.lang.Throwable -> L2d
            goto L29
        L41:
            return
        L42:
            r6.restoreToCount(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ttcjpaysdk.bdpay.security.loading.view.CJScanningTextView.onDraw(android.graphics.Canvas):void");
    }

    public final void setConfig(ScanningTextConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        setShouldStartScan(true);
        this.config = r100;
        createGradient();
        createAnimator();
    }

    public final void setShouldStartScan(boolean r100) {
        this.shouldStartScan = r100;
    }

    public static final /* synthetic */ void access$setDelayedStartRunnable$p(CJScanningTextView r100, Runnable r101) {
        r100.delayedStartRunnable = r101;
    }

    public static final /* synthetic */ void access$setGradientTranslate$p(CJScanningTextView r100, float r101) {
        r100.gradientTranslate = r101;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJScanningTextView#onMeasure", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJScanningTextView#onMeasure", e);
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
    }

    public CJScanningTextView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.gradientMatrix = new Matrix();
        this.config = new ScanningTextConfig(0, null, null, null, 0, 0, 0, 127, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L5;
        return;
    L5:
        if (this.shouldStartScan == false) goto L12;
        this.viewWidth = r100;
        if (r100 <= 0) goto L9;
        createGradient();
        createAnimator();
        startScan();
        return;
    L9:
        stopScan();
        this.gradient = null;
        this.scanAnimator = null;
        getPaint().setShader(null);
        return;
    }

    public /* synthetic */ CJScanningTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
