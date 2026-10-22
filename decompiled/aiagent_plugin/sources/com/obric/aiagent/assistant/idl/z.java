package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowFeedbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowFeedbackIDLStubWrapper>> f16297a = null;

    public static final IFlowFeedbackIDL a(d.m.c<IFlowFeedbackIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowFeedbackIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowFeedbackIDL.class), IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IFlowFeedbackIDL a(IFlowFeedbackIDL r1, boolean r2, int r3, Object r4) {
        IFlowFeedbackIDL r5 = (IFlowFeedbackIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowFeedbackIDL a(IFlowFeedbackIDL r8, boolean r9) {
        IFlowFeedbackIDL r10 = (IFlowFeedbackIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowFeedbackIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowFeedbackIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowFeedbackIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
        return r11;
    }

    static {
        f16297a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowFeedbackIDL b(IFlowFeedbackIDL r3, boolean r4) {
        IFlowFeedbackIDL r5 = (IFlowFeedbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowFeedbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowFeedbackIDL) ZeusTransformUtils.preCheckCast(new FlowFeedbackIDLIpcWrapper(((FlowFeedbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowFeedbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowFeedbackIDL) ZeusTransformUtils.preCheckCast(new FlowFeedbackIDLIpcWrapper(r5, r4), IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
    }
}
