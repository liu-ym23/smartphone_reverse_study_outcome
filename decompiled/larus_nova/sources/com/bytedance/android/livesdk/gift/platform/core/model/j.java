package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.livesdk.gift.model.w1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f130898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f130899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<w1> f130900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f130901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f130902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f130903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f130904g;

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends w1> r100, long r101, int r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "giftPages");
        Intrinsics.checkNotNullParameter(r104, "logId");
        this.f130900c = r100;
        this.f130901d = r101;
        this.f130902e = r102;
        this.f130903f = r103;
        this.f130904g = r104;
    }
}
