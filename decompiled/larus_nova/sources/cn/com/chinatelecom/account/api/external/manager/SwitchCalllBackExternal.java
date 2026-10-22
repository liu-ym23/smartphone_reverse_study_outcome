package cn.com.chinatelecom.account.api.external.manager;

import android.net.Network;

/* JADX INFO: loaded from: classes28.dex */
public interface SwitchCalllBackExternal {
    void onSwitchError(long r100);

    void onSwitchSuccess(Network r100, long r101);

    void onSwitchTimeout();
}
