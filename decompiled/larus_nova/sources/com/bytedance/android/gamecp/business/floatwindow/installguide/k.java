package com.bytedance.android.gamecp.business.floatwindow.installguide;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f53207a = null;

    static {
        f53207a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        InstallGuideFloatWindowManager.f53171a = false;
    }
}
