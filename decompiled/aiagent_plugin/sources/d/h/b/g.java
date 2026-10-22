package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: CollectionToArray.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f38494a = null;

    static {
        f38494a = new Object[0];
    }

    public static final Object[] a(Collection<?> r6, Object[] r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        o.e(r8, "collection");
        Objects.requireNonNull(r7);
        int r0 = r8.size();
        int r3 = 0;
        if (r0 == 0) goto L5;
        Iterator r9 = r8.iterator();
        if (r9.hasNext() == true) goto L13;
        if (r7.length <= 0) goto L43;
        r7[0] = null;
        return r7;
    L43:
        return r7;
    L13:
        if (r0 > r7.length) goto L15;
        Object[] r1 = r7;
    L16:
        int r2 = r3 + 1;
        r1[r3] = r9.next();
        if (r2 < r1.length) goto L29;
        if (r9.hasNext() == false) goto L45;
        int r4 = ((r2 * 3) + 1) >>> 1;
        if (r4 > r2) goto L27;
        if (r2 >= 2147483645) goto L26;
        r4 = 2147483645;
        goto L27
    L26:
        throw new OutOfMemoryError();
    L27:
        r1 = Arrays.copyOf(r1, r4);
        o.c(r1, "copyOf(...)");
    L34:
        r3 = r2;
        goto L16
    L45:
        return r1;
    L29:
        if (r9.hasNext() == true) goto L34;
        if (r1 != r7) goto L32;
        r7[r2] = null;
        return r7;
    L32:
        Object[] r10 = Arrays.copyOf(r1, r2);
        o.c(r10, "copyOf(...)");
        return r10;
    L15:
        Object r5 = Array.newInstance(r7.getClass().getComponentType(), r0);
        o.a(r5, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r1 = (Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.aiagent.plugin");
        goto L16
    L5:
        if (r7.length <= 0) goto L41;
        r7[0] = null;
        return r7;
    L41:
        return r7;
    }

    public static final Object[] a(Collection<?> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        o.e(r6, "collection");
        int r0 = r6.size();
        if (r0 == 0) goto L31;
        Iterator r7 = r6.iterator();
        if (r7.hasNext() == false) goto L31;
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L9:
        int r3 = r2 + 1;
        r1[r2] = r7.next();
        if (r3 < r1.length) goto L22;
        if (r7.hasNext() == false) goto L32;
        int r4 = ((r3 * 3) + 1) >>> 1;
        if (r4 > r3) goto L20;
        if (r3 >= 2147483645) goto L19;
        r4 = 2147483645;
        goto L20
    L19:
        throw new OutOfMemoryError();
    L20:
        r1 = Arrays.copyOf(r1, r4);
        o.c(r1, "copyOf(...)");
    L25:
        r2 = r3;
        goto L9
    L32:
        return r1;
    L22:
        if (r7.hasNext() == true) goto L25;
        Object[] r8 = Arrays.copyOf(r1, r3);
        o.c(r8, "copyOf(...)");
        return r8;
    L31:
        return f38494a;
    }
}
