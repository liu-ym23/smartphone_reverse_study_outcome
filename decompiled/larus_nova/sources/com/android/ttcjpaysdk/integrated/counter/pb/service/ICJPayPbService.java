package com.android.ttcjpaysdk.integrated.counter.pb.service;

import com.android.ttcjpaysdk.integrated.counter.data.BizContentRequestParams;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.io.InputStream;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/pb/service/ICJPayPbService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getTradeCreateRequestDataArray", "", "bizContentParams", "Lcom/android/ttcjpaysdk/integrated/counter/data/BizContentRequestParams;", "fieldMap", "", "", "parseTradeCreateResponseDataByPB", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterResponseBean;", "data", "Ljava/io/InputStream;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayPbService extends ICJService {
    byte[] getTradeCreateRequestDataArray(BizContentRequestParams r100, Map<String, String> r101);

    CounterResponseBean parseTradeCreateResponseDataByPB(InputStream r100);
}
