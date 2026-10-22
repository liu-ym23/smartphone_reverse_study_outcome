package com.obric.autogui.util.b.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DoubaoUserInfoRepo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31498a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C0863a f31499b = null;

    /* JADX INFO: renamed from: com.obric.autogui.util.b.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DoubaoUserInfoRepo.kt */
    private static final class C0863a extends PluginBroadcastReceiver {
        public C0863a() {
        }

        public void onReceive(Context r9, Intent r10) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
            o.e(r11, "context");
            o.e(r10, MemorySourceLinkType.INTENT);
            boolean r12 = r10.getBooleanExtra("is_login", false);     // Catch: Throwable -> L8
            Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [DoubaoLoginState] received doubao login-state change --> (" + r12 + ").");
            if (r12 == true) goto L13;
            IAutoActionAgentApi r0 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            String r2 = r11.getString(ZeusTransformUtils.mapRes(R.string.terminate_task_due_to_doubao_exited, WsChannelMultiProcessSharedProvider.STRING_TYPE, "terminate_task_due_to_doubao_exited"));
            o.c(r2, "getString(...)");
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default(r0, null, r2, 104003, null, null, 24, null);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [DoubaoLoginState] failed to get login-state: " + th, th);
        }
    }

    private a() {
    }

    public final void a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        IntentFilter r0 = new IntentFilter("com.obric.assistant.login_status_changed");
        ZeusTransformUtils.registerReceiver(r6, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f31499b, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r0, 4, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [DoubaoLoginState] listening to doubao's login state.");
    }

    static {
        f31498a = new a();
        f31499b = new C0863a();
    }
}
