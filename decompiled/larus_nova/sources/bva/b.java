package bva;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements DiskCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SafeKeyGenerator f20968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gbb.a f20969b;

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void put(Key r100, DiskCache.Writer r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "writer");
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void clear() {
        this.f20969b.delete();
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key r100) {
        this.f20969b.remove(this.f20968a.getSafeKey(r100));
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final File get(Key r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.f20968a.getSafeKey(r100);
        return this.f20969b.c(r101);
    }

    public b(SafeKeyGenerator r100, gbb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "keyGenerator");
        Intrinsics.checkNotNullParameter(r101, "larkDiskCache");
        this.f20968a = r100;
        this.f20969b = r101;
    }
}
