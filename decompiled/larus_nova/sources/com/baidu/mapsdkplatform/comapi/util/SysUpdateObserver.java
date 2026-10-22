package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public interface SysUpdateObserver {
    void init(String r100);

    void updateCuid(String r100);

    void updateNetworkInfo(Context r100);

    void updateNetworkProxy(Context r100);

    void updatePhoneInfo(String r100);

    void updateZid(String r100);
}
