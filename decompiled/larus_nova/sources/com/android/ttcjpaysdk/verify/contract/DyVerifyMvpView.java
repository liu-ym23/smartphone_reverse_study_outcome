package com.android.ttcjpaysdk.verify.contract;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001d\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u0001H\bH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/contract/DyVerifyMvpView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onVerifyFailure", "", "errorCode", "", "errorMsg", "onVerifySuccess", ExifInterface.GPS_DIRECTION_TRUE, "response", "(Ljava/lang/Object;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DyVerifyMvpView extends MvpView {
    void onVerifyFailure(String r100, String r101);

    <T> void onVerifySuccess(T r100);
}
