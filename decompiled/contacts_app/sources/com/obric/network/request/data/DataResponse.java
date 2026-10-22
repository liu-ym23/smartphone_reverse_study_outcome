package com.obric.network.request.data;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/network/request/data/DataResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/network/request/data/BaseResponse;", "()V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataResponse<T> extends BaseResponse {
    private T data;

    public DataResponse() {
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T r1) {
        this.data = r1;
    }
}
