package com.android.server.pm.verify.domain.proxy;

import android.content.ComponentName;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class DomainVerificationProxyCombined implements DomainVerificationProxy {
    private final DomainVerificationProxy mProxyV1;
    private final DomainVerificationProxy mProxyV2;

    DomainVerificationProxyCombined(DomainVerificationProxy proxyV1, DomainVerificationProxy proxyV2) {
        this.mProxyV1 = proxyV1;
        this.mProxyV2 = proxyV2;
    }

    @Override // com.android.server.pm.verify.domain.proxy.DomainVerificationProxy
    public void sendBroadcastForPackages(Set<String> packageNames) {
        this.mProxyV2.sendBroadcastForPackages(packageNames);
        this.mProxyV1.sendBroadcastForPackages(packageNames);
    }

    @Override // com.android.server.pm.verify.domain.proxy.DomainVerificationProxy
    public boolean runMessage(int messageCode, Object object) {
        boolean resultV2 = this.mProxyV2.runMessage(messageCode, object);
        boolean resultV1 = this.mProxyV1.runMessage(messageCode, object);
        if (resultV2 == true) goto L7;
        if (resultV1 == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.pm.verify.domain.proxy.DomainVerificationProxy
    public boolean isCallerVerifier(int callingUid) {
        if (this.mProxyV2.isCallerVerifier(callingUid) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mProxyV1.isCallerVerifier(callingUid) == true) goto L8;
        return false;
    }

    @Override // com.android.server.pm.verify.domain.proxy.DomainVerificationProxy
    public ComponentName getComponentName() {
        return this.mProxyV2.getComponentName();
    }
}
