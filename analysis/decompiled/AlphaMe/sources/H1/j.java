package H1;

import F1.A;
import F1.B;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes.dex */
public final class j implements B {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f728a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f729b;

    public /* synthetic */ j(int i4, Object obj) {
        this.f728a = i4;
        this.f729b = obj;
    }

    @Override // F1.B
    public final A a(F1.n nVar, TypeToken typeToken) {
        int i4 = this.f728a;
        Object obj = this.f729b;
        switch (i4) {
            case 0:
                if (typeToken.getRawType() == Number.class) {
                    return (l) obj;
                }
                return null;
            default:
                if (typeToken.getRawType() == Object.class) {
                    return new n(nVar, (F1.z) obj);
                }
                return null;
        }
    }
}
