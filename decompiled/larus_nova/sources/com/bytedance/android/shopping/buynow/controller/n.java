package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.shopping.base.event.EventActionImpl;
import io.reactivex.functions.Action;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f170849a = null;

    static {
        f170849a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        EventActionImpl r100 = new EventActionImpl();
        Pair[] r101 = new Pair[4];
        r101[0] = TuplesKt.to("business", "buynow");
        r101[1] = TuplesKt.to("location", "buy");
        nl.c r102 = o.f170850a;
        Object r103 = null;
        if (r102 == null) goto L12;
        Map<String, String> r104 = r102.b();
        if (r104 == null) goto L12;
        Map r105 = MapsKt.toMutableMap(r104);
        if (r105 == null) goto L12;
        nl.c r106 = o.f170850a;
        if (r106 == null) goto L11;
        r103 = r106.a();
    L11:
        r105.put("mega_object", r103);
        Unit r107 = Unit.INSTANCE;
        r103 = r105;
    L12:
        r101[2] = TuplesKt.to("in_schema", r103);
        r101[3] = TuplesKt.to("log_id", o.f170851b);
        r100.doEventAction("schema_report", MapsKt.mapOf(r101));
    }
}
