package com.bytedance.android.monitorV2;

import android.util.LruCache;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f163108a = null;

    public static final class a extends LruCache<String, String> {
        public a(int r100) {
            super(r100);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, String r101) {
            String r102 = r100;
            String r103 = r101;
            int r104 = 0;
            if (r102 == null) goto L9;
            int r105 = r102.length();
            if (r103 == null) goto L8;
            r104 = r103.length();
        L8:
            return r104 + r105;
        L9:
            return 0;
        }
    }

    static {
        f163108a = new a((((int) Runtime.getRuntime().maxMemory()) / 1024) / 8);
    }

    public static String a(String r100, List r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        List r103 = r101;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        String r105 = "";
        if (r104 == false) goto L12;
        return "";
    L12:
        long r106 = System.currentTimeMillis();
        String r107 = f163108a.get(r100);
        if (r107 == null) goto L16;
        System.out.println("hit cache: ".concat(r107));
        b(true, r100, r106);
        return r107;
    L16:
        if (r102 == true) goto L18;
        return "";
    L18:
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "regexList");
        Iterator r108 = r101.iterator();
    L20:
        if (r108.hasNext() == false) goto L24;
        lz2.a r109 = (lz2.a) r108.next();
        if (r109.b().containsMatchIn(r100) == false) goto L20;
        System.out.print(r109.b() + " match " + r109.f511342a);
    L25:
        if (r109 == null) goto L27;
        r105 = r109.f511342a;
    L27:
        f163108a.put(r100, r105);
        b(false, r100, r106);
        return r105;
    L24:
        r109 = null;
        goto L25
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public static void b(boolean r100, String r101, long r102) {
        Map<String, Map<String, String>> r103 = InternalWatcher.f162982a;
        InternalWatcher.a(null, "regex_perf", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r101), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_HIT_CACHE, String.valueOf(r100))}), MapsKt.mapOf(TuplesKt.to("regex_match_time", Long.valueOf(System.currentTimeMillis() - r102))));
    }
}
