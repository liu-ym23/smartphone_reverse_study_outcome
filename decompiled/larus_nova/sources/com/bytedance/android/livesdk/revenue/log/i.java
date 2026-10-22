package com.bytedance.android.livesdk.revenue.log;

import am2.x;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f157176a;

    public i() {
        this.f157176a = new x();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "belong");
        this.f157176a.f4349a = r100;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        this.f157176a.f4351c = r100;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        this.f157176a.f4350b = r100;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f157176a.f4353e = r100;
    }
}
