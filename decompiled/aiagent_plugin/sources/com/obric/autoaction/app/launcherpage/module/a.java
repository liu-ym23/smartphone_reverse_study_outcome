package com.obric.autoaction.app.launcherpage.module;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TaskManagementViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<Boolean, x> f23976b;

    public a(String r3, d.h.a.b<? super Boolean, x> r4) {
        d.h.a.b<Boolean, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "timerTaskId");
        o.e(r5, "confirm");
        this.f23975a = r3;
        this.f23976b = r5;
    }

    public final d.h.a.b<Boolean, x> a() {
        return this.f23976b;
    }
}
