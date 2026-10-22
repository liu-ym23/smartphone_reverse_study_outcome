package com.bytedance.android.live.browser;

import com.bytedance.android.live.core.log.ALogger;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements f8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f62586a;

    @Override // f8.a
    public final List<com.lynx.tasm.behavior.a> provide() {
        ALogger.i("AnnieNGInitHelper", "provide getBehaviorList");
        return this.f62586a.getBehaviorList();
    }

    public b(w r100) {
        this.f62586a = r100;
    }
}
