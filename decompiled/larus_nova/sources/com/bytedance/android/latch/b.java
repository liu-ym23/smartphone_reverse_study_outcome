package com.bytedance.android.latch;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f58213c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f58214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58215b;

    public static final class a {
        public static void a(Map r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "settings");
            Intrinsics.checkNotNullParameter(r101, "key");
            if (r102 == false) goto L5;
            String r103 = "1";
        L6:
            r100.put(r101, r103);
            return;
        L5:
            r103 = "0";
            goto L6
        }
    }

    static {
    }

    public b(Map<String, String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.f58214a = r100;
        this.f58215b = r101;
    }
}
