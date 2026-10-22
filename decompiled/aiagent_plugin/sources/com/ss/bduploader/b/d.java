package com.ss.bduploader.b;

import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.ugc.clientai.core.api.SmartInputData;
import com.ss.ugc.clientai.core.api.SmartOutputData;
import com.ss.ugc.clientai.core.api.SmartService;
import com.ss.ugc.clientai.core.api.SmartServiceConfig;
import com.ss.ugc.clientai.core.api.SmartServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SmartServiceWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SmartService f37475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f37477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f37478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37479e;

    public d() {
        this.f37476b = "";
        this.f37477c = "";
        this.f37478d = "";
        this.f37479e = "";
    }

    @Override // com.ss.bduploader.b.c
    public void a(int r1, String r2) {
        switch(r1) {
            case 1000: goto L7;
            case 1001: goto L6;
            case 1002: goto L5;
            case 1003: goto L4;
            default: goto L12;
        };
    L4:
        this.f37479e = r2;
        return;
    L5:
        this.f37478d = r2;
        return;
    L6:
        this.f37477c = r2;
        return;
    L7:
        this.f37476b = r2;
        return;
    }

    @Override // com.ss.bduploader.b.c
    public void a() {
        if (TextUtils.isEmpty(this.f37476b) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f37478d) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f37477c) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.f37479e) == true) goto L19;
        SmartService r0 = SmartServiceManager.instance().getCommonService(this.f37477c);
        this.f37475a = r0;
        if (r0 == null) goto L18;
        a("intelligent_wrapper", "service valid");
        SmartServiceConfig r1 = new SmartServiceConfig(this.f37477c);
        Map r2 = r1.configMap();
        r2.put("engineType", this.f37476b);
        r2.put("outputType", this.f37478d);
        r2.put("packageUrl", this.f37479e);
        this.f37475a.configService(r1);
        return;
    L18:
        return;
    }

    @Override // com.ss.bduploader.b.c
    public void b() {
        SmartService r0 = this.f37475a;
        if (r0 == null) goto L6;
        r0.preloadEnv();
        return;
    }

    @Override // com.ss.bduploader.b.c
    public boolean c() {
        SmartService r0 = this.f37475a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.enable() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.ss.bduploader.b.c
    public float a(Map r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        a("intelligent_wrapper", "syncMap" + r7);
        SmartInputData r0 = new SmartInputData();
        Map r1 = r0.inputMap();
        Iterator r2 = r7.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r3 = r2.next();
        r1.put(r3, r7.get(r3));
        goto L4
    L6:
        SmartService r8 = this.f37475a;
        if (r8 != null) goto L9;
    L17:
        return -1.0f;
    L9:
        if (r8.enable() == false) goto L17;
        SmartOutputData r5 = this.f37475a.runSync(r0);
        if (r5 == null) goto L17;
        if (r5.success() == false) goto L17;
        if (r5.getValue() == null) goto L17;
        return r5.getValue().floatValue();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
