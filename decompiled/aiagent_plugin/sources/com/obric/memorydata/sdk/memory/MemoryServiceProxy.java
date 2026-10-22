package com.obric.memorydata.sdk.memory;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import com.obric.memorydata.sdk.c;
import com.obric.memorydata.sdk.service.IMemoryDataService;
import com.obric.memorydata.sdk.service.MemoryDataServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MemoryServiceProxy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MemoryServiceProxy {
    private static final String TAG = "MemoryServiceProxy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemoryServiceProxy f33843a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile IMemoryService f33844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Boolean f33845c;

    /* JADX INFO: compiled from: MemoryServiceProxy.kt */
    private static final class ServiceProxy implements IMemoryService {
        private final IMemoryService service;

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.d(r0, r1);
        }

        public ServiceProxy(IMemoryService r3) {
            IMemoryService r4 = (IMemoryService) ZeusTransformUtils.wrapperContextForParams(r3, IMemoryService.class, "com.obric.aiagent.plugin");
            o.e(r4, WsConstants.KEY_SERVICE);
            this.service = r4;
        }

        public final IMemoryService getService() {
            return this.service;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.service.asBinder();
        L4:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MemoryServiceProxy.TAG, "asBinder error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void registerMemoryCallback(IMemoryCallback r4) {
            IMemoryCallback r5 = (IMemoryCallback) ZeusTransformUtils.wrapperContextForParams(r4, IMemoryCallback.class, "com.obric.aiagent.plugin");
            o.e(r5, "callback");
            INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(MemoryServiceProxy.TAG, "registerMemoryCallback");     // Catch: RemoteException -> L5
            this.service.registerMemoryCallback(r5);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MemoryServiceProxy.TAG, "registerMemoryCallback error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void saveAssistantChatMemory(String r3, String r4, Bundle r5) {
            o.e(r3, "type");
            o.e(r4, "memory");
            o.e(r5, "extras");
            INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(MemoryServiceProxy.TAG, "saveAssistantChatMemory");     // Catch: RemoteException -> L5
            this.service.saveAssistantChatMemory(r3, r4, r5);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MemoryServiceProxy.TAG, "saveAssistantChatMemory error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public boolean getDialogueMemoryEnableState() {
            INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(MemoryServiceProxy.TAG, "getDialogueMemoryEnableState");     // Catch: RemoteException -> L5
            return this.service.getDialogueMemoryEnableState();
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MemoryServiceProxy.TAG, "getDialogueMemoryEnableState error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return false;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void syncAssistantChat(String r2) {
            o.e(r2, "json");
            this.service.syncAssistantChat(r2);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MemoryServiceProxy.TAG, "syncAssistantChat error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
            if (a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_memorydata_sdk_memory_MemoryServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public static /* synthetic */ x lambda$49nUO6iCHIPYCdcNor10Cat1zJU(String r0) {
        return b(r0);
    }

    public static /* synthetic */ x lambda$_iBOevbkLGQz9oW8kRVABAW2Cyc(String r0, String r1, Bundle r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$chVH513jmH1QXUlKjkx7GGYpGSU() {
        return c();
    }

    private MemoryServiceProxy() {
    }

    public static final /* synthetic */ void a(IMemoryService r2) {
        f33844b = (IMemoryService) ZeusTransformUtils.wrapperContextForParams(r2, IMemoryService.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(Boolean r0) {
        f33845c = r0;
    }

    static {
        f33843a = new MemoryServiceProxy();
        MemoryDataServiceProxy.f33905a.a(com.obric.memorydata.sdk.service.a.f33912c.ordinal(), (MemoryDataServiceProxy.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), MemoryDataServiceProxy.a.class, "com.obric.aiagent.plugin"));
    }

    private final IMemoryService b() {
        if (f33844b != null) goto L25;
        a(TAG, "getService: remoteService is null");
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (f33844b != null) goto L18;
        IMemoryDataService r0 = MemoryDataServiceProxy.f33905a.a();     // Catch: Throwable -> L21
        if (r0 == null) goto L11;
        IBinder r1 = r0.queryBinder(com.obric.memorydata.sdk.service.a.f33912c.ordinal());     // Catch: Throwable -> L21
    L12:
        IMemoryService r2 = IMemoryService.Stub.asInterface(r1);     // Catch: Throwable -> L21
        if (r2 == null) goto L15;
        f33844b = (IMemoryService) ZeusTransformUtils.preCheckCast(new ServiceProxy(r2), IMemoryService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
    L15:
        IMemoryService r3 = f33844b;     // Catch: Throwable -> L21
        if (r3 == null) goto L18;
        r3.registerMemoryCallback((IMemoryCallback) ZeusTransformUtils.preCheckCast(new MemoryServiceProxy$getService$1$2(), IMemoryCallback.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        goto L18
    L11:
        r1 = null;
    L18:
        x r4 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(this);
    L25:
        return f33844b;
    }

    public final boolean a() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(c.a($$Lambda$MemoryServiceProxy$chVH513jmH1QXUlKjkx7GGYpGSU.INSTANCE), Boolean.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.booleanValue();
    }

    private static final boolean c() {
        boolean r1 = false;
        if (f33845c != null) goto L7;
        IMemoryService r0 = f33843a.b();
        if (r0 == null) goto L10;
        r1 = r0.getDialogueMemoryEnableState();
    L10:
        a(TAG, "getDialogueMemoryEnableState: " + r1);
        return r1;
    L7:
        Boolean r2 = f33845c;
        if (r2 == null) goto L10;
        r1 = r2.booleanValue();
        goto L10
    }

    public final void a(final String r1, final String r2, final Bundle r3) {
        o.e(r1, "type");
        o.e(r2, "memory");
        o.e(r3, "extras");
        c.a(new $$Lambda$MemoryServiceProxy$_iBOevbkLGQz9oW8kRVABAW2Cyc(r1, r2, r3));
    }

    private static final x b(String r1, String r2, Bundle r3) {
        IMemoryService r0 = f33843a.b();
        if (r0 == null) goto L5;
        r0.saveAssistantChatMemory(r1, r2, r3);
        return x.f38692a;
    L5:
        return null;
    }

    public final void a(final String r1) {
        o.e(r1, "json");
        c.a(new $$Lambda$MemoryServiceProxy$49nUO6iCHIPYCdcNor10Cat1zJU(r1));
    }

    private static final x b(String r1) {
        IMemoryService r0 = f33843a.b();
        if (r0 == null) goto L5;
        r0.syncAssistantChat(r1);
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
