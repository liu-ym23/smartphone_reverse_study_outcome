package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public final class NfcTeardownResult extends ComponentResult {
    public int mNfcCount;

    public NfcTeardownResult(int nfcCurrent, int nfcCount) {
        this.mCurrent = nfcCurrent;
        this.mNfcCount = nfcCount;
    }

    public String toString() {
        return "[Nfc] nfc current = " + this.mCurrent + "μA, nfcCount =" + this.mNfcCount + "\n";
    }
}
