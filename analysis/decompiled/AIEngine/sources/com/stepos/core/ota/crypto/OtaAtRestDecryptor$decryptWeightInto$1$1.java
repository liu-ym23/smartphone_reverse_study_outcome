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
@c(c = "com.stepos.core.ota.crypto.OtaAtRestDecryptor$decryptWeightInto$1$1", f = "OtaAtRestDecryptor.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OtaAtRestDecryptor$decryptWeightInto$1$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
    final /* synthetic */ byte[] $dek;
    final /* synthetic */ ByteBuffer $out;
    final /* synthetic */ String $srcPath;
    final /* synthetic */ OtaAtRestDecryptor $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtaAtRestDecryptor$decryptWeightInto$1$1(OtaAtRestDecryptor otaAtRestDecryptor, String str, byte[] bArr, ByteBuffer byteBuffer, b<? super OtaAtRestDecryptor$decryptWeightInto$1$1> bVar) {
        super(2, bVar);
        this.$this_runCatching = otaAtRestDecryptor;
        this.$srcPath = str;
        this.$dek = bArr;
        this.$out = byteBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new OtaAtRestDecryptor$decryptWeightInto$1$1(this.$this_runCatching, this.$srcPath, this.$dek, this.$out, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objMo122decryptToBufferBWLJW6A;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            ModelCryptoImpl modelCryptoImpl = this.$this_runCatching.crypto;
            String str = this.$srcPath;
            byte[] bArr = this.$dek;
            ByteBuffer byteBuffer = this.$out;
            this.label = 1;
            objMo122decryptToBufferBWLJW6A = modelCryptoImpl.mo122decryptToBufferBWLJW6A(str, bArr, byteBuffer, this);
            if (objMo122decryptToBufferBWLJW6A == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            objMo122decryptToBufferBWLJW6A = ((Result) obj).f9987a;
        }
        kotlin.c.b(objMo122decryptToBufferBWLJW6A);
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((OtaAtRestDecryptor$decryptWeightInto$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
