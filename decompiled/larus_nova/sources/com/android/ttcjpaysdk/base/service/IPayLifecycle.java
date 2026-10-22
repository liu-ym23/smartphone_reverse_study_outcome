package com.android.ttcjpaysdk.base.service;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\u00032\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IPayLifecycle;", "", "onConfirm", "", "errorInfo", "Lcom/android/ttcjpaysdk/base/service/IErrorInfo;", "onInitEnd", "onInitStart", "onPayMethodChange", "onPayMsgUpdate", "updateMsg", "", "Lcom/android/ttcjpaysdk/base/service/PayMsg;", "onRefreshEnd", "onRefreshStart", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPayLifecycle {
    void onConfirm(IErrorInfo r100);

    void onInitEnd(IErrorInfo r100);

    void onInitStart();

    void onPayMethodChange();

    void onPayMsgUpdate(Map<PayMsg, ? extends Object> r100);

    void onRefreshEnd(IErrorInfo r100);

    void onRefreshStart();
}
