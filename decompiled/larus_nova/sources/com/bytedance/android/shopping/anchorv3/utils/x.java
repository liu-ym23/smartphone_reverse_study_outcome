package com.bytedance.android.shopping.anchorv3.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165359a = 0;

    static {
    }

    public static Map a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return d(r100, SetsKt.setOf(q.e.f165347b));
    }

    public static Map b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return d(r100, SetsKt.setOf(new q[]{q.c.f165345b, q.f.f165348b, q.d.f165346b, q.h.f165350b, q.b.f165344b}));
    }

    public static Map c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return d(r100, SetsKt.setOf(q.k.f165353b));
    }

    public static Map d(Context r100, Set r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        q r104 = (q) r103.next();
        String r105 = p.b(r100, r104);
        if (r105 == null) goto L4;
        r102.put(r104.f165342a, r105);
        goto L4
    L8:
        return r102;
    }
}
