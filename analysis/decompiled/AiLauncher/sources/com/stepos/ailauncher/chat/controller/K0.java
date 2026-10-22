package com.stepos.ailauncher.chat.controller;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0003R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/K0;", "", "<init>", "()V", "", "agentId", "", "toastResId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;I)V", Const.INTENT_KEY_PKGNAME, "uninstalledAgentId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUninstalledAgentId", "(Ljava/lang/String;)V", "blockedAgentId", "c", "setBlockedAgentId", "blockedToastResId", "I", Const.INTENT_KEY_UMID, "()I", "setBlockedToastResId", "(I)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class K0 {
    private static volatile String blockedAgentId;
    private static volatile String uninstalledAgentId;
    public static final K0 INSTANCE = new K0();
    private static volatile int blockedToastResId = R$string.chat_agent_reinstall_hint;

    public final void a(String agentId, int toastResId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        blockedAgentId = agentId;
        uninstalledAgentId = agentId;
        blockedToastResId = toastResId;
    }

    public final void b() {
        blockedAgentId = null;
        uninstalledAgentId = null;
        blockedToastResId = R$string.chat_agent_reinstall_hint;
    }

    public final String c() {
        return blockedAgentId;
    }

    public final int d() {
        return blockedToastResId;
    }

    public final String e() {
        return uninstalledAgentId;
    }
}
