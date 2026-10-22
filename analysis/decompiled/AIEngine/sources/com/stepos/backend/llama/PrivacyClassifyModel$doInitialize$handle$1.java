package com.stepos.backend.llama;

import b7.k;
import c7.d;
import com.stepos.core.data.base.Content;
import java.io.File;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.backend.llama.PrivacyClassifyModel$doInitialize$handle$1", f = "PrivacyClassifyModel.kt", l = {Content.Types.TYPE_FLOAT_ARRAY}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PrivacyClassifyModel$doInitialize$handle$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Long>, Object> {
    final /* synthetic */ k $config;
    final /* synthetic */ File $ggufFile;
    final /* synthetic */ int $threads;
    int label;
    final /* synthetic */ PrivacyClassifyModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyClassifyModel$doInitialize$handle$1(k kVar, File file, int i10, PrivacyClassifyModel privacyClassifyModel, qb.b<? super PrivacyClassifyModel$doInitialize$handle$1> bVar) {
        super(2, bVar);
        this.$config = kVar;
        this.$ggufFile = file;
        this.$threads = i10;
        this.this$0 = privacyClassifyModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PrivacyClassifyModel$doInitialize$handle$1(this.$config, this.$ggufFile, this.$threads, this.this$0, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            k kVar = this.$config;
            File file = this.$ggufFile;
            this.label = 1;
            obj = com.stepos.base.model.atrest.a.a(kVar, file, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        AutoCloseable autoCloseable = (AutoCloseable) obj;
        int i11 = this.$threads;
        PrivacyClassifyModel privacyClassifyModel = this.this$0;
        try {
            Long l10 = new Long(PrivacyClassifyJni.nativeInit(((d) autoCloseable).f3303a, i11, privacyClassifyModel.nCtx, privacyClassifyModel.nBatch, privacyClassifyModel.flashAttn));
            xb.a.a(autoCloseable, null);
            return l10;
        } finally {
        }
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Long> bVar) {
        return ((PrivacyClassifyModel$doInitialize$handle$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
