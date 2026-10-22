package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f115851a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f115851a, ((l) r100).f115851a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        i r100 = this.f115851a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MorePanelGuideCommand(bubble=" + this.f115851a + ")";
    }

    public l(i r100) {
        Intrinsics.checkNotNullParameter(r100, "bubble");
        this.f115851a = r100;
    }
}
