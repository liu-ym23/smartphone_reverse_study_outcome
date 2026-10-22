package com.stepos.ailauncher.express.orchestrator;

import K5.c;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.express.orchestrator.ExpressOrchestrator$run$1", f = "ExpressOrchestrator.kt", l = {61, 78, 81}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ExpressOrchestrator$run$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ String $instruction;
    final /* synthetic */ c $mapper;
    final /* synthetic */ String $pkg;
    final /* synthetic */ String $trackId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ ExpressOrchestrator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressOrchestrator$run$1(ExpressOrchestrator expressOrchestrator, String str, c cVar, String str2, long j10, String str3, InterfaceC4014c<? super ExpressOrchestrator$run$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = expressOrchestrator;
        this.$pkg = str;
        this.$mapper = cVar;
        this.$trackId = str2;
        this.$generation = j10;
        this.$instruction = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ExpressOrchestrator$run$1(this.this$0, this.$pkg, this.$mapper, this.$trackId, this.$generation, this.$instruction, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ExpressOrchestrator$run$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0185, code lost:
    
        if (r7.h(r5, r4, r8, r14) == r0) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014d A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:8:0x0029, B:15:0x004e, B:49:0x0147, B:51:0x014d, B:54:0x0188, B:56:0x018c, B:57:0x0194, B:59:0x0198, B:60:0x01a0, B:62:0x01a4, B:68:0x01c3, B:69:0x01c8, B:16:0x0053, B:22:0x0076, B:23:0x008a, B:25:0x0090, B:29:0x00a3, B:31:0x00a7, B:33:0x00b0, B:34:0x00bf, B:36:0x00c5, B:37:0x00d3, B:39:0x00dd, B:40:0x00f2, B:42:0x0112, B:45:0x011e, B:44:0x0118, B:19:0x005a), top: B:74:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0188 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:8:0x0029, B:15:0x004e, B:49:0x0147, B:51:0x014d, B:54:0x0188, B:56:0x018c, B:57:0x0194, B:59:0x0198, B:60:0x01a0, B:62:0x01a4, B:68:0x01c3, B:69:0x01c8, B:16:0x0053, B:22:0x0076, B:23:0x008a, B:25:0x0090, B:29:0x00a3, B:31:0x00a7, B:33:0x00b0, B:34:0x00bf, B:36:0x00c5, B:37:0x00d3, B:39:0x00dd, B:40:0x00f2, B:42:0x0112, B:45:0x011e, B:44:0x0118, B:19:0x005a), top: B:74:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.express.orchestrator.ExpressOrchestrator$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
