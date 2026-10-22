package v2;

import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.B;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import l2.m;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class d implements e {

    /* renamed from: a, reason: collision with root package name */
    private long f23312a;

    /* renamed from: b, reason: collision with root package name */
    private final B<Boolean> f23313b = new B<>();

    /* renamed from: c, reason: collision with root package name */
    private final A3.b f23314c = new A3.b();

    /* renamed from: d, reason: collision with root package name */
    private m f23315d;

    public d(long j5) {
        this.f23312a = j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f23315d = FamilyGuardDatabase.x().D().a(this.f23312a);
        this.f23313b.k(Boolean.TRUE);
    }

    @Override // v2.e
    public void a() {
        this.f23314c.dispose();
        this.f23315d = null;
    }

    @Override // v2.e
    public AbstractC0545z<Boolean> b() {
        return this.f23313b;
    }

    @Override // v2.e
    public AbstractC0545z<Object> c() {
        return null;
    }

    public long e() {
        return this.f23312a;
    }

    public m f() {
        return this.f23315d;
    }

    @Override // v2.e
    public void init() {
        this.f23314c.c(AbstractC1286b.b().j(T3.a.c()).g(new D3.a() { // from class: v2.c
            @Override // D3.a
            public final void run() {
                this.f23311a.g();
            }
        }));
    }
}
