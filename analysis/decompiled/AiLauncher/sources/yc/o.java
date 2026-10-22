package yc;

import Mb.AbstractC0974l;
import Mb.C0966d;
import Mb.I;
import Mb.InterfaceC0968f;
import java.io.IOException;
import java.util.Objects;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.InterfaceC5539f;

/* loaded from: classes5.dex */
public final class o<T> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final u f44349a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f44350b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f44351c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5538e.a f44352d;

    /* renamed from: e, reason: collision with root package name */
    public final h<AbstractC5531D, T> f44353e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f44354f;

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC5538e f44355g;

    /* renamed from: h, reason: collision with root package name */
    public Throwable f44356h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f44357i;

    public class a implements InterfaceC5539f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f44358a;

        public a(f fVar) {
            this.f44358a = fVar;
        }

        @Override // tb.InterfaceC5539f
        public void a(InterfaceC5538e interfaceC5538e, C5530C c5530c) {
            try {
                try {
                    this.f44358a.a(o.this, o.this.g(c5530c));
                } catch (Throwable th) {
                    A.t(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                A.t(th2);
                b(th2);
            }
        }

        public final void b(Throwable th) {
            try {
                this.f44358a.b(o.this, th);
            } catch (Throwable th2) {
                A.t(th2);
                th2.printStackTrace();
            }
        }

        @Override // tb.InterfaceC5539f
        public void d(InterfaceC5538e interfaceC5538e, IOException iOException) {
            b(iOException);
        }
    }

    public static final class b extends AbstractC5531D {

        /* renamed from: d, reason: collision with root package name */
        public final AbstractC5531D f44360d;

        /* renamed from: e, reason: collision with root package name */
        public final InterfaceC0968f f44361e;

        /* renamed from: f, reason: collision with root package name */
        public IOException f44362f;

        public class a extends AbstractC0974l {
            public a(I i10) {
                super(i10);
            }

            @Override // Mb.AbstractC0974l, Mb.I
            public long u0(C0966d c0966d, long j10) throws IOException {
                try {
                    return super.u0(c0966d, j10);
                } catch (IOException e10) {
                    b.this.f44362f = e10;
                    throw e10;
                }
            }
        }

        public b(AbstractC5531D abstractC5531D) {
            this.f44360d = abstractC5531D;
            this.f44361e = Mb.u.c(new a(abstractC5531D.getSource()));
        }

        public void G() throws IOException {
            IOException iOException = this.f44362f;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // tb.AbstractC5531D, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f44360d.close();
        }

        @Override // tb.AbstractC5531D
        /* renamed from: i */
        public long getContentLength() {
            return this.f44360d.getContentLength();
        }

        @Override // tb.AbstractC5531D
        /* renamed from: l */
        public tb.x getMediaType() {
            return this.f44360d.getMediaType();
        }

        @Override // tb.AbstractC5531D
        /* renamed from: n */
        public InterfaceC0968f getSource() {
            return this.f44361e;
        }
    }

    public static final class c extends AbstractC5531D {

        /* renamed from: d, reason: collision with root package name */
        public final tb.x f44364d;

        /* renamed from: e, reason: collision with root package name */
        public final long f44365e;

        public c(tb.x xVar, long j10) {
            this.f44364d = xVar;
            this.f44365e = j10;
        }

        @Override // tb.AbstractC5531D
        /* renamed from: i */
        public long getContentLength() {
            return this.f44365e;
        }

        @Override // tb.AbstractC5531D
        /* renamed from: l */
        public tb.x getMediaType() {
            return this.f44364d;
        }

        @Override // tb.AbstractC5531D
        /* renamed from: n */
        public InterfaceC0968f getSource() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public o(u uVar, Object obj, Object[] objArr, InterfaceC5538e.a aVar, h<AbstractC5531D, T> hVar) {
        this.f44349a = uVar;
        this.f44350b = obj;
        this.f44351c = objArr;
        this.f44352d = aVar;
        this.f44353e = hVar;
    }

    @Override // yc.d
    public void A(f<T> fVar) {
        InterfaceC5538e interfaceC5538e;
        Throwable th;
        Objects.requireNonNull(fVar, "callback == null");
        synchronized (this) {
            try {
                if (this.f44357i) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f44357i = true;
                interfaceC5538e = this.f44355g;
                th = this.f44356h;
                if (interfaceC5538e == null && th == null) {
                    try {
                        InterfaceC5538e interfaceC5538eD = d();
                        this.f44355g = interfaceC5538eD;
                        interfaceC5538e = interfaceC5538eD;
                    } catch (Throwable th2) {
                        th = th2;
                        A.t(th);
                        this.f44356h = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            fVar.b(this, th);
            return;
        }
        if (this.f44354f) {
            interfaceC5538e.cancel();
        }
        interfaceC5538e.J(new a(fVar));
    }

    @Override // yc.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o<T> clone() {
        return new o<>(this.f44349a, this.f44350b, this.f44351c, this.f44352d, this.f44353e);
    }

    @Override // yc.d
    public synchronized C5528A b() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create request.", e10);
        }
        return f().getOriginalRequest();
    }

    @Override // yc.d
    public void cancel() {
        InterfaceC5538e interfaceC5538e;
        this.f44354f = true;
        synchronized (this) {
            interfaceC5538e = this.f44355g;
        }
        if (interfaceC5538e != null) {
            interfaceC5538e.cancel();
        }
    }

    public final InterfaceC5538e d() throws IOException {
        InterfaceC5538e interfaceC5538eA = this.f44352d.a(this.f44349a.a(this.f44350b, this.f44351c));
        if (interfaceC5538eA != null) {
            return interfaceC5538eA;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    @Override // yc.d
    public boolean e() {
        boolean z10 = true;
        if (this.f44354f) {
            return true;
        }
        synchronized (this) {
            try {
                InterfaceC5538e interfaceC5538e = this.f44355g;
                if (interfaceC5538e == null || !interfaceC5538e.getCanceled()) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    public final InterfaceC5538e f() throws IOException {
        InterfaceC5538e interfaceC5538e = this.f44355g;
        if (interfaceC5538e != null) {
            return interfaceC5538e;
        }
        Throwable th = this.f44356h;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            InterfaceC5538e interfaceC5538eD = d();
            this.f44355g = interfaceC5538eD;
            return interfaceC5538eD;
        } catch (IOException | Error | RuntimeException e10) {
            A.t(e10);
            this.f44356h = e10;
            throw e10;
        }
    }

    public v<T> g(C5530C c5530c) throws IOException {
        AbstractC5531D body = c5530c.getBody();
        C5530C c5530cC = c5530c.e0().b(new c(body.getMediaType(), body.getContentLength())).c();
        int code = c5530cC.getCode();
        if (code < 200 || code >= 300) {
            try {
                return v.c(A.a(body), c5530cC);
            } finally {
                body.close();
            }
        }
        if (code == 204 || code == 205) {
            body.close();
            return v.i(null, c5530cC);
        }
        b bVar = new b(body);
        try {
            return v.i(this.f44353e.convert(bVar), c5530cC);
        } catch (RuntimeException e10) {
            bVar.G();
            throw e10;
        }
    }
}
