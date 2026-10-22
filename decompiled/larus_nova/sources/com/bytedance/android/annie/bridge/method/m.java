package com.bytedance.android.annie.bridge.method;

import com.byted.cast.common.source.ISendResultListener;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadFileMethod f38723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f38724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f38725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f38726d;

    public m(DownloadFileMethod r100, String r101, int r102, Integer r103) {
        this.f38723a = r100;
        this.f38724b = r101;
        this.f38725c = r102;
        this.f38726d = r103;
    }

    public final void a() {
        DownloadFileMethod r100 = this.f38723a;
        DownloadFileMethod.DownloadFileResModel r101 = new DownloadFileMethod.DownloadFileResModel();
        String r102 = this.f38724b;
        int r103 = this.f38725c;
        Integer r104 = this.f38726d;
        r101.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);
        if (r102 != null) goto L5;
        r102 = ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_BODY_IS_NULL;
    L5:
        r101.f(r102);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(r103));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r106) == false) goto L13;
        r106 = 0;
    L13:
        r101.e((Integer) r106);
        Object r107 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r107) == false) goto L21;
        r107 = 0;
    L21:
        r101.a((Integer) r107);
        r101.c("");
        r100.finishWithResult(r101);
        return;
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
