package com.bytedance.android.livesdk.performance.gc.opt.leakfixer;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.j1;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.WeakHashMap;
import yn2.a;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveLeakFixer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<LifecycleOwner, Set<a>> f154643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f154644b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<LifecycleOwner> f154645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LiveLeakFixer$lifeCycleObserver$1 f154646d = null;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.android.livesdk.performance.gc.opt.leakfixer.LiveLeakFixer$lifeCycleObserver$1] */
    static {
        f154643a = new WeakHashMap();
        f154644b = j1.f142014a.getValue().getOpenFixer();
        f154646d = new LiveLeakFixer$lifeCycleObserver$1();
    }
}
