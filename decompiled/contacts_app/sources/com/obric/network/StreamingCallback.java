package com.obric.network;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.retrofit2.Call;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import kotlin.Metadata;

/* JADX INFO: compiled from: NetWorkClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J#\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/network/StreamingCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onError", "", "t", "", "call", "Lcom/bytedance/retrofit2/Call;", "onStreamReady", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "(Ljava/lang/Object;Lcom/bytedance/retrofit2/Call;)V", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface StreamingCallback<T> {
    void onError(Throwable r1, Call<T> r2);

    void onStreamReady(T r1, Call<T> r2);
}
