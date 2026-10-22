package X8;

import a9.InterfaceC0311c;
import a9.InterfaceC0312d;
import i8.InterfaceC1556b;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class A extends U implements InterfaceC0311c, InterfaceC0312d {
    @Override // X8.U
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public abstract A f0(boolean z10);

    @Override // X8.U
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public abstract A m0(H h);

    public String toString() throws IOException {
        StringBuilder sb = new StringBuilder();
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            String[] strArr = {"[", I8.g.e.v((InterfaceC1556b) it.next(), null), "] "};
            for (int i = 0; i < 3; i++) {
                sb.append(strArr[i]);
            }
        }
        sb.append(Q());
        if (!L().isEmpty()) {
            D7.v.H0(L(), sb, ", ", "<", ">", null, 112);
        }
        if (W()) {
            sb.append("?");
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }
}
