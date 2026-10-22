package com.bytedance.android.latch.jsb2.internal;

import com.bytedance.android.latch.prefetch.internal.g0;
import com.bytedance.android.latch.prefetch.internal.o;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f58412a;

    public e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        this.f58412a = r100;
    }

    @Override // com.bytedance.android.latch.prefetch.internal.o
    public final void b(String r100, Map<String, String> r101, Map<String, String> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r103, "callbackId");
        JSONObject r104 = new JSONObject();
        r104.put("url", r100);
        r104.put(com.alipay.sdk.m.p.e.f25671s, MonitorConstants.CONNECT_TYPE_GET);
        r104.put("headers", g0.d(r101));
        r104.put("pb_extras", g0.d(r102));
        String r105 = r104.toString();
        b r106 = this.f58412a;
        c0.a r107 = c0.a();
        r107.f249329c = "fetch";
        r107.f249330d = r105;
        r107.f249331e = r103;
        r107.f249332f = null;
        r106.o(r107.a());
    }

    @Override // com.bytedance.android.latch.prefetch.internal.o
    public final void a(String r100, Map<String, String> r101, String r102, JSONObject r103, Map<String, String> r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r105, "callbackId");
        JSONObject r106 = new JSONObject();
        r106.put("url", r100);
        r106.put(com.alipay.sdk.m.p.e.f25671s, UGCMonitor.TYPE_POST);
        r106.put("headers", g0.d(r101));
        r106.put("data", r103);
        r106.put("pb_extras", g0.d(r104));
        String r107 = r106.toString();
        b r108 = this.f58412a;
        c0.a r109 = new c0.a();
        r109.f249329c = "fetch";
        r109.f249330d = r107;
        r109.f249331e = r105;
        r109.f249332f = null;
        r108.o(new c0(r109));
    }
}
