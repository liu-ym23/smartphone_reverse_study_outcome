package U;

import D.C0761b0;
import D.r0;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.util.GLUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;
import m.InterfaceC4887a;

/* renamed from: U.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1037s implements Q, SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final C1043y f6128a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f6129b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f6130c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f6131d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f6132e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f6133f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f6134g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<r0, Surface> f6135h;

    /* renamed from: i, reason: collision with root package name */
    public int f6136i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6137j;

    /* renamed from: k, reason: collision with root package name */
    public final List<b> f6138k;

    /* renamed from: U.s$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static InterfaceC4887a<D.B, Q> f6139a = new InterfaceC4887a() { // from class: U.r
            @Override // m.InterfaceC4887a
            public final Object apply(Object obj) {
                return new C1037s((D.B) obj);
            }
        };

        public static Q a(D.B b10) {
            return f6139a.apply(b10);
        }
    }

    /* renamed from: U.s$b */
    public static abstract class b {
        public static C1020a d(int i10, int i11, CallbackToFutureAdapter.a<Void> aVar) {
            return new C1020a(i10, i11, aVar);
        }

        public abstract CallbackToFutureAdapter.a<Void> a();

        public abstract int b();

        public abstract int c();
    }

    public C1037s(D.B b10) {
        this(b10, Collections.EMPTY_MAP);
    }

    public static /* synthetic */ void e(C1037s c1037s, SurfaceRequest surfaceRequest, SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.f fVar) {
        c1037s.getClass();
        surfaceRequest.k();
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
        surface.release();
        c1037s.f6136i--;
        c1037s.q();
    }

    public static /* synthetic */ void f(C1037s c1037s) {
        c1037s.f6137j = true;
        c1037s.q();
    }

    public static /* synthetic */ void g(C1037s c1037s, D.B b10, Map map, CallbackToFutureAdapter.a aVar) {
        c1037s.getClass();
        try {
            c1037s.f6128a.h(b10, map);
            aVar.c(null);
        } catch (RuntimeException e10) {
            aVar.f(e10);
        }
    }

    public static /* synthetic */ Object h(final C1037s c1037s, int i10, int i11, final CallbackToFutureAdapter.a aVar) {
        c1037s.getClass();
        final C1020a c1020aD = b.d(i10, i11, aVar);
        c1037s.s(new Runnable() { // from class: U.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f6122a.f6138k.add(c1020aD);
            }
        }, new Runnable() { // from class: U.p
            @Override // java.lang.Runnable
            public final void run() {
                aVar.f(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
            }
        });
        return "DefaultSurfaceProcessor#snapshot";
    }

    public static /* synthetic */ void i(C1037s c1037s, SurfaceRequest surfaceRequest, SurfaceRequest.g gVar) {
        c1037s.getClass();
        GLUtils.InputFormat inputFormat = GLUtils.InputFormat.DEFAULT;
        if (surfaceRequest.m().d() && gVar.e()) {
            inputFormat = GLUtils.InputFormat.YUV;
        }
        c1037s.f6128a.o(inputFormat);
    }

    public static /* synthetic */ void j(final C1037s c1037s, final r0 r0Var) {
        Surface surfaceQ = r0Var.Q(c1037s.f6130c, new B0.a() { // from class: U.c
            @Override // B0.a
            public final void accept(Object obj) {
                C1037s.k(this.f6097a, r0Var, (r0.b) obj);
            }
        });
        c1037s.f6128a.j(surfaceQ);
        c1037s.f6135h.put(r0Var, surfaceQ);
    }

    public static /* synthetic */ void k(C1037s c1037s, r0 r0Var, r0.b bVar) {
        c1037s.getClass();
        r0Var.close();
        Surface surfaceRemove = c1037s.f6135h.remove(r0Var);
        if (surfaceRemove != null) {
            c1037s.f6128a.r(surfaceRemove);
        }
    }

    public static /* synthetic */ Object l(final C1037s c1037s, final D.B b10, final Map map, final CallbackToFutureAdapter.a aVar) {
        c1037s.getClass();
        c1037s.r(new Runnable() { // from class: U.k
            @Override // java.lang.Runnable
            public final void run() {
                C1037s.g(this.f6112a, b10, map, aVar);
            }
        });
        return "Init GlRenderer";
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void o(final C1037s c1037s, final SurfaceRequest surfaceRequest) throws ExecutionException, InterruptedException {
        c1037s.f6136i++;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(c1037s.f6128a.g());
        surfaceTexture.setDefaultBufferSize(surfaceRequest.n().getWidth(), surfaceRequest.n().getHeight());
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.s(c1037s.f6130c, new SurfaceRequest.h() { // from class: U.i
            @Override // androidx.camera.core.SurfaceRequest.h
            public final void a(SurfaceRequest.g gVar) {
                C1037s.i(this.f6106a, surfaceRequest, gVar);
            }
        });
        surfaceRequest.r(surface, c1037s.f6130c, new B0.a() { // from class: U.j
            @Override // B0.a
            public final void accept(Object obj) {
                C1037s.e(this.f6108a, surfaceRequest, surfaceTexture, surface, (SurfaceRequest.f) obj);
            }
        });
        surfaceTexture.setOnFrameAvailableListener(c1037s, c1037s.f6131d);
    }

    public static /* synthetic */ void p(C1037s c1037s, Runnable runnable, Runnable runnable2) {
        if (c1037s.f6137j) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    @Override // D.s0
    public void a(final SurfaceRequest surfaceRequest) {
        if (this.f6132e.get()) {
            surfaceRequest.u();
            return;
        }
        Runnable runnable = new Runnable() { // from class: U.f
            @Override // java.lang.Runnable
            public final void run() throws ExecutionException, InterruptedException {
                C1037s.o(this.f6102a, surfaceRequest);
            }
        };
        Objects.requireNonNull(surfaceRequest);
        s(runnable, new RunnableC1026g(surfaceRequest));
    }

    @Override // U.Q
    public InterfaceFutureC4095a<Void> b(final int i10, final int i11) {
        return O.f.i(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: U.n
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return C1037s.h(this.f6119a, i10, i11, aVar);
            }
        }));
    }

    @Override // D.s0
    public void c(final r0 r0Var) {
        if (this.f6132e.get()) {
            r0Var.close();
            return;
        }
        Runnable runnable = new Runnable() { // from class: U.d
            @Override // java.lang.Runnable
            public final void run() {
                C1037s.j(this.f6099a, r0Var);
            }
        };
        Objects.requireNonNull(r0Var);
        s(runnable, new RunnableC1024e(r0Var));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) throws IOException {
        if (this.f6132e.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.f6133f);
        Triple<Surface, Size, float[]> triple = null;
        for (Map.Entry<r0, Surface> entry : this.f6135h.entrySet()) {
            Surface value = entry.getValue();
            r0 key = entry.getKey();
            key.B0(this.f6134g, this.f6133f);
            if (key.getFormat() == 34) {
                try {
                    this.f6128a.n(surfaceTexture.getTimestamp(), this.f6134g, value);
                } catch (RuntimeException e10) {
                    C0761b0.d("DefaultSurfaceProcessor", "Failed to render with OpenGL.", e10);
                }
            } else {
                B0.h.i(key.getFormat() == 256, "Unsupported format: " + key.getFormat());
                B0.h.i(triple == null, "Only one JPEG output is supported.");
                triple = new Triple<>(value, key.getSize(), (float[]) this.f6134g.clone());
            }
        }
        try {
            w(triple);
        } catch (RuntimeException e11) {
            t(e11);
        }
    }

    public final void q() {
        if (this.f6137j && this.f6136i == 0) {
            Iterator<r0> it = this.f6135h.keySet().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            Iterator<b> it2 = this.f6138k.iterator();
            while (it2.hasNext()) {
                it2.next().a().f(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            this.f6135h.clear();
            this.f6128a.k();
            this.f6129b.quit();
        }
    }

    public final void r(Runnable runnable) {
        s(runnable, new Runnable() { // from class: U.l
            @Override // java.lang.Runnable
            public final void run() {
                C1037s.m();
            }
        });
    }

    @Override // U.Q
    public void release() {
        if (this.f6132e.getAndSet(true)) {
            return;
        }
        r(new Runnable() { // from class: U.h
            @Override // java.lang.Runnable
            public final void run() {
                C1037s.f(this.f6105a);
            }
        });
    }

    public final void s(final Runnable runnable, final Runnable runnable2) {
        try {
            this.f6130c.execute(new Runnable() { // from class: U.m
                @Override // java.lang.Runnable
                public final void run() {
                    C1037s.p(this.f6116a, runnable2, runnable);
                }
            });
        } catch (RejectedExecutionException e10) {
            C0761b0.p("DefaultSurfaceProcessor", "Unable to executor runnable", e10);
            runnable2.run();
        }
    }

    public final void t(Throwable th) {
        Iterator<b> it = this.f6138k.iterator();
        while (it.hasNext()) {
            it.next().a().f(th);
        }
        this.f6138k.clear();
    }

    public final Bitmap u(Size size, float[] fArr, int i10) {
        float[] fArr2 = (float[]) fArr.clone();
        M.k.c(fArr2, i10, 0.5f, 0.5f);
        M.k.d(fArr2, 0.5f);
        return this.f6128a.p(M.o.o(size, i10), fArr2);
    }

    public final void v(final D.B b10, final Map<GLUtils.InputFormat, B> map) throws ExecutionException, InterruptedException {
        try {
            CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: U.q
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return C1037s.l(this.f6125a, b10, map, aVar);
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

    public final void w(Triple<Surface, Size, float[]> triple) throws IOException {
        if (this.f6138k.isEmpty()) {
            return;
        }
        if (triple == null) {
            t(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator<b> it = this.f6138k.iterator();
                int iC = -1;
                int iB = -1;
                Bitmap bitmapU = null;
                byte[] byteArray = null;
                while (it.hasNext()) {
                    b next = it.next();
                    if (iC != next.c() || bitmapU == null) {
                        iC = next.c();
                        if (bitmapU != null) {
                            bitmapU.recycle();
                        }
                        bitmapU = u(triple.e(), triple.f(), iC);
                        iB = -1;
                    }
                    if (iB != next.b()) {
                        byteArrayOutputStream.reset();
                        iB = next.b();
                        bitmapU.compress(Bitmap.CompressFormat.JPEG, iB, byteArrayOutputStream);
                        byteArray = byteArrayOutputStream.toByteArray();
                    }
                    Surface surfaceD = triple.d();
                    Objects.requireNonNull(byteArray);
                    ImageProcessingUtil.q(surfaceD, byteArray);
                    next.a().c(null);
                    it.remove();
                }
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (IOException e10) {
            t(e10);
        }
    }

    public C1037s(D.B b10, Map<GLUtils.InputFormat, B> map) throws ExecutionException, InterruptedException {
        this.f6132e = new AtomicBoolean(false);
        this.f6133f = new float[16];
        this.f6134g = new float[16];
        this.f6135h = new LinkedHashMap();
        this.f6136i = 0;
        this.f6137j = false;
        this.f6138k = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("CameraX-GL Thread");
        this.f6129b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f6131d = handler;
        this.f6130c = N.a.e(handler);
        this.f6128a = new C1043y();
        try {
            v(b10, map);
        } catch (RuntimeException e10) {
            release();
            throw e10;
        }
    }
}
