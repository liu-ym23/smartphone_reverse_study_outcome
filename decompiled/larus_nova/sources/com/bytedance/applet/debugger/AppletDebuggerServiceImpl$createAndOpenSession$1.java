package com.bytedance.applet.debugger;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerServiceImpl", f = "AppletDebuggerServiceImpl.kt", i = {0, 0, 1}, l = {45, 66, 79}, m = "createAndOpenSession", n = {PerfLog.PARAM_KEY_CONTEXT_ID, RemoteMessageConst.MessageBody.MSG_CONTENT, "result"}, s = {"L$0", "L$1", "L$0"})
public final class AppletDebuggerServiceImpl$createAndOpenSession$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDebuggerServiceImpl this$0;

    public AppletDebuggerServiceImpl$createAndOpenSession$1(AppletDebuggerServiceImpl r100, Continuation<? super AppletDebuggerServiceImpl$createAndOpenSession$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, null, this);
    }
}
