package com.stepos.core.ota.crypto;

import java.io.InputStream;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl$openDecryptedStream$2", f = "ModelCryptoImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$openDecryptedStream$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends InputStream>>, Object> {
    final /* synthetic */ byte[] $key;
    final /* synthetic */ String $srcPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$openDecryptedStream$2(ModelCryptoImpl modelCryptoImpl, String str, byte[] bArr, b<? super ModelCryptoImpl$openDecryptedStream$2> bVar) {
        super(2, bVar);
        this.this$0 = modelCryptoImpl;
        this.$srcPath = str;
        this.$key = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ModelCryptoImpl$openDecryptedStream$2 modelCryptoImpl$openDecryptedStream$2 = new ModelCryptoImpl$openDecryptedStream$2(this.this$0, this.$srcPath, this.$key, bVar);
        modelCryptoImpl$openDecryptedStream$2.L$0 = obj;
        return modelCryptoImpl$openDecryptedStream$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        try {
            objA = this.this$0.openStream(this.$srcPath, this.$key);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends InputStream>> bVar) {
        return ((ModelCryptoImpl$openDecryptedStream$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
