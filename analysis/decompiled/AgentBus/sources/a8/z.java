package a8;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class z extends a0 {
    @Override // a8.h
    public final Object h(Object[] objArr) {
        q7.k.e(objArr, "args");
        g.checkArguments(this, objArr);
        Object obj = objArr[0];
        Object[] objArrC0 = objArr.length <= 1 ? new Object[0] : d7.n.c0(objArr, 1, objArr.length);
        return this.f432a.invoke(obj, Arrays.copyOf(objArrC0, objArrC0.length));
    }
}
