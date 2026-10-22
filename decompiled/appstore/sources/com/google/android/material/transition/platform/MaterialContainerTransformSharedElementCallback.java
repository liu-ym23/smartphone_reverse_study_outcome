package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.a;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.common.primitives.Ints;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {

    @Nullable
    private static WeakReference<View> capturedSharedElement;
    private boolean entering;

    @Nullable
    private Rect returnEndBounds;

    @Nullable
    private ShapeProvider shapeProvider;
    private boolean sharedElementReenterTransitionEnabled;
    private boolean transparentWindowBackgroundEnabled;

    public interface ShapeProvider {
        @Nullable
        ShapeAppearanceModel provideShape(@NonNull View r10);
    }

    public static class ShapeableViewShapeProvider implements ShapeProvider {
        public ShapeableViewShapeProvider() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        @Nullable
        public ShapeAppearanceModel provideShape(@NonNull View r10) {
            if ((r10 instanceof Shapeable) == true) goto L7;
            return null;
        L7:
            return ((Shapeable) r10).getShapeAppearanceModel();
        }
    }

    public MaterialContainerTransformSharedElementCallback() {
        this.entering = true;
        this.transparentWindowBackgroundEnabled = true;
        this.sharedElementReenterTransitionEnabled = false;
        this.shapeProvider = new ShapeableViewShapeProvider();
    }

    public static /* synthetic */ void access$000(Window r10) {
        removeWindowBackground(r10);
    }

    public static /* synthetic */ void access$100(Window r10) {
        restoreWindowBackground(r10);
    }

    public static /* synthetic */ WeakReference access$200() {
        return capturedSharedElement;
    }

    public static /* synthetic */ WeakReference access$202(WeakReference r10) {
        capturedSharedElement = r10;
        return r10;
    }

    private static void removeWindowBackground(Window r10) {
        r10.getDecorView().getBackground().mutate().setColorFilter(a.a(0, BlendModeCompat.CLEAR));
    }

    private static void restoreWindowBackground(Window r10) {
        r10.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private void setUpEnterTransform(final Window r10) {
        Transition r11 = r10.getSharedElementEnterTransition();
        if ((r11 instanceof MaterialContainerTransform) == false) goto L11;
        MaterialContainerTransform r12 = (MaterialContainerTransform) r11;
        if (this.sharedElementReenterTransitionEnabled == true) goto L8;
        r10.setSharedElementReenterTransition(null);
    L8:
        if (this.transparentWindowBackgroundEnabled == false) goto L12;
        updateBackgroundFadeDuration(r10, r12);
        r12.addListener(new AnonymousClass1(this, r10));
        return;
    L12:
        return;
    }

    private void setUpReturnTransform(final Activity r10, final Window r11) {
        Transition r12 = r11.getSharedElementReturnTransition();
        if ((r12 instanceof MaterialContainerTransform) == false) goto L8;
        MaterialContainerTransform r13 = (MaterialContainerTransform) r12;
        r13.setHoldAtEndEnabled(true);
        r13.addListener(new AnonymousClass2(this, r10));
        if (this.transparentWindowBackgroundEnabled == false) goto L9;
        updateBackgroundFadeDuration(r11, r13);
        r13.addListener(new AnonymousClass3(this, r11));
        return;
    L9:
        return;
    }

    private static void updateBackgroundFadeDuration(Window r10, MaterialContainerTransform r11) {
        if (r11.getDuration() < 0) goto L6;
        r10.setTransitionBackgroundFadeDuration(r11.getDuration());
        return;
    }

    @Nullable
    public ShapeProvider getShapeProvider() {
        return this.shapeProvider;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View r10, @NonNull Matrix r11, @NonNull RectF r12) {
        capturedSharedElement = new WeakReference(r10);
        return super.onCaptureSharedElementSnapshot(r10, r11, r12);
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public View onCreateSnapshotView(@NonNull Context r10, @Nullable Parcelable r11) {
        View r12 = super.onCreateSnapshotView(r10, r11);
        if (r12 == null) goto L13;
        WeakReference<View> r13 = capturedSharedElement;
        if (r13 == null) goto L13;
        if (this.shapeProvider == null) goto L13;
        View r14 = r13.get();
        if (r14 == null) goto L13;
        ShapeAppearanceModel r15 = this.shapeProvider.provideShape(r14);
        if (r15 == null) goto L13;
        r12.setTag(R.id.mtrl_motion_snapshot_view, r15);
    L13:
        return r12;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@NonNull List<String> r10, @NonNull Map<String, View> r11) {
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L16;
        View r12 = r11.get(r10.get(0));
        if (r12 == null) goto L17;
        Activity r13 = ContextUtils.getActivity(r12.getContext());
        if (r13 == null) goto L18;
        Window r14 = r13.getWindow();
        if (this.entering == false) goto L13;
        setUpEnterTransform(r14);
        return;
    L13:
        setUpReturnTransform(r13, r14);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@NonNull List<String> r10, @NonNull List<View> r11, @NonNull List<View> r12) {
        if (r11.isEmpty() == true) goto L8;
        View r13 = r11.get(0);
        int r14 = R.id.mtrl_motion_snapshot_view;
        if ((r13.getTag(r14) instanceof View) == false) goto L8;
        r11.get(0).setTag(r14, null);
    L8:
        if (this.entering == false) goto L10;
    L12:
        this.entering = false;
        return;
    L10:
        if (r11.isEmpty() == true) goto L12;
        this.returnEndBounds = TransitionUtils.getRelativeBoundsRect(r11.get(0));
        goto L12
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@NonNull List<String> r10, @NonNull List<View> r11, @NonNull List<View> r12) {
        if (r11.isEmpty() == true) goto L8;
        if (r12.isEmpty() == true) goto L8;
        r11.get(0).setTag(R.id.mtrl_motion_snapshot_view, r12.get(0));
    L8:
        if (this.entering == false) goto L10;
        return;
    L10:
        if (r11.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.returnEndBounds == null) goto L17;
        View r13 = r11.get(0);
        r13.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), Ints.MAX_POWER_OF_TWO));
        Rect r14 = this.returnEndBounds;
        r13.layout(r14.left, r14.top, r14.right, r14.bottom);
        return;
    }

    public void setShapeProvider(@Nullable ShapeProvider r10) {
        this.shapeProvider = r10;
    }

    public void setSharedElementReenterTransitionEnabled(boolean r10) {
        this.sharedElementReenterTransitionEnabled = r10;
    }

    public void setTransparentWindowBackgroundEnabled(boolean r10) {
        this.transparentWindowBackgroundEnabled = r10;
    }
}
