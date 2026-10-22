package com.stepos.core.ota.domain.install;

import com.stepos.core.ota.crypto.AtRestSealer;
import com.stepos.core.ota.domain.port.OtaLogger;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import qb.b;
import rb.c;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SealAtRestStage implements InstallStage {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "SealAtRest";
    private final a<Boolean> gate;
    private final OtaLogger log;
    private final String name;
    private final AtRestSealer sealer;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.install.SealAtRestStage", f = "SealAtRestStage.kt", l = {26}, m = "execute")
    /* renamed from: com.stepos.core.ota.domain.install.SealAtRestStage$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SealAtRestStage.this.execute(null, this);
        }
    }

    public SealAtRestStage(AtRestSealer sealer, a<Boolean> gate, OtaLogger log) {
        g.f(sealer, "sealer");
        g.f(gate, "gate");
        g.f(log, "log");
        this.sealer = sealer;
        this.gate = gate;
        this.log = log;
        this.name = TAG;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.install.InstallStage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(com.stepos.core.ota.domain.install.InstallContext r7, qb.b<? super com.stepos.core.ota.domain.install.StageOutcome> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.core.ota.domain.install.SealAtRestStage.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ota.domain.install.SealAtRestStage$execute$1 r0 = (com.stepos.core.ota.domain.install.SealAtRestStage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.domain.install.SealAtRestStage$execute$1 r0 = new com.stepos.core.ota.domain.install.SealAtRestStage$execute$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$0
            com.stepos.core.ota.domain.install.SealAtRestStage r7 = (com.stepos.core.ota.domain.install.SealAtRestStage) r7
            kotlin.c.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.f9987a
            goto L73
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.c.b(r8)
            zb.a<java.lang.Boolean> r8 = r6.gate
            java.lang.Object r8 = r8.invoke()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L4f
            com.stepos.core.ota.domain.install.StageOutcome$Proceed r6 = com.stepos.core.ota.domain.install.StageOutcome.Proceed.INSTANCE
            return r6
        L4f:
            com.stepos.core.ota.domain.model.ModelManifest r8 = r7.getManifest()
            java.lang.String r8 = r8.getOtaId()
            com.stepos.core.ota.crypto.AtRestSealer r2 = r6.sealer
            java.io.File r4 = new java.io.File
            java.lang.String r7 = r7.getTempDir()
            r4.<init>(r7)
            r0.L$0 = r6
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = r2.m118sealDirgIAlus(r4, r0)
            if (r7 != r1) goto L6f
            return r1
        L6f:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L73:
            java.lang.Throwable r0 = kotlin.Result.b(r8)
            if (r0 != 0) goto L93
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            com.stepos.core.ota.domain.port.OtaLogger r7 = r7.log
            java.lang.String r0 = "] sealed "
            java.lang.String r1 = " weight file(s) at rest"
            java.lang.String r2 = "["
            java.lang.String r6 = ai.onnxruntime.a.i(r2, r8, r6, r0, r1)
            java.lang.String r8 = "SealAtRest"
            r7.i(r8, r6)
            com.stepos.core.ota.domain.install.StageOutcome$Proceed r6 = com.stepos.core.ota.domain.install.StageOutcome.Proceed.INSTANCE
            return r6
        L93:
            com.stepos.core.ota.domain.install.StageOutcome$Fail r8 = new com.stepos.core.ota.domain.install.StageOutcome$Fail
            com.stepos.core.ota.domain.OtaError$InstallFailed r1 = new com.stepos.core.ota.domain.OtaError$InstallFailed
            java.lang.String r7 = r7.getName()
            r1.<init>(r6, r7, r0)
            r8.<init>(r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.install.SealAtRestStage.execute(com.stepos.core.ota.domain.install.InstallContext, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }
}
