package io.ktor.client.plugins.cache.storage;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2$1$1", f = "FileCacheStorage.kt", l = {151, 153}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FileCacheStorage$writeCacheUnsafe$2$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ List<CachedResponseData> $caches;
    final /* synthetic */ ByteChannel $channel;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$writeCacheUnsafe$2$1$1(ByteChannel byteChannel, List<CachedResponseData> list, FileCacheStorage fileCacheStorage, InterfaceC4014c<? super FileCacheStorage$writeCacheUnsafe$2$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$channel = byteChannel;
        this.$caches = list;
        this.this$0 = fileCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FileCacheStorage$writeCacheUnsafe$2$1$1(this.$channel, this.$caches, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FileCacheStorage$writeCacheUnsafe$2$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r7, r1, r6) == r0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r1 = r6.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r1 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r1
            java.lang.Object r1 = r6.L$0
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.C4849c.b(r7)
            goto L41
        L1a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L22:
            kotlin.C4849c.b(r7)
            goto L3a
        L26:
            kotlin.C4849c.b(r7)
            io.ktor.utils.io.ByteChannel r7 = r6.$channel
            java.util.List<io.ktor.client.plugins.cache.storage.CachedResponseData> r1 = r6.$caches
            int r1 = r1.size()
            r6.label = r3
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r7, r1, r6)
            if (r7 != r0) goto L3a
            goto L61
        L3a:
            java.util.List<io.ktor.client.plugins.cache.storage.CachedResponseData> r7 = r6.$caches
            java.util.Iterator r7 = r7.iterator()
            r1 = r7
        L41:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L62
            java.lang.Object r7 = r1.next()
            io.ktor.client.plugins.cache.storage.CachedResponseData r7 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r7
            io.ktor.client.plugins.cache.storage.FileCacheStorage r3 = r6.this$0
            io.ktor.utils.io.ByteChannel r4 = r6.$channel
            r6.L$0 = r1
            java.lang.Object r5 = g9.h.a(r7)
            r6.L$1 = r5
            r6.label = r2
            java.lang.Object r7 = io.ktor.client.plugins.cache.storage.FileCacheStorage.access$writeCache(r3, r4, r7, r6)
            if (r7 != r0) goto L41
        L61:
            return r0
        L62:
            io.ktor.utils.io.ByteChannel r6 = r6.$channel
            r6.close()
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
