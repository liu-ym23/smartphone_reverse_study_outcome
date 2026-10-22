package androidx.compose.ui.spatial;

import S7.n;
import S7.o;
import S7.p;
import S7.q;
import S7.r;
import androidx.collection.SieveCacheKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0014J%\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ;\u0010!\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042$\u0010 \u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u001f¢\u0006\u0004\b!\u0010\"J/\u0010%\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e0#¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b'\u0010\u0012J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+JD\u0010-\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0,H\u0086\b¢\u0006\u0004\b-\u0010.JD\u0010/\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0,H\u0086\b¢\u0006\u0004\b/\u0010.J<\u00101\u001a\u00020\u000e2*\u0010 \u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e00H\u0086\b¢\u0006\u0004\b1\u00102J4\u0010-\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0,H\u0086\b¢\u0006\u0004\b-\u00105JD\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00042*\u0010 \u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e00H\u0086\b¢\u0006\u0004\b7\u00108J7\u0010=\u001a\u00020:2\u0006\u00109\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b;\u0010<Jr\u0010@\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000420\u0010 \u001a,\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0?H\u0086\b¢\u0006\u0004\b@\u0010AJ8\u0010B\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u000e¢\u0006\u0004\bD\u0010\u0003J\r\u0010E\u001a\u00020\u000e¢\u0006\u0004\bE\u0010\u0003J0\u0010G\u001a\u00020\u000e2\u001e\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e0FH\u0086\b¢\u0006\u0004\bG\u0010HJ\r\u0010J\u001a\u00020I¢\u0006\u0004\bJ\u0010KJ\u0010\u0010L\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\bL\u0010MJ'\u0010R\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\bR\u0010SJ'\u0010\u001b\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010UR\u0016\u0010V\u001a\u00020P8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020P8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bX\u0010WR\u0016\u0010Y\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0011\u0010\\\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b[\u0010M¨\u0006]"}, d2 = {"Landroidx/compose/ui/spatial/RectList;", "", AppAgent.CONSTRUCT, "()V", "", "value", "l", "t", "r", "b", "parentId", "", "focusable", "gesturable", "LC7/r;", "insert", "(IIIIIIZZ)V", "remove", "(I)Z", "update", "(IIIII)Z", "updateFlagsFor", "(IZZ)Z", "move", "id", "deltaX", "deltaY", "updateSubhierarchy", "(III)V", "markUpdated", "(I)V", "Lkotlin/Function4;", "block", "withRect", "(ILS7/p;)Z", "Lkotlin/Function2;", "", "withTopLeftBottomRight", "(ILS7/n;)Z", "contains", "indexOf", "(I)I", "metaFor", "(I)J", "Lkotlin/Function1;", "forEachIntersection", "(IIIILS7/k;)V", "forEachGesturableIntersection", "Lkotlin/Function5;", "forEachRect", "(LS7/q;)V", "x", "y", "(IILS7/k;)V", "index", "forEachIntersectingRectWithValueAt", "(ILS7/q;)V", "searchAxis", "", "neighborsScoredByDistance$ui_release", "(IIIII)[I", "neighborsScoredByDistance", "k", "Lkotlin/Function6;", "findKNearestNeighbors", "(IIIIIILS7/r;)V", "findNearestNeighbor", "(IIIII)I", "defragment", "clearUpdated", "Lkotlin/Function3;", "forEachUpdatedRect", "(LS7/o;)V", "", "debugString", "()Ljava/lang/String;", "allocateItemsIndex", "()I", "actualSize", "currentSize", "", "currentItems", "resizeStorage", "(II[J)V", "stackMeta", "(JII)V", "items", "[J", "stack", "itemsSize", "I", "getSize", "size", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RectList {
    public static final int $stable = 8;
    public int itemsSize;
    public long[] items = new long[192];
    public long[] stack = new long[192];

    private final int allocateItemsIndex() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i6 = i + 3;
        this.itemsSize = i6;
        int length = jArr.length;
        if (length <= i6) {
            resizeStorage(length, i, jArr);
        }
        return i;
    }

    public static /* synthetic */ void insert$default(RectList rectList, int i, int i6, int i10, int i11, int i12, int i13, boolean z10, boolean z11, int i14, Object obj) {
        boolean z12;
        RectList rectList2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20 = (i14 & 32) != 0 ? -1 : i13;
        boolean z13 = (i14 & 64) != 0 ? false : z10;
        if ((i14 & 128) != 0) {
            z12 = false;
            i15 = i;
            i16 = i6;
            i17 = i10;
            i18 = i11;
            i19 = i12;
            rectList2 = rectList;
        } else {
            z12 = z11;
            rectList2 = rectList;
            i15 = i;
            i16 = i6;
            i17 = i10;
            i18 = i11;
            i19 = i12;
        }
        rectList2.insert(i15, i16, i17, i18, i19, i20, z13, z12);
    }

    private final void resizeStorage(int actualSize, int currentSize, long[] currentItems) {
        int iMax = Math.max(actualSize * 2, currentSize + 3);
        long[] jArrCopyOf = Arrays.copyOf(currentItems, iMax);
        k.e(jArrCopyOf, "copyOf(...)");
        this.items = jArrCopyOf;
        long[] jArrCopyOf2 = Arrays.copyOf(this.stack, iMax);
        k.e(jArrCopyOf2, "copyOf(...)");
        this.stack = jArrCopyOf2;
    }

    public final void clearUpdated() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i; i6 += 3) {
            int i10 = i6 + 2;
            jArr[i10] = jArr[i10] & (-2305843009213693953L);
        }
    }

    public final boolean contains(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            if ((((int) jArr[i10 + 2]) & RectListKt.Lower26Bits) == i) {
                return true;
            }
        }
        return false;
    }

    public final String debugString() {
        StringBuilder sb = new StringBuilder();
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i; i6 += 3) {
            long j5 = jArr[i6];
            long j6 = jArr[i6 + 1];
            long j10 = jArr[i6 + 2];
            sb.append("id=" + (((int) j10) & RectListKt.Lower26Bits) + ", rect=[" + ((int) (j5 >> 32)) + ',' + ((int) j5) + ',' + ((int) (j6 >> 32)) + ',' + ((int) j6) + "], parent=" + (((int) (j10 >> 26)) & RectListKt.Lower26Bits));
            sb.append('\n');
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final void defragment() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        long[] jArr2 = this.stack;
        int i6 = 0;
        for (int i10 = 0; i10 < jArr.length - 2 && i6 < jArr2.length - 2 && i10 < i; i10 += 3) {
            int i11 = i10 + 2;
            if (jArr[i11] != RectListKt.TombStone) {
                jArr2[i6] = jArr[i10];
                jArr2[i6 + 1] = jArr[i10 + 1];
                jArr2[i6 + 2] = jArr[i11];
                i6 += 3;
            }
        }
        this.itemsSize = i6;
        this.items = jArr2;
        this.stack = jArr;
    }

    public final void findKNearestNeighbors(int searchAxis, int k, int l, int t9, int r5, int b, r block) {
        int i;
        int[] iArrNeighborsScoredByDistance$ui_release = neighborsScoredByDistance$ui_release(searchAxis, l, t9, r5, b);
        long[] jArr = this.items;
        int i6 = 1;
        int i10 = 0;
        int i11 = 0;
        while (i10 <= k) {
            int iMin = Integer.MAX_VALUE;
            int i12 = 0;
            while (i12 < iArrNeighborsScoredByDistance$ui_release.length) {
                int i13 = iArrNeighborsScoredByDistance$ui_release[i12];
                if (i13 > i6) {
                    iMin = Math.min(iMin, i13);
                }
                if (i13 == i6) {
                    int i14 = i12 * 3;
                    long j5 = jArr[i14];
                    long j6 = jArr[i14 + 1];
                    i = i6;
                    block.invoke(Integer.valueOf(i13), Integer.valueOf(((int) jArr[i14 + 2]) & RectListKt.Lower26Bits), Integer.valueOf((int) (j5 >> 32)), Integer.valueOf((int) j5), Integer.valueOf((int) (j6 >> 32)), Integer.valueOf((int) j6));
                    i11++;
                    if (i11 == k) {
                        return;
                    }
                } else {
                    i = i6;
                }
                i12++;
                i6 = i;
            }
            i10++;
            i6 = iMin;
        }
    }

    public final int findNearestNeighbor(int searchAxis, int l, int t9, int r5, int b) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i6 = Integer.MAX_VALUE;
        int i10 = -1;
        for (int i11 = 0; i11 < jArr.length - 2 && i11 < i; i11 += 3) {
            long j5 = jArr[i11];
            int i12 = i11 + 1;
            long j6 = jArr[i12];
            int iDistanceScore = RectListKt.distanceScore(searchAxis, l, t9, r5, b, (int) (j5 >> 32), (int) j5, (int) (j6 >> 32), (int) j6);
            boolean z10 = (iDistanceScore < i6) & (iDistanceScore > 0);
            if (z10) {
                i6 = iDistanceScore;
            }
            if (z10) {
                i10 = i12;
            }
        }
        if (i10 < 0 || i10 >= jArr.length) {
            return -1;
        }
        return ((int) jArr[i10]) & RectListKt.Lower26Bits;
    }

    public final void forEachGesturableIntersection(int l, int t9, int r5, int b, S7.k block) {
        long j5 = (l << 32) | (t9 & 4294967295L);
        long j6 = (r5 << 32) | (b & 4294967295L);
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i; i6 += 3) {
            long j10 = jArr[i6 + 2];
            if ((((int) (j10 >> 63)) & 1) != 0) {
                if (((((j6 - jArr[i6]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i6 + 1] - j5) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    block.invoke(Integer.valueOf(((int) j10) & RectListKt.Lower26Bits));
                }
            }
        }
    }

    public final void forEachIntersectingRectWithValueAt(int index, q block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        long j5 = jArr[index];
        long j6 = jArr[index + 1];
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i; i6 += 3) {
            if (i6 != index) {
                long j10 = jArr[i6];
                long j11 = jArr[i6 + 1];
                if (((((j6 - j10) - InlineClassHelperKt.Uint64Low32) | ((j11 - j5) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    block.invoke(Integer.valueOf((int) (j10 >> 32)), Integer.valueOf((int) j10), Integer.valueOf((int) (j11 >> 32)), Integer.valueOf((int) j11), Integer.valueOf(((int) jArr[i6 + 2]) & RectListKt.Lower26Bits));
                }
            }
        }
    }

    public final void forEachIntersection(int l, int t9, int r5, int b, S7.k block) {
        long j5 = (l << 32) | (t9 & 4294967295L);
        long j6 = (r5 << 32) | (b & 4294967295L);
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i; i6 += 3) {
            if (((((j6 - jArr[i6]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i6 + 1] - j5) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                block.invoke(Integer.valueOf(((int) jArr[i6 + 2]) & RectListKt.Lower26Bits));
            }
        }
    }

    public final void forEachRect(q block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i; i6 += 3) {
            long j5 = jArr[i6];
            long j6 = jArr[i6 + 1];
            block.invoke(Integer.valueOf(((int) jArr[i6 + 2]) & RectListKt.Lower26Bits), Integer.valueOf((int) (j5 >> 32)), Integer.valueOf((int) j5), Integer.valueOf((int) (j6 >> 32)), Integer.valueOf((int) j6));
        }
    }

    public final void forEachUpdatedRect(o block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i; i6 += 3) {
            long j5 = jArr[i6 + 2];
            if ((((int) (j5 >> 61)) & 1) != 0) {
                block.invoke(Integer.valueOf(((int) j5) & RectListKt.Lower26Bits), Long.valueOf(jArr[i6]), Long.valueOf(jArr[i6 + 1]));
            }
        }
    }

    public final int getSize() {
        return this.itemsSize / 3;
    }

    public final int indexOf(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            if ((((int) jArr[i10 + 2]) & RectListKt.Lower26Bits) == i) {
                return i10;
            }
        }
        return -1;
    }

    public final void insert(int value, int l, int t9, int r5, int b, int parentId, boolean focusable, boolean gesturable) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i6 = i + 3;
        this.itemsSize = i6;
        int length = jArr.length;
        if (length <= i6) {
            resizeStorage(length, i, jArr);
        }
        long[] jArr2 = this.items;
        jArr2[i] = (l << 32) | (t9 & 4294967295L);
        jArr2[i + 1] = (r5 << 32) | (b & 4294967295L);
        long j5 = ((gesturable ? 1L : 0L) << 63) | ((focusable ? 1L : 0L) << 62) | (1 << 61) | (0 << 52);
        int i10 = parentId & RectListKt.Lower26Bits;
        jArr2[i + 2] = j5 | (i10 << 26) | (value & RectListKt.Lower26Bits);
        if (parentId < 0) {
            return;
        }
        for (int i11 = i - 3; i11 >= 0; i11 -= 3) {
            int i12 = i11 + 2;
            long j6 = jArr2[i12];
            if ((((int) j6) & RectListKt.Lower26Bits) == i10) {
                jArr2[i12] = (j6 & RectListKt.EverythingButLastChildOffset) | (((i - i11) & 511) << 52);
                return;
            }
        }
    }

    public final void markUpdated(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            int i11 = i10 + 2;
            long j5 = jArr[i11];
            if ((((int) j5) & RectListKt.Lower26Bits) == i) {
                jArr[i11] = 2305843009213693952L | j5;
                return;
            }
        }
    }

    public final long metaFor(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            long j5 = jArr[i10 + 2];
            if ((((int) j5) & RectListKt.Lower26Bits) == i) {
                return j5;
            }
        }
        return RectListKt.TombStone;
    }

    public final boolean move(int value, int l, int t9, int r5, int b) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            int i11 = i10 + 2;
            long j5 = jArr[i11];
            if ((((int) j5) & RectListKt.Lower26Bits) == i) {
                long j6 = jArr[i10];
                jArr[i10] = (t9 & 4294967295L) | (l << 32);
                int i12 = i10;
                jArr[i10 + 1] = (b & 4294967295L) | (r5 << 32);
                jArr[i11] = 2305843009213693952L | j5;
                int i13 = l - ((int) (j6 >> 32));
                int i14 = t9 - ((int) j6);
                if ((i13 != 0) | (i14 != 0)) {
                    updateSubhierarchy((RectListKt.EverythingButParentId & j5) | (((i12 + 3) & RectListKt.Lower26Bits) << 26), i13, i14);
                }
                return true;
            }
        }
        return false;
    }

    public final int[] neighborsScoredByDistance$ui_release(int searchAxis, int l, int t9, int r5, int b) {
        long[] jArr = this.items;
        int i = this.itemsSize / 3;
        int[] iArr = new int[i];
        for (int i6 = 0; i6 < i; i6++) {
            int i10 = i6 * 3;
            if (i10 < 0 || i10 >= jArr.length - 1) {
                break;
            }
            long j5 = jArr[i10];
            long j6 = jArr[i10 + 1];
            iArr[i6] = RectListKt.distanceScore(searchAxis, l, t9, r5, b, (int) (j5 >> 32), (int) j5, (int) (j6 >> 32), (int) j6);
        }
        return iArr;
    }

    public final boolean remove(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            int i11 = i10 + 2;
            if ((((int) jArr[i11]) & RectListKt.Lower26Bits) == i) {
                jArr[i10] = -1;
                jArr[i10 + 1] = -1;
                jArr[i11] = 2305843009213693951L;
                return true;
            }
        }
        return false;
    }

    public final boolean update(int value, int l, int t9, int r5, int b) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            int i11 = i10 + 2;
            long j5 = jArr[i11];
            if ((((int) j5) & RectListKt.Lower26Bits) == i) {
                jArr[i10] = (l << 32) | (t9 & 4294967295L);
                jArr[i10 + 1] = (r5 << 32) | (4294967295L & b);
                jArr[i11] = 2305843009213693952L | j5;
                return true;
            }
        }
        return false;
    }

    public final boolean updateFlagsFor(int value, boolean focusable, boolean gesturable) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            int i11 = i10 + 2;
            long j5 = jArr[i11];
            if ((((int) j5) & RectListKt.Lower26Bits) == i) {
                jArr[i11] = (4611686018427387903L & j5) | ((focusable ? 1L : 0L) * SieveCacheKt.NodeVisitedBit) | ((gesturable ? 1L : 0L) * Long.MIN_VALUE);
                return true;
            }
        }
        return false;
    }

    public final void updateSubhierarchy(int id, int deltaX, int deltaY) {
        updateSubhierarchy(((this.itemsSize & 511) << 52) | (0 << 26) | (id & RectListKt.Lower26Bits), deltaX, deltaY);
    }

    public final boolean withRect(int value, p block) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            if ((((int) jArr[i10 + 2]) & RectListKt.Lower26Bits) == i) {
                long j5 = jArr[i10];
                long j6 = jArr[i10 + 1];
                block.invoke(Integer.valueOf((int) (j5 >> 32)), Integer.valueOf((int) j5), Integer.valueOf((int) (j6 >> 32)), Integer.valueOf((int) j6));
                return true;
            }
        }
        return false;
    }

    public final boolean withTopLeftBottomRight(int value, n block) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i6 = this.itemsSize;
        for (int i10 = 0; i10 < jArr.length - 2 && i10 < i6; i10 += 3) {
            if ((((int) jArr[i10 + 2]) & RectListKt.Lower26Bits) == i) {
                block.invoke(Long.valueOf(jArr[i10]), Long.valueOf(jArr[i10 + 1]));
                return true;
            }
        }
        return false;
    }

    private final void updateSubhierarchy(long stackMeta, int deltaX, int deltaY) {
        int i;
        char c;
        char c2;
        long[] jArr = this.items;
        long[] jArr2 = this.stack;
        int size = getSize();
        jArr2[0] = stackMeta;
        int i6 = 1;
        while (i6 > 0) {
            i6--;
            long j5 = jArr2[i6];
            int i10 = RectListKt.Lower26Bits;
            int i11 = ((int) j5) & RectListKt.Lower26Bits;
            char c5 = 26;
            int i12 = ((int) (j5 >> 26)) & RectListKt.Lower26Bits;
            char c10 = '4';
            int i13 = ((int) (j5 >> 52)) & 511;
            int i14 = i13 == 511 ? size : i13 + i12;
            if (i12 < 0) {
                return;
            }
            while (i12 < jArr.length - 2 && i12 < i14) {
                int i15 = i12 + 2;
                long j6 = jArr[i15];
                if ((((int) (j6 >> c5)) & i10) == i11) {
                    long j10 = jArr[i12];
                    int i16 = i12 + 1;
                    i = i10;
                    c = c5;
                    long j11 = jArr[i16];
                    c2 = c10;
                    jArr[i12] = ((((int) j10) + deltaY) & 4294967295L) | ((((int) (j10 >> 32)) + deltaX) << 32);
                    jArr[i16] = ((((int) j11) + deltaY) & 4294967295L) | ((((int) (j11 >> 32)) + deltaX) << 32);
                    jArr[i15] = 2305843009213693952L | j6;
                    if ((((int) (j6 >> c2)) & 511) > 0) {
                        jArr2[i6] = (RectListKt.EverythingButParentId & j6) | (((i12 + 3) & i) << c);
                        i6++;
                    }
                } else {
                    i = i10;
                    c = c5;
                    c2 = c10;
                }
                i12 += 3;
                i10 = i;
                c5 = c;
                c10 = c2;
            }
        }
    }

    public final void forEachIntersection(int x10, int y, S7.k block) {
        long j5 = (y & 4294967295L) | (x10 << 32);
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i6 = 0; i6 < jArr.length - 2 && i6 < i; i6 += 3) {
            if (((((j5 - jArr[i6]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i6 + 1] - j5) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                block.invoke(Integer.valueOf(((int) jArr[i6 + 2]) & RectListKt.Lower26Bits));
            }
        }
    }
}
