package com.obric.structure.omvvm.core.performance;

import android.os.Looper;
import android.view.Choreographer;
import com.GlobalProxyLancet;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.structure.omvvm.core.util.QExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QVsyncFrameCaller.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0014J\u001c\u0010\u0015\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u0016\u001a\u00020\u0006J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0006\u0010\u001c\u001a\u00020\fR\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/structure/omvvm/core/performance/QVsyncFrameCaller;", "", "()V", "commitCallback", "Landroid/view/Choreographer$FrameCallback;", "commitOp", "", "nextVsync", "uiActions", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/lang/Runnable;", "addTask", "", "runnable", "frameCaller", "timeNanos", "", "commit", "nextOp", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "Lkotlin/Function0;", "postBind", "isPostScatter", "removeTask", "setMinLimit", "minLimit", "", "setMinLimit$omvvm_core_release", "start", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QVsyncFrameCaller {
    public static final QVsyncFrameCaller INSTANCE = null;
    private static final Choreographer.FrameCallback commitCallback = null;
    private static boolean commitOp;
    private static boolean nextVsync;
    private static LinkedBlockingQueue<Runnable> uiActions;

    /* JADX INFO: renamed from: $r8$lambda$9-OeHs01Wa963FRapfyklbJZzEc, reason: not valid java name */
    public static /* synthetic */ void m772$r8$lambda$9OeHs01Wa963FRapfyklbJZzEc(long r0) {
        commitCallback$lambda$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$AGwZXnXdBfaeEvXc7a3yLrSN_8U(Function0 r0) {
        post$lambda$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$KrDmWp9OY00CA2_yPLANxvwZM90(Function0 r0) {
        postBind$lambda$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$_9AKM8d71QkK_j4gjSSz56TBJFU() {
        nextOp$lambda$0();
    }

    public final void start() {
    }

    private QVsyncFrameCaller() {
    }

    static {
        INSTANCE = new QVsyncFrameCaller();
        uiActions = new LinkedBlockingQueue();
        commitCallback = new QVsyncFrameCaller$$ExternalSyntheticLambda3();
    }

    public final void addTask(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        uiActions.add(r2);
        nextOp();
    }

    public final void removeTask(Runnable r1) {
        Intrinsics.checkNotNullParameter(r1, "runnable");
        if (uiActions.contains(r1) == false) goto L6;
        uiActions.remove(r1);
        return;
    }

    private final void frameCaller(long r10, boolean r12) {
        long r0 = System.nanoTime();
        if (r10 <= r0) goto L5;
        r10 = r0;
    L5:
        long r2 = 16000000 - (r0 - r10);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("QVsyncFrameCaller", "new frame " + r12 + ' ' + (r2 / ((long) 1000000)));
        if (r12 == false) goto L8;
        Long r9 = QVsyncFrameCallerKt.access$getMIN_LIMIT();
        Intrinsics.checkNotNull(r9);
        long r11 = r9.longValue();
    L9:
        int r4 = 0;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        if (r2 > r11) goto L14;
    L19:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("QVsyncFrameCaller", " count " + r4);
        return;
    L14:
        if ((!uiActions.isEmpty()) == false) goto L19;
        long r5 = System.nanoTime();
        Runnable r3 = uiActions.poll();
        if (r3 == null) goto L18;
        r3.run();
    L18:
        r2 = r2 - (System.nanoTime() - r5);
        r4 = r4 + 1;
        r1 = false;
        goto L10
    L8:
        r11 = 8000000;
        goto L9
    }

    private final void nextOp() {
        if (nextVsync == false) goto L5;
        return;
    L5:
        nextVsync = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        QVsyncWorkerCompat.Companion r2 = QVsyncWorkerCompat.Companion;
        Choreographer r0 = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        commitOp = r2.postCommitCallback(r0, commitCallback);
        return;
    L8:
        QExecutor.INSTANCE.main().post(new QVsyncFrameCaller$$ExternalSyntheticLambda2());
    }

    private static final void nextOp$lambda$0() {
        QVsyncWorkerCompat.Companion r0 = QVsyncWorkerCompat.Companion;
        Choreographer r1 = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(r1, "getInstance()");
        commitOp = r0.postCommitCallback(r1, commitCallback);
    }

    private static final void commitCallback$lambda$1(long r2) {
        QVsyncFrameCaller r0 = INSTANCE;
        nextVsync = false;
        r0.frameCaller(r2, commitOp);
        if ((!uiActions.isEmpty()) == false) goto L6;
        r0.nextOp();
        return;
    }

    public final void setMinLimit$omvvm_core_release(int r3) {
        boolean r2 = false;
        if (1 <= r3) goto L5;
    L7:
        if (r2 == false) goto L10;
        QVsyncFrameCallerKt.access$setMIN_LIMIT$p(Long.valueOf(((long) r3) * 1000000));
        return;
    L10:
        return;
    L5:
        if (r3 >= 17) goto L7;
        r2 = true;
        goto L7
    }

    private static final void post$lambda$2(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }

    public final void post(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        QExecutor.INSTANCE.main().post(new QVsyncFrameCaller$$ExternalSyntheticLambda0(r2));
    }

    public final void postBind(final Function0<Unit> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (r3 == false) goto L5;
        post(r2);
        return;
    L5:
        addTask(new QVsyncFrameCaller$$ExternalSyntheticLambda1(r2));
    }

    private static final void postBind$lambda$3(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }
}
