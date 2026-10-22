package com.stepos.common.utils.filestorage.internal;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1", f = "UploadCoordinator.kt", l = {71, 72}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class UploadCoordinator$uploadBatch$4$reporter$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ M $$this$coroutineScope;
    final /* synthetic */ AtomicInteger $lastPct;
    final /* synthetic */ p<Integer, InterfaceC4014c<? super t>, Object> $onTotalProgress;
    final /* synthetic */ long $totalBytes;
    final /* synthetic */ AtomicLong $uploadedBytes;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadCoordinator$uploadBatch$4$reporter$1(AtomicLong atomicLong, long j10, AtomicInteger atomicInteger, M m10, p<? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super UploadCoordinator$uploadBatch$4$reporter$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$uploadedBytes = atomicLong;
        this.$totalBytes = j10;
        this.$lastPct = atomicInteger;
        this.$$this$coroutineScope = m10;
        this.$onTotalProgress = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UploadCoordinator$uploadBatch$4$reporter$1(this.$uploadedBytes, this.$totalBytes, this.$lastPct, this.$$this$coroutineScope, this.$onTotalProgress, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UploadCoordinator$uploadBatch$4$reporter$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        if (Ua.U.a(80, r10) != r0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[Catch: CancellationException -> 0x0044, PHI: r10
      0x0037: PHI (r10v0 com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1) = 
      (r10v1 com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1)
      (r10v3 com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1)
     binds: [B:14:0x0034, B:11:0x001e] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0044, blocks: (B:6:0x000e, B:13:0x0023, B:16:0x0037, B:10:0x001b), top: B:22:0x0008 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003f -> B:19:0x0042). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.C4849c.b(r12)     // Catch: java.util.concurrent.CancellationException -> L44
            r10 = r11
            goto L42
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1b:
            kotlin.C4849c.b(r12)     // Catch: java.util.concurrent.CancellationException -> L44
            r10 = r11
            goto L37
        L20:
            kotlin.C4849c.b(r12)
        L23:
            java.util.concurrent.atomic.AtomicLong r4 = r11.$uploadedBytes     // Catch: java.util.concurrent.CancellationException -> L44
            long r5 = r11.$totalBytes     // Catch: java.util.concurrent.CancellationException -> L44
            java.util.concurrent.atomic.AtomicInteger r7 = r11.$lastPct     // Catch: java.util.concurrent.CancellationException -> L44
            Ua.M r8 = r11.$$this$coroutineScope     // Catch: java.util.concurrent.CancellationException -> L44
            p9.p<java.lang.Integer, e9.c<? super Y8.t>, java.lang.Object> r9 = r11.$onTotalProgress     // Catch: java.util.concurrent.CancellationException -> L44
            r11.label = r3     // Catch: java.util.concurrent.CancellationException -> L44
            r10 = r11
            java.lang.Object r11 = com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.f(r4, r5, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L44
            if (r11 != r0) goto L37
            goto L41
        L37:
            r10.label = r2     // Catch: java.util.concurrent.CancellationException -> L44
            r11 = 80
            java.lang.Object r11 = Ua.U.a(r11, r10)     // Catch: java.util.concurrent.CancellationException -> L44
            if (r11 != r0) goto L42
        L41:
            return r0
        L42:
            r11 = r10
            goto L23
        L44:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
