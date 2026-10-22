package bva;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.ss.android.lark.app.glide.diskcache.LarkGlideDiskCache;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.component.storage.file.dirs.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements LarkGlideDiskCache.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SafeKeyGenerator f20965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SafeKeyGenerator.IKeyGeneratorHandler f20966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20967c;

    @Override // com.ss.android.lark.app.glide.diskcache.LarkGlideDiskCache.c
    public final boolean a() {
        return false;
    }

    @Override // com.ss.android.lark.app.glide.diskcache.LarkGlideDiskCache.c
    public final boolean b(Key r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f20966b.handleDataCacheKey(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f20966b.handleResourceCacheKey(r100) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.app.glide.diskcache.LarkGlideDiskCache.c
    public final DiskCache c(String r100) {
        String r101 = k.f460651a.a(LarkContext.getApplication(), "AvatarDiskCacheHandler");
        return new b(this.f20965a, new gbb.a(VFSFiles.f444819b.i(r101), 1, this.f20967c));
    }

    public a(SafeKeyGenerator r100, SafeKeyGenerator.IKeyGeneratorHandler r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "keyGenerator");
        Intrinsics.checkNotNullParameter(r101, "keyHandler");
        this.f20965a = r100;
        this.f20966b = r101;
        this.f20967c = r102;
    }
}
