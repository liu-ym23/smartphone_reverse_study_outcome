package p3;

import W3.C0403n;
import java.util.List;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f19586a = new s();

    private s() {
    }

    public final int a(int i5, int i6, int i7, int i8) {
        return kotlin.ranges.l.b(((i5 - i6) - i7) - i8, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] b(boolean r2, boolean r3, boolean r4, int r5, int r6) {
        /*
            r1 = this;
            r1 = 0
            if (r2 == 0) goto L7
            if (r3 == 0) goto L7
            r0 = r5
            goto L8
        L7:
            r0 = r1
        L8:
            if (r4 != 0) goto Lc
        La:
            r5 = r1
            goto L12
        Lc:
            if (r3 == 0) goto L10
            r5 = r6
            goto L12
        L10:
            if (r2 == 0) goto La
        L12:
            int[] r1 = new int[]{r1, r0, r5}
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.s.b(boolean, boolean, boolean, int, int):int[]");
    }

    public final boolean c(int i5, int i6, boolean z5, boolean z6) {
        if (i5 < 0 || i5 >= 4) {
            throw new IllegalArgumentException(("button count must be in 0..3 but was " + i5).toString());
        }
        if (i6 < 0 || i6 >= 3) {
            throw new IllegalArgumentException("buttonLayout must be AUTO(0), HORIZONTAL(1) or VERTICAL(2)");
        }
        if (i5 == 0) {
            return false;
        }
        if (i5 == 1 || i5 == 3) {
            return true;
        }
        if (i6 != 1) {
            return i6 == 2 || z5 || z6;
        }
        return false;
    }

    public final <T> List<T> d(T t5, T t6, T t7, boolean z5) {
        List<T> listM = C0403n.m(t7, t6, t5);
        return z5 ? (listM.size() == 3 || t5 == null) ? C0403n.m(t5, t6, t7) : listM : listM;
    }
}
