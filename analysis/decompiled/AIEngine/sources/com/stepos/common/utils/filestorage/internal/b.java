package com.stepos.common.utils.filestorage.internal;

import ad.l;
import ad.n;
import bd.d;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.core.common.cloud.FileStorageBootstrap$ensureSetup$1$headerProvider$1;
import com.stepos.core.common.cloud.FileStorageBootstrap$ensureSetup$1$tokenProvider$1;
import h0.e;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final l f6763f = d.a("application/json; charset=UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final Set<String> f6764g = mb.l.s0(new String[]{"zy-app-id", "zy-nonce", "zy-timestamp", "zy-sign"});

    /* renamed from: a, reason: collision with root package name */
    public final m8.b f6765a;

    /* renamed from: b, reason: collision with root package name */
    public final FileStorageBootstrap$ensureSetup$1$tokenProvider$1 f6766b;

    /* renamed from: c, reason: collision with root package name */
    public final FileStorageBootstrap$ensureSetup$1$headerProvider$1 f6767c;

    /* renamed from: d, reason: collision with root package name */
    public final n f6768d;

    /* renamed from: e, reason: collision with root package name */
    public final uc.a f6769e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    public b(m8.b bVar, FileStorageBootstrap$ensureSetup$1$tokenProvider$1 fileStorageBootstrap$ensureSetup$1$tokenProvider$1, FileStorageBootstrap$ensureSetup$1$headerProvider$1 fileStorageBootstrap$ensureSetup$1$headerProvider$1, n nVar) {
        uc.l json = n8.d.f10653a;
        g.f(json, "json");
        this.f6765a = bVar;
        this.f6766b = fileStorageBootstrap$ensureSetup$1$tokenProvider$1;
        this.f6767c = fileStorageBootstrap$ensureSetup$1$headerProvider$1;
        this.f6768d = nVar;
        this.f6769e = json;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(com.stepos.common.utils.filestorage.internal.b r8, okhttp3.Response r9) throws com.stepos.common.utils.filestorage.exceptions.FileStorageException.Network, com.stepos.common.utils.filestorage.exceptions.FileStorageException.GatewayException, com.stepos.common.utils.filestorage.exceptions.FileStorageException.BizError {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.b.a(com.stepos.common.utils.filestorage.internal.b, okhttp3.Response):java.lang.String");
    }

    public static FileStorageException.GatewayException d(int i10, int i11, String message) {
        if (i10 != 11121) {
            if (i10 == 99999) {
                g.f(message, "message");
                return new FileStorageException.GatewayException.TokenInvalid(99999, message);
            }
            switch (i10) {
                case 10010:
                    g.f(message, "message");
                    return new FileStorageException.GatewayException.SystemMaintenance(10010, message);
                case 10011:
                    g.f(message, "message");
                    return new FileStorageException.GatewayException.DuplicateRequest(10011, message);
                case 10012:
                    g.f(message, "message");
                    return new FileStorageException.GatewayException.MissingCommonParam(10012, message);
                case 10013:
                    break;
                default:
                    StringBuilder sbD = e.d(i11, "http=", i10, ", gatewayCode=", ", msg=");
                    sbD.append(message);
                    String message2 = sbD.toString();
                    g.f(message2, "message");
                    return new FileStorageException.GatewayException.Other(i10, message2);
            }
        }
        g.f(message, "message");
        return new FileStorageException.GatewayException.SignatureInvalid(i10, message);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r14, java.lang.String r15, java.util.Map r16, java.lang.String r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        /*
            Method dump skipped, instructions count: 691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.b.b(java.lang.String, java.lang.String, java.util.Map, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r9, kotlin.collections.builders.MapBuilder r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.stepos.common.utils.filestorage.internal.GatewayClient$get$1
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.common.utils.filestorage.internal.GatewayClient$get$1 r0 = (com.stepos.common.utils.filestorage.internal.GatewayClient$get$1) r0
            int r1 = r0.f6669d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6669d = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.common.utils.filestorage.internal.GatewayClient$get$1 r0 = new com.stepos.common.utils.filestorage.internal.GatewayClient$get$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.f6667b
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r6.f6669d
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 == r2) goto L34
            if (r1 != r7) goto L2c
            kotlin.c.b(r11)
            return r11
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            com.stepos.common.utils.filestorage.internal.b r8 = r6.f6666a
            kotlin.c.b(r11)
            goto L4f
        L3a:
            kotlin.c.b(r11)
            r6.f6666a = r8
            r6.f6669d = r2
            java.lang.String r2 = "GET"
            r5 = 0
            r1 = r8
            r3 = r9
            r4 = r10
            java.lang.Object r11 = r1.b(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L4e
            goto L68
        L4e:
            r8 = r1
        L4f:
            okhttp3.h r11 = (okhttp3.h) r11
            r9 = 0
            r6.f6666a = r9
            r6.f6669d = r7
            r8.getClass()
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.common.utils.filestorage.internal.GatewayClient$execute$2 r1 = new com.stepos.common.utils.filestorage.internal.GatewayClient$execute$2
            r1.<init>(r11, r8, r9)
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r10, r1, r6)
            if (r8 != r0) goto L69
        L68:
            return r0
        L69:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.b.c(java.lang.String, kotlin.collections.builders.MapBuilder, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r9, java.lang.String r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1 r0 = (com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1) r0
            int r1 = r0.f6673d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f6673d = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1 r0 = new com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.f6671b
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r6.f6673d
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 == r2) goto L34
            if (r1 != r7) goto L2c
            kotlin.c.b(r11)
            return r11
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            com.stepos.common.utils.filestorage.internal.b r8 = r6.f6670a
            kotlin.c.b(r11)
            goto L52
        L3a:
            kotlin.c.b(r11)
            java.util.Map r4 = kotlin.collections.b.d0()
            r6.f6670a = r8
            r6.f6673d = r2
            java.lang.String r2 = "POST"
            r1 = r8
            r3 = r9
            r5 = r10
            java.lang.Object r11 = r1.b(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L51
            goto L6b
        L51:
            r8 = r1
        L52:
            okhttp3.h r11 = (okhttp3.h) r11
            r9 = 0
            r6.f6670a = r9
            r6.f6673d = r7
            r8.getClass()
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.common.utils.filestorage.internal.GatewayClient$execute$2 r1 = new com.stepos.common.utils.filestorage.internal.GatewayClient$execute$2
            r1.<init>(r11, r8, r9)
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r10, r1, r6)
            if (r8 != r0) goto L6c
        L6b:
            return r0
        L6c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.b.e(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
