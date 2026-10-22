package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.x2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f96600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f96601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f96602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f96603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBaseBattleSetting f96604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x2 f96605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f96606g;

    public v(long r100, long r101, int r102, IBaseBattleSetting r103, x2 r104, int r105) {
        Intrinsics.checkNotNullParameter(r103, "setting");
        this.f96601b = r100;
        this.f96602c = r101;
        this.f96603d = r102;
        this.f96604e = r103;
        this.f96605f = r104;
        this.f96606g = r105;
        this.f96600a = true;
    }
}
