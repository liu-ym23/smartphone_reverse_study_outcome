package stepai.aios.guiagent.tracer.remote;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$2", f = "GuiAgentTraceManager.kt", l = {69, 76, 98}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Result;", "", "<anonymous>", "(Lm9/z;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
public final class GuiAgentTraceManager$postExecution$2 extends SuspendLambda implements n {
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ Map<String, Object> $metadata;
    final /* synthetic */ k $onProgress;
    final /* synthetic */ String $taskId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiAgentTraceManager$postExecution$2(Map<String, ? extends Object> map, String str, k kVar, Map<String, String> map2, H7.c<? super GuiAgentTraceManager$postExecution$2> cVar) {
        super(2, cVar);
        this.$metadata = map;
        this.$taskId = str;
        this.$onProgress = kVar;
        this.$headers = map2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        GuiAgentTraceManager$postExecution$2 guiAgentTraceManager$postExecution$2 = new GuiAgentTraceManager$postExecution$2(this.$metadata, this.$taskId, this.$onProgress, this.$headers, cVar);
        guiAgentTraceManager$postExecution$2.L$0 = obj;
        return guiAgentTraceManager$postExecution$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0220, code lost:
    
        if (r0 != r8) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c5 A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:8:0x0033, B:75:0x0223, B:77:0x022b, B:79:0x0231, B:82:0x0238, B:83:0x0257, B:86:0x0276, B:87:0x0279, B:13:0x0066, B:60:0x01b5, B:62:0x01c5, B:65:0x01d2, B:68:0x01df, B:69:0x01e4, B:71:0x01f8, B:72:0x01fd, B:16:0x0096, B:53:0x0179, B:55:0x0186, B:56:0x018b, B:20:0x00ae, B:23:0x00b8, B:26:0x00d7, B:27:0x00dc, B:29:0x00e4, B:32:0x00ee, B:35:0x00fc, B:37:0x0102, B:40:0x0113, B:42:0x0119, B:44:0x0121, B:46:0x0127, B:49:0x012e, B:88:0x027a, B:89:0x0281), top: B:94:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d2 A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:8:0x0033, B:75:0x0223, B:77:0x022b, B:79:0x0231, B:82:0x0238, B:83:0x0257, B:86:0x0276, B:87:0x0279, B:13:0x0066, B:60:0x01b5, B:62:0x01c5, B:65:0x01d2, B:68:0x01df, B:69:0x01e4, B:71:0x01f8, B:72:0x01fd, B:16:0x0096, B:53:0x0179, B:55:0x0186, B:56:0x018b, B:20:0x00ae, B:23:0x00b8, B:26:0x00d7, B:27:0x00dc, B:29:0x00e4, B:32:0x00ee, B:35:0x00fc, B:37:0x0102, B:40:0x0113, B:42:0x0119, B:44:0x0121, B:46:0x0127, B:49:0x012e, B:88:0x027a, B:89:0x0281), top: B:94:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01df A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:8:0x0033, B:75:0x0223, B:77:0x022b, B:79:0x0231, B:82:0x0238, B:83:0x0257, B:86:0x0276, B:87:0x0279, B:13:0x0066, B:60:0x01b5, B:62:0x01c5, B:65:0x01d2, B:68:0x01df, B:69:0x01e4, B:71:0x01f8, B:72:0x01fd, B:16:0x0096, B:53:0x0179, B:55:0x0186, B:56:0x018b, B:20:0x00ae, B:23:0x00b8, B:26:0x00d7, B:27:0x00dc, B:29:0x00e4, B:32:0x00ee, B:35:0x00fc, B:37:0x0102, B:40:0x0113, B:42:0x0119, B:44:0x0121, B:46:0x0127, B:49:0x012e, B:88:0x027a, B:89:0x0281), top: B:94:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f8 A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:8:0x0033, B:75:0x0223, B:77:0x022b, B:79:0x0231, B:82:0x0238, B:83:0x0257, B:86:0x0276, B:87:0x0279, B:13:0x0066, B:60:0x01b5, B:62:0x01c5, B:65:0x01d2, B:68:0x01df, B:69:0x01e4, B:71:0x01f8, B:72:0x01fd, B:16:0x0096, B:53:0x0179, B:55:0x0186, B:56:0x018b, B:20:0x00ae, B:23:0x00b8, B:26:0x00d7, B:27:0x00dc, B:29:0x00e4, B:32:0x00ee, B:35:0x00fc, B:37:0x0102, B:40:0x0113, B:42:0x0119, B:44:0x0121, B:46:0x0127, B:49:0x012e, B:88:0x027a, B:89:0x0281), top: B:94:0x0017 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Result<String>> cVar) {
        return ((GuiAgentTraceManager$postExecution$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
