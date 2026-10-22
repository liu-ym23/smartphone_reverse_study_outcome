package com.obric.aikernel.phx.core.conn;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ProcessPriorityBinding.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProcessPriorityBindingKt {
    public static final int AUTO_CREATE_BIND_FLAGS = 1;
    public static final int CHILD_PROCESS_IMPORTANT_BIND_FLAGS = 65;

    public static final boolean bindAutoCreate(Context r2, Intent r3, Executor r4, ServiceConnection r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r3, MemorySourceLinkType.INTENT);
        o.e(r7, "executor");
        o.e(r8, WsConstants.KEY_CONNECTION);
        return r6.bindService(r3, 1, r7, r8);
    }

    public static final boolean bindForChildProcessPriority(Context r2, Intent r3, Executor r4, ServiceConnection r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r3, MemorySourceLinkType.INTENT);
        o.e(r7, "executor");
        o.e(r8, WsConstants.KEY_CONNECTION);
        return r6.bindService(r3, 65, r7, r8);
    }
}
