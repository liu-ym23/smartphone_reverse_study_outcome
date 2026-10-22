package com.obric.aiagent.flow.applog.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: FlowAppLogIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAppLogIDLStub extends IFlowAppLogIDL.Stub implements IFlowAppLogIDL {
    private final /* synthetic */ IFlowAppLogIDL $$delegate_0;

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addDataObserver(IFlowAppLogDataObserverIDL r3) {
        IFlowAppLogDataObserverIDL r4 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.addDataObserver(r4);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addEventObserver(IFlowAppLogEventObserverIDL r3) {
        IFlowAppLogEventObserverIDL r4 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.addEventObserver(r4);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addSessionHook(IFlowAppLogSessionObserverIDL r3) {
        IFlowAppLogSessionObserverIDL r4 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.addSessionHook(r4);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void clearLaunchService() {
        this.$$delegate_0.clearLaunchService();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getDid() {
        return this.$$delegate_0.getDid();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getIid() {
        return this.$$delegate_0.getIid();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getSsid() {
        return this.$$delegate_0.getSsid();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserID() {
        return this.$$delegate_0.getUserID();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserUniqueID() {
        return this.$$delegate_0.getUserUniqueID();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3(String r1) {
        this.$$delegate_0.onEventV3(r1);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Bundle(String r1, Bundle r2) {
        this.$$delegate_0.onEventV3Bundle(r1, r2);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Json(String r1, String r2) {
        this.$$delegate_0.onEventV3Json(r1, r2);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onPause() {
        this.$$delegate_0.onPause();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onResume(String r1, int r2) {
        this.$$delegate_0.onResume(r1, r2);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onStop() {
        this.$$delegate_0.onStop();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeDataObserver(IFlowAppLogDataObserverIDL r3) {
        IFlowAppLogDataObserverIDL r4 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.removeDataObserver(r4);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeEventObserver(IFlowAppLogEventObserverIDL r3) {
        IFlowAppLogEventObserverIDL r4 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.removeEventObserver(r4);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeSessionHook(IFlowAppLogSessionObserverIDL r3) {
        IFlowAppLogSessionObserverIDL r4 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.removeSessionHook(r4);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setHeaderInfo(Map r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.setHeaderInfo(r4);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setLaunchService(String r1) {
        this.$$delegate_0.setLaunchService(r1);
    }

    public FlowAppLogIDLStub() {
        Object r0 = (IFlowAppLogIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAppLogIDLSPI.class), IFlowAppLogIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAppLogIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAppLogIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        o.c(r1, "asBinder(...)");
        return r1;
    }
}
