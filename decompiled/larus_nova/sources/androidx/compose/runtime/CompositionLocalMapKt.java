package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00012.\u0010\u0002\u001a*\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00070\u0004\u0012\u0004\u0012\u00020\b0\u0003H\u0080\b\u001a \u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005H\u0000\u001a%\u0010\r\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005H\u0000¢\u0006\u0002\u0010\u000e\u001a3\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"mutate", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "mutator", "Lkotlin/Function1;", "", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "", "contains", "", ExifInterface.GPS_DIRECTION_TRUE, "key", "read", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "updateCompositionMap", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "previous", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/PersistentCompositionLocalMap;)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CompositionLocalMapKt {
    public static final <T> boolean contains(PersistentCompositionLocalMap r100, CompositionLocal<T> r101) {
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        return r100.containsKey(r101);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    public static final PersistentCompositionLocalMap mutate(PersistentCompositionLocalMap r100, Function1<? super Map<CompositionLocal<Object>, ValueHolder<Object>>, Unit> r101) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> r102 = r100.builder();
        r101.invoke(r102);
        return r102.build();
    }

    public static final <T> T read(PersistentCompositionLocalMap r100, CompositionLocal<T> r101) {
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        ValueHolder r102 = r100.get(r101);
        if (r102 != null) goto L6;
        r102 = r101.getDefaultValueHolder$runtime();
    L6:
        return (T) r102.readValue(r100);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    public static final PersistentCompositionLocalMap updateCompositionMap(ProvidedValue<?>[] r100, PersistentCompositionLocalMap r101, PersistentCompositionLocalMap r102) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> r103 = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf().builder();
        int r104 = r100.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        ProvidedValue<?> r106 = r100[r105];
        CompositionLocal<?> r107 = r106.getCompositionLocal();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
        ProvidableCompositionLocal r108 = (ProvidableCompositionLocal) r107;
        if (r106.getCanOverride() == false) goto L7;
    L8:
        ValueHolder<Object> r109 = (ValueHolder) r102.get(r108);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        r103.put(r108, r108.updatedStateOf$runtime(r106, r109));
    L9:
        r105 = r105 + 1;
        goto L3
    L7:
        if (contains(r101, r108) == true) goto L9;
    L11:
        return r103.build();
    }

    public static /* synthetic */ PersistentCompositionLocalMap updateCompositionMap$default(ProvidedValue[] r100, PersistentCompositionLocalMap r101, PersistentCompositionLocalMap r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    L6:
        return updateCompositionMap(r100, r101, r102);
    }
}
