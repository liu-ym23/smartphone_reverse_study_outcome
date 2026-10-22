package androidx.camera.core;

import D.B;
import D.C0761b0;
import D.InterfaceC0778o;
import D.S;
import H.ImageFormatFeature;
import J.C;
import J.D;
import J.K;
import J.d0;
import K.C0877d;
import K.InterfaceC0872a0;
import K.InterfaceC0898v;
import K.z0;
import M.n;
import X.c;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.location.Location;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.internal.utils.ImageUtil;
import g3.InterfaceFutureC4095a;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import m.InterfaceC4887a;

/* loaded from: classes.dex */
public final class ImageCapture extends UseCase {

    /* renamed from: H, reason: collision with root package name */
    public static final c f11170H = new c();

    /* renamed from: I, reason: collision with root package name */
    public static final S.b f11171I = new S.b();

    /* renamed from: A, reason: collision with root package name */
    public Rational f11172A;

    /* renamed from: B, reason: collision with root package name */
    public P.g f11173B;

    /* renamed from: C, reason: collision with root package name */
    public SessionConfig.b f11174C;

    /* renamed from: D, reason: collision with root package name */
    public D f11175D;

    /* renamed from: E, reason: collision with root package name */
    public d0 f11176E;

    /* renamed from: F, reason: collision with root package name */
    public SessionConfig.c f11177F;

    /* renamed from: G, reason: collision with root package name */
    public final C f11178G;

    /* renamed from: v, reason: collision with root package name */
    public final InterfaceC0872a0.a f11179v;

    /* renamed from: w, reason: collision with root package name */
    public final int f11180w;

    /* renamed from: x, reason: collision with root package name */
    public final AtomicReference<Integer> f11181x;

    /* renamed from: y, reason: collision with root package name */
    public final int f11182y;

    /* renamed from: z, reason: collision with root package name */
    public int f11183z;

    public interface OnImageSavedCallback {
        default void onCaptureProcessProgressed(int i10) {
        }

        default void onCaptureStarted() {
        }

        void onError(ImageCaptureException imageCaptureException);

        void onImageSaved(g gVar);

        default void onPostviewBitmapAvailable(Bitmap bitmap) {
        }
    }

    public static final class OutputFileOptions {

        /* renamed from: a, reason: collision with root package name */
        public final File f11184a;

        /* renamed from: b, reason: collision with root package name */
        public final ContentResolver f11185b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f11186c;

        /* renamed from: d, reason: collision with root package name */
        public final ContentValues f11187d;

        /* renamed from: e, reason: collision with root package name */
        public final OutputStream f11188e;

        /* renamed from: f, reason: collision with root package name */
        public final e f11189f;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public File f11190a;

            /* renamed from: b, reason: collision with root package name */
            public ContentResolver f11191b;

            /* renamed from: c, reason: collision with root package name */
            public Uri f11192c;

            /* renamed from: d, reason: collision with root package name */
            public ContentValues f11193d;

            /* renamed from: e, reason: collision with root package name */
            public OutputStream f11194e;

            /* renamed from: f, reason: collision with root package name */
            public e f11195f;

            public a(File file) {
                this.f11190a = file;
            }

            public OutputFileOptions a() {
                return new OutputFileOptions(this.f11190a, this.f11191b, this.f11192c, this.f11193d, this.f11194e, this.f11195f);
            }
        }

        public OutputFileOptions(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, e eVar) {
            this.f11184a = file;
            this.f11185b = contentResolver;
            this.f11186c = uri;
            this.f11187d = contentValues;
            this.f11188e = outputStream;
            this.f11189f = eVar == null ? new e() : eVar;
        }

        public ContentResolver a() {
            return this.f11185b;
        }

        public ContentValues b() {
            return this.f11187d;
        }

        public File c() {
            return this.f11184a;
        }

        public e d() {
            return this.f11189f;
        }

        public OutputStream e() {
            return this.f11188e;
        }

        public Uri f() {
            return this.f11186c;
        }

        public String toString() {
            return "OutputFileOptions{mFile=" + this.f11184a + ", mContentResolver=" + this.f11185b + ", mSaveCollection=" + this.f11186c + ", mContentValues=" + this.f11187d + ", mOutputStream=" + this.f11188e + ", mMetadata=" + this.f11189f + "}";
        }
    }

    public class a implements C {
        public a() {
        }

        @Override // J.C
        public InterfaceFutureC4095a<Void> a(List<androidx.camera.core.impl.l> list) {
            return ImageCapture.this.N0(list);
        }

        @Override // J.C
        public void b() {
            ImageCapture.this.I0();
        }

        @Override // J.C
        public void c() {
            ImageCapture.this.P0();
        }
    }

    public static final class b implements z.b<ImageCapture, q, b>, s.a<b> {

        /* renamed from: a, reason: collision with root package name */
        public final u f11197a;

        public b() {
            this(u.k0());
        }

        public static b f(Config config) {
            return new b(u.l0(config));
        }

        @Override // D.C
        public t a() {
            return this.f11197a;
        }

        public ImageCapture e() {
            Integer num = (Integer) a().g(q.f11472V, null);
            if (num != null) {
                a().t(r.f11483n, num);
            } else if (ImageCapture.C0(a())) {
                a().t(r.f11483n, 32);
            } else if (ImageCapture.D0(a())) {
                a().t(r.f11483n, 32);
                a().t(r.f11484o, 256);
            } else if (ImageCapture.E0(a())) {
                a().t(r.f11483n, 4101);
                a().t(r.f11485p, B.f1997c);
            } else {
                a().t(r.f11483n, 256);
            }
            q qVarD = d();
            s.y(qVarD);
            ImageCapture imageCapture = new ImageCapture(qVarD);
            Size size = (Size) a().g(s.f11490u, null);
            if (size != null) {
                imageCapture.J0(new Rational(size.getWidth(), size.getHeight()));
            }
            B0.h.g((Executor) a().g(P.e.f5330a, N.a.c()), "The IO executor can't be null");
            t tVarA = a();
            Config.a<Integer> aVar = q.f11470T;
            if (tVarA.b(aVar)) {
                Integer num2 = (Integer) a().a(aVar);
                if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set: " + num2);
                }
                if (num2.intValue() == 3 && a().g(q.f11479c0, null) == null) {
                    throw new IllegalArgumentException("A ScreenFlash instance is required for FLASH_MODE_SCREEN but was not found. If value from PreviewView.getScreenFlash() is set to ImageCapture.setScreenFlash(), ensure PreviewView.setScreenFlashWindow() is invoked first.");
                }
            }
            return imageCapture;
        }

        @Override // androidx.camera.core.impl.z.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public q d() {
            return new q(v.j0(this.f11197a));
        }

        public b h(UseCaseConfigFactory.CaptureType captureType) {
            a().t(z.f11551L, captureType);
            return this;
        }

        public b i(B b10) {
            a().t(r.f11485p, b10);
            return this;
        }

        public b j(int i10) {
            a().t(q.f11473W, Integer.valueOf(i10));
            return this;
        }

        public b k(X.c cVar) {
            a().t(s.f11494y, cVar);
            return this;
        }

        public b l(StreamUseCase streamUseCase) {
            a().t(z.f11556Q, streamUseCase);
            return this;
        }

        public b m(int i10) {
            a().t(z.f11544E, Integer.valueOf(i10));
            return this;
        }

        @Deprecated
        public b n(int i10) {
            if (i10 == -1) {
                i10 = 0;
            }
            a().t(s.f11486q, Integer.valueOf(i10));
            return this;
        }

        public b o(Class<ImageCapture> cls) {
            a().t(P.m.f5354c, cls);
            if (a().g(P.m.f5353b, null) == null) {
                p(cls.getCanonicalName() + O6.l.DATE_SEPARATOR + UUID.randomUUID());
            }
            return this;
        }

        public b p(String str) {
            a().t(P.m.f5353b, str);
            return this;
        }

        @Override // androidx.camera.core.impl.s.a
        @Deprecated
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b c(Size size) {
            a().t(s.f11490u, size);
            return this;
        }

        @Override // androidx.camera.core.impl.s.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b b(int i10) {
            a().t(s.f11487r, Integer.valueOf(i10));
            return this;
        }

        public b(u uVar) {
            this.f11197a = uVar;
            Class cls = (Class) uVar.g(P.m.f5354c, null);
            if (cls == null || cls.equals(ImageCapture.class)) {
                h(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
                o(ImageCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final StreamUseCase f11198a;

        /* renamed from: b, reason: collision with root package name */
        public static final X.c f11199b;

        /* renamed from: c, reason: collision with root package name */
        public static final q f11200c;

        /* renamed from: d, reason: collision with root package name */
        public static final B f11201d;

        static {
            StreamUseCase streamUseCase = StreamUseCase.STILL_CAPTURE;
            f11198a = streamUseCase;
            X.c cVarA = new c.a().d(X.a.f6804c).f(X.d.f6816c).a();
            f11199b = cVarA;
            B b10 = B.f1998d;
            f11201d = b10;
            f11200c = new b().m(4).l(streamUseCase).n(0).k(cVarA).j(0).i(b10).d();
        }

        public q a() {
            return f11200c;
        }
    }

    public static class d implements S {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC0778o f11202a;

        public d(InterfaceC0778o interfaceC0778o) {
            this.f11202a = interfaceC0778o;
        }

        @Override // D.S
        public Set<Integer> a() {
            Set<Integer> setB = b();
            if (setB != null) {
                return setB;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(0);
            if (d()) {
                hashSet.add(1);
            }
            if (c()) {
                hashSet.add(2);
                hashSet.add(3);
            }
            return hashSet;
        }

        public final Set<Integer> b() {
            InterfaceC0778o interfaceC0778o = this.f11202a;
            HashSet hashSet = null;
            if (!(interfaceC0778o instanceof C0877d)) {
                return null;
            }
            Config configA = ((C0877d) interfaceC0778o).b().k().a(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE, 1);
            if (configA != null) {
                Config.a<List<Pair<Integer, Size[]>>> aVar = s.f11493x;
                if (configA.b(aVar)) {
                    hashSet = new HashSet();
                    hashSet.add(0);
                    Iterator it = ((List) configA.a(aVar)).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((Integer) ((Pair) it.next()).first).intValue() == 4101) {
                            hashSet.add(1);
                            break;
                        }
                    }
                }
            }
            return hashSet;
        }

        public final boolean c() {
            InterfaceC0778o interfaceC0778o = this.f11202a;
            if (!(interfaceC0778o instanceof InterfaceC0898v)) {
                return false;
            }
            InterfaceC0898v interfaceC0898v = (InterfaceC0898v) interfaceC0778o;
            if (interfaceC0898v.u().contains(3)) {
                return interfaceC0898v.a().contains(32);
            }
            return false;
        }

        public final boolean d() {
            InterfaceC0778o interfaceC0778o = this.f11202a;
            if (interfaceC0778o instanceof InterfaceC0898v) {
                return ((InterfaceC0898v) interfaceC0778o).a().contains(4101);
            }
            return false;
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11203a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11204b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11205c;

        /* renamed from: d, reason: collision with root package name */
        public Location f11206d;

        public Location a() {
            return this.f11206d;
        }

        public boolean b() {
            return this.f11203a;
        }

        public boolean c() {
            return this.f11205c;
        }

        public String toString() {
            return "Metadata{mIsReversedHorizontal=" + this.f11203a + ", mIsReversedVertical=" + this.f11205c + ", mLocation=" + this.f11206d + "}";
        }
    }

    public static abstract class f {
        public abstract void a(int i10);

        public abstract void b();

        public abstract void c(androidx.camera.core.i iVar);

        public abstract void d(ImageCaptureException imageCaptureException);

        public abstract void e(Bitmap bitmap);
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f11207a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11208b;

        public g(Uri uri, int i10) {
            this.f11207a = uri;
            this.f11208b = i10;
        }
    }

    public interface h {
        void a(long j10, i iVar);

        void clear();
    }

    public interface i {
        void a();
    }

    public ImageCapture(q qVar) {
        super(qVar);
        this.f11179v = new InterfaceC0872a0.a() { // from class: D.P
            @Override // K.InterfaceC0872a0.a
            public final void a(InterfaceC0872a0 interfaceC0872a0) {
                ImageCapture.i0(interfaceC0872a0);
            }
        };
        this.f11181x = new AtomicReference<>(null);
        this.f11183z = -1;
        this.f11172A = null;
        this.f11178G = new a();
        q qVar2 = (q) l();
        if (qVar2.b(q.f11469S)) {
            this.f11180w = qVar2.i0();
        } else {
            this.f11180w = 1;
        }
        this.f11182y = qVar2.k0(0);
        this.f11173B = P.g.g(qVar2.n0());
    }

    public static boolean B0(List<Pair<Integer, Size[]>> list, int i10) {
        if (list == null) {
            return false;
        }
        Iterator<Pair<Integer, Size[]>> it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next().first).equals(Integer.valueOf(i10))) {
                return true;
            }
        }
        return false;
    }

    public static boolean C0(t tVar) {
        return Objects.equals(tVar.g(q.f11473W, null), 2);
    }

    public static boolean D0(t tVar) {
        return Objects.equals(tVar.g(q.f11473W, null), 3);
    }

    public static boolean E0(t tVar) {
        return Objects.equals(tVar.g(q.f11473W, null), 1);
    }

    public static /* synthetic */ void h0(ImageCapture imageCapture, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (imageCapture.i() == null) {
            return;
        }
        imageCapture.f11176E.pause();
        imageCapture.r0(true);
        SessionConfig.b bVarS0 = imageCapture.s0(imageCapture.k(), (q) imageCapture.l(), (y) B0.h.f(imageCapture.g()));
        imageCapture.f11174C = bVarS0;
        imageCapture.e0(List.of(bVarS0.o()));
        imageCapture.L();
        imageCapture.f11176E.resume();
    }

    public static /* synthetic */ void i0(InterfaceC0872a0 interfaceC0872a0) {
        try {
            androidx.camera.core.i iVarD = interfaceC0872a0.d();
            try {
                Log.d("ImageCapture", "Discarding ImageProxy which was inadvertently acquired: " + iVarD);
                if (iVarD != null) {
                    iVarD.close();
                }
            } finally {
            }
        } catch (IllegalStateException e10) {
            Log.e("ImageCapture", "Failed to acquire latest image.", e10);
        }
    }

    public static /* synthetic */ Void j0(List list) {
        return null;
    }

    private void q0() {
        r0(false);
    }

    public static S x0(InterfaceC0778o interfaceC0778o) {
        return new d(interfaceC0778o);
    }

    public int A0() {
        return C();
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> B() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public z.b<?, ?, ?> D(Config config) {
        return b.f(config);
    }

    @Override // androidx.camera.core.UseCase
    public boolean F() {
        return true;
    }

    public boolean F0() {
        return ((Boolean) l().g(q.f11481e0, Boolean.FALSE)).booleanValue();
    }

    public final boolean G0(Map<Integer, List<Size>> map, int i10) {
        return map.containsKey(Integer.valueOf(i10)) && !map.get(Integer.valueOf(i10)).isEmpty();
    }

    public final boolean H0() {
        return (i() == null || i().e().T(null) == null) ? false : true;
    }

    public void I0() {
        synchronized (this.f11181x) {
            try {
                if (this.f11181x.get() != null) {
                    return;
                }
                this.f11181x.set(Integer.valueOf(w0()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void J0(Rational rational) {
        this.f11172A = rational;
    }

    public final void K0() {
        L0(this.f11173B);
    }

    public final void L0(h hVar) {
        j().h(hVar);
    }

    public void M0(int i10) {
        int iA0 = A0();
        if (!b0(i10) || this.f11172A == null) {
            return;
        }
        this.f11172A = ImageUtil.f(Math.abs(M.c.b(i10) - M.c.b(iA0)), this.f11172A);
    }

    @Override // androidx.camera.core.UseCase
    public void N() {
        B0.h.g(i(), "Attached camera cannot be null");
        if (w0() == 3 && u0() != 0) {
            throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
        }
    }

    public InterfaceFutureC4095a<Void> N0(List<androidx.camera.core.impl.l> list) {
        n.b();
        return O.f.n(j().c(list, this.f11180w, this.f11182y), new InterfaceC4887a() { // from class: D.Q
            @Override // m.InterfaceC4887a
            public final Object apply(Object obj) {
                return ImageCapture.j0((List) obj);
            }
        }, N.a.a());
    }

    @Override // androidx.camera.core.UseCase
    public void O() {
        C0761b0.a("ImageCapture", "onCameraControlReady");
        O0();
        K0();
    }

    public final void O0() {
        synchronized (this.f11181x) {
            try {
                if (this.f11181x.get() != null) {
                    return;
                }
                j().d(w0());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    public z<?> P(InterfaceC0898v interfaceC0898v, z.b<?, ?, ?> bVar) {
        o0(bVar);
        if (interfaceC0898v.s().a(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            t tVarA = bVar.a();
            Config.a<Boolean> aVar = q.f11476Z;
            Boolean bool2 = Boolean.TRUE;
            if (bool.equals(tVarA.g(aVar, bool2))) {
                C0761b0.o("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                C0761b0.e("ImageCapture", "Requesting software JPEG due to device quirk.");
                bVar.a().t(aVar, bool2);
            }
        }
        boolean zT0 = t0(bVar.a());
        Integer num = (Integer) bVar.a().g(q.f11472V, null);
        if (num != null) {
            B0.h.b(!H0() || num.intValue() == 256, "Cannot set non-JPEG buffer format with Extensions enabled.");
            bVar.a().t(r.f11483n, Integer.valueOf(zT0 ? 35 : num.intValue()));
        } else if (C0(bVar.a())) {
            bVar.a().t(r.f11483n, 32);
        } else if (D0(bVar.a())) {
            bVar.a().t(r.f11483n, 32);
            bVar.a().t(r.f11484o, 256);
        } else if (E0(bVar.a())) {
            bVar.a().t(r.f11483n, 4101);
            bVar.a().t(r.f11485p, B.f1997c);
        } else if (zT0) {
            bVar.a().t(r.f11483n, 35);
        } else {
            List list = (List) bVar.a().g(s.f11493x, null);
            if (list == null || B0(list, 256)) {
                bVar.a().t(r.f11483n, 256);
            } else if (B0(list, 35)) {
                bVar.a().t(r.f11483n, 35);
            }
        }
        return bVar.d();
    }

    public void P0() {
        synchronized (this.f11181x) {
            try {
                Integer andSet = this.f11181x.getAndSet(null);
                if (andSet == null) {
                    return;
                }
                if (andSet.intValue() != w0()) {
                    O0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    public void Q(int i10) {
        M0(i10);
    }

    @Override // androidx.camera.core.UseCase
    public void S() {
        k0();
    }

    @Override // androidx.camera.core.UseCase
    public y T(Config config) {
        this.f11174C.g(config);
        e0(List.of(this.f11174C.o()));
        return g().i().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    public y U(y yVar, y yVar2) {
        C0761b0.a("ImageCapture", "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + yVar + ", secondaryStreamSpec " + yVar2);
        SessionConfig.b bVarS0 = s0(k(), (q) l(), yVar);
        this.f11174C = bVarS0;
        e0(List.of(bVarS0.o()));
        J();
        return yVar;
    }

    @Override // androidx.camera.core.UseCase
    public void V() {
        k0();
        q0();
        L0(null);
    }

    public final void k0() {
        this.f11173B.f();
        d0 d0Var = this.f11176E;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // androidx.camera.core.UseCase
    public z<?> m(boolean z10, UseCaseConfigFactory useCaseConfigFactory) {
        c cVar = f11170H;
        Config configA = useCaseConfigFactory.a(cVar.a().V(), v0());
        if (z10) {
            configA = Config.X(configA, cVar.a());
        }
        if (configA == null) {
            return null;
        }
        return D(configA).d();
    }

    public final void o0(z.b<?, ?, ?> bVar) {
        Set<F.b> setO = o();
        if (setO != null) {
            int iF = 0;
            for (F.b bVar2 : setO) {
                if (bVar2 instanceof ImageFormatFeature) {
                    iF = ((ImageFormatFeature) bVar2).getImageCaptureOutputFormat();
                }
            }
            bVar.a().t(q.f11473W, Integer.valueOf(iF));
        }
    }

    public final K p0(int i10, Size size) {
        z0 z0VarZ0 = z0();
        if (z0VarZ0 == null) {
            return null;
        }
        Map<Integer, List<Size>> mapC = z0VarZ0.c(size);
        ArrayList arrayList = new ArrayList();
        if (G0(mapC, 35)) {
            arrayList.add(35);
        }
        if (G0(mapC, 256)) {
            arrayList.add(256);
        }
        if (G0(mapC, 4101)) {
            arrayList.add(4101);
        }
        int iA = !arrayList.isEmpty() ? i().e().H().a(i10, arrayList) : 0;
        if (iA == 0) {
            return null;
        }
        List<Size> list = mapC.get(Integer.valueOf(iA));
        X.c cVar = (X.c) l().g(q.f11480d0, null);
        if (cVar == null) {
            return K.a((Size) Collections.max(list, new M.d()), iA);
        }
        Collections.sort(list, new M.d(true));
        CameraInternal cameraInternalI = i();
        Rect rectJ = cameraInternalI.i().j();
        InterfaceC0898v interfaceC0898vI = cameraInternalI.i();
        List<Size> listP = P.k.p(cVar, list, null, A0(), new Rational(rectJ.width(), rectJ.height()), interfaceC0898vI.e(), interfaceC0898vI.k());
        if (listP.isEmpty()) {
            throw new IllegalArgumentException("The postview ResolutionSelector cannot select a valid size for the postview.");
        }
        return K.a(listP.get(0), iA);
    }

    public final void r0(boolean z10) {
        d0 d0Var;
        Log.d("ImageCapture", "clearPipeline");
        n.b();
        SessionConfig.c cVar = this.f11177F;
        if (cVar != null) {
            cVar.b();
            this.f11177F = null;
        }
        D d10 = this.f11175D;
        if (d10 != null) {
            d10.a();
            this.f11175D = null;
        }
        if (!z10 && (d0Var = this.f11176E) != null) {
            d0Var.b();
            this.f11176E = null;
        }
        j().a();
    }

    public final SessionConfig.b s0(String str, q qVar, y yVar) {
        n.b();
        Log.d("ImageCapture", String.format("createPipeline(cameraId: %s, streamSpec: %s)", str, yVar));
        Size sizeF = yVar.f();
        CameraInternal cameraInternalI = i();
        Objects.requireNonNull(cameraInternalI);
        boolean z10 = !cameraInternalI.p();
        if (this.f11175D != null) {
            B0.h.h(z10);
            this.f11175D.a();
        }
        Set<Integer> setA = x0(i().a()).a();
        B0.h.b(setA.contains(Integer.valueOf(y0())), "The specified output format (" + y0() + ") is not supported by current configuration. Supported output formats: " + setA);
        CameraCharacteristics cameraCharacteristics = null;
        K kP0 = F0() ? p0(qVar.o(), sizeF) : null;
        if (i() != null) {
            try {
                Object objQ = i().i().q();
                if (objQ instanceof CameraCharacteristics) {
                    cameraCharacteristics = (CameraCharacteristics) objQ;
                }
            } catch (Exception e10) {
                Log.e("ImageCapture", "getCameraCharacteristics failed", e10);
            }
        }
        this.f11175D = new D(qVar, sizeF, cameraCharacteristics, n(), z10, kP0);
        if (this.f11176E == null) {
            this.f11176E = l().r().a(this.f11178G);
        }
        this.f11176E.a(this.f11175D);
        SessionConfig.b bVarF = this.f11175D.f(yVar.f());
        bVarF.w(yVar.g());
        if (v0() == 2 && !yVar.h()) {
            j().b(bVarF);
        }
        if (yVar.d() != null) {
            bVarF.g(yVar.d());
        }
        SessionConfig.c cVar = this.f11177F;
        if (cVar != null) {
            cVar.b();
        }
        SessionConfig.c cVar2 = new SessionConfig.c(new SessionConfig.d() { // from class: D.O
            @Override // androidx.camera.core.impl.SessionConfig.d
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                ImageCapture.h0(this.f2072a, sessionConfig, sessionError);
            }
        });
        this.f11177F = cVar2;
        bVarF.q(cVar2);
        return bVarF;
    }

    public boolean t0(t tVar) {
        boolean z10;
        Boolean bool = Boolean.TRUE;
        Config.a<Boolean> aVar = q.f11476Z;
        Boolean bool2 = Boolean.FALSE;
        boolean z11 = false;
        if (bool.equals(tVar.g(aVar, bool2))) {
            if (H0()) {
                C0761b0.o("ImageCapture", "Software JPEG cannot be used with Extensions.");
                z10 = false;
            } else {
                z10 = true;
            }
            Integer num = (Integer) tVar.g(q.f11472V, null);
            if (num == null || num.intValue() == 256) {
                z11 = z10;
            } else {
                C0761b0.o("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z11) {
                C0761b0.o("ImageCapture", "Unable to support software JPEG. Disabling.");
                tVar.t(aVar, bool2);
            }
        }
        return z11;
    }

    public String toString() {
        return "ImageCapture:" + r();
    }

    public final int u0() {
        CameraInternal cameraInternalI = i();
        if (cameraInternalI != null) {
            return cameraInternalI.a().k();
        }
        return -1;
    }

    public int v0() {
        return this.f11180w;
    }

    public int w0() {
        int iJ0;
        synchronized (this.f11181x) {
            iJ0 = this.f11183z;
            if (iJ0 == -1) {
                iJ0 = ((q) l()).j0(2);
            }
        }
        return iJ0;
    }

    public int y0() {
        return ((Integer) B0.h.f((Integer) l().g(q.f11473W, 0))).intValue();
    }

    public final z0 z0() {
        return i().e().T(null);
    }
}
