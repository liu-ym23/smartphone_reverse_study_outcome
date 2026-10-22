package com.bytedance.android.live.revlink.link.domain.streammix;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f98567a = null;

    static {
        f98567a = new h();
    }

    public h() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        com.bytedance.android.live.revlink.link.domain.service.d r102 = (com.bytedance.android.live.revlink.link.domain.service.d) r100;
        com.bytedance.android.live.revlink.link.domain.service.d r103 = (com.bytedance.android.live.revlink.link.domain.service.d) r101;
        Intrinsics.checkNotNullParameter(r102, "wrapL");
        Intrinsics.checkNotNullParameter(r103, "wrapR");
        if (r102.f98536b.f() == r103.f98536b.f()) goto L8;
        if (r102.f98536b.f() >= r103.f98536b.f()) goto L14;
    L6:
        return -1;
    L14:
        return 1;
    L8:
        if (r102.f98536b.e() != r103.f98536b.e()) goto L10;
        return 0;
    L10:
        if (r102.f98536b.e() < r103.f98536b.e()) goto L6;
        return 1;
    }
}
