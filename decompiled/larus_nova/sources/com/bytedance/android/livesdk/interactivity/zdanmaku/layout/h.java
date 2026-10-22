package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements Comparator<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f141672a;

    public h(j r100) {
        this.f141672a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Integer r100, Integer r101) {
        int r102 = r100.intValue();
        int r103 = r101.intValue();
        int r104 = this.f141672a.f141674a.f531916a / 2;
        if (Math.abs(r102 - r104) <= Math.abs(r103 - r104)) goto L5;
        return 1;
    L5:
        return -1;
    }
}
