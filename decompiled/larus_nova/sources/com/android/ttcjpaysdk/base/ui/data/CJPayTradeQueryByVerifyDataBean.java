package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayTradeQueryByVerifyDataBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", SendClosePdpEventParam.KEY_LYNX_URL, "", "(Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayTradeQueryByVerifyDataBean implements CJPayObject, Serializable {
    public String lynx_url;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayTradeQueryByVerifyDataBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CJPayTradeQueryByVerifyDataBean(String r100) {
        Intrinsics.checkNotNullParameter(r100, SendClosePdpEventParam.KEY_LYNX_URL);
        this.lynx_url = r100;
    }

    public /* synthetic */ CJPayTradeQueryByVerifyDataBean(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
