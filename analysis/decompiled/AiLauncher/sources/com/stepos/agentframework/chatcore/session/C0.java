package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.deepbinder.core.constant.Constants;
import java.util.Map;
import kotlin.C0917m;
import kotlin.Metadata;
import u4.AgentResponse;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lu4/d;", "LK6/m;", Constants.PARAM_REPLY, "", Const.INTENT_KEY_APIKEY, "(Lu4/d;LK6/m;)Z", "", "PUSH_EXTRA_DISCONNECT_REASON", "Ljava/lang/String;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class C0 {
    public static final String PUSH_EXTRA_DISCONNECT_REASON = "disconnectReason";

    public static final boolean a(AgentResponse agentResponse, C0917m reply) {
        kotlin.jvm.internal.p.i(agentResponse, "<this>");
        kotlin.jvm.internal.p.i(reply, "reply");
        Map<String, String> mapS = reply.s();
        String str = mapS != null ? mapS.get("disconnectReason") : null;
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            return false;
        }
        agentResponse.F("");
        agentResponse.R(EReplyStatus.CANCELED);
        return true;
    }
}
