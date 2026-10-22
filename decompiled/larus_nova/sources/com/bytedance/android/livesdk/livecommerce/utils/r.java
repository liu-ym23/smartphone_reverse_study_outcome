package com.bytedance.android.livesdk.livecommerce.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f153110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EnumEntranceInfoScene f153111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f153112c;

    public r(String r100, EnumEntranceInfoScene r101, Function0 r102) {
        this.f153110a = r100;
        this.f153111b = r101;
        this.f153112c = r102;
    }

    public final void a() {
        sg2.v r100 = new sg2.v("schema_report", com.bytedance.android.ec.common.api.jump.model.b.f42853a);
        r100.c("location", "ecomLive");
        r100.c("business", this.f153111b.getValue());
        Function0 r101 = this.f153112c;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r101.invoke());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        r100.c("in_schema", (String) r103);
        r100.c("out_schema", this.f153110a);
        r100.i(null);
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
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
