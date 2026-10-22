package com.amap.api.mapcore.util;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class w8 extends v8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f28315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28316c;

    @Override // com.amap.api.mapcore.util.v8
    public boolean c() {
        if (o5.h(this.f28315b) != 1) goto L5;
    L9:
        return true;
    L5:
        if (this.f28316c == true) goto L9;
        return false;
    }

    public w8(Context r100, boolean r101) {
        this.f28315b = r100;
        this.f28316c = r101;
    }
}
