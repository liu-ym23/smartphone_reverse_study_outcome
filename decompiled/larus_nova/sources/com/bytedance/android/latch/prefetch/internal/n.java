package com.bytedance.android.latch.prefetch.internal;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f58484a;

    public static final class a implements k {
        public a() {
        }

        @Override // com.bytedance.android.latch.prefetch.internal.k
        public final void onLog(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        @Override // com.bytedance.android.latch.prefetch.internal.k
        public final void a(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            r101.printStackTrace();
        }
    }

    public n() {
    }

    static {
        f58484a = new a();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        f58484a.onLog(r100);
    }
}
