package com.bytedance.applog.log;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements a {
    public f() {
    }

    @Override // com.bytedance.applog.log.a
    public final void a(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
    }

    @Override // com.bytedance.applog.log.a
    public final void b(String r100, Throwable r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
    }
}
