package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Long> f141373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f141374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Long> f141375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f141376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f141377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f141378f;

    public final int a() {
        return RangesKt.random(new IntRange(this.f141378f, this.f141377e), Random.Default);
    }

    public final int b() {
        long r100 = RangesKt.random(new LongRange(0, this.f141376d), Random.Default);
        Iterator<T> r101 = this.f141375c.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r100 <= ((Number) r101.next()).longValue()) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return 0;
    }

    public f() {
        this.f141373a = new ArrayList();
        this.f141375c = new ArrayList();
        this.f141377e = 6;
        this.f141378f = 3;
    }

    public final void c(List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f141374b = 0;
        this.f141373a.clear();
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        long r103 = ((com.bytedance.android.livesdk.interactivity.api.barrage.data.f) ListProtector.get(r100, r102)).f();
        long r104 = this.f141374b + r103;
        this.f141374b = r104;
        this.f141373a.add(Long.valueOf(r104));
        r102 = r102 + 1;
        goto L3
    }

    public final void d(List<Long> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f141376d = 0;
        this.f141375c.clear();
        int r103 = ((ArrayList) r100).size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        long r105 = ((Number) ListProtector.get(r100, r104)).longValue();
        long r106 = this.f141376d + r105;
        this.f141376d = r106;
        this.f141375c.add(Long.valueOf(r106));
        r104 = r104 + 1;
        goto L3
    L5:
        this.f141377e = Math.max(r102, r101);
        this.f141378f = Math.min(r102, r101);
    }
}
