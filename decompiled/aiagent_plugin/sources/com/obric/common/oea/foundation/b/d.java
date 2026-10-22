package com.obric.common.oea.foundation.b;

import d.h.b.h;

/* JADX INFO: compiled from: SdkInit.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static final String TAG = "OEA_FOUNDATION";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f32476b;

    /* JADX INFO: compiled from: SdkInit.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        f32475a = new a(null);
    }

    public d() {
        if (f32476b != 0) goto L5;
        c.f32472a.d(TAG, "init, SDK_BUILD_NO: [20260708-10:26:47|1|554a099|20260708-10:17:28_feature: add fps api]");
    L5:
        f32476b++;
    }
}
