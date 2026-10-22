package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetAnchorTopicParamsResultModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e0 extends w20.q2<JsonObject, LiveGetAnchorTopicParamsResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f118785a;

    public static final class a {
    }

    static {
    }

    public e0(DataCenter r100) {
        this.f118785a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o.b(this.f118785a);
        String r103 = com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o.a(this.f118785a);
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("live_type", r102);
        r104.put("live_sub_type", r103);
        LiveGetAnchorTopicParamsResultModel r105 = new LiveGetAnchorTopicParamsResultModel();
        r105.a(LiveGetAnchorTopicParamsResultModel.Code.Success);
        LiveGetAnchorTopicParamsResultModel.a r106 = new LiveGetAnchorTopicParamsResultModel.a();
        JsonObject r107 = new JsonObject();
        Iterator r108 = r104.entrySet().iterator();
    L4:
        if (r108.hasNext() == false) goto L6;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.addProperty((String) r109.getKey(), (String) r109.getValue());
        goto L4
    L6:
        Unit r110 = Unit.INSTANCE;
        r106.a(r107);
        r105.b(r106);
        finishWithResult(r105);
    }
}
