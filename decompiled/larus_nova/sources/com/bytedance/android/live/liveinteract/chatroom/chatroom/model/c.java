package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f72165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f72166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f72167c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (this.f72165a == r101.f72165a) goto L8;
        return false;
    L8:
        if (this.f72166b == r101.f72166b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f72167c, r101.f72167c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f72165a * 31) + this.f72166b) * 31;
        List<Integer> r101 = this.f72167c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "SwitchSceneEventForBackUpWidget(scene=" + this.f72165a + ", uiLayout=" + this.f72166b + ", playMode=" + this.f72167c + ")";
    }

    public c(int r100, int r101, List<Integer> r102) {
        this.f72165a = r100;
        this.f72166b = r101;
        this.f72167c = r102;
    }
}
