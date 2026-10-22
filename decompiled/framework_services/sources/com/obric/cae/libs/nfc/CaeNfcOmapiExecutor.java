package com.obric.cae.libs.nfc;

import com.obric.cae.libs.bluetooth.a;
import com.obric.cae.libs.utils.LogUtil;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CaeNfcOmapiExecutor {
    public final ICaeNfcOmapiExecutor a;

    public CaeNfcOmapiExecutor(ICaeNfcOmapiExecutor r1) {
        this.a = r1;
    }

    public String getEseId() {
        ICaeNfcOmapiExecutor r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "getEseId: service is null");
        return null;
    L11:
        return r0.getEseId();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcOmapiExecutor");
        return null;
    }

    public CaeNfcCardQueryResult queryInstalledCards(List<String> r6) {
        ICaeNfcOmapiExecutor r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "queryInstalledCards: service is null");
        return new CaeNfcCardQueryResult(2, false, Collections.emptyList());
    L11:
        return r0.queryInstalledCards(r6);
    L8:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "queryInstalledCards RemoteException: " + e);
        return new CaeNfcCardQueryResult(2, false, Collections.emptyList());
    }

    public CaeNfcCardSwitchResult switchActiveCard(String r14, List<String> r15) {
        ICaeNfcOmapiExecutor r0 = this.a;
        if (r0 != null) goto L12;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "switchActiveCard: service is null");
        return new CaeNfcCardSwitchResult(8, null, r14, 0, 0, 0, 0);
    L12:
        return r0.switchActiveCard(r14, r15);
    L9:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "switchActiveCard RemoteException: " + e);
        return new CaeNfcCardSwitchResult(8, null, r14, 0, 0, 0, 0);
    }
}
