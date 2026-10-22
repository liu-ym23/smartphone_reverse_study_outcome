package com.bytedance.android.live.broadcastgame.opengame.message;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f60194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f60195b;

    public d0() {
        long r100 = System.currentTimeMillis();
        this.f60194a = r100;
        this.f60195b = new AtomicLong(r100 + 1);
    }
}
