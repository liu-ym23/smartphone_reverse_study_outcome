package com.bytedance.android.livehostapi.wrap;

import android.content.Context;
import com.bytedance.android.livehostapi.platform.IHostCoinState;
import com.bytedance.android.livehostapi.platform.depend.Callback;

/* JADX INFO: loaded from: classes7.dex */
public class AbsHostCoinState implements IHostCoinState {
    public AbsHostCoinState() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostCoinState
    public boolean isEnableBindAccountAwardTask() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostCoinState
    public void getCoinState(Context r100, Callback<Boolean> r101) {
        r101.call(Boolean.FALSE);
    }
}
