package com.obric.agent.permission;

import com.obric.aiagent.assistant.idl.IFlowPermissionIDL;
import com.obric.aiagent.assistant.idl.aq;
import d.h.b.aa;

/* JADX INFO: compiled from: Ext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final IFlowPermissionIDL a() {
        IFlowPermissionIDL r0 = aq.a(aa.b(IFlowPermissionIDL.class));
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new com.obric.agent.permission.a.a("IFlowPermissionIDL service not found!");
    }
}
