package com.bytedance.android.gamecp.live_impl.utils;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f58091a = null;

    static {
        f58091a = new HashMap();
    }

    public static void a(int r100, ToolbarReasonTag r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "reason");
        String r103 = String.valueOf(r100);
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "reason");
        f58091a.put(r103, r101.getTag() + r102);
    }
}
