package H2;

import android.app.Application;
import com.stepos.familyguard.net.entity.BaseEntity;
import m2.C0861d;

/* renamed from: H2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0302a extends P0 {

    /* renamed from: i, reason: collision with root package name */
    private static final androidx.lifecycle.B<Long> f2764i = new androidx.lifecycle.B<>();

    /* renamed from: j, reason: collision with root package name */
    private static Q1.c<A3.c> f2765j = Q1.c.a();

    public C0302a(Application application) {
        super(application);
    }

    @Override // com.stepos.familyguard.ui.base.i
    public Q1.c<A3.c> Z() {
        return f2765j;
    }

    @Override // com.stepos.familyguard.ui.base.i
    public androidx.lifecycle.B<Long> a0() {
        return f2764i;
    }

    @Override // com.stepos.familyguard.ui.base.i
    protected x3.f<BaseEntity<String>> b0(String str) {
        return C0861d.a().b(str);
    }

    @Override // com.stepos.familyguard.ui.base.i
    protected x3.f<BaseEntity<Long>> c0(String str, String str2) {
        return C0861d.a().d(1, str, P0.q0(K()), str2);
    }

    @Override // com.stepos.familyguard.ui.base.i
    public void m0(Q1.c<A3.c> cVar) {
        f2765j = cVar;
    }
}
