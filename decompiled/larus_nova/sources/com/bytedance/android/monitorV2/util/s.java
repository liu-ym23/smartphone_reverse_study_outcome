package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class s extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f163254d = null;

    static {
        f163254d = new s();
    }

    public s() {
        super("regex_list_bid");
    }

    @Override // com.bytedance.android.monitorV2.util.a
    public final a.C2495a a(String r110, String r111) {
        List<lz2.a> r112 = com.bytedance.android.monitorV2.g.e().d().a();
        List<lz2.a> r100 = r112;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        if (r110 == null) goto L14;
        long r102 = System.currentTimeMillis();
        String r103 = a.f163229c.get(r110);
        if (r103 == null) goto L39;
        c(true, r110, r102);
        return b(r103);
    L39:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L25
        UriProtector.getQueryParameter(UriProtector.parse(r110), "url");     // Catch: Throwable -> L25
        if (StringsKt.startsWith$default(r110, "http", false, 2, null) == false) goto L22;
        String r105 = (String) CollectionsKt.first(StringsKt.split$default(r110, new String[]{"?"}, false, 0, 6, null));     // Catch: Throwable -> L25
    L23:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r106) == false) goto L30;
        r106 = r110;
    L30:
        String r107 = (String) r106;
        Iterator<lz2.a> r113 = r112.iterator();
    L32:
        if (r113.hasNext() == false) goto L36;
        lz2.a r108 = r113.next();
        if (r108.b().containsMatchIn(r107) == false) goto L32;
        String r114 = r108.f511342a;
    L37:
        a.f163229c.put(r110, r114);
        c(false, r110, r102);
        return b(r114);
    L36:
        r114 = "";
        goto L37
    L22:
        r105 = r110;
    L25:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L14:
        return this.f163231b;
    L11:
        return this.f163231b;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static void c(boolean r100, String r101, long r102) {
        Map<String, Map<String, String>> r103 = InternalWatcher.f162982a;
        InternalWatcher.a(null, "regex_perf", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r101), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_HIT_CACHE, String.valueOf(r100))}), MapsKt.mapOf(TuplesKt.to("regex_match_time", Long.valueOf(System.currentTimeMillis() - r102))));
    }
}
