package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b!\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H&J\u0013\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H&¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/AbstractMapBuilderEntries;", ExifInterface.LONGITUDE_EAST, "", "K", "V", "Lkotlin/collections/AbstractMutableSet;", "<init>", "()V", "contains", "", "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "remove", "removeEntry", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractMapBuilderEntries<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    public static final int $stable = 8;

    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> r100);

    public abstract boolean removeEntry(Map.Entry<? extends K, ? extends V> r100);

    public AbstractMapBuilderEntries() {
    }

    public final boolean contains(E r100) {
        if ((r100 instanceof Object) == false) goto L5;
        E r101 = r100;
    L7:
        if ((r101 instanceof Map.Entry) == true) goto L11;
        return false;
    L11:
        return containsEntry(r100);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean remove(E r100) {
        if ((r100 instanceof Object) == false) goto L5;
        E r101 = r100;
    L7:
        if ((r101 instanceof Map.Entry) == true) goto L11;
        return false;
    L11:
        return removeEntry(r100);
    L5:
        r101 = null;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return contains((Map.Entry) r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return remove((Map.Entry) r100);
    }
}
