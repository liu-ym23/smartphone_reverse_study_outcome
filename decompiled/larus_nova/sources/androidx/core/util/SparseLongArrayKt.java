package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0086\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0086\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u0002\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u001a\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0086\n\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006!"}, d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseLongArrayKt {
    public static final int getSize(SparseLongArray r100) {
        return r100.size();
    }

    public static final boolean isEmpty(SparseLongArray r100) {
        if (r100.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseLongArray r100) {
        if (r100.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IntIterator keyIterator(final SparseLongArray r100) {
        return new AnonymousClass1(r100);
    }

    public static final LongIterator valueIterator(final SparseLongArray r100) {
        return new C87811(r100);
    }

    public static final boolean contains(SparseLongArray r100, int r101) {
        if (r100.indexOfKey(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(SparseLongArray r100, int r101) {
        if (r100.indexOfKey(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseLongArray r100, long r101) {
        if (r100.indexOfValue(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(SparseLongArray r100, Function2<? super Integer, ? super Long, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(Integer.valueOf(r100.keyAt(r103)), Long.valueOf(r100.valueAt(r103)));
        r103 = r103 + 1;
        goto L3
    }

    public static final SparseLongArray plus(SparseLongArray r100, SparseLongArray r101) {
        SparseLongArray r102 = new SparseLongArray(r100.size() + r101.size());
        putAll(r102, r100);
        putAll(r102, r101);
        return r102;
    }

    public static final void putAll(SparseLongArray r100, SparseLongArray r101) {
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.put(r101.keyAt(r103), r101.valueAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final long getOrDefault(SparseLongArray r100, int r101, long r102) {
        return r100.get(r101, r102);
    }

    public static final long getOrElse(SparseLongArray r100, int r101, Function0<Long> r102) {
        int r103 = r100.indexOfKey(r101);
        if (r103 < 0) goto L6;
        return r100.valueAt(r103);
    L6:
        return r102.invoke().longValue();
    }

    public static final boolean remove(SparseLongArray r100, int r101, long r102) {
        int r103 = r100.indexOfKey(r101);
        if (r103 >= 0) goto L5;
        return false;
    L5:
        if (r102 != r100.valueAt(r103)) goto L10;
        r100.removeAt(r103);
        return true;
    L10:
        return false;
    }

    public static final void set(SparseLongArray r100, int r101, long r102) {
        r100.put(r101, r102);
    }
}
