package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a1 implements af1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vlc.d f113299a;

    public a1(vlc.d r100) {
        this.f113299a = r100;
    }

    @Override // af1.c
    public final void a(int r100, ye1.e.b r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f113299a.addMessageListener(r100, r101);
    }

    @Override // af1.c
    public final void b(int r100, ye1.e.b r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f113299a.removeMessageListener(r100, r101);
    }
}
