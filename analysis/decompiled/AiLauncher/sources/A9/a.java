package A9;

import java.util.Map;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class a implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final Map f1286a;

    public a(Map map) {
        this.f1286a = map;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return Integer.valueOf(e.j(this.f1286a));
    }
}
