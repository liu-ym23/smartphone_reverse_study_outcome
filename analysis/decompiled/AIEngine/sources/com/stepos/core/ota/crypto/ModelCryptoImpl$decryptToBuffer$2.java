package com.stepos.core.ota.crypto;

import java.nio.ByteBuffer;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToBuffer$2", f = "ModelCryptoImpl.kt", l = {70}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$decryptToBuffer$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends n>>, Object> {
    final /* synthetic */ byte[] $key;
    final /* synthetic */ ByteBuffer $out;
    final /* synthetic */ String $srcPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$decryptToBuffer$2(ModelCryptoImpl modelCryptoImpl, String str, byte[] bArr, ByteBuffer byteBuffer, b<? super ModelCryptoImpl$decryptToBuffer$2> bVar) {
        super(2, bVar);
        this.this$0 = modelCryptoImpl;
        this.$srcPath = str;
        this.$key = bArr;
        this.$out = byteBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ModelCryptoImpl$decryptToBuffer$2 modelCryptoImpl$decryptToBuffer$2 = new ModelCryptoImpl$decryptToBuffer$2(this.this$0, this.$srcPath, this.$key, this.$out, bVar);
        modelCryptoImpl$decryptToBuffer$2.L$0 = obj;
        return modelCryptoImpl$decryptToBuffer$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends n>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<n>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        try {
            if (i10 == 0) {
                kotlin.c.b(obj);
                ModelCryptoImpl modelCryptoImpl = this.this$0;
                String str = this.$srcPath;
                byte[] bArr = this.$key;
                ByteBuffer byteBuffer = this.$out;
                CryptoHeader cryptoHeader = CryptoHeaderParser.INSTANCE.parse(modelCryptoImpl.readHead(str, 38));
                int iDecryptThreads = modelCryptoImpl.decryptThreads(cryptoHeader.getBlockCount());
                this.label = 1;
                if (modelCryptoImpl.decryptBlocksParallel(str, bArr, cryptoHeader, byteBuffer, iDecryptThreads, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<n>> bVar) {
        return ((ModelCryptoImpl$decryptToBuffer$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
