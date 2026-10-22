package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends BaseJsBridgeMethodFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WelfareAudienceWelfareServiceWidget f117649a;

    public static final class a extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f117650a;

        public a(b r100) {
            this.f117650a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final JSONObject invoke(JSONObject r100, CallContext r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            DataCenter r102 = this.f117650a.f117649a.dataCenter;
            long r103 = 0;
            if (r102 == null) goto L7;
            Long r104 = (Long) r102.get("data_live_welfare_donation_click_count", 0L);
            if (r104 == null) goto L7;
            r103 = r104.longValue();
        L7:
            DataCenter r105 = this.f117650a.f117649a.dataCenter;
            if (r105 == null) goto L10;
            r105.put("data_live_welfare_donation_click_count", Long.valueOf(r103 + 1));
        L10:
            this.f117650a.f117649a.getClass();
            JSONObject r106 = new JSONObject();
            r106.put("code", 0);
            return r106;
        }
    }

    public b(WelfareAudienceWelfareServiceWidget r100) {
        this.f117649a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideStatelessMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        HashMap r101 = new HashMap();
        r101.put("donationButtonClick", new a(this));
        return r101;
    }
}
