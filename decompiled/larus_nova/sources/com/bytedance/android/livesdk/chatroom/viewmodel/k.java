package com.bytedance.android.livesdk.chatroom.viewmodel;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f114804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f114805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f114806c;

    public k(int r100, int r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        this.f114804a = r100;
        this.f114805b = r101;
        this.f114806c = r102;
    }
}
