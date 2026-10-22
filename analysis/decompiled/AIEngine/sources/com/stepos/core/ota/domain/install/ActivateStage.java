package com.stepos.core.ota.domain.install;

import com.stepos.core.ota.domain.port.ModelActivator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.g;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ActivateStage implements InstallStage {
    private final ModelActivator activator;
    private final String name;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.install.ActivateStage", f = "InstallPipeline.kt", l = {387}, m = "execute")
    /* renamed from: com.stepos.core.ota.domain.install.ActivateStage$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActivateStage.this.execute(null, this);
        }
    }

    public ActivateStage(ModelActivator activator) {
        g.f(activator, "activator");
        this.activator = activator;
        this.name = "Activate";
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.core.ota.domain.install.InstallStage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(com.stepos.core.ota.domain.install.InstallContext r8, qb.b<? super com.stepos.core.ota.domain.install.StageOutcome> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.core.ota.domain.install.ActivateStage.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            com.stepos.core.ota.domain.install.ActivateStage$execute$1 r0 = (com.stepos.core.ota.domain.install.ActivateStage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.core.ota.domain.install.ActivateStage$execute$1 r0 = new com.stepos.core.ota.domain.install.ActivateStage$execute$1
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r7 = r6.L$0
            com.stepos.core.ota.domain.model.ModelManifest r7 = (com.stepos.core.ota.domain.model.ModelManifest) r7
            kotlin.c.b(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r8 = r9.f9987a
            goto L68
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.c.b(r9)
            com.stepos.core.ota.domain.model.ModelManifest r9 = r8.getManifest()
            boolean r1 = r9.isPlugin()
            if (r1 == 0) goto L49
            com.stepos.core.ota.domain.install.StageOutcome$Proceed r7 = com.stepos.core.ota.domain.install.StageOutcome.Proceed.INSTANCE
            return r7
        L49:
            com.stepos.core.ota.domain.port.ModelActivator r1 = r7.activator
            r7 = r2
            java.lang.String r2 = r9.getOtaId()
            int r3 = r9.getVersion()
            java.lang.String r4 = r8.getTargetDir()
            java.lang.String r5 = r8.getInstaller()
            r6.L$0 = r9
            r6.label = r7
            java.lang.Object r8 = r1.mo115activateyxL6bBk(r2, r3, r4, r5, r6)
            if (r8 != r0) goto L67
            return r0
        L67:
            r7 = r9
        L68:
            boolean r9 = r8 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L6f
            com.stepos.core.ota.domain.install.StageOutcome$Proceed r7 = com.stepos.core.ota.domain.install.StageOutcome.Proceed.INSTANCE
            return r7
        L6f:
            com.stepos.core.ota.domain.install.StageOutcome$Fail r9 = new com.stepos.core.ota.domain.install.StageOutcome$Fail
            com.stepos.core.ota.domain.OtaError$ActivationFailed r0 = new com.stepos.core.ota.domain.OtaError$ActivationFailed
            java.lang.String r7 = r7.getOtaId()
            java.lang.Throwable r8 = kotlin.Result.b(r8)
            r0.<init>(r7, r8)
            r9.<init>(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.install.ActivateStage.execute(com.stepos.core.ota.domain.install.InstallContext, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }
}
