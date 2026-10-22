package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FlowPermissionIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowPermissionIDLStub extends IFlowPermissionIDL.Stub implements IFlowPermissionIDL {
    private final /* synthetic */ IFlowPermissionIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isAppletPermissionGranted(String r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.isAppletPermissionGranted(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPermissionGranted(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.isPermissionGranted(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPersonalPermissionGranted(String r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.isPersonalPermissionGranted(r3, r5);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public boolean requestPermission(String r1, String r2) {
        return this.$$delegate_0.requestPermission(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updateAppletPermissions(List<Permission> r3) {
        List<Permission> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.updateAppletPermissions(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updatePersonalPermissions(List<Permission> r3) {
        List<Permission> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.updatePersonalPermissions(r4);
    }

    public FlowPermissionIDLStub() {
        Object r0 = (IFlowPermissionIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowPermissionIDLSPI.class), IFlowPermissionIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowPermissionIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowPermissionIDL) ZeusTransformUtils.preCheckCast(r0, IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
