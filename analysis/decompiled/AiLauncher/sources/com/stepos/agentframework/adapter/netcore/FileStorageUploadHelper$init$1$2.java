package com.stepos.agentframework.adapter.netcore;

import kotlin.Metadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileStorageUploadHelper$init$1$2 implements com.stepos.common.utils.filestorage.a {
    final /* synthetic */ FileStorageConfig $config;

    public FileStorageUploadHelper$init$1$2(FileStorageConfig fileStorageConfig) {
        this.$config = fileStorageConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.common.utils.filestorage.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(e9.InterfaceC4014c<? super java.util.Map<java.lang.String, java.lang.String>> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$init$1$2$getHeaders$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$init$1$2$getHeaders$1 r0 = (com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$init$1$2$getHeaders$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$init$1$2$getHeaders$1 r0 = new com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$init$1$2$getHeaders$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            com.stepos.agentframework.adapter.netcore.k r4 = r4.$config
            com.stepos.agentframework.adapter.netcore.l r4 = r4.getHeaderProvider()
            if (r4 == 0) goto L48
            r0.label = r3
            java.lang.Object r5 = r4.a(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.util.Map r5 = (java.util.Map) r5
            goto L49
        L48:
            r5 = 0
        L49:
            if (r5 != 0) goto L50
            java.util.Map r4 = kotlin.collections.a.i()
            return r4
        L50:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$init$1$2.a(e9.c):java.lang.Object");
    }
}
