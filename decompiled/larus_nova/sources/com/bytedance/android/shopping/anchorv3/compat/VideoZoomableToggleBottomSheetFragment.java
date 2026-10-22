package com.bytedance.android.shopping.anchorv3.compat;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import n83.m;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/compat/VideoZoomableToggleBottomSheetFragment;", "Lcom/bytedance/android/shopping/anchorv3/compat/ToggleBottomSheetFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class VideoZoomableToggleBottomSheetFragment extends ToggleBottomSheetFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m f164790n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f164791o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f164792p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f164793q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f164794r;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoZoomableToggleBottomSheetFragment f164795a;

        public b(VideoZoomableToggleBottomSheetFragment r100) {
            this.f164795a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoZoomableToggleBottomSheetFragment r100 = this.f164795a;     // Catch: Throwable -> L9
            ValueAnimator r101 = r100.f164791o;     // Catch: Throwable -> L9
            if (r101 != null) goto L5;
        L7:
            ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{-1.0f, 0.0f});     // Catch: Throwable -> L9
            r102.setDuration(150);     // Catch: Throwable -> L9
            r102.addUpdateListener(new i(r100));     // Catch: Throwable -> L9
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r100.f164791o = r102;     // Catch: Throwable -> L9
            r102.start();     // Catch: Throwable -> L9
            return;
        L5:
            if (r101.isRunning() != true) goto L7;
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoZoomableToggleBottomSheetFragment f164796a;

        public c(VideoZoomableToggleBottomSheetFragment r100) {
            this.f164796a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            this.f164796a.aa0(r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final void Z90() {
        ValueAnimator r100 = this.f164794r;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{this.f164792p, -1.0f});
        r101.setDuration(150);
        r101.addUpdateListener(new c(this));
        Unit r102 = Unit.INSTANCE;
        this.f164794r = r101;
        r101.start();
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
    }

    public int Y90() {
        return U90();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Z90();
    }

    @Override // com.bytedance.android.shopping.anchorv3.compat.ToggleBottomSheetFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f164793q == true) goto L8;
        this.f164793q = true;
        View r100 = getView();
        if (r100 == null) goto L9;
        r100.post(new b(this));
        return;
    L9:
        return;
    }

    public VideoZoomableToggleBottomSheetFragment() {
    }

    @Override // com.bytedance.android.shopping.anchorv3.compat.ToggleBottomSheetFragment
    public void W90(float r100) {
        this.f164792p = r100;
        ValueAnimator r101 = this.f164791o;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L6:
        ValueAnimator r103 = this.f164794r;
        if (r103 != null) goto L9;
    L11:
        r102 = false;
    L12:
        if (r102 == true) goto L15;
        aa0(r100);
        return;
    L15:
        return;
    L9:
        if (r103.isRunning() != true) goto L11;
    L5:
        if (r101.isRunning() == true) goto L12;
        goto L6
    }

    public void aa0(float r100) {
        Y90();
        Math.min(r100, 0.0f);
        m r101 = this.f164790n;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.compat.ToggleBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L5;
        View r102 = r101.findViewById(R.id.touch_outside);
    L6:
        if (r102 == null) goto L9;
        r102.setBackgroundColor(0);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
