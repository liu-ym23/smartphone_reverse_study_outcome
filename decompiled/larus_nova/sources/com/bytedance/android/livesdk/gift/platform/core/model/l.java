package com.bytedance.android.livesdk.gift.platform.core.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> f130911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f130912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f130913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f130914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f130915e;

    public final List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> a() {
        return this.f130911a;
    }

    public l(List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> r100, long r101, int r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "giftPages");
        Intrinsics.checkNotNullParameter(r104, "logId");
        this.f130911a = r100;
        this.f130912b = r101;
        this.f130913c = r102;
        this.f130914d = r103;
        this.f130915e = r104;
    }
}
