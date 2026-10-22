package com.android.ttcjpaysdk.integrated.counter.utils;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.integrated.counter.component.config.PayType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayWXUtils;", "", "()V", "getSupportEvokeChannels", "", "ptCode", "isAliH5", "", "tradeType", "isSupportWXApp", "isWXH5", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayWXUtils {
    public static final CJPayWXUtils INSTANCE = null;

    static {
        INSTANCE = new CJPayWXUtils();
    }

    private CJPayWXUtils() {
    }

    private final boolean isSupportWXApp() {
        CJPayHostInfo.Companion r100 = CJPayHostInfo.Companion;
        if (r100.curAppAsDouMall() == false) goto L5;
    L10:
        return true;
    L5:
        if (r100.curAppAsDouYin() == true) goto L10;
        if (r100.curAppAsDouhuo() == true) goto L10;
        return false;
    }

    public final String getSupportEvokeChannels(String r100) {
        if (Intrinsics.areEqual(r100, PayType.WX.getPtcode()) == false) goto L9;
        if (isSupportWXApp() == false) goto L7;
        return "APP,MINIAPP,H5,MINIH5";
    L7:
        return "H5,MINIH5";
    L9:
        if (Intrinsics.areEqual(r100, PayType.ALIPAY.getPtcode()) == false) goto L11;
        return "APP,H5";
    L11:
        return "";
    }

    public final boolean isAliH5(String r100) {
        return Intrinsics.areEqual(r100, CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_ALI_H5);
    }

    public final boolean isWXH5(String r100) {
        if (Intrinsics.areEqual(r100, CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_MWEB) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, CJPayConstant.TT_CJ_PAY_KEY_FOR_CHANNEL_MINIH5) == true) goto L8;
        return false;
    }
}
