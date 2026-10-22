package com.bytedance.android.annie.lynx.resource;

import android.net.Uri;
import android.os.AsyncTask;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.service.preload.PreLoadUtils;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxEnv;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class LynxTemplateProvider extends d8a.b implements com.bytedance.android.annie.card.base.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.annie.service.resource.g f39495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f39496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> f39497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d8a.b f39498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f39499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.annie.card.base.c f39500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f39501g;

    @Override // com.bytedance.android.annie.card.base.d
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> a() {
        return this.f39497c;
    }

    public LynxTemplateProvider(com.bytedance.android.annie.service.resource.g r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f39495a = r100;
        this.f39497c = new ConcurrentHashMap();
        if (com.bytedance.android.annie.ng.g.b().f39659c.f522326c == false) goto L7;
        ConcurrentHashMap<String, d8.b> r101 = e8.d.f471282a;
        f8.d r102 = e8.d.a(r100.f40037f).f467379f;
        if (r102 == null) goto L7;
        d8a.b r103 = r102.provide();
    L8:
        if (r103 != null) goto L10;
        r103 = LynxEnv.inst().getTemplateProvider();
    L10:
        this.f39498d = r103;
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // d8a.b
    public final void loadTemplate(String r100, d8a.b.a r110) {
        Intrinsics.checkNotNullParameter(r100, "url");
        c r101 = this.f39499e;
        if (r101 == null) goto L18;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L6
    L8:
        String r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L11;
        r103 = null;
    L11:
        Uri r105 = (Uri) r103;
        if (r105 == null) goto L14;
        r104 = r105.getPath();
    L14:
        if (r104 != null) goto L16;
        r104 = "";
    L16:
        r101.b(r100, r104);
    L6:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L18:
        if (this.f39496b == false) goto L24;
        c r107 = this.f39499e;
        if (r107 == null) goto L50;
        r107.a(new com.bytedance.android.annie.card.web.resource.a(false, "cdn", 0, false));
        return;
    L50:
        return;
    L24:
        if (this.f39495a.f40032a == false) goto L26;
    L29:
        LinkedHashMap r108 = new LinkedHashMap();
        com.bytedance.android.annie.card.base.c r109 = this.f39500f;
        if (r109 == null) goto L32;
        r109.b(r100, AnnieResType.LYNX_TEMPLATE, IHybridComponent.HybridType.LYNX, r108);
    L32:
        PreLoadUtils r111 = PreLoadUtils.f40001a;
        String r112 = this.f39501g;
        r111.getClass();
        boolean r113 = CollectionsKt.contains(((com.bytedance.android.annie.service.preload.b) PreLoadUtils.f40002b.getValue()).f40015b, r112);
        String r114 = this.f39501g;
        if (r114 != null) goto L35;
    L38:
        boolean r115 = true;
    L39:
        if (r115 == true) goto L43;
        if (r113 == false) goto L43;
        r100 = this.f39501g;
        Intrinsics.checkNotNull(r100);
    L43:
        String r116 = r100;
        if (AnnieConfigSettingKeys.FOREST_LOAD_RESOURCE_IN_MAIN.a().booleanValue() == false) goto L46;
        b(r116, r110, true, r108, r113);
        return;
    L46:
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new g(this, r116, r110, r108, r113));
        return;
    L35:
        if (StringsKt.isBlank(r114) == true) goto L38;
        r115 = false;
        goto L39
    L26:
        if (AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue() == false) goto L29;
        this.f39498d.loadTemplate(r100, new f(this, r110));
    }

    public final void b(final String r100, final d8a.b.a r101, boolean r102, Map<String, Object> r103, boolean r104) {
        RequestConfig r105 = new RequestConfig(AnnieResType.LYNX_TEMPLATE);
        r105.f40018c = n.c(IHybridComponent.HybridType.LYNX);
        r105.f40021f = r102;
        r105.f40022g = r104;
        com.bytedance.android.annie.service.resource.g r106 = this.f39495a;
        r105.f40027l = r106.f40036e;
        if (r106.f40034c == false) goto L5;
        r105.f40023h = r106.f40035d;
    L5:
        r105.a().putAll(r103);
        com.bytedance.android.annie.service.resource.h r107 = n.g(r100, r105, new LynxTemplateProvider$realLoadResource$2(this, r100, r101));
        if (r107 == null) goto L9;
        this.f39497c.put(r100, r107);
        return;
    }
}
