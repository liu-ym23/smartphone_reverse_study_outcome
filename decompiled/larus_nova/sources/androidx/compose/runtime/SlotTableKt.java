package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000~\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b¢\u0006\u0002\u0010\u0007\u001a7\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0000\u001a\u0015\u0010,\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u0015\u0010/\u001a\u00020\u0006*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u0015\u00100\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u0015\u00101\u001a\u00020\u0006*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u0014\u00102\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0002\u001a\u0015\u00103\u001a\u00020\u0006*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u0014\u00104\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0002\u001a\u0015\u00106\u001a\u00020\u0006*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u001c\u00107\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u0015\u00109\u001a\u00020\u0006*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u001c\u0010:\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u0015\u0010;\u001a\u00020\u0006*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u0014\u0010<\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0002\u001a\u0014\u0010=\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0002\u001a\u0011\u0010>\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0082\b\u001a\u0015\u0010?\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0A*\u00020-2\b\b\u0002\u0010B\u001a\u00020\tH\u0002\u001a\u0015\u0010C\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u001c\u0010D\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0002\u001a\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\t0A*\u00020-2\b\b\u0002\u0010B\u001a\u00020\tH\u0002\u001a\u0015\u0010F\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u001d\u0010G\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0082\b\u001a\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\t0A*\u00020-2\b\b\u0002\u0010B\u001a\u00020\tH\u0002\u001a\u0014\u0010I\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0002\u001a\u001c\u0010J\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0002\u001a \u0010K\u001a\b\u0012\u0004\u0012\u00020\t0A*\u00020-2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\t0MH\u0002\u001a\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\t0A*\u00020-2\b\b\u0002\u0010B\u001a\u00020\tH\u0002\u001a\u0015\u0010O\u001a\u00020\t*\u00020-2\u0006\u0010.\u001a\u00020\tH\u0082\b\u001a\u001d\u0010P\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0082\b\u001a\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\t0A*\u00020-2\b\b\u0002\u0010B\u001a\u00020\tH\u0002\u001aD\u0010S\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0002\u001a\r\u0010V\u001a\u00020\t*\u00020\u0006H\u0082\b\u001a\u001c\u0010W\u001a\u000205*\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0002\u001a;\u0010X\u001a\u00020Y*\u0012\u0012\u0004\u0012\u00020Y0\u0002j\b\u0012\u0004\u0012\u00020Y`\u00032\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0]H\u0082\b\u001a.\u0010^\u001a\u0004\u0018\u00010Y*\u0012\u0012\u0004\u0012\u00020Y0\u0002j\b\u0012\u0004\u0012\u00020Y`\u00032\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0002\u001a,\u0010_\u001a\u00020\t*\u0012\u0012\u0004\u0012\u00020Y0\u0002j\b\u0012\u0004\u0012\u00020Y`\u00032\u0006\u0010`\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0002\u001a,\u0010a\u001a\u00020\t*\u0012\u0012\u0004\u0012\u00020Y0\u0002j\b\u0012\u0004\u0012\u00020Y`\u00032\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0002\u001a\"\u0010c\u001a\u000205*\b\u0012\u0004\u0012\u00020e0d2\u0006\u0010?\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0002\u001a\b\u0010f\u001a\u000205H\u0000\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0013\u001a\u00020\t*\u00020\u00148Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u000e\u0010\u0017\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"fastLastOrNull", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "predicate", "Lkotlin/Function1;", "", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastIndexOf", "", "summarize", "", "size", "compositionGroupOf", "Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/runtime/SlotTable;", "group", "EmptyLongArray", "", "firstBitSet", "", "getFirstBitSet", "(J)I", "parentAnchorPivot", "Key_Offset", "GroupInfo_Offset", "ParentAnchor_Offset", "Size_Offset", "DataAnchor_Offset", "Group_Fields_Size", "NodeBit_Mask", "NodeBit_Shift", "ObjectKey_Mask", "ObjectKey_Shift", "Aux_Mask", "Aux_Shift", "Mark_Mask", "Mark_Shift", "ContainsMark_Mask", "ContainsMark_Shift", "Slots_Shift", "NodeCount_Mask", "MinGroupGrowthSize", "MinSlotsGrowthSize", "groupInfo", "", "address", "isNode", "nodeIndex", "hasObjectKey", "objectKeyIndex", "hasAux", "addAux", "", "hasMark", "updateMark", "value", "containsMark", "updateContainsMark", "containsAnyMark", "auxIndex", "slotAnchor", "countOneBits", "key", "keys", "", "len", "nodeCount", "updateNodeCount", "nodeCounts", "parentAnchor", "updateParentAnchor", "parentAnchors", "groupSize", "updateGroupSize", "slice", "indices", "", "groupSizes", "dataAnchor", "updateDataAnchor", "anchor", "dataAnchors", "initGroup", "hasDataKey", "hasData", "toBit", "updateGroupKey", "getOrAdd", "Landroidx/compose/runtime/Anchor;", "index", "effectiveSize", "block", "Lkotlin/Function0;", "find", "search", "location", "locationOf", "LIVE_EDIT_INVALID_KEY", "add", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "throwConcurrentModificationException", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SlotTableKt {
    private static final int Aux_Mask = 268435456;
    private static final int Aux_Shift = 28;
    private static final int ContainsMark_Mask = 67108864;
    private static final int ContainsMark_Shift = 26;
    private static final int DataAnchor_Offset = 4;
    private static final long[] EmptyLongArray = null;
    private static final int GroupInfo_Offset = 1;
    private static final int Group_Fields_Size = 5;
    private static final int Key_Offset = 0;
    private static final int LIVE_EDIT_INVALID_KEY = -3;
    private static final int Mark_Mask = 134217728;
    private static final int Mark_Shift = 27;
    private static final int MinGroupGrowthSize = 32;
    private static final int MinSlotsGrowthSize = 32;
    private static final int NodeBit_Mask = 1073741824;
    private static final int NodeBit_Shift = 30;
    private static final int NodeCount_Mask = 67108863;
    private static final int ObjectKey_Mask = 536870912;
    private static final int ObjectKey_Shift = 29;
    private static final int ParentAnchor_Offset = 2;
    private static final int Size_Offset = 3;
    private static final int Slots_Shift = 28;
    private static final int parentAnchorPivot = -2;

    static {
        EmptyLongArray = new long[0];
    }

    private static final int toBit(boolean r100) {
        return r100 ? 1 : 0;
    }

    public static final void throwConcurrentModificationException() {
        throw new ConcurrentModificationException();
    }

    public static final /* synthetic */ long[] access$getEmptyLongArray$p() {
        return EmptyLongArray;
    }

    private static final int countOneBits(int r100) {
        return Integer.bitCount(r100);
    }

    private static final int getFirstBitSet(long r100) {
        return Long.numberOfTrailingZeros(r100);
    }

    public static final /* synthetic */ void access$addAux(int[] r100, int r101) {
        addAux(r100, r101);
    }

    public static final /* synthetic */ int access$auxIndex(int[] r100, int r101) {
        return auxIndex(r100, r101);
    }

    public static final /* synthetic */ List access$dataAnchors(int[] r100, int r101) {
        return dataAnchors(r100, r101);
    }

    public static final /* synthetic */ int access$groupSize(int[] r100, int r101) {
        return groupSize(r100, r101);
    }

    public static final /* synthetic */ List access$groupSizes(int[] r100, int r101) {
        return groupSizes(r100, r101);
    }

    public static final /* synthetic */ List access$keys(int[] r100, int r101) {
        return keys(r100, r101);
    }

    public static final /* synthetic */ List access$nodeCounts(int[] r100, int r101) {
        return nodeCounts(r100, r101);
    }

    public static final /* synthetic */ int access$objectKeyIndex(int[] r100, int r101) {
        return objectKeyIndex(r100, r101);
    }

    public static final /* synthetic */ List access$parentAnchors(int[] r100, int r101) {
        return parentAnchors(r100, r101);
    }

    public static final /* synthetic */ int access$slotAnchor(int[] r100, int r101) {
        return slotAnchor(r100, r101);
    }

    public static final /* synthetic */ String access$summarize(String r100, int r101) {
        return summarize(r100, r101);
    }

    private static final void addAux(int[] r100, int r101) {
        int r102 = (r101 * 5) + 1;
        r100[r102] = r100[r102] | 268435456;
    }

    private static final int auxIndex(int[] r100, int r101) {
        int r102 = r101 * 5;
        if (r102 >= r100.length) goto L7;
        int r103 = r100[r102 + 4];
        return Integer.bitCount(r100[r102 + 1] >> 29) + r103;
    L7:
        return r100.length;
    }

    public static final CompositionGroup compositionGroupOf(SlotTable r100, int r101) {
        return new SlotTableGroup(r100, r101, r100.getVersion$runtime());
    }

    private static final boolean containsAnyMark(int[] r100, int r101) {
        if ((r100[(r101 * 5) + 1] & 201326592) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean containsMark(int[] r100, int r101) {
        if ((r100[(r101 * 5) + 1] & 67108864) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final int dataAnchor(int[] r100, int r101) {
        return r100[(r101 * 5) + 4];
    }

    private static final List<Integer> dataAnchors(int[] r100, int r101) {
        return slice(r100, RangesKt.step(RangesKt.until(4, r101), 5));
    }

    private static final <T> int fastIndexOf(ArrayList<T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101.invoke((Object) ListProtector.get(r100, r103)).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return -1;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
    private static final <T> T fastLastOrNull(ArrayList<T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size() - 1;
    L3:
        if (r102 < 0) goto L8;
        ?? r103 = (Object) ListProtector.get(r100, r102);
        if (r101.invoke(r103).booleanValue() == true) goto L6;
        r102 = r102 - 1;
        goto L3
    L6:
        return r103;
    L8:
        return null;
    }

    private static final int groupInfo(int[] r100, int r101) {
        return r100[(r101 * 5) + 1];
    }

    private static final int groupSize(int[] r100, int r101) {
        return r100[(r101 * 5) + 3];
    }

    private static final List<Integer> groupSizes(int[] r100, int r101) {
        return slice(r100, RangesKt.step(RangesKt.until(3, r101), 5));
    }

    private static final boolean hasAux(int[] r100, int r101) {
        if ((r100[(r101 * 5) + 1] & 268435456) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean hasMark(int[] r100, int r101) {
        if ((r100[(r101 * 5) + 1] & 134217728) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean hasObjectKey(int[] r100, int r101) {
        if ((r100[(r101 * 5) + 1] & 536870912) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean isNode(int[] r100, int r101) {
        if ((r100[(r101 * 5) + 1] & 1073741824) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final int key(int[] r100, int r101) {
        return r100[r101 * 5];
    }

    private static final List<Integer> keys(int[] r100, int r101) {
        return slice(r100, RangesKt.step(RangesKt.until(0, r101), 5));
    }

    private static final int nodeCount(int[] r100, int r101) {
        return r100[(r101 * 5) + 1] & 67108863;
    }

    private static final List<Integer> nodeCounts(int[] r100, int r101) {
        List<Integer> r102 = slice(r100, RangesKt.step(RangesKt.until(1, r101), 5));
        ArrayList r103 = new ArrayList(r102.size());
        int r104 = r102.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.add(Integer.valueOf(((Number) ListProtector.get(r102, r105)).intValue() & 67108863));
        r105 = r105 + 1;
        goto L3
    L5:
        return r103;
    }

    private static final int nodeIndex(int[] r100, int r101) {
        return r100[(r101 * 5) + 4];
    }

    private static final int objectKeyIndex(int[] r100, int r101) {
        int r102 = r101 * 5;
        return r100[r102 + 4] + Integer.bitCount(r100[r102 + 1] >> 30);
    }

    private static final int parentAnchor(int[] r100, int r101) {
        return r100[(r101 * 5) + 2];
    }

    private static final List<Integer> parentAnchors(int[] r100, int r101) {
        return slice(r100, RangesKt.step(RangesKt.until(2, r101), 5));
    }

    private static final List<Integer> slice(int[] r100, Iterable<Integer> r101) {
        ArrayList r102 = new ArrayList();
        Iterator<Integer> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(Integer.valueOf(r100[r103.next().intValue()]));
        goto L4
    L6:
        return r102;
    }

    private static final int slotAnchor(int[] r100, int r101) {
        int r102 = r101 * 5;
        return r100[r102 + 4] + Integer.bitCount(r100[r102 + 1] >> 28);
    }

    private static final String summarize(String r110, int r111) {
        String r112 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "androidx.", "a.", false, 4, null), "compose.", "c.", false, 4, null), "runtime.", "r.", false, 4, null), "internal.", "ι.", false, 4, null), "ui.", "u.", false, 4, null), "Modifier", "μ", false, 4, null), "material.", "m.", false, 4, null), "Function", "λ", false, 4, null), "OpaqueKey", "κ", false, 4, null), "MutableState", "σ", false, 4, null);
        return r112.substring(0, Math.min(r111, r112.length()));
    }

    public static final /* synthetic */ void access$add(MutableIntObjectMap r100, int r101, int r102) {
        add(r100, r101, r102);
    }

    public static final /* synthetic */ Anchor access$find(ArrayList r100, int r101, int r102) {
        return find(r100, r101, r102);
    }

    public static final /* synthetic */ int access$locationOf(ArrayList r100, int r101, int r102) {
        return locationOf(r100, r101, r102);
    }

    public static final /* synthetic */ int access$search(ArrayList r100, int r101, int r102) {
        return search(r100, r101, r102);
    }

    public static final /* synthetic */ void access$updateContainsMark(int[] r100, int r101, boolean r102) {
        updateContainsMark(r100, r101, r102);
    }

    public static final /* synthetic */ void access$updateGroupKey(int[] r100, int r101, int r102) {
        updateGroupKey(r100, r101, r102);
    }

    public static final /* synthetic */ void access$updateGroupSize(int[] r100, int r101, int r102) {
        updateGroupSize(r100, r101, r102);
    }

    public static final /* synthetic */ void access$updateMark(int[] r100, int r101, boolean r102) {
        updateMark(r100, r101, r102);
    }

    public static final /* synthetic */ void access$updateNodeCount(int[] r100, int r101, int r102) {
        updateNodeCount(r100, r101, r102);
    }

    private static final void add(MutableIntObjectMap<MutableIntSet> r100, int r101, int r102) {
        MutableIntSet r103 = r100.get(r101);
        if (r103 != null) goto L5;
        int r104 = 0;
        r103 = new MutableIntSet(r104, 1, null);
        r100.set(r101, r103);
    L5:
        r103.add(r102);
    }

    private static final Anchor find(ArrayList<Anchor> r100, int r101, int r102) {
        int r103 = search(r100, r101, r102);
        if (r103 >= 0) goto L7;
        return null;
    L7:
        return (Anchor) ListProtector.get(r100, r103);
    }

    private static final int locationOf(ArrayList<Anchor> r100, int r101, int r102) {
        int r103 = search(r100, r101, r102);
        if (r103 < 0) goto L6;
        return r103;
    L6:
        return -(r103 + 1);
    }

    private static final int search(ArrayList<Anchor> r100, int r101, int r102) {
        int r103 = r100.size() - 1;
        int r104 = 0;
    L3:
        if (r104 > r103) goto L14;
        int r105 = (r104 + r103) >>> 1;
        int r106 = ((Anchor) ListProtector.get(r100, r105)).getLocation$runtime();
        if (r106 >= 0) goto L7;
        r106 = r106 + r102;
    L7:
        int r107 = Intrinsics.compare(r106, r101);
        if (r107 < 0) goto L9;
        if (r107 <= 0) goto L12;
        r103 = r105 - 1;
        goto L3
    L12:
        return r105;
    L9:
        r104 = r105 + 1;
        goto L3
    L14:
        return -(r104 + 1);
    }

    private static final void updateContainsMark(int[] r100, int r101, boolean r102) {
        int r103 = (r101 * 5) + 1;
        int r104 = r100[r103] & (-67108865);
        r100[r103] = ((r102 ? 1 : 0) << 26) | r104;
    }

    private static final void updateDataAnchor(int[] r100, int r101, int r102) {
        r100[(r101 * 5) + 4] = r102;
    }

    private static final void updateGroupKey(int[] r100, int r101, int r102) {
        r100[(r101 * 5) + 0] = r102;
    }

    private static final void updateGroupSize(int[] r100, int r101, int r102) {
        r100[(r101 * 5) + 3] = r102;
    }

    private static final void updateMark(int[] r100, int r101, boolean r102) {
        int r103 = (r101 * 5) + 1;
        int r104 = r100[r103] & (-134217729);
        r100[r103] = ((r102 ? 1 : 0) << 27) | r104;
    }

    private static final void updateNodeCount(int[] r100, int r101, int r102) {
        if (r102 >= 0) goto L4;
    L4:
        int r103 = (r101 * 5) + 1;
        r100[r103] = r102 | (r100[r103] & (-67108864));
    }

    private static final void updateParentAnchor(int[] r100, int r101, int r102) {
        r100[(r101 * 5) + 2] = r102;
    }

    public static /* synthetic */ List dataAnchors$default(int[] r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.length;
    L6:
        return dataAnchors(r100, r101);
    }

    private static final Anchor getOrAdd(ArrayList<Anchor> r100, int r101, int r102, Function0<Anchor> r103) {
        int r104 = access$search(r100, r101, r102);
        if (r104 >= 0) goto L6;
        Anchor r105 = r103.invoke();
        ListProtector.add(r100, -(r104 + 1), r105);
        return r105;
    L6:
        return (Anchor) ListProtector.get(r100, r104);
    }

    public static /* synthetic */ List groupSizes$default(int[] r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.length;
    L6:
        return groupSizes(r100, r101);
    }

    public static /* synthetic */ List keys$default(int[] r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.length;
    L6:
        return keys(r100, r101);
    }

    public static /* synthetic */ List nodeCounts$default(int[] r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.length;
    L6:
        return nodeCounts(r100, r101);
    }

    public static /* synthetic */ List parentAnchors$default(int[] r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.length;
    L6:
        return parentAnchors(r100, r101);
    }

    public static final /* synthetic */ void access$initGroup(int[] r100, int r101, int r102, boolean r103, boolean r104, boolean r105, int r106, int r107) {
        initGroup(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    private static final void initGroup(int[] r100, int r101, int r102, boolean r103, boolean r104, boolean r105, int r106, int r107) {
        int r108 = r101 * 5;
        r100[r108 + 0] = r102;
        r100[r108 + 1] = (((r103 ? 1 : 0) << 30) | ((r104 ? 1 : 0) << 29)) | ((r105 ? 1 : 0) << 28);
        r100[r108 + 2] = r106;
        r100[r108 + 3] = 0;
        r100[r108 + 4] = r107;
    }
}
