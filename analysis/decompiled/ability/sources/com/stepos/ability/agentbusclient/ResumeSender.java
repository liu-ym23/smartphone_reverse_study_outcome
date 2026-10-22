package com.stepos.ability.agentbusclient;

import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\f\u001a\u00020\u000b2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/ability/agentbusclient/ResumeSender;", "", "Lcom/stepos/ability/agentbusclient/AwaitReq;", "awaitReq", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/agentbusclient/AwaitReq;)V", "", "", "params", "", "attempts", "LC7/r;", "publish", "(Ljava/util/Map;ILH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/agentbusclient/AwaitReq;", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResumeSender {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_ATTEMPTS = 4;
    private static final String METHOD = "stepclaw.approvals.resolve";
    private static final String TAG = "ResumeSender";
    private final AwaitReq awaitReq;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/ability/agentbusclient/ResumeSender$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "METHOD", "MAX_ATTEMPTS", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @c(c = "com.stepos.ability.agentbusclient.ResumeSender", f = "ResumeSender.kt", l = {23}, m = "publish", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.agentbusclient.ResumeSender$publish$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResumeSender.this.publish(null, 0, this);
        }
    }

    public ResumeSender(AwaitReq awaitReq) {
        k.f(awaitReq, "awaitReq");
        this.awaitReq = awaitReq;
    }

    public static /* synthetic */ Object publish$default(ResumeSender resumeSender, Map map, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 4;
        }
        return resumeSender.publish(map, i, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0077 -> B:25:0x007d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object publish(java.util.Map<java.lang.String, ? extends java.lang.Object> r11, int r12, H7.c<? super C7.r> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.ability.agentbusclient.ResumeSender.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.ability.agentbusclient.ResumeSender$publish$1 r0 = (com.stepos.ability.agentbusclient.ResumeSender.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ability.agentbusclient.ResumeSender$publish$1 r0 = new com.stepos.ability.agentbusclient.ResumeSender$publish$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            C7.r r3 = C7.r.f317a
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 != r5) goto L3f
            int r11 = r0.I$2
            int r12 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref$ObjectRef) r6
            java.lang.Object r7 = r0.L$0
            java.util.Map r7 = (java.util.Map) r7
            kotlin.b.b(r13)     // Catch: java.lang.Throwable -> L38 java.util.concurrent.CancellationException -> L85
            return r3
        L38:
            r13 = move-exception
            r9 = r0
            r0 = r12
            r12 = r7
            r7 = r6
            r6 = r9
            goto L7d
        L3f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L47:
            kotlin.b.b(r13)
            r13 = 4
            int r13 = g1.AbstractC1451a.u(r12, r5, r13)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r6 = r2
            r2 = r0
            r0 = r12
            r12 = r11
            r11 = r4
        L59:
            if (r11 >= r13) goto L87
            com.stepos.ability.agentbusclient.AwaitReq r7 = r10.awaitReq     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            java.lang.String r8 = "stepclaw.approvals.resolve"
            r2.L$0 = r12     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            r2.L$1 = r6     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            r2.I$0 = r0     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            r2.I$1 = r13     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            r2.I$2 = r11     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            r2.I$3 = r11     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            r2.I$4 = r4     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            r2.label = r5     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            java.lang.Object r10 = r7.invoke(r8, r12, r2)     // Catch: java.lang.Throwable -> L76 java.util.concurrent.CancellationException -> L85
            if (r10 != r1) goto Lb1
            return r1
        L76:
            r7 = move-exception
            r9 = r0
            r0 = r13
            r13 = r7
            r7 = r6
            r6 = r2
            r2 = r9
        L7d:
            r7.f4920a = r13
            int r11 = r11 + r5
            r13 = r0
            r0 = r2
            r2 = r6
            r6 = r7
            goto L59
        L85:
            r10 = move-exception
            throw r10
        L87:
            java.lang.String r10 = "ResumeSender"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r11.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r12 = "resume publish failed after "
            r11.append(r12)     // Catch: java.lang.Throwable -> Lad
            r11.append(r13)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r12 = " attempts"
            r11.append(r12)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> Lad
            java.lang.Object r12 = r6.f4920a     // Catch: java.lang.Throwable -> Lad
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch: java.lang.Throwable -> Lad
            int r10 = android.util.Log.w(r10, r11, r12)     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r11 = new java.lang.Integer     // Catch: java.lang.Throwable -> Lad
            r11.<init>(r10)     // Catch: java.lang.Throwable -> Lad
            goto Lb1
        Lad:
            r10 = move-exception
            kotlin.b.a(r10)
        Lb1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.ResumeSender.publish(java.util.Map, int, H7.c):java.lang.Object");
    }
}
