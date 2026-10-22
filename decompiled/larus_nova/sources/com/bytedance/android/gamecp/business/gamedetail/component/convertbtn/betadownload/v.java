package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import com.ss.android.common.applog.EventVerify;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class v implements com.bytedance.android.gamecp.base.core.service.depend.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBetaDownloadWidget f54064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f54065b;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.t
    public final void onResult(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (Intrinsics.areEqual(r100, "install") == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100, EventVerify.TYPE_LAUNCH) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r100, "pause_download") == true) goto L13;
        NewBetaDownloadWidget r101 = this.f54064a;
        t r102 = this.f54065b;
        int r103 = NewBetaDownloadWidget.f53947y;
        r101.er(r102, false);
        return;
    }

    public v(NewBetaDownloadWidget r100, t r101) {
        this.f54064a = r100;
        this.f54065b = r101;
    }
}
