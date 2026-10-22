package io.ktor.client.plugins.cache.storage;

import Ua.I;
import Ua.Y;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/io/File;", "directory", "LUa/I;", "dispatcher", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "FileStorage", "(Ljava/io/File;LUa/I;)Lio/ktor/client/plugins/cache/storage/CacheStorage;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FileCacheStorageKt {
    public static final CacheStorage FileStorage(File directory, I dispatcher) {
        p.i(directory, "directory");
        p.i(dispatcher, "dispatcher");
        return new CachingCacheStorage(new FileCacheStorage(directory, dispatcher));
    }

    public static /* synthetic */ CacheStorage FileStorage$default(File file, I i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Y.b();
        }
        return FileStorage(file, i10);
    }
}
