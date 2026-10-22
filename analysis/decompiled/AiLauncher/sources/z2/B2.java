package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class B2 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final B2 f44599a = new B2();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f44600b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f44601c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f44602d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f44603e;

    static {
        C4765c.b bVarA = C4765c.a("imageFormat");
        V v10 = new V();
        v10.a(1);
        f44600b = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a("originalImageSize");
        V v11 = new V();
        v11.a(2);
        f44601c = bVarA2.b(v11.b()).a();
        C4765c.b bVarA3 = C4765c.a("compressedImageSize");
        V v12 = new V();
        v12.a(3);
        f44602d = bVarA3.b(v12.b()).a();
        C4765c.b bVarA4 = C4765c.a("isOdmlImage");
        V v13 = new V();
        v13.a(4);
        f44603e = bVarA4.b(v13.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        E5 e52 = (E5) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f44600b, e52.a());
        interfaceC4767e2.a(f44601c, e52.b());
        interfaceC4767e2.a(f44602d, null);
        interfaceC4767e2.a(f44603e, null);
    }
}
