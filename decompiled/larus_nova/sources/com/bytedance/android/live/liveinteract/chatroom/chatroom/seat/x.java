package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class x extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f72350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f72351b;

    public final String toString() {
        return "ThemedCompetitionSeatAnimEvent{ userId=" + this.f72350a + ", url=" + this.f72351b + '}';
    }

    public x(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f72350a = r100;
        this.f72351b = r101;
    }
}
