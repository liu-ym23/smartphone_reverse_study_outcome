package com.stepos.ability.net.biz;

import H7.c;
import com.stepos.ability.net.biz.model.AbilityInfoRsp;
import com.stepos.ability.net.biz.model.ApiResult;
import com.stepos.ability.net.biz.model.AppInfoRsp;
import com.stepos.ability.net.biz.model.CallToolCloudAbilityRequest;
import com.stepos.ability.net.biz.model.DeviceAppRequest;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import java.util.List;
import kotlin.Metadata;
import sa.InterfaceC1926a;
import sa.f;
import sa.i;
import sa.o;
import sa.t;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJD\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u000e\u0010\u000fJD\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00130\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u0016H§@¢\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u001c\u001a\u00020\u001b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/net/biz/ApiService;", "", "", "deviceId", "pkg", "Lcom/stepos/ability/net/biz/model/ApiResult;", "Lcom/stepos/ability/net/biz/model/AppInfoRsp;", "getAppInfo", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "abilityId", "toolName", AgentBusWakeContract.EXTRA_TRACE_ID, "Lcom/stepos/ability/net/biz/model/AbilityInfoRsp;", "getAbilityInfo", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "appName", QueryAlgorithmBundle.KEY_CATEGORY, "naturalLang", "", "getAbilityList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/net/biz/model/DeviceAppRequest;", "req", "", "uploadAbilities", "(Lcom/stepos/ability/net/biz/model/DeviceAppRequest;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/net/biz/model/CallToolCloudAbilityRequest;", "request", "callToolCloudAbility", "(Lcom/stepos/ability/net/biz/model/CallToolCloudAbilityRequest;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ApiService {
    static /* synthetic */ Object callToolCloudAbility$default(ApiService apiService, CallToolCloudAbilityRequest callToolCloudAbilityRequest, String str, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callToolCloudAbility");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return apiService.callToolCloudAbility(callToolCloudAbilityRequest, str, cVar);
    }

    static /* synthetic */ Object getAbilityInfo$default(ApiService apiService, String str, Long l, String str2, String str3, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAbilityInfo");
        }
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return apiService.getAbilityInfo(str, l, str2, str3, cVar);
    }

    @o("api/mcp/async/call-tool")
    Object callToolCloudAbility(@InterfaceC1926a CallToolCloudAbilityRequest callToolCloudAbilityRequest, @i("zy-trace-id") String str, c<? super ApiResult<Object>> cVar);

    @f("api/v1/ability/abilityInfo")
    Object getAbilityInfo(@t("deviceId") String str, @t("abilityId") Long l, @t("toolName") String str2, @i("zy-trace-id") String str3, c<? super ApiResult<AbilityInfoRsp>> cVar);

    @f("api/v1/ability/list")
    Object getAbilityList(@t("deviceId") String str, @t("appName") String str2, @t(QueryAlgorithmBundle.KEY_CATEGORY) String str3, @t("naturalLang") String str4, c<? super ApiResult<List<AbilityInfoRsp>>> cVar);

    @f("api/v1/ability/appInfo")
    Object getAppInfo(@t("deviceId") String str, @t("packageName") String str2, c<? super ApiResult<AppInfoRsp>> cVar);

    @o("api/v1/ability/record")
    Object uploadAbilities(@InterfaceC1926a DeviceAppRequest deviceAppRequest, c<? super ApiResult<Boolean>> cVar);
}
