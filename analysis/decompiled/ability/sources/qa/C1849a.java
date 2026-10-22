package qa;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: qa.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1849a implements InterfaceC1859k {
    public static final C1849a b = new C1849a(0);
    public static final C1849a c = new C1849a(1);
    public static final C1849a d = new C1849a(2);
    public static final C1849a e = new C1849a(3);
    public static final C1849a f = new C1849a(4);
    public static final C1849a g = new C1849a(5);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5652a;

    public /* synthetic */ C1849a(int i) {
        this.f5652a = i;
    }

    public List a(Executor executor) {
        return Collections.singletonList(new C1861m(executor));
    }

    public List b() {
        return Collections.EMPTY_LIST;
    }

    public String c(Method method, int i) {
        return "parameter #" + (i + 1);
    }

    /* JADX WARN: Finally extract failed */
    @Override // qa.InterfaceC1859k
    public Object convert(Object obj) {
        switch (this.f5652a) {
            case 0:
                return obj.toString();
            case 1:
                F9.P p = (F9.P) obj;
                try {
                    V9.g gVar = new V9.g();
                    p.f().o(gVar);
                    F9.O o = new F9.O(p.c(), p.b(), gVar, 0);
                    p.close();
                    return o;
                } catch (Throwable th) {
                    p.close();
                    throw th;
                }
            case 2:
                return (F9.K) obj;
            case 3:
                return (F9.P) obj;
            case 4:
                ((F9.P) obj).close();
                return C7.r.f317a;
            default:
                ((F9.P) obj).close();
                return null;
        }
    }

    public Object d(Method method, Class cls, Object obj, Object[] objArr) {
        throw new AssertionError();
    }

    public boolean e(Method method) {
        return false;
    }
}
