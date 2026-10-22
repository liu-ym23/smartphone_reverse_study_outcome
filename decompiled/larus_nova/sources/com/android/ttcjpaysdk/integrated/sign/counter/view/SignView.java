package com.android.ttcjpaysdk.integrated.sign.counter.view;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.integrated.sign.counter.data.SignCreateResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/view/SignView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onSignCreateFailed", "", "message", "", "onSignCreateSuccess", "response", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignCreateResponse;", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SignView extends MvpView {
    void onSignCreateFailed(String r100);

    void onSignCreateSuccess(SignCreateResponse r100);
}
