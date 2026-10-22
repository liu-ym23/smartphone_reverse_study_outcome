package com.bytedance.android.shopping.inflow.compat;

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

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/inflow/compat/VideoZoomableToggleBottomSheetFragment;", "Lcom/bytedance/android/shopping/inflow/compat/ToggleBottomSheetFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class VideoZoomableToggleBottomSheetFragment extends ToggleBottomSheetFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m f176281m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f176282n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f176283o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f176284p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f176285q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoZoomableToggleBottomSheetFragment f176286a;

        public b(VideoZoomableToggleBottomSheetFragment r100) {
            this.f176286a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoZoomableToggleBottomSheetFragment r100 = this.f176286a;     // Catch: Throwable -> L9
            ValueAnimator r101 = r100.f176282n;     // Catch: Throwable -> L9
            if (r101 != null) goto L5;
        L7:
            ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{-1.0f, 0.0f});     // Catch: Throwable -> L9
            r102.setDuration(150);     // Catch: Throwable -> L9
            r102.addUpdateListener(new d(r100));     // Catch: Throwable -> L9
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r100.f176282n = r102;     // Catch: Throwable -> L9
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

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ValueAnimator r100 = this.f176285q;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{this.f176283o, -1.0f});
        r101.setDuration(150);
        r101.addUpdateListener(new e(this));
        Unit r102 = Unit.INSTANCE;
        this.f176285q = r101;
        r101.start();
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f176284p == true) goto L8;
        this.f176284p = true;
        View r100 = getView();
        if (r100 == null) goto L9;
        r100.post(new b(this));
        return;
    L9:
        return;
    }

    public VideoZoomableToggleBottomSheetFragment() {
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public void W90(float r100) {
        this.f176283o = r100;
        ValueAnimator r101 = this.f176282n;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L6:
        ValueAnimator r103 = this.f176285q;
        if (r103 != null) goto L9;
    L11:
        r102 = false;
    L12:
        if (r102 == true) goto L15;
        Z90(r100);
        return;
    L15:
        return;
    L9:
        if (r103.isRunning() != true) goto L11;
    L5:
        if (r101.isRunning() == true) goto L12;
        goto L6
    }

    public void Z90(float r100) {
        U90();
        Math.min(r100, 0.0f);
        m r101 = this.f176281m;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
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
