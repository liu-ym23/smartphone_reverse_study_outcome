package com.stepos.ability.agentbusclient;

import C7.r;
import J7.c;
import S7.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import w9.e;

@c(c = "com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$job$1", f = "AbilityAgentBusNodeAgentBusBinding.kt", l = {200, 205, 208, 210, 213, 216}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$job$1 extends SuspendLambda implements n {
    final /* synthetic */ String $command;
    final /* synthetic */ String $invocationId;
    final /* synthetic */ String $nodeIdStr;
    final /* synthetic */ Map<String, Object> $paramsMap;
    final /* synthetic */ e $sem;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AbilityAgentBusNodeAgentBusBinding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$job$1(AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding, String str, String str2, String str3, Map<String, ? extends Object> map, e eVar, H7.c<? super AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$job$1> cVar) {
        super(2, cVar);
        this.this$0 = abilityAgentBusNodeAgentBusBinding;
        this.$command = str;
        this.$invocationId = str2;
        this.$nodeIdStr = str3;
        this.$paramsMap = map;
        this.$sem = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$job$1(this.this$0, this.$command, this.$invocationId, this.$nodeIdStr, this.$paramsMap, this.$sem, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
    
        if (r11 == r1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0161, code lost:
    
        if (r5.sendInvokeError(r6, r7, r8, r11, r10) == r1) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a9, code lost:
    
        if (r4.sendInvokeError(r5, r6, "STEPCLAW_INTERNAL", r8, r9) == r1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ea, code lost:
    
        if (r4.sendInvokeError(r5, r6, "STEPCLAW_INVOKE_CANCELLED", r12, r9) != r1) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0113 A[Catch: all -> 0x0132, CancellationException -> 0x0136, TryCatch #1 {all -> 0x0132, blocks: (B:55:0x0109, B:57:0x0113, B:64:0x013a, B:51:0x00f8, B:52:0x00fa), top: B:106:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013a A[Catch: all -> 0x0132, CancellationException -> 0x0136, TRY_LEAVE, TryCatch #1 {all -> 0x0132, blocks: (B:55:0x0109, B:57:0x0113, B:64:0x013a, B:51:0x00f8, B:52:0x00fa), top: B:106:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017f A[Catch: all -> 0x0193, TRY_LEAVE, TryCatch #3 {all -> 0x0193, blocks: (B:101:0x01ed, B:74:0x016b, B:76:0x017f, B:78:0x0189, B:86:0x019a, B:95:0x01c4, B:98:0x01da, B:50:0x00e7), top: B:112:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$job$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
