package com.bytedance.android.annie.bridge.method;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadFileMethod f38735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f38736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f38737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f38738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Integer f38739e;

    public o(DownloadFileMethod r100, LinkedHashMap<String, String> r101, String r102, int r103, Integer r104) {
        this.f38735a = r100;
        this.f38736b = r101;
        this.f38737c = r102;
        this.f38738d = r103;
        this.f38739e = r104;
    }

    public final void a() {
        DownloadFileMethod r100 = this.f38735a;
        DownloadFileMethod.DownloadFileResModel r101 = new DownloadFileMethod.DownloadFileResModel();
        LinkedHashMap<String, String> r102 = this.f38736b;
        String r103 = this.f38737c;
        int r104 = this.f38738d;
        Integer r105 = this.f38739e;
        r101.b(DownloadFileMethod.DownloadFileResModel.Code.Success);
        r101.f("Success");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L5
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(r104));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r107) == false) goto L10;
        r107 = 0;
    L10:
        r101.e((Integer) r107);
        Object r108 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r108) == false) goto L18;
        r108 = 0;
    L18:
        r101.a((Integer) r108);
        r101.d(r102);
        r101.c(r103);
        r100.finishWithResult(r101);
        return;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
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
