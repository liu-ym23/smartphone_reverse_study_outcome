package u3;

import a6.f0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class c implements f0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater d;

    /* renamed from: e, reason: collision with root package name */
    public static final r4.a f5630e;

    /* renamed from: a, reason: collision with root package name */
    public final t3.c f5631a;

    /* renamed from: b, reason: collision with root package name */
    public f4.b f5632b;

    /* renamed from: c, reason: collision with root package name */
    public h4.c f5633c;
    private volatile /* synthetic */ int received = 0;

    static {
        kotlin.jvm.internal.f0 f0VarC;
        h hVarA = z.a(Object.class);
        try {
            f0VarC = z.c(Object.class);
        } catch (Throwable unused) {
            f0VarC = null;
        }
        f5630e = new r4.a("CustomResponse", new w4.a(hVarA, f0VarC));
        d = AtomicIntegerFieldUpdater.newUpdater(c.class, "received");
    }

    public c(t3.c cVar) {
        this.f5631a = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b6, code lost:
    
        if (r8 == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(w4.a r7, h5.c r8) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.c.a(w4.a, h5.c):java.lang.Object");
    }

    @Override // a6.f0
    public final f5.h b() {
        return e().b();
    }

    public boolean c() {
        return false;
    }

    public final f4.b d() {
        f4.b bVar = this.f5632b;
        if (bVar != null) {
            return bVar;
        }
        p.l("request");
        throw null;
    }

    public final h4.c e() {
        h4.c cVar = this.f5633c;
        if (cVar != null) {
            return cVar;
        }
        p.l("response");
        throw null;
    }

    public Object f() {
        return e().d();
    }

    public final r4.d getAttributes() {
        return d().getAttributes();
    }

    public final String toString() {
        return "HttpClientCall[" + d().u() + ", " + e().g() + AbstractJsonLexerKt.END_LIST;
    }
}
