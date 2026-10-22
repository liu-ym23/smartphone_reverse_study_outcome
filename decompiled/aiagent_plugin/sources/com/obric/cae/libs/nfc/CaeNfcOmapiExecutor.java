package com.obric.cae.libs.nfc;

import com.obric.cae.libs.utils.LogUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class CaeNfcOmapiExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICaeNfcOmapiExecutor f31765a;

    public CaeNfcOmapiExecutor(ICaeNfcOmapiExecutor r3) {
        this.f31765a = (ICaeNfcOmapiExecutor) ZeusTransformUtils.wrapperContextForParams(r3, ICaeNfcOmapiExecutor.class, "com.obric.aiagent.plugin");
    }

    public String getEseId() {
        ICaeNfcOmapiExecutor r3 = this.f31765a;
        if (r3 != null) goto L11;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "getEseId: service is null");
        return null;
    L11:
        return r3.getEseId();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcOmapiExecutor");
        return null;
    }
}
