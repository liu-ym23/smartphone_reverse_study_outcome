package com.bytedance.android.annie.bridge.method;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadFileMethod f38743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f38744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f38745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f38746d;

    public p(DownloadFileMethod r100, Exception r101, int r102, Integer r103) {
        this.f38743a = r100;
        this.f38744b = r101;
        this.f38745c = r102;
        this.f38746d = r103;
    }

    public final void a() {
        DownloadFileMethod r100 = this.f38743a;
        DownloadFileMethod.DownloadFileResModel r101 = new DownloadFileMethod.DownloadFileResModel();
        Exception r102 = this.f38744b;
        int r103 = this.f38745c;
        Integer r104 = this.f38746d;
        r101.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);
        r101.f(r102.getMessage());
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(r103));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r106) == false) goto L10;
        r106 = 0;
    L10:
        r101.e((Integer) r106);
        if (r104 != null) goto L26;
        Integer r107 = null;
    L16:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L13
    L20:
        if (Result.m9455isFailureimpl(r108) == false) goto L22;
        r108 = 0;
    L22:
        r101.a((Integer) r108);
        r100.finishWithResult(r101);
        return;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L26:
        r107 = Integer.valueOf(r104.intValue());     // Catch: Throwable -> L13
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
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
