package r4;

import i4.InterfaceC0772l;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: r4.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1032o {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Appendable appendable, T t5, InterfaceC0772l<? super T, ? extends CharSequence> interfaceC0772l) throws IOException {
        j4.k.g(appendable, "<this>");
        if (interfaceC0772l != null) {
            appendable.append(interfaceC0772l.invoke(t5));
            return;
        }
        if (t5 == 0 ? true : t5 instanceof CharSequence) {
            appendable.append((CharSequence) t5);
        } else if (t5 instanceof Character) {
            appendable.append(((Character) t5).charValue());
        } else {
            appendable.append(t5.toString());
        }
    }
}
