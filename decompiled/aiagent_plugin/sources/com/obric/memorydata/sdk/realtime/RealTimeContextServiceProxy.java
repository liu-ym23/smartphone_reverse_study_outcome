package com.obric.memorydata.sdk.realtime;

import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.sdk.c;
import com.obric.memorydata.sdk.service.IMemoryDataService;
import com.obric.memorydata.sdk.service.MemoryDataServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: RealTimeContextServiceProxy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RealTimeContextServiceProxy {
    private static final String TAG = "RealTimeContextServiceProxy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RealTimeContextServiceProxy f33846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile IRealTimeContextService f33847b;

    /* JADX INFO: compiled from: RealTimeContextServiceProxy.kt */
    private static final class ServiceProxy implements IRealTimeContextService {
        private final IRealTimeContextService service;

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.d(r0, r1);
        }

        public ServiceProxy(IRealTimeContextService r3) {
            IRealTimeContextService r4 = (IRealTimeContextService) ZeusTransformUtils.wrapperContextForParams(r3, IRealTimeContextService.class, "com.obric.aiagent.plugin");
            o.e(r4, WsConstants.KEY_SERVICE);
            this.service = r4;
        }

        public final IRealTimeContextService getService() {
            return this.service;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.service.asBinder();
        L4:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(RealTimeContextServiceProxy.TAG, "asBinder error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleAssist(AssistStructure r4, List<AppEntity> r5) {
            List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(RealTimeContextServiceProxy.TAG, "onHandleAssist");     // Catch: RemoteException -> L5
            this.service.onHandleAssist(r4, r6);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(RealTimeContextServiceProxy.TAG, "onHandleAssist error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleScreenshot(Bitmap r3) {
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(RealTimeContextServiceProxy.TAG, "onHandleScreenshot");     // Catch: RemoteException -> L5
            this.service.onHandleScreenshot(r3);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(RealTimeContextServiceProxy.TAG, "onHandleScreenshot error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public RealTimeContextResult queryRealTimeContext(String r3, String r4, String r5) {
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(RealTimeContextServiceProxy.TAG, "queryRealTimeContext");     // Catch: RemoteException -> L5
            return this.service.queryRealTimeContext(r3, r4, r5);
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(RealTimeContextServiceProxy.TAG, "queryRealTimeContext error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
        public void onHandleAssistWithCallback(AssistStructure r4, List<AppEntity> r5, IRealTimeContextCallback r6) {
            List<AppEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            IRealTimeContextCallback r8 = (IRealTimeContextCallback) ZeusTransformUtils.wrapperContextForParams(r6, IRealTimeContextCallback.class, "com.obric.aiagent.plugin");
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(RealTimeContextServiceProxy.TAG, "onHandleAssistWithCallback");     // Catch: RemoteException -> L5
            this.service.onHandleAssistWithCallback(r4, r7, r8);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(RealTimeContextServiceProxy.TAG, "onHandleAssistWithCallback error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
            if (a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_memorydata_sdk_realtime_RealTimeContextServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public static /* synthetic */ x lambda$7NswZSkVmqIL3BC1WCxF_M_Hwv4(AssistStructure r0, List r1, IRealTimeContextCallback r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$m_URZfRINl-y_YnlyzqKNtIJoE0, reason: not valid java name */
    public static /* synthetic */ x m956lambda$m_URZfRINly_YnlyzqKNtIJoE0(Bitmap r0) {
        return b(r0);
    }

    private RealTimeContextServiceProxy() {
    }

    public static final /* synthetic */ void a(IRealTimeContextService r2) {
        f33847b = (IRealTimeContextService) ZeusTransformUtils.wrapperContextForParams(r2, IRealTimeContextService.class, "com.obric.aiagent.plugin");
    }

    static {
        f33846a = new RealTimeContextServiceProxy();
        MemoryDataServiceProxy.f33905a.a(com.obric.memorydata.sdk.service.a.f33911b.ordinal(), (MemoryDataServiceProxy.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), MemoryDataServiceProxy.a.class, "com.obric.aiagent.plugin"));
    }

    private final IRealTimeContextService a() {
        if (f33847b != null) goto L22;
        a(TAG, "getService: remoteService is null");
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (f33847b != null) goto L15;
        IMemoryDataService r0 = MemoryDataServiceProxy.f33905a.a();     // Catch: Throwable -> L18
        if (r0 == null) goto L11;
        IBinder r1 = r0.queryBinder(com.obric.memorydata.sdk.service.a.f33911b.ordinal());     // Catch: Throwable -> L18
    L12:
        IRealTimeContextService r2 = IRealTimeContextService.Stub.asInterface(r1);     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        f33847b = (IRealTimeContextService) ZeusTransformUtils.preCheckCast(new ServiceProxy(r2), IRealTimeContextService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        goto L15
    L11:
        r1 = null;
    L15:
        x r3 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(this);
    L22:
        return f33847b;
    }

    public final void a(final Bitmap r1) {
        o.e(r1, "bitmap");
        c.a(new $$Lambda$RealTimeContextServiceProxy$m_URZfRINly_YnlyzqKNtIJoE0(r1));
    }

    private static final x b(Bitmap r1) {
        IRealTimeContextService r0 = f33846a.a();
        if (r0 == null) goto L5;
        r0.onHandleScreenshot(r1);
        return x.f38692a;
    L5:
        return null;
    }

    public final void a(final AssistStructure r2, List<AppEntity> r3, IRealTimeContextCallback r4) {
        final List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        final IRealTimeContextCallback r5 = (IRealTimeContextCallback) ZeusTransformUtils.wrapperContextForParams(r4, IRealTimeContextCallback.class, "com.obric.aiagent.plugin");
        o.e(r5, "callback");
        c.a(new $$Lambda$RealTimeContextServiceProxy$7NswZSkVmqIL3BC1WCxF_M_Hwv4(r2, r1, r5));
    }

    private static final x b(AssistStructure r2, List r3, IRealTimeContextCallback r4) {
        List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        IRealTimeContextCallback r6 = (IRealTimeContextCallback) ZeusTransformUtils.wrapperContextForParams(r4, IRealTimeContextCallback.class, "com.obric.aiagent.plugin");
        IRealTimeContextService r0 = f33846a.a();
        if (r0 == null) goto L5;
        r0.onHandleAssistWithCallback(r2, r5, r6);
        return x.f38692a;
    L5:
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
