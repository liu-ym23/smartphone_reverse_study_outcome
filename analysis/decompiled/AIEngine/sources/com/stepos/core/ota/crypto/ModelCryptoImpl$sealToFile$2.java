package com.stepos.core.ota.crypto;

import com.stepos.core.ability.speech.PcmDumpBudget;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl$sealToFile$2", f = "ModelCryptoImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$sealToFile$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends String>>, Object> {
    final /* synthetic */ int $blockSize;
    final /* synthetic */ String $dstPath;
    final /* synthetic */ byte[] $key;
    final /* synthetic */ String $srcPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$sealToFile$2(int i10, String str, byte[] bArr, String str2, ModelCryptoImpl modelCryptoImpl, b<? super ModelCryptoImpl$sealToFile$2> bVar) {
        super(2, bVar);
        this.$blockSize = i10;
        this.$srcPath = str;
        this.$key = bArr;
        this.$dstPath = str2;
        this.this$0 = modelCryptoImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ModelCryptoImpl$sealToFile$2 modelCryptoImpl$sealToFile$2 = new ModelCryptoImpl$sealToFile$2(this.$blockSize, this.$srcPath, this.$key, this.$dstPath, this.this$0, bVar);
        modelCryptoImpl$sealToFile$2.L$0 = obj;
        return modelCryptoImpl$sealToFile$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends String>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<String>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        byte[] bArr;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        int i10 = this.$blockSize;
        String str = this.$srcPath;
        byte[] bArr2 = this.$key;
        String str2 = this.$dstPath;
        ModelCryptoImpl modelCryptoImpl = this.this$0;
        try {
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (1 > i10 || i10 >= 1048577) {
            throw new IllegalArgumentException(("blockSize out of range: " + i10).toString());
        }
        File file = new File(str);
        long length = file.length();
        if (length <= 0) {
            throw new IllegalArgumentException(("cannot seal empty file: " + str).toString());
        }
        byte[] bArr3 = new byte[12];
        new SecureRandom().nextBytes(bArr3);
        long j10 = i10;
        CryptoHeader cryptoHeader = new CryptoHeader(CryptoAlgorithm.AES_256_GCM, 1, bArr3, i10, length, (((int) (((length + j10) - 1) / j10)) * 16) + length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2)), PcmDumpBudget.HARD_MAX_DIR_MB);
        try {
            bufferedOutputStream.write(CryptoHeaderParser.INSTANCE.build(cryptoHeader));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), PcmDumpBudget.HARD_MAX_DIR_MB);
            try {
                byte[] bArr4 = new byte[i10];
                int i11 = 0;
                while (true) {
                    int block = modelCryptoImpl.readBlock(bufferedInputStream, bArr4);
                    if (block == 0) {
                        break;
                    }
                    if (block == i10) {
                        bArr = bArr4;
                    } else {
                        byte[] bArrCopyOf = Arrays.copyOf(bArr4, block);
                        g.e(bArrCopyOf, "copyOf(...)");
                        bArr = bArrCopyOf;
                    }
                    SecretKeySpec secretKeySpec2 = secretKeySpec;
                    bufferedOutputStream.write(GcmBlocks.INSTANCE.encrypt(secretKeySpec2, bArr3, cryptoHeader.getFormatVersion(), i11, bArr));
                    i11++;
                    secretKeySpec = secretKeySpec2;
                }
                n nVar = n.f10413a;
                bufferedInputStream.close();
                bufferedOutputStream.close();
                objA = str2;
                return new Result(objA);
            } finally {
            }
        } finally {
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<String>> bVar) {
        return ((ModelCryptoImpl$sealToFile$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
