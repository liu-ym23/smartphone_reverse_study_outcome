package com.baidu.platform.comapi.license;

import android.content.Context;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public interface ILicenseAuthManager {
    boolean isEffective(String r100, String r101);

    boolean isHaveAuthority();

    boolean isHaveAuthority(Map<String, Integer> r100);

    void loadAuth(Context r100, ILicenseAuthManagerListener r101);

    Map<String, Integer> loadLocalAuth(Context r100) throws BaseLicenseAuthDataStandardProcess.ProcessException;
}
