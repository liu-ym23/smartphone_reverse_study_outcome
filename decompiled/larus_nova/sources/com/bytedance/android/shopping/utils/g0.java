package com.bytedance.android.shopping.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f187082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f187083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f187084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f187085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f187086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f187087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f187088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function2 f187089h;

    public final void a() {
        n1.f45660i.getClass();
        n1.f45658g = true;
        MonitorUtils.monitorEvent("goods_alibc_init_error_rate", new JSONObject().put("status", 0), null, null);
        int r100 = h0.f187145a;
        h0.b(this.f187082a, this.f187083b, this.f187084c, this.f187085d, this.f187086e, this.f187087f, this.f187088g, this.f187089h);
    }

    public g0(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, Function2 r107) {
        this.f187082a = r100;
        this.f187083b = r101;
        this.f187084c = r102;
        this.f187085d = r103;
        this.f187086e = r104;
        this.f187087f = r105;
        this.f187088g = r106;
        this.f187089h = r107;
    }
}
