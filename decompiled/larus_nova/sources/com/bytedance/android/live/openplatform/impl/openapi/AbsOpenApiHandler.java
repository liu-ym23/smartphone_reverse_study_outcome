package com.bytedance.android.live.openplatform.impl.openapi;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.impl.base.bootconfig.BootConfigContextService;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.vd0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yo0.c;
import yo0.d;

/* JADX INFO: loaded from: classes46.dex */
public abstract class AbsOpenApiHandler implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, yo0.a> f85367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Queue<Long>> f85368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OpenPlatformContext f85369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f85370d;

    public AbsOpenApiHandler(OpenPlatformContext r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r101, "appId");
        this.f85369c = r100;
        this.f85370d = r101;
        this.f85367a = new LinkedHashMap();
        this.f85368b = new LinkedHashMap();
        b("getRoomInfo", new AnonymousClass1(this));
        b("getUserInfo", new AnonymousClass2(this));
        b("isFollowingAnchor", new AnonymousClass3(this));
    }

    @Override // yo0.c
    public final void a(JSONObject r110, yo0.a.InterfaceC8363a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r100 = r110.optString("eventName");
        yo0.a r101 = (yo0.a) ((LinkedHashMap) this.f85367a).get(r100);
        boolean r102 = true;
        if (this.f85369c.isAnchor() == false) goto L7;
        List<String> r103 = ee0.f120119a.getValue().a();
        if (r103 == null) goto L10;
        boolean r104 = r103.contains(r100);
    L11:
        if (r101 == null) goto L54;
        if (r104 == false) goto L54;
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        yo0.a.b r105 = new yo0.a.b(r111);
        String r112 = r101.b();
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r105, "callback");     // Catch: Throwable -> L51
        Intrinsics.checkNotNullParameter(r112, e.f25671s);     // Catch: Throwable -> L51
        if (v.a() == true) goto L19;
    L22:
        BootConfigContextService.b r106 = ((BootConfigContextService) r101.f568619b.getService(BootConfigContextService.class)).f(r101.f568621d, r112);     // Catch: Throwable -> L51
        if (r106 != null) goto L27;
        yo0.a.b.b(r105, OpenApiErrorInfo.NO_REQUEST_PERMISSION);     // Catch: Throwable -> L51
        monitor-exit(r101);
    L44:
        r102 = false;
    L49:
        if (r102 == false) goto L57;
        r101.call(r110, r105);
        return;
    L57:
        return;
    L27:
        int r107 = r106.f84011a;     // Catch: Throwable -> L51
        int r108 = r106.f84012b;     // Catch: Throwable -> L51
        if (((ArrayList) r101.f568618a).contains(r112) == true) goto L48;
        if (r108 == 0) goto L48;
        if (r107 != 0) goto L35;
        yo0.a.b.b(r105, OpenApiErrorInfo.NO_REQUEST_PERMISSION);     // Catch: Throwable -> L51
        monitor-exit(r101);
        goto L44
    L35:
        long r109 = System.currentTimeMillis();     // Catch: Throwable -> L51
        if (r101.f568620c.size() >= r107) goto L41;
        r101.f568620c.offer(Long.valueOf(r109));     // Catch: Throwable -> L51
        monitor-exit(r101);
        goto L49
    L41:
        if ((r109 - r101.f568620c.peek().longValue()) > (r108 * 1000)) goto L45;
        yo0.a.b.b(r105, OpenApiErrorInfo.EXCEED_FREQ_LIMIT);     // Catch: Throwable -> L51
        monitor-exit(r101);
        goto L44
    L45:
        r101.f568620c.poll();     // Catch: Throwable -> L51
        r101.f568620c.offer(Long.valueOf(r109));     // Catch: Throwable -> L51
        monitor-exit(r101);
    L48:
        monitor-exit(r101);
        goto L49
    L19:
        if (Intrinsics.areEqual(vd0.f121440a.getValue(), Boolean.FALSE) == false) goto L22;
        monitor-exit(r101);
    L51:
        th = move-exception;
        throw th;
    L54:
        d.a.f568627d.getClass();
        r111.a(d.a.C8364a.a(-2, "Function " + r100 + " is not registered.", null).a());
        return;
    L10:
        r104 = true;
        goto L11
    L7:
        List<String> r113 = ee0.f120119a.getValue().b();
        if (r113 == null) goto L10;
        r104 = r113.contains(r100);
        goto L11
    }

    public final void b(String r100, Function1<? super Queue<Long>, ? extends yo0.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "methodProvider");
        Map<String, yo0.a> r102 = this.f85367a;
        LinkedHashMap r103 = (LinkedHashMap) this.f85368b;
        Object r104 = r103.get(r100);
        if (r104 != null) goto L5;
        r104 = new LinkedList();
        r103.put(r100, r104);
    L5:
        r102.put(r100, r101.invoke(r104));
    }

    @Override // yo0.c
    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        IHostLiveOpenPlatform r102 = TTLiveSDK.hostService().hostOpenPlatform();
        String r103 = this.f85370d;
        JSONObject r104 = new JSONObject();
        r104.put("eventName", r100);
        r104.put("data", r101);
        Unit r105 = Unit.INSTANCE;
        r102.dispatchHostEvent(r103, "live_open_api", r104);
    }
}
