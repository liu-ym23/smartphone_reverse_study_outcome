package C0;

import A0.d;
import C0.f;
import H0.n;
import java.io.File;
import java.util.List;
import z0.EnumC1335a;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
class c implements f, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final List<InterfaceC1340f> f304a;

    /* renamed from: b, reason: collision with root package name */
    private final g<?> f305b;

    /* renamed from: c, reason: collision with root package name */
    private final f.a f306c;

    /* renamed from: d, reason: collision with root package name */
    private int f307d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC1340f f308e;

    /* renamed from: f, reason: collision with root package name */
    private List<H0.n<File, ?>> f309f;

    /* renamed from: g, reason: collision with root package name */
    private int f310g;

    /* renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f311h;

    /* renamed from: i, reason: collision with root package name */
    private File f312i;

    c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean b() {
        return this.f310g < this.f309f.size();
    }

    @Override // C0.f
    public boolean a() {
        while (true) {
            boolean z5 = false;
            if (this.f309f != null && b()) {
                this.f311h = null;
                while (!z5 && b()) {
                    List<H0.n<File, ?>> list = this.f309f;
                    int i5 = this.f310g;
                    this.f310g = i5 + 1;
                    this.f311h = list.get(i5).b(this.f312i, this.f305b.s(), this.f305b.f(), this.f305b.k());
                    if (this.f311h != null && this.f305b.t(this.f311h.f2005c.a())) {
                        this.f311h.f2005c.e(this.f305b.l(), this);
                        z5 = true;
                    }
                }
                return z5;
            }
            int i6 = this.f307d + 1;
            this.f307d = i6;
            if (i6 >= this.f304a.size()) {
                return false;
            }
            InterfaceC1340f interfaceC1340f = this.f304a.get(this.f307d);
            File fileA = this.f305b.d().a(new d(interfaceC1340f, this.f305b.o()));
            this.f312i = fileA;
            if (fileA != null) {
                this.f308e = interfaceC1340f;
                this.f309f = this.f305b.j(fileA);
                this.f310g = 0;
            }
        }
    }

    @Override // A0.d.a
    public void c(Exception exc) {
        this.f306c.b(this.f308e, exc, this.f311h.f2005c, EnumC1335a.DATA_DISK_CACHE);
    }

    @Override // C0.f
    public void cancel() {
        n.a<?> aVar = this.f311h;
        if (aVar != null) {
            aVar.f2005c.cancel();
        }
    }

    @Override // A0.d.a
    public void f(Object obj) {
        this.f306c.e(this.f308e, obj, this.f311h.f2005c, EnumC1335a.DATA_DISK_CACHE, this.f308e);
    }

    c(List<InterfaceC1340f> list, g<?> gVar, f.a aVar) {
        this.f307d = -1;
        this.f304a = list;
        this.f305b = gVar;
        this.f306c = aVar;
    }
}
