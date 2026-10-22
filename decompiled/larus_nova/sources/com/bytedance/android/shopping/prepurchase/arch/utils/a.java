package com.bytedance.android.shopping.prepurchase.arch.utils;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f181012a = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.arch.utils.a$a, reason: collision with other inner class name */
    public final class RunnableC2696a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f181013a;

        public RunnableC2696a(Function0 r100) {
            this.f181013a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f181013a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f181012a = new Handler(Looper.getMainLooper());
    }

    public static final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f181012a.post(new RunnableC2696a(r100));
    }
}
