package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.i;
import java.util.List;
import kotlin.Result;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class GetZTEDeletedSysApps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18069a;

    public GetZTEDeletedSysApps(Context r10) {
        q.g(r10, "context");
        this.f18069a = r10;
    }

    public static final /* synthetic */ Context a(GetZTEDeletedSysApps r10) {
        return r10.f18069a;
    }

    public final Object b(Continuation r10) {
        if ((r10 instanceof GetZTEDeletedSysApps$invoke$1) == false) goto L7;
        GetZTEDeletedSysApps$invoke$1 r11 = (GetZTEDeletedSysApps$invoke$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L17;
        if (r15 != 1) goto L16;
        kotlin.c.b(r13);     // Catch: Throwable -> L13
    L24:
        Object r16 = Result.m35constructorimpl((List) r13);     // Catch: Throwable -> L13
    L27:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 == null) goto L30;
        j.q("[ZTE][GetZTEDeletedSysApps] Get deleted sys apps failed", r17);
    L30:
        return r16;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        kotlin.c.b(r13);
        if (i.f10206a.b() == true) goto L21;
        j.n("[ZTE][GetZTEDeletedSysApps] Not N1 Device");
        Result.a r18 = Result.Companion;
        return Result.m35constructorimpl(t.i());
    L21:
        Result.a r19 = Result.Companion;     // Catch: Throwable -> L13
        CoroutineDispatcher r20 = l0.b();     // Catch: Throwable -> L13
        GetZTEDeletedSysApps$invoke$2$deleted$1 r21 = new GetZTEDeletedSysApps$invoke$2$deleted$1(this, null);     // Catch: Throwable -> L13
        r11.label = 1;     // Catch: Throwable -> L13
        r13 = h.g(r20, r21, r11);     // Catch: Throwable -> L13
        if (r13 != r14) goto L24;
        return r14;
    L13:
        th = move-exception;
        Result.a r22 = Result.Companion;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));
    L7:
        r11 = new GetZTEDeletedSysApps$invoke$1(this, r10);
        goto L8
    }
}
