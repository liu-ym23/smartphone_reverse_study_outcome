package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f114247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f114248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Long, RoomAuthStatus.Style, Unit> f114249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoomAuthStatus.Style f114250d;

    public u8() {
        throw null;
    }

    public u8(String r100, long r101, Function2 r102, RoomAuthStatus.Style r103, int r104) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "setAuthValue");
        this.f114247a = r100;
        this.f114248b = r101;
        this.f114249c = r102;
        this.f114250d = r103;
    }
}
