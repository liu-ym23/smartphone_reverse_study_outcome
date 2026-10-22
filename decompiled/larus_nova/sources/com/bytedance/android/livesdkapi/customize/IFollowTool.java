package com.bytedance.android.livesdkapi.customize;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.service.ILiveCallback;

/* JADX INFO: loaded from: classes12.dex */
public interface IFollowTool extends IService {
    void changeUserAllowFollowStateSync(boolean r100, ILiveCallback<Boolean> r101);

    void isUserAllowFollowStateSync(ILiveCallback<Boolean> r100);
}
