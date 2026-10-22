package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class F2 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final F2 f44656a = new F2();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f44657b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f44658c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f44659d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f44660e;

    /* renamed from: f, reason: collision with root package name */
    public static final C4765c f44661f;

    /* renamed from: g, reason: collision with root package name */
    public static final C4765c f44662g;

    /* renamed from: h, reason: collision with root package name */
    public static final C4765c f44663h;

    /* renamed from: i, reason: collision with root package name */
    public static final C4765c f44664i;

    /* renamed from: j, reason: collision with root package name */
    public static final C4765c f44665j;

    /* renamed from: k, reason: collision with root package name */
    public static final C4765c f44666k;

    static {
        C4765c.b bVarA = C4765c.a("durationMs");
        V v10 = new V();
        v10.a(1);
        f44657b = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a("errorCode");
        V v11 = new V();
        v11.a(2);
        f44658c = bVarA2.b(v11.b()).a();
        C4765c.b bVarA3 = C4765c.a("isColdCall");
        V v12 = new V();
        v12.a(3);
        f44659d = bVarA3.b(v12.b()).a();
        C4765c.b bVarA4 = C4765c.a("autoManageModelOnBackground");
        V v13 = new V();
        v13.a(4);
        f44660e = bVarA4.b(v13.b()).a();
        C4765c.b bVarA5 = C4765c.a("autoManageModelOnLowMemory");
        V v14 = new V();
        v14.a(5);
        f44661f = bVarA5.b(v14.b()).a();
        C4765c.b bVarA6 = C4765c.a("isNnApiEnabled");
        V v15 = new V();
        v15.a(6);
        f44662g = bVarA6.b(v15.b()).a();
        C4765c.b bVarA7 = C4765c.a("eventsCount");
        V v16 = new V();
        v16.a(7);
        f44663h = bVarA7.b(v16.b()).a();
        C4765c.b bVarA8 = C4765c.a("otherErrors");
        V v17 = new V();
        v17.a(8);
        f44664i = bVarA8.b(v17.b()).a();
        C4765c.b bVarA9 = C4765c.a("remoteConfigValueForAcceleration");
        V v18 = new V();
        v18.a(9);
        f44665j = bVarA9.b(v18.b()).a();
        C4765c.b bVarA10 = C4765c.a("isAccelerated");
        V v19 = new V();
        v19.a(10);
        f44666k = bVarA10.b(v19.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        K5 k52 = (K5) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f44657b, k52.e());
        interfaceC4767e2.a(f44658c, k52.a());
        interfaceC4767e2.a(f44659d, k52.d());
        interfaceC4767e2.a(f44660e, k52.b());
        interfaceC4767e2.a(f44661f, k52.c());
        interfaceC4767e2.a(f44662g, null);
        interfaceC4767e2.a(f44663h, null);
        interfaceC4767e2.a(f44664i, null);
        interfaceC4767e2.a(f44665j, null);
        interfaceC4767e2.a(f44666k, null);
    }
}
