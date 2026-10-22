package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f21181a = null;

    static {
        f21181a = new Object[0];
    }

    public static final Object[] a(Collection r10) {
        q.g(r10, "collection");
        int r11 = r10.size();
        if (r11 == 0) goto L32;
        Iterator r12 = r10.iterator();
        if (r12.hasNext() == false) goto L32;
        Object[] r13 = new Object[r11];
        int r14 = 0;
    L9:
        int r15 = r14 + 1;
        r13[r14] = r12.next();
        if (r15 < r13.length) goto L24;
        if (r12.hasNext() == false) goto L33;
        int r16 = ((r15 * 3) + 1) >>> 1;
        if (r16 > r15) goto L21;
        r16 = 2147483645;
        if (r15 < 2147483645) goto L21;
        throw new OutOfMemoryError();
    L21:
        r13 = Arrays.copyOf(r13, r16);
        q.f(r13, "copyOf(...)");
    L22:
        r14 = r15;
        goto L9
    L33:
        return r13;
    L24:
        if (r12.hasNext() == true) goto L22;
        Object[] r17 = Arrays.copyOf(r13, r15);
        q.f(r17, "copyOf(...)");
        return r17;
    L32:
        return f21181a;
    }

    public static final Object[] b(Collection r10, Object[] r11) {
        q.g(r10, "collection");
        if (r11 == null) goto L38;
        int r12 = r10.size();
        int r13 = 0;
        if (r12 == 0) goto L7;
        Iterator r14 = r10.iterator();
        if (r14.hasNext() == true) goto L15;
        if (r11.length <= 0) goto L47;
        r11[0] = null;
        return r11;
    L47:
        return r11;
    L15:
        if (r12 > r11.length) goto L17;
        Object[] r15 = r11;
    L18:
        int r16 = r13 + 1;
        r15[r13] = r14.next();
        if (r16 < r15.length) goto L33;
        if (r14.hasNext() == false) goto L49;
        int r17 = ((r16 * 3) + 1) >>> 1;
        if (r17 > r16) goto L30;
        r17 = 2147483645;
        if (r16 < 2147483645) goto L30;
        throw new OutOfMemoryError();
    L30:
        r15 = Arrays.copyOf(r15, r17);
        q.f(r15, "copyOf(...)");
    L31:
        r13 = r16;
        goto L18
    L49:
        return r15;
    L33:
        if (r14.hasNext() == true) goto L31;
        if (r15 != r11) goto L36;
        r11[r16] = null;
        return r11;
    L36:
        Object[] r18 = Arrays.copyOf(r15, r16);
        q.f(r18, "copyOf(...)");
        return r18;
    L17:
        Object r19 = Array.newInstance(r11.getClass().getComponentType(), r12);
        q.e(r19, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r15 = (Object[]) r19;
        goto L18
    L7:
        if (r11.length <= 0) goto L45;
        r11[0] = null;
        return r11;
    L45:
        return r11;
    L38:
        throw null;
    }
}
