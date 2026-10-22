package androidx.camera.core;

import D.C0761b0;
import D.C0762c;
import D.T;
import D.p0;
import K.AbstractC0889l;
import K.InterfaceC0872a0;
import K.InterfaceC0891n;
import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.camera.core.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class j implements InterfaceC0872a0, g.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11603a;

    /* renamed from: b, reason: collision with root package name */
    public AbstractC0889l f11604b;

    /* renamed from: c, reason: collision with root package name */
    public int f11605c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0872a0.a f11606d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11607e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0872a0 f11608f;

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC0872a0.a f11609g;

    /* renamed from: h, reason: collision with root package name */
    public Executor f11610h;

    /* renamed from: i, reason: collision with root package name */
    public final LongSparseArray<T> f11611i;

    /* renamed from: j, reason: collision with root package name */
    public final LongSparseArray<i> f11612j;

    /* renamed from: k, reason: collision with root package name */
    public int f11613k;

    /* renamed from: l, reason: collision with root package name */
    public final List<i> f11614l;

    /* renamed from: m, reason: collision with root package name */
    public final List<i> f11615m;

    public class a extends AbstractC0889l {
        public a() {
        }

        @Override // K.AbstractC0889l
        public void b(int i10, InterfaceC0891n interfaceC0891n) {
            super.b(i10, interfaceC0891n);
            j.this.q(interfaceC0891n);
        }
    }

    public j(int i10, int i11, int i12, int i13) {
        this(j(i10, i11, i12, i13));
    }

    public static /* synthetic */ void h(j jVar, InterfaceC0872a0.a aVar) {
        jVar.getClass();
        aVar.a(jVar);
    }

    public static /* synthetic */ void i(j jVar, InterfaceC0872a0 interfaceC0872a0) {
        synchronized (jVar.f11603a) {
            jVar.f11605c++;
        }
        jVar.n(interfaceC0872a0);
    }

    public static InterfaceC0872a0 j(int i10, int i11, int i12, int i13) {
        return new C0762c(ImageReader.newInstance(i10, i11, i12, i13));
    }

    @Override // K.InterfaceC0872a0
    public int a() {
        int iA;
        synchronized (this.f11603a) {
            iA = this.f11608f.a();
        }
        return iA;
    }

    @Override // K.InterfaceC0872a0
    public void b(InterfaceC0872a0.a aVar, Executor executor) {
        synchronized (this.f11603a) {
            this.f11609g = (InterfaceC0872a0.a) B0.h.f(aVar);
            this.f11610h = (Executor) B0.h.f(executor);
            this.f11608f.b(this.f11606d, executor);
        }
    }

    @Override // androidx.camera.core.g.a
    public void c(i iVar) {
        synchronized (this.f11603a) {
            k(iVar);
        }
    }

    @Override // K.InterfaceC0872a0
    public void close() {
        synchronized (this.f11603a) {
            try {
                if (this.f11607e) {
                    return;
                }
                Iterator it = new ArrayList(this.f11614l).iterator();
                while (it.hasNext()) {
                    ((i) it.next()).close();
                }
                this.f11614l.clear();
                this.f11608f.close();
                this.f11607e = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // K.InterfaceC0872a0
    public i d() {
        synchronized (this.f11603a) {
            try {
                if (this.f11614l.isEmpty()) {
                    return null;
                }
                if (this.f11613k >= this.f11614l.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < this.f11614l.size() - 1; i10++) {
                    if (!this.f11615m.contains(this.f11614l.get(i10))) {
                        arrayList.add(this.f11614l.get(i10));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((i) it.next()).close();
                }
                int size = this.f11614l.size();
                List<i> list = this.f11614l;
                this.f11613k = size;
                i iVar = list.get(size - 1);
                this.f11615m.add(iVar);
                return iVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // K.InterfaceC0872a0
    public int e() {
        int iE;
        synchronized (this.f11603a) {
            iE = this.f11608f.e();
        }
        return iE;
    }

    @Override // K.InterfaceC0872a0
    public void f() {
        synchronized (this.f11603a) {
            this.f11608f.f();
            this.f11609g = null;
            this.f11610h = null;
            this.f11605c = 0;
        }
    }

    @Override // K.InterfaceC0872a0
    public i g() {
        synchronized (this.f11603a) {
            try {
                if (this.f11614l.isEmpty()) {
                    return null;
                }
                if (this.f11613k >= this.f11614l.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                List<i> list = this.f11614l;
                int i10 = this.f11613k;
                this.f11613k = i10 + 1;
                i iVar = list.get(i10);
                this.f11615m.add(iVar);
                return iVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // K.InterfaceC0872a0
    public int getHeight() {
        int height;
        synchronized (this.f11603a) {
            height = this.f11608f.getHeight();
        }
        return height;
    }

    @Override // K.InterfaceC0872a0
    public Surface getSurface() {
        Surface surface;
        synchronized (this.f11603a) {
            surface = this.f11608f.getSurface();
        }
        return surface;
    }

    @Override // K.InterfaceC0872a0
    public int getWidth() {
        int width;
        synchronized (this.f11603a) {
            width = this.f11608f.getWidth();
        }
        return width;
    }

    public final void k(i iVar) {
        synchronized (this.f11603a) {
            try {
                int iIndexOf = this.f11614l.indexOf(iVar);
                if (iIndexOf >= 0) {
                    this.f11614l.remove(iIndexOf);
                    int i10 = this.f11613k;
                    if (iIndexOf <= i10) {
                        this.f11613k = i10 - 1;
                    }
                }
                this.f11615m.remove(iVar);
                if (this.f11605c > 0) {
                    n(this.f11608f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(p0 p0Var) {
        final InterfaceC0872a0.a aVar;
        Executor executor;
        synchronized (this.f11603a) {
            try {
                if (this.f11614l.size() < a()) {
                    p0Var.b(this);
                    this.f11614l.add(p0Var);
                    aVar = this.f11609g;
                    executor = this.f11610h;
                } else {
                    C0761b0.a("TAG", "Maximum image number reached.");
                    p0Var.close();
                    aVar = null;
                    executor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            if (executor != null) {
                executor.execute(new Runnable() { // from class: D.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        androidx.camera.core.j.h(this.f2089a, aVar);
                    }
                });
            } else {
                aVar.a(this);
            }
        }
    }

    public AbstractC0889l m() {
        return this.f11604b;
    }

    public void n(InterfaceC0872a0 interfaceC0872a0) {
        i iVarG;
        synchronized (this.f11603a) {
            try {
                if (this.f11607e) {
                    return;
                }
                int size = this.f11612j.size() + this.f11614l.size();
                if (size >= interfaceC0872a0.a()) {
                    C0761b0.a("MetadataImageReader", "Skip to acquire the next image because the acquired image count has reached the max images count.");
                    return;
                }
                do {
                    try {
                        iVarG = interfaceC0872a0.g();
                        if (iVarG != null) {
                            this.f11605c--;
                            size++;
                            this.f11612j.put(iVarG.Z0().getTimestamp(), iVarG);
                            o();
                        }
                    } catch (IllegalStateException e10) {
                        C0761b0.b("MetadataImageReader", "Failed to acquire next image.", e10);
                        iVarG = null;
                    }
                    if (iVarG == null || this.f11605c <= 0) {
                        break;
                    }
                } while (size < interfaceC0872a0.a());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        synchronized (this.f11603a) {
            try {
                for (int size = this.f11611i.size() - 1; size >= 0; size--) {
                    T tValueAt = this.f11611i.valueAt(size);
                    long timestamp = tValueAt.getTimestamp();
                    i iVar = this.f11612j.get(timestamp);
                    if (iVar != null) {
                        this.f11612j.remove(timestamp);
                        this.f11611i.removeAt(size);
                        l(new p0(iVar, tValueAt));
                    }
                }
                p();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p() {
        synchronized (this.f11603a) {
            try {
                if (this.f11612j.size() != 0 && this.f11611i.size() != 0) {
                    long jKeyAt = this.f11612j.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.f11611i.keyAt(0);
                    B0.h.a(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.f11612j.size() - 1; size >= 0; size--) {
                            if (this.f11612j.keyAt(size) < jKeyAt2) {
                                this.f11612j.valueAt(size).close();
                                this.f11612j.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.f11611i.size() - 1; size2 >= 0; size2--) {
                            if (this.f11611i.keyAt(size2) < jKeyAt) {
                                this.f11611i.removeAt(size2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    public void q(InterfaceC0891n interfaceC0891n) {
        synchronized (this.f11603a) {
            try {
                if (this.f11607e) {
                    return;
                }
                this.f11611i.put(interfaceC0891n.getTimestamp(), new P.a(interfaceC0891n));
                o();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j(InterfaceC0872a0 interfaceC0872a0) {
        this.f11603a = new Object();
        this.f11604b = new a();
        this.f11605c = 0;
        this.f11606d = new InterfaceC0872a0.a() { // from class: D.c0
            @Override // K.InterfaceC0872a0.a
            public final void a(InterfaceC0872a0 interfaceC0872a02) {
                androidx.camera.core.j.i(this.f2088a, interfaceC0872a02);
            }
        };
        this.f11607e = false;
        this.f11611i = new LongSparseArray<>();
        this.f11612j = new LongSparseArray<>();
        this.f11615m = new ArrayList();
        this.f11608f = interfaceC0872a0;
        this.f11613k = 0;
        this.f11614l = new ArrayList(a());
    }
}
