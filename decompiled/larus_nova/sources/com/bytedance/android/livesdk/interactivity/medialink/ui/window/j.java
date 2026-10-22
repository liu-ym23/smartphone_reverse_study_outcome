package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import io.reactivex.functions.Consumer;
import zg1.h1;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaMultiLinkAudienceWindowManager f138429a;

    public j(MediaMultiLinkAudienceWindowManager r100) {
        this.f138429a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MediaMultiLinkAudienceWindowManager r101 = this.f138429a;
        r101.onEvent((h1) r100);
    }
}
