package androidx.collection.internal;

import com.bytedance.lark.pb.space.drive.v1.CoverDownloadInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0000\u001a \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0000X\u0081\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0016"}, d2 = {"EMPTY_INTS", "", "EMPTY_LONGS", "", "EMPTY_OBJECTS", "", "", "[Ljava/lang/Object;", "idealIntArraySize", "", "need", "idealLongArraySize", "idealByteArraySize", CoverDownloadInfo.DEFAULT_POLICY, "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "binarySearch", "array", "size", "value", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContainerHelpersKt {
    public static final int[] EMPTY_INTS = null;
    public static final long[] EMPTY_LONGS = null;
    public static final Object[] EMPTY_OBJECTS = null;

    static {
        EMPTY_INTS = new int[0];
        EMPTY_LONGS = new long[0];
        EMPTY_OBJECTS = new Object[0];
    }

    public static final int idealByteArraySize(int r100) {
        int r101 = 4;
    L4:
        if (r101 >= 32) goto L9;
        int r102 = (1 << r101) - 12;
        if (r100 <= r102) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return r100;
    }

    public static final int idealIntArraySize(int r100) {
        return idealByteArraySize(r100 * 4) / 4;
    }

    public static final int idealLongArraySize(int r100) {
        return idealByteArraySize(r100 * 8) / 8;
    }

    public static final boolean equal(Object r100, Object r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    public static final int binarySearch(long[] r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "array");
        int r103 = r101 - 1;
        int r104 = 0;
    L3:
        if (r104 > r103) goto L11;
        int r105 = (r104 + r103) >>> 1;
        long r106 = r100[r105];
        if (r106 < r102) goto L6;
        if (r106 <= r102) goto L9;
        r103 = r105 - 1;
        goto L3
    L9:
        return r105;
    L6:
        r104 = r105 + 1;
        goto L3
    L11:
        return ~r104;
    }

    public static final int binarySearch(int[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "array");
        int r103 = r101 - 1;
        int r104 = 0;
    L3:
        if (r104 > r103) goto L11;
        int r105 = (r104 + r103) >>> 1;
        int r106 = r100[r105];
        if (r106 < r102) goto L6;
        if (r106 <= r102) goto L9;
        r103 = r105 - 1;
        goto L3
    L9:
        return r105;
    L6:
        r104 = r105 + 1;
        goto L3
    L11:
        return ~r104;
    }
}
