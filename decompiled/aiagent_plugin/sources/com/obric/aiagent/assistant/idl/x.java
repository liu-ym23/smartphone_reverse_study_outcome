package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowCocreationReviewIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowCocreationReviewIDLStubWrapper>> f16295a = null;

    public static final IFlowCocreationReviewIDL a(d.m.c<IFlowCocreationReviewIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowCocreationReviewIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowCocreationReviewIDL.class), IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IFlowCocreationReviewIDL a(IFlowCocreationReviewIDL r1, boolean r2, int r3, Object r4) {
        IFlowCocreationReviewIDL r5 = (IFlowCocreationReviewIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowCocreationReviewIDL a(IFlowCocreationReviewIDL r8, boolean r9) {
        IFlowCocreationReviewIDL r10 = (IFlowCocreationReviewIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowCocreationReviewIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowCocreationReviewIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowCocreationReviewIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
        return r11;
    }

    static {
        f16295a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowCocreationReviewIDL b(IFlowCocreationReviewIDL r3, boolean r4) {
        IFlowCocreationReviewIDL r5 = (IFlowCocreationReviewIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowCocreationReviewIDLIpcWrapper.class) == false) goto L7;
        return (IFlowCocreationReviewIDL) ZeusTransformUtils.preCheckCast(new FlowCocreationReviewIDLIpcWrapper(((FlowCocreationReviewIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowCocreationReviewIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowCocreationReviewIDL) ZeusTransformUtils.preCheckCast(new FlowCocreationReviewIDLIpcWrapper(r5, r4), IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
    }
}
