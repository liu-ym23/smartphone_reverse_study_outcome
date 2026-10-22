package cn.com.chinatelecom.account;

import android.net.Network;

/* JADX INFO: loaded from: classes28.dex */
public interface c0 {
    void onSwitchError(long r100);

    void onSwitchSuccess(Network r100, long r101);

    void onSwitchTimeout();
}
