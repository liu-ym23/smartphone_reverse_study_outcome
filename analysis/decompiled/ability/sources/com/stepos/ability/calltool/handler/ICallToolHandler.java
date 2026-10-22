package com.stepos.ability.calltool.handler;

import S7.k;
import com.stepos.ability.api.ability.calltool.CallToolRequest;
import com.stepos.ability.beaninternal.ability.FunctionCallResult;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H¦@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/calltool/handler/ICallToolHandler;", "", "Lcom/stepos/ability/api/ability/calltool/CallToolRequest;", "request", "Lkotlin/Function1;", "Lcom/stepos/ability/beaninternal/ability/ProgressNotification;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;", "Lcom/stepos/ability/beaninternal/ability/CallToolExeResult;", "handle", "(Lcom/stepos/ability/api/ability/calltool/CallToolRequest;LS7/k;LH7/c;)Ljava/lang/Object;", "calltool_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICallToolHandler {
    static /* synthetic */ Object handle$default(ICallToolHandler iCallToolHandler, CallToolRequest callToolRequest, k kVar, H7.c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handle");
        }
        if ((i & 2) != 0) {
            kVar = null;
        }
        return iCallToolHandler.handle(callToolRequest, kVar, cVar);
    }

    Object handle(CallToolRequest callToolRequest, k kVar, H7.c<? super FunctionCallResult> cVar);
}
