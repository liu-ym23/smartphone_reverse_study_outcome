package io.ktor.util.cio;

import Ua.Y;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.g;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\t\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ljava/io/InputStream;", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lkotlin/coroutines/d;", "context", "Lkotlinx/coroutines/g;", "parent", "Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannel", "(Ljava/io/InputStream;Lio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/d;Lkotlinx/coroutines/g;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputStreamAdaptersKt {
    public static final ByteReadChannel toByteReadChannel(InputStream inputStream, ObjectPool<ByteBuffer> pool, d context, g parent) {
        p.i(inputStream, "<this>");
        p.i(pool, "pool");
        p.i(context, "context");
        p.i(parent, "parent");
        return ReadingKt.toByteReadChannel(inputStream, context.plus(parent), pool);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(InputStream inputStream, ObjectPool objectPool, d dVar, g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i10 & 2) != 0) {
            dVar = Y.d();
        }
        if ((i10 & 4) != 0) {
            gVar = JobKt__JobKt.b(null, 1, null);
        }
        return toByteReadChannel(inputStream, objectPool, dVar, gVar);
    }
}
