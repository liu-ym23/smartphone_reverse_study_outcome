package ad;

import java.io.EOFException;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final s f539c;

    /* renamed from: a, reason: collision with root package name */
    public List f540a;

    /* renamed from: b, reason: collision with root package name */
    public List f541b;

    static {
        Pattern pattern = s.f568d;
        f539c = id.k.t("application/x-www-form-urlencoded");
    }

    @Override // ad.c0
    public final long a() {
        return d(null, true);
    }

    @Override // ad.c0
    public final s b() {
        return f539c;
    }

    @Override // ad.c0
    public final void c(od.j jVar) throws EOFException {
        d(jVar, false);
    }

    public final long d(od.j jVar, boolean z10) throws EOFException {
        od.i iVarA;
        List list = this.f540a;
        if (z10) {
            iVarA = new od.i();
        } else {
            jVar.getClass();
            iVarA = jVar.a();
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                iVarA.b0(38);
            }
            iVarA.g0((String) list.get(i));
            iVarA.b0(61);
            iVarA.g0((String) this.f541b.get(i));
        }
        if (!z10) {
            return 0L;
        }
        long j10 = iVarA.f9454f;
        iVarA.d();
        return j10;
    }
}
