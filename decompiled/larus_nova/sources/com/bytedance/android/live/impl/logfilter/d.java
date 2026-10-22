package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import java.util.Deque;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d implements z90.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f69214a;

    public abstract void b(String r100, String r101);

    public d() {
        this.f69214a = "LFM-FeatureFilter";
    }

    public static void c(String r100, Deque r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "deque");
        LinkedList r103 = (LinkedList) r101;
        r103.offerLast(Long.valueOf(r102));
    L4:
        if ((!r103.isEmpty()) == false) goto L10;
        Long r104 = (Long) r103.peekFirst();
        if (r104 == null) goto L10;
        float r105 = r102 - r104.longValue();
        FeatureManager.f69275u.getClass();
        if (r105 <= (FeatureManager.f69262h * 60000)) goto L10;
        r103.pollFirst();
    L10:
        FeatureManager.f69275u.i(r100, Integer.valueOf(r103.size()), FeatureType.DYNAMIC);
    }

    public static void d(String r100, Deque r101, int r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "deque");
        if (r102 == 0) goto L6;
        LinkedList r104 = (LinkedList) r101;
        r104.pollLast();
        c(r100, r104, r103);
        return;
    }
}
