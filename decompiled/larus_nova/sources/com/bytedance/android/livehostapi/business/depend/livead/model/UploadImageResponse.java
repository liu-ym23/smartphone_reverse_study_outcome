package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.bytedance.android.live.base.model.user.CoverImageModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/UploadImageResponse;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "()V", "imageModel", "Lcom/bytedance/android/live/base/model/user/CoverImageModel;", "getImageModel", "()Lcom/bytedance/android/live/base/model/user/CoverImageModel;", "setImageModel", "(Lcom/bytedance/android/live/base/model/user/CoverImageModel;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UploadImageResponse extends BaseResponse {
    private CoverImageModel imageModel;

    public UploadImageResponse() {
    }

    public final CoverImageModel getImageModel() {
        return this.imageModel;
    }

    public final void setImageModel(CoverImageModel r100) {
        this.imageModel = r100;
    }
}
