package com.bytedance.android.livesdk.interactivity.asr;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<byte[]> f133835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<Long> f133836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f133837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f133838d;

    public final void a() {
    L7:
        e = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("clear error", e);
        return;
    L3:
        if ((!this.f133835a.isEmpty()) == false) goto L5;
        ((LinkedList) this.f133835a).clear();     // Catch: Exception -> L7
        ((LinkedList) this.f133836b).clear();     // Catch: Exception -> L7
    L5:
        this.f133837c = null;     // Catch: Exception -> L7
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("AudioDataCollector clear");     // Catch: Exception -> L7
    }

    public d(int r100) {
        this.f133838d = r100;
        this.f133835a = new LinkedList();
        this.f133836b = new LinkedList();
    }
}
