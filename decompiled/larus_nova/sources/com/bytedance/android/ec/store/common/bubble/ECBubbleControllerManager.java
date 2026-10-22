package com.bytedance.android.ec.store.common.bubble;

import androidx.lifecycle.LifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECBubbleControllerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<LifecycleOwner, c> f48206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECBubbleControllerManager f48207b = null;

    public ECBubbleControllerManager() {
    }

    static {
        f48207b = new ECBubbleControllerManager();
        f48206a = new LinkedHashMap();
    }

    public final synchronized c a(final LifecycleOwner r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");     // Catch: Throwable -> L10
        Map<LifecycleOwner, c> r101 = f48206a;     // Catch: Throwable -> L10
        c r102 = (c) ((LinkedHashMap) r101).get(r100);     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        monitor-exit(this);
        return r102;
    L7:
        c r103 = new c();     // Catch: Throwable -> L10
        r101.put(r100, r103);     // Catch: Throwable -> L10
        r100.getLifecycle().addObserver(new ECBubbleControllerManager$getInstance$1(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return r103;
    L10:
        th = move-exception;
        throw th;
    }
}
