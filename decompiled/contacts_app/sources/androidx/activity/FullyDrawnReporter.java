package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullyDrawnReporter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u0016\u001a\u00020\u0006J\b\u0010\u0017\u001a\u00020\u0006H\u0007J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0014\u0010\u0019\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/activity/FullyDrawnReporter;", "", "executor", "Ljava/util/concurrent/Executor;", "reportFullyDrawn", "Lkotlin/Function0;", "", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;)V", "isFullyDrawnReported", "", "()Z", "lock", "onReportCallbacks", "", "reportPosted", "reportRunnable", "Ljava/lang/Runnable;", "reportedFullyDrawn", "reporterCount", "", "addOnReportDrawnListener", "callback", "addReporter", "fullyDrawnReported", "postWhenReportersAreDone", "removeOnReportDrawnListener", "removeReporter", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock;
    private final List<Function0<Unit>> onReportCallbacks;
    private final Function0<Unit> reportFullyDrawn;
    private boolean reportPosted;
    private final Runnable reportRunnable;
    private boolean reportedFullyDrawn;
    private int reporterCount;

    /* JADX INFO: renamed from: $r8$lambda$9oQ81V-Fq3e0CkAqj9HHhVQeVeY, reason: not valid java name */
    public static /* synthetic */ void m6$r8$lambda$9oQ81VFq3e0CkAqj9HHhVQeVeY(FullyDrawnReporter r0) {
        reportRunnable$lambda$2(r0);
    }

    public FullyDrawnReporter(Executor r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "executor");
        Intrinsics.checkNotNullParameter(r3, "reportFullyDrawn");
        this.executor = r2;
        this.reportFullyDrawn = r3;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
        this.reportRunnable = new FullyDrawnReporter$$ExternalSyntheticLambda0(this);
    }

    public final boolean isFullyDrawnReported() {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = this.reportedFullyDrawn;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static final void reportRunnable$lambda$2(FullyDrawnReporter r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Object r0 = r2.lock;
        monitor-enter(r0);
        r2.reportPosted = false;     // Catch: Throwable -> L13
        if (r2.reporterCount == 0) goto L8;
    L10:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L8:
        if (r2.reportedFullyDrawn == true) goto L10;
        r2.reportFullyDrawn.invoke();     // Catch: Throwable -> L13
        r2.fullyDrawnReported();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void addReporter() {
        Object r0 = this.lock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.reportedFullyDrawn == true) goto L7;
        this.reporterCount++;     // Catch: Throwable -> L10
    L7:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public final void removeReporter() {
        Object r0 = this.lock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.reportedFullyDrawn == true) goto L9;
        int r1 = this.reporterCount;     // Catch: Throwable -> L12
        if (r1 <= 0) goto L9;
        this.reporterCount = r1 - 1;     // Catch: Throwable -> L12
        postWhenReportersAreDone();     // Catch: Throwable -> L12
    L9:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
    }

    public final void addOnReportDrawnListener(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Object r0 = this.lock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.reportedFullyDrawn == false) goto L7;
        boolean r2 = true;
    L9:
        monitor-exit(r0);
        if (r2 == false) goto L18;
        r3.invoke();
        return;
    L18:
        return;
    L7:
        this.onReportCallbacks.add(r3);     // Catch: Throwable -> L13
        r2 = false;
        goto L9
    }

    public final void removeOnReportDrawnListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Object r0 = this.lock;
        monitor-enter(r0);
        this.onReportCallbacks.remove(r2);     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void fullyDrawnReported() {
        Object r0 = this.lock;
        monitor-enter(r0);
        this.reportedFullyDrawn = true;     // Catch: Throwable -> L12
        Iterator<T> r1 = this.onReportCallbacks.iterator();     // Catch: Throwable -> L12
    L7:
        if (r1.hasNext() == false) goto L9;
        ((Function0) r1.next()).invoke();     // Catch: Throwable -> L12
        goto L7
    L9:
        this.onReportCallbacks.clear();     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final void postWhenReportersAreDone() {
        if (this.reportPosted == false) goto L5;
        return;
    L5:
        if (this.reporterCount != 0) goto L9;
        this.reportPosted = true;
        this.executor.execute(this.reportRunnable);
        return;
    }
}
