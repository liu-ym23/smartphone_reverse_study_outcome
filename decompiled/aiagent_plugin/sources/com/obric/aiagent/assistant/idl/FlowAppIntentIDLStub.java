package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowAppIntentIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowAppIntentIDLStub extends IFlowAppIntentIDL.Stub implements IFlowAppIntentIDL {
    private final /* synthetic */ IFlowAppIntentIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean checkPermission(String r1, boolean r2, long r3) {
        return this.$$delegate_0.checkPermission(r1, r2, r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public long currentTimeMillis() {
        return this.$$delegate_0.currentTimeMillis();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void getLocation(IFlowGetLocationCallbackIDL r3) {
        IFlowGetLocationCallbackIDL r4 = (IFlowGetLocationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.getLocation(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public OTaskTimeoutConfig getObricTaskTimeoutConfig() {
        return this.$$delegate_0.getObricTaskTimeoutConfig();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public String getUserId() {
        return this.$$delegate_0.getUserId();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isDoraConnected() {
        return this.$$delegate_0.isDoraConnected();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isEnterpriseAccount() {
        return this.$$delegate_0.isEnterpriseAccount();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isLogin() {
        return this.$$delegate_0.isLogin();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void jumpDoraPage() {
        this.$$delegate_0.jumpDoraPage();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean openMiniApp(String r1) {
        return this.$$delegate_0.openMiniApp(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void setAppIntentActive(boolean r1) {
        this.$$delegate_0.setAppIntentActive(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void stopComplexTask(String r1) {
        this.$$delegate_0.stopComplexTask(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean syncAppletData(String r1) {
        return this.$$delegate_0.syncAppletData(r1);
    }

    public FlowAppIntentIDLStub() {
        Object r0 = (IFlowAppIntentIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowAppIntentIDLSPI.class), IFlowAppIntentIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowAppIntentIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowAppIntentIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
