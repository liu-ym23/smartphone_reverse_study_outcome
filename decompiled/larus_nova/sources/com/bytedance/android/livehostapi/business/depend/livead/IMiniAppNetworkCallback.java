package com.bytedance.android.livehostapi.business.depend.livead;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/IMiniAppNetworkCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "error", "", "onSuccess", "response", "(Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiniAppNetworkCallback<T extends BaseResponse> {
    void onError(Throwable r100);

    void onSuccess(T r100);
}
