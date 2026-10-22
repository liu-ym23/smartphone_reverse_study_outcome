package com.byted.cast.common.api;

import com.byted.cast.common.bean.DeviceInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface IGetDeviceInfoListener {
    void onFail(int r100, String r101);

    void onSuccess(DeviceInfo r100);
}
