package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class qd implements SingleObserver<Response<UploadResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UploadScreenMethod f63621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f63622b;

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        UploadScreenMethod.b r101 = new UploadScreenMethod.b();
        this.f63621a.k(r101);
        ALogger.e("UploadScreenMethod", "upload error", r100);
        UploadScreenMethod.j(this.f63621a);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f63621a.f63277a = r100;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(Response<UploadResult> r100) {
        Response<UploadResult> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        UploadScreenMethod r102 = this.f63621a;
        UploadResult r103 = r101.data;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getUri();
    L6:
        String r106 = this.f63622b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r106, "filepath");
        UploadScreenMethod.b r107 = new UploadScreenMethod.b();
        if (r105 != null) goto L9;
    L12:
        boolean r108 = true;
    L13:
        if (r108 == false) goto L15;
        r102.k(r107);
    L16:
        StringBuilder r109 = new StringBuilder("upload success,uri is ");
        UploadResult r110 = r101.data;
        if (r110 == null) goto L19;
        r104 = r110.getUri();
    L19:
        r109.append(r104);
        ALogger.i("UploadScreenMethod", r109.toString());
        UploadScreenMethod.j(this.f63621a);
        return;
    L15:
        r107.b(r105);
        r107.a(r106);
        r102.finishWithResult(new UploadScreenMethod.c(0, "成功", r107));
        goto L16
    L9:
        if (r105.length() == 0) goto L12;
        r108 = false;
        goto L13
    L5:
        r105 = null;
        goto L6
    }

    public qd(UploadScreenMethod r100, String r101) {
        this.f63621a = r100;
        this.f63622b = r101;
    }
}
