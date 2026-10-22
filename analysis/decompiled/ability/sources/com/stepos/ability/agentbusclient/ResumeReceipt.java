package com.stepos.ability.agentbusclient;

import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u009c\u0001\u0010\u0014\u001a\u00020\b26\u0010\u000e\u001a2\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2*\u0010\u0010\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ability/agentbusclient/ResumeReceipt;", "", AppAgent.CONSTRUCT, "()V", "Lorg/json/JSONObject;", "res", "", "reqId", "LC7/r;", "requireOk", "(Lorg/json/JSONObject;Ljava/lang/String;)V", "Lkotlin/Function3;", "", "LH7/c;", "sendReq", "", "awaitResponse", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "params", "timeoutMs", "await", "(LS7/o;LS7/o;Ljava/lang/String;Ljava/util/Map;JLH7/c;)Ljava/lang/Object;", "TIMEOUT_MS", "J", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResumeReceipt {
    public static final ResumeReceipt INSTANCE = new ResumeReceipt();
    public static final long TIMEOUT_MS = 60000;

    @c(c = "com.stepos.ability.agentbusclient.ResumeReceipt", f = "ResumeReceipt.kt", l = {36, 37}, m = "await", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.agentbusclient.ResumeReceipt$await$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResumeReceipt.this.await(null, null, null, null, 0L, this);
        }
    }

    private ResumeReceipt() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0094, code lost:
    
        if (r13 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object await(S7.o r7, S7.o r8, java.lang.String r9, java.util.Map<java.lang.String, ? extends java.lang.Object> r10, long r11, H7.c<? super C7.r> r13) {
        /*
            r6 = this;
            boolean r0 = r13 instanceof com.stepos.ability.agentbusclient.ResumeReceipt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.ability.agentbusclient.ResumeReceipt$await$1 r0 = (com.stepos.ability.agentbusclient.ResumeReceipt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ability.agentbusclient.ResumeReceipt$await$1 r0 = new com.stepos.ability.agentbusclient.ResumeReceipt$await$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L62
            if (r2 == r4) goto L4b
            if (r2 != r3) goto L43
            java.lang.Object r6 = r0.L$5
            com.stepos.ability.agentbusclient.ResumeReceipt r6 = (com.stepos.ability.agentbusclient.ResumeReceipt) r6
            java.lang.Object r7 = r0.L$4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$3
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r8 = r0.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$1
            S7.o r8 = (S7.o) r8
            java.lang.Object r8 = r0.L$0
            S7.o r8 = (S7.o) r8
            kotlin.b.b(r13)
            goto L97
        L43:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L4b:
            long r11 = r0.J$0
            java.lang.Object r7 = r0.L$3
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            r8 = r7
            S7.o r8 = (S7.o) r8
            java.lang.Object r7 = r0.L$0
            S7.o r7 = (S7.o) r7
            kotlin.b.b(r13)
            goto L78
        L62:
            kotlin.b.b(r13)
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r5
            r0.L$3 = r5
            r0.J$0 = r11
            r0.label = r4
            java.lang.Object r13 = r7.invoke(r9, r10, r0)
            if (r13 != r1) goto L78
            goto L96
        L78:
            r7 = r13
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Long r9 = new java.lang.Long
            r9.<init>(r11)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.L$3 = r5
            r0.L$4 = r7
            r0.L$5 = r6
            r0.J$0 = r11
            r0.label = r3
            java.lang.Object r13 = r8.invoke(r7, r9, r0)
            if (r13 != r1) goto L97
        L96:
            return r1
        L97:
            org.json.JSONObject r13 = (org.json.JSONObject) r13
            r6.requireOk(r13, r7)
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.ResumeReceipt.await(S7.o, S7.o, java.lang.String, java.util.Map, long, H7.c):java.lang.Object");
    }

    public final void requireOk(JSONObject res, String reqId) {
        JSONObject jSONObjectOptJSONObject;
        k.f(reqId, "reqId");
        if (res == null) {
            throw new IllegalStateException("resume await timeout reqId=".concat(reqId).toString());
        }
        if (res.optBoolean("ok", false)) {
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = res.optJSONObject("payload");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("error")) == null) {
            jSONObjectOptJSONObject = res.optJSONObject("error");
        }
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("code") : null;
        if (strOptString == null) {
            strOptString = "";
        }
        String strOptString2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("message") : null;
        String str = strOptString2 != null ? strOptString2 : "";
        StringBuilder sbW = B7.a.w("resume rejected reqId=", reqId, " code=", strOptString, " message=");
        sbW.append(str);
        throw new IllegalStateException(sbW.toString().toString());
    }
}
