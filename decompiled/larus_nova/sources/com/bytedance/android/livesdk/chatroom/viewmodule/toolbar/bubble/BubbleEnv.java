package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class BubbleEnv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f115775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomContext f115776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f115777c;

    public final g a() {
        return (g) this.f115775a.getValue();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BubbleEnv) == false) goto L10;
        BubbleEnv r101 = (BubbleEnv) r100;
        if (Intrinsics.areEqual(this.f115776b, r101.f115776b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f115777c, r101.f115777c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        RoomContext r100 = this.f115776b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DataCenter r104 = this.f115777c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BubbleEnv(roomContext=" + this.f115776b + ", dataCenter=" + this.f115777c + ")";
    }

    public BubbleEnv(RoomContext r100, DataCenter r101) {
        this.f115776b = r100;
        this.f115777c = r101;
        this.f115775a = LazyKt.lazy(BubbleEnv$showRecord$2.INSTANCE);
    }
}
