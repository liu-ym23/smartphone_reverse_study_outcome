package com.bytedance.android.live.liveinteract.plantform.utils;

import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f77474a;

    public e(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
        this.f77474a = r100;
    }

    public final void a(JSONObject r110, int r111, String r210) {
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r210, "strInfo");
        p0 r100 = this.f77474a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r210, "strInfo");
        if ((System.currentTimeMillis() - r100.f77514f) <= r100.f77513e) goto L5;
        r100.f77510b.clear();
    L5:
        r100.f77514f = System.currentTimeMillis();
        Iterator<p> r101 = r100.f77509a.iterator();
    L7:
        if (r101.hasNext() == false) goto L64;
        p r102 = r101.next();
        Pair<String, Integer> r103 = r102.a(r110);
        if (r103 == null) goto L10;
        String r104 = r103.getFirst();
        Integer r105 = r100.f77510b.get(r104);
        if (r105 != null) goto L14;
        r105 = -1;
    L14:
        int r106 = r105.intValue();
        int r107 = r103.getSecond().intValue();
        boolean r112 = false;
        int r113 = 0;
        int r114 = 0;
        if (r100.f77527s == false) goto L49;
        if (r111 == 1) goto L18;
        if (r111 == 2) goto L29;
    L38:
        int r115 = r107 - r100.f77525q;
        if (2 > r115) goto L45;
        if (59 < r115) goto L45;
        r100.f77526r += r115;
    L45:
        if (r100.f77518j != null) goto L47;
        r100.f77518j = Integer.valueOf(r107);
    L47:
        r100.f77517i = r107;
    L52:
        if (r106 < r107) goto L60;
        if ((r106 - r107) > r100.f77511c) goto L60;
        if (r111 == 1) goto L58;
        r100.f77521m++;
        goto L7
    L58:
        r100.f77522n++;
    L60:
        r100.f77525q = r107;
        r100.f77510b.put(r104, Integer.valueOf(r107));
        if (r111 == 2) goto L62;
        r102.b(r110.toString());
        goto L7
    L62:
        r102.b(r210);
        goto L7
    L29:
        if (r107 <= r100.f77523o) goto L37;
        Integer r116 = r100.f77518j;
        if (r116 == null) goto L33;
        r114 = r116.intValue();
    L33:
        if (r107 <= r114) goto L37;
        r100.f77515g++;
        if (r100.f77519k != null) goto L37;
        r100.f77519k = Integer.valueOf(r107);
    L37:
        r100.f77523o = r107;
        goto L38
    L18:
        if (r107 <= r100.f77524p) goto L26;
        Integer r117 = r100.f77518j;
        if (r117 == null) goto L22;
        r113 = r117.intValue();
    L22:
        if (r107 <= r113) goto L26;
        r100.f77516h++;
        if (r100.f77520l != null) goto L26;
        r100.f77520l = Integer.valueOf(r107);
    L26:
        r100.f77524p = r107;
        goto L38
    L49:
        if ((System.currentTimeMillis() - r100.f77528t) <= 5000) goto L51;
        r112 = true;
    L51:
        r100.f77527s = r112;
        goto L52
    L10:
        r102.b(r210);
        goto L7
    }
}
