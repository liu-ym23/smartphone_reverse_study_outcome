package com.stepos.core.ota.crypto;

import com.stepos.core.ability.speech.PcmDumpBudget;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToFile$2", f = "ModelCryptoImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$decryptToFile$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $dstPath;
    final /* synthetic */ byte[] $key;
    final /* synthetic */ String $srcPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$decryptToFile$2(ModelCryptoImpl modelCryptoImpl, String str, byte[] bArr, String str2, b<? super ModelCryptoImpl$decryptToFile$2> bVar) {
        super(2, bVar);
        this.this$0 = modelCryptoImpl;
        this.$srcPath = str;
        this.$key = bArr;
        this.$dstPath = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ModelCryptoImpl$decryptToFile$2 modelCryptoImpl$decryptToFile$2 = new ModelCryptoImpl$decryptToFile$2(this.this$0, this.$srcPath, this.$key, this.$dstPath, bVar);
        modelCryptoImpl$decryptToFile$2.L$0 = obj;
        return modelCryptoImpl$decryptToFile$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends String>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<String>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        ModelCryptoImpl modelCryptoImpl = this.this$0;
        String str = this.$srcPath;
        byte[] bArr = this.$key;
        String str2 = this.$dstPath;
        try {
            if (CryptoHeaderParser.INSTANCE.peekMagic(modelCryptoImpl.readHead(str, 4)) != 1398031696) {
                objA = str;
            } else {
                InputStream inputStreamOpenStream = modelCryptoImpl.openStream(str, bArr);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2)), PcmDumpBudget.HARD_MAX_DIR_MB);
                    try {
                        jd.b.n(inputStreamOpenStream, bufferedOutputStream);
                        bufferedOutputStream.close();
                        inputStreamOpenStream.close();
                        objA = str2;
                    } finally {
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<String>> bVar) {
        return ((ModelCryptoImpl$decryptToFile$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
