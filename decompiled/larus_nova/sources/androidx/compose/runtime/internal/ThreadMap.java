package androidx.compose.runtime.internal;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "<init>", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", MonitorConstants.CONNECT_TYPE_GET, "key", "", "trySet", "", "value", "newWith", "find", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThreadMap {
    public static final int $stable = 8;
    private final long[] keys;
    private final int size;
    private final Object[] values;

    private final int find(long r100) {
        int r101 = this.size - 1;
        if (r101 == (-1)) goto L29;
        int r102 = 0;
        if (r101 == 0) goto L15;
    L6:
        if (r102 > r101) goto L14;
        int r103 = (r102 + r101) >>> 1;
        long r104 = this.keys[r103] - r100;
        if (r104 < 0) goto L9;
        if (r104 <= 0) goto L12;
        r101 = r103 - 1;
        goto L6
    L12:
        return r103;
    L9:
        r102 = r103 + 1;
        goto L6
    L14:
        return -(r102 + 1);
    L15:
        long r105 = this.keys[0];
        if (r105 != r100) goto L19;
        return 0;
    L19:
        if (r105 <= r100) goto L31;
        return -2;
    L31:
        return -1;
    L29:
        return -1;
    }

    public final Object get(long r100) {
        int r101 = find(r100);
        if (r101 >= 0) goto L7;
        return null;
    L7:
        return this.values[r101];
    }

    public final ThreadMap newWith(long r110, Object r111) {
        int r100 = this.size;
        Object[] r101 = this.values;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L3:
        boolean r106 = true;
        if (r104 >= r102) goto L12;
        if (r101[r104] != null) goto L9;
        r106 = false;
    L9:
        if (r106 == false) goto L11;
        r105 = r105 + 1;
    L11:
        r104 = r104 + 1;
        goto L3
    L12:
        int r107 = r105 + 1;
        long[] r108 = new long[r107];
        Object[] r109 = new Object[r107];
        if (r107 <= 1) goto L30;
        int r112 = 0;
    L15:
        if (r103 >= r107) goto L23;
        if (r112 >= r100) goto L23;
        long r113 = this.keys[r112];
        Object r114 = this.values[r112];
        if (r113 > r110) goto L19;
        if (r114 == null) goto L22;
        r108[r103] = r113;
        r109[r103] = r114;
        r103 = r103 + 1;
    L22:
        r112 = r112 + 1;
        goto L15
    L19:
        r108[r103] = r110;
        r109[r103] = r111;
        r103 = r103 + 1;
    L23:
        if (r112 != r100) goto L25;
        int r115 = r107 - 1;
        r108[r115] = r110;
        r109[r115] = r111;
    L32:
        return new ThreadMap(r107, r108, r109);
    L25:
        if (r103 >= r107) goto L32;
        long r116 = this.keys[r112];
        Object r117 = this.values[r112];
        if (r117 == null) goto L29;
        r108[r103] = r116;
        r109[r103] = r117;
        r103 = r103 + 1;
    L29:
        r112 = r112 + 1;
        goto L25
    L30:
        r108[0] = r110;
        r109[0] = r111;
        goto L32
    }

    public final boolean trySet(long r100, Object r101) {
        int r102 = find(r100);
        if (r102 >= 0) goto L6;
        return false;
    L6:
        this.values[r102] = r101;
        return true;
    }

    public ThreadMap(int r100, long[] r101, Object[] r102) {
        this.size = r100;
        this.keys = r101;
        this.values = r102;
    }
}
