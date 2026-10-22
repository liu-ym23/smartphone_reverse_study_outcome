package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: z2.g1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6137g1 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C6137g1 f45009a = new C6137g1();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f45010b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f45011c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f45012d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f45013e;

    /* renamed from: f, reason: collision with root package name */
    public static final C4765c f45014f;

    /* renamed from: g, reason: collision with root package name */
    public static final C4765c f45015g;

    /* renamed from: h, reason: collision with root package name */
    public static final C4765c f45016h;

    static {
        C4765c.b bVarA = C4765c.a("errorCode");
        V v10 = new V();
        v10.a(1);
        f45010b = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a("hasResult");
        V v11 = new V();
        v11.a(2);
        f45011c = bVarA2.b(v11.b()).a();
        C4765c.b bVarA3 = C4765c.a("isColdCall");
        V v12 = new V();
        v12.a(3);
        f45012d = bVarA3.b(v12.b()).a();
        C4765c.b bVarA4 = C4765c.a("imageInfo");
        V v13 = new V();
        v13.a(4);
        f45013e = bVarA4.b(v13.b()).a();
        C4765c.b bVarA5 = C4765c.a("options");
        V v14 = new V();
        v14.a(5);
        f45014f = bVarA5.b(v14.b()).a();
        C4765c.b bVarA6 = C4765c.a("detectedBarcodeFormats");
        V v15 = new V();
        v15.a(6);
        f45015g = bVarA6.b(v15.b()).a();
        C4765c.b bVarA7 = C4765c.a("detectedBarcodeValueTypes");
        V v16 = new V();
        v16.a(7);
        f45016h = bVarA7.b(v16.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        C6206n0 c6206n0 = (C6206n0) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f45010b, c6206n0.c());
        interfaceC4767e2.a(f45011c, null);
        interfaceC4767e2.a(f45012d, c6206n0.e());
        interfaceC4767e2.a(f45013e, null);
        interfaceC4767e2.a(f45014f, c6206n0.d());
        interfaceC4767e2.a(f45015g, c6206n0.a());
        interfaceC4767e2.a(f45016h, c6206n0.b());
    }
}
