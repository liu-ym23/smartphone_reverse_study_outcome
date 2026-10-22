package com.bytedance.android.live.room.api.experience.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f98915a = null;

    static {
        f98915a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L6;
        boolean r102 = r101.booleanValue();
        PlatformExpUtils.f98911c = true;
        PlatformExpUtils.f98912d = r102;
        return;
    }
}
