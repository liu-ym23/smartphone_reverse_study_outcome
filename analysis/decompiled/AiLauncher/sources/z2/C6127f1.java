package z2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: z2.f1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6127f1 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C6127f1 f45002a = new C6127f1();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f45003b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f45004c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f45005d;

    static {
        C4765c.b bVarA = C4765c.a("logEventKey");
        V v10 = new V();
        v10.a(1);
        f45003b = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a("eventCount");
        V v11 = new V();
        v11.a(2);
        f45004c = bVarA2.b(v11.b()).a();
        C4765c.b bVarA3 = C4765c.a("inferenceDurationStats");
        V v12 = new V();
        v12.a(3);
        f45005d = bVarA3.b(v12.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        C6226p0 c6226p0 = (C6226p0) obj;
        InterfaceC4767e interfaceC4767e2 = interfaceC4767e;
        interfaceC4767e2.a(f45003b, c6226p0.a());
        interfaceC4767e2.a(f45004c, c6226p0.c());
        interfaceC4767e2.a(f45005d, c6226p0.b());
    }
}
