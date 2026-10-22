package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/x;", "", "<init>", "()V", "", "agentType", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "AGENT_TYPE_LOCAL", "Ljava/lang/String;", "AGENT_TYPE_REMOTE", "AGENT_TYPE_THIRD_PART", "AGENT_TYPE_OPENCLAW", "AGENT_TYPE_AGENTBUS", "AGENT_TYPE_AGENTBUS_BFF", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1963x {
    public static final String AGENT_TYPE_AGENTBUS = "agentbus";
    public static final String AGENT_TYPE_AGENTBUS_BFF = "agentbus_bff";
    public static final String AGENT_TYPE_LOCAL = "local";
    public static final String AGENT_TYPE_OPENCLAW = "openclaw";
    public static final String AGENT_TYPE_REMOTE = "remote";
    public static final String AGENT_TYPE_THIRD_PART = "third_part";
    public static final C1963x INSTANCE = new C1963x();

    public final boolean a(String agentType) {
        kotlin.jvm.internal.p.i(agentType, "agentType");
        return kotlin.jvm.internal.p.d(agentType, AGENT_TYPE_OPENCLAW) || kotlin.jvm.internal.p.d(agentType, AGENT_TYPE_AGENTBUS) || kotlin.jvm.internal.p.d(agentType, AGENT_TYPE_AGENTBUS_BFF);
    }
}
