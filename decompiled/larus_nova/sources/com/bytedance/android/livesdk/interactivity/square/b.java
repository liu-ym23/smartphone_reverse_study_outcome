package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends BaseTimingUpdater<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f141107c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void c() {
        e(Unit.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final long d() {
        return this.f141107c;
    }

    public b(long r100) {
        this.f141107c = r100;
    }
}
