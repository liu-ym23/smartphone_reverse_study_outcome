package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: z2.b3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6089b3 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C6089b3 f44971a = new C6089b3();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f44972b;

    static {
        C4765c.b bVarA = C4765c.a("errorCode");
        V v10 = new V();
        v10.a(1);
        f44972b = bVarA.b(v10.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        interfaceC4767e.a(f44972b, ((C6172j6) obj).a());
    }
}
