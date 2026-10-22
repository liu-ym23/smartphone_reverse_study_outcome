package com.obric.memorydata.sdk.assistant;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.memorydata.sdk.c;
import com.obric.memorydata.sdk.service.IMemoryDataService;
import com.obric.memorydata.sdk.service.MemoryDataServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AssistantStateServiceProxy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AssistantStateServiceProxy {
    private static final String TAG = "AssistantStateServiceProxy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AssistantStateServiceProxy f33799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile IAssistantStateService f33800b;

    /* JADX INFO: compiled from: AssistantStateServiceProxy.kt */
    private static final class ServiceProxy implements IAssistantStateService {
        private final IAssistantStateService service;

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.d(r0, r1);
        }

        public ServiceProxy(IAssistantStateService r3) {
            IAssistantStateService r4 = (IAssistantStateService) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantStateService.class, "com.obric.aiagent.plugin");
            o.e(r4, WsConstants.KEY_SERVICE);
            this.service = r4;
        }

        public final IAssistantStateService getService() {
            return this.service;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.service.asBinder();
        L4:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_assistant_AssistantStateServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(AssistantStateServiceProxy.TAG, "asBinder error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }

        @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
        public void onActive() {
            INVOKESTATIC_com_obric_memorydata_sdk_assistant_AssistantStateServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(AssistantStateServiceProxy.TAG, "onActive");     // Catch: RemoteException -> L5
            this.service.onActive();     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_assistant_AssistantStateServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(AssistantStateServiceProxy.TAG, "onActive error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.memorydata.sdk.assistant.IAssistantStateService
        public void onQuery(QueryContext r3) {
            o.e(r3, "queryContext");
            INVOKESTATIC_com_obric_memorydata_sdk_assistant_AssistantStateServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(AssistantStateServiceProxy.TAG, "onQuery");     // Catch: RemoteException -> L5
            this.service.onQuery(r3);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_assistant_AssistantStateServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(AssistantStateServiceProxy.TAG, "onQuery error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_memorydata_sdk_assistant_AssistantStateServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_memorydata_sdk_assistant_AssistantStateServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public static /* synthetic */ x lambda$MiXLr0Ej2Fk_O7Qj65E0L2oLkmc(QueryContext r0) {
        return b(r0);
    }

    public static /* synthetic */ x lambda$uqm9PGFUw2DkqmI_bON_UskNpz0() {
        return c();
    }

    private AssistantStateServiceProxy() {
    }

    public static final /* synthetic */ void a(IAssistantStateService r2) {
        f33800b = (IAssistantStateService) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantStateService.class, "com.obric.aiagent.plugin");
    }

    static {
        f33799a = new AssistantStateServiceProxy();
        MemoryDataServiceProxy.f33905a.a(com.obric.memorydata.sdk.service.a.f33913d.ordinal(), (MemoryDataServiceProxy.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), MemoryDataServiceProxy.a.class, "com.obric.aiagent.plugin"));
    }

    private final IAssistantStateService b() {
        if (f33800b != null) goto L22;
        a(TAG, "getService: remoteService is null");
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (f33800b != null) goto L15;
        IMemoryDataService r0 = MemoryDataServiceProxy.f33905a.a();     // Catch: Throwable -> L18
        if (r0 == null) goto L11;
        IBinder r1 = r0.queryBinder(com.obric.memorydata.sdk.service.a.f33913d.ordinal());     // Catch: Throwable -> L18
    L12:
        IAssistantStateService r2 = IAssistantStateService.Stub.asInterface(r1);     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        f33800b = (IAssistantStateService) ZeusTransformUtils.preCheckCast(new ServiceProxy(r2), IAssistantStateService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        goto L15
    L11:
        r1 = null;
    L15:
        x r3 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(this);
    L22:
        return f33800b;
    }

    public final void a(final QueryContext r1) {
        o.e(r1, "queryContext");
        c.a(new $$Lambda$AssistantStateServiceProxy$MiXLr0Ej2Fk_O7Qj65E0L2oLkmc(r1));
    }

    private static final x b(QueryContext r1) {
        IAssistantStateService r0 = f33799a.b();
        if (r0 == null) goto L5;
        r0.onQuery(r1);
        return x.f38692a;
    L5:
        return null;
    }

    public final void a() {
        c.a($$Lambda$AssistantStateServiceProxy$uqm9PGFUw2DkqmI_bON_UskNpz0.INSTANCE);
    }

    private static final x c() {
        IAssistantStateService r0 = f33799a.b();
        if (r0 == null) goto L5;
        r0.onActive();
        return x.f38692a;
    L5:
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
