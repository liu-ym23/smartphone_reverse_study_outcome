package com.android.ttcjpaysdk.integrated.sign.counter.view;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.integrated.sign.counter.data.SignConfirmResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/view/SignConfirmView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onSignConfirmFailed", "", "message", "", "onSignConfirmSuccess", "result", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignConfirmResponse;", "onSignDyResult", "code", "data", "onSignQueryResult", "status", "", "errorCode", "errorMessage", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SignConfirmView extends MvpView {
    void onSignConfirmFailed(String r100);

    void onSignConfirmSuccess(SignConfirmResponse r100);

    void onSignDyResult(String r100, String r101);

    void onSignQueryResult(int r100, String r101, String r102);
}
