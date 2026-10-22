package com.bytedance.android.ec.window.base.utils.taskmanager;

import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECWindowTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f49770a = null;

    public static final class a {
        public static ECWindowTaskManager a() {
            return (ECWindowTaskManager) ECWindowTaskManager.f49770a.getValue();
        }
    }

    static {
        f49770a = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECWindowTaskManager$Companion$instance$2.INSTANCE);
    }

    public ECWindowTaskManager() {
        new LinkedHashMap();
    }

    public static void a(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        int r101 = b.f49775c;
        b.C0853b.f49778a.a(WindowExecutorType.IO, r100);
    }
}
