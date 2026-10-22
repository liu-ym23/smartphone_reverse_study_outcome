package com.stepos.core.ota.crypto;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl$readHeader$2", f = "ModelCryptoImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$readHeader$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends CryptoHeader>>, Object> {
    final /* synthetic */ String $srcPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$readHeader$2(ModelCryptoImpl modelCryptoImpl, String str, b<? super ModelCryptoImpl$readHeader$2> bVar) {
        super(2, bVar);
        this.this$0 = modelCryptoImpl;
        this.$srcPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ModelCryptoImpl$readHeader$2 modelCryptoImpl$readHeader$2 = new ModelCryptoImpl$readHeader$2(this.this$0, this.$srcPath, bVar);
        modelCryptoImpl$readHeader$2.L$0 = obj;
        return modelCryptoImpl$readHeader$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends CryptoHeader>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<CryptoHeader>>) bVar);
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
            objA = CryptoHeaderParser.INSTANCE.parse(this.this$0.readHead(this.$srcPath, 38));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<CryptoHeader>> bVar) {
        return ((ModelCryptoImpl$readHeader$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
