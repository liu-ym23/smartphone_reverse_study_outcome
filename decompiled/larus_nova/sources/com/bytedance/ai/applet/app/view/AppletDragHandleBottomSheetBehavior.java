package com.bytedance.ai.applet.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J!\u0010\u001b\u001a\u00020\f*\u00020\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u001dH\u0082\bJ8\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010H\u0016R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletDragHandleBottomSheetBehavior;", "Lcom/bytedance/ai/view/popup/anim/BottomSheetBehavior;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dragRegionViewRef", "Ljava/lang/ref/WeakReference;", "touchStartedInDragRegion", "", "touchEventOffsetY", "", "gestureStartSheetTop", "", "setDragRegionView", "", "view", "onInterceptTouchEvent", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "event", "Landroid/view/MotionEvent;", "onTouchEvent", "offsetForBottomSheet", "block", "Lkotlin/Function1;", "onStartNestedScroll", "coordinatorLayout", "directTargetChild", PickerReporterConstants.KEY.TARGET, "axes", "type", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDragHandleBottomSheetBehavior extends BottomSheetBehavior<View> {
    public WeakReference<View> W;
    public boolean X;
    public float Y;
    public int Z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    public AppletDragHandleBottomSheetBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r102.getActionMasked() != 0) goto L19;
        WeakReference<View> r103 = this.W;
        if (r103 == null) goto L7;
        View r104 = r103.get();
    L8:
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        this.X = r105;
        if (r105 == false) goto L16;
        this.Z = r101.getTop();
        float r106 = (r101.getTop() - r102.getY()) + 1.0f;
    L17:
        this.Y = r106;
        goto L19
    L16:
        r106 = 0.0f;
        goto L17
    L10:
        if (r100.isPointInChildBounds(r104, (int) r102.getX(), (int) r102.getY()) == false) goto L12;
        r105 = true;
        goto L13
    L7:
        r104 = null;
    L19:
        if (this.X == true) goto L21;
        return false;
    L21:
        MotionEvent r107 = MotionEvent.obtain(r102);
        r107.offsetLocation(0.0f, this.Y);
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L29
        boolean r108 = super.onInterceptTouchEvent(r100, r101, r107);     // Catch: Throwable -> L29
        r107.recycle();
        if (r102.getActionMasked() != 1) goto L26;
    L27:
        this.X = false;
        this.Y = 0.0f;
    L28:
        return r108;
    L26:
        if (r102.getActionMasked() != 3) goto L28;
    L29:
        th = move-exception;
        r107.recycle();
        throw th;
    }

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, View r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r111, "event");
        if (this.X == true) goto L5;
        return false;
    L5:
        int r101 = r111.getActionMasked();
        int r102 = 3;
        if (r101 == 1) goto L10;
        if (r101 == 3) goto L9;
        Integer r103 = null;
    L18:
        MotionEvent r112 = MotionEvent.obtain(r111);
        r112.offsetLocation(0.0f, this.Y);
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L24
        boolean r104 = super.onTouchEvent(r100, r110, r112);     // Catch: Throwable -> L24
        r112.recycle();
        if (r103 == null) goto L23;
        b(r103.intValue(), true);
        this.X = false;
        this.Y = 0.0f;
    L23:
        return r104;
    L24:
        th = move-exception;
        r112.recycle();
        throw th;
    L9:
        r103 = 3;
        goto L18
    L10:
        int r105 = r110.getTop() - this.Z;
        if (r105 < this.A) goto L13;
        boolean r106 = true;
    L14:
        com.bytedance.ai.utils.g.f37637a.i("AppletDragBehavior", "gesture released: dragDistance=" + r105 + ", closeThreshold=" + this.A + ", dismiss=" + r106);
        if (r106 == false) goto L17;
        r102 = 5;
    L17:
        r103 = Integer.valueOf(r102);
        goto L18
    L13:
        r106 = false;
        goto L14
    }
}
