package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrFileResult;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrLocalFileInferencer {
    public static final AsrLocalFileInferencer INSTANCE = new AsrLocalFileInferencer();
    private static final int SAMPLE_RATE = 16000;
    private static final String TAG = "AsrLocalFileInferencer";

    private AsrLocalFileInferencer() {
    }

    /* renamed from: recognizeFile-yxL6bBk$default, reason: not valid java name */
    public static /* synthetic */ Object m52recognizeFileyxL6bBk$default(AsrLocalFileInferencer asrLocalFileInferencer, e7.a aVar, String str, String str2, Object obj, qb.b bVar, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i10 & 8) != 0) {
            obj = null;
        }
        return asrLocalFileInferencer.m54recognizeFileyxL6bBk(aVar, str, str3, obj, bVar);
    }

    /* renamed from: recognizePcmSegments-hUnOzRk$default, reason: not valid java name */
    public static /* synthetic */ Object m53recognizePcmSegmentshUnOzRk$default(AsrLocalFileInferencer asrLocalFileInferencer, e7.a aVar, short[] sArr, int i10, String str, Object obj, qb.b bVar, int i11, Object obj2) {
        if ((i11 & 8) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            obj = null;
        }
        return asrLocalFileInferencer.m55recognizePcmSegmentshUnOzRk(aVar, sArr, i10, str2, obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence recognizePcmSegments_hUnOzRk$lambda$3(AsrFileResult.Utterance it) {
        kotlin.jvm.internal.g.f(it, "it");
        return it.getText();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00da A[Catch: Exception -> 0x011d, TRY_LEAVE, TryCatch #2 {Exception -> 0x011d, blocks: (B:34:0x00d6, B:36:0x00da), top: B:58:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* renamed from: recognizeFile-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m54recognizeFileyxL6bBk(e7.a r17, java.lang.String r18, java.lang.String r19, java.lang.Object r20, qb.b<? super kotlin.Result<com.stepos.core.ability.speech.AsrFileResult>> r21) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalFileInferencer.m54recognizeFileyxL6bBk(e7.a, java.lang.String, java.lang.String, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* renamed from: recognizePcmSegments-hUnOzRk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m55recognizePcmSegmentshUnOzRk(e7.a r18, short[] r19, int r20, java.lang.String r21, java.lang.Object r22, qb.b<? super kotlin.Result<com.stepos.core.ability.speech.AsrFileResult>> r23) {
        /*
            r17 = this;
            r2 = r19
            r0 = r23
            boolean r1 = r0 instanceof com.stepos.core.ability.speech.AsrLocalFileInferencer$recognizePcmSegments$1
            if (r1 == 0) goto L18
            r1 = r0
            com.stepos.core.ability.speech.AsrLocalFileInferencer$recognizePcmSegments$1 r1 = (com.stepos.core.ability.speech.AsrLocalFileInferencer$recognizePcmSegments$1) r1
            int r3 = r1.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r1.label = r3
        L16:
            r6 = r1
            goto L20
        L18:
            com.stepos.core.ability.speech.AsrLocalFileInferencer$recognizePcmSegments$1 r1 = new com.stepos.core.ability.speech.AsrLocalFileInferencer$recognizePcmSegments$1
            r3 = r17
            r1.<init>(r3, r0)
            goto L16
        L20:
            java.lang.Object r0 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r6.label
            r8 = 1
            if (r1 == 0) goto L43
            if (r1 != r8) goto L3b
            int r1 = r6.I$0
            java.lang.Object r2 = r6.L$1
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r3 = r6.L$0
            short[] r3 = (short[]) r3
            kotlin.c.b(r0)     // Catch: java.lang.Exception -> Lb0
            r7 = r2
            r2 = r3
            goto L85
        L3b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L43:
            kotlin.c.b(r0)
            int r0 = r2.length
            if (r0 != 0) goto L4a
            goto L4c
        L4a:
            if (r20 > 0) goto L5c
        L4c:
            com.stepos.core.ability.speech.AsrFileResult r9 = new com.stepos.core.ability.speech.AsrFileResult
            r15 = 12
            r16 = 0
            r10 = 0
            java.lang.String r12 = ""
            r13 = 0
            r14 = 0
            r9.<init>(r10, r12, r13, r14, r15, r16)
            return r9
        L5c:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lb0
            r9.<init>()     // Catch: java.lang.Exception -> Lb0
            com.stepos.core.ability.speech.AsrLocalChunkedInferencer r0 = com.stepos.core.ability.speech.AsrLocalChunkedInferencer.INSTANCE     // Catch: java.lang.Exception -> Lb0
            r1 = r18
            r3 = r20
            r4 = r21
            r5 = r22
            kotlinx.coroutines.flow.Flow r0 = r0.inferFlow(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Lb0
            com.stepos.core.ability.speech.AsrLocalFileInferencer$recognizePcmSegments$2 r1 = new com.stepos.core.ability.speech.AsrLocalFileInferencer$recognizePcmSegments$2     // Catch: java.lang.Exception -> Lb0
            r1.<init>()     // Catch: java.lang.Exception -> Lb0
            r6.L$0 = r2     // Catch: java.lang.Exception -> Lb0
            r6.L$1 = r9     // Catch: java.lang.Exception -> Lb0
            r6.I$0 = r3     // Catch: java.lang.Exception -> Lb0
            r6.label = r8     // Catch: java.lang.Exception -> Lb0
            java.lang.Object r0 = r0.collect(r1, r6)     // Catch: java.lang.Exception -> Lb0
            if (r0 != r7) goto L83
            return r7
        L83:
            r1 = r3
            r7 = r9
        L85:
            int r0 = r2.length     // Catch: java.lang.Exception -> Lb0
            double r2 = (double) r0     // Catch: java.lang.Exception -> Lb0
            double r0 = (double) r1     // Catch: java.lang.Exception -> Lb0
            double r4 = r2 / r0
            java.lang.String r0 = ""
            com.stepos.core.ability.speech.n0 r1 = new com.stepos.core.ability.speech.n0     // Catch: java.lang.Exception -> Lb0
            r2 = 1
            r1.<init>(r2)     // Catch: java.lang.Exception -> Lb0
            r2 = 30
            r3 = 0
            r6 = 0
            r18 = r0
            r21 = r1
            r22 = r2
            r19 = r3
            r20 = r6
            r17 = r7
            java.lang.String r6 = kotlin.collections.a.z0(r17, r18, r19, r20, r21, r22)     // Catch: java.lang.Exception -> Lb0
            com.stepos.core.ability.speech.AsrFileResult r3 = new com.stepos.core.ability.speech.AsrFileResult     // Catch: java.lang.Exception -> Lb0
            r9 = 8
            r10 = 0
            r8 = 0
            r3.<init>(r4, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> Lb0
            return r3
        Lb0:
            r0 = move-exception
            kotlin.Result$Failure r0 = kotlin.c.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalFileInferencer.m55recognizePcmSegmentshUnOzRk(e7.a, short[], int, java.lang.String, java.lang.Object, qb.b):java.lang.Object");
    }
}
