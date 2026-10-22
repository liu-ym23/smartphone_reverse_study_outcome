package com.bytedance.ai.applet.render.core.camera;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<b> f35104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f35105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f35107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f35108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<Object> f35109f;

    public x() {
        throw null;
    }

    public final boolean a() {
        if (this.f35104a.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public x(WeakReference r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "devicePosition");
        this.f35104a = r100;
        this.f35105b = r101;
        this.f35106c = r102;
        this.f35107d = false;
        this.f35108e = false;
        this.f35109f = null;
    }
}
