package com.stepos.core.ota.crypto;

import com.stepos.core.common.util.TraceIdKeys;
import h0.e;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl$decryptBlocksParallel$2$1$1$1", f = "ModelCryptoImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$decryptBlocksParallel$2$1$1$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
    final /* synthetic */ int $blockSize;
    final /* synthetic */ FileChannel $channel;
    final /* synthetic */ long $cipherBlockFull;
    final /* synthetic */ AtomicLong $cipherNs;
    final /* synthetic */ CryptoHeader $header;
    final /* synthetic */ AtomicInteger $nextBlock;
    final /* synthetic */ ByteBuffer $out;
    final /* synthetic */ AtomicLong $readNs;
    final /* synthetic */ SecretKeySpec $secretKey;
    int label;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$decryptBlocksParallel$2$1$1$1(int i10, AtomicInteger atomicInteger, CryptoHeader cryptoHeader, long j10, ModelCryptoImpl modelCryptoImpl, FileChannel fileChannel, AtomicLong atomicLong, SecretKeySpec secretKeySpec, ByteBuffer byteBuffer, AtomicLong atomicLong2, b<? super ModelCryptoImpl$decryptBlocksParallel$2$1$1$1> bVar) {
        super(2, bVar);
        this.$blockSize = i10;
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
        return new ModelCryptoImpl$decryptBlocksParallel$2$1$1$1(this.$blockSize, this.$nextBlock, this.$header, this.$cipherBlockFull, this.this$0, this.$channel, this.$readNs, this.$secretKey, this.$out, this.$cipherNs, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        int andIncrement;
        int iPlainBytesOf;
        int iDoFinal;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.$blockSize + 16);
        do {
            andIncrement = this.$nextBlock.getAndIncrement();
            if (andIncrement >= this.$header.getBlockCount()) {
                return n.f10413a;
            }
            iPlainBytesOf = this.$header.plainBytesOf(andIncrement);
            long j10 = andIncrement;
            long j11 = (this.$cipherBlockFull * j10) + 38;
            long jNanoTime = System.nanoTime();
            byteBufferAllocateDirect.clear();
            byteBufferAllocateDirect.limit(iPlainBytesOf + 16);
            ModelCryptoImpl modelCryptoImpl = this.this$0;
            FileChannel fileChannel = this.$channel;
            g.c(fileChannel);
            modelCryptoImpl.readFullyAt(fileChannel, j11, byteBufferAllocateDirect);
            byteBufferAllocateDirect.flip();
            long jNanoTime2 = System.nanoTime();
            this.$readNs.addAndGet(jNanoTime2 - jNanoTime);
            SecretKeySpec secretKeySpec = this.$secretKey;
            GcmBlocks gcmBlocks = GcmBlocks.INSTANCE;
            cipher.init(2, secretKeySpec, new GCMParameterSpec(TraceIdKeys.MAX_LENGTH, gcmBlocks.nonce(this.$header.getIv(), andIncrement)));
            cipher.updateAAD(gcmBlocks.aad(this.$header.getFormatVersion(), andIncrement));
            int i10 = (int) (j10 * this.$blockSize);
            ByteBuffer byteBufferDuplicate = this.$out.duplicate();
            byteBufferDuplicate.position(i10);
            byteBufferDuplicate.limit(i10 + iPlainBytesOf);
            iDoFinal = cipher.doFinal(byteBufferAllocateDirect, byteBufferDuplicate);
            this.$cipherNs.addAndGet(System.nanoTime() - jNanoTime2);
        } while (iDoFinal == iPlainBytesOf);
        StringBuilder sbD = e.d(andIncrement, "block ", iDoFinal, " decrypted ", " bytes, expected ");
        sbD.append(iPlainBytesOf);
        throw new EOFException(sbD.toString());
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((ModelCryptoImpl$decryptBlocksParallel$2$1$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
