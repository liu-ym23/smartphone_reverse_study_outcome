package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ValueHolder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001a2\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005:\u0002\u0019\u001aB3\u0012\"\u0010\u0006\u001a\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R6\u0010\f\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "size", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "putValue", "value", "builder", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Builder", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentCompositionLocalHashMap extends PersistentHashMap<CompositionLocal<Object>, ValueHolder<Object>> implements PersistentCompositionLocalMap {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final PersistentCompositionLocalHashMap Empty = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "map", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "<init>", "(Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;)V", "getMap$runtime", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "setMap$runtime", "build", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder extends PersistentHashMapBuilder<CompositionLocal<Object>, ValueHolder<Object>> implements PersistentCompositionLocalMap.Builder {
        public static final int $stable = 8;
        private PersistentCompositionLocalHashMap map;

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        public PersistentMap<CompositionLocal<Object>, ValueHolder<Object>> build() {
            if (getNode$runtime() != this.map.getNode$runtime()) goto L5;
            PersistentCompositionLocalHashMap r100 = this.map;
        L6:
            this.map = r100;
            return r100;
        L5:
            setOwnership(new MutabilityOwnership());
            r100 = new PersistentCompositionLocalHashMap(getNode$runtime(), size());
            goto L6
        }

        public final PersistentCompositionLocalHashMap getMap$runtime() {
            return this.map;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        public /* bridge */ /* synthetic */ PersistentMap<CompositionLocal<Object>, ValueHolder<Object>> build() {
            return build();
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ PersistentMap<CompositionLocal<Object>, ValueHolder<Object>> build2() {
            return build();
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        public /* bridge */ /* synthetic */ PersistentMap<CompositionLocal<Object>, ValueHolder<Object>> build() {
            return build();
        }

        public Builder(PersistentCompositionLocalHashMap r100) {
            super(r100);
            this.map = r100;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r100) {
            if ((r100 instanceof CompositionLocal) == true) goto L7;
            return false;
        L7:
            return containsKey((CompositionLocal) r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r100) {
            if ((r100 instanceof ValueHolder) == true) goto L7;
            return false;
        L7:
            return containsValue((ValueHolder) r100);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ ValueHolder<Object> get(Object r100) {
            if ((r100 instanceof CompositionLocal) == true) goto L7;
            return null;
        L7:
            return get((CompositionLocal) r100);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ ValueHolder<Object> remove(Object r100) {
            if ((r100 instanceof CompositionLocal) == true) goto L7;
            return null;
        L7:
            return remove((CompositionLocal) r100);
        }

        public final void setMap$runtime(PersistentCompositionLocalHashMap r100) {
            this.map = r100;
        }

        public /* bridge */ boolean containsKey(CompositionLocal<Object> r100) {
            return super.containsKey(r100);
        }

        public /* bridge */ boolean containsValue(ValueHolder<Object> r100) {
            return super.containsValue(r100);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object r100) {
            if ((r100 instanceof CompositionLocal) == true) goto L7;
            return null;
        L7:
            return get((CompositionLocal) r100);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object r100) {
            if ((r100 instanceof CompositionLocal) == true) goto L7;
            return null;
        L7:
            return remove((CompositionLocal) r100);
        }

        public /* bridge */ ValueHolder<Object> get(CompositionLocal<Object> r100) {
            return (ValueHolder) super.get(r100);
        }

        public /* bridge */ ValueHolder<Object> remove(CompositionLocal<Object> r100) {
            return (ValueHolder) super.remove(r100);
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
            if ((r100 instanceof CompositionLocal) == true) goto L6;
            return r101;
        L6:
            return getOrDefault((CompositionLocal) r100, (ValueHolder) r101);
        }

        public final /* bridge */ ValueHolder<Object> getOrDefault(Object r100, ValueHolder<Object> r101) {
            if ((r100 instanceof CompositionLocal) == true) goto L6;
            return r101;
        L6:
            return getOrDefault((CompositionLocal) r100, r101);
        }

        public /* bridge */ ValueHolder<Object> getOrDefault(CompositionLocal<Object> r100, ValueHolder<Object> r101) {
            return (ValueHolder) super.getOrDefault(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\u00020\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "getEmpty$annotations", "getEmpty", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getEmpty$annotations() {
        }

        public final PersistentCompositionLocalHashMap getEmpty() {
            return PersistentCompositionLocalHashMap.access$getEmpty$cp();
        }
    }

    @Override // androidx.compose.runtime.PersistentCompositionLocalMap, androidx.compose.runtime.CompositionLocalAccessorScope
    public final /* synthetic */ Object getCurrentValue(CompositionLocal r100) {
        return PersistentCompositionLocalMap.CC.$default$getCurrentValue(this, r100);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        TrieNode r100 = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.ValueHolder<kotlin.Any?>>");
        Empty = new PersistentCompositionLocalHashMap(r100, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder() {
        return new Builder(this);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public ImmutableSet<Map.Entry<CompositionLocal<Object>, ValueHolder<Object>>> getEntries() {
        return super.getEntries();
    }

    public static final /* synthetic */ PersistentCompositionLocalHashMap access$getEmpty$cp() {
        return Empty;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public /* bridge */ /* synthetic */ PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder() {
        return builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    /* JADX INFO: renamed from: builder, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder2() {
        return builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public /* bridge */ /* synthetic */ PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder() {
        return builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof CompositionLocal) == true) goto L7;
        return false;
    L7:
        return containsKey((CompositionLocal) r100);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof ValueHolder) == true) goto L7;
        return false;
    L7:
        return containsValue((ValueHolder) r100);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ ValueHolder<Object> get(Object r100) {
        if ((r100 instanceof CompositionLocal) == true) goto L7;
        return null;
    L7:
        return get((CompositionLocal) r100);
    }

    public /* bridge */ boolean containsKey(CompositionLocal<Object> r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(ValueHolder<Object> r100) {
        return super.containsValue(r100);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof CompositionLocal) == true) goto L7;
        return null;
    L7:
        return get((CompositionLocal) r100);
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public /* bridge */ ValueHolder<Object> get(CompositionLocal<Object> r100) {
        return (ValueHolder) super.get(r100);
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public <T> T get(CompositionLocal<T> r100) {
        return (T) CompositionLocalMapKt.read(this, r100);
    }

    public PersistentCompositionLocalHashMap(TrieNode<CompositionLocal<Object>, ValueHolder<Object>> r100, int r101) {
        super(r100, r101);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof CompositionLocal) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((CompositionLocal) r100, (ValueHolder) r101);
    }

    @Override // androidx.compose.runtime.PersistentCompositionLocalMap
    public PersistentCompositionLocalMap putValue(CompositionLocal<Object> r100, ValueHolder<Object> r101) {
        TrieNode.ModificationResult<CompositionLocal<Object>, ValueHolder<Object>> r102 = getNode$runtime().put(r100.hashCode(), r100, r101, 0);
        if (r102 != null) goto L6;
        return this;
    L6:
        return new PersistentCompositionLocalHashMap(r102.getNode(), size() + r102.getSizeDelta());
    }

    public final /* bridge */ ValueHolder<Object> getOrDefault(Object r100, ValueHolder<Object> r101) {
        if ((r100 instanceof CompositionLocal) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((CompositionLocal) r100, r101);
    }

    public /* bridge */ ValueHolder<Object> getOrDefault(CompositionLocal<Object> r100, ValueHolder<Object> r101) {
        return (ValueHolder) super.getOrDefault(r100, r101);
    }
}
