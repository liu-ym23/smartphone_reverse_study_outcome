package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.u;
import com.bytedance.android.livehostapi.business.view.ISurfaceViewService;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0018B\u001d\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/ContinuousSurfaceAdapterView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/bytedance/android/live/ktv/common/util/u;", "Landroid/graphics/Rect;", "getSurfaceViewPos", "", "visible", "", "setBusinessVisible", "Landroid/view/SurfaceHolder;", "c", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceHolder", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class ContinuousSurfaceAdapterView extends SurfaceView implements SurfaceHolder.Callback, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f70710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f70711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SurfaceHolder f70712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f70713d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContinuousSurfaceAdapterView f70714a;

        public b(ContinuousSurfaceAdapterView r100) {
            this.f70714a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ContinuousSurfaceAdapterView.a(this.f70714a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    private final Rect getSurfaceViewPos() {
        Class<? super Object> r100 = getClass().getSuperclass();     // Catch: Exception -> L16
        if (r100 == null) goto L6;
        Field r101 = r100.getDeclaredField("mRTLastReportedPosition");     // Catch: Exception -> L16
    L7:
        if (r101 == null) goto L9;
        r101.setAccessible(true);     // Catch: Exception -> L16
    L9:
        if (r101 == null) goto L11;
        Object r102 = r101.get(this);     // Catch: Exception -> L16
    L12:
        if (r102 == null) goto L15;
        return (Rect) r102;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Exception -> L16
    L11:
        r102 = null;
        goto L12
    L6:
        r101 = null;
    L16:
        e = move-exception;
        e.toString();
        return null;
    }

    public final void c() {
        setZOrderOnTop(true);
        getHolder().setFormat(-3);
        SurfaceHolder r100 = getHolder();
        this.f70712c = r100;
        if (r100 == null) goto L5;
        r100.addCallback(this);
    L5:
        ISurfaceViewService r101 = (ISurfaceViewService) k.f(ISurfaceViewService.class);
        if (r101 == null) goto L9;
        r101.fixPositionChangedCrash("ktv", this);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHPaused() {
        this.f70711b = true;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHResume() {
        this.f70711b = false;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHSelected() {
        this.f70710a = true;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHUnBind() {
        this.f70710a = false;
        this.f70711b = false;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHUnSelected() {
        this.f70710a = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    private final void b() {
        Rect r100 = getSurfaceViewPos();
        int r101 = DeviceUtils.getScreenWidth(getContext());
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.centerX() >= r101) goto L13;
        setVisibility(8);
        if (Build.VERSION.SDK_INT < 33) goto L9;
        return;
    L9:
        if (this.f70713d != 0) goto L15;
        setVisibility(0);
        return;
    L15:
        return;
    }

    public final SurfaceHolder getSurfaceHolder() {
        return this.f70712c;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final boolean isVHPaused() {
        return this.f70711b;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final boolean isVHSelected() {
        return this.f70710a;
    }

    public ContinuousSurfaceAdapterView(Context r100) {
        this(r100, null);
    }

    public static final /* synthetic */ void a(ContinuousSurfaceAdapterView r100) {
        r100.b();
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void attachFromWindow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        ALogger.i("SurfaceAdapterView", name() + ", attachFromWindow: msg=" + r100);
        if (getVisibility() != 0) goto L5;
        return;
    L5:
        if (this.f70713d != 0) goto L9;
        setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void detachFromWindow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        if (getVisibility() != 8) goto L5;
        return;
    L5:
        setVisibility(8);
        ALogger.i("SurfaceAdapterView", name() + ", detachFromWindow: msg=" + r100);
        b();
        postDelayed(new b(this), 100);
    }

    public void setBusinessVisible(int r100) {
        this.f70713d = r100;
    }

    public final void setSurfaceHolder(SurfaceHolder r100) {
        this.f70712c = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (Build.VERSION.SDK_INT >= 33) goto L6;
        return;
    L6:
        if (this.f70710a == true) goto L11;
        postDelayed(new c(this), 100);
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        detachFromWindow("surfaceDestroyed");
    }

    public ContinuousSurfaceAdapterView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        c();
    }
}
