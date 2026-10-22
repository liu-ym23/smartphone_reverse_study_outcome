package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ScrollingView;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.DefaultGestureHandler;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListenerWrapper;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010S\u001a\u00020\u00182\u0018\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0015J\u0012\u0010U\u001a\u00020\u00182\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\u0010\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\bH\u0016J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010[\u001a\u00020\bH\u0016J\b\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020\u0018H\u0016J\b\u0010^\u001a\u00020\bH\u0016J\b\u0010_\u001a\u00020\bH\u0016J\b\u0010`\u001a\u00020\bH\u0016J\b\u0010a\u001a\u0004\u0018\u00010\u0017J\u0012\u0010b\u001a\u00020\u00182\b\u0010c\u001a\u0004\u0018\u00010\u0017H\u0004J\u0010\u0010d\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u0017H\u0004J\u001a\u0010e\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010f\u001a\u00020\u00182\u0006\u0010g\u001a\u00020hH\u0014J\b\u0010i\u001a\u00020\u0018H\u0002J0\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\n2\u0006\u0010l\u001a\u00020\b2\u0006\u0010m\u001a\u00020\b2\u0006\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\bH\u0014J\b\u0010p\u001a\u00020\u0018H\u0002J\u0010\u0010q\u001a\u00020\n2\u0006\u0010r\u001a\u00020sH\u0016J \u0010t\u001a\u00020\u00182\u0018\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0015J\u0012\u0010u\u001a\u00020\u00182\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\u0012\u0010v\u001a\u00020\u00182\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0010\u0010w\u001a\u00020\u00182\u0006\u0010x\u001a\u00020)H\u0004J\u000e\u0010y\u001a\u00020\u00182\u0006\u0010z\u001a\u00020\nJ\u0010\u0010{\u001a\u00020\u00182\u0006\u0010O\u001a\u00020PH\u0004J\b\u0010|\u001a\u00020\u0018H\u0002J\b\u0010}\u001a\u00020\u0018H\u0004R&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010.\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R$\u00104\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u000e\u00106\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00108\u001a\u0002072\u0006\u0010\f\u001a\u0002078F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R&\u0010=\u001a\u0002072\u0006\u0010\f\u001a\u0002078F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R*\u0010A\u001a\u0004\u0018\u00010@2\b\u0010\f\u001a\u0004\u0018\u00010@8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER*\u0010G\u001a\u0004\u0018\u00010F2\b\u0010\f\u001a\u0004\u0018\u00010F8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoDraweeView;", "Lcom/facebook/drawee/view/GenericDraweeView;", "Landroidx/core/view/ScrollingView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "needSetupZoomController", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "value", "", "animationDuration", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "boundsChangeListeners", "", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/RectF;", "", "callback", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IPhotoDraweeViewCallback;", "getCallback", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/IPhotoDraweeViewCallback;", "setCallback", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/IPhotoDraweeViewCallback;)V", "controllerListener", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "getControllerListener", "()Lcom/facebook/drawee/controller/BaseControllerListener;", "setControllerListener", "(Lcom/facebook/drawee/controller/BaseControllerListener;)V", "controllerListenerInternal", "Lcom/facebook/drawee/controller/ControllerListener;", "defaultGestureHandler", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;", "gestureDetector", "Landroid/view/GestureDetector;", "hasSetImage", "imageBounds", "isDoubleClickScaleEnabled", "()Z", "setDoubleClickScaleEnabled", "(Z)V", "isScaleEnabled", "setScaleEnabled", "isTranslationEnabled", "setTranslationEnabled", "lastImageBounds", "", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "scaleFactorRetriever", "getScaleFactorRetriever", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "setScaleFactorRetriever", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;)V", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "tapListener", "getTapListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "setTapListener", "(Landroid/view/GestureDetector$SimpleOnGestureListener;)V", "tapListenerWrapper", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListenerWrapper;", "viewBounds", "zoomableController", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;", "zoomableListener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableController$Listener;", "addBoundsChangeListener", "listener", "addControllerListener", "controller", "Lcom/facebook/drawee/interfaces/DraweeController;", "canScrollVertically", "direction", "computeHorizontalScrollExtent", "computeHorizontalScrollOffset", "computeHorizontalScrollRange", "computeScroll", "computeVerticalScrollExtent", "computeVerticalScrollOffset", "computeVerticalScrollRange", "getAvailableImageBounds", "getImageBounds", "outBounds", "getLimitBounds", "inflateHierarchy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFinalImageSet", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onRelease", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "removeBoundsChangeListener", "removeControllerListener", "setController", "setGestureHandler", "gestureHandler", "setHorizontalNestedScrollEnabled", "enabled", "setZoomableControllerImp", "setupZoomController", "updateZoomableControllerBounds", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoDraweeView extends GenericDraweeView implements ScrollingView {
    private long animationDuration;
    private final Set<Function2<View, RectF, Unit>> boundsChangeListeners;
    private IPhotoDraweeViewCallback callback;
    private BaseControllerListener<Object> controllerListener;
    private final ControllerListener<Object> controllerListenerInternal;
    private DefaultGestureHandler defaultGestureHandler;
    private GestureDetector gestureDetector;
    private boolean hasSetImage;
    private final RectF imageBounds;
    private boolean isDoubleClickScaleEnabled;
    private boolean isScaleEnabled;
    private boolean isTranslationEnabled;
    private final RectF lastImageBounds;
    private float maxScaleFactor;
    private float minScaleFactor;
    private ScaleFactorRetriever scaleFactorRetriever;
    private GestureDetector.SimpleOnGestureListener tapListener;
    private GestureListenerWrapper tapListenerWrapper;
    private final RectF viewBounds;
    private ZoomableControllerImp zoomableController;
    private final ZoomableController.Listener zoomableListener;

    public PhotoDraweeView(Context r100) {
        this(r100, null, 0, false, 14, null);
    }

    public PhotoDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, false, 12, null);
    }

    public PhotoDraweeView(Context r100, AttributeSet r101, int r110) {
        this(r100, r101, r110, false, 8, null);
    }

    private final void onFinalImageSet() {
        this.hasSetImage = true;
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        if (r100.isEnabled() == true) goto L12;
        ZoomableControllerImp r101 = this.zoomableController;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L10:
        r101.setEnabled(true);
        updateZoomableControllerBounds();
        return;
    }

    private final void onRelease() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r100.setEnabled(false);
    }

    private final void setupZoomController() {
        ZoomableControllerImp r100 = new ZoomableControllerImp(new TransformGestureDetector(), getContext());
        setZoomableControllerImp(r100);
        setGestureHandler(new DefaultGestureHandler(r100));
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r100.computeScroll();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.computeVerticalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.computeVerticalScrollRange();
    }

    public final long getAnimationDuration() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.getAnimationDuration();
    }

    public final RectF getAvailableImageBounds() {
        if (this.hasSetImage == true) goto L7;
        return null;
    L7:
        return this.imageBounds;
    }

    public final float getMaxScaleFactor() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.getMaxScaleFactor();
    }

    public final float getMinScaleFactor() {
        ZoomableControllerImp r100 = this.zoomableController;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r100.getMinScaleFactor();
    }

    public final GestureDetector.SimpleOnGestureListener getTapListener() {
        GestureListenerWrapper r100 = this.tapListenerWrapper;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L6:
        return r100.getListener();
    }

    public final boolean isDoubleClickScaleEnabled() {
        DefaultGestureHandler r100 = this.defaultGestureHandler;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L6:
        return r100.isDoubleClickScaleEnabled();
    }

    public final void updateZoomableControllerBounds() {
        getImageBounds(this.imageBounds);
        getLimitBounds(this.viewBounds);
        IPhotoDraweeViewCallback.Companion r100 = IPhotoDraweeViewCallback.Companion;
        r100.getTempRect().set(this.imageBounds);
        IPhotoDraweeViewCallback r101 = this.callback;
        if (r101 == null) goto L5;
        r101.configTransform(this, r100.getTempRect());
    L5:
        IPhotoDraweeViewCallback r102 = this.callback;
        if (r102 == null) goto L10;
        Matrix r103 = r102.getDefaultTransform();
        if (r103 == null) goto L10;
        r103.mapRect(this.imageBounds);
    L10:
        ZoomableControllerImp r104 = this.zoomableController;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L13:
        r104.setImageBounds(this.imageBounds);
        ZoomableControllerImp r105 = this.zoomableController;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L16:
        r105.setViewBounds(this.viewBounds);
        if ((!Intrinsics.areEqual(this.lastImageBounds, this.imageBounds)) == false) goto L24;
        this.lastImageBounds.set(this.imageBounds);
        if (this.hasSetImage == false) goto L26;
        Iterator<T> r106 = this.boundsChangeListeners.iterator();
    L22:
        if (r106.hasNext() == false) goto L27;
        ((Function2) r106.next()).invoke(this, this.imageBounds);
        goto L22
    L27:
        return;
    L26:
        return;
    }

    public final IPhotoDraweeViewCallback getCallback() {
        return this.callback;
    }

    public final BaseControllerListener<Object> getControllerListener() {
        return this.controllerListener;
    }

    public final ScaleFactorRetriever getScaleFactorRetriever() {
        return this.scaleFactorRetriever;
    }

    public final boolean isScaleEnabled() {
        return this.isScaleEnabled;
    }

    public final boolean isTranslationEnabled() {
        return this.isTranslationEnabled;
    }

    public static final /* synthetic */ DefaultGestureHandler access$getDefaultGestureHandler$p(PhotoDraweeView r100) {
        DefaultGestureHandler r101 = r100.defaultGestureHandler;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        return r101;
    }

    public static final /* synthetic */ void access$onFinalImageSet(PhotoDraweeView r100) {
        r100.onFinalImageSet();
    }

    public static final /* synthetic */ void access$onRelease(PhotoDraweeView r100) {
        r100.onRelease();
    }

    private final void addControllerListener(DraweeController r100) {
        if ((r100 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r100).addControllerListener(this.controllerListenerInternal);
        return;
    }

    private final void removeControllerListener(DraweeController r100) {
        if ((r100 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r100).removeControllerListener(this.controllerListenerInternal);
        return;
    }

    public final void addBoundsChangeListener(Function2<? super View, ? super RectF, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.boundsChangeListeners.add(r100);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r100) {
        return super.canScrollVertically(r100);
    }

    public final void getImageBounds(RectF r100) {
        getHierarchy().getActualImageBounds(r100);
    }

    public final void getLimitBounds(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "outBounds");
        r100.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        ZoomableControllerImp r102 = this.zoomableController;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r100.concat(r102.getActiveTransform());
        IPhotoDraweeViewCallback r103 = this.callback;
        if (r103 == null) goto L10;
        Matrix r104 = r103.getDefaultTransform();
        if (r104 == null) goto L10;
        r100.concat(r104);
    L10:
        super.onDraw(r100);
        r100.restoreToCount(r101);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.onTouchEvent(r100);
        GestureDetector r101 = this.gestureDetector;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L5:
        r101.onTouchEvent(r100);
        ZoomableControllerImp r102 = this.zoomableController;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L9:
        if (r102.onTouchEvent(r100) == false) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        getParent().requestDisallowInterceptTouchEvent(false);
        MotionEvent r103 = MotionEvent.obtain(r100);
        r103.setAction(3);
        GestureDetector r104 = this.gestureDetector;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L15:
        r104.onTouchEvent(r103);
        ZoomableControllerImp r105 = this.zoomableController;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L18:
        r105.onTouchEvent(r103);
        r103.recycle();
        return false;
    }

    public final void removeBoundsChangeListener(Function2<? super View, ? super RectF, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.boundsChangeListeners.remove(r100);
    }

    public final void setAnimationDuration(long r100) {
        this.animationDuration = r100;
        ZoomableControllerImp r101 = this.zoomableController;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r101.setAnimationDuration(r100);
    }

    public final void setCallback(IPhotoDraweeViewCallback r100) {
        this.callback = r100;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(DraweeController r100) {
        removeControllerListener(getController());
        addControllerListener(r100);
        super.setController(r100);
    }

    public final void setControllerListener(BaseControllerListener<Object> r100) {
        this.controllerListener = r100;
    }

    public final void setDoubleClickScaleEnabled(boolean r100) {
        DefaultGestureHandler r101 = this.defaultGestureHandler;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        r101.setDoubleClickScaleEnabled(r100);
        this.isDoubleClickScaleEnabled = r100;
    }

    public final void setGestureHandler(DefaultGestureHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "gestureHandler");
        this.defaultGestureHandler = r100;
        DefaultGestureHandler r101 = this.defaultGestureHandler;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        this.tapListenerWrapper = new GestureListenerWrapper(r101);
        Context r102 = getContext();
        GestureListenerWrapper r103 = this.tapListenerWrapper;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L8:
        GestureDetector r104 = new GestureDetector(r102, r103);
        this.gestureDetector = r104;
        r104.setIsLongpressEnabled(true);
        r100.setScaleFactorRetriever(getScaleFactorRetriever());
    }

    public final void setHorizontalNestedScrollEnabled(boolean r100) {
        ZoomableControllerImp r101 = this.zoomableController;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r101.setHorizontalNestedScrollEnabled(r100);
    }

    public final void setMaxScaleFactor(float r100) {
        this.maxScaleFactor = r100;
        ZoomableControllerImp r101 = this.zoomableController;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r101.setMaxScaleFactor(r100);
    }

    public final void setMinScaleFactor(float r100) {
        this.minScaleFactor = r100;
        ZoomableControllerImp r101 = this.zoomableController;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r101.setMinScaleFactor(r100);
    }

    public final void setScaleEnabled(boolean r100) {
        this.isScaleEnabled = r100;
        ZoomableControllerImp r101 = this.zoomableController;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r101.setScaleEnabled(r100);
    }

    public final void setScaleFactorRetriever(ScaleFactorRetriever r100) {
        this.scaleFactorRetriever = r100;
        DefaultGestureHandler r101 = this.defaultGestureHandler;
        if (r101 == null) goto L8;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L6:
        r101.setScaleFactorRetriever(r100);
        return;
    }

    public final void setTapListener(GestureDetector.SimpleOnGestureListener r100) {
        GestureListenerWrapper r101 = this.tapListenerWrapper;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L5:
        r101.setListener(r100);
        this.tapListener = r100;
    }

    public final void setTranslationEnabled(boolean r100) {
        this.isTranslationEnabled = r100;
        ZoomableControllerImp r101 = this.zoomableController;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r101.setTranslationEnabled(r100);
    }

    public final void setZoomableControllerImp(ZoomableControllerImp r100) {
        Intrinsics.checkNotNullParameter(r100, "zoomableController");
        this.zoomableController = r100;
        r100.setListener(this.zoomableListener);
        setScaleFactorRetriever(new DefaultScaleFactorRetrieverImp(r100));
    }

    public static final /* synthetic */ void access$setDefaultGestureHandler$p(PhotoDraweeView r100, DefaultGestureHandler r101) {
        r100.defaultGestureHandler = r101;
    }

    @Override // com.facebook.drawee.view.GenericDraweeView
    public void inflateHierarchy(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GenericDraweeHierarchyBuilder r102 = new GenericDraweeHierarchyBuilder(r100.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchyInflater.updateBuilder(r102, r100, r101);
        setAspectRatio(r102.getDesiredAspectRatio());
        setHierarchy(r102.build());
    }

    public PhotoDraweeView(Context r100, AttributeSet r101, int r102, boolean r103) {
        super(r100, r101, r102);
        this.imageBounds = new RectF();
        this.viewBounds = new RectF();
        this.isDoubleClickScaleEnabled = true;
        this.maxScaleFactor = 1.0f;
        this.minScaleFactor = 1.0f;
        this.controllerListenerInternal = new PhotoDraweeView$controllerListenerInternal$1(this);
        this.zoomableListener = new PhotoDraweeView$zoomableListener$1(this);
        if (r103 == false) goto L5;
        setupZoomController();
    L5:
        this.isScaleEnabled = true;
        this.isTranslationEnabled = true;
        this.lastImageBounds = new RectF();
        this.boundsChangeListeners = new LinkedHashSet();
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        updateZoomableControllerBounds();
    }

    public /* synthetic */ PhotoDraweeView(Context r100, AttributeSet r101, int r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = true;
    L11:
        this(r100, r101, r102, r103);
    }
}
