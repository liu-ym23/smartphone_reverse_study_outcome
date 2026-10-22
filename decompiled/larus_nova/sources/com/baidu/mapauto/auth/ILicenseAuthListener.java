package com.baidu.mapauto.auth;

import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public interface ILicenseAuthListener {
    void onError(int r100, String r101, Exception r102);

    void onSuccess(Map<String, Integer> r100);
}
