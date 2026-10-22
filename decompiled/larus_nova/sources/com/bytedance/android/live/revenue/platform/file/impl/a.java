package com.bytedance.android.live.revenue.platform.file.impl;

import android.os.FileObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements m97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileObserver f91374a;

    @Override // m97.a
    public final void a() {
        this.f91374a.stopWatching();
    }

    public final void b() {
        this.f91374a.startWatching();
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "fileObserver");
        this.f91374a = r100;
    }
}
