package com.bytedance.android.live.effect.api;

/* JADX INFO: loaded from: classes45.dex */
public final class y implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f66782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f66783b;

    public y(boolean r100, boolean r101) {
        this.f66782a = r100;
        this.f66783b = r101;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        StringBuilder r100 = new StringBuilder("set value for commodity no filter mode: ");
        if (this.f66782a == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        r100.append(r101);
        return r100.toString();
    L5:
        if (this.f66783b == false) goto L7;
        r101 = true;
        goto L8
    }
}
