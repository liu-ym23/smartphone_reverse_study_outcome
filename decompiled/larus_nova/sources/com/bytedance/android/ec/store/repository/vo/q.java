package com.bytedance.android.ec.store.repository.vo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f48476c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f48477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48478b;

    public static final class a {
        public static q a(com.bytedance.android.ec.store.repository.dto.k r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            q r101 = new q();
            r101.f48477a = r100.a();
            Intrinsics.checkNotNullParameter(r100.b(), "<set-?>");
            r101.f48478b = r100.c();
            return r101;
        }
    }

    static {
    }

    public q() {
    }
}
