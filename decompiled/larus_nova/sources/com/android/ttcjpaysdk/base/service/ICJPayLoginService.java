package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import com.android.ttcjpaysdk.network.ITTCJPayCallback;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayLoginService extends ICJPayService {
    void senselessCheckAndLogin(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, ITTCJPayCallback r108);

    void senselessLogin(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, ITTCJPayCallback r112);
}
