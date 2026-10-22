package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.livesdk.gift.model.h3;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Long> f130109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f130110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f130111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Exception f130112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h3 f130113e;

    public f(Set<Long> r100, long r101, boolean r102, Exception r103, h3 r104) {
        Intrinsics.checkNotNullParameter(r100, "giftIds");
        this.f130109a = r100;
        this.f130110b = r101;
        this.f130111c = r102;
        this.f130112d = r103;
        this.f130113e = r104;
    }
}
