package com.bytedance.android.annie.business.lynx;

import com.bytedance.ies.bullet.lynx.resource.DefaultDynamicComponentFetcher;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends DefaultDynamicComponentFetcher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, ? extends k7a.a> f39043d;

    /* JADX INFO: renamed from: com.bytedance.android.annie.business.lynx.a$a, reason: collision with other inner class name */
    public static final class C0730a {
    }

    static {
    }

    public a(j r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        f8.b r102 = com.bytedance.android.annie.lynx.e.a().f467381h;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        Map<String, k7a.a> r103 = r102.provide();     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L15;
        r104 = MapsKt.emptyMap();
    L15:
        this.f39043d = (Map) r104;
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.ies.bullet.lynx.resource.DefaultDynamicComponentFetcher, k7a.a
    public final void loadDynamicComponent(String r100, k7a.a.InterfaceC6515a r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L41;
        Map<String, ? extends k7a.a> r104 = this.f39043d;
        if (r104 == null) goto L41;
        if (r104.isEmpty() != true) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L41;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L39
        String r107 = UriProtector.getQueryParameter(UriProtector.parse(r100), "res_biz_name");     // Catch: Throwable -> L39
        if (r107 != null) goto L21;
    L24:
        boolean r108 = true;
    L25:
        if (r108 == true) goto L41;
        Map<String, ? extends k7a.a> r109 = this.f39043d;     // Catch: Throwable -> L39
        if (r109 == null) goto L36;
        Iterator<Map.Entry<String, ? extends k7a.a>> r110 = r109.entrySet().iterator();     // Catch: Throwable -> L39
    L31:
        if (r110.hasNext() == false) goto L35;
        Map.Entry<String, ? extends k7a.a> r111 = r110.next();     // Catch: Throwable -> L39
        if (Intrinsics.areEqual(r111.getKey(), r107) == false) goto L31;
        r111.getValue().loadDynamicComponent(r100, new b(this, r100, r101));     // Catch: Throwable -> L39
        r102 = true;
        goto L41
    L35:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L39
    L37:
        Result.m9449constructorimpl(r112);     // Catch: Throwable -> L39
        goto L41
    L36:
        r112 = null;
        goto L37
    L21:
        if (r107.length() == 0) goto L24;
        r108 = false;
    L39:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L15:
        r105 = false;
    L41:
        if (r102 == false) goto L43;
        return;
    L43:
        super.loadDynamicComponent(r100, r101);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
