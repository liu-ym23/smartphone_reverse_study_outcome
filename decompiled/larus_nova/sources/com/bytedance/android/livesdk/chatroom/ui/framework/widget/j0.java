package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.utils.f2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j0 implements vlc.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f113416a;

    @Override // vlc.n
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    @Override // vlc.n
    public final void d(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
    }

    @Override // vlc.n
    public final void a() {
        f2.c(this.f113416a, 0);
    }

    public j0(String r100) {
        this.f113416a = r100;
    }
}
