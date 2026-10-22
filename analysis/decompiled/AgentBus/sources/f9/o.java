package f9;

import java.io.Serializable;
import java.util.Collections;

/* loaded from: classes.dex */
public abstract class o extends a implements Serializable {
    public static n e(a aVar, a aVar2, int i2, m0 m0Var, Class cls) {
        return new n(aVar, Collections.EMPTY_LIST, aVar2, new m(i2, m0Var, true), cls);
    }

    public static n f(a aVar, Object obj, a aVar2, int i2, m0 m0Var, Class cls) {
        return new n(aVar, obj, aVar2, new m(i2, m0Var, false), cls);
    }
}
