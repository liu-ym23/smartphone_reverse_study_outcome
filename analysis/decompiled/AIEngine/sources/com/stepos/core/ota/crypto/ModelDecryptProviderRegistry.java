package com.stepos.core.ota.crypto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.g;
import mb.m;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDecryptProviderRegistry {
    private final List<ModelDecryptProvider> providers;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.crypto.ModelDecryptProviderRegistry", f = "ModelDecryptProvider.kt", l = {102}, m = "select")
    /* renamed from: com.stepos.core.ota.crypto.ModelDecryptProviderRegistry$select$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModelDecryptProviderRegistry.this.select(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModelDecryptProviderRegistry(List<? extends ModelDecryptProvider> providers) {
        g.f(providers, "providers");
        this.providers = providers;
        if (providers.isEmpty()) {
            throw new IllegalArgumentException("no decrypt provider registered");
        }
    }

    public final List<String> getRegisteredIds() {
        List<ModelDecryptProvider> list = this.providers;
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelDecryptProvider) it.next()).getId());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006d -> B:23:0x0071). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object select(java.lang.String r7, com.stepos.core.ota.crypto.CryptoAlgorithm r8, qb.b<? super com.stepos.core.ota.crypto.ModelDecryptProvider> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.core.ota.crypto.ModelDecryptProviderRegistry.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.ota.crypto.ModelDecryptProviderRegistry$select$1 r0 = (com.stepos.core.ota.crypto.ModelDecryptProviderRegistry.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.ModelDecryptProviderRegistry$select$1 r0 = new com.stepos.core.ota.crypto.ModelDecryptProviderRegistry$select$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$3
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r0.L$1
            com.stepos.core.ota.crypto.CryptoAlgorithm r8 = (com.stepos.core.ota.crypto.CryptoAlgorithm) r8
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.c.b(r9)
            goto L71
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.c.b(r9)
            java.util.List<com.stepos.core.ota.crypto.ModelDecryptProvider> r6 = r6.providers
            java.util.Iterator r6 = r6.iterator()
            r5 = r7
            r7 = r6
            r6 = r5
        L49:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L83
            java.lang.Object r9 = r7.next()
            r2 = r9
            com.stepos.core.ota.crypto.ModelDecryptProvider r2 = (com.stepos.core.ota.crypto.ModelDecryptProvider) r2
            boolean r4 = r2.supports(r6, r8)
            if (r4 == 0) goto L7f
            r0.L$0 = r6
            r0.L$1 = r8
            r0.L$2 = r7
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r2 = r2.isAvailable(r0)
            if (r2 != r1) goto L6d
            return r1
        L6d:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L71:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L7d
            r9 = r6
            r6 = r2
            r2 = r3
            goto L80
        L7d:
            r9 = r6
            r6 = r2
        L7f:
            r2 = 0
        L80:
            if (r2 == 0) goto L49
            return r9
        L83:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelDecryptProviderRegistry.select(java.lang.String, com.stepos.core.ota.crypto.CryptoAlgorithm, qb.b):java.lang.Object");
    }
}
