package com.bytedance.android.ec.store.common.bubble;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f48211b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f48212c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f48213a;

    /* JADX INFO: renamed from: com.bytedance.android.ec.store.common.bubble.a$a, reason: collision with other inner class name */
    public static final class C0837a {
    }

    static {
        f48211b = new a(80);
        f48212c = new a(100);
    }

    public a(int r100) {
        this.f48213a = r100;
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return Intrinsics.compare(this.f48213a, r101.f48213a);
    }
}
