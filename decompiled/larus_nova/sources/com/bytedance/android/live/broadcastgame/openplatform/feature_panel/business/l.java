package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;

/* JADX INFO: loaded from: classes45.dex */
public final class l extends o2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f61452a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == true) goto L6;
        return false;
    L6:
        if (this.f61452a == ((l) r100).f61452a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f61452a;
    }

    public final String toString() {
        return "PreviewToolbarBehaviorExtra(toBeExtended=" + this.f61452a + ")";
    }

    public l() {
        this.f61452a = 0;
    }
}
