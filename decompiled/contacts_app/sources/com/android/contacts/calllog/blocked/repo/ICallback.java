package com.android.contacts.calllog.blocked.repo;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: ICallback.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/android/contacts/calllog/blocked/repo/ICallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onError", "", "throwable", "", "onSuccess", "data", "(Ljava/lang/Object;)V", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ICallback<T> {
    void onError(Throwable r1);

    void onSuccess(T r1);
}
