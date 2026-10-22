package com.stepos.base.model.atrest;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(b7.k r8, java.io.File r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            boolean r0 = r10 instanceof com.stepos.base.model.atrest.AtRestLoadKt$resolveModelWeight$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.base.model.atrest.AtRestLoadKt$resolveModelWeight$1 r0 = (com.stepos.base.model.atrest.AtRestLoadKt$resolveModelWeight$1) r0
            int r1 = r0.f6347e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6347e = r1
            goto L18
        L13:
            com.stepos.base.model.atrest.AtRestLoadKt$resolveModelWeight$1 r0 = new com.stepos.base.model.atrest.AtRestLoadKt$resolveModelWeight$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f6346d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6347e
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            long r8 = r0.f6345c
            b6.f r1 = r0.f6344b
            b7.k r0 = r0.f6343a
            kotlin.c.b(r10)     // Catch: java.lang.Throwable -> L2f
            r4 = r8
            r8 = r0
            goto L75
        L2f:
            r8 = move-exception
            goto Lb9
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.c.b(r10)
            com.stepos.core.ota.crypto.OtaAtRestDecryptor r10 = a4.a.f37i
            if (r10 != 0) goto L56
            java.lang.String r8 = r9.getAbsolutePath()
            java.lang.String r9 = "getAbsolutePath(...)"
            kotlin.jvm.internal.g.e(r8, r9)
            c7.d r9 = new c7.d
            a9.a r10 = new a9.a
            r0 = 4
            r10.<init>(r0)
            r9.<init>(r8, r10)
            return r9
        L56:
            b6.f r2 = androidx.datastore.preferences.protobuf.b1.h
            if (r2 == 0) goto L61
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            java.lang.String r5 = r8.f3090a
            r2.invoke(r4, r5)
        L61:
            long r4 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> Lb5
            r0.f6343a = r8     // Catch: java.lang.Throwable -> Lb5
            r0.f6344b = r2     // Catch: java.lang.Throwable -> Lb5
            r0.f6345c = r4     // Catch: java.lang.Throwable -> Lb5
            r0.f6347e = r3     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r10 = r10.resolveForBackend(r9, r0)     // Catch: java.lang.Throwable -> Lb5
            if (r10 != r1) goto L74
            return r1
        L74:
            r1 = r2
        L75:
            c7.d r10 = (c7.d) r10     // Catch: java.lang.Throwable -> Lb3
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r9 = c7.b.f3302a     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r9 = r8.f3090a     // Catch: java.lang.Throwable -> Lb3
            long r6 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> Lb3
            long r6 = r6 - r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r6 / r4
            int r0 = r9.length()     // Catch: java.lang.Throwable -> Lb3
            if (r0 != 0) goto L8b
            goto La6
        L8b:
            r4 = 0
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 > 0) goto L92
            goto La6
        L92:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r0 = c7.b.f3302a     // Catch: java.lang.Throwable -> Lb3
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> Lb3
            b6.f r4 = new b6.f     // Catch: java.lang.Throwable -> Lb3
            r4.<init>(r3)     // Catch: java.lang.Throwable -> Lb3
            c7.a r3 = new c7.a     // Catch: java.lang.Throwable -> Lb3
            r5 = 0
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> Lb3
            r0.merge(r9, r2, r3)     // Catch: java.lang.Throwable -> Lb3
        La6:
            if (r1 == 0) goto Laf
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            java.lang.String r8 = r8.f3090a
            r1.invoke(r9, r8)
        Laf:
            return r10
        Lb0:
            r0 = r8
            r8 = r9
            goto Lb9
        Lb3:
            r9 = move-exception
            goto Lb0
        Lb5:
            r9 = move-exception
            r0 = r8
            r8 = r9
            r1 = r2
        Lb9:
            if (r1 == 0) goto Lc2
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            java.lang.String r10 = r0.f3090a
            r1.invoke(r9, r10)
        Lc2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.model.atrest.a.a(b7.k, java.io.File, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
