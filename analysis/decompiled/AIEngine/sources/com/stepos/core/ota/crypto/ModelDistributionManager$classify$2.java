package com.stepos.core.ota.crypto;

import java.io.EOFException;
import java.io.FileInputStream;
import java.util.Arrays;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelDistributionManager$classify$2", f = "ModelDistributionManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelDistributionManager$classify$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends PayloadKind>>, Object> {
    final /* synthetic */ String $srcPath;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelDistributionManager$classify$2(String str, b<? super ModelDistributionManager$classify$2> bVar) {
        super(2, bVar);
        this.$srcPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ModelDistributionManager$classify$2 modelDistributionManager$classify$2 = new ModelDistributionManager$classify$2(this.$srcPath, bVar);
        modelDistributionManager$classify$2.L$0 = obj;
        return modelDistributionManager$classify$2;
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
            byte[] bArr = new byte[4];
            FileInputStream fileInputStream = new FileInputStream(this.$srcPath);
            int i10 = 0;
            while (i10 < 4) {
                try {
                    int i11 = fileInputStream.read(bArr, i10, 4 - i10);
                    if (i11 < 0) {
                        throw new EOFException("payload shorter than 4 bytes");
                    }
                    i10 += i11;
                } finally {
                }
            }
            n nVar = n.f10413a;
            fileInputStream.close();
            int iPeekMagic = CryptoHeaderParser.INSTANCE.peekMagic(bArr);
            if (iPeekMagic == 1347093252) {
                objA = PayloadKind.PLAIN_ZIP;
            } else {
                if (iPeekMagic != 1398031696) {
                    throw new IllegalStateException(("unrecognized payload magic 0x" + String.format("%08x", Arrays.copyOf(new Object[]{new Integer(iPeekMagic)}, 1))).toString());
                }
                objA = PayloadKind.ENCRYPTED;
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends PayloadKind>> bVar) {
        return ((ModelDistributionManager$classify$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
