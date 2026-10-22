package com.bytedance.android.livesdk.summer;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h<R> extends c<R> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object[] f158464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f158465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f158466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<R> f158467k;

    @Override // com.bytedance.android.livesdk.summer.c
    public final R d() {
        this.f158447f.incrementAndGet();
        int r100 = this.f158466j;
        int r101 = 0;
        R r102 = null;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L13;
        if (r102 != null) goto L11;
        int[] r104 = this.f158465i;
        if (r104[r101] != 1) goto L11;
        Object[] r105 = this.f158464h;
        Object r106 = r105[r101];
        if (r106 == null) goto L11;
        r104[r101] = 2;
        r105[r101] = null;
        r102 = (R) r106;
    L11:
        r103 = r103 + this.f158465i[r101];
        r101 = r101 + 1;
        goto L4
    L13:
        if (r103 <= (((this.f158466j * 2) / 3) * 2)) goto L15;
        d.a(this);
    L15:
        if (r102 == null) goto L17;
        this.f158446e.incrementAndGet();
    L17:
        if (r102 == null) goto L19;
        return r102;
    L19:
        return this.f158467k.invoke();
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final R e() {
        this.f158447f.incrementAndGet();
        int r100 = this.f158466j;
        int r101 = 0;
        R r102 = null;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L13;
        if (r102 != null) goto L11;
        int[] r104 = this.f158465i;
        if (r104[r101] != 1) goto L11;
        Object[] r105 = this.f158464h;
        Object r106 = r105[r101];
        if (r106 == null) goto L11;
        r104[r101] = 2;
        r105[r101] = null;
        r102 = (R) r106;
    L11:
        r103 = r103 + this.f158465i[r101];
        r101 = r101 + 1;
        goto L4
    L13:
        if (r103 <= (((this.f158466j * 2) / 3) * 2)) goto L15;
        d.a(this);
    L15:
        if (r102 == null) goto L17;
        this.f158446e.incrementAndGet();
    L17:
        return r102;
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final R f() {
        return this.f158467k.invoke();
    }

    public final void h() {
        int r100 = this.f158445d;
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        int r101 = 2;
    L9:
        this.f158445d = r101;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        int r103 = this.f158466j;     // Catch: Throwable -> L18
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L16;
        if (this.f158465i[r104] == 1) goto L15;
        this.f158464h[r104] = f();     // Catch: Throwable -> L18
        this.f158465i[r104] = 1;     // Catch: Throwable -> L18
    L15:
        r104 = r104 + 1;     // Catch: Throwable -> L18
        goto L11
    L16:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        this.f158445d = 4;
        return;
    L18:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L8:
        r101 = 3;
        goto L9
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

    @Override // com.bytedance.android.livesdk.summer.c
    public final <T> boolean b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f158466j > 0) goto L5;
        return false;
    L5:
        Object[] r101 = this.f158464h;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L16;
        Object r104 = r101[r103];
        if (r104 != null) goto L17;
        r103 = r103 + 1;
        goto L6
    L17:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        Object r106 = Result.m9449constructorimpl(r100.cast(r104));     // Catch: Throwable -> L11
    L14:
        return Result.m9456isSuccessimpl(r106);
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(int r100, Function0<? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f158466j = r100;
        this.f158467k = r101;
        this.f158464h = new Object[r100];
        int[] r102 = new int[r100];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r102[r103] = 0;
        r103 = r103 + 1;
        goto L3
    L5:
        this.f158465i = r102;
        String r104 = this.f158467k.getClass().getSimpleName();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f158448g = r104;
    }
}
