package com.bytedance.android.livesdk.dynamicstrategy.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import is2.b;
import java.util.Map;
import ju1.h;
import ju1.l;
import ju1.n;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@ServiceLookup("com.bytedance.android.livesdk.dynamicstrategy.impl.DynamicStrategyService")
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J&\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H&J&\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0004H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\rH&J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H&J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0004H&J$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H&J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH&J\b\u0010\"\u001a\u00020 H&J\b\u0010$\u001a\u00020#H&J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H&J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%0\u0006H&¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyService;", "Lcom/bytedance/android/live/base/IService;", "", "init", "", "eventKey", "", "eventParams", "sendNfaEvent", "", "forceFetchFull", "updateDynamicStrategyInfo", "strategyName", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a0;", "getDynamicStrategyRule", "express", "", PerfLog.PARAM_KEY_CONTEXT_ID, "executeExpress", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lju1/h;", "parseStrategy", "strategyRule", "parseStrategyRule", "Lju1/n;", "executeStrategy", "scene", "Lju1/l;", "parseScene", "executeScene", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext;", "createLiveRoomStrategyContext", "getGlobalStrategyContext", "Lis2/b;", "getFeatureBackendHandler", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/m;", "feature", "mockFeature", "getMockFeature", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDynamicStrategyService extends IService {
    IDynamicStrategyContext createLiveRoomStrategyContext(DataCenter r100);

    Object executeExpress(String r100, Map<String, ? extends Object> r101);

    boolean executeScene(l r100, Map<String, ? extends Object> r101);

    n executeStrategy(h r100, Map<String, ? extends Object> r101);

    a0 getDynamicStrategyRule(String r100);

    b getFeatureBackendHandler();

    IDynamicStrategyContext getGlobalStrategyContext();

    Map<String, m> getMockFeature();

    void init();

    void mockFeature(m r100);

    l parseScene(String r100);

    h parseStrategy(String r100);

    h parseStrategyRule(a0 r100);

    void sendNfaEvent(String r100, Map<String, String> r101);

    void updateDynamicStrategyInfo(boolean r100);
}
