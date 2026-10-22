package com.bytedance.android.live.core.utils.statusbar;

import com.bytedance.android.live.core.log.ALogger;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f66400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1098a f66401b = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.statusbar.a$a, reason: collision with other inner class name */
    public static final class C1098a {
        public final a a() {
            a r100 = a.f66400a;
            if (r100 != null) goto L15;
            monitor-enter(this);
            r100 = a.f66400a;     // Catch: Throwable -> L9
            if (r100 != null) goto L11;
            r100 = new a();     // Catch: Throwable -> L9
            a.f66400a = r100;     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r100;
        }

        public C1098a() {
        }
    }

    static {
        f66401b = new C1098a();
    }

    public a() {
        new LinkedHashSet();
    }

    public static void a(int r100, StatusBarInfoType r101) {
        Intrinsics.checkNotNullParameter(r101, "StatusBarInfoType");
        ALogger.i("ImmersiveStatusBarMgr", "statusbar " + r101.name() + ", result = " + r100);
    }
}
