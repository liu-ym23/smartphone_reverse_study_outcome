package com.obric.agent.permission.b;

import com.obric.agent.permission.bean.CheckPermissionReq;
import com.obric.agent.permission.bean.Permission;
import com.obric.agent.permission.bean.RequestPermissionReq;
import com.obric.agent.permission.bean.RequestPermissionResult;
import com.obric.agent.permission.bean.UpdatePermissionReq;
import com.obric.aiagent.assistant.idl.IFlowPermissionIDL;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NativePermissionProtocol.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {
    private static final String TAG = "NativePermissionProtocol";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15406a = null;

    /* JADX INFO: compiled from: NativePermissionProtocol.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f15406a = new a(null);
    }

    @Override // com.obric.agent.permission.b.b
    public void a(UpdatePermissionReq r1) {
        o.e(r1, Ext.KEY_REQUEST);
    }

    public c() {
    }

    @Override // com.obric.agent.permission.b.b
    public List<Permission> a(CheckPermissionReq r11) {
        o.e(r11, Ext.KEY_REQUEST);
        Map<String, Boolean> r10 = a(r11.getPermissions());
        if (r10 == null) goto L10;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r10.size()), Collection.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, Boolean>> r12 = r10.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.add(new Permission((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), (Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.aiagent.plugin"), null, null, 12, null));
        goto L6
    L12:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L10:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.permission.b.b
    public RequestPermissionResult requestPermissions(RequestPermissionReq r6, DispatchContext r7) {
        o.e(r6, Ext.KEY_REQUEST);
        o.e(r7, "dispatchContext");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.getPermissions(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L14;
        Object r0 = r8.next();
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(((Permission) ZeusTransformUtils.preCheckCast(r0, Permission.class, "com.obric.aiagent.plugin")).getAppletId(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L4;
    L15:
        Permission r9 = (Permission) ZeusTransformUtils.preCheckCast(r0, Permission.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L20;
        return new RequestPermissionResult(RequestPermissionResult.a.f15408a, null, 2, null);
    L20:
        return a(r9, r7);
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L12
    L14:
        r0 = null;
        goto L15
    }

    private final Map<String, Boolean> a(List<Permission> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        IFlowPermissionIDL r6 = com.obric.agent.permission.a.a();
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r1.add(((Permission) ZeusTransformUtils.preCheckCast(r8.next(), Permission.class, "com.obric.aiagent.plugin")).getType());
        goto L4
    L6:
        Map<String, Boolean> r9 = r6.isPermissionGranted((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r9, Map.class) == true) goto L12;
        return null;
    L12:
        return r9;
    }

    private final RequestPermissionResult a(Permission r3, DispatchContext r4) {
        ISecureLogDepend.Companion.d(TAG, "requestPermission called, permission = " + r3);
        if (com.obric.agent.permission.a.a().requestPermission(String.valueOf(r4.getQuestionId()), r3.getType()) == false) goto L6;
        return new RequestPermissionResult(RequestPermissionResult.a.f15409b, null, 2, null);
    L6:
        return new RequestPermissionResult(RequestPermissionResult.a.f15408a, null, 2, null);
    }
}
