package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.shape.q;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    private static WeakReference<View> capturedSharedElement;
    private boolean entering;
    private Rect returnEndBounds;
    private a shapeProvider;
    private boolean sharedElementReenterTransitionEnabled;
    private boolean transparentWindowBackgroundEnabled;

    public interface a {
        com.google.android.material.shape.m a(View r1);
    }

    public static class b implements a {
        public b() {
        }

        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.a
        public com.google.android.material.shape.m a(View r2) {
            if (ZeusTransformUtils.instanceOf(r2, q.class) == true) goto L7;
            return null;
        L7:
            return ((q) ZeusTransformUtils.preCheckCast(r2, q.class, "com.obric.aiagent.plugin")).getShapeAppearanceModel();
        }
    }

    public MaterialContainerTransformSharedElementCallback() {
        this.entering = true;
        this.transparentWindowBackgroundEnabled = true;
        this.sharedElementReenterTransitionEnabled = false;
        this.shapeProvider = new b();
    }

    static /* synthetic */ void access$000(Window r0) {
        removeWindowBackground(r0);
    }

    static /* synthetic */ void access$100(Window r0) {
        restoreWindowBackground(r0);
    }

    static /* synthetic */ WeakReference access$200() {
        return capturedSharedElement;
    }

    static /* synthetic */ WeakReference access$202(WeakReference r0) {
        capturedSharedElement = r0;
        return r0;
    }

    @Override // android.app.SharedElementCallback
    public Parcelable onCaptureSharedElementSnapshot(View r2, Matrix r3, RectF r4) {
        capturedSharedElement = new WeakReference(r2);
        return super.onCaptureSharedElementSnapshot(r2, r3, r4);
    }

    @Override // android.app.SharedElementCallback
    public View onCreateSnapshotView(Context r3, Parcelable r4) {
        View r5 = super.onCreateSnapshotView((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L13;
        WeakReference<View> r6 = capturedSharedElement;
        if (r6 == null) goto L13;
        if (this.shapeProvider == null) goto L13;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.get(), View.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        com.google.android.material.shape.m r2 = this.shapeProvider.a(r7);
        if (r2 == null) goto L13;
        r5.setTag(ZeusTransformUtils.mapRes(R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view"), r2);
    L13:
        return r5;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(List<String> r3, Map<String, View> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L16;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.get(r5.get(0)), View.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.internal.c.getActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L18;
        Window r9 = ZeusTransformUtils.getWindow(r8, "com.obric.aiagent.plugin");
        if (this.entering == false) goto L13;
        setUpEnterTransform(r9);
        return;
    L13:
        setUpReturnTransform(r8, r9);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(List<String> r6, List<View> r7, List<View> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r10.isEmpty() == true) goto L8;
        if (r11.isEmpty() == true) goto L8;
        ((View) ZeusTransformUtils.preCheckCast(r10.get(0), View.class, "com.obric.aiagent.plugin")).setTag(ZeusTransformUtils.mapRes(R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view"), r11.get(0));
    L8:
        if (this.entering == false) goto L10;
        return;
    L10:
        if (r10.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.returnEndBounds == null) goto L17;
        View r12 = (View) ZeusTransformUtils.preCheckCast(r10.get(0), View.class, "com.obric.aiagent.plugin");
        r12.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
        r12.layout(this.returnEndBounds.left, this.returnEndBounds.top, this.returnEndBounds.right, this.returnEndBounds.bottom);
        return;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(List<String> r5, List<View> r6, List<View> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r9.isEmpty() == true) goto L8;
        if (ZeusTransformUtils.instanceOf(((View) ZeusTransformUtils.preCheckCast(r9.get(0), View.class, "com.obric.aiagent.plugin")).getTag(ZeusTransformUtils.mapRes(R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view")), View.class) == false) goto L8;
        ((View) ZeusTransformUtils.preCheckCast(r9.get(0), View.class, "com.obric.aiagent.plugin")).setTag(ZeusTransformUtils.mapRes(R.id.mtrl_motion_snapshot_view, DbHelper.COL_ID, "mtrl_motion_snapshot_view"), null);
    L8:
        if (this.entering == false) goto L10;
    L12:
        this.entering = false;
        return;
    L10:
        if (r9.isEmpty() == true) goto L12;
        this.returnEndBounds = l.b((View) ZeusTransformUtils.preCheckCast(r9.get(0), View.class, "com.obric.aiagent.plugin"));
        goto L12
    }

    public a getShapeProvider() {
        return this.shapeProvider;
    }

    public void setShapeProvider(a r3) {
        this.shapeProvider = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    public void setTransparentWindowBackgroundEnabled(boolean r1) {
        this.transparentWindowBackgroundEnabled = r1;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public void setSharedElementReenterTransitionEnabled(boolean r1) {
        this.sharedElementReenterTransitionEnabled = r1;
    }

    private void setUpEnterTransform(final Window r4) {
        Transition r0 = r4.getSharedElementEnterTransition();
        if (ZeusTransformUtils.instanceOf(r0, MaterialContainerTransform.class) == false) goto L11;
        MaterialContainerTransform r1 = (MaterialContainerTransform) ZeusTransformUtils.preCheckCast(r0, MaterialContainerTransform.class, "com.obric.aiagent.plugin");
        if (this.sharedElementReenterTransitionEnabled == true) goto L8;
        r4.setSharedElementReenterTransition(null);
    L8:
        if (this.transparentWindowBackgroundEnabled == false) goto L12;
        updateBackgroundFadeDuration(r4, r1);
        r1.addListener(new AnonymousClass1(this, r4));
        return;
    L12:
        return;
    }

    private void setUpReturnTransform(Activity r4, final Window r5) {
        final Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        Transition r0 = r5.getSharedElementReturnTransition();
        if (ZeusTransformUtils.instanceOf(r0, MaterialContainerTransform.class) == false) goto L8;
        MaterialContainerTransform r1 = (MaterialContainerTransform) ZeusTransformUtils.preCheckCast(r0, MaterialContainerTransform.class, "com.obric.aiagent.plugin");
        r1.setHoldAtEndEnabled(true);
        r1.addListener(new AnonymousClass2(this, r6));
        if (this.transparentWindowBackgroundEnabled == false) goto L9;
        updateBackgroundFadeDuration(r5, r1);
        r1.addListener(new AnonymousClass3(this, r5));
        return;
    L9:
        return;
    }

    private static void removeWindowBackground(Window r2) {
        Drawable r3 = getWindowBackground(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        r3.mutate().setColorFilter(androidx.core.graphics.b.a(0, androidx.core.graphics.c.f1193a));
    }

    private static void restoreWindowBackground(Window r0) {
        Drawable r1 = getWindowBackground(r0);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.mutate().clearColorFilter();
    }

    private static Drawable getWindowBackground(Window r0) {
        return r0.getDecorView().getBackground();
    }

    private static void updateBackgroundFadeDuration(Window r4, MaterialContainerTransform r5) {
        if (r5.getDuration() < 0) goto L6;
        r4.setTransitionBackgroundFadeDuration(r5.getDuration());
        return;
    }
}
