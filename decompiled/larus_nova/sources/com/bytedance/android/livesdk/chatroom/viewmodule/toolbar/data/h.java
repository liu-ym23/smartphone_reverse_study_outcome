package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f115930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f115931b;

    public final boolean a() {
        if (this.f115930a != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public h(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, "tips");
        this.f115930a = r100;
        this.f115931b = r102;
    }
}
