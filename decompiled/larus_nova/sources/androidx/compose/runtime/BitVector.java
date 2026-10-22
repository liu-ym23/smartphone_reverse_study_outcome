package androidx.compose.runtime;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086\u0002J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000eH\u0086\u0002J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ%\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0017H\u0082\bJ\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/BitVector;", "", "<init>", "()V", SoloKtvContext.SOLO_PAGE_FIRST, "", "second", "others", "", "size", "", "getSize", "()I", MonitorConstants.CONNECT_TYPE_GET, "", "index", "set", "", "value", "nextSet", "nextClear", "nextBit", "valueSelector", "Lkotlin/Function1;", "setRange", "start", "end", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitVector {
    public static final int $stable = 8;
    private long first;
    private long[] others;
    private long second;

    public final int getSize() {
        return (this.others.length + 2) * 64;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("BitVector [");
        int r101 = getSize();
        boolean r102 = true;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L10;
        if (get(r103) == false) goto L9;
        if (r102 == true) goto L8;
        r100.append(", ");
    L8:
        r100.append(r103);
        r102 = false;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        r100.append(']');
        return r100.toString();
    }

    public BitVector() {
        this.others = SlotTableKt.access$getEmptyLongArray$p();
    }

    public final boolean get(int r110) {
        if (r110 >= 64) goto L10;
        if (((1 << r110) & this.first) != 0) goto L27;
        return false;
    L27:
        return true;
    L10:
        if (r110 < 128) goto L12;
        long[] r100 = this.others;
        int r101 = r100.length;
        if (r101 != 0) goto L19;
        return false;
    L19:
        int r102 = (r110 / 64) - 2;
        if (r102 < r101) goto L23;
        return false;
    L23:
        if (((1 << (r110 % 64)) & r100[r102]) != 0) goto L29;
        return false;
    L29:
        return true;
    L12:
        if (((1 << (r110 - 64)) & this.second) != 0) goto L28;
        return false;
    L28:
        return true;
    }

    public final int nextClear(int r110) {
        if (r110 >= 64) goto L8;
        int r100 = Long.numberOfTrailingZeros(((~this.first) >>> r110) << r110);
        if (r100 >= 64) goto L8;
        return r100;
    L8:
        if (r110 >= 128) goto L12;
        int r101 = r110 - 64;
        int r102 = Long.numberOfTrailingZeros(((~this.second) >>> r101) << r101);
        if (r102 >= 64) goto L12;
        return r102 + 64;
    L12:
        int r111 = Math.max(r110, 128);
        int r103 = (r111 / 64) - 2;
        long[] r104 = this.others;
        int r105 = r104.length;
        int r106 = r103;
    L13:
        if (r106 >= r105) goto L21;
        long r107 = ~r104[r106];
        if (r106 != r103) goto L17;
        int r108 = r111 % 64;
        r107 = (r107 >>> r108) << r108;
    L17:
        int r109 = Long.numberOfTrailingZeros(r107);
        if (r109 < 64) goto L26;
        r106 = r106 + 1;
        goto L13
    L26:
        return ((r106 * 64) + 128) + r109;
    L21:
        return Integer.MAX_VALUE;
    }

    public final int nextSet(int r110) {
        if (r110 >= 64) goto L8;
        int r100 = Long.numberOfTrailingZeros((this.first >>> r110) << r110);
        if (r100 >= 64) goto L8;
        return r100;
    L8:
        if (r110 >= 128) goto L12;
        int r101 = r110 - 64;
        int r102 = Long.numberOfTrailingZeros((this.second >>> r101) << r101);
        if (r102 >= 64) goto L12;
        return r102 + 64;
    L12:
        int r111 = Math.max(r110, 128);
        int r103 = (r111 / 64) - 2;
        long[] r104 = this.others;
        int r105 = r104.length;
        int r106 = r103;
    L13:
        if (r106 >= r105) goto L21;
        long r107 = r104[r106];
        if (r106 != r103) goto L17;
        int r108 = r111 % 64;
        r107 = (r107 >>> r108) << r108;
    L17:
        int r109 = Long.numberOfTrailingZeros(r107);
        if (r109 < 64) goto L26;
        r106 = r106 + 1;
        goto L13
    L26:
        return ((r106 * 64) + 128) + r109;
    L21:
        return Integer.MAX_VALUE;
    }

    private final int nextBit(int r110, Function1<? super Long, Long> r111) {
        if (r110 >= 64) goto L8;
        int r100 = Long.numberOfTrailingZeros((r111.invoke(Long.valueOf(this.first)).longValue() >>> r110) << r110);
        if (r100 >= 64) goto L8;
        return r100;
    L8:
        if (r110 >= 128) goto L13;
        int r101 = r110 - 64;
        int r102 = Long.numberOfTrailingZeros((r111.invoke(Long.valueOf(this.second)).longValue() >>> r101) << r101);
        if (r102 >= 64) goto L13;
        return r102 + 64;
    L13:
        int r112 = Math.max(r110, 128);
        int r103 = (r112 / 64) - 2;
        long[] r104 = this.others;
        int r105 = r104.length;
        int r106 = r103;
    L14:
        if (r106 >= r105) goto L23;
        long r107 = r111.invoke(Long.valueOf(r104[r106])).longValue();
        if (r106 != r103) goto L18;
        int r108 = r112 % 64;
        r107 = (r107 >>> r108) << r108;
    L18:
        int r109 = Long.numberOfTrailingZeros(r107);
        if (r109 < 64) goto L21;
        r106 = r106 + 1;
        goto L14
    L21:
        return ((r106 * 64) + 128) + r109;
    L23:
        return Integer.MAX_VALUE;
    }

    public final void set(int r100, boolean r101) {
        if (r100 >= 64) goto L7;
        this.first = ((r101 ? 1 : 0) << r100) | ((~(1 << r100)) & this.first);
        return;
    L7:
        if (r100 >= 128) goto L10;
        long r102 = this.second;
        this.second = ((r101 ? 1 : 0) << r100) | ((~(1 << (r100 - 64))) & r102);
        return;
    L10:
        int r103 = (r100 / 64) - 2;
        int r104 = r100 % 64;
        long r105 = 1 << r104;
        long[] r106 = this.others;
        if (r103 < r106.length) goto L13;
        r106 = Arrays.copyOf(r106, r103 + 1);
        this.others = r106;
    L13:
        r106[r103] = ((r101 ? 1 : 0) << r104) | ((~r105) & r106[r103]);
    }

    public final void setRange(int r110, int r111) {
        if (r110 >= r111) goto L4;
        long r100 = -1;
    L5:
        int r101 = 0;
        if (r110 >= 64) goto L8;
        int r102 = 1;
    L9:
        this.first = (((((long) r102) * r100) >>> (64 - (Math.min(64, r111) - r110))) << r110) | this.first;
        if (r111 <= 64) goto L19;
        int r112 = Math.max(r110, 64);
        if (r112 >= 128) goto L14;
        r101 = 1;
    L14:
        this.second = (((r100 * ((long) r101)) >>> (128 - (Math.min(128, r111) - r112))) << r112) | this.second;
        if (r111 <= 128) goto L21;
        int r113 = Math.max(r112, 128);
    L17:
        if (r113 >= r111) goto L22;
        set(r113, true);
        r113 = r113 + 1;
        goto L17
    L22:
        return;
    L21:
        return;
    L19:
        return;
    L8:
        r102 = 0;
        goto L9
    L4:
        r100 = 0;
        goto L5
    }
}
