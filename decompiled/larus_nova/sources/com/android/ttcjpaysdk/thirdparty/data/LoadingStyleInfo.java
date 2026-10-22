package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPaySecurityLoadingStyleInfo;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/LoadingStyleInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "loading_style_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo;", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoadingStyleInfo implements CJPayObject, Serializable {
    public CJPaySecurityLoadingStyleInfo loading_style_info;

    public LoadingStyleInfo() {
        this.loading_style_info = new CJPaySecurityLoadingStyleInfo();
    }
}
