package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class R1 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final R1 f44902a = new R1();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f44903b;

    static {
        C4765c.b bVarA = C4765c.a("format");
        V v10 = new V();
        v10.a(1);
        f44903b = bVarA.b(v10.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        interfaceC4767e.a(f44903b, ((C6184k8) obj).a());
    }
}
