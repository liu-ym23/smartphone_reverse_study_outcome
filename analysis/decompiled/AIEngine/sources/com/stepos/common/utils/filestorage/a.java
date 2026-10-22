package com.stepos.common.utils.filestorage;

import ad.n;
import android.content.Context;
import android.util.Log;
import androidx.compose.runtime.i;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.common.utils.filestorage.internal.UploadCoordinator;
import com.stepos.core.common.cloud.FileStorageBootstrap$ensureSetup$1$headerProvider$1;
import com.stepos.core.common.cloud.FileStorageBootstrap$ensureSetup$1$tokenProvider$1;
import com.stepos.core.common.cloud.e;
import com.stepos.core.common.cloud.f;
import com.stepos.core.ota.d;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import m8.b;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference<C0046a> f6632a = new AtomicReference<>(null);

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Job> f6633b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.common.utils.filestorage.a$a, reason: collision with other inner class name */
    public static final class C0046a {

        /* renamed from: a, reason: collision with root package name */
        public final b f6634a;

        /* renamed from: b, reason: collision with root package name */
        public final com.stepos.common.utils.filestorage.internal.a f6635b;

        /* renamed from: c, reason: collision with root package name */
        public final UploadCoordinator f6636c;

        public C0046a(b bVar, com.stepos.common.utils.filestorage.internal.a aVar, UploadCoordinator uploadCoordinator) {
            this.f6634a = bVar;
            this.f6635b = aVar;
            this.f6636c = uploadCoordinator;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0046a)) {
                return false;
            }
            C0046a c0046a = (C0046a) obj;
            return g.b(this.f6634a, c0046a.f6634a) && g.b(this.f6635b, c0046a.f6635b) && g.b(this.f6636c, c0046a.f6636c);
        }

        public final int hashCode() {
            return this.f6636c.hashCode() + ((this.f6635b.hashCode() + (this.f6634a.hashCode() * 31)) * 31);
        }

        public final String toString() {
            return "Components(config=" + this.f6634a + ", api=" + this.f6635b + ", coordinator=" + this.f6636c + ")";
        }
    }

    static {
        new AtomicReference(null);
        f6633b = new ConcurrentHashMap<>();
    }

    public static Job a(Context context, List list, String str, i iVar, l lVar, e eVar, f fVar) throws FileStorageException.NotInitialized {
        C0046a c0046a = f6632a.get();
        if (c0046a == null) {
            throw FileStorageException.NotInitialized.f6646a;
        }
        Log.i("FileStorageManager", "enqueueBatchUpload taskId=" + str + " count=" + list.size());
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FileStorageManager$enqueueBatchUpload$job$1(c0046a, context, list, str, iVar, eVar, fVar, lVar, null), 3, null);
        f6633b.put(str, jobLaunch$default);
        return jobLaunch$default;
    }

    public static void b(String str, Integer num, androidx.compose.runtime.g gVar, l lVar) {
        C0046a c0046a = f6632a.get();
        if (c0046a == null) {
            throw FileStorageException.NotInitialized.f6646a;
        }
        Log.i("FileStorageManager", "getDownloadUrl fileId=" + str + " resizePercent=null expiresSeconds=" + num);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FileStorageManager$getDownloadUrl$1(c0046a, str, num, gVar, lVar, null), 3, null);
    }

    public static void c(b bVar, FileStorageBootstrap$ensureSetup$1$tokenProvider$1 fileStorageBootstrap$ensureSetup$1$tokenProvider$1, FileStorageBootstrap$ensureSetup$1$headerProvider$1 fileStorageBootstrap$ensureSetup$1$headerProvider$1) {
        ad.l lVar = com.stepos.common.utils.filestorage.internal.b.f6763f;
        n.a aVar = new n.a();
        long j10 = bVar.f10530l;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVar.b(j10, timeUnit);
        long j11 = bVar.f10531m;
        aVar.c(j11, timeUnit);
        aVar.d(j11, timeUnit);
        aVar.f145f = true;
        n nVar = new n(aVar);
        long j12 = bVar.f10532n;
        n.a aVar2 = new n.a();
        aVar2.b(30L, TimeUnit.SECONDS);
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        aVar2.c(j12, timeUnit2);
        aVar2.d(j12, timeUnit2);
        aVar2.f145f = true;
        aVar2.f144e = new d(20);
        n nVar2 = new n(aVar2);
        com.stepos.common.utils.filestorage.internal.a aVar3 = new com.stepos.common.utils.filestorage.internal.a(new com.stepos.common.utils.filestorage.internal.b(bVar, fileStorageBootstrap$ensureSetup$1$tokenProvider$1, fileStorageBootstrap$ensureSetup$1$headerProvider$1, nVar));
        f6632a.set(new C0046a(bVar, aVar3, new UploadCoordinator(bVar, aVar3, new stepos.support.v7.app.palette.b(nVar2, 10))));
        Log.i("FileStorageManager", "FileStorageManager.setup() done. baseUrl=" + bVar.f10523d + ", service=" + bVar.f10524e);
    }
}
