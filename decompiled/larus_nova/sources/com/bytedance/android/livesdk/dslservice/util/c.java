package com.bytedance.android.livesdk.dslservice.util;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Consumer<Integer> f122967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f122968b = null;

    public c() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    static {
        f122968b = new c();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        Consumer<Integer> r100 = f122967a;
        if (r100 == null) goto L6;
        r100.accept(0);
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r100) {
        if (r100 != 10) goto L5;
    L7:
        Consumer<Integer> r101 = f122967a;
        if (r101 == null) goto L11;
        r101.accept(Integer.valueOf(r100));
        return;
    L11:
        return;
    L5:
        if (r100 == 15) goto L7;
    }
}
