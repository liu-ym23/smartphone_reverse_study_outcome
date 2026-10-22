package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class h extends r22.a<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> f133985c;

    public static final class a {
    }

    static {
    }

    public com.bytedance.android.livesdk.interactivity.api.publicscreen.d m() {
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) ((LinkedList) this.f133985c).pollFirst();
    }

    @Override // r22.a
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d j() {
        return m();
    }

    @Override // r22.a
    public final Queue<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> h() {
        return this.f133985c;
    }

    public h(r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
        super(r100);
        this.f133985c = new LinkedList();
    }

    @Override // r22.a
    public /* bridge */ /* synthetic */ void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
        l(r100);
    }

    public void l(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
        Intrinsics.checkNotNullParameter(r100, "danmaku");
        if (((LinkedList) this.f133985c).size() < 200) goto L5;
        ((LinkedList) this.f133985c).removeFirst();
    L5:
        ((LinkedList) this.f133985c).add(r100);
        k();
    }
}
