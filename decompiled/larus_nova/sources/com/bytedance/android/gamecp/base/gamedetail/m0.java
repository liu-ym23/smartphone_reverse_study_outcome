package com.bytedance.android.gamecp.base.gamedetail;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51632a;

    public m0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == true) goto L6;
        return false;
    L6:
        if (this.f51632a == ((m0) r100).f51632a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f51632a;
    }

    public final String toString() {
        return "GameDeveloperStyle(textColor=" + this.f51632a + ")";
    }

    public /* synthetic */ m0(Object r100) {
        this(R.color.gamecp_game_FE2C55);
    }

    public m0(int r100) {
        this.f51632a = r100;
    }
}
