package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class A4 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final A4 f44592a = new A4();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f44593b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f44594c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f44595d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f44596e;

    /* renamed from: f, reason: collision with root package name */
    public static final C4765c f44597f;

    static {
        C4765c.b bVarA = C4765c.a("xMin");
        V v10 = new V();
        v10.a(1);
        f44593b = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a("yMin");
        V v11 = new V();
        v11.a(2);
        f44594c = bVarA2.b(v11.b()).a();
        C4765c.b bVarA3 = C4765c.a("xMax");
        V v12 = new V();
        v12.a(3);
        f44595d = bVarA3.b(v12.b()).a();
        C4765c.b bVarA4 = C4765c.a("yMax");
        V v13 = new V();
        v13.a(4);
        f44596e = bVarA4.b(v13.b()).a();
        C4765c.b bVarA5 = C4765c.a("confidenceScore");
        V v14 = new V();
        v14.a(5);
        f44597f = bVarA5.b(v14.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        D7 d72 = (D7) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f44593b, d72.c());
        interfaceC4767e2.a(f44594c, d72.e());
        interfaceC4767e2.a(f44595d, d72.b());
        interfaceC4767e2.a(f44596e, d72.d());
        interfaceC4767e2.a(f44597f, d72.a());
    }
}
