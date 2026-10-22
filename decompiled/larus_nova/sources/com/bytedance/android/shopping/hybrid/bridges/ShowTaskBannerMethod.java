package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.widgets.LynxTaskBanner;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ShowTaskBannerMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowTaskBannerMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f176217e = 0;

    public static final class a {
        public static void a(Context r210, JSONObject r211, Function2 r212) {
            Intrinsics.checkNotNullParameter(r211, "params");
            Intrinsics.checkNotNullParameter(r212, "callback");
            String r100 = r211.optString("task_enter_from");
            String r101 = r211.optString(AiProactiveTaskViewModel.PARAM_TASK_TYPE);
            JSONObject r102 = r211.optJSONObject("extra");
            JSONObject r110 = r211.optJSONObject("task_request_params");
            JSONObject r111 = r211.optJSONObject("log_extra");
            if (r111 == null) goto L5;
            String r112 = r111.optString("page_name");
        L7:
            if (r111 == null) goto L9;
            String r103 = r111.optString("source_page");
        L10:
            JSONObject r104 = r211.optJSONObject("frame");
            if (r110 != null) goto L21;
            if (r101 != null) goto L14;
        L17:
            boolean r213 = true;
        L18:
            if (r213 == false) goto L21;
            r212.invoke(null, "task_request_params or task_type should not be empty");
            return;
        L14:
            if (r101.length() == 0) goto L17;
            r213 = false;
        L21:
            if (r210 == null) goto L25;
            Map r105 = MapsKt.mapOf(new Pair[]{TuplesKt.to("frame", r104), TuplesKt.to("task_enter_from", r100), TuplesKt.to(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r101), TuplesKt.to("page_name", r112), TuplesKt.to("source_page", r103), TuplesKt.to("log_extra", r111), TuplesKt.to("extra", r102), TuplesKt.to("task_request_params", r110)});
            Map<String, LynxTaskBanner> r106 = LynxTaskBanner.f44339i;
            r212.invoke(LynxTaskBanner.a.a(r210, r105, null), null);
            return;
        L25:
            return;
        L9:
            r103 = null;
            goto L10
        L5:
            r112 = null;
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecomShowTaskBanner";
    }

    public ShowTaskBannerMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, final ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        final JSONObject r102 = r100.optJSONObject("frame");
        a.a(getContext(), r100, new ShowTaskBannerMethod$handle$1(r101, r102));
    }
}
