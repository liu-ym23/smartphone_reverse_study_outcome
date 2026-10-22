package com.bytedance.android.shopping.anchorv3.utils;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165310a = 0;

    static {
    }

    public static String a(Context r100, long r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r111 = r110 / ((long) 1000);
        long r101 = 60;
        long r102 = r111 % r101;
        long r112 = (r111 / r101) % r101;
        long r103 = 10;
        if (r102 >= r103) goto L5;
        String r104 = th.a.f(r100).getString(R.string.shopping_date_zero_placeholder, new Object[]{Long.valueOf(r102)});
    L7:
        if (r112 >= r103) goto L9;
        String r113 = th.a.f(r100).getString(R.string.shopping_date_zero_placeholder, new Object[]{Long.valueOf(r112)});
    L10:
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        return String.format(th.a.f(r100).getString(R.string.shopping_date_format), Arrays.copyOf(new Object[]{r113, r104}, 2));
    L9:
        r113 = String.valueOf(r112);
        goto L10
    L5:
        r104 = String.valueOf(r102);
        goto L7
    }
}
