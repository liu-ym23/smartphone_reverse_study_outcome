package com.obric.autoaction.e;

import com.obric.autogui.common.api.logging.Loog;
import d.h.b.o;

/* JADX INFO: compiled from: LogUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24680a = null;

    public static /* synthetic */ String lambda$Jig_DFVbdfV6HYg3XcL7iaz1gt4(String r0, String r1) {
        return b(r0, r1);
    }

    private b() {
    }

    static {
        f24680a = new b();
        TAG = "AutoActionUI";
    }

    private static final String b(String r1, String r2) {
        return r1 + ": " + r2;
    }

    public final void a(final String r3, final String r4) {
        o.e(r3, "tag");
        o.e(r4, "message");
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$Jig_DFVbdfV6HYg3XcL7iaz1gt4(r3, r4));
    }
}
