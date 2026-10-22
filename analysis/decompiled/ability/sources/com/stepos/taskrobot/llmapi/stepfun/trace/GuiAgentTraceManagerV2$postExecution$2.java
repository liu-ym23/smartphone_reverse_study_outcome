package com.stepos.taskrobot.llmapi.stepfun.trace;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.material3.MenuKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$2", f = "GuiAgentTraceManagerV2.kt", l = {113, MenuKt.InTransitionDuration}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Result;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class GuiAgentTraceManagerV2$postExecution$2 extends SuspendLambda implements n {
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ Map<String, Object> $metadata;
    final /* synthetic */ k $onProgress;
    final /* synthetic */ String $subSessionId;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $traceId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiAgentTraceManagerV2$postExecution$2(Map<String, ? extends Object> map, String str, String str2, k kVar, Map<String, String> map2, String str3, H7.c<? super GuiAgentTraceManagerV2$postExecution$2> cVar) {
        super(2, cVar);
        this.$metadata = map;
        this.$taskId = str;
        this.$traceId = str2;
        this.$onProgress = kVar;
        this.$headers = map2;
        this.$subSessionId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        GuiAgentTraceManagerV2$postExecution$2 guiAgentTraceManagerV2$postExecution$2 = new GuiAgentTraceManagerV2$postExecution$2(this.$metadata, this.$taskId, this.$traceId, this.$onProgress, this.$headers, this.$subSessionId, cVar);
        guiAgentTraceManagerV2$postExecution$2.L$0 = obj;
        return guiAgentTraceManagerV2$postExecution$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x017f A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:7:0x0044, B:35:0x0170, B:37:0x017f, B:40:0x018a, B:43:0x0195, B:44:0x019a, B:46:0x01aa, B:48:0x01b2, B:51:0x01ba, B:53:0x01c0, B:56:0x01c8, B:59:0x01d6, B:62:0x01de, B:64:0x01ea, B:67:0x01f4, B:69:0x0212, B:71:0x021a, B:76:0x0226, B:66:0x01f0, B:14:0x0091, B:28:0x0128, B:30:0x0137, B:31:0x013c, B:17:0x00be, B:20:0x00c8, B:23:0x00f1, B:24:0x00f6, B:77:0x0311, B:78:0x0318), top: B:86:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018a A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:7:0x0044, B:35:0x0170, B:37:0x017f, B:40:0x018a, B:43:0x0195, B:44:0x019a, B:46:0x01aa, B:48:0x01b2, B:51:0x01ba, B:53:0x01c0, B:56:0x01c8, B:59:0x01d6, B:62:0x01de, B:64:0x01ea, B:67:0x01f4, B:69:0x0212, B:71:0x021a, B:76:0x0226, B:66:0x01f0, B:14:0x0091, B:28:0x0128, B:30:0x0137, B:31:0x013c, B:17:0x00be, B:20:0x00c8, B:23:0x00f1, B:24:0x00f6, B:77:0x0311, B:78:0x0318), top: B:86:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0195 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:7:0x0044, B:35:0x0170, B:37:0x017f, B:40:0x018a, B:43:0x0195, B:44:0x019a, B:46:0x01aa, B:48:0x01b2, B:51:0x01ba, B:53:0x01c0, B:56:0x01c8, B:59:0x01d6, B:62:0x01de, B:64:0x01ea, B:67:0x01f4, B:69:0x0212, B:71:0x021a, B:76:0x0226, B:66:0x01f0, B:14:0x0091, B:28:0x0128, B:30:0x0137, B:31:0x013c, B:17:0x00be, B:20:0x00c8, B:23:0x00f1, B:24:0x00f6, B:77:0x0311, B:78:0x0318), top: B:86:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f0 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:7:0x0044, B:35:0x0170, B:37:0x017f, B:40:0x018a, B:43:0x0195, B:44:0x019a, B:46:0x01aa, B:48:0x01b2, B:51:0x01ba, B:53:0x01c0, B:56:0x01c8, B:59:0x01d6, B:62:0x01de, B:64:0x01ea, B:67:0x01f4, B:69:0x0212, B:71:0x021a, B:76:0x0226, B:66:0x01f0, B:14:0x0091, B:28:0x0128, B:30:0x0137, B:31:0x013c, B:17:0x00be, B:20:0x00c8, B:23:0x00f1, B:24:0x00f6, B:77:0x0311, B:78:0x0318), top: B:86:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0329  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Result<r>> cVar) {
        return ((GuiAgentTraceManagerV2$postExecution$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
