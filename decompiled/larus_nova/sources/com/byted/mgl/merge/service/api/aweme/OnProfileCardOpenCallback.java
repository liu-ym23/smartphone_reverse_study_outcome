package com.byted.mgl.merge.service.api.aweme;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/OnProfileCardOpenCallback;", "", "onClose", "", SendEventContainerMethodParamModel.EventKinds.onShow, "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface OnProfileCardOpenCallback {
    void onClose();

    void onShow();
}
