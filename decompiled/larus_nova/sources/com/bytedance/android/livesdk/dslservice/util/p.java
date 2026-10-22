package com.bytedance.android.livesdk.dslservice.util;

import android.os.SystemClock;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f123009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f123010b;

    public p() {
        this.f123010b = SystemClock.uptimeMillis();
    }

    public final void a(Consumer<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        if (this.f123009a == false) goto L5;
        return;
    L5:
        this.f123009a = true;
        r100.accept(Long.valueOf(SystemClock.uptimeMillis() - this.f123010b));
    }
}
