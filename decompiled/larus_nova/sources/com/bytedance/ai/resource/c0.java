package com.bytedance.ai.resource;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c0 implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f37304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f37305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f37306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f37307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f37308e;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.e(ChameleonOpenTracker.ParamKey.COST, this.f37304a);
        r100.f("url", this.f37305b);
        r100.d("error_code", this.f37306c);
        String r101 = this.f37307d;
        if (r101 == null) goto L5;
        r100.f("error_msg", r101);
    L5:
        String r102 = this.f37308e;
        if (r102 == null) goto L9;
        r100.f("res_from", r102);
        return;
    }

    public c0(long r100, String r101, int r102, String r103, String r104) {
        this.f37304a = r100;
        this.f37305b = r101;
        this.f37306c = r102;
        this.f37307d = r103;
        this.f37308e = r104;
    }
}
