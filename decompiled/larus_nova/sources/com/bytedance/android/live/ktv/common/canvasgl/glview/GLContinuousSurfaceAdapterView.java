package com.bytedance.android.live.ktv.common.canvasgl.glview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.u;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u0013\b\u0016\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(B\u001d\b\u0016\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b'\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0013\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0010H\u0016R\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010$R\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010$¨\u0006."}, d2 = {"Lcom/bytedance/android/live/ktv/common/canvasgl/glview/GLContinuousSurfaceAdapterView;", "Lcom/bytedance/android/live/ktv/common/canvasgl/glview/GLContinuousView;", "Lcom/bytedance/android/live/ktv/common/util/u;", "", "checkAbnormalSurfaceViewCaseForAndroid13", "checkAbnormalSurfaceViewCase", "Landroid/graphics/Rect;", "getSurfaceViewPos", "Landroid/view/SurfaceHolder;", "holder", "surfaceDestroyed", "Ljavax/microedition/khronos/opengles/GL10;", "gl", "Ljavax/microedition/khronos/egl/EGLConfig;", "config", "onSurfaceCreated", "", "width", "height", "onSurfaceChanged", "", "log", "attachFromWindow", "detachFromWindow", "onVHSelected", "onVHUnSelected", "onVHPaused", "onVHResume", "onVHUnBind", "", "isVHSelected", "isVHPaused", "visible", "setBusinessVisible", "businessVisible", "I", "Z", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class GLContinuousSurfaceAdapterView extends GLContinuousView implements u {
    private static final long ABNORMAL_SURFACE_VIEW_CASE_DELAY = 100;
    private static final String ALOG_TAG = "SurfaceAdapterView";
    private static final int ANDROID_33_VERSION_CODE = 33;
    public static final a Companion = null;
    private int businessVisible;
    private boolean isVHPaused;
    private boolean isVHSelected;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GLContinuousSurfaceAdapterView f69458a;

        public b(GLContinuousSurfaceAdapterView r100) {
            this.f69458a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (GLContinuousSurfaceAdapterView.access$isVHSelected$p(this.f69458a) == true) goto L9;
            GLContinuousSurfaceAdapterView.access$checkAbnormalSurfaceViewCase(this.f69458a);     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GLContinuousSurfaceAdapterView f69459a;

        public c(GLContinuousSurfaceAdapterView r100) {
            this.f69459a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLContinuousSurfaceAdapterView.access$checkAbnormalSurfaceViewCase(this.f69459a);     // Catch: Throwable -> L4
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
        Companion = new a();
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

    @Override // com.bytedance.android.live.ktv.common.util.u
    public void onVHPaused() {
        this.isVHPaused = true;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public void onVHResume() {
        this.isVHPaused = false;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public void onVHSelected() {
        this.isVHSelected = true;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public void onVHUnBind() {
        this.isVHSelected = false;
        this.isVHPaused = false;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public void onVHUnSelected() {
        this.isVHSelected = false;
    }

    private final void checkAbnormalSurfaceViewCaseForAndroid13() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return;
    L5:
        ALogger.i(ALOG_TAG, "checkAbnormalSurfaceViewCaseForAndroid13: isVHSelected=" + this.isVHSelected);
        if (this.isVHSelected == false) goto L8;
        return;
    L8:
        postDelayed(new b(this), 100);
    }

    private final void checkAbnormalSurfaceViewCase() {
        Rect r100 = getSurfaceViewPos();
        int r101 = DeviceUtils.getScreenWidth(getContext());
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.centerX() >= r101) goto L11;
        setVisibility(8);
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        setVisibility(0);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public boolean isVHPaused() {
        return this.isVHPaused;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public boolean isVHSelected() {
        return this.isVHSelected;
    }

    public GLContinuousSurfaceAdapterView(Context r100) {
        super(r100);
    }

    public static final /* synthetic */ void access$checkAbnormalSurfaceViewCase(GLContinuousSurfaceAdapterView r100) {
        r100.checkAbnormalSurfaceViewCase();
    }

    public static final /* synthetic */ boolean access$isVHSelected$p(GLContinuousSurfaceAdapterView r100) {
        return r100.isVHSelected;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public void attachFromWindow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        ALogger.i(ALOG_TAG, name() + ", attachFromWindow: msg=" + r100);
        if (getVisibility() == 0) goto L6;
        setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public void detachFromWindow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        if (getVisibility() != 8) goto L5;
        return;
    L5:
        setVisibility(8);
        ALogger.i(ALOG_TAG, name() + ", detachFromWindow: msg=" + r100);
        checkAbnormalSurfaceViewCase();
        postDelayed(new c(this), 100);
    }

    public void setBusinessVisible(int r100) {
        this.businessVisible = r100;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.surfaceDestroyed(r100);
        detachFromWindow("surfaceDestroyed");
    }

    public GLContinuousSurfaceAdapterView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public static final /* synthetic */ void access$setVHSelected$p(GLContinuousSurfaceAdapterView r100, boolean r101) {
        r100.isVHSelected = r101;
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.GLView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        super.onSurfaceCreated(r100, r101);
        checkAbnormalSurfaceViewCaseForAndroid13();
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.GLView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 r100, int r101, int r102) {
        super.onSurfaceChanged(r100, r101, r102);
    }
}
