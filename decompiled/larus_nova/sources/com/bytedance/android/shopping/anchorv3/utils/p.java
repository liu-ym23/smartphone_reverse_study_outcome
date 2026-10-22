package com.bytedance.android.shopping.anchorv3.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.k1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p {
    static {
    }

    @JvmStatic
    public static final String a(int r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append('_');
        r102.append(r101);
        return r102.toString();
    }

    @JvmStatic
    public static final String b(Context r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageDisplayPosition");
        if (Intrinsics.areEqual(r101, q.j.f165352b) == false) goto L6;
        return a(vf4.a.a(r100, 32.0f), vf4.a.a(r100, 32.0f));
    L6:
        if (Intrinsics.areEqual(r101, q.a.f165343b) == false) goto L9;
        return a(vf4.a.a(r100, 94.0f), vf4.a.a(r100, 94.0f));
    L9:
        if (Intrinsics.areEqual(r101, q.c.f165345b) == false) goto L12;
        return a(vf4.a.a(r100, 48.0f), vf4.a.a(r100, 48.0f));
    L12:
        if (Intrinsics.areEqual(r101, q.f.f165348b) == false) goto L15;
        return a(k1.m(r100), k1.m(r100));
    L15:
        if (Intrinsics.areEqual(r101, q.d.f165346b) == false) goto L18;
        return a(vf4.a.a(r100, 169.0f), vf4.a.a(r100, 169.0f));
    L18:
        if (Intrinsics.areEqual(r101, q.e.f165347b) == false) goto L21;
        return a(k1.m(r100), -1);
    L21:
        if (Intrinsics.areEqual(r101, q.g.f165349b) == false) goto L24;
        return a(vf4.a.a(r100, 173.0f), vf4.a.a(r100, 173.0f));
    L24:
        if (Intrinsics.areEqual(r101, q.h.f165350b) == false) goto L27;
        return a(vf4.a.a(r100, 37.0f), vf4.a.a(r100, 37.0f));
    L27:
        if (Intrinsics.areEqual(r101, q.b.f165344b) == false) goto L30;
        return a(k1.m(r100) * 3, k1.m(r100) * 3);
    L30:
        if (Intrinsics.areEqual(r101, q.k.f165353b) == false) goto L33;
        return a(vf4.a.a(r100, 150.0f), vf4.a.a(r100, 150.0f));
    L33:
        if (Intrinsics.areEqual(r101, q.i.f165351b) == true) goto L47;
        return null;
    L47:
        return a(vf4.a.a(r100, 64.0f), vf4.a.a(r100, 64.0f));
    }
}
