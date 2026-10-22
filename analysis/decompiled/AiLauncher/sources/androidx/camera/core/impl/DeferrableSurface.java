package androidx.camera.core.impl;

import D.C0761b0;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class DeferrableSurface {

    /* renamed from: k, reason: collision with root package name */
    public static final Size f11320k = new Size(0, 0);

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f11321l = C0761b0.f("DeferrableSurface");

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicInteger f11322m = new AtomicInteger(0);

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicInteger f11323n = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public final Object f11324a;

    /* renamed from: b, reason: collision with root package name */
    public int f11325b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11326c;

    /* renamed from: d, reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f11327d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceFutureC4095a<Void> f11328e;

    /* renamed from: f, reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f11329f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceFutureC4095a<Void> f11330g;

    /* renamed from: h, reason: collision with root package name */
    public final Size f11331h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11332i;

    /* renamed from: j, reason: collision with root package name */
    public Class<?> f11333j;

    public static final class SurfaceClosedException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public DeferrableSurface f11334a;

        public SurfaceClosedException(String str, DeferrableSurface deferrableSurface) {
            super(str);
            this.f11334a = deferrableSurface;
        }

        public DeferrableSurface a() {
            return this.f11334a;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(String str) {
            super(str);
        }
    }

    public DeferrableSurface() {
        this(f11320k, 0);
    }

    public static /* synthetic */ Object a(DeferrableSurface deferrableSurface, CallbackToFutureAdapter.a aVar) {
        synchronized (deferrableSurface.f11324a) {
            deferrableSurface.f11327d = aVar;
        }
        return "DeferrableSurface-termination(" + deferrableSurface + ")";
    }

    public static /* synthetic */ Object b(DeferrableSurface deferrableSurface, CallbackToFutureAdapter.a aVar) {
        synchronized (deferrableSurface.f11324a) {
            deferrableSurface.f11329f = aVar;
        }
        return "DeferrableSurface-close(" + deferrableSurface + ")";
    }

    public static /* synthetic */ void c(DeferrableSurface deferrableSurface, String str) throws ExecutionException, InterruptedException {
        deferrableSurface.getClass();
        try {
            deferrableSurface.f11328e.get();
            deferrableSurface.n("Surface terminated", f11323n.decrementAndGet(), f11322m.get());
        } catch (Exception e10) {
            C0761b0.c("DeferrableSurface", "Unexpected surface termination for " + deferrableSurface + "\nStack Trace:\n" + str);
            synchronized (deferrableSurface.f11324a) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", deferrableSurface, Boolean.valueOf(deferrableSurface.f11326c), Integer.valueOf(deferrableSurface.f11325b)), e10);
            }
        }
    }

    public void d() {
        CallbackToFutureAdapter.a<Void> aVar;
        synchronized (this.f11324a) {
            try {
                if (this.f11326c) {
                    aVar = null;
                } else {
                    this.f11326c = true;
                    this.f11329f.c(null);
                    if (this.f11325b == 0) {
                        aVar = this.f11327d;
                        this.f11327d = null;
                    } else {
                        aVar = null;
                    }
                    if (C0761b0.f("DeferrableSurface")) {
                        C0761b0.a("DeferrableSurface", "surface closed,  useCount=" + this.f11325b + " closed=true " + this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public void e() {
        CallbackToFutureAdapter.a<Void> aVar;
        synchronized (this.f11324a) {
            try {
                int i10 = this.f11325b;
                if (i10 == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                int i11 = i10 - 1;
                this.f11325b = i11;
                if (i11 == 0 && this.f11326c) {
                    aVar = this.f11327d;
                    this.f11327d = null;
                } else {
                    aVar = null;
                }
                if (C0761b0.f("DeferrableSurface")) {
                    C0761b0.a("DeferrableSurface", "use count-1,  useCount=" + this.f11325b + " closed=" + this.f11326c + " " + this);
                    if (this.f11325b == 0) {
                        n("Surface no longer in use", f11323n.get(), f11322m.decrementAndGet());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public InterfaceFutureC4095a<Void> f() {
        return O.f.i(this.f11330g);
    }

    public Class<?> g() {
        return this.f11333j;
    }

    public Size h() {
        return this.f11331h;
    }

    public int i() {
        return this.f11332i;
    }

    public final InterfaceFutureC4095a<Surface> j() {
        synchronized (this.f11324a) {
            try {
                if (this.f11326c) {
                    return O.f.f(new SurfaceClosedException("DeferrableSurface already closed.", this));
                }
                return o();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public InterfaceFutureC4095a<Void> k() {
        return O.f.i(this.f11328e);
    }

    public void l() throws SurfaceClosedException {
        synchronized (this.f11324a) {
            try {
                int i10 = this.f11325b;
                if (i10 == 0 && this.f11326c) {
                    throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
                this.f11325b = i10 + 1;
                if (C0761b0.f("DeferrableSurface")) {
                    if (this.f11325b == 1) {
                        n("New surface in use", f11323n.get(), f11322m.incrementAndGet());
                    }
                    C0761b0.a("DeferrableSurface", "use count+1, useCount=" + this.f11325b + " " + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean m() {
        boolean z10;
        synchronized (this.f11324a) {
            z10 = this.f11326c;
        }
        return z10;
    }

    public final void n(String str, int i10, int i11) {
        if (!f11321l && C0761b0.f("DeferrableSurface")) {
            C0761b0.a("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        C0761b0.a("DeferrableSurface", str + "[total_surfaces=" + i10 + ", used_surfaces=" + i11 + "](" + this + "}");
    }

    public abstract InterfaceFutureC4095a<Surface> o();

    public void p(Class<?> cls) {
        this.f11333j = cls;
    }

    public DeferrableSurface(Size size, int i10) {
        this.f11324a = new Object();
        this.f11325b = 0;
        this.f11326c = false;
        this.f11331h = size;
        this.f11332i = i10;
        InterfaceFutureC4095a<Void> interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: K.S
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return DeferrableSurface.a(this.f3927a, aVar);
            }
        });
        this.f11328e = interfaceFutureC4095aA;
        this.f11330g = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: K.T
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return DeferrableSurface.b(this.f3928a, aVar);
            }
        });
        if (C0761b0.f("DeferrableSurface")) {
            n("Surface created", f11323n.incrementAndGet(), f11322m.get());
            final String stackTraceString = Log.getStackTraceString(new Exception());
            interfaceFutureC4095aA.a(new Runnable() { // from class: K.U
                @Override // java.lang.Runnable
                public final void run() throws ExecutionException, InterruptedException {
                    DeferrableSurface.c(this.f3929a, stackTraceString);
                }
            }, N.a.a());
        }
    }
}
