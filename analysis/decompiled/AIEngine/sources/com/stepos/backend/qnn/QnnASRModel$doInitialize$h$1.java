package com.stepos.backend.qnn;

import com.stepos.core.common.log.AiEngineAtrace;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.backend.qnn.QnnASRModel$doInitialize$h$1", f = "QnnASRModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class QnnASRModel$doInitialize$h$1 extends SuspendLambda implements zb.l<qb.b<? super Long>, Object> {
    final /* synthetic */ boolean $enableProfile;
    final /* synthetic */ String $nativeLibDir;
    final /* synthetic */ String $path;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnASRModel$doInitialize$h$1(String str, String str2, boolean z, qb.b<? super QnnASRModel$doInitialize$h$1> bVar) {
        super(1, bVar);
        this.$path = str;
        this.$nativeLibDir = str2;
        this.$enableProfile = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invokeSuspend$lambda$0(String str, String str2, boolean z) {
        kotlin.jvm.internal.g.c(str2);
        return QnnNative.nativeAsrCreate(str, str2, z);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(qb.b<?> bVar) {
        return new QnnASRModel$doInitialize$h$1(this.$path, this.$nativeLibDir, this.$enableProfile, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        final String str = this.$path;
        final String str2 = this.$nativeLibDir;
        final boolean z = this.$enableProfile;
        return AiEngineAtrace.section("qnn/init", "asr", new zb.a() { // from class: com.stepos.backend.qnn.f
            @Override // zb.a
            public final Object invoke() {
                return Long.valueOf(QnnASRModel$doInitialize$h$1.invokeSuspend$lambda$0(str, str2, z));
            }
        });
    }

    @Override // zb.l
    public final Object invoke(qb.b<? super Long> bVar) {
        return ((QnnASRModel$doInitialize$h$1) create(bVar)).invokeSuspend(lb.n.f10413a);
    }
}
