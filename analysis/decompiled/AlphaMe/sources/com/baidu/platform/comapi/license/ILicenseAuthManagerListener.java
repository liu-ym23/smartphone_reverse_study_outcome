package com.baidu.platform.comapi.license;

import java.util.Map;

/* loaded from: classes.dex */
public interface ILicenseAuthManagerListener {
    void onError(String str, String str2, int i4, int i5, String str3);

    void onSuccess(String str, String str2, int i4, Map<String, Integer> map);
}
