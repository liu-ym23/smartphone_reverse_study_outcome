package h3;

import java.util.Set;
import n3.InterfaceC4938b;

/* renamed from: h3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4125a implements InterfaceC4128d {
    @Override // h3.InterfaceC4128d
    public <T> Set<T> b(Class<T> cls) {
        return a(cls).get();
    }

    @Override // h3.InterfaceC4128d
    public <T> T get(Class<T> cls) {
        InterfaceC4938b<T> interfaceC4938bC = c(cls);
        if (interfaceC4938bC == null) {
            return null;
        }
        return interfaceC4938bC.get();
    }
}
