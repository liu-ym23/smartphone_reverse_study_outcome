package com.obric.aiagent.ipc.assistant;

import android.content.Intent;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IAgentIDL;
import com.obric.aiagent.assistant.idl.e;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AssistantIDLService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AssistantIDLService extends PluginService {
    public static final a Companion = null;
    private static final String TAG = "AssistantIDLService";

    /* JADX INFO: compiled from: AssistantIDLService.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public AssistantIDLService() {
    }

    public IBinder onBind(Intent r6) {
        ILogDepend.Companion.i(TAG, "onBind");
        if (r6 == null) goto L5;
        String r2 = r6.getStringExtra(IAgentIDL.EXTRA_CLIENT_PKG);
    L6:
        if (r2 == null) goto L12;
        com.obric.aiagent.ipc.a.a r3 = com.obric.aiagent.ipc.a.a.f18605a;
        String r5 = getPackageName();
        o.c(r5, "getPackageName(...)");
        if (r3.a(r2, r5, "AssistantIDLService.onBind") == false) goto L12;
        com.obric.aiagent.ipc.notifier.a.f18639a.a(r6);
        IAgentIDL.Stub r7 = e.a(aa.b(IAgentIDL.class), false);
        ILogDepend.Companion.i(TAG, "onBind result: " + r7);
        return (IBinder) ZeusTransformUtils.preCheckCast(r7, IBinder.class, "com.obric.aiagent.plugin");
    L12:
        ILogDepend.Companion.e(TAG, "onBind check failed: " + r2);
        return null;
    L5:
        r2 = null;
        goto L6
    }

    public boolean onUnbind(Intent r2) {
        com.obric.aiagent.ipc.notifier.a r1 = com.obric.aiagent.ipc.notifier.a.f18639a;
        if (r2 != null) goto L5;
        r2 = new Intent(IAgentIDL.ACTION_BIND_IPC);
    L5:
        r1.b(r2);
        return true;
    }
}
