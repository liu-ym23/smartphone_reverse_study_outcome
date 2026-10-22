package com.stepos.common.utils.filestorage.internal;

import P6.UploadRequest;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.r;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$fileReporter$1", f = "UploadCoordinator.kt", l = {99, 100}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class UploadCoordinator$uploadBatch$4$fileReporter$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ M $$this$coroutineScope;
    final /* synthetic */ a[] $fileTrackers;
    final /* synthetic */ List<UploadRequest> $items;
    final /* synthetic */ AtomicIntegerArray $lastFilePct;
    final /* synthetic */ r<Integer, String, Integer, InterfaceC4014c<? super t>, Object> $onFileProgress;
    final /* synthetic */ int $total;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadCoordinator$uploadBatch$4$fileReporter$1(int i10, a[] aVarArr, AtomicIntegerArray atomicIntegerArray, M m10, r<? super Integer, ? super String, ? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> rVar, List<UploadRequest> list, InterfaceC4014c<? super UploadCoordinator$uploadBatch$4$fileReporter$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$total = i10;
        this.$fileTrackers = aVarArr;
        this.$lastFilePct = atomicIntegerArray;
        this.$$this$coroutineScope = m10;
        this.$onFileProgress = rVar;
        this.$items = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UploadCoordinator$uploadBatch$4$fileReporter$1(this.$total, this.$fileTrackers, this.$lastFilePct, this.$$this$coroutineScope, this.$onFileProgress, this.$items, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UploadCoordinator$uploadBatch$4$fileReporter$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        r10 = r11;
        r10.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
    
        if (Ua.U.a(80, r10) != r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002b A[Catch: CancellationException -> 0x0054, TryCatch #0 {CancellationException -> 0x0054, blocks: (B:6:0x000e, B:15:0x0027, B:17:0x002b, B:21:0x0042, B:22:0x0046, B:11:0x001d), top: B:28:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046 A[EDGE_INSN: B:31:0x0046->B:22:0x0046 BREAK  A[LOOP:0: B:15:0x0027->B:21:0x0042], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004f -> B:25:0x0052). Please report as a decompilation issue!!! */
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
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.C4849c.b(r12)     // Catch: java.util.concurrent.CancellationException -> L54
            r10 = r11
            goto L52
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1b:
            int r1 = r11.I$0
            kotlin.C4849c.b(r12)     // Catch: java.util.concurrent.CancellationException -> L54
            r10 = r11
            goto L42
        L22:
            kotlin.C4849c.b(r12)
        L25:
            r12 = 0
            r9 = r12
        L27:
            int r12 = r11.$total     // Catch: java.util.concurrent.CancellationException -> L54
            if (r9 >= r12) goto L46
            com.stepos.common.utils.filestorage.internal.a[] r4 = r11.$fileTrackers     // Catch: java.util.concurrent.CancellationException -> L54
            java.util.concurrent.atomic.AtomicIntegerArray r5 = r11.$lastFilePct     // Catch: java.util.concurrent.CancellationException -> L54
            Ua.M r6 = r11.$$this$coroutineScope     // Catch: java.util.concurrent.CancellationException -> L54
            p9.r<java.lang.Integer, java.lang.String, java.lang.Integer, e9.c<? super Y8.t>, java.lang.Object> r7 = r11.$onFileProgress     // Catch: java.util.concurrent.CancellationException -> L54
            java.util.List<P6.l> r8 = r11.$items     // Catch: java.util.concurrent.CancellationException -> L54
            r11.I$0 = r9     // Catch: java.util.concurrent.CancellationException -> L54
            r11.label = r3     // Catch: java.util.concurrent.CancellationException -> L54
            r10 = r11
            java.lang.Object r11 = com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.h(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L54
            if (r11 != r0) goto L41
            goto L51
        L41:
            r1 = r9
        L42:
            int r9 = r1 + 1
            r11 = r10
            goto L27
        L46:
            r10 = r11
            r10.label = r2     // Catch: java.util.concurrent.CancellationException -> L54
            r11 = 80
            java.lang.Object r11 = Ua.U.a(r11, r10)     // Catch: java.util.concurrent.CancellationException -> L54
            if (r11 != r0) goto L52
        L51:
            return r0
        L52:
            r11 = r10
            goto L25
        L54:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$fileReporter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
