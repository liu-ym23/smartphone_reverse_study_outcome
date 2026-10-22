package com.bytedance.android.ec.hybrid.ui;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;
import yj.k;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f47704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f47705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f47706c;

    public h(HashMap r100, long r101, long r102) {
        this.f47704a = r100;
        this.f47705b = r101;
        this.f47706c = r102;
    }

    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L29
        Object r101 = this.f47704a.get("openTime");     // Catch: Throwable -> L29
        Unit r102 = null;
        if ((r101 instanceof Double) == true) goto L6;
        r101 = null;
    L6:
        Double r103 = (Double) r101;     // Catch: Throwable -> L29
        if (r103 == null) goto L28;
        long r104 = (long) r103.doubleValue();     // Catch: Throwable -> L29
        if (r104 > 0) goto L11;
        return;
    L11:
        Object r105 = this.f47704a.get("jsbStartTime");     // Catch: Throwable -> L29
        if ((r105 instanceof Double) == true) goto L14;
        r105 = null;
    L14:
        Double r106 = (Double) r105;     // Catch: Throwable -> L29
        if (r106 == null) goto L17;
        Long r107 = Long.valueOf((long) r106.doubleValue());     // Catch: Throwable -> L29
    L18:
        Object r108 = this.f47704a.get("jsb_end_time");     // Catch: Throwable -> L29
        if ((r108 instanceof Long) == true) goto L21;
        r108 = null;
    L21:
        Long r109 = (Long) r108;     // Catch: Throwable -> L29
        IHybridHostService r110 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L29
        if (r110 == null) goto L26;
        k r111 = r110.getIHybridHostEventService();     // Catch: Throwable -> L29
        if (r111 == null) goto L26;
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L29
        r112.putOpt("open_time", Long.valueOf(r104));     // Catch: Throwable -> L29
        r112.putOpt("jsb_start_time", r107);     // Catch: Throwable -> L29
        r112.putOpt("jsb_end_time", r109);     // Catch: Throwable -> L29
        r112.putOpt("router_end_time", Long.valueOf(this.f47705b));     // Catch: Throwable -> L29
        r112.putOpt("scene", "go_product_detail");     // Catch: Throwable -> L29
        r112.putOpt("page_name", this.f47704a.get("page_name"));     // Catch: Throwable -> L29
        r112.putOpt("router_start_time", Long.valueOf(this.f47706c));     // Catch: Throwable -> L29
        r112.putOpt("type", "use_method");     // Catch: Throwable -> L29
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L29
        r111.logV3("mall_enter_detail_time", r112);     // Catch: Throwable -> L29
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L29
    L26:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L29
        return;
    L17:
        r107 = null;
        goto L18
    L28:
        return;
    L29:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
