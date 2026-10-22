package com.baidu.platform.comapi.license;

import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public interface ILicenseAuthManagerListener {
    void onError(String r100, String r101, int r102, int r103, String r104);

    void onSuccess(String r100, String r101, int r102, Map<String, Integer> r103);
}
