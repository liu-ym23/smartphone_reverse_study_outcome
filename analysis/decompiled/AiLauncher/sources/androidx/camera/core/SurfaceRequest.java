package androidx.camera.core;

import D.B;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.y;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SurfaceRequest {

    /* renamed from: q, reason: collision with root package name */
    public static final Range<Integer> f11219q = y.f11539a;

    /* renamed from: a, reason: collision with root package name */
    public final Object f11220a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Size f11221b;

    /* renamed from: c, reason: collision with root package name */
    public final B f11222c;

    /* renamed from: d, reason: collision with root package name */
    public final Range<Integer> f11223d;

    /* renamed from: e, reason: collision with root package name */
    public final CameraInternal f11224e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11225f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11226g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceFutureC4095a<Surface> f11227h;

    /* renamed from: i, reason: collision with root package name */
    public final CallbackToFutureAdapter.a<Surface> f11228i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceFutureC4095a<Void> f11229j;

    /* renamed from: k, reason: collision with root package name */
    public final CallbackToFutureAdapter.a<Void> f11230k;

    /* renamed from: l, reason: collision with root package name */
    public final CallbackToFutureAdapter.a<Void> f11231l;

    /* renamed from: m, reason: collision with root package name */
    public final DeferrableSurface f11232m;

    /* renamed from: n, reason: collision with root package name */
    public g f11233n;

    /* renamed from: o, reason: collision with root package name */
    public h f11234o;

    /* renamed from: p, reason: collision with root package name */
    public Executor f11235p;

    public static final class RequestCancelledException extends RuntimeException {
        public RequestCancelledException(String str, Throwable th) {
            super(str, th);
        }
    }

    public class a implements O.c<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f11236a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceFutureC4095a f11237b;

        public a(CallbackToFutureAdapter.a aVar, InterfaceFutureC4095a interfaceFutureC4095a) {
            this.f11236a = aVar;
            this.f11237b = interfaceFutureC4095a;
        }

        @Override // O.c
        public void b(Throwable th) {
            if (th instanceof RequestCancelledException) {
                B0.h.h(this.f11237b.cancel(false));
            } else {
                B0.h.h(this.f11236a.c(null));
            }
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r12) {
            B0.h.h(this.f11236a.c(null));
        }
    }

    public class b extends DeferrableSurface {
        public b(Size size, int i10) {
            super(size, i10);
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public InterfaceFutureC4095a<Surface> o() {
            return SurfaceRequest.this.f11227h;
        }
    }

    public class c implements O.c<Surface> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceFutureC4095a f11240a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f11241b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f11242c;

        public c(InterfaceFutureC4095a interfaceFutureC4095a, CallbackToFutureAdapter.a aVar, String str) {
            this.f11240a = interfaceFutureC4095a;
            this.f11241b = aVar;
            this.f11242c = str;
        }

        @Override // O.c
        public void b(Throwable th) {
            if (!(th instanceof CancellationException)) {
                this.f11241b.c(null);
                return;
            }
            B0.h.h(this.f11241b.f(new RequestCancelledException(this.f11242c + " cancelled.", th)));
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Surface surface) {
            O.f.j(this.f11240a, this.f11241b);
        }
    }

    public class d implements O.c<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ B0.a f11244a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Surface f11245b;

        public d(B0.a aVar, Surface surface) {
            this.f11244a = aVar;
            this.f11245b = surface;
        }

        @Override // O.c
        public void b(Throwable th) {
            B0.h.i(th instanceof RequestCancelledException, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th);
            this.f11244a.accept(f.c(1, this.f11245b));
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r22) {
            this.f11244a.accept(f.c(0, this.f11245b));
        }
    }

    public class e implements O.c<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f11247a;

        public e(Runnable runnable) {
            this.f11247a = runnable;
        }

        @Override // O.c
        public void b(Throwable th) {
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r12) {
            this.f11247a.run();
        }
    }

    public static abstract class f {
        public static f c(int i10, Surface surface) {
            return new androidx.camera.core.d(i10, surface);
        }

        public abstract int a();

        public abstract Surface b();
    }

    public static abstract class g {
        public static g g(Rect rect, int i10, int i11, boolean z10, Matrix matrix, boolean z11) {
            return new androidx.camera.core.e(rect, i10, i11, z10, matrix, z11);
        }

        public abstract Rect a();

        public abstract int b();

        public abstract Matrix c();

        public abstract int d();

        public abstract boolean e();

        public abstract boolean f();
    }

    public interface h {
        void a(g gVar);
    }

    public SurfaceRequest(Size size, CameraInternal cameraInternal, boolean z10, B b10, int i10, Range<Integer> range, Runnable runnable) {
        this.f11221b = size;
        this.f11224e = cameraInternal;
        this.f11225f = z10;
        B0.h.b(b10.e(), "SurfaceRequest's DynamicRange must always be fully specified.");
        this.f11222c = b10;
        this.f11226g = i10;
        this.f11223d = range;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        InterfaceFutureC4095a interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: D.y0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return SurfaceRequest.a(atomicReference, str, aVar);
            }
        });
        CallbackToFutureAdapter.a<Void> aVar = (CallbackToFutureAdapter.a) B0.h.f((CallbackToFutureAdapter.a) atomicReference.get());
        this.f11231l = aVar;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        InterfaceFutureC4095a<Void> interfaceFutureC4095aA2 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: D.z0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar2) {
                return SurfaceRequest.j(atomicReference2, str, aVar2);
            }
        });
        this.f11229j = interfaceFutureC4095aA2;
        O.f.b(interfaceFutureC4095aA2, new a(aVar, interfaceFutureC4095aA), N.a.a());
        CallbackToFutureAdapter.a aVar2 = (CallbackToFutureAdapter.a) B0.h.f((CallbackToFutureAdapter.a) atomicReference2.get());
        final AtomicReference atomicReference3 = new AtomicReference(null);
        InterfaceFutureC4095a<Surface> interfaceFutureC4095aA3 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: D.A0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar3) {
                return SurfaceRequest.c(atomicReference3, str, aVar3);
            }
        });
        this.f11227h = interfaceFutureC4095aA3;
        this.f11228i = (CallbackToFutureAdapter.a) B0.h.f((CallbackToFutureAdapter.a) atomicReference3.get());
        b bVar = new b(size, 34);
        this.f11232m = bVar;
        InterfaceFutureC4095a<Void> interfaceFutureC4095aK = bVar.k();
        O.f.b(interfaceFutureC4095aA3, new c(interfaceFutureC4095aK, aVar2, str), N.a.a());
        interfaceFutureC4095aK.a(new Runnable() { // from class: D.B0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2007a.f11227h.cancel(true);
            }
        }, N.a.a());
        this.f11230k = o(N.a.a(), runnable);
    }

    public static /* synthetic */ Object a(AtomicReference atomicReference, String str, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return str + "-cancellation";
    }

    public static /* synthetic */ Object c(AtomicReference atomicReference, String str, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return str + "-Surface";
    }

    public static /* synthetic */ Object g(SurfaceRequest surfaceRequest, AtomicReference atomicReference, CallbackToFutureAdapter.a aVar) {
        surfaceRequest.getClass();
        atomicReference.set(aVar);
        return "SurfaceRequest-surface-recreation(" + surfaceRequest.hashCode() + ")";
    }

    public static /* synthetic */ Object j(AtomicReference atomicReference, String str, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return str + "-status";
    }

    public void k() {
        synchronized (this.f11220a) {
            this.f11234o = null;
            this.f11235p = null;
        }
    }

    public DeferrableSurface l() {
        return this.f11232m;
    }

    public B m() {
        return this.f11222c;
    }

    public Size n() {
        return this.f11221b;
    }

    public final CallbackToFutureAdapter.a<Void> o(Executor executor, Runnable runnable) {
        final AtomicReference atomicReference = new AtomicReference(null);
        O.f.b(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: D.C0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return SurfaceRequest.g(this.f2008a, atomicReference, aVar);
            }
        }), new e(runnable), executor);
        return (CallbackToFutureAdapter.a) B0.h.f((CallbackToFutureAdapter.a) atomicReference.get());
    }

    public boolean p() {
        u();
        return this.f11230k.c(null);
    }

    public boolean q() {
        return this.f11225f;
    }

    public void r(final Surface surface, Executor executor, final B0.a<f> aVar) throws ExecutionException, InterruptedException {
        if (!surface.isValid()) {
            executor.execute(new Runnable() { // from class: D.v0
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.accept(SurfaceRequest.f.c(2, surface));
                }
            });
            return;
        }
        if (this.f11228i.c(surface) || this.f11227h.isCancelled()) {
            O.f.b(this.f11229j, new d(aVar, surface), executor);
            return;
        }
        B0.h.h(this.f11227h.isDone());
        try {
            this.f11227h.get();
            executor.execute(new Runnable() { // from class: D.w0
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.accept(SurfaceRequest.f.c(3, surface));
                }
            });
        } catch (InterruptedException | ExecutionException unused) {
            executor.execute(new Runnable() { // from class: D.x0
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.accept(SurfaceRequest.f.c(4, surface));
                }
            });
        }
    }

    public void s(Executor executor, final h hVar) {
        final g gVar;
        synchronized (this.f11220a) {
            this.f11234o = hVar;
            this.f11235p = executor;
            gVar = this.f11233n;
        }
        if (gVar != null) {
            executor.execute(new Runnable() { // from class: D.t0
                @Override // java.lang.Runnable
                public final void run() {
                    hVar.a(gVar);
                }
            });
        }
    }

    public void t(final g gVar) {
        final h hVar;
        Executor executor;
        synchronized (this.f11220a) {
            this.f11233n = gVar;
            hVar = this.f11234o;
            executor = this.f11235p;
        }
        if (hVar == null || executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: D.u0
            @Override // java.lang.Runnable
            public final void run() {
                hVar.a(gVar);
            }
        });
    }

    public boolean u() {
        return this.f11228i.f(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }
}
