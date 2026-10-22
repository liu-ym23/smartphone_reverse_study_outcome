package com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f133508a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133509b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f133510c = 0;

    static {
        f133508a = 1.1428572f;
        if (PublicScreenABHelper.c() == false) goto L5;
        float r100 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.g.a(PublicScreenABHelper.e() * 14.0f);
    L6:
        f133509b = (int) r100;
        f133510c = (int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.g.a(16.0f);
        return;
    L5:
        r100 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.g.a(16.0f);
        goto L6
    }
}
