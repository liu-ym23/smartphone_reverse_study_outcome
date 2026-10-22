package K9;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: K9.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0922c {

    /* renamed from: a, reason: collision with root package name */
    public static final C0922c f4165a = new C0922c();

    /* renamed from: b, reason: collision with root package name */
    public static a f4166b;

    /* renamed from: K9.c$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f4167a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f4168b;

        public a(Method method, Method method2) {
            this.f4167a = method;
            this.f4168b = method2;
        }

        public final Method a() {
            return this.f4168b;
        }

        public final Method b() {
            return this.f4167a;
        }
    }

    public final a a(Member member) throws NoSuchMethodException, SecurityException {
        kotlin.jvm.internal.p.i(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", null), C0925f.j(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List<String> b(Member member) {
        Method methodA;
        kotlin.jvm.internal.p.i(member, "member");
        a aVarA = f4166b;
        if (aVarA == null) {
            synchronized (this) {
                aVarA = f4166b;
                if (aVarA == null) {
                    aVarA = f4165a.a(member);
                    f4166b = aVarA;
                }
            }
        }
        Method methodB = aVarA.b();
        if (methodB == null || (methodA = aVarA.a()) == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(member, null);
        kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object objInvoke2 = methodA.invoke(obj, null);
            kotlin.jvm.internal.p.g(objInvoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }
}
