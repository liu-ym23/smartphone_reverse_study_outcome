package com.obric.agent.trace.omni;

import com.obric.autogui.common.api.AOAgentRobotsTools;

/* JADX INFO: compiled from: PrivacyGrantAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static final AOAgentRobotsTools.ToolAuditLogParams a(n r31, String r32) {
        d.h.b.o.e(r31, "<this>");
        d.h.b.o.e(r32, "toolName");
        return new AOAgentRobotsTools.ToolAuditLogParams("", null, "0", r31.b(), "{\"is_granted\":" + r31.c() + '}', null, null, null, null, null, null, null, null, null, r32, null, null, r31.a(), null, null, null, null, null, null, null, null, null, 134070242, null);
    }
}
