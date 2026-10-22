package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f190153a;

    public static final class a {
    }

    static {
    }

    public r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheId");
        this.f190153a = Keva.getRepo(r100, 1);
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Keva r102 = this.f190153a;
        if (r102 == null) goto L6;
        r102.storeString(r100, r101);
        return;
    }
}
