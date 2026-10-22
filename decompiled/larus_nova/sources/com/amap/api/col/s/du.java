package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public final class du extends dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f26598b;

    @Override // com.amap.api.col.s.dt
    public final boolean a() {
        if (bm.p(this.f26597a) != 1) goto L5;
    L9:
        return true;
    L5:
        if (this.f26598b == true) goto L9;
        return false;
    }

    public du(Context r100) {
        this.f26597a = r100;
        this.f26598b = false;
    }
}
