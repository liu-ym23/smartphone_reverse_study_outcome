package A2;

import com.stepos.aiengine.args.QueryAlgorithmBundle;
import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class C1 implements InterfaceC4766d {

    /* renamed from: a, reason: collision with root package name */
    public static final C1 f306a = new C1();

    /* renamed from: b, reason: collision with root package name */
    public static final C4765c f307b;

    /* renamed from: c, reason: collision with root package name */
    public static final C4765c f308c;

    /* renamed from: d, reason: collision with root package name */
    public static final C4765c f309d;

    /* renamed from: e, reason: collision with root package name */
    public static final C4765c f310e;

    static {
        C4765c.b bVarA = C4765c.a(QueryAlgorithmBundle.KEY_CATEGORY);
        C0604f c0604f = new C0604f();
        c0604f.a(1);
        f307b = bVarA.b(c0604f.b()).a();
        C4765c.b bVarA2 = C4765c.a("classificationConfidence");
        C0604f c0604f2 = new C0604f();
        c0604f2.a(2);
        f308c = bVarA2.b(c0604f2.b()).a();
        C4765c.b bVarA3 = C4765c.a("trackingId");
        C0604f c0604f3 = new C0604f();
        c0604f3.a(3);
        f309d = bVarA3.b(c0604f3.b()).a();
        C4765c.b bVarA4 = C4765c.a("labelCount");
        C0604f c0604f4 = new C0604f();
        c0604f4.a(4);
        f310e = bVarA4.b(c0604f4.b()).a();
    }

    @Override // j3.InterfaceC4764b
    public final /* bridge */ /* synthetic */ void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
        throw null;
    }
}
