package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveCloudCollaborateActionResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.m2;
import w20.na;

/* JADX INFO: loaded from: classes46.dex */
public final class e0 extends m2<na, LiveCloudCollaborateActionResultModel> {
    public e0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        na r102 = (na) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        JsonObject r104 = r102.a();
        if (r104 == null) goto L12;
        JsonElement r105 = r104.get("is_accept");
        if (r105 == null) goto L12;
        boolean r106 = true;
        if (r105.getAsBoolean() != true) goto L12;
    L13:
        ALogger.i("LiveCloudCollaborateActionMethod", "type = " + r103 + ", is_accept=" + r106);
        if (Intrinsics.areEqual(r103, "acceptCloudCollaborateInvite") == false) goto L20;
        IInteractService r107 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r107 == null) goto L20;
        z30.b r108 = r107.getCloudGroupLiveService();
        if (r108 == null) goto L20;
        r108.a(r106, "");
    L20:
        LiveCloudCollaborateActionResultModel r109 = new LiveCloudCollaborateActionResultModel();
        r109.a(LiveCloudCollaborateActionResultModel.Code.Success);
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r109);
        return;
    L12:
        r106 = false;
        goto L13
    }
}
