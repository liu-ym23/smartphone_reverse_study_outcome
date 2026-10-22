package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowVoiceInteractionIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowVoiceInteractionIDLStubWrapper>> f16234a = null;

    public static final IFlowVoiceInteractionIDL a(d.m.c<IFlowVoiceInteractionIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowVoiceInteractionIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowVoiceInteractionIDL.class), IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IFlowVoiceInteractionIDL a(IFlowVoiceInteractionIDL r1, boolean r2, int r3, Object r4) {
        IFlowVoiceInteractionIDL r5 = (IFlowVoiceInteractionIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowVoiceInteractionIDL a(IFlowVoiceInteractionIDL r8, boolean r9) {
        IFlowVoiceInteractionIDL r10 = (IFlowVoiceInteractionIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowVoiceInteractionIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowVoiceInteractionIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowVoiceInteractionIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
        return r11;
    }

    static {
        f16234a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowVoiceInteractionIDL b(IFlowVoiceInteractionIDL r3, boolean r4) {
        IFlowVoiceInteractionIDL r5 = (IFlowVoiceInteractionIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowVoiceInteractionIDLIpcWrapper.class) == false) goto L7;
        return (IFlowVoiceInteractionIDL) ZeusTransformUtils.preCheckCast(new FlowVoiceInteractionIDLIpcWrapper(((FlowVoiceInteractionIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowVoiceInteractionIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowVoiceInteractionIDL) ZeusTransformUtils.preCheckCast(new FlowVoiceInteractionIDLIpcWrapper(r5, r4), IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
    }
}
