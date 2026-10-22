package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetVisualEventTrackingSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getVisualEventTrackingSettings")
public final class GetVisualEventTrackingSettingsMethod extends w20.y1<JsonObject, GetVisualEventTrackingSettingsResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JsonArray f63247a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetVisualEventTrackingSettingsMethod$VirtualEventSettingsApi;", "", "", "aid", "Lcom/bytedance/retrofit2/Call;", "Lcom/google/gson/JsonObject;", "getSettingsApi", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface VirtualEventSettingsApi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f63248a = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final VirtualEventSettingsApi f63249a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ a f63250b = null;

            public a() {
            }

            static {
                f63250b = new a();
                f63249a = (VirtualEventSettingsApi) RetrofitUtils.createSsService("https://logview.zijieapi.com", VirtualEventSettingsApi.class);
            }
        }

        static {
            f63248a = a.f63250b;
        }

        @GET("/api/config/get_online_configs/")
        Call<JsonObject> getSettingsApi(@Query("appId") String r100);
    }

    public static final class a {
    }

    static {
    }

    public GetVisualEventTrackingSettingsMethod() {
    }

    public final void j(JsonArray r100) {
        if (r100 != null) goto L4;
        finishWithFailure();     // Catch: Exception -> L10
        return;
    L4:
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L10
        Iterator<JsonElement> r102 = r100.iterator();     // Catch: Exception -> L10
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.add(r102.next().toString());     // Catch: Exception -> L10
        goto L6
    L8:
        GetVisualEventTrackingSettingsResultModel r103 = new GetVisualEventTrackingSettingsResultModel();     // Catch: Exception -> L10
        r103.a(GetVisualEventTrackingSettingsResultModel.Code.Success);     // Catch: Exception -> L10
        GetVisualEventTrackingSettingsResultModel.a r104 = new GetVisualEventTrackingSettingsResultModel.a();     // Catch: Exception -> L10
        GetVisualEventTrackingSettingsResultModel.b r105 = new GetVisualEventTrackingSettingsResultModel.b();     // Catch: Exception -> L10
        r105.a(r101);     // Catch: Exception -> L10
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L10
        r104.a(r105);     // Catch: Exception -> L10
        r103.b(r104);     // Catch: Exception -> L10
        finishWithResult(r103);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        finishWithFailure(e);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonArray r102 = f63247a;
        if (r102 == null) goto L5;
        j(r102);
        return;
    L5:
        VirtualEventSettingsApi.f63248a.getClass();
        VirtualEventSettingsApi.a.f63249a.getSettingsApi("1128").enqueue(new j5(this));
    }
}
