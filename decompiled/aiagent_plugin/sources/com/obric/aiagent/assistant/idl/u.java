package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowAssistantStateIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowAssistantStateIDLStubWrapper>> f16291a = null;

    /* JADX INFO: compiled from: FlowAssistantStateIDLExt.kt */
    public static final class a implements com.obric.aiagent.ipc.utils.i.b<IFlowAssistantStateIDL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.ipc.utils.i.b<IFlowAssistantStateIDL> f16292a;

        a(com.obric.aiagent.ipc.utils.i.b<IFlowAssistantStateIDL> r3) {
            this.f16292a = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.ipc.utils.i.b
        public /* synthetic */ void onRegister(IFlowAssistantStateIDL r3) {
            a((IFlowAssistantStateIDL) ZeusTransformUtils.preCheckCast(r3, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin"));
        }

        public void a(IFlowAssistantStateIDL r5) {
            IFlowAssistantStateIDL r6 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "inst");
            com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAssistantStateIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"));
            this.f16292a.onRegister(r6);
        }
    }

    public static final IFlowAssistantStateIDL a(d.m.c<IFlowAssistantStateIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowAssistantStateIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAssistantStateIDL.class), IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IFlowAssistantStateIDL a(IFlowAssistantStateIDL r1, boolean r2, int r3, Object r4) {
        IFlowAssistantStateIDL r5 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowAssistantStateIDL a(IFlowAssistantStateIDL r8, boolean r9) {
        IFlowAssistantStateIDL r10 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowAssistantStateIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowAssistantStateIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAssistantStateIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
        return r11;
    }

    public static /* synthetic */ void a(d.m.c r1, boolean r2, boolean r3, com.obric.aiagent.ipc.utils.i.b r4, int r5, Object r6) {
        d.m.c r7 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r1, d.m.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.ipc.utils.i.b r8 = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = false;
    L8:
        a(r7, r2, r3, r8);
    }

    public static final void a(d.m.c<IFlowAssistantStateIDL> r2, boolean r3, boolean r4, com.obric.aiagent.ipc.utils.i.b<IFlowAssistantStateIDL> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.ipc.utils.i.b r7 = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "action");
        if (r4 == false) goto L5;
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAssistantStateIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(new a(r7), com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"), r3);
        return;
    L5:
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAssistantStateIDL.class, r7, r3);
    }

    static {
        f16291a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowAssistantStateIDL b(IFlowAssistantStateIDL r3, boolean r4) {
        IFlowAssistantStateIDL r5 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowAssistantStateIDLIpcWrapper.class) == false) goto L7;
        return (IFlowAssistantStateIDL) ZeusTransformUtils.preCheckCast(new FlowAssistantStateIDLIpcWrapper(((FlowAssistantStateIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAssistantStateIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowAssistantStateIDL) ZeusTransformUtils.preCheckCast(new FlowAssistantStateIDLIpcWrapper(r5, r4), IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
    }
}
