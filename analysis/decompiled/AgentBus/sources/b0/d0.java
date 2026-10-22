package b0;

import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import mobile.Mobile;

/* loaded from: classes.dex */
public final /* synthetic */ class d0 implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1122f;

    public /* synthetic */ d0(int i2) {
        this.f1122f = i2;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f1122f) {
            case 0:
                s.d("Unexpected call to default provider");
                throw new a4.u();
            case 1:
                return c7.r.f1986a;
            case 2:
                e0 e0Var = d.g.f2741a;
                return null;
            case 3:
                return AgentCacheSdk.init$lambda$0();
            case 4:
                e0 e0Var2 = e3.a.f3051a;
                return null;
            case 5:
                return Long.valueOf(System.currentTimeMillis());
            case 6:
                throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present");
            case 7:
                c3 c3Var = k0.e.f5573a;
                return null;
            case 8:
                c3 c3Var2 = m0.d.f6125a;
                return null;
            case 9:
                c3 c3Var3 = m0.f.f6127a;
                return null;
            case 10:
                ab.s sVar = new ab.s();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                sVar.a(15L, timeUnit);
                sVar.d(60L, timeUnit);
                sVar.b(0L, timeUnit);
                TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                q7.k.e(timeUnit2, "unit");
                sVar.f625y = bb.b.b("interval", 10000L, timeUnit2);
                return new ab.t(sVar);
            case 11:
                return Long.valueOf(System.currentTimeMillis());
            case 12:
                return Long.valueOf(System.currentTimeMillis());
            case 13:
                return UUID.randomUUID().toString();
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                return Mobile.newGuard(2L, 3L);
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return Boolean.TRUE;
            default:
                throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present");
        }
    }
}
