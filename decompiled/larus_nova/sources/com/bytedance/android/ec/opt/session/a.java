package com.bytedance.android.ec.opt.session;

import bm.b;
import com.bytedance.android.ec.opt.session.model.StageType;
import com.bytedance.android.ec.opt.session.settings.ECPerfSettings;
import com.bytedance.android.ec.opt.session.settings.ParamsExtractRule;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bm.a f48099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f48100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f48101c;

    public final synchronized bm.a a() {
        monitor-enter(this);
        bm.a r100 = this.f48099a.a(null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final void b() {
        bm.a r100 = a();
        JSONObject r101 = new JSONObject();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Iterator r103 = ((LinkedHashMap) r100.f19538b).entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        if (r103.hasNext() == false) goto L7;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L13
        r101.putOpt((String) r104.getKey(), r104.getValue());     // Catch: Throwable -> L13
        goto L5
    L7:
        Iterator r105 = ((LinkedHashMap) r100.f19537a).entrySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r105.hasNext() == false) goto L11;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L13
        r101.putOpt((String) r106.getKey(), r106.getValue());     // Catch: Throwable -> L13
        goto L9
    L11:
        r101.putOpt("type", "PERFORMANCE_LOG");     // Catch: Throwable -> L13
        Result.m9449constructorimpl(r101.putOpt(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI));     // Catch: Throwable -> L13
    L15:
        AppLogNewUtils.onEventV3("ec_perf_secondary_page", r101);
        return;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        bm.a r101 = new bm.a();
        this.f48099a = r101;
        this.f48100b = "0";
        this.f48101c = System.currentTimeMillis();
        r101.f19537a.put("session_id", r100);
        r101.f19537a.put("stage", "Unknown");
        r101.f19537a.put("has_leave", this.f48100b);
    }

    public final void c(String r110, b r111) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L38
        List r101 = (List) ((Map) ECPerfSettings.f48105c.getValue()).get(r110);     // Catch: Throwable -> L38
        Unit r102 = null;
        if (r101 == null) goto L36;
        Iterator r103 = r101.iterator();     // Catch: Throwable -> L38
    L6:
        if (r103.hasNext() == false) goto L35;
        ParamsExtractRule r104 = (ParamsExtractRule) r103.next();     // Catch: Throwable -> L38
        String r105 = r104.getRedirectName();     // Catch: Throwable -> L38
        if (r105 != null) goto L14;
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L38
        r106.append(r110);     // Catch: Throwable -> L38
        r106.append('_');     // Catch: Throwable -> L38
        String r107 = r104.getKeyPath();     // Catch: Throwable -> L38
        if (r107 == null) goto L12;
        String r108 = StringsKt.replace$default(r107, ".", "_", false, 4, null);     // Catch: Throwable -> L38
    L13:
        r106.append(r108);     // Catch: Throwable -> L38
        r105 = r106.toString();     // Catch: Throwable -> L38
        goto L14
    L12:
        r108 = null;
    L14:
        Map<String, Object> r109 = r111.b();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r104, "$this$getOriginValueByPath");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r109, "data");     // Catch: Throwable -> L38
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L21
        String r113 = r104.getKeyPath();     // Catch: Throwable -> L21
        if (r113 == null) goto L23;
        List r114 = StringsKt.split$default(r113, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L21
        if (r114 == null) goto L23;
        Object r115 = com.bytedance.android.ec.opt.session.settings.a.a(r109, r114);     // Catch: Throwable -> L21
    L24:
        if (r115 == null) goto L6;
        Object r116 = com.bytedance.android.ec.opt.session.settings.a.b(r104, r115);     // Catch: Throwable -> L38
        if (r116 == null) goto L6;
        this.f48099a.f19538b.put(r105, r116);     // Catch: Throwable -> L38
        Integer r117 = r104.getAddCommonParams();     // Catch: Throwable -> L38
        if (r117 == null) goto L6;
        if (r117.intValue() != 1) goto L6;
        this.f48099a.f19537a.put(r105, r116);     // Catch: Throwable -> L38
        goto L6
    L23:
        r115 = null;
    L21:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L38
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L38
        goto L23
    L35:
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L38
    L36:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L38
    L40:
        this.f48099a.f19537a.put("stage", r110);
        this.f48099a.f19537a.put("has_leave", this.f48100b);
        this.f48099a.f19537a.put("P_" + r110 + "_timestamp", r111.f19543d);
        if (r111.getType() != StageType.VIRTUAL) goto L43;
        return;
    L43:
        if (this.f48099a.f19537a.containsKey(ILoadStallMonitor.START_TIME) == true) goto L65;
        this.f48099a.f19537a.put(ILoadStallMonitor.START_TIME, r111.f19543d);
        return;
    L65:
        return;
    L38:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    }
}
