package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f71487e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f71488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f71489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f71490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f71491d;

    public static final class a {
        public static f a(View r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r100, "$this$onNextDraw");
            Intrinsics.checkNotNullParameter(r101, "onDrawCallback");
            f r102 = new f(r100, r101);
            r100.getViewTreeObserver().addOnDrawListener(r102);
            return r102;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f71492a;

        public b(f r100) {
            this.f71492a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f71492a.f71490c.getViewTreeObserver().isAlive() == false) goto L9;
            this.f71492a.f71490c.getViewTreeObserver().removeOnDrawListener(this.f71492a);     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        if (this.f71489b == false) goto L5;
        return;
    L5:
        this.f71489b = true;
        this.f71491d.invoke();
        this.f71488a.post(new b(this));
    }

    public f(View r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "onDrawCallback");
        this.f71490c = r100;
        this.f71491d = r101;
        this.f71488a = new Handler(Looper.getMainLooper());
    }
}
