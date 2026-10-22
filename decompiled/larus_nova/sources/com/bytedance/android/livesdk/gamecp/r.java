package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdkapi.service.gamecp.OnVerifyResultListenerProxy;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements OnVerifyResultListenerProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bw.t f125462a;

    public r(com.bytedance.android.gamecp.business.props.r r100) {
        this.f125462a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.gamecp.OnVerifyResultListenerProxy
    public final void onVerifyResult(int r100) {
        bw.t r101 = this.f125462a;
        if (r101 == null) goto L6;
        r101.onVerifyResult(r100);
        return;
    }
}
