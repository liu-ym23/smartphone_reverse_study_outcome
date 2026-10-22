package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import u4.AgentResponse;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/M;", "", "<init>", "()V", "Lu4/d;", UxipConstants.f30685x, "", Const.INTENT_KEY_APIKEY, "(Lu4/d;)Z", "holdForUserInput", "inquiryContinuationActive", Const.INTENT_KEY_PKGNAME, "(ZZLu4/d;)Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class M {
    public static final M INSTANCE = new M();

    public final boolean a(AgentResponse response) {
        kotlin.jvm.internal.p.i(response, "response");
        if (response.getStatus() != EReplyStatus.COMPLETED || response.getContent().length() != 0 || response.getDeepThinkingText().length() != 0) {
            return false;
        }
        List<AgentTool> listY = response.y();
        return listY == null || listY.isEmpty();
    }

    public final boolean b(boolean holdForUserInput, boolean inquiryContinuationActive, AgentResponse response) {
        kotlin.jvm.internal.p.i(response, "response");
        if (response.getStatus() != EReplyStatus.COMPLETED) {
            return false;
        }
        if (holdForUserInput) {
            return true;
        }
        if (inquiryContinuationActive) {
            return !a(response);
        }
        return false;
    }
}
