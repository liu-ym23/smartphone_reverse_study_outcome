package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendJoinMatrixInvitationResultModel;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;

/* JADX INFO: loaded from: classes46.dex */
public final class f1 implements IMiddlewareHostAction.LiveMatrixInviteCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g1 f74218a;

    public f1(g1 r100) {
        this.f74218a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.LiveMatrixInviteCallback
    public final void onResult(boolean r100) {
        SendJoinMatrixInvitationResultModel r101 = new SendJoinMatrixInvitationResultModel();
        if (r100 == false) goto L6;
        r101.a(SendJoinMatrixInvitationResultModel.Code.Success);
        SendJoinMatrixInvitationResultModel.a r102 = new SendJoinMatrixInvitationResultModel.a();
        r102.a(Boolean.valueOf(r100));
        r101.b(r102);
        this.f74218a.finishWithResult(r101);
        return;
    }
}
