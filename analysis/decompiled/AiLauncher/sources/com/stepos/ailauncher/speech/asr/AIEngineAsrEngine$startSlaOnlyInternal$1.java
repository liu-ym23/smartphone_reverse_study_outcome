package com.stepos.ailauncher.speech.asr;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$startSlaOnlyInternal$1", f = "AIEngineAsrEngine.kt", l = {428}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineAsrEngine$startSlaOnlyInternal$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ AsrCallback $callback;
    final /* synthetic */ h $mode;
    final /* synthetic */ long $sessionId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIEngineAsrEngine this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$startSlaOnlyInternal$1$1", f = "AIEngineAsrEngine.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$startSlaOnlyInternal$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ AsrCallback $callback;
        final /* synthetic */ Exception $e;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AsrCallback asrCallback, Exception exc, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$callback = asrCallback;
            this.$e = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$callback, this.$e, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            AsrCallback asrCallback = this.$callback;
            String message = this.$e.getMessage();
            if (message == null) {
                message = "recording failed";
            }
            asrCallback.onError(-1, message);
            this.$callback.onRecordingStopped();
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineAsrEngine$startSlaOnlyInternal$1(AIEngineAsrEngine aIEngineAsrEngine, AsrCallback asrCallback, long j10, h hVar, InterfaceC4014c<? super AIEngineAsrEngine$startSlaOnlyInternal$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aIEngineAsrEngine;
        this.$callback = asrCallback;
        this.$sessionId = j10;
        this.$mode = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AIEngineAsrEngine$startSlaOnlyInternal$1 aIEngineAsrEngine$startSlaOnlyInternal$1 = new AIEngineAsrEngine$startSlaOnlyInternal$1(this.this$0, this.$callback, this.$sessionId, this.$mode, interfaceC4014c);
        aIEngineAsrEngine$startSlaOnlyInternal$1.L$0 = obj;
        return aIEngineAsrEngine$startSlaOnlyInternal$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineAsrEngine$startSlaOnlyInternal$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            java.lang.Object r0 = r14.L$0
            r1 = r0
            Ua.M r1 = (Ua.M) r1
            java.lang.Object r0 = f9.C4063a.g()
            int r2 = r14.label
            r3 = 1
            if (r2 == 0) goto L22
            if (r2 != r3) goto L1a
            kotlin.C4849c.b(r15)     // Catch: java.lang.Exception -> L15
            goto L9e
        L15:
            r0 = move-exception
            r15 = r0
            r7 = r14
        L18:
            r4 = r15
            goto L40
        L1a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L22:
            kotlin.C4849c.b(r15)
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine r2 = r14.this$0     // Catch: java.lang.Exception -> L3d
            r15 = r3
            com.stepos.ailauncher.contract.api.speech.AsrCallback r3 = r14.$callback     // Catch: java.lang.Exception -> L3d
            long r4 = r14.$sessionId     // Catch: java.lang.Exception -> L3d
            com.stepos.ailauncher.speech.asr.h r6 = r14.$mode     // Catch: java.lang.Exception -> L3d
            r14.L$0 = r1     // Catch: java.lang.Exception -> L3d
            r14.label = r15     // Catch: java.lang.Exception -> L3d
            r7 = r14
            java.lang.Object r14 = com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.k(r2, r3, r4, r6, r7)     // Catch: java.lang.Exception -> L3a
            if (r14 != r0) goto L9e
            return r0
        L3a:
            r0 = move-exception
        L3b:
            r15 = r0
            goto L18
        L3d:
            r0 = move-exception
            r7 = r14
            goto L3b
        L40:
            long r14 = r7.$sessionId
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine r0 = r7.this$0
            java.util.concurrent.atomic.AtomicLong r0 = com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.s(r0)
            long r2 = r0.get()
            int r14 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r14 == 0) goto L75
            long r14 = r7.$sessionId
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "sla-only recording failed on stale session="
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = ", ignore"
            r0.append(r14)
            java.lang.String r3 = r0.toString()
            r6 = 8
            r7 = 0
            java.lang.String r2 = "AIEngineAsr"
            r5 = 0
            h8.C4148a.t(r2, r3, r4, r5, r6, r7)
            Y8.t r14 = Y8.t.f7040a
            return r14
        L75:
            r12 = 8
            r13 = 0
            java.lang.String r8 = "AIEngineAsr"
            java.lang.String r9 = "sla-only recording failed"
            r11 = 0
            r10 = r4
            h8.C4148a.g(r8, r9, r10, r11, r12, r13)
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine r14 = r7.this$0
            java.util.concurrent.atomic.AtomicBoolean r14 = com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.u(r14)
            r15 = 0
            r14.set(r15)
            Ua.A0 r2 = Ua.Y.c()
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$startSlaOnlyInternal$1$1 r4 = new com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$startSlaOnlyInternal$1$1
            com.stepos.ailauncher.contract.api.speech.AsrCallback r14 = r7.$callback
            r15 = 0
            r4.<init>(r14, r10, r15)
            r5 = 2
            r6 = 0
            r3 = 0
            Ua.C1056g.d(r1, r2, r3, r4, r5, r6)
        L9e:
            Y8.t r14 = Y8.t.f7040a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$startSlaOnlyInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
