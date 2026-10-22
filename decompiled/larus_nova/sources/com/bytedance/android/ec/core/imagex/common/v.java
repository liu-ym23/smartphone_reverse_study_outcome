package com.bytedance.android.ec.core.imagex.common;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f44660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f44661c;

    public static final class a extends v {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Runnable f44662d;

        @Override // com.bytedance.android.ec.core.imagex.common.v
        public final void b() {
            this.f44662d.run();
        }

        public a(Integer r100, Runnable r101) {
            Intrinsics.checkNotNullParameter(r101, "runnable");
            super(r100);
            this.f44662d = r101;
        }
    }

    public v() {
        this(null);
    }

    public final void a() {
        Integer r100 = null;
        Integer r101 = Integer.valueOf(Process.getThreadPriority(Process.myTid()));     // Catch: Throwable -> L5
    L6:
        this.f44660b = r101;
        if ((!Intrinsics.areEqual(r101, this.f44661c)) == false) goto L16;
        Integer r102 = this.f44661c;
        if (r102 == null) goto L16;
        int r103 = r102.intValue();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        Process.setThreadPriority(r103);     // Catch: Throwable -> L13
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Result.m9448boximpl(r105);
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        b();
        if (this.f44659a == false) goto L40;
        r100 = Integer.valueOf(Process.getThreadPriority(Process.myTid()));     // Catch: Throwable -> L20
    L22:
        if ((!Intrinsics.areEqual(r100, this.f44660b)) == false) goto L41;
        Integer r107 = this.f44660b;
        if (r107 == null) goto L42;
        int r108 = r107.intValue();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L28
        Process.setThreadPriority(r108);     // Catch: Throwable -> L28
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Result.m9448boximpl(r110);
        return;
    L28:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public abstract void b();

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

    public v(Integer r100) {
        this.f44661c = r100;
        this.f44659a = true;
    }
}
