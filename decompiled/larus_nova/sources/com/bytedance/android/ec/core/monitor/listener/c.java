package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends ActionRateListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f45178j;

    public static void j(c r100, int r101) {
        Intrinsics.checkNotNullParameter("", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        r100.k(r101, "", r100.f45167b);
    }

    public c(String r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "fullFill");
        super(r100, r101, r102);
        this.f45178j = r102;
    }

    public final void k(int r100, String r101, JSONObject r110) {
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L12;
        if (r100 != (-1)) goto L12;
        r101 = "接口请求失败";
    L10:
        String r104 = r101;
        Set<String> r105 = ECProcessMonitor.f45118a;
        ECProcessMonitor.m(this, this.f45172g, this.f45173h, Integer.valueOf(r100), r104, r110, this.f45168c);
        this.f45178j.invoke();
        return;
    L12:
        if (r101.length() != 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L20;
        if (r100 != (-2)) goto L20;
        r101 = "schema为空";
    L20:
        if (r101.length() != 0) goto L22;
        r102 = true;
    L22:
        if (r102 == false) goto L10;
        if (r100 != (-3)) goto L10;
        r101 = "法务检查失败";
        goto L10
    L14:
        r106 = false;
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    public final void l(int r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        JSONObject r103 = x0.a(this.f45167b);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        if (r102 == null) goto L12;
        Iterator<Map.Entry<String, ? extends Object>> r105 = r102.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r105.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r106 = r105.next();     // Catch: Throwable -> L15
        if (r106.getValue() == null) goto L7;
        r103.put(r106.getKey(), r106.getValue());     // Catch: Throwable -> L15
        goto L7
    L11:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L15
    L17:
        k(r100, r101, r103);
        return;
    L12:
        r107 = null;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
