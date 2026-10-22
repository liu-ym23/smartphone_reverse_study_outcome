package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowSettingsIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowSettingsIDLStubWrapper>> f16228a = null;

    /* JADX INFO: compiled from: FlowSettingsIDLExt.kt */
    public static final class a implements com.obric.aiagent.ipc.utils.i.b<IFlowSettingsIDL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.ipc.utils.i.b<IFlowSettingsIDL> f16229a;

        a(com.obric.aiagent.ipc.utils.i.b<IFlowSettingsIDL> r3) {
            this.f16229a = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.ipc.utils.i.b
        public /* synthetic */ void onRegister(IFlowSettingsIDL r3) {
            a((IFlowSettingsIDL) ZeusTransformUtils.preCheckCast(r3, IFlowSettingsIDL.class, "com.obric.aiagent.plugin"));
        }

        public void a(IFlowSettingsIDL r5) {
            IFlowSettingsIDL r6 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "inst");
            com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowSettingsIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"));
            this.f16229a.onRegister(r6);
        }
    }

    public static final IFlowSettingsIDL a(d.m.c<IFlowSettingsIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowSettingsIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowSettingsIDL.class), IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ IFlowSettingsIDL a(IFlowSettingsIDL r1, boolean r2, int r3, Object r4) {
        IFlowSettingsIDL r5 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowSettingsIDL a(IFlowSettingsIDL r8, boolean r9) {
        IFlowSettingsIDL r10 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowSettingsIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowSettingsIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowSettingsIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
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

    public static final void a(d.m.c<IFlowSettingsIDL> r2, boolean r3, boolean r4, com.obric.aiagent.ipc.utils.i.b<IFlowSettingsIDL> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.ipc.utils.i.b r7 = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "action");
        if (r4 == false) goto L5;
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowSettingsIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(new a(r7), com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"), r3);
        return;
    L5:
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowSettingsIDL.class, r7, r3);
    }

    static {
        f16228a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowSettingsIDL b(IFlowSettingsIDL r3, boolean r4) {
        IFlowSettingsIDL r5 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowSettingsIDLIpcWrapper.class) == false) goto L7;
        return (IFlowSettingsIDL) ZeusTransformUtils.preCheckCast(new FlowSettingsIDLIpcWrapper(((FlowSettingsIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowSettingsIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowSettingsIDL) ZeusTransformUtils.preCheckCast(new FlowSettingsIDLIpcWrapper(r5, r4), IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
    }
}
