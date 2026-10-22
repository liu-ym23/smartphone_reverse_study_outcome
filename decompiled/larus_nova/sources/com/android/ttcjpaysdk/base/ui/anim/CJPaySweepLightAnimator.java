package com.android.ttcjpaysdk.base.ui.anim;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewOverlay;
import android.view.animation.PathInterpolator;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00030\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJPaySweepLightAnimator;", "", "targetView", "Landroid/view/View;", "config", "Lcom/android/ttcjpaysdk/base/ui/anim/CJPaySweepLightConfig;", "(Landroid/view/View;Lcom/android/ttcjpaysdk/base/ui/anim/CJPaySweepLightConfig;)V", "attached", "", "delayedStart", "Ljava/lang/Runnable;", "drawable", "Lcom/android/ttcjpaysdk/base/ui/anim/CJPaySweepLightDrawable;", "isCancelled", "runningTimes", "", "targetViewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "valueAnimator", "Landroid/animation/ValueAnimator;", "attachDrawable", "", "cancel", "cancelDelayedStart", "detachDrawable", "release", "scheduleNextRun", "start", "startSingleRun", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySweepLightAnimator {
    private boolean attached;
    private final CJPaySweepLightConfig config;
    private Runnable delayedStart;
    private final CJPaySweepLightDrawable drawable;
    private boolean isCancelled;
    private int runningTimes;
    private final WeakReference<View> targetViewRef;
    private ValueAnimator valueAnimator;

    public final void cancel() {
        this.isCancelled = true;
        cancelDelayedStart();
        ValueAnimator r100 = this.valueAnimator;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.valueAnimator = null;
        this.drawable.updateProgress(0.0f);
        detachDrawable();
    }

    private final void cancelDelayedStart() {
        View r100 = this.targetViewRef.get();
        Runnable r101 = this.delayedStart;
        if (r101 == null) goto L6;
        if (r100 == null) goto L6;
        r100.removeCallbacks(r101);
    L6:
        this.delayedStart = null;
    }

    private final void detachDrawable() {
        if (this.attached == true) goto L5;
        return;
    L5:
        View r100 = this.targetViewRef.get();
        if (r100 == null) goto L10;
        ViewOverlay r101 = r100.getOverlay();
        if (r101 == null) goto L10;
        r101.remove(this.drawable);
    L10:
        this.attached = false;
    }

    private final void scheduleNextRun() {
        View r100 = this.targetViewRef.get();
        if (r100 != null) goto L5;
        return;
    L5:
        cancelDelayedStart();
        Runnable r101 = new AnonymousClass1(this);
        if (this.config.getRepeatInterval() <= 0) goto L8;
        r100.postDelayed(r101, this.config.getRepeatInterval());
    L9:
        this.delayedStart = r101;
        return;
    L8:
        r100.post(r101);
        goto L9
    }

    private final void startSingleRun() {
        View r100 = this.targetViewRef.get();
        if (r100 != null) goto L5;
        return;
    L5:
        attachDrawable(r100);
        ValueAnimator r101 = this.valueAnimator;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setDuration(this.config.getDuration());
        if (this.runningTimes != 0) goto L11;
        long r103 = this.config.getStartDelay();
    L12:
        r102.setStartDelay(r103);
        r102.setInterpolator(new PathInterpolator(0.53f, 0.0f, 0.73f, 1.0f));
        r102.addUpdateListener(new CJPaySweepLightAnimator$startSingleRun$1$1(this));
        r102.addListener(new CJPaySweepLightAnimator$startSingleRun$1$2(this));
        r102.start();
        this.valueAnimator = r102;
        return;
    L11:
        r103 = 0;
        goto L12
    }

    public final void start() {
        View r100 = this.targetViewRef.get();
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.config.getRunningTimes() > 0) goto L8;
        return;
    L8:
        this.isCancelled = false;
        cancelDelayedStart();
        if (r100.getWidth() > 0) goto L11;
    L15:
        Runnable r101 = new RunnableC88781(this);
        r100.post(r101);
        this.delayedStart = r101;
        return;
    L11:
        if (r100.getHeight() <= 0) goto L15;
        this.runningTimes = 0;
        startSingleRun();
    }

    public final void release() {
        cancel();
    }

    public static final /* synthetic */ void access$detachDrawable(CJPaySweepLightAnimator r100) {
        r100.detachDrawable();
    }

    public static final /* synthetic */ CJPaySweepLightConfig access$getConfig$p(CJPaySweepLightAnimator r100) {
        return r100.config;
    }

    public static final /* synthetic */ CJPaySweepLightDrawable access$getDrawable$p(CJPaySweepLightAnimator r100) {
        return r100.drawable;
    }

    public static final /* synthetic */ int access$getRunningTimes$p(CJPaySweepLightAnimator r100) {
        return r100.runningTimes;
    }

    public static final /* synthetic */ boolean access$isCancelled$p(CJPaySweepLightAnimator r100) {
        return r100.isCancelled;
    }

    public static final /* synthetic */ void access$scheduleNextRun(CJPaySweepLightAnimator r100) {
        r100.scheduleNextRun();
    }

    public static final /* synthetic */ void access$startSingleRun(CJPaySweepLightAnimator r100) {
        r100.startSingleRun();
    }

    private final void attachDrawable(View r100) {
        this.drawable.setBounds(0, 0, r100.getWidth(), r100.getHeight());
        if (this.attached == true) goto L6;
        r100.getOverlay().add(this.drawable);
        this.attached = true;
        return;
    }

    public CJPaySweepLightAnimator(View r100, CJPaySweepLightConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.config = r101;
        this.targetViewRef = new WeakReference(r100);
        this.drawable = new CJPaySweepLightDrawable(r101);
    }

    public static final /* synthetic */ void access$setRunningTimes$p(CJPaySweepLightAnimator r100, int r101) {
        r100.runningTimes = r101;
    }
}
