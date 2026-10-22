package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AddTopicToPublishResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "addTopicToPublish")
public final class c0 extends w20.f<w20.k7, AddTopicToPublishResultModel> {

    public static final class a {
    }

    static {
    }

    public c0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.k7 r102 = (w20.k7) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostBusiness r103 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r103 == null) goto L15;
        JsonObject r104 = new JsonObject();
        JsonArray r105 = new JsonArray();
        List<w20.k7.a> r106 = r102.a();
        if (r106 == null) goto L20;
        Iterator<w20.k7.a> r107 = r106.iterator();
    L9:
        if (r107.hasNext() == false) goto L14;
        w20.k7.a r108 = r107.next();
        JsonObject r109 = new JsonObject();
        String r110 = r108.a();
        if (r110 != null) goto L13;
        r110 = "";
    L13:
        r109.addProperty("name", r110);
        Unit r111 = Unit.INSTANCE;
        r105.add(r109);
        goto L9
    L14:
        Unit r112 = Unit.INSTANCE;
        r104.add("topic_list", r105);
        r103.addTopicToPublish(r104);
        goto L15
    L20:
        return;
    L15:
        finishWithSuccess();
    }
}
