package com.bytedance.android.live.multilink.service.common;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.multilink.external.api.core.service.IMultiLinkExternalService;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.multilink.service.base.MultiLinkExposedWrapperBase;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/multilink/service/common/MultiLinkGlobalServiceWrapper;", "Lcom/bytedance/android/live/multilink/service/base/MultiLinkExposedWrapperBase;", "Lcom/bytedance/android/live/multilink/internal/api/core/service/IMultiLinkInternalService;", "Lcom/bytedance/android/live/multilink/external/api/core/service/IMultiLinkExternalService;", "Lcom/bytedance/android/live/base/IService;", "()V", "getGlobalTestString", "", "multilink-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MultiLinkGlobalServiceWrapper extends MultiLinkExposedWrapperBase<IMultiLinkInternalService> implements IMultiLinkExternalService, IService {
    public MultiLinkGlobalServiceWrapper() {
        super(IMultiLinkInternalService.class);
    }

    @Override // com.bytedance.android.live.multilink.external.api.core.service.IMultiLinkExternalService
    public String getGlobalTestString() {
        return getRealInstance().getGlobalTestString() + "by Wrapper";
    }
}
