package l;

import com.stepos.account.oauth.OAuthConstants;
import java.util.NoSuchElementException;
import q7.k;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5724a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f5725b = new long[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Object[] f5726c = new Object[0];

    public static final int a(int i2, int i10, int[] iArr) {
        k.e(iArr, "array");
        int i11 = i2 - 1;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            int i14 = iArr[i13];
            if (i14 < i10) {
                i12 = i13 + 1;
            } else {
                if (i14 <= i10) {
                    return i13;
                }
                i11 = i13 - 1;
            }
        }
        return ~i12;
    }

    public static final int b(long[] jArr, int i2, long j2) {
        k.e(jArr, "array");
        int i10 = i2 - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            long j4 = jArr[i12];
            if (j4 < j2) {
                i11 = i12 + 1;
            } else {
                if (j4 <= j2) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return ~i11;
    }

    public static final void c(String str) {
        k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        throw new IllegalArgumentException(str);
    }

    public static final void d(String str) {
        k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        throw new IndexOutOfBoundsException(str);
    }

    public static final void e(String str) {
        k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        throw new NoSuchElementException(str);
    }
}
