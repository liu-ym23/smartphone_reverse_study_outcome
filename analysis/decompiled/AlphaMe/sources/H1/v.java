package H1;

import F1.A;
import F1.B;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes.dex */
public final class v implements B {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f765a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f766b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ A f767c;

    public /* synthetic */ v(Class cls, A a4, int i4) {
        this.f765a = i4;
        this.f766b = cls;
        this.f767c = a4;
    }

    @Override // F1.B
    public final A a(F1.n nVar, TypeToken typeToken) {
        int i4 = this.f765a;
        Class cls = this.f766b;
        switch (i4) {
            case 0:
                if (typeToken.getRawType() == cls) {
                    return this.f767c;
                }
                return null;
            default:
                Class<?> rawType = typeToken.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return new c(this, rawType);
                }
                return null;
        }
    }

    public final String toString() {
        int i4 = this.f765a;
        A a4 = this.f767c;
        Class cls = this.f766b;
        switch (i4) {
            case 0:
                return "Factory[type=" + cls.getName() + ",adapter=" + a4 + "]";
            default:
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + a4 + "]";
        }
    }
}
