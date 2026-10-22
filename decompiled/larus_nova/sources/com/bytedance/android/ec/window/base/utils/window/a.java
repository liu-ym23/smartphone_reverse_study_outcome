package com.bytedance.android.ec.window.base.utils.window;

import com.bytedance.android.ec.base.service.ECServiceManager;
import kotlin.jvm.internal.Intrinsics;
import s83.d;
import s83.g;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f49789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f49790b;

    public a() {
        boolean r100 = ECServiceManager.f42805a;
        this.f49790b = ((g) ECServiceManager.c(g.class)).N();
    }

    public final void a(boolean r100) {
        Boolean r101 = this.f49789a;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L17;
        if (r100 == false) goto L11;
        d r102 = this.f49790b;
        if (r102 == null) goto L21;
        r102.g();
        return;
    L21:
        return;
    L11:
        d r103 = this.f49790b;
        if (r103 == null) goto L14;
        r103.c();
    L14:
        d r104 = this.f49790b;
        if (r104 == null) goto L23;
        r104.h();
        return;
    L23:
        return;
    L17:
        d r105 = this.f49790b;
        if (r105 == null) goto L25;
        r105.g();
        return;
    }
}
