package f9;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3559b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Map f3560a;

    static {
        new h(0);
    }

    public h() {
        this.f3560a = new HashMap();
    }

    public final void a(n nVar) {
        this.f3560a.put(new g(nVar.f3583d.f3569f, nVar.f3580a), nVar);
    }

    public h(int i2) {
        this.f3560a = Collections.EMPTY_MAP;
    }
}
