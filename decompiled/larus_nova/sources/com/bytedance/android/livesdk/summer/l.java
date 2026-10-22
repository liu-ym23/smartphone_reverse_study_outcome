package com.bytedance.android.livesdk.summer;

import com.bytedance.android.livesdkapi.service.ISummerService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l<R> extends k<R> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object[] f158479o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f158480p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f158481q;

    @Override // com.bytedance.android.livesdk.summer.c
    public final R d() {
        this.f158447f.incrementAndGet();
        int r100 = this.f158481q;
        int r101 = 0;
        R r102 = null;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L13;
        if (r102 != null) goto L11;
        int[] r104 = this.f158480p;
        if (r104[r101] != 1) goto L11;
        Object[] r105 = this.f158479o;
        Object r106 = r105[r101];
        if (r106 == null) goto L11;
        r104[r101] = 2;
        r105[r101] = null;
        r102 = (R) r106;
    L11:
        r103 = r103 + this.f158480p[r101];
        r101 = r101 + 1;
        goto L4
    L13:
        if (r103 <= (((this.f158481q * 2) / 3) * 2)) goto L15;
        d.a(this);
    L15:
        if (r102 == null) goto L17;
        this.f158446e.incrementAndGet();
    L17:
        if (r102 == null) goto L19;
        return r102;
    L19:
        return f();
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final R e() {
        this.f158447f.incrementAndGet();
        int r100 = this.f158481q;
        int r101 = 0;
        R r102 = null;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L13;
        if (r102 != null) goto L11;
        int[] r104 = this.f158480p;
        if (r104[r101] != 1) goto L11;
        Object[] r105 = this.f158479o;
        Object r106 = r105[r101];
        if (r106 == null) goto L11;
        r104[r101] = 2;
        r105[r101] = null;
        r102 = (R) r106;
    L11:
        r103 = r103 + this.f158480p[r101];
        r101 = r101 + 1;
        goto L4
    L13:
        if (r103 <= (((this.f158481q * 2) / 3) * 2)) goto L15;
        d.a(this);
    L15:
        if (r102 == null) goto L17;
        this.f158446e.incrementAndGet();
    L17:
        if (r102 == null) goto L19;
        return r102;
    L19:
        return f();
    }

    public final void i() {
        int r100 = this.f158445d;
        int r101 = 2;
        if (r100 != 2) goto L5;
        return;
    L5:
        if (r100 != 3) goto L7;
        return;
    L7:
        if (r100 != (-1)) goto L10;
        return;
    L10:
        if (r100 == 1) goto L13;
        r101 = 3;
    L13:
        this.f158445d = r101;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        int r103 = this.f158481q;     // Catch: Throwable -> L22
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L20;
        if (this.f158480p[r104] == 1) goto L19;
        this.f158479o[r104] = f();     // Catch: Throwable -> L22
        this.f158480p[r104] = 1;     // Catch: Throwable -> L22
    L19:
        r104 = r104 + 1;     // Catch: Throwable -> L22
        goto L15
    L20:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        this.f158445d = 4;
        return;
    L22:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    @Override // com.bytedance.android.livesdk.summer.c, java.lang.Runnable
    public final void run() {
        i();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final <T> boolean b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f158481q <= 0) goto L13;
        Object r101 = this.f158479o[0];
        if (r101 == null) goto L13;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(r100.cast(r101));     // Catch: Throwable -> L9
    L12:
        return Result.m9456isSuccessimpl(r103);
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        return false;
    }

    public /* synthetic */ l(int r100, Function0 r101) {
        this(r100, 1, 0, 3, r101);
    }

    public l(@ISummerService.TaskID int r100, int r101, int r102, int r103, Function0<? extends R> r104) {
        Intrinsics.checkNotNullParameter(r104, "action");
        super(r100, r101, r102, r104);
        this.f158481q = r103;
        this.f158479o = new Object[r103];
        int[] r105 = new int[r103];
        int r106 = 0;
    L3:
        if (r106 >= r103) goto L5;
        r105[r106] = 0;
        r106 = r106 + 1;
        goto L3
    L5:
        this.f158480p = r105;
    }
}
