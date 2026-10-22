package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements Function1<ExtendedToolbarButton, c0.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends c0.b> f116686a;

    public r(Class<? extends c0.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        this.f116686a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final c0.b invoke(ExtendedToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return this.f116686a.newInstance();
    }
}
