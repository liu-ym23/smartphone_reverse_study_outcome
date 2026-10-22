package com.stepos.agentframework.adapter.agentbus;

import a4.Message;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\n\u0010\b\"\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"La4/w;", "message", "", "c", "(La4/w;)Z", "", "rawTaskId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "rawVersionId", Const.INTENT_KEY_PKGNAME, "BUS_V2_TASK_ID_PREFIX", "Ljava/lang/String;", "BUS_V2_VERSION_ID_PREFIX", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1832h {
    private static final String BUS_V2_TASK_ID_PREFIX = "task_";
    private static final String BUS_V2_VERSION_ID_PREFIX = "version_";

    public static final String a(String rawTaskId) {
        kotlin.jvm.internal.p.i(rawTaskId, "rawTaskId");
        return La.H.R0(rawTaskId, BUS_V2_TASK_ID_PREFIX);
    }

    public static final String b(String rawVersionId) {
        kotlin.jvm.internal.p.i(rawVersionId, "rawVersionId");
        return La.H.R0(rawVersionId, BUS_V2_VERSION_ID_PREFIX);
    }

    public static final boolean c(Message message) {
        kotlin.jvm.internal.p.i(message, "message");
        return AgentBusChannelOpsKt.v(message);
    }
}
