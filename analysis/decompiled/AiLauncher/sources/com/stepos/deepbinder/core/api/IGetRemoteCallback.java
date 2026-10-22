package com.stepos.deepbinder.core.api;

import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/deepbinder/core/api/IGetRemoteCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "getRemoteCallback", "()Ljava/lang/Object;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IGetRemoteCallback<T> {
    @Keep
    T getRemoteCallback();
}
