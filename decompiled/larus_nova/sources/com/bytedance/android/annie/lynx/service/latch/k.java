package com.bytedance.android.annie.lynx.service.latch;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<List<String>> f39578a;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.annie.service.prefetch.n f39579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f39580b;

        public a(com.bytedance.android.annie.service.prefetch.n r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "loader");
            Intrinsics.checkNotNullParameter(r101, "channel");
            this.f39579a = r100;
            this.f39580b = r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Function0<? extends List<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "channels");
        this.f39578a = r100;
    }
}
