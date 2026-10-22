package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000\u001a1\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\bH\u0080\b\u001a'\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\bH\u0080\b¨\u0006\u000b"}, d2 = {"wrapIntoSet", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/ScatterSet;", "fastForEach", "", "", "block", "Lkotlin/Function1;", "fastAny", "", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScatterSetWrapperKt {
    public static final <T> Set<T> wrapIntoSet(ScatterSet<T> r100) {
        return new ScatterSetWrapper(r100);
    }

    public static final boolean fastAny(Set<? extends Object> r110, Function1<Object, Boolean> r111) {
        if ((r110 instanceof ScatterSetWrapper) == false) goto L23;
        ScatterSet r100 = ((ScatterSetWrapper) r110).getSet$runtime();
        Object[] r101 = r100.elements;
        long[] r102 = r100.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L27;
        int r104 = 0;
    L7:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r112 = 0;
    L10:
        if (r112 >= r106) goto L20;
        if ((255 & r105) >= 128) goto L14;
        boolean r113 = true;
    L15:
        if (r113 == false) goto L19;
        if (r111.invoke(r101[(r104 << 3) + r112]).booleanValue() == false) goto L19;
        return true;
    L19:
        r105 = r105 >> 8;
        r112 = r112 + 1;
        goto L10
    L14:
        r113 = false;
        goto L15
    L20:
        if (r106 != 8) goto L27;
    L21:
        if (r104 == r103) goto L27;
        r104 = r104 + 1;
    L27:
        return false;
    L23:
        Set<? extends Object> r107 = r110;
        if ((r107 instanceof Collection) == true) goto L26;
    L28:
        Iterator<T> r108 = r107.iterator();
    L30:
        if (r108.hasNext() == false) goto L27;
        if (r111.invoke(r108.next()).booleanValue() == false) goto L30;
        return true;
    L26:
        if (r107.isEmpty() == false) goto L28;
        goto L27
    }

    public static final <T> void fastForEach(Set<? extends T> r110, Function1<? super T, Unit> r111) {
        if ((r110 instanceof ScatterSetWrapper) == false) goto L21;
        ScatterSet<T> r112 = ((ScatterSetWrapper) r110).getSet$runtime();
        Object[] r100 = r112.elements;
        long[] r113 = r112.metadata;
        int r101 = r113.length - 2;
        if (r101 < 0) goto L25;
        int r102 = 0;
    L7:
        long r103 = r113[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L18;
        if ((255 & r103) >= 128) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L17;
        r111.invoke(r100[(r102 << 3) + r105]);
    L17:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L10
    L14:
        r106 = false;
        goto L15
    L18:
        if (r104 == 8) goto L19;
        return;
    L19:
        if (r102 == r101) goto L33;
        r102 = r102 + 1;
        goto L7
    L33:
        return;
    L25:
        return;
    L21:
        Iterator<T> r114 = r110.iterator();
    L23:
        if (r114.hasNext() == false) goto L34;
        r111.invoke(r114.next());
        goto L23
    }
}
