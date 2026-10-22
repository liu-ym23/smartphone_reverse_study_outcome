package com.stepos.core.ota.crypto;

import dc.e;
import dc.h;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.crypto.spec.SecretKeySpec;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import lb.n;
import mb.m;
import mb.t;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl$decryptBlocksParallel$2$1", f = "ModelCryptoImpl.kt", l = {140}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$decryptBlocksParallel$2$1 extends SuspendLambda implements p<CoroutineScope, b<? super List<? extends n>>, Object> {
    final /* synthetic */ int $blockSize;
    final /* synthetic */ FileChannel $channel;
    final /* synthetic */ long $cipherBlockFull;
    final /* synthetic */ AtomicLong $cipherNs;
    final /* synthetic */ CryptoHeader $header;
    final /* synthetic */ AtomicInteger $nextBlock;
    final /* synthetic */ ByteBuffer $out;
    final /* synthetic */ AtomicLong $readNs;
    final /* synthetic */ SecretKeySpec $secretKey;
    final /* synthetic */ int $threads;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$decryptBlocksParallel$2$1(int i10, int i11, AtomicInteger atomicInteger, CryptoHeader cryptoHeader, long j10, ModelCryptoImpl modelCryptoImpl, FileChannel fileChannel, AtomicLong atomicLong, SecretKeySpec secretKeySpec, ByteBuffer byteBuffer, AtomicLong atomicLong2, b<? super ModelCryptoImpl$decryptBlocksParallel$2$1> bVar) {
        super(2, bVar);
        this.$threads = i10;
        this.$blockSize = i11;
        this.$nextBlock = atomicInteger;
        this.$header = cryptoHeader;
        this.$cipherBlockFull = j10;
        this.this$0 = modelCryptoImpl;
        this.$channel = fileChannel;
        this.$readNs = atomicLong;
        this.$secretKey = secretKeySpec;
        this.$out = byteBuffer;
        this.$cipherNs = atomicLong2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ModelCryptoImpl$decryptBlocksParallel$2$1 modelCryptoImpl$decryptBlocksParallel$2$1 = new ModelCryptoImpl$decryptBlocksParallel$2$1(this.$threads, this.$blockSize, this.$nextBlock, this.$header, this.$cipherBlockFull, this.this$0, this.$channel, this.$readNs, this.$secretKey, this.$out, this.$cipherNs, bVar);
        modelCryptoImpl$decryptBlocksParallel$2$1.L$0 = obj;
        return modelCryptoImpl$decryptBlocksParallel$2$1;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super List<? extends n>> bVar) {
        return invoke2(coroutineScope, (b<? super List<n>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        e eVarE0 = h.e0(0, this.$threads);
        int i11 = this.$blockSize;
        AtomicInteger atomicInteger = this.$nextBlock;
        CryptoHeader cryptoHeader = this.$header;
        long j10 = this.$cipherBlockFull;
        ModelCryptoImpl modelCryptoImpl = this.this$0;
        FileChannel fileChannel = this.$channel;
        AtomicLong atomicLong = this.$readNs;
        SecretKeySpec secretKeySpec = this.$secretKey;
        ByteBuffer byteBuffer = this.$out;
        AtomicLong atomicLong2 = this.$cipherNs;
        ArrayList arrayList = new ArrayList(m.Z(eVarE0, 10));
        Iterator<Integer> it = eVarE0.iterator();
        while (it.hasNext()) {
            ((t) it).nextInt();
            AtomicLong atomicLong3 = atomicLong2;
            arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getDefault(), null, new ModelCryptoImpl$decryptBlocksParallel$2$1$1$1(i11, atomicInteger, cryptoHeader, j10, modelCryptoImpl, fileChannel, atomicLong, secretKeySpec, byteBuffer, atomicLong3, null), 2, null));
            i11 = i11;
            atomicInteger = atomicInteger;
            cryptoHeader = cryptoHeader;
            j10 = j10;
            modelCryptoImpl = modelCryptoImpl;
            fileChannel = fileChannel;
            atomicLong = atomicLong;
            secretKeySpec = secretKeySpec;
            byteBuffer = byteBuffer;
            atomicLong2 = atomicLong3;
        }
        this.label = 1;
        Object objAwaitAll = AwaitKt.awaitAll(arrayList, this);
        return objAwaitAll == coroutineSingletons ? coroutineSingletons : objAwaitAll;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super List<n>> bVar) {
        return ((ModelCryptoImpl$decryptBlocksParallel$2$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
