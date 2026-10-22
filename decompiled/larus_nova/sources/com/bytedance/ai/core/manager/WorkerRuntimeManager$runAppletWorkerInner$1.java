package com.bytedance.ai.core.manager;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager", f = "WorkerRuntimeManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {184}, m = "runAppletWorkerInner", n = {IFlowAppIntentIDL.PARAM_APPLET_ID, "application", "conversationId", "botId", RemoteMessageConst.MSGID, "replyFor", InteractConst.WAKEUP_SESSION_TYPE, "traceInfo", "runtime", "traceId", "eventType", DyPayConstant.KEY_START_TIME, "loadStartTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "J$1"})
final class WorkerRuntimeManager$runAppletWorkerInner$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkerRuntimeManager this$0;

    public WorkerRuntimeManager$runAppletWorkerInner$1(WorkerRuntimeManager r100, Continuation<? super WorkerRuntimeManager$runAppletWorkerInner$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return WorkerRuntimeManager.a(this.this$0, null, null, null, null, null, null, null, null, this);
    }
}
