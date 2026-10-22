package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowPermissionIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowPermissionIDLStubWrapper>> f16225a = null;

    public static final IFlowPermissionIDL a(d.m.c<IFlowPermissionIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowPermissionIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowPermissionIDL.class), IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IFlowPermissionIDL a(IFlowPermissionIDL r1, boolean r2, int r3, Object r4) {
        IFlowPermissionIDL r5 = (IFlowPermissionIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowPermissionIDL a(IFlowPermissionIDL r8, boolean r9) {
        IFlowPermissionIDL r10 = (IFlowPermissionIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowPermissionIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowPermissionIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowPermissionIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
        return r11;
    }

    static {
        f16225a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowPermissionIDL b(IFlowPermissionIDL r3, boolean r4) {
        IFlowPermissionIDL r5 = (IFlowPermissionIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowPermissionIDLIpcWrapper.class) == false) goto L7;
        return (IFlowPermissionIDL) ZeusTransformUtils.preCheckCast(new FlowPermissionIDLIpcWrapper(((FlowPermissionIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowPermissionIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowPermissionIDL) ZeusTransformUtils.preCheckCast(new FlowPermissionIDLIpcWrapper(r5, r4), IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
    }
}
