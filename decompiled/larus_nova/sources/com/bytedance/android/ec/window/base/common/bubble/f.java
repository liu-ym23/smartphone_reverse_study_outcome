package com.bytedance.android.ec.window.base.common.bubble;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<LifecycleOwner, d> f49122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f49123b = null;

    public f() {
    }

    static {
        f49123b = new f();
        f49122a = new LinkedHashMap();
    }

    public final synchronized d a(final FragmentActivity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");     // Catch: Throwable -> L10
        Map<LifecycleOwner, d> r101 = f49122a;     // Catch: Throwable -> L10
        d r102 = (d) ((LinkedHashMap) r101).get(r100);     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        monitor-exit(this);
        return r102;
    L7:
        d r103 = new d();     // Catch: Throwable -> L10
        r101.put(r100, r103);     // Catch: Throwable -> L10
        r100.getLifecycle().addObserver(new ECWindowBubbleControllerManager$getInstance$1(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return r103;
    L10:
        th = move-exception;
        throw th;
    }
}
