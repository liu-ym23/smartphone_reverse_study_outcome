package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
abstract class as<T, V> extends b<T, V> {
    @Override // com.amap.api.col.s.cy
    public String h() {
        return h.a() + "/weather/weatherInfo?";
    }

    public final T i() {
        return this.f25991b;
    }

    public as(Context r100, T r101) {
        super(r100, r101);
    }
}
