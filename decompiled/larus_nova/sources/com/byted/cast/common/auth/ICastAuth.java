package com.byted.cast.common.auth;

import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface ICastAuth {
    void destroy();

    String getLicenseParam(String r100);

    List<String> getServiceContentList(String r100);

    String getServiceEdition(String r100);

    void init(String r100);

    void verifyLicense(String r100, IAuthListener r101);
}
