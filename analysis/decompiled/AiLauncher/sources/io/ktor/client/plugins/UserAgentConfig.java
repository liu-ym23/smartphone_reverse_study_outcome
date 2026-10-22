package io.ktor.client.plugins;

import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;

@KtorDsl
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lio/ktor/client/plugins/UserAgentConfig;", "", "", "agent", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getAgent", "()Ljava/lang/String;", "setAgent", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAgentConfig {
    private String agent;

    /* JADX WARN: Multi-variable type inference failed */
    public UserAgentConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getAgent() {
        return this.agent;
    }

    public final void setAgent(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.agent = str;
    }

    public UserAgentConfig(String agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        this.agent = agent;
    }

    public /* synthetic */ UserAgentConfig(String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "Ktor http-client" : str);
    }
}
