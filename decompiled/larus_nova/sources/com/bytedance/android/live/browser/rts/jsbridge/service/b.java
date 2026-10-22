package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import p30.g;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements z<JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f64174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f64175b;

    public static final class a implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f64176a;

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void a(JSONObject r100) {
        }

        public a(b r100) {
            this.f64176a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onFailed(Throwable r100) {
            this.f64176a.f64175b.invoke(new g("", RTSLiveJSBResponseCode.FAILED, ""));
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onSucceed(Object r100) {
            if ((r100 instanceof JsonObject) == false) goto L15;
            e.a r101 = e.f64183a;
            JsonObject r102 = (JsonObject) r100;
            JsonElement r103 = r102.get("data");
            if ((r103 instanceof JsonObject) == true) goto L7;
            r103 = null;
        L7:
            JsonObject r104 = (JsonObject) r103;
            if (r104 != null) goto L10;
            r104 = new JsonObject();
        L10:
            r101.getClass();
            Map r105 = e.a.c(r104);
            Function1 r106 = this.f64176a.f64175b;
            RTSLiveJSBResponseCode r107 = RTSLiveJSBResponseCode.SUCCESS;
            Object r108 = r102.get("key");
            if (r108 != null) goto L13;
            r108 = "";
        L13:
            r106.invoke(new g(r108, r107, r105));
            return;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final z.a getCallBack() {
        return new a(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final CallContext a() {
        return this.f64174a;
    }

    public b(CallContext r100, Function1 r101) {
        this.f64174a = r100;
        this.f64175b = r101;
    }
}
