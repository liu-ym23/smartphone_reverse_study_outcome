package com.bytedance.android.live.revenue.platform.network.impl;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.i;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f91563a = null;

    static {
        f91563a = GsonHelper.get();
    }

    public static Extra a(Extra r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "originExtra");
        Intrinsics.checkNotNullParameter(r101, "extraType");
        if ((r100 instanceof i) == false) goto L6;
        return (Extra) GsonProtectorUtils.fromJson(f91563a, ((i) r100).f58838b, r101);
    L6:
        return (Extra) r101.newInstance();
    }
}
