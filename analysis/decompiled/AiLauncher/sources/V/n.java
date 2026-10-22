package V;

import D.A;
import D.B;
import D.C0761b0;
import D.r0;
import U.Q;
import U.RunnableC1024e;
import U.RunnableC1026g;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.util.GLUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import p9.q;

/* loaded from: classes.dex */
public class n implements Q, SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final b f6445a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f6446b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f6447c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f6448d;

    /* renamed from: e, reason: collision with root package name */
    public int f6449e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6450f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f6451g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<r0, Surface> f6452h;

    /* renamed from: i, reason: collision with root package name */
    public SurfaceTexture f6453i;

    /* renamed from: j, reason: collision with root package name */
    public SurfaceTexture f6454j;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static q<B, A, A, Q> f6455a = new q() { // from class: V.m
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return new n((B) obj, (A) obj2, (A) obj3);
            }
        };

        public static Q a(B b10, A a10, A a11) {
            return f6455a.invoke(b10, a10, a11);
        }
    }

    public n(B b10, A a10, A a11) {
        this(b10, Collections.EMPTY_MAP, a10, a11);
    }

    public static /* synthetic */ void d(n nVar, Runnable runnable, Runnable runnable2) {
        if (nVar.f6450f) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void f(n nVar, SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.f fVar) {
        nVar.getClass();
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
        surface.release();
        nVar.f6449e--;
        nVar.m();
    }

    public static /* synthetic */ void g(n nVar) {
        nVar.f6450f = true;
        nVar.m();
    }

    public static /* synthetic */ void h(n nVar, r0 r0Var, r0.b bVar) {
        nVar.getClass();
        r0Var.close();
        Surface surfaceRemove = nVar.f6452h.remove(r0Var);
        if (surfaceRemove != null) {
            nVar.f6445a.r(surfaceRemove);
        }
    }

    public static /* synthetic */ void i(final n nVar, final r0 r0Var) {
        Surface surfaceQ = r0Var.Q(nVar.f6447c, new B0.a() { // from class: V.e
            @Override // B0.a
            public final void accept(Object obj) {
                n.h(this.f6429a, r0Var, (r0.b) obj);
            }
        });
        nVar.f6445a.j(surfaceQ);
        nVar.f6452h.put(r0Var, surfaceQ);
    }

    public static /* synthetic */ void j(final n nVar, SurfaceRequest surfaceRequest) throws ExecutionException, InterruptedException {
        nVar.f6449e++;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(nVar.f6445a.t(surfaceRequest.q()));
        surfaceTexture.setDefaultBufferSize(surfaceRequest.n().getWidth(), surfaceRequest.n().getHeight());
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.r(surface, nVar.f6447c, new B0.a() { // from class: V.h
            @Override // B0.a
            public final void accept(Object obj) {
                n.f(this.f6434a, surfaceTexture, surface, (SurfaceRequest.f) obj);
            }
        });
        if (surfaceRequest.q()) {
            nVar.f6453i = surfaceTexture;
        } else {
            nVar.f6454j = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(nVar, nVar.f6448d);
        }
    }

    public static /* synthetic */ void k(n nVar, B b10, Map map, CallbackToFutureAdapter.a aVar) {
        nVar.getClass();
        try {
            nVar.f6445a.h(b10, map);
            aVar.c(null);
        } catch (RuntimeException e10) {
            aVar.f(e10);
        }
    }

    public static /* synthetic */ Object l(final n nVar, final B b10, final Map map, final CallbackToFutureAdapter.a aVar) {
        nVar.getClass();
        nVar.n(new Runnable() { // from class: V.d
            @Override // java.lang.Runnable
            public final void run() {
                n.k(this.f6425a, b10, map, aVar);
            }
        });
        return "Init GlRenderer";
    }

    private void m() {
        if (this.f6450f && this.f6449e == 0) {
            Iterator<r0> it = this.f6452h.keySet().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.f6452h.clear();
            this.f6445a.k();
            this.f6446b.quit();
        }
    }

    private void n(Runnable runnable) {
        o(runnable, new Runnable() { // from class: V.g
            @Override // java.lang.Runnable
            public final void run() {
                n.e();
            }
        });
    }

    private void o(final Runnable runnable, final Runnable runnable2) {
        try {
            this.f6447c.execute(new Runnable() { // from class: V.f
                @Override // java.lang.Runnable
                public final void run() {
                    n.d(this.f6431a, runnable2, runnable);
                }
            });
        } catch (RejectedExecutionException e10) {
            C0761b0.p("DualSurfaceProcessor", "Unable to executor runnable", e10);
            runnable2.run();
        }
    }

    private void p(final B b10, final Map<GLUtils.InputFormat, U.B> map) throws ExecutionException, InterruptedException {
        try {
            CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: V.k
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return n.l(this.f6440a, b10, map, aVar);
                }
            }).get();
        } catch (InterruptedException | ExecutionException e10) {
            e = e10;
            if (e instanceof ExecutionException) {
                e = e.getCause();
            }
            if (!(e instanceof RuntimeException)) {
                throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
            }
            throw ((RuntimeException) e);
        }
    }

    @Override // D.s0
    public void a(final SurfaceRequest surfaceRequest) throws ProcessingException {
        if (this.f6451g.get()) {
            surfaceRequest.u();
            return;
        }
        Runnable runnable = new Runnable() { // from class: V.j
            @Override // java.lang.Runnable
            public final void run() throws ExecutionException, InterruptedException {
                n.j(this.f6438a, surfaceRequest);
            }
        };
        Objects.requireNonNull(surfaceRequest);
        o(runnable, new RunnableC1026g(surfaceRequest));
    }

    @Override // D.s0
    public void c(final r0 r0Var) throws ProcessingException {
        if (this.f6451g.get()) {
            r0Var.close();
            return;
        }
        Runnable runnable = new Runnable() { // from class: V.l
            @Override // java.lang.Runnable
            public final void run() {
                n.i(this.f6443a, r0Var);
            }
        };
        Objects.requireNonNull(r0Var);
        o(runnable, new RunnableC1024e(r0Var));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        if (this.f6451g.get() || (surfaceTexture2 = this.f6453i) == null || this.f6454j == null) {
            return;
        }
        surfaceTexture2.updateTexImage();
        this.f6454j.updateTexImage();
        for (Map.Entry<r0, Surface> entry : this.f6452h.entrySet()) {
            Surface value = entry.getValue();
            r0 key = entry.getKey();
            if (key.getFormat() == 34) {
                try {
                    this.f6445a.v(surfaceTexture.getTimestamp(), value, key, this.f6453i, this.f6454j);
                } catch (RuntimeException e10) {
                    C0761b0.d("DualSurfaceProcessor", "Failed to render with OpenGL.", e10);
                }
            }
        }
    }

    @Override // U.Q
    public void release() {
        if (this.f6451g.getAndSet(true)) {
            return;
        }
        n(new Runnable() { // from class: V.i
            @Override // java.lang.Runnable
            public final void run() {
                n.g(this.f6437a);
            }
        });
    }

    public n(B b10, Map<GLUtils.InputFormat, U.B> map, A a10, A a11) throws ExecutionException, InterruptedException {
        this.f6449e = 0;
        this.f6450f = false;
        this.f6451g = new AtomicBoolean(false);
        this.f6452h = new LinkedHashMap();
        HandlerThread handlerThread = new HandlerThread("CameraX-GL Thread");
        this.f6446b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f6448d = handler;
        this.f6447c = N.a.e(handler);
        this.f6445a = new b(a10, a11);
        try {
            p(b10, map);
        } catch (RuntimeException e10) {
            release();
            throw e10;
        }
    }
}
