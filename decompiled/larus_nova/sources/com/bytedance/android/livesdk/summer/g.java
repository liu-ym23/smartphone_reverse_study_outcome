package com.bytedance.android.livesdk.summer;

import com.bytedance.android.livesdkapi.service.ProviderResult;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g<R> extends c<R> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<? extends R> f158463h;

    @Override // com.bytedance.android.livesdk.summer.c
    public final R f() {
        return this.f158463h.invoke();
    }

    public final void h() {
        if (this.f158445d == 1) goto L5;
        return;
    L5:
        this.f158445d = 2;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        setResult(f());     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        R r101 = this.f158443b;
        int r102 = 5;
        if (r101 != null) goto L14;
        this.f158445d = 5;
        return;
    L14:
        Boolean r103 = null;
        if ((r101 instanceof ProviderResult) == true) goto L17;
        Object r104 = null;
    L19:
        if (((ProviderResult) r104) != null) goto L23;
        this.f158445d = 4;
        return;
    L23:
        if ((r101 instanceof ProviderResult) == false) goto L34;
        this.f158447f.incrementAndGet();
        R r105 = this.f158443b;
        if ((r105 instanceof ProviderResult) == true) goto L27;
        r105 = (R) null;
    L27:
        ProviderResult r106 = r105;
        if (r106 == null) goto L35;
        Boolean r107 = Boolean.valueOf(r106.isOk());
        if (r107.booleanValue() == false) goto L32;
        r103 = r107;
    L32:
        if (r103 == null) goto L35;
        r103.booleanValue();
        this.f158446e.incrementAndGet();
    L35:
        this.f158445d = r102;
        return;
    L34:
        r102 = 4;
        goto L35
    L17:
        r104 = r101;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.bytedance.android.livesdk.summer.c, java.lang.Runnable
    public final void run() {
        h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(Function0<? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f158463h = r100;
        String r101 = r100.getClass().getSimpleName();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f158448g = r101;
    }
}
