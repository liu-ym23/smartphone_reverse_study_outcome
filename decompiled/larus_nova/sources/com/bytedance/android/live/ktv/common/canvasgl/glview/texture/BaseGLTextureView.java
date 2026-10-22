package com.bytedance.android.live.ktv.common.canvasgl.glview.texture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hb0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
abstract class BaseGLTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f69467g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f69468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.b f69469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Runnable> f69470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextureView.SurfaceTextureListener f69471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f69472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f69473f;

    public class a implements d.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGLTextureView f69474a;

        public a(BaseGLTextureView r100) {
            this.f69474a = r100;
        }
    }

    public int getRenderMode() {
        return 0;
    }

    public void c() {
        if (this.f69472e == true) goto L5;
        return;
    L5:
        d.b r100 = this.f69469b;
        if (r100.f484450d == null) goto L41;
        if (r100.f484452f != null) goto L15;
        if (r100.f484449c != null) goto L15;
        throw new NullPointerException("surface has not been set");
    L15:
        if (r100.f484447a != null) goto L18;
        r100.f484447a = new d.m();
    L18:
        if (r100.f484448b != null) goto L21;
        r100.f484448b = new d.f();
    L21:
        if (r100.f484449c != null) goto L23;
        r100.f484449c = new d.g();
    L23:
        d r101 = new d(r100.f484447a, r100.f484448b, r100.f484449c, r100.f484450d, r100.f484451e, r100.f484452f, r100.f484453g);
        this.f69468a = r101;
        r101.C = new a(this);
        ThreadMethodProxy.start(r101);
        d(getWidth(), getHeight());
        Iterator r102 = ((ArrayList) this.f69470c).iterator();
    L25:
        if (r102.hasNext() == false) goto L38;
        Runnable r103 = (Runnable) r102.next();
        d r104 = this.f69468a;
        if (r103 == null) goto L36;
        d.k r105 = r104.f484441v;
        monitor-enter(r105);
        r104.Q.add(r103);     // Catch: Throwable -> L33
        r104.f484441v.notifyAll();     // Catch: Throwable -> L33
        monitor-exit(r105);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L36:
        r104.getClass();
        throw new IllegalArgumentException("r must not be null");
    L38:
        ((ArrayList) this.f69470c).clear();
        return;
    L41:
        throw new NullPointerException("renderer has not been set");
    }

    public void f() {
        d r100 = this.f69468a;
        if (r100 == null) goto L19;
        d.k r101 = r100.f484441v;
        monitor-enter(r101);
        ALogger.i("GLThread", "surfaceDestroyed tid=" + r100.getId());     // Catch: Throwable -> L16
        r100.F = false;     // Catch: Throwable -> L16
        r100.f484441v.notifyAll();     // Catch: Throwable -> L16
    L8:
        if (r100.H == true) goto L14;
        if (r100.E == true) goto L14;
        r100.f484441v.wait();     // Catch: InterruptedException -> L13 Throwable -> L16
    L13:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        this.f69468a.requestExitAndWait();
    L16:
        th = move-exception;
        throw th;
    L19:
        this.f69472e = false;
        this.f69468a = null;
    }

    public final void finalize() throws Throwable {
        d r100 = this.f69468a;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.requestExitAndWait();     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public final void g() {
        d r100 = this.f69468a;
        if (r100 == null) goto L43;
        d.k r101 = r100.f484441v;
        monitor-enter(r101);
    L40:
        th = move-exception;
        throw th;
    L7:
        if (ThreadMethodProxy.currentThread() != r100) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L40
        return;
    L10:
        r100.O = true;     // Catch: Throwable -> L40
        r100.N = true;     // Catch: Throwable -> L40
        r100.P = false;     // Catch: Throwable -> L40
        r100.f484441v.notifyAll();     // Catch: Throwable -> L40
    L12:
        if (r100.E == true) goto L38;
        if (r100.P == true) goto L38;
        if (r100.I == true) goto L18;
    L33:
        boolean r102 = false;
    L34:
        if (r102 == false) goto L38;
        r100.f484441v.wait();     // Catch: InterruptedException -> L37 Throwable -> L40
    L37:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L40
        goto L12
    L18:
        if (r100.f484440J == false) goto L33;
        if (r100.F == true) goto L22;
    L30:
        boolean r103 = false;
    L31:
        if (r103 == false) goto L33;
        r102 = true;
        goto L34
    L22:
        if (r100.G == true) goto L30;
        if (r100.L <= 0) goto L30;
        if (r100.M <= 0) goto L30;
        if (r100.N == false) goto L30;
        r103 = true;
    L38:
        monitor-exit(r101);     // Catch: Throwable -> L40
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        d r100 = this.f69468a;
        if (r100 == null) goto L5;
        r100.requestExitAndWait();
    L5:
        super.onDetachedFromWindow();
    }

    public void e() {
        super.setSurfaceTextureListener(this);
    }

    public BaseGLTextureView(Context r100) {
        super(r100);
        this.f69470c = new ArrayList();
        this.f69472e = false;
        e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        f();
        TextureView.SurfaceTextureListener r101 = this.f69471d;
        if (r101 == null) goto L7;
        r101.onSurfaceTextureDestroyed(r100);
        return true;
    L7:
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        TextureView.SurfaceTextureListener r101 = this.f69471d;
        if (r101 == null) goto L6;
        r101.onSurfaceTextureUpdated(r100);
        return;
    }

    public void setRenderer(c r100) {
        this.f69473f = r100;
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        this.f69471d = r100;
    }

    public BaseGLTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f69470c = new ArrayList();
        this.f69472e = false;
        e();
    }

    public final void d(int r100, int r101) {
        d r102 = this.f69468a;
        d.k r103 = r102.f484441v;
        monitor-enter(r103);
        ALogger.i("GLThread", "surfaceCreated tid=" + r102.getId());     // Catch: Throwable -> L17
        r102.F = true;     // Catch: Throwable -> L17
        r102.K = false;     // Catch: Throwable -> L17
        r102.f484441v.notifyAll();     // Catch: Throwable -> L17
    L6:
        if (r102.H == false) goto L14;
        if (r102.K == true) goto L14;
        if (r102.E == true) goto L14;
        r102.f484441v.wait();     // Catch: InterruptedException -> L13 Throwable -> L17
    L13:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L17
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L17
        this.f69468a.onWindowResize(r100, r101);
        g();
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public BaseGLTextureView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f69470c = new ArrayList();
        this.f69472e = false;
        e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        this.f69472e = true;
        d.b r103 = new d.b();
        this.f69469b = r103;
        d r104 = this.f69468a;
        if (r104 != null) goto L6;
        r103.f484451e = getRenderMode();
        r103.f484452f = r100;
        r103.f484450d = this.f69473f;
        c();
    L9:
        TextureView.SurfaceTextureListener r105 = this.f69471d;
        if (r105 == null) goto L13;
        r105.onSurfaceTextureAvailable(r100, r101, r102);
        return;
    L13:
        return;
    L6:
        if (r104.B == r100) goto L8;
        r104.S = true;
    L8:
        r104.B = r100;
        d(r101, r102);
        goto L9
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        this.f69468a.onWindowResize(r101, r102);
        g();
        TextureView.SurfaceTextureListener r103 = this.f69471d;
        if (r103 == null) goto L6;
        r103.onSurfaceTextureSizeChanged(r100, r101, r102);
        return;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        d r104 = this.f69468a;
        if (r104 == null) goto L6;
        r104.onWindowResize(r100, r101);
        return;
    }
}
