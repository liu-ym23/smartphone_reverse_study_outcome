package com.bytedance.android.latch.xbridge.internal;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.latch.prefetch.internal.g0;
import com.bytedance.android.latch.prefetch.internal.o;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kx.b.a f58507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.latch.xbridge.internal.b f58508b;

    public static final class a implements kx.b.a.InterfaceC6625a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f58509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f58510b;

        @Override // kx.b.a.InterfaceC6625a
        public final void onFail(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f58509a.f58508b.c(com.bytedance.android.latch.internal.util.b.a(new Pair[]{TuplesKt.to("reason", r100)}), "fetch", this.f58510b);
        }

        @Override // kx.b.a.InterfaceC6625a
        public final void onSuccess(Map<String, ?> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            if (r100.get("__jsb2__data__") == null) goto L5;
            com.bytedance.android.latch.xbridge.internal.b r101 = this.f58509a.f58508b;
            Object r102 = r100.get("__jsb2__data__");
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type org.json.JSONObject");
            r101.c((JSONObject) r102, "fetch", this.f58510b);
            return;
        L5:
            this.f58509a.f58508b.c(new JSONObject(r100), "fetch", this.f58510b);
        }

        public a(c r100, String r101) {
            this.f58509a = r100;
            this.f58510b = r101;
        }
    }

    public static final class b implements kx.b.a.InterfaceC6625a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f58511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f58512b;

        @Override // kx.b.a.InterfaceC6625a
        public final void onFail(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f58511a.f58508b.c(com.bytedance.android.latch.internal.util.b.a(new Pair[]{TuplesKt.to("reason", r100)}), "fetch", this.f58512b);
        }

        @Override // kx.b.a.InterfaceC6625a
        public final void onSuccess(Map<String, ?> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            if (r100.get("__jsb2__data__") == null) goto L5;
            com.bytedance.android.latch.xbridge.internal.b r101 = this.f58511a.f58508b;
            Object r102 = r100.get("__jsb2__data__");
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type org.json.JSONObject");
            r101.c((JSONObject) r102, "fetch", this.f58512b);
            return;
        L5:
            this.f58511a.f58508b.c(new JSONObject(r100), "fetch", this.f58512b);
        }

        public b(c r100, String r101) {
            this.f58511a = r100;
            this.f58512b = r101;
        }
    }

    public c(kx.b.a r100, com.bytedance.android.latch.xbridge.internal.b r101) {
        Intrinsics.checkNotNullParameter(r100, "callHandler");
        Intrinsics.checkNotNullParameter(r101, "methodListenerStore");
        this.f58507a = r100;
        this.f58508b = r101;
    }

    @Override // com.bytedance.android.latch.prefetch.internal.o
    public final void b(String r100, Map<String, String> r101, Map<String, String> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r103, "callbackId");
        this.f58508b.d("fetch", r103);
        JSONObject r104 = new JSONObject();
        r104.put("url", r100);
        r104.put(e.f25671s, MonitorConstants.CONNECT_TYPE_GET);
        r104.put("headers", g0.d(r101));
        r104.put("pb_extras", g0.d(r102));
        this.f58507a.a("fetch", lx.a.b(r104), new a(this, r103));
    }

    @Override // com.bytedance.android.latch.prefetch.internal.o
    public final void a(String r100, Map<String, String> r101, String r102, JSONObject r103, Map<String, String> r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r105, "callbackId");
        this.f58508b.d("fetch", r105);
        JSONObject r106 = new JSONObject();
        r106.put("url", r100);
        r106.put(e.f25671s, UGCMonitor.TYPE_POST);
        r106.put("headers", g0.d(r101));
        r106.put("data", r103);
        r106.put("pb_extras", g0.d(r104));
        this.f58507a.a("fetch", lx.a.b(r106), new b(this, r105));
    }
}
