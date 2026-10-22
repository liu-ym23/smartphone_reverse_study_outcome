package w3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.z;
import v5.k;
import z3.q0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final r4.a f6192a;

    static {
        f0 f0Var;
        kotlin.jvm.internal.h hVarA = z.a(Map.class);
        try {
            k kVarW = k4.z.w(z.d(e.class, k.f5986c));
            k kVarW2 = k4.z.w(z.c(Object.class));
            a0 a0Var = z.f3687a;
            kotlin.jvm.internal.h hVarA2 = z.a(Map.class);
            List listAsList = Arrays.asList(kVarW, kVarW2);
            a0Var.getClass();
            f0 f0VarB = a0.b(hVarA2, listAsList);
            f0Var = new f0(f0VarB.f3670a, f0VarB.f3671b, f0VarB.f3672c | 2);
        } catch (Throwable unused) {
            f0Var = null;
        }
        f6192a = new r4.a("EngineCapabilities", new w4.a(hVarA, f0Var));
        a.a.a0(q0.f6496a);
    }
}
