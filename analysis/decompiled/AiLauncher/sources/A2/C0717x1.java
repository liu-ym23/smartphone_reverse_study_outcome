package A2;

import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: A2.x1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0717x1 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0717x1 f1079a = new C0717x1();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f1080b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f1081c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f1082d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f1083e;

    static {
        C4765c.b bVarA = C4765c.a("isChargingRequired");
        C0604f c0604f = new C0604f();
        c0604f.a(1);
        f1080b = bVarA.b(c0604f.b()).a();
        C4765c.b bVarA2 = C4765c.a("isWifiRequired");
        C0604f c0604f2 = new C0604f();
        c0604f2.a(2);
        f1081c = bVarA2.b(c0604f2.b()).a();
        C4765c.b bVarA3 = C4765c.a("isDeviceIdleRequired");
        C0604f c0604f3 = new C0604f();
        c0604f3.a(3);
        f1082d = bVarA3.b(c0604f3.b()).a();
        C4765c.b bVarA4 = C4765c.a("canDownloadInBackground");
        C0604f c0604f4 = new C0604f();
        c0604f4.a(4);
        f1083e = bVarA4.b(c0604f4.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        throw null;
    }
}
