package com.stepos.core.ota.domain.install;

import com.stepos.core.ota.domain.port.PayloadDecryptor;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.g;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DecryptStage implements InstallStage {
    private final PayloadDecryptor decryptor;
    private final String name;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.install.DecryptStage", f = "InstallPipeline.kt", l = {190, 209}, m = "execute")
    /* renamed from: com.stepos.core.ota.domain.install.DecryptStage$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DecryptStage.this.execute(null, this);
        }
    }

    public DecryptStage(PayloadDecryptor decryptor) {
        g.f(decryptor, "decryptor");
        this.decryptor = decryptor;
        this.name = "Decrypt";
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
    
        if (r11 == r0) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.core.ota.domain.install.InstallStage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(com.stepos.core.ota.domain.install.InstallContext r10, qb.b<? super com.stepos.core.ota.domain.install.StageOutcome> r11) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.install.DecryptStage.execute(com.stepos.core.ota.domain.install.InstallContext, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }
}
