package com.obric.aiagent.privacy_sec.impl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IAgentPrivacyIDLSPI;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.privacy_sec.IPrivacy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PrivacyIDLStub.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyIDLStub implements IAgentPrivacyIDLSPI {
    public PrivacyIDLStub() {
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentPrivacyIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentPrivacyIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentPrivacyIDL
    public String getPemCertChain(String r4, String r5) {
        o.e(r4, "keyAlias");
        o.e(r5, "customInfo");
        ILogDepend.Companion.d(IAgentPrivacyIDLSPI.TAG, "getPemCertChain called, keyAlias = " + r4 + ", customInfo = " + r5);
        IPrivacy r3 = (IPrivacy) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacy.class), IPrivacy.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        String r6 = r3.getPemCertChain(r4, r5);
    L6:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        ILogDepend.Companion.d(IAgentPrivacyIDLSPI.TAG, "getPemCertChain called, return pemCertChain = " + r6);
        return r6;
    L5:
        r6 = null;
        goto L6
    }
}
