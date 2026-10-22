package com.bytedance.android.live.effect.api;

/* JADX INFO: loaded from: classes45.dex */
public final class v implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f66777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f66778b;

    public v(boolean r100, boolean r101) {
        this.f66777a = r100;
        this.f66778b = r101;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "notify commodity no filter status, hasCommodity: " + this.f66777a + ", isNoFilterEnable: " + this.f66778b;
    }
}
