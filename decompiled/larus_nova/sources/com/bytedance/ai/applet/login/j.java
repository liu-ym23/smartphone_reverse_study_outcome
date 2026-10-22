package com.bytedance.ai.applet.login;

import com.bytedance.ai.bridge.login.AbsLoginWithDoubaoWidgetMethodIDL;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.c f34762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.j f34763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f34765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f34766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f34767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> f34768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AppletAuthTaskMonitor.Session f34769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppletAuthTaskMonitor.a f34770i;

    public j() {
        throw null;
    }

    public j(u2.c r100, u2.j r101, boolean r102, String r103, f3.h r104, AppletAuthTaskMonitor.Session r105) {
        h.c r106 = h.c.f34755a;
        Intrinsics.checkNotNullParameter(r100, "metaData");
        Intrinsics.checkNotNullParameter(r101, "relatedData");
        Intrinsics.checkNotNullParameter(r106, "state");
        Intrinsics.checkNotNullParameter(r103, "fromPage");
        this.f34762a = r100;
        this.f34763b = r101;
        this.f34764c = r102;
        this.f34765d = false;
        this.f34766e = r106;
        this.f34767f = r103;
        this.f34768g = r104;
        this.f34769h = r105;
        this.f34770i = null;
    }
}
