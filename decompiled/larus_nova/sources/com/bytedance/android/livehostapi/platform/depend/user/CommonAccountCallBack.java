package com.bytedance.android.livehostapi.platform.depend.user;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/user/CommonAccountCallBack;", ExifInterface.GPS_DIRECTION_TRUE, "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "errorCode", "", "errorMsg", "", "onResponse", "response", "(Ljava/lang/Object;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CommonAccountCallBack<T> {
    void onError(int r100, String r101);

    void onResponse(T r100);
}
