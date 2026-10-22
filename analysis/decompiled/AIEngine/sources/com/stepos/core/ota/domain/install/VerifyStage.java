package com.stepos.core.ota.domain.install;

import com.stepos.core.ota.domain.port.IntegrityVerifier;
import com.stepos.core.ota.domain.port.ModelStorage;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.g;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VerifyStage implements InstallStage {
    private final String name;
    private final ModelStorage storage;
    private final IntegrityVerifier verifier;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.install.VerifyStage", f = "InstallPipeline.kt", l = {169}, m = "execute")
    /* renamed from: com.stepos.core.ota.domain.install.VerifyStage$execute$1, reason: invalid class name */
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
            return VerifyStage.this.execute(null, this);
        }
    }

    public VerifyStage(IntegrityVerifier verifier, ModelStorage storage) {
        g.f(verifier, "verifier");
        g.f(storage, "storage");
        this.verifier = verifier;
        this.storage = storage;
        this.name = "Verify";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.install.InstallStage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(com.stepos.core.ota.domain.install.InstallContext r9, qb.b<? super com.stepos.core.ota.domain.install.StageOutcome> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.core.ota.domain.install.VerifyStage.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.core.ota.domain.install.VerifyStage$execute$1 r0 = (com.stepos.core.ota.domain.install.VerifyStage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.domain.install.VerifyStage$execute$1 r0 = new com.stepos.core.ota.domain.install.VerifyStage$execute$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r8 = r0.L$0
            r9 = r8
            com.stepos.core.ota.domain.install.InstallContext r9 = (com.stepos.core.ota.domain.install.InstallContext) r9
            kotlin.c.b(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r8 = r10.f9987a
            goto L92
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.c.b(r10)
            com.stepos.core.ota.domain.model.ModelManifest r10 = r9.getManifest()
            long r4 = r10.getSizeBytes()
            r6 = 0
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 <= 0) goto L79
            com.stepos.core.ota.domain.port.ModelStorage r10 = r8.storage
            java.lang.String r2 = r9.getDownloadedFilePath()
            long r6 = r10.payloadBytes(r2)
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L79
            com.stepos.core.ota.domain.install.StageOutcome$Fail r8 = new com.stepos.core.ota.domain.install.StageOutcome$Fail
            com.stepos.core.ota.domain.OtaError$EmptyPayload r10 = new com.stepos.core.ota.domain.OtaError$EmptyPayload
            com.stepos.core.ota.domain.model.ModelManifest r9 = r9.getManifest()
            java.lang.String r9 = r9.getOtaId()
            java.lang.String r0 = "download size "
            java.lang.String r1 = " != expected "
            java.lang.StringBuilder r0 = ai.onnxruntime.a.q(r6, r0, r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r10.<init>(r9, r0)
            r8.<init>(r10)
            return r8
        L79:
            com.stepos.core.ota.domain.port.IntegrityVerifier r8 = r8.verifier
            java.lang.String r10 = r9.getDownloadedFilePath()
            com.stepos.core.ota.domain.model.ModelManifest r2 = r9.getManifest()
            com.stepos.core.ota.domain.model.Integrity r2 = r2.getIntegrity()
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r8 = r8.mo109verify0E7RQCE(r10, r2, r0)
            if (r8 != r1) goto L92
            return r1
        L92:
            boolean r10 = r8 instanceof kotlin.Result.Failure
            if (r10 != 0) goto L99
            com.stepos.core.ota.domain.install.StageOutcome$Proceed r8 = com.stepos.core.ota.domain.install.StageOutcome.Proceed.INSTANCE
            return r8
        L99:
            com.stepos.core.ota.domain.install.StageOutcome$Fail r10 = new com.stepos.core.ota.domain.install.StageOutcome$Fail
            com.stepos.core.ota.domain.OtaError$IntegrityFailed r0 = new com.stepos.core.ota.domain.OtaError$IntegrityFailed
            com.stepos.core.ota.domain.model.ModelManifest r9 = r9.getManifest()
            java.lang.String r9 = r9.getOtaId()
            java.lang.Throwable r8 = kotlin.Result.b(r8)
            if (r8 == 0) goto Lb1
            java.lang.String r8 = r8.getMessage()
            if (r8 != 0) goto Lb3
        Lb1:
            java.lang.String r8 = "mismatch"
        Lb3:
            r0.<init>(r9, r8)
            r10.<init>(r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.install.VerifyStage.execute(com.stepos.core.ota.domain.install.InstallContext, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }
}
