package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159144a = 0;

    static {
    }

    public static int a(IBaseUser r100) {
        Intrinsics.checkNotNullParameter(r100, "iUser");
        if (r100.getUserHonor() == null) goto L9;
        py.d r101 = r100.getUserHonor();
        if (r101 == null) goto L9;
        if (r101.getLevel() != 0) goto L9;
        return 1;
    L9:
        return 0;
    }
}
