package a8;

import java.lang.reflect.Member;

/* loaded from: classes.dex */
public abstract class g {
    public static <M extends Member> void checkArguments(h hVar, Object[] objArr) {
        q7.k.e(objArr, "args");
        if (ib.c.A(hVar) == objArr.length) {
            return;
        }
        throw new IllegalArgumentException("Callable expects " + ib.c.A(hVar) + " arguments, but " + objArr.length + " were provided.");
    }
}
