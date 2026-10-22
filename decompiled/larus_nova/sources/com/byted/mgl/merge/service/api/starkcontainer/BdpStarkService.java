package com.byted.mgl.merge.service.api.starkcontainer;

import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpStarkService extends IBdpService {
    void cleanScStorage(int r100);

    void handleAction(String r100, Object... r101);

    void initProcess(Object... r100);

    void triggerScGameManage(String r100, String r101);
}
