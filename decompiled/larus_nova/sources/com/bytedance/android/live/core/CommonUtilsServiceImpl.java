package com.bytedance.android.live.core;

import android.app.Activity;
import ao0.g;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livehostapi.SDKInitTracer;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class CommonUtilsServiceImpl implements IUtilsCommonService {

    public class a extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public long startTimeOfSDKInitTracer() {
        return SDKInitTracer.INSTANCE.getStartTime();
    }

    public CommonUtilsServiceImpl() {
        k.l(IUtilsCommonService.class, this);
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public String getBDNetWorkRequestTag() {
        return (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new a()).second;
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public JSONObject nQECommonParamsBuild() {
        return g.a();
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public float deviceScoreHelperGetScore(boolean r100) {
        return z0.b(r100);
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public int liveBrightnessUtilGetSystemValue(Activity r100) {
        ILiveBrightnessService r101 = (ILiveBrightnessService) k.f(ILiveBrightnessService.class);
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.getSystemValue(r100);
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public <T> T liveClientGetService(Class<T> r100) {
        return (T) c.b().e(r100);
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public void runOnUIThread(Function0<Unit> r100) {
        UtilityKotlinExtentionsKt.r(0, false, false, r100);
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public void showCenterToast(String r100) {
        f2.c(r100, 0);
    }

    @Override // com.bytedance.android.livesdkapi.api.IUtilsCommonService
    public void showSystemToast(String r100, int r101) {
        f2.j(r100, r101);
    }
}
