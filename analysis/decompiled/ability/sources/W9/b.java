package W9;

import kotlin.jvm.internal.k;
import okio.SegmentedByteString;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f1497a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final int b(SegmentedByteString segmentedByteString, int i) {
        int i6;
        int[] iArr = segmentedByteString.f;
        int i10 = i + 1;
        int length = segmentedByteString.e.length;
        k.f(iArr, "<this>");
        int i11 = length - 1;
        int i12 = 0;
        while (true) {
            if (i12 <= i11) {
                i6 = (i12 + i11) >>> 1;
                int i13 = iArr[i6];
                if (i13 >= i10) {
                    if (i13 <= i10) {
                        break;
                    }
                    i11 = i6 - 1;
                } else {
                    i12 = i6 + 1;
                }
            } else {
                i6 = (-i12) - 1;
                break;
            }
        }
        return i6 >= 0 ? i6 : ~i6;
    }
}
