package com.bytedance.android.livehostapi.business.depend;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/ISimpleCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onResult", "", "result", "(Ljava/lang/Object;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISimpleCallback<T> {
    void onResult(T r100);
}
