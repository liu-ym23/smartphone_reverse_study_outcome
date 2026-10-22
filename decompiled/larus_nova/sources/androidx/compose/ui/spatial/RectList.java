package androidx.compose.ui.spatial;

import androidx.collection.SieveCacheKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import com.alibaba.fastjson.parser.JSONLexer;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.event.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\f\u001a\u00020\bH\u0082\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002JL\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\bJ.\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u001e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ.\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u001e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bJ \u0010 \u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0002J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\bJ4\u0010'\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2$\u0010(\u001a \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0)J(\u0010*\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0+J\u0011\u0010,\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\bH\u0086\u0002J\u000e\u0010-\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010.\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\bJ=\u0010/\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e00H\u0086\bJ=\u00101\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e00H\u0086\bJ5\u00102\u001a\u00020\u000e2*\u0010(\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e03H\u0086\bJ-\u0010/\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e00H\u0086\bJ=\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\b2*\u0010(\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e03H\u0086\bJ5\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0000¢\u0006\u0002\b;JÇ\u0001\u0010<\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u008b\u0001\u0010(\u001a\u0086\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0>H\u0086\bJ1\u0010B\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0086\bJ\u0006\u0010C\u001a\u00020\u000eJ\u0006\u0010D\u001a\u00020\u000eJ)\u0010E\u001a\u00020\u000e2\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0FH\u0086\bJ\u0006\u0010G\u001a\u00020HR\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006I"}, d2 = {"Landroidx/compose/ui/spatial/RectList;", "", "<init>", "()V", "items", "", "stack", "itemsSize", "", "size", "getSize", "()I", "allocateItemsIndex", "resizeStorage", "", "actualSize", "currentSize", "currentItems", "insert", "value", "l", "t", "r", "b", "parentId", "focusable", "", "gesturable", "remove", "update", "updateFlagsFor", "move", "updateSubhierarchy", "id", "deltaX", "deltaY", "stackMeta", "", "markUpdated", "withRect", "block", "Lkotlin/Function4;", "withTopLeftBottomRight", "Lkotlin/Function2;", "contains", "indexOf", "metaFor", "forEachIntersection", "Lkotlin/Function1;", "forEachGesturableIntersection", "forEachRect", "Lkotlin/Function5;", "x", "y", "forEachIntersectingRectWithValueAt", "index", "neighborsScoredByDistance", "", "searchAxis", "neighborsScoredByDistance$ui_release", "findKNearestNeighbors", ce.f26396k, "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", a.KEY_SCORE, "findNearestNeighbor", "defragment", "clearUpdated", "forEachUpdatedRect", "Lkotlin/Function3;", "debugString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RectList {
    public static final int $stable = 8;
    public long[] items;
    public int itemsSize;
    public long[] stack;

    private final int allocateItemsIndex() {
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        int r102 = r101 + 3;
        this.itemsSize = r102;
        int r103 = r100.length;
        if (r103 > r102) goto L5;
        resizeStorage(r103, r101, r100);
    L5:
        return r101;
    }

    public final void clearUpdated() {
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        int r102 = 0;
    L4:
        if (r102 >= (r100.length - 2)) goto L7;
        if (r102 >= r101) goto L10;
        int r103 = r102 + 2;
        r100[r103] = r100[r103] & (-2305843009213693953L);
        r102 = r102 + 3;
        goto L4
    L10:
        return;
    }

    public final String debugString() {
        StringBuilder r100 = new StringBuilder();
        long[] r101 = this.items;
        int r102 = this.itemsSize;
        int r103 = 0;
    L4:
        if (r103 >= (r101.length - 2)) goto L8;
        if (r103 >= r102) goto L8;
        long r104 = r101[r103 + 0];
        long r105 = r101[r103 + 1];
        long r106 = r101[r103 + 2];
        int r110 = (int) (r104 >> 32);
        int r107 = (int) r104;
        int r108 = (int) (r105 >> 32);
        int r109 = (int) r105;
        r100.append("id=" + (((int) r106) & RectListKt.Lower26Bits) + ", rect=[" + r110 + ',' + r107 + ',' + r108 + ',' + r109 + "], parent=" + (((int) (r106 >> 26)) & RectListKt.Lower26Bits));
        r100.append('\n');
        r103 = r103 + 3;
    L8:
        return r100.toString();
    }

    public final void defragment() {
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        long[] r102 = this.stack;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= (r100.length - 2)) goto L12;
        if (r104 >= (r102.length - 2)) goto L12;
        if (r103 >= r101) goto L12;
        int r105 = r103 + 2;
        if (r100[r105] == RectListKt.TombStone) goto L11;
        r102[r104 + 0] = r100[r103 + 0];
        r102[r104 + 1] = r100[r103 + 1];
        r102[r104 + 2] = r100[r105];
        r104 = r104 + 3;
    L11:
        r103 = r103 + 3;
    L12:
        this.itemsSize = r104;
        this.items = r102;
        this.stack = r100;
    }

    public final int getSize() {
        return this.itemsSize / 3;
    }

    public RectList() {
        this.items = new long[192];
        this.stack = new long[192];
    }

    public final boolean contains(int r100) {
        int r101 = r100 & RectListKt.Lower26Bits;
        long[] r102 = this.items;
        int r103 = this.itemsSize;
        int r104 = 0;
    L4:
        if (r104 >= (r102.length - 2)) goto L11;
        if (r104 >= r103) goto L11;
        if ((((int) r102[r104 + 2]) & RectListKt.Lower26Bits) == r101) goto L8;
        r104 = r104 + 3;
        goto L4
    L8:
        return true;
    L11:
        return false;
    }

    public final void forEachRect(Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r110) {
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        int r102 = 0;
    L4:
        if (r102 >= (r100.length - 2)) goto L7;
        if (r102 >= r101) goto L10;
        long r103 = r100[r102 + 0];
        long r104 = r100[r102 + 1];
        r110.invoke(Integer.valueOf(67108863 & ((int) r100[r102 + 2])), Integer.valueOf((int) (r103 >> 32)), Integer.valueOf((int) r103), Integer.valueOf((int) (r104 >> 32)), Integer.valueOf((int) r104));
        r102 = r102 + 3;
        goto L4
    L10:
        return;
    }

    public final void forEachUpdatedRect(Function3<? super Integer, ? super Long, ? super Long, Unit> r110) {
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        int r102 = 0;
    L4:
        if (r102 >= (r100.length - 2)) goto L10;
        if (r102 >= r101) goto L15;
        long r103 = r100[r102 + 2];
        if ((((int) (r103 >> 61)) & 1) == 0) goto L9;
        r110.invoke(Integer.valueOf(67108863 & ((int) r103)), Long.valueOf(r100[r102 + 0]), Long.valueOf(r100[r102 + 1]));
    L9:
        r102 = r102 + 3;
        goto L4
    L15:
        return;
    }

    public final int indexOf(int r100) {
        int r101 = r100 & RectListKt.Lower26Bits;
        long[] r102 = this.items;
        int r103 = this.itemsSize;
        int r104 = 0;
    L4:
        if (r104 >= (r102.length - 2)) goto L10;
        if (r104 >= r103) goto L15;
        if ((((int) r102[r104 + 2]) & RectListKt.Lower26Bits) == r101) goto L8;
        r104 = r104 + 3;
        goto L4
    L8:
        return r104;
    L15:
        return -1;
    L10:
        return -1;
    }

    public final void markUpdated(int r100) {
        int r101 = r100 & RectListKt.Lower26Bits;
        long[] r102 = this.items;
        int r103 = this.itemsSize;
        int r104 = 0;
    L4:
        if (r104 >= (r102.length - 2)) goto L11;
        if (r104 >= r103) goto L15;
        int r105 = r104 + 2;
        long r106 = r102[r105];
        if ((((int) r106) & RectListKt.Lower26Bits) == r101) goto L8;
        r104 = r104 + 3;
        goto L4
    L8:
        r102[r105] = 2305843009213693952L | r106;
        return;
    L15:
        return;
    }

    public final long metaFor(int r100) {
        int r101 = r100 & RectListKt.Lower26Bits;
        long[] r102 = this.items;
        int r103 = this.itemsSize;
        int r104 = 0;
    L4:
        if (r104 >= (r102.length - 2)) goto L10;
        if (r104 >= r103) goto L15;
        long r105 = r102[r104 + 2];
        if ((((int) r105) & RectListKt.Lower26Bits) == r101) goto L8;
        r104 = r104 + 3;
        goto L4
    L8:
        return r105;
    L15:
        return RectListKt.TombStone;
    L10:
        return RectListKt.TombStone;
    }

    public final boolean remove(int r100) {
        int r101 = r100 & RectListKt.Lower26Bits;
        long[] r102 = this.items;
        int r103 = this.itemsSize;
        int r104 = 0;
    L4:
        if (r104 >= (r102.length - 2)) goto L11;
        if (r104 >= r103) goto L11;
        int r105 = r104 + 2;
        if ((((int) r102[r105]) & RectListKt.Lower26Bits) == r101) goto L8;
        r104 = r104 + 3;
        goto L4
    L8:
        r102[r104 + 0] = -1;
        r102[r104 + 1] = -1;
        r102[r105] = 2305843009213693951L;
        return true;
    L11:
        return false;
    }

    public final void forEachIntersectingRectWithValueAt(int r210, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r211) {
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        long r102 = r100[r210];
        long r103 = r100[r210 + 1];
        int r104 = 0;
    L4:
        if (r104 >= (r100.length - 2)) goto L16;
        if (r104 >= r101) goto L24;
        if (r104 == r210) goto L7;
        long r110 = r100[r104 + 0];
        long r111 = r100[r104 + 1];
        if (((((r103 - r110) - InlineClassHelperKt.Uint64Low32) | ((r111 - r102) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0) goto L11;
        boolean r112 = true;
    L12:
        if (r112 == false) goto L14;
        int r113 = r104;
        r211.invoke(Integer.valueOf((int) (r110 >> 32)), Integer.valueOf((int) r110), Integer.valueOf((int) (r111 >> 32)), Integer.valueOf((int) r111), Integer.valueOf(67108863 & ((int) r100[r113 + 2])));
    L15:
        r104 = r113 + 3;
        goto L4
    L14:
        r113 = r104;
        goto L15
    L11:
        r112 = false;
        goto L12
    L7:
        r104 = r104 + 3;
        goto L4
    L24:
        return;
    }

    public final boolean withRect(int r100, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r101) {
        int r102 = r100 & RectListKt.Lower26Bits;
        long[] r103 = this.items;
        int r104 = this.itemsSize;
        int r105 = 0;
    L4:
        if (r105 >= (r103.length - 2)) goto L11;
        if (r105 >= r104) goto L11;
        if ((((int) r103[r105 + 2]) & RectListKt.Lower26Bits) == r102) goto L8;
        r105 = r105 + 3;
        goto L4
    L8:
        long r106 = r103[r105 + 0];
        long r107 = r103[r105 + 1];
        r101.invoke(Integer.valueOf((int) (r106 >> 32)), Integer.valueOf((int) r106), Integer.valueOf((int) (r107 >> 32)), Integer.valueOf((int) r107));
        return true;
    L11:
        return false;
    }

    public final boolean withTopLeftBottomRight(int r100, Function2<? super Long, ? super Long, Unit> r101) {
        int r102 = r100 & RectListKt.Lower26Bits;
        long[] r103 = this.items;
        int r104 = this.itemsSize;
        int r105 = 0;
    L4:
        if (r105 >= (r103.length - 2)) goto L11;
        if (r105 >= r104) goto L11;
        if ((((int) r103[r105 + 2]) & RectListKt.Lower26Bits) == r102) goto L8;
        r105 = r105 + 3;
        goto L4
    L8:
        r101.invoke(Long.valueOf(r103[r105 + 0]), Long.valueOf(r103[r105 + 1]));
        return true;
    L11:
        return false;
    }

    private final void resizeStorage(int r100, int r101, long[] r102) {
        int r103 = Math.max(r100 * 2, r101 + 3);
        this.items = Arrays.copyOf(r102, r103);
        this.stack = Arrays.copyOf(this.stack, r103);
    }

    private final void updateSubhierarchy(long r210, int r211, int r212) {
        long[] r100 = this.items;
        long[] r101 = this.stack;
        getSize();
        r101[0] = r210;
        int r102 = 1;
    L3:
        if (r102 <= 0) goto L21;
        r102 = r102 - 1;
        long r103 = r101[r102];
        int r104 = RectListKt.Lower26Bits;
        int r105 = ((int) r103) & RectListKt.Lower26Bits;
        char r106 = JSONLexer.EOI;
        int r107 = ((int) (r103 >> 26)) & RectListKt.Lower26Bits;
        int r108 = ((int) (r103 >> 52)) & 511;
        if (r108 != 511) goto L7;
        int r109 = r100.length;
    L8:
        if (r107 < 0) goto L29;
    L10:
        if (r107 >= (r100.length - 2)) goto L3;
        if (r107 >= r109) goto L3;
        int r110 = r107 + 2;
        long r111 = r100[r110];
        if ((((int) (r111 >> r106)) & r104) != r105) goto L18;
        int r112 = r107 + 0;
        long r113 = r100[r112];
        int r114 = r107 + 1;
        int r115 = r109;
        long r116 = r100[r114];
        r100[r112] = (((long) (((int) r113) + r212)) & BodyPartID.bodyIdMax) | (((long) (((int) (r113 >> 32)) + r211)) << 32);
        r100[r114] = (((long) (((int) r116) + r212)) & BodyPartID.bodyIdMax) | (((long) (((int) (r116 >> 32)) + r211)) << 32);
        r100[r110] = 2305843009213693952L | r111;
        if ((((int) (r111 >> 52)) & 511) <= 0) goto L17;
        long r117 = RectListKt.EverythingButParentId & r111;
        long r118 = (r107 + 3) & RectListKt.Lower26Bits;
        r106 = JSONLexer.EOI;
        r101[r102] = r117 | (r118 << 26);
        r102 = r102 + 1;
    L20:
        r107 = r107 + 3;
        r109 = r115;
        r104 = RectListKt.Lower26Bits;
        goto L10
    L17:
        r106 = JSONLexer.EOI;
        goto L20
    L18:
        r115 = r109;
        goto L20
    L29:
        return;
    L7:
        r109 = r108 + r107;
        goto L8
    }

    public final void forEachIntersection(int r110, int r111, Function1<? super Integer, Unit> r112) {
        long r113 = (((long) r111) & BodyPartID.bodyIdMax) | (((long) r110) << 32);
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        int r102 = 0;
    L4:
        if (r102 >= (r100.length - 2)) goto L13;
        if (r102 >= r101) goto L18;
        if (((((r113 - r100[r102 + 0]) - InlineClassHelperKt.Uint64Low32) | ((r100[r102 + 1] - r113) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        r112.invoke(Integer.valueOf(67108863 & ((int) r100[r102 + 2])));
    L12:
        r102 = r102 + 3;
        goto L4
    L9:
        r103 = false;
        goto L10
    L18:
        return;
    }

    public final boolean updateFlagsFor(int r110, boolean r111, boolean r112) {
        int r113 = r110 & RectListKt.Lower26Bits;
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        int r102 = 0;
    L4:
        if (r102 >= (r100.length - 2)) goto L11;
        if (r102 >= r101) goto L11;
        int r103 = r102 + 2;
        long r104 = r100[r103];
        if ((((int) r104) & RectListKt.Lower26Bits) == r113) goto L8;
        r102 = r102 + 3;
        goto L4
    L8:
        r100[r103] = (((r111 ? 1 : 0) * SieveCacheKt.NodeVisitedBit) | (((-4611686018427387905L) & r104) & Long.MAX_VALUE)) | ((r112 ? 1 : 0) * Long.MIN_VALUE);
        return true;
    L11:
        return false;
    }

    public final void updateSubhierarchy(int r100, int r101, int r102) {
        updateSubhierarchy((((((long) Math.min(this.itemsSize, 511)) << 52) | 0) | (((long) 0) << 26)) | (((long) (r100 & RectListKt.Lower26Bits)) << 0), r101, r102);
    }

    public final int findNearestNeighbor(int r210, int r211, int r212, int r213, int r310) {
        long[] r100 = this.items;
        int r101 = this.itemsSize;
        int r102 = Integer.MAX_VALUE;
        int r103 = 0;
        int r104 = -1;
    L4:
        if (r103 >= (r100.length - 2)) goto L19;
        if (r103 >= r101) goto L19;
        long r105 = r100[r103 + 0];
        int r110 = r103 + 1;
        long r111 = r100[r110];
        int r106 = RectListKt.distanceScore(r210, r211, r212, r213, r310, (int) (r105 >> 32), (int) r105, (int) (r111 >> 32), (int) r111);
        boolean r107 = true;
        if (r106 <= 0) goto L9;
        boolean r112 = true;
    L10:
        if (r106 < r102) goto L13;
        r107 = false;
    L13:
        boolean r108 = r107 & r112;
        if (r108 == false) goto L16;
        r102 = r106;
    L16:
        if (r108 == false) goto L18;
        r104 = r110;
    L18:
        r103 = r103 + 3;
        goto L4
    L9:
        r112 = false;
    L19:
        if (r104 >= 0) goto L21;
        return -1;
    L21:
        if (r104 < r100.length) goto L24;
        return -1;
    L24:
        return ((int) r100[r104]) & RectListKt.Lower26Bits;
    }

    public final void forEachGesturableIntersection(int r110, int r210, int r211, int r212, Function1<? super Integer, Unit> r213) {
        long r100 = (((long) r110) << 32) | (((long) r210) & BodyPartID.bodyIdMax);
        long r101 = (((long) r211) << 32) | (((long) r212) & BodyPartID.bodyIdMax);
        long[] r102 = this.items;
        int r103 = this.itemsSize;
        int r104 = 0;
    L4:
        if (r104 >= (r102.length - 2)) goto L16;
        if (r104 >= r103) goto L21;
        long r105 = r102[r104 + 2];
        boolean r111 = true;
        if ((((int) (r105 >> 63)) & 1) == 0) goto L15;
        if (((((r101 - r102[r104 + 0]) - InlineClassHelperKt.Uint64Low32) | ((r102[r104 + 1] - r100) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) goto L12;
        r111 = false;
    L12:
        if (r111 == false) goto L15;
        r213.invoke(Integer.valueOf(67108863 & ((int) r105)));
    L15:
        r104 = r104 + 3;
        goto L4
    L21:
        return;
    }

    public final void forEachIntersection(int r110, int r111, int r112, int r113, Function1<? super Integer, Unit> r114) {
        long r100 = (((long) r110) << 32) | (((long) r111) & BodyPartID.bodyIdMax);
        long r115 = (((long) r112) << 32) | (((long) r113) & BodyPartID.bodyIdMax);
        long[] r116 = this.items;
        int r117 = this.itemsSize;
        int r101 = 0;
    L4:
        if (r101 >= (r116.length - 2)) goto L13;
        if (r101 >= r117) goto L18;
        if (((((r115 - r116[r101 + 0]) - InlineClassHelperKt.Uint64Low32) | ((r116[r101 + 1] - r100) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        r114.invoke(Integer.valueOf(67108863 & ((int) r116[r101 + 2])));
    L12:
        r101 = r101 + 3;
        goto L4
    L9:
        r102 = false;
        goto L10
    L18:
        return;
    }

    public final boolean move(int r110, int r210, int r211, int r212, int r213) {
        int r100 = r110 & RectListKt.Lower26Bits;
        long[] r101 = this.items;
        int r102 = this.itemsSize;
        int r103 = 0;
    L4:
        if (r103 >= (r101.length - 2)) goto L20;
        if (r103 >= r102) goto L25;
        int r104 = r103 + 2;
        long r111 = r101[r104];
        if ((((int) r111) & RectListKt.Lower26Bits) == r100) goto L8;
        r103 = r103 + 3;
        goto L4
    L8:
        int r105 = r103 + 0;
        long r112 = r101[r105];
        r101[r105] = (((long) r211) & BodyPartID.bodyIdMax) | (((long) r210) << 32);
        r101[r103 + 1] = (((long) r212) << 32) | (((long) r213) & BodyPartID.bodyIdMax);
        r101[r104] = 2305843009213693952L | r111;
        int r106 = r210 - ((int) (r112 >> 32));
        int r107 = r211 - ((int) r112);
        if (r106 == 0) goto L11;
        boolean r108 = true;
    L12:
        if (r107 == 0) goto L14;
        boolean r109 = true;
    L16:
        if ((r108 | r109) == false) goto L18;
        updateSubhierarchy((RectListKt.EverythingButParentId & r111) | (((long) (67108863 & (r103 + 3))) << 26), r106, r107);
    L18:
        return true;
    L14:
        r109 = false;
        goto L16
    L11:
        r108 = false;
        goto L12
    L25:
        return false;
    L20:
        return false;
    }

    public final int[] neighborsScoredByDistance$ui_release(int r210, int r211, int r212, int r213, int r214) {
        long[] r100 = this.items;
        int r101 = this.itemsSize / 3;
        int[] r102 = new int[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L10;
        int r104 = r103 * 3;
        if (r104 < 0) goto L10;
        if (r104 >= (r100.length - 1)) goto L10;
        long r105 = r100[r104 + 0];
        long r106 = r100[r104 + 1];
        r102[r103] = RectListKt.distanceScore(r210, r211, r212, r213, r214, (int) (r105 >> 32), (int) r105, (int) (r106 >> 32), (int) r106);
        r103 = r103 + 1;
    L10:
        return r102;
    }

    public final boolean update(int r110, int r111, int r112, int r210, int r211) {
        int r100 = r110 & RectListKt.Lower26Bits;
        long[] r101 = this.items;
        int r102 = this.itemsSize;
        int r103 = 0;
    L4:
        if (r103 >= (r101.length - 2)) goto L11;
        if (r103 >= r102) goto L11;
        int r104 = r103 + 2;
        long r105 = r101[r104];
        if ((((int) r105) & RectListKt.Lower26Bits) == r100) goto L8;
        r103 = r103 + 3;
        goto L4
    L8:
        r101[r103 + 0] = (((long) r111) << 32) | (((long) r112) & BodyPartID.bodyIdMax);
        r101[r103 + 1] = (((long) r210) << 32) | (((long) r211) & BodyPartID.bodyIdMax);
        r101[r104] = 2305843009213693952L | r105;
        return true;
    L11:
        return false;
    }

    public final void findKNearestNeighbors(int r210, int r211, int r212, int r213, int r214, int r215, Function6<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r310) {
        int[] r100 = neighborsScoredByDistance$ui_release(r210, r212, r213, r214, r215);
        long[] r101 = this.items;
        int r102 = 1;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 > r211) goto L17;
        int r105 = Integer.MAX_VALUE;
        int r106 = 0;
    L6:
        if (r106 >= r100.length) goto L16;
        int r110 = r100[r106];
        if (r110 <= r102) goto L10;
        r105 = Math.min(r105, r110);
    L10:
        if (r110 != r102) goto L15;
        int r111 = r106 * 3;
        long r112 = r101[r111 + 0];
        long r113 = r101[r111 + 1];
        long r107 = r101[r111 + 2];
        r310.invoke(Integer.valueOf(r110), Integer.valueOf(67108863 & ((int) r107)), Integer.valueOf((int) (r112 >> 32)), Integer.valueOf((int) r112), Integer.valueOf((int) (r113 >> 32)), Integer.valueOf((int) r113));
        r104 = r104 + 1;
        if (r104 != r211) goto L15;
        return;
    L15:
        r106 = r106 + 1;
        r102 = r102;
        goto L6
    L16:
        r103 = r103 + 1;
        r102 = r105;
        goto L3
    }

    public final void insert(int r110, int r111, int r112, int r113, int r210, int r211, boolean r212, boolean r213) {
        int r100 = r110 & RectListKt.Lower26Bits;
        long[] r101 = this.items;
        int r102 = this.itemsSize;
        int r103 = r102 + 3;
        this.itemsSize = r103;
        int r104 = r101.length;
        if (r104 > r103) goto L5;
        resizeStorage(r104, r102, r101);
    L5:
        long[] r105 = this.items;
        r105[r102 + 0] = (((long) r111) << 32) | (((long) r112) & BodyPartID.bodyIdMax);
        r105[r102 + 1] = (((long) r113) << 32) | (((long) r210) & BodyPartID.bodyIdMax);
        long r106 = ((((r213 ? 1 : 0) << 63) | ((r212 ? 1 : 0) << 62)) | (((long) 1) << 61)) | (((long) Math.min(0, 511)) << 52);
        int r114 = r211 & RectListKt.Lower26Bits;
        r105[r102 + 2] = (r106 | (((long) r114) << 26)) | (((long) (r100 & RectListKt.Lower26Bits)) << 0);
        if (r211 >= 0) goto L8;
        return;
    L8:
        int r107 = r102 - 3;
    L9:
        if (r107 < 0) goto L15;
        int r108 = r107 + 2;
        long r109 = r105[r108];
        if ((((int) r109) & RectListKt.Lower26Bits) == r114) goto L12;
        r107 = r107 - 3;
        goto L9
    L12:
        r105[r108] = (RectListKt.EverythingButLastChildOffset & r109) | (((long) Math.min(r102 - r107, 511)) << 52);
        return;
    }

    public static /* synthetic */ void insert$default(RectList r110, int r111, int r112, int r113, int r114, int r115, int r116, boolean r117, boolean r118, int r210, Object r211) {
        if ((r210 & 32) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r210 & 64) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r210 & 128) == 0) goto L13;
        boolean r119 = false;
    L14:
        r110.insert(r111, r112, r113, r114, r115, r100, r101, r119);
        return;
    L13:
        r119 = r118;
        goto L14
    L9:
        r101 = r117;
        goto L11
    L5:
        r100 = r116;
        goto L7
    }
}
