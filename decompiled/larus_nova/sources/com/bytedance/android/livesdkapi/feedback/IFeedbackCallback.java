package com.bytedance.android.livesdkapi.feedback;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feedback/IFeedbackCallback;", "", "onClose", "", "onFallback", "errorCode", "", "errorMessage", "", "onLoadSucceed", "onSubmit", "isPositive", "", "toastInfo", "onUIUpdate", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFeedbackCallback {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onFallback(IFeedbackCallback r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
        }
    }

    void onClose();

    void onFallback(int r100, String r101);

    void onLoadSucceed();

    void onSubmit(boolean r100, String r101);

    void onUIUpdate();
}
