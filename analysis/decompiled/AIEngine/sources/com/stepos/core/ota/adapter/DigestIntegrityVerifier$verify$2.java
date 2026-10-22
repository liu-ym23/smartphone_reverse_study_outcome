package com.stepos.core.ota.adapter;

import com.stepos.core.ota.domain.model.Integrity;
import gc.o;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.DigestIntegrityVerifier$verify$2", f = "InstallAdapters.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DigestIntegrityVerifier$verify$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends n>>, Object> {
    final /* synthetic */ Integrity $expected;
    final /* synthetic */ String $filePath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DigestIntegrityVerifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigestIntegrityVerifier$verify$2(Integrity integrity, DigestIntegrityVerifier digestIntegrityVerifier, String str, b<? super DigestIntegrityVerifier$verify$2> bVar) {
        super(2, bVar);
        this.$expected = integrity;
        this.this$0 = digestIntegrityVerifier;
        this.$filePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        DigestIntegrityVerifier$verify$2 digestIntegrityVerifier$verify$2 = new DigestIntegrityVerifier$verify$2(this.$expected, this.this$0, this.$filePath, bVar);
        digestIntegrityVerifier$verify$2.L$0 = obj;
        return digestIntegrityVerifier$verify$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends n>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<n>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        Integrity integrity = this.$expected;
        DigestIntegrityVerifier digestIntegrityVerifier = this.this$0;
        String str = this.$filePath;
        try {
            if (integrity.getHasAny()) {
                String md5 = integrity.getMd5();
                if (md5 != null) {
                    String strDigest = digestIntegrityVerifier.digest(str, "MD5");
                    if (!o.f0(strDigest, md5)) {
                        throw new IllegalStateException(("MD5 mismatch: expected=" + md5 + " actual=" + strDigest).toString());
                    }
                }
                String sha256 = integrity.getSha256();
                if (sha256 != null && !o.f0(digestIntegrityVerifier.digest(str, "SHA-256"), sha256)) {
                    throw new IllegalStateException("SHA256 mismatch");
                }
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<n>> bVar) {
        return ((DigestIntegrityVerifier$verify$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
