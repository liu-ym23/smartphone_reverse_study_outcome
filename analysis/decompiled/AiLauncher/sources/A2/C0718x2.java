package A2;

import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* renamed from: A2.x2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0718x2 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0718x2 f1084a = new C0718x2();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f1085b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f1086c;

    static {
        C4765c.b bVarA = C4765c.a("stageId");
        C0604f c0604f = new C0604f();
        c0604f.a(1);
        f1085b = bVarA.b(c0604f.b()).a();
        C4765c.b bVarA2 = C4765c.a(Parameters.DEVICE);
        C0604f c0604f2 = new C0604f();
        c0604f2.a(2);
        f1086c = bVarA2.b(c0604f2.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        throw null;
    }
}
