package x4;

import V3.n;
import a.C0404a;

/* renamed from: x4.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1293E {

    /* renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f23830a = new C0404a().a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f23831b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f23832c;

    static {
        Object objA;
        Object objA2;
        try {
            n.a aVar = V3.n.f5531a;
            objA = V3.n.a(kotlin.coroutines.jvm.internal.a.class.getCanonicalName());
        } catch (Throwable th) {
            n.a aVar2 = V3.n.f5531a;
            objA = V3.n.a(V3.o.a(th));
        }
        if (V3.n.b(objA) != null) {
            objA = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f23831b = (String) objA;
        try {
            objA2 = V3.n.a(C1293E.class.getCanonicalName());
        } catch (Throwable th2) {
            n.a aVar3 = V3.n.f5531a;
            objA2 = V3.n.a(V3.o.a(th2));
        }
        if (V3.n.b(objA2) != null) {
            objA2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f23832c = (String) objA2;
    }

    public static final <E extends Throwable> E a(E e6) {
        return e6;
    }
}
