package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.bytedance.android.ui.ec.widget.photodraweeview.PhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransitionGestureHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB/\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000200H\u0016J\b\u00107\u001a\u000205H\u0016J\u0006\u00108\u001a\u00020\u001fJ\u0010\u00109\u001a\u0002052\u0006\u00106\u001a\u000200H\u0016J\u001a\u0010:\u001a\u0002052\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002050<R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0096\u000f¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u00020\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001c\u001a\u00020\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0018\u0010\u001e\u001a\u00020\u001fX\u0096\u000f¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010$\u001a\u00020\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010)\u001a\u00020*X\u0096\u000f¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020002j\b\u0012\u0004\u0012\u000200`3X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPhotoDraweeView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoDraweeView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/ITransitionParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "controllerImp", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionZoomableControllerImp;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionZoomableControllerImp;)V", "getExitRect", "Lkotlin/Function0;", "Landroid/graphics/Rect;", "getGetExitRect", "()Lkotlin/jvm/functions/Function0;", "setGetExitRect", "(Lkotlin/jvm/functions/Function0;)V", "isDragReturnAnimationEnabled", "", "()Z", "setDragReturnAnimationEnabled", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "maxDragTransitionFactor", "", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "startRect", "getStartRect", "()Landroid/graphics/Rect;", "setStartRect", "(Landroid/graphics/Rect;)V", "transitionAnimationDuration", "", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "transitionListenerWrapper", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "addTransitionListener", "", "listener", "dismissAnimated", "getScaleFactor", "removeTransitionListener", "setZoomListener", "scaleListener", "Lkotlin/Function1;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionPhotoDraweeView extends PhotoDraweeView implements TransitionView, ITransitionParams {
    private final TransitionZoomableControllerImp controllerImp;
    private final TransitionListener transitionListenerWrapper;
    private final LinkedHashSet<TransitionListener> transitionListeners;

    public TransitionPhotoDraweeView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public Function0<Rect> getGetExitRect() {
        return this.controllerImp.getGetExitRect();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public float getMaxDragTransitionFactor() {
        return this.controllerImp.getMaxDragTransitionFactor();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public Rect getStartRect() {
        return this.controllerImp.getStartRect();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public long getTransitionAnimationDuration() {
        return this.controllerImp.getTransitionAnimationDuration();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isDragReturnAnimationEnabled() {
        return this.controllerImp.isDragReturnAnimationEnabled();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isDragTransitionEnabled() {
        return this.controllerImp.isDragTransitionEnabled();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isSingleTagDismissEnabled() {
        return this.controllerImp.isSingleTagDismissEnabled();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setDragReturnAnimationEnabled(boolean r100) {
        this.controllerImp.setDragReturnAnimationEnabled(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setDragTransitionEnabled(boolean r100) {
        this.controllerImp.setDragTransitionEnabled(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setGetExitRect(Function0<Rect> r100) {
        this.controllerImp.setGetExitRect(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setMaxDragTransitionFactor(float r100) {
        this.controllerImp.setMaxDragTransitionFactor(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setSingleTagDismissEnabled(boolean r100) {
        this.controllerImp.setSingleTagDismissEnabled(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setStartRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.controllerImp.setStartRect(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setTransitionAnimationDuration(long r100) {
        this.controllerImp.setTransitionAnimationDuration(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void dismissAnimated() {
        this.controllerImp.dismissAnimated();
    }

    public final float getScaleFactor() {
        return this.controllerImp.getScaleFactor();
    }

    public static final /* synthetic */ TransitionZoomableControllerImp access$getControllerImp$p(TransitionPhotoDraweeView r100) {
        return r100.controllerImp;
    }

    public static final /* synthetic */ LinkedHashSet access$getTransitionListeners$p(TransitionPhotoDraweeView r100) {
        return r100.transitionListeners;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void addTransitionListener(TransitionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.transitionListeners.add(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void removeTransitionListener(TransitionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.transitionListeners.remove(r100);
    }

    public final void setZoomListener(final Function1<? super Float, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleListener");
        final ZoomableController.Listener r101 = this.controllerImp.getListener();
        this.controllerImp.setListener(new AnonymousClass1(this, r101, r100));
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, new TransitionZoomableControllerImp(new TransformGestureDetector(), r100));
    }

    private TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102, TransitionZoomableControllerImp r103) {
        super(r100, r101, r102, false);
        this.controllerImp = r103;
        this.transitionListeners = new LinkedHashSet();
        TransitionListener r104 = new TransitionPhotoDraweeView$transitionListenerWrapper$1(this);
        this.transitionListenerWrapper = r104;
        r103.addTransitionListener(r104);
        setZoomableControllerImp(r103);
        setGestureHandler(new TransitionGestureHandler(r103));
    }

    public /* synthetic */ TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public /* synthetic */ TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102, TransitionZoomableControllerImp r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = new TransitionZoomableControllerImp(new TransformGestureDetector(), r100);
    L11:
        this(r100, r101, r102, r103);
    }
}
