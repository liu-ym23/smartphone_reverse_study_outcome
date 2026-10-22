package x4;

import r4.C1031n;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: x4.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C1297I {
    public static final int a(String str, int i5, int i6, int i7) {
        return (int) C1295G.c(str, i5, i6, i7);
    }

    public static final long b(String str, long j5, long j6, long j7) {
        String strD = C1295G.d(str);
        if (strD == null) {
            return j5;
        }
        Long lJ = C1031n.j(strD);
        if (lJ == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strD + '\'').toString());
        }
        long jLongValue = lJ.longValue();
        if (j6 <= jLongValue && jLongValue <= j7) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j6 + ".." + j7 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String strD = C1295G.d(str);
        return strD == null ? str2 : strD;
    }

    public static final boolean d(String str, boolean z5) {
        String strD = C1295G.d(str);
        return strD != null ? Boolean.parseBoolean(strD) : z5;
    }

    public static /* synthetic */ int e(String str, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            i6 = 1;
        }
        if ((i8 & 8) != 0) {
            i7 = Integer.MAX_VALUE;
        }
        return C1295G.b(str, i5, i6, i7);
    }

    public static /* synthetic */ long f(String str, long j5, long j6, long j7, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            j6 = 1;
        }
        long j8 = j6;
        if ((i5 & 8) != 0) {
            j7 = Long.MAX_VALUE;
        }
        return C1295G.c(str, j5, j8, j7);
    }
}
