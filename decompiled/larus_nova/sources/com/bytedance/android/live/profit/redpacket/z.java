package com.bytedance.android.live.profit.redpacket;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class z<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f88792a = null;

    static {
        f88792a = new z();
    }

    public z() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        RedPacketIconHelpersKt$generateEntryList$topUsers$2.a r102 = (RedPacketIconHelpersKt$generateEntryList$topUsers$2.a) r100;
        RedPacketIconHelpersKt$generateEntryList$topUsers$2.a r103 = (RedPacketIconHelpersKt$generateEntryList$topUsers$2.a) r101;
        int r104 = r102.f88525a;
        int r105 = r103.f88525a;
        if (r104 == r105) goto L6;
        return Intrinsics.compare(r105, r104);
    L6:
        return r102.f88526b.f88670f.a(r103.f88526b.f88670f);
    }
}
