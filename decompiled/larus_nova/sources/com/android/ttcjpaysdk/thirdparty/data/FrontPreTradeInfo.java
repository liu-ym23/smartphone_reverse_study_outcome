package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "pre_trade_info", "Lcom/android/ttcjpaysdk/thirdparty/data/PreTradeInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/data/PreTradeInfo;)V", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FrontPreTradeInfo implements CJPayObject, Serializable {
    public String code;
    public String msg;
    public PreTradeInfo pre_trade_info;

    public FrontPreTradeInfo() {
        this(null, null, null, 7, null);
    }

    public FrontPreTradeInfo(String r100, String r101, PreTradeInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "pre_trade_info");
        this.code = r100;
        this.msg = r101;
        this.pre_trade_info = r102;
    }

    public /* synthetic */ FrontPreTradeInfo(String r110, String r111, PreTradeInfo r112, int r113, DefaultConstructorMarker r210) {
        String r100 = "";
        if ((r113 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r113 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r113 & 4) == 0) goto L13;
        PreTradeInfo r102 = new PreTradeInfo(null, null, null, null, null, null, null, null, null, 511, null);
    L14:
        this(r101, r100, r102);
        return;
    L13:
        r102 = r112;
        goto L14
    L5:
        r101 = r110;
        goto L7
    }
}
