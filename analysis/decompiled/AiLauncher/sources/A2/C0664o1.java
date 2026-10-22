package A2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: A2.o1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0664o1 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0664o1 f823a = new C0664o1();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f824b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f825c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f826d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f827e;

    /* renamed from: f, reason: collision with root package name */
    public static final C4765c f828f;

    /* renamed from: g, reason: collision with root package name */
    public static final C4765c f829g;

    /* renamed from: h, reason: collision with root package name */
    public static final C4765c f830h;

    static {
        C4765c.b bVarA = C4765c.a("durationMs");
        C0604f c0604f = new C0604f();
        c0604f.a(1);
        f824b = bVarA.b(c0604f.b()).a();
        C4765c.b bVarA2 = C4765c.a("imageSource");
        C0604f c0604f2 = new C0604f();
        c0604f2.a(2);
        f825c = bVarA2.b(c0604f2.b()).a();
        C4765c.b bVarA3 = C4765c.a("imageFormat");
        C0604f c0604f3 = new C0604f();
        c0604f3.a(3);
        f826d = bVarA3.b(c0604f3.b()).a();
        C4765c.b bVarA4 = C4765c.a("imageByteSize");
        C0604f c0604f4 = new C0604f();
        c0604f4.a(4);
        f827e = bVarA4.b(c0604f4.b()).a();
        C4765c.b bVarA5 = C4765c.a("imageWidth");
        C0604f c0604f5 = new C0604f();
        c0604f5.a(5);
        f828f = bVarA5.b(c0604f5.b()).a();
        C4765c.b bVarA6 = C4765c.a("imageHeight");
        C0604f c0604f6 = new C0604f();
        c0604f6.a(6);
        f829g = bVarA6.b(c0604f6.b()).a();
        C4765c.b bVarA7 = C4765c.a("rotationDegrees");
        C0604f c0604f7 = new C0604f();
        c0604f7.a(7);
        f830h = bVarA7.b(c0604f7.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        C0719x3 c0719x3 = (C0719x3) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f824b, c0719x3.g());
        interfaceC4767e2.a(f825c, c0719x3.b());
        interfaceC4767e2.a(f826d, c0719x3.a());
        interfaceC4767e2.a(f827e, c0719x3.c());
        interfaceC4767e2.a(f828f, c0719x3.e());
        interfaceC4767e2.a(f829g, c0719x3.d());
        interfaceC4767e2.a(f830h, c0719x3.f());
    }
}
