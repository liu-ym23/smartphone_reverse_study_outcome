package com.bytedance.android.live.revenue.platform.file.impl;

import android.os.FileObserver;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.h2;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m97.b f91375a;

    public b(h2 r100, String r101) {
        this.f91375a = r100;
        super(r101, UnixStat.PERM_MASK);
    }

    @Override // android.os.FileObserver
    public final void onEvent(int r100, String r101) {
        this.f91375a.onEvent(r100, r101);
    }
}
