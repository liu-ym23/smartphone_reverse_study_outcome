package G2;

import java.util.HashMap;
import java.util.Map;

/* renamed from: G2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0294b implements w {

    /* renamed from: a, reason: collision with root package name */
    private final Map<F2.z, u> f1891a = new HashMap();

    @Override // G2.w
    public u a(F2.z zVar, v vVar) {
        if (this.f1891a.containsKey(zVar)) {
            return this.f1891a.get(zVar);
        }
        u uVarB = b(zVar, vVar);
        this.f1891a.put(zVar, uVarB);
        return uVarB;
    }

    protected abstract u b(F2.z zVar, v vVar);
}
