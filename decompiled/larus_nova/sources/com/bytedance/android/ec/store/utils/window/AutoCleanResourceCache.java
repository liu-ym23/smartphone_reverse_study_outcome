package com.bytedance.android.ec.store.utils.window;

import androidx.lifecycle.LifecycleOwner;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class AutoCleanResourceCache<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<LifecycleOwner, Map<Class<?>, AutoCleanResourceCache<?>>> f48701a = null;

    public static final class a {
    }

    static {
        f48701a = new ConcurrentHashMap();
        new AutoCleanResourceCache$Companion$lifecycleDestroyedObserver$1();
    }
}
