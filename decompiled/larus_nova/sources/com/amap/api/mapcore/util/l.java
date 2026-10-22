package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class l extends y implements IGLSurfaceView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IAMapDelegate f27509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f27510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private GLMapRender f27511l;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f27512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f27513b;

        @Override // java.lang.Runnable
        public void run() {
            com_amap_api_mapcore_util_l$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_mapcore_util_l$a__run$___twin___() {
        L11:
            th = move-exception;
            th.printStackTrace();
            w3.a(th);
            return;
        L3:
            if (l.a(this.f27513b) != null) goto L5;
        L7:
            Runnable r100 = this.f27512a;     // Catch: Throwable -> L11
            if (r100 == null) goto L16;
            r100.run();     // Catch: Throwable -> L11
            return;
        L16:
            return;
        L5:
            if (l.a(this.f27513b).mSurfacedestoryed == true) goto L7;
            l.a(this.f27513b).onSurfaceDestory();     // Catch: Throwable -> L11
            goto L7
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_l$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_mapcore_util_l$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(l r100, Runnable r101) {
            this.f27513b = r100;
            this.f27512a = r101;
        }
    }

    public boolean g() {
        this.f27510k = true;
        GLMapRender r100 = this.f27511l;     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        r100.onDetachedFromWindow();     // Catch: Throwable -> L7
    L9:
        boolean r101 = a(300, null);
        if (r101 == false) goto L12;
        this.f27510k = false;
    L12:
        return r101;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setZOrderOnTop(boolean r100) {
    }

    @Override // com.amap.api.mapcore.util.y, android.view.View
    public void onDetachedFromWindow() {
        z3.b("[map][lifecycle]", "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView() == true) goto L33;
        z3.b("[map][lifecycle]", "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.f27511l.mSurfacedestoryed);
        if (this.f27511l.mSurfacedestoryed == true) goto L16;
        queueEvent(new m(this));
        int r100 = 0;
    L8:
        if (this.f27511l.mSurfacedestoryed == true) goto L16;
        int r101 = r100 + 1;
        if (r100 >= 50) goto L16;
        Thread.sleep(20);     // Catch: InterruptedException -> L14
    L15:
        r100 = r101;
    L16:
        super.d();
        GLMapRender r102 = this.f27511l;     // Catch: Throwable -> L21
        if (r102 == null) goto L23;
        r102.onDetachedFromWindow();     // Catch: Throwable -> L21
    L23:
        super.onDetachedFromWindow();
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void onDetachedGLThread() {
        z3.b("[map][lifecycle]", "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView() == false) goto L6;
        a(null, 300);
        return;
    }

    @Override // com.amap.api.mapcore.util.y, android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        z3.b("[map][lifecycle]", "AMapGLTextureView onAttachedToWindow");
        GLMapRender r100 = this.f27511l;     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        r100.onAttachedToWindow();     // Catch: Throwable -> L7
    L9:
        super.e();
        z3.b("[map][lifecycle]", "AMapGLTextureView onResume");
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public IAMapDelegate f() {
        return this.f27509j;
    }

    public static /* synthetic */ GLMapRender a(l r100) {
        return r100.f27511l;
    }

    @Override // com.amap.api.mapcore.util.y, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        z3.b("[map][lifecycle]", "AMapGLTextureView onSurfaceTextureDestroyed");
        if (this.f27510k == true) goto L12;
        requestRender();
    L9:
        th = move-exception;
        th.printStackTrace();
        w3.a(th);
        goto L12
    L6:
        if (MapsInitializer.getTextureDestroyRender() == false) goto L12;
        Thread.sleep(100);     // Catch: Throwable -> L9
    L12:
        if (this.f27510k == false) goto L14;
        long r101 = 300;
    L15:
        a(r101);
        return true;
    L14:
        r101 = 0;
        goto L15
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        super.onTouchEvent(r100);
        return this.f27509j.onTouchEvent(r100);
    L5:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        z3.b("[map][lifecycle]", "AMapGLTextureView onWindowVisibilityChanged visibility " + r100);
        if (r100 != 8) goto L5;
    L11:
        GLMapRender r101 = this.f27511l;     // Catch: Throwable -> L16
        if (r101 == null) goto L14;
        r101.renderPause();     // Catch: Throwable -> L16
    L14:
        requestRender();     // Catch: Throwable -> L16
        return;
    L5:
        if (r100 == 4) goto L11;
        if (r100 != 0) goto L20;
        GLMapRender r102 = this.f27511l;     // Catch: Throwable -> L16
        if (r102 == null) goto L21;
        r102.renderResume();     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L20:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        w3.a(th);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLConfigChooser(h3 r100) {
        a(r100);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLContextFactory(i3 r100) {
        a(r100);
    }

    @Override // com.amap.api.mapcore.util.y, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer r100) {
        this.f27511l = (GLMapRender) r100;
        super.setRenderer(r100);
    }

    public l(Context r100, boolean r101) {
        super(r100, null);
        this.f27509j = null;
        this.f27510k = false;
        this.f27511l = null;
        if (Build.VERSION.SDK_INT < 34) goto L5;
        n0.a(this, 8, 8, 8, 0, 16, 8);
    L6:
        this.f27509j = new b(this, r100, r101);
        return;
    L5:
        n0.a(this, 5, 6, 5, 0, 16, 8);
        goto L6
    }

    public boolean a(Runnable r100, long r101) {
        this.f27510k = true;
        GLMapRender r102 = this.f27511l;     // Catch: Throwable -> L7
        if (r102 == null) goto L9;
        r102.onDetachedFromWindow();     // Catch: Throwable -> L7
    L9:
        boolean r103 = a(r101, new a(this, null));
        if (r103 == false) goto L12;
        this.f27510k = false;
    L12:
        return r103;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }
}
