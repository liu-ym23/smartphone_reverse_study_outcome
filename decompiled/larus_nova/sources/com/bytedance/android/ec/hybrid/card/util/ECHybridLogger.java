package com.bytedance.android.ec.hybrid.card.util;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f46584a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yj.h f46585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f46586b;

        public a(yj.h r100, String r101) {
            this.f46585a = r100;
            this.f46586b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f46585a.log("ECHybrid", this.f46586b);     // Catch: Throwable -> L4
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
        f46584a = LazyKt.lazy(ECHybridLogger$SERVICE$2.INSTANCE);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        yj.h r101 = (yj.h) f46584a.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        com.bytedance.android.ec.hybrid.card.util.a.a(new a(r101, r100));
    }
}
