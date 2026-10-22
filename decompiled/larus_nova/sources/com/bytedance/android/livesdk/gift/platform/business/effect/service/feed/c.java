package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static final zy0.d a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        vy0.b r102 = (vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        Intrinsics.checkNotNullParameter(r101, "$this$toUri");
        return r102.U0(r100, UriProtector.parse(r101), null);
    }
}
