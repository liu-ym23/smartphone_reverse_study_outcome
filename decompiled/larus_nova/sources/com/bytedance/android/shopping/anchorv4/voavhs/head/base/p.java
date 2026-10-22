package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PlayerBlock f168524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f168525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f168526c;

    public final String getType() {
        return this.f168525b;
    }

    public p(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f168525b = r100;
        this.f168526c = r101;
    }
}
