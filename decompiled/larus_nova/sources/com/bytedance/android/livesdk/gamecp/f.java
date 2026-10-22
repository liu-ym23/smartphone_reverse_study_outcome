package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livehostapi.platform.IHostAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements IHostAction.IMConversationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yv.a.InterfaceC8393a f125436a;

    public f(com.bytedance.android.gamecp.business.gamedetail.component.fansgroup.c.a r100) {
        this.f125436a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAction.IMConversationCallback
    public final void onFailure(JSONObject r100) {
        yv.a.InterfaceC8393a r101 = this.f125436a;
        if (r101 == null) goto L6;
        r101.onFailure(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAction.IMConversationCallback
    public final void onSuccess(JSONObject r100) {
        yv.a.InterfaceC8393a r101 = this.f125436a;
        if (r101 == null) goto L6;
        r101.onFailure(r100);
        return;
    }
}
