package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowAppStateIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowAppStateIDLStubWrapper>> f16288a = null;

    /* JADX INFO: compiled from: FlowAppStateIDLExt.kt */
    public static final class a implements com.obric.aiagent.ipc.utils.i.b<IFlowAppStateIDL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.ipc.utils.i.b<IFlowAppStateIDL> f16289a;

        a(com.obric.aiagent.ipc.utils.i.b<IFlowAppStateIDL> r3) {
            this.f16289a = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.ipc.utils.i.b
        public /* synthetic */ void onRegister(IFlowAppStateIDL r3) {
            a((IFlowAppStateIDL) ZeusTransformUtils.preCheckCast(r3, IFlowAppStateIDL.class, "com.obric.aiagent.plugin"));
        }

        public void a(IFlowAppStateIDL r5) {
            IFlowAppStateIDL r6 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "inst");
            com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAppStateIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"));
            this.f16289a.onRegister(r6);
        }
    }

    public static final IFlowAppStateIDL a(d.m.c<IFlowAppStateIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowAppStateIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAppStateIDL.class), IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IFlowAppStateIDL a(IFlowAppStateIDL r1, boolean r2, int r3, Object r4) {
        IFlowAppStateIDL r5 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowAppStateIDL a(IFlowAppStateIDL r8, boolean r9) {
        IFlowAppStateIDL r10 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowAppStateIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowAppStateIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAppStateIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
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

    public static final void a(d.m.c<IFlowAppStateIDL> r2, boolean r3, boolean r4, com.obric.aiagent.ipc.utils.i.b<IFlowAppStateIDL> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.ipc.utils.i.b r7 = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "action");
        if (r4 == false) goto L5;
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAppStateIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(new a(r7), com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"), r3);
        return;
    L5:
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowAppStateIDL.class, r7, r3);
    }

    static {
        f16288a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowAppStateIDL b(IFlowAppStateIDL r3, boolean r4) {
        IFlowAppStateIDL r5 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowAppStateIDLIpcWrapper.class) == false) goto L7;
        return (IFlowAppStateIDL) ZeusTransformUtils.preCheckCast(new FlowAppStateIDLIpcWrapper(((FlowAppStateIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAppStateIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowAppStateIDL) ZeusTransformUtils.preCheckCast(new FlowAppStateIDLIpcWrapper(r5, r4), IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
    }
}
