package com.bytedance.android.shopping.yata.frontier;

import com.heytap.mcssdk.constant.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f187601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f187602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f187603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f187604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f187605e;

    public a(int r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, b.f276376z);
        this.f187602b = r100;
        this.f187603c = r101;
        this.f187604d = r102;
        this.f187605e = r103;
        this.f187601a = r100 + '_' + r101 + '_' + r102 + '_' + r103;
    }
}
