package com.stepos.ailauncher.chat.trace;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.agentbus.bff.PrimaryAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/trace/b;", "", "<init>", "()V", "", "agentId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();

    public final String a(String agentId) {
        String string;
        if (agentId != null && (string = H.D1(agentId).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return PrimaryAgent.INSTANCE.a(string) ? PrimaryAgent.AMOO.getId() : string;
            }
        }
        return null;
    }
}
