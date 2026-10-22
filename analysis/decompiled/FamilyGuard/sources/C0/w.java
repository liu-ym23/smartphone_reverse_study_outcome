package C0;

import A0.d;
import C0.f;
import H0.n;
import java.io.File;
import java.util.List;
import z0.EnumC1335a;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
class w implements f, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final f.a f491a;

    /* renamed from: b, reason: collision with root package name */
    private final g<?> f492b;

    /* renamed from: c, reason: collision with root package name */
    private int f493c;

    /* renamed from: d, reason: collision with root package name */
    private int f494d = -1;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC1340f f495e;

    /* renamed from: f, reason: collision with root package name */
    private List<H0.n<File, ?>> f496f;

    /* renamed from: g, reason: collision with root package name */
    private int f497g;

    /* renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f498h;

    /* renamed from: i, reason: collision with root package name */
    private File f499i;

    /* renamed from: j, reason: collision with root package name */
    private x f500j;

    w(g<?> gVar, f.a aVar) {
        this.f492b = gVar;
        this.f491a = aVar;
    }

    private boolean b() {
        return this.f497g < this.f496f.size();
    }

    @Override // C0.f
    public boolean a() {
        List<InterfaceC1340f> listC = this.f492b.c();
        boolean z5 = false;
        if (listC.isEmpty()) {
            return false;
        }
        List<Class<?>> listM = this.f492b.m();
        if (listM.isEmpty()) {
            if (File.class.equals(this.f492b.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f492b.i() + " to " + this.f492b.q());
        }
        while (true) {
            if (this.f496f != null && b()) {
                this.f498h = null;
                while (!z5 && b()) {
                    List<H0.n<File, ?>> list = this.f496f;
                    int i5 = this.f497g;
                    this.f497g = i5 + 1;
                    this.f498h = list.get(i5).b(this.f499i, this.f492b.s(), this.f492b.f(), this.f492b.k());
                    if (this.f498h != null && this.f492b.t(this.f498h.f2005c.a())) {
                        this.f498h.f2005c.e(this.f492b.l(), this);
                        z5 = true;
                    }
                }
                return z5;
            }
            int i6 = this.f494d + 1;
            this.f494d = i6;
            if (i6 >= listM.size()) {
                int i7 = this.f493c + 1;
                this.f493c = i7;
                if (i7 >= listC.size()) {
                    return false;
                }
                this.f494d = 0;
            }
            InterfaceC1340f interfaceC1340f = listC.get(this.f493c);
            Class<?> cls = listM.get(this.f494d);
            this.f500j = new x(this.f492b.b(), interfaceC1340f, this.f492b.o(), this.f492b.s(), this.f492b.f(), this.f492b.r(cls), cls, this.f492b.k());
            File fileA = this.f492b.d().a(this.f500j);
            this.f499i = fileA;
            if (fileA != null) {
                this.f495e = interfaceC1340f;
                this.f496f = this.f492b.j(fileA);
                this.f497g = 0;
            }
        }
    }

    @Override // A0.d.a
    public void c(Exception exc) {
        this.f491a.b(this.f500j, exc, this.f498h.f2005c, EnumC1335a.RESOURCE_DISK_CACHE);
    }

    @Override // C0.f
    public void cancel() {
        n.a<?> aVar = this.f498h;
        if (aVar != null) {
            aVar.f2005c.cancel();
        }
    }

    @Override // A0.d.a
    public void f(Object obj) {
        this.f491a.e(this.f495e, obj, this.f498h.f2005c, EnumC1335a.RESOURCE_DISK_CACHE, this.f500j);
    }
}
