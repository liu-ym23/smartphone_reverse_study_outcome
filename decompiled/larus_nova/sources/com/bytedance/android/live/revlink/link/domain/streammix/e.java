package com.bytedance.android.live.revlink.link.domain.streammix;

import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f98561a = null;

    static {
        f98561a = new e();
    }

    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        IRegion r102 = (IRegion) r100;
        IRegion r103 = (IRegion) r101;
        Intrinsics.checkNotNullParameter(r102, "regionL");
        Intrinsics.checkNotNullParameter(r103, "regionR");
        if (r102.getY() == r103.getY()) goto L8;
        if (r102.getY() >= r103.getY()) goto L14;
    L6:
        return -1;
    L14:
        return 1;
    L8:
        if (r102.getX() != r103.getX()) goto L10;
        return 0;
    L10:
        if (r102.getX() < r103.getX()) goto L6;
        return 1;
    }
}
