package com.bytedance.android.ec.core.abtest;

import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.Charsets;
import org.json.JSONObject;
import yf7.n;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f43637a;

    public b(long r100) {
        this.f43637a = r100;
    }

    @Override // yf7.n
    public final void a(yf7.j.a r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        if (r110 != null) goto L5;
        return;
    L5:
        JSONObject r101 = new JSONObject(new String(r110.f567450a, Charsets.UTF_8));     // Catch: Throwable -> L7
        Lazy r102 = ECByteSyncManager.f43615a;     // Catch: Throwable -> L7
        c.f43638a.getClass();     // Catch: Throwable -> L7
        ECByteSyncManager.a(r101, c.a(r110), r110.f567451b, this.f43637a);     // Catch: Throwable -> L7
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L15;
        dm.a.a("EcByteSync").b("safeListenToByteSync", r112);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
