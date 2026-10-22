package androidx.collection.internal;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001f\b\u0016\u0012\u0014\u0010\n\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Landroidx/collection/internal/LruHashMap;", "K", "", "V", "initialCapacity", "", "loadFactor", "", "<init>", "(IF)V", "original", "(Landroidx/collection/internal/LruHashMap;)V", "map", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isEmpty", "", "()Z", "entries", "", "", "getEntries", "()Ljava/util/Set;", MonitorConstants.CONNECT_TYPE_GET, "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LruHashMap<K, V> {
    private final LinkedHashMap<K, V> map;

    public LruHashMap() {
        int r100 = 0;
        float r101 = 0.0f;
        this(r100, r101, 3, null);
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        return this.map.entrySet();
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public LruHashMap(LruHashMap<? extends K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        int r101 = 0;
        float r102 = 0.0f;
        this(r101, r102, 3, null);
        Iterator<Map.Entry<? extends K, V>> r103 = r100.getEntries().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<? extends K, V> r104 = r103.next();
        put(r104.getKey(), r104.getValue());
        goto L4
    }

    public final V get(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.map.get(r100);
    }

    public final V remove(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.map.remove(r100);
    }

    public LruHashMap(int r100, float r101) {
        this.map = new LinkedHashMap(r100, r101, true);
    }

    public final V put(K r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        return this.map.put(r100, r101);
    }

    public /* synthetic */ LruHashMap(int r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 16;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.75f;
    L8:
        this(r100, r101);
    }
}
