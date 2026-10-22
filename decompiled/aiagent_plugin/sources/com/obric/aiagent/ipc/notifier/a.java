package com.obric.aiagent.ipc.notifier;

import android.content.Intent;
import android.net.Uri;
import com.obric.aiagent.assistant.idl.IAgentIDL;
import com.obric.aiagent.ipc.utils.h;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: IPCLifecycleNotifier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "LifecycleNotifier";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18639a = null;

    static {
        f18639a = new a();
    }

    private a() {
    }

    public final void a(Intent r5) {
        o.e(r5, MemorySourceLinkType.INTENT);
        String r4 = r5.getStringExtra(IAgentIDL.EXTRA_CLIENT_PKG);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        h.f18670a.a(TAG, "IPC Bind: " + r5.getAction() + ". pkg=" + r4);
        Set r0 = ServiceManager.get().getServices(IAgentIPCLifecycleDispatchSPI.class);
        o.b(r0, "ServiceManager.get().getServices(T::class.java)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((IAgentIPCLifecycleDispatchSPI) ZeusTransformUtils.preCheckCast(r1.next(), IAgentIPCLifecycleDispatchSPI.class, "com.obric.aiagent.plugin")).onBind(r4, r5);
        goto L7
    }

    public final void b(Intent r5) {
        o.e(r5, MemorySourceLinkType.INTENT);
        String r4 = r5.getStringExtra(IAgentIDL.EXTRA_CLIENT_PKG);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        h.f18670a.a(TAG, "IPC Unbind: " + r5.getAction() + ". pkg=" + r4);
        Set r0 = ServiceManager.get().getServices(IAgentIPCLifecycleDispatchSPI.class);
        o.b(r0, "ServiceManager.get().getServices(T::class.java)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((IAgentIPCLifecycleDispatchSPI) ZeusTransformUtils.preCheckCast(r1.next(), IAgentIPCLifecycleDispatchSPI.class, "com.obric.aiagent.plugin")).onUnbind(r4, r5);
        goto L7
    }

    public final void c(Intent r5) {
        o.e(r5, MemorySourceLinkType.INTENT);
        Uri r4 = r5.getData();
        if (r4 == null) goto L5;
        String r6 = r4.getSchemeSpecificPart();
    L6:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        h.f18670a.a(TAG, "IPC App Reset: " + r5.getAction() + ". pkg=" + r6);
        Set r0 = ServiceManager.get().getServices(IAgentIPCLifecycleDispatchSPI.class);
        o.b(r0, "ServiceManager.get().getServices(T::class.java)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        ((IAgentIPCLifecycleDispatchSPI) ZeusTransformUtils.preCheckCast(r1.next(), IAgentIPCLifecycleDispatchSPI.class, "com.obric.aiagent.plugin")).onAppReset(r6, r5);
        goto L10
    L12:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
