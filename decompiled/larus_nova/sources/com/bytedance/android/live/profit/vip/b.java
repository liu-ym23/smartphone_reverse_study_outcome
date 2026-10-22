package com.bytedance.android.live.profit.vip;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f89130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f89131b;

    public b() {
        this(null, 3);
    }

    public b(List r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        Intrinsics.checkNotNullParameter(r100, "exposedEmojiIdList");
        this.f89130a = r100;
        this.f89131b = 0;
    }
}
