package kotlin.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public static void a(Appendable r10, Object r11, Function1 r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r12 == null) goto L5;
        r10.append((CharSequence) r12.invoke(r11));
        return;
    L5:
        if (r11 != null) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L11;
        r10.append((CharSequence) r11);
        return;
    L11:
        if ((r11 instanceof Character) == false) goto L13;
        r10.append(((Character) r11).charValue());
        return;
    L13:
        r10.append(String.valueOf(r11));
        return;
    L7:
        r13 = r11 instanceof CharSequence;
        goto L8
    }
}
