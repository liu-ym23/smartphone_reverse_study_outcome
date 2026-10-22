package com.mdisdk.gles;

import C7.r;
import D6.i;
import H7.c;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.view.Surface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.base.ALog;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import m9.C1718k;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\tJ\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001a\u0010\u000eJ\u0010\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R(\u0010-\u001a\u0004\u0018\u00010\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010+R\u0018\u00108\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010.R\u0018\u00109\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/mdisdk/gles/EglRenderPipeline;", "Ljava/lang/Thread;", "", "width", "height", AppAgent.CONSTRUCT, "(II)V", "LC7/r;", McpSchema.METHOD_INITIALIZE, "()V", "renderLoop", "Landroid/view/Surface;", "surface", "switchOutputSurfaceInternal", "(Landroid/view/Surface;)V", "renderFrame", "Lcom/mdisdk/gles/EglRenderPipeline$CaptureRequest;", "request", "handleCaptureRequest", "(Lcom/mdisdk/gles/EglRenderPipeline$CaptureRequest;)V", "cleanup", "run", "", "timeoutMs", "awaitInputSurface", "(J)Landroid/view/Surface;", "setOutputSurface", "Landroid/graphics/Bitmap;", "captureFrame", "(LH7/c;)Ljava/lang/Object;", "release", "I", "Lcom/mdisdk/gles/EglCore;", "eglCore", "Lcom/mdisdk/gles/EglCore;", "Lcom/mdisdk/gles/TextureInput;", "textureInput", "Lcom/mdisdk/gles/TextureInput;", "Lcom/mdisdk/gles/FrameCapture;", "frameCapture", "Lcom/mdisdk/gles/FrameCapture;", "", "isRunning", "Z", "value", "currentOutputSurface", "Landroid/view/Surface;", "getCurrentOutputSurface", "()Landroid/view/Surface;", "Ljava/util/concurrent/CountDownLatch;", "setupLatch", "Ljava/util/concurrent/CountDownLatch;", "Ljava/lang/Object;", "lock", "Ljava/lang/Object;", "usingOutputSurface", "pendingOutputSurface", "captureRequest", "Lcom/mdisdk/gles/EglRenderPipeline$CaptureRequest;", "Companion", "CaptureRequest", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EglRenderPipeline extends Thread {
    private static final String TAG = "EglRenderPipeline";
    private CaptureRequest captureRequest;
    private volatile Surface currentOutputSurface;
    private EglCore eglCore;
    private FrameCapture frameCapture;
    private final int height;
    private volatile boolean isRunning;
    private final Object lock;
    private Surface pendingOutputSurface;
    private final CountDownLatch setupLatch;
    private TextureInput textureInput;
    private volatile boolean usingOutputSurface;
    private final int width;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/mdisdk/gles/EglRenderPipeline$CaptureRequest;", "", "LH7/c;", "Landroid/graphics/Bitmap;", "continuation", AppAgent.CONSTRUCT, "(LH7/c;)V", "component1", "()LH7/c;", "copy", "(LH7/c;)Lcom/mdisdk/gles/EglRenderPipeline$CaptureRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LH7/c;", "getContinuation", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class CaptureRequest {
        private final c<Bitmap> continuation;

        /* JADX WARN: Multi-variable type inference failed */
        public CaptureRequest(c<? super Bitmap> continuation) {
            k.f(continuation, "continuation");
            this.continuation = continuation;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CaptureRequest copy$default(CaptureRequest captureRequest, c cVar, int i, Object obj) {
            if ((i & 1) != 0) {
                cVar = captureRequest.continuation;
            }
            return captureRequest.copy(cVar);
        }

        public final c<Bitmap> component1() {
            return this.continuation;
        }

        public final CaptureRequest copy(c<? super Bitmap> continuation) {
            k.f(continuation, "continuation");
            return new CaptureRequest(continuation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CaptureRequest) && k.b(this.continuation, ((CaptureRequest) other).continuation);
        }

        public final c<Bitmap> getContinuation() {
            return this.continuation;
        }

        public int hashCode() {
            return this.continuation.hashCode();
        }

        public String toString() {
            return "CaptureRequest(continuation=" + this.continuation + ')';
        }
    }

    public EglRenderPipeline(int i, int i6) {
        super(TAG);
        this.width = i;
        this.height = i6;
        this.setupLatch = new CountDownLatch(1);
        this.lock = new Object();
    }

    public static /* synthetic */ Surface awaitInputSurface$default(EglRenderPipeline eglRenderPipeline, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = 3000;
        }
        return eglRenderPipeline.awaitInputSurface(j5);
    }

    private final void cleanup() {
        TextureInput textureInput = this.textureInput;
        if (textureInput == null) {
            k.n("textureInput");
            throw null;
        }
        textureInput.release();
        FrameCapture frameCapture = this.frameCapture;
        if (frameCapture == null) {
            k.n("frameCapture");
            throw null;
        }
        frameCapture.release();
        EglCore eglCore = this.eglCore;
        if (eglCore != null) {
            eglCore.release();
        } else {
            k.n("eglCore");
            throw null;
        }
    }

    private final void handleCaptureRequest(CaptureRequest request) {
        try {
            FrameCapture frameCapture = this.frameCapture;
            if (frameCapture == null) {
                k.n("frameCapture");
                throw null;
            }
            request.getContinuation().resumeWith(frameCapture.capture(new i(this, 18)));
        } catch (Exception e) {
            request.getContinuation().resumeWith(b.a(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r handleCaptureRequest$lambda$8(EglRenderPipeline eglRenderPipeline) {
        TextureInput textureInput = eglRenderPipeline.textureInput;
        if (textureInput != null) {
            textureInput.draw();
            return r.f317a;
        }
        k.n("textureInput");
        throw null;
    }

    private final void initialize() {
        EglCore eglCore = new EglCore();
        this.eglCore = eglCore;
        eglCore.initialize();
        EglCore eglCore2 = this.eglCore;
        if (eglCore2 == null) {
            k.n("eglCore");
            throw null;
        }
        eglCore2.createPbufferSurface(this.width, this.height);
        EglCore eglCore3 = this.eglCore;
        if (eglCore3 == null) {
            k.n("eglCore");
            throw null;
        }
        eglCore3.makeCurrent();
        TextureInput textureInput = new TextureInput(this.width, this.height);
        this.textureInput = textureInput;
        textureInput.setup();
        FrameCapture frameCapture = new FrameCapture(this.width, this.height);
        this.frameCapture = frameCapture;
        frameCapture.setup();
        this.isRunning = true;
        this.setupLatch.countDown();
    }

    private final void renderFrame() {
        TextureInput textureInput = this.textureInput;
        if (textureInput == null) {
            k.n("textureInput");
            throw null;
        }
        textureInput.draw();
        EglCore eglCore = this.eglCore;
        if (eglCore != null) {
            eglCore.swapBuffers();
        } else {
            k.n("eglCore");
            throw null;
        }
    }

    private final void renderLoop() throws InterruptedException {
        CaptureRequest captureRequest;
        while (this.isRunning) {
            synchronized (this.lock) {
                try {
                    if (this.pendingOutputSurface != this.currentOutputSurface) {
                        switchOutputSurfaceInternal(this.pendingOutputSurface);
                        this.currentOutputSurface = this.pendingOutputSurface;
                    }
                    captureRequest = this.captureRequest;
                    if (captureRequest != null) {
                        this.captureRequest = null;
                    } else {
                        captureRequest = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            TextureInput textureInput = this.textureInput;
            if (textureInput == null) {
                k.n("textureInput");
                throw null;
            }
            if (textureInput.hasNewFrame()) {
                TextureInput textureInput2 = this.textureInput;
                if (textureInput2 == null) {
                    k.n("textureInput");
                    throw null;
                }
                textureInput2.updateTexture();
                renderFrame();
            } else {
                Thread.sleep(10L);
            }
            if (captureRequest != null) {
                handleCaptureRequest(captureRequest);
            }
        }
    }

    private final void switchOutputSurfaceInternal(Surface surface) {
        EglCore eglCore = this.eglCore;
        if (eglCore == null) {
            k.n("eglCore");
            throw null;
        }
        eglCore.destroyWindowSurface();
        if (surface == null) {
            EglCore eglCore2 = this.eglCore;
            if (eglCore2 == null) {
                k.n("eglCore");
                throw null;
            }
            eglCore2.createPbufferSurface(this.width, this.height);
            ALog.d$default(TAG, "Switched to Pbuffer surface", null, 4, null);
        } else if (surface.isValid()) {
            try {
                EglCore eglCore3 = this.eglCore;
                if (eglCore3 == null) {
                    k.n("eglCore");
                    throw null;
                }
                eglCore3.createWindowSurface(surface);
                ALog.d$default(TAG, "Switched to Window surface", null, 4, null);
            } catch (Exception e) {
                ALog.e$default(TAG, "Failed to create window surface, fallback to Pbuffer. Surface: " + surface + ", isValid: " + surface.isValid() + ", error: " + e.getMessage(), null, 4, null);
                EglCore eglCore4 = this.eglCore;
                if (eglCore4 == null) {
                    k.n("eglCore");
                    throw null;
                }
                eglCore4.createPbufferSurface(this.width, this.height);
                synchronized (this.lock) {
                    if (this.pendingOutputSurface == surface) {
                        this.pendingOutputSurface = null;
                    }
                }
            }
        } else {
            ALog.w$default(TAG, "Attempted to switch to invalid surface, skipped", null, 4, null);
            EglCore eglCore5 = this.eglCore;
            if (eglCore5 == null) {
                k.n("eglCore");
                throw null;
            }
            eglCore5.createPbufferSurface(this.width, this.height);
        }
        EglCore eglCore6 = this.eglCore;
        if (eglCore6 == null) {
            k.n("eglCore");
            throw null;
        }
        eglCore6.makeCurrent();
        GLES20.glViewport(0, 0, this.width, this.height);
    }

    public final Surface awaitInputSurface(long timeoutMs) throws InterruptedException {
        try {
            this.setupLatch.await(timeoutMs, TimeUnit.SECONDS);
            TextureInput textureInput = this.textureInput;
            if (textureInput != null) {
                return textureInput.getSurface();
            }
            k.n("textureInput");
            throw null;
        } catch (InterruptedException e) {
            ALog.e(TAG, "Timeout waiting for input surface", e);
            return null;
        }
    }

    public final Object captureFrame(c<? super Bitmap> cVar) {
        C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        synchronized (this.lock) {
            try {
                if (this.captureRequest != null) {
                    c1718k.resumeWith(b.a(new IllegalStateException("Another capture in progress")));
                } else {
                    this.captureRequest = new CaptureRequest(c1718k);
                    this.lock.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    public final Surface getCurrentOutputSurface() {
        return this.currentOutputSurface;
    }

    public final void release() {
        this.isRunning = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            initialize();
            renderLoop();
        } catch (Exception e) {
            ALog.e(TAG, "Pipeline error: " + e, e);
        } finally {
            cleanup();
        }
    }

    public final void setOutputSurface(Surface surface) {
        synchronized (this.lock) {
            if (this.pendingOutputSurface == surface) {
                return;
            }
            this.pendingOutputSurface = surface;
            this.lock.notifyAll();
        }
    }
}
