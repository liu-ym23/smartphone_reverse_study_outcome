package com.bytedance.android.shopping.api.mall;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function9;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016Jx\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052^\u0010\u000e\u001aZ\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t0\u000fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J!\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0003H\u0016J\u001a\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallDeliveryService;", "", "checkCanShowInterceptDialog", "", "enterFrom", "", "channelTag", "uniqueId", "clearShareData", "", "shareKey", "fetchDeliveryCentralize", "deliverySessionId", "originSchema", "callBack", "Lkotlin/Function9;", "", "", "getShareData", "notifyDeliveryEventBlockEnd", "forbidExitAnimation", "registerDeliveryPopupListener", "url", "pageName", "sendPageDismiss", "sessionID", "forceReport", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "sendPageShow", "setShareData", "shareData", "showDeliveryInterceptDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallDeliveryService {
    boolean checkCanShowInterceptDialog(String r100, String r101, String r102);

    void clearShareData(String r100);

    void fetchDeliveryCentralize(String r100, String r101, Function9<? super Integer, ? super String, ? super String, ? super String, ? super Map<String, ? extends Object>, ? super Integer, ? super String, ? super String, ? super String, Unit> r102);

    String getShareData(String r100);

    void notifyDeliveryEventBlockEnd(boolean r100);

    void registerDeliveryPopupListener(String r100, String r101);

    void sendPageDismiss(String r100, Boolean r101);

    void sendPageShow(String r100, boolean r101);

    void setShareData(String r100, String r101);

    void showDeliveryInterceptDialog(Context r100);
}
