package com.bytedance.android.livesdk.summer;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f<R> extends c<R> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object[] f158458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f158459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f158460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<R> f158461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<R, Unit> f158462l;

    @Override // com.bytedance.android.livesdk.summer.c
    public final R d() {
        this.f158447f.incrementAndGet();
        int r100 = this.f158460j;
        int r101 = 0;
        R r102 = null;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L11;
        if (r102 != null) goto L9;
        int[] r104 = this.f158459i;
        if (r104[r101] != 1) goto L9;
        r102 = (R) this.f158458h[r101];
        r104[r101] = 2;
    L9:
        r103 = r103 + this.f158459i[r101];
        r101 = r101 + 1;
        goto L4
    L11:
        if (r103 != (this.f158460j * 2)) goto L13;
        this.f158445d = 5;
    L13:
        if (r102 == null) goto L15;
        this.f158446e.incrementAndGet();
    L15:
        if (r102 == null) goto L17;
        return r102;
    L17:
        return this.f158461k.invoke();
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final R e() {
        this.f158447f.incrementAndGet();
        int r100 = this.f158460j;
        int r101 = 0;
        R r102 = null;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L11;
        if (r102 != null) goto L9;
        int[] r104 = this.f158459i;
        if (r104[r101] != 1) goto L9;
        r102 = (R) this.f158458h[r101];
        r104[r101] = 2;
    L9:
        r103 = r103 + this.f158459i[r101];
        r101 = r101 + 1;
        goto L4
    L11:
        if (r103 != (this.f158460j * 2)) goto L13;
        this.f158445d = 5;
    L13:
        if (r102 == null) goto L15;
        this.f158446e.incrementAndGet();
    L15:
        return r102;
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final R f() {
        return this.f158461k.invoke();
    }

    public final void h() {
        if (this.f158445d == 1) goto L5;
        return;
    L5:
        this.f158445d = 2;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        int r101 = this.f158460j;     // Catch: Throwable -> L11
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L9;
        this.f158458h[r102] = f();     // Catch: Throwable -> L11
        this.f158459i[r102] = 1;     // Catch: Throwable -> L11
        r102 = r102 + 1;     // Catch: Throwable -> L11
        goto L7
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        this.f158445d = 4;
        return;
    L11:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
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
        if (this.f158460j > 0) goto L5;
        return false;
    L5:
        Object[] r101 = this.f158458h;
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
    public f(int r100, Function0<? extends R> r101, Function1<? super R, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "recovery");
        this.f158460j = r100;
        this.f158461k = r101;
        this.f158462l = r102;
        this.f158458h = new Object[r100];
        int[] r103 = new int[r100];
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L5;
        r103[r104] = 0;
        r104 = r104 + 1;
        goto L3
    L5:
        this.f158459i = r103;
        String r105 = this.f158461k.getClass().getSimpleName();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f158448g = r105;
    }
}
