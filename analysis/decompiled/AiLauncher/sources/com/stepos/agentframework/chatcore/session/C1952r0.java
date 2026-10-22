package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.ability.converter.BundleContentBridge;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "type", "", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;)I", "Lcom/stepos/agentframework/chatcore/session/AgentRole;", BundleContentBridge.KEY_ROLE, "c", "(Lcom/stepos/agentframework/chatcore/session/AgentRole;)I", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.r0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1952r0 {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.r0$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentMessageType.values().length];
            try {
                iArr[AgentMessageType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentMessageType.IMAGE_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentMessageType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentMessageType.FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AgentMessageType.TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int c(AgentRole agentRole) {
        return agentRole == AgentRole.USER ? 0 : 1;
    }

    public static final int d(AgentMessageType agentMessageType) {
        int i10 = agentMessageType == null ? -1 : a.$EnumSwitchMapping$0[agentMessageType.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return 0;
        }
        if (i10 == 3) {
            return 1;
        }
        if (i10 != 4) {
            return i10 != 5 ? 4 : 3;
        }
        return 2;
    }
}
