package v9;

import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class z extends z0 implements y9.j, y9.k {
    @Override // v9.z0
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public abstract z I0(boolean z4);

    @Override // v9.z0
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public abstract z K0(i0 i0Var);

    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            String[] strArr = {"[", g9.g.f3941e.y((g8.c) it.next(), null), "] "};
            for (int i2 = 0; i2 < 3; i2++) {
                sb2.append(strArr[i2]);
            }
        }
        sb2.append(E0());
        if (!C0().isEmpty()) {
            d7.r.T0(C0(), sb2, ", ", "<", ">", null, 112);
        }
        if (F0()) {
            sb2.append("?");
        }
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
