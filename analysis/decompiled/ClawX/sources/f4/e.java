package f4;

import k4.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final r4.a f2602a;

    static {
        f0 f0VarC;
        kotlin.jvm.internal.h hVarA = z.a(i.class);
        try {
            f0VarC = z.c(i.class);
        } catch (Throwable unused) {
            f0VarC = null;
        }
        f2602a = new r4.a("ResponseAdapterAttributeKey", new w4.a(hVarA, f0VarC));
    }

    public static final void a(c cVar, String urlString) {
        p.e(urlString, "urlString");
        d0.b(cVar.f2591a, urlString);
    }
}
