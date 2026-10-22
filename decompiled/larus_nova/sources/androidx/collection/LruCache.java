package androidx.collection;

import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import androidx.collection.internal.RuntimeHelpersKt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0011\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0015\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0015\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J/\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00012\b\u0010 \u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0015\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0016J\u001d\u0010#\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010$J\u001d\u0010%\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010$J\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010(J\b\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/collection/LruCache;", "K", "", "V", "maxSize", "", "<init>", "(I)V", "map", "Landroidx/collection/internal/LruHashMap;", "lock", "Landroidx/collection/internal/Lock;", "size", "putCount", "createCount", "evictionCount", "hitCount", "missCount", "resize", "", MonitorConstants.CONNECT_TYPE_GET, "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "trimToSize", "remove", "entryRemoved", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "create", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "evictAll", "snapshot", "", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public V create(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return null;
    }

    public void entryRemoved(boolean r100, K r101, V r102, V r103) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public int sizeOf(K r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        return 1;
    }

    public final int createCount() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.createCount;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int evictionCount() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.evictionCount;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int hitCount() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.hitCount;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int maxSize() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.maxSize;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int missCount() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.missCount;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int putCount() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.putCount;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int size() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.size;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<K, V> snapshot() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        LinkedHashMap r101 = new LinkedHashMap(this.map.getEntries().size());     // Catch: Throwable -> L11
        Iterator<T> r102 = this.map.getEntries().iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L11
        r101.put(r103.getKey(), r103.getValue());     // Catch: Throwable -> L11
        goto L6
    L9:
        monitor-exit(r100);
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    public String toString() {
        Lock r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.hitCount;     // Catch: Throwable -> L11
        int r102 = this.missCount + r101;     // Catch: Throwable -> L11
        if (r102 == 0) goto L7;
        int r103 = (r101 * 100) / r102;     // Catch: Throwable -> L11
    L8:
        String r104 = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + r103 + "%]";     // Catch: Throwable -> L11
        monitor-exit(r100);
        return r104;
    L7:
        r103 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public LruCache(int r100) {
        this.maxSize = r100;
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        RuntimeHelpersKt.throwIllegalArgumentException("maxSize <= 0");
    L8:
        this.map = new LruHashMap(0, 0.75f);
        this.lock = new Lock();
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final V get(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Lock r101 = this.lock;
        monitor-enter(r101);
        V r102 = this.map.get(r100);     // Catch: Throwable -> L29
        if (r102 == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L29
        monitor-exit(r101);
        return r102;
    L9:
        this.missCount++;     // Catch: Throwable -> L29
        monitor-exit(r101);
        V r103 = create(r100);
        if (r103 != null) goto L15;
        return null;
    L15:
        Lock r104 = this.lock;
        monitor-enter(r104);
        this.createCount++;     // Catch: Throwable -> L26
        V r105 = (V) this.map.put(r100, r103);
        if (r105 == null) goto L20;
        this.map.put(r100, r105);     // Catch: Throwable -> L26
    L21:
        monitor-exit(r104);
        if (r105 == null) goto L24;
        entryRemoved(false, r100, r103, r105);
        return r105;
    L24:
        trimToSize(this.maxSize);
        return r103;
    L20:
        this.size += safeSizeOf(r100, r103);     // Catch: Throwable -> L26
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    public final V remove(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Lock r101 = this.lock;
        monitor-enter(r101);
        V r102 = this.map.remove(r100);     // Catch: Throwable -> L12
        if (r102 == null) goto L7;
        this.size -= safeSizeOf(r100, r102);     // Catch: Throwable -> L12
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        if (r102 == null) goto L11;
        entryRemoved(false, r100, r102, null);
    L11:
        return r102;
    L12:
        th = move-exception;
        throw th;
    }

    public void resize(int r100) {
        if (r100 <= 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L7;
        RuntimeHelpersKt.throwIllegalArgumentException("maxSize <= 0");
    L7:
        Lock r102 = this.lock;
        monitor-enter(r102);
        this.maxSize = r100;     // Catch: Throwable -> L13
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        trimToSize(r100);
        return;
    L13:
        th = move-exception;
        throw th;
    L4:
        r101 = false;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void trimToSize(int r100) {
    L2:
        Lock r101 = this.lock;
        monitor-enter(r101);
        if (this.size >= 0) goto L7;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L15;
        RuntimeHelpersKt.throwIllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L28
    L15:
        if (this.size <= r100) goto L26;
        if (this.map.isEmpty() == true) goto L26;
        Map.Entry r103 = (Map.Entry) CollectionsKt.firstOrNull(this.map.getEntries());     // Catch: Throwable -> L28
        if (r103 == null) goto L21;
        Object r104 = r103.getKey();     // Catch: Throwable -> L28
        Object r105 = r103.getValue();     // Catch: Throwable -> L28
        this.map.remove((K) r104);     // Catch: Throwable -> L28
        this.size -= safeSizeOf(r104, r105);     // Catch: Throwable -> L28
        this.evictionCount++;     // Catch: Throwable -> L28
        monitor-exit(r101);
        entryRemoved(true, r104, r105, null);
        goto L2
    L21:
        monitor-exit(r101);
        return;
    L26:
        monitor-exit(r101);
        return;
    L7:
        if (this.map.isEmpty() == true) goto L9;
    L10:
        r102 = true;
        goto L12
    L9:
        if (this.size != 0) goto L11;
    L28:
        th = move-exception;
        throw th;
    }

    private final int safeSizeOf(K r100, V r101) {
        int r102 = sizeOf(r100, r101);
        if (r102 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        RuntimeHelpersKt.throwIllegalStateException("Negative size: " + r100 + com.alipay.sdk.m.n.a.f25612h + r101);
    L8:
        return r102;
    L5:
        r103 = false;
        goto L6
    }

    public final V put(K r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Lock r102 = this.lock;
        monitor-enter(r102);
        this.putCount++;     // Catch: Throwable -> L13
        this.size += safeSizeOf(r100, r101);     // Catch: Throwable -> L13
        V r103 = this.map.put(r100, r101);     // Catch: Throwable -> L13
        if (r103 == null) goto L7;
        this.size -= safeSizeOf(r100, r103);     // Catch: Throwable -> L13
    L7:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        if (r103 == null) goto L11;
        entryRemoved(false, r100, r103, r101);
    L11:
        trimToSize(this.maxSize);
        return r103;
    L13:
        th = move-exception;
        throw th;
    }
}
