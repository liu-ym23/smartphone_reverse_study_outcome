package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ScrollingView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0004J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0004J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\rR*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010 \u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020!8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/PhotoDraweeView;", "Lcom/facebook/drawee/view/GenericDraweeView;", "Landroidx/core/view/ScrollingView;", "Lba2/a;", "gestureHandler", "", "setGestureHandler", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/ZoomableControllerImp;", "zoomableController", "setZoomableControllerImp", "Lcom/facebook/drawee/interfaces/DraweeController;", "controller", "setController", "Landroid/graphics/RectF;", "getAvailableImageBounds", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "f", "Lcom/facebook/drawee/controller/BaseControllerListener;", "getControllerListener", "()Lcom/facebook/drawee/controller/BaseControllerListener;", "setControllerListener", "(Lcom/facebook/drawee/controller/BaseControllerListener;)V", "controllerListener", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/e;", "value", "h", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/e;", "getScaleFactorRetriever", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/e;", "setScaleFactorRetriever", "(Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/e;)V", "scaleFactorRetriever", "", "isDoubleClickScaleEnabled", "Z", "()Z", "setDoubleClickScaleEnabled", "(Z)V", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/d;", "callback", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/d;", "getCallback", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/d;", "setCallback", "(Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/d;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoDraweeView extends GenericDraweeView implements ScrollingView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f139292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f139293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ZoomableControllerImp f139294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GestureDetector f139295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ba2.c f139296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseControllerListener<Object> f139297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ba2.a f139298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f139299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f139300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f139301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f139302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f139303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<Function2<View, RectF, Unit>> f139304m;

    public static final class a extends BaseControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoDraweeView f139305a;

        public a(PhotoDraweeView r100) {
            this.f139305a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            ZoomableControllerImp r101 = this.f139305a.f139294c;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        L5:
            r101.b(false);
            BaseControllerListener<Object> r102 = this.f139305a.getControllerListener();
            if (r102 == null) goto L9;
            r102.onRelease(r100);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            super.onFailure(r100, r101);
            BaseControllerListener<Object> r102 = this.f139305a.getControllerListener();
            if (r102 == null) goto L6;
            r102.onFailure(r100, r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
            super.onIntermediateImageFailed(r100, r101);
            BaseControllerListener<Object> r102 = this.f139305a.getControllerListener();
            if (r102 == null) goto L6;
            r102.onIntermediateImageFailed(r100, r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super.onIntermediateImageSet(r100, r101);
            BaseControllerListener<Object> r102 = this.f139305a.getControllerListener();
            if (r102 == null) goto L6;
            r102.onIntermediateImageSet(r100, r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
            super.onSubmit(r100, r101);
            BaseControllerListener<Object> r102 = this.f139305a.getControllerListener();
            if (r102 == null) goto L6;
            r102.onSubmit(r100, r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            PhotoDraweeView r103 = this.f139305a;
            r103.f139302k = true;
            ZoomableControllerImp r104 = r103.f139294c;
            if (r104 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        L6:
            if (r104.f139330c == true) goto L11;
            ZoomableControllerImp r105 = r103.f139294c;
            if (r105 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
        L10:
            r105.b(true);
            r103.updateZoomableControllerBounds();
        L11:
            BaseControllerListener<Object> r106 = this.f139305a.getControllerListener();
            if (r106 == null) goto L15;
            r106.onFinalImageSet(r100, r101, r102);
            return;
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoDraweeView f139306a;

        public b(PhotoDraweeView r100) {
            this.f139306a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.publicscreen.preview.f
        public final void a() {
            this.f139306a.invalidate();
        }
    }

    public PhotoDraweeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PhotoDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final d getCallback() {
        return null;
    }

    public final void setCallback(d r100) {
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollExtent() {
        ZoomableControllerImp r100 = this.f139294c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) r100.f139332e.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollOffset() {
        ZoomableControllerImp r100 = this.f139294c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) (r100.f139332e.left - r100.f139334g.left);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollRange() {
        ZoomableControllerImp r100 = this.f139294c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) r100.f139334g.width();
    }

    @Override // android.view.View
    public final void computeScroll() {
        ZoomableControllerImp r100 = this.f139294c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        if (r100.f139325t.computeScrollOffset() == false) goto L12;
        int r101 = r100.f139325t.getCurrX();
        int r102 = r100.f139325t.getCurrY();
        r100.f139319n.set(r100.f139321p);
        Matrix r103 = r100.f139319n;
        r103.postTranslate(r101, r102);
        r100.e(r103);
        Matrix r104 = r100.f139319n;
        if (r100.f139322q.isRunning() == false) goto L10;
        r100.j();
    L10:
        r100.f139320o.set(r104);
        r100.f139335h.set(r104);
        r100.a();
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollExtent() {
        ZoomableControllerImp r100 = this.f139294c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) r100.f139332e.height();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollOffset() {
        ZoomableControllerImp r100 = this.f139294c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) (r100.f139332e.top - r100.f139334g.top);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollRange() {
        ZoomableControllerImp r100 = this.f139294c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return (int) r100.f139334g.height();
    }

    public final RectF getAvailableImageBounds() {
        if (this.f139302k == true) goto L7;
        return null;
    L7:
        return this.f139292a;
    }

    public final void updateZoomableControllerBounds() {
        getHierarchy().getActualImageBounds(this.f139292a);
        RectF r100 = this.f139293b;
        Intrinsics.checkNotNullParameter(r100, "outBounds");
        r100.set(0.0f, 0.0f, getWidth(), getHeight());
        d.f139343a.getClass();
        d.a.f139344a.set(this.f139292a);
        ZoomableControllerImp r101 = this.f139294c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        RectF r102 = this.f139292a;
        if (r102 != null) goto L9;
        r101.getClass();
    L11:
        ZoomableControllerImp r103 = this.f139294c;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L14:
        r103.f139332e.set(this.f139293b);
        r103.c();
        if ((!Intrinsics.areEqual(this.f139303l, this.f139292a)) == false) goto L22;
        this.f139303l.set(this.f139292a);
        if (this.f139302k == false) goto L24;
        Iterator<T> r104 = this.f139304m.iterator();
    L20:
        if (r104.hasNext() == false) goto L25;
        ((Function2) r104.next()).invoke(this, this.f139292a);
        goto L20
    L25:
        return;
    L24:
        return;
    L22:
        return;
    L9:
        if (r102.equals(r101.f139333f) == true) goto L11;
        r101.f139333f.set(r102);
        r101.c();
        r101.a();
        goto L11
    }

    public final BaseControllerListener<Object> getControllerListener() {
        return this.f139297f;
    }

    public final e getScaleFactorRetriever() {
        return this.f139299h;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        return super.canScrollVertically(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        ZoomableControllerImp r102 = this.f139294c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r100.concat(r102.f139335h);
        super.onDraw(r100);
        r100.restoreToCount(r101);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.onTouchEvent(r100);
        GestureDetector r101 = this.f139295d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L5:
        r101.onTouchEvent(r100);
        ZoomableControllerImp r102 = this.f139294c;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L9:
        if (r102.h(r100) == false) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        getParent().requestDisallowInterceptTouchEvent(false);
        MotionEvent r103 = MotionEvent.obtain(r100);
        r103.setAction(3);
        GestureDetector r104 = this.f139295d;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L15:
        r104.onTouchEvent(r103);
        ZoomableControllerImp r105 = this.f139294c;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L18:
        r105.h(r103);
        r103.recycle();
        return false;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(DraweeController r100) {
        DraweeController r101 = getController();
        if ((r101 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r101).removeControllerListener(this.f139300i);
    L6:
        if ((r100 instanceof AbstractDraweeController) == false) goto L8;
        ((AbstractDraweeController) r100).addControllerListener(this.f139300i);
    L8:
        super.setController(r100);
    }

    public final void setControllerListener(BaseControllerListener<Object> r100) {
        this.f139297f = r100;
    }

    public final void setDoubleClickScaleEnabled(boolean r100) {
        ba2.a r101 = this.f139298g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        r101.f18385c = r100;
    }

    public final void setGestureHandler(ba2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "gestureHandler");
        this.f139298g = r100;
        ba2.a r101 = this.f139298g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        this.f139296e = new ba2.c(r101);
        Context r102 = getContext();
        ba2.c r103 = this.f139296e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L8:
        GestureDetector r104 = new GestureDetector(r102, r103);
        this.f139295d = r104;
        r104.setIsLongpressEnabled(true);
        r100.f18384b = getScaleFactorRetriever();
    }

    public final void setScaleFactorRetriever(e r100) {
        this.f139299h = r100;
        ba2.a r101 = this.f139298g;
        if (r101 == null) goto L8;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L6:
        r101.f18384b = r100;
        return;
    }

    public final void setZoomableControllerImp(ZoomableControllerImp r100) {
        Intrinsics.checkNotNullParameter(r100, "zoomableController");
        this.f139294c = r100;
        r100.f139329b = this.f139301j;
        setScaleFactorRetriever(new com.bytedance.android.livesdk.interactivity.publicscreen.preview.b(r100));
    }

    @Override // com.facebook.drawee.view.GenericDraweeView
    public final void inflateHierarchy(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GenericDraweeHierarchyBuilder r102 = new GenericDraweeHierarchyBuilder(r100.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchyInflater.updateBuilder(r102, r100, r101);
        setAspectRatio(r102.getDesiredAspectRatio());
        setHierarchy(r102.build());
    }

    public PhotoDraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f139292a = new RectF();
        this.f139293b = new RectF();
        this.f139300i = new a(this);
        this.f139301j = new b(this);
        this.f139303l = new RectF();
        this.f139304m = new LinkedHashSet();
    }

    public /* synthetic */ PhotoDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        updateZoomableControllerBounds();
    }
}
