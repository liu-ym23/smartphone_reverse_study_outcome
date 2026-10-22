package com.bytedance.android.ec.core.monitor;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f45133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f45134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f45135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f45136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f45137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f45138f;

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "metricName");
        Long r101 = (Long) ((HashMap) this.f45133a).get(r100);
        if (r101 == null) goto L8;
        long r102 = r101.longValue();
        long r103 = SystemClock.elapsedRealtime() - r102;
        if (r103 <= 0) goto L9;
        Map<String, Long> r104 = this.f45134b;
        HashMap r105 = (HashMap) r104;
        r105.put(r100, Long.valueOf(r103));
        return;
    L9:
        return;
    }

    public a(String r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f45137e = r100;
        this.f45138f = r101;
        this.f45133a = new HashMap();
        this.f45134b = new HashMap();
        this.f45135c = new HashMap();
        this.f45136d = new HashMap();
    }
}
