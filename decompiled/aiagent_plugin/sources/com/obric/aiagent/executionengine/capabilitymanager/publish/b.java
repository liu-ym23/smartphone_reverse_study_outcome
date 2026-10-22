package com.obric.aiagent.executionengine.capabilitymanager.publish;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IErrorCodeCallback;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: RegistrationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "RegistrationClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16563a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RemoteCallbackList<IErrorCodeCallback> f16564b = null;

    private b() {
    }

    static {
        f16563a = new b();
        f16564b = new RemoteCallbackList();
    }

    public final void a(String r3) {
        if (r3 == null) goto L7;
        IJobManagerApi r2 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        r2.dispatchActionResultFromClient(r3);
        return;
    L8:
        return;
    }

    public final void a(IntentResult<?> r3, String r4) {
        if (r3 == null) goto L8;
        if (r4 == null) goto L9;
        IJobManagerApi r2 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        r2.dispatchIntentExecutionResultFromClient(r3, r4);
        return;
    L10:
        return;
    L9:
        return;
    }

    public final void a(IntentResult<?> r8, long r9, boolean r11, Map<?, ?> r12) {
        Map<?, ?> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "result");
        IJobManagerApi r1 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.updateIntentResult(r9, r8, r11, r6);
        return;
    }

    public final void a(long r3) {
        IJobManagerApi r2 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.hideIntentResultCard(r3);
        return;
    }

    public final PendingIntent a(long r3, Intent r5, FloatingIntentParams r6) {
        o.e(r5, MemorySourceLinkType.INTENT);
        o.e(r6, "params");
        IJobManagerApi r2 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getFloatingPendingIntent(r3, r5, r6);
    }

    public final void b(long r3) {
        IJobManagerApi r2 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.finishFloatingActivity(r3);
        return;
    }

    public final boolean c(long r3) {
        IJobManagerApi r2 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isCardViewVisible(r3);
    }

    public final void a(IErrorCodeCallback r3) {
        IErrorCodeCallback r2 = (IErrorCodeCallback) ZeusTransformUtils.wrapperContextForParams(r3, IErrorCodeCallback.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        f16564b.register((IInterface) ZeusTransformUtils.preCheckCast(r2, IInterface.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void b(IErrorCodeCallback r3) {
        IErrorCodeCallback r2 = (IErrorCodeCallback) ZeusTransformUtils.wrapperContextForParams(r3, IErrorCodeCallback.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        f16564b.unregister((IInterface) ZeusTransformUtils.preCheckCast(r2, IInterface.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void a(int r6, String r7) {
        RemoteCallbackList<IErrorCodeCallback> r5 = f16564b;
        int r0 = r5.beginBroadcast();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        ((IErrorCodeCallback) ZeusTransformUtils.preCheckCast(r5.getBroadcastItem(r1), IErrorCodeCallback.class, "com.obric.aiagent.plugin")).onResult(r6, r7);     // Catch: RemoteException -> L6
    L8:
        r1 = r1 + 1;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L9:
        r5.finishBroadcast();
    }

    public final void a(Bundle r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        RemoteCallbackList<IErrorCodeCallback> r5 = f16564b;
        int r0 = r5.beginBroadcast();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L11;
        ((IErrorCodeCallback) ZeusTransformUtils.preCheckCast(r5.getBroadcastItem(r1), IErrorCodeCallback.class, "com.obric.aiagent.plugin")).onResultBundled(r6);     // Catch: RemoteException -> L8
    L10:
        r1 = r1 + 1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        r5.finishBroadcast();
    }
}
