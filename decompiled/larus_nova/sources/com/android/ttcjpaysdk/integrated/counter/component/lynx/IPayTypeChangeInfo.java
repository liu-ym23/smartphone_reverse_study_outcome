package com.android.ttcjpaysdk.integrated.counter.component.lynx;

import com.android.ttcjpaysdk.base.CJPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "", "getCombineInfo", "", "getPayTypeIndex", "getPtCode", CJPayConstant.CJ_PAY_SHARE_PARAMS_KEY_IS_ASSET_STANDARD, "", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPayTypeChangeInfo {
    String getCombineInfo();

    String getPayTypeIndex();

    String getPtCode();

    boolean isAssetStd();
}
