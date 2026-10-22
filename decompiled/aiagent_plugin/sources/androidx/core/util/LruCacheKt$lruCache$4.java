package androidx.core.util;

import android.util.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.r;
import d.x;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ d.h.a.b<K, V> $create;
    final /* synthetic */ r<Boolean, K, V, V, x> $onEntryRemoved;
    final /* synthetic */ m<K, V, Integer> $sizeOf;

    public LruCacheKt$lruCache$4(int r3, m<? super K, ? super V, Integer> r4, d.h.a.b<? super K, ? extends V> r5, r<? super Boolean, ? super K, ? super V, ? super V, x> r6) {
        m<K, V, Integer> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        d.h.a.b<K, V> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        r<Boolean, K, V, V, x> r9 = (r) ZeusTransformUtils.wrapperContextForParams(r6, r.class, "com.obric.aiagent.plugin");
        this.$sizeOf = r7;
        this.$create = r8;
        this.$onEntryRemoved = r9;
        super(r3);
    }

    @Override // android.util.LruCache
    public int sizeOf(K r1, V r2) {
        return ((Number) ZeusTransformUtils.preCheckCast(this.$sizeOf.invoke(r1, r2), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // android.util.LruCache
    public V create(K r1) {
        return this.$create.invoke(r1);
    }

    @Override // android.util.LruCache
    public void entryRemoved(boolean r1, K r2, V r3, V r4) {
        this.$onEntryRemoved.a(Boolean.valueOf(r1), r2, r3, r4);
    }
}
