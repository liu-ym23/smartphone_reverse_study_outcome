package com.bytedance.android.livesdkapi.service;

import androidx.exifinterface.media.ExifInterface;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onFailed", "", LynxError.LYNX_THROWABLE, "", "onSuccess", "data", "(Ljava/lang/Object;)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCallback<T> {
    void onFailed(Throwable r100);

    void onSuccess(T r100);
}
