package com.android.ttcjpaysdk.fastpay.view;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayQueryBean;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayResponseBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/view/FastPayView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onFastPayFailure", "", "code", "", "msg", "onFastPaySuccess", "responseBean", "Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayResponseBean;", "onQueryFailure", "onQuerySuccess", "Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayQueryBean;", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FastPayView extends MvpView {
    void onFastPayFailure(String r100, String r101);

    void onFastPaySuccess(FastPayResponseBean r100);

    void onQueryFailure(String r100, String r101);

    void onQuerySuccess(FastPayQueryBean r100);
}
