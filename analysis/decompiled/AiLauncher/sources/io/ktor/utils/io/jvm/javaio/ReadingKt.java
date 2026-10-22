package io.ktor.utils.io.jvm.javaio;

import Ua.Y;
import fb.C4080g;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0007¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Ljava/io/InputStream;", "Lkotlin/coroutines/d;", "context", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannel", "(Ljava/io/InputStream;Lkotlin/coroutines/d;Lio/ktor/utils/io/pool/ObjectPool;)Lio/ktor/utils/io/ByteReadChannel;", "", "toByteReadChannelWithArrayPool", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReadingKt {
    public static final ByteReadChannel toByteReadChannel(InputStream inputStream, d context, ObjectPool<ByteBuffer> pool) {
        p.i(inputStream, "<this>");
        p.i(context, "context");
        p.i(pool, "pool");
        return new RawSourceChannel(C4080g.b(inputStream), context);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(InputStream inputStream, d dVar, ObjectPool objectPool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = Y.b();
        }
        return toByteReadChannel(inputStream, dVar, objectPool);
    }

    public static final ByteReadChannel toByteReadChannelWithArrayPool(InputStream inputStream, d context, ObjectPool<byte[]> pool) {
        p.i(inputStream, "<this>");
        p.i(context, "context");
        p.i(pool, "pool");
        return new RawSourceChannel(C4080g.b(inputStream), context);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannelWithArrayPool$default(InputStream inputStream, d dVar, ObjectPool objectPool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = Y.b();
        }
        if ((i10 & 2) != 0) {
            objectPool = ByteArrayPoolKt.getByteArrayPool();
        }
        return toByteReadChannelWithArrayPool(inputStream, dVar, objectPool);
    }
}
