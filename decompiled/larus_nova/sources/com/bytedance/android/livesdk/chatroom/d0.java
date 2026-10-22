package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.livesdk.config.p21;
import com.bytedance.android.livesdk.config.rt;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p21 f105605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Pair<Integer, Long>> f105606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f105607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f105608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f105609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f105610f;

    public d0() {
        p21 r100 = rt.f121156a.getValue();
        this.f105605a = r100;
        this.f105606b = new ConcurrentLinkedQueue();
        this.f105607c = r100.b();
        this.f105608d = r100.e();
        this.f105610f = System.currentTimeMillis();
    }
}
