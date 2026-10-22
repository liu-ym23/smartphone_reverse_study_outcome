package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: z2.v2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6288v2 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C6288v2 f45116a = new C6288v2();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f45117b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f45118c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f45119d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f45120e;

    /* renamed from: f, reason: collision with root package name */
    public static final C4765c f45121f;

    /* renamed from: g, reason: collision with root package name */
    public static final C4765c f45122g;

    static {
        C4765c.b bVarA = C4765c.a("maxMs");
        V v10 = new V();
        v10.a(1);
        f45117b = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a("minMs");
        V v11 = new V();
        v11.a(2);
        f45118c = bVarA2.b(v11.b()).a();
        C4765c.b bVarA3 = C4765c.a("avgMs");
        V v12 = new V();
        v12.a(3);
        f45119d = bVarA3.b(v12.b()).a();
        C4765c.b bVarA4 = C4765c.a("firstQuartileMs");
        V v13 = new V();
        v13.a(4);
        f45120e = bVarA4.b(v13.b()).a();
        C4765c.b bVarA5 = C4765c.a("medianMs");
        V v14 = new V();
        v14.a(5);
        f45121f = bVarA5.b(v14.b()).a();
        C4765c.b bVarA6 = C4765c.a("thirdQuartileMs");
        V v15 = new V();
        v15.a(6);
        f45122g = bVarA6.b(v15.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        C6321y5 c6321y5 = (C6321y5) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f45117b, c6321y5.c());
        interfaceC4767e2.a(f45118c, c6321y5.e());
        interfaceC4767e2.a(f45119d, c6321y5.a());
        interfaceC4767e2.a(f45120e, c6321y5.b());
        interfaceC4767e2.a(f45121f, c6321y5.d());
        interfaceC4767e2.a(f45122g, c6321y5.f());
    }
}
