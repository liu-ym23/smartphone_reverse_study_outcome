package com.bytedance.android.sdk.bdticketguard.util;

import com.bytedance.android.sdk.bdticketguard.NonRetryableException;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f164051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f164052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f164053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f164054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f164055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Integer, T> f164056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function3<Result<? extends T>, Integer, Boolean, Unit> f164057g;

    public final boolean b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f164052b == false) goto L6;
    L9:
        boolean r100 = false;
    L10:
        monitor-exit(this);
        return r100;
    L6:
        if (this.f164053c == true) goto L9;
        r100 = true;
        this.f164053c = true;     // Catch: Throwable -> L12
        this.f164051a.shutdownNow();     // Catch: Throwable -> L12
        goto L10
    }

    public static final void a(e r100, int r101) {
        monitor-enter(r100);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (r100.f164053c == false) goto L7;
        monitor-exit(r100);
        return;
    L7:
        boolean r102 = true;
        r100.f164052b = true;     // Catch: Throwable -> L36
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(r100.f164056f.invoke(Integer.valueOf(r101)));     // Catch: Throwable -> L11
    L14:
        if (Result.m9456isSuccessimpl(r104) == false) goto L19;
        Function3<Result<? extends T>, Integer, Boolean, Unit> r105 = r100.f164057g;     // Catch: Throwable -> L36
        if (r105 == null) goto L18;
        Unit r106 = r105.invoke(Result.m9448boximpl(r104), Integer.valueOf(r101), Boolean.TRUE);     // Catch: Throwable -> L36
    L18:
        r100.f164051a.shutdown();     // Catch: Throwable -> L36
    L34:
        monitor-exit(r100);
        return;
    L19:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L36
        if (r107 == null) goto L22;
        boolean r108 = !(r107 instanceof NonRetryableException);     // Catch: Throwable -> L36
    L23:
        if (r108 == true) goto L25;
    L28:
        Function3<Result<? extends T>, Integer, Boolean, Unit> r109 = r100.f164057g;     // Catch: Throwable -> L36
        if (r109 == null) goto L31;
        Unit r110 = r109.invoke(Result.m9448boximpl(r104), Integer.valueOf(r101), Boolean.valueOf(r102));     // Catch: Throwable -> L36
    L31:
        if (r102 == true) goto L33;
        r100.f164051a.schedule(new c(r100, r101), r100.f164055e, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L36
        goto L34
    L33:
        r100.f164051a.shutdown();     // Catch: Throwable -> L36
        goto L34
    L25:
        if (r101 >= (r100.f164054d - 1)) goto L28;
        r102 = false;
        goto L28
    L22:
        r108 = true;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L36
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L36
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(long r100, int r101, long r102, Function1<? super Integer, ? extends T> r103, Function3<? super Result<? extends T>, ? super Integer, ? super Boolean, Unit> r110) {
        this.f164054d = r101;
        this.f164055e = r102;
        this.f164056f = r103;
        this.f164057g = r110;
        this.f164051a = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("RetryExecutor"));
        boolean r104 = false;
        if (r100 < 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L21;
        if (r101 <= 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L19;
        if (r102 < 0) goto L14;
        r104 = true;
    L14:
        if (r104 == false) goto L17;
        return;
    L17:
        throw new IllegalArgumentException("Retry interval must be non-negative".toString());
    L19:
        throw new IllegalArgumentException("Max attempts must be positive".toString());
    L9:
        r106 = false;
        goto L10
    L21:
        throw new IllegalArgumentException("Initial delay must be non-negative".toString());
    L5:
        r105 = false;
        goto L6
    }
}
