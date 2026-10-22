package com.bytedance.android.monitorV2.util;

import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class t extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f163255d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ArrayList<String> f163256e = null;

    static {
        f163255d = new t();
        f163256e = CollectionsKt.arrayListOf(new String[]{"bd_hybrid_monitor_bid", "bdhm_bid"});
    }

    public t() {
        super("regex_param_bid");
    }

    @Override // com.bytedance.android.monitorV2.util.a
    public final a.C2495a a(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L16:
        if (r101 != null) goto L18;
    L29:
        ArrayList r103 = CollectionsKt.arrayListOf(new String[]{r100, r101});
        if (r103 != null) goto L32;
    L35:
        boolean r104 = true;
    L36:
        if (r104 == true) goto L53;
        Iterator r105 = r103.iterator();
    L40:
        if (r105.hasNext() == false) goto L53;
        String r106 = (String) r105.next();
        Iterator<T> r107 = f163256e.iterator();
    L43:
        if (r107.hasNext() == false) goto L40;
        String r108 = (String) r107.next();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L50
        String r110 = UriProtector.getQueryParameter(UriProtector.parse(r106), r108);     // Catch: Throwable -> L50
        if (r110 == null) goto L48;
        a.f163229c.put(r106, r110);     // Catch: Throwable -> L50
    L55:
        if (r110.length() == 0) goto L58;
        r102 = false;
    L58:
        if (r102 == true) goto L64;
        if (Intrinsics.areEqual(r110, "__hybrid_default") == true) goto L64;
        return b(r110);
    L64:
        return this.f163231b;
    L48:
        Object r111 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L50
    L52:
        Result.m9452exceptionOrNullimpl(r111);
    L50:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L53:
        r110 = "";
        goto L55
    L32:
        if (r103.isEmpty() == true) goto L35;
        r104 = false;
        goto L36
    L18:
        if (r101.length() <= 0) goto L20;
        boolean r113 = true;
    L21:
        if (r113 == false) goto L23;
        String r114 = r101;
    L24:
        if (r114 == null) goto L29;
        String r115 = a.f163229c.get(r114);
        if (r115 == null) goto L29;
        return f163255d.b(r115);
    L23:
        r114 = null;
        goto L24
    L20:
        r113 = false;
        goto L21
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r116 = true;
    L8:
        if (r116 == false) goto L10;
        String r117 = r100;
    L11:
        if (r117 == null) goto L16;
        String r118 = a.f163229c.get(r117);
        if (r118 == null) goto L16;
        return f163255d.b(r118);
    L10:
        r117 = null;
        goto L11
    L7:
        r116 = false;
        goto L8
    }
}
