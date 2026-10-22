package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntList;
import androidx.compose.ui.unit.IntOffset;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001ax\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\t*\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u000e0\u001bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Debug", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "mainAxisOffset", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "applyStickyItems", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "firstVisibleItemIndex", "lastVisibleItemIndex", "positionedItems", "", "stickyItems", "Landroidx/collection/IntList;", "beforeContentPadding", "afterContentPadding", "layoutWidth", "layoutHeight", "getAndMeasure", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutStickyItemsKt {
    private static final boolean Debug = false;

    private static final void debugLog(Function0<String> r100) {
    }

    public static final /* synthetic */ int access$getMainAxisOffset(LazyLayoutMeasuredItem r100) {
        return getMainAxisOffset(r100);
    }

    private static final int getMainAxisOffset(LazyLayoutMeasuredItem r100) {
        long r101 = r100.mo841getOffsetBjo55l4(0);
        if (r100.isVertical() == false) goto L6;
        return IntOffset.m7677getYimpl(r101);
    L6:
        return IntOffset.m7676getXimpl(r101);
    }

    public static final <T extends LazyLayoutMeasuredItem> List<T> applyStickyItems(StickyItemsPlacement r110, int r111, int r210, List<T> r211, IntList r212, int r213, int r214, int r215, int r216, Function1<? super Integer, ? extends T> r217) {
        if (r110 == null) goto L39;
        if ((!r211.isEmpty()) == false) goto L39;
        if (r212._size == 0) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == false) goto L39;
        IntList r101 = r110.getStickingIndices(r111, r210, r212);
        ArrayList r112 = new ArrayList();
        ArrayList r113 = new ArrayList(r211.size());
        int r102 = r211.size();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L17;
        Object r104 = ListProtector.get(r211, r103);
        if (r212.contains(((LazyLayoutMeasuredItem) r104).getIndex()) == false) goto L16;
        r113.add(r104);
    L16:
        r103 = r103 + 1;
        goto L12
    L17:
        int[] r114 = r101.content;
        int r105 = r101._size;
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L48;
        int r107 = r114[r106];
        Iterator<T> r108 = r211.iterator();
        int r109 = 0;
    L21:
        if (r108.hasNext() == false) goto L29;
        if (r108.next().getIndex() != r107) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == true) goto L30;
        r109 = r109 + 1;
    L30:
        if (r109 != (-1)) goto L32;
        T r116 = r217.invoke(Integer.valueOf(r107));
    L33:
        T r117 = r116;
        int r118 = r117.getMainAxisSizeWithSpacings();
        if (r109 != (-1)) goto L36;
        int r119 = Integer.MIN_VALUE;
    L37:
        int r120 = r110.calculateStickingItemOffset(r113, r107, r118, r119, r213, r214, r215, r216);
        r117.setNonScrollableItem(true);
        r117.position(r120, 0, r215, r216);
        r112.add(r117);
        r106 = r106 + 1;
        r105 = r105;
        goto L18
    L36:
        r119 = getMainAxisOffset(r117);
        goto L37
    L32:
        r116 = (T) ListProtector.remove(r211, r109);
        goto L33
    L25:
        r115 = false;
        goto L26
    L29:
        r109 = -1;
        goto L30
    L48:
        return r112;
    L9:
        r100 = false;
    L39:
        return CollectionsKt.emptyList();
    }
}
