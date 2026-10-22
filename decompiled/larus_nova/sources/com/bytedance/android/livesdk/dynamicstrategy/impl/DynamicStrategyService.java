package com.bytedance.android.livesdk.dynamicstrategy.impl;

import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.x;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.y;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import com.bytedance.android.livesdk.dynamicstrategy.impl.source.DynamicStrategyApi;
import com.bytedance.android.livesdk.dynamicstrategy.impl.source.DynamicStrategyFetcher;
import com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.f;
import com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.g;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import ju1.h;
import ju1.l;
import ju1.n;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nu1.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\rH\u0016J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%0\u0006H\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/DynamicStrategyService;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyService;", "", "init", "", "eventKey", "", "eventParams", "sendNfaEvent", "", "forceFetchFull", "updateDynamicStrategyInfo", "strategyName", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a0;", "getDynamicStrategyRule", "express", "", PerfLog.PARAM_KEY_CONTEXT_ID, "executeExpress", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lju1/h;", "parseStrategy", "strategyRule", "parseStrategyRule", "Lju1/n;", "executeStrategy", "scene", "Lju1/l;", "parseScene", "executeScene", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext;", "createLiveRoomStrategyContext", "getGlobalStrategyContext", "Lis2/b;", "getFeatureBackendHandler", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/m;", "feature", "mockFeature", "getMockFeature", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DynamicStrategyService implements IDynamicStrategyService {
    public static final a Companion = null;
    private static boolean isFirstTimeCreateContext;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        isFirstTimeCreateContext = true;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public is2.b getFeatureBackendHandler() {
        return new g();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public IDynamicStrategyContext getGlobalStrategyContext() {
        return GlobalDynamicStrategyContext.INSTANCE.init();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public Map<String, m> getMockFeature() {
        boolean r100 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.f123267a;
        return com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.f123271e;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public void init() {
        new com.bytedance.android.livesdk.dynamicstrategy.impl.source.b().run();
    }

    public DynamicStrategyService() {
        k.l(IDynamicStrategyService.class, this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public IDynamicStrategyContext createLiveRoomStrategyContext(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        long r101 = System.currentTimeMillis();
        AbsDynamicStrategyContext r102 = new LiveRoomDynamicStrategyContext(r100).init();
        long r103 = System.currentTimeMillis() - r101;
        int r104 = lu1.k.f510820a;
        String r105 = String.valueOf(a0.n(r100).getRoomId());
        String r106 = String.valueOf(hashCode());
        Intrinsics.checkNotNullParameter(r105, "roomId");
        Intrinsics.checkNotNullParameter(r106, "contextTag");
        lu1.k.g("DynamicStrategy_cost", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "context init"), TuplesKt.to("room_id", r105), TuplesKt.to("context_tag", r106), TuplesKt.to(ChameleonOpenTracker.ParamKey.COST, String.valueOf(r103))}));
        int r107 = DynamicStrategyMonitor.f123031a;
        boolean r108 = isFirstTimeCreateContext;
        JSONObject r109 = new JSONObject();
        r109.put("isFirst", r108);
        LiveMonitor.a r110 = DynamicStrategyMonitor.a(DynamicStrategyMonitor.Event.StrategyContextInitContext);
        r110.b(r109);
        r110.h(r103);
        r110.a().report();
        isFirstTimeCreateContext = false;
        return r102;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0 getDynamicStrategyRule(String r100) {
        Intrinsics.checkNotNullParameter(r100, "strategyName");
        boolean r101 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.f123260a;
        Iterator r102 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (TextUtils.equals(((com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0) r103).strategyName, r100) == false) goto L4;
    L10:
        return (com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0) r103;
    L8:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public void mockFeature(m r100) {
        Intrinsics.checkNotNullParameter(r100, "feature");
        boolean r101 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.f123267a;
        Intrinsics.checkNotNullParameter(r100, "feature");
        String r102 = r100.name;
        if (r102 == null) goto L7;
        com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.f123271e.put(r102, r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public l parseScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Map<String, l> r101 = mu1.a.f515720a;
        Intrinsics.checkNotNullParameter(r100, "sceneStr");
        l r102 = (l) ((LinkedHashMap) mu1.a.f515720a).get(r100);
        if (r102 != null) goto L17;
        Iterator r103 = ((ArrayList) mu1.a.f515721b).iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        l r104 = ((e) r103.next()).parse();
        if (r104 == null) goto L7;
        mu1.a.f515720a.put(r100, r104);
        return r104;
    L11:
        return null;
    L17:
        return r102;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public h parseStrategy(String r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        return mu1.b.d(r100);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public h parseStrategyRule(com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "strategyRule");
        return mu1.b.c(r100);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public void updateDynamicStrategyInfo(boolean r100) {
        DynamicStrategyFetcher.INSTANCE.updateStrategyWhenUserChanged(null, r100);
        boolean r101 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.f123267a;
        if (com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.f123267a == true) goto L5;
        com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.d();
    L5:
        Boolean r102 = ku1.e.f506183a.getValue();
        lu1.k.a("CloudFactorStore onLoginChanged");
        DynamicStrategyApi r103 = (DynamicStrategyApi) com.bytedance.android.live.network.c.b().e(DynamicStrategyApi.class);
        if (r103 == null) goto L16;
        String r104 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.f123269c;
        String r105 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.b()).second;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        Observable<BaseResponse<y, x>> r106 = r103.getFeature(4, r104, "", r105, r102.booleanValue());
        if (r106 == null) goto L17;
        Observable<BaseResponse<y, x>> r107 = r106.subscribeOn(Schedulers.io());
        if (r107 == null) goto L18;
        r107.subscribe(new com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.e(r102), f.f123278a);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public Object executeExpress(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "express");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return qu1.b.a(r100, r101);
    L5:
        e = move-exception;
        int r102 = lu1.k.f510820a;
        lu1.k.f("external_call ", r100, e);
        int r103 = DynamicStrategyMonitor.f123031a;
        String r104 = e.getMessage();
        if (r104 != null) goto L9;
        r104 = "express error";
    L9:
        DynamicStrategyMonitor.d("external_call", "unknown", r100, r104);
        return null;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public boolean executeScene(l r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return mu1.a.a(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public n executeStrategy(h r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return mu1.b.b(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public void sendNfaEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventKey");
        Intrinsics.checkNotNullParameter(r101, "eventParams");
        com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.f.f123235b.getClass();
        com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.f.a(r100, r101);
    }
}
