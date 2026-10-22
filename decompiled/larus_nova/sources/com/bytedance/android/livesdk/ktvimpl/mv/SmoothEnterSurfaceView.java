package com.bytedance.android.livesdk.ktvimpl.mv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import com.bytedance.android.live.ktv.common.view.ContinuousSurfaceAdapterView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/SmoothEnterSurfaceView;", "Lcom/bytedance/android/live/ktv/common/view/ContinuousSurfaceAdapterView;", "Lcom/bytedance/android/livesdk/ktvimpl/mv/x;", "e", "Lcom/bytedance/android/livesdk/ktvimpl/mv/x;", "getSmoothEnterCallback", "()Lcom/bytedance/android/livesdk/ktvimpl/mv/x;", "setSmoothEnterCallback", "(Lcom/bytedance/android/livesdk/ktvimpl/mv/x;)V", "smoothEnterCallback", "", "isBusinessVisibale", "Z", "()Z", "setBusinessVisibale", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SmoothEnterSurfaceView extends ContinuousSurfaceAdapterView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x f146032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f146033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f146034g;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmoothEnterSurfaceView f146035a;

        public b(SmoothEnterSurfaceView r100) {
            this.f146035a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            x r100 = this.f146035a.getSmoothEnterCallback();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final String name() {
        return "SmoothEnterSurfaceView";
    }

    public final void setBusinessVisibale(boolean r100) {
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f146033f.postDelayed(this.f146034g, 300);
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x r100 = this.f146032e;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        super.onDetachedFromWindow();
    }

    public final x getSmoothEnterCallback() {
        return this.f146032e;
    }

    public final void setSmoothEnterCallback(x r100) {
        this.f146032e = r100;
    }

    public SmoothEnterSurfaceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f146033f = new Handler(Looper.getMainLooper());
        this.f146034g = new b(this);
    }
}
