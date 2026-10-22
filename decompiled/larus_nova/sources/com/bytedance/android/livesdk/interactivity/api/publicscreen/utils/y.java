package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes9.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f133656a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133657b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f133658c = 0;

    static {
        f133656a = s1.f(195.0f);
        f133657b = s1.f(165.0f);
        f133658c = s1.f(180.0f);
    }

    public static final int a() {
        double r100 = (s1.y() * 1.0f) / s1.w();
        if (r100 < 0.56d) goto L7;
        return f133657b;
    L7:
        if (r100 < 0.5d) goto L10;
        return f133658c;
    L10:
        return f133656a;
    }
}
