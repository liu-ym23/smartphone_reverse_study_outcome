package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61753a;

    public abstract void a();

    public d() {
        this("");
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f61753a = r100;
    }
}
