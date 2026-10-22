package com.stepos.ability.manager.discovery;

import android.util.Log;
import com.stepos.ability.net.INet;
import d4.d;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import s9.C1923c;
import u9.c;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final INet f3142a;
    public String b;
    public final d c;
    public final C1923c d;

    public a(INet iNet, String deviceId, d uploadGate) {
        k.f(iNet, "iNet");
        k.f(deviceId, "deviceId");
        k.f(uploadGate, "uploadGate");
        this.f3142a = iNet;
        this.b = deviceId;
        this.c = uploadGate;
        u9.d dVar = AbstractC1691I.f5315a;
        this.d = AbstractC1683A.b(c.f6743a);
        AbilityUploadState[] abilityUploadStateArr = AbilityUploadState.f3141a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0222 A[LOOP:1: B:61:0x021c->B:63:0x0222, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0321  */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x018d -> B:44:0x0195). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(android.content.Context r34, java.util.Map r35, java.util.Map r36, java.util.List r37, java.util.List r38, java.util.Map r39, kotlin.coroutines.jvm.internal.ContinuationImpl r40) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 873
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.discovery.a.a(android.content.Context, java.util.Map, java.util.Map, java.util.List, java.util.List, java.util.Map, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void b() {
        try {
            AbstractC1683A.e(this.d, null);
        } catch (Exception e) {
            Log.e("AbilityDiscoveryProcessor", "cancel error:" + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0100 A[LOOP:0: B:36:0x00fa->B:38:0x0100, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0127 A[LOOP:1: B:40:0x0121->B:42:0x0127, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.content.Context r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.discovery.a.c(android.content.Context, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        if (r7.g(r6, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(android.content.Context r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performLocalScan$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performLocalScan$1 r0 = (com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performLocalScan$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performLocalScan$1 r0 = new com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performLocalScan$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            java.lang.String r3 = "AbilityDiscoveryProcessor"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L38
            if (r2 != r4) goto L30
            java.util.List r6 = r0.b
            java.util.List r6 = (java.util.List) r6
            kotlin.b.b(r8)
            goto L7c
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            android.content.Context r7 = r0.f3139a
            kotlin.b.b(r8)
            goto L4c
        L3e:
            kotlin.b.b(r8)
            r0.f3139a = r7
            r0.e = r5
            java.lang.Object r8 = r6.c(r7, r0)
            if (r8 != r1) goto L4c
            goto L7b
        L4c:
            r6 = r8
            java.util.List r6 = (java.util.List) r6
            boolean r8 = r6.isEmpty()
            if (r8 == 0) goto L65
            java.lang.String r6 = "performLocalScan: no abilities discovered."
            android.util.Log.i(r3, r6)
            com.stepos.ability.manager.discovery.AbilityUploadState[] r6 = com.stepos.ability.manager.discovery.AbilityUploadState.f3141a
            Z3.a r6 = new Z3.a
            kotlin.collections.EmptyList r7 = kotlin.collections.EmptyList.f4893a
            r8 = 0
            r6.<init>(r7, r8)
            return r6
        L65:
            F.i r8 = com.stepos.ability.manager.cache.a.e
            com.stepos.ability.manager.cache.a r7 = r8.x(r7)
            r8 = 0
            r0.f3139a = r8
            r8 = r6
            java.util.List r8 = (java.util.List) r8
            r0.b = r8
            r0.e = r4
            java.lang.Object r7 = r7.g(r6, r0)
            if (r7 != r1) goto L7c
        L7b:
            return r1
        L7c:
            int r7 = r6.size()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "performLocalScan: saved "
            r8.<init>(r0)
            r8.append(r7)
            java.lang.String r7 = " apps."
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            android.util.Log.i(r3, r7)
            Z3.a r7 = new Z3.a
            r7.<init>(r6, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.discovery.a.d(android.content.Context, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b7 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:11:0x0028, B:40:0x00a7, B:43:0x00ad, B:48:0x00b7, B:49:0x00ba, B:26:0x0060, B:31:0x006f, B:35:0x0075, B:37:0x009e), top: B:54:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba A[Catch: Exception -> 0x002d, TRY_LEAVE, TryCatch #0 {Exception -> 0x002d, blocks: (B:11:0x0028, B:40:0x00a7, B:43:0x00ad, B:48:0x00b7, B:49:0x00ba, B:26:0x0060, B:31:0x006f, B:35:0x0075, B:37:0x009e), top: B:54:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.util.List r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            r13 = this;
            java.lang.String r0 = "Upload abilities. start. apps="
            boolean r1 = r15 instanceof com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performUpload$1
            if (r1 == 0) goto L15
            r1 = r15
            com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performUpload$1 r1 = (com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performUpload$1) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.c = r2
            goto L1a
        L15:
            com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performUpload$1 r1 = new com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor$performUpload$1
            r1.<init>(r13, r15)
        L1a:
            java.lang.Object r15 = r1.f3140a
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.c
            r4 = 0
            java.lang.String r5 = "AbilityDiscoveryProcessor"
            r6 = 1
            if (r3 == 0) goto L39
            if (r3 != r6) goto L31
            kotlin.b.b(r15)     // Catch: java.lang.Exception -> L2d
            goto La7
        L2d:
            r0 = move-exception
            r13 = r0
            goto Lbe
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L39:
            kotlin.b.b(r15)
            boolean r15 = r14.isEmpty()
            if (r15 == 0) goto L4c
            java.lang.String r13 = "performUpload: empty apps, skip."
            android.util.Log.w(r5, r13)
            com.stepos.ability.manager.discovery.AbilityUploadState[] r13 = com.stepos.ability.manager.discovery.AbilityUploadState.f3141a
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            return r13
        L4c:
            d4.d r15 = r13.c
            boolean r15 = r15.a()
            if (r15 != 0) goto L5e
            java.lang.String r13 = "performUpload: skipped, no auth token"
            android.util.Log.i(r5, r13)
            com.stepos.ability.manager.discovery.AbilityUploadState[] r13 = com.stepos.ability.manager.discovery.AbilityUploadState.f3141a
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            return r13
        L5e:
            com.stepos.ability.manager.discovery.AbilityUploadState[] r15 = com.stepos.ability.manager.discovery.AbilityUploadState.f3141a
            com.stepos.ability.net.biz.model.DeviceAppRequest r7 = new com.stepos.ability.net.biz.model.DeviceAppRequest     // Catch: java.lang.Exception -> L2d
            java.lang.String r8 = r13.b     // Catch: java.lang.Exception -> L2d
            java.lang.String r9 = "INSTALL"
            java.lang.String r15 = android.os.Build.MODEL     // Catch: java.lang.Exception -> L2d
            java.lang.String r3 = "unknown"
            if (r15 != 0) goto L6e
            r10 = r3
            goto L6f
        L6e:
            r10 = r15
        L6f:
            java.lang.String r15 = android.os.Build.VERSION.RELEASE     // Catch: java.lang.Exception -> L2d
            if (r15 != 0) goto L74
            goto L75
        L74:
            r3 = r15
        L75:
            java.lang.String r15 = "Android "
            java.lang.String r11 = r15.concat(r3)     // Catch: java.lang.Exception -> L2d
            r12 = r14
            r7.<init>(r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L2d
            int r14 = r12.size()     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r15.<init>(r0)     // Catch: java.lang.Exception -> L2d
            r15.append(r14)     // Catch: java.lang.Exception -> L2d
            java.lang.String r14 = r15.toString()     // Catch: java.lang.Exception -> L2d
            android.util.Log.i(r5, r14)     // Catch: java.lang.Exception -> L2d
            com.stepos.ability.net.INet r13 = r13.f3142a     // Catch: java.lang.Exception -> L2d
            java.lang.Class<com.stepos.ability.net.biz.ApiService> r14 = com.stepos.ability.net.biz.ApiService.class
            java.lang.Object r13 = r13.create(r14)     // Catch: java.lang.Exception -> L2d
            com.stepos.ability.net.biz.ApiService r13 = (com.stepos.ability.net.biz.ApiService) r13     // Catch: java.lang.Exception -> L2d
            if (r13 == 0) goto Laa
            r1.c = r6     // Catch: java.lang.Exception -> L2d
            java.lang.Object r15 = r13.uploadAbilities(r7, r1)     // Catch: java.lang.Exception -> L2d
            if (r15 != r2) goto La7
            return r2
        La7:
            com.stepos.ability.net.biz.model.ApiResult r15 = (com.stepos.ability.net.biz.model.ApiResult) r15     // Catch: java.lang.Exception -> L2d
            goto Lab
        Laa:
            r15 = 0
        Lab:
            if (r15 == 0) goto Lb4
            boolean r13 = r15.isSuccess()     // Catch: java.lang.Exception -> L2d
            if (r13 != r6) goto Lb4
            goto Lb5
        Lb4:
            r6 = r4
        Lb5:
            if (r6 == 0) goto Lba
            com.stepos.ability.manager.discovery.AbilityUploadState[] r13 = com.stepos.ability.manager.discovery.AbilityUploadState.f3141a     // Catch: java.lang.Exception -> L2d
            goto Lbc
        Lba:
            com.stepos.ability.manager.discovery.AbilityUploadState[] r13 = com.stepos.ability.manager.discovery.AbilityUploadState.f3141a     // Catch: java.lang.Exception -> L2d
        Lbc:
            r4 = r6
            goto Lc5
        Lbe:
            java.lang.String r14 = "performUpload failed"
            android.util.Log.e(r5, r14, r13)
            com.stepos.ability.manager.discovery.AbilityUploadState[] r13 = com.stepos.ability.manager.discovery.AbilityUploadState.f3141a
        Lc5:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r4)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.discovery.a.e(java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
