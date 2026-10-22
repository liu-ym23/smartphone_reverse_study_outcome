package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowFrontierIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowFrontierIDLStubWrapper>> f16209a = null;

    /* JADX INFO: compiled from: FlowFrontierIDLExt.kt */
    public static final class a implements com.obric.aiagent.ipc.utils.i.b<IFlowFrontierIDL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.ipc.utils.i.b<IFlowFrontierIDL> f16210a;

        a(com.obric.aiagent.ipc.utils.i.b<IFlowFrontierIDL> r3) {
            this.f16210a = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.ipc.utils.i.b
        public /* synthetic */ void onRegister(IFlowFrontierIDL r3) {
            a((IFlowFrontierIDL) ZeusTransformUtils.preCheckCast(r3, IFlowFrontierIDL.class, "com.obric.aiagent.plugin"));
        }

        public void a(IFlowFrontierIDL r5) {
            IFlowFrontierIDL r6 = (IFlowFrontierIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "inst");
            com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowFrontierIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"));
            this.f16210a.onRegister(r6);
        }
    }

    public static final IFlowFrontierIDL a(d.m.c<IFlowFrontierIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowFrontierIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowFrontierIDL.class), IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IFlowFrontierIDL a(IFlowFrontierIDL r1, boolean r2, int r3, Object r4) {
        IFlowFrontierIDL r5 = (IFlowFrontierIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowFrontierIDL a(IFlowFrontierIDL r8, boolean r9) {
        IFlowFrontierIDL r10 = (IFlowFrontierIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowFrontierIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowFrontierIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowFrontierIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
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

    public static final void a(d.m.c<IFlowFrontierIDL> r2, boolean r3, boolean r4, com.obric.aiagent.ipc.utils.i.b<IFlowFrontierIDL> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.ipc.utils.i.b r7 = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "action");
        if (r4 == false) goto L5;
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowFrontierIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(new a(r7), com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"), r3);
        return;
    L5:
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowFrontierIDL.class, r7, r3);
    }

    static {
        f16209a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowFrontierIDL b(IFlowFrontierIDL r3, boolean r4) {
        IFlowFrontierIDL r5 = (IFlowFrontierIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowFrontierIDLIpcWrapper.class) == false) goto L7;
        return (IFlowFrontierIDL) ZeusTransformUtils.preCheckCast(new FlowFrontierIDLIpcWrapper(((FlowFrontierIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowFrontierIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowFrontierIDL) ZeusTransformUtils.preCheckCast(new FlowFrontierIDLIpcWrapper(r5, r4), IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
    }
}
