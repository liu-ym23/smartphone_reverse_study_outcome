package com.bytedance.android.livesdkapi.service;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.buynow.IECBuyNowService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H&J&\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IMiddlewareHostCommerceServiceLive;", "Lcom/bytedance/android/live/base/IService;", "getBuyNowService", "Lcom/bytedance/android/livesdkapi/buynow/IECBuyNowService;", "roomEnter", "", "roomId", "", "anchorId", "ecomLiveParams", "eventParmas", "", "setAddress", "addressId", "addressType", "", "addressStrategyType", "setEnterRoomInfo", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "businessName", "businessArgs", "Landroid/os/Bundle;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareHostCommerceServiceLive extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static IECBuyNowService getBuyNowService(IMiddlewareHostCommerceServiceLive r100) {
            return null;
        }

        public static void roomEnter(IMiddlewareHostCommerceServiceLive r100, String r101, String r102, String r103, Map<String, String> r104) {
            Intrinsics.checkNotNullParameter(r101, "roomId");
            Intrinsics.checkNotNullParameter(r102, "anchorId");
            Intrinsics.checkNotNullParameter(r104, "eventParmas");
        }
    }

    IECBuyNowService getBuyNowService();

    void roomEnter(String r100, String r101, String r102, Map<String, String> r103);

    void setAddress(String r100, int r101, String r102);

    void setEnterRoomInfo(Context r100, String r101, Bundle r102);
}
