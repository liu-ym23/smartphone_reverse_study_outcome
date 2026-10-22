package org.chromium.support_lib_boundary;

import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    Set<String> getRequestedWithHeaderOriginAllowList();

    void setAllowContentAccess(boolean r1);

    void setAllowFileAccess(boolean r1);

    void setBlockNetworkLoads(boolean r1);

    void setCacheMode(int r1);

    void setRequestedWithHeaderOriginAllowList(Set<String> r1);
}
