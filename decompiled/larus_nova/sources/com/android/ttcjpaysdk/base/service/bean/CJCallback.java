package com.android.ttcjpaysdk.base.service.bean;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import tf4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/CJCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "", "onSuccess", "(Ljava/lang/Object;)V", "Ltf4/a;", "err", LynxVideoManagerLite.EVENT_ON_ERROR, "base-context_release"}, k = 1, mv = {1, 6, 0})
public interface CJCallback<T> {
    void onError(a r100);

    void onSuccess(T r100);
}
