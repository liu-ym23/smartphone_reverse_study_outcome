package com.stepos.common.utils.filestorage.internal;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f6762a;

    public a(b bVar) {
        this.f6762a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(o8.b r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1 r0 = (com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1) r0
            int r1 = r0.f6650c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6650c = r1
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1 r0 = new com.stepos.common.utils.filestorage.internal.FileStorageApi$createUploadSession$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f6648a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6650c
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L28
            kotlin.c.b(r11)
            goto La2
        L28:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L30:
            kotlin.c.b(r11)
            uc.l r11 = n8.d.f10653a
            r11.getClass()
            o8.b$b r2 = o8.b.Companion
            pc.a r2 = r2.serializer()
            java.lang.String r4 = "serializer"
            kotlin.jvm.internal.g.f(r2, r4)
            l5.a r4 = new l5.a
            r5 = 2
            r6 = 0
            r4.<init>(r5, r6)
            vc.b r5 = vc.b.f13493c
            monitor-enter(r5)
            java.lang.Object r6 = r5.f8519b     // Catch: java.lang.Throwable -> L6a
            mb.k r6 = (mb.k) r6     // Catch: java.lang.Throwable -> L6a
            boolean r7 = r6.isEmpty()     // Catch: java.lang.Throwable -> L6a
            r8 = 0
            if (r7 == 0) goto L5a
            r6 = r8
            goto L5e
        L5a:
            java.lang.Object r6 = r6.removeLast()     // Catch: java.lang.Throwable -> L6a
        L5e:
            char[] r6 = (char[]) r6     // Catch: java.lang.Throwable -> L6a
            if (r6 == 0) goto L6c
            int r7 = r5.f8518a     // Catch: java.lang.Throwable -> L6a
            int r8 = r6.length     // Catch: java.lang.Throwable -> L6a
            int r7 = r7 - r8
            r5.f8518a = r7     // Catch: java.lang.Throwable -> L6a
            r8 = r6
            goto L6c
        L6a:
            r9 = move-exception
            goto Lb9
        L6c:
            monitor-exit(r5)
            if (r8 != 0) goto L73
            r5 = 128(0x80, float:1.8E-43)
            char[] r8 = new char[r5]
        L73:
            r4.f10234c = r8
            vc.k r5 = new vc.k     // Catch: java.lang.Throwable -> Lb4
            kotlinx.serialization.json.internal.WriteMode r6 = kotlinx.serialization.json.internal.WriteMode.f10136c     // Catch: java.lang.Throwable -> Lb4
            sb.a r7 = kotlinx.serialization.json.internal.WriteMode.f10140k     // Catch: java.lang.Throwable -> Lb4
            mb.a r7 = (mb.a) r7     // Catch: java.lang.Throwable -> Lb4
            int r7 = r7.a()     // Catch: java.lang.Throwable -> Lb4
            uc.k[] r7 = new uc.k[r7]     // Catch: java.lang.Throwable -> Lb4
            hb.c r8 = new hb.c     // Catch: java.lang.Throwable -> Lb4
            r8.<init>(r4)     // Catch: java.lang.Throwable -> Lb4
            r5.<init>(r8, r11, r6, r7)     // Catch: java.lang.Throwable -> Lb4
            r5.q(r2, r10)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> Lb4
            r4.i()
            com.stepos.common.utils.filestorage.internal.b r9 = r9.f6762a
            java.lang.String r11 = "/storage/upload-sessions"
            r0.f6650c = r3
            java.lang.Object r11 = r9.e(r11, r10, r0)
            if (r11 != r1) goto La2
            return r1
        La2:
            java.lang.String r11 = (java.lang.String) r11
            uc.l r9 = n8.d.f10653a
            r9.getClass()
            o8.c$b r10 = o8.c.Companion
            pc.a r10 = r10.serializer()
            java.lang.Object r9 = r9.a(r11, r10)
            return r9
        Lb4:
            r9 = move-exception
            r4.i()
            throw r9
        Lb9:
            monitor-exit(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.a.a(o8.b, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r5, java.lang.Integer r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1 r0 = (com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1) r0
            int r1 = r0.f6653c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6653c = r1
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1 r0 = new com.stepos.common.utils.filestorage.internal.FileStorageApi$getDownloadUrl$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f6651a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6653c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r7)
            goto L59
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.c.b(r7)
            kotlin.collections.builders.MapBuilder r7 = new kotlin.collections.builders.MapBuilder
            r7.<init>()
            if (r6 == 0) goto L42
            java.lang.String r2 = "expiresSeconds"
            java.lang.String r6 = r6.toString()
            r7.put(r2, r6)
        L42:
            kotlin.collections.builders.MapBuilder r6 = r7.b()
            java.lang.String r7 = "/storage/objects/"
            java.lang.String r2 = "/download-url"
            java.lang.String r5 = a0.a.k(r7, r5, r2)
            r0.f6653c = r3
            com.stepos.common.utils.filestorage.internal.b r4 = r4.f6762a
            java.lang.Object r7 = r4.c(r5, r6, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            java.lang.String r7 = (java.lang.String) r7
            uc.l r4 = n8.d.f10653a
            r4.getClass()
            o8.d$b r5 = o8.d.Companion
            pc.a r5 = r5.serializer()
            java.lang.Object r4 = r4.a(r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.a.b(java.lang.String, java.lang.Integer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
