package com.stepos.ailauncher.speech.asr;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$launchRecordSession$1", f = "AIEngineAsrEngine.kt", l = {1957, 1966}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineAsrEngine$launchRecordSession$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ p<M, InterfaceC4014c<? super t>, Object> $block;
    final /* synthetic */ int $launchId;
    final /* synthetic */ boolean $needHandoff;
    final /* synthetic */ kotlinx.coroutines.g $previous;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIEngineAsrEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AIEngineAsrEngine$launchRecordSession$1(boolean z10, kotlinx.coroutines.g gVar, p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, AIEngineAsrEngine aIEngineAsrEngine, int i10, InterfaceC4014c<? super AIEngineAsrEngine$launchRecordSession$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$needHandoff = z10;
        this.$previous = gVar;
        this.$block = pVar;
        this.this$0 = aIEngineAsrEngine;
        this.$launchId = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AIEngineAsrEngine$launchRecordSession$1 aIEngineAsrEngine$launchRecordSession$1 = new AIEngineAsrEngine$launchRecordSession$1(this.$needHandoff, this.$previous, this.$block, this.this$0, this.$launchId, interfaceC4014c);
        aIEngineAsrEngine$launchRecordSession$1.L$0 = obj;
        return aIEngineAsrEngine$launchRecordSession$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineAsrEngine$launchRecordSession$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        if (r10.invoke(r0, r9) != r1) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = r9.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r9.label
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L26
            if (r2 == r5) goto L22
            if (r2 != r3) goto L1a
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L18
            goto L65
        L18:
            r10 = move-exception
            goto L7b
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L22:
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L18
            goto L48
        L26:
            kotlin.C4849c.b(r10)
            boolean r10 = r9.$needHandoff     // Catch: java.lang.Throwable -> L18
            if (r10 == 0) goto L54
            kotlinx.coroutines.g r10 = r9.$previous     // Catch: java.lang.Throwable -> L18
            if (r10 == 0) goto L54
            kotlinx.coroutines.g.Y0(r10, r6, r5, r6)     // Catch: java.lang.Throwable -> L18
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$launchRecordSession$1$joined$1 r10 = new com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$launchRecordSession$1$joined$1     // Catch: java.lang.Throwable -> L18
            kotlinx.coroutines.g r2 = r9.$previous     // Catch: java.lang.Throwable -> L18
            r10.<init>(r2, r6)     // Catch: java.lang.Throwable -> L18
            r9.L$0 = r0     // Catch: java.lang.Throwable -> L18
            r9.label = r5     // Catch: java.lang.Throwable -> L18
            r7 = 400(0x190, double:1.976E-321)
            java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.e(r7, r10, r9)     // Catch: java.lang.Throwable -> L18
            if (r10 != r1) goto L48
            goto L64
        L48:
            Y8.t r10 = (Y8.t) r10     // Catch: java.lang.Throwable -> L18
            if (r10 != 0) goto L54
            java.lang.String r10 = "AIEngineAsr"
            java.lang.String r2 = "AIOSBUG-17956: previous recordJob still running after 400ms, open a new AudioRecord"
            r5 = 4
            h8.C4148a.u(r10, r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L18
        L54:
            p9.p<Ua.M, e9.c<? super Y8.t>, java.lang.Object> r10 = r9.$block     // Catch: java.lang.Throwable -> L18
            java.lang.Object r2 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L18
            r9.L$0 = r2     // Catch: java.lang.Throwable -> L18
            r9.label = r3     // Catch: java.lang.Throwable -> L18
            java.lang.Object r10 = r10.invoke(r0, r9)     // Catch: java.lang.Throwable -> L18
            if (r10 != r1) goto L65
        L64:
            return r1
        L65:
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine r10 = r9.this$0
            java.util.concurrent.atomic.AtomicInteger r10 = com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.r(r10)
            int r10 = r10.get()
            int r0 = r9.$launchId
            if (r10 != r0) goto L78
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine r9 = r9.this$0
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.y(r9, r4)
        L78:
            Y8.t r9 = Y8.t.f7040a
            return r9
        L7b:
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine r0 = r9.this$0
            java.util.concurrent.atomic.AtomicInteger r0 = com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.r(r0)
            int r0 = r0.get()
            int r1 = r9.$launchId
            if (r0 != r1) goto L8e
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine r9 = r9.this$0
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.y(r9, r4)
        L8e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$launchRecordSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
