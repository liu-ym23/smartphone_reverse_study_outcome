package com.baidu.mapauto.auth;

import java.util.Map;

/* loaded from: classes.dex */
public interface ILicenseAuthListener {
    void onError(int i4, String str);

    void onSuccess(Map<String, Integer> map);
}
