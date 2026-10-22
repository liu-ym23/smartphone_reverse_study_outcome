package com.stepos.common.utils.filestorage.internal;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J<\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/FileStorageApi;", "", "Lcom/stepos/common/utils/filestorage/internal/GatewayClient;", "gw", "<init>", "(Lcom/stepos/common/utils/filestorage/internal/GatewayClient;)V", "LP6/d;", "req", "LP6/e;", Const.INTENT_KEY_PKGNAME, "(LP6/d;Le9/c;)Ljava/lang/Object;", "", "", "fileIds", "LP6/c;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "fileId", "", "resizePercent", "expiresSeconds", "LP6/g;", "c", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Le9/c;)Ljava/lang/Object;", "dstType", "page", "LP6/f;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/common/utils/filestorage/internal/GatewayClient;", "Companion", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileStorageApi {
    public static final int MAX_BATCH_QUERY_SIZE = 100;
    private final GatewayClient gw;

    public FileStorageApi(GatewayClient gw) {
        p.i(gw, "gw");
        this.gw = gw;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ce -> B:31:0x00d2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.util.List<java.lang.String> r9, e9.InterfaceC4014c<? super P6.BatchQueryStorageObjectResponse> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.FileStorageApi.a(java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(P6.CreateUploadSessionRequest r5, e9.InterfaceC4014c<? super P6.CreateUploadSessionResponse> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1 r0 = (com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1 r0 = new com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r6)
            goto L54
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r6)
            qb.a r6 = com.stepos.common.utils.filestorage.internal.c.c()
            r6.getSerializersModule()
            P6.d$b r2 = P6.CreateUploadSessionRequest.INSTANCE
            kotlinx.serialization.KSerializer r2 = r2.serializer()
            lb.m r2 = (lb.m) r2
            java.lang.String r5 = r6.a(r2, r5)
            com.stepos.common.utils.filestorage.internal.GatewayClient r4 = r4.gw
            r0.label = r3
            java.lang.String r6 = "/storage/upload-sessions"
            java.lang.Object r6 = r4.k(r6, r5, r0)
            if (r6 != r1) goto L54
            return r1
        L54:
            java.lang.String r6 = (java.lang.String) r6
            qb.a r4 = com.stepos.common.utils.filestorage.internal.c.c()
            r4.getSerializersModule()
            P6.e$b r5 = P6.CreateUploadSessionResponse.INSTANCE
            kotlinx.serialization.KSerializer r5 = r5.serializer()
            lb.a r5 = (lb.InterfaceC4883a) r5
            java.lang.Object r4 = r4.c(r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.FileStorageApi.b(P6.d, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r5, java.lang.Integer r6, java.lang.Integer r7, e9.InterfaceC4014c<? super P6.DownloadUrlResponse> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1 r0 = (com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1 r0 = new com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r8)
            goto L74
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r8)
            java.util.Map r8 = Z8.Q.c()
            if (r6 == 0) goto L44
            java.lang.String r2 = "resizePercent"
            java.lang.String r6 = r6.toString()
            r8.put(r2, r6)
        L44:
            if (r7 == 0) goto L4f
            java.lang.String r6 = "expiresSeconds"
            java.lang.String r7 = r7.toString()
            r8.put(r6, r7)
        L4f:
            java.util.Map r6 = Z8.Q.b(r8)
            com.stepos.common.utils.filestorage.internal.GatewayClient r4 = r4.gw
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "/storage/objects/"
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = "/download-url"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.label = r3
            java.lang.Object r8 = r4.h(r5, r6, r0)
            if (r8 != r1) goto L74
            return r1
        L74:
            java.lang.String r8 = (java.lang.String) r8
            qb.a r4 = com.stepos.common.utils.filestorage.internal.c.c()
            r4.getSerializersModule()
            P6.g$b r5 = P6.DownloadUrlResponse.INSTANCE
            kotlinx.serialization.KSerializer r5 = r5.serializer()
            lb.a r5 = (lb.InterfaceC4883a) r5
            java.lang.Object r4 = r4.c(r5, r8)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.FileStorageApi.c(java.lang.String, java.lang.Integer, java.lang.Integer, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r5, java.lang.String r6, java.lang.Integer r7, java.lang.Integer r8, e9.InterfaceC4014c<? super P6.DocumentPreviewResponse> r9) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.stepos.common.utils.filestorage.internal.FileStorageApi$getPreviewUrl$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.common.utils.filestorage.internal.FileStorageApi$getPreviewUrl$1 r0 = (com.stepos.common.utils.filestorage.internal.FileStorageApi$getPreviewUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.FileStorageApi$getPreviewUrl$1 r0 = new com.stepos.common.utils.filestorage.internal.FileStorageApi$getPreviewUrl$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r9)
            goto L7b
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r9)
            java.util.Map r9 = Z8.Q.c()
            if (r6 == 0) goto L3f
            java.lang.String r2 = "dstType"
            r9.put(r2, r6)
        L3f:
            if (r7 == 0) goto L4a
            java.lang.String r6 = "expiresSeconds"
            java.lang.String r7 = r7.toString()
            r9.put(r6, r7)
        L4a:
            if (r8 == 0) goto L56
            java.lang.String r6 = "page"
            java.lang.String r7 = r8.toString()
            r9.put(r6, r7)
        L56:
            java.util.Map r6 = Z8.Q.b(r9)
            com.stepos.common.utils.filestorage.internal.GatewayClient r4 = r4.gw
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "/storage/objects/"
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = "/preview-url"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.label = r3
            java.lang.Object r9 = r4.h(r5, r6, r0)
            if (r9 != r1) goto L7b
            return r1
        L7b:
            java.lang.String r9 = (java.lang.String) r9
            qb.a r4 = com.stepos.common.utils.filestorage.internal.c.c()
            r4.getSerializersModule()
            P6.f$b r5 = P6.DocumentPreviewResponse.INSTANCE
            kotlinx.serialization.KSerializer r5 = r5.serializer()
            lb.a r5 = (lb.InterfaceC4883a) r5
            java.lang.Object r4 = r4.c(r5, r9)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.FileStorageApi.d(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, e9.c):java.lang.Object");
    }
}
