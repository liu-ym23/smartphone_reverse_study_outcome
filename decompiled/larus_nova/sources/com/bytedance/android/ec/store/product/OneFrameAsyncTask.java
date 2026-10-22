package com.bytedance.android.ec.store.product;

import android.os.Looper;
import com.bytedance.apm.util.u;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class OneFrameAsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Runnable> f48288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OneFrameAsyncTask$handler$1 f48289b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f48290a;

        public a(Runnable r100) {
            this.f48290a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList<Runnable> r100 = OneFrameAsyncTask.f48288a;     // Catch: Throwable -> L4
            OneFrameAsyncTask.a(this.f48290a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.ec.store.product.OneFrameAsyncTask$handler$1] */
    static {
        f48288a = new ArrayList();
        final Looper r100 = Looper.getMainLooper();
        f48289b = new OneFrameAsyncTask$handler$1(r100);
    }

    public static void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (u.a() == true) goto L6;
        f48289b.post(new a(r100));
        return;
    L6:
        f48288a.add(r100);
        OneFrameAsyncTask$handler$1 r101 = f48289b;
        if (r101.hasMessages(0) == true) goto L10;
        r101.sendEmptyMessage(0);
        return;
    }
}
