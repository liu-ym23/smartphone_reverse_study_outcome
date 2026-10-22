package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import java.util.ArrayList;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import p22.n;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<uc2.b> f141747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f141748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f141749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f141750d;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f141751a = null;

        static {
            f141751a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((Integer) r100).intValue() - ((Integer) r101).intValue();
        }
    }

    public g(n r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuConfig");
        this.f141750d = r100;
        this.f141747a = new ArrayList();
        this.f141748b = new ArrayList();
        this.f141749c = a.f141751a;
        n r101 = this.f141750d;
        Intrinsics.checkNotNullParameter(r101, "danmakuConfig");
        int r102 = r101.f527439c;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        this.f141747a.add(new uc2.h(r103, true, false, null));
        r103 = r103 + 1;
        goto L3
    }

    public static void a(com.bytedance.android.livesdk.interactivity.zdanmaku.i r100) {
        Intrinsics.checkNotNullParameter(r100, "danmaku");
        float r101 = r100.c();
        uc2.b r102 = r100.f141635e;
        if (r102 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r103 = r102.f549423c;
        if (r103 == null) goto L7;
        float r104 = r103.c();
    L9:
        if (r101 <= r104) goto L14;
        uc2.b r105 = r100.f141635e;
        if (r105 == null) goto L15;
        r105.f549423c = r100;
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r104 = 0.0f;
        goto L9
    }
}
