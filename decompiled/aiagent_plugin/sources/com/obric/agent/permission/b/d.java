package com.obric.agent.permission.b;

import com.obric.agent.permission.bean.CheckPermissionReq;
import com.obric.agent.permission.bean.Permission;
import com.obric.agent.permission.bean.RequestPermissionReq;
import com.obric.agent.permission.bean.RequestPermissionResult;
import com.obric.agent.permission.bean.UpdatePermissionReq;
import com.obric.agent.w;
import com.obric.aiagent.assistant.idl.IFlowPermissionIDL;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PersonalPermissionProtocol.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements b {
    public d() {
    }

    @Override // com.obric.agent.permission.b.b
    public List<Permission> a(CheckPermissionReq r11) {
        o.e(r11, Ext.KEY_REQUEST);
        String r0 = r11.getAppletId();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        Map<String, Boolean> r10 = a(r0, r11.getPermissions());
        if (r10 == null) goto L17;
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r10.size()), Collection.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, Boolean>> r13 = r10.entrySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r12.add(new Permission((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (Boolean) ZeusTransformUtils.preCheckCast(r2.getValue(), Boolean.class, "com.obric.aiagent.plugin"), r0, null, 8, null));
        goto L13
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
    L17:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L8:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.agent.permission.b.b
    public RequestPermissionResult requestPermissions(RequestPermissionReq r1, DispatchContext r2) {
        o.e(r1, Ext.KEY_REQUEST);
        o.e(r2, "dispatchContext");
        return e.f15407a.requestPermissions(r1, r2);
    }

    @Override // com.obric.agent.permission.b.b
    public void a(UpdatePermissionReq r12) {
        o.e(r12, Ext.KEY_REQUEST);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getPermissions(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Object r1 = r14.next();
        if (w.a(((Permission) ZeusTransformUtils.preCheckCast(r1, Permission.class, "com.obric.aiagent.plugin")).getAppletId()) == false) goto L4;
        r13.add(r1);
        goto L4
    L8:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
        if (r15.isEmpty() == false) goto L11;
        return;
    L11:
        IFlowPermissionIDL r16 = com.obric.agent.permission.a.a();
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r17, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r17.iterator();
    L13:
        if (r18.hasNext() == false) goto L15;
        Permission r3 = (Permission) ZeusTransformUtils.preCheckCast(r18.next(), Permission.class, "com.obric.aiagent.plugin");
        r2.add(new com.obric.aiagent.assistant.idl.bean.Permission(r3.getType(), null, r3.getAppletId(), r3.getConfirmMode(), 2, null));
        goto L13
    L15:
        r16.updatePersonalPermissions((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
    }

    private final Map<String, Boolean> a(String r5, List<Permission> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        IFlowPermissionIDL r7 = com.obric.agent.permission.a.a();
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.add(((Permission) ZeusTransformUtils.preCheckCast(r9.next(), Permission.class, "com.obric.aiagent.plugin")).getType());
        goto L4
    L6:
        Map<String, Boolean> r10 = r7.isPersonalPermissionGranted(r5, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r10, Map.class) == true) goto L12;
        return null;
    L12:
        return r10;
    }
}
