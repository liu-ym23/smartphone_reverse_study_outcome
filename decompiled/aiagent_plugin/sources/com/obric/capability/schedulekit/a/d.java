package com.obric.capability.schedulekit.a;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppHostImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Application f31871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f31872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f31873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f31874e;
    private final int f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final int k;
    private final int l;

    public d(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        o.e(r4, "app");
        this.f31871b = r4;
        this.f31872c = "160";
        this.f31873d = 160;
        this.f31874e = (a) ZeusTransformUtils.preCheckCast(new b(), a.class, "com.obric.aiagent.plugin");
        this.f = 498349;
        this.g = "obric_assistant";
        this.h = "OGrace";
        this.i = "sdk";
        this.j = "0.0.1";
        this.k = 1;
        this.l = 1;
    }

    @Override // com.obric.capability.schedulekit.a.c
    public Application a() {
        return this.f31871b;
    }
}
