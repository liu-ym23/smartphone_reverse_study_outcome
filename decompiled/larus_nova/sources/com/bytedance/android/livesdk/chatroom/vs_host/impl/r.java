package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements vr1.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<com.bytedance.android.live.pushstream.d> f118311a;

    public r(WeakReference<com.bytedance.android.live.pushstream.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        this.f118311a = r100;
    }
}
