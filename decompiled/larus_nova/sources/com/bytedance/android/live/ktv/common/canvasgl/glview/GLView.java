package com.bytedance.android.live.ktv.common.canvasgl.glview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES11;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fb0.e;
import ib0.d;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes45.dex */
public abstract class GLView extends GLSurfaceView implements GLSurfaceView.Renderer, lb0.c {

    /* JADX INFO: renamed from: gl, reason: collision with root package name */
    protected GL10 f69460gl;
    private long glThreadId;
    private boolean isFirstFrame;
    protected eb0.b mCanvas;
    private c onSizeChangeCallback;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f69461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GLView f69462b;

        /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.canvasgl.glview.GLView$a$a, reason: collision with other inner class name */
        public class RunnableC1130a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f69463a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f69463a.getClass();     // Catch: Throwable -> L4
                throw null;     // Catch: Throwable -> L4
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC1130a(a r100, Bitmap r101) {
                this.f69463a = r100;
            }
        }

        public final void a() {
            GLView r100 = this.f69462b;
            GL10 r101 = r100.f69460gl;
            if (r101 != null) goto L5;
            return;
        L5:
            r100.onDrawFrame(r101);
            GLView r102 = this.f69462b;
            r102.onDrawFrame(r102.f69460gl);
            Rect r103 = this.f69461a;
            int r104 = r103.left;
            int r105 = r103.top;
            int r106 = r103.right;
            int r107 = r103.bottom;
            int r108 = this.f69462b.getHeight();
            int r109 = r106 * r107;
            int[] r110 = new int[r109];
            int[] r111 = new int[r109];
            IntBuffer r112 = IntBuffer.wrap(r110);
            r112.position(0);
            GLES11.glReadPixels(r104, (r108 - r107) - r105, r106, r107, 6408, 5121, r112);     // Catch: GLException -> L14
            int r113 = 0;
        L7:
            if (r113 >= r107) goto L13;
            int r114 = r113 * r106;     // Catch: GLException -> L14
            int r115 = ((r107 - r113) - 1) * r106;     // Catch: GLException -> L14
            int r116 = 0;
        L9:
            if (r116 >= r106) goto L12;
            int r117 = r110[r114 + r116];     // Catch: GLException -> L14
            r111[r115 + r116] = ((r117 & FakePickerAvatarCreator.GREEN) | ((r117 << 16) & 16711680)) | ((r117 >> 16) & 255);     // Catch: GLException -> L14
            r116 = r116 + 1;
            goto L9
        L12:
            r113 = r113 + 1;
            goto L7
        L13:
            Bitmap r118 = Bitmap.createBitmap(r111, r106, r107, Bitmap.Config.ARGB_8888);
        L15:
            this.f69462b.post(new RunnableC1130a(this, r118));
            return;
        L14:
            r118 = null;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(GLView r100, Rect r101) {
            this.f69462b = r100;
            this.f69461a = r101;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public void init() {
        setZOrderOnTop(true);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setPreserveEGLContextOnPause(true);
        getHolder().setFormat(-3);
        setRenderer(this);
        setRenderMode(0);
    }

    public abstract void onGLDraw(eb0.c r100);

    public void setOnSizeChangeCallback(c r100) {
    }

    public abstract boolean useGLChoreographer();

    public void clearBitmapCache() {
        eb0.b r100 = this.mCanvas;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (useGLChoreographer() == false) goto L11;
        long r100 = this.glThreadId;
        gb0.a r101 = gb0.a.f480645k.get(Long.valueOf(r100));
        if (r101 != null) goto L7;
        r101 = gb0.a.f480646l.get(Long.valueOf(r100));
    L7:
        if (r101 == null) goto L9;
        r101.e();
    L9:
        this.isFirstFrame = true;
        return;
    }

    public void stop() {
        onPause();
        eb0.b r100 = this.mCanvas;
        if (r100 == null) goto L8;
        d r101 = r100.f471789g;
        if (r101 == null) goto L9;
        r101.destroy();
        return;
    L9:
        return;
    }

    @Override // android.opengl.GLSurfaceView, lb0.c
    public void requestRender() {
        super.requestRender();
    }

    public void restart() {
        onResume();
    }

    public GLView(Context r100) {
        super(r100);
        this.isFirstFrame = true;
        init();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r100) {
        if (useGLChoreographer() == false) goto L8;
        gb0.a r101 = gb0.a.c();
        if (this.isFirstFrame == false) goto L8;
        if (r101 == null) goto L8;
        requestRender();
        gb0.a.b r102 = r101.f480651e;
        long r103 = r101.f480647a;
        r102.postDelayed(new gb0.a.c(r102, this, r103), r103);
        this.isFirstFrame = false;
    L8:
        this.f69460gl = r100;
        ((e) this.mCanvas.f471784b).getClass();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        onGLDraw(this.mCanvas);
    }

    public GLView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.isFirstFrame = true;
        init();
    }

    public void getDrawingBitmap(Rect r100, b r101) {
        queueEvent(new a(this, r100));
        requestRender();
    }

    public void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        this.mCanvas = new eb0.b();
        this.glThreadId = ThreadMethodProxy.currentThread().getId();
        if (useGLChoreographer() == false) goto L6;
        gb0.a.d();
        return;
    }

    public void onSurfaceChanged(GL10 r100, int r101, int r102) {
        eb0.b r103 = this.mCanvas;
        r103.f471787e = r101;
        r103.f471788f = r102;
        ((e) r103.f471784b).c(r101, r102);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }
}
