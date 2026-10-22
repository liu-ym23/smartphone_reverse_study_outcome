package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.optimize.statistics.FrescoMonitorConst;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f44890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f44891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f44892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ECImageMainHandlerOpt.URIStruct f44893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f44894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f44895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ yl.a f44896g;

    public r(long r100, long r101, long r102, ECImageMainHandlerOpt.URIStruct r103, boolean r104, boolean r105, yl.a r110) {
        this.f44890a = r100;
        this.f44891b = r101;
        this.f44892c = r102;
        this.f44893d = r103;
        this.f44894e = r104;
        this.f44895f = r105;
        this.f44896g = r110;
    }

    public final void a() {
        long r100 = this.f44890a;
        long r101 = this.f44891b;
        double r102 = (r100 - r101) / 1000000.0d;
        long r103 = this.f44892c;
        double r104 = (r103 - r100) / 1000000.0d;
        double r105 = (r103 - r101) / 1000000.0d;
        int r106 = ECMonitorService.f45110b;
        JSONObject r107 = new JSONObject();
        String r108 = this.f44893d.b("biz_tag");
        if (r108 == null) goto L5;
        r107.put("biz_tag", r108);
    L5:
        String r109 = this.f44893d.b(FrescoMonitorConst.SCENE_TAG);
        if (r109 == null) goto L8;
        r107.put(FrescoMonitorConst.SCENE_TAG, r109);
    L8:
        r107.put("url", this.f44893d.toString());
        r107.put("is_success", this.f44894e);
        r107.put("is_asynchronous", this.f44895f);
        String r110 = this.f44896g.f568301a;
        if (r110 == null) goto L11;
        r107.put("hit_rule_key", r110);
    L11:
        Unit r111 = Unit.INSTANCE;
        JSONObject r112 = new JSONObject();
        r112.put("obtain_duration", r102);
        r112.put("new_result_duration", r104);
        r112.put("total_duration", r105);
        ECMonitorService.a.a("ecom_image_main_handler_opt_monitor", r107, r112, new JSONObject());
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
