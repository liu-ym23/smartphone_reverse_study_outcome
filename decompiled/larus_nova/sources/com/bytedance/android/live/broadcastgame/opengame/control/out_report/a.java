package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements SingleObserver<Response<UploadResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReportSubmitControl f59909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f59910b;

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.f59909a.getActivity() == null) goto L5;
        ExceptionUtils.handleException(this.f59909a.getActivity(), r100);
    L5:
        com.bytedance.android.live.broadcastgame.opengame.control.report.c r101 = this.f59909a.f59902b;
        if (r101 == null) goto L9;
        r101.i();
        return;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(Response<UploadResult> r100) {
        Response<UploadResult> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        r101.data.setPath(this.f59910b);
        ReportSubmitControl r102 = this.f59909a;
        UploadResult r103 = r101.data;
        r102.f59904d = r103;
        com.bytedance.android.live.broadcastgame.opengame.control.report.c r104 = r102.f59902b;
        if (r104 == null) goto L6;
        r104.J(r103);
        return;
    }

    public a(ReportSubmitControl r100, String r101) {
        this.f59909a = r100;
        this.f59910b = r101;
    }
}
