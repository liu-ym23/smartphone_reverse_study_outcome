package com.obric.event.task.base.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: ExperimentConfigKeys.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a<Integer> f32673b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a<Integer> f32674c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final LinkedHashMap<String, a<?>> f32675d = null;

    private b() {
    }

    static {
        b r0 = new b();
        f32672a = r0;
        f32675d = new LinkedHashMap();
        f32673b = r0.a("location_monitor_window_minutes", 10, true);
        f32674c = r0.a("location_monitor_sample_interval_seconds", 120, true);
    }

    private final a<Integer> a(String r2, int r3, boolean r4) {
        return b(a.f32662a.a(r2, r3, r4));
    }

    private final <T> a<T> b(a<T> r3) {
        if (((a) ZeusTransformUtils.preCheckCast(f32675d.putIfAbsent(r3.a(), r3), a.class, "com.obric.aiagent.plugin")) != null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return r3;
    L9:
        throw new IllegalArgumentException(("Duplicate EventTask experiment config key: " + r3.a()).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final boolean a(a<?> r2) {
        o.e(r2, "key");
        if (f32675d.get(r2.a()) != r2) goto L5;
        return true;
    L5:
        return false;
    }
}
