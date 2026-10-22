package com.bytedance.android.live.broadcast.api.stable;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface b extends Comparable<b> {

    public static final class a {
        public static int a(b r100, b r101) {
            Intrinsics.checkNotNullParameter(r101, "other");
            r100.getPriority();
            r101.getPriority();
            return 0;
        }
    }

    void getPriority();
}
