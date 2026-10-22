package com.bytedance.android.ec.store.prefetch;

import io.reactivex.subjects.Subject;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<PrefetchScene, ConcurrentHashMap<PrefetchJobKey<?>, Subject<?>>> f48262a = null;

    static {
        f48262a = new ConcurrentHashMap();
    }
}
