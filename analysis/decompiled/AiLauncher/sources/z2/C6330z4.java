package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: z2.z4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6330z4 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C6330z4 f45165a = new C6330z4();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f45166b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f45167c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f45168d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f45169e;

    /* renamed from: f, reason: collision with root package name */
    public static final C4765c f45170f;

    /* renamed from: g, reason: collision with root package name */
    public static final C4765c f45171g;

    static {
        C4765c.b bVarA = C4765c.a("appName");
        V v10 = new V();
        v10.a(1);
        f45166b = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a("sessionId");
        V v11 = new V();
        v11.a(2);
        f45167c = bVarA2.b(v11.b()).a();
        C4765c.b bVarA3 = C4765c.a("startZoomLevel");
        V v12 = new V();
        v12.a(3);
        f45168d = bVarA3.b(v12.b()).a();
        C4765c.b bVarA4 = C4765c.a("endZoomLevel");
        V v13 = new V();
        v13.a(4);
        f45169e = bVarA4.b(v13.b()).a();
        C4765c.b bVarA5 = C4765c.a("durationMs");
        V v14 = new V();
        v14.a(5);
        f45170f = bVarA5.b(v14.b()).a();
        C4765c.b bVarA6 = C4765c.a("predictedArea");
        V v15 = new V();
        v15.a(6);
        f45171g = bVarA6.b(v15.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        E7 e72 = (E7) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f45166b, e72.e());
        interfaceC4767e2.a(f45167c, e72.f());
        interfaceC4767e2.a(f45168d, e72.c());
        interfaceC4767e2.a(f45169e, e72.b());
        interfaceC4767e2.a(f45170f, e72.d());
        interfaceC4767e2.a(f45171g, e72.a());
    }
}
