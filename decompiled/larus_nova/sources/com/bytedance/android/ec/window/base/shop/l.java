package com.bytedance.android.ec.window.base.shop;

import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<PrefetchScene, ConcurrentHashMap<WindowPrefetchJobKey<?>, Subject<?>>> f49650a = null;

    static {
        f49650a = new ConcurrentHashMap();
    }

    public static Subject b(PrefetchScene r100, WindowPrefetchJobKey r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Subject<?> r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        ConcurrentHashMap<PrefetchScene, ConcurrentHashMap<WindowPrefetchJobKey<?>, Subject<?>>> r103 = f49650a;
        ConcurrentHashMap<WindowPrefetchJobKey<?>, Subject<?>> r104 = r103.get(r100);
        if (r104 != null) goto L9;
        r104 = new ConcurrentHashMap();
        r103.put(r100, r104);
    L9:
        Subject<?> r105 = r104.remove(r101);
        if ((r105 instanceof Subject) == false) goto L14;
        r102 = r105;
    L14:
        return r102;
    }

    public static void a(PrefetchScene r100, WindowPrefetchJobKey r101, ReplaySubject r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_SUBJECT);
        ConcurrentHashMap<PrefetchScene, ConcurrentHashMap<WindowPrefetchJobKey<?>, Subject<?>>> r103 = f49650a;
        ConcurrentHashMap<WindowPrefetchJobKey<?>, Subject<?>> r104 = r103.get(r100);
        if (r104 != null) goto L6;
        r104 = new ConcurrentHashMap();
        r103.put(r100, r104);
    L6:
        r104.put(r101, r102);
    }
}
