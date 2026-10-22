package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: z2.a3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6079a3 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C6079a3 f44962a = new C6079a3();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f44963b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f44964c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f44965d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f44966e;

    /* renamed from: f, reason: collision with root package name */
    public static final C4765c f44967f;

    static {
        C4765c.b bVarA = C4765c.a("inferenceCommonLogEvent");
        V v10 = new V();
        v10.a(1);
        f44963b = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a("options");
        V v11 = new V();
        v11.a(2);
        f44964c = bVarA2.b(v11.b()).a();
        C4765c.b bVarA3 = C4765c.a("detectedBarcodeFormats");
        V v12 = new V();
        v12.a(3);
        f44965d = bVarA3.b(v12.b()).a();
        C4765c.b bVarA4 = C4765c.a("detectedBarcodeValueTypes");
        V v13 = new V();
        v13.a(4);
        f44966e = bVarA4.b(v13.b()).a();
        C4765c.b bVarA5 = C4765c.a("imageInfo");
        V v14 = new V();
        v14.a(5);
        f44967f = bVarA5.b(v14.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        C6142g6 c6142g6 = (C6142g6) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f44963b, c6142g6.d());
        interfaceC4767e2.a(f44964c, c6142g6.e());
        interfaceC4767e2.a(f44965d, c6142g6.a());
        interfaceC4767e2.a(f44966e, c6142g6.b());
        interfaceC4767e2.a(f44967f, c6142g6.c());
    }
}
