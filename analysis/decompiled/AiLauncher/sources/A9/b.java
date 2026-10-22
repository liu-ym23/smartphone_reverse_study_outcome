package A9;

import java.util.Map;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class b implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1287a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f1288b;

    public b(Class cls, Map map) {
        this.f1287a = cls;
        this.f1288b = map;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return e.l(this.f1287a, this.f1288b);
    }
}
