package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentRole;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a)\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentRole;", "olderRole", "", "userHalfGapPx", "defaultHalfGapPx", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/AgentRole;II)I", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class G1 {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentRole.values().length];
            try {
                iArr[AgentRole.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int a(AgentRole agentRole, int i10, int i11) {
        int i12 = agentRole == null ? -1 : a.$EnumSwitchMapping$0[agentRole.ordinal()];
        if (i12 != -1) {
            return i12 != 1 ? i11 * 2 : i10 * 2;
        }
        return 0;
    }
}
