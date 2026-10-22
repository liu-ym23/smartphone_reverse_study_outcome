package H2;

import android.app.Application;
import com.stepos.familyguard.net.entity.BaseEntity;
import java.util.concurrent.Callable;
import m2.C0861d;

/* renamed from: H2.p0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0333p0 extends P0 {

    /* renamed from: i, reason: collision with root package name */
    private static final androidx.lifecycle.B<Long> f2806i = new androidx.lifecycle.B<>();

    /* renamed from: j, reason: collision with root package name */
    private static Q1.c<A3.c> f2807j = Q1.c.a();

    public C0333p0(Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long w0() {
        return Long.valueOf(P0.q0(K()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long x0() {
        return Long.valueOf(P0.q0(K()));
    }

    @Override // com.stepos.familyguard.ui.base.i
    public Q1.c<A3.c> Z() {
        return f2807j;
    }

    @Override // com.stepos.familyguard.ui.base.i
    public androidx.lifecycle.B<Long> a0() {
        return f2806i;
    }

    @Override // com.stepos.familyguard.ui.base.i
    protected x3.f<BaseEntity<String>> b0(final String str) {
        return x3.f.x(new Callable() { // from class: H2.n0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2803a.w0();
            }
        }).r(new D3.h() { // from class: H2.o0
            @Override // D3.h
            public final Object apply(Object obj) {
                return C0861d.a().c(str, ((Long) obj).longValue());
            }
        });
    }

    @Override // com.stepos.familyguard.ui.base.i
    protected x3.f<BaseEntity<Long>> c0(final String str, final String str2) {
        return x3.f.x(new Callable() { // from class: H2.l0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2797a.x0();
            }
        }).r(new D3.h() { // from class: H2.m0
            @Override // D3.h
            public final Object apply(Object obj) {
                return C0861d.a().d(3, str, ((Long) obj).longValue(), str2);
            }
        });
    }

    @Override // com.stepos.familyguard.ui.base.i
    public void m0(Q1.c<A3.c> cVar) {
        f2807j = cVar;
    }
}
