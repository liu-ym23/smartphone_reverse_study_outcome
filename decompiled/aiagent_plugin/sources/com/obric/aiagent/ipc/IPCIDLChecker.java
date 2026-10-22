package com.obric.aiagent.ipc;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.applog.ICommonParams;
import com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IPCIDLChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IPCIDLChecker implements IAgentIPCLifecycleDispatchSPI {
    public static final a Companion = null;
    private static final String TAG = "IPCIDLChecker";

    /* JADX INFO: compiled from: IPCIDLChecker.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: IPCIDLChecker.kt */
    public static final class b implements ICommonParams.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPCIDLChecker f18599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ICommonParams f18600b;

        b(IPCIDLChecker r3, ICommonParams r4) {
            ICommonParams r5 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r4, ICommonParams.class, "com.obric.aiagent.plugin");
            this.f18599a = r3;
            this.f18600b = r5;
        }

        @Override // com.obric.aiagent.applog.ICommonParams.a
        public void a(String r3, String r4) {
            o.e(r3, "key");
            o.e(r4, "value");
            IPCIDLChecker.access$checkIDLWithFlow(this.f18599a, r4, com.obric.aiagent.assistant.ipc.BuildConfig.IPC_IDL_SIGN);
            this.f18600b.removeParamUpdateListener(r3, (ICommonParams.a) ZeusTransformUtils.preCheckCast(this, ICommonParams.a.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$HiZcVVtZ4QPa4Wk_4brMBGuYR9w() {
        checkIDLWithFlow$lambda$0();
    }

    public IPCIDLChecker() {
    }

    public static final /* synthetic */ void access$checkIDLWithFlow(IPCIDLChecker r0, String r1, String r2) {
        r0.checkIDLWithFlow(r1, r2);
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onAppReset(String r1, Intent r2) {
        IAgentIPCLifecycleDispatchSPI.a.b(this, r1, r2);
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onUnbind(String r1, Intent r2) {
        IAgentIPCLifecycleDispatchSPI.a.a(this, r1, r2);
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onBind(String r2, Intent r3) {
        o.e(r2, "pkg");
        o.e(r3, MemorySourceLinkType.INTENT);
        if (o.a(r2, com.obric.aiagent.ipc.a.f18601a.a().a()) == false) goto L6;
        checkIDLWithFlow();
        return;
    }

    private final void checkIDLWithFlow() {
        ICommonParams r0 = (ICommonParams) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ICommonParams.class), ICommonParams.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        String r3 = r0.getCommonParam("flow_idl_sign");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        checkIDLWithFlow(r3, com.obric.aiagent.assistant.ipc.BuildConfig.IPC_IDL_SIGN);
        return;
    L11:
        r0.addParamUpdateListener("flow_idl_sign", (ICommonParams.a) ZeusTransformUtils.preCheckCast(new b(this, r0), ICommonParams.a.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r4 = false;
        goto L9
    }

    private final void checkIDLWithFlow(String r4, String r5) {
        if (o.a(r4, r5) == true) goto L13;
        ICommonParams r3 = (ICommonParams) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ICommonParams.class), ICommonParams.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        String r6 = r3.getCommonParam("flow_version_code");
    L8:
        ILogDepend.Companion.e(TAG, "Flow sign not match. FlowVer: " + r6 + ". AgentVer: " + IAppContext.Companion.getVersionCode());
        if (IAppContext.Companion.isDebug() == false) goto L11;
    L12:
        new Handler(Looper.getMainLooper()).post($$Lambda$IPCIDLChecker$HiZcVVtZ4QPa4Wk_4brMBGuYR9w.INSTANCE);
        return;
    L11:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L12;
        return;
    L7:
        r6 = null;
        goto L8
    L13:
        ILogDepend.Companion.i(TAG, "Flow sign check passed");
    }

    private static final void checkIDLWithFlow$lambda$0() {
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.ipc_toast_sign_unmatch, WsChannelMultiProcessSharedProvider.STRING_TYPE, "ipc_toast_sign_unmatch"), new Object[]{IAppContext.Companion.getAppStringName()}), CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
    }
}
