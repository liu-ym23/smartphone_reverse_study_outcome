package com.android.ttcjpaysdk.bdpay.outer.authorize.model;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0002J.\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bJ.\u0010\r\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/outer/authorize/model/CJPayOuterAuthorizeModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "addRequest", "", ExifInterface.GPS_DIRECTION_TRUE, "params", "", "", e.f25671s, "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "bindBytePay", "fetchAuthProtocol", "bdpay-outer-authorize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOuterAuthorizeModel extends MvpModel {
    public CJPayOuterAuthorizeModel() {
    }

    public final <T> void bindBytePay(Map<String, String> r100, ICJPayNetWorkCallback<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        addRequest(r100, "tp.customer.bind_bytepay", r101);
    }

    public final <T> void fetchAuthProtocol(Map<String, String> r100, ICJPayNetWorkCallback<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        addRequest(r100, "tp.customer.query_bind_authorize_info", r101);
    }

    private final <T> void addRequest(Map<String, String> r100, String r101, ICJPayNetWorkCallback<T> r102) {
        ICJPayIntegratedCounterService r103 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        if (r103 != null) goto L5;
        return;
    L5:
        String r104 = r103.getIntegratedCounterUrl("gateway-u", r101);
        addRequest(CJPayNetworkManager.postForm(r104, r103.getIntegratedCounterHttpData(r100, r101, "0", ""), r103.getIntegratedCounterHttpHeader(r104, r101), r102));
    }
}
