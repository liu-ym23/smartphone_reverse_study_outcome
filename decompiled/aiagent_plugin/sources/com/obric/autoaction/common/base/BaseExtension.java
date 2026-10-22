package com.obric.autoaction.common.base;

import androidx.lifecycle.d;
import androidx.lifecycle.p;
import com.obric.autoaction.common.base.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BaseExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseExtension<C extends b, H extends p> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C f24632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final H f24633b;

    public BaseExtension(C r3, H r4) {
        C r5 = (C) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        H r6 = (H) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        o.e(r5, "config");
        o.e(r6, "host");
        this.f24632a = r5;
        this.f24633b = r6;
    }

    public final C a() {
        return this.f24632a;
    }

    public final H b() {
        return this.f24633b;
    }
}
