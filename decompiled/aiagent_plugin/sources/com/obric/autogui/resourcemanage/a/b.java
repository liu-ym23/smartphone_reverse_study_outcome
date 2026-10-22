package com.obric.autogui.resourcemanage.a;

import com.obric.autogui.common.api.logging.Loog;
import d.h.b.o;

/* JADX INFO: compiled from: ResourceLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30588a = null;

    static {
        f30588a = new b();
    }

    private b() {
    }

    public static final void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        o.e(r3, "tr");
        Loog.INSTANCE.e(r1, r2, r3);
    }
}
