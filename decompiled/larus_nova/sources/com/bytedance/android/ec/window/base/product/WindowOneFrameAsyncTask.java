package com.bytedance.android.ec.window.base.product;

import android.os.Looper;
import com.bytedance.apm.util.u;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class WindowOneFrameAsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Runnable> f49364a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WindowOneFrameAsyncTask$handler$1 f49365b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f49366a;

        public a(Runnable r100) {
            this.f49366a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList<Runnable> r100 = WindowOneFrameAsyncTask.f49364a;     // Catch: Throwable -> L4
            WindowOneFrameAsyncTask.a(this.f49366a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.ec.window.base.product.WindowOneFrameAsyncTask$handler$1] */
    static {
        f49364a = new ArrayList();
        final Looper r100 = Looper.getMainLooper();
        f49365b = new WindowOneFrameAsyncTask$handler$1(r100);
    }

    public static void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (u.a() == true) goto L6;
        f49365b.post(new a(r100));
        return;
    L6:
        f49364a.add(r100);
        WindowOneFrameAsyncTask$handler$1 r101 = f49365b;
        if (r101.hasMessages(0) == true) goto L10;
        r101.sendEmptyMessage(0);
        return;
    }
}
