package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import io.reactivex.functions.Consumer;
import zg1.h1;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaMultiLinkAnchorWindowManager f138422a;

    public c(MediaMultiLinkAnchorWindowManager r100) {
        this.f138422a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MediaMultiLinkAnchorWindowManager r101 = this.f138422a;
        r101.onEvent((h1) r100);
    }
}
