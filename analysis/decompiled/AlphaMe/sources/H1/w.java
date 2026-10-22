package H1;

import F1.A;
import F1.B;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes.dex */
public final class w implements B {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f768a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f769b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f770c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ A f771d;

    public /* synthetic */ w(Class cls, Class cls2, A a4, int i4) {
        this.f768a = i4;
        this.f769b = cls;
        this.f770c = cls2;
        this.f771d = a4;
    }

    @Override // F1.B
    public final A a(F1.n nVar, TypeToken typeToken) {
        int i4 = this.f768a;
        A a4 = this.f771d;
        Class cls = this.f770c;
        Class cls2 = this.f769b;
        switch (i4) {
            case 0:
                Class rawType = typeToken.getRawType();
                if (rawType != cls2 && rawType != cls) {
                    break;
                }
                break;
            default:
                Class rawType2 = typeToken.getRawType();
                if (rawType2 != cls2 && rawType2 != cls) {
                    break;
                }
                break;
        }
        return null;
    }

    public final String toString() {
        int i4 = this.f768a;
        A a4 = this.f771d;
        Class cls = this.f770c;
        Class cls2 = this.f769b;
        switch (i4) {
            case 0:
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + a4 + "]";
            default:
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + a4 + "]";
        }
    }
}
