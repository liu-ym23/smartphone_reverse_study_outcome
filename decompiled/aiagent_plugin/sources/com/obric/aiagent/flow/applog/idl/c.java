package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowAppLogIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowAppLogIDLStubWrapper>> f18590a = null;

    /* JADX INFO: compiled from: FlowAppLogIDLExt.kt */
    public static final class a implements i.b<IFlowAppLogIDL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b<IFlowAppLogIDL> f18591a;

        a(i.b<IFlowAppLogIDL> r3) {
            this.f18591a = (i.b) ZeusTransformUtils.wrapperContextForParams(r3, i.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.ipc.utils.i.b
        public /* synthetic */ void onRegister(IFlowAppLogIDL r3) {
            a((IFlowAppLogIDL) ZeusTransformUtils.preCheckCast(r3, IFlowAppLogIDL.class, "com.obric.aiagent.plugin"));
        }

        public void a(IFlowAppLogIDL r5) {
            IFlowAppLogIDL r6 = (IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
            o.e(r6, "inst");
            i.f18671a.a(IFlowAppLogIDL.class, (i.b) ZeusTransformUtils.preCheckCast(this, i.b.class, "com.obric.aiagent.plugin"));
            this.f18591a.onRegister(r6);
        }
    }

    public static /* synthetic */ IFlowAppLogIDL a(IFlowAppLogIDL r1, boolean r2, int r3, Object r4) {
        IFlowAppLogIDL r5 = (IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFlowAppLogIDL a(IFlowAppLogIDL r8, boolean r9) {
        IFlowAppLogIDL r10 = (IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        h.a(h.f18670a, "IFlowAppLogIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowAppLogIDL r11 = b(r10, r9);
        i.f18671a.a(IFlowAppLogIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
        return r11;
    }

    public static final void a(d.m.c<IFlowAppLogIDL> r2, boolean r3, boolean r4, i.b<IFlowAppLogIDL> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        i.b r7 = (i.b) ZeusTransformUtils.wrapperContextForParams(r5, i.b.class, "com.obric.aiagent.plugin");
        o.e(r6, "<this>");
        o.e(r7, "action");
        if (r4 == false) goto L5;
        i.f18671a.a(IFlowAppLogIDL.class, (i.b) ZeusTransformUtils.preCheckCast(new a(r7), i.b.class, "com.obric.aiagent.plugin"), r3);
        return;
    L5:
        i.f18671a.a(IFlowAppLogIDL.class, r7, r3);
    }

    static {
        f18590a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowAppLogIDL b(IFlowAppLogIDL r3, boolean r4) {
        IFlowAppLogIDL r5 = (IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowAppLogIDLIpcWrapper.class) == false) goto L7;
        return (IFlowAppLogIDL) ZeusTransformUtils.preCheckCast(new FlowAppLogIDLIpcWrapper(((FlowAppLogIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAppLogIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowAppLogIDL) ZeusTransformUtils.preCheckCast(new FlowAppLogIDLIpcWrapper(r5, r4), IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
    }
}
