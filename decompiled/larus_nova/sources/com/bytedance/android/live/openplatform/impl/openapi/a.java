package com.bytedance.android.live.openplatform.impl.openapi;

import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yo0.b;
import yo0.c;
import yo0.d;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f85371a;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.openapi.a$a, reason: collision with other inner class name */
    public static final class C1318a {
    }

    static {
    }

    public a() {
        this.f85371a = new ConcurrentHashMap();
    }

    @Override // yo0.b
    public final void b(AbsOpenApiHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f85371a.put(r100.f85370d, r100);
    }

    @Override // yo0.b
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        this.f85371a.remove(r100);
    }

    @Override // yo0.b
    public final void a(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        c r103 = this.f85371a.get(r100);
        if (r103 != null) goto L6;
        int r104 = qo0.a.f534145a;
        qo0.a.b("OpenApiService", "无法处理该事件发送，params = " + r102, null);
        return;
    L6:
        r103.sendEvent(r101, r102);
    }

    @Override // yo0.b
    public final void c(String r100, JSONObject r101, yo0.a.InterfaceC8363a r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        c r103 = this.f85371a.get(r100);
        if (r103 != null) goto L6;
        int r104 = qo0.a.f534145a;
        qo0.a.b("OpenApiService", "无法处理该方法调用，params = " + r101, null);
        d.a.C8364a r105 = d.a.f568627d;
        OpenApiErrorInfo r106 = OpenApiErrorInfo.INTERNAL_ERROR;
        r105.getClass();
        r102.a(d.a.C8364a.b(r106, null).a());
        return;
    L6:
        r103.a(r101, r102);
    }
}
