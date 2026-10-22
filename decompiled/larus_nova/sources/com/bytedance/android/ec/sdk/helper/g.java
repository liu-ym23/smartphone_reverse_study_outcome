package com.bytedance.android.ec.sdk.helper;

import android.content.Context;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f48122a = null;

    public g() {
    }

    static {
        f48122a = new g();
    }

    public static xi.a f() {
        return d.f48119b.getIECHostLogService();
    }

    @Override // xi.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "abSDKVersion");
        f().a(r100);
    }

    @Override // xi.a
    public final String addCommonParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return f().addCommonParams(r100);
    }

    @Override // xi.a
    @Deprecated(message = "use ECLogService instead.")
    public final void e(Exception r100) {
        f().e(r100);
    }

    @Override // xi.a
    public final void c(long r100, long r101) {
        Intrinsics.checkNotNullParameter("ECFullTradeMonitor", "scene");
        f().c(r100, r101);
    }

    @Override // xi.a
    public final void logV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        CopyOnWriteArraySet<u> r102 = f.f48121a;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Iterator<u> r103 = f.f48121a.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        u r104 = r103.next();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        r104.a(r100, r101);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    L10:
        f().logV3(r100, r101);
        CopyOnWriteArrayList<t> r107 = e.f48120a;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Iterator r108 = CollectionsKt.toMutableList(e.f48120a).iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        ((t) r108.next()).a();
        goto L12
    }

    @Override // xi.a
    public final void d(String r100, List<String> r101, Long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "trackLabel");
        f().d(r100, r101, r102, r103);
    }

    public final void g(String r100, JSONObject r101, String r102, PageFinder r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "btm");
        Intrinsics.checkNotNullParameter(r103, "pageFinder");
        Iterator<Map.Entry<String, Object>> r104 = BtmSDK.INSTANCE.createReportParams(r102, r103).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, Object> r105 = r104.next();
        r101.putOpt(r105.getKey(), r105.getValue());
        goto L4
    L6:
        logV3(r100, r101);
    }

    @Override // xi.a
    public final void b(Context r110, String r111, String r112, String r113, long r114, JSONObject r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "eventName");
        Intrinsics.checkNotNullParameter(r112, "labelName");
        Intrinsics.checkNotNullParameter(r113, "value");
        Intrinsics.checkNotNullParameter(r115, "ext_json");
        f().b(r110, r111, r112, r113, r114, r115);
    }
}
